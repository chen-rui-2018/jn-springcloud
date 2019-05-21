<template>
  <div :class="className" :style="{height:height,width:width}" ref="myEchart"/>
</template>

<script>
// import echarts from 'echarts'
import { debounce } from '@/utils'

// echarts相关
let echarts = require('echarts/lib/echarts');
require('echarts/lib/chart/bar');
require('echarts/lib/component/tooltip');
require('echarts/lib/component/toolbox');
require('echarts/lib/component/legend');
require('echarts/lib/component/markLine');

const animationDuration = 6000

export default {
  props: {
    listData: {
      type: Object,
      default:function(){
        return {
          totalCost:[],
          companyExpense:[],
          personalExpense:[],
          insuredPeopleNo:[]
        }
      }
    },
    title: {
      type: String,
      default: ''
    },
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '300px'
    }
  },
  data() {
    return {
      chart: null,
      totalCostValues: [],
      totalCostNames:[],
      companyExpenseValues: [],
      companyExpenseNames:[],
      personalExpenseValues:[],
      personalExpenseNames:[],
      insuredPeopleNoValues:[],
      insuredPeopleNoNames:[]
    }
  },
  mounted() {
    this.initChart()
    this.__resizeHandler = debounce(() => {
      if (this.chart) {
        this.chart.resize()
      }
    }, 100)
    window.addEventListener('resize', this.__resizeHandler)
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    window.removeEventListener('resize', this.__resizeHandler)
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$refs.myEchart)
      this.setOption()

    },
    setOption() {
      if(!this.chart){
        return;
      }
      let totalCost = this.listData.totalCost
      this.totalCostNames = totalCost.map(data => {
        return data.name
      })

      let companyExpense = this.listData.companyExpense
      this.companyExpenseNames = companyExpense.map(data => {
        return data.name
      })

      let personalExpense = this.listData.personalExpense
      this.personalExpenseNames = personalExpense.map(data => {
        return data.name
      })

      let insuredPeopleNo = this.listData.insuredPeopleNo
      this.insuredPeopleNoNames = insuredPeopleNo.map(data => {
        return data.name
      })


      this.totalCostValues = totalCost.map(data => {
        return data.value
      })
      this.companyExpenseValues = companyExpense.map(data => {
        return data.value
      })

      this.personalExpenseValues = personalExpense.map(data => {
        return data.value
      })
      this.insuredPeopleNoValues = insuredPeopleNo.map(data => {
        return data.value
      })


      this.chart.setOption({
        title : {
          text: '各部门月参保费用TOP9统计'
        },
        color: ['#59D8E2','#4FA8f9','#66DDB8','#FF977B'],
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          data:['总费用','公司费用','个人费用','参保人数']
        },
        toolbox: {
          show : true,
          feature : {
            mark : {show: true},
            dataView : {
              show: true,
              readOnly: false,
              title: '数据视图',
              optionToContent: function(opt) {
                let axisData = opt.xAxis[0].data; //坐标数据
                let series = opt.series; //折线图数据
                let tdHeads = '<td  style="padding: 0 10px">部门</td>'; //表头
                let tdBodys = ''; //数据
                series.forEach(function (item) {
                  //组装表头
                  tdHeads += `<td style="padding: 0 10px">${item.name}</td>`;
                });
                let table = `<table border="1" style="margin-left:20px;border-collapse:collapse;font-size:14px;text-align:center;border-color: #00a0e9"><tbody><tr style="background-color: #1e6abc">${tdHeads} </tr>`;
                for (let i = 0, l = axisData.length; i < l; i++) {
                  for (let j = 0; j < series.length; j++) {
                    //组装表数据
                    tdBodys += `<td>${ series[j].data[i]}</td>`;
                  }
                  table += `<tr><td style="padding: 0 10px">${axisData[i]}</td>${tdBodys}</tr>`;
                  tdBodys = '';
                }
                table += '</tbody></table>';
                return table;
              }
            },
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
          }
        },
        calculable : true,
        xAxis: [
          {
            type: 'category',
            data: this.totalCostNames
          }
          /*,{
            type: 'category',
            data: this.companyExpenseNames
          },
          {
            type: 'category',
            data: this.personalExpenseNames
          },{
            type: 'category',
            data: this.insuredPeopleNoNames
          }*/
        ],
        yAxis: [
          {
            type: 'value',
            name:'(千)'
          },{
            type: 'value',
            name:'(人)'
          }
        ],
        series: [{
          name:'总费用',
          data: this.totalCostValues,
          type: 'bar'
        },{
          name:'公司费用',
          data: this.companyExpenseValues,
          type: 'bar'
        },{
          name:'个人费用',
          data: this.personalExpenseValues,
          type: 'bar'
        },{
          name:'参保人数',
          data: this.insuredPeopleNoValues,
          type: 'line'
        }]
      })
    }
  },
  watch: {
    listData: {
      handler(newValue, oldValue) {
        this.setOption()
      },
      deep: true
    },
  }
}
</script>

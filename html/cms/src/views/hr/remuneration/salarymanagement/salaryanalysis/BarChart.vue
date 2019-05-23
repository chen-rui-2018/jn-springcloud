<template>
  <div ref="myEchart" :class="className" :style="{height:height,width:width}"/>
</template>

<script>
// import echarts from 'echarts'
import { debounce } from '@/utils'

// echarts相关
const echarts = require('echarts/lib/echarts')
require('echarts/lib/chart/bar')
require('echarts/lib/component/tooltip')
require('echarts/lib/component/toolbox')
require('echarts/lib/component/legend')
require('echarts/lib/component/markLine')

// const animationDuration = 6000

export default {
  props: {
    listData: {
      type: Object,
      default: function() {
        return {
          percapitaWage: [],
          peopleNo: []
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
      names: [],
      peopleNames: [],
      values: [],
      peopleNo: []
    }
  },
  watch: {
    listData: {
      handler(newValue, oldValue) {
        this.setOption()
      },
      deep: true
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
      // this.chart = echarts.init(this.$el, 'macarons')
      this.chart = echarts.init(this.$refs.myEchart)
      this.setOption()
    },
    setOption() {
      if (!this.chart) {
        return
      }
      const percapitaWage = this.listData.percapitaWage
      this.names = percapitaWage.map(data => {
        return data.name
      })
      const peopleNo = this.listData.peopleNo
      this.peopleNames = peopleNo.map(data => {
        return data.name
      })

      this.values = percapitaWage.map(data => {
        return data.value
      })
      this.peopleNo = peopleNo.map(data => {
        return data.value
      })

      this.chart.setOption({
        title: {
          text: '部门人均工资TOP9统计图'
        },
        color: ['#3398DB', '#FFA500'],
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          data: ['人均工资', '计薪人数']
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: {
              show: true,
              readOnly: false,
              title: '数据视图',
              optionToContent: function(opt) {
                const axisData = opt.xAxis[0].data // 坐标数据
                const series = opt.series // 折线图数据
                let tdHeads = '<td  style="padding: 0 10px">部门</td>' // 表头
                let tdBodys = '' // 数据
                series.forEach(function(item) {
                  // 组装表头
                  tdHeads += `<td style="padding: 0 10px">${item.name}</td>`
                })
                let table = `<table border="1" style="margin-left:20px;border-collapse:collapse;font-size:14px;text-align:center;border-color: #00a0e9"><tbody><tr style="background-color: #1e6abc">${tdHeads} </tr>`
                for (let i = 0, l = axisData.length; i < l; i++) {
                  for (let j = 0; j < series.length; j++) {
                    // 组装表数据
                    tdBodys += `<td>${series[j].data[i]}</td>`
                  }
                  table += `<tr><td style="padding: 0 10px">${axisData[i]}</td>${tdBodys}</tr>`
                  tdBodys = ''
                }
                table += '</tbody></table>'
                return table
              }
            },
            magicType: { show: true, type: ['line', 'bar'] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        calculable: true,
        xAxis: [
          {
            type: 'category',
            data: this.names
          }/*, {
            type: 'category',
            data: this.peopleNames
           }*/
        ],
        yAxis: [
          {
            type: 'value',
            name: '(千)'
          }, {
            type: 'value',
            name: '(人)'
          }
        ],
        series: [{
          name: '人均工资',
          data: this.values,
          type: 'bar'
        }, {
          name: '计薪人数',
          data: this.peopleNo,
          type: 'line'
        }]
      })
    }
  }
}
</script>

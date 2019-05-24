<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from 'echarts'

// require('echarts/theme/macarons') // echarts theme
// echarts相关
// let echarts = require('echarts/lib/echarts');
// require('echarts/lib/chart/bar');
// require('echarts/lib/component/tooltip');
// require('echarts/lib/component/toolbox');
// require('echarts/lib/component/legend');
// require('echarts/lib/component/markLine');

import { debounce } from '@/utils'

export default {
  props: {
    title: {
      type: String,
      default: ''
    },
    listData: {
      type: Array,
      default: function() {
        return []
      }
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
      names: []
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
      this.chart = echarts.init(this.$el, 'macarons')
      this.setOption()
    },
    setOption() {
      if (!this.chart) {
        return
      }
      this.names = this.listData.map(data => data.name)
      this.chart.setOption({
        title: {
          text: this.title,
          left: 'center',
          top: 20,
          textStyle: {
            color: '#ccc'
          }
        },
        // tooltip: {
        //   trigger: 'item',
        //   formatter: '{a} <br/>{b}: {c} ({d}%)'
        // },
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },

        legend: {
          orient: 'vertical',
          x: 'left',
          data: this.names
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
                const seriesData = opt.series[0].data // 折线图数据
                let tdBodys = '' // 数据
                let table = '<table border="1" style="margin-left:20px;border-collapse:collapse;font-size:14px;text-align:center;border-color: #00a0e9"><tbody>'
                let tableHeader = ''
                for (let i = 0; i < seriesData.length; i++) {
                  tableHeader = tableHeader + '<td>' + seriesData[i].name + '</td>'
                  tdBodys = tdBodys + '<td>' + seriesData[i].value + '</td>'
                }
                table = table + '<tr style="background-color: #1e6abc">' + tableHeader + '</tr>' + '<tr>' + tdBodys + '</tr>'
                return table
              }
            }
            // magicType : {show: true, type: ['line', 'bar']},
            // restore : {show: true}
            // saveAsImage : {show: true}
          }
        },
        calculable: true,
        series: [
          {
            name: this.title,
            type: 'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            data: this.listData,
            animationEasing: 'cubicInOut',
            animationDuration: 2600,
            label: {
              normal: {
                show: false,
                position: 'center',
                formatter: '{b}: {c}元({d}%)'
              },
              emphasis: {
                show: true,
                textStyle: {
                  fontSize: '20',
                  fontWeight: 'bold'
                }
              }
            },
            labelLine: {
              normal: {
                show: false,
                formatter: '{b}: {c}元({d}%)'
              }
            }
          }
        ]
      })
    }

  }

}
</script>

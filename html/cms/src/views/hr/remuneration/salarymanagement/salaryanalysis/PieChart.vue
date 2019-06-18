<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from 'echarts'
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
      default: '350px'
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
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        // color: ['#f9a84f', '#e2d859', '#b5dd66', '#aaf7b8', '#8fdcff', '#7b97ff', '#9473ff', '#BA55D3', '#DDA0DD'],
        legend: {
          type: 'scroll',
          orient: 'vertical',
          x: 'left',
          right: 10,
          top: 40,
          bottom: 20,
          data: this.names
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: {
              show: true,
              readOnly: false,
              title: '表格',
              optionToContent: function(opt) {
                const seriesData = opt.series[0].data // 折线图数据
                let tdBodys = '' // 数据
                let table = '<table border="1" style="margin-left:20px;border-collapse:collapse;font-size:14px;text-align:center;border-color: #00a0e9"><tbody>'
                let tableHeader = ''
                for (let i = 0; i < seriesData.length; i++) {
                  tableHeader = tableHeader + '<td>' + seriesData[i].name + '</td>'
                  tdBodys = tdBodys + '<td>' + seriesData[i].value + '</td>'
                }
                table = table + '<tr>' + tableHeader + '</tr>' + '<tr>' + tdBodys + '</tr>'
                return table
              }
            }
          }
        },
        calculable: true,
        series: [
          {
            name: this.title,
            type: 'pie',
            radius: '55%',
            center: ['60%', '50%'],
            // startAngle: 270, // 设置起始坐标
            // clockwise: false, // 逆时针旋转
            data: this.listData,
            animationEasing: 'cubicInOut',
            animationDuration: 2600,
            label: {
              normal: {
                show: false,
                position: 'center'
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
                show: false
              }
            }
            /* itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }*/
          }
        ]
      })
    }

  }

}
</script>

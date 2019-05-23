<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from 'echarts'

require('echarts/theme/macarons') // echarts theme
import { debounce } from '@/utils'

export default {
  props: {
    title: {
      type: String,
      default: 'aaaaaa'
    },
    listData: {
      type: Array,
      default: () => {
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
      if (this.chart) {
        this.chart.dispose()
        this.chart = null
      }

      const that = this
      this.chart = echarts.init(this.$el, 'macarons')
      this.setOption()
      this.chart.on('magictypechanged', function(opt) {
        if (opt.currentType === 'bar') {
          that.setBarOption()
        }
        if (opt.currentType === 'line') {
          that.initChart()
        }
      })
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
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          x: 'left',
          data: this.names
        },
        calculable: true,
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            magicType: {
              show: true,
              type: ['pie', 'funnel', 'bar']
            },
            restore: { show: true },
            saveAsImage: { show: true }
          },
          optionToContent: function(opt) {
            const type = opt.series[0].name.substring(2, 6)
            const tdHeads = `<th  style="padding: 0 10px">${type}</th><th style="padding: 0 10px">数量</th>`
            let table = `<table border="1" style="margin-left:20px;border-collapse:collapse;font-size:14px;text-align:center"><tbody><tr>${tdHeads} </tr>`
            opt.series[0].data.forEach(item => {
              table += `<tr><td style="padding: 0 10px">${item.name}</td><td style="padding: 0 10px">${item.value}</td></tr>`
            })
            table += '</tbody></table>'
            return table
          }
        },
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
          }
        ]
      })
    },

    setBarOption() {
      if (!this.chart) {
        return
      }
      this.names = this.listData.map(data => {
        return data.name
      })
      this.values = this.listData.map(data => {
        return data.value
      })
      this.chart.setOption({
        title: {
          text: this.title,
          left: 'center',
          top: 20,
          textStyle: {
            color: '#ccc'
          }
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar', 'pie'], title: {
              line: '切换为饼状图'
            }, icon: {
              line: 'image:///static/images/pie.jpg'
            }
            },
            restore: { show: true },
            saveAsImage: { show: true }
          },
          optionToContent: function(opt) {
            const axisData = opt.xAxis[0].data // 坐标数据
            const series = opt.series // 折线图数据
            let tdHeads = `<td  style="padding: 0 10px">${opt.title[0].text.substring(2, 6)}</td>` // 表头
            let tdBodys = '' // 数据
            series.forEach(function(item) {
              // 组装表头
              tdHeads += `<td style="padding: 0 10px">${item.name}</td>`
            })
            let table = `<table border="1" style="margin-left:20px;border-collapse:collapse;font-size:14px;text-align:center"><tbody><tr>${tdHeads} </tr>`
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
        xAxis: {
          type: 'category',
          data: this.names
        },
        yAxis: {
          type: 'value',
          name: '(人)'
        },
        series: [{
          data: this.values,
          name: '人数',
          type: 'bar'
        }]
      })
    }

  }

}
</script>

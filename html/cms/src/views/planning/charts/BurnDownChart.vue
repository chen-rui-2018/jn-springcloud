<template>
  <div :class="className" :id="id" :style="{height:height,width:width}"/>
</template>
<script>
import $ from 'jquery'
import echarts from 'echarts'
import resize from '@/components/Charts/resize'
export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    id: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '200px'
    },
    height: {
      type: String,
      default: '200px'
    },
    chartopts: {
      type: Object,
      default: null
    }
  },
  data() {
    return {
      chart: null
    }
  },
  mounted() {
    this.initChart()
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      const opts = this.chartopts // 完成进度
      const mLength = opts.currentMonth // 当前月份
      const dateData = opts.cycle // 项目月份周期数组  ;
      let pData = opts.uncompletedArr // 项目月份未完成比例数组,开始默认100%
      pData = pData.map(function(n) {
        return parseInt(n)
      })
      function inArray(value, arr) {
        for (var k in arr) {
          if (arr[k] === value) {
            return k
          }
          if (k === arr.length - 1) {
            return -1
          }
        }
      }
      const mIndex = parseInt(inArray(mLength, dateData))
      const dateDateLength = dateData.length
      const unfinishedData = []
      const doneData = []
      const c = 100 / (dateDateLength - 1)
      for (let i = 0; i < dateDateLength; i++) {
        const j = dateDateLength - i - 1
        if (i < mIndex) {
          doneData.push(c * j)
          unfinishedData.push('')
        } else if (i === mIndex) {
          doneData.push(c * j)
          unfinishedData.push(c * j)
        } else {
          doneData.push('')
          unfinishedData.push(c * j)
        }
      }
      this.chart = echarts.init(document.getElementById(this.id))
      let option = {
        markLine: {
          show: false
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            // type: 'cross',
            lineStyle: {
              color: 'transparent'
            },
            label: {
              backgroundColor: '#000'
            }
          },
          formatter: function(a) {
            var c = a[0]
            var cm = c.axisValue // 选择的月份
            var cv = c.value // 数值
            var cn = c.seriesName // 名称
            return cm + '<br/>' + cn + ':还剩' + cv + '%'
          }
        },
        toolbox: {
          show: false,
          feature: {
            saveAsImage: {}
          }
        },
        grid: {
          left: '-20px',
          right: '3%',
          bottom: '0%',
          top: '10px',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            boundaryGap: false,
            axisTick: {
              show: false
            },
            splitLine: {
              show: false
            },
            axisLabel: {
              textStyle: {
                color: '#999'
              }
            },
            axisLine: {
              lineStyle: {
                color: '#dfe0e0'
              }
            },
            data: dateData
          }
        ],
        yAxis: [
          {
            type: 'value',
            boundaryGap: false,
            splitLine: {
              show: false
            },
            axisTick: {
              show: false
            },
            axisLine: {
              // show:false,
              lineStyle: {
                color: '#dfe0e0'
              }
            },
            axisLabel: {
              textStyle: {
                color: '#999'
              },
              formatter: function(a) {
                if (a === 100 || a === 0) {
                  return a + '%'
                }
              }
            }
          }
        ],
        series: [
          {
            name: '项目进度',
            type: 'line',
            symbol: 'emptyCircle',
            symbolSize: 13,
            color: '#2ca9e7',
            itemStyle: {
              normal: {
                lineStyle: {
                  color: '#2ca9e7',
                  width: 2
                }
              }
            },
            data: pData
          },
          {
            name: '未完成进度',
            type: 'line',
            symbol: 'none',
            itemStyle: {
              normal: {
                areaStyle: {
                  type: 'default',
                  color: '#ffd5d3'
                },
                lineStyle: {
                  color: '#f35a4c',
                  width: 2,
                  type: 'dotted'
                }
              }
            },
            data: unfinishedData
          },
          {
            name: '已完成进度',
            type: 'line',
            symbol: 'none',
            itemStyle: {
              normal: {
                areaStyle: {
                  type: 'default',
                  color: '#c3ffe1'
                },
                lineStyle: {
                  color: '#58cc77',
                  width: 2,
                  type: 'dotted'
                }
              }
            },
            data: doneData
          }
        ]
      }
      option = $.extend({}, option, opts.options)
      this.chart.setOption(option)
    }
  }
}
</script>

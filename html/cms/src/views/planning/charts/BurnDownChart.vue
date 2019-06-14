<template>
  <div>
    <!-- <div>{{ chartopts }}</div> -->
    <div :class="className" :id="id" :style="{height:height,width:width}"/>
  </div>
</template>
<script>
import $ from 'jquery'
import echarts from 'echarts'
// import resize from '@/components/Charts/resize'
export default {
  // mixins: [resize],
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
  // watch: {
  //   chartopts() {
  //     console.log(this.chartopts)
  //   }
  // },
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
      const opts = this.chartopts // 图表参数
      if (opts.arrayModel.createdTime) {
        var dateData = opts.arrayModel.createdTime // 项目月份周期数组  ;
      }
      const mLength = dateData[dateData.length - 1]// 当前月份
      if (opts.planStartTime !== opts.arrayModel.createdTime[0]) {
        dateData.unshift(opts.planStartTime)
      }
      dateData.push(opts.planStopTime)
      const pData = []// 项目月份未完成比例数组,开始默认100%
      opts.arrayModel.progress.forEach(v => {
        pData.push(100 - v)
      })
      // pData = pData.map(function(n) {
      //   return parseInt(n)
      // })
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
      // console.log(mIndex, mLength, dateData)
      const dateDateLength = dateData.length
      const unfinishedData = []
      const doneData = []
      // const unfinishedData = dateData.slice(dateData.length - 1)
      // const doneData = dateData.slice(0, dateData.length - 1)
      // console.log(unfinishedData, doneData)
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
      // console.log(unfinishedData, doneData)
      this.chart = echarts.init(document.getElementById(this.id))
      var option = {
        // markLine: {
        //   show: false
        // },
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
          left: '-15px',
          right: '20%',
          bottom: '0%',
          top: '10px',
          containLabel: true
        },
        xAxis: [
          {
            show: true,
            name: '工\n期',
            nameLocation: 'end',
            type: 'category',
            boundaryGap: false,
            axisTick: {
              show: false
            },
            splitLine: {
              show: false
            },

            axisLabel: {
              rotate: '45',
              textStyle: {
                color: '#777'
              }
            },
            axisLine: {
              show: true, // 是否显示
              symbol: ['none', 'arrow'], // 是否显示轴线箭头
              symbolSize: [8, 10], // 箭头大小
              symbolOffset: [0, 10], // 箭头位置
              lineStyle: {
                color: '#999'
              }
            },
            data: dateData
          }
        ],
        yAxis: [
          {
            show: true,
            type: 'value',
            name: '剩余任务量',
            nameLocation: 'end',
            boundaryGap: false,
            splitLine: {
              show: false
            },
            axisTick: {
              show: false
            },
            axisLine: {
              // show: true, // 是否显示
              // symbol: ['none', 'arrow'], // 是否显示轴线箭头
              // symbolSize: [8, 10], // 箭头大小
              // symbolOffset: [0, 15], // 箭头位置
              lineStyle: {
                color: '#999'
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
            // data: ''
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
            // data: ''
          }
        ]
      }
      option = $.extend({}, option, opts.options)

      this.chart.setOption(option)
    }
  }
}
</script>

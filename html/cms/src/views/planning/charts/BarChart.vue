<template>
  <div :class="className" :id="id" :style="{height:height,width:width}"/>
</template>
<script>
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
      type: Array,
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
      const opts = this.chartopts
      console.log(opts)
      this.chart = echarts.init(document.getElementById(this.id))
      // const option = {
      //   color: ['red', 'yellow', 'green'],
      //   backgroundColor: ['#fff'],
      //   tooltip: {
      //     trigger: 'item',
      //     formatter: '{b}'
      //   },
      //   legend: {
      //     orient: 'vertical',
      //     x: 'left',
      //     y: 'center',
      //     icon: 'circle',
      //     data: ['任务量', '已完成', '超出预期']
      //   },
      //   grid: {
      //     left: 10
      //   },
      //   series: [
      //     {
      //       label: {
      //         normal: {
      //           position: 'inner',
      //           textStyle: {
      //             fontSize: 16
      //           }
      //         }
      //       },
      //       type: 'pie',
      //       radius: '60%',
      //       center: ['60%', 'center'],
      //       selectedMode: 'single',
      //       data: opts.label,
      //       itemStyle: {
      //         emphasis: {
      //           shadowBlur: 10,
      //           shadowOffsetX: 0,
      //           shadowColor: 'rgba(0, 0, 0, 0.5)'
      //         }
      //       }
      //     }
      //   ]
      // }
      const data = [
        { index: 1, 已完成: 30, 超期: 0 },
        { index: 1, 已完成: 100, 超期: 10 },
        { index: 1, 已完成: 100, 超期: 0 },
        { index: 1, 已完成: 100, 超期: 10 },
        { index: 1, 已完成: 30, 超期: 0 }
      ]
      const xAxis = []
      const data1 = []
      const data2 = []
      const data3 = []
      data.forEach(item => {
        xAxis.push(item.index)
        // const label = {
        //   normal: {
        //     show: true,
        //     position: 'top',
        //     formatter: '{c}%'
        //   }
        // }
        if (item.超期 !== 0) {
          data1.push({
            value: item.已完成,
            label: {
              normal: {
                show: false
              }
            }
          })
          data2.push({
            value: 100 - item.已完成,
            label: {
              normal: {
                show: false
              }
            }
          })
          data3.push({ value: item.超期, label: {
            normal: {
              show: true,
              position: 'top',
              textStyle: {
                color: 'red'
              },
              formatter: function(value) {
                // console.log(value.data)

                return value.data.value + 100 + '%'
              },
              itemStyle: {
                rich: {
                  a: {

                  }
                }
              }
            }
          }})
        } else {
          data1.push({ value: item.已完成,
            label: {
              normal: {
                show: item.已完成 !== 100,
                position: 'top',
                textStyle: {
                  color: 'red'
                },
                formatter: function(value) {
                  console.log(value.data.value)
                  if (value.data.value === '100') {
                    return ''
                  } else {
                    return value.data.value + '%'
                  }
                }
              }
            }
          })
          data2.push({
            value: 100 - item.已完成,
            label: {
              normal: {
                show: true,
                position: 'top',
                textStyle: {
                  color: 'red'
                },
                formatter: function(value) {
                  // console.log(value.data)
                  if (value.data.value === '100') {
                    return ''
                  } else {
                    return 100 - value.data.value + '%'
                  }
                  // return 100 - value.data.value + '%'
                }
              }
            }
          })
          data3.push({
            value: item.超期,
            label: {
              normal: {
                show: false
              }
            }
          })
        }
      })
      // console.log(data1, data2, data3)
      const option = {
        color: ['rgb(27, 142, 240)', 'rgb(215, 215, 215)', 'rgb(255, 192, 0)'],
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          },
          formatter: `{b}<br />\
                	<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:#7ace4c"></span>\
                	{a0}：{c0}%<br />\
                	<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:#ffbb44"></span>\
                	{a1}：{c1}%<br />\
                	<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:#11a0f8"></span>\
                	{a2}：{c2}%<br />`
        },
        legend: {
          icon: 'circle',
          data: ['任务量', '已完成', '超出预期']
        },
        grid: {
          left: 10,
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        // xAxis: {
        //   type: 'category',
        //   data: xAxis
        // },
        yAxis: {
          type: 'value',
          axisLabel: {
            show: true,
            interval: 'auto',
            formatter: '{value} %'
          },
          show: true
        },
        series: [
          {
            data: data1,
            type: 'bar',
            stack: '1',
            smooth: true
          },
          {
            data: data2,
            stack: '1',
            type: 'bar',
            smooth: true
          },
          {
            data: data3,
            stack: '1',
            type: 'bar',
            smooth: true
          }
        ],
        xAxis: {
          type: 'category',
          data: opts.label

        }
        // yAxis: {
        //   type: 'value',
        //   axisLabel: {
        //     show: true,
        //     interval: 'auto',
        //     formatter: '{value} %'
        //   },
        //   show: true

        // },
        // series: [

        //   {
        //     name: '已完成',
        //     type: 'bar',
        //     stack: '总量',
        //     label: {
        //       normal: {
        //         show: true,
        //         position: 'top'
        //       }
        //     },
        //     data: [59, 70, 100, 82, 76, 87, 100]
        //   },
        //   {
        //     name: '任务量',
        //     type: 'bar',
        //     stack: '总量',
        //     barWidth: 30,
        //     data: [41, 30, 0, 18, 26, 13, 0]
        //   },
        //   {
        //     name: '超出预期',
        //     type: 'bar',
        //     stack: '总量',
        //     label: {
        //       normal: {
        //         show: true,
        //         position: 'top',
        //         formatter: '{c}%'
        //       }
        //     },
        //     data: [0, 0, 136, 0, 0, 0, 0]
        //   }

        // ]
      }
      this.chart.setOption(option)
    }
  }
}
</script>

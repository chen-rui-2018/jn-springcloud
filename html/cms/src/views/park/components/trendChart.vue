<template>
  <div :class="className" :style="{height:height,width:width}"/>
</template>

<script>
import echarts from 'echarts'
// 随屏幕改变  图表也相应的变化
import resize from '@/components/Charts/mixins/resize'
export default {
  // vue中的混入写法，当文件中有其中的代码 则以文件中的为主，没有则合并
  mixins: [resize],
  props: {
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
      chart: null
    }
  },
  mounted() {
    this.initChart()
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')

      this.chart.setOption({
        color: ['#92d050', '#f56b6b'],
        /*         legend: {
                         y: 10
                     },*/
        /*         tooltip: {
                         trigger: 'axis',
                         showContent: false
                     },*/
        tooltip: {
          trigger: 'axis',
          formatter: function(a, b, c) {
            var v = 21 - parseInt(a[0]['value'][1])
            return '第' + v + '名'
          }
        },
        dataset: {
          source: [
            ['2012', '2013', '2014', '2015', '2016', '2017', '2018'],
            [1, 2, 5, 8, 11, 16, 17]
          ]
        },
        xAxis: {
          type: 'category',
          axisLine: {
            lineStyle: {
              color: '#999'
            }
          }
        },
        yAxis: {
          splitLine: {
            show: false
          },
          gridIndex: 0,
          axisLine: {
            show: false,
            lineStyle: {
              color: '#999'

            }
          },
          axisTick: {
            show: false
          },
          axisLabel: {
            show: false
          }
        },
        grid: { left: 15, top: 20, bottom: 30, right: 15 },
        series: [
          { type: 'line', smooth: true, seriesLayoutBy: 'row', symbolSize: 7 }
        ]

      })
    }
  }
}
</script>

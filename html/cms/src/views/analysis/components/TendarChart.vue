<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>
<script>
import echarts from 'echarts'
import { Tenlist } from '@/api/article'
import resize from '@/components/Charts/mixins/resize'
import 'echarts-gl'
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
      default: '400px'
    }
  },
  data() {
    return {
      result: [],
      chart: null,
      data1: [],
      data2: []
    }
  },
  mounted() {
    Tenlist().then(res => {
      this.result = res.data
      this.initChart()
    })
  },

  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')

      this.chart.setOption({
        title: {
          show: false
          // text: '近十年园区每日用电统计'
        },
        tooltip: {
          trigger: 'axis'
        },
        grid: {
          left: 40
        },
        xAxis: {
          data: this.result.map(function(item) {
            return item[0]
          })
          // data: this.data1
          // data: ['2000-10-01', '2000-10-02', '2000-10-03', '2000-10-04', '2000-10-05', '2000-10-06', '2000-10-07', '2000-10-08']
        },
        yAxis: {
          splitLine: {
            show: false
          }
        },
        toolbox: {
          show: false,
          left: 'center',
          feature: {
            dataZoom: {
              yAxisIndex: 'none'
            },
            restore: {},
            saveAsImage: {}
          }
        },
        dataZoom: [{
          startValue: '2014-06-01'
        }, {
          type: 'inside'
        }],
        visualMap: {
          top: 10,
          right: 10,
          pieces: [{
            gt: 0,
            lte: 50,
            color: '#096'
          }, {
            gt: 50,
            lte: 100,
            color: '#ffde33'
          }, {
            gt: 100,
            lte: 150,
            color: '#ff9933'
          }, {
            gt: 150,
            lte: 200,
            color: '#cc0033'
          }, {
            gt: 200,
            lte: 300,
            color: '#660099'
          }, {
            gt: 300,
            color: '#7e0023'
          }],
          outOfRange: {
            color: '#999'
          }
        },
        series: {
          name: '近十年园区每日用电统计',
          type: 'line',
          data: this.result.map(function(item) {
            return item[1]
          }),
          // data: ['102', '103', '104', '105', '130', '30', '20', '70'],
          // data: this.data2,
          markLine: {
            silent: true,
            data: [{
              yAxis: 50
            }, {
              yAxis: 100
            }, {
              yAxis: 150
            }, {
              yAxis: 200
            }, {
              yAxis: 300
            }]
          }
        }
      })
    }
  }
}
</script>

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
        color: ['#f9cf5a'],
        tooltip: {
          show: true,
          axisPointer: { type: 'none' },
          trigger: 'axis',
          formatter: function(datas) {
            var v = datas[0].value
            var i = datas[0].dataIndex + 1
            if (i === '4') {
              var res = '白下高新智慧园区<br/>发展评分： ' + v + '<br/>排名 ' + i
            } else {
              res = ''
            }
            return res
          }
        },
        grid: {
          left: 10,
          top: 15,
          bottom: 15,
          right: 10
        },
        xAxis: {
          show: false,
          axisLine: {
            lineStyle: {
              color: '#f2f2f2'
            }
          },
          splitLine: { lineStyle: { color: ['#f2f2f2'] }},
          type: 'category',
          data: ['', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '']
        },
        yAxis: {
          show: false,
          splitLine: { lineStyle: { color: '#eee' }},
          axisLine: {

            lineStyle: {
              color: '#ccc'
            }
          },
          type: 'value'
        },
        series: [{
          name: '云创大数据',
          barWidth: '67%', // 柱图宽度
          data: [100, 99, 85, 84, 83, 80, 78, 78, 77, 74, 70, 69, 63, 60, 60, 58, 50, 45, 30, 22],
          type: 'bar',
          itemStyle: {
            emphasis: {
              color: '#00b1f1'
            }
          }
        }]

      })
    }
  }
}
</script>

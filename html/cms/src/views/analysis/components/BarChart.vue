<template>
  <div :class="className" :style="{height:height,width:width}"/>
</template>

<script>
import echarts from 'echarts'
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
        color: ['#2ca9f8', '#aaa'],

        tooltip: {
          trigger: 'axis'
        },
        legend: {
          y: '10px',
          data: ['去年同期照明用电', '昨夜分时照明用电']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },

        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['18:00', '19:00', '20:00', '21:00', '22:00', '23:00', '24:00', '1:00', '2:00', '3:00', '4:00', '5:00']
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          name: '昨夜分时照明用电',
          type: 'line',
          stack: '总量',
          data: [115, 102, 181, 220, 175, 60, 105, 79, 88, 60, 30, 26]

        }, {
          name: '去年同期照明用电',
          type: 'line',
          stack: '总量',
          data: [120, 132, 191, 234, 190, 80, 110, 99, 98, 70, 50, 46]
        }]
      })
    }
  }
}
</script>

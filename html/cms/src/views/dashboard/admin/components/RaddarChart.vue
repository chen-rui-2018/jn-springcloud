<template>
  <div :class="className" :style="{height:height,width:width}"/>
</template>

<script>
import echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import { debounce } from '@/utils'

const animationDuration = 3000

export default {
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

      this.chart.setOption({
        tooltip: {
          trigger: 'axis',
          showContent: false
        },
        dataset: {
          source: [
            ['product', '6时', '7时', '8时', '9时', '10时', '11时', '12时', '13时', '14时', '15时'],
            ['公共照明', 41.1, 30.4, 65.1, 53.3, 83.8, 98.7, 41.1, 30.4, 65.1, 53.3],
            ['企业用电', 86.5, 92.1, 85.7, 83.1, 73.4, 55.1, 92.1, 85.7, 83.1, 73.4],
            ['空调用电', 24.1, 67.2, 79.5, 86.4, 65.2, 82.5, 67.2, 79.5, 86.4, 65.2],
            ['电梯用电', 55.2, 67.1, 69.2, 72.4, 53.9, 39.1, 55.2, 67.1, 69.2, 72.4]
          ]
        },
        xAxis: { type: 'category' },
        yAxis: { gridIndex: 0 },
        grid: { top: '55%' },
        series: [
          { type: 'line', smooth: true, seriesLayoutBy: 'row' },
          { type: 'line', smooth: true, seriesLayoutBy: 'row' },
          { type: 'line', smooth: true, seriesLayoutBy: 'row' },
          { type: 'line', smooth: true, seriesLayoutBy: 'row' }, {
            type: 'pie',
            id: 'pie',
            radius: '30%',
            center: ['50%', '30%'],
            label: {
              formatter: '{b}: {@6时} ({d}%)'
            },
            encode: {
              itemName: 'product',
              value: '6时',
              tooltip: '6时'
            },
            animationDuration: animationDuration
          }]
      })
    }
  }
}
</script>

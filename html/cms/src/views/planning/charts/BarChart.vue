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
      const opts = this.chartopts
      this.chart = echarts.init(document.getElementById(this.id))
      const option = {
        color: ['#81ca3f', '#2181da', '#fdb409'],
        backgroundColor: ['#fff'],
        tooltip: {
          trigger: 'item',
          formatter: '{b}'
        },
        legend: {
          orient: 'vertical',
          x: 'left',
          y: 'center',
          icon: 'circle',
          data: ['项目一', '项目二', '项目三']
        },
        grid: {
          left: 10
        },
        series: [
          {
            label: {
              normal: {
                position: 'inner',
                textStyle: {
                  fontSize: 16
                }
              }
            },
            type: 'pie',
            radius: '60%',
            center: ['60%', 'center'],
            selectedMode: 'single',
            data: opts.series[0].data,
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      }
      this.chart.setOption(option)
    }
  }
}
</script>

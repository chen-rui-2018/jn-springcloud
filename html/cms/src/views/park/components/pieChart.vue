<template>

  <div :piedata="piedata" :class="className" :style="{width:width,height:height}"/>
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
      default: '120px'
    },
    piedata: {
      type: Array,
      default: function() {
        return []
      }
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
        color: ['#79c2ed', '#b1db7e'],
        series: [
          {
            data: this.piedata,
            name: '数据',
            type: 'pie',
            radius: '80%',
            center: ['50%', '40%'],
            avoidLabelOverlap: false,
            labelLine: {
              normal: {
                show: false
              }
            }
          }
        ]
      })
    }
  }
}
</script>

<template>
  <div :class="className" :style="{height:height,width:width}"/>
</template>

<script>
import echarts from 'echarts'
import resize from '@/components/Charts/mixins/resize'
// const animationDuration = 3000
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
        color: ['rgba(92,166,42,1)', 'rgba(192,0,0,1)', 'rgba(25,115,189,1)', 'rgba(92,166,42,.95)', 'rgba(92,166,42,.9)', 'rgba(92,166,42,.85)', 'rgba(192,0,0,.95)', 'rgba(192,0,0,.9)', 'rgba(192,0,0,.85)', 'rgba(25,115,189,.95)', 'rgba(25,115,189,.9)', 'rgba(25,115,189,.85)'],
        series: [{
          name: '来源',
          type: 'pie',
          selectedMode: 'single',
          radius: [0, '25%'],

          label: {
            normal: {
              position: 'inner'
            }
          },
          labelLine: {
            normal: {
              show: false
            }
          },
          data: [
            { value: 1005, name: '电梯', selected: true },
            { value: 670, name: '照明' },
            { value: 1350, name: '空调' }
          ]
        }, {
          name: '用电类型',
          type: 'pie',
          radius: ['35%', '50%'],
          label: {
            normal: {
              formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
              backgroundColor: '#eee',
              borderColor: '#aaa',
              borderWidth: 1,
              borderRadius: 4,
              rich: {
                a: {
                  color: '#999',
                  lineHeight: 22,
                  align: 'center'
                },
                hr: {
                  borderColor: '#aaa',
                  width: '100%',
                  borderWidth: 0.5,
                  height: 0
                },
                b: {
                  fontSize: 14,
                  lineHeight: 33
                },
                per: {
                  color: '#eee',
                  backgroundColor: '#334455',
                  padding: [2, 4],
                  borderRadius: 2
                }
              }
            }
          },
          data: [
            { value: 335, name: '楼一电梯' },
            { value: 335, name: '楼二电梯' },
            { value: 335, name: '楼三电梯' },
            { value: 310, name: '楼一照明' },
            { value: 230, name: '楼二照明' },
            { value: 130, name: '楼三照明' },
            { value: 450, name: '楼一空调' },
            { value: 450, name: '楼二空调' },
            { value: 450, name: '楼三空调' }
          ]
        }]
      })
    }
  }
}
</script>

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
        color: ['#13bafa'],
        tooltip: {
          show: true,
          axisPointer: { type: 'none' },
          trigger: 'axis',
          formatter: function(datas) {
            var v = datas[0].value
            var n = ''
            if (v > 100) {
              n = '优'
            } else if (v > 0 && v < 100) {
              n = '良'
            }
            // var arr=["云创大数据","紫光西部数据","艾科朗克","拓视普","佳汇科技"];
            // var a=arr[parseInt(Math.random()*5)];
            var res = '云创大数据<br/>信用 ' + datas[0].value + '<br/>信用度 ' + n
            /* for (var i = 0, length = datas.length; i < length; i++) {
                       res += datas[i].seriesName + '：'
                           + datas[i].data.originValue + '<br/>'
                     }*/
            return res
          }
        },
        grid: {
          left: 50,
          top: 20,
          bottom: 54,
          right: 30
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
          data: ['', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '']
        },
        yAxis: {
          show: true,
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
          barWidth: 2, // 柱图宽度
          data: [198, 197, 196, 195, 194, 193, 192, 191, 190, 189, 188, 177, 176, 165, 164, 163, 162, 155, 153, 149, 148, 137, 136, 135, 134, 133, 129, 128, 126, 124, 124, 123, 123, 121, 121, 120, 120, 119, 116, 115, 110, 108, 104, 103, 100, 97, 97, 96, 96, 94, 94, 93, 93, 93, 90, 90, 90, 86, 86, 85, 85, 80, 80, 78, 78, 77, 77, 76, 76, 76, 76, 75, 75, 75, 74, 74, 74, 74, 72, 72, 72, 72, 72, 71, 71, 71, 71, 70, 69, 69, 65, 65, 60, 60, 59, 59, 59, 58, 58, 58, 57, 57, 56, 56, 55, 55, 53, 53, 53, 52, 52, 52, 51, 51, 51, 50, 50, 50, 49, 49, 48, 48, 48, 45, 45, 45, 45, 45, 40, 40, 40, 40, 39, 39, 39, 36, 36, 36, 36, 36, 35, 35, 35, 35, 34, 34, 34, 34, 31, 31, 31, 31, 30, 30, 30, 29, 29, 29, 29, 24, 24, 24, 24, 21, 21, 21, 21, 20, 20, 20, 20, 19, 19, 19, 18, 18, 18, 16, 16, 16, 11, 11, 11, 11, 9, 9, 9, 9, 5, 5, 4, 4, 4, 3, 3, 3, 2, 1],
          type: 'bar',
          itemStyle: {
            emphasis: {
              color: '#f00'
            }

          }
        }]
      })
    }
  }
}
</script>

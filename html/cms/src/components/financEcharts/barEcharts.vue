<template>
  <div :id="id" :data="data" :style="{height:height,width:width}"/>
</template>

<script>
import echarts from 'echarts'
import resize from '@/components/Charts/mixins/resize'

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: ''
    },
    id: {
      type: String,
      default: ''
    },
    data: {
      type: Object,
      default: function() {
        return {}
      }
    },
    width: {
      type: String,
      default: ''
    },
    height: {
      type: String,
      default: ''
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
      console.log(this.id)
      this.chart = echarts.init(document.getElementById(this.id))

      var options = {
        title: {
          text: '年' + '管委会每月预算监控(已支出/全年预算)',
          textStyle: {
            color: 'rgb(183, 178, 255)'
          },
          left: '35%'
          // subtext: '纯属虚构'
        },
        tooltip: {
          trigger: 'axis'
          // formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        color: ['rgb(44, 169, 248)', 'rgb(253, 180, 9)'],
        legend: {
          data: ['预算费用', '已支出费用'],
          right: '10%',
          top: '5%',
          orient: 'vertical'
        },
        calculable: true,
        xAxis: {
          show: true, // 是否显示
          position: 'bottom', // x轴的位置
          offset: 0, // x轴相对于默认位置的偏移
          type: 'category', // 轴类型， 默认为 'category'
          name: '月份', // 轴名称
          nameLocation: 'end', // 轴名称相对位置
          nameTextStyle: { // 坐标轴名称样式
            // color: 'red',
            padding: [5, 0, 0, -5]
          },
          nameGap: 15, // 坐标轴名称与轴线之间的距离
          nameRotate: 0, // 坐标轴名字旋转
          axisLine: { // 坐标轴 轴线
            show: true, // 是否显示
            symbol: ['none', 'arrow'], // 是否显示轴线箭头
            symbolSize: [8, 10], // 箭头大小
            symbolOffset: [0, 8], // 箭头位置
            lineStyle: {
              // color: 'blue',
              width: 1,
              type: 'solid'
            }
          },
          axisTick: { // 坐标轴 刻度
            show: true, // 是否显示
            inside: true, // 是否朝内
            length: 3, // 长度
            lineStyle: { // 默认取轴线的样式
              // color: 'red',
              width: 1,
              type: 'solid'
            }
          },
          axisLabel: { // 坐标轴标签
            show: true, // 是否显示
            inside: false, // 是否朝内
            // formatter: '{value}\n' + data.lastYearPercent,
            formatter: function(value, index) {
              // if (data.rows[index].month.slice(4, 5) < 1) {
              //   data.rows[index].month = data.rows[index].month.slice(3, 4) + '月'
              // } else {
              //   data.rows[index].month = data.rows[index].month.slice(4, 6) + '月'
              // }
              var text = this.data.data.dynamicHeadList[index] + ' ' + this.data.data.rows[index].ratio
              return text
            },
            rich: {},
            rotate: 45, // 旋转角度
            margin: 5 // 刻度标签与轴线之间的距离
            // color: 'red' // 默认取轴线的颜色
          },
          splitLine: { // gird区域中的分割线
            show: false, // 是否显示
            lineStyle: {
              // color: 'red',
              // width: 1,
              // type: 'solid'
            }
          },
          splitArea: { // 网格区域
            show: false // 是否显示，默认为false
          },
          data: this.data.data.dynamicHeadList
          // data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        },
        yAxis: [
          {
            axisLine: {
              symbol: ['none', 'arrow'],
              symbolSize: [8, 10], // 箭头大小
              symbolOffset: [0, 8] // 箭头位置
            },
            type: 'value',
            name: '金额（元）'
          }
        ],
        series: [
          {
            name: '预算费用',
            type: 'bar',
            barWidth: '20%',
            data: this.data.lastYearIncomeArr
          },
          {
            name: '已支出费用',
            type: 'bar',
            barGap: '0%',
            barWidth: '20%',
            data: this.data.incomeArr

          }
        ]
      }
      this.chart.setOption(options)
      window.addEventListener('resize', () => { this.chart.resize() })
    }
  }
}
</script>

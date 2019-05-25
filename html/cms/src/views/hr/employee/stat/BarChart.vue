<template>
  <div :class="className" :style="{height:height,width:width}"/>
</template>

<script>
import echarts from 'echarts'
// require('echarts/theme/macarons') // echarts theme
import { debounce } from '@/utils'

export default {
  props: {
    listData: {
      type: Array,
      default: () => {
        return []
      }
    },
    title: {
      type: String,
      default: ''
    },
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
      chart: null,
      names: [],
      values: []
    }
  },
  watch: {
    listData: {
      handler(newValue, oldValue) {
        this.setOption()
      },
      deep: true
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
      this.setOption()
    },
    setOption() {
      if (!this.chart) {
        return
      }
      this.names = this.listData.map(data => {
        return data.name
      })
      this.values = this.listData.map(data => {
        return data.value
      })
      this.chart.setOption({
        title: {
          text: this.title,
          left: 'center',
          top: 20,
          textStyle: {
            color: '#ccc'
          }
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar'] },
            restore: { show: true },
            saveAsImage: { show: true }
          },
          optionToContent: function(opt) {
            const axisData = opt.xAxis[0].data // 坐标数据
            const series = opt.series // 折线图数据
            let tdHeads = '<td  style="padding: 0 10px">部门</td>' // 表头
            let tdBodys = '' // 数据
            series.forEach(function(item) {
              // 组装表头
              tdHeads += `<td style="padding: 0 10px">${item.name}</td>`
            })
            let table = `<table border="1" style="margin-left:20px;border-collapse:collapse;font-size:14px;text-align:center"><tbody><tr>${tdHeads} </tr>`
            for (let i = 0, l = axisData.length; i < l; i++) {
              for (let j = 0; j < series.length; j++) {
                // 组装表数据
                tdBodys += `<td>${series[j].data[i]}</td>`
              }
              table += `<tr><td style="padding: 0 10px">${axisData[i]}</td>${tdBodys}</tr>`
              tdBodys = ''
            }
            table += '</tbody></table>'
            return table
          }
        },
        xAxis: {
          type: 'category',
          data: this.names
        },
        yAxis: {
          type: 'value',
          name: '(人)'
        },
        series: [{
          data: this.values,
          name: '人数',
          type: 'bar'
        }]
      })
    }
  }
}
</script>
<style scoped>
  .chart{
    position:relative;
  }
</style>

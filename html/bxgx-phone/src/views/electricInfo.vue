<template>
  <div class="electricInfo">
    <div>{{currentDate}}</div>
    <div>{{enterpriseName}}</div>
    <div class="site">
      <div><span>{{site}}</span><span>{{roomNumber}}</span></div>
      <div><span> <i class="room1"></i> 607室</span> <span> <i class="room2"> </i> 608室</span></div>
    </div>
    <div>今日用电</div>
     <div id="dayElectric" style="height:200px;width:100%">

  </div>
    <div>本月用电</div>
    <div id="monthElectric" style="height:200px;width:100%"></div>
    <div>今年用电</div>
    <div id="yearElectric" style="height:200px;width:100%"></div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      roomNumber: '607、608室',
      enterpriseName: '南京白下高新科技企业',
      currentDate: '',
      site: '白下高新区XX路XX号',
      dayData: ['1点', '2点', '3点', '4点', '5点', '6点', '7点', '8点', '9点', '10点', '11点', '12点', '13点', '14点', '15点', '16点', '17点', '18点', '19点', '20点', '21点', '22点', '23点', '24点'],
      yearData: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
      monthData: ['9月1日', '9月2日', '9月3日', '9月4日', '9月5日', '9月6日', '9月7日', '9月8日', '9月9日', '9月10日', '9月11日', '9月12日', '9月13日', '9月14日', '9月15日', '9月16日', '9月17日', '9月18日', '9月19日', '9月20日', '9月21日', '9月22日', '9月23日', '9月24日', '9月25日', '9月26日', '9月27日', '9月28日']
    }
  },
  mounted () {
    this.currentDate = this.api.getCurrentTime()
    this.init()
  },
  methods: {
    getDay () {
      let dayElectric = this.$echarts.init(
        document.getElementById('dayElectric')
      )
      this.drawLine(dayElectric, this.dayData)
      window.onresize = function () {
        dayElectric.resize()
      }
    },
    getMonth () {
      let monthElectric = this.$echarts.init(
        document.getElementById('monthElectric')
      )
      this.drawLine(monthElectric, this.monthData)
      window.onresize = function () {
        monthElectric.resize()
      }
    },
    getYear () {
      let yearElectric = this.$echarts.init(
        document.getElementById('yearElectric')
      )
      this.yearCharts(yearElectric, this.yearData)
      window.onresize = function () {
        yearElectric.resize()
      }
    },
    init () {
      this.getDay()
      this.getMonth()
      this.getYear()
    },
    drawLine (name, data) {
      // 绘制图表
      name.setOption({
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        color: ['rgb(68, 114, 196)', 'rgb(237, 125, 49)'],
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          top: '4%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          data: data,
          axisLabel: {
            interval: 0,
            rotate: 90,
            textStyle: {
            //   color: '#c3dbff', // 更改坐标轴文字颜色
              fontSize: 10 // 更改坐标轴文字大小
            }
          },
          axisTick: {
            alignWithLabel: true
          }
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '直接访问',
            type: 'bar',
            stack: '总量',
            data: [320, 302, 301, 334, 390, 330, 320]
          },
          {
            name: '邮件营销',
            type: 'bar',
            stack: '总量',
            data: [120, 132, 101, 134, 90, 230, 210]
          }
        ]
      })
    },
    yearCharts (name, data) {
      // 绘制图表
      name.setOption({
        color: ['#3398DB'],
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          top: '4%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            data: data,
            axisLabel: {
              interval: 0,
              textStyle: {
                //   color: '#c3dbff', // 更改坐标轴文字颜色
                fontSize: 10 // 更改坐标轴文字大小
              }
            },
            axisTick: {
              alignWithLabel: true
            }
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: '直接访问',
            type: 'bar',
            barWidth: '60%',
            data: [10, 52, 200, 334, 390, 330, 220]
          }
        ]
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.electricInfo {
  padding-top: 1.4rem;
  > div {
    font-size: 34px;
    padding: 15px 30px;
  }
  .site {
    font-size: 28px;
    display: flex;
    justify-content: space-between;
    .room1,
    .room2 {
      display: inline-block;
      width: 20px;
      height: 20px;
      vertical-align: middle;
    }
    .room1 {
      background: rgb(68, 114, 196);
    }
    .room2 {
      background: rgb(237, 125, 49);
    }
  }
}
</style>

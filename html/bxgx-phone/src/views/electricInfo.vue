<template>
  <div class="electricInfo">
    <div>{{currentDate}}</div>
    <div>{{enterpriseName}}</div>
    <div class="site">
      <div><span>{{site}}</span><span>{{roomNumber}}</span></div>
      <!-- <div><span> <i class="room1"></i> 607室</span> <span> <i class="room2"> </i> 608室</span></div> -->
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
      // roomNumber: '607、608室',
      enterpriseName: '',
      currentDate: '',
      site: '',
      dayData: ['0点', '1点', '2点', '3点', '4点', '5点', '6点', '7点', '8点', '9点', '10点', '11点', '12点', '13点', '14点', '15点', '16点', '17点', '18点', '19点', '20点', '21点', '22点', '23点'],
      yearData: [],
      monthData: []
    }
  },
  mounted () {
    this.currentDate = this.api.getCurrentTime()
    this.init()
  },
  methods: {
    getDay () {
      this.api.get({
        url: 'todayelectro',
        // data: this.userInfo,
        callback: res => {
          if (res.code === '0000') {
            let electricData = []
            if (res.data) {
              res.data.forEach(v => {
                electricData.push(v.sumelectro)
              })
              let dayElectric = this.$echarts.init(
                document.getElementById('dayElectric')
              )

              window.onresize = function () {
                dayElectric.resize()
              }
              this.$nextTick(() => {
                this.myCharts(dayElectric, this.dayData, electricData)
              })
            }
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    },
    getMonth () {
      this.api.get({
        url: 'monthelectro',
        // data: this.userInfo,
        callback: res => {
          if (res.code === '0000') {
            let electricData = []
            if (res.data) {
              res.data.forEach(v => {
                electricData.push(v.sumelectro)
                this.monthData.push(v.data)
              })
              let monthElectric = this.$echarts.init(
                document.getElementById('monthElectric')
              )

              window.onresize = function () {
                monthElectric.resize()
              }
              this.$nextTick(() => {
                this.myCharts(monthElectric, this.monthData, electricData)
              })
            }
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    },
    getYear () {
      this.api.get({
        url: 'yearelectro',
        // data: this.userInfo,
        callback: res => {
          if (res.code === '0000') {
            console.log(res)
            let electricData = []
            if (res.data) {
              res.data.forEach(v => {
                electricData.push(v.sumelectro)
                this.yearData.push(v.year + '年' + v.month)
              })
              let yearElectric = this.$echarts.init(
                document.getElementById('yearElectric')
              )

              window.onresize = function () {
                yearElectric.resize()
              }
              this.$nextTick(() => {
                this.myCharts(yearElectric, this.yearData, electricData)
              })
            }
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    },
    init () {
      this.getCompanyDetailByNowAccount()
      this.getDay()
      this.getMonth()
      this.getYear()
    },
    // 获取用户企业信息
    getCompanyDetailByNowAccount () {
      this.api.get({
        url: 'getCompanyDetailByNowAccount',
        // data: this.userInfo,
        callback: res => {
          if (res.code === '0000') {
            console.log(res)
            if (res.data) {
              this.enterpriseName = res.data.comName
              this.site = res.data.addrPark
            }
          }
        }
      })
    },
    myCharts (name, data, electricData) {
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
            name: '用电情况',
            type: 'bar',
            // stack: '总量',
            // data: [320, 302, 301, 334, 390, 330, 320]
            data: electricData
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

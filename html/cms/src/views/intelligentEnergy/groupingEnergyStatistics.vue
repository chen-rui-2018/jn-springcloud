<template>
  <div class="groupingEnergyStatistics">
    <div class="building">
      <div><span>当日楼宇能耗统计(千瓦时)</span> </div>
      <div id="build" style="width:100%;height:400px;" />
      <div class="table-d">
        <table border="0" cellspacing="1" cellpadding="0">
          <tr>
            <td width="150">楼宇位置</td>
            <td v-for="(v, index1) in positionList" :key="index1" width="10"> {{ v }} </td>
          </tr>
          <tr>
            <td width="150"><i class="energy"/>能耗</td>
            <td v-for="(item, index) in energyList" :key="index">{{ item }}</td>
          </tr>
          <tr>
            <td class="tdWidth"><i class="energyNum" /> 高能耗设备数量</td>
            <td v-for="(i, idx) in isHeightList" :key="idx">{{ i }}</td>
          </tr>
        </table>
      </div>
    </div>
    <div class="building">
      <div><span>当日分类设备能耗趋势(千瓦时)</span></div>
      <div id="equipment" style="width:100%;height:400px;" />
    </div>
  </div>
</template>

<script>
import { api } from '@/api/axios'
export default {
  data() {
    return {
      energyList: [],
      isHeightList: [],
      positionList: []
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      api(
        `${this.GLOBAL.parkUrl}meter/groupChart
`,
        '',
        'get'
      ).then(res => {
        console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          this.$nextTick(() => {
            this.myCharts(res.data.data)
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
      api(`${this.GLOBAL.parkUrl}meter/categaryChart`, '', 'get').then(res => {
        console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          this.$nextTick(() => {
            this.equipment(res.data)
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    myCharts(data) {
      const xData = []
      const energyArr = []
      data.forEach(val => {
        xData.push(val.position)
        energyArr.push(Number(val.brReadingEnd).toFixed(2))
        this.isHeightList.push(val.isHigh)
      })
      this.energyList = energyArr
      this.positionList = xData
      // 基于准备好的dom，初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById('build'))

      // 指定图表的配置项和数据
      var option = {
        color: ['#3398DB'],
        tooltip: {
          trigger: 'axis'
          // axisPointer: { // 坐标轴指示器，坐标轴触发有效
          //   type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          // }
        },
        grid: {
          // left: '3%',
          // right: '4%',
          bottom: '10%',
          containLabel: true
        },
        xAxis: [
          {
            // name: '时',
            type: 'category',
            // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            data: xData,
            // axisTick: {length:5},
            axisLabel: {// 坐标轴刻度标签的相关设置。
              // interval: 0,
              rotate: '45'
            },
            axisTick: {
              alignWithLabel: true,
              length: 2
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
            name: '当日能耗',
            type: 'bar',
            barWidth: '20%',
            // data: [10, 52, 200, 334, 390, 330, 220]
            data: energyArr
          }
        ]
      }

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option)
      window.addEventListener('resize', () => {
        myChart.resize()
      })
    },
    equipment(data) {
      console.log(data)
      if (data.data) {
        var xArr = [] // x轴数据
        var publicArr = [] // 公共用电
        var airArr = [] // 空调用电
        var floorArr = [] // 楼层用电
        var enterpriseArr = []// 企业用电
        data.data.forEach(val => {
          xArr.push(val.dealDateValue)
          if (val.type === '1') {
            publicArr.push(val.bValue)
          } else if (val.type === '2') {
            airArr.push(val.bValue)
          } else if (val.type === '3') {
            floorArr.push(val.bValue)
          } else if (val.type === '0') {
            enterpriseArr.push(val.bValue)
          }
        })
        xArr = Array.from(new Set(xArr))
        // publicArr = Array.from(new Set(publicArr))
        // airArr = Array.from(new Set(airArr))
        // floorArr = Array.from(new Set(floorArr))
        // console.log(xArr)
        // console.log(publicArr)
        // console.log(airArr)
        // console.log(floorArr)
        // 基于准备好的dom，初始化echarts实例
        var Chart = this.$echarts.init(document.getElementById('equipment'))

        // 指定图表的配置项和数据
        var options = {
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: ['企业用电', '公共照明', '空调用电', '楼层用电']
          },
          // grid: {
          //   left: '3%',
          //   right: '4%',
          //   bottom: '3%',
          //   containLabel: true
          // },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: xArr
            // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
          },
          yAxis: {
            // name: '每日用电趋势',
            type: 'value'
          },
          series: [
            {
              name: '企业用电',
              type: 'line',
              itemStyle: {
                normal: {
                  color: 'rgb(255, 155, 121)', // 这点颜色
                  lineStyle: {
                    color: 'rgb(255, 155, 121)' // 折线颜色
                  }
                }
              },
              // stack: '总量',
              data: enterpriseArr
              // data: [120, 132, 101, 134, 90, 230, 210]
            },
            {
              name: '公共照明',
              type: 'line',
              itemStyle: {
                normal: {
                  color: 'rgb(255, 155, 121)', // 这点颜色
                  lineStyle: {
                    color: 'rgb(255, 155, 121)' // 折线颜色
                  }
                }
              },
              // stack: '总量',
              data: publicArr
              // data: [120, 132, 101, 134, 90, 230, 210]
            },
            {
              name: '空调用电',
              type: 'line',
              // stack: '总量',
              data: airArr
              // data: [220, 182, 191, 234, 290, 330, 310]
            },
            {
              name: '楼层用电',
              type: 'line',
              // stack: '总量',
              data: floorArr
              // data: [320, 332, 301, 334, 390, 330, 320]
            }
          ]
        }

        // 使用刚指定的配置项和数据显示图表。
        Chart.setOption(options)
        window.addEventListener('resize', () => {
          Chart.resize()
        })
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.groupingEnergyStatistics {
  .table-d{
    text-align: center;
    text-align: -webkit-center;
     .energy {
      display: inline-block;
      width: 10px;
      margin-right:5px;
      height: 10px;
      background: rgb(66, 112, 195);
    }
    .energyNum {
      display: inline-block;
      width: 10px;
      height: 10px;
      background: rgb(255, 155, 121);
    }
    .tdWidth{
      width: 150px !important;
    }
  }
  .table-d table {
    background: #ccc;
  }
  .table-d table td {
    background: #fff;
    text-align: center;
    padding: 15px;
    font-size: 14px;
    word-wrap:break-word;word-break:break-all;
    width:80px;
  }
  .building {
    margin-top: 20px;
    > div:nth-child(1) {
      padding: 10px 20px;
      display: flex;
      justify-content: space-between;
      // > span:nth-child(2) {
      //   color: rgb(128, 190, 255);
      //   font-size: 14px;
      //   cursor: pointer;
      // }
    }
  }

}
</style>

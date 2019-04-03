<template>
  <div>
    <header class="clearfix">
      <div style="float:left;font-size: 27px;">财务监控明细 - 园区收入</div>
      <el-form
        :inline="true"
        :model="listQuery"
        style="float:left;margin-left:20px;"
      >
        <el-form-item
          label="数据月份:"
          style="margin-bottom:unset;"
        >
          <el-date-picker
            v-model="listQuery.startMonth"
            type="month"
            value-format="yyyyMM"
            placeholder="开始月份"
          />
          至
          <el-date-picker
            v-model="listQuery.endMonth"
            type="month"
            value-format="yyyyMM"
            placeholder="结束月份"
          />
        </el-form-item>
        <el-button
          type="primary"
          style="float:right;margin-right:10px;"
          icon="el-icon-search"
          @click="handleFilter"
        >查询</el-button>
        <el-button
          type="primary"
          style="float:right;margin-right:10px;"
        ><router-link :to="{name:'expenses'}">支出导入</router-link></el-button>
        <el-button
          type="primary"
          style="float:right;margin-right:10px;"
          @click="handleexcel"
        >导出</el-button>
        <el-button
          type="primary"
          style="float:right;margin-right:10px;"
          @click="handleFilter"
        >返回主页</el-button>
      </el-form>
    </header>
    <hr>
    <el-row :gutter="10">
      <el-col :span="6" style="height:250px;">
        <div
          class="echarsborder"
          style="padding:10px 10px;"
        >
          <div style="background:rgb(40, 175, 231);color:#fff;padding:10px;border-radius:5px;height:47%">
            <div style="margin-bottom:10px;"> <span style="font-size:50px;margin-right:10px;">{{ money }}</span>万元 </div>
            <div style="position:relative">
              <span>收入合计</span>
              <span
                class="iconfont"
                style="font-size: 42px;
                 position: absolute;
                 top: -18px;
                 right: -1px;"
              >&#xe602;</span>
            </div>
          </div>
          <div style="background:rgb(253, 180, 9);color:#fff;padding:10px;border-radius:5px;height:47%;margin-top:10px;">
            <div style="margin-bottom:10px;"> <span :class="percentage.slice(0,1)==='-'?'text-red':percentage.slice(0,1)==='+'?'text-green':''" style="font-size:50px;margin-right:10px;">{{ percentage }}</span>
              <strong
                v-show="percentage.slice(0,1)==='-'"
                class="iconfont"
                style="font-size: 35px;
                    vertical-align: super;
             color: red;"
              >&#xe631;</strong> <strong
                v-show="percentage.slice(0,1)==='+'"
                class="iconfont"
                style="font-size: 35px;
                    vertical-align: super;
             color: green;"
              >&#xe63a;</strong> <strong
                v-show="percentage.slice(0,1)===''"
                class="iconfont"
                style="font-size: 35px;
                    vertical-align: super;
             color: '';"
            /> </div>

            <div style="position:relative">
              <span>对比去年同期</span>
              <span
                class="iconfont"
                style="font-size: 42px;
                 position: absolute;
                 top: -18px;
                 right: -1px;"
              >&#xe629;</span>
            </div>
          </div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="echarsborder">
        <div id="myChart" :style="{width: '100%', height: '250px'}"/></div>
      </el-col>
      <el-col :span="6">
        <div class="echarsborder">
          <div id="collect" :style="{width: '100%', height: '250px'}" />
      </div></el-col>
    </el-row>
    <!-- 表格数据 -->
    <div style="margin:20px 0px;">
      <el-table :data="incomeList" border fit highlight-current-row style="width: 100%;">
        <el-table-column label="序列" type="index" align="center" width="60"/>
        <el-table-column label="分类" prop="incomeTypeName" align="center" />
        <el-table-column :label="textYear" align="center" >
          <el-table-column v-for="(item, index) in tableHeader" :key="index" :label="item" prop="financeIncomeLastYearContrastModels" align="center" min-width="100">
            <el-table-column label="去年" prop="createdTime" align="center">
              <template slot-scope="scope">
                <span>￥{{ scope.row.financeIncomeLastYearContrastModels[index].lastYearIncome }}</span>
              </template>
            </el-table-column>
            <el-table-column label="今年" prop="createdTime" align="center">
              <template slot-scope="scope">
                <span>￥{{ scope.row.financeIncomeLastYearContrastModels[index].income }}</span>
              </template>
            </el-table-column>
          <!-- <template slot-scope="scope">
              <span>{{ scope.row.budgetMoneyModels[index].money }}</span>
            </template> -->
          </el-table-column>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import {
  api
} from '@/api/financ'
export default {
  data() {
    return {
      percentage: '',
      // showUp: false,
      textYear: '',
      tableHeader: [],
      incomeList: [],
      drawLineData: [],
      money: '',
      listQuery: {
        startMonth: '',
        endMonth: ''
      }
    }
  },
  mounted() {
    this.getDate()
    this.inislist()
    this.getPeriodContrast()
    // this.drawLine(this.drawLineData)
  },
  methods: {
    // 导出
    handleexcel() {
      api(`finance/income/exportContrast?year=${this.textYear}`, '', 'get').then(res => {
        window.location.href = res.request.responseURL
      })
    },
    // 获取时间
    getDate() {
      const date = new Date()
      const month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1
      this.listQuery.startMonth = date.getFullYear() + '01'
      this.listQuery.endMonth = (date.getFullYear()).toString() + month.toString()
    },
    // 查询数据
    handleFilter() {
      this.inislist()
    },
    // 设置柱状图
    drawLine(data) {
      var mouthArr = []
      var lastYearIncomeArr = []
      var incomeArr = []

      for (let i = 0; i < data.length; i++) {
        mouthArr.push(data[i].month)
        lastYearIncomeArr.push(
          Number(data[i].lastYearIncome)
        )
        incomeArr.push(
          Number(data[i].income)
        )
      }
      for (let j = 0; j < mouthArr.length; j++) {
        if (mouthArr[j].slice(0, 1) < 1) {
          mouthArr[j] = mouthArr[j].slice(1, 2) + '月'
        } else {
          mouthArr[j] = mouthArr[j] + '月'
        }
      }
      // 基于准备好的dom，初始化echarts实例
      const myChart = this.$echarts.init(document.getElementById('myChart'))
      // 绘制图表
      var options = {
        title: {
          text: '园区各月收入与同期对比',
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
          data: ['去年同期收入', '今年当期收入'],
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
              if (data[index].month.slice(0, 1) < 1) {
                data[index].month = data[index].month.slice(1, 2) + '月'
              }
              var text = data[index].month + '\n' + data[index].lastYearPercent
              return text
            },
            rich: {},
            rotate: 0, // 旋转角度
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
          data: mouthArr
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
            name: '去年同期收入',
            type: 'bar',
            barWidth: '20%',
            data: lastYearIncomeArr
          },
          {
            name: '今年当期收入',
            type: 'bar',
            barGap: '0%',
            barWidth: '20%',
            data: incomeArr

          }
        ]
      }
      myChart.setOption(options)
    },
    // 设置汇总圆环图
    collectPie(data) {
      console.log(data)
      var legendArr = []
      var seriesArr = []
      data.forEach(val => {
        legendArr.push(val.incomeTypeName)
        seriesArr.push({
          value: val.income,
          name: val.incomeTypeName
        })
      })

      const collect = this.$echarts.init(document.getElementById('collect'))
      var collectOption = {
        title: {
          text: '各项收入汇总占比情况',
          textStyle: {
            color: 'rgb(183, 178, 255)'
          },
          left: '20%'
        // subtext: '纯属虚构'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          right: '5%',
          bottom: '20%',
          // data: ['电费', '楼宇租金', '物业费', '其它']
          data: legendArr
        },
        series: [
          {
            name: '收入分类',
            type: 'pie',
            center: ['35%', '55%'],
            radius: ['50%', '70%'],
            color: ['rgb(46, 199, 201)', 'rgb(182, 162, 222)', 'rgb(123, 192, 242)', 'rgb(255, 185, 128)'],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: false,
                position: 'center'
              },
              emphasis: {
                show: true,
                textStyle: {
                  fontSize: '25',
                  fontWeight: 'bold'
                  // color: '#000'
                }
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            // data: [
            //   { value: 335, name: '电费' },
            //   { value: 310, name: '楼宇租金' },
            //   { value: 234, name: '物业费' },
            //   { value: 135, name: '其它' }
            // ]
            data: seriesArr
          }
        ]
      }
      collect.setOption(collectOption)
    },
    inislist() {
      this.getPeriodContrast()
      this.getCollect()
      this.textYear = this.listQuery.startMonth.slice(0, 4) + '年'
      this.getTableDate()
    },
    // 获取表格数据
    getTableDate() {
      api(`finance/income/lastYearContrast?startTime=${this.listQuery.startMonth}&endTime=${this.listQuery.endMonth}`, '', 'get').then(res => {
        if (res.data.code === '0000') {
          this.incomeList = res.data.data.rows
          this.tableHeader = res.data.data.dynamicHeadList
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取汇总信息
    getCollect() {
      api(`finance/income/summarizingProportion?startTime=${this.listQuery.startMonth}&endTime=${this.listQuery.endMonth}`, '', 'get').then(res => {
        if (res.data.code === '0000') {
          this.collectPie(res.data.data)
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取明细， 同期对比
    getPeriodContrast() {
      api(`finance/income/periodContrast?startTime=${this.listQuery.startMonth}&endTime=${this.listQuery.endMonth}`, '', 'get').then(res => {
        if (res.data.code === '0000') {
          console.log(res)
          // myChart.setOption.xAxis.data = res.data
          this.drawLine(res.data.data)
          this.money = res.data.data[0].sumIncome
          this.money = (Math.round(this.money / 100) / 100).toFixed(2)
          console.log(this.money)
          this.percentage = res.data.data[0].sumLastYearPercent
          // if (res.data.data[0].lastYearPercent.slice(0, 1) === '-') {
          //   this.showUp = false
          //   this.showDown = true
          // } else if (res.data.data[0].lastYearPercent.slice(0, 1) === '+') {
          //   this.showUp = true
          //   this.showDown = false
          // }
          // this.drawLineData = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  .echarsborder{
    border:1px solid rgb(44, 169, 248);
    border-radius:8px;
  }
</style>

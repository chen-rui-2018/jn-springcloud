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
        ><router-link :to="{name:'expenses'}">支出录入</router-link></el-button>
        <el-button
          type="primary"
          style="float:right;margin-right:10px;"
          @click="handleexcel"
        >导出</el-button>
        <el-button
          type="primary"
          style="float:right;margin-right:10px;"
          @click="handleFilter"
        ><router-link :to="{name:'monitoring'}">返回主页</router-link></el-button>
      </el-form>
    </header>
    <hr>
    <el-row :gutter="10">
      <el-col :span="6" style="height:250px;">
        <div
          class="echarsborder write"
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
                v-show="percentage.slice(0,1)!=='-'"
                class="iconfont"
                style="font-size: 35px;
                    vertical-align: super;
             color: green;"
            >&#xe63a;</strong></div>

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
        <div class="echarsborder write">
        <div id="myChart" :style="{width: '100%', height: '250px'}"/></div>
      </el-col>
      <el-col :span="6">
        <div class="echarsborder write">
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
  },
  methods: {
    // 导出
    handleexcel() {
      api(`finance/income/exportContrast?year=${this.textYear.slice(0, 4)}`, '', 'get').then(res => {
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
      if (this.listQuery.startMonth === '' || this.listQuery.startMonth === undefined) {
        alert('请选择开始日期')
        return false
      } else if (this.listQuery.endMonth === '' || this.listQuery.endMonth === undefined) {
        alert('请选择结束日期')
        return false
      }
      this.inislist()
    },
    // 设置柱状图
    drawLine(data) {
      // 基于准备好的dom，初始化echarts实例
      const myChart = this.$echarts.init(document.getElementById('myChart'))
      if (data.rows) {
        myChart.hideLoading()
        var lastYearIncomeArr = []
        var incomeArr = []
        for (let i = 0; i < data.rows.length; i++) {
          lastYearIncomeArr.push(
            Number(data.rows[i].lastYearIncome)
          )
          incomeArr.push(
            Number(data.rows[i].income)
          )
        }
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
              // if (data[index].month.slice(0, 1) < 1) {
              //   data[index].month = data[index].month.slice(1, 2) + '月'
              // }
              // else {
              //   data[index].month = data[index].month + '月'
              // }
                var text = data.dynamicHeadList[index] + '  ' + data.rows[index].lastYearPercent
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
            data: data.dynamicHeadList
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
      } else {
        var ttt = {
          text: '暂无数据',
          color: '#c23531',
          textColor: '#000',
          maskColor: 'rgba(255, 255, 255, 0.8)',
          zlevel: 0
        }

        myChart.setOption({}, true)
        // myChart.clear()
        myChart.showLoading('default', ttt)
      }
    },
    // 设置汇总圆环图
    collectPie(data) {
      const collect = this.$echarts.init(document.getElementById('collect'))
      if (data.length > 0) {
        collect.hideLoading()
        var legendArr = []
        var seriesArr = []
        data.forEach(val => {
          legendArr.push(val.incomeTypeName)
          seriesArr.push({
            value: val.income,
            name: val.incomeTypeName
          })
        })
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
      } else {
        var ttt = {
          text: '暂无数据',
          color: '#c23531',
          textColor: '#000',
          maskColor: 'rgba(255, 255, 255, 0.8)',
          zlevel: 0
        }

        collect.setOption({}, true)
        // myChart.clear()
        collect.showLoading('default', ttt)
      }
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
        if (res.data.code === this.GLOBAL.code) {
          if (res.data.data.rows.length > 0) {
            this.incomeList = res.data.data.rows
            this.tableHeader = res.data.data.dynamicHeadList
          } else {
            this.incomeList = []
            this.tableHeader = []
          }
        } else {
          this.$message.error(res.data.result)
          this.incomeList = []
          this.tableHeader = []
        }
      })
    },
    // 获取汇总信息
    getCollect() {
      api(`finance/income/summarizingProportion?startTime=${this.listQuery.startMonth}&endTime=${this.listQuery.endMonth}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.collectPie(res.data.data)
        } else {
          // this.$message.error(res.data.result)
          this.collectPie(this.drawLineData)
        }
      })
    },
    // 获取明细， 同期对比
    getPeriodContrast() {
      api(`finance/income/periodContrast?startTime=${this.listQuery.startMonth}&endTime=${this.listQuery.endMonth}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          // myChart.setOption.xAxis.data = res.data
          if (res.data.data.rows.length > 1) {
            this.drawLine(res.data.data)
            this.money = res.data.data.rows[0].sumIncome
            this.money = (Math.round(this.money / 100) / 100).toFixed(2)
            this.percentage = res.data.data.rows[0].sumLastYearPercent
          } else {
            this.drawLine(this.drawLineData)
            this.money = ''
            this.percentage = ''
          }
        } else {
          this.drawLine(this.drawLineData)
          // this.$message.error(res.data.result)
          this.money = ''
          this.percentage = ''
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

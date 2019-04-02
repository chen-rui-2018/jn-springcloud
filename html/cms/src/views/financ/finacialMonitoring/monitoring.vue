<template>
  <div class="monitoring">
    <header>
      <el-row>
        <el-col
          :span="4"
          class="Year">
          <el-date-picker
            v-model="selectYear"
            type="year"
            value-format="yyyy"
            placeholder="请选择年"
            size="small"
          />
        </el-col>
        <el-col :span="12">
          <div style="text-align:center;height:36px; line-height: 36px;">园区管委会:&nbsp;&nbsp; <span style="color:#666;"><span>{{ selectYear }}</span>已支出/全年预算:&nbsp;&nbsp;</span><span style="color:rgb(64, 158, 255);">{{ baifen }}</span></div>
        </el-col>
        <el-col :span="8">
          <div style="float:right;margin-left:10px;height:36px; line-height: 36px;color:#333;font-size:18px;">预算使用状态:<span
            style="    height: 32px;
             width: 66px;
           margin-left: 5px;
          display: inline-block;
          background: rgb(95, 202, 9);
               font-size: 14px;
            border-radius: 4px;
          text-align: center;
          color: rgb(255, 255, 255);">正常</span></div>
          <div style="float:right;">
            <el-button type="primary">
              <router-link :to="{name:'income'}">收入</router-link>
            </el-button>
            <el-button type="primary">返回主页</el-button>
          </div>
        </el-col>
      </el-row>
    </header>
    <el-row :gutter="15" style="margin-top:20px;">
      <el-col v-for="(item, index) in headerArr" :span="4" :key="index">
        <div class="write ">
          <div class="textPadding" style="color:#666;">{{ item.departmentName }}</div>
          <div style="text-align: center;"><span style="font-size:60px;"> {{ item.ratio.split('%')[0] }}</span>{{ item.ratio.split('.')[1] }}</div>
          <div class="textStyle">已支出/全年预算</div>
          <div class="textPadding textBorder" >
            查看明细
          </div>
      </div></el-col>
    </el-row>
    <div id="myChart" :style="{width: '100%', height: '350px'}"/>
</div></template>

<script>
import {
  api
} from '@/api/financ'
export default {
  data() {
    return {
      headerArr: [],
      selectYear: '2019',
      baifen: '76%'
    }
  },
  mounted() {
    this.getDate()
    this.getBudgetExpendRatio()
  },
  methods: {
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
          text: '管委会每月预算监控(已支出/全年预算)',
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
          data: ['预算费用', '已支出/全年预算百分比'],
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
            name: '预算费用',
            type: 'bar',
            barWidth: '20%',
            data: lastYearIncomeArr
          },
          {
            name: '已支出/全年预算百分比',
            type: 'bar',
            barGap: '0%',
            barWidth: '20%',
            data: incomeArr

          }
        ]
      }
      myChart.setOption(options)
    },
    // 各部门预算支出占比模块
    getBudgetExpendRatio() {
      api(`finance/index/budgetExpendRatio?year=${this.selectYear}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          console.log(res)
          this.headerArr = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取时间
    getDate() {
      var time = new Date()
      this.selectYear = time.getFullYear() + ''
    }
  }
}
</script>

<style lang="scss" scoped>
.el-date-editor.el-input,
.el-date-editor.el-input__inner {
  width: 90px;
  background: #fff;
}
.write{
  background: #fff;
  border-radius: 8px;
}
.textStyle{
      color: #666;
    text-align: center;
    font-size: 14px;
    padding-bottom: 20px;
}
.textPadding{
  padding:15px;
  text-align: center;
}
.textBorder{
  border-top:1px solid #ccc;
}
</style>
<style lang="scss">
.monitoring {
  header {
    // .dis{
    //    display:inline-block;
    //   }
    .Year {
      .el-input--suffix .el-input__inner {
        padding-right: unset !important;
      }
    }
  }
}
</style>

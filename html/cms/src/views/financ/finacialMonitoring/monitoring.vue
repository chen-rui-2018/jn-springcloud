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
            @change="changeYear"
          />
        </el-col>
        <el-col :span="12">
          <div style="text-align:center;height:36px; line-height: 36px;">园区管委会:&nbsp;&nbsp; <span style="color:#666;"><span>{{ selectYear }}</span>已支出/全年预算:&nbsp;&nbsp;</span><span style="color:rgb(64, 158, 255);">{{ ratio }}</span></div>
        </el-col>
        <el-col :span="8">
          <div style="float:right;margin-left:10px;height:36px; line-height: 36px;color:#333;font-size:18px;">预算使用状态:<span
            :class="textRatio!=='正常'?'ratioRed ratio':'ratioGreen ratio'">{{ textRatio }}</span></div>
          <div style="float:right;">
            <el-button type="primary">
              <router-link :to="{name:'income'}">收入情况</router-link>
            </el-button>
            <el-button type="primary">返回主页</el-button>
          </div>
        </el-col>
      </el-row>
    </header>
    <el-row :gutter="15" style="margin-top:10px;">
      <el-col v-for="(item, index) in headerArr" v-show="headerArr.length>0" :span="4" :key="index" >
        <div class="write " style="margin-top:10px;margin-bottom:10px;" @click="handleDetails(item)">
          <div class="textPadding" style="color:#666;">{{ item.departmentName }}</div>
          <div style="text-align: center;color:#666;"><span :class="Number(item.ratio.split('%')[0])>Number(ratio.split('%')[0])?'text-red':'text-blue'" style="font-size:60px;"> {{ item.ratio.split('%')[0] }}</span>%</div>
          <div class="textStyle">已支出/全年预算</div>
          <div
            :class="Number(item.ratio.split('%')[0])>Number(ratio.split('%')[0])?'text-red':'text-blue'"
            style=" padding:15px;
             text-align: center; border-top:1px solid #ccc;">
            查看明细 <span v-show="Number(item.ratio.split('%')[0])>Number(ratio.split('%')[0])" class="iconfont" style="color:red;float:right;font-size:20px;">&#xe604;</span>
            <span v-show="Number(item.ratio.split('%')[0])<Number(ratio.split('%')[0])" class="iconfont" style="color:blue;float:right;font-size:20px;">&#xe68b;</span>
          </div>
      </div></el-col>
      <div v-show="headerArr.length<=0" class="write" style="text-align:center;height:200px;line-height:200px;">暂无数据</div>
    </el-row>
    <div style="margin:20px 0px ; background:#fff;padding:10px 0; ">
    <div id="myChart" :style="{width: '99%', height: '350px'}"/></div>
</div></template>

<script>
import {
  api
} from '@/api/financ'
export default {
  data() {
    return {
      empty: [],
      headerArr: [],
      selectYear: '',
      ratio: '',
      textRatio: ''
    }
  },
  mounted() {
    this.getDate()
    this.getBudgetExpendRatio()
    this.getExpendBudget()
    this.getRatio()
  },
  methods: {
    // 获取管委会支出与预算占比
    getRatio() {
      api(`finance/index/ratioAndState?year=${this.selectYear}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          // this.headerArr = res.data.data
          // this.drawLine(res.data.data)
          this.ratio = res.data.data.ratio
          this.textRatio = res.data.data.state
        } else {
          this.$message.error(res.data.result)
          this.ratio = ''
          this.textRatio = ''
        }
      })
    },
    // 改变时间
    changeYear(value) {
      this.selectYear = value
      this.getExpendBudget()
      this.getBudgetExpendRatio()
      this.getRatio()
    },
    // 点击部门查看详情
    handleDetails(value) {
      this.$router.push({ name: 'financeDetails', query: { departmentId: value.departmentId, depName: value.departmentName }})
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
        // mouthArr.push(data[i].month.slice(4, 6))
          lastYearIncomeArr.push(
            Number(data.rows[i].budgetNumber)
          )
          incomeArr.push(
            Number(data.rows[i].cost)
          )
        }
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
                var text = data.dynamicHeadList[index] + ' ' + data.rows[index].ratio
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
              data: lastYearIncomeArr
            },
            {
              name: '已支出费用',
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

    // 已支出全年预算统计柱状图
    getExpendBudget() {
      api(`finance/index/expendBudget?year=${this.selectYear}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          if (res.data.data.rows.length > 0) {
            this.drawLine(res.data.data)
          }
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 各部门预算支出占比模块
    getBudgetExpendRatio() {
      api(`finance/index/budgetExpendRatio?year=${this.selectYear}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          if (res.data.data.length > 0) {
            this.headerArr = res.data.data
          } else {
            this.headerArr = []
          }
        } else {
          this.$message.error(res.data.result)
          this.headerArr = []
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
  cursor:pointer;
}
.ratio{
   height: 32px;
             width: 66px;
           margin-left: 5px;
          display: inline-block;
          // background: rgb(95, 202, 9);
               font-size: 14px;
            border-radius: 4px;
          text-align: center;
          color: rgb(255, 255, 255);
}
.ratioRed{
  background: red;
}
.ratioGreen{
  background: rgb(95, 202, 9);
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

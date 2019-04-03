<template>
  <div class="details">
    <div style="margin-bottom:20px;font-size:26px;">财务监控明细— <span>{{ depName }}</span></div>
    <header>
      <el-form
        :inline="true"
        :model="listQuery"
      >
        <el-form-item
          class="Year"
          label="数据年份:"
          style="margin-bottom:unset;"
        >
          <el-date-picker
            v-model="listQuery.selectYear"
            type="year"
            value-format="yyyy"
            placeholder="请选择年"
            size="small"
            @change="changeYear"
          />
        </el-form-item>
        <el-form-item label="分类:">
          <el-select v-model="listQuery.typeId" placeholder="请选择分类" clearable >
            <el-option v-for="item in typeIdOptions" :key="item.financeId" :label="item.financeName" :value="item.financeId" />
          </el-select>
        </el-form-item>
        <el-button
          type="primary"
          style="margin-right:10px;"
          icon="el-icon-search"
          @click="handleFilter"
        >查询</el-button>
        <el-button
          type="primary"
          style="margin-right:10px;"
        ><router-link :to="{name:'expenses'}">支出录入</router-link></el-button>
        <el-button
          type="primary"
          style="margin-right:10px;"
          @click="handleexcel"
        >导出</el-button>
        <el-button
          type="primary"
          style="margin-right:10px;"
          @click="handleFilter"
        ><router-link :to="{name:'monitoring'}">返回</router-link></el-button>
      </el-form>
    </header>
    <el-row :gutter="10">
      <el-col :span="12">
        <div class="echarsborder write">
        <div id="myChart" :style="{width: '100%', height: '250px'}"/></div>
      </el-col>
      <el-col :span="6" style="height:250px;">
        <div
          class="echarsborder write"
          style="padding:10px 10px;"
        >
          <div style="background:rgb(40, 175, 231);color:#fff;padding:10px;border-radius:5px;height:47%">
            <div style="margin-bottom:10px;"> <span style="font-size:50px;margin-right:10px;">{{ money }}</span>元 </div>
            <div style="position:relative">
              <span>预算合计</span>
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
            <div style="margin-bottom:10px;"> <span style="font-size:50px;margin-right:10px;">{{ percentage }}</span>元
            </div>

            <div style="position:relative">
              <span>支出合计</span>
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
      <el-col :span="6">
        <div class="echarsborder write">
          <div id="collect" :style="{width: '100%', height: '250px'}" />
      </div></el-col>
    </el-row>
    <!-- 表格数据 -->
    <div style="margin:20px 0px;">
      <el-table :data="incomeList" border fit highlight-current-row style="width: 100%;">
        <el-table-column label="序列" type="index" align="center" width="60"/>
        <el-table-column label="分类" prop="costTypeName" align="center" />
        <el-table-column :label="listQuery.selectYear+'年'" align="center" >
          <el-table-column v-for="(item, index) in tableHeader" :key="index" :label="item" prop="financeIndexSectionExpendFormsModels" align="center">
            <el-table-column label="预算" align="center" min-width="100">
              <template slot-scope="scope">
                <span>￥{{ scope.row.financeIndexSectionExpendFormsModels[index].budgetNumber }}元</span>
              </template>
            </el-table-column>
            <el-table-column label="支出" align="center" min-width="100">
              <template slot-scope="scope">
                <span>￥{{ scope.row.financeIndexSectionExpendFormsModels[index].cost }}元</span>
              </template>
            </el-table-column>
          </el-table-column>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import {
  api
} from '@/api/axios'
export default {
  data() {
    return {
      empty: [],
      tableHeader: [],
      incomeList: [],
      percentage: '',
      money: '',
      departmentId: '',
      typeIdOptions: [],
      depName: '',
      listQuery: {
        financeTypeId: '',
        selectYear: '',
        typeId: ''
      }
    }
  },
  mounted() {
    this.getDate()
    this.inislist()
  },
  methods: {
    // 改变时间
    changeYear(value) {
      this.listQuery.selectYear = value
      this.inislist()
    },
    // 获取时间
    getDate() {
      var time = new Date()
      this.listQuery.selectYear = time.getFullYear() + ''
    },
    // 导出
    handleexcel() {
      api(`${this.GLOBAL.financUrl}finance/index/expendFormsExport?year=${this.listQuery.selectYear}&departmentId=${this.departmentId}`, '', 'get').then(res => {
        window.location.href = res.request.responseURL
      })
    },
    // 查询数据
    handleFilter() {
      this.inislist()
    },
    // 设置柱状图
    drawLine(data) {
      // var mouthArr = []
      var lastYearIncomeArr = []
      var incomeArr = []

      // 基于准备好的dom，初始化echarts实例
      const myChart = this.$echarts.init(document.getElementById('myChart'))
      // 绘制图表
      var options = {
        title: {
          text: '部门预算及支出各月统计情况',
          textStyle: {
            color: 'rgb(44, 169, 248)',
            fontWeight: 'lighter'
          },
          top: 10,
          left: 'center'
          // subtext: '纯属虚构'
        },
        tooltip: {
          trigger: 'axis'
          // formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        color: ['rgb(44, 169, 248)', 'rgb(253, 180, 9)'],
        legend: {
          data: ['当月预算', '当月支出'],
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
            interval: 0,
            inside: false, // 是否朝内
            // formatter: '{value}\n' + data.lastYearPercent,
            formatter: function(value, index) {
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
          // data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
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
            name: '当月预算',
            type: 'bar',
            barWidth: '20%',
            data: lastYearIncomeArr
          },
          {
            name: '当月支出',
            type: 'bar',
            barGap: '0%',
            barWidth: '20%',
            data: incomeArr

          }
        ]
      }
      if (data.rows) {
        myChart.hideLoading()
        for (let i = 0; i < data.rows.length; i++) {
        // mouthArr.push(data[i].month.slice(4, 6))
          lastYearIncomeArr.push(
            Number(data.rows[i].budgetNumber)
          )
          incomeArr.push(
            Number(data.rows[i].cost)
          )
        }

        myChart.setOption(options)
        window.addEventListener('resize', () => { myChart.resize() })
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
          legendArr.push(val.costftertypename)
          seriesArr.push({
            value: val.cost,
            name: val.costftertypename
          })
        })
        var collectOption = {
          title: {
            text: '各项累计支出占比情况',
            textStyle: {
              color: 'rgb(44, 169, 248)',
              fontWeight: 'lighter'
            },
            top: 10,
            left: 'center'
            // subtext: '纯属虚构'
          },
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
          },
          legend: {
            type: 'scroll',
            orient: 'vertical',
            right: 10,
            top: 35,
            bottom: 20,
            // data: ['电费', '楼宇租金', '物业费', '其它']
            data: legendArr
          },
          series: [
            {
              name: '收入分类',
              type: 'pie',
              center: ['35%', '55%'],
              radius: ['50%', '70%'],
              color: ['rgb(255, 152, 115)', 'rgb(135, 206, 250)', 'rgb(218, 112, 214)', 'rgb(50, 205, 50)', 'rgb(100, 149, 237)', 'rgb(255, 105, 180)', 'rgb(186, 85, 211)', 'rgb(205, 92, 92)'],
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
        window.addEventListener('resize', () => { collect.resize() })
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
      this.departmentId = this.$route.query.departmentId
      this.depName = this.$route.query.depName
      this.getPeriodContrast()
      this.getCollect()
      this.getType()
      // this.textYear = this.listQuery.selectYear + '年'
      this.getTableDate()
    },
    // 获取表格数据
    getTableDate() {
      api(`${this.GLOBAL.financUrl}finance/index/sectionExpendForms?year=${this.listQuery.selectYear}&departmentId=${this.departmentId}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.incomeList = res.data.data.rows
          this.tableHeader = res.data.data.dynamicHeadList
        } else {
          this.$message.error(res.data.result)
          this.incomeList = []
          this.tableHeader = []
        }
      })
    },
    // 获取汇总信息
    getCollect() {
      api(`${this.GLOBAL.financUrl}finance/index/accumulativeExpendRatio?year=${this.listQuery.selectYear}&departmentId=${this.departmentId}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          if (res.data.data.length > 0) {
            this.collectPie(res.data.data)

            this.money = res.data.data[0].budgetnumber
            // this.money = (Math.round(this.money / 100) / 100).toFixed(2)
            this.percentage = res.data.data[0].sumExpeng
          } else {
            this.collectPie(this.empty)
            this.money = ''
            this.percentage = ''
          }
        } else {
          this.collectPie(this.empty)
          this.$message.error(res.data.result)
          this.money = ''
          this.percentage = ''
        }
      })
    },
    // 获取明细， 同期对比
    getPeriodContrast() {
      api(`${this.GLOBAL.financUrl}finance/index/sectionBudgetExpend?year=${this.listQuery.selectYear}&departmentId=${this.departmentId}&typeId=${this.listQuery.typeId}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          // myChart.setOption.xAxis.data = res.data
          this.drawLine(res.data.data)
        } else {
          this.$message.error(res.data.result)
          this.drawLine(this.empty)
        }
      })
    },
    // 获取分类
    getType() {
      api(`${this.GLOBAL.financUrl}finance/index/downType`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.typeIdOptions = res.data.data
          // this.collectPie(res.data.data)
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang='scss' scoped>
 .echarsborder{
    border:1px solid rgb(44, 169, 248);
    border-radius:8px;
  }
  .el-date-editor.el-input,
.el-date-editor.el-input__inner {
  width: 90px;
  background: #fff;
}
</style>
<style lang="scss">
.details {
  header {
    // .dis{
    //    display:inline-block;
    //   }
    .Year {
      .el-input--suffix .el-input__inner {
        padding-right: unset !important;
        border:none;
      }
    }
  }
}
</style>

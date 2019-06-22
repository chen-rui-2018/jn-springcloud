<template>
  <div class="projectDetails">
    <!-- <div class="gantt_ot" style="width:800px; margin:100px auto;">
      <div class="gantt"/>
    </div> -->
    <div class="projectDetails-title">
      <div>
        <span>{{ title }}</span>
        <span>{{ currentDay }}</span>
      </div>
      <div>
        <el-button type="primary" round><a :href="ibpsUrl+'560993009357815808.htm'">日报填写</a> </el-button>
        <el-button type="primary" round class="el-radio-group">
          <router-link :to="{path: '/planning/project'}">返回 </router-link>
        </el-button>
      </div>
    </div>
    <div class="details-top">
      <!-- <div class="gantt_ot" style="width:800px; margin:100px auto;">
      <div id="gant" class="gantt"/>
    </div> -->
      <!-- <div id ="GanttChartDIV" style ="position:relative;" class="gantt"/> -->
      <el-table :data="detailData" style="width: 100%;margin-bottom:40px;">
        <el-table-column :show-overflow-tooltip="true" prop="taskName" label="任务" align="center">
          <template slot-scope="scope">
            <span class="text-blue">{{ scope.row.taskName }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="nowadaysProgress" label="进度" align="center">
          <template slot-scope="scope">
            <span :class="scope.row.nowadaysProgress==='100%'?'text-green':''">{{ scope.row.nowadaysProgress }}</span>
          </template>
        </el-table-column>
        <el-table-column label="状态" align="center">
          <el-table-column prop="taskState" label="时间" align="center">
            <template slot-scope="scope">
              <span v-show="scope.row.taskState==='延期'" class="text-red">{{ scope.row.taskState }}</span>
              <span v-show="scope.row.taskState==='提前'||scope.row.taskState==='准时'" class="text-green">{{
              scope.row.taskState }}</span>
              <span v-show="scope.row.taskState==='未到期'">{{ scope.row.taskState }}</span>
            </template>
          </el-table-column>
          <el-table-column prop="appraise" label="评价" align="center" />
        </el-table-column>
        <el-table-column label="计划时间" align="center">
          <el-table-column prop="planStartTime" label="开始" align="center" />
          <el-table-column prop="planStopTime" label="结束" align="center" />
        </el-table-column>
        <!-- <el-table-column /> -->
      </el-table>
      <div class="container">
        <gantt :tasks="tasks" style="height:100%;" />
      </div>
    </div>
    <el-row :gutter="15">
      <el-col :span="8">
        <el-card class="box-card">
          <div slot="header">
            <span>任务进展情况</span>
          </div>
          <div class="card-body">
            <div id="pieChart" style="width: 100%;height:300px;" />
            <!-- <pie-chart id="pie-chart" :chartopts="pieData" style="width: 100%;height:300px;" /> -->
          </div>
        </el-card>
      </el-col>
      <div :span="16">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>进度及时率月统计</span>
          </div>
          <div class="card-body">
            <div id="barChart" style="width: 100%;height:300px;" />
            <!-- <bar-chart id="bar-chart" :chartopts="barData" style="width: 100%;height:300px;" /> -->
          </div>
        </el-card>
      </div>
    </el-row>
  </div>
  <!-- </div> -->
</template>

<script>
// import gantt from 'dhtmlx-gantt' // 引入模块
import Gantt from '@/components/gantt.vue'
import { api } from '@/api/axios'
import PieChart from '../charts/PieChart'
import BarChart from '../charts/BarChart'
export default {
  components: { PieChart, BarChart, Gantt },
  data() {
    return {
      ibpsUrl: this.GLOBAL.ibpsUrl,
      position: 'inner',
      detailData: [],
      currentDay: '',
      title: '',
      projectNo: '',
      pieData: [],
      barData: {},
      tasks: {
        data: [
          // {
          //   id: 1,
          //   text: '1',
          //   start_date: '15-05-2019',
          //   duration: 5,
          //   progress: 0
          // },
          // {
          //   id: 2,
          //   text: '2',
          //   start_date: '15-05-2019',
          //   duration: 5,
          //   progress: 1
          // },
          // {
          //   id: 3,
          //   text: '3',
          //   start_date: '15-05-2019',
          //   duration: 4,
          //   progress: 0.66
          // }
        ],
        links: [
          // { id: 1, source: 1, target: 2, type: '0' }
        ]
      }
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    // 反转字符串
    reverseString(str) {
      return str.split('/').reverse().join('-')
    },
    //  reverseString("hello"); // => olleh
    init() {
      // this.ganttInit()
      // console.log(this.$route.query.projectNo)
      this.projectNo = this.$route.query.projectNo
      this.title = this.$route.query.title
      this.currentDay = this.$route.query.day
      // 获取饼图数据
      api(
        `${this.GLOBAL.parkUrl}planning/project/findTaskPlan?projectNo=${
          this.projectNo
        }`,
        '',
        'get'
      ).then(res => {
        // console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          res.data.data.forEach(val => {
            this.pieData.push({
              name: val.key,
              value: val.value === '0%' ? '0' : parseInt(val.value)
            })
          })
          // this.dataList = res.data.data.rows
          // this.noticeList = res.data.data.rows
          // this.total = res.data.data.total
          this.$nextTick(() => {
            this.initChart(this.pieData)
          })
          // this.initChart(this.pieData)
        } else {
          this.$message.error(res.data.result)
        }
      })
      // 甘特图数据
      api(
        `${this.GLOBAL.parkUrl}planning/project/findProjectTask?projectNo=${
          this.projectNo
        }`,
        '',
        'get'
      ).then(res => {
        // console.log(res)
        // const date = new Date()
        if (res.data.code === this.GLOBAL.code) {
          this.detailData = res.data.data
          if (res.data.data) {
            res.data.data.forEach((v, i) => {
              this.tasks.data.push({
                // $index: 0,
                // $level: 0,
                // $no_end: false,
                // $no_start: false,
                // $rendered_type: 'task',
                // $source: [],
                // $target: [],
                text: v.taskName,
                id: i + 1,
                // start_date: this.reverseString(v.planStartTime),
                start_date: new Date(v.planStartTime),
                // end_date: this.reverseString(v.planStopTime),
                duration: ((new Date(v.planStopTime).getTime() - new Date(v.planStartTime).getTime()) / 3600 / 1000 / 24) + 1,
                // duration: 20,
                progress: Number(v.nowadaysProgress.split('%')[0]) / 100
              })
            })
          }
          // console.log(this.tasks.data)
        } else {
          this.$message.error(res.data.result)
        }
      })
      // 柱状图数据
      api(
        `${this.GLOBAL.parkUrl}planning/project/findCompleteRatio?projectNo=${
          this.projectNo
        }`,
        '',
        'get'
      ).then(res => {
        // console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          // this.detailData = res.data.data
          this.$nextTick(() => {
            this.initBarChart(res.data.data)
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    initChart(data) {
      // console.log(data)
      var collect = this.$echarts.init(document.getElementById('pieChart'))
      if (data.length > 0) {
        console.log(data)
        var bar = 'inner'
        var isFlag = false
        data.forEach(v => {
          if (v.value === 100) {
            isFlag = true
            // data = [v]
          }
        })
        if (isFlag) {
          bar = 'center'
        } else {
          bar = 'inner'
        }
        collect.hideLoading()
        const option = {
          color: ['#fdb409', '#81ca3f', '#2181da'],
          backgroundColor: ['#fff'],
          tooltip: {
            trigger: 'item',
            formatter: '{b} : {c}%'
          },
          legend: {
            orient: 'vertical',
            x: 'left',
            y: 'center',
            icon: 'circle',
            data: ['已完成', '已开始', '未开始']
          },
          grid: {
            left: 10
          },
          series: [
            {
              label: {
                normal: {
                  position: bar,
                  textStyle: {
                    fontSize: 16
                  },
                  color: '#fff',
                  verticalAlign: 'middle',
                  formatter: function(value) {
                    return value.data.value + '%'
                    // if (value.data.value === '0') {
                    //   return value.data.value
                    // } else {
                    //   return value.data.value + '%'
                    // }
                  }
                }
              },
              stillShowZeroSum: false,
              type: 'pie',
              radius: '60%',
              center: ['60%', 'center'],
              selectedMode: 'single',
              data: data,
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
        }
        collect.setOption(option)
        window.addEventListener('resize', () => {
          collect.resize()
        })
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
    deepCopy(obj) {
      var result = Array.isArray(obj) ? [] : {}
      for (var key in obj) {
        if (obj.hasOwnProperty(key)) {
          if (typeof obj[key] === 'object') {
            result[key] = this.deepCopy(obj[key]) // 递归复制
          } else {
            result[key] = obj[key]
          }
        }
      }
      return result
    },
    initBarChart(data) {
      // const newArr = data.completeRatioModels
      var newObj = this.deepCopy(data)
      newObj.completeRatioModels.plan.map(function(item, index) {
        if (
          newObj.completeRatioModels.plan[index] > 0 &&
          newObj.completeRatioModels.autual[index] > 0 &&
          newObj.completeRatioModels.plan[index] !== '' &&
          newObj.completeRatioModels.autual[index] !== ''
        ) {
          if (
            newObj.completeRatioModels.completeRatio[index] > 0 &&
            newObj.completeRatioModels.completeRatio[index] !== ''
          ) {
            newObj.completeRatioModels.completeRatio[index] =
              (newObj.completeRatioModels.completeRatio[index] /
                newObj.completeRatioModels.plan[index]) *
              100
          }
          if (
            newObj.completeRatioModels.autual[index] >
            newObj.completeRatioModels.plan[index]
          ) {
            newObj.completeRatioModels.autual[index] = 100
          } else {
            newObj.completeRatioModels.autual[index] =
              (newObj.completeRatioModels.autual[index] /
                newObj.completeRatioModels.plan[index]) *
              100
          }
          newObj.completeRatioModels.plan[index] =
            100 - newObj.completeRatioModels.autual[index]
        }
      })
      var barChart = this.$echarts.init(document.getElementById('barChart'))
      if (data.month.length > 0) {
        barChart.hideLoading()
        const option = {
          color: [
            'rgb(27, 142, 240)',
            'rgb(215, 215, 215)',
            'rgb(255, 192, 0)'
          ],
          tooltip: {
            trigger: 'axis',
            // trigger: 'item',
            axisPointer: {
              // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            },
            formatter: function(params) {
              var res = `${params[0].axisValue}进度及时率月统计<br />\<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color: rgb(215, 215, 215)"></span>\ 	任务量：${data.completeRatioModels.plan[params[0].dataIndex]}<br />\
                	<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:#11a0f8"></span>\
               	已完成任务：&nbsp;${data.completeRatioModels.autual[params[0].dataIndex]}<br />\
               	<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:rgb(255, 192, 0)"></span>\
                	超出完成：&nbsp; ${data.completeRatioModels.completeRatio[params[0].dataIndex] > 0 ? ((data.completeRatioModels.completeRatio[ params[0].dataIndex ] / data.completeRatioModels.plan[ params[0].dataIndex]) * 100).toFixed(2) + '%' : '0'}<br />`
              return res
              // var res = `<div style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:#11a0f8">任务量：${data.completeRatioModels.plan[params[0].dataIndex]}<div></br><div style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:rgb(215, 215, 215)">已完成任务：${data.completeRatioModels.autual[params[0].dataIndex]}<div></br><div style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:rgb(255, 192, 0)">超出完成:${(data.completeRatioModels.completeRatio[params[0].dataIndex] / data.completeRatioModels.plan[params[0].dataIndex] * 100) + '%'}<div>`
              // return res
              // return dataArr[params.dataIndex] + "<br />" +
              // params.seriesName + "：" + params.value;
            }
            // formatter: `{b}<br />\
            //     	<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:#11a0f8"></span>\
            //     	{a0}：{c0}<br />\
            //     	<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:rgb(215, 215, 215)"></span>\
            //     	{a1}：{c1}<br />\
            //     	<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:rgb(255, 192, 0)"></span>\
            //     	{a2}：{c2}%<br />`
          },
          legend: {
            icon: 'circle',
            data: ['任务量', '已完成', '超出预期']
          },
          grid: {
            left: 30,
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          yAxis: {
            type: 'value',
            axisLabel: {
              show: true,
              interval: 'auto',
              formatter: '{value} %'
            },
            show: true
          },
          series: [
            {
              name: '已完成',
              // data: data.completeRatioModels.autual,
              data: newObj.completeRatioModels.autual,
              type: 'bar',
              stack: '1',
              smooth: true
            },
            {
              name: '任务量',
              // data: data.completeRatioModels.plan,
              data: newObj.completeRatioModels.plan,
              // data: [50, 100],
              stack: '1',
              type: 'bar',
              label: {
                normal: {
                  show: true,
                  position: 'top',
                  formatter: function(value) {
                    if (value.value > 0 && value.value !== '') {
                      console.log(value.value)
                      return 100 - value.value + '%'
                    } else {
                      return ''
                    }
                  }
                }
              },
              smooth: true
            },
            {
              name: '超出预期',
              // data: data.completeRatioModels.completeRatio,
              data: newObj.completeRatioModels.completeRatio,
              stack: '1',
              type: 'bar',
              barWidth: 30, // 柱图宽度
              label: {
                normal: {
                  show: true,
                  position: 'top',
                  formatter: function(value) {
                    if (value.value > 0 && value.value !== '') {
                      return (value.value + 100).toFixed(2) + '%'
                    } else {
                      return ''
                    }
                  }
                }
              },
              smooth: true
            }
          ],
          xAxis: {
            type: 'category',
            data: data.month
          }
        }
        barChart.setOption(option)
        window.addEventListener('resize', () => {
          barChart.resize()
        })
      } else {
        var ttt = {
          text: '暂无数据',
          color: '#c23531',
          textColor: '#000',
          maskColor: 'rgba(255, 255, 255, 0.8)',
          zlevel: 0
        }

        barChart.setOption({}, true)
        // myChart.clear()
        barChart.showLoading('default', ttt)
      }
    }
  }
}
</script>

<style lang="scss">
 .gantt_message_area{
    display: none!important;
  }
.projectDetails {
  .el-table--medium td, .el-table--medium th{
    padding:6px 0;
  }
  .projectDetails-title {
    display: flex;
    padding: 10px 20px;
    justify-content: space-between;
    > div:nth-child(1) {
      > span:nth-child(1) {
        font-size: 28px;
      }
      > span:nth-child(2) {
        color: #333;
        margin-left: 25px;
      }
    }
  }
  // .el-card__header{
  //     padding:10px 20px;
  //     font-size: 14px;
  // }
  .details-top{
    display: flex;
    // >div:nth-child(1){
    //   // flex:6;
    // }
     >div:nth-child(2){
      // flex:4;
      width:54%;
      >div:nth-child(1){
        height: 100%;
        >div:nth-child(1){
          height: unset!important;
          >div:nth-child(1){
            height: unset!important;
            >div:nth-child(1){
               display: none;
            }
            >div:nth-child(2){
              height: unset!important;
              width: 100%!important;
              >div:nth-child(1){
                height: unset!important;
              }
              .gantt_task_scale{
                height: 74px!important;
                >div:nth-child(1){
                  div{
                     width: 100%!important;
                  }
                }
              }
              .gantt_scale_line {
                height: 37px!important;
                line-height: 37px !important;
                background: #e0f1fc;
                >div{
                  height: 37px!important;
                line-height: 37px !important;

                }
              }
            }
          }
        }
      }
    }
    // .gantt_task_row{
    //   height: 45px!important;
    // }
  .gantt_task_content{
    display: none;
  }
  .gantt_task_progress{
    margin-top: 7px;
    height: 15px;
    background: #67c23a;
  }
  }

  .gantt_task .gantt_task_scale .gantt_scale_cell{
        color: black;
    border-right: 1px solid #a3d9f4;
  }
  .gantt_grid_scale, .gantt_task_scale{
        border-bottom: 1px solid #a3d9f4;
  }
  .gantt_scale_line{
        border-top: 1px solid #a3d9f4
  }
  .gantt_layout_cell_border_bottom{
    border-bottom: 1px solid #a3d9f4;
  }
  .gantt_layout_cell_border_top{
    border-top: unset;
  }
  .gantt_layout_cell_border_right{
    border-right: 1px solid #a3d9f4;
  }
   .gantt_layout_cell_border_left{
    border-left: 1px solid #a3d9f4;
  }
.gantt_data_area{
  height: unset !important;
  width: 100%!important;
  >div{
    width: 100%!important;
  }
}
.gantt_task_line{
  background: rgb(255, 255, 105);
  border:none;
}
.gantt_task_scale{
  width: 100% !important;
}
// .gantt_bars_area{
//   // >div{
//   //   // height: 44px !important;
//   //   // line-height: 44px !important;
//   //   // top:0px !important;
//   // }
// }
}
</style>

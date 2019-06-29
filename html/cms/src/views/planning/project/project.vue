<template>
  <div v-loading="listLoading" class="project">
    <div style="margin-bottom:20px;">
      <el-radio-group v-model="listQuery.projectState" @change="handleFilter">
        <el-radio-button label="">全部</el-radio-button>
        <el-radio-button label="1">进行中</el-radio-button>
        <el-radio-button label="0">未开始</el-radio-button>
        <el-radio-button label="2">已完成</el-radio-button>
      </el-radio-group>
      <el-radio-group v-model="listQuery.progress" @change="handleFilter">
        <el-radio-button label="">全部</el-radio-button>
        <el-radio-button label="0">正常</el-radio-button>
        <el-radio-button label="2">延迟</el-radio-button>
        <el-radio-button label="1">提前</el-radio-button>
      </el-radio-group>
      <div style=" display: inline-block;position:relative">

        <el-button
          type="primary"
          round
          icon="el-icon-top"
          style="padding-left: 5px;
    padding-right: 20px;"
          @click="handleTimeSort"> 剩余时间排序</el-button><span
            v-show="listQuery.orderByClause==='surplus_time asc'"
            class="iconfont"
            style="font-size: 26px;
    position: absolute;
    top: 2px;
    color: #fff;
    right: -1px;"
          >&#xe63a;</span>
        <span
          v-show="listQuery.orderByClause==='surplus_time desc'"
          class="iconfont"
          style="font-size: 26px;
    position: absolute;
    top: 2px;
    color: #fff;
    right: -1px;"
        >&#xe72a;</span>
      </div>
      <div style=" display: inline-block;position:relative">
        <el-button type="primary" round @click="handleSort">进度排序</el-button><span
          v-show="listQuery.orderByClause==='progress asc'"
          class="iconfont"
          style="font-size: 26px;
    position: absolute;
    top: 2px;
    color: #fff;
    right: -1px;"
        >&#xe63a;</span>
        <span
          v-show="listQuery.orderByClause==='progress desc'"
          class="iconfont"
          style="font-size: 26px;
    position: absolute;
    top: 2px;
    color: #fff;
    right: -1px;"
      >&#xe72a;</span></div>
      <el-input v-model="listQuery.projectName" placeholder="请输入项目名称" class="input-with-select">
        <el-button slot="append" icon="el-icon-search" @click="handleFilter" />
      </el-input>
    </div>
    <el-row :gutter="25">
      <!-- <div v-for="(item,index) in dataList" :key="index">
        <el-col :span="12" :xs="24" :lg="8">
          <router-link
            :to="{path: '/planning/details', query: {projectNo: item.projectNo,title:item.projectName,day:item.nowTime }}"
            class="c-item-grid">
            <div class="flex-column-wrap">
              <h3 class="r1 f-18 "><span class="text-blue"> {{ item.projectName }} </span></h3>
              <div class="r2 f-25">
                <div class="chart-tips">
                  <p>截止 {{ item.planStopTime }} 剩余任务</p>
                  <p><span class="value"><strong> {{ item.projectSurplusTask }} </strong></span></p>
                </div>
                <table>
                  <tbody>
                    <tr class="text-nowrap">
                      <td class="text-left">剩余任务量</td>
                      <td class="text-right" colspan="2">进度：<b class="text-green"> {{ item.progress }} </b>
                      </td>
                    </tr>
                    <tr>
                      <td colspan="2">
                        <div id="proChart" :style="{width: '100%', height: '200px'}" />
                      </td>
                      <td width="18" valign="bottom">工期</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="r3">
                <p class="text-muted f-14">距离计划工期余剩</p>
                <p class="f-18"> {{ item.surplusTime }} </p>
              </div>
            </div>
            <footer class="bg-blue f-18"> -->
      <!-- {{ item.projectStatus }} -->
      <!-- <span v-show="item.projectState==='1'">进行中</span>
              <span v-show="item.projectState==='0'">未开始</span>
              <span v-show="item.projectState==='2'">已完成</span>
              <i class="iconfont icon-clock" />
            </footer>
          </router-link>
        </el-col>
      </div> -->
      <project-grid v-for="(item,index) in dataList" v-show="dataList.length>0" :i-data="item" :g-index="index" :key="index" />
      <div v-show="dataList.length===0||dataList===null">暂无数据</div>
    </el-row>
  </div>
</template>
<script>
import { api } from '@/api/axios'
import projectGrid from '../components/projectGrid'
export default {
  name: 'ProjectPage',
  components: { projectGrid },
  data() {
    return {
      listLoading: false,
      dataList: [
        // {
        //   data: {
        //     content: {
        //       title: '19号楼建设任务',
        //       scheduleStatus: '正常',
        //       deadline: '8月6日',
        //       remainingPercentage: '20%',
        //       daysRemaining: '31天5小时',
        //       projectStatus: '进行中'
        //     },
        //     chart: {
        //       uncompletedArr: ['100%', '90%', '70%', '20%'],
        //       cycle: ['6月', '7月', '8月', '9月', '10月', '11月', '12月'],
        //       currentMonth: '9月'
        //     }
        //   }
        // },
        // {
        //   data: {
        //     content: {
        //       title: '园区路灯安装任务',
        //       scheduleStatus: '正常',
        //       deadline: '8月6日',
        //       remainingPercentage: '100%',
        //       daysRemaining: '31天5小时',
        //       projectStatus: '未完成'
        //     },
        //     chart: {
        //       uncompletedArr: ['100%', '100%', '100%', '100%'],
        //       cycle: ['5月', '7月', '8月', '9月'],
        //       currentMonth: '9月'
        //     }
        //   }
        // },
        // {
        //   data: {
        //     content: {
        //       title: '园区路灯安装任务22',
        //       scheduleStatus: '正常',
        //       deadline: '8月6日',
        //       remainingPercentage: '100%',
        //       daysRemaining: '31天5小时',
        //       projectStatus: '已完成'
        //     },
        //     chart: {
        //       uncompletedArr: ['100%', '100%', '100%', '100%'],
        //       cycle: ['5月', '7月', '8月', '9月'],
        //       currentMonth: '9月'
        //     }
        //   }
        // },
        // {
        //   data: {
        //     content: {
        //       title: '19号楼建设任务',
        //       scheduleStatus: '延迟',
        //       deadline: '8月6日',
        //       remainingPercentage: '20%',
        //       daysRemaining: '31天5小时',
        //       projectStatus: '进行中'
        //     },
        //     chart: {
        //       uncompletedArr: ['100%', '90%', '70%', '30%'],
        //       cycle: ['6月', '7月', '8月', '9月', '10月', '11月', '12月'],
        //       currentMonth: '9月'
        //     }
        //   }
        // },
        // {
        //   data: {
        //     content: {
        //       title: '园区路灯安装任务123',
        //       scheduleStatus: '提前',
        //       deadline: '8月6日',
        //       remainingPercentage: '20%',
        //       daysRemaining: '31天5小时',
        //       projectStatus: '未完成'
        //     },
        //     chart: {
        //       uncompletedArr: ['100%', '100%', '100%', '20%'],
        //       cycle: ['5月', '7月', '8月', '9月'],
        //       currentMonth: '9月'
        //     }
        //   }
        // },
        // {
        //   data: {
        //     content: {
        //       title: '园区路灯安装任务22',
        //       scheduleStatus: '正常',
        //       deadline: '8月6日',
        //       remainingPercentage: '100%',
        //       daysRemaining: '31天5小时',
        //       projectStatus: '已完成'
        //     },
        //     chart: {
        //       uncompletedArr: ['100%', '70%', '50%', '0%'],
        //       cycle: ['5月', '7月', '8月', '9月'],
        //       currentMonth: '9月',
        //       options: {}
        //     }
        //   }
        // }
      ],
      listQuery: {
        orderByClause: 'project_no desc',
        progress: '', // 项目进度
        projectState: '', // 任务状态
        projectName: '' // 项目名称
      }
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    // 剩余时间排序
    handleTimeSort() {
      if (this.listQuery.orderByClause === 'surplus_time desc') {
        this.listQuery.orderByClause = 'surplus_time asc'
      } else {
        this.listQuery.orderByClause = 'surplus_time desc'
      }
      this.init()
    },
    // 进度排序
    handleSort() {
      if (this.listQuery.orderByClause === 'project_surplus_task desc') {
        this.listQuery.orderByClause = 'project_surplus_task asc'
      } else {
        this.listQuery.orderByClause = 'project_surplus_task desc'
      }
      this.init()
    },
    handleFilter() {
      this.init()
    },
    init() {
      // console.log(this.GLOBAL.parkUrl)
      this.listLoading = true
      api(
        `${this.GLOBAL.parkUrl}planning/project/findAll?orderByClause=${
          this.listQuery.orderByClause
        }&progress=${this.listQuery.progress}&projectName=${
          this.listQuery.projectName
        }&page=1&rows=10&projectState=${this.listQuery.projectState}`,
        '',
        'get'
      ).then(res => {
        console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          this.dataList = res.data.data.rows
          // this.noticeList = res.data.data.rows
          // this.total = res.data.data.total
          // for (let i = 0; i < this.dataList.length; i++) {
          //   this.$nextTick(() => { this.drawLine(this.dataList[i].arrayModel, this.dataList[i].planStopTime) })
          // }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    }
    // inArray(value, arr) {
    //   for (var k in arr) {
    //     if (arr[k] === value) {
    //       return k
    //     }
    //     if (k === arr.length - 1) {
    //       return -1
    //     }
    //   }
    // },
    // drawLine(data, stop) {
    //   // 基于准备好的dom，初始化echarts实例
    //   const myChart = this.$echarts.init(document.getElementById('proChart'))
    //   if (data) {
    //     // console.log(data)
    //     // const opts = {
    //     //   uncompletedArr: ['100%', '100%', '100%', '20%'],
    //     //   cycle: ['5月', '7月', '8月', '9月'],
    //     //   currentMonth: '9月'
    //     // } // 图表参数
    //     // const mLength = opts.currentMonth // 当前月份
    //     const mLength = data.currentData // 当前日期
    //     const dateData = data.createdTime // 项目日期周期数组
    //     dateData.push(stop)
    //     // const dateData = opts.cycle // 项目月份周期数组  ;
    //     const pData = []
    //     data.progress.forEach(val => {
    //       pData.push(100 - val)
    //     })
    //     // let pData = opts.uncompletedArr // 项目月份未完成比例数组,开始默认100%
    //     // let pData = data.progress // 项目月份未完成比例数组,开始默认100%
    //     // pData = pData.map(function(n) {
    //     //   return parseInt(n)
    //     // })
    //     const mIndex = parseInt(this.inArray(mLength, dateData))
    //     console.log(mIndex)
    //     const dateDateLength = dateData.length
    //     const unfinishedData = []
    //     const doneData = []
    //     const c = 100 / (dateDateLength - 1)
    //     for (let i = 0; i < dateDateLength; i++) {
    //       const j = dateDateLength - i - 1
    //       if (i < mIndex) {
    //         doneData.push(c * j)
    //         unfinishedData.push('')
    //       } else if (i === mIndex) {
    //         doneData.push(c * j)
    //         unfinishedData.push(c * j)
    //       } else {
    //         doneData.push('')
    //         unfinishedData.push(c * j)
    //       }
    //     }
    //     // console.log(dateData, unfinishedData, doneData, pData)
    //     // const mLength = data.currentData.substring(8, 10) + '日'
    //     // const dateData = data.createdTime
    //     myChart.hideLoading()
    //     var options = {
    //     // markLine: {
    //     //   show: false
    //     // },
    //       tooltip: {
    //         trigger: 'axis',
    //         axisPointer: {
    //         // type: 'cross',
    //           lineStyle: {
    //             color: 'transparent'
    //           },
    //           label: {
    //             backgroundColor: '#000'
    //           }
    //         },
    //         formatter: function(a) {
    //           var c = a[0]
    //           var cm = c.axisValue // 选择的月份
    //           var cv = c.value // 数值
    //           var cn = c.seriesName // 名称
    //           return cm + '<br/>' + cn + ':还剩' + cv + '%'
    //         }
    //       },
    //       toolbox: {
    //         show: false,
    //         feature: {
    //           saveAsImage: {}
    //         }
    //       },
    //       grid: {
    //         left: '-20px',
    //         right: '3%',
    //         bottom: '0%',
    //         top: '10px',
    //         containLabel: true
    //       },
    //       xAxis: [
    //         {
    //           type: 'category',
    //           boundaryGap: false,
    //           axisTick: {
    //             show: false
    //           },
    //           splitLine: {
    //             show: false
    //           },
    //           name: '工期234',
    //           nameLocation: 'end', // 坐标轴名称显示位置。
    //           axisLabel: {
    //             rotate: '45',
    //             textStyle: {
    //               color: '#999'
    //             }
    //           },
    //           axisLine: {
    //             lineStyle: {
    //               color: '#dfe0e0'
    //             }
    //           },
    //           data: dateData
    //         }
    //       ],
    //       yAxis: [
    //         {
    //           type: 'value',
    //           boundaryGap: false,
    //           splitLine: {
    //             show: false
    //           },
    //           axisTick: {
    //             show: false
    //           },
    //           axisLine: {
    //           // show:false,
    //             lineStyle: {
    //               color: '#dfe0e0'
    //             }
    //           },
    //           axisLabel: {
    //             textStyle: {
    //               color: '#999'
    //             },
    //             formatter: function(a) {
    //               if (a === 100 || a === 0) {
    //                 return a + '%'
    //               }
    //             }
    //           }
    //         }
    //       ],
    //       series: [
    //         {
    //           name: '项目进度',
    //           type: 'line',
    //           symbol: 'emptyCircle',
    //           symbolSize: 13,
    //           color: '#2ca9e7',
    //           itemStyle: {
    //             normal: {
    //               lineStyle: {
    //                 color: '#2ca9e7',
    //                 width: 2
    //               }
    //             }
    //           },
    //           data: pData
    //         },
    //         {
    //           name: '未完成进度',
    //           type: 'line',
    //           symbol: 'none',
    //           itemStyle: {
    //             normal: {
    //               areaStyle: {
    //                 type: 'default',
    //                 color: '#ffd5d3'
    //               },
    //               lineStyle: {
    //                 color: '#f35a4c',
    //                 width: 2,
    //                 type: 'dotted'
    //               }
    //             }
    //           },
    //           data: unfinishedData
    //           // data: ''
    //         },
    //         {
    //           name: '已完成进度',
    //           type: 'line',
    //           symbol: 'none',
    //           itemStyle: {
    //             normal: {
    //               areaStyle: {
    //                 type: 'default',
    //                 color: '#c3ffe1'
    //               },
    //               lineStyle: {
    //                 color: '#58cc77',
    //                 width: 2,
    //                 type: 'dotted'
    //               }
    //             }
    //           },
    //           data: doneData
    //           // data: ''
    //         }
    //       ]
    //     }
    //     myChart.setOption(options)
    //     window.addEventListener('resize', () => {
    //       myChart.resize()
    //     })
    //   } else {
    //     var ttt = {
    //       text: '暂无数据',
    //       color: '#c23531',
    //       textColor: '#000',
    //       maskColor: 'rgba(255, 255, 255, 0.8)',
    //       zlevel: 0
    //     }

    //     myChart.setOption({}, true)
    //     // myChart.clear()
    //     myChart.showLoading('default', ttt)
    //   }
    // }
  }
}
</script>
<style lang='scss'   >
@import "project.scss";
.project {
  .el-radio-button--medium .el-radio-button__inner {
    padding: 10px;
  }
  .el-input-group {
    width: 266px;
  }
  .el-radio-group {
    margin-right: 10px;
  }
  // .c-item-grid {
  //   display: block;
  //   margin-bottom: 15px;
  //   text-align: center;
  //   background: #fff;
  //   border-radius: 8px;
  //   transition: all 0.5s ease;
  //   .flex-column-wrap {
  //     height: 260px;
  //   }
  //   table {
  //     width: 100%;
  //   }
  //   h3 {
  //     margin: 0;
  //     color: #595959;
  //   }
  //   .r1 {
  //     padding: 15px;
  //     font-size: 22px;
  //     color: #000;
  //   }
  //   .r2 {
  //     position: relative;
  //     padding: 0 15px;
  //     font-size: 14px;
  //     line-height: 125%;
  //     color: #999;
  //     span {
  //       display: inline-block;
  //       line-height: 100%;
  //       font-family: "lsLigth";
  //     }
  //   }
  //   .r3 {
  //     padding: 15px;
  //     font-size: 18px;
  //     color: #000;
  //     p {
  //       margin-bottom: 5px;
  //     }
  //     span {
  //       margin: 0 3px;
  //     }
  //   }
  //   b {
  //     font-weight: normal;
  //   }
  //   .c-logo {
  //     img {
  //       margin-bottom: 10px;
  //     }
  //   }
  //   footer {
  //     position: relative;
  //     padding: 20px 0;
  //     line-height: 100%;
  //     border-radius: 0 0 8px 8px;
  //     .iconfont {
  //       display: inline-block;
  //       font-size: 22px;
  //       position: absolute;
  //       top: 50%;
  //       right: 15px;
  //       line-height: 100%;
  //       margin-top: -11px;
  //     }
  //   }
  //   &:hover {
  //     text-decoration: none;
  //     box-shadow: 0 0 10px #2ca8e7;
  //     transform: translateY(-3px);
  //   }
  // }

  // .chart-tips {
  //   text-align: right;
  //   position: absolute;
  //   right: 15px;
  //   top: 40px;
  //   color: #666;
  // }

  // .chart-tips .value {
  //   font-size: 30px;
  //   color: #333;
  // }

  // .c-item-grid .flex-column-wrap {
  //   height: auto;
  // }
}
</style>

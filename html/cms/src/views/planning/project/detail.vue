<template>
  <div style="width:100%;">
    <div class="c--bar">
      <span class="title" style="font-size:32px">19号楼建设任务</span>
      <span style="font-size:18px;margin-right:58px;color:#797c82">2018年7月17日</span>
      <div class="flex-item" />
      <router-link to="/planning/project/index" >返回
      </router-link>
    </div>
    <el-table
      :data="detailData"
      :span-method="arraySpanMethod"
      :header-cell-class-name="handlerHeaderRowClass"
      :cell-class-name="handlerRowClass"
      class="mb--gap"
      style="width: 100%;">
      <el-table-column
        fixed
        prop="task"
        label="任务"
        width="150"
        align="center" />
      <el-table-column
        prop="progress"
        label="进度"
        width="80"
        align="center" />
      <el-table-column
        label="状态"
        align="center">
        <el-table-column
          prop="statusTime"
          label="时间"
          width="50"
          align="center" />
        <el-table-column
          prop="statusComment"
          label="评价"
          width="50"
          align="center" />
      </el-table-column>
      <el-table-column
        label="计划时间"
        align="center">
        <el-table-column
          prop="dateStart"
          label="开始"
          width="90"
          align="center" />
        <el-table-column
          prop="dateEnd"
          label="结束"
          width="90"
          align="center" />
      </el-table-column>
      <el-table-column
        label="2018年7月"
        align="center" >
        <el-table-column
          v-for="(item,index) in 31"
          :key="index"
          :label="item"
          :class="[ item==currentDate && 'current']"
          prop=""
          min-width="30"
          align="center" />
        <span>234</span>
      </el-table-column>
    </el-table>
    <el-row :gutter="15" >
      <el-col :span="8">
        <el-card class="box-card">
          <div slot="header">
            <span>任务进展情况</span>
          </div>
          <div class="card-body">
            <pie-chart id="pie-chart" :chartopts="pieData" style="width: 100%;height:300px;" />
          </div>
        </el-card>
      </el-col>
      <el-col :span="16" >
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>进度及时率月统计</span>
          </div>
          <div class="card-body">
            <bar-chart id="bar-chart" :chartopts="barData" style="width: 100%;height:300px;" />
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import PieChart from '../charts/PieChart'
import BarChart from '../charts/BarChart'
export default {
  components: { PieChart, BarChart },
  data() {
    return {
      currentDate: 30,
      currentMonthDays: 31,
      detailData: [
        {
          task: '工作事项01',
          progress: '100%',
          statusTime: '+2',
          statusComment: '差',
          dateStart: '2018/7/1',
          dateEnd: '2018/7/5'
        },
        {
          task: '工作事项02',
          progress: '100%',
          statusTime: '-2',
          statusComment: '好',
          dateStart: '2018/7/3',
          dateEnd: '2018/7/20'
        },
        {
          task: '工作事项03',
          progress: '100%',
          statusTime: '0',
          statusComment: '差',
          dateStart: '2018/7/10',
          dateEnd: '2018/8/5'
        },
        {
          task: '工作事项04',
          progress: '40%',
          statusTime: '+2',
          statusComment: '差',
          dateStart: '2018/7/10',
          dateEnd: '2018/7/28'
        },
        {
          task: '工作事项05',
          progress: '0%',
          statusTime: '',
          statusComment: '差',
          dateStart: '2018/7/10',
          dateEnd: '2018/8/5'
        }
      ],
      pieData: {
        series: [{
          data: [{
            value: 400,
            name: '项目一'
          }, {
            value: 400,
            name: '项目二'
          }, {
            value: 410,
            name: '项目三'
          }]
        }]
      },
      barData: {
        label: ['2017年\n5月', '6\n月', '7\n月', '8\n月', '9\n月', '10\n月', '11\n月', '12\n月', '2018年\n1月', '2\n月', '3\n月', '4\n月']
      }
    }
  },
  computed: {},
  methods: {
    handlerHeaderRowClass({ row, column, rowIndex, columnIndex }) {
      const currentDate = this.currentDate
      if (columnIndex === currentDate + 3) {
        return 'current'
      }
    },
    handlerRowClass({ row, column, rowIndex, columnIndex }) {
      const currentRowData = this.detailData[rowIndex]
      const currentDate = this.currentDate
      const currentMonthDays = this.currentMonthDays
      const progressVal = currentRowData.progress
      const statusTime = parseInt(currentRowData.statusTime)
      const startDateIndex = parseInt(currentRowData.dateStart.split('/')[2]) + 5
      let endDateIndex = +currentRowData.dateEnd.split('/')[2] + 5
      let customClass = ''
      if (endDateIndex < startDateIndex) {
        endDateIndex = currentMonthDays
      }
      if (columnIndex >= startDateIndex && columnIndex <= endDateIndex) {
        customClass += 'planned-time'
      }
      if (
        progressVal === '100%' &&
        columnIndex >= startDateIndex &&
        columnIndex <= endDateIndex + statusTime
      ) {
        customClass += ' green'
      }

      if (
        progressVal !== '100%' &&
        progressVal !== '0%' &&
        columnIndex >= startDateIndex &&
        columnIndex <= endDateIndex + statusTime
      ) {
        customClass += ' blue'
      }
      if (columnIndex === currentDate + 5) {
        customClass += ' current'
      }
      if (columnIndex === 1) {
        if (progressVal === '100%') {
          customClass += 'text-green'
        }
      }
      return customClass
    },
    arraySpanMethod({ row, column, rowIndex, columnIndex }) {
    }
  }
}
</script>
<style lang='scss' scoped >
@import 'detail.scss';
</style>
<style lang='scss'>
.text-green {
  color: #00b050;
}

.planned-time,
.planned-time .cell {
  background: #ffff69 !important;
}
.green:before {
  content: '';
  position: absolute;
  top: 50%;
  left: 0;
  right: -1px;
  margin-top: -5px;

  height: 10px;
  background: #00b050;
}
.blue:before {
  content: '';
  position: absolute;
  top: 50%;
  left: 0;
  right: -1px;
  margin-top: -5px;

  height: 10px;
  background: #3ca0e4;
}
.current {
  position: relative;
  &:after {
    content: '';
    position: absolute;
    top: -1px;
    bottom: 0;
    right: -1px;
    z-index: 2;
    display: block;
    width: 0;
    border-right: 1px #3ca0e4 solid;
  }
}
.el-table thead .current {
  background: #3ca9e4 !important;
  border-right: 1px #3ca0e4 solid !important;
  .cell {
    color: #fff;
  }
}
</style>

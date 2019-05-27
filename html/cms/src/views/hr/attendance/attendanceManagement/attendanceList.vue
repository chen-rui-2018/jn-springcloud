<template>
  <div class="attendanceList">
    <el-form :model="listQuery" :inline="true" class="info-form">
      <el-form-item label="日期:" lable-position="right" label-width="80px">
        <el-date-picker
          v-model="listQuery.startTime"
          :picker-options="pickerOptions"
          type="date"
          placeholder="选择开始时间："
          format="yyyy-MM-dd"
          value-format="yyyy-MM-dd"
          style="width: 200px"
          clearable/>
        至
        <el-date-picker
          v-model="listQuery.endTime"
          :picker-options="pickerOptions"
          type="date"
          placeholder="选择结束时间："
          format="yyyy-MM-dd"
          value-format="yyyy-MM-dd"
          style="width: 200px"
          clearable/>
      </el-form-item>

      <el-form-item label="姓名:" lable-position="right" label-width="80px">
        <el-input
          v-model.trim="listQuery.name"
          maxlength="200"
          style="width: 200px"
          placeholder=""
          clearable/>
      </el-form-item>

      <el-form-item label="部门：" prop="departmentId">
        <el-cascader
          ref="departRef"
          :options="departmentList"
          v-model="currentDepartmentIds"
          change-on-select
          placeholder="请选择"
          clearable
          @change="handleChangeDepartment"
        />
      </el-form-item>
      <el-row>
        <el-form-item class="form-btn">
          <el-button class="filter-item" type="primary" @click="exportExcel">导出</el-button>
          <el-button class="filter-item" type="primary" @click="handleFilter">查询</el-button>
        </el-form-item>
      </el-row>
    </el-form>
    <div class="table-head">{{ listQuery.startTime }} 至 {{ listQuery.endTime }} 考勤情况统计</div>
    <!-- 表格 -->
    <el-table
      v-loading="listLoading"
      ref="multipleTable"
      :data="attendanceList"
      border
      fit
      highlight-current-row
      style="width: 100%;height:100%;"
      @row-click="showRow">
      <el-table-column label="选择" width="50" align="center">
        <template slot-scope="scope">
          <el-radio v-model="currJobNumber" :label="scope.row.jobNumber" class="radio" checked="checked">&nbsp;
          </el-radio>
        </template>
      </el-table-column>
      <el-table-column label="部门名称" align="center" prop="department"/>
      <el-table-column label="姓名" align="center" prop="name"/>
      <el-table-column label="考勤情况" align="center">
        <el-table-column label="出勤(天)" align="center" prop="attendance"/>
        <el-table-column label="迟到(次)" align="center" prop="late"/>
        <el-table-column label="早退(次)" align="center" prop="leaveEarly"/>
        <el-table-column label="上班缺卡数(次)" align="center" prop="startMissCard"/>
        <el-table-column label="下班缺卡数(天)" align="center" prop="endMissCard"/>
        <el-table-column label="旷工(天)" align="center" prop="absenteeism"/>
        <el-table-column label="请假" align="center">
          <el-table-column label="事假(时)" align="center" prop="compassionateLeave"/>
          <el-table-column label="病假(时)" align="center" prop="sickLeave"/>
          <el-table-column label="婚假(时)" align="center" prop="marriageHoliday"/>
          <el-table-column label="丧假(时)" align="center" prop="funeralLeave"/>
          <el-table-column label="产假(时)" align="center" prop="maternityLeave"/>
          <el-table-column label="年休假(时)" align="center" prop="annualLeave"/>
        </el-table-column>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      v-show="total>0"
      :current-page="listQuery.page"
      :page-sizes="[5,10,20,30, 50]"
      :page-size="listQuery.rows"
      :total="total"
      class="tablePagination"
      background
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"/>

    <div style="margin-top: 20px">
      <el-button @click="gotoDetail('absenceDetailList')">旷工明细</el-button>
      <el-button @click="gotoDetail('comeLateDetailList')">迟到明细</el-button>
      <el-button @click="gotoDetail('leaveEarlyDetailList')">早退明细</el-button>
      <el-button @click="gotoDetail('notCardDetailList')">缺卡明细</el-button>
      <el-button @click="gotoDetail('leaveDetailist')">请假明细</el-button>
    </div>

  </div>
</template>

<script>

import {
  list, exportAttendanceList
} from '@/api/hr/attendance'

import moment from 'moment'

import {
  api
} from '@/api/axios'

export default {
  data() {
    return {
      currentDepartmentIds: [],
      currJobNumber: '',
      currUserId: '',
      currDepartment: '',
      currName: '',
      departmentList: [],
      listLoading: false,
      listQuery: {
        page: 1,
        rows: 10,
        name: '',
        startTime: '',
        endTime: '',
        department: '',
        departmentId: ''
      },
      total: 0,
      attendanceList: [],
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', start)
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', start)
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', start)
          }
        }]
      }
    }
  },
  mounted() {
    this.getAllDepartment()
    this.currJobNumber = this.$route.query.jobNumber
    this.currUserId = this.$route.query.userId
    this.currDepartment = this.$route.query.department
    this.currName = this.$route.query.name
    this.listQuery.startTime = this.$route.query.startTime
    this.listQuery.endTime = this.$route.query.endTime
    // this.listQuery.departmentId = this.$route.query.departmentId
    // this.listQuery.department = this.$route.query.department
    // 初始化开始时间为上月1号,结束时间为昨天
    // let currDate=new Date()
    if (!this.listQuery.startTime || this.listQuery.startTime === '') {
      this.listQuery.startTime = moment().subtract(1, 'months').startOf('month').format('YYYY-MM-DD')
    }
    if (!this.listQuery.endTime || this.listQuery.endTime === '') {
      this.listQuery.endTime = moment().subtract(1, 'days').format('YYYY-MM-DD')
    }

    this.initList()
  },
  methods: {
    getAllDepartment() {
      this.departmentListLoading = true
      api(`${this.GLOBAL.systemUrl}system/sysDepartment/findDepartmentAllByLevel`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.departmentList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.departmentListLoading = false
      })
    },
    handleChangeDepartment(value) {
      this.listQuery.departmentId = this.currentDepartmentIds[this.currentDepartmentIds.length - 1]
      const arr = this.$refs['departRef'].currentLabels
      this.listQuery.department = arr[arr.length - 1]
    },
    initList() {
      console.log('查询考勤。。。')

      if (!this.listQuery.startTime || this.listQuery.startTime === '') {
        this.$message.error('开始时间不能为空')
        return
      }
      if (!this.listQuery.endTime || this.listQuery.endTime === '') {
        this.$message.error('结束时间不能为空')
        return
      }

      this.listLoading = true

      list(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.attendanceList = res.data.data.rows
          this.total = res.data.data.total
          if (this.attendanceList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    exportExcel() {
      exportAttendanceList(this.listQuery).then(res => {
        console.log('导出。。。')
        window.location.href = res.request.responseURL
      })
    },
    // 表格分页功能
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    // 表格分页功能
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    },
    showRow(row) {
      this.currJobNumber = row.jobNumber
      this.currUserId = row.userId
      this.currDepartment = row.department
      this.currName = row.name
    },
    gotoDetail(name) {
      if (!this.currJobNumber || this.currJobNumber === '') {
        this.$message.error('请至少勾选一条记录')
        return
      }

      if (!this.listQuery.startTime || this.listQuery.startTime === '') {
        this.$message.error('开始时间不能为空')
        return
      }
      if (!this.listQuery.endTime || this.listQuery.endTime === '') {
        this.$message.error('结束时间不能为空')
        return
      }

      this.$router.push({
        name: name, query: {
          jobNumber: this.currJobNumber, userId: this.currUserId,
          startTime: this.listQuery.startTime, endTime: this.listQuery.endTime,
          name: this.currName,
          departmentId: this.listQuery.departmentId,
          department: this.currDepartment
        }
      })
    }
  }
}
</script>

<style scoped>
  .form-btn {
    float: right;
    padding-right: 200px;
  }

  .table-head {
    text-align: center;
    line-height: 30px;
    font-weight: bold;
    font-size: 16px;
    margin-bottom: 10px;
  }
</style>

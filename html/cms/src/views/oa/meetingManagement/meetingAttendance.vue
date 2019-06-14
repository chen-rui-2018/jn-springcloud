<template>
  <div v-loading="listLoading" class="meetingAttendance">

    <el-form :inline="true" :model="listQuery" class="filter-bar">

      <el-form-item label="姓名:">
        <el-input v-model="listQuery.userName" placeholder="请输入姓名" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <!-- <el-form-item label="状态:">
        <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable style="width: 150px" class="filter-item" @change="selecteUserStatus">
          <el-option v-for="(item,index) in userStatusOptions" :key="item" :label="item" :value="index" />
        </el-select>
      </el-form-item> -->
      <el-form-item label="会议时间:">
        <el-date-picker v-model="listQuery.startTime" value-format="yyyy/MM/dd HH:mm:ss" type="datetime" placeholder="选择开始时间" />
        至
        <el-date-picker v-model="listQuery.endTime" type="datetime" value-format="yyyy/MM/dd HH:mm:ss" placeholder="选择结束时间" />
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleExcel">导出</el-button>

    </el-form>
    <!-- 表格 -->
    <el-table :data="attendanceList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="会议室" align="center" prop="meetingRoomName"/>
      <el-table-column label="会议时间" align="center" min-width="150" >
        <template slot-scope="scope">
          <span>{{ scope.row.meetingStartDate+" "+ scope.row.meetingStartTime+'-'+ scope.row.meetingEndTime }}</span>
        </template>
      </el-table-column>
      <el-table-column label="会议主题" align="center" prop="meetingTitle" />
      <el-table-column label="姓名" align="center" prop="userName" />
      <el-table-column label="部门" align="center" prop="departmentName" />
      <el-table-column label="签到打卡" align="center" prop="signInTime" min-width="120"/>
      <el-table-column label="签退打卡" align="center" prop="signBackTime" min-width="120" />
      <el-table-column label="签到状态" align="center" prop="signInStatus">
        <template slot-scope="scope">
          <span :class="scope.row.signInStatus==='正常' ? 'text-green' : 'text-red'">{{ scope.row.signInStatus }}</span>
        </template>
      </el-table-column>
      <el-table-column label="签退状态" align="center" prop="signOutStatus">
        <template slot-scope="scope">
          <span :class="scope.row.signOutStatus==='正常' ? 'text-green' : 'text-red'">{{ scope.row.signOutStatus }}</span>
        </template>
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
      @current-change="handleCurrentChange" />
  </div>
</template>

<script>
import {
  api
} from '@/api/axios'
export default {
  data() {
    return {
      total: 0,
      attendanceList: [],
      listLoading: false,
      listQuery: {
        // endTime: '',
        // startTime: '',
        page: 1,
        rows: 10,
        // meetingTitle: '',
        userName: '',
        id: ''
      }
      // userStatusOptions: ['可用', '不可用']
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    // 导出功能
    handleExcel() {
      api(`${this.GLOBAL.oaUrl}oa/oaMeetingAttendance/exportExcelMeetingAttendance`, '', 'get').then(res => {
        window.location.href = res.request.responseURL
      })
    },
    handleFilter() {
      this.initList()
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
    // 页面初始化
    initList() {
      this.listLoading = true
      api(`${this.GLOBAL.oaUrl}oa/oaMeetingAttendance/list`, this.listQuery, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          console.log(res)
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
    }
  }
}
</script>

<style lang="scss">
.meetingAttendance{
 .el-date-editor.el-input, .el-date-editor.el-input__inner{
    width:150px;
  }
  .el-input--medium .el-input__inner{
    width:150px;
  }
}
</style>

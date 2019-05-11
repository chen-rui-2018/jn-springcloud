<template>
  <div v-loading="listLoading" class="attendance">

    <el-form :inline="true" :model="listQuery" class="filter-bar">

      <el-form-item label="姓名:">
        <el-input v-model="listQuery.userName" placeholder="请输入姓名" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="部门:">
        <el-cascader
          :props="defaultParams"
          :show-all-levels="false"
          :options="departmentOptions"
          v-model="departmentId"
          clearable
          expand-trigger="hover"
          @change="handleChange"/>
      </el-form-item>
      <el-form-item label="打卡时间:">
        <el-date-picker v-model="listQuery.startTime" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始时间" />
        至
        <el-date-picker v-model="listQuery.endTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间"/>
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <!-- <el-button type="primary"> <router-link :to="{name:'attendanceSign'}">返回</router-link></el-button> -->
      <!-- <el-button type="primary"> <router-link :to="{name:'att'}">考勤</router-link></el-button> -->

    </el-form>
    <!-- 表格 -->
    <el-table :data="attendanceList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="姓名" align="center" prop="userName" />
      <el-table-column label="部门" align="center" prop="departmentName" />
      <el-table-column label="上班签到时间" align="center" prop="signInAttendanceTime">
        <template slot-scope="scope">
          <span :class="scope.row.signInAttendanceTime?'':'text-red'">{{ scope.row.signInAttendanceTime?scope.row.signInAttendanceTime:'未签到' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="下班签退时间" align="center" prop="signOutAttendanceTime">
        <template slot-scope="scope">
          <span :class="scope.row.signOutAttendanceTime?'':'text-red'">{{ scope.row.signOutAttendanceTime?scope.row.signOutAttendanceTime:'未签退' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="上班签到平台" align="center" prop="signInAttendancePlatform">
        <template slot-scope="scope">
          <span v-if="scope.row.signInAttendancePlatform==='1'" >PC</span>
          <span v-if="scope.row.signInAttendancePlatform==='2'" >App</span>
          <span v-if="scope.row.signInAttendancePlatform==='3'" >钉钉</span>
          <span v-if="scope.row.signInAttendancePlatform===null" class="text-red" >未签到</span>
        </template>
      </el-table-column>
      <el-table-column label="下班签退平台" align="center" prop="signOutAttendancePlatform">
        <template slot-scope="scope">
          <span v-if="scope.row.signOutAttendancePlatform==='1'" >PC </span>
          <span v-if="scope.row.signOutAttendancePlatform==='2'" >App</span>
          <span v-if="scope.row.signOutAttendancePlatform==='3'" >钉钉</span>
          <span v-if="scope.row.signOutAttendancePlatform===null" class="text-red">未签退</span>
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
      style="margin-top:15px;"
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
      defaultParams: {
        label: 'label',
        value: 'id',
        children: 'children'
      },
      departmentId: [],
      departmentOptions: [],
      total: 0,
      attendanceList: [],
      listLoading: false,
      listQuery: {
        departmentId: '',
        endTime: '',
        startTime: '',
        page: 1,
        rows: 10,
        userName: ''
      }
      // userStatusOptions: ['可用', '不可用']
    }
  },
  mounted() {
    this.initList()
    this.getAllDepartment()
  },
  methods: {
    // 获取部门信息
    // getDepartment() {
    //   api(`${this.GLOBAL.parkUrl}finance/expenses/selectDepartment`, '', 'get').then(res => {
    //     if (res.data.code === this.GLOBAL.code) {
    //       console.log(res)
    //       this.departmentOptions = res.data.data
    //     } else {
    //       this.$message.error(res.data.result)
    //     }
    //   })
    // },
    handleChange(val) {
      if (val.length > 0) {
        this.listQuery.departmentId = val[val.length - 1]
      } else {
        this.listQuery.departmentId = ''
      }
    },
    // 获取所有部门列表
    getAllDepartment() {
      api(`${this.GLOBAL.systemUrl}system/sysDepartment/findDepartmentAllByLevel`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.departmentOptions = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
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
    // 查询
    handleFilter() {
      if (this.listQuery.startTime) {
        if (!this.listQuery.endTime) {
          alert('请选择结束时间')
          return
        }
      }
      if (!this.listQuery.startTime) {
        if (this.listQuery.endTime) {
          alert('请选择开始时间')
          return
        }
      }
      if (new Date(this.listQuery.startTime.replace(/-/g, '\/')) > new Date(this.listQuery.endTime.replace(/-/g, '\/'))) {
        alert('开始时间不能大于结束时间,请重新选择 ')
        return
      }
      this.listQuery.page = 1
      this.initList()
    },
    // 页面初始化
    initList() {
      this.listLoading = true
      api(`${this.GLOBAL.oaUrl}oa/attendance/list`, this.listQuery, 'post').then(res => {
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
</style>

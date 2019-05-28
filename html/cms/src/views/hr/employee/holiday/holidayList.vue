<template>
  <div class="holidayList">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="姓名:">
        <el-input v-model="listQuery.name" maxlength="20" placeholder="请输入姓名" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="部门">
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
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button class="filter-item" type="primary" @click="handleExcel">导出</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table v-loading="listLoading" ref="multipleTable" :data="holidayList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="工号" align="center" prop="jobNumber" />
      <el-table-column label="部门" align="center" prop="departmentName" />
      <el-table-column label="职位" align="center" prop="jobName" />
      <el-table-column label="联系电话" align="center" prop="phone" />
      <el-table-column label="工龄" align="center" prop="workingAge"/>
      <el-table-column label="年休假" align="center" prop="annualLeave"/>
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
  postapi, exportExcel
} from '@/api/hr/holidayList'

import {
  api
} from '@/api/axios'

export default {
  data() {
    return {
      currentDepartmentIds: [],
      departmentList: [],
      holidayList: [],
      listLoading: false,
      listQuery: {
        name: '',
        page: 1,
        rows: 10,
        departmentId: ''
      },
      total: 0
    }
  },
  mounted() {
    this.initDepartMents()
    this.initList()
  },
  methods: {
    handleChangeDepartment(value) {
      this.listQuery.departmentId = this.currentDepartmentIds[this.currentDepartmentIds.length - 1]
    },
    // 导出功能
    handleExcel() {
      exportExcel(this.listQuery).then(res => {
        console.log('导出。。。')
        window.location.href = res.request.responseURL
      })
    },
    initDepartMents() {
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
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    initList() {
      console.log('查询。。。')
      this.listLoading = true
      postapi('hr/holidayRule/list', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.holidayList = res.data.data.rows
          this.total = res.data.data.total
          if (this.holidayList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
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
    }
  }
}
</script>

<style lang="scss">
  .el-pagination{
    margin-top:15px;
  }
</style>

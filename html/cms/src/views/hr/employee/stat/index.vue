<template>
  <div class="dashboard-editor-container">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="部门">
        <el-select v-model="listQuery.departmentId" placeholder="请选择" clearable style="width: 150px"
                   class="filter-item">
          <el-option  label="请选择" value="" />
          <el-option v-for="item in departmentList" :key="item.departmentId" :label="item.departmentName"
                     :value="item.departmentId"/>
        </el-select>
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
    </el-form>
    <el-row :gutter="32">
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="employeeTypeList" title="在职员工类型分布"/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="employeeCompanyDateList" title="在职员工司龄分布"/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="employeePostNameList" title="在职员工职级分布"/>
        </div>
      </el-col>

    </el-row>
    <el-row :gutter="32">
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="employeeSexList" title="在职员工性别分布"/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="employeeAcademicList" title="在职员工学历分布"/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="employeeAgeList" title="在职员工年龄分布"/>
        </div>
      </el-col>

    </el-row>
   <el-col :xs="24" :sm="24" :lg="24">
      <div class="chart-wrapper">
        <bar-chart :list-data="employeeDepartmentList" title="部门人数统计排名"/>
      </div>
    </el-col>

  </div>
</template>

<script>
  import PieChart from './PieChart'
  import BarChart from './BarChart'
  import {
    getDepartMents
  } from '@/api/hr/holidayList'
  import {
    getApi
  } from '@/api/hr/employeeStat'


  export default {
    name: 'EmployeeStat',
    components: {
      PieChart,
      BarChart,
    },
    data() {
      return {
        departmentList: [],
        employeeTypeList: [],
        employeeCompanyDateList: [],
        employeePostNameList: [],
        employeeSexList: [],
        employeeAcademicList: [],
        employeeAgeList: [],
        employeeDepartmentList: [],
        listQuery: {
          departmentId: ''
        }
      }
    },
    methods: {
      handleFilter() {
        this.initList()
      },
      initDepartMents() {
        getDepartMents().then(res => {
          if (res.data.code === '0000') {
            this.departmentList = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
      },
      initList() {
        getApi('hr/employeeStat/statByEmployeeType', this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.employeeTypeList = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
        getApi('hr/employeeStat/statByEmployeeCompanyDate', this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.employeeCompanyDateList = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
        getApi('hr/employeeStat/statByEmployeePostName', this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.employeePostNameList = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
        getApi('hr/employeeStat/statByEmployeeSex', this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.employeeSexList = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
        getApi('hr/employeeStat/statByEmployeeAcademic', this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.employeeAcademicList = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
        getApi('hr/employeeStat/statByEmployeeAge', this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.employeeAgeList = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
        getApi('hr/employeeStat/statByEmployeeDepartment', this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.employeeDepartmentList = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    mounted() {
      this.initDepartMents()
      this.initList()
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .dashboard-editor-container {
    padding: 32px;
    background-color: rgb(240, 242, 245);
    .chart-wrapper {
      background: #fff;
      padding: 16px 16px 0;
      margin-bottom: 32px;
    }
  }
</style>


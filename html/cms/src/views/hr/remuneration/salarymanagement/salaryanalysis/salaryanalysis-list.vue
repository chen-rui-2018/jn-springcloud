<template>
  <div class="dashboard-editor-container" style="height: 1000px">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="月份">
        <el-date-picker v-model="listQuery.accountEntryTime" value-format="yyyy-MM" type="month" placeholder="选择月份" style="width: 200px;"/>
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
    </el-form>
    <el-row>
      <el-col :span="5">
        <div style="height:66px; width: 210px;">
          <span style="height: 100%;width: 80px;display:inline-block; line-height: 15px;">
            <p style="color: #666666">计薪人数</p>
            <p>{{ salaryAnalysis.number }}人</p>
          </span>
          <span style="width: 120px;float: right;line-height: 66px;display:inline-block;color: #666666">
            环比{{ salaryAnalysis.lastNumber }}人
            <img v-if="imgs.wageNumberUpPng" src="@/assets/images/up.png" style="height: 20px;width: 10px;" alt="图片">
            <img v-if="imgs.wageNumberDownPng" src="@/assets/images/down.png" style="height: 20px;width: 10px;" alt="图片">
          </span>
        </div>
      </el-col>
      <el-col :span="6">
        <div style="height:66px; width: 230px;">
          <span style="height: 100%;width: 100px;line-height: 15px;display:  inline-block;">
            <p style="color: #666666">应发工资总计</p>
            <p>{{ salaryAnalysis.deserveWage }}元</p>
          </span>
          <span style="width: 120px;float: right;line-height: 66px;display:inline-block;color: #666666">
            环比{{ salaryAnalysis.lastDeserveWage }}
            <img v-if="imgs.deserveWageNumberUpPng" src="@/assets/images/up.png" style="height: 20px;width: 10px;" alt="图片">
            <img v-if="imgs.deserveWageNumberDownPng" src="@/assets/images/down.png" style="height: 20px;width: 10px;" alt="图片">
          </span>
        </div>
      </el-col>
      <el-col :span="6">
        <div style="height:66px; width: 250px;">
          <span style="height: 100%;width: 120px;line-height: 15px;display:  inline-block;">
            <p style="color: #666666">实际工资总计</p>
            <p>{{ salaryAnalysis.realWage }}元</p>
          </span>
          <span style="width: 120px;float: right;line-height: 66px;display:inline-block;color: #666666">
            环比{{ salaryAnalysis.lastRealWage }}
            <img v-if="imgs.realWageNumberUpPng" src="@/assets/images/up.png" style="height: 20px;width: 10px;" alt="图片">
            <img v-if="imgs.realWageNumberDownPng" src="@/assets/images/down.png" style="height: 20px;width: 10px;" alt="图片">
          </span>
        </div>
      </el-col>
      <el-col :span="6">
        <div style="height:66px; width: 250px;">
          <span style="height: 100%;line-height: 15px;width: 120px;display:  inline-block;">
            <p style="color: #666666">月度人力成本</p>
            <p>{{ salaryAnalysis.realWage }}元</p>
          </span>
          <span style="width: 120px;float: right;line-height: 66px;display:inline-block; color: #666666">
            环比{{ salaryAnalysis.lastRealWage }}
            <img v-if="imgs.realWageNumberUpPng" src="@/assets/images/up.png" style="height: 20px;width: 10px;" alt="图片">
            <img v-if="imgs.realWageNumberDownPng" src="@/assets/images/down.png" style="height: 20px;width: 10px;" alt="图片">
          </span>
        </div>
      </el-col>
    </el-row>
    <el-row :gutter="32" style="margin-top: 20px;">
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="baseSalaryCompositionList" title="园区员工基础工资占比图"/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="subsidySalaryCompositionList" title="园区员工各项补贴占比图"/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="socialSecurityAccumulationFundCompositionList" title="园区员工社保公积金缴纳占比图"/>
        </div>
      </el-col>
    </el-row>
    <el-row :gutter="32" style="margin-top: 20px;">
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="deductMoneyCompositionList" title="园区员工各项扣款占比图"/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart :list-data="laborCostsList" title="部门人力成本TOP7比图"/>
        </div>
      </el-col>
    </el-row>
    <el-col :xs="24" :sm="24" :lg="24">
      <div class="chart-wrapper">
        <bar-chart :list-data="percapitaWagePeopleList " title="部门人均工资TOP9统计图"/>
      </div>
    </el-col>

  </div>
</template>

<script>
import PieChart from './PieChart'
import BarChart from './BarChart'
import {
  api
} from '@/api/hr/common'

export default {
  name: 'EmployeeStat',
  components: {
    PieChart,
    BarChart
  },
  data() {
    return {
      baseSalaryCompositionList: [],
      subsidySalaryCompositionList: [],
      socialSecurityAccumulationFundCompositionList: [],
      deductMoneyCompositionList: [],
      laborCostsList: [],
      percapitaWagePeopleList: {
        percapitaWage: [],
        peopleNo: []
      },
      color: ['#f9a84f', '#e2d859', '#b5dd66', '#aaf7b8', '#8fdcff', '#7b97ff', '#9473ff', '#BA55D3', '#DDA0DD', '#AB82FF', '#87CEEB', '#B0E2FF'],
      salaryAnalysis: {
        number: 0,
        realWage: 0,
        deserveWage: 0,
        lastNumber: '0%',
        lastDeserveWage: '0%',
        lastRealWage: '0%'
      },
      imgs: {
        wageNumberUpPng: true,
        wageNumberDownPng: false,
        deserveWageNumberUpPng: true,
        deserveWageNumberDownPng: false,
        realWageNumberUpPng: true,
        realWageNumberDownPng: false,
        monthlyLaborCostUpPng: true,
        monthlyLaborCostDownPng: false
      },
      listQuery: {
        accountEntryTime: ''
      }
    }
  },
  watch: {
    'listQuery.accountEntryTime': function() {
      this.listQuery.page = 1
      this.initList()
    }
  },
  mounted() {
    this.getCurrMonth()
    this.initList()
  },
  methods: {
    handleFilter() {
      this.initList()
    },
    getCurrMonth() {
      const currentDate = new Date()
      const currentMonth = currentDate.getMonth() + 1// 获得当前月份0-11
      const currentYear = currentDate.getFullYear()// 获得当前年份4位年
      this.listQuery.accountEntryTime = currentYear + '-' + '0' + currentMonth
    },
    initList() {
      api('hr/SalaryWelfareManagement/salaryAnalysis', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.baseSalaryCompositionList = []
          this.subsidySalaryCompositionList = []
          this.socialSecurityAccumulationFundCompositionList = []
          this.deductMoneyCompositionList = []
          this.laborCostsList = []
          const baseSalaryCompositionListD = res.data.data.basicWageProportion // 基础工资占比
          for (let i = 0; i < baseSalaryCompositionListD.length; i++) {
            const item = baseSalaryCompositionListD[i]
            item.itemStyle = { 'normal': { 'color': this.color[i] }}
            this.baseSalaryCompositionList.push(item)
          }
          const subsidySalaryCompositionListD = res.data.data.subsidyProportion // 各项补贴占比
          for (let i = 0; i < subsidySalaryCompositionListD.length; i++) {
            const item = subsidySalaryCompositionListD[i]
            item.itemStyle = { 'normal': { 'color': this.color[i] }}
            this.subsidySalaryCompositionList.push(item)
          }

          const socialSecurityAccumulationFundCompositionListD = res.data.data.socialSecurityProportion // 社保公积金缴纳占比
          for (let i = 0; i < socialSecurityAccumulationFundCompositionListD.length; i++) {
            const item = socialSecurityAccumulationFundCompositionListD[i]
            item.itemStyle = { 'normal': { 'color': this.color[i] }}
            this.socialSecurityAccumulationFundCompositionList.push(item)
          }

          const deductMoneyCompositionListD = res.data.data.deductionProportion // 各项扣款
          for (let i = 0; i < deductMoneyCompositionListD.length; i++) {
            const item = deductMoneyCompositionListD[i]
            item.itemStyle = { 'normal': { 'color': this.color[i] }}
            this.deductMoneyCompositionList.push(item)
          }

          const laborCostsListD = res.data.data.laborCosts

          for (let i = 0; i < laborCostsListD.length; i++) {
            const item = laborCostsListD[i]
            item.itemStyle = { 'normal': { 'color': this.color[i] }}
            this.laborCostsList.push(item)
          }

          this.percapitaWagePeopleList.percapitaWage = res.data.data.perpleCapita
          this.percapitaWagePeopleList.peopleNo = res.data.data.departmentNumber
          this.salaryAnalysis.number = res.data.data.number
          this.salaryAnalysis.realWage = res.data.data.realWage
          this.salaryAnalysis.deserveWage = res.data.data.deserveWage
          this.salaryAnalysis.lastNumber = res.data.data.lastNumber
          if (res.data.data.lastNumber.indexOf('+') !== -1) {
            this.imgs.wageNumberUpPng = true
            this.imgs.wageNumberDownPng = false
          } else if (res.data.data.lastNumber.indexOf('-') !== -1) {
            this.imgs.wageNumberUpPng = false
            this.imgs.wageNumberDownPng = true
          } else {
            this.imgs.wageNumberUpPng = false
            this.imgs.wageNumberDownPng = false
          }
          this.salaryAnalysis.lastDeserveWage = res.data.data.lastDeserveWage
          if (res.data.data.lastDeserveWage.indexOf('+') !== -1) {
            this.imgs.deserveWageNumberUpPng = true
            this.imgs.deserveWageNumberDownPng = false
          } else if (res.data.data.lastDeserveWage.indexOf('-') !== -1) {
            this.imgs.deserveWageNumberUpPng = false
            this.imgs.deserveWageNumberDownPng = true
          } else {
            this.imgs.deserveWageNumberUpPng = false
            this.imgs.deserveWageNumberDownPng = false
          }
          this.salaryAnalysis.lastRealWage = res.data.data.lastRealWage
          if (res.data.data.lastRealWage.indexOf('+') !== -1) {
            this.imgs.realWageNumberUpPng = true
            this.imgs.realWageNumberDownPng = false
          } else if (res.data.data.lastRealWage.indexOf('-') !== -1) {
            this.imgs.realWageNumberUpPng = false
            this.imgs.realWageNumberDownPng = true
          } else {
            this.imgs.realWageNumberUpPng = false
            this.imgs.realWageNumberDownPng = false
          }
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
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


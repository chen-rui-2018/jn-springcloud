<template>
  <div class="dashboard-editor-container" style="height: 1000px">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="月份">
        <el-date-picker v-model="listQuery.insuredMonth" value-format="yyyy-MM" type="month" placeholder="选择月份" style="width: 200px;"/>
      </el-form-item>
      <el-form-item label="参保类型">
        <el-select
          v-model="listQuery.type"
          placeholder="请选择"
          clearable
          style="width: 150px"
          class="filter-item"
          @change="changeProjectType">
          <el-option label="社保和公积金" value="3" />
          <el-option label="社保" value="1" />
          <el-option label="公积金" value="2" />
        </el-select>
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
    </el-form>

    <el-row style="margin-top: 10px;margin-bottom: 10px;">
      <el-col :span="6">
        <div style="height:66px; width: 220px;">
          <span style="height: 100%;width: 80px;display:inline-block; line-height: 15px;">
            <p style="color: #666666">参保人数</p>
            <p>{{ statisticalInfo.insuredNumber }}人</p>
          </span>
          <span style="width: 140px;float: right;line-height: 66px;display:inline-block;color: #666666">
            环比{{ statisticalInfo.lastInsuredNumber }}人
            <img v-if="imgs.insuredNumberUpPng" src="@/assets/images/up.png" style="height: 20px;width: 10px;" alt="图片">
            <img v-if="imgs.insuredNumberDownPng" src="@/assets/images/down.png" style="height: 20px;width: 10px;" alt="图片">
          </span>
        </div>
      </el-col>
      <el-col v-if="socialSecurityFlag" :span="6">
        <div style="height:66px; width: 220px;">
          <span style="height: 100%;width: 80px;line-height: 15px;display:  inline-block;">
            <p style="color: #666666">社保费用</p>
            <p>{{ statisticalInfo.socialSecurityCost }}元</p>
          </span>
          <span style="width: 140px;float: right;line-height: 66px;display:inline-block;color: #666666">
            环比{{ statisticalInfo.lastSocialSecurityCost }}元
            <img v-if="imgs.socialSecurityUpPng" src="@/assets/images/up.png" style="height: 20px;width: 10px;" alt="图片">
            <img v-if="imgs.socialSecurityDownPng" src="@/assets/images/down.png" style="height: 20px;width: 10px;" alt="图片">
          </span>
        </div>
      </el-col>
      <el-col v-if="accumulationFundFlag" :span="6">
        <div style="height:66px; width: 240px;">
          <span style="height: 100%;width: 100px;line-height: 15px;display:  inline-block;">
            <p style="color: #666666">公积金</p>
            <p>{{ statisticalInfo.accumulationFund }}元</p>
          </span>
          <span style="width: 140px;float: right;line-height: 66px;display:inline-block;color: #666666">
            环比{{ statisticalInfo.lastAccumulationFund }}元
            <img v-if="imgs.accumulationFundUpPng" src="@/assets/images/up.png" style="height: 20px;width: 10px;" alt="图片">
            <img v-if="imgs.accumulationFundDownPng" src="@/assets/images/down.png" style="height: 20px;width: 10px;" alt="图片">
          </span>
        </div>
      </el-col>
      <el-col :span="6">
        <div style="height:66px; width: 240px;">
          <span style="height: 100%;line-height: 15px;width: 100px;display:  inline-block;">
            <p style="color: #666666">总费用</p>
            <p>{{ statisticalInfo.totalCost }}元</p>
          </span>
          <span style="width: 140px;float: right;line-height: 66px;display:inline-block; color: #666666">
            环比{{ statisticalInfo.lastTotalCost }}元
            <img v-if="imgs.totalCostUpPng" src="@/assets/images/up.png" style="height: 20px;width: 10px;" alt="图片">
            <img v-if="imgs.totalCostDownPng" src="@/assets/images/down.png" style="height: 20px;width: 10px;" alt="图片">
          </span>
        </div>
      </el-col>
    </el-row>
    <el-col :xs="40" :sm="40" :lg="24">
      <div class="chart-wrapper">
        <bar-chart :list-data="socialSecurityList" title="各部门月参保费用TOP9统计"/>
      </div>
    </el-col>

  </div>
</template>

<script>
import BarChart from './BarChart'
import {
  api
} from '@/api/hr/common'

export default {
  name: 'EmployeeStat',
  components: {
    BarChart
  },
  data() {
    return {
      statisticalInfo: {
        insuredNumber: '',
        lastInsuredNumber: '',
        socialSecurityCost: '',
        lastSocialSecurityCost: '',
        accumulationFund: '',
        lastAccumulationFund: '',
        totalCost: '',
        lastTotalCost: ''
      },
      socialSecurityList: {
        totalCost: [],
        companyExpense: [],
        personalExpense: [],
        insuredPeopleNo: []
      },
      imgs: {
        socialSecurityUpPng: true,
        socialSecurityDownPng: false,
        accumulationFundUpPng: true,
        accumulationFundDownPng: false,
        totalCostUpPng: true,
        totalCostDownPng: false,
        insuredNumberUpPng: true,
        insuredNumberDownPng: false
      },
      listQuery: {
        insuredMonth: '',
        type: '3'
      },
      socialSecurityFlag: true,
      accumulationFundFlag: true
    }
  },
  watch: {
    'listQuery.insuredMonth': function() {
      this.listQuery.page = 1
      this.initList()
    },
    'listQuery.type': function() {
      this.listQuery.page = 1
      this.initList()
    }
  },
  mounted() {
    this.getCurrMonth()
    this.initList()
  },
  methods: {
    changeProjectType(val) {
      if (val === '1') {
        this.socialSecurityFlag = true
        this.accumulationFundFlag = false
      } else if (val === '2') { // 公积金
        this.socialSecurityFlag = false
        this.accumulationFundFlag = true
      } else {
        this.socialSecurityFlag = true
        this.accumulationFundFlag = true
      }
    },
    handleFilter() {
      this.initList()
    },
    getCurrMonth() {
      const currentDate = new Date()
      const currentMonth = currentDate.getMonth() + 1// 获得当前月份0-11
      const currentYear = currentDate.getFullYear()// 获得当前年份4位年
      this.listQuery.insuredMonth = currentYear + '-' + '0' + currentMonth
    },
    initList() {
      api('hr/SalaryWelfareManagement/insuredOverview', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.socialSecurityList.totalCost = res.data.data.departmentTotalCost == null ? [] : res.data.data.departmentTotalCost
          this.socialSecurityList.companyExpense = res.data.data.departmentCompanyCost == null ? [] : res.data.data.departmentCompanyCost
          this.socialSecurityList.personalExpense = res.data.data.departmentPersonalCost == null ? [] : res.data.data.departmentPersonalCost
          this.socialSecurityList.insuredPeopleNo = res.data.data.departmentNumber == null ? [] : res.data.data.departmentNumber

          this.statisticalInfo.insuredNumber = res.data.data.number
          this.statisticalInfo.socialSecurityCost = res.data.data.socialSecurity
          this.statisticalInfo.accumulationFund = res.data.data.accumulationFund
          this.statisticalInfo.totalCost = res.data.data.totalCost

          this.statisticalInfo.lastInsuredNumber = res.data.data.lastNumber
          this.statisticalInfo.lastSocialSecurityCost = res.data.data.lastSocialSecurity
          this.statisticalInfo.lastAccumulationFund = res.data.data.lastAccumulationFund
          this.statisticalInfo.lastTotalCost = res.data.data.lastTotalCost

          if (res.data.data.lastNumber.indexOf('+') !== -1) { // 参保人数
            this.imgs.insuredNumberUpPng = true
            this.imgs.insuredNumberDownPng = false
          } else if (res.data.data.lastNumber.indexOf('-') !== -1) {
            this.imgs.insuredNumberUpPng = false
            this.imgs.insuredNumberDownPng = true
          } else {
            this.imgs.insuredNumberUpPng = false
            this.imgs.insuredNumberDownPng = false
          }
          if (res.data.data.lastSocialSecurity.indexOf('+') !== -1) { // 社保费用
            this.imgs.socialSecurityUpPng = true
            this.imgs.socialSecurityDownPng = false
          } else if (res.data.data.lastSocialSecurity.indexOf('-') !== -1) {
            this.imgs.socialSecurityUpPng = false
            this.imgs.socialSecurityDownPng = true
          } else {
            this.imgs.socialSecurityUpPng = false
            this.imgs.socialSecurityDownPng = false
          }
          if (res.data.data.lastAccumulationFund.indexOf('+') !== -1) { // 公积金
            this.imgs.accumulationFundUpPng = true
            this.imgs.accumulationFundDownPng = false
          } else if (res.data.data.lastAccumulationFund.indexOf('-') !== -1) {
            this.imgs.accumulationFundUpPng = false
            this.imgs.accumulationFundDownPng = true
          } else {
            this.imgs.accumulationFundUpPng = false
            this.imgs.accumulationFundDownPng = false
          }
          if (res.data.data.lastTotalCost.indexOf('+') !== -1) { // 总费用
            this.imgs.totalCostUpPng = true
            this.imgs.totalCostDownPng = false
          } else if (res.data.data.lastTotalCost.indexOf('-') !== -1) {
            this.imgs.totalCostUpPng = false
            this.imgs.totalCostDownPng = true
          } else {
            this.imgs.totalCostUpPng = false
            this.imgs.totalCostDownPng = false
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


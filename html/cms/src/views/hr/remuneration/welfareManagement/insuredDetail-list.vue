<template>
  <div v-loading="listLoading" class="insuredDetaildList">
    <el-form :inline="true" class="filter-bar">
      <el-button class="filter-item" type="primary" @click="goBack($route)" >返回</el-button>
      <el-button class="filter-item" type="primary" @click="stopInsurance">停止参保</el-button>
      <el-button class="filter-item" type="primary" @click="handleExport">导出</el-button>
    </el-form>
    <el-form :inline="true" :model="listQuery" class="filter-bar" style="margin-top: 10px;">
      <el-form-item label="姓名:" style="margin-left: 30px;" >
        <el-input v-model="listQuery.name" maxlength="20" placeholder="" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="部门:" style="margin:0px 30px;">
        <el-cascader
          :options="departmentList"
          v-model="departmentIdS"
          change-on-select
          placeholder="请选择"
          clearable
          @change="handleChangeDepartment"
        />
        <!--<el-select v-model="listQuery.departmentId" placeholder="请选择部门" filterable>
          <el-option v-for="item in departmentList" :key="item.departmentId" :label="item.departmentName" :value="item.departmentId" />
        </el-select>-->
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
    </el-form>

    <div style="height:92px; width: 99.8%; border: 1px solid #b3d4fc">
      <span style="width: 9%;float: left;line-height: 92px;display:inline-block;text-align: center;font-size: 13px;font-weight: bold;color: blue">
        <img src="@/assets/images/left.png" style="height: 20px;width: 20px;" alt="图片" @click="getInsuredMonthPreMonth">
        {{ queryMonth }}
        <img src="@/assets/images/right.png" style="height: 20px;width: 20px;" alt="图片" @click="getInsuredMonthNextMonth">
      </span>
      <span style="height: 100%;width: 91%; display:inline-block; line-height: 15px;">
        <el-table :data="insuredSummary" border fit highlight-current-row style="width: 100%;height:100%;">
          <el-table-column :show-overflow-tooltip="true" label="参保人数" align="center" prop="insuredNumber" />
          <el-table-column :show-overflow-tooltip="true" label="本月新增" align="center" prop="increaseInsuranceNumber"/>
          <el-table-column :show-overflow-tooltip="true" label="本月停保" align="center" prop="stopInsuranceNumber"/>
          <el-table-column :show-overflow-tooltip="true" label="个人社保" align="center" prop="personalSocialSecurity"/>
          <el-table-column :show-overflow-tooltip="true" label="公司社保" align="center" prop="companySocialSecurity" />
          <el-table-column :show-overflow-tooltip="true" label="个人公积金" align="center" prop="personalAccumulationFund"/>
          <el-table-column :show-overflow-tooltip="true" label="公司公积金" align="center" prop="companyAccumulationFund" />
          <el-table-column :show-overflow-tooltip="true" label="合计" align="center" prop="summary" />
        </el-table>
      </span>
    </div>
    <!-- 表格 -->
    <el-table ref="insuredDetaildTab" :data="insuredDetaildList" border fit highlight-current-row style="width: 100%;height:100%;margin-top: 10px;">
      <!--<el-table-column type="selection" width="45" align="center"/>-->
      <el-table-column label="选择" width="60" align="center">
        <template slot-scope="scope">
          <el-radio-group v-model="radioGroup">
            <el-radio v-model="jobNumberSel" :label="scope.row.jobNumber" :checked="radioChecked" @change.native="getJobNumberSel(scope.$index,scope.row)" @click.native.prevent="clickRadio(scope.row)">&nbsp;</el-radio>
          </el-radio-group>
        </template>
      </el-table-column>
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column :show-overflow-tooltip="true" label="姓名" align="center" prop="name" />
      <el-table-column :show-overflow-tooltip="true" label="工号" align="center" prop="jobNumber"/>
      <el-table-column :show-overflow-tooltip="true" label="部门" align="center" prop="department"/>
      <el-table-column :show-overflow-tooltip="true" label="参保城市" align="center" prop="cityName"/>
      <el-table-column :show-overflow-tooltip="true" label="个人社保费" align="center" prop="personalSocialSecurity" />
      <el-table-column :show-overflow-tooltip="true" label="公司社保费" width="120" align="center" prop="companySocialSecurity"/>
      <el-table-column :show-overflow-tooltip="true" label="个人公积金费" align="center" prop="personalAccumulationFund" />
      <el-table-column :show-overflow-tooltip="true" label="公司公积金费" align="center" prop="companyAccumulationFund" />
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

    <!-- 停止参保弹出框 -->
    <template v-if="stopInsuranceFormVisible">
      <el-dialog :visible.sync="stopInsuranceFormVisible" title="减员月份" width="650px">
        <el-form label-position="right" label-width="80px">
          <el-form-item label="减员月份:">
            <el-date-picker v-model="stopInsuranceFormData.insuredMonth" type="month" value-format="yyyy-MM" placeholder="" style="width: 100%;"/>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button :disabled="stopInsuranceFormBt" type="primary" @click="stopInsuranceTimeSubmit">保存</el-button>
          <el-button @click="handleCancle">取消</el-button>
        </div>
      </el-dialog>
    </template>

  </div>
</template>
<script>
import {
  api, exportExcel, getPreMonth, getNextMonth, systemApi, accMul, accAdd
} from '@/api/hr/common'

import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      jobNumberSel: '',
      radioGroup: '',
      radioChecked: false,
      seleRow: {
        jobNumber: '',
        schemeId: ''
      },
      stopInsuranceFormBt: false,
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      insuredDetaildList: [],
      insuredSummary: [],
      departmentList: [],
      departmentIdS: [],
      departmentListLoading: false,
      stopInsuranceFormVisible: false,
      stopInsuranceFormData: {
        insuredMonth: '',
        jobNumber: ''
      },
      total: 0,
      listLoading: false,
      queryMonth: '',
      listQuery: {
        page: 1,
        rows: 10,
        name: '',
        departmentId: '',
        insuredMonth: ''
      },
      code: {
        groupCode: 'platform_type',
        moduleCode: 'springcloud-hr',
        parentGroupCode: 'welfareManagement'
      }
    }
  },
  watch: {
    'listQuery.name': function() {
      this.listQuery.page = 1
      this.reflushList()
    },
    'listQuery.departmentId': function() {
      this.listQuery.page = 1
      this.reflushList()
    }
  },
  mounted() {
    this.initList()
    this.getAllDepartment()
  },
  methods: {
    clickRadio(row) {
      const e = row.jobNumber
      if (e === this.radioGroup) {
        this.radioGroup = ''
        this.seleRow.schemeId = ''
        this.seleRow.jobNumber = ''
      } else {
        this.radioGroup = e
        this.seleRow.schemeId = row.schemeId
        this.seleRow.jobNumber = row.jobNumber
      }
    },
    getJobNumberSel(index, row) {
      this.seleRow.schemeId = row.schemeId
      this.seleRow.jobNumber = row.jobNumber
    },
    // 选择部门（新增用户对话框）
    handleChangeDepartment(value) {
      this.listQuery.departmentId = this.departmentIdS[this.departmentIdS.length - 1]
    },
    // 获取所有部门列表
    getAllDepartment() {
      this.departmentListLoading = true
      systemApi('system/sysDepartment/findDepartmentAllByLevel').then(res => {
        if (res.data.code === '0000') {
          this.departmentList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.departmentListLoading = false
      })
    },
    reflushList() {
      this.getInsuredDetaildList(this.queryMonth)
      this.getDetailSub(this.queryMonth, this.listQuery.departmentId)
    },
    getInsuredMonthNextMonth() {
      const curMonth = this.queryMonth
      const year = curMonth.substr(0, 4)
      let month = curMonth.substr(curMonth.indexOf('-') + 1, curMonth.length)
      if (month.length === 1) {
        month = '0' + month
      }
      this.queryMonth = getNextMonth(year + '-' + month + '-01')
      this.getDetailSub(this.queryMonth, this.listQuery.department)
      this.getInsuredDetaildList(this.queryMonth)
    },
    getInsuredMonthPreMonth() {
      const curMonth = this.queryMonth
      const year = curMonth.substr(0, 4)
      let month = curMonth.substr(curMonth.indexOf('-') + 1, curMonth.length)
      if (month.length === 1) {
        month = '0' + month
      }
      this.queryMonth = getPreMonth(year + '-' + month + '-01')
      this.getDetailSub(this.queryMonth, this.listQuery.department)
      this.getInsuredDetaildList(this.queryMonth)
    },
    stopInsuranceTimeSubmit() {
      this.stopInsuranceFormBt = true
      if (this.stopInsuranceFormData.insuredMonth === '') {
        alert('请选择停止参保月份')
        this.stopInsuranceFormBt = false
        return false
      }
      this.stopInsuranceFormData.jobNumber = this.seleRow.jobNumber
      this.stopInsuranceFormData.insuredProgrammeId = this.seleRow.schemeId
      api('hr/SalaryWelfareManagement/stopInsurance', this.stopInsuranceFormData).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '减员成功',
            type: 'success'
          })
          this.stopInsuranceFormVisible = false
          this.stopInsuranceFormBt = false
          this.clickRadio(this.seleRow.jobNumber)
          this.seleRow.jobNumber = ''
          this.seleRow.schemeId = ''
          this.stopInsuranceFormData.insuredMonth = ''
          this.radioChecked = false
          this.initList()
        } else {
          this.$message.error(res.data.result)
          this.stopInsuranceFormVisible = false
          this.stopInsuranceFormBt = false
        }
      })
    },
    handleCancle() {
      this.stopInsuranceFormVisible = false
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('insurancemanagement-list')
        }
      })
    },
    stopInsurance() {
      if (this.seleRow.jobNumber === '') {
        this.$message.error('只能选择一条停止参保员工记录')
        return
      } else {
        this.stopInsuranceFormVisible = true
      }
      // const seleRow = this.$refs.insuredDetaildTab.store.states.selection
      // if (seleRow.length !== 0) {
      //   if (seleRow.length > 1) {
      //     this.$message.error('只能选择一条停止参保员工记录')
      //     return
      //   }
      //   this.stopInsuranceFormVisible = true
      // } else {
      //   this.$message.error('请选择要停保的员工')
      // }
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
    // 查询数据
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    getInsuredDetaildList(month) {
      this.listQuery.insuredMonth = month
      this.listLoading = true
      api('hr/SalaryWelfareManagement/paginationInquireInsuranceRecord', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.insuredDetaildList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result == null ? '查询失败' : res.data.result)
        }
        this.listLoading = false
      })
    },
    // 初始化
    initList() {
      const queryRow = this.$route.query.row
      this.queryMonth = queryRow.insuredMonth
      this.getInsuredDetaildList(queryRow.insuredMonth)
      this.getDetailSub(this.queryMonth, '')
    },
    getDetailSub(month, departmentId) {
      this.insuredSummary = []
      api('hr/SalaryWelfareManagement/insuredDetailedSubsidiary', { page: 1, rows: 10, insuredMonth: month, departmentId: departmentId }).then(res => {
        if (res.data.code === '0000') {
          const row = res.data.data
          // const summary = (res.data.data.personalSocialSecurity + res.data.data.companySocialSecurity) * res.data.data.insuredNumber +
          //   (res.data.data.personalAccumulationFund + res.data.data.companyAccumulationFund) * res.data.data.insuredNumber
          const summary = accAdd(accMul(accAdd(res.data.data.personalSocialSecurity, res.data.data.companySocialSecurity), res.data.data.insuredNumber),
            accMul(accAdd(res.data.data.personalAccumulationFund, res.data.data.companyAccumulationFund), res.data.data.insuredNumber))
          row.summary = summary
          this.insuredSummary.push(row)
        } else {
          this.$message.error(res.data.result == null ? '查询失败' : res.data.result)
        }
        this.listLoading = false
      })
    },
    handleExport() {
      exportExcel('hr/SalaryWelfareManagement/exportInsuranceRecord').then(res => {
        window.location.href = res.request.responseURL
      })
    }
  }
}
</script>

<style lang="scss"  scoped>
.setCursor{
  cursor: auto;
}
    .el-pagination{
      margin-top:15px;
    }

</style>
<style lang="scss">
.noticeContent{
.el-dialog{
      height: 550px;
      overflow: auto;
    }
}
</style>

<template>
  <div v-loading="listLoading">
    <div style="border: 1px;border-color: #00a0e9;">
      <el-form :inline="true" class="filter-bar">
        <el-button class="filter-item" type="primary" @click="handleExport">导出</el-button>
        <el-button class="filter-item" type="primary" @click="importExcel">导入</el-button>
      </el-form>

      <el-form :inline="true" :model="listQuery" class="filter-bar" style="margin-top: 10px;">
        <el-form-item label="姓名:" >
          <el-input v-model="listQuery.name" maxlength="20" placeholder="" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      </el-form>
    </div>
    <!-- 表格 -->
    <el-table :data="salaryPayrollList" border fit highlight-current-row>
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column
        :show-overflow-tooltip="true"
        width="100"
        label="发放单位"
        header-align="center"
        align="center"
        prop="issuingUnit"/>
      <el-table-column
        width="80"
        label="姓名"
        header-align="center"
        align="center"
        prop="name"/>
      <el-table-column
        :show-overflow-tooltip="true"
        width="100"
        label="身份证号"
        header-align="center"
        align="center"
        prop="idCard"/>
      <el-table-column
        :show-overflow-tooltip="true"
        width="90"
        label="人员类别"
        header-align="center"
        align="center"
        prop="personnelCategory"/>
      <el-table-column
        :show-overflow-tooltip="true"
        width="90"
        label="应付工资"
        header-align="center"
        align="center"
        prop="deserveWage"/>
      <el-table-column
        prop="signBill"
        label="基本薪酬(固定类工资)"
        header-align="center"
        align="center">
        <el-table-column
          :show-overflow-tooltip="true"
          width="100"
          prop="basicWage"
          label="基本工资"
          header-align="center"
          align="center"
        />
        <el-table-column
          :show-overflow-tooltip="true"
          width="140"
          prop="seniorityWage"
          label="本单位工龄工资"
          header-align="center"
          align="center"/>
        <el-table-column
          width="100"
          prop="professionalTitleAllowance"
          label="职称津贴"
          header-align="center"
          align="center"/>
        <el-table-column
          width="120"
          prop="technicalAllowance"
          label="技术岗位津贴"
          header-align="center"
          align="center"/>
        <el-table-column
          width="100"
          prop="educationAllowance"
          label="学历津贴"
          header-align="center"
          align="center"/>
        <el-table-column
          width="110"
          prop="workAllowance"
          label="工作性津贴"
          header-align="center"
          align="center"/>
        <el-table-column
          width="100"
          prop="dutyAllowance"
          label="职务津贴"
          header-align="center"
          align="center"/>
        <el-table-column
          width="100"
          prop="specialSubsidy"
          label="专项补贴"
          header-align="center"
          align="center"/>
        <el-table-column
          width="100"
          prop="jobAllowance"
          label="岗位津贴"
          header-align="center"
          align="center"/>
        <el-table-column
          width="100"
          prop="compositeSubsidy"
          label="综合补贴"
          header-align="center"
          align="center"/>
        <el-table-column
          width="220"
          prop="basicWageTotal"
          label="基本薪酬(固定类薪资)小计"
          header-align="center"
          align="center"/>
      </el-table-column>
      <el-table-column
        label="绩效薪酬(浮动类工资)"
        header-align="center"
        align="center">
        <el-table-column
          width="90"
          prop="seasonBonus"
          label="季度奖"
          header-align="center"
          align="center"/>
        <el-table-column
          width="90"
          prop="yearEndBonus"
          label="年终奖"
          header-align="center"
          align="center"/>
        <el-table-column
          width="220"
          prop="salaryTotal"
          label="绩效薪酬(浮动类工资)小计"
          header-align="center"
          align="center"/>
      </el-table-column>
      <el-table-column
        width="100"
        label="任期激励"
        header-align="center"
        align="center"
        prop="workExcitation"/>
      <el-table-column
        label="加、值班费"
        header-align="center"
        align="center">
        <el-table-column
          width="90"
          prop="overtimeCost"
          label="加班费"
          header-align="center"
          align="center"/>
        <el-table-column
          width="90"
          prop="onDutyCost"
          label="值班费"
          header-align="center"
          align="center"/>
        <el-table-column
          width="120"
          prop="overtimeTotal"
          label="加值班费小计"
          header-align="center"
          align="center"/>
      </el-table-column>
      <el-table-column
        width="120"
        label="公务用车补贴"
        header-align="center"
        align="center"
        prop="businessCarSubsidy"/>
      <el-table-column
        label="拆迁补贴"
        header-align="center"
        align="center">
        <el-table-column
          width="120"
          prop="siteOvertimeSubsidy"
          label="现场加班补助"
          header-align="center"
          align="center"/>
        <el-table-column
          width="90"
          prop="walkDoorBouns"
          label="走户奖"
          header-align="center"
          align="center"/>
        <el-table-column
          width="90"
          prop="demolitionSubsidy"
          label="拆迁补贴其他"
          header-align="center"
          align="center"/>
        <el-table-column
          width="120"
          prop="demolitionSubsidyTotal"
          label="拆迁补贴小计"
          header-align="center"
          align="center"/>
      </el-table-column>
      <el-table-column
        label="其他一"
        header-align="center"
        align="center">
        <el-table-column
          width="90"
          prop="delayCost"
          label="误餐费"
          header-align="center"
          align="center"/>
        <el-table-column
          width="90"
          prop="rewardWage"
          label="奖励金"
          header-align="center"
          align="center"/>
        <el-table-column
          width="110"
          prop="otherOneTotal"
          label="其他一小计"
          header-align="center"
          align="center"/>
      </el-table-column>
      <el-table-column
        width="90"
        label="其他二"
        header-align="center"
        align="center"
        prop="otherWage"/>
      <el-table-column
        width="100"
        label="应发小计"
        header-align="center"
        align="center"
        prop="deserveWageTotal"/>
      <el-table-column
        label="个人社会保险"
        header-align="center"
        align="center">
        <el-table-column
          width="70"
          prop="pensionWage"
          label="养老"
          header-align="center"
          align="center"/>
        <el-table-column
          width="70"
          prop="unemploymentWage"
          label="失业"
          header-align="center"
          align="center"/>
        <el-table-column
          width="70"
          prop="medicalWage"
          label="医疗"
          header-align="center"
          align="center"/>
        <el-table-column
          width="100"
          prop="majorIllnessWage"
          label="大病统筹"
          header-align="center"
          align="center"/>
        <el-table-column
          width="150"
          prop="personalSocialSecurityWageTotal"
          label="个人社会保险小计"
          header-align="center"
          align="center"/>
      </el-table-column>
      <el-table-column
        width="120"
        label="单位社会保险"
        header-align="center"
        align="center"
        prop="unitSocietyWage"/>
      <el-table-column
        width="90"
        label="公积金"
        header-align="center"
        align="center"
        prop="providentFund"/>
      <el-table-column
        width="110"
        label="单位公积金"
        header-align="center"
        align="center"
        prop="unitProvidentFund"/>
      <el-table-column
        width="90"
        label="工会会费"
        header-align="center"
        align="center"
        prop="unionFee"/>
      <el-table-column
        label="扣款1"
        header-align="center"
        align="center">
        <el-table-column
          width="70"
          prop="mealFee"
          label="餐费"
          header-align="center"
          align="center"/>
        <el-table-column
          width="70"
          prop="leaveFee"
          label="事假"
          header-align="center"
          align="center"/>
        <el-table-column
          width="70"
          prop="sickLeaveFee"
          label="病假"
          header-align="center"
          align="center"/>
        <el-table-column
          width="90"
          label="扣罚金"
          header-align="center"
          align="center"
          prop="penaltyFee"/>
        <el-table-column
          width="100"
          label="扣款1小计"
          header-align="center"
          align="center"
          prop="deductionOneWageTotal"/>
      </el-table-column>
      <el-table-column
        label="扣款2"
        header-align="center"
        align="center">
        <el-table-column
          width="70"
          prop="deductionOne"
          label="1"
          header-align="center"
          align="center"/>
        <el-table-column
          width="70"
          prop="deductionTwo"
          label="2"
          header-align="center"
          align="center"/>
        <el-table-column
          width="100"
          prop="deductionTwoWageTotal"
          label="扣款2小计"
          header-align="center"
          align="center"/>

      </el-table-column>
      <el-table-column
        width="110"
        label="个人所得税"
        header-align="center"
        align="center"
        prop="pendingPersonalTax"/>
      <el-table-column
        width="100"
        label="实发小计"
        header-align="center"
        align="center"
        prop="realWage"/>
      <el-table-column
        width="120"
        label="存放个人账户"
        header-align="center"
        align="center"
        prop="depositPersonalAccount"/>
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

    <el-dialog
      :visible.sync="dialogImportVisible"
      :modal-append-to-body="false"
      :close-on-click-modal="false"
      title="工资条导入"
      class="dialog-import">
      <div :class="{'import-content': importFlag === 1, 'hide-dialog': importFlag !== 1}">
        <el-upload
          :action="importUrl"
          :headers="importHeaders"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :before-upload="beforeUpload"
          :on-error="uploadFail"
          :on-success="uploadSuccess"
          :file-list="fileList"
          class="upload-demo">
          <!-- 是否支持发送cookie信息 -->
          <el-button :disabled="processing" size="small" type="primary">{{ uploadTip }}</el-button>
          <div slot="tip" class="el-upload__tip">只能上传excel文件</div>
        </el-upload>
        <div class="download-template">
          <a class="btn-download" href="/static/file/工资条条目.xlsx">
          <i class="el-icon-download"/>下载模板</a>
        </div>
      </div>
      <div :class="{'import-failure': importFlag === 2, 'hide-dialog': importFlag !== 2}">
        <div class="failure-tips">
          <i class="el-icon-warning"/>导入失败
        </div>
        <div class="failure-reason">
          <h4>失败原因</h4>
          <li v-for="(error,index) in errorResults" :key="index">{{ error }}</li>
        </div>
      </div>
    </el-dialog>

  </div>
</template>
<script>
import {
  api, exportExcelByObj
} from '@/api/hr/common'
import { getToken } from '@/utils/auth'

import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      salaryPayrollList: [],
      errorResults: [],
      processing: false,
      uploadTip: '点击上传',
      importFlag: 1,
      importHeaders: {
        enctype: 'multipart/form-data',
        token: getToken()
      },
      fileList: [],
      importUrl: process.env.BASE_API + 'springcloud-hr/hr/SalaryWelfareManagement/importPayroll',
      dialogImportVisible: false,
      total: 0,
      listLoading: false,
      listQuery: {
        page: 1,
        rows: 10,
        name: ''
      },
      code: {
        groupCode: 'platform_type',
        moduleCode: 'springcloud-hr',
        parentGroupCode: 'salaryIssue'
      }
    }
  },
  watch: {
    'listQuery.name': function() {
      this.listQuery.page = 1
      this.initList()
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    // 文件上传
    handlePreview(file) {

    },
    handleRemove(file, fileList) {

    },
    beforeUpload(file) {
      // 上传前配置
      const excelfileExtend = '.xls,.xlsx'// 设置文件格式
      const fileExtend = file.name.substring(file.name.lastIndexOf('.')).toLowerCase()
      if (excelfileExtend.indexOf(fileExtend) <= -1) {
        this.$message.error('文件格式错误')
        return false
      }
      this.uploadTip = '正在处理中...'
      this.processing = true
    },
    uploadFail(err, file, fileList) {
      this.uploadTip = '点击上传'
      this.processing = false
      this.$message.error(err)
    },
    uploadSuccess(response, file, fileList) {
      this.uploadTip = '点击上传'
      this.processing = false
      if (response.code === '0000') {
        if (response.data === '导入成功') {
          this.importFlag = 3
          this.dialogImportVisible = false
          this.$message.info(response.data)
          this.initList()
        } else {
          this.importFlag = 2
          if (response.data) {
            this.errorResults = response.data.split(';')
          } else {
            this.errorResults.push(response.result)
          }
          this.initList()
        }
      } else {
        this.dialogImportVisible = false
        this.$message.error(response.result)
      }
      this.fileList = []
    },
    importExcel() {
      this.importFlag = 1
      this.fileList = []
      this.uploadTip = '点击上传'
      this.processing = false
      this.dialogImportVisible = true
    },
    getEndtime() {},

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
    // 初始化
    initList() {
      this.listLoading = true
      api('hr/SalaryWelfareManagement/paginationInquirePayroll', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.salaryPayrollList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result == null ? '查询失败' : res.data.result)
        }
        this.listLoading = false
      })
    },
    handleExport() {
      const param = {}
      if (this.listQuery.name !== '') {
        param.name = this.listQuery.name
      }
      exportExcelByObj('hr/SalaryWelfareManagement/exportPayroll', param).then(res => {
        window.location.href = res.request.responseURL
      })
    }
  }
}
</script>
<style lang="scss">

</style>

<style scoped>
  .hide-dialog {
    display: none;
  }

  .download-template {
    margin-top: 20px;
  }
  .download-template a:hover{
    color:red
  }
  .failure-reason h4{
    margin: 10px 0;
    line-height:20px;
    font-size:14px;
    color:red;

  }
  .failure-reason ul{
    padding:0 0;
    margin: 0 0;
  }

  .failure-reason ul li {
    color: red;
    line-height:20px;
  }

</style>

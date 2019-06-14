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
      <el-table-column type="index" width="50" label="序号" align="center" />
      <el-table-column label="姓名" header-align="center" align="center" prop="name"/>
      <el-table-column label="工资档次及金额" align="center" prop="basicWage"/>
      <el-table-column label="园区工龄工资" align="center" prop="seniorityWage"/>
      <el-table-column label="技术岗位津贴" align="center" prop="technicalAllowance"/>
      <el-table-column label="职务津贴" align="center" prop="dutyAllowance"/>
      <el-table-column label="工作性津贴" align="center" prop="workSubsidy" />
      <el-table-column label="学历津贴" align="center" prop="educationAllowance" />
      <el-table-column label="职称津贴" align="center" prop="professionalTitleAllowance" />
      <el-table-column label="专项补贴" align="center" prop="specialSubsidy"/>
      <el-table-column label="餐补" align="center" prop="mealSubsidy"/>
      <el-table-column label="应发工资" align="center" prop="deserveWage" />
      <el-table-column label="代扣社会统筹保险" align="center" prop="pendingSocialpoolingInsurance"/>
      <el-table-column label="代扣公积金" align="center" prop="pendingProvidentfund" />
      <el-table-column label="扣个税" align="center" prop="pendingPersonalTax"/>
      <el-table-column label="食堂餐费" align="center" prop="canteenMealFee" />
      <el-table-column label="工会会费" align="center" prop="unionFee" />
      <el-table-column label="实发工资" align="center" prop="realWage" />
      <el-table-column label="存入个人帐户" align="center" prop="accountEntryTime" />
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
        rows: 10
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
      const param = {
        name: this.listQuery.name
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

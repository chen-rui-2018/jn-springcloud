<template>
  <div v-loading="listLoading" class="salarymanagementList">
    <el-form :inline="true" class="filter-bar">
      <el-button
        class="filter-item"
        type="primary"
        icon="el-icon-circle-plus-outline"
        @click="handleCreate">新增
      </el-button>
      <el-button class="filter-item" type="primary" @click="handleExport">导出</el-button>
      <el-button class="filter-item" type="primary" @click="importExcel">导入</el-button>

    </el-form>
    <el-form :inline="true" :model="listQuery" class="filter-bar" style="margin-top: 10px;">
      <el-form-item label="姓名:">
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
      <el-form-item label="入职时间:" style="margin-left: 30px;" >
        <el-date-picker
          v-model="listQuery.entryDate"
          value-format="yyyy-MM-dd"
          type="date"
          placeholder=""/>
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="salarymanagementList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column :show-overflow-tooltip="true" label="姓名" align="center" prop="name" />
      <el-table-column :show-overflow-tooltip="true" label="部门" align="center" prop="departmentName"/>
      <el-table-column :show-overflow-tooltip="true" label="职位" align="center" prop="jobName"/>
      <el-table-column :show-overflow-tooltip="true" label="职级" align="center" prop="rankName"/>
      <el-table-column :show-overflow-tooltip="true" label="联系电话" align="center" prop="phone" />
      <el-table-column :show-overflow-tooltip="true" label="身份证号" width="120" align="center" prop="certificateNumber"/>
      <el-table-column :show-overflow-tooltip="true" label="入职时间" align="center" prop="entryDate" />
      <el-table-column :show-overflow-tooltip="true" label="试用工资" align="center" prop="probationWage" />
      <el-table-column :show-overflow-tooltip="true" label="转正工资" align="center" prop="conversionWage" />
      <el-table-column :show-overflow-tooltip="true" label="当前工资" align="center" prop="currentWage" />
      <el-table-column label="操作" align="center" min-width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" @click="updatesalarymanagement(scope.row)">修改</el-button>
          <el-button type="text" @click="viewsalarymanagement(scope.row)">详情</el-button>
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

    <el-dialog
      :visible.sync="dialogImportVisible"
      :modal-append-to-body="false"
      :close-on-click-modal="false"
      title="薪资导入"
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
          <a class="btn-download" href="/static/file/薪资导入模板.xlsx">
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
  api, downloadTempExcel, exportExcelByObj, systemApi
} from '@/api/hr/common'
import { setChild } from '@/api/hr/util'
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
      salarymanagementList: [],
      departmentListLoading: false,
      errorResults: [],
      departmentList: [],
      departmentIdS: [],
      processing: false,
      uploadTip: '点击上传',
      importFlag: 1,
      importHeaders: {
        enctype: 'multipart/form-data',
        token: getToken()
      },
      fileList: [],
      importUrl: process.env.BASE_API + 'springcloud-hr/hr/SalaryWelfareManagement/importSalaryInfo',
      dialogImportVisible: false,
      total: 0,
      listLoading: false,
      listQuery: {
        entryDate: '',
        page: 1,
        rows: 10,
        name: '',
        departmentId: ''
      },
      code: {
        groupCode: 'platform_type',
        moduleCode: 'springcloud-hr',
        parentGroupCode: 'salarymanagement'
      }
    }
  },
  watch: {
    'listQuery.entryDate': function() {
      this.listQuery.page = 1
      this.initList()
    },
    'listQuery.name': function() {
      this.listQuery.page = 1
      this.initList()
    },
    'listQuery.departmentId': function() {
      this.listQuery.page = 1
      this.initList()
    }
  },
  mounted() {
    this.initList()
    this.getAllDepartment()
    // this.getDepartmentList()
  },
  methods: {
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
          const nodes = []
          setChild(nodes, res.data.data)
          console.log(JSON.stringify(nodes))
        } else {
          this.$message.error(res.data.result)
        }
        this.departmentListLoading = false
      })
    },
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
    // 修改
    updatesalarymanagement(row) {
      this.$router.push({ name: 'salarymanagement-edit', query: { title: '修改', row: row }})
    },
    viewsalarymanagement(row) {
      this.$router.push({ name: 'salarymanagement-view', query: { title: '查看', row: row }})
    },
    // 点击新增按钮的时候
    handleCreate() {
      this.$router.push({ name: 'salarymanagement-add', query: { title: '新增薪资' }})
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
    // 初始化
    initList() {
      this.listLoading = true
      api('hr/SalaryWelfareManagement/paginationInquireSalaryInfo', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.salarymanagementList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result == null ? '查询失败' : res.data.result)
        }
        this.listLoading = false
      })
    },
    downloadExcelTemplate() {
      downloadTempExcel('hr/SalaryManagement/downLoadSalaryInfoExcelTemplate').then(res => {
        window.location.href = res.request.responseURL
      })
    },
    handleExport() {
      exportExcelByObj('hr/SalaryWelfareManagement/exportSalarInfo', this.listQuery).then(res => {
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

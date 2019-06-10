<template>
  <div class="employeeBasicInfoList">

    <el-container>
      <el-aside width="200px">
        <el-tree v-loading="departmentListLoading" :highlight-current="true" :data="departmentList" :expand-on-click-node="false" :props="defaultProps" default-expand-all @node-click="handleNodeClick"/>
      </el-aside>
      <el-main>

        <el-form :model="listQuery" :inline="true" class="info-form">
          <el-form-item label="姓名:" label-width="54px">
            <el-input
              v-model="listQuery.name"
              maxlength="20"
              placeholder=""
              class="filter-item"
              clearable
              @keyup.enter.native="handleFilter"/>
          </el-form-item>

          <el-form-item label="职级">
            <el-select v-model="listQuery.jobId" placeholder="请选择" clearable style="width: 150px" class="filter-item">
              <el-option label="请选择" value=""/>
              <el-option v-for="item in jobList" :key="item.key" :label="item.lable" :value="item.key"/>
            </el-select>
          </el-form-item>

          <el-form-item label="员工类型">
            <el-select
              v-model="listQuery.employeeType"
              placeholder="请选择"
              clearable
              style="width: 150px"
              class="filter-item">
              <el-option label="请选择" value=""/>
              <el-option label="正式" value="1"/>
              <el-option label="实习生" value="2"/>
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button
              class="filter-item"
              type="primary"
              style="margin-left:10px;"
              @click="add">新增
            </el-button>
            <el-button class="filter-item" type="primary" @click="exportExcel">导出</el-button>

            <el-dropdown @command="handleCommand">
              <span class="el-dropdown-link">
                <el-button type="primary">
                  导入<i class="el-icon-arrow-down el-icon--right"/>
                </el-button>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="importExcelBaseInfo" >导入员工基本信息</el-dropdown-item>
                <el-dropdown-item command="importExcelWork" >导入工作经历</el-dropdown-item>
                <el-dropdown-item command="importExcelEducation" >导入教育经历</el-dropdown-item>
                <el-dropdown-item command="importExcelSecurity" >导入社保福利</el-dropdown-item>
                <el-dropdown-item command="importExcelLeader" >导入直属领导</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>

            <el-button class="filter-item" type="primary" @click="handleFilter">查询</el-button>
          </el-form-item>

        </el-form>

        <el-table
          v-loading="listLoading"
          ref="multipleTable"
          :data="employeeBasicInfoList"
          border
          fit
          highlight-current-row
          style="width: 100%;">
          <el-table-column type="index" width="60" label="序号" align="center"/>
          <el-table-column label="工号" align="center" prop="jobNumber"/>
          <el-table-column label="姓名" align="center" prop="name"/>
          <el-table-column label="员工状态" align="center" prop="employStatusStr"/>
          <el-table-column label="性别" align="center" prop="sexStr"/>
          <el-table-column label="职级" align="center" prop="jobName"/>
          <el-table-column label="岗位" align="center" prop="postName"/>
          <el-table-column label="联系电话" align="center" prop="phone"/>
          <el-table-column label="员工类型" align="center" prop="employeeTypeStr"/>
          <el-table-column label="操作" align="center" min-width="100" width="200" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button type="text" @click="update(scope.row)">编辑</el-button>
              <el-button type="text" @click="deleteFile(scope.row)">删除</el-button>
              <el-button type="text" @click="queryDetail(scope.row)">详情</el-button>
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
          @current-change="handleCurrentChange"/>
      </el-main>
    </el-container>

    <file-upload
      :title="importTitle"
      :import-url="importUrl"
      :dialog-visible="dialogImportVisible"
      :template-path="templatePath"
      :limit="1"
      @uploadSuccess="uploadSuccess"
      @closeDialog="dialogImportVisible=false"/>

  </div>

</template>

<script>
import {
  list,
  deleteEmployeeBasicInfo, exportEmployeeBasicInfo

} from '@/api/hr/employeeBasicInfo'
import { getToken } from '@/utils/auth'
import {
  getCode, isvalidName
} from '@/api/hr/util'

import FileUpload from '@/views/hr/employee/fileUpload'
import {
  api
} from '@/api/axios'

export default {
  components: {
    FileUpload
  },
  data() {
    var checkName = (rule, value, callback) => {
      if (!isvalidName(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }
    return {
      departmentListLoading: false,

      currentDepartmentIds: undefined,
      departmentList: undefined,
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      jobList: [],
      errorResults: [],
      processing: false,
      uploadTip: '点击上传',
      importFlag: 1,
      importHeaders: {
        enctype: 'multipart/form-data',
        token: getToken()
      },
      importTitle: '',
      importUrl: '',
      templatePath: '',
      importBaseInfoTitle: '员工基本信息导入',
      importBaseInfoUrl: process.env.BASE_API + 'springcloud-hr/hr/employeeBasicInfo/importEmployeeBasicInfo',
      baseInfoTemplatePath: '/static/file/员工花名册模板.xlsx',
      importEducationTitle: '教育经历导入',
      importEducationUrl: process.env.BASE_API + 'springcloud-hr/hr/employeeBasicInfo/importEducationExperience',
      educationTemplatePath: '/static/file/教育经历模板.xlsx',
      importWorkTitle: '工作经历导入',
      importWorkUrl: process.env.BASE_API + 'springcloud-hr/hr/employeeBasicInfo/importWorkExperience',
      workTemplatePath: '/static/file/工作经历模板.xlsx',
      importLeaderTitle: '直属领导导入',
      importLeaderUrl: process.env.BASE_API + 'springcloud-hr/hr/employeeBasicInfo/importDirectlyLeader',
      leaderTemplatePath: '/static/file/直属领导模板.xlsx',
      importSecurityTitle: '社保福利导入',
      importSecurityUrl: process.env.BASE_API + 'springcloud-hr/hr/employeeBasicInfo/importSocialSecurity',
      securityTemplatePath: '/static/file/社保福利模板.xlsx',
      fileList: [],
      dialogImportVisible: false,
      employeeBasicInfoList: [],
      menuVisible: false,
      rules: {
        departmentName: [{ required: true, message: '请输入分类名称', trigger: 'blur' }, {
          validator: checkName,
          trigger: 'blur'
        }]
      },
      isDisabled: false,
      listLoading: false,
      listQuery: {
        employeeType: '',
        page: 1,
        rows: 10,
        name: '',
        jobId: '',
        departmentId: ''
      },
      total: 0
    }
  },
  mounted() {
    this.initList()
    this.initJobList()
    this.getAllDepartment()
  },
  methods: {
    getAllDepartment() {
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
    handleNodeClick(data) {
      this.listQuery.page = 1
      this.listQuery.departmentId = data.value
      this.initList()
    },
    initJobList() {
      getCode({ 'groupCode': 'job', 'parentGroupCode': 'employee', 'moduleCode': 'springcloud_hr' }).then(res => {
        if (res.data.code === '0000') {
          this.jobList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    uploadSuccess(response, file, fileList) {
      this.$message({
        message: '导入成功',
        type: 'success'
      })
      this.dialogImportVisible = false
      if (this.importTitle === '员工基本信息导入') {
        this.initList()
      }
    },
    handleCommand(command) {
      if (command === 'importExcelBaseInfo') {
        this.importExcelBaseInfo()
      } else if (command === 'importExcelWork') {
        this.importExcelWork()
      } else if (command === 'importExcelEducation') {
        this.importExcelEducation()
      } else if (command === 'importExcelSecurity') {
        this.importExcelSecurity()
      } else {
        this.importExcelLeader()
      }
    },
    importExcelBaseInfo() {
      this.dialogImportVisible = true
      this.importTitle = this.importBaseInfoTitle
      this.importUrl = this.importBaseInfoUrl
      this.templatePath = this.baseInfoTemplatePath
    },
    importExcelWork() {
      this.dialogImportVisible = true
      this.importTitle = this.importWorkTitle
      this.importUrl = this.importWorkUrl
      this.templatePath = this.workTemplatePath
    },
    importExcelEducation() {
      this.dialogImportVisible = true
      this.importTitle = this.importEducationTitle
      this.importUrl = this.importEducationUrl
      this.templatePath = this.educationTemplatePath
    },
    importExcelSecurity() {
      this.dialogImportVisible = true
      this.importTitle = this.importSecurityTitle
      this.importUrl = this.importSecurityUrl
      this.templatePath = this.securityTemplatePath
    },
    importExcelLeader() {
      this.dialogImportVisible = true
      this.importTitle = this.importLeaderTitle
      this.importUrl = this.importLeaderUrl
      this.templatePath = this.leaderTemplatePath
    },
    add() {
      this.$router.push({ name: 'employeeBasicInfoAdd', query: { title: '新增员工花名册' }})
    },
    exportExcel() {
      if (!this.listQuery.departmentId) {
        this.listQuery.departmentId = ''
      }
      exportEmployeeBasicInfo(this.listQuery).then(res => {
        console.log('导出。。。')
        window.location.href = res.request.responseURL
      })
    },
    update(row) {
      this.$router.push({ name: 'employeeBasicInfoUpdate', query: { id: row.id, title: '编辑员工花名册' }})
    },
    deleteFile(row) {
      console.log('删除' + row)
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteEmployeeBasicInfo(row.id).then(res => {
          if (res.data.code === '0000') {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            if (this.listQuery.page > 1 && this.total % this.listQuery.rows === 1) {
              this.listQuery.page = this.listQuery.page - 1
            }
            this.initList()
          } else {
            this.$message.error(res.data.result)
          }
        })
      })
    },
    queryDetail(row) {
      this.$router.push({ name: 'employeeBasicInfoDetail', query: { title: '员工花名册详情', id: row.id }})
    },
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    queryAttachDetail(row) {
      this.$router.push({ name: 'attachmentList', query: { fileId: row.fileId, titleName: row.titleName }})
    },
    initList() {
      console.log('查询员工花名册。。。')
      this.listLoading = true
      if (!this.listQuery.departmentId) {
        this.listQuery.departmentId = ''
      }
      list(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.employeeBasicInfoList = res.data.data.rows
          this.total = res.data.data.total
          if (this.employeeBasicInfoList.length === 0 && this.total > 0) {
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

<style scoped>
  .hide-dialog {
    display: none;
  }

  .el-table .cell {
    white-space: pre-line;
  }

  .download-template {
    margin-top: 20px;

  }

  .failure-reason li {
    color: red
  }

  .el-pagination {
    margin-top: 15px;
  }

  .menu-div {
    margin: 0 0;
    width: 100px;
    height: 110px;
    padding: 0px 0px;
    border: 1px solid #999999;
    border-radius: 5px;
    background-color: #f4f4f4;
    position: absolute;
    z-index: 999;
  }

  .menu-div ul {
    padding: 0 0;
  }

  .menu__item {
    display: block;
    line-height: 30px;
    height: 30px;
    text-align: center;
  }

  li:hover {
    background-color: #1790ff;
    color: white;
  }
   .tree-search{
     width: 200px;
     height: 40px;
     margin-top: 20px;
  }
</style>

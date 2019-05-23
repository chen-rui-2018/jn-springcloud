<template>
  <div class="employeeBasicInfoList">


    <el-container>
      <el-aside width="200px">
        <div class="tree-search">
          <el-button style="width:200px;" type="primary"  @click="addCard">新增组织</el-button>
        </div>
        <el-tree :data="treeList" :props="defaultProps" @node-click="handleNodeClick" node-key="departmentId"
                 :highlight-current="true" @node-contextmenu="rightClick"
                 style="min-height:613px;margin-top:18px;"></el-tree>
        <div v-show="menuVisible" id="menu-div" class="menu-div">
          <ul id="menu" class="menu">
            <li class="menu__item" @click="addCard()">添加</li>
            <li class="menu__item" @click="updateCard()">编辑</li>
            <li class="menu__item" @click="deleteCard">删除</li>
          </ul>
        </div>

        <template v-if="treeFormVisible">
          <el-dialog :visible.sync="treeFormVisible" title="组织架构" width="450px">
            <el-form ref="treeForm" :rules="rules" :model="treeForm" label-position="right" label-width="130px"
                     style="max-width:400px;margin-left:20px">
              <el-form-item label="部门名称:" prop="departmentName">
                <el-input v-model.trim="treeForm.departmentName" maxlength="200" style="width: 200px"
                          placeholder="请输入花名册分类名称"
                          clearable/>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer" align="center">
              <el-button type="primary" @click="handleTree">保存</el-button>
              <el-button @click="cancelTree">取消</el-button>
            </div>
          </el-dialog>
        </template>


      </el-aside>
      <el-main>

        <el-form :model="listQuery" class="info-form" :inline="true">
          <el-form-item label="姓名:" label-width="54px">
            <el-input v-model="listQuery.name" maxlength="20" placeholder="" class="filter-item"
                      clearable @keyup.enter.native="handleFilter"/>
          </el-form-item>

          <el-form-item label="职级">
            <el-select v-model="listQuery.jobId" placeholder="请选择" clearable style="width: 150px" class="filter-item">
              <el-option label="请选择" value=""/>
              <el-option v-for="item in jobList" :key="item.key" :label="item.lable" :value="item.key"/>
            </el-select>
          </el-form-item>

          <el-form-item label="员工类型">
            <el-select v-model="listQuery.employeeType" placeholder="请选择" clearable style="width: 150px"
                       class="filter-item">
              <el-option label="请选择" value=""/>
              <el-option label="正式" value="1"/>
              <el-option label="实习生" value="2"/>
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button class="filter-item" type="primary"  style="margin-left:10px;"
                       @click="add">新增
            </el-button>
            <el-button class="filter-item" type="primary" @click="exportExcel">导出</el-button>
            
            <el-dropdown  @command="handleCommand">
              <span class="el-dropdown-link">
                <el-button type="primary">
                  导入<i class="el-icon-arrow-down el-icon--right"></i>
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


            <el-button class="filter-item" type="primary"  @click="handleFilter">查询</el-button>
          </el-form-item>

        </el-form>

        <el-table v-loading="listLoading" ref="multipleTable" :data="employeeBasicInfoList" border fit
                  highlight-current-row
                  style="width: 100%;">
          <el-table-column type="index" width="60" label="序号" align="center"/>
          <el-table-column label="工号" align="center" prop="jobNumber"/>
          <el-table-column label="姓名" align="center" prop="name"/>
          <el-table-column label="员工状态" align="center" prop="employStatusStr"/>
          <el-table-column label="性别" align="center" prop="sexStr"/>
          <el-table-column label="职位" align="center" prop="jobName"/>
          <el-table-column label="职级" align="center" prop="postName"/>
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

    <file-upload :title="importTitle" :importUrl="importUrl" :dialogVisible="dialogImportVisible"
                 :templatePath="templatePath" :limit="1"
                 @uploadSuccess="uploadSuccess" @closeDialog="dialogImportVisible=false"/>


  </div>


</template>


<script>
  import {
    addEmployeeDepartment, updateEmployeeDepartment, deleteEmployeeDepartment, getTreeList, list,
    deleteEmployeeBasicInfo, importEmployeeBasicInfo, exportEmployeeBasicInfo

  } from '@/api/hr/employeeBasicInfo'
  import {getToken} from '@/utils/auth'
  import {
    getCode, isvalidName
  } from '@/api/hr/util'

  import FileUpload from '@/views/hr/employee/fileUpload'

  export default {
    data() {
      var checkName = (rule, value, callback) => {
        if (!isvalidName(value)) {
          callback(new Error('名称只允许数字、中文、字母及下划线'))
        } else {
          callback()
        }
      }
      return {
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
        defaultProps: {
          label: 'departmentName',
          children: 'children'
        },
        menuVisible: false,
        treeSelectNode: {},
        treeSelect: {
          departmentId: '',
          departmentName: '',
        },
        treeForm: {
          departmentId: '',
          departmentName: '',
        },
        rules: {
          departmentName: [{required: true, message: '请输入分类名称', trigger: 'blur'}, {
            validator: checkName,
            trigger: 'blur'
          }],
        },
        treeFormVisible: false,
        treeList: [],
        isDisabled: false,
        listLoading: false,
        listQuery: {
          employeeType: '',
          page: 1,
          rows: 10,
          name: '',
          jobId: ''
        },
        total: 0,
      }
    },
    components: {
      FileUpload
    },
    mounted() {
      this.initList()
      this.initTree()
      this.initJobList()
    },
    methods: {
      initJobList() {
        getCode({'groupCode': 'job', 'parentGroupCode': 'employee', 'moduleCode': 'springcloud_hr'}).then(res => {
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
        this.dialogImportVisible=false
        if(this.importTitle==='员工基本信息导入'){
          this.initList()
        }

      },
      handleCommand(command){
        if(command==='importExcelBaseInfo'){
          this.importExcelBaseInfo()
        }else if(command==='importExcelWork'){
          this.importExcelWork()
        }else if(command==='importExcelEducation'){
          this.importExcelEducation()
        }else if(command==='importExcelSecurity'){
          this.importExcelSecurity()
        }else{
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
        this.$router.push({name: 'employeeBasicInfoAdd', query: {title: '新增员工花名册'}})
      },
      exportExcel() {
        exportEmployeeBasicInfo(this.listQuery).then(res => {
          console.log("导出。。。")
          window.location.href = res.request.responseURL
        })
      },
      update(row) {
        this.$router.push({name: 'employeeBasicInfoUpdate', query: {id: row.id, title: '编辑员工花名册'}})
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
        this.$router.push({name: 'employeeBasicInfoDetail', query: {title: '员工花名册详情', id: row.id}})
      },
      handleFilter() {
        this.listQuery.page = 1
        this.initList()
      },
      queryAttachDetail(row) {
        this.$router.push({name: 'attachmentList', query: {fileId: row.fileId, titleName: row.titleName}})
      },
      initTree() {
        getTreeList().then(res => {
          if (res.data.code === '0000') {
            this.treeList = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
      },
      handleNodeClick(data) {
        this.listQuery.departmentId = data.departmentId
        this.treeForm.departmentId = data.departmentId
        this.treeForm.departmentName = data.departmentName
        this.initList()
      },
      rightClick(MouseEvent, data, Node, element) {
        this.menuVisible = false
        this.menuVisible = true
        this.treeSelect = data
        this.treeSelectNode = Node
        var menu = document.querySelector('#menu-div')
        menu.style.left = MouseEvent.clientX - 200 + 'px'
        document.addEventListener('click', this.closeTree)
        menu.style.top = MouseEvent.clientY - 80 + 'px'
        console.log('右键被点击的data:', data)
      },
      closeTree() {
        this.menuVisible = false
      },
      addCard() {
        this.treeFormVisible = true
        this.treeForm.departmentId = ''
        this.treeForm.departmentName = ''
      },
      updateCard() {
        this.treeFormVisible = true
        this.treeForm.departmentId = this.treeSelect.departmentId
        this.treeForm.departmentName = this.treeSelect.departmentName
      },
      deleteCard() {
        this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteEmployeeDepartment(this.treeSelect.departmentId).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              this.initTree()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
      },
      handleTree() {
        this.treeForm.departmentId != '' ? this.updateTree() : this.saveTree()
      },
      saveTree() {
        console.log('保存树')
        this.$refs['treeForm'].validate(valid => {
          if (valid) {
            addEmployeeDepartment(this.treeForm).then(
              res => {
                if (res.data.code === '0000') {
                  this.$message.success("保存成功")
                } else {
                  this.$message.error(res.data.result)
                }
                this.$refs['treeForm'].resetFields()
                this.treeFormVisible = false
                this.initTree()
              }
            )
          }
        })
      },
      updateTree() {
        this.$refs['treeForm'].validate(valid => {
          if (valid) {
            updateEmployeeDepartment(this.treeForm).then(
              res => {
                if (res.data.code === '0000') {
                  this.$message.success("保存成功")
                } else {
                  this.$message.error(res.data.result)
                }
                this.$refs['treeForm'].resetFields()
                this.treeFormVisible = false
                this.initTree()
              }
            )
          }
        })
      },
      cancelTree() {
        this.treeFormVisible = false
      },
      initList() {
        console.log('查询员工花名册。。。')
        this.listLoading = true
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

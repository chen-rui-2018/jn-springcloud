<template>
  <div class="employeeFileList">

    <el-container>
      <el-aside width="200px">
        <div class="tree-search">
          <el-input v-model="treeNodeName" placeholder="搜索名称" style="margin-bottom:10px;" suffix-icon="el-icon-search"/>
          <el-button type="primary" style="width:200px;" @click="addCardParent()">添加一级员工档案分类</el-button>
        </div>
        <el-tree
          ref="tree"
          :data="treeList"
          :props="defaultProps"
          :highlight-current="true"
          :filter-node-method="filterNode"
          node-key="id"
          style="min-height:613px;"
          @node-click="handleNodeClick"
          @node-contextmenu="rightClick"/>
        <div v-show="menuVisible" id="menu-div" class="menu-div">
          <ul id="menu" class="menu">
            <li class="menu__item" @click="addCard('1')">平级添加</li>
            <li class="menu__item" @click="addCard('2')">下级添加</li>
            <li class="menu__item" @click="updateCard()">编辑</li>
            <li class="menu__item" @click="deleteCard">删除</li>
          </ul>
        </div>

        <template v-if="treeFormVisible">
          <el-dialog :visible.sync="treeFormVisible" title="员工档案分类" width="450px">
            <el-form
              ref="treeForm"
              :rules="rules"
              :model="treeForm"
              label-position="right"
              label-width="130px"
              style="max-width:400px;margin-left:20px">
              <el-form-item label="档案分类名称:" prop="nodeName">
                <el-input
                  v-model.trim="treeForm.nodeName"
                  maxlength="200"
                  style="width: 200px"
                  placeholder="请输入档案分类名称"
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

        <el-form :model="listQuery" :inline="true" class="info-form">
          <el-form-item label="档号:" label-width="54px">
            <el-input
              v-model="listQuery.fileId"
              maxlength="20"
              placeholder=""
              class="filter-item"
              clearable
              @keyup.enter.native="handleFilter"/>
          </el-form-item>
          <el-form-item label="题名:" label-width="54px">
            <el-input
              v-model="listQuery.titleName"
              maxlength="20"
              placeholder=""
              class="filter-item"
              clearable
              @keyup.enter.native="handleFilter"/>
          </el-form-item>

          <el-form-item>
            <el-button
              class="filter-item"
              type="primary"
              style="margin-left:10px;"
              @click="add">新增
            </el-button>
            <el-button class="filter-item" type="primary" @click="exportExcel">导出</el-button>
            <el-button class="filter-item" type="primary" @click="importExcel">导入</el-button>
            <el-button class="filter-item" type="primary" @click="handleFilter">查询</el-button>
          </el-form-item>

        </el-form>

        <el-table
          v-loading="listLoading"
          ref="multipleTable"
          :data="employeeFileList"
          border
          fit
          highlight-current-row
          style="width: 100%;">
          <el-table-column type="index" width="60" label="序号" align="center"/>
          <el-table-column label="档号" align="center" prop="fileId"/>
          <el-table-column label="文号" align="center" prop="symbol"/>
          <el-table-column label="题名" align="center" prop="titleName"/>
          <el-table-column label="备注" align="center" prop="remark"/>
          <el-table-column label="创建日期" align="center" prop="createdTime"/>
          <el-table-column label="责任人" align="center" prop="personLiable"/>
          <el-table-column label="附件管理" align="center" prop="resumeInfo">
            <template slot-scope="scope">
              <el-button type="text" @click="queryAttachDetail(scope.row)">明细
              </el-button>
            </template>
          </el-table-column>
          <el-table-column label="操作" align="center" min-width="100" width="200" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button type="text" @click="update(scope.row)">编辑</el-button>
              <el-button type="text" @click="deleteFile(scope.row)">删除</el-button>
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
      :title="'员工档案导入'"
      :import-url="importUrl"
      :dialog-visible="dialogImportVisible"
      :template-path="'/static/file/员工档案模板.xlsx'"
      :limit="1"
      @uploadSuccess="uploadSuccess"
      @closeDialog="dialogImportVisible=false"/>
  </div>

</template>

<script>
import {
  addEmployeeFileClass, updateEmployeeFileClass, deleteEmployeeFileClass, getTreeList, list,
  deleteEmployeeFile, exportEmployeeFile

} from '@/api/hr/employeeFile'
// import { getToken } from '@/utils/auth'
import {
  isvalidName
} from '@/api/hr/util'
import FileUpload from '@/views/hr/employee/fileUpload'

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
      importUrl: process.env.BASE_API + 'springcloud-hr/hr/employeeFile/importEmployeeFile',
      dialogImportVisible: false,
      employeeFileList: [],
      defaultProps: {
        label: 'label',
        children: 'children'
      },
      menuVisible: false,
      treeSelect: {
        id: '',
        parentId: '',
        label: '',
        level: ''
      },
      treeForm: {
        classId: '',
        parentId: '',
        nodeName: '',
        level: ''
      },
      rules: {
        nodeName: [{ required: true, message: '请输入分类名称', trigger: 'blur' }, { validator: checkName, trigger: 'blur' }]
      },
      treeFormVisible: false,
      treeList: [],
      isDisabled: false,
      listLoading: false,
      listQuery: {
        fileId: '',
        page: 1,
        rows: 10,
        titleName: '',
        classId: ''
      },
      total: 0,
      treeNodeName: ''
    }
  },
  watch: {
    treeNodeName(val) {
      this.$refs.tree.filter(val)
    }
  },
  mounted() {
    this.initList()
    this.initTree()
  },
  methods: {
    uploadSuccess() {
      this.$message({
        message: '导入成功',
        type: 'success'
      })
      this.dialogImportVisible = false
      this.initList()
    },
    importExcel() {
      this.dialogImportVisible = true
    },
    add() {
      if (this.treeForm.classId === '') {
        this.$message({
          message: '请先选择档案分类',
          type: 'error'
        })
        return
      }
      this.$router.push({ name: 'employeeFileAdd', query: { title: '新增员工档案', nodeName: this.treeForm.nodeName,
        classId: this.treeForm.classId }})
    },
    exportExcel() {
      exportEmployeeFile(this.listQuery).then(res => {
        console.log('导出。。。')
        window.location.href = res.request.responseURL
      })
    },
    update(row) {
      this.$router.push({ name: 'employeeFileAdd', query: { fileId: row.fileId, title: '编辑员工档案' }})
    },
    deleteFile(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteEmployeeFile(row.fileId).then(res => {
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
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    queryAttachDetail(row) {
      this.$router.push({ name: 'attachmentList', query: { fileId: row.fileId, titleName: row.titleName }})
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
    filterNode(value, data) {
      if (!value) return true
      return data.label.indexOf(value) !== -1
    },
    handleNodeClick(data) {
      this.listQuery.classId = data.id
      this.treeForm.classId = data.id
      this.treeForm.nodeName = data.label
      this.initList()
    },
    rightClick(MouseEvent, data, Node, element) {
      this.menuVisible = false
      this.menuVisible = true
      this.treeSelect = data
      var menu = document.querySelector('#menu-div')
      menu.style.left = MouseEvent.clientX - 200 + 'px'
      document.addEventListener('click', this.closeTree)
      menu.style.top = MouseEvent.clientY - 80 + 'px'
      console.log('右键被点击的data:', data)
    },
    closeTree() {
      this.menuVisible = false
    },
    addCardParent() {
      this.treeFormVisible = true
      this.treeForm.level = 1
      this.treeForm.parentId = '0'
      this.treeForm.classId = ''
      this.treeForm.nodeName = ''
    },
    addCard(type) {
      this.treeFormVisible = true
      if (type === '1') {
        // 平级添加
        this.treeForm.level = this.treeSelect.level
        this.treeForm.parentId = this.treeSelect.parentId
      } else {
        // 下级添加
        this.treeForm.level = parseInt(this.treeSelect.level) + 1
        this.treeForm.parentId = this.treeSelect.id
      }
      this.treeForm.classId = ''
      this.treeForm.nodeName = ''
    },
    updateCard() {
      this.treeFormVisible = true
      this.treeForm.level = this.treeSelect.level
      this.treeForm.parentId = this.treeSelect.parentId
      this.treeForm.classId = this.treeSelect.id
      this.treeForm.nodeName = this.treeSelect.label
    },
    deleteCard() {
      this.$confirm(`此操作将永久删除当前节点,已经当前节点下的所有子节点, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteEmployeeFileClass(this.treeSelect.id).then(res => {
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
      this.treeForm.classId !== '' ? this.updateTree() : this.saveTree()
    },
    saveTree() {
      console.log('保存树')
      this.$refs['treeForm'].validate(valid => {
        if (valid) {
          addEmployeeFileClass(this.treeForm).then(
            res => {
              if (res.data.code === '0000') {
                this.$message.success('保存成功')
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
          updateEmployeeFileClass(this.treeForm).then(
            res => {
              if (res.data.code === '0000') {
                this.$message.success('保存成功')
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
      console.log('查询员工档案。。。')
      this.listLoading = true
      list(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.employeeFileList = res.data.data.rows
          this.total = res.data.data.total
          if (this.employeeFileList.length === 0 && this.total > 0) {
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
  .employeeFileList .tree-search{
    width:200px;
    height:82px;
    margin-bottom:10px;
    margin-top: 20px;
  }

  .el-table .cell {
    white-space: pre-line;
  }

  .el-pagination {
    margin-top: 15px;
  }
  .menu-div{
    margin: 0 0;
    width:130px;
    height:140px;
    padding: 0px 0px;
    border: 1px solid #999999;
    border-radius: 5px;
    background-color: #f4f4f4;
    position: absolute;
    z-index:999;
  }

  .menu-div ul{
    padding: 0 0;
  }

  .menu__item {
    display: block;
    line-height: 30px;
    height:30px;
    text-align: center;
  }

  li:hover {
    background-color: #1790ff;
    color: white;
  }
</style>

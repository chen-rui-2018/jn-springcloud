<template>
  <div v-loading="listLoading" class="moduleMag">
    <div class="filter-container">
      <el-form :inline="true" :model="moduleForm" class="demo-form-inline">
        <el-form-item label="模块编码">
          <el-input v-model="moduleForm.moduleCode" placeholder="请输入内容" clearable style="width: 200px;" @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-form-item label="模块名称">
          <el-input v-model="moduleForm.moduleValue" placeholder="请输入内容" clearable style="width: 200px;" @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
        <el-button type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
        <el-button type="primary" @click="handleBack">返回</el-button>
      </el-form>
    </div>
    <el-table ref="moduleTable" :data="moduleData" highlight-current-row border fit style="width: 100%">
      <el-table-column label="序列" type="index" align="center" width="60"/>
      <el-table-column label="模块编码" prop="moduleCode" align="center" />
      <el-table-column label="模块名称" prop="moduleValue" align="center" />
      <el-table-column label="创建时间" prop="createdTime" align="center" />
      <el-table-column label="操作" prop="operate" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <el-pagination v-show="total>0" :current-page="moduleForm.page" :page-sizes="[10,20,30,50]" :page-size="moduleForm.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <!-- 新增弹框 -->
    <template v-if="moduleDialogFormVisible">
      <el-dialog :visible.sync="moduleDialogFormVisible" :title="dialogStatus" width="450px">
        <el-form ref="moduleform" :rules="rules" :model="moduleform" label-position="right" label-width="100px" style="max-width:350px;margin-left:20px">
          <el-form-item label="模块编码:" prop="moduleCode">
            <el-input v-model.trim="moduleform.moduleCode" maxlength="100" clearable/>
          </el-form-item>
          <el-form-item label="模块名称:" prop="moduleValue">
            <el-input v-model.trim="moduleform.moduleValue" maxlength="50" clearable/>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增模块'?createModuleData():updateData()">保存</el-button>
          <el-button @click="moduleDialogFormVisible = false">取消</el-button>
        </div>
      </el-dialog>
    </template>
  </div>
</template>
<script>
import { api, paramApi } from '@/api/Permission-model/userManagement'
export default {
  data() {
    var check = (rule, value, callback) => {
      const reg = /^[0-9a-zA-Z_]{1,}$/
      if (!reg.test(value)) {
        callback(new Error('只允许输入数字、字母及下划线'))
      } else {
        callback()
      }
    }
    var check1 = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,50}$/
      if (!reg.test(value)) {
        callback(new Error('只允许输入数字、字母及下划线'))
      } else {
        callback()
      }
    }
    return {
      listLoading: false,
      total: 0,
      moduleForm: {
        moduleCode: '',
        moduleValue: '',
        page: 1,
        rows: 10
      },
      // moduleOptions: [],
      moduleData: [],
      moduleDialogFormVisible: false,
      dialogStatus: '',
      isDisabled: false,
      moduleform: {
        id: '',
        moduleCode: '',
        moduleValue: ''
      },
      rules: {
        moduleCode: [
          { required: true, message: '请输入模块编码', trigger: 'blur' },
          { validator: check, trigger: 'blur' }],
        moduleValue: [
          { required: true, message: '请输入模块名称', trigger: 'blur' },
          { validator: check1, trigger: 'blur' }
        ]
      }
    }
  },
  mounted() {
    this.initList()
    // this.getAllModule()
  },
  methods: {
    handleSizeChange(val) {
      this.moduleForm.rows = val
      this.initList()
    },
    handleCurrentChange(val) {
      this.moduleForm.page = val
      this.initList()
    },
    handleFilter() {
      this.moduleForm.page = 1
      this.initList()
    },
    handleCreate() {
      this.moduleform.moduleCode = ''
      this.moduleform.moduleValue = ''
      this.moduleform.id = ''
      this.dialogStatus = '新增模块'
      this.moduleDialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['moduleform'].clearValidate()
      })
    },
    handleBack() {
      this.$router.push({ path: 'dataDictionary' })
    },
    handleUpdate(row) {
      this.moduleDialogFormVisible = true
      this.dialogStatus = '修改模块'
      this.moduleform.moduleCode = row.moduleCode
      this.moduleform.moduleValue = row.moduleValue
      this.moduleform.id = row.id
      this.$nextTick(() => {
        this.$refs['moduleform'].clearValidate()
      })
    },
    handleDelete(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi('system/sysModule/delete', id, 'moduleId').then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.moduleForm.rows === 1) {
                this.moduleForm.page = this.moduleForm.page - 1
              }
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        }).catch(() => {

        })
    },
    initList() {
      api('system/sysModule/list', this.moduleForm).then(res => {
        if (res.data.code === '0000') {
          this.moduleData = res.data.data.rows
          this.total = res.data.data.total
          if (this.moduleData.length === 0 && this.total > 0) {
            this.moduleForm.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    createModuleData() {
      this.isDisabled = true
      this.$refs['moduleform'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api('system/sysModule/add', this.moduleform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            this.moduleDialogFormVisible = false
            this.initList()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    updateData() {
      this.$refs['moduleform'].validate(valid => {
        this.isDisabled = true
        if (valid) {
          api('system/sysModule/update', this.moduleform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            this.moduleDialogFormVisible = false
            this.initList()
          })
        } else {
          this.isDisabled = false
        }
      })
    }
  }
}
</script>
<style lang="scss">

</style>

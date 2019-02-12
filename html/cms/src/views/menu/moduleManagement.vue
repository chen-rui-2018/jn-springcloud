<template>
  <div v-loading="listLoading" class="moduleMag">
    <div class="filter-container">
      <el-form :inline="true" :model="moduleForm" class="demo-form-inline">
        <el-form-item label="模块编码">
          <el-input v-model="moduleForm.moduleCode" placeholder="请输入内容" style="width: 200px;" @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-form-item label="模块名称">
          <el-select v-model="moduleForm.moduleValue" placeholder="请选择" style="width: 200px;">
            <el-option v-for="(item,index) in moduleOptions" :key="index" :label="item.moduleValue" :value="item.moduleValue"/>
          </el-select>
        </el-form-item>
        <el-button type="primary" @click="handleFilter">搜索</el-button>
        <el-button type="primary" @click="handleCreate">添加</el-button>
        <el-button type="primary" @click="handleBack">返回</el-button>
      </el-form>
    </div>
    <el-table ref="moduleTable" :data="moduleData" highlight-current-row border fit style="width: 100%">
      <el-table-column label="序列" type="index" align="center" width="60"/>
      <el-table-column label="模块编码" prop="moduleCode" align="center" />
      <el-table-column label="模块名称" prop="moduleValue" align="center" />
      <el-table-column label="创建时间" prop="createdTime" align="center" >
        <template slot-scope="scope">
          {{ scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}') }}
        </template>
      </el-table-column>
      <el-table-column label="操作" prop="operate" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">修改</el-button>
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
import { getAllModule } from '@/api/Permission-model/dataDictionary'
import { getModuleList, addModule, editModule, deleteModule } from '@/api/Permission-model/moduleManagement'
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
      moduleOptions: [],
      moduleData: [],
      moduleDialogFormVisible: false,
      dialogStatus: '',
      isDisabled: false,
      moduleform: {
        moduleId: '',
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
    this.getAllModule()
  },
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`)
    },
    handleFilter() {
      this.moduleForm.page = 1
      this.initList()
    },
    handleCreate() {
      this.moduleform.moduleCode = ''
      this.moduleform.moduleValue = ''
      this.moduleform.moduleId = ''
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
      this.moduleform.moduleId = row.id
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
          deleteModule(id).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.moduleForm.rows === 1) {
                debugger
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
    // 获取全部模块
    getAllModule() {
      getAllModule().then(res => {
        if (res.data.code === '0000') {
          res.data.data.forEach(val => {
            this.moduleOptions.push({
              value: val.moduleCode,
              label: val.moduleValue
            })
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.moduleOptions = res.data.data
      })
    },
    initList() {
      getModuleList(this.moduleForm).then(res => {
        this.total = res.data.data.total
        this.moduleData = res.data.data.rows
      })
    },
    createModuleData() {
      this.isDisabled = true
      this.$refs['moduleform'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          addModule(this.moduleform).then(res => {
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
        if (valid) {
          this.isDisabled = true
          editModule(this.moduleform).then(res => {
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
        }
      })
    }
  }
}
</script>
<style lang="scss">

</style>

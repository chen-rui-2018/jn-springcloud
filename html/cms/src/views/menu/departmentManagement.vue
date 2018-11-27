<template>
  <div class="departmentManagement">
    <header>部门管理</header>
    <div class="department-left">
      <el-tree v-loading="listLoading" :data="departmentList" :expand-on-click-node="false" :render-content="renderContent" node-key="id" default-expand-all @node-click="handleNodeClick"/>
    </div>
    <!-- 弹出的新增和编辑对话框 -->
    <el-dialog :visible.sync="departmentDialogVisible" :title="dialogStatus" width="400px">
      <el-form ref="departmentForm" :model="departmentForm" label-width="100px">
        <el-form-item label="上级部门">
          <el-input v-model="departmentForm.parentDepartmentName" disabled style="width:200px;" />
        </el-form-item>
        <el-form-item label="部门名称">
          <el-input :rules="rules" v-model="departmentForm.departmentName" style="width:200px;" />
        </el-form-item>
        <el-form-item>
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增部门'?createData():updateData()">保存</el-button>
          <el-button @click="departmentDialogVisible = false">取消</el-button>
        </el-form-item>
      </el-form>

    </el-dialog>

  </div>
</template>

<script>
import {
  getDepartment, updateDepartment, createDepartment, checkDepartmentName, deleteDepartmentById
} from '@/api/Permission-model/departmentManagement'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的角色名称'))
      } else {
        if (this.oldDepartmentName !== this.departmentForm.departmentName) {
          checkDepartmentName(this.departmentForm.departmentName).then(response => {
            const result = response.data.data
            if (result === 'success') {
              callback()
            } else {
              callback(new Error('部门名称已重复'))
            }
          })
        } else {
          callback()
        }
      }
    }
    return {
      isDisabled: false,
      departmentForm: {
        departmentId: undefined,
        departmentName: undefined,
        parentDepartmentName: undefined
      },
      departmentDialogVisible: false,
      dialogStatus: undefined,
      listLoading: false,
      departmentList: [],
      rules: {
        departmentName: [
          { required: true, message: '请输入部门名称', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    handleNodeClick(data, Node) {
      console.log(data, Node)
    },
    renderContent(h, { node, data, store }) {
      return (
        <span style=' align-items: center; font-size: 14px'>
          <span>
            <span>{node.label}</span>
          </span>
          <span style='margin-left:10px'>
            <el-button type='text'on-click={() => this.addDepartment(data)} >新增</el-button>
            <el-button on-click={() => this.editDepartment(data)} type='text'>
              编辑
            </el-button>
            <el-button on-click={() => this.deleteDepartment(data.id)} type='text'>
              删除
            </el-button>
          </span>
        </span>
      )
    },
    // 删除部门功能实现
    deleteDepartment(id) {
      this.$confirm(`此操作将永久删除这个部门及其子部门, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deleteDepartmentById(id).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              this.initList()
            } else {
              this.$message.error('删除失败')
            }
          })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
    // 显示编辑对话框
    editDepartment(data) {
      this.dialogStatus = '编辑部门'
      this.departmentForm.id = data.id
      this.departmentDialogVisible = true
      this.departmentForm.departmentName = data.label
      if (data.parentlabel) {
        this.departmentForm.parentDepartmentName = data.parentlabel
      } else {
        this.departmentForm.parentDepartmentName = '没有上级部门了'
      }
    },
    // 编辑部门功能的实现
    updateData() {
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisabled = false
      }, 500)
      this.$refs['departmentForm'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.roledialogFormVisible = false
          // // 调用接口发送请求
          updateDepartment(this.departmentForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            }
            // 重置表单元素的数据
            this.$refs['departmentForm'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 新增部门功能的实现
    createData() {
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisabled = false
      }, 500)
      this.$refs['departmentForm'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.roledialogFormVisible = false
          // 调用接口发送请求
          createDepartment(this.departmentForm).then(res => {
            console.log(res)
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error('添加数据失败')
            }
            // 重置表单元素的数据
            this.$refs['departmentForm'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 显示新增部门对话框
    addDepartment(data) {
      this.dialogStatus = '新增部门'
      this.departmentDialogVisible = true
      this.departmentForm.departmentName = undefined
      this.$nextTick(() => {
        this.$refs['departmentForm'].clearValidate()
      })
    },
    // 初始化项目
    initList() {
      this.listLoading = true
      getDepartment().then(res => {
        if (res.data.code === '0000') {
          this.departmentList = res.data.data
        } else {
          this.$message.error('获取数据失败')
        }
        this.listLoading = false
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.departmentManagement{
 header{
   margin-bottom: 20px;
 }
.department-left{
  .el-tree{
  padding: 20px;
  }
}
}
</style>

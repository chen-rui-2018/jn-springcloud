<template>
  <div class="departmentManagement">
    <div class="department-left">
      <el-tree v-loading="listLoading" :data="departmentList" :expand-on-click-node="false" default-expand-all node-key="id" @node-click="handleNodeClick">
        <span slot-scope="{ node, data }" class="custom-tree-node">
          <span>
            <i style="margin-right:3px"/>{{ node.label }}
          </span>
          <span style="margin-left:20px">
            <i
              class="el-icon-plus"
              @click="() => addDepartment(data)"/>
            <i
              class="el-icon-edit"
              @click="() => editDepartment( data)"/>
            <i
              class="el-icon-delete"
              @click="() => deleteDepartment( data.id)"/>
          </span>
        </span>
      </el-tree>
      <!-- <el-tree v-loading="listLoading" :data="departmentList" :expand-on-click-node="false" :render-content="renderContent" node-key="id" default-expand-all @node-click="handleNodeClick"/> -->
    </div>
    <!-- 弹出的新增和编辑对话框 -->
    <el-dialog :visible.sync="departmentDialogVisible" :title="dialogStatus" width="400px">
      <el-form ref="departmentForm" :rules="rules" :model="departmentForm" label-width="100px">
        <el-form-item label="上级部门:">
          <el-input v-model="departmentForm.parentDepartmentName" disabled style="width:200px;" />
        </el-form-item>
        <el-form-item v-show="visible" label="新增位置:">
          <el-radio v-model="location" label="1">同级部门</el-radio>
          <el-radio v-model="location" label="0">子部门</el-radio>
        </el-form-item>
        <el-form-item label="部门名称:" prop="departmentName">
          <el-input v-model="departmentForm.departmentName" style="width:200px;" />
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
        callback(new Error('请输入正确的部门名称'))
      } else {
        if (this.oldDepartmentName !== this.departmentForm.departmentName) {
          checkDepartmentName({ departmentName: this.departmentForm.departmentName, parentId: this.departmentForm.parentId }).then(response => {
            const result = response.data.data
            if (result === 'success') {
              callback()
            } else {
              callback(new Error('response.result'))
            }
          })
        } else {
          callback()
        }
      }
    }
    return {
      currentId: undefined,
      visible: false,
      location: '1',
      oldDepartmentName: undefined,
      isDisabled: false,
      departmentForm: {
        parentId: undefined,
        id: undefined,
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
      this.isShow = true
      console.log(data, Node)
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
      this.$nextTick(() => {
        this.$refs['departmentForm'].clearValidate()
      })
      this.visible = false
      console.log(data)
      this.dialogStatus = '编辑部门'
      this.oldDepartmentName = data.label
      this.departmentForm.id = data.id
      this.departmentDialogVisible = true
      this.departmentForm.departmentName = data.label
      if (data.parentName) {
        this.departmentForm.parentDepartmentName = data.parentName
        this.departmentForm.parentId = data.parentId
      } else {
        this.departmentForm.parentDepartmentName = ''
        this.departmentForm.parentId = '1'
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
          this.departmentDialogVisible = false
          console.log(this.departmentForm)
          // // 调用接口发送请求
          updateDepartment(this.departmentForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error('res.result')
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
      if (this.location === '0') {
        this.departmentForm.parentId = this.currentId
      }
      this.$refs['departmentForm'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.departmentDialogVisible = false
          // 调用接口发送请求
          createDepartment(this.departmentForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error('res.result')
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
      console.log(data)
      this.visible = true
      this.dialogStatus = '新增部门'
      this.departmentDialogVisible = true
      this.departmentForm.departmentName = undefined
      this.location = '1'
      if (data.parentName) {
        this.departmentForm.parentDepartmentName = data.parentName
        this.departmentForm.parentId = data.parentId
      } else {
        this.departmentForm.parentDepartmentName = ''
        this.departmentForm.parentId = '1'
      }
      this.currentId = data.id
      console.log(data)
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
.department-left{
  .el-tree{
    width: 30%;
  padding: 20px;
  }
}
 .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
  }
}
</style>

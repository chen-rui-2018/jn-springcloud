<template>
  <div class="departmentManagement">
    <div class="department-left">
      <el-tree v-loading="listLoading" :data="departmentList" :expand-on-click-node="false" default-expand-all node-key="id" @node-click="handleNodeClick">
        <span slot-scope="{ node, data }" class="custom-tree-node">
          <span>
            <i style="margin-right:3px"/>{{ node.label }}
          </span>
          <span style="margin-left:20px;padding-right:18px">
            <i
              class="el-icon-plus"
              @click="() => addDepartment(data)"/>
            <i
              class="el-icon-edit"
              @click="() => editDepartment( data)"/>
            <i
              class="el-icon-delete"
              @click="() => deleteDepartment( data.value)"/>
          </span>
        </span>
      </el-tree>
    </div>
    <div v-show="isData" class="department-right">
      <div v-if="isSubForm">没有子部门</div>
      <div v-show="isDepartmentInfo">
        <div class="department-title">下级部门</div>
        <div class="department-content">
          <span>{{ currentDepartmentName }}</span>
          <el-form ref="subForm" :rules="rules" :model="subForm" label-width="100px">
            <el-form-item
              v-for="(item,index) in subForm.departmentData"
              :key="index"
              :prop="'departmentData.'+index+'.label'"
              :rules="departmentDataRules.label">
              <el-input v-model="item.label" clearable maxlength="20" @blur="checkoutSubName" />
            </el-form-item>
            <el-form-item class="footer">
              <el-button :disabled="isDisabled" type="primary" @click="submitDepartmentInfo('subForm')" >保存</el-button>
              <el-button @click="cencalEdit('subForm')" >取消</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
    <!-- 弹出的新增和编辑对话框 -->
    <template v-if="departmentDialogVisible">
      <el-dialog :visible.sync="departmentDialogVisible" :title="dialogStatus" width="400px">
        <el-form ref="departmentForm" :rules="rules" :model="departmentForm" label-width="100px" @submit.native.prevent>
          <el-form-item v-show="visible" label="新增位置:">
            <el-radio v-model="location" label="1">同级部门</el-radio>
            <el-radio v-model="location" label="0">子部门</el-radio>
          </el-form-item>
          <el-form-item label="部门名称:" prop="departmentName">
            <el-input v-model.trim="departmentForm.departmentName" style="width:200px;" maxlength="20" />
          </el-form-item>
          <el-form-item>
            <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增部门'?createData():updateData()">保存</el-button>
            <el-button @click="departmentDialogVisible = false">取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import {
  getDepartment, updateDepartment, createDepartment, checkDepartmentName, deleteDepartmentById, updateAllMenu, getOldData
} from '@/api/Permission-model/departmentManagement'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.oldDepartmentName !== this.departmentForm.departmentName) {
          checkDepartmentName({ departmentName: this.departmentForm.departmentName, parentId: this.departmentForm.parentId }).then(res => {
            if (res.data.code === '0000') {
              if (res.data.data === 'success') {
                callback()
              } else {
                callback(new Error('部门名称已重复'))
              }
            }
          })
        } else {
          callback()
        }
      }
    }
    var checkLabel = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        var count = 0
        // 循环整个数组 判断有没有重名的字段
        this.subForm.departmentData.forEach((val, index) => {
          if (value === val.label) {
            count = count + 1
          }
        })
        if (count > 1) {
          callback(new Error('部门名称已重复'))
        } else {
          callback()
        }
      }
    }
    return {
      isData: false,
      currentId: undefined,
      isDepartmentInfo: false,
      isSubForm: false,
      subForm: {
        departmentData: []
      },
      currentDepartmentName: undefined,
      checkoutParentId: undefined,
      checkoutId: undefined,
      visible: false,
      location: '1',
      oldDepartmentName: undefined,
      isDisabled: false,
      departmentForm: {
        parentId: undefined,
        id: undefined,
        departmentName: undefined
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
      },
      departmentDataRules: {
        label: [{ required: true, message: '请输入部门名称', trigger: 'blur' }, { validator: checkLabel, trigger: 'blur' }]
      }
    }
  },
  watch: {
    // 监听location
    'location': function() {
      if (this.location === '1') {
        this.departmentForm.parentId = this.checkoutParentId
      } else if (this.location === '0') {
        this.departmentForm.parentId = this.checkoutId
      }
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    // 失去焦点的时候判断子部门的名字是否有重复
    checkoutSubName() {
      const arr = []
      this.subForm.departmentData.forEach(val => {
        arr.push(val.label)
      })
      if ((new Set(arr)).size === arr.length) {
        this.$refs['subForm'].clearValidate()
      }
    },
    cencalEdit(formName) {
      getOldData(this.currentId).then(res => {
        if (res.data.code === '0000') {
          this.subForm.departmentData = res.data.data
          this.$refs['subForm'].clearValidate()
        } else {
          this.$message.error(res.data.result)
        }
        this.initList()
      })
    },
    // 点击保存的时候
    submitDepartmentInfo(formName) {
      const newData = []
      // 对数组进行遍历 得到与后台要求的数据一样
      this.subForm.departmentData.forEach((val) => {
        newData.push({
          id: val.value,
          departmentName: val.label,
          parentId: this.currentId
        })
      })
      this.$refs['subForm'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          // 调用接口发送请求 进行批量更新
          updateAllMenu(newData).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '保存成功',
                type: 'success'
              })
            } else { this.$message.error(res.data.result) }
            this.isDisabled = false
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    handleNodeClick(data) {
      this.isData = true
      this.currentId = data.value
      this.currentDepartmentName = data.label
      if (data.children === null) {
        this.isDepartmentInfo = false
        this.isSubForm = true
      } else {
        this.isSubForm = false
        this.isDepartmentInfo = true
        this.subForm.departmentData = data.children
      }
      const arr = []
      this.subForm.departmentData.forEach(val => {
        arr.push(val.label)
      })
      if ((new Set(arr)).size === arr.length) {
        this.$refs['subForm'].clearValidate()
      }
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
              if (this.currentId === id) {
                this.isData = false
                this.initList()
              } else {
                this.isData = true
              }
            } else {
              this.$message.error(res.data.result)
            }
          })
        }).catch(() => {

        })
    },
    // 显示编辑对话框
    editDepartment(data) {
      this.visible = false
      this.dialogStatus = '编辑部门'
      this.oldDepartmentName = data.label
      this.departmentForm.id = data.value
      this.departmentDialogVisible = true
      this.departmentForm.departmentName = data.label
      if (data.parentName) {
        this.departmentForm.parentId = data.parentId
      } else {
        this.departmentForm.parentId = '1'
      }
      this.$nextTick(() => {
        this.$refs['departmentForm'].clearValidate()
      })
    },
    // 编辑部门功能的实现
    updateData() {
      this.$refs['departmentForm'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          // 将对话框隐藏
          this.departmentDialogVisible = false
          // // 调用接口发送请求
          updateDepartment(this.departmentForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 刷新页面显示
            this.initList()
            this.updataRight()
          })
        }
      })
    },
    // 新增部门功能的实现
    createData() {
      this.isDisabled = true
      this.$refs['departmentForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          createDepartment(this.departmentForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              // 将对话框隐藏
              this.departmentDialogVisible = false
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 重置表单元素的数据
            this.$refs['departmentForm'].resetFields()
            // 刷新页面显示
            this.initList()
            this.updataRight()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    // 显示新增部门对话框
    addDepartment(data) {
      this.visible = true
      this.location = '1'
      this.dialogStatus = '新增部门'
      this.departmentDialogVisible = true
      this.departmentForm.departmentName = undefined
      this.checkoutId = data.value
      this.checkoutParentId = data.parentId
      if (data.parentName) {
        this.departmentForm.parentId = data.parentId
      } else {
        this.departmentForm.parentId = '1'
      }
      this.$nextTick(() => {
        this.$refs['departmentForm'].clearValidate()
      })
    },
    // 更新右侧页面
    updataRight() {
      if (this.location === '0') {
        getOldData(this.checkoutId).then(res => {
          if (res.data.code === '0000') {
            this.subForm.departmentData = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    // 初始化项目
    initList() {
      this.listLoading = true
      getDepartment().then(res => {
        if (res.data.code === '0000') {
          this.departmentList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.departmentManagement{
  height: 100%;
  display: flex;
.department-left{
  height: 100%;
  .el-tree{
    height: 100%;
    overflow: auto;
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
<style lang="scss">
 .department-right{
   height: 100%;
   width: 100%;
   overflow:auto;
    padding: 20px;
    .department-content{
      display: flex;
      align-items: center;
      >span{
        margin-right:100px;
      }
    .el-form-item{
      width: 360px;
    }
    .footer{
      width: 370px;
    }
    }
  }
</style>

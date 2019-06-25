<template>
  <div class="addForm">
    <el-card>
      <el-form ref="addForm" :model="addForm" :rules="rules" label-width="120px" >
        <el-row>
          <el-col :span="12">
            <el-form-item label="归类：" prop="nodeName">
              <el-input v-model.trim="addForm.nodeName" disabled style="width: 200px" placeholder="" clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="登记部门：" prop="regDepartment">
              <el-input v-model.trim="addForm.regDepartment" style="width: 200px" placeholder="请输入登记部门" clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>

          <el-col :span="12">
            <el-form-item label="文号：" prop="symbol">
              <el-input v-model.trim="addForm.symbol" style="width: 200px" placeholder="请输入文号" clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="题名：" prop="titleName">
              <el-input v-model.trim="addForm.titleName" style="width: 200px" placeholder="请输入题名" clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="责任人：" prop="personLiable">
              <el-input v-model.trim="addForm.personLiable" disabled style="width: 200px" placeholder="请输入责任人" clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="备注：" prop="remark">
              <el-input v-model.trim="addForm.remark" type="textarea" style="width: 200px"/>
            </el-form-item>
          </el-col>

        </el-row>

        <el-row style="margin-top:40px;">
          <el-form-item>
            <el-button :disabled="isDisabled" type="primary" @click="title==='新增员工档案'?submitForm():updateData()">提交</el-button>
            <el-button style="margin-left:50%;" @click="cancel">取消</el-button>
          </el-form-item>
        </el-row>

      </el-form>
    </el-card>
  </div>

</template>

<script>
import {
  addEmployeeFile, updateEmployeeFile, getEmployeeFile
} from '@/api/hr/employeeFile'
import {
  isvalidName
} from '@/api/hr/util'

export default {
  data() {
    var checkName = (rule, value, callback) => {
      if (!isvalidName(value)) {
        callback(new Error('姓名只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }
    return {
      title: '',
      isDisabled: false,
      rules: {
        regDepartment: [{ required: true, message: '请输入登记部门', trigger: 'blur' }, { validator: checkName, trigger: 'blur' }],
        symbol: [{ required: true, message: '请输入文号', trigger: 'blur' }],
        titleName: [{ required: true, message: '请输入题名', trigger: 'blur' }]/*,
        personLiable: [{ required: true, message: '请输入责任人', trigger: 'blur' }, { validator: checkName, trigger: 'blur' }]*/
      },
      addForm: {
        classId: '',
        nodeName: '',
        symbol: '',
        titleName: '',
        remark: '',
        personLiable: '',
        regDepartment: '',
        fileId: ''
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    cancel() {
      this.$router.push('employeeFileList')
    },
    submitForm() {
      if (!this.addForm.classId || this.addForm.classId.trim() === '') {
        this.$message({
          message: '请选择档案分类',
          type: 'info'
        })
        return
      }
      if (!this.addForm.nodeName || this.addForm.nodeName.trim() === '') {
        this.$message({
          message: '请选择档案分类',
          type: 'info'
        })
        return
      }
      this.isDisabled = true
      this.$refs['addForm'].validate(valid => {
        if (valid) {
          addEmployeeFile(this.addForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              this.$router.push('employeeFileList')
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // this.$refs['addForm'].resetFields()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    updateData() {
      if (!this.addForm.classId || this.addForm.classId.trim() === '') {
        this.$message({
          message: '请选择档案分类',
          type: 'info'
        })
        return
      }
      if (!this.addForm.nodeName || this.addForm.nodeName.trim() === '') {
        this.$message({
          message: '请选择档案分类',
          type: 'info'
        })
        return
      }
      this.isDisabled = true
      this.$refs['addForm'].validate(valid => {
        if (valid) {
          updateEmployeeFile(this.addForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              this.$router.push('employeeFileList')
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    initList() {
      const query = this.$route.query
      this.title = query.title
      this.addForm.classId = query.classId
      this.addForm.nodeName = query.nodeName
      this.addForm.personLiable = localStorage.getItem('userName')
      if (query.fileId) {
        this.addForm.fileId = query.fileId
        getEmployeeFile(query.fileId).then(res => {
          if (res.data.code === '0000') {
            this.addForm.classId = res.data.data.classId
            this.addForm.nodeName = res.data.data.nodeName
            this.addForm.symbol = res.data.data.symbol
            this.addForm.titleName = res.data.data.titleName
            this.addForm.remark = res.data.data.remark
            this.addForm.personLiable = res.data.data.personLiable
            this.addForm.regDepartment = res.data.data.regDepartment
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    }
  }
}
</script>

<style lang="scss">

</style>

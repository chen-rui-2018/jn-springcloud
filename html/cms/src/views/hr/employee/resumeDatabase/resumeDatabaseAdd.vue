<template>
  <div class="addForm">
    <el-card>
      <el-form ref="addForm" :model="addForm" :rules="rules" label-width="120px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名：" prop="name">
              <el-input v-model.trim="addForm.name" style="width: 200px" placeholder="请输入姓名" clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="性别：" prop="sex">
              <el-select v-model="addForm.sex" placeholder="请选择性别" style="width: 200px">
                <el-option label="请选择" value=""/>
                <el-option label="男" value="1"/>
                <el-option label="女" value="2"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="部门：" prop="departmentId">
              <el-cascader
                ref="departRef"
                :options="departmentList"
                v-model="currentDepartmentIds"
                change-on-select
                placeholder="请选择"
                clearable
                @change="handleChangeDepartment"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="应聘职位：" prop="jobId">
              <el-select v-model="addForm.jobId" placeholder="请选择" clearable style="width: 200px" class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in jobList" :key="item.id" :label="item.postName" :value="item.id"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="个人邮箱：" prop="mailbox">
              <el-input v-model.trim="addForm.mailbox" style="width: 200px" placeholder="请输入邮箱" clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="手机号码：" prop="phone">
              <el-input v-model.trim="addForm.phone" style="width: 200px" placeholder="请输入联系电话" clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="学历：" prop="educationId">
              <el-select
                v-model="addForm.educationId"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in educationList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="毕业院校：" prop="graduaAcademy">
              <el-input v-model.trim="addForm.graduaAcademy" style="width: 200px" placeholder="请输入毕业院校" clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="证件类型：" prop="certificateId">
              <el-select
                v-model="addForm.certificateId"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in certificateList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="证件号：" prop="certificateNumber">
              <el-input v-model.trim="addForm.certificateNumber" style="width: 200px" placeholder="请输入证件号"/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-form-item label="简历：" prop="resumeInfo">
            <el-upload
              ref="resumeInfoUpload"
              :action="fileUrl"
              :on-preview="handlePreview"
              :headers="importHeaders"
              :show-file-list="true"
              :limit="1"
              :on-remove="handleRemove"
              :on-change="fileChange"
              :on-success="handleSuccess"
              :file-list="fileList"
              :before-upload="beforeUpload"
              class="avatar-uploader">
              <i class="el-icon-plus avatar-uploader-icon"/>
            </el-upload>

          </el-form-item>

        </el-row>

        <el-row style="margin-top:40px;">
          <el-form-item>
            <el-button :disabled="isDisabled" type="primary" @click="title==='新增简历库'?submitForm():updateData()">提交
            </el-button>
            <el-button style="margin-left:50%;" @click="cancel">取消</el-button>
          </el-form-item>
        </el-row>
      </el-form>
    </el-card>
  </div>

</template>

<script>
import store from '@/store'
import { getToken } from '@/utils/auth'
import {
  addResumeDatabase, updateResumeDatabase, getResumeDatabaseById
} from '@/api/hr/resumeDatabase'
import {
  getCode, isvalidName, isvalidMobile, uploadUrl, setChild, findNodeById, findP
} from '@/api/hr/util'

import {
  api
} from '@/api/axios'

export default {
  data() {
    var checkName = (rule, value, callback) => {
      if (!isvalidName(value)) {
        callback(new Error('只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }
    var validMobile = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入手机号码'))
      } else if (!isvalidMobile(value)) {
        callback(new Error('请输入正确的11位手机号码'))
      } else {
        callback()
      }
    }
    const reg = /^\w{5,18}$/i
    const checkZjhm = (rule, value, callback) => {
      if (!reg.test(value)) {
        callback(new Error('请输入正确的证件号码'))
      } else {
        callback()
      }
    }

    return {
      nodes: [],
      pNodes: [],
      currentDepartmentIds: [],
      departmentOptions: [],
      departmentListLoading: false,
      importHeaders: {
        enctype: 'multipart/form-data',
        token: getToken()
      },
      fileUrl: process.env.BASE_API + 'springcloud-hr/hr/common/uploadAttachment',
      title: '',
      fileList: [],
      uploadUrl: uploadUrl,
      departmentList: [],
      jobList: [],
      educationList: [],
      certificateList: [],
      isDisabled: false,
      rules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }, { validator: checkName, trigger: 'blur' }],
        sex: [{ required: true, message: '请选择性别', trigger: 'change' }],
        departmentId: [{ required: true, message: '请选择应聘部门', trigger: 'change' }],
        jobId: [{ required: true, message: '请选择应聘职位', trigger: 'change' }],
        mailbox: [{ required: true, message: '请输入个人邮箱', trigger: 'blur' },
          { type: 'email', message: '请正确输入个人邮箱', trigger: 'blur' }],
        phone: [{ required: true, message: '请输入手机号码', trigger: 'blur' }, { validator: validMobile, trigger: 'blur' }],
        educationId: [{ required: true, message: '请选择学历', trigger: 'change' }],
        graduaAcademy: [{ required: true, message: '请输入毕业院校', trigger: 'blur' }, {
          validator: checkName,
          trigger: 'blur'
        }],
        certificateId: [{ required: true, message: '请选择证件类型', trigger: 'change' }],
        certificateNumber: [{ required: true, message: '请选择证件号', trigger: 'blur' }, {
          validator: checkZjhm,
          trigger: 'blur'
        }]
      },
      addForm: {
        name: '',
        sex: '',
        departmentId: '',
        departmentName: '',
        jobId: '',
        jobName: '',
        mailbox: '',
        phone: '',
        educationId: '',
        educationName: '',
        graduaAcademy: '',
        certificateId: '',
        certificateType: '',
        certificateNumber: '',
        resumeInfo: '',
        id: ''

      }
    }
  },
  created() {
    this.initSelect()
    this.initList()
  },
  methods: {
    handlePreview(file) {
      const link = document.createElement('a')
      link.setAttribute('href', file.url)
      link.setAttribute('download', file.name)
      link.style.visibility = 'hidden'
      document.body.appendChild(link)
      link.click()
      document.body.removeChild(link)
    },
    fileChange(file, fileList) {
      console.log('fileChange')

      const isLt6M = file.size / 1024 / 1024 < 6

      if (!isLt6M) {
        this.$message.error('上传文件大小不能超过 6MB!')
        fileList.pop()
      }
      const existFile = fileList.slice(0, fileList.length - 1).find(f => f.name === file.name)
      if (existFile) {
        this.$message.error('当前文件已经存在!')
        fileList.pop()
      }
      this.fileList = fileList
    },
    beforeUpload(file) {
      const isLt6M = file.size / 1024 / 1024 < 6

      if (!isLt6M) {
        this.$message.error('上传文件大小不能超过 6MB!')
      }
      return isLt6M
    },
    handleSuccess(response, file, fileList) {
      let flag = false
      if (response.code === '0000') {
        if (response.data && response.data !== '[]') {
          const url = JSON.parse(response.data)[0].url
          if (url) {
            this.addForm.resumeInfo = url
            flag = true
          }
        }
      }
      if (!flag) {
        this.$message.error('文件上传失败')
        this.$refs['resumeInfoUpload'].clearFiles()
      }
    },
    handleRemove(file, fileList) {
      this.addForm.resumeInfo = ''
      this.fileList = fileList
    },
    getToken() {
      var token = store.getters.token
      return { 'token': token }
    },
    cancel() {
      this.$router.push('resumeDatabaseList')
    },
    submitForm() {
      this.isDisabled = true
      const that = this
      this.$refs['addForm'].validate(valid => {
        if (valid) {
          const job = that.jobList.find(item => item.id === that.addForm.jobId)
          if (job) {
            that.addForm.jobName = job['postName']
          }

          const education = that.educationList.find(item => item.key === that.addForm.educationId)
          if (education) {
            that.addForm.educationName = education['lable']
          }

          const certificate = that.certificateList.find(item => item.key === that.addForm.certificateId)
          if (certificate) {
            that.addForm.certificateType = certificate['lable']
          }
          addResumeDatabase(that.addForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              this.$router.push('resumeDatabaseList')
            } else {
              this.$message.error(res.data.result)
            }
            that.isDisabled = false
          })
        } else {
          that.isDisabled = false
        }
      })
    },
    updateData() {
      this.isDisabled = true
      this.$refs['addForm'].validate(valid => {
        if (valid) {
          const job = this.jobList.find(item => item.id === this.addForm.jobId)
          if (job) {
            this.addForm.jobName = job['postName']
          }

          const education = this.educationList.find(item => item.key === this.addForm.educationId)
          if (education) {
            this.addForm.educationName = education['lable']
          }

          const certificate = this.certificateList.find(item => item.key === this.addForm.certificateId)
          if (certificate) {
            this.addForm.certificateType = certificate['lable']
          }

          updateResumeDatabase(this.addForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              this.$router.push('resumeDatabaseList')
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
      var query = this.$route.query
      this.title = query.title
      if (query.id) {
        this.addForm.id = query.id
        getResumeDatabaseById(query.id).then(res => {
          if (res.data.code === '0000') {
            this.addForm = res.data.data

            setChild(this.nodes, this.departmentList)
            const currNode = findNodeById(this.nodes, this.addForm.departmentId)
            this.pNodes.push(currNode)
            findP(this.nodes, currNode, this.pNodes)
            this.pNodes.reverse()
            const arr = []
            this.pNodes.forEach(item => {
              arr.push(item.id)
            })
            this.currentDepartmentIds = arr

            if (this.addForm.resumeInfo && this.addForm.resumeInfo !== '') {
              var obj = {}
              const index = this.addForm.resumeInfo.lastIndexOf('\/')
              const fileName = this.addForm.resumeInfo.substring(index + 1, this.addForm.resumeInfo.length)
              this.$set(obj, 'name', fileName)
              this.$set(obj, 'url', this.addForm.resumeInfo)
              this.fileList.push(obj)
            }
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    handleChangeDepartment(value) {
      this.addForm.departmentId = this.currentDepartmentIds[this.currentDepartmentIds.length - 1]
      const arr = this.$refs['departRef'].currentLabels
      this.addForm.departmentName = arr[arr.length - 1]
    },
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
    initSelect() {
      this.getAllDepartment()
      api(`${this.GLOBAL.systemUrl}system/sysPost/findSysPostAll`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.jobList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })

      getCode({ 'groupCode': 'education', 'parentGroupCode': 'employee', 'moduleCode': 'springcloud_hr' }).then(res => {
        if (res.data.code === '0000') {
          this.educationList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
      getCode({
        'groupCode': 'certificate_type',
        'parentGroupCode': 'employee',
        'moduleCode': 'springcloud_hr'
      }).then(res => {
        if (res.data.code === '0000') {
          this.certificateList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss">
  .avatar-uploader {
    width: 120px;
    height: 120px;
  }

  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 16px;
    color: #8c939d;
    width: 120px;
    height: 120px;
    line-height: 120px;
    text-align: center;
  }

</style>

<template>
  <div class="addForm">
    <el-card>
      <el-form ref="form" :model="addForm" label-width="150px" >

        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名：">
              {{ addForm.name }}
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="性别：">
              <el-select v-model="addForm.sex" disabled placeholder="请选择性别" style="width: 200px">
                <el-option label="请选择" value=""/>
                <el-option label="男" value="1"/>
                <el-option label="女" value="2"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="应聘部门：">
              {{ addForm.departmentName }}
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="应聘职位：">
              {{ addForm.jobName }}
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="个人邮箱：">
              {{ addForm.mailbox }}
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="手机号码：">
              {{ addForm.phone }}
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="学历：">
              <el-select v-model="addForm.educationId" disabled placeholder="请选择" clearable style="width: 200px" class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in educationList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="毕业院校：">
              {{ addForm.graduaAcademy }}
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="证件类型：">
              <el-select v-model="addForm.certificateId" disabled placeholder="请选择" clearable style="width: 200px" class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in certificateList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="证件号：">
              {{ addForm.certificateNumber }}
            </el-form-item>
          </el-col>
        </el-row>

        <el-form-item label="简历：">
          <el-button v-if="addForm.resumeInfo && addForm.resumeInfo.length>0" type="primary" @click="download">下载</el-button>
          <span v-else>无</span>
        </el-form-item>

        <el-form-item v-if="!addForm.backgroundInvest" label="背景调查">
          未完成
        </el-form-item>

        <template v-if="addForm.backgroundInvest">
          <span class="background-info-head">背景调查信息</span>

          <el-row>
            <el-col :span="12">
              <el-form-item label="身份核查：">
                {{ addForm.backgroundInvest.identityCheck==1?'核查属实':'核查不属实' }}
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="学历核查：">
                {{ addForm.backgroundInvest.educationCheck==1?'核查属实':'核查不属实' }}
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="上家公司名称：">
                {{ addForm.backgroundInvest.corporateName }}
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="上家公司职位：">
                {{ addForm.backgroundInvest.corporateJob }}
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="上家公司证明人：">
                {{ addForm.backgroundInvest.companyCertifier }}
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="核查人：">
                {{ addForm.backgroundInvest.inspectors }}
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="核查人联系电话：">
                {{ addForm.backgroundInvest.inspectorsPhone }}
              </el-form-item>
            </el-col>

          </el-row>

        </template>

        <el-form-item style="text-align: center;">
          <el-button type="primary" style="margin-left:-75px;" @click="cancel">返回</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>

</template>

<script>
import {
  getResumeDatabaseById
} from '@/api/hr/resumeDatabase'
import {
  getCode
} from '@/api/hr/util'

export default {
  data() {
    return {
      departmentList: [],
      jobList: [],
      educationList: [],
      certificateList: [],
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
        backgroundInvest: {
          id: '',
          identityCheck: '',
          educationCheck: '',
          corporateName: '',
          corporateJob: '',
          companyCertifier: '',
          inspectors: '',
          inspectorsPhone: ''
        }
      }
    }
  },
  created() {
    this.initSelect()
    this.initForm()
  },
  methods: {
    initForm() {
      const id = this.$route.query.id
      console.log('id=' + id)
      if (id) {
        getResumeDatabaseById(id).then(res => {
          if (res.data.code === '0000') {
            this.addForm = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    download() {
      const fileName = this.addForm.resumeInfo.substring(this.addForm.resumeInfo.lastIndexOf('.') + 1)
      const link = document.createElement('a')
      link.setAttribute('href', this.addForm.resumeInfo)
      link.setAttribute('download', fileName)
      link.style.visibility = 'hidden'
      document.body.appendChild(link)
      link.click()
      document.body.removeChild(link)
    },
    cancel() {
      this.$router.push('resumeDatabaseList')
    },
    initSelect() {
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
.background-info-head{
  color: #c3c3c3;
  font-size: 16px;
  margin: 0px auto;
  display:block;width:300px;
  height:30px;line-height:30px;
  font-weight:bold
}
</style>

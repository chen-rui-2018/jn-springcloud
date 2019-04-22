<template>
  <div class="addwork write">
    <h2>添加工作计划</h2>
    <el-form ref="workForm" :model="workForm" :rules="rules" label-width="100px" size="mini">
      <div class="merge">
        <el-form-item label="所属项目:" prop="itemId">
          <el-select
            v-model="workForm.itemId"
            style="width: 100%;"
            clearable
            placeholder="请选择项目"
          >
            <el-option
              v-for="item in itemOptions"
              :key="item.id"
              :label="item.itemName"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="任务名称:" prop="workPlanName">
          <el-input v-model="workForm.workPlanName" clearable/>
        </el-form-item>
      </div>
      <div class="merge">
        <el-form-item label="负责人:">
          <el-select
            v-model="userAccount"
            multiple
            style="width: 100%;"
            clearable
            filterable
            placeholder="请选择负责人"
          >
            <el-option
              v-for="item in userOptions"
              :key="item.userId"
              :label="item.name"
              :value="item.account"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="预计工时:">
          <el-input v-model="workForm.planTime"><template slot="append">小时</template></el-input>
        </el-form-item>
      </div>
      <div class="merge">
        <el-form-item label="开始时间:" prop="planStartTime">
          <el-date-picker v-model="workForm.planStartTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期" style="width: 100%;" />
        </el-form-item>
        <el-form-item label="截止时间:" prop="planEndTime">
          <el-date-picker v-model="workForm.planEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期" style="width: 100%;" />
        </el-form-item>
      </div>
      <el-form-item label="需求描述:" prop="desc">
        <el-input v-model="workForm.demandDescribe" placeholder="请输入需求描述" type="textarea"/>
      </el-form-item>
      <el-form-item label="附件:" class="inline ueditor">
        <el-upload
          :on-error="handleError"
          :headers="{token: $store.getters.token}"
          :on-remove="handleRemove"
          :before-upload="beforeUpload"
          :on-success="uploadDone"
          :on-exceed="handleExceed"
          :limit="1"
          :action="baseUrl+'zuul/'+oaUrl+'oa/common/uploadAttachment'">
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">附件大小不能超过50M</div>
        </el-upload>
        <!-- <el-button v-if="meetingForm.fileUrl" size="small" type="primary" icon="el-icon-download"><a :href="meetingForm.fileUrl" download="" target="_blank">点击下载附件</a></el-button>
        <div v-if="!meetingForm.fileUrl && dialogStatus !== '会议申请'" class="attachment-tips">暂无附件</div> -->
      </el-form-item>
      <div class="ueQuedit">
        <el-form-item label="任务内容:" lass="inline">
          <div class="editor-container">
            <UE ref="ue" :default-msg="defaultMsg" :config="config"/>
          </div>
      </el-form-item></div>
      <el-form-item size="large">
        <el-button :disabled="isDisabled" type="primary" @click="submitForm('workForm')" >保存</el-button>
        <el-button @click="goBack($route)" >返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import UE from '@/components/ue.vue'
import {
  api
} from '@/api/axios'
export default {
  components: { UE },
  props: {
    multiple: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      isDisabled: false,
      userAccount: [],
      userOptions: [],
      itemOptions: [],
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 150
      },
      oaUrl: this.GLOBAL.oaUrl,
      baseUrl: process.env.BASE_API,
      workForm: {
        workPlanName: '',
        responsibleUserAccount: '',
        planStartTime: '',
        planEndTime: '',
        Uecontent: '',
        demandDescribe: '',
        itemId: '',
        attachment: '',
        planTime: 0
      },
      rules: {
        itemId: [
          { required: true, message: '请选择项目', trigger: 'change' }
        ],
        workPlanName: [
          { required: true, message: '请输入任务名称', trigger: 'blur' }
        ],
        planStartTime: [
          { required: true, message: '请选择开始时间', trigger: 'change' }
        ],
        planEndTime: [
          { required: true, message: '请选择结束时间', trigger: 'change' }
        ]
      }
    }
  },
  mounted() {
    this.getItem()
    this.getALLlist()
    this.getDate()
  },
  methods: {
    // 提交表单
    submitForm(workForm) {
      this.$refs[workForm].validate((valid) => {
        if (valid) {
          this.isDisabled = true
          if (this.userAccount.length === 0) {
            alert('请选择负责人')
            this.isDisabled = false
            return
          }
          if (new Date(this.workForm.planStartTime.replace(/-/g, '\/')) > new Date(this.workForm.planEndTime.replace(/-/g, '\/'))) {
            alert('开始时间必须大于截止时间,请重新选择')
            this.isDisabled = false
            return false
          }
          this.workform.Uecontent = this.$refs.ue.getUEContent()
          this.workForm.responsibleUserAccount = this.userAccount.join(',')
          api(`${this.GLOBAL.oaUrl}oa/workPlan/add`, this.workForm, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.goBack(this.$route)
              this.$refs[workForm].resetFields()
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
          })
        } else {
          this.isDisabled = false
          return false
        }
      })
    },
    uploadDone(res, file, fileList) {
      console.log(res)
      this.workForm.attachment = res.data
    },
    handleRemove(file, fileList) {
      this.workForm.attachment = ''
    },
    handleError(e) {
      this.$message.error('上传文件失败!')
    },
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传1个附件`)
    },
    beforeUpload(file) {
      if (file.size / 1024 / 1024 > 50) {
        this.$message.warning('附件大小不能超过50M')
        return false
      }
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    // 关闭当前页面
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('workPlanManagement')
        }
      })
    },
    //  获取项目
    getItem() {
      api(`${this.GLOBAL.oaUrl}oa/workPlan/getItemAll`, '', 'get').then(res => {
        console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          this.itemOptions = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取所有用户
    getALLlist() {
      api(`${this.GLOBAL.oaUrl}oa/addressBook/list`, { page: 1, rows: 2000 }, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          //   this.userNamesOptions = res.data.data
          res.data.data.rows.forEach(val => {
            if (val.name !== null) {
              this.userOptions.push({ userId: val.id, name: val.name, account: val.account })
            } else {
              this.userOptions.push({ userId: val.id, name: val.account, account: val.account })
            }
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取时间
    getDate() {
      var date = new Date()
      var sign1 = '-'
      var sign2 = ':'
      var year = date.getFullYear() // 年
      var month = date.getMonth() + 1 // 月
      var day = date.getDate() // 日
      var hour = date.getHours() // 时
      var minutes = date.getMinutes() // 分
      var seconds = date.getSeconds() // 秒
      // 给一位数数据前面加 “0”
      if (month >= 1 && month <= 9) {
        month = '0' + month
      }
      if (day >= 0 && day <= 9) {
        day = '0' + day
      }
      if (hour >= 0 && hour <= 9) {
        hour = '0' + hour
      }
      if (minutes >= 0 && minutes <= 9) {
        minutes = '0' + minutes
      }
      if (seconds >= 0 && seconds <= 9) {
        seconds = '0' + seconds
      }
      this.workForm.planStartTime = year + sign1 + month + sign1 + day + ' ' + hour + sign2 + minutes + sign2 + seconds
    }
  }
}
</script>

<style lang="scss" >
      .addwork{
        .el-form-item--mini .el-form-item__content, .el-form-item--mini .el-form-item__label{
          color:#141414;
        }
          padding: 20px;
           .el-form-item--mini .el-form-item__content, .el-form-item--mini .el-form-item__label {
    width: 300px ;
  }
  .el-form-item--mini.el-form-item, .el-form-item--small.el-form-item{
    margin-bottom: 14px;
  }
  .el-textarea{
    width: 707px!important;
  }
  .el-textarea__inner{
    min-height: 100px!important;
  }
  .merge{
    .el-form-item--mini.el-form-item, .el-form-item--small.el-form-item{
      display: inline-block
    }
  }
  .ueQuedit{
     .el-form-item--mini .el-form-item__content, .el-form-item--mini .el-form-item__label {
    width: 80% ;
  }
  .el-form-item--mini .el-form-item__content, .el-form-item--mini .el-form-item__label{
    line-height: 22px;
  }
  }
      }
</style>

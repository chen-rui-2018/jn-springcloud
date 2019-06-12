<template>
  <div class="meetingApplication noticePublish">
    <div class="meetingApplication-top">
      <el-form ref="ruleForm" :model="ruleForm" :rules="rules" label-width="160px" class="demo-meetingForm">
        <div style="display:flex">
          <el-form-item label="公告编号" prop="noticeSerial" class="inline">
            <el-input v-model="ruleForm.noticeSerial"/>
          </el-form-item>
          <el-form-item label="公告标题" prop="noticeTitle" class="inline">
            <el-input v-model="ruleForm.noticeTitle"/>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="生效时间" prop="startTime" class="inline">
            <el-date-picker
              v-model="ruleForm.startTime"
              :picker-options="startTimePickerOptions"
              type="date"
              placeholder="选择日期"
              style="width: 100%;"
              @change="startTimeChange"/>
          </el-form-item>
          <el-form-item label="失效时间" prop="endTime" class="inline">
            <el-date-picker
              v-model="ruleForm.endTime"
              :picker-options="endTimePickerOptions"
              :disabled="!ruleForm.startTime"
              type="date"
              placeholder="选择日期"
              style="width: 100%;"
            />
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="是否首页弹出" prop="homePopup" >
            <el-radio-group v-model="ruleForm.homePopup">
              <el-radio label="1">是</el-radio>
              <el-radio label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否首页展示" prop="homeShow">
            <el-radio-group v-model="ruleForm.homeShow">
              <el-radio label="1">是</el-radio>
              <el-radio label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="排序" prop="sortField">
            <el-input-number v-model="ruleForm.sortField" :min="0"/>
          </el-form-item>
          <el-form-item label="平台类型" prop="platformType">
            <el-select v-model="ruleForm.platformType" placeholder="请选择">
              <el-option label="全部" value="P001"/>
              <el-option label="App" value="P002"/>
              <el-option label="门户" value="P003"/>
            </el-select>
          </el-form-item>
        </div>
        <el-form-item label="平台类型名称" prop="platformName">
          <el-select v-model="ruleForm.platformName" placeholder="请选择">
            <el-option label="全部" value="全部"/>
            <el-option label="App" value="App"/>
            <el-option label="门户" value="门户"/>
          </el-select>
        </el-form-item>
        <el-form-item label="公告内容">
          <div style="width: calc(100%)">
            <UE ref="UEdit" :config="ueConfig" :default-msg="initUEditContent"/>
          </div>
        </el-form-item>
      </el-form>
      <div class="btn-row">
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
        <el-button @click="$router.go(-1)">返回上一页</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import UE from '@/components/ue'
export default {
  name: 'AddData',
  components: {
    UE
  },
  props: {
    title: {
      type: String,
      required: false,
      default: '提示'
    }
  },
  data() {
    /*
    homePopup string 是否首页弹出,(0:否-1:是,不给值则返回全部)
    homeShow string 是否首页展示,(0:否-1:是,不给值则返回全部)
    keyWord string 关键词,(公告标题/平台名称(app/门户))
     string (0:无效-1:有效,不给值noticeStatus则返回全部)
    page integer($int32) 页码
    rows integer($int32) 每页显示数量
    * */
    return {
      initUEditContent: '',
      ueConfig: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      noticeId: this.$route.query.noticeId,
      ruleForm: {
        noticeId: '',
        homePopup: '',
        homeShow: '',
        noticeDetails: '',
        noticeSerial: '',
        noticeTitle: '',
        platformName: '',
        platformType: '',
        sortField: null,
        startTime: '',
        endTime: ''
      },
      startTimePickerOptions: {
        disabledDate(time) {
          return time.getTime() < Date.now() - 8.64e7
        }
      },
      endTimePickerOptions: {},
      rules: {
        homePopup: [
          { required: true, message: '请选择', trigger: 'change' }
        ],
        homeShow: [
          { required: true, message: '请选择', trigger: 'change' }
        ],
        noticeDetails: [
          { required: true, message: '请输入', trigger: 'blur' }
        ],
        noticeSerial: [
          { required: true, message: '请输入', trigger: 'blur' }
        ],
        noticeTitle: [
          { required: true, message: '请输入', trigger: 'blur' }
        ],
        platformName: [
          { required: true, message: '请输入', trigger: 'change' }
        ],
        platformType: [
          { required: true, message: '请输入', trigger: 'change' }
        ],
        sortField: [
          { type: 'number', required: false, message: '请输入', trigger: 'blur' }
        ],
        startTime: [
          { required: true, message: '请选择', trigger: 'change' }
        ],
        endTime: [
          { required: true, message: '请选择', trigger: 'change' }
        ]
      }
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.init()
    })
  },
  methods: {
    init() {
      this.getData()
    },
    startTimeChange() {
      this.endTimePickerOptions = {
        disabledDate: (time) => {
          return new Date(this.ruleForm.startTime).getTime() >= time.getTime() + 8.64e7
        }
      }
    },
    getData() {
      // 如果路由有id，那么就查询回显
      if (!this.noticeId) {
        return
      }
      this.loading = true
      this.$_get(`${this.GLOBAL.parkUrl}park/notice/findNoticeDetails`, { noticeId: this.noticeId })
        .then(res => {
          if (res.code === '0000') {
            const data = res.data
            const ruleForm = this.ruleForm
            for (const key in ruleForm) {
              if (data.hasOwnProperty(key)) {
                ruleForm[key] = data[key]
              }
            }
            this.initUEditContent = ruleForm.noticeDetails
          } else {
            this.$message.error(res.result)
          }
          this.loading = false
        })
    },
    submit() {
      // 获取富文本框内容
      this.ruleForm.noticeDetails = this.$refs.UEdit.getUEContent()
      const data = {
        ...this.ruleForm
      }
      data.startTime = this.formatDate(data.startTime)
      data.endTime = this.formatDate(data.endTime)
      this.loading = true
      let url
      if (data.noticeId) {
        url = 'park/notice/modifyNoticeList'
      } else {
        delete data.noticeId
        url = 'park/notice/addNotice'
      }
      this.$_post(`${this.GLOBAL.parkUrl}${url}`, data)
        .then(data => {
          if (data.code === '0000') {
            this.$message.success('提交成功')
            this.query = Object.assign({}, this.originQuery)
            this.getData()
            this.$refs['ruleForm'].resetFields()
          } else {
            this.$message.error(data.result)
          }
          this.loading = false
        })
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.$refs.UEdit.hasContents()) {
            this.submit()
          } else {
            this.$message.warning('公告内容不能为空')
          }
        } else {
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    formatDate(str) {
      const date = new Date(str)
      const y = date.getFullYear()
      let m = date.getMonth() + 1
      m = m > 10 ? m : '0' + m
      let d = date.getDay()
      d = d > 10 ? d : '0' + d
      return y + '-' + m + '-' + d
    }
  }
}
</script>
<style lang="scss">
  @import "~@/styles/r-common";
  $gray: #ccc;
  .meetingApplication.noticePublish{
    .el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
      line-height: 20px;
    }
    .edui-editor {
      width: 100% !important;
    }
    .btn-row {
      padding:10px;
      margin-top: 10px;
      text-align: center;
    }
    .el-form-item__content {
      margin-left: 0 !important;
    }
    .demo-meetingForm {
      border-top: 1px solid $gray;
      border-left: 1px solid $gray;
    }
    .el-form-item__error{
      left:22px;
      top:unset;
      padding-top: unset;
    }
  }
  .meetingApplication-top {
    .inline {
      display: inline-block;
    }
    .el-form-item__label {
      flex: none;
      width: 120px;
      padding: 15px 0;
      background-color: #f0f0f0;
      display: flex;
      align-items: center;
      justify-content: center;
      border-right: 1px solid $gray;
    }
    .edui-default .edui-editor-bottomContainer{
      display: none;
    }
    .el-form-item {
      margin-bottom: 0px;
      flex: 1;
      display: flex;
      border-bottom: 1px solid $gray;
      border-right: 1px solid $gray;
    }
    .el-form-item__content {
      flex: 1;
      display: inline-block;
      padding: 15px;
    }
    .primaryList {
      margin-top: 30px;
      text-align: center;
    }
    .el-steps{
      margin-left: 100px;
    }
    .el-textarea__inner{
      min-height: 120px !important;
    }

  }
  .lookMeetingroom{
    .el-form--inline .el-form-item{
      margin-right: 70px;
    }

    .el-dialog{
      width: 70vw;
      height: 82vh;
      margin-top:6vh !important;
      overflow: auto;
    }
    .usableMeetingroom{
      background-color: #ccc;
      padding: 15px;
      border:1px solid #666;
    }
    .meetingroomList{
      >div{
        width: 31.7%;
        display: inline-block;
        margin-right: 21px;
        margin-top: 30px;
        padding: 10px;
        //  box-sizing: border-box;
        img{
          width: 100%;
          height: 182px;
        }
      }
      .active{
        border:2px solid rgb(226, 43, 113);
      }
      h3{
        text-align: center;
      }
    }
    .meetingroomList div:nth-child(3n){
      margin-right: 0px;
    }
    .dialog-footer{
      text-align: center;
      margin-top:20px;
    }
  }
  .attachment-tips{
    font-size: 12px;
  }
</style>

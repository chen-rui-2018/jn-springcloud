<template>
  <div class="addemail write">
    <div class="header">{{ title }}</div>
    <el-form ref="emailForm" :model="emailForm" :rules="rules">
      <div style="display:flex">
        <el-form-item id="setheight" label="编号" class="inline ">
          <span>{{ emailForm.workOrderNum }}</span>
        </el-form-item>
        <el-form-item label="邮件标题" prop="title" class="inline">
          <el-input :disabled="title==='一键Email详情'" v-model="emailForm.title" clearable placeholder="请输入邮件标题" maxlength="20" />
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="发起人" class="inline">
          <span>{{ creator }}</span>
        </el-form-item>
        <el-form-item v-show="title!=='一键Email编辑'" label="发起人部门" class="inline">
          <span>{{ department }} </span>
        </el-form-item>
        <el-form-item v-show="title==='一键Email编辑'" label="发送状态" class="inline">
          <el-select v-model="emailForm.sendStatus" placeholder="请选择状态" class="filter-item">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="是否定时发送" class="inline">
          <el-radio-group :disabled="title==='一键Email详情'" v-model="emailForm.isDelay">
            <el-radio label="1">是</el-radio>
            <el-radio label="0">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="定时发送时间" class="inline">
          <el-date-picker
            :disabled="emailForm.isDelay==='0'||title==='一键Email详情'"
            v-model="emailForm.delaySendTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm"
            placeholder="选择日期时间" />

        </el-form-item>
      </div>
      <div v-show="title==='一键Email详情'" style="display:flex">
        <el-form-item label="发送时间" class="inline">
          <el-date-picker
            :disabled="title==='一键Email详情'"
            v-model="sendTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm"
            placeholder="选择日期时间" />
        </el-form-item>
        <el-form-item label="发送状态" class="inline">
          <el-select v-model="emailForm.sendStatus" :disabled="title==='一键Email详情'" placeholder="请选择状态" class="filter-item">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>

        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="接收人" lass="inline">
          <div v-show="title!=='一键Email详情'">
            <span>添加接收人</span>
            <el-select
              :disabled="title==='一键Email详情'"
              v-model="userNames"
              multiple
              value-key="userId"
              filterable
              placeholder="请选择接收人"
              @change="changeUsername(userNames)">
              <el-option
                v-loading="userNamesOptions.length === 0"
                v-for="item in userNamesOptions"
                :key="item.userId"
                :label="item.name"
                :value="item" />
            </el-select>
          </div>
          <div style="margin-top:10px;">
            <el-table :data="userData" max-height="250" style="width: 98%">
              <el-table-column label="序列" type="index" align="center" width="60" />
              <el-table-column prop="name" align="center" label="姓名" />
              <el-table-column prop="email" label="邮箱" align="center" />
              <!-- <el-table-column prop="address" align="center" label="操作">
                <template slot-scope="scope">
                  <el-button type="text" size="mini" @click="handleDelete(scope.row)" >删除</el-button>
                </template>
              </el-table-column> -->
            </el-table>
          </div>
        </el-form-item>
      </div>
      <el-form-item label="附件" class="inline ueditor">
        <!-- <form :action="baseUrl+'zuul/'+oaUrl+'oa/common/uploadAttachment'" method="post" enctype="multipart/form-data">
          <p>选择文件1:<input type="file" name="file" @change="getFile($event)" ></p>
          <p>选择文件2:<input type="file" name="file" @change="getFile($event)" ></p>
          <p>选择文件3:<input type="file" name="file" @change="getFile($event)" ></p>
          <input type="submit" value="上传" >
        </form> -->
        <el-upload
          :on-change="judgeFile"
          :disabled="title==='一键Email详情'"
          :on-error="handleError"
          :on-preview="download"
          :headers="{token: $store.getters.token}"
          :on-remove="handleRemove"
          :before-upload="beforeUpload"
          :on-success="uploadDone"
          :on-exceed="handleExceed"
          :file-list="fileList"
          :limit="1"
          :action="baseUrl+'zuul/'+oaUrl+'oa/common/uploadAttachment'">
          <el-button size="small" type="primary">选择文件</el-button>
          <div slot="tip" class="el-upload__tip">附件大小不能超过50M</div>
        </el-upload>
        <!-- <el-button v-if="title==='一键Email详情'&&emailForm.attachment" size="small" type="primary" icon="el-icon-download"><a :href="emailForm.attachment" download="" target="_blank">点击下载附件</a></el-button> -->
        <div v-if="!emailForm.attachment && title !== '一键Email新增'" class="attachment-tips">暂无附件</div>
      </el-form-item>
      <div style="display:flex">
        <el-form-item label="邮件内容" prop="emailContent" lass="inline">
          <div class="editor-container">
            <UE ref="ue" :disabled="title==='一键Email详情'" :default-msg="defaultMsg" :config="config" />
          </div>
        </el-form-item>
      </div>
      <!-- :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'" -->
      <div class="primaryList">
        <el-button v-show="title!=='一键Email详情'" :disabled="isDisabled" type="primary" @click="title==='一键Email新增'?submitForm():updateData()">提交</el-button>
        <el-button @click="goBack($route)">返回</el-button>

      </div>
    </el-form>
  </div>
</template>

<script>
import { api } from '@/api/axios'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    var checkemailTitle = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }
    return {
      judge: '',
      sendTime: '',
      statusOptions: [
        {
          value: '1',
          label: '未发送'
        },
        {
          value: '2',
          label: '发送成功'
        },
        {
          value: '3',
          label: '发送失败'
        }
      ],
      oaUrl: this.GLOBAL.oaUrl,
      baseUrl: process.env.BASE_API,
      isSendStatus: false,
      department: '',
      creator: '',
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      fileList: [],
      isShow: false,
      isDisabled: false,
      title: '',
      userData: [],
      userNames: [],
      userNamesOptions: [],
      emailForm: {
        workOrderNum: '',
        title: '',
        isDelay: '1',
        emailContent: '',
        delaySendTime: '',
        id: '',
        userAccounts: [],
        attachment: [],
        sendStatus: ''
      },
      rules: {
        title: [
          { required: true, message: '请输入邮件标题', trigger: 'blur' },
          { validator: checkemailTitle, trigger: 'blur' }
        ],
        sendStatus: [
          { required: true, message: '请选择状态', trigger: 'change' }
        ],
        // userNames: [{ required: true, message: '请选择接收人', trigger: 'change' }],
        // delaySendTime: [{ required: true, message: '请选择发送时间', trigger: 'change' }],
        emailContent: [
          { required: true, message: '请输入邮件内容', trigger: 'blur' }
        ]
      }
    }
  },
  watch: {
    // 如果 `emailForm.isDelay` 发生改变，这个函数就会运行
    'emailForm.isDelay': function() {
      if (this.emailForm.isDelay === '0') {
        this.emailForm.delaySendTime = ''
      }
    }
  },
  created() {
    this.getALLlist()
  },
  mounted() {
    this.initList()
    this.getUserInfo()
  },
  methods: {
    judgeFile() {
      this.judge = 1
    },
    uploadDone(res, file, fileList) {
      this.emailForm.attachment = res.data
    },
    beforeUpload(file) {
      if (file.size / 1024 / 1024 > 50) {
        this.$message.warning('附件大小不能超过50M')
        return false
      }
    },
    download(file) {
      api(
        `${this.GLOBAL.oaUrl}oa/common/downLoadAttachment?title=${
          file.name
        }&url=${file.url}`,
        '',
        'get'
      ).then(res => {
        window.location.href = res.request.responseURL
      })
      // if (this.title === '一键Email详情') {
      //   window.location.href = file.url
      // }
    },
    handleRemove(file, fileList) {
      this.emailForm.attachment = ''
    },
    handleError(e) {
      this.$message.error('上传文件失败!')
    },
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传1个附件`)
    },
    //   改变接收人
    changeUsername(val) {
      this.userData = val
    },
    // 获取所有用户
    getALLlist() {
      api(
        `${this.GLOBAL.oaUrl}oa/addressBook/list`,
        { page: 1, rows: 2000 },
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          //   this.userNamesOptions = res.data.data
          res.data.data.rows.forEach(val => {
            if (val.name !== null) {
              this.userNamesOptions.push({
                userId: val.id,
                name: val.name,
                email: val.email,
                account: val.account
              })
            } else {
              this.userNamesOptions.push({
                userId: val.id,
                name: val.account,
                email: val.email,
                account: val.account
              })
            }
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取登陆用户信息
    getUserInfo() {
      api(
        `${this.GLOBAL.systemUrl}system/sysUser/getUserInfo`,
        '',
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          if (res.data.data.name) {
            this.creator = res.data.data.name
          } else {
            this.creator = res.data.data.account
          }
          if (
            res.data.data.sysDepartmentPostVO &&
            res.data.data.sysDepartmentPostVO.length > 0
          ) {
            res.data.data.sysDepartmentPostVO.forEach(val => {
              if (val.isDefault === '1') {
                this.department = val.departmentName
              }
            })
          } else {
            this.department = '无'
          }
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 新增提交表单
    submitForm() {
      this.isDisabled = true
      if (this.emailForm.sendStatus === '1' && !this.emailForm.delaySendTime) {
        alert('请选择定时发送时间')
        this.isDisabled = false
        return false
      } else if (this.userNames.length === 0) {
        alert('请选择接收人')
        this.isDisabled = false
        return false
      } else if (this.emailForm.delaySendTime) {
        if (new Date(this.emailForm.delaySendTime) < new Date().getTime()) {
          alert('定时发送时间必须大于当前时间,请重新选择')
          this.isDisabled = false
          return false
        }
      }
      this.userData.forEach(val => {
        this.emailForm.userAccounts.push(val.account)
      })
      this.emailForm.userAccounts = [...new Set(this.emailForm.userAccounts)]
      this.emailForm.emailContent = this.$refs.ue.getUEContent()
      this.$refs['emailForm'].validate(valid => {
        if (valid) {
          if (this.emailForm.attachment.length > 0) {
            this.emailForm.attachment = this.emailForm.attachment
          } else {
            if (this.judge === 1 && this.emailForm.attachment.length === 0) {
              alert('附件没有上传成功或上传失败')
            }
            this.emailForm.attachment = this.emailForm.attachment + ''
          }
          // 调用接口发送请求
          api(
            `${this.GLOBAL.oaUrl}oa/email/addOrUpdate`,
            this.emailForm,
            'post'
          ).then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              this.goBack(this.$route)
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
    isActive(route) {
      return route.path === this.$route.path
    },
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('email')
        }
      })
    },
    // 编辑表单
    updateData() {
      this.isDisabled = true
      this.emailForm.emailContent = this.$refs.ue.getUEContent()
      this.$refs['emailForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          if (this.emailForm.sendStatus === '1') {
            if (this.emailForm.delaySendTime) {
              if (
                new Date(this.emailForm.delaySendTime) < new Date().getTime()
              ) {
                alert('定时发送时间必须大于当前时间,请重新选择')
                this.isDisabled = false
                return false
              }
            }
          }
          this.userData.forEach(val => {
            this.emailForm.userAccounts.push(val.account)
          })
          this.emailForm.userAccounts = [...new Set(this.emailForm.userAccounts)]
          api(
            `${this.GLOBAL.oaUrl}oa/email/addOrUpdate`,
            this.emailForm,
            'post'
          ).then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              this.goBack(this.$route)
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
    // 页面初始化
    initList() {
      var query = this.$route.query
      this.title = query.title
      if (query.emailId) {
        this.emailForm.id = query.emailId
        api(
          `${this.GLOBAL.oaUrl}oa/email/getEmailDetails?emailId=${
            query.emailId
          }`,
          '',
          'get'
        ).then(res => {
          if (res.data.code === this.GLOBAL.code) {
            // var data = res.data.data
            console.log(res)
            this.emailForm.title = res.data.data.title
            this.emailForm.workOrderNum = res.data.data.workOrderNum
            this.emailForm.delaySendTime = res.data.data.delaySendTime
            this.emailForm.isDelay = res.data.data.isDelay
            this.emailForm.sendStatus = res.data.data.sendStatus
            this.userNames = res.data.data.receiverList
            this.userData = this.userNames
            this.sendTime = res.data.data.sendTime
            this.emailForm.attachment = res.data.data.attachment
            if (res.data.data.attachment) {
              var fileListArr = []
              JSON.parse(res.data.data.attachment).forEach(val => {
                fileListArr.push({ name: val.title, url: val.url })
              })
              // 数组去重
              this.fileList = Array.from(new Set(fileListArr))
            }
            // this.emailForm.recordStatus = data.recordStatus.toString()
            // this.platformType = JSON.parse(data.platformType)
            this.defaultMsg = res.data.data.emailContent
          } else {
            this.$message.error(res.data.result)
          }
        })
      } else {
        this.emailForm.workOrderNum = query.workOrderNum
      }
    }
  }
}
</script>

<style lang="scss">
.addemail {
  padding-bottom: 20px;
  .header {
    color: cadetblue;
    background: #f0f0f0;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: Center;
    padding: 20px 0px;
    border: 1px solid #ccc;
  }
  .inline {
    display: inline-block;
  }
  .el-form-item__label {
    width: 120px;
    padding: 15px 0;
    display: inline-block;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .el-form-item {
    margin-bottom: 0px;
    flex: 1;
    display: flex;
  }
  .el-input--medium {
    width: 300px;
  }
  .el-form-item__content {
    flex: 1;
    // line-height: 36px;
    display: inline-block;
    padding: 15px;
    border: 1px solid #ccc;
  }
  #setheight {
    .el-form-item__content {
      line-height: 36px;
    }
  }
  .primaryList {
    margin-top: 30px;
    text-align: center;
  }
  .el-form-item__error {
    left: 22px;
    top: unset;
    padding-top: unset;
  }
  .el-form-item--medium .el-form-item__content,
  .el-form-item--medium .el-form-item__label {
    line-height: 22px;
  }
}
.attachment-tips {
  font-size: 12px;
}
</style>

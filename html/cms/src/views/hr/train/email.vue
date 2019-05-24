<template>
  <div class="email">
    <el-card>
      <span class="title">发送考试通知</span>
      <div class="content">
        <el-form class="form" label-width="98px">
          <el-form-item label="邮件标题">
            <el-input v-model="formData.emailSubject"/>
          </el-form-item>
          <el-form-item label="邮件内容">
            <div class="editor-container">
              <UE ref="ue" :default-msg="formData.emailContent" :config="config"/>
            </div>
          </el-form-item>
          <el-form-item label="收件人邮箱">
            <span class="tips">多个邮箱以逗号隔开,如a@qq.com,b@sina.com</span>
            <el-input v-model="formData.emailList" :rows="6" type="textarea"/>
          </el-form-item>
        </el-form>
        <div class="btnGroup">
          <el-button type="primary" @click="save">保存</el-button>
          <el-button @click="goBack($route)">关闭</el-button>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import { api } from '@/api/hr/train'
import VueQr from 'vue-qr'
import UE from '@/components/ue.vue'
export default {
  components: { UE, VueQr },
  data() {
    return {
      // 富文本
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 150,
        autoFloatEnabled: false
      },
      appSrc:
        'http://localhost:9527/#/hr/train/investigation/invest-page?projectId=' +
        this.$route.query.projectId,
      formData: {
        emailSubject: '',
        emailContent: '',
        emailList: ''
      }
    }
  },
  created() {
    this.init()
  },
  methods: {
    // 初始化
    init() {
      // if(this.$route.query.status === 0) {
      //     return false
      // }
      const data = {
        projectId: this.$route.query.projectId
      }
      api('hr/train/loginInvestiage', data).then(res => {
        if (res.data.code === '0000') {
          const returnData = res.data.data
          this.formData = Object.assign(this.formData, returnData)
          this.formData.emailSubject =
            '【考试通知】-请参加"' + returnData.researchProject + '"考试'
          this.formData.emailContent =
            '你好！<br/>邀请你参加"在职测试"考试，您可以点击下面的考试链接或者扫描二维码直接参加考试<br/>点击链接参加考试：<a href="' +
            returnData.surveyUrl +
            '" style="color:purple;cursor:pointer;">' +
            returnData.surveyUrl +
            '</a><br/>或者扫描二维码参加考试：<div class="maImg"><vue-qr :logo-src="' +
            returnData.surveyDimensional +
            '" :size="88" :margin="0" :auto-color="true" :dot-scale="1" :text="' +
            this.appSrc +
            '" /></div>'
          // this.$nextTick(() => {
          //     document.getElementById("ma").appendChild('<vue-qr :logo-src="'+returnData.surveyDimensional+'" :size="88" :margin="0" :auto-color="true" :dot-scale="1" :text="'+this.appSrc+'" />')
          // })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 保存
    save() {
      api('hr/train/sendInvestiage', this.formData).then(res => {
        if (res.data.code === '0000') {
          this.$message.success('发送成功！')
          this.goBack(this.$route)
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 返回
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          const latestView = visitedViews.slice(-1)[0]
          if (latestView) {
            this.$router.push('investigation/invest-analysis')
          } else {
            this.$router.push('/')
          }
        }
      })
    },
    isActive(route) {
      return route.path === this.$route.path
    }
  }
}
</script>

<style lang="scss" scoped>
.email {
  font-size: 14px;
  .title {
    display: inline-block;
    width: 100%;
    height: 36px;
    font-size: 15px;
    font-weight: bold;
    border-bottom: 2px solid #ccc;
  }
  .content {
    padding: 30px 20px;
    .tips {
      font-size: 12px;
      color: rgb(170, 170, 170);
    }
    .btnGroup {
      margin-top: 36px;
      text-align: center;
    }
    .maImg {
      width: 126px;
      height: 126px;
      border: 1px solid #ccc;
      img {
        width: 100%;
        height: 100%;
      }
    }
  }
  .form /deep/ .el-form-item__label {
    text-align: left;
    color: #999;
  }
}
</style>

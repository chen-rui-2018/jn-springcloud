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
              <div v-show="false" id="vueQrEmint">
                <vue-qr :size="191" :margin="0" :auto-color="true" :dot-scale="1" :text="returnData.examinaUrl" />
              </div>
              <UE ref="ue" :default-msg="formData.emailContent" :config="config" />
            </div>
          </el-form-item>
          <el-form-item label="收件人邮箱">
            <span class="tips">多个邮箱以逗号隔开,如a@qq.com,b@sina.com{{ returnData.examinaUrl }}</span>
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
import VueQr from 'vue-qr'
import {
  examLoginManagement,
  examSendExaminaManagement
} from '@/api/hr/examManage'
import UE from '@/components/ue.vue'
export default {
  components: {
    VueQr,
    UE
  },
  props: ['examItem'],
  data() {
    return {
      // 富文本
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 150,
        autoFloatEnabled: false
      },
      returnData: {
        examinaUrl: 'http.www.baidu.com'
      },
      isF5: false,
      vueQrEmintDom: '',
      appSrc: 'http://localhost:9527/#/hr/train/investigation/invest-page?projectId=' + this.$route.query.projectId,
      formData: {
        emailSubject: '',
        emailContent: '',
        emailList: ''
      }
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    // 初始化
    init() {
      const data = {
        id: this.examItem.id
      }
      examLoginManagement(data).then(res => {
        if (res.data.code === '0000') {
          const _this = this
          const returnData = res.data.data
          this.returnData = res.data.data
          this.formData = Object.assign(this.formData, returnData)
          this.formData.emailSubject = '【考试通知】-请参加"' + returnData.examinaName + '"考试'
          window.setTimeout(function() {
            _this.vueQrEmintDom = document.getElementById('vueQrEmint').innerHTML // 创建一个隐藏元素
            _this.formData.emailContent = '你好！<br/>邀请你参加"在职测试"考试，您可以点击下面的考试链接或者扫描二维码直接参加考试<br/>点击链接参加考试：<a href="' + returnData.examinaUrl + '" style="color:purple;cursor:pointer;">' + returnData.examinaUrl + '</a><br/>或者扫描二维码参加考试：<br/><br/>' + _this.vueQrEmintDom
          }, 300)
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 保存
    save() {
      examSendExaminaManagement({ ...this.formData,
        ...this.examItem
      }).then(res => {
        if (res.data.code === '0000') {
          this.$message.success('发送成功！')
          this.$emit('confirmEmit', 'false')
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 返回
    goBack(view) {
      this.$emit('confirmEmit', 'false')
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
				color: rgb(170, 170, 170)
			}
			.btnGroup {
				margin-top: 36px;
				text-align: center;
			}
		}
		.form /deep/ .el-form-item__label {
			text-align: left;
			color: #999;
		}

	}
</style>

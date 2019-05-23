<template>
  <div class="invest-give">
    <el-card>
      <!-- 标题 -->
      <el-tabs v-model="activeName">
        <el-tab-pane label="编辑调研" name="first"/>
        <el-tab-pane label="发放调研" name="second"/>
        <el-tab-pane label="调研结果" name="third"/>
      </el-tabs>
      <!-- 模块一 -->
      <div class="mode">
        <div class="modeTit">
          <span>发放方式</span>
          <span class="line"/>
        </div>
        <div class="modeCon">
          <el-row class="item">
            <el-col :span="5">
              <span class="item-l">二维码：</span>
            </el-col>
            <el-col :span="19">
              <el-row>
                <el-col :span="5">
                  <div class="maImg">
                    <vue-qr
                      :logo-src="formData.surveyDimensional"
                      :size="191"
                      :margin="0"
                      :auto-color="true"
                      :dot-scale="1"
                      :text="appSrc"
                    />
                  </div>
                </el-col>
                <el-col :span="19" class="maCon">
                  <p>1、微信扫一扫二维码，打开调研页面，转发到微信好友，微信群或朋友圈；</p>
                  <p>2、把二维码图片发送到微信/手机QQ群中，学员扫一扫填写；</p>
                  <p>3、通过邮件把课程问卷地址或二维码图片发给学员。</p>
                  <el-button size="small" @click="downloadImg">下载二维码</el-button>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
          <el-row class="item">
            <el-col :span="5">
              <span class="item-l">网址：</span>
            </el-col>
            <el-col :span="19">
              <el-row>复制链接，通过链接分享或用邮件将报名链接发送给学员</el-row>
              <el-row class="maLink">
                <el-col :span="10">
                  <el-input v-model="formData.surveyUrl"/>
                </el-col>
                <el-col :span="9" :offset="1">
                  <el-button
                    v-clipboard:copy="formData.surveyUrl"
                    v-clipboard:success="clipboardSuccess"
                    icon="el-icon-document"
                  >复制</el-button>
                  <el-button icon="el-icon-message" @click="sendEmail">邮件</el-button>
                  <el-button type="primary" plain @click="jumpPage">打开</el-button>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </div>
      </div>
      <!-- 模块二 -->
      <div class="mode">
        <div class="modeTit">
          <span>发放设置</span>
          <span class="line"/>
        </div>
        <div class="modeCon">
          <el-row class="item">
            <el-col :span="5">
              <span class="item-l">调研时段：</span>
            </el-col>
            <el-col :span="19">
              <span>
                <el-date-picker
                  v-model="formData.effectiveTimeStart"
                  format="yyyy-MM-dd HH:mm:ss"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  type="datetime"
                  placeholder="选择日期时间"
                />
              </span>
              <span>到</span>
              <span>
                <el-date-picker
                  v-model="formData.effectiveTimeEnd"
                  format="yyyy-MM-dd HH:mm:ss"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  type="datetime"
                  placeholder="选择日期时间"
                />
              </span>
            </el-col>
          </el-row>
          <el-row class="item">
            <el-col :span="5">
              <span class="item-l">调研方式：</span>
            </el-col>
            <el-col :span="19">
              <p>
                <el-radio v-model="formData.researchMethod" :label="1">匿名调研</el-radio>
              </p>
              <p>
                <el-radio v-model="formData.researchMethod" :label="2">实名调研</el-radio>
              </p>
              <p v-if="formData.researchMethod === 2">
                <el-checkbox
                  :checked="formData.isShowName===1?true:false"
                  v-model="formData.isShowName"
                  :true-label="1"
                  :false-label="2"
                  label="姓名"
                />
                <el-checkbox
                  :checked="formData.isShowJobNumber===1?true:false"
                  v-model="formData.isShowJobNumber"
                  :true-label="1"
                  :false-label="2"
                  label="工号"
                />
                <el-checkbox
                  :checked="formData.isShowPhone===1?true:false"
                  v-model="formData.isShowPhone"
                  :true-label="1"
                  :false-label="2"
                  label="手机"
                />
              </p>
            </el-col>
          </el-row>
        </div>
      </div>
      <!-- 模块三 -->
      <div class="mode">
        <div class="modeTit">
          <span>调研限制</span>
          <span class="line"/>
        </div>
        <div class="modeCon">
          <el-row class="item">
            <el-col :span="5">
              <span class="item-l">次数限制：</span>
            </el-col>
            <el-col :span="19">
              <el-checkbox
                :checked="formData.frequencyLimit===1?true:false"
                v-model="formData.frequencyLimit"
                :true-label="1"
                :false-label="2"
                label="每个学员只能调研一次"
              />
            </el-col>
          </el-row>
          <el-row class="item">
            <el-col :span="5">
              <span class="item-l">显示设置：</span>
            </el-col>
            <el-col :span="19">
              <el-checkbox
                :checked="formData.isShowTips===1?true:false"
                v-model="formData.isShowTips"
                :true-label="1"
                :false-label="2"
                label="调研后提示"
              />
            </el-col>
          </el-row>
        </div>
      </div>
      <el-row type="flex" justify="center">
        <el-col :span="1">
          <el-button type="primary" @click="save">保存</el-button>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import { api } from '@/api/hr/train'
import VueQr from 'vue-qr'
import clipboard from '@/directive/clipboard/index.js'
export default {
  components: { VueQr },
  directives: {
    clipboard
  },
  data() {
    return {
      activeName: 'second',
      // 二维码
      appSrc:
        'http://localhost:9527/#/hr/train/investigation/invest-page?projectId=' +
        this.$route.query.id,
      // 提交数据
      formData: {
        effectiveTimeEnd: '',
        effectiveTimeStart: '',
        // emailContent: '',
        // emailList: '',
        // emailSubject: '',
        frequencyLimit: 2,
        isShowJobNumber: 2,
        isShowName: 2,
        isShowPhone: 2,
        isShowTips: 2,
        projectId: this.$route.query.id,
        // promptingLanguage: '',
        researchMethod: 2,
        researchProject: this.$route.query.researchProject,
        surveyDimensional: 'static/QrCode/qr.jpg',
        surveyUrl:
          'http://localhost:9527/#/hr/train/investigation/invest-page?projectId=' +
          this.$route.query.id
      }
    }
  },
  created() {
    this.init()
    // 登录信息免登录
    // const token = this.$store.getters.token;
    // this.appSrc = 'http://172.16.0.199:9527/#/hr/train/investigation/invest-page?token='+token
  },
  methods: {
    // 初始化
    init() {
      if (this.$route.query.status === 0) {
        return false
      }
      const data = {
        projectId: this.$route.query.id
      }
      api('hr/train/loginInvestiage', data).then(res => {
        if (res.data.code === '0000') {
          this.formData = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 下载图片
    downloadImg() {
      var oQrcode = document.querySelector('.maImg img')
      var url = oQrcode.src
      var a = document.createElement('a')
      var event = new MouseEvent('click')
      // 图片名称
      a.download = this.$route.query.id
      a.href = url
      a.dispatchEvent(event)
    },
    // 发送邮件
    sendEmail() {
      this.$router.push({
        name: 'email',
        query: {
          projectId: this.$route.query.id,
          status: this.$route.query.status
        }
      })
    },
    // 调研页面
    jumpPage() {
      this.$router.push({
        name: 'invest-page',
        query: { projectId: this.$route.query.id }
      })
    },
    // 复制
    clipboardSuccess() {
      this.$message({
        message: '✔ 已成功复制到粘贴板',
        type: 'success',
        duration: 1500
      })
    },
    // 保存
    save() {
      api('hr/train/sendInvestiage', this.formData).then(res => {
        if (res.data.code === '0000') {
          this.$message.success('保存成功！')
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.mode {
  padding: 10px 10px;
  .modeTit {
    display: flex;
    align-items: center;
    width: 100%;
    height: 26px;
    span {
      display: inline-block;
      width: 68px;
      font-size: 14px;
      font-weight: bold;
    }
    .line {
      display: inline-block;
      width: 100%;
      height: 2px;
      background-color: #f5f5f5;
    }
  }
  .modeCon {
    padding: 20px;
    font-size: 14px;
    .item {
      margin-bottom: 36px;
      .item-l {
        font-size: 14px;
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
      .maCon {
        p:first-child {
          margin-top: 0;
        }
      }
      .maLink {
        margin-top: 16px;
      }
    }
  }
}
</style>

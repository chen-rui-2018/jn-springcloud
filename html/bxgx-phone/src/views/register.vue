<template>
  <div class="register">
    <div :class="allShow ? 'show' : 'hide'">
      <div class="s2 s2-1">
        <div class="inpt-wrap">
          <div><div class="tit">手机号：</div></div>
          <div class="flex-1"><input v-model="phone" placeholder="请输入手机号码" class="inp" /></div>
        </div>
        <div class="inpt-wrap">
          <div><div class="tit">验证码：</div></div>
          <div class="flex-1" ><input v-model="code" placeholder="请输入验证码" class="inp"/></div>
          <div><div class="split"></div></div>
          <div>
            <div class="get-code" :class="is_show ? 'show':'hide'" @click="getCode">获取验证码</div>
            <div class="get-code" :class="is_show ? 'hide' : 'show'" >重新发送{{last_time}}秒</div>
          </div>
        </div>
        <button class="btn mt-2" @click="finishRegister">完 成</button>
      </div>
    </div>
  </div>
</template>

<script>
import { urlSearch, hexToDec } from '@/utils'
export default {
  data () {
    return {
      // 手机号
      phone: '',
      // 验证码
      code: '',
      // 验证码倒计时
      last_time: '',
      // 验证码是否显示标志，true：显示获取验证码   false:显示验证码倒计时
      is_show: true,
      // 倒计时数
      countdown: 60,
      // 是否隐藏  false 为隐藏  true 为显示
      allShow: true
    }
  },
  methods: {
    // 验证码倒计时
    settime (that) {
      const t = this
      if (this.countdown === 0) {
        that.setData({
          is_show: true
        })
        this.countdown = 60
        return
      } else {
        this.countdown = this.countdown--
        this.is_show = false
      }
      setTimeout(function () {
        t.settime(that)
      }, 1000)
    },
    // 验证码
    getCode () {
      this.flag = true
      const phone = this.phone
      const myreg = /^1[3|4|5|7|8|6][0-9]{9}$/
      if (!myreg.test(phone)) {
        this.$vux.toast.text('手机号有误', 'middle')
        setTimeout(() => {
          this.$vux.toast.hide()
        }, 2000)
      } else {
        this.api.get({
          url: 'getCode',
          data: {
            phone: this.phone
          },
          callback: res => {
            if (res.code === '0000') {
              this.$vux.toast.text('发送成功', 'middle')
              // 将获取验证码按钮隐藏60s，60s后再次显示
              this.is_show = !this.is_show
              this.settime(this)
              setTimeout(() => {
                this.$vux.toast.hide()
              }, 2000)
            }
            if (res.code === 1) {
              this.$vux.toast.text('发送失败', 'middle')
              setTimeout(() => {
                this.$vux.toast.hide()
              }, 2000)
            }
          }
        })
      }
    },
    // 点击完成按钮后的操作
    finishRegister () {
      // 手机号
      // const phone = this.phone
      // // 验证码
      // const code = this.code
      // if (code === '' || phone === '') {
      //   this.$vux.toast.text('手机号或验证码填写有误请重新填写', 'middle')
      //   setTimeout(() => {
      //     this.$vux.toast.hide()
      //   }, 2000)
      //   return
      // }
      // 注册
      this.api.post({
        url: 'registerUrl',
        data: {
          phoneNo: this.phone,
          phoneCode: this.code,
          userFlag: urlSearch.userFlag
        },
        callback: res => {
          if (res.code === '0000') {
            this.$vux.toast.text('注册绑定成功', 'middle')
            setTimeout(() => {
              this.$vux.toast.hide()
              window.location.href = hexToDec(urlSearch.targetUrl)
            }, 1500)
          } else {
            this.$vux.toast.text(res.result == null ? '验证码错误或验证码已过期' : res.result, 'middle')
            setTimeout(() => {
              this.$vux.toast.hide()
            }, 2000)
          }
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  .hide {
    display: none;
  }

  .show {
    display: block;
  }

  .flex {
    display: flex;
    align-items: center;
  }

  .flex-1 {
    flex: 1;
    overflow: hidden;
  }

  button {
    font-size: inherit;
    color: inherit;
    background: none;
    border-radius: 0;
  }

  button:after {
    display: none;
  }

  .navigator-hover {
    background: none;
    opacity: 0.7;
  }

  .button-hover {
    opacity: 0.7;
  }

  .txt-0 {
    color: transparent;
    pointer-events: none;
    user-select: none;
  }

  .btn-primary {
    display: block;
    padding: 0;
    height: 88px;
    line-height: 88px;
    background: #00a041;
    font-size: 34px;
    border-radius: 10px;
    color: #fff;
    text-align: center;
  }

  .btn-primary.fixed {
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    z-index: 5;
    border-radius: 0;
    height: 100px;
    line-height: 100px;
  }

  .btn-primary.button-hover, .btn-primary.navigator-hover {
    background: #549a05;
    opacity: 1;
  }

  radio .wx-radio-input, radio .wx-radio-input.wx-radio-input-checked,
  checkbox .wx-checkbox-input.wx-checkbox-input-checked {
    border: none;
    box-sizing: border-box;
    background-position-x: 100%;
  }

  radio .wx-radio-input.wx-radio-input-checked::before,
  checkbox .wx-checkbox-input.wx-checkbox-input-checked::before {
    display: none;
  }

  .m-0 {
    margin: 0px !important;
  }

  .p-0 {
    padding: 0px !important;
  }

  .mt-0 {
    margin-top: 0px !important;
  }

  .mr-0 {
    margin-right: 0px !important;
  }

  .mb-0 {
    margin-bottom: 0px !important;
  }

  .ml-0 {
    margin-left: 0px !important;
  }

  .pt-0 {
    padding-top: 0px !important;
  }

  .pr-0 {
    padding-right: 0px !important;
  }

  .pb-0 {
    padding-bottom: 0px !important;
  }

  .pl-0 {
    padding-left: 0px !important;
  }

  .mx-0 {
    margin-left: 0px !important;
    margin-right: 0px !important;
  }

  .my-0 {
    margin-top: 0px !important;
    margin-bottom: 0px !important;
  }

  .px-0 {
    padding-left: 0px !important;
    padding-right: 0px !important;
  }

  .py-0 {
    padding-top: 0px !important;
    padding-bottom: 0px !important;
  }

  .m-1 {
    margin: 10px !important;
  }

  .p-1 {
    padding: 10px !important;
  }

  .mt-1 {
    margin-top: 10px !important;
  }

  .mr-1 {
    margin-right: 10px !important;
  }

  .mb-1 {
    margin-bottom: 10px !important;
  }

  .ml-1 {
    margin-left: 10px !important;
  }

  .pt-1 {
    padding-top: 10px !important;
  }

  .pr-1 {
    padding-right: 10px !important;
  }

  .pb-1 {
    padding-bottom: 10px !important;
  }

  .pl-1 {
    padding-left: 10px !important;
  }

  .mx-1 {
    margin-left: 10px !important;
    margin-right: 10px !important;
  }

  .my-1 {
    margin-top: 10px !important;
    margin-bottom: 10px !important;
  }

  .px-1 {
    padding-left: 10px !important;
    padding-right: 10px !important;
  }

  .py-1 {
    padding-top: 10px !important;
    padding-bottom: 10px !important;
  }

  .m-2 {
    margin: 20px !important;
  }

  .p-2 {
    padding: 20px !important;
  }

  .mt-2 {
    margin-top: 20px !important;
  }

  .mr-2 {
    margin-right: 20px !important;
  }

  .mb-2 {
    margin-bottom: 20px !important;
  }

  .ml-2 {
    margin-left: 20px !important;
  }

  .pt-2 {
    padding-top: 20px !important;
  }

  .pr-2 {
    padding-right: 20px !important;
  }

  .pb-2 {
    padding-bottom: 20px !important;
  }

  .pl-2 {
    padding-left: 20px !important;
  }

  .mx-2 {
    margin-left: 20px !important;
    margin-right: 20px !important;
  }

  .my-2 {
    margin-top: 20px !important;
    margin-bottom: 20px !important;
  }

  .px-2 {
    padding-left: 20px !important;
    padding-right: 20px !important;
  }

  .py-2 {
    padding-top: 20px !important;
    padding-bottom: 20px !important;
  }

  .m-3 {
    margin: 30px !important;
  }

  .p-3 {
    padding: 30px !important;
  }

  .mt-3 {
    margin-top: 30px !important;
  }

  .mr-3 {
    margin-right: 30px !important;
  }

  .mb-3 {
    margin-bottom: 30px !important;
  }

  .ml-3 {
    margin-left: 30px !important;
  }

  .pt-3 {
    padding-top: 30px !important;
  }

  .pr-3 {
    padding-right: 30px !important;
  }

  .pb-3 {
    padding-bottom: 30px !important;
  }

  .pl-3 {
    padding-left: 30px !important;
  }

  .mx-3 {
    margin-left: 30px !important;
    margin-right: 30px !important;
  }

  .my-3 {
    margin-top: 30px !important;
    margin-bottom: 30px !important;
  }

  .px-3 {
    padding-left: 30px !important;
    padding-right: 30px !important;
  }

  .py-3 {
    padding-top: 30px !important;
    padding-bottom: 30px !important;
  }

  .m-4 {
    margin: 40px !important;
  }

  .p-4 {
    padding: 40px !important;
  }

  .mt-4 {
    margin-top: 40px !important;
  }

  .mr-4 {
    margin-right: 40px !important;
  }

  .mb-4 {
    margin-bottom: 40px !important;
  }

  .ml-4 {
    margin-left: 40px !important;
  }

  .pt-4 {
    padding-top: 40px !important;
  }

  .pr-4 {
    padding-right: 40px !important;
  }

  .pb-4 {
    padding-bottom: 40px !important;
  }

  .pl-4 {
    padding-left: 40px !important;
  }

  .mx-4 {
    margin-left: 40px !important;
    margin-right: 40px !important;
  }

  .my-4 {
    margin-top: 40px !important;
    margin-bottom: 40px !important;
  }

  .px-4 {
    padding-left: 40px !important;
    padding-right: 40px !important;
  }

  .py-4 {
    padding-top: 40px !important;
    padding-bottom: 40px !important;
  }

  .m-5 {
    margin: 50px !important;
  }

  .p-5 {
    padding: 50px !important;
  }

  .mt-5 {
    margin-top: 50px !important;
  }

  .mr-5 {
    margin-right: 50px !important;
  }

  .mb-5 {
    margin-bottom: 50px !important;
  }

  .ml-5 {
    margin-left: 50px !important;
  }

  .pt-5 {
    padding-top: 50px !important;
  }

  .pr-5 {
    padding-right: 50px !important;
  }

  .pb-5 {
    padding-bottom: 50px !important;
  }

  .pl-5 {
    padding-left: 50px !important;
  }

  .mx-5 {
    margin-left: 50px !important;
    margin-right: 50px !important;
  }

  .my-5 {
    margin-top: 50px !important;
    margin-bottom: 50px !important;
  }

  .px-5 {
    padding-left: 50px !important;
    padding-right: 50px !important;
  }

  .py-5 {
    padding-top: 50px !important;
    padding-bottom: 50px !important;
  }

  .m-6 {
    margin: 60px !important;
  }

  .p-6 {
    padding: 60px !important;
  }

  .mt-6 {
    margin-top: 60px !important;
  }

  .mr-6 {
    margin-right: 60px !important;
  }

  .mb-6 {
    margin-bottom: 60px !important;
  }

  .ml-6 {
    margin-left: 60px !important;
  }

  .pt-6 {
    padding-top: 60px !important;
  }

  .pr-6 {
    padding-right: 60px !important;
  }

  .pb-6 {
    padding-bottom: 60px !important;
  }

  .pl-6 {
    padding-left: 60px !important;
  }

  .mx-6 {
    margin-left: 60px !important;
    margin-right: 60px !important;
  }

  .my-6 {
    margin-top: 60px !important;
    margin-bottom: 60px !important;
  }

  .px-6 {
    padding-left: 60px !important;
    padding-right: 60px !important;
  }

  .py-6 {
    padding-top: 60px !important;
    padding-bottom: 60px !important;
  }

  .m-7 {
    margin: 70px !important;
  }

  .p-7 {
    padding: 70px !important;
  }

  .mt-7 {
    margin-top: 70px !important;
  }

  .mr-7 {
    margin-right: 70px !important;
  }

  .mb-7 {
    margin-bottom: 70px !important;
  }

  .ml-7 {
    margin-left: 70px !important;
  }

  .pt-7 {
    padding-top: 70px !important;
  }

  .pr-7 {
    padding-right: 70px !important;
  }

  .pb-7 {
    padding-bottom: 70px !important;
  }

  .pl-7 {
    padding-left: 70px !important;
  }

  .mx-7 {
    margin-left: 70px !important;
    margin-right: 70px !important;
  }

  .my-7 {
    margin-top: 70px !important;
    margin-bottom: 70px !important;
  }

  .px-7 {
    padding-left: 70px !important;
    padding-right: 70px !important;
  }

  .py-7 {
    padding-top: 70px !important;
    padding-bottom: 70px !important;
  }

  .m-8 {
    margin: 80px !important;
  }

  .p-8 {
    padding: 80px !important;
  }

  .mt-8 {
    margin-top: 80px !important;
  }

  .mr-8 {
    margin-right: 80px !important;
  }

  .mb-8 {
    margin-bottom: 80px !important;
  }

  .ml-8 {
    margin-left: 80px !important;
  }

  .pt-8 {
    padding-top: 80px !important;
  }

  .pr-8 {
    padding-right: 80px !important;
  }

  .pb-8 {
    padding-bottom: 80px !important;
  }

  .pl-8 {
    padding-left: 80px !important;
  }

  .mx-8 {
    margin-left: 80px !important;
    margin-right: 80px !important;
  }

  .my-8 {
    margin-top: 80px !important;
    margin-bottom: 80px !important;
  }

  .px-8 {
    padding-left: 80px !important;
    padding-right: 80px !important;
  }

  .py-8 {
    padding-top: 80px !important;
    padding-bottom: 80px !important;
  }

  .m-9 {
    margin: 90px !important;
  }

  .p-9 {
    padding: 90px !important;
  }

  .mt-9 {
    margin-top: 90px !important;
  }

  .mr-9 {
    margin-right: 90px !important;
  }

  .mb-9 {
    margin-bottom: 90px !important;
  }

  .ml-9 {
    margin-left: 90px !important;
  }

  .pt-9 {
    padding-top: 90px !important;
  }

  .pr-9 {
    padding-right: 90px !important;
  }

  .pb-9 {
    padding-bottom: 90px !important;
  }

  .pl-9 {
    padding-left: 90px !important;
  }

  .mx-9 {
    margin-left: 90px !important;
    margin-right: 90px !important;
  }

  .my-9 {
    margin-top: 90px !important;
    margin-bottom: 90px !important;
  }

  .px-9 {
    padding-left: 90px !important;
    padding-right: 90px !important;
  }

  .py-9 {
    padding-top: 90px !important;
    padding-bottom: 90px !important;
  }

  .m-10 {
    margin: 100px !important;
  }

  .p-10 {
    padding: 100px !important;
  }

  .mt-10 {
    margin-top: 100px !important;
  }

  .mr-10 {
    margin-right: 100px !important;
  }

  .mb-10 {
    margin-bottom: 100px !important;
  }

  .ml-10 {
    margin-left: 100px !important;
  }

  .pt-10 {
    padding-top: 100px !important;
  }

  .pr-10 {
    padding-right: 100px !important;
  }

  .pb-10 {
    padding-bottom: 100px !important;
  }

  .pl-10 {
    padding-left: 100px !important;
  }

  .mx-10 {
    margin-left: 100px !important;
    margin-right: 100px !important;
  }

  .my-10 {
    margin-top: 100px !important;
    margin-bottom: 100px !important;
  }

  .px-10 {
    padding-left: 100px !important;
    padding-right: 100px !important;
  }

  .py-10 {
    padding-top: 100px !important;
    padding-bottom: 100px !important;
  }

  .text-left {
    text-align: left;
  }

  .text-center {
    text-align: center;
  }

  .text-right {
    text-align: right;
  }

  .text-nowrap {
    white-space: nowrap;
  }

  .color-primary {
    color: #00a041;
  }

  .view-more-btn {
    margin: auto;
    display: block;
    width: 200px;
    height: 70px;
    line-height: 70px;
    text-align: center;
    color: #999;
    border: 1px #eee solid;
  }

  .view-more-btn.button-hover {
    background: none;
  }

  .border-none {
    border: none !important;
  }

  .modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 20;
  }

  .modal .mask {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
  }

  .modal .main {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 600px;
    border-radius: 10px;
    background: #fff;
    z-index: 2;
  }

  .modal .main .modal-head {
    padding: 30px;
    font-size: 30px;
    text-align: center;
  }

  .modal .main .modal-body {
    padding: 0 30px 30px;
  }

  .modal .main .modal-foot {
    display: flex;
    align-items: center;
    justify-content: center;
    border-top: solid 1px #a8a8a8;
  }

  .modal .main .modal-foot .btn {
    flex: 1;
    display: block;
    padding: 0;
    height: 100px;
    line-height: 100px;
    text-align: center;
    border-right: solid 1px #a8a8a8;
  }

  .modal .main .modal-foot .btn:last-child {
    border-right: none;
  }

  .modal .main .modal-foot .btn.c1 {
    color: #00a041;
  }

  /*login*/

  .register {
    min-height: 100vh;
    display: flex;
    align-items: normal;
    justify-content: space-between;
    flex-direction: column;
    overflow: hidden;
    background-color: #fafafa;
  }

  .register .s1 .logo {
    display: block;
    margin: 80px auto 60px auto;
    width: 250px;
    height: 250px;
  }

  .register .s2 {
    padding: 30px;
  }

  .register .s2 .inpt-wrap {
    margin-bottom: 40px;
    display: flex;
    align-items: center;
    padding: 0 20px;
    border-bottom: 2px solid #d0d0d0;
  }

  .register .s2 .inpt-wrap .inp {
    width: 100%;
    padding: 0 20px;
    height: 80px;
    font-size: 26px;
    background-color: transparent;
  }

  .register .s2 .inpt-wrap .inp .input-placeholder {
    color: #bbb;
  }

  .register .s2 .inpt-wrap .toggle {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: row;
    margin-right: -20px;
    padding: 0 20px;
    height: 80px;
  }

  .register .s2 .btn {
    width: 100%;
    margin: 80px 0 20px;
    height: 88px;
    line-height: 88px;
    border-radius: 88px;
    border: none;
    background: #00a041;
    font-size: 32px;
    color: #fff;
    text-align: center;
  }

  .register .s2 .btn.btn-o {
    background: none;
    border: solid 2px #00a041;
    color: #00a041;
  }

  .register .s2 .link-group {
    padding: 0 4px;
  }

  .register .s2 .link-group .link {
    color: #00a041;
  }

  .register .s2-1 .inpt-wrap {
    padding: 0;
    margin: 0;
    font-size: 30px;
    border-color: #ddd;
  }

  .register .s2-1 .inpt-wrap .get-code {
    padding: 0 40px;
    color: #00a041;
  }

  .register .s2-1 .inpt-wrap .split {
    height: 50px;
    width: 2px;
    background: #e6e6e6;
  }

  .register .s2-1 .inpt-wrap .inp {
    font-size: 30px;
    height: 100px;
  }

  .register .s2-1 .inpt-wrap .tit {
    min-width: 110px;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .register .s2-1 .red {
    color: #fd4242;
  }

  .register .s2-1 .label-box {
    padding: 10px 0;
    display: flex;
    align-items: center;
    font-size: 26px;
  }

  .register .s2-1 .label-box label {
    display: flex;
    align-items: center;
  }

  .register .s2-1 .label-box .link {
    color: #00a041;
  }

  .register .s2-1 .label-box .chk {
    position: relative;
    top: -2px;
  }

  .register .s2-1 .label-box .chk .wx-checkbox-input {
    width: 32px;
    height: 32px;
  }

  .register .s3 {
    padding: 0 80px;
  }

  .register .s3 .title {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: row;
    position: relative;
    padding: 20px 0;
    text-align: center;
    color: #888;
    font-size: 28px;
  }

  .register .s3 .title:after {
    content: "";
    position: absolute;
    top: 50%;
    left: 0;
    transform: translateY(-50%);
    width: 100%;
    height: 2px;
    background: #ccc;
  }

  .register .s3 .title .wrap {
    padding: 0 20px;
    position: relative;
    background: #fff;
    z-index: 2;
  }

  .register .s3 .btn-box .btn {
    padding: 0;
    width: 71px;
    height: 61px;
    background: none;
  }

  .register .s3 .btn-box .btn .icon-1 {
    width: 71px;
    height: 61px;
  }

  .register .s4 {
    padding: 30px 0;
    text-align: center;
    font-size: 24px;
    color: #bbb;
  }

</style>

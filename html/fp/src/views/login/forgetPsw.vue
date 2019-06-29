<template>
  <div class="forgetPsw">
    <div class="loginLogo">
      <img src="@/../static/img/login-logo.png" alt="">
    </div>
    <div class="registerBox">
      <h3>找回密码</h3>
      <input class="input" type="text" placeholder="请输入手机号码" v-model="phone">
      <div class="tipPsw">请输入账号绑定的手机号码</div>
      <div class="yanzheng">
        <input class="input" type="text" placeholder="请输入验证码" style="width:140px" v-model="messageCode">
        <span class="getCode" v-if="sendAuthCode" @click="getCode">获取验证码</span>
        <span class="getCode" v-else style="padding: 10px 15px;">
          <span>{{auth_time}}</span>秒后重新获取</span>
      </div>
      <div class="tipPsw">请输入收到短信中的验证码</div>
      <input class="input" type="password" placeholder="请输入新密码" v-model="password">
      <div class="tipPsw">密码至少为字母、数字、符号两种组成的8-16字符</div>
      <input class="input" type="password" style="margin-bottom:30px" placeholder="请确认登录密码" v-model="password1">
      <el-button type="success" plain style="width:100%;height:35px;border:1px solid #41d787;color:#00a041;background:#ecfcf2;font-size:14px;line-height: 5px;" @click="submit()">提交</el-button>
      <div class="returnBack" @click="handleLogin">返回登录页</div>
    </div>
  </div>
</template>

<script>
import { encrypt } from '@/util'
export default {
  data() {
    return {
      sendAuthCode: true,
      auth_time: 0,
      phone: "",
      messageCode: "",
      password: "",
      password1: ""
    };
  },
  created() {},
  methods: {
    handleLogin() {
      this.$router.push({ path: "/login" });
    },
    submit() {
      let phone = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
      let psw = /^(?!^\d+$)(?!^[A-Za-z]+$)(?!^[^A-Za-z0-9]+$)(?!^.*[\u4E00-\u9FA5].*$)^\S{8,16}$/;
      let code = /^[0-9]{6}$/;
      if (!phone.test(this.phone)) {
        this.$message.error("请输入11位正确的手机号码");
        return;
      }
      if (!code.test(this.messageCode)) {
        this.$message.error("请输入6位数字验证码");
        return;
      }
      if (!psw.test(this.password)) {
        this.$message.error(
          "密码至少为字母、数字、符号两种组成的8-16字符，不包含空格,不能输入中文"
        );
        return;
      }
      if (this.password != this.password1) {
        this.$message.error("两次输入的密码不一致");
        return;
      }
      let _this = this;
      this.api.post({
        url: "updatePassword",
        data: {
          messageCode: _this.messageCode,
          password: encrypt(_this.password),
          phone: encrypt(_this.phone)
        },
        // dataFlag: false,
        callback: function(res) {
          if (res.code == "0000") {
            _this.$message.success("修改密码成功");
            setTimeout(() => {
              _this.$router.push("/");
            }, 1000);
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    getCode() {
      let phone = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
      if (!phone.test(this.phone)) {
        this.$message.error("请输入11位正确的手机号码");
        return;
      }
      let _this = this;
      this.api.get({
        url: `getCode`,
        data: {
          phone: _this.phone
        },
        // dataFlag: true,
        // urlFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.sendAuthCode = false;
            _this.auth_time = 60;
            var auth_timetimer = setInterval(() => {
              _this.auth_time--;
              if (_this.auth_time <= 0) {
                _this.sendAuthCode = true;
                clearInterval(auth_timetimer);
              }
            }, 1000);
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.forgetPsw {
  font-family: "微软雅黑";
  font-size: 13px;
  color: #333;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: url("../../../static/img/beijing.png") 100% 100% / 100% 100%
    no-repeat;
  input:focus {
    border-color: #00a041 !important;
  }
  .returnBack {
    color: #00a041;
    cursor: pointer;
    position: relative;
    right: -282px;
    top: 20px;
    font-size: 12px;
  }
  .loginLogo {
    position: absolute;
    width: 155px;
    height: 38px;
    left: 160px;
    top: 35px;
    img {
      width: 100%;
      height: 100%;
    }
  }
  .registerBox,
  .registerBox2 {
    background: rgba(255, 255, 255, 0.95);
    padding: 21px 95px;
    padding-bottom: 35px;
    width: 282px;
    // height: 415px;
    // height: 220px;
    border-radius: 10px;
    position: relative;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    > h3 {
      color: #00a041;
      font-weight: normal;
      text-align: center;
      margin-bottom: 30px;
      font-size: 16px;
    }
    .input {
      height: 35px;
      border: 1px solid #eee;
      width: 266px;
      color: #333;
      font-size: 13px;
      text-indent: 15px;
      border-radius: 5px;
    }
    .input::-webkit-input-placeholder {
      color: #b7b7b7;
      font-size: 12px;
    }
    .tipPsw {
      font-size: 12px;
      margin: 5px 0 15px 0;
      margin-left: 15px;
      color: #666;
    }
    .yanzheng {
      .getCode {
        display: inline-block;
        background-color: #00a041;
        color: #fff;
        padding: 10px 24px;
        border-radius: 5px;
        margin-left: 10px;
        cursor: pointer;
      }
    }
    .regFoot {
      margin-top: 30px;
      margin-bottom: 20px;
      .emailReg {
        position: absolute;
        left: -85px;
        .iconfont {
          font-size: 13px;
        }
      }
      > span {
        position: absolute;
        right: -85px;
      }
    }
  }
}
</style>

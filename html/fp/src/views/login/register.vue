<template>
  <div class="register" v-loading="loading">
    <div class="loginLogo">
      <img src="@/../static/img/login-logo.png" alt="">
    </div>
    <div class="registerBox">
      <h3>注册新用户</h3>
      <input class="input" type="text" placeholder="请输入手机号码" v-model.trim="phone" @blur="inputBlur">
      <div class="tipPsw">请输入正确手机号码，可用于登录或找回密码</div>
      <div class="yanzheng">
        <input class="input" type="text" placeholder="请输入验证码" style="width:140px" v-model="messageCode">
        <span class="getCode" v-if="sendAuthCode" @click="getCode">获取验证码</span>
        <span class="getCode" v-else style="padding: 10px 15px;">
          <span>{{auth_time}}</span>秒后重新获取</span>
      </div>
      <div class="tipPsw">请输入收到短信中的验证码</div>
      <input class="input" type="password" placeholder="请输入登录密码" v-model="password">
      <div class="tipPsw">密码至少为字母、数字、符号两种组成的8-16字符</div>
      <input class="input" type="password" placeholder="请确认登录密码" v-model="password1">
      <div class="userAgree">
        <!-- <input id="usercheckBox" v-model="checked" type="checkbox"> -->
        <i class="iconfont icon-xuanzhong" v-if="xuanzhong" @click="xuanzhong=false"></i>
        <i class="iconfont icon-weixuanzhong1" v-else @click="xuanzhong=true"></i>
        <!-- <label for="checkBox"> -->
        <span class="remeberpw">
          <span>我已阅读并同意</span>
          <span style="color:#f00">用户协议</span>
        </span>
        <!-- </label> -->
      </div>
      <el-button type="success" plain style="width:100%;height:35px;border:1px solid #41d787;color:#00a041;background:#ecfcf2;font-size:14px;line-height: 5px;" @click="registerForm">注册</el-button>
      <div class="regFoot pr">
        <div @click="$router.push({path:'/'})">返回首页</div>
        <span>我已有账号，
          <i style="color:#00a041;font-size:13px;cursor: pointer;" @click="handleLogin">直接登录</i>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      sendAuthCode: true,
      auth_time: 0,
      xuanzhong: true,
      // checked: true,
      phone: "",
      messageCode: "",
      password: "",
      password1: "",
      loading:false
    };
  },
  created() {},
  methods: {
    inputBlur(){
        this.api.get({
        url: "accountIsExist",
        data: {
          registerAccount:this.phone
        },
        callback: (res) =>{
          if (res.code == "0000") {
            this.$message.error('当前账号已注册');
            return
          } 
        }
      });
    }, 
    handleLogin() {
      this.$router.push({ path: "/login" });
    },
    registerForm() {
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
      if (!this.xuanzhong) {
        this.$message.error("请先同意用户协议");
        return;
      }
      this.loading = true;
      let _this = this;
      this.api.post({
        url: "addUser",
        data: {
          messageCode: _this.messageCode,
          password: _this.password,
          phone: _this.phone
        },
        dataFlag: false,
        callback: function(res) {
          _this.loading = false;
          if (res.code == "0000") {
            _this.$message.success("注册成功");
            _this.$confirm('注册成功, 是否登录?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'success '
            }).then(() => {
              _this.loading = true;
                _this.api.post({
                  url: "loginURL",
                  data: {
                    account: _this.phone,
                    password: _this.password
                  },
                  dataFlag: false,
                  callback: function(res) {
                    _this.loading = false;
                    if (res.code == "0000") {
                      sessionStorage.token = res.data;
                      _this.$router.push({
                        path: "/",
                        // query: { account: _this.phone }
                      });
                    } else {
                      _this.$message.error(res.result);
                    }
                  }
                });
            }).catch(() => {

            });
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
        // url: `springcloud-user/guest/userJoin/getCode?phone=${_this.phone}`,
        url: "getCode",
        data: {
          phone: _this.phone
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
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
.register {
  font-family: "微软雅黑";
  font-size: 13px;
  color: #333;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: -1;
  background: url("../../../static/img/beijing.png") 100% 100% / 100% 100%
    no-repeat;
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
   input:focus{
      border-color: #00a041 !important;
    }
  .registerBox,
  .resiter2 {
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
      // width: 266px;
      width: 100%;
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
    .userAgree {
      margin: 21px 0 27px 0;
      .icon-weixuanzhong1,
      .icon-xuanzhong {
        font-size: 14px;
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
        .emailItem {
          color: red;
          cursor: pointer;
        }
      }
      > div {
        position: absolute;
        left: -80px;
        font-size: 12px;
        color: #666;
        cursor: pointer;
      }
      > span {
        position: absolute;
        right: -80px;
        font-size: 12px;
      }
    }
  }
}
</style>

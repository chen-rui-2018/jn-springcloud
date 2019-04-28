<template>
  <div class="loginbg">
    <div class="loginLogo">
      <img src="@/../static/img/login-logo.png" alt="">
    </div>
    <div class="loginBox">
      <el-form ref="loginform" :model="loginform">
        <input type="text" placeholder="请输入手机号码" v-model.trim="loginform.account">
        <input type="password" placeholder="请输入密码" v-model.trim="loginform.password">
        <span class="forgetPass" @click="handleForpsw">忘记密码？</span>
        <el-button plain style="width:100%;height:40px;line-height:14px;border:1px solid #41d787;color:#00a041;background:#ecfcf2;font-size:14px;" @click="loginForm('loginform')">登&nbsp;录</el-button>
        <div class="returnBack" @click="$router.push({path:'/'})">返回首页</div>
        <span class="register" @click="handleRester">立即注册</span>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loginform: {
        account: "",
        password: ""
      },
      input: ""
    };
  },
  created() {
    // this.init();
  },
  methods: {
    handleForpsw() {
      this.$router.push({ path: "forgetPsw" });
    },
    handleRester() {
      this.$router.push({ path: "register" });
    },
    loginForm(loginform) {
      if (!this.loginform.account) {
        this.$message.error("请输入用户名");
        return;
      }
      if (!this.loginform.password) {
        this.$message.error("请输入密码");
        return;
      }
      let _this = this;
      this.api.post({
        url: "loginURL",
        data: {
          account: _this.loginform.account,
          password: _this.loginform.password
        },
        dataFlag: false,
        callback: function(res) {
          if (res.code == "0000") {
            sessionStorage.token = res.data;
            // _this.api.setToken(res.data);
            _this.$router.push({
              path: "/userinfo",
              query: { account: _this.loginform.account }
            });
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
.loginbg {
  font-family: "微软雅黑";
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: -1;
  background: url("../../../static/img/beijing.png") 100% 100% / 100% 100%
    no-repeat;
  .loginLogo {
    width: 155px;
    height: 38px;
    img {
      width: 100%;
      height: 100%;
      padding-left: 160px;
      padding-top: 35px;
    }
  }
  .loginBox {
    background: rgba(255, 255, 255, .95);
    padding: 45px 75px;
    width: 266px;
    height: 185px;
    // height: 220px;
    border-radius: 10px;
    position: relative;
    top: 45%;
    left: 50%;
    transform: translate(-50%, -50%);
    input {
      height: 40px;
      border: 1px solid #eee;
      width: 266px;
      color: #333;
      font-size: 13px;
      text-indent: 15px;
      border-radius: 5px;
    }
    input:nth-child(1) {
      margin-bottom: 20px;
    }
    input::-webkit-input-placeholder {
      color: #b7b7b7;
      font-size: 12px;
    }
    // .el-form-item:nth-child(2) {
    //   margin-bottom: 0;
    // }
    .forgetPass {
      display: inline-block;
      font-size: 13px;
      color: #f00;
      margin: 5px 0;
      margin-left: 16px;
      margin-bottom: 10px;
      cursor: pointer;
    }
    .register {
      // display: inline-block;
      font-size: 13px;
      color: #f00;
      position: absolute;
      right: 20px;
      bottom: 10px;
      cursor: pointer;
    }
    .returnBack {
      font-size: 13px;
      position: absolute;
      left:20px;
      bottom:10px;
      cursor: pointer;
    }
  }
}
</style>

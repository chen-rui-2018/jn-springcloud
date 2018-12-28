<template>
  <div class="login-container">
    <div class="loginTitle"/>
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on" label-position="left">

      <!-- <div class="title-container">
        <h3 class="title">登陆系统</h3>
      </div> -->

      <el-form-item prop="username">
        <!-- <span class="svg-container">
          <svg-icon icon-class="user" />
        </span> -->
        <el-input v-model="loginForm.username" placeholder="请输入用户名" name="username" type="text" clearable auto-complete="on" maxlength="16" />
      </el-form-item>

      <el-form-item prop="password">
        <!-- <span class="svg-container">
          <svg-icon icon-class="password" />
        </span> -->
        <el-input :type="passwordType" v-model="loginForm.password" placeholder="请输入密码" name="password" clearable auto-complete="on" maxlength="16" @keyup.enter.native="handleLogin" />
        <span class="show-pwd" @click="showPwd">
          <svg-icon icon-class="eye" />
        </span>
      </el-form-item>

      <!-- <el-button :loading="loading" style="width:100%;margin-bottom:20px;" @click.native.prevent="handleLogin">登&nbsp;&nbsp;&nbsp;&nbsp;录</el-button> -->
      <el-button :loading="loading" style="width:100%;margin-bottom:20px;" @click="submitForm('loginForm')" @click.native.prevent="handleLogin">登&nbsp;&nbsp;&nbsp;&nbsp;录</el-button>
      <div class="formFooter">
        <input id="checkBox" type="checkbox" checked><label for="checkBox"><span class="remeberpw">&nbsp;&nbsp;记住密码</span></label>
        <a href="javascript:void(0)" class="forgetpw">忘记密码</a>
      </div>
    </el-form>
    <!-- <footer class="footer">
      <span>版权所有&nbsp;&copy;深圳君南信息系统有限公司</span>
      <i>苏ICP00000000号-1</i>
      <span>地址：南京白下高新科技园区</span>
    </footer> -->
  </div>
</template>

<script>
// import { isvalidUsername } from '@/utils/validate'

export default {
  name: 'Login',
  data() {
    var validatePassword = (rule, value, callback) => {
      const reg = /^[a-zA-Z0-9_!~&@]{6,16}$/
      if (!reg.test(value)) {
        callback(new Error('请输入6到16位由字母或数字组成的密码'))
      } else {
        callback()
      }
    }
    const validateUsername = (rule, value, callback) => {
      const reg = /[A-Za-z0-9]{6,16}$/
      if (!reg.test(value)) {
        callback(new Error('请输入6到16位长度字符的数字及字母'))
      } else {
        callback()
      }
    }
    return {
      loginForm: {
        username: 'wangsong',
        password: 'wangsong'
      },
      loginRules: {
        username: [
          { required: true, message: '用户名不能为空', trigger: 'blur' },
          { validator: validateUsername, trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' },
          { validator: validatePassword, trigger: 'blur' }
        ]
      },
      passwordType: 'password',
      loading: false,
      showDialog: false,
      redirect: undefined
    }
  },
  // watch: {
  //   $route: {
  //     handler: function(route) {
  //       this.redirect = route.query && route.query.redirect
  //     },
  //     immediate: true
  //   }
  // },
  mounted() {
    this.getCookie()
  },
  created() {
    // window.addEventListener('hashchange', this.afterQRScan)
  },
  destroyed() {
    // window.removeEventListener('hashchange', this.afterQRScan)
  },
  methods: {
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          this.$store
            .dispatch('LoginByUsername', this.loginForm)
            .then(() => {
              this.loading = false
              this.$router.push({ path: this.redirect || '/' })
            })
            .catch(() => {
              this.loading = false
            })
        } else {
          return false
        }
      })
    },
    submitForm(formName) {
      const self = this
      if (self.checked === true) {
        console.log('checked == true')
        self.setCookie(self.loginForm.username, self.loginForm.password, 7)
      } else {
        console.log('清空Cookie')
        self.clearCookie()
      }
    },
    setCookie(c_name, c_pwd, exdays) {
      var exdate = new Date() // 获取时间
      exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays) // 保存的天数//字符串拼接cookie
      window.document.cookie = 'userName' + '=' + c_name + ';path=/;expires=' + exdate.toGMTString()
      window.document.cookie = 'userPwd' + '=' + c_pwd + ';path=/;expires=' + exdate.toGMTString()
    },
    // 读取cookie
    getCookie: function() {
      if (document.cookie.length > 0) {
        var arr = document.cookie.split('; ')
        for (var i = 0; i < arr.length; i++) {
          var arr2 = arr[i].split('=')
          if (arr2[0] === 'userName') {
            this.loginForm.username = arr2[1]
          } else if (arr2[0] === 'userPwd') {
            this.loginForm.password = arr2[1]
          }
        }
      }
    },
    // 清除cookie
    clearCookie: function() {
      this.setCookie('', '', -1) // 修改2值都为空，天数为负1天就好了
    }

  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg: #80d5c2;
$light_gray: #eee;
$cursor: #fff;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
    &::first-line {
      color: $light_gray;
    }
  }
}

/* reset element-ui css */
.login-container {
  background: url("/static/corporate/logo/bg222.jpg") 100% 100% / 100% 100%
    no-repeat;
    .loginTitle{
      position: absolute;
      top:150px;
      left:340px;
      width:434px;
      height:41px;
      background: url("/static/corporate/logo/wenzi1.png") 100% 100% / cover no-repeat;
    }
  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.2);
    background: #80d5c2;
    border-radius: 5px;
    color: #454545;
  }
  .el-input {
    display: inline-block;
    height: 35px;
    width: 90%;
    input {
      background: transparent;
      text-align: center;
      font-family: "微软雅黑";
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 35px;
      caret-color: $cursor;
      &:-webkit-autofill {
        -webkit-box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
     }
    }
  }

</style>

<style rel="stylesheet/scss" lang="scss" scoped>
$bg: #2d3a4b;
$dark_gray: #889aa4;
$light_gray: #eee;

.login-container {
  position: fixed;
  height: 100%;
  width: 100%;
  background-color: $bg;
  .login-form {
    position: absolute;
    top: 15%;
    left: -28%;
    right: 0;
    width: 250px;
    max-width: 100%;
    // padding: 35px 35px 15px 35px;
    margin: 120px auto;
  }
  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;
    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }
  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }
  .title-container {
    position: relative;
    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }
  .show-pwd {
    position: absolute;
    right: 10px;
    top: 3px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
  .el-button {
    height: 38px;
    font-size: 16px;
    font-family: "微软雅黑";
    color: #878787;
    border-radius: 10px;
  }
  .formFooter {
    font-size: 12px;
    .remeberpw{
      color:#404343 !important;
      font-weight: normal;
    }
    .forgetpw {
      float: right;
      color:#404343;
    }
    input[type="checkbox"]{
      width:13.5px;
      height:13.5px;
      display: inline-block;
      text-align: center;
      vertical-align: top;
      line-height: 13.5px;
      position: relative;
      }
    input[type="checkbox"]::before{
      content: "";
      position: absolute;
      top: 0;
      left: 0;
      background: #47c1a8;
      width: 100%;
      height: 100%;
      border: 1px solid #404343;
      }
    input[type="checkbox"]:checked::before{
      content: "\2714";
      background-color: #47c1a8;
      position: absolute;
      top: 0;
      left: 0;
      width:100%;
      border: 1px solid #404343;
      color:#404343;
      font-size: 12px;
      font-weight: bolder;
      }
  }
  .footer {
    position: absolute;
    bottom: 110px;
    left: 32%;
    color: #898989;
    font-size: 13px;
    i {
      font-style: normal;
      margin: 0 30px;
    }
  }
}
</style>

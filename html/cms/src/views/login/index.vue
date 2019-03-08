<template>
  <div class="login-container">
    <div class="login-logo">
      <img src="/static/corporate/logo/logo.jpg" alt="logo图片">
    </div>
    <div class="loginTitle">白下高新区</div>
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on" label-position="left">

      <!-- <div class="title-container">
        <h3 class="title">登陆系统</h3>
      </div> -->

      <el-form-item prop="username">
        <!-- <span class="svg-container">
          <svg-icon icon-class="user" />
        </span> -->
        <!-- <input v-model="loginForm.username" type="text"  placeholder="请输入用户名" name="username" clearable auto-complete="on" maxlength="16"> -->
        <el-input v-model="loginForm.username" placeholder="请输入用户名" class="username-input" name="username" type="text" clearable auto-complete="on" maxlength="16" />
      </el-form-item>

      <el-form-item prop="password" class="password">
        <!-- <span class="svg-container">
          <svg-icon icon-class="password" />
        </span> -->
        <el-input :type="passwordType" v-model="loginForm.password" placeholder="请输入密码" name="password" auto-complete="on" clearable maxlength="16" @keyup.enter.native="handleLogin" />
        <span class="show-pwd" @click="showPwd">
          <svg-icon icon-class="eye" />
        </span>
      </el-form-item>

      <!-- <el-button :loading="loading" style="width:100%;margin-bottom:20px;" @click.native.prevent="handleLogin">登&nbsp;&nbsp;&nbsp;&nbsp;录</el-button> -->
      <el-button :loading="loading" class="login-button" @click.native.prevent="handleLogin">登&nbsp;&nbsp;&nbsp;&nbsp;录</el-button>
      <div class="formFooter">
        <input id="checkBox" v-model="checked" type="checkbox" ><label for="checkBox"><span class="remeberpw">&nbsp;&nbsp;记住密码</span></label>
        <!-- <a href="javascript:void(0)" class="forgetpw">忘记密码</a> -->
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
      checked: true,
      loginForm: {
        username: '',
        password: ''
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
  created() {
    this.initlist()
    // window.addEventListener('hashchange', this.afterQRScan)
  },
  destroyed() {
    // window.removeEventListener('hashchange', this.afterQRScan)
  },
  methods: {
    initlist() {
      if (localStorage.getItem('username')) {
        this.loginForm.username = localStorage.getItem('username')
        this.loginForm.password = localStorage.getItem('password')
      }
    },
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
    },
    handleLogin() {
      if (this.loading) {
        return
      }
      const _this = this
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          this.$store
            .dispatch('LoginByUsername', this.loginForm)
            .then((response) => {
              _this.loading = false
              if (response.code === '0000') {
                _this.$router.push({ path: this.redirect || '/' })
              }
              if (this.checked) {
                localStorage.setItem('username', this.loginForm.username)
                localStorage.setItem('password', this.loginForm.password)
              } else {
                localStorage.removeItem('username')
                localStorage.removeItem('password')
              }
            })
            .catch(() => {
              _this.loading = false
            })
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg: #80d5c2;
$light_gray: #eee;
$cursor: #fff;

// @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
//   .login-container .el-input input {
//     // color: $cursor;
//     // &::first-line {
//     //   // color: $light_gray;
//     // }
//   }
// }

/* reset element-ui css */
.login-container {
  background: url("/static/corporate/logo/login.png") 100% 100% / 100% 100%
    no-repeat;
    .loginTitle{
      position: absolute;
      top:26%;
      left:0;
      right: 0;
      font-family: "微软雅黑";
      font-size: 50px;
      color: #fff;
    text-align: center;
      // position: absolute;
      // top:150px;
      // left:340px;
      // width:434px;
      // height:50px;
    }
     input::-webkit-input-placeholder {
        /* placeholder颜色  */       color: #606266 !important;
        /* placeholder字体大小  */
         font-size: 18px;
        /* placeholder位置  */
      // text-align: right;
    }
  .el-form-item {
    // border: 1px solid rgba(255, 255, 255, 0.2);
    // background: #80d5c2;
    border-radius: 5px;
    line-height: 53px;
    height: 53px;
    font-size: 18px;
    color:#999999;
    background-color: rgb(255, 154, 255);
    // color: #454545;
  }
    .el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
    line-height: 53px !important;
}
.password{
  background: #fff;
  border-radius: 5px;
}
.el-input__suffix{
  right:25px;
}
.el-input .el-input__clear{
  width:20px;
  color:d2d2d2;
}
  .el-input {
    display: inline-block;
    // height: 35px;
    width: 100%;
    input {
      background: transparent;
      text-align: center;
      font-family: "微软雅黑";
      font-size: 18px;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      // &:-webkit-autofill {
      //   -webkit-box-shadow: 0 0 0px 1000px $bg inset !important;
      //   -webkit-text-fill-color: $cursor !important;
      // }
     }
    }
  }

</style>

<style lang="scss" scoped>
$bg: #2d3a4b;
$dark_gray: #889aa4;
$light_gray: #eee;
.login-logo{
   position: absolute;
      top:40px;
      left:68px;
}
.login-container {
  position: fixed;
  height: 100%;
  width: 100%;
  // background-color: $bg;
  .login-form {
    position: absolute;
    top: 35%;
    left: 0%;
    right: 0;
    width: 350px;
    max-width: 100%;
    margin: 0 auto;
  }
  // .tips {
  //   font-size: 14px;
  //   color: #fff;
  //   margin-bottom: 10px;
  //   span {
  //     &:first-of-type {
  //       margin-right: 16px;
  //     }
  //   }
  // }
  // .svg-container {
  //   padding: 6px 5px 6px 15px;
  //   color: $dark_gray;
  //   vertical-align: middle;
  //   width: 30px;
  //   display: inline-block;
  // }
  // .title-container {
  //   position: relative;
  //   .title {
  //     font-size: 26px;
  //     color: $light_gray;
  //     margin: 0px auto 40px auto;
  //     text-align: center;
  //     font-weight: bold;
  //   }
  // }
  .show-pwd {
    position: absolute;
    right: 10px;
    top: 3px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
  .login-button {
    height: 53px;
    font-size: 24px;
    font-family: "微软雅黑";
    color: #fff;
    background:rgb(0, 160, 65);
    border-radius: 10px;
    width:100%;
    margin-bottom:20px;
         border: none;
  }
   .remeberpw{
      color:#fff;
      font-weight:400;
      cursor: pointer;
      font-size:16px;
    }
    #checkBox{
      height: 15px;
      width: 15x;
      vertical-align:middle;
    }
  .formFooter {
    input[type="checkbox"]{
      width:15px;
      // height:13.5px;
      display: inline-block;
      text-align: center;
      vertical-align: top;
      // line-height: 13.5px;
      position: relative;
      cursor: pointer;
      }
    input[type="checkbox"]::before{
      content: "";
      position: absolute;
      top: 0;
      left: 0;
      background: #fff;
      width: 100%;
      height: 100%;
      // border: 1px solid rgb(255, 154, 255);
      }
    input[type="checkbox"]:checked::before{
      content: "\2713";
       background-color: rgb(255, 154, 255);
      position: absolute;
      top: 0;
      left: 0;
      width:100%;
      border: 1px solid rgb(255, 154, 255);
      color:#fff;
      font-size: 12px;
      font-weight: bolder;
      }
  }
  // .footer {
  //   position: absolute;
  //   bottom: 110px;
  //   left: 32%;
  //   color: #898989;
  //   font-size: 13px;
  //   i {
  //     font-style: normal;
  //     margin: 0 30px;
  //   }
  // }
}
</style>

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
          <span style="color:#f00; cursor: pointer" @click="showAgreement = true">用户协议</span>
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
    <el-dialog
      :visible.sync="showAgreement"
      title="注册条款"
      center
      width="50%">
      <div class="agreement-sign">
        <div class="agreement-paragraph">
          <div class="agreement-main">
            <div class="agreement-tips">欢迎您在白下高新区企业服务空间注册，在您注册之前，请先认真阅读本协议!</div>
            <div class="agreement-tips">为方便园区企业用户，提高办事效率，加强企业与政府的沟通交互，白下高新区管委会通过开通企业服务空间，实现政府面向企业网上服务的统一入口，实现政府与企业的沟通交互的统一门户。您通过注册即可使用企业服务空间，请您遵守以下条款：</div>
          </div>
        </div>
        <div class="agreement-paragraph">
          <div class="agreement-title">（一）、白下高新区企业服务空间提供的服务内容：</div>
          <div class="agreement-main">
            <div class="agreement-content">
              <div>（1）白下高新区企业服务空间是白下高新区政府面向企业网上服务系统开通的统一门户，用户在门户注册成功，一次登录可以访问接入门户的多个系统；</div>
              <div>（2）企业服务空间提供在线申报功能，企业可以在线进行事项申报，查询办理状态，查看申报历史；</div>
              <div>（3）企业服务空间提供政企交互功能，用户登录后可以查看通知公告、平台公告、政策宣传，参与政府发布的活动报名及问卷调查问卷活动；</div>
              <div>（4）企业服务空间提供消息提醒功能，用户登录后可以查看企业服务空间的消息通知以及接入门户应用系统发送的消息通知。</div>
            </div>
          </div>
        </div>
        <div class="agreement-paragraph">
          <div class="agreement-title">（二）、用户注册要求</div>
          <div class="agreement-main">
            <div class="agreement-content">
              <div>（1）企业服务空间面向企业用户，每个用户需要隶属于一家企业，详细规则参照《白下高新区企业服务空间用户管理规范》；</div>
              <div>（2）用户注册角色分为：企业管理员、企业一般用户，企业管理员的注册需要企业提供授权文件，授权文件可在注册时根据注册提示信息获取；企业一般用户注册信息由企业管理员负责审核，审核通过后才可以登录空间办事；</div>
              <div>（3）企业用户采用自我维护机制，每个企业需要设置一名企业管理员，负责审核企业用户注册信息；</div>
              <div>（4）企业服务空间用户注册采用实名制原则，为确保空间及时将各类信息及时通知到您，用户注册信息的手机或邮箱均需要验证。</div>
              <div>（5）用户应妥善保管个人帐号和密码，凡使用您的帐号进行网上办事、咨询、投诉和查询，企业服务空间均视为您亲自办理；用户将自行承担因密码保管不善带来的不利后果；</div>
              <div>（6）个人信息变更时请及时登录企业服务空间进行信息修改；</div>
            </div>
          </div>
        </div>
        <div class="agreement-paragraph">
          <div class="agreement-title">（三）、隐私保护</div>
          <div class="agreement-main">
            <div class="agreement-tips">保护用户隐私是白下高新区企业服务空间的一项基本政策，企业服务空间保证不对外公开或向第三方提供用户注册资料及用户在使用网络服务时存储在白下高新区企业服务空间平台的非公开内容，但下列情况除外：</div>
            <div class="agreement-content">
              <div>（1）事先获得用户的明确授权；</div>
              <div>（2）据有关的法律法规要求；</div>
              <div>（3）照相关政府主管部门或司法部门的要求；</div>
              <div>（4）为维护社会公众的利益；</div>
              <div>（5）为维护白下高新区企业服务空间平台的合法权益；</div>
            </div>
          </div>
        </div>
        <div class="agreement-paragraph">
          <div class="agreement-title">（四）、免责声明</div>
          <div class="agreement-main">
            <div class="agreement-tips">用户明确同意其使用白下高新区企业服务空间，网络服务所存在的风险将完全由其自己承担；因其使用空间网络服务而产生的一切后果也由其自己承担，白下高新区管委会对用户不承担任何责任。</div>
            <div class="agreement-tips">白下高新区企业服务空间不保证提供的网络服务一定能满足用户的要求，也不承诺网络服务不会中断，对网络服务的及时性、安全性、准确性都不作承诺，且不对上述事项承担任何责任。</div>
          </div>
        </div>
        <div class="agreement-paragraph">
          <div class="agreement-title">（五）、服务条款的完善和修改</div>
          <div class="agreement-main">
            <div class="agreement-tips">白下高新区企业服务空间有权根据互联网的发展和中华人民共和国有关法律、法规的变化，不时地完善和修改服务条款。用户在使用企业服务空间的服务时，应事先仔细阅读和重新确认企业服务空间服务条款（含变更条款）。用户一经登录企业服务空间，即被视为已经阅读并同意接受企业服务空间服务条款内容以及对条款所做的变更。当发生有关争议时，请以最新的服务条款为准。</div>
          </div>
        </div>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="showAgreement = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { setToken } from '@/util/auth'
import { encrypt } from '@/util'
export default {
  data() {
    return {
      showAgreement: false,
      sendAuthCode: true,
      auth_time: 0,
      xuanzhong: false,
      // checked: true,
      phone: "",
      messageCode: "",
      password: "",
      password1: "",
      loading: false
    };
  },
  created() {},
  methods: {
    inputBlur() {
      let _this=this
      this.api.get({
        url: "accountIsExist",
        data: {
          registerAccount: this.phone
        },
        callback: res => {
          if (res.code == "0000") {
            if(res.data=='fail'){
              _this.$message.error("当前账号已注册");
              return
            }
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
          password: encrypt(_this.password),
          phone: encrypt(_this.phone)
        },
        dataFlag: false,
        callback: function(res) {
          _this.loading = false;
          if (res.code == "0000") {
            _this.$message.success("注册成功");
            _this
              .$confirm("注册成功, 是否登录?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "success "
              })
              .then(() => {
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
                      setToken(res.data)
                      _this.$router.push({
                        path: "/"
                        // query: { account: _this.phone }
                      });
                    } else {
                      _this.$message.error(res.result);
                    }
                  }
                });
              })
              .catch(() => {});
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
.agreement-sign {
  line-height: 24px;
}
.agreement-title {
  font-weight: 600;
}.agreement-tips {
   text-indent: 2em;
 }

.register {
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
  input:focus {
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

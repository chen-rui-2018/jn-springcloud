<template>
  <div class="upgradeStaff" v-loading="loading">
    <div class="ordinary_title">
      升级员工
    </div>
    <div class="ordinary_main">
      <div class="formData">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="名号" prop="name">
            <label slot="label">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
            <el-input v-model.trim="ruleForm.name" clearable></el-input>
          </el-form-item>
          <el-form-item label="出生年月" prop="date1">
            <el-date-picker v-model="ruleForm.date1" type="month" placeholder="请选择出生年月">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="联系手机" prop="phone">
            <el-input v-model="ruleForm.phone" maxlength="11" minlenght="11" clearable></el-input>
          </el-form-item>
          <el-form-item label="真实姓名" prop="realname">
            <el-input v-model.trim="ruleForm.realname" clearable></el-input>
          </el-form-item>
          <el-form-item label="加入公司" prop="joinCom">
            <el-select v-model="ruleForm.joinCom" placeholder="请选择公司名" value-key='id' @change="change" clearable>
              <el-option :label="i.comName" :value="i" v-for="i in companyList" :key="i.id"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item prop="code">
            <el-input v-model="ruleForm.checkCode" class="input1" placeholder="请输入验证码" style="width:150px" clearable></el-input>
            <span class="getCode" v-if="sendAuthCode" @click="getCode">获取验证码</span>
            <span class="getCode" v-else style="padding: 0px 15px;">
              <span>{{auth_time}}</span>秒后重新获取</span>
            <div class="tipPsw">请输入收到短信中的验证码</div>
          </el-form-item>
        </el-form>
        <div class="businessFooter">
          <span @click="submit('ruleForm')">提交审核</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    var checkPhoneNumber = (rule, value, callback) => {
      const reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
      if (!reg.test(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    return {
      loading: false,
      sendAuthCode: true,
      auth_time: 0,
      comId: "",
      comName: "",
      companyList: "",
      sendData: {
        keyWords: "",
        orgId: "",
        page: 1,
        productStatus: "",
        productType: 0,
        rows: 8
      },
      ruleForm: {
        name: "",
        phone: "",
        date1: "",
        realname: "",
        joinCom: "",
        checkCode: "",
      },
      rules: {
        name: [{ required: true, message: "请输入名号", trigger: "blur" }],
        age: [{ required: true, message: "请选择出生年月", trigger: "change" }],
        date1: [
          {
            // type: "month",
            required: true,
            message: "请选择日期",
            trigger: "change"
          }
        ],
        phone: [
          { required: true, message: "请输入手机号码", trigger: "blur" },
          { validator: checkPhoneNumber, trigger: "blur" }
        ],
        realname: [
          { required: true, message: "请输入真实姓名", trigger: "blur" }
        ],
        joinCom: [
          { required: true, message: "请选择公司名字", trigger: "change" }
        ]
      }
    };
  },
  mounted() {
    this.getOrgId();
    this.selectCompany();
  },
  methods: {
    change(v) {
      console.log(v);
      this.comName = v.comName;
      this.comId = v.id;
    },
    submit(formName) {
      // let phone = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
      // let psw = /^(?!^\d+$)(?!^[A-Za-z]+$)(?!^[^A-Za-z0-9]+$)(?!^.*[\u4E00-\u9FA5].*$)^\S{8,16}$/;
      // let code = /^[0-9]{6}$/;
      // if (!phone.test(this.ruleForm.phone)) {
      //   this.$message.error("请输入11位正确的手机号码");
      //   return;
      // }
      // if (!code.test(this.ruleForm.code)) {
      //   this.$message.error("请输入6位数字验证码");
      //   return;
      // }
      this.$refs[formName].validate(valid => {
        if (valid) {
          let _this = this;
          this.api.post({
            url: "changeToStaff",
            data: {
              checkCode: _this.ruleForm.checkCode,
              comName: _this.comName,
              comId: _this.comId
            },
            callback: function(res) {
              if (res.code == "0000") {
                _this.$message.success('提交成功，等待审核');
                 _this.$refs['ruleForm'].resetFields();
                 _this.ruleForm.checkCode=''
              }
            }
          });
        } else {
          _this.$message.error(res.result);
          return false;
        }
      });
    },
    //获取短信验证码
    getCode() {
      // let phone = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
      // if (!this.ruleForm.phone.test(phone)) {
      //   this.$message.error("请输入11位正确的手机号码");
      //   return;
      // }
      let _this = this;
      this.api.get({
        // url: `springcloud-user/guest/userJoin/getCode?phone=${_this.phone}`,
        url: "getUserCode",
        data: {
          // phone: _this.ruleForm.phone
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
    },
    // 获取当前登录id
    getOrgId() {
      let _this = this;
      this.api.get({
        url: "getUserExtension",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            // _this.sendData.orgId = res.data.id;
            _this.$nextTick(() => {
              _this.selectCompany();
            });
          }
        }
      });
    },
    // 查询公司
    selectCompany() {
      let _this = this;
      this.api.get({
        url: "selectCompany",
        data: {
          comName: ""
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.companyList = res.data;
          }
        }
      });
    }
  }
};
</script>

<style lang="scss">
.upgradeStaff {
  width: 100%;
  .ordinary_title {
    background-color: #fff;
    padding: 17px;
    font-size: 13px;
    border-radius: 5px;
  }
  .ordinary_main {
    margin-top: 14px;
    background-color: #fff;
    padding: 17px;
    .el-form-item__content {
      line-height: 33px;
    }
    .el-input{
      width: 266px;
    }
    .el-input__inner {
      width: 266px;
      height: 33px;
    }
    .input1 .el-input__inner {
      width: 150px;
    }
    .el-form-item {
      height: 33px;
    }
    .el-form-item__error {
      padding-top: 0;
    }
    .formData {
      padding-top: 40px;
      width: 500px;
      margin: 0 auto;
    }
    .getCode {
      display: inline-block;
      background-color: #00a041;
      color: #fff;
      padding: 0 20px;
      border-radius: 5px;
      margin-left: 6px;
      cursor: pointer;
    }
    .el-button {
      width: 50%;
      height: 35px;
      border: 1px solid #41d787;
      color: #00a041;
      background: #ecfcf2;
      font-size: 14px;
      line-height: 5px;
    }
    .businessFooter {
      margin-top: 58px;
      text-align: center;
      margin-bottom: 17px;
      > span {
        display: inline-block;
        color: rgba(0, 160, 65, 1);
        font-size: 12px;
        padding: 0 20px;
        height: 29px;
        line-height: 29px;
        background: rgba(236, 252, 242, 1);
        border: 1px solid rgba(65, 215, 135, 1);
        border-radius: 4px;
        cursor: pointer;
      }
    }
    .tipPsw {
      font-size: 13px;
    }
  }
}
</style>


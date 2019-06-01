<template>
  <div class="businessInvitation">
    <div class="business_title font16">
      <div class="font16">企业邀请</div>
    </div>
    <div class="business_content">
      <div class="enterprise">企业邀请</div>
      <el-form class="tableEnterprise">
        <div style="display:flex">
          <el-form-item label="企业名称:">
            <span>{{comName}}</span>
          </el-form-item>
          <el-form-item label="企业简称:" class="borr">
            <span>{{comNameShort}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="产业领域:">
            <span>{{induTypeName}}</span>
          </el-form-item>
          <el-form-item label="法人:" class="borr">
            <span>{{ownerLaw}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="联系电话:">
            <span>{{conPhone}}</span>
          </el-form-item>
          <el-form-item label="注册时间:">
            {{foundingTime}}
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="落地时间:">
            <span>{{runTime}}</span>
          </el-form-item>
          <el-form-item label="注册地址:" class="borr">
            <span>{{comAddress}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="实际经营地址:">
            <span>{{addrPark}}</span>
          </el-form-item>
          <el-form-item label="固定电话:">
            <span>{{comTele}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="注册资金（万元）:">
            <span>{{regCapital}}</span>
          </el-form-item>
          <el-form-item label="企业规模:" class="borr">
            <span>{{comScale}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="统一社会信用代码:" class="borb">
            <span>{{unifyCode}}</span>
          </el-form-item>
          <el-form-item label="企业性质:" class="borr borb">
            <span>{{comPropertyNames}}</span>
          </el-form-item>
        </div>
        <!-- <div style="display:flex">
          <el-form-item label="所属园区:" class=" borb">
            <span>{{parkBuildName}}</span>
          </el-form-item>
          <el-form-item label="企业官网地址:" class=" borb borr">
            <span>{{comWeb}}</span>
          </el-form-item>
        </div> -->

      </el-form>
      <div style="padding:10px 0px;">企业已发布企业简介，查看详情点击<router-link class="mainColor" :to="{path: '/profileDetails', query: {id:supplementForm.comId } }">企业简介</router-link>
      </div>
      <el-form class="enterprise_bottom" label-position="right" label-width="142px">
        <el-form-item label="企业LOGO:">
          <img :src="avatar.url" alt="LOGO图片" class="enterprise_img">
        </el-form-item>
        <el-form-item label="三证一体或营业执照:">
          <img :src="businessLicense.url" alt="营业执照" class="enterprise_img">
        </el-form-item>
      </el-form>
      <div class="enterprise">补充资料</div>
      <el-form class="supplement" :rules="rules" :model="supplementForm" ref="supplementForm">
        <div style="display:flex">
          <el-form-item label="名称:" prop="nickName">
            <label slot="label">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
            <el-input v-model="supplementForm.nickName" clearable></el-input>
          </el-form-item>
          <el-form-item label="出生年月:" prop="birthday">
            <el-date-picker v-model="supplementForm.birthday" type="date" value-format="yyyy-MM-dd" placeholder="选择出生年月">
            </el-date-picker>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="联系手机:" prop="phone">
            <el-input v-model="supplementForm.phone" maxlength='11' clearable></el-input>
          </el-form-item>
          <el-form-item label="真实姓名:" prop="name">

            <el-input v-model="supplementForm.name" clearable></el-input>
          </el-form-item>
        </div>

      </el-form>
      <div class="footer ct">
        <el-button size="mini" :disabled="disabled" class="mainColor accept" @click="handleAccept">接受邀请</el-button>
        <el-button size="mini" type="success" @click="toUserCenter" class="footerCancel">拒绝邀请</el-button>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  data() {
    var checkPhone = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("手机号不能为空"));
      } else {
        const reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
        if (reg.test(value)) {
          callback();
        } else {
          return callback(new Error("请输入正确的手机号"));
        }
      }
    };
    return {
      birthdayOptions: [],
      disabled: false,
      userAccount: "",
      foundingTime: "", //注册时间
      comName: "", //企业名称
      comNameShort: "", //企业简称
      induTypeName: "", //行业分类ID(产业领域、所属行业)
      ownerLaw: "", //法人
      comTele: "", //固定电话
      runTime: "", //落地时间
      unifyCode: "", //统一社会信用代码
      comAddress: "", //注册地址
      addrPark: "", //公司园区地址-实际经营地址
      conPhone: "", //联系电话
      regCapital: "", //注册资本 万元
      comScale: "", //企业规模
      comType: "", //企业类型
      // parkBuildName: "", //园区名称
      // comWeb: "", //企业官网地址
      avatar: "", //企业logo
      businessLicense: "", //营业执照
      comPropertyNames: "", //企业性质名称，
      supplementForm: {
        // account: sessionStorage.account,
        birthday: "",
        comId: "",
        name: "",
        nickName: "",
        phone: ""
      },
      rules: {
        nickName: [{ required: true, message: "请输入名称", trigger: "blur" }],
        phone: [{ required: true, validator: checkPhone, trigger: "blur" }],
        birthday: [
          { required: true, message: "请选择出生年月", trigger: "change" }
        ],
        name: [{ required: true, message: "请输入真实姓名", trigger: "blur" }]
      }
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    //   接受邀请
    handleAccept() {
      this.disabled = true;
      this.$refs["supplementForm"].validate(valid => {
        if (valid) {
          this.api.post({
            url: "acceptInvite",
            data: this.supplementForm,
            callback: res => {
              if (res.code == "0000") {
                this.$message({
                  message: "操作成功",
                  type: "success"
                });
                this.$router.push({
                  path: "/home"
                });
              } else {
                this.$message.error(res.result);
                return false;
              }
              this.disabled = true;
            }
          });
        } else {
          this.disabled = false;
        }
      });
    },
    init() {
      console.log(this.$route.query)
      this.supplementForm.comId = this.$route.query.comId;
      let _this = this;
      _this.api.get({
        url: "getCompanyDetailByAccountOrCompanyId",
        data: { accountOrCompanyId: this.$route.query.comId },
        callback: function(res) {
          console.log(res);
          if (res.code == "0000") {
            _this.comName = res.data.comName;
            _this.comNameShort = res.data.comNameShort;
            _this.induTypeName = res.data.induTypeName;
            _this.ownerLaw = res.data.ownerLaw;
            _this.comTele = res.data.comTele;
            _this.runTime = res.data.runTime;
            _this.unifyCode = res.data.unifyCode;
            _this.comAddress = res.data.comAddress;
            _this.addrPark = res.data.addrPark;
            _this.conPhone = res.data.conPhone;
            _this.regCapital = res.data.regCapital;
            _this.comScale = res.data.comScale;
            _this.comType = res.data.comType;
            // _this.parkBuildName = res.data.parkBuildName;
            _this.foundingTime = res.data.foundingTime;
            // _this.comWeb = res.data.comWeb;
            _this.avatar = res.data.avatar;
            _this.businessLicense = res.data.businessLicense;
          }
        }
      });
    },

    toUserCenter() {
      this.api.post({
        url: "refuseInvite",
        data: { comId: this.supplementForm.comId },
        dataFlag: true,
        callback: res => {
          if (res.code == "0000") {
            this.$message({
              message: "操作成功",
              type: "success"
            });
            this.$router.push({ path: "/home" });
          } else {
            this.$message.error(res.result);
            return false;
          }
        }
      });
    }
  }
};
</script>

<style lang="scss" >
.businessInvitation {
  .footer {
    margin: 0 auto;
    margin-top: 100px;
    height: 29px;
    line-height: 29px;
    margin-bottom: 17px;
    .accept {
      background: rgba(236, 252, 242, 1);
      border: 1px solid rgba(65, 215, 135, 1);
      border-radius: 4px;
      color: #00a041;
    }
    .footerCancel {
      background: rgba(0, 160, 65, 1);
    }
  }
  .supplement {
    color: #00a041;
    .el-form-item__error {
      left: 15px;
    }
    .el-input {
      width: 266px;
    }
    padding-left: 100px;
    .el-input__inner {
      line-height: 32px;
      height: 32px;
      width: 266px;
    }
    .el-form-item__label {
      width: 75px;
      line-height: 32px;
      // padding: 15px 0;
      display: inline-block;
      //   background-color: #f0f0f0;
      //   border: 1px solid #ccc;
      display: flex;
      //   line-height: 45px;
      // padding-left: 13px;
      font-size: 13px;
      padding-right: unset;
    }
    .el-form-item {
      margin-bottom: 23px;
      flex: 1;
      display: flex;
    }
    .el-form-item__content {
      line-height: 32px;
      flex: 1;
      display: inline-block;
      padding-left: 13px;
      // padding: 15px;
      //   border: 1px solid #ccc;
    }
  }
  .tableEnterprise {
    .borb {
      border-bottom: 1px solid #ccc;
    }
    .borr {
      border-right: 1px solid #ccc;
    }
    .el-form-item__label {
      width: 133px;
      // padding: 15px 0;
      display: inline-block;
      background-color: #f0f0f0;
      // border: 1px solid #ccc;
      border-top: unset;
      display: flex;
      line-height: 45px;
      padding-left: 13px;
      font-size: 13px;
      // padding-right: unset;
    }
    .el-form-item {
      margin-bottom: 0px;
      flex: 1;
      border-top: 1px solid #ccc;
      border-left: 1px solid #ccc;
      display: flex;
    }
    .el-form-item__content {
      flex: 1;
      display: inline-block;
      padding-left: 13px;
      // padding: 15px;
      // border-bottom: 1px solid #ccc;
    }
  }

  .business_title {
    // width: 813px;
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: #333;
    padding: 19px 27px;
    // font-size: 13px;
    border-radius: 5px;
    .business_nav {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 18px 0px;
      margin-right: 8px;
      border-bottom: 1px solid #ccc;
    }
    // .myBusiness {
    //   color: #333;
    //   font-size: 13px;
    // }
  }
  .business_content {
    background: #fff;
    margin-top: 14px;
    // width: 813px;
    padding: 21px 28px;
    .enterprise {
      margin-bottom: 16px;
      border-left: 4px solid rgb(0, 160, 65);
      font-size: 13px;
      padding: 0px 15px;
    }
    .enterprise_bottom {
      .el-form-item {
        margin-top: 36px;
        font-size: 13px;
        color: #333;
      }

      .enterprise_img {
        width: 115px;
        // height: 69px;
      }
    }
  }
  .business_footer {
    margin: 0 auto;
    margin-top: 58px;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    height: 29px;
    line-height: 29px;
    width: 90px;
    color: #41d787;
    background: rgba(236, 252, 242, 1);
    border: 1px solid rgba(65, 215, 135, 1);
    margin-bottom: 17px;
  }
}
</style>

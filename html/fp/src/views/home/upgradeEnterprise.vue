<template>
  <div class="upgradeEnterprise" v-loading="loading">
    <div class="business_title">
      <div class="myBusiness">升级企业</div>
    </div>
    <div class="business_content">
      <div class="enterprise">企业信息
        <span>(一个企业账号只可以设置一位总负责人，其他用户可以申请成为您的企业负责人，需要总负责人审核，也可申请成为普通员工，需要经过负责)</span>
      </div>
      <el-form class="tableEnterprise" :rules="rules" :model="businessForm" ref="businessForm">
        <div style="display:flex">
          <el-form-item label="企业名称:" class="inline" prop="comName">
            <el-input v-model="businessForm.comName" clearable></el-input>
            <!-- <span>{{comName}}</span> -->
          </el-form-item>
          <el-form-item label="企业简称:" class="inline" prop="comNameShort">
            <el-input v-model="businessForm.comNameShort" clearable></el-input>
            <!-- <span>{{comNameShort}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="主营行业:" class="inline" prop="induType">
            <el-select v-model="businessForm.induType" placeholder="请选择主营行业" clearable>
              <el-option v-for="item in induTypeOptions" :key="item.id" :label="item.preValue" :value="item.id">
              </el-option>
            </el-select>
            <!-- <span>{{induTypeName}}</span> -->
          </el-form-item>
          <el-form-item label="法人:" class="inline" prop="ownerLaw">
            <label slot="label">法&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人:</label>
            <el-input v-model="businessForm.ownerLaw" clearable></el-input>
            <!-- <span>{{ownerLaw}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="联系电话:" class="inline" prop="ownerPhone">
            <el-input v-model="businessForm.ownerPhone" clearable></el-input>
            <!-- <span>{{conPhone}}</span> -->
          </el-form-item>
          <el-form-item label="注册时间:" class="inline" prop="foundingTime">
            <el-date-picker value-format="yyyy-MM-dd" v-model="businessForm.foundingTime" type="date" placeholder="选择日期">
            </el-date-picker>
            <!-- {{foundingTime}} -->
          </el-form-item>
        </div>
        <!-- <div style="display:flex">
          <el-form-item label="落地时间:" lass="inline" prop="runTime">
            <el-date-picker value-format="yyyy-MM-dd" v-model="businessForm.runTime" type="date" placeholder="选择日期">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="注册地址:" lass="inline" prop="comAddress">
            <el-input v-model="businessForm.comAddress" clearable></el-input>
          </el-form-item>
        </div> -->
        <div style="display:flex">
          <el-form-item class="br" label="实际经营地址:" lass="inline" prop="addrPark">
            <el-input v-model="businessForm.addrPark" clearable></el-input>
            <!-- <span>{{addrPark}}</span> -->
          </el-form-item>
          <el-form-item label="固定电话:" lass="inline" prop="comTele">
            <el-input v-model="businessForm.comTele" clearable></el-input>
            <!-- <span>{{conPhone}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="注册资金(万元):" lass="inline" prop="regCapital" class="brLine">
            <el-input v-model="businessForm.regCapital" clearable></el-input>
            <!-- <span>{{regCapital}}</span> -->
          </el-form-item>
          <el-form-item label="企业规模(人):" lass="inline" prop="comScale" class="brLine">
            <!-- <el-input v-model="businessForm.comScale" clearable></el-input> -->
            <el-select v-model="businessForm.comScale" placeholder="请选择企业规模" clearable>
              <el-option v-for="item in typeList" :key="item.codeName" :label="item.codeValue" :value="item.codeName">
              </el-option>
            </el-select>
            <!-- <span>{{comScale}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item class="br" label="统一社会信用代码:" lass="inline" prop="unifyCode">
            <el-input v-model="businessForm.unifyCode" clearable></el-input>
            <!-- <span>{{unifyCode}}</span> -->
          </el-form-item>
          <el-form-item label="企业性质:" lass="inline" prop="comPropertys">
            <el-select v-model="businessForm.comPropertys" multiple placeholder="请选择企业性质" clearable :multiple-limit=3>
              <el-option v-for="item in comPropertyOptions" :key="item.id" :label="item.preValue" :value="item.id">
              </el-option>
            </el-select>
            <!-- <span>{{comType}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="所属园区:" lass="inline" prop="affiliatedPark">
            <el-select v-model="businessForm.affiliatedPark" placeholder="请选择所属园区" clearable>
              <el-option v-for="item in parkList" :key="item.id" :label="item.parkName" :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="企业来源:" lass="inline" prop="comSource">
            <el-select v-model="businessForm.comSource" placeholder="请选择企业来源" clearable>
              <el-option v-for="item in comSourceOptions" :key="item.value" :label="item.label" :value="item.value">
              </el-option>
            </el-select>
            <!-- <span>{{comWeb}}</span> -->
          </el-form-item>

        </div>
        <div style="display:flex">
          <el-form-item label="我的服务:" lass="inline" prop="comServer">
            <label slot="label">&nbsp;&nbsp;&nbsp;&nbsp;我的服务:</label>
            <el-input v-model="businessForm.comServer" clearable maxlength=20></el-input>
          </el-form-item>
          <el-form-item label="我的需求:" lass="inline" prop="comDemand">
            <label slot="label">&nbsp;&nbsp;&nbsp;我的需求:</label>
            <el-input v-model="businessForm.comDemand" clearable maxlength=20></el-input>
          </el-form-item>

        </div>
        <div style="display:flex">
          <el-form-item label="注册地址:" lass="inline" prop="comAddress">
            <el-input v-model="businessForm.comAddress" clearable></el-input>
            <!-- <span>{{comAddress}}</span> -->
          </el-form-item>
          <el-form-item label="企业官网地址:" lass="inline" class="br" prop="comWeb">
            <el-input v-model="businessForm.comWeb" clearable></el-input>
          </el-form-item>
        </div>
        <el-form-item label="企业LOGO:" class="br enterprise_bottom" prop="avatar">
          <el-upload class="avatar-uploader" :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'" :headers="headers" :show-file-list="false" :on-success="handleAvatarSuccess" :before-upload="beforeUpload">
            <img v-if="businessForm.avatar" :src="businessForm.avatar" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
        <el-form-item label="三证一体或营业执照:" class="br" prop="businessLicense">
          <el-dialog :visible.sync="businessLicenseDialogVisible">
            <img width="100%" :src="businessLicenseUrl" alt="LOGO图片">
          </el-dialog>
          <el-upload class="avatar-uploader" :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'" :headers="headers" :show-file-list="false" :on-success="handleBusinessLicenseSuccess" :before-upload="beforeUpload">
            <img v-if="businessForm.businessLicense" :src="businessForm.businessLicense" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
        <el-form-item prop="checkCode">
          <el-input v-model="businessForm.checkCode" class="input1" placeholder="请输入验证码" style="width:200px" clearable></el-input>
          <!-- <span class="getCode">获取验证码</span> -->
          <span class="getCode" v-if="sendAuthCode" @click="getCode">获取验证码</span>
          <span class="getCode" v-else style="padding: 0px 15px;">
            <span>{{auth_time}}</span>秒后重新获取</span>
          <!-- <div class="tipPsw">请输入收到短信中的验证码</div> -->
        </el-form-item>
      </el-form>
      <div class="businessFooter">
        <span @click="submitCompany('businessForm')">提交审核</span>
      </div>
    </div>

  </div>
</template>

<script>
import { getToken } from "@/util/auth";
export default {
  data() {
    var checkPhoneNumber = (rule, value, callback) => {
      const reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
      if (!reg.test(value)) {
        callback("请输入正确的手机号码");
      } else {
        callback();
      }
    };
    var checkWeb = (rule, value, callback) => {
      const reg = /^(http|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?$/;
      if (!reg.test(value)) {
        callback("请输入正确的网址");
      } else {
        callback();
      }
    };
    var checkTel = (rule, value, callback) => {
      const reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
      if (!reg.test(value)) {
        callback("请输入正确的电话格式");
      } else {
        callback();
      }
    };
    var checkNumber = (rule, value, callback) => {
      const reg = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/;
      if (!reg.test(value)) {
        callback("请输入大于0的数字");
      } else {
        callback();
      }
    };
     var checkComScale = (rule, value, callback) => {
      const reg = /^[1-9][0-9]*$/;
      if (!reg.test(value)) {
        callback("请输入大于0的整数");
      } else {
        callback();
      }
    };
    return {
      loading: false,
      baseUrl: this.api.host,
      fileList: [],
      showImg: false,
      auth_time: 0,
      sendAuthCode: true,
      input: "",
      imageUrl: "",
      headers: {
        token: getToken()
      },
      comSourceOptions: [
        {
          value: 1,
          label: "人才企业"
        },
        {
          value: 2,
          label: "招商企业"
        }
      ],
      parkList: [],
      imgParamsDialogVisible: false,
      imgParamsUrl: "",
      businessLicenseDialogVisible: false,
      avatarUrl: "",
      businessLicenseUrl: "",
      avatarDialogVisible: false,
      comPropertyOptions: [],
      induTypeOptions: [],
      userAccount: "",
      typeList:[],
      businessForm: {
        comPropertys: [],
        affiliatedPark: "",
        comServer: "", //我的服务
        comDemand: "", //我的需求
        comSource: "",
        foundingTime: "", //注册时间
        comName: "", //企业名称
        comNameShort: "", //企业简称
        induType: "", //行业分类ID(产业领域、所属行业)
        ownerLaw: "", //法人
        comTele: "", //固定电话
        runTime: "", //落地时间
        unifyCode: "", //统一社会信用代码
        comAddress: "", //注册地址
        addrPark: "", //公司园区地址-实际经营地址
        ownerPhone: "", //联系电话
        regCapital: "", //注册资本 万元
        comScale: "", //企业规模
        comType: "", //企业类型
        //    parkBuildName:'',//园区名称
        comWeb: "", //企业官网地址
        avatar: "", //企业logo
        businessLicense: "", //营业执照
        checkCode: ""
      },
      rules: {
        comName: [
          { required: true, message: "请输入企业名称", trigger: "blur" }
        ],
        comNameShort: [
          { required: true, message: "请输入企业简称", trigger: "blur" }
        ],
        induType: [
          { required: true, message: "请选择主营行业", trigger: "change" }
        ],
        ownerLaw: [{ required: true, message: "请输入法人", trigger: "blur" }],
        ownerPhone: [
          { required: true, message: "请输入联系电话", trigger: "blur" },
          { validator: checkPhoneNumber, trigger: "blur" }
        ],
        foundingTime: [
          { required: true, message: "请选择注册时间", trigger: "change" }
        ],
        runTime: [
          { required: true, message: "请选择落地时间", trigger: "change" }
        ],
        addrPark: [
          { required: true, message: "请输入实际经营地址", trigger: "blur" }
        ],
        comTele: [
          // { required: false, message: "", trigger: "blur" }
        ],
        regCapital: [
          { required: true, message: "请输入注册资金", trigger: "blur" },
          { validator: checkNumber, trigger: "blur" }
        ],
        comScale: [
          { required: true, message: "请选择企业规模", trigger: "change" }
          // { validator: checkComScale, trigger: "blur" }
        ],
        unifyCode: [
          { required: true, message: "请输入统一社会信用代码", trigger: "blur" }
        ],
        affiliatedPark: [
          { required: true, message: "请选择所属园区", trigger: "change" }
        ],
        comSource: [
          { required: true, message: "请选择企业来源", trigger: "change" }
        ],
        // comServer: [
        //   { required: true, message: "请输入我的服务", trigger: "blur" }
        // ],
        // comDemand: [
        //   { required: true, message: "请输入我的需求", trigger: "blur" }
        // ],
        // comWeb: [
        //   { required: true, message: "请输入企业官网地址", trigger: "blur" }
        // ],
        comAddress: [
          { required: true, message: "请输入注册地址", trigger: "blur" }
        ],
        comPropertys: [
          { required: true, message: "请选择企业性质", trigger: "change" }
        ],
        avatar: [
          { required: true, message: "请选择LOGO图片", trigger: "blur" }
        ],
        businessLicense: [
          { required: true, message: "请选择营业执照", trigger: "blur" }
        ],
        imgParams: [
          { required: true, message: "请选择宣传图片", trigger: "change" }
        ],
        comDetails: [
          { required: true, message: "请输入公司简介", trigger: "blur" }
        ],
        mainProducts: [
          { required: true, message: "请输入产品", trigger: "blur" }
        ]
      }
    };
  },
  mounted() {
    this.selectIndustryList();
    this.getComPropertyOptions();
    this.getParkList();
    this.getInviteType();
  },
  methods: {
    submitCompany(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (
            new Date(this.businessForm.foundingTime) >
            new Date()
          ) {
            this.$message.error("注册时间须小于当前时间");
            return false;
          }
          this.loading = true;
          let _this = this;
          this.api.post({
            url: "changeToCompany",
            data: {
              comNameShort: _this.businessForm.comNameShort,
              comName: _this.businessForm.comName,
              induType: _this.businessForm.induType,
              ownerLaw: _this.businessForm.ownerLaw,
              ownerPhone: _this.businessForm.ownerPhone,
              foundingTime: _this.businessForm.foundingTime,
              runTime: _this.businessForm.runTime,
              comAddress: _this.businessForm.comAddress,
              addrPark: _this.businessForm.addrPark,
              comTele: _this.businessForm.comTele,
              regCapital: _this.businessForm.regCapital,
              comScale: _this.businessForm.comScale,
              unifyCode: _this.businessForm.unifyCode,
              comPropertys: _this.businessForm.comPropertys,
              affiliatedPark: _this.businessForm.affiliatedPark,
              comSource: _this.businessForm.comSource,
              comServer: _this.businessForm.comServer,
              comDemand: _this.businessForm.comDemand,
              comWeb: _this.businessForm.comWeb,
              avatar: _this.businessForm.avatar,
              businessLicense: _this.businessForm.businessLicense,
              checkCode: _this.businessForm.checkCode
            },
            callback: function(res) {
              _this.loading = false;
              if (res.code == "0000") {
                _this.$message.success("提交成功，等待审核");
                _this.$refs["businessForm"].resetFields();
              } else {
                _this.$message.error(res.result);
                // _this.businessForm.comProperty.split(',')
                return false;
              }
            }
          });
        }
      });
    },
    //企业规模
     getInviteType() {
      let _this = this;
      this.api.get({
        url: "getInviteType",
        data: {
          groupId: "companyScale"
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.typeList = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //所属园区
    getParkList() {
      let _this = this;
      this.api.get({
        url: "getParkList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.parkList = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //获取验证码
    getCode() {
      this.$refs["businessForm"].validate(valid => {
        if (valid) {
          if (
            new Date() <
            new Date(this.businessForm.foundingTime)
          ) {
            this.$message.error("注册时间须小于当前时间");
            return false;
          }
          let _this = this;
          this.api.get({
            url: "getUserCode",
            data: {},
            callback: function(res) {
              if (res.code == "0000") {
                _this.$message.success(res.data);
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
      });
    },
    selectIndustryList() {
      this.api.get({
        url: "selectTeamList",
        data: { preType: 1 },
        callback: res => {
          this.induTypeOptions = res.data;
        }
      });
    },
    getComPropertyOptions() {
      this.api.get({
        url: "selectTeamList",
        data: { preType: 3 },
        callback: res => {
          this.comPropertyOptions = res.data;
        }
      });
    },
    handleExceed(files, fileList) {
      this.$message.warning(`只能上传一张图片`);
    },
    handleAvatarRemove(file, fileList) {
      this.avatarUrl = "";
    },
    handleAvatarPictureCardPreview(file) {
      this.avatarUrl = file.url;
      this.avatarDialogVisible = true;
    },
    handleAvatarSuccess(res, file) {
      this.businessForm.avatar = res.data;
      if (this.businessForm.avatar) {
          this.$refs['businessForm'].clearValidate('avatar')
        }
    },
    // 文件上传之前的函数
    beforeUpload(file) {
      const isLt2M = file.size / 1024 / 1024 < 5;
      if (!isLt2M) {
        this.$message.error("上传图片大小不能超过 5MB!");
        return false;
      }
      if (
        file.name.substr(file.name.lastIndexOf(".")).toLowerCase() !== ".png" &&
        file.name.substr(file.name.lastIndexOf(".")).toLowerCase() !== ".jpg" &&
        file.name.substr(file.name.lastIndexOf(".")).toLowerCase() !== ".gif"
      ) {
        this.$message({
          message: "文件格式错误,请选择png、jpg、gif等格式",
          type: "error"
        });
        return false;
      }
    },
    // 宣传图片上传成功时的函数
    handleimgParamsSuccess(res, file, fileList) {
      // console.log(this.meetingroomForm.attachmentPaths)
      // console.log(file)
      // console.log(fileList)
      // console.log(res)
      // this.businessForm.imgParams.push(res.data)
    },
    // 预览宣传图片
    handleimgParamsPictureCardPreview(file) {
      // if (this.title === '编辑会议室') {
      //   this.dialogImageUrl = file.url
      // }
      this.dialogVisible = true;
    },
    // 删除宣传图片
    handleimgParamsRemove(file, fileList) {
      // 删除的
      // if (this.title === '编辑会议室') {
      //   var editDelFile = file.url
      //   var editIndex = this.meetingroomForm.attachmentPaths.indexOf(editDelFile)
      //   this.meetingroomForm.attachmentPaths.splice(editIndex, 1)
      // } else {
      // 先获取当前用户已经删除了文件路径
      var delFile = file.response.data;
      var index = this.businessForm.imgParams.indexOf(delFile);
      this.businessForm.imgParams.splice(index, 1);
      // }
    },
    handleBusinessLicenseRemove(file, fileList) {
      this.businessLicenseUrl = "";
    },
    handleBusinessLicensePictureCardPreview(file) {
      this.businessLicenseUrl = file.url;
      this.businessLicenseDialogVisible = true;
    },
    handleBusinessLicenseSuccess(res, file) {
      this.businessForm.businessLicense = res.data;
      if (this.businessForm.businessLicense) {
          this.$refs['businessForm'].clearValidate('businessLicense')
        }
    }
  }
};
</script>

<style lang="scss" >
.upgradeEnterprise {
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409eff;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 85px;
    height: 85px;
    line-height: 85px;
    text-align: center;
  }
  .avatar {
    width: 85px;
    height: 85px;
    display: block;
  }
  //   .el-input.is-active .el-input__inner,
  //   .el-input__inner:focus {
  //     border-color: #00a041;
  //   }
  //   .el-select .el-input.is-focus .el-input__inner {
  //     border-color: #00a041;
  // }
  .tipPsw {
    font-size: 13px;
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
  .br {
    .el-form-item__label {
      height: 20px;
      //  text-align: left;
      line-height: 20px !important;
    }
  }
  .el-form-item__error {
    margin-left: 13px;
  }
  .minHeight {
    .el-textarea__inner {
      min-height: 97px !important;
      // width: 100% !important;
      background: #fff;
      // height: unset !important;
      // line-height: unset !important;
    }
    // .editBusiness .tableEnterprise .el-input__inner{

    // }
  }
  .el-upload-list--picture-card .el-upload-list__item {
    width: 85px;
    height: 85px;
  }
  .el-upload--picture-card {
    width: 85px;
    height: 85px;
    line-height: 85px;
  }
  .tableEnterprise {
    .inline {
      display: inline-block;
    }
    .el-input {
      width: 266px;
    }
    .el-input__inner {
      line-height: 32px;
      height: 32px;
      width: 266px;
    }
    .input1 .el-input__inner {
      width: 200px;
    }
    .el-input__icon {
      line-height: 32px;
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
    .brLine {
      .el-form-item__label {
        line-height: 20px;
      }
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

  .business_title {
    // width: 813px;
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 24px 28px 24px;
    // font-size: 13px;
    border-radius: 5px;
    // div:nth-child(2) {
    //   background-color: #ecfcf2;
    //   border-radius: 5px;
    //   border: solid 2px #41d787;
    //   padding: 8px 11px;
    //   font-size: 12px;
    //   cursor: pointer;
    // }
  }
  .business_content {
    background: #fff;
    margin-top: 14px;
    // width: 813px;
    padding: 21px 28px;
    .enterprise {
      margin-bottom: 32px;
      border-left: 4px solid rgb(0, 160, 65);
      font-size: 13px;
      padding: 0px 15px;
      > span {
        color: #00a041;
        font-size: 10px;
      }
    }
    .enterprise_bottom {
      .el-form-item {
        margin-top: 36px;
        font-size: 12px;
        color: #333;
      }
      .el-form-item__label {
        font-size: 12px;
      }
      .enterprise_img {
        width: 115px;
        // height: 69px;
      }
    }
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
}
</style>


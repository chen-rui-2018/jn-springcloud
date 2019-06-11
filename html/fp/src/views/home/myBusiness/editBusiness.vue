<template>
  <div class="editBusiness" v-loading="loading">
    <div class="business_title">
      <div class="font16">编辑企业</div>
    </div>
    <div class="business_content">
      <div class="enterprise">
        企业信息
        <span>(一个企业账号只可以设置一位总负责人，其他用户可以申请成为您的企业负责人，需要总负责人审核，也可申请成为普通员工，需要经过负责)</span>
      </div>
      <el-form class="tableEnterprise" :rules="rules" :model="businessForm" ref="businessForm">
        <div style="display:flex">
          <el-form-item label="企业名称:"  prop="comName">
            <el-input v-model="businessForm.comName" clearable></el-input>
          </el-form-item>
          <el-form-item label="企业简称:"  prop="comNameShort">
            <el-input v-model="businessForm.comNameShort" clearable></el-input>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="主营行业:" prop="induType">
            <el-select v-model="businessForm.induType" placeholder="请选择主营行业" clearable>
              <el-option
                v-for="item in induTypeOptions"
                :key="item.id"
                :label="item.preValue"
                :value="item.id"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="法人:"  prop="ownerLaw">
            <label slot="label">法&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人:</label>
            <el-input v-model="businessForm.ownerLaw" clearable></el-input>
            <!-- <span>{{ownerLaw}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="联系电话:"  prop="ownerPhone">
            <el-input v-model="businessForm.ownerPhone" clearable></el-input>
            <!-- <span>{{conPhone}}</span> -->
          </el-form-item>
          <el-form-item label="注册时间:"  prop="foundingTime">
            <el-date-picker
              value-format="yyyy-MM-dd"
              v-model="businessForm.foundingTime"
              type="date"
              placeholder="选择日期"
              clearable
            ></el-date-picker>
            <!-- {{foundingTime}} -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="落地时间:"  prop="runTime">
            <el-date-picker
              value-format="yyyy-MM-dd"
              v-model="businessForm.runTime"
              type="date"
              placeholder="选择日期"
              clearable
            ></el-date-picker>
          </el-form-item>
          <el-form-item label="注册地址:"  prop="comAddress">
            <el-input v-model="businessForm.comAddress" clearable></el-input>
            <!-- <span>{{comAddress}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item class="br" label="实际经营地址:"  prop="addrPark">
            <el-input v-model="businessForm.addrPark" clearable></el-input>
            <!-- <span>{{addrPark}}</span> -->
          </el-form-item>
          <el-form-item label="固定电话:"  prop="comTele">
            <el-input v-model="businessForm.comTele" clearable></el-input>
            <!-- <span>{{conPhone}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="注册资金（万元）:" class="br" prop="regCapital">
            <el-input v-model="businessForm.regCapital" clearable></el-input>
          </el-form-item>
          <el-form-item label="企业规模（人）:" class="br" prop="comScale">
            <el-input v-model="businessForm.comScale" clearable></el-input>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item class="br" label="统一社会信用代码:"  prop="unifyCode">
            <el-input v-model="businessForm.unifyCode" clearable></el-input>
            <!-- <span>{{unifyCode}}</span> -->
          </el-form-item>
          <el-form-item label="企业性质:"  prop="comProperty">
            <el-select  v-model="businessForm.comProperty" clearable placeholder="请选择企业性质">
              <el-option
                v-for="item in comPropertyOptions"
                :key="item.id"
                :label="item.preValue"
                :value="item.id"
              ></el-option>
            </el-select>
            <!-- <span>{{comType}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="所属园区:" prop="affiliatedPark">
            <el-select v-model="businessForm.affiliatedPark" clearable placeholder="请选择所属园区">
              <el-option
                v-for="item in parkList"
                :key="item.id"
                :label="item.parkName"
                :value="item.id"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="企业来源:"  prop="comSource">
            <el-select v-model="businessForm.comSource" clearable placeholder="请选择企业来源">
              <el-option
                v-for="item in comSourceOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
            <!-- <span>{{comWeb}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="我的服务:" >
            <el-input v-model="businessForm.comServer" clearable></el-input>
          </el-form-item>
          <el-form-item label="我的需求:"  >
            <el-input v-model="businessForm.comDemand" clearable></el-input>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="企业官网地址:"  class="br" prop="comWeb">
            <el-input v-model="businessForm.comWeb" clearable></el-input>
          </el-form-item>
        </div>

        <!-- <el-form
        class="enterprise_bottom"
        label-width="83px"
        :rules="rules"
        >-->
        <el-form-item label="企业LOGO:" class="br enterprise_bottom" prop="avatar">
          <el-upload
              :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
            :headers="headers"
              :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeUpload"
          >
          <img v-if="businessForm.avatar" :src="businessForm.avatar" alt="企业LOGO">
            <i v-else class="el-icon-plus "></i>
          </el-upload>
        </el-form-item>
        <el-form-item label="三证一体或营业执照:" class="br" prop="businessLicense">
          <el-upload
             :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
            :headers="headers"
            :show-file-list="false"
            :on-success="handleBusinessLicenseSuccess"
            :before-upload="beforeUpload"
          >
          <img v-if="businessForm.businessLicense" :src="businessForm.businessLicense" alt="营业执照">
            <i v-else class="el-icon-plus "></i>
          </el-upload>
        </el-form-item>
        <el-form-item label="企业宣传图片:" prop="businessLicense" class="br">
          <el-upload
            :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
            :headers="headers"
            :on-exceed=" handleExceed"
            :limit="5"
            list-type="picture-card"
            :on-success="handleimgParamsSuccess"
            :before-upload="beforeUpload"
            :file-list="fileList"
            :on-preview="handleimgParamsPictureCardPreview"
            :on-remove="handleimgParamsRemove"
          >
            <div v-if="showImg" class="showImg">
              <img v-for="(item,index) in fileList" :key="index" :src="item" alt="企业宣传图片">
            </div>
            <i class="el-icon-plus"/>
          </el-upload>
          <el-dialog :visible.sync="imgParamsDialogVisible" :modal-append-to-body="false">
            <img style="width:100%;height:200px;" :src="dialogImageUrl" alt="企业宣传图片">
          </el-dialog>
        </el-form-item>
        <el-form-item label="公司简介:" class="minHeight" prop="comSynopsis">
          <el-input v-model="businessForm.comSynopsis" autosize type="textarea"></el-input>
        </el-form-item>
        <el-form-item label="产品:"  class="minHeight" prop="mainProducts">
          <label slot="label">产&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;品:</label>
          <el-input v-model="businessForm.mainProducts" autosize  type='textarea' maxlength="500"
  show-word-limit></el-input>
        </el-form-item>
         <el-form-item class="mrf">
          <el-input v-model="businessForm.checkCode" class="input1" placeholder="请输入验证码" style="width:200px"></el-input>
          <!-- <span class="getCode">获取验证码</span> -->
          <span class="getCode" v-if="sendAuthCode" @click="getCode">获取验证码</span>
          <span class="getCode" v-else style="padding: 0px 15px;">
            <span>{{auth_time}}</span>秒后重新获取</span>
          <!-- <div class="tipPsw">请输入收到短信中的验证码</div> -->
        </el-form-item>
      </el-form>
      <div class="bus_footer">
        <span @click="submit">保存修改</span>
        <span>取消</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
      var checkPhone = (rule, value, callback) => {
      const reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
      if (!reg.test(value)) {
        callback("请输入正确的手机号码");
      } else {
        callback();
      }
    };
    //  var checkTel = (rule, value, callback) => {
    //   // const reg = /^0\\d{2,3}-[1-9]\\d{6,7}$/;
    //   const reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
    //   if (!reg.test(value)) {
    //     callback("请输入正确的电话格式");
    //   } else {
    //     callback();
    //   }
    // };
    //   var checkWeb = (rule, value, callback) => {
    //   const reg = /^(http|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?$/;
    //   if (!reg.test(value)) {
    //     callback("请输入正确的网址");
    //   } else {
    //     callback();
    //   }
    // };
    return {
      loading:false,
      baseUrl:this.api.host,
      parkList:[],
      fileList: [],
      showImg: false,
      headers: {
        token: sessionStorage.token
      },
      comSourceOptions: [
        {
          value: '1',
          label: "人才企业"
        },
        {
          value: '2',
          label: "招商企业"
        }
      ],
      imgParamsDialogVisible: false,
      dialogImageUrl: "",
      businessLicenseDialogVisible: false,
      avatarUrl: "",
      businessLicenseUrl: "",
      avatarDialogVisible: false,
      comPropertyOptions: [],
      induTypeOptions: [],
      userAccount: "",
       sendAuthCode: true,
      auth_time: 0,
      businessForm: {
        checkCode:undefined,
        comProperty: '',
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
        propagandaPictureList:[], //企业宣传图片
        comSynopsis:'',//公司简介
        mainProducts:'',//主要产品
      },
      rules: {
        comName: [
          { required: true, message: "请输入企业名称", trigger: "blur" }
        ],
        comNameShort: [
          { required: true, message: "请输入企业简称", trigger: "blur" }
        ],
        induType: [
          { required: true, message: "请选择产业领域", trigger: "change" }
        ],
        ownerLaw: [{ required: true, message: "请输入法人", trigger: "blur" }],
        ownerPhone: [
          { required: true, message: "请输入联系电话", trigger: "blur" },
          { validator: checkPhone, trigger: 'blur' }
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
          { required: true, message: "请输入固定电话", trigger: "blur" },
          // { validator: checkTel, trigger: 'blur' }
        ],
        regCapital: [
          { required: true, message: "请输入注册资金", trigger: "blur" }
        ],
        comScale: [
          { required: true, message: "请输入企业规模", trigger: "blur" }
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
        comWeb: [
          { required: true, message: "请输入企业官网地址", trigger: "blur" },
          // { validator: checkWeb, trigger: 'blur' }
        ],
        comAddress: [
          { required: true, message: "请输入注册地址", trigger: "blur" }
        ],
        comProperty: [
          { required: true, message: "请选择企业性质", trigger: "change" }
        ],
        avatar: [
          { required: true, message: "请选择LOGO图片", trigger: "blur" }
        ],
        businessLicense: [
          { required: true, message: "请选择营业执照", trigger: "blur" }
        ],
        // imgParams: [
        //   { required: true, message: "请选择宣传图片", trigger: "change" }
        // ],
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
    this.init();
    this.getParkList()
  },
  methods: {
     //获取验证码
    getCode() {
      let _this = this;
      this.api.get({
        url: "getUserCode",
        // data: {
        //   phone: _this.businessForm.ownerPhone
        // },
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
      });},
    submit() {

      this.$refs['businessForm'].validate(valid => {
        if (valid) {
          this.loading=true
         this.api.post({
              url: "updateCompanyInfo",
              data: this.businessForm,
              callback: res => {
                 this.loading=false
                if (res.code == "0000") {

                  this.$message({
                    message: "企业信息已提交，请等待后台审核",
                    type: "success"
                  });

                this.$router.push({path:'/myBusiness/index'})
                } else {
                  this.$message.error(res.result);
                  return false;
                }
              }
            });
        } else {
          // this.isDisabled = false
        }
      })
    },
     //所属园区
    getParkList() {
      let _this = this;
      this.api.get({
        url: "getParkList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
           _this.parkList=res.data
          } else {
            _this.$message.error(res.result);
          }
        }
      });},
    init() {
      let _this = this;
      _this.api.get({
        url: "getMyBusiness",
        callback: function(res) {
          console.log(res);
          if (res.code == "0000") {
            _this.businessForm.comName = res.data.comName;
            _this.businessForm.comNameShort = res.data.comNameShort;
            _this.businessForm.induType = res.data.induType;
            _this.businessForm.ownerLaw = res.data.ownerLaw;
            _this.businessForm.comTele = res.data.comTele;
            _this.businessForm.comServer = res.data.comServer;
            _this.businessForm.comDemand = res.data.comDemand;
            _this.businessForm.runTime = res.data.runTime
            _this.businessForm.comSource = res.data.comSource
            _this.businessForm.unifyCode = res.data.unifyCode;
            _this.businessForm.comAddress = res.data.comAddress;
            _this.businessForm.addrPark = res.data.addrPark;
            _this.businessForm.ownerPhone = res.data.ownerPhone;
            _this.businessForm.regCapital = res.data.regCapital;
            _this.businessForm.comScale = res.data.comScale;
            _this.businessForm.comType = res.data.comType;
            _this.businessForm.parkBuildName = res.data.parkBuildName;
            _this.businessForm.affiliatedPark = res.data.affiliatedPark;
            _this.businessForm.foundingTime=res.data.foundingTime
            _this.businessForm.comWeb = res.data.comWeb;
            _this.businessForm.mainProducts = res.data.mainProducts;
            _this.businessForm.comSynopsis = res.data.comSynopsis;
            _this.businessForm.avatar = res.data.avatar;
            _this.businessForm.induCode = res.data.induCode;
            // _this.avatarUrl= res.data.avatar
            _this.businessForm.businessLicense = res.data.businessLicense;
            // _this.businessForm.propagandaPictureList = res.data.propagandaPicture;
            console.log(res.data.propagandaPicture)
            if ( res.data.propagandaPicture) {
              _this.businessForm.propagandaPictureList=res.data.propagandaPicture
              let fileListArr = []
              res.data.propagandaPicture.forEach(val => {
                console.log(val)
                fileListArr.push({ name: '', url: val })
              })
              // 数组去重
              _this.fileList = Array.from(new Set(fileListArr))
            }
            _this.businessForm.comProperty = res.data.comProperty;
          }
        }
      });
    },
    selectIndustryList() {
      this.api.get({
        url: "selectTeamList",
        data: { preType: 1 },
        callback: res => {
          console.log(res);
          this.induTypeOptions = res.data;
        }
      });
    },
    getComPropertyOptions() {
      this.api.get({
        url: "selectTeamList",
        data: { preType: 3 },
        callback: res => {
          console.log(res);
          this.comPropertyOptions = res.data;
        }
      });
    },
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传5张图片`);
    },
    handleAvatarRemove(file, fileList) {
      this.avatarUrl = "";
    },
    handleAvatarPictureCardPreview(file) {
      this.avatarUrl = file.url;
      this.avatarDialogVisible = true;
    },
    handleAvatarSuccess(res, file) {
      // console.log(res,file)
      this.businessForm.avatar = res.data;
    },
    // 文件上传之前的函数
    beforeUpload(file) {
      const isLt2M = file.size / 1024 / 1024 < 1;
      if (!isLt2M) {
        this.$message.error("上传图片大小不能超过 1MB!");
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
      console.log(res)
      this.businessForm.propagandaPictureList.push(res.data)
    },
    // 预览宣传图片
    handleimgParamsPictureCardPreview(file) {
      console.log(file)
        this.dialogImageUrl = file.url
      this.imgParamsDialogVisible = true;
    },
    // 删除宣传图片
    handleimgParamsRemove(file, fileList) {
      // 删除的
        let editDelFile = file.url
        let editIndex = this.businessForm.propagandaPictureList.indexOf(editDelFile)
        this.businessForm.propagandaPictureList.splice(editIndex, 1)

    },
    // beforeUpload(file) {
    //   const isLt2M = file.size / 1024 / 1024 < 5;
    //    const isJPG = file.type === 'image/jpeg'||file.type === 'image/png'
    //   if (!isLt2M) {
    //     this.$message.error('上传图片大小不能超过 5MB!');
    //   }
    //    if (!isJPG) {
    //     this.$message.error('上传图片只能是 JPG、png 格式!');
    //   }
    // return isJPG && isLt2M;
    // },
    handleBusinessLicenseRemove(file, fileList) {
      this.businessLicenseUrl = "";
    },
    handleBusinessLicensePictureCardPreview(file) {
      this.businessLicenseUrl = file.url;
      this.businessLicenseDialogVisible = true;
    },
    handleBusinessLicenseSuccess(res, file) {
      this.businessForm.businessLicense = res.data;
    }
  }
};
</script>

<style lang="scss" >
.editBusiness {
  .el-input{
    width:266px;
  }
  .br {
    .el-form-item__label {
      height: 20px;
      //  text-align: left;
      line-height: 20px !important;
    }
  }
  .mrf{
    margin-left:75px;
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
  .el-form-item__error {
    margin-left: 13px;
  }
  .el-date-editor.el-input, .el-date-editor.el-input__inner{
    width: 266px;
  }
  .el-upload{
     width: 85px;
    height: 85px;
    line-height: 85px;
    // border:none;
    border: 1px dashed #c0ccda;
    border-radius: 6px;
    >i{
      font-size: 28px;
    color: #8c939d;
    }
    >img{
          border-radius: 6px;
      width: 85px;
      height: 85px;
      vertical-align: unset;
    }
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
    border:none;
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
    .el-input__inner {
      line-height: 32px;
      height: 32px;
      width: 266px;
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
  .input1 .el-input__inner {
      width: 200px;
    }
  .bus_footer {
    margin: 0 auto;
    margin-top: 58px;
    // border-radius: 4px;
    text-align: center;
    // cursor: pointer;
    height: 29px;
    line-height: 29px;
    // width: 90px;
    // color: #41d787;
    // background: rgba(236, 252, 242, 1);
    // border: 1px solid rgba(65, 215, 135, 1);
    margin-bottom: 17px;
    > span:nth-child(1) {
      display: inline-block;
      color: rgba(0, 160, 65, 1);
      font-size: 12px;
      width: 90px;
      height: 29px;
      background: rgba(236, 252, 242, 1);
      border: 1px solid rgba(65, 215, 135, 1);
      border-radius: 4px;
      margin-right: 85px;
      cursor: pointer;
    }
    > span:nth-child(2) {
      display: inline-block;
      width: 90px;
      color: rgba(255, 255, 255, 1);
      font-size: 12px;
      height: 29px;
      background: rgba(0, 160, 65, 1);
      border-radius: 4px;
       cursor: pointer;
    }
  }
}
</style>

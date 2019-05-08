<template>
  <div class="editBusiness">
    <div class="business_title">
      <div class="myBusiness">编辑企业</div>
    </div>
    <div class="business_content">
      <div class="enterprise">企业信息 <span>(一个企业账号只可以设置一位总负责人，其他用户可以申请成为您的企业负责人，需要总负责人审核，也可申请成为普通员工，需要经过负责)</span></div>
      <el-form class="tableEnterprise"  :rules="rules" :model="businessForm"  ref="businessForm">
        <div style="display:flex">
          <el-form-item
            label="企业名称:"
            class="inline"
            prop="comName"
          >
          <el-input v-model="businessForm.comName"></el-input>
            <!-- <span>{{comName}}</span> -->
          </el-form-item>
          <el-form-item
            label="企业简称:"
            class="inline"
            prop="comNameShort"
          >
            <el-input v-model="businessForm.comNameShort"></el-input>
            <!-- <span>{{comNameShort}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="产业领域:"
            class="inline"
            prop="induType"
          >
           <el-select
            v-model="businessForm.induType"
            placeholder="请选择产业领域"
          >
            <el-option
              v-for="item in induTypeOptions"
              :key="item.id"
              :label="item.preValue"
              :value="item.id"
            >
            </el-option>
          </el-select>
            <!-- <span>{{induTypeName}}</span> -->
          </el-form-item>
          <el-form-item
            label="法人:"
            class="inline"
             prop="ownerLaw"
          >
           <label slot="label">法&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人:</label>
           <el-input v-model="businessForm.ownerLaw"></el-input>
            <!-- <span>{{ownerLaw}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="联系电话:"
            class="inline"
            prop="conPhone"
          >
          <el-input v-model="businessForm.conPhone"></el-input>
            <!-- <span>{{conPhone}}</span> -->
          </el-form-item>
          <el-form-item
            label="注册时间:"
            class="inline"
            prop="foundingTime"
          >
           <el-date-picker
           value-format="yyyy-MM-dd"
      v-model="businessForm.foundingTime"
      type="date"
      placeholder="选择日期">
    </el-date-picker>
           <!-- {{foundingTime}} -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="落地时间:"
            lass="inline"
            prop="runTime"
          >
            <el-date-picker
           value-format="yyyy-MM-dd"
      v-model="businessForm.runTime"
      type="date"
      placeholder="选择日期">
    </el-date-picker>
            <!-- <span>{{runTime}}</span> -->
          </el-form-item>
          <el-form-item
            label="注册地址:"
            lass="inline"
             prop="comAddress"
          >
          <el-input v-model="businessForm.comAddress"></el-input>
            <!-- <span>{{comAddress}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
          class="br"
            label="实际经营地址:"
            lass="inline"
            prop="addrPark"
          >
          <el-input v-model="businessForm.addrPark"></el-input>
            <!-- <span>{{addrPark}}</span> -->
          </el-form-item>
          <el-form-item
            label="固定电话:"
            lass="inline"
            prop="comTele"
          >
          <el-input v-model="businessForm.comTele"></el-input>
            <!-- <span>{{conPhone}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="注册资金:"
            lass="inline"
           prop="regCapital"
          >
          <el-input v-model="businessForm.regCapital"></el-input>
            <!-- <span>{{regCapital}}</span> -->
          </el-form-item>
          <el-form-item
            label="企业规模:"
            lass="inline"
             prop="comScale"
          >
          <el-input v-model="businessForm.comScale"></el-input>
            <!-- <span>{{comScale}}</span> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
          class="br"
            label="统一社会信用代码:"
            lass="inline"
              prop="unifyCode"
          >
          <el-input v-model="businessForm.unifyCode"></el-input>
            <!-- <span>{{unifyCode}}</span> -->
          </el-form-item>
          <el-form-item
            label="企业性质:"
            lass="inline"
            prop="comPropertys"
          >
           <el-select
           multiple
            v-model="businessForm.comPropertys"
            placeholder="请选择企业性质"
          >
            <el-option
              v-for="item in comPropertyOptions"
              :key="item.id"
              :label="item.preValue"
              :value="item.id"
            >
            </el-option>
          </el-select>
            <!-- <span>{{comType}}</span> -->
          </el-form-item>
        </div>
         <div style="display:flex">
          <el-form-item
            label="所属园区:"
            lass="inline"
             prop="affiliatedPark"
          >
          <el-select
            v-model="businessForm.affiliatedPark"
            placeholder="请选择所属园区"
          >
            <el-option
              v-for="item in comSourceOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
          </el-form-item>
          <el-form-item
            label="企业来源:"
            lass="inline"
            prop="comSource"
          >
           <el-select
            v-model="businessForm.comSource"
            placeholder="请选择企业来源"
          >
            <el-option
              v-for="item in comSourceOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
            <!-- <span>{{comWeb}}</span> -->
          </el-form-item>

        </div>
        <div style="display:flex">
          <el-form-item
            label="我的服务:"
            lass="inline"
            prop="comServer"
          >
          <el-input v-model="businessForm.comServer"></el-input>
          </el-form-item>
          <el-form-item
            label="我的需求:"
            lass="inline"
             prop="comDemand"
          >

          <el-input v-model="businessForm.comDemand"></el-input>
          </el-form-item>

        </div>
         <div style="display:flex">
          <el-form-item
            label="企业官网地址:"
            lass="inline"
            class="br"
            prop="comWeb"
          >
          <el-input v-model="businessForm.comWeb"></el-input>
          </el-form-item>
        </div>

      <!-- <el-form
        class="enterprise_bottom"
        label-width="83px"
        :rules="rules"
      > -->
        <el-form-item label="企业LOGO:" class="br enterprise_bottom" prop="avatar" >
          <el-upload
 action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
 :headers="headers"
 :on-exceed=" handleExceed"
            :limit="1"
  list-type="picture-card"
  :on-success="handleAvatarSuccess"
  :before-upload="beforeUpload"
  :on-preview="handleAvatarPictureCardPreview"
  :on-remove="handleAvatarRemove">
  <i class="el-icon-plus"></i>
</el-upload>
<el-dialog :visible.sync="avatarDialogVisible">
  <img width="100%" :src="avatarUrl" alt="LOGO图片">
</el-dialog>
        </el-form-item>
        <el-form-item label="三证一体或营业执照:" class="br" prop="businessLicense">
            <el-upload
 action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
 :headers="headers"
 :on-exceed=" handleExceed"
            :limit="1"
  list-type="picture-card"
  :on-success="handleBusinessLicenseSuccess"
  :before-upload="beforeUpload"
  :on-preview="handleBusinessLicensePictureCardPreview"
  :on-remove="handleBusinessLicenseRemove">
  <i class="el-icon-plus"></i>
</el-upload>
<el-dialog :visible.sync="businessLicenseDialogVisible">
  <img width="100%" :src="businessLicenseUrl" alt="LOGO图片">
</el-dialog>
        </el-form-item>
        <el-form-item label="企业宣传图片:" class="br" prop="imgParams">
                 <el-upload
 action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
 :headers="headers"
 :on-exceed=" handleExceed"
            :limit="1"
  list-type="picture-card"
  :on-success="handleimgParamsSuccess"
  :before-upload="beforeUpload"
   :file-list="fileList"
  :on-preview="handleimgParamsPictureCardPreview"
  :on-remove="handleimgParamsRemove">
 <div v-if="showImg" class="showImg"><img v-for="(item,index) in fileList" :key="index" :src="item" alt="会议室图片"></div>

            <i class="el-icon-plus"/>
          </el-upload>
<el-dialog :visible.sync="imgParamsDialogVisible">

  <img width="100%" :src="imgParamsUrl" alt="企业宣传图片">
</el-dialog>
        </el-form-item>
        <el-form-item label="公司简介:" class="minHeight" prop="comDetails">
           <el-input v-model="businessForm.comDetails" autosize type="textarea"></el-input>
        </el-form-item>
        <el-form-item label="产品:" class="minHeight" prop="mainProducts">
           <label slot="label">产&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;品:</label>
               <el-input v-model="businessForm.mainProducts" autosize type="textarea"></el-input>
        </el-form-item>
      </el-form>
      <div class="business_footer" >
          <span @click="submit">保存修改</span>    <span>取消</span>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  data() {
    return {
      fileList:[],
      showImg:false,
       headers: {
        token: sessionStorage.token
      },
        comSourceOptions:[{
            value:1,
            label:'人才企业'
        },
        {
            value:2,
            label:'招商企业'
        }],
        imgParamsDialogVisible:false,
        imgParamsUrl:'',
        businessLicenseDialogVisible:false,
        avatarUrl:'',
        businessLicenseUrl:'',
        avatarDialogVisible:false,
        comPropertyOptions:[],
        induTypeOptions:[],
           userAccount:'',
           businessForm:{
               comPropertys:[],
               affiliatedPark:'',
           comServer:'',//我的服务
           comDemand:'',//我的需求
           comSource:'',
           foundingTime:'',//注册时间
           comName:'',//企业名称
           comNameShort:'',//企业简称
           induType:'',//行业分类ID(产业领域、所属行业)
           ownerLaw:'',//法人
           comTele:'',//固定电话
           runTime:'',//落地时间
           unifyCode:'',//统一社会信用代码
           comAddress:'',//注册地址
           addrPark:'',//公司园区地址-实际经营地址
           conPhone:'',//联系电话
           regCapital:'',//注册资本 万元
           comScale:'',//企业规模
           comType:'',//企业类型
        //    parkBuildName:'',//园区名称
           comWeb:'',//企业官网地址
           avatar:'',//企业logo
           businessLicense:'',//营业执照
proImgs:[],//企业宣传图片
           },
             rules: {
          comName: [
            { required: true, message: '请输入企业名称', trigger: 'blur' }
          ],
          comNameShort: [
            { required: true, message: '请输入企业简称', trigger: 'blur' }
          ],
          induType: [
            { required: true, message: '请选择产业领域', trigger: 'change' }
          ],
          ownerLaw: [
            { required: true, message: '请输入法人', trigger: 'blur' }
          ],
          conPhone: [
            { required: true, message: '请输入联系电话', trigger: 'blur' }
          ],
           foundingTime: [
            { required: true, message: '请选择注册时间', trigger: 'change' }
          ],
          runTime: [
            { required: true, message: '请选择落地时间', trigger: 'change' }
          ],
          addrPark: [
            { required: true, message: '请输入实际经营地址', trigger: 'blur' }
          ],
          comTele: [
            { required: true, message: '请输入固定电话', trigger: 'blur' }
          ],
          regCapital: [
            { required: true, message: '请输入注册资金', trigger: 'blur' }
          ],
          comScale: [
            { required: true, message: '请输入企业规模', trigger: 'blur' }
          ],
          unifyCode: [
            { required: true, message: '请输入统一社会信用代码', trigger: 'blur' }
          ],
          affiliatedPark: [
            { required: true, message: '请选择所属园区', trigger: 'change' }
          ],
          comSource: [
            { required: true, message: '请选择企业来源', trigger: 'change' }
          ],
          comServer: [
            { required: true, message: '请输入我的服务', trigger: 'blur' }
          ],
          comDemand: [
            { required: true, message: '请输入我的需求', trigger: 'blur' }
          ],
          comWeb: [
            { required: true, message: '请输入企业官网地址', trigger: 'blur' }
          ],
          comAddress: [
            { required: true, message: '请输入注册地址', trigger: 'blur' }
          ],
          comPropertys: [
            { required: true, message: '请选择企业性质', trigger: 'change' }
          ],
          avatar: [
            { required: true, message: '请选择LOGO图片', trigger: 'blur' }
          ],
          businessLicense: [
            { required: true, message: '请选择营业执照', trigger: 'blur' }
          ],
          imgParams: [
            { required: true, message: '请选择宣传图片', trigger: 'change' }
          ],
          comDetails: [
            { required: true, message: '请输入公司简介', trigger: 'blur' }
          ],
          mainProducts: [
            { required: true, message: '请输入产品', trigger: 'blur' }
          ]
        }

    }
  },
  mounted(){
      this.selectIndustryList()
      this.getComPropertyOptions()
        this.init()
  },
  methods: {
    submit(){

    },
       init(){
          let _this = this;
             _this.api.get({
                   url: "getMyBusiness",
        callback: function(res) {
          console.log(res);
          if (res.code == "0000") {
            _this.businessForm.comName = res.data.comName
            _this.businessForm.comNameShort = res.data.comNameShort
            _this.businessForm.induTypeName = res.data.induTypeName
            _this.businessForm.ownerLaw = res.data.ownerLaw
            _this.businessForm.comTele = res.data.comTele
            // _this.businessForm.runTime = res.data.runTime
            _this.businessForm.unifyCode = res.data.unifyCode
            _this.businessForm.comAddress = res.data.comAddress
            _this.businessForm.addrPark = res.data.addrPark
            _this.businessForm.conPhone = res.data.conPhone
            _this.businessForm.regCapital = res.data.regCapital
            _this.businessForm.comScale = res.data.comScale
            _this.businessForm.comType=res.data.comType
            _this.businessForm.parkBuildName=res.data.parkBuildName
            // _this.businessForm.foundingTime=res.data.foundingTime
            _this.businessForm.comWeb=res.data.comWeb
            _this.businessForm.avatar=res.data.avatar
            _this.businessForm.businessLicense=res.data.businessLicense
            _this.businessForm.proImgs=res.data.proImgs
            _this.businessForm.comPropertys=res.data.comPropertys

          }
        }
      })
      },
     selectIndustryList(){
     this.api.get({
                  url:'selectTeamList',
                 data:{preType:1},
                 callback:(res=>{
                     console.log(res)
                   this.induTypeOptions=res.data
                  })
              })
    },
     getComPropertyOptions(){
     this.api.get({
                  url:'selectTeamList',
                 data:{preType:3},
                 callback:(res=>{
                     console.log(res)
                   this.comPropertyOptions=res.data
                  })
              })
    },
     handleExceed(files, fileList) {
      this.$message.warning(`只能上传一张图片`)
    },
     handleAvatarRemove(file, fileList) {
       this.avatarUrl=''
      },
      handleAvatarPictureCardPreview(file) {
        this.avatarUrl = file.url;
        this.avatarDialogVisible = true;
      },
        handleAvatarSuccess(res, file) {
        this.businessForm.avatar  = res.data;
      },
       // 文件上传之前的函数
    beforeUpload(file) {
       const isLt2M = file.size / 1024 / 1024 < 1;
      if (!isLt2M) {
          this.$message.error('上传图片大小不能超过 1MB!');
          return false
        }
      if ((file.name.substr(file.name.lastIndexOf('.')).toLowerCase()) !== '.png' && (file.name.substr(file.name.lastIndexOf('.')).toLowerCase()) !== '.jpg' && (file.name.substr(file.name.lastIndexOf('.')).toLowerCase()) !== '.gif') {
        this.$message({
          message: '文件格式错误,请选择png、jpg、gif等格式',
          type: 'error'
        })
        return false
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
      this.dialogVisible = true
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
        var delFile = file.response.data
        var index = this.businessForm.imgParams.indexOf(delFile)
        this.businessForm.imgParams.splice(index, 1)
      // }
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
       this.businessLicenseUrl=''
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
  .br{
        .el-form-item__label{
        height:20px;
        //  text-align: left;
        line-height:20px!important;
        }
    }
    .el-form-item__error{
      margin-left:13px;
    }
    .minHeight{
      .el-textarea__inner{
      min-height: 97px !important;
      // width: 100% !important;
      background: #fff;
        // height: unset !important;
        // line-height: unset !important;
      }
      // .editBusiness .tableEnterprise .el-input__inner{

      // }
    }
    .el-upload-list--picture-card .el-upload-list__item{
      width: 85px;
      height: 85px;
    }
    .el-upload--picture-card{
        width: 85px;
      height: 85px;
      line-height: 85px;
    }
  .tableEnterprise {
    .inline {
      display: inline-block;
    }
    .el-input__inner{
        line-height:32px;
        height:32px;
        width:266px;
    }
    .el-input__icon{
        line-height:32px;
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
    width: 813px;
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
    width: 813px;
    padding: 21px 28px;
    .enterprise {
      margin-bottom: 32px;
      border-left: 4px solid rgb(0, 160, 65);
      font-size: 13px;
      padding: 0px 15px;
      >span{
          color:#00A041;
          font-size:10px;
      }
    }
    .enterprise_bottom {
      .el-form-item {
        margin-top: 36px;
        font-size: 12px;
        color: #333;
      }
.el-form-item__label{
  font-size: 12px;
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
    >span:nth-child(1){
      display:inline-block;
      color:rgba(0,160,65,1);
      font-size: 12px;
      width:90px;
height:29px;
background:rgba(236,252,242,1);
border:1px solid rgba(65,215,135,1);
border-radius:4px;
margin-right:85px;
    }
    >span:nth-child(2){
       display:inline-block;
      width:90px;
      color:rgba(255,255,255,1);
      font-size: 12px;
height:29px;
background:rgba(0,160,65,1);
border-radius:4px;
    }
  }
}
</style>

<template>
  <div class="acceptInvitation">
    <div class="advisory_title">
      <div>{{title}}</div>
      <div @click="toCounselorManagement">返回</div>
    </div>

    <div class="advisory_content">
      <div class="enterprise">基本信息 <span @click="editBasic('basicForm')"> <i class="el-icon-edit-outline"></i>&nbsp;{{basicText}}</span></div>
      <el-form
        class="tableEnterprise marBtn"
        v-if="isShow"
      >
        <div style="display:flex">
          <el-form-item
            label="从业年限:"
            class="inline "
          >
            <span>{{basicForm.workingYears}}年</span>
          </el-form-item>
          <el-form-item
            label="毕业学校:"
            class="inline bodyName"
          >
            <span>{{basicForm.graduatedSchool}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="学历:"
            class="inline"
          >
            <span>{{basicForm.education}}</span>
          </el-form-item>
          <el-form-item
            label="联系手机:"
            class="inline bodyName"
          >
            <span>{{basicForm.phone}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="联系邮箱:"
            class="inline"
          >
            <span>{{basicForm.contactEmail}}</span>
          </el-form-item>
          <el-form-item
            label="执业资源:"
            class="inline"
          >
            <span>{{basicForm.practiceQualification}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="业务擅长:"
            class="inline"
          >
            <span>{{basicForm.goodAtBusiness}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="个人简介:"
            class="inline border-bottom"
          >
            <span>{{basicForm.personalProfile}}</span>
          </el-form-item>
        </div>
      </el-form>
      <el-form
        class="editForm"
        v-if="!isShow"
        :rules="rules"
        :model="basicForm"
        label-width="100px"
        ref="basicForm"
      >
        <el-form-item
          label="从业年限:"
          class="inline "
          prop="workingYears"
        >
          <el-input
            v-model="basicForm.workingYears"
            placeholder="请输入从业年限"
            clearable
          ></el-input>
          <!-- <span>{{workingYears}}年</span> -->
        </el-form-item>
        <el-form-item
          label="毕业学校:"
          class="inline bodyName"
          prop="graduatedSchool"
        >
          <el-input
            v-model="basicForm.graduatedSchool"
            placeholder="请输入毕业学校"
            clearable
          ></el-input>
          <!-- <span>{{graduatedSchool}}</span> -->
        </el-form-item>

        <el-form-item
          label="学历:"
          class="inline"
          prop="education"
        >
          <label slot="label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</label>
          <el-input
            v-model="basicForm.education"
            placeholder="请输入学历"
            clearable
          ></el-input>
          <!-- <span>{{education}}</span> -->
        </el-form-item>
        <el-form-item
          label="联系手机:"
          class="inline bodyName"
          prop="phone"
        >
          <el-input
            v-model="basicForm.phone"
            placeholder="请输入联系手机"
            clearable
          ></el-input>
          <!-- <span>{{phone}}</span> -->
        </el-form-item>

        <el-form-item
          label="联系邮箱:"
          class="inline"
          prop="contactEmail"
        >
          <el-input
            v-model="basicForm.contactEmail"
            placeholder="请输入联系邮箱"
            clearable
          ></el-input>
          <!-- <span>{{contactEmail}}</span> -->
        </el-form-item>
        <el-form-item
          label="执业资源:"
          prop="practiceQualification"
        >
          <el-input
            v-model="basicForm.practiceQualification"
            placeholder="请输入执业资源"
            clearable
          ></el-input>
          <!-- <span>{{practiceQualification}}</span> -->
        </el-form-item>
        <el-form-item
          label="业务领域:"
          prop="business"
        >
          <el-select
            v-model="basicForm.business"
            placeholder="请选择业务领域"
            clearable
          >
            <el-option
              v-for="item in businessAreasOptions"
              :key="item.id"
              :label="item.preValue"
              :value="item.id"
            >
            </el-option>
          </el-select>
          <!-- <el-input v-model="basicForm.goodAtBusiness" placeholder="请输入业务擅长" clearable></el-input> -->
          <!-- <span>{{goodAtBusiness}}</span> -->
        </el-form-item>
        <el-form-item
          label="业务擅长:"
          class="inline"
          prop="goodAtBusiness"
        >
          <el-input
            v-model="basicForm.goodAtBusiness"
            placeholder="请输入业务擅长"
            clearable
          ></el-input>
          <!-- <span>{{goodAtBusiness}}</span> -->
        </el-form-item>

        <el-form-item
          label="个人简介:"
          prop="personalProfile"
          class="inline border-bottom"
        >
          <el-input
            v-model="basicForm.personalProfile"
            type="textarea"
            autosize
            placeholder="请输入个人简介"
            clearable
          ></el-input>
          <!-- <span>{{personalProfile}}</span> -->
        </el-form-item>

      </el-form>
      <div class="enterprise">荣誉资质 <span @click="editCertificate('certificateForm')"> <i class="el-icon-plus"></i>&nbsp;{{editText}}</span> <span>取消</span></div>
      <div
        class="marBtn"
        v-if="!isShowEdit"
      >
        <el-table
          :data="honorData"
          style="width: 100%"
        >
          <el-table-column
            prop="certificateName"
            align="center"
            label="证书名称"
          >
            <!-- <template slot-scope="scope">
              <span v-if="!isShowEdit">{{scope.row.certificateName}}</span>
              <el-input
                v-if="isShowEdit"
                v-model="honorData[scope.$index].certificateName"
                placeholder="请输入证书名称"
                clearable
              ></el-input>
            </template> -->
          </el-table-column>
          <el-table-column
            prop="certificateType"
            label="证书类型"
            align="center"
          >
          </el-table-column>
          <el-table-column
            prop="issuingAgency"
            label="颁发机构"
            align="center"
          >
          </el-table-column>
          <el-table-column
            prop="getTime"
            align="center"
            label="颁发时间"
          >
          </el-table-column>
          <el-table-column
            prop="certificatePhoto"
            align="center"
            label="附件"
          >
            <template slot-scope="scope">
              <span
                v-if="scope.row.certificatePhoto"
                class="themeColor smallSize cur"
                @click="lookPoster(scope.row)"
              >点击查看</span>
              <span v-if="!scope.row.certificatePhoto">暂无附件</span>
            </template>
          </el-table-column>
          <el-table-column
            prop="certificatePhoto"
            align="center"
            label=""
            v-if="title==='XX机构邀请'"
          >
            <template>
              <!-- <span v-if="!scope.row.certificateName" class="themeColor smallSize cur" @click="lookPoster(scope.row)">保存并更新</span> -->
              <span
                class="redColor smallSize cur"
                @click="editCertificate"
              >编辑</span>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-form
        class="editForm"
        v-if="isShowEdit"
        :rules="certificateFormRules"
        :model="certificateForm"
        label-width="100px"
        ref="certificateForm"
      >
        <el-form-item
          label="证书名称:"
          prop="certificateName"
        >
          <el-input
            v-model="certificateForm.certificateName"
            placeholder="请输入证书名称"
            clearable
          ></el-input>
          <!-- <span>{{workingYears}}年</span> -->
        </el-form-item>
        <el-form-item
          label="证书类型:"
          prop="certificateCode"
        >
          <el-select
            v-model="certificateForm.certificateCode"
            placeholder="请选择证书类型"
            clearable
          >
            <el-option
              v-for="item in certificateAreasOptions"
              :key="item.certificateCode"
              :label="item.certificateName"
              :value="item.certificateCode"
            >
            </el-option>
          </el-select>
          <!-- <el-input v-model="basicForm.goodAtBusiness" placeholder="请输入业务擅长" clearable></el-input> -->
          <!-- <span>{{goodAtBusiness}}</span> -->
        </el-form-item>
         <el-form-item
          label="颁发机构:"
          prop="issuingAgency"
        >
          <el-input
            v-model="certificateForm.issuingAgency"
            placeholder="请输入颁发机构"
            clearable
          ></el-input>
          <!-- <span>{{workingYears}}年</span> -->
        </el-form-item>
        <el-form-item
          label="颁发时间:"
          class="inline"
          prop="getTime"
        >
          <el-date-picker
            v-model="certificateForm.getTime"
            value-format="yyyyMM"
            type="date"
            placeholder="选择日期"
          >
          </el-date-picker>
        </el-form-item>

        <el-form-item
          label="附件:"
          prop="personalProfile"
          class="inline border-bottom"
        >
         <label slot="label">附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件:</label>
          <el-upload
            action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
            :headers="headers"
            :on-exceed="handleExceed"
            :limit="1"
            list-type="picture-card"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
          >
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img
              width="100%"
              :src="dialogImageUrl"
              alt=""
            >
          </el-dialog>
          <!-- <span>{{personalProfile}}</span> -->
        </el-form-item>

      </el-form>
      <div class="enterprise">服务经历</div>
      <div class="marBtn">
        <el-table
          :data="serviceExperienceList"
          style="width: 100%"
        >
          <el-table-column
            prop="companyName"
            label="公司名称"
            align="center"
          >
          </el-table-column>
          <el-table-column
            prop="name"
            align="position"
            label="职务"
          >
          </el-table-column>
          <el-table-column
            prop="workTime"
            align="center"
            label="入职时间"
          >
          </el-table-column>
        </el-table>
      </div>

      <div class="enterprise">项目经验</div>
      <div class="marBtn">
        <el-table
          :data="serviceProjectExperienceList"
          style="width: 100%"
        >
          <el-table-column
            prop="projectName"
            align="center"
            label="项目名称"
          >
          </el-table-column>
          <el-table-column
            align="center"
            prop="companyName"
            label="公司名称"
          >
          </el-table-column>
          <el-table-column
            prop="personalDuties"
            align="center"
            label="个人职责"
          >
          </el-table-column>
          <el-table-column
            prop="projectTime"
            align="center"
            label="项目时间"
          >
          </el-table-column>
        </el-table>
      </div>
      <button
        class="business_footer"
        @click="submitForm('counselorForm')"
        :disabled="disabled"
      > 接受邀请 </button>
      <button
        class="business_footer"
        @click="submitForm('counselorForm')"
        :disabled="disabled"
      > 拒绝邀请 </button>
    </div>
    <el-dialog
      :visible.sync="dialogVisible"
      width="50%"
    >
      <img
        :src="certificatePhoto"
        alt="图片"
        style="width:100%"
      >
      <span
        slot="footer"
        class="dialog-footer"
      >
        <el-button @click="dialogVisible = false">返 回</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogImageUrl:'',
      dialogVisible:false,
      headers: {
        token: sessionStorage.token
      },
      certificateAreasOptions:[],//证书类型
      editText: "添加荣誉资质",
      isShowEdit: false,
      title: "XX机构邀请",
      businessAreasOptions: [],
      basicText: "编 辑",
      isShow: true,
      disabled: false,
      certificatePhoto: "",
      dialogVisible: false,
      // counselorForm:{

      // approvalResults:'',
      // approvalDesc:'',
      // },
      serviceProjectExperienceList: [], //项目经验表格数据
      honorData: [], //荣誉资质表格数据
      serviceExperienceList: [], //服务经历表格
      basicForm: {
        business: "",
        advisorAccount: sessionStorage.getItem("account"),
        businessAreas: [], //业务领域
        personalProfile: "", //个人简介
        practiceQualification: "", //执业资质
        workingYears: "", //从业年限
        graduatedSchool: "", //毕业院校
        goodAtBusiness: "", //业务擅长
        education: "", //学历
        contactEmail: "", //联系邮箱
        phone: "",
        orgId: "285bfb89580a422ea927200f5d7accc4"
      },
      certificateForm:{
        advisorAccount:sessionStorage.getItem("account"),
        certificateName:'',
        certificateCode:'',
        id:'',
         getTime:'',
         certificatePhoto:'',
         issuingAgency:'',//颁发机构

        },
        certificateFormRules:{
              certificateCode: [
          { required: true, message: "请选择证书类型", trigger: "change" }
        ],
        certificateName: [
          { required: true, message: "请输入证书名称", trigger: "blur" }
        ],
        issuingAgency: [
          { required: true, message: "请输入颁发机构", trigger: "blur" }
        ],
        },
      rules: {
        //     workingYears: [
        //       { required: true, message: '请输入从业年限', trigger: 'blur' }
        //     ],
        //     graduatedSchool: [
        //       { required: true, message: '请输入毕业学校', trigger: 'blur' }
        //     ],
        //     education: [
        //       { required: true, message: '请输入学历', trigger: 'blur' }
        //     ],
        //     phone: [
        //       { required: true, message: '请输入联系电话', trigger: 'blur' }
        //     ],
        //      contactEmail: [
        //        { required: true, message: '请输入邮箱地址', trigger: 'blur' },
        // { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        //     ],
        //     practiceQualification: [
        //       { required: true, message: '请输入执业资源', trigger: 'blur' }
        //     ],
        business: [
          { required: true, message: "请选择业务领域", trigger: "change" }
        ],
        //     personalProfile: [
        //       { required: true, message: '请输入个人简介', trigger: 'blur' }
        //     ],
        unifyCode: [
          { required: true, message: "请输入统一社会信用代码", trigger: "blur" }
        ],
        affiliatedPark: [
          { required: true, message: "请选择所属园区", trigger: "change" }
        ],
        comSource: [
          { required: true, message: "请选择企业来源", trigger: "change" }
        ],

        comDemand: [
          { required: true, message: "请输入我的需求", trigger: "blur" }
        ],
        comWeb: [
          { required: true, message: "请输入企业官网地址", trigger: "blur" }
        ],
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
      } //联系手机
    };
  },
  mounted() {
    this.init();
    this.getBusinessAreas();
    this.getCertificateTypeList();
  },
  methods: {
      // resetForm(formName) {
      //   this.$refs[formName].resetFields();
      // },
    // 保存荣誉资质
    editCertificate(certificateForm) {
      if (this.editText === "添加荣誉资质") {
    // this.resetForm('certificateForm')
    // this.$refs['certificateForm'].resetFields();
    this.certificateForm.getTime=''
    this.certificateForm.certificateName=''
    this.certificateForm.certificateCode=''
    this.certificateForm.certificatePhoto=''
    this.certificateForm.issuingAgency=''
        this.isShowEdit = true;
        this.editText = "保存并更新";
      } else {
          this.$refs[certificateForm].validate(valid => {
          if (valid) {
            // this.certificateForm.getTime=/
            console.log(this.certificateForm);
            this.api.post({
              url: "saveOrUpdateAdvisorHonor",
              data: this.certificateForm,
              callback: res => {
                console.log(res);
                if (res.code == "0000") {
                  this.$message({
                    message: "操作成功",
                    type: "success"
                  });
                   this.isShowEdit = false;
        this.editText = "添加荣誉资质";
                  this.init();
                } else {
                  this.$message.error(res.result);
                  return false;
                }
              }
            });
          } else {
            return false;
          }
        });

      }
    },
    // 获取业务领域
    getBusinessAreas() {
      this.api.get({
        url: "selectTeamList",
        data: { preType: "0" },
        callback: res => {
          if (res.code === "0000") {
            console.log(res);
            this.businessAreasOptions = res.data;
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    // 获取证书类型
    getCertificateTypeList() {
      this.api.get({
        url: "getCertificateTypeList",
        data: { preType: "0" },
        callback: res => {
          if (res.code === "0000") {
            console.log(res);
            this.certificateAreasOptions = res.data;
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    handleExceed(files, fileList) {
      this.$message.warning(`只能上传一张海报图片`);
    },
    handleRemove(file, fileList) {
      this.dialogImageUrl = "";
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    handleAvatarSuccess(res, file) {
      this.certificateForm.certificatePhoto = res.data;
    },
    beforeAvatarUpload(file) {
      const isLt2M = file.size / 1024 / 1024 < 5;
      const isJPG = file.type === "image/jpeg" || file.type === "image/png";
      if (!isLt2M) {
        this.$message.error("上传图片大小不能超过 5MB!");
      }
      if (!isJPG) {
        this.$message.error("上传图片只能是 JPG、png 格式!");
      }
      return isJPG && isLt2M;
    },
    // 保存基本信息
    editBasic(basicForm) {
      if (this.basicText === "保 存") {
        this.$refs[basicForm].validate(valid => {
          if (valid) {
            this.basicForm.businessAreas = this.basicForm.business.split();
            console.log(this.basicForm);
            this.api.post({
              url: "saveOrUpdateAdvisorBaseInfo",
              data: this.basicForm,
              callback: res => {
                console.log(res);
                if (res.code == "0000") {
                  this.$message({
                    message: "操作成功",
                    type: "success"
                  });
                  this.isShow = true;
                  this.basicText = "编 辑";
                  this.init();
                } else {
                  this.$message.error(res.result);
                  return false;
                }
              }
            });
          } else {
            return false;
          }
        });
      } else {
        this.isShow = false;
        this.basicText = "保 存";
      }
    },
    //   查看附件图片
    lookPoster(row) {
      //  if(!row.posterUrl){
      //      this.$message.error('此宣传没有宣传海报')
      //  }else{
      this.certificatePhoto = row.certificatePhoto;
      this.dialogVisible = true;
      //  }
    },
    init() {
      let _this = this;
      // this.basicForm.advisorAccount = sessionStorage.getItem("account");
      // this.certificateForm.advisorAccount = sessionStorage.getItem("account");
      console.log(this.basicForm.advisorAccount);
      _this.api.get({
        url: "advisorDetails",
        data: { advisorAccount: this.basicForm.advisorAccount },
        callback: function(res) {
          console.log(res);
          if (res.code == "0000") {
            _this.basicForm.personalProfile =
              res.data.advisorServiceInfo.personalProfile;
            _this.basicForm.graduatedSchool =
              res.data.advisorServiceInfo.graduatedSchool;
            _this.basicForm.education = res.data.advisorServiceInfo.education;
            _this.basicForm.business = res.data.advisorServiceInfo.businessArea;
            _this.basicForm.phone = res.data.advisorServiceInfo.phone;
            _this.basicForm.contactEmail =
              res.data.advisorServiceInfo.contactEmail;
            _this.basicForm.practiceQualification =
              res.data.advisorServiceInfo.practiceQualification;
            _this.basicForm.workingYears =
              res.data.advisorServiceInfo.workingYears;
            _this.basicForm.goodAtBusiness =
              res.data.advisorServiceInfo.goodAtBusiness;
            _this.honorData = res.data.serviceHonorList;
            _this.serviceExperienceList = res.data.serviceExperienceList;
            _this.serviceProjectExperienceList =
              res.data.serviceProjectExperienceList;
          }
        }
      });
    },
    submitForm(formName) {
      this.disabled = true;
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.api.post({
            url: "approvalAdvisorInfo",
            data: this.counselorForm,
            callback: res => {
              console.log(res);
              if (res.code == "0000") {
                this.$message({
                  message: "操作成功",
                  type: "success"
                });
                this.$router.push({ name: "counselorManagement" });
                this.disabled = false;
              } else {
                this.$message.error(res.result);
                this.disabled = false;
                return false;
              }
            }
          });
        } else {
          this.disabled = false;
          return false;
        }
      });
    },
    toCounselorManagement() {
      this.$router.push({ name: "counselorManagement" });
    }
    // toEditAdvisers() {
    //   this.$router.push({ name: "editAdvisers" });
    // }
  }
};
</script>

<style lang="scss" >
.acceptInvitation {
  .el-table thead {
    color: #00a041;
  }
  .el-table {
    font-size: 12px;
  }
  .el-table td,
  .el-table th {
    padding: 5px;
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
  .editForm {
    padding-left: 170px;
    .el-form-item__content {
      width: 266px;
      line-height: 33px;
    }
    .el-input__inner {
      line-height: 33px;
      height: 33px;
      width: 266px;
    }
    .el-form-item__label {
      line-height: 33px;
    }
    .el-textarea__inner {
      width: 387px;
    }
  }
  .el-table__empty-block {
    min-height: 36px;
  }
  .el-table__empty-text {
    line-height: 36px;
  }
  .el-table td,
  .el-table th.is-leaf {
    border-right: unset;
    // border-left:1px solid rgba(65,215,135,1);
    // border-right:1px solid rgba(65,215,135,1);
  }
  .el-table th {
    width: 750px;
    height: 28px;
    background: rgba(236, 252, 242, 1);
    border-top: 1px solid rgba(65, 215, 135, 1);
    border-bottom: 1px solid rgba(65, 215, 135, 1);
    // border: 1px solid rgba(65,215,135,1);
    padding: unset;
    font-size: 12px;
    // color: #00A041;
    font-weight: 400;
    text-align: center;
  }
  .marBtn {
    margin-bottom: 30px;
  }
  .el-textarea__inner {
    min-height: 97px !important;
    background: #fff;
  }
  .tableEnterprise {
    .inline {
      display: inline-block;
    }
    .el-form-item__label {
      width: 132px;
      // padding: 15px 0;
      display: inline-block;
      background-color: #f0f0f0;
      //   border: 1px solid #ccc;
      display: flex;
      line-height: 45px;
      padding-left: 13px;
      font-size: 13px;
      padding-right: unset;
    }
    .el-form-item {
      border-top: 1px solid #ccc;
      border-left: 1px solid #ccc;
      border-right: 1px solid #ccc;
      margin-bottom: 0px;
      flex: 1;
      display: flex;
    }
    .el-form-item__content {
      flex: 1;
      display: inline-block;
      padding-left: 13px;
      // padding: 15px;
      //   border: 1px solid #ccc;
    }
    .bodyName {
      border-left: unset;
    }
    .border-bottom {
      border-bottom: 1px solid #ccc;
    }
  }

  .advisory_title {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 17px;
    font-size: 13px;
    border-radius: 5px;
    div:nth-child(2) {
      width: 88px;
      height: 26px;
      background: rgba(236, 252, 242, 1);
      border: 1px solid rgba(65, 215, 135, 1);
      border-radius: 4px;
      text-align: center;
      line-height: 26px;
      font-size: 12px;
      color: #00a041;
      cursor: pointer;
    }
  }
  .myBusiness {
    color: #333;
    font-size: 13px;
    padding: 25px 0px;
  }
}
.advisory_content {
  background: #fff;
  margin-top: 14px;
  width: 813px;
  padding: 21px 28px;
  .enterprise {
    margin-bottom: 16px;
    border-left: 4px solid rgb(0, 160, 65);
    font-size: 13px;
    padding: 0px 15px;
    > span {
      float: right;
      font-size: 12px;
      cursor: pointer;
      color: #00a041;
      [class*=" el-icon-"],
      [class^="el-icon-"] {
        font-size: 14px;
        vertical-align: bottom;
      }
    }
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
  display: block;
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
</style>

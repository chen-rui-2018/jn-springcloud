<template>
  <div class="advisoryInformation">
    <div class="advisory_title font16">
      <div>顾问资料</div>
    </div>

    <div class="advisory_content">
      <div class="enterprise">基本信息
        <span class="cancel" @click="cancelBasic" v-if="!isShow">取&nbsp;消</span>
        <span @click="editBasic('basicForm')" v-show="isConceal!=='1'">
          <i class="el-icon-edit-outline"></i>&nbsp;{{basicText}}</span></div>
      <el-form class="tableEnterprise marBtn" v-if="isShow">
        <div style="display:flex">
          <el-form-item label="从业年限:" class="inline ">
            <span>{{basicForm.workingYears}}</span>
          </el-form-item>
          <el-form-item label="毕业学校:" class="inline bodyName">
            <span>{{basicForm.graduatedSchool}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="学历:" class="inline">
            <span>{{basicForm.education}}</span>
          </el-form-item>
          <el-form-item label="联系手机:" class="inline bodyName">
            <span>{{basicForm.phone}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="联系邮箱:" class="inline">
            <span>{{basicForm.contactEmail}}</span>
          </el-form-item>
          <el-form-item label="执业资质:" class="inline bodyName">
            <span>{{basicForm.practiceQualification}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="业务擅长:" class="inline">
            <span>{{basicForm.goodAtBusiness}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="个人简介:" class="inline border-bottom">
            <span>{{basicForm.personalProfile}}</span>
          </el-form-item>
        </div>
      </el-form>
      <el-form class="editForm" v-if="!isShow" :rules="rules" :model="basicForm" label-width="100px" ref="basicForm">
        <el-form-item label="从业年限:" class="inline " prop="workingYears">
          <el-input v-model="basicForm.workingYears" placeholder="请输入从业年限(数字)" clearable step="1"  min="0" onkeyup="this.value= this.value.match(/\d+(\.\d{0,2})?/) ? this.value.match(/\d+(\.\d{0,2})?/)[0] : ''"></el-input>
        </el-form-item>
        <el-form-item label="毕业学校:" class="inline bodyName" prop="graduatedSchool">
          <el-input v-model="basicForm.graduatedSchool" placeholder="请输入毕业学校" clearable></el-input>
        </el-form-item>
        <el-form-item label="学历:" class="inline" prop="education">
          <label slot="label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</label>
          <el-input v-model="basicForm.education" placeholder="请输入学历" clearable></el-input>
        </el-form-item>
        <el-form-item label="联系手机:" class="inline bodyName" prop="phone">
          <el-input v-model="basicForm.phone" placeholder="请输入联系手机" maxlength='11' clearable></el-input>
        </el-form-item>
        <el-form-item label="联系邮箱:" class="inline" prop="contactEmail">
          <el-input v-model="basicForm.contactEmail" placeholder="请输入联系邮箱" clearable></el-input>
        </el-form-item>
        <el-form-item label="执业资质:" prop="practiceQualification">
          <el-input v-model="basicForm.practiceQualification" placeholder="请输入执业资源" clearable></el-input>
        </el-form-item>
        <!-- <el-form-item label="业务领域:" prop="businessArea">
          <el-select v-model="basicForm.businessArea" placeholder="请选择业务领域" clearable>
            <el-option v-for="item in businessAreasOptions" :key="item.id" :label="item.preValue" :value="item.id">
            </el-option>
          </el-select>
        </el-form-item> -->
        <el-form-item label="业务擅长:" class="inline" prop="goodAtBusiness">
          <el-input v-model="basicForm.goodAtBusiness" placeholder="请输入业务擅长" clearable></el-input>
        </el-form-item>
        <el-form-item label="个人简介:" prop="personalProfile" class="inline border-bottom">
          <el-input v-model="basicForm.personalProfile" type="textarea" autosize placeholder="请输入个人简介" clearable></el-input>
        </el-form-item>
      </el-form>
      <div class="enterprise">荣誉资质 <span class="cancel" @click="cancelHonorData" v-if="isShowEdit">取&nbsp;消</span><span
          @click="addCertificate('certificateForm')" v-show="isConceal!=='1'"> <i class="el-icon-plus"></i>&nbsp;{{editText}}</span>
      </div>
      <div class="marBtn" v-if="!isShowEdit">
        <el-table :data="honorData" style="width: 99%">
          <el-table-column prop="certificateName" align="center" label="证书名称">
          </el-table-column>
          <el-table-column prop="certificateTypeName" label="证书类型" align="center">
          </el-table-column>
          <el-table-column prop="issuingAgency" label="颁发机构" align="center">
          </el-table-column>
          <el-table-column prop="getTime" align="center" label="颁发时间">
          </el-table-column>
          <el-table-column prop="certificatePhoto" align="center" label="附件">
            <template slot-scope="scope">
              <span v-if="scope.row.certificatePhoto" class="themeColor smallSize cur" @click="lookPoster(scope.row)">点击查看</span>
              <span v-if="!scope.row.certificatePhoto">暂无附件</span>
            </template>
          </el-table-column>
          <el-table-column prop="certificatePhoto" align="center" label="操作" v-if="isConceal!=='1'">
            <template slot-scope="scope">
              <!-- <span v-if="!scope.row.certificateName" class="themeColor smallSize cur" @click="lookPoster(scope.row)">保存并更新</span> -->
              <span class="redColor smallSize cur"  @click="editCertificate(scope.row)">编辑</span>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-form class="editForm" v-if="isShowEdit" :rules="certificateFormRules" :model="certificateForm" label-width="100px"
        ref="certificateForm">
        <el-form-item label="证书名称:" prop="certificateName">
          <el-input v-model="certificateForm.certificateName" placeholder="请输入证书名称" clearable></el-input>
        </el-form-item>
        <el-form-item label="证书类型:" prop="certificateCode">
          <el-select v-model="certificateForm.certificateCode" placeholder="请选择证书类型" clearable>
            <el-option v-for="item in certificateAreasOptions" :key="item.certificateCode" :label="item.certificateName"
              :value="item.certificateCode">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="颁发机构:" prop="issuingAgency">
          <el-input v-model="certificateForm.issuingAgency" placeholder="请输入颁发机构" clearable></el-input>
        </el-form-item>
        <el-form-item label="颁发时间:" class="inline maxWidth" prop="getTime">
          <el-date-picker v-model="certificateForm.getTime" value-format="yyyyMM" type="month" placeholder="请选择时间">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="附件:" prop="personalProfile" class="inline border-bottom">
          <label slot="label">附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件:</label>
          <el-upload class="avatarImg" :show-file-list="false" :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
            :headers="headers" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
            <img v-if="certificateForm.certificatePhoto" :src="certificateForm.certificatePhoto">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>

      </el-form>
      <div class="enterprise">服务经历 <span class="cancel" @click="cancelExperienceList" v-if="isShowExperienceList">取&nbsp;消</span><span
          @click="addExperienceList('experienceListForm')" v-show="isConceal!=='1'"> <i class="el-icon-plus"></i>&nbsp;{{editExperienceList}}</span>
      </div>
      <div class="marBtn" v-if="!isShowExperienceList">
        <el-table :data="serviceExperienceList" style="width: 99%">
          <el-table-column prop="companyName" label="公司名称" align="center">
          </el-table-column>
          <el-table-column prop="position" align="center" label="职务">
          </el-table-column>
          <el-table-column prop="workTime" align="center" label="入职时间">
          </el-table-column>
          <el-table-column align="center" label="操作">
            <template slot-scope="scope">
              <span class="redColor smallSize cur" @click="updataExperienceList(scope.row)">编辑</span>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-form class="editForm" v-if="isShowExperienceList" :rules="experienceListFormRules" :model="experienceListForm"
        label-width="100px" ref="experienceListForm">
        <el-form-item label="公司名称:" prop="companyName">
          <el-input v-model="experienceListForm.companyName" placeholder="请输入公司名称" clearable></el-input>
        </el-form-item>
        <el-form-item label="职务:" prop="position">
          <label slot="label">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务:</label>
          <el-input v-model="experienceListForm.position" placeholder="请输入职务" clearable></el-input>
          <!-- <span>{{goodAtBusiness}}</span> -->
        </el-form-item>
        <el-form-item label="入职日期:" class="inline maxWidth">
          <el-date-picker v-model="experienceListForm.workTime" type="month" value-format="yyyyMM" placeholder="请选择时间">
          </el-date-picker>
        </el-form-item>

      </el-form>
      <div class="enterprise">项目经验<span class="cancel" @click="cancelProjectExperienceList" v-if="isShowProjectExperienceList">取&nbsp;消</span><span
          @click="addProjectExperienceList('projectExperienceListForm')" v-show="isConceal!=='1'"> <i class="el-icon-plus"></i>&nbsp;{{editProjectExperienceList}}</span></div>
      <div class="marBtn" v-if="!isShowProjectExperienceList">
        <el-table :data="serviceProjectExperienceList" style="width: 99%">
          <el-table-column prop="projectName" align="center" label="项目名称">
          </el-table-column>
          <el-table-column align="center" prop="companyName" label="公司名称">
          </el-table-column>
          <el-table-column prop="personalDuties" align="center" label="个人职责">
          </el-table-column>
          <el-table-column prop="projectTime" align="center" label="项目时间">
          </el-table-column>
          <el-table-column align="center" label="操作">
            <template slot-scope="scope">
              <span class="redColor smallSize cur" @click="updataProjectExperienceList(scope.row)">编辑</span>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-form class="editForm" v-if="isShowProjectExperienceList" :rules="projectExperienceListFormRules" :model="projectExperienceListForm"
        label-width="100px" ref="projectExperienceListForm">
        <el-form-item label="项目名称:" prop="projectName">
          <el-input v-model="projectExperienceListForm.projectName" placeholder="请输入项目名称" clearable></el-input>
          <!-- <span>{{workingYears}}年</span> -->
        </el-form-item>
        <el-form-item label="公司名称:" prop="companyName">
          <el-input v-model="projectExperienceListForm.companyName" placeholder="请输入公司名称" clearable></el-input>
          <!-- <span>{{workingYears}}年</span> -->
        </el-form-item>
        <el-form-item label="项目时间:" class="inline maxWidth">
          <el-date-picker v-model="projectExperienceListForm.projectTime" type="month" value-format="yyyyMM"
            placeholder="请选择时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="个人职责:">
          <el-input v-model="projectExperienceListForm.personalDuties" placeholder="请输入个人职责" type="textarea" clearable></el-input>
        </el-form-item>
      </el-form>
      <div class="footer ct" v-show="showBtn">
        <el-button size="mini" v-show="isConceal!=='1'" @click="acceptInvitation" :disabled="disabled" class="mainColor accept">发送申请</el-button>
      </div>

    </div>
    <el-dialog :visible.sync="dialogVisible" width="50%" :modal-append-to-body="false">
      <img :src="certificatePhoto" alt="图片" style="width:100%;height:200px">
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">返 回</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    var checkPhone = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("手机号不能为空"));
      } else {
        const reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
        console.log(reg.test(value));
        if (reg.test(value)) {
          callback();
        } else {
          return callback(new Error("请输入正确的手机号"));
        }
      }
    };
    return {
      baseUrl: this.api.host,
      orgId: undefined,
      isConceal: undefined,
      showBtn: true,
      dialogImageUrl: "",
      dialogVisible: false,
      headers: {
        token: sessionStorage.token
      },
      certificateAreasOptions: [], //证书类型
      editText: "添加荣誉资质",
      editExperienceList: "添加服务经历",
      editProjectExperienceList: "添加项目经验",
      isShowExperienceList: false,
      isShowProjectExperienceList: false,
      isShowEdit: false,
      businessAreasOptions: [],
      basicText: "编 辑",
      isShow: true,
      disabled: false,
      certificatePhoto: "",
      dialogVisible: false,
      serviceProjectExperienceList: [], //项目经验表格数据
      honorData: [], //荣誉资质表格数据
      serviceExperienceList: [], //服务经历表格
      basicForm: {
        advisorAccount: sessionStorage.getItem("account"),
        // businessArea:'',
        businessAreas: [], //业务领域
        personalProfile: "", //个人简介
        practiceQualification: "", //执业资质
        workingYears: "", //从业年限
        graduatedSchool: "", //毕业院校
        goodAtBusiness: "", //业务擅长
        education: "", //学历
        contactEmail: "", //联系邮箱
        phone: "",
        orgId: ""
      },
      certificateForm: {
        advisorAccount: sessionStorage.getItem("account"),
        certificateName: "",
        certificateCode: "",
        id: "",
        getTime: "",
        certificatePhoto: "",
        issuingAgency: "" //颁发机构
      },
      projectExperienceListForm: {
        advisorAccount: sessionStorage.getItem("account"),
        personalDuties: "",
        companyName: "",
        id: "",
        projectName: "",
        projectTime: ""
      },
      experienceListForm: {
        advisorAccount: sessionStorage.getItem("account"),
        companyName: "",
        position: "",
        id: "",
        workTime: ""
      },
      projectExperienceListFormRules: {
        companyName: [
          { required: true, message: "请输入公司名称", trigger: "blur" }
        ],
        projectName: [
          { required: true, message: "请输入项目名称", trigger: "blur" }
        ]
      },
      experienceListFormRules: {
        companyName: [
          { required: true, message: "请输入公司名称", trigger: "blur" }
        ],
        position: [{ required: true, message: "请输入职务", trigger: "blur" }]
      },
      certificateFormRules: {
        certificateCode: [
          { required: true, message: "请选择证书类型", trigger: "change" }
        ],
        certificateName: [
          { required: true, message: "请输入证书名称", trigger: "blur" }
        ],
        issuingAgency: [
          { required: true, message: "请输入颁发机构", trigger: "blur" }
        ]
      },
      rules: {
        // businessArea: [
        //   { required: true, message: "请选择业务领域", trigger: "change" }
        // ],
        phone: [{ required: false, validator: checkPhone, trigger: "blur" }],
        // affiliatedPark: [
        //   { required: true, message: "请选择所属园区", trigger: "change" }
        // ],
        contactEmail: [
          { required: false, message: "请选择邮箱", trigger: "change" },
          {
            type: "email",
            message: "请输入正确的邮箱地址",
            trigger: ["blur", "change"]
          }
        ]

        // comDemand: [
        //   { required: true, message: "请输入我的需求", trigger: "blur" }
        // ],
        // comWeb: [
        //   { required: true, message: "请输入企业官网地址", trigger: "blur" }
        // ],
        // comAddress: [
        //   { required: true, message: "请输入注册地址", trigger: "blur" }
        // ],
        // comPropertys: [
        //   { required: true, message: "请选择企业性质", trigger: "change" }
        // ],
        // avatar: [
        //   { required: true, message: "请选择LOGO图片", trigger: "blur" }
        // ],
        // businessLicense: [
        //   { required: true, message: "请选择营业执照", trigger: "blur" }
        // ],
        // imgParams: [
        //   { required: true, message: "请选择宣传图片", trigger: "change" }
        // ],
        // comDetails: [
        //   { required: true, message: "请输入公司简介", trigger: "blur" }
        // ],
        // mainProducts: [
        //   { required: true, message: "请输入产品", trigger: "blur" }
        // ]
      }
    };
  },
  mounted() {
    this.init();
    // this.getBusinessAreas();
    this.getCertificateTypeList();
  },
  methods: {
    //发送申请
    acceptInvitation() {
      this.api.post({
        url: "sendApproval",
        callback: res => {
          if (res.code === "0000") {
            this.$message({
              message: "操作成功,请等待后台审核",
              type: "success"
            });
            this.$router.push({ path: "/home" });
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    // 新增项目经验
    addProjectExperienceList(projectExperienceListForm) {
      if (!this.basicForm.phone) {
        this.$message.error("请先填写基本信息");
        return false;
      }
      if (this.editProjectExperienceList === "添加项目经验") {
        this.projectExperienceListForm.personalDuties = "";
        this.projectExperienceListForm.companyName = "";
        this.projectExperienceListForm.projectName = "";
        this.projectExperienceListForm.projectTime = "";
        this.projectExperienceListForm.id = "";
        this.isShowProjectExperienceList = true;
        this.showBtn = false;
        this.editProjectExperienceList = "保存并更新";
      } else {
        this.$refs[projectExperienceListForm].validate(valid => {
          if (valid) {
            console.log(this.projectExperienceListForm);
            this.api.post({
              url: "saveOrUpdateAdvisorProjectExperience",
              data: this.projectExperienceListForm,
              callback: res => {
                if (res.code == "0000") {
                  this.$message({
                    message: "操作成功",
                    type: "success"
                  });
                  this.isShowProjectExperienceList = false;
                  this.showBtn = true;
                  this.editProjectExperienceList = "添加项目经验";
                  this.getInit();
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
    // 取消项目经验
    cancelProjectExperienceList() {
      this.isShowProjectExperienceList = false;
      this.editProjectExperienceList = "添加项目经验";
      this.showBtn = true;
    },
    // 编辑项目经验
    updataProjectExperienceList(row) {
      this.projectExperienceListForm.personalDuties = row.personalDuties;
      this.projectExperienceListForm.companyName = row.companyName;
      this.projectExperienceListForm.projectName = row.projectName;
      this.projectExperienceListForm.projectTime = row.projectTime;
      this.projectExperienceListForm.id = row.id;
      this.isShowProjectExperienceList = true;
      this.showBtn = false;
      this.editProjectExperienceList = "保存并更新";
    },
    // 编辑服务经历
    updataExperienceList(row) {
      this.experienceListForm.workTime = row.workTime;
      this.experienceListForm.companyName = row.companyName;
      this.experienceListForm.position = row.position;
      this.experienceListForm.id = row.id;
      this.isShowExperienceList = true;
      this.showBtn = false;
      this.editExperienceList = "保存并更新";
    },
    // 新增服务经历
    addExperienceList(experienceListForm) {
      if (!this.basicForm.phone) {
        this.$message.error("请先填写基本信息");
        return false;
      }
      if (this.editExperienceList === "添加服务经历") {
        // this.resetForm('certificateForm')
        // this.$refs['certificateForm'].resetFields();
        this.experienceListForm.workTime = "";
        this.experienceListForm.companyName = "";
        this.experienceListForm.position = "";
        this.experienceListForm.id = "";
        this.isShowExperienceList = true;
        this.showBtn = false;
        this.editExperienceList = "保存并更新";
      } else {
        this.$refs[experienceListForm].validate(valid => {
          if (valid) {
            console.log(this.experienceListForm);
            this.api.post({
              url: "saveOrUpdateAdvisorExperience",
              data: this.experienceListForm,
              callback: res => {
                if (res.code == "0000") {
                  this.$message({
                    message: "操作成功",
                    type: "success"
                  });
                  this.showBtn = true;
                  this.isShowExperienceList = false;
                  this.editExperienceList = "添加服务经历";
                  this.getInit();
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

    // 取消基本信息的更改
    cancelBasic() {
      this.isShow = true;
      this.showBtn = true;
      this.basicText = "编 辑";
    },
    // 取消服务经历的更改
    cancelExperienceList() {
      this.isShowExperienceList = false;
      this.editExperienceList = "添加服务经历";
      this.showBtn = true;
    },
    // 取消编辑荣誉资质
    cancelHonorData() {
      this.isShowEdit = false;
      this.editText = "添加荣誉资质";
      this.showBtn = true;
    },
    //编辑荣誉资质
    editCertificate(row) {
      console.log(row);
      this.certificateForm.certificateName = row.certificateName;
      this.certificateForm.certificateCode = row.certificateType;
      this.certificateForm.getTime = row.getTime;
      this.certificateForm.id = row.id;
      this.certificateForm.certificatePhoto = row.certificatePhoto;
      this.certificateForm.issuingAgency = row.issuingAgency;
      this.isShowEdit = true;
      this.showBtn = false;
      this.editText = "保存并更新";
    },
    // 新增荣誉资质
    addCertificate(certificateForm) {
      if (!this.basicForm.phone) {
        this.$message.error("请先填写基本信息");
        return false;
      }
      if (this.editText === "添加荣誉资质") {
        // this.resetForm('certificateForm')
        // this.$refs['certificateForm'].resetFields();
        this.certificateForm.getTime = "";
        this.certificateForm.certificateName = "";
        this.certificateForm.certificateCode = "";
        this.certificateForm.certificatePhoto = "";
        this.certificateForm.issuingAgency = "";
        this.certificateForm.id = "";
        this.isShowEdit = true;
        this.showBtn = false;
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
                  this.showBtn = true;
                  this.isShowEdit = false;
                  this.editText = "添加荣誉资质";
                  this.getInit();
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
    // getBusinessAreas() {
    //   this.api.get({
    //     url: "selectTeamList",
    //     data: { preType: "0" },
    //     callback: res => {
    //       if (res.code === "0000") {
    //         this.businessAreasOptions = res.data;
    //       } else {
    //         this.$message.error(res.result);
    //       }
    //     }
    //   });
    // },
    // 获取证书类型
    getCertificateTypeList() {
      this.api.get({
        url: "getCertificateTypeList",
        data: { preType: "0" },
        callback: res => {
          if (res.code === "0000") {
            this.certificateAreasOptions = res.data;
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    handleAvatarSuccess(res, file) {
      this.certificateForm.certificatePhoto = res.data;
    },
    beforeAvatarUpload(file) {
      const isLt2M = file.size / 1024 / 1024 < 1;
      const isJPG = file.type === "image/jpeg" || file.type === "image/png";
      if (!isLt2M) {
        this.$message.error("上传图片大小不能超过 1MB!");
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
            if (this.orgId !== this.basicForm.orgId) {
              this.$confirm(`此操作将改变机构信息, 是否继续?`, "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
              })
                .then(() => {
                  this.api.post({
                    url: "saveOrUpdateAdvisorBaseInfo",
                    data: this.basicForm,
                    callback: res => {
                      if (res.code == "0000") {
                        this.$message({
                          message: "操作成功",
                          type: "success"
                        });
                        this.isShow = true;
                        this.showBtn = true;
                        this.basicText = "编 辑";
                        this.getInit();
                      } else {
                        this.$message.error(res.result);
                        return false;
                      }
                    }
                  });
                })
                .catch(() => {});
            }else{
               this.api.post({
                    url: "saveOrUpdateAdvisorBaseInfo",
                    data: this.basicForm,
                    callback: res => {
                      if (res.code == "0000") {
                        this.$message({
                          message: "操作成功",
                          type: "success"
                        });
                        this.isShow = true;
                        this.showBtn = true;
                        this.basicText = "编 辑";
                        this.getInit();
                      } else {
                        this.$message.error(res.result);
                        return false;
                      }
                    }
                  });
            }
          } else {
            return false;
          }
        });
      } else {
        this.isShow = false;
        this.showBtn = false;
        this.basicText = "保 存";
      }
    },
    //   查看附件图片
    lookPoster(row) {
      this.certificatePhoto = row.certificatePhoto;
      this.dialogVisible = true;
    },
    //获取顾问详情
    getInit() {
      this.api.get({
        url: "serviceAdvisorInfo",
        data: { advisorAccount: this.basicForm.advisorAccount },
        callback: res => {
          if (res.code == "0000") {
            this.basicForm.personalProfile =
              res.data.advisorServiceInfo.personalProfile;
            this.basicForm.graduatedSchool =
              res.data.advisorServiceInfo.graduatedSchool;
            this.basicForm.education = res.data.advisorServiceInfo.education;
            // if(res.data.advisorServiceInfo.businessArea){
            //   this.basicForm.businessArea = res.data.advisorServiceInfo.businessArea;
            // }
            this.basicForm.phone = res.data.advisorServiceInfo.phone;
            this.basicForm.contactEmail =
              res.data.advisorServiceInfo.contactEmail;
            this.basicForm.practiceQualification =
              res.data.advisorServiceInfo.practiceQualification;
            this.basicForm.workingYears =
              res.data.advisorServiceInfo.workingYears;
            this.basicForm.goodAtBusiness =
              res.data.advisorServiceInfo.goodAtBusiness;
            this.honorData = res.data.serviceHonorList;
            this.serviceExperienceList = res.data.serviceExperienceList;
            this.serviceProjectExperienceList =
              res.data.serviceProjectExperienceList;
            this.orgId = res.data.advisorServiceInfo.orgId;
          } else {
            this.$message.error(res.result);
            return false;
          }
        }
      });
    },
    init() {
      let query = this.$route.query;
      this.isConceal = query.isConceal;
      console.log(query)
      if(query.businessArea){
        this.basicForm.businessAreas = query.businessArea.split();
      }
      this.basicForm.orgId = query.orgId;
      this.basicForm.advisorAccount = sessionStorage.getItem("account");
      this.certificateForm.advisorAccount = sessionStorage.getItem("account");

      this.getInit();
    }
  }
};
</script>

<style lang="scss" >
.advisoryInformation {
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
    //     >span:nth-child(1){
    //       display:inline-block;
    //       color:rgba(0,160,65,1);
    //       width:90px;
    // height:29px;
    // background:rgba(236,252,242,1);
    // border:1px solid rgba(65,215,135,1);
    // border-radius:4px;
    // margin-right:85px;
    //     }
    //     >span:nth-child(2){
    //        display:inline-block;
    //       width:90px;
    //       color:rgba(255,255,255,1);
    // height:29px;
    // background:rgba(0,160,65,1);
    // border-radius:4px;
    //     }

    // display: block;
    // margin: 0 auto;
    // margin-top: 58px;
    // border-radius: 4px;
    // text-align: center;
    // cursor: pointer;
    // height: 29px;
    // line-height: 29px;
    // width: 90px;
    // color: #41d787;
    // background: rgba(236, 252, 242, 1);
    // border: 1px solid rgba(65, 215, 135, 1);
    // margin-bottom: 17px;
  }
  .el-table__header {
    border-right: 1px solid rgba(65, 215, 135, 1);
    border-left: 1px solid rgba(65, 215, 135, 1);
    table-layout: auto;
  }
  .cancel {
    margin-left: 15px;
  }
  .avatar-uploader-icon {
    border: 2px dashed #eee;
    font-size: 20px;
    color: #8c939d;
    width: 85px;
    height: 85px;
    line-height: 85px;
    text-align: center;
  }
  .avatarImg {
    //  width: 85px;
    // height: 85px;
    img {
      width: 85px;
      height: 85px;
    }
  }
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
  // .el-upload-list--picture-card .el-upload-list__item {
  //   width: 85px;
  //   height: 85px;
  // }
  // .el-upload--picture-card {
  //   width: 85px;
  //   height: 85px;
  //   line-height: 85px;
  // }
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
    // padding: unset;
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
    // font-size: 13px;
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
</style>

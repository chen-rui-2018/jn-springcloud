<template>
  <div class="acceptInvitation" v-loading="loading">
    <div class="advisory_title font16">
      <div>{{title}}</div>
      <div @click="toCounselorManagement">返回</div>
    </div>

    <div class="advisory_content">
      <div class="enterprise">基本信息 <span class="cancel" @click="cancelBasic" v-if="!isShow">取&nbsp;消</span><span v-show="!isConceal"
          @click="editBasic('basicForm')">
          <i class="el-icon-edit-outline"></i>&nbsp;{{basicText}}</span></div>
      <el-form class="tableEnterprise marBtn" v-if="isShow">
        <div style="display:flex">
          <el-form-item label="从业年限:" class="inline ">
            <span>{{basicForm.workingYears}}<i v-if="basicForm.workingYears">年</i></span>
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
          <el-input v-model="basicForm.workingYears" placeholder="请输入从业年限" clearable></el-input>
        </el-form-item>
        <el-form-item label="毕业学校:" class="inline bodyName" prop="graduatedSchool">
          <el-input v-model="basicForm.graduatedSchool" placeholder="请输入毕业学校" clearable></el-input>
        </el-form-item>

        <el-form-item label="学历:" class="inline" prop="education">
          <label slot="label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</label>
          <el-input v-model="basicForm.education" placeholder="请输入学历" clearable></el-input>

        </el-form-item>
        <el-form-item label="联系手机:" class="inline bodyName" prop="phone">
          <el-input v-model.trim="basicForm.phone" placeholder="请输入联系手机" clearable maxlength="11"></el-input>

        </el-form-item>

        <el-form-item label="联系邮箱:" class="inline" prop="contactEmail">
          <el-input v-model="basicForm.contactEmail" placeholder="请输入联系邮箱" clearable></el-input>

        </el-form-item>
        <el-form-item label="执业资质:" prop="practiceQualification">
          <el-input v-model="basicForm.practiceQualification" placeholder="请输入执业资质" clearable></el-input>

        </el-form-item>

        <el-form-item label="业务擅长:" class="inline" prop="goodAtBusiness">
          <el-input v-model="basicForm.goodAtBusiness" placeholder="请输入业务擅长" clearable></el-input>
        </el-form-item>

        <el-form-item label="个人简介:" prop="personalProfile" class="inline border-bottom">
          <el-input v-model="basicForm.personalProfile" type="textarea" autosize placeholder="请输入个人简介" clearable></el-input>
          <!-- <span>{{personalProfile}}</span> -->
        </el-form-item>

      </el-form>
      <div class="enterprise">荣誉资质 <span class="cancel" @click="cancelHonorData" v-if="isShowEdit">取&nbsp;消</span><span
          v-show="!isConceal" @click="addCertificate('certificateForm')"> <i class="el-icon-plus"></i>&nbsp;{{editText}}</span>
      </div>
      <div class="marBtn" v-if="!isShowEdit">
        <el-table :data="honorData" style="width: 98%">
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
          <el-table-column prop="certificatePhoto" align="center" label="操作" v-if="!isConceal">
            <template slot-scope="scope">
              <span class="redColor smallSize cur" @click="editCertificate(scope.row)">编辑</span>
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
        <el-form-item label="颁发时间:" class="inline" prop="getTime">

          <el-date-picker v-model="certificateForm.getTime" value-format="yyyyMM" type="month" placeholder="请选择时间">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="附件:" prop="personalProfile" class="inline border-bottom">
          <label slot="label">附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件:</label>
          <el-upload class="avatarImg" :show-file-list="false" :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
            :headers="headers" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
            <img v-if="certificateForm.certificatePhoto" :src="certificateForm.certificatePhoto">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            <!-- <i class="el-icon-plus"></i> -->
          </el-upload>
          <!-- <el-dialog :visible.sync="dialogVisible">
            <img
              width="100%"
              :src="dialogImageUrl"
              alt=""
            > -->
          <!-- </el-dialog> -->
          <!-- <span>{{personalProfile}}</span> -->
        </el-form-item>

      </el-form>
      <div class="enterprise">服务经历 <span class="cancel" @click="cancelExperienceList" v-if="isShowExperienceList">取&nbsp;消</span><span
          v-show="!isConceal" @click="addExperienceList('experienceListForm')"> <i class="el-icon-plus"></i>&nbsp;{{editExperienceList}}</span>
      </div>
      <div class="marBtn" v-if="!isShowExperienceList">
        <el-table :data="serviceExperienceList" style="width: 98%">
          <el-table-column prop="companyName" label="公司名称" align="center">
          </el-table-column>
          <el-table-column prop="position" align="center" label="职务">
          </el-table-column>
          <el-table-column prop="workTime" align="center" label="入职时间">
          </el-table-column>
          <el-table-column align="center" label="操作" v-if="!isConceal">
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
        </el-form-item>
        <el-form-item label="入职日期:" class="inline">
          <el-date-picker v-model="experienceListForm.workTime" type="month" value-format="yyyyMM" placeholder="请选择时间">
          </el-date-picker>
        </el-form-item>

      </el-form>
      <div class="enterprise">项目经验<span class="cancel" @click="cancelProjectExperienceList" v-if="isShowProjectExperienceList">取&nbsp;消</span><span
          v-show="!isConceal" @click="addProjectExperienceList('projectExperienceListForm')"> <i class="el-icon-plus"></i>&nbsp;{{editProjectExperienceList}}</span></div>
      <div class="marBtn" v-if="!isShowProjectExperienceList">
        <el-table :data="serviceProjectExperienceList" style="width: 98%">
          <el-table-column prop="projectName" align="center" label="项目名称">
          </el-table-column>
          <el-table-column align="center" prop="companyName" label="公司名称">
          </el-table-column>
          <el-table-column prop="personalDuties" align="center" label="个人职责">
          </el-table-column>
          <el-table-column prop="projectTime" align="center" label="项目时间">
          </el-table-column>
          <el-table-column align="center" label="操作" v-if="!isConceal">
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
        </el-form-item>
        <el-form-item label="公司名称:" prop="companyName">
          <el-input v-model="projectExperienceListForm.companyName" placeholder="请输入公司名称" clearable></el-input>
        </el-form-item>
        <el-form-item label="项目时间:" class="inline">
          <el-date-picker v-model="projectExperienceListForm.projectTime" type="month" value-format="yyyyMM"
            placeholder="请选择时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="个人职责:">
          <el-input v-model="projectExperienceListForm.personalDuties" placeholder="请输入个人职责" type="textarea" clearable></el-input>
        </el-form-item>

      </el-form>
      <div v-show="showBtn" class="footer ct">
        <el-button v-show="!isConceal" size="mini" @click="acceptInvitation"  class="mainColor accept">接受邀请</el-button>
        <el-button v-show="!isConceal" size="mini" type="success" @click="refuseInvitation">拒绝邀请</el-button>
      </div>

    </div>
    <el-dialog :visible.sync="dialogVisible" width="39%" :modal-append-to-body="false">
      <img :src="certificatePhoto" alt="图片" style="width:100%;">
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">返 回</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getToken, getUserInfo } from '@/util/auth'
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
    var checkWorkingYears = (rule, value, callback) => {
      const reg = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/;
      if (!reg.test(value)) {
        callback("请输入正数");
      } else {
        callback();
      }
    };
    const account = JSON.parse(getUserInfo()).account
    return {
      loading:false,
      isConceal: false,
      baseUrl: this.api.host,
      showBtn: true,
      dialogImageUrl: "",
      dialogVisible: false,
      headers: {
        token: getToken()
      },
      certificateAreasOptions: [], //证书类型
      editText: "添加荣誉资质",
      editExperienceList: "添加服务经历",
      editProjectExperienceList: "添加项目经验",
      isShowExperienceList: false,
      isShowProjectExperienceList: false,
      isShowEdit: false,
      title: "",
      // businessAreasOptions: [],
      basicText: "编 辑",
      isShow: true,
      // disabled: false,
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
        advisorAccount: account,
        businessAreas: null, //业务领域
        personalProfile: "", //个人简介
        practiceQualification: "", //执业资质
        workingYears: "", //从业年限
        graduatedSchool: "", //毕业院校
        goodAtBusiness: "", //业务擅长
        education: "", //学历
        contactEmail: "", //联系邮箱
        phone: "",
        // orgId: "285bfb89580a422ea927200f5d7accc4"
        orgId: ""
      },
      certificateForm: {
        advisorAccount: account,
        certificateName: "",
        certificateCode: "",
        id: "",
        getTime: "",
        certificatePhoto: "",
        issuingAgency: "" //颁发机构
      },
      projectExperienceListForm: {
        advisorAccount: account,
        personalDuties: "",
        companyName: "",
        id: "",
        projectName: "",
        projectTime: ""
      },
      experienceListForm: {
        advisorAccount: account,
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
        workingYears: [
          { required: true, message: "请输入从业年限", trigger: "blur" },
          { validator: checkWorkingYears, trigger: "blur" }
        ],
        graduatedSchool: [
          { required: true, message: "请输入毕业学校", trigger: "blur" }
        ],
        education: [{ required: true, message: "请输入学历", trigger: "blur" }],
        phone: [
          { required: true, message: "请输入手机号码", trigger: "blur" },
          { validator: checkPhone, trigger: "blur" }
        ],
        contactEmail: [
          { required: true, message: "请输入邮箱地址", trigger: "blur" },
          { type: "email", message: "请输入正确的邮箱地址", trigger: "blur" }
        ],
        practiceQualification: [
          { required: true, message: "请输入执业资质", trigger: "blur" }
        ],

        personalProfile: [
          { required: true, message: "请输入个人简介", trigger: "blur" }
        ],
        goodAtBusiness: [
          { required: true, message: "请输入业务擅长", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.api.get({
      url: "getUserApprovalStatus",
      // data: { orgName: "" },
      callback: res => {
        if (res.code == "0000") {
          if (res.data.approvalDesc === "认证中") {
            this.isConceal = true;
            this.changeStatus();
          } else {
            this.isConceal = false;
          }
        } else {
          this.$message.error(res.result);
        }
      }
    });
  },
  mounted() {
    this.init();
    this.getCertificateTypeList();
  },
  methods: {
    //修改消息状态（已读）
    changeStatus() {
      this.api.post({
        url: "updateIsReadStatus",
        data: { id: this.messageId },
        dataFlag: true,
        callback: res => {}
      });
    },
    //拒绝邀请
    refuseInvitation() {
      this.api.post({
        url: "refuseInvitation",
        data: { advisorAccount: this.basicForm.advisorAccount },
        dataFlag: true,
        callback: res => {
          if (res.code === "0000") {
            this.$message({
              message: "操作成功",
              type: "success"
            });
            this.$router.push({ path: "/home" });
            this.changeStatus();
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    // 接受邀请
    acceptInvitation() {

      if (!this.basicForm.workingYears) {
        this.$message.error("请先填写基本信息");
        return false;
      }
      this.loading=true
      this.api.post({
        url: "acceptOrgInvitation",
        data: { advisorAccount: this.basicForm.advisorAccount },
        dataFlag: true,
        callback: res => {
          this.loading=false
          if (res.code === "0000") {
            this.$message({
              message: "操作成功,请等待后台审核",
              type: "success"
            });
            this.$router.push({ path: "/home" });
            this.changeStatus();

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
      this.editProjectExperienceList = "保存并更新";
      this.showBtn = false;
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
                  this.isShowExperienceList = false;
                  this.showBtn = true;
                  this.editExperienceList = "添加服务经历";
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
    // 取消基本信息的更改
    cancelBasic() {
      this.isShow = true;
      this.basicText = "编 辑";
      this.showBtn = true;
      this.init();
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
      this.showBtn = true;
      this.editText = "添加荣誉资质";
    },
    // resetForm(formName) {
    //   this.$refs[formName].resetFields();
    // },
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
                  this.isShowEdit = false;
                  this.showBtn = true;
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
    // handleExceed(files, fileList) {
    //   this.$message.warning(`只能上传一张海报图片`);
    // },
    // handleRemove(file, fileList) {
    //   this.dialogImageUrl = "";
    // },
    // handlePictureCardPreview(file) {
    //   this.dialogImageUrl = file.url;
    //   this.dialogVisible = true;
    // },
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
            this.api.post({
              url: "saveOrUpdateAdvisorBaseInfo",
              data: this.basicForm,
              callback: res => {
                if (res.code == "0000") {
                  this.$message({
                    message: "操作成功",
                    type: "success"
                  });
                  this.showBtn = true;
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
        this.showBtn = false;
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
      console.log(this.$route.query);
      if (this.$route.query.businessArea) {
        this.basicForm.businessAreas = this.$route.query.businessArea.split();
      }
      let _this = this;
      this.messageId = this.$route.query.messageId;
      this.basicForm.orgId = this.$route.query.orgId;
      this.title = this.$route.query.orgName;
      _this.api.get({
        url: "serviceAdvisorInfo",
        data: { advisorAccount: this.basicForm.advisorAccount },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            if (res.data) {
              _this.basicForm.personalProfile =
                res.data.advisorServiceInfo.personalProfile;
              _this.basicForm.graduatedSchool =
                res.data.advisorServiceInfo.graduatedSchool;
              _this.basicForm.education = res.data.advisorServiceInfo.education;
              _this.basicForm.business =
                res.data.advisorServiceInfo.businessArea;
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
        }
      });
    },

    toCounselorManagement() {
      this.$router.push({ path: "/home" });
    }
  }
};
</script>

<style lang="scss" >
.acceptInvitation {
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
  // width: 813px;
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

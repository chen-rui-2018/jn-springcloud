<template>
  <div class="approveAdvisory">
    <div class="advisory_title font16" >
      <div>审批顾问</div>
      <div @click="toCounselorManagement">返回列表</div>
    </div>

    <div class="advisory_content">
      <div class="enterprise">基本信息 </div>
      <el-form class="tableEnterprise marBtn">
        <div style="display:flex">
          <el-form-item
            label="从业年限:"
            class="inline "
          >
            <span>{{workingYears}}年</span>
          </el-form-item>
          <el-form-item
            label="毕业学校:"
            class="inline bodyName"
          >
            <span>{{graduatedSchool}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="学历:"
            class="inline"
          >
            <span>{{education}}</span>
          </el-form-item>
          <el-form-item
            label="联系手机:"
            class="inline bodyName"
          >
            <span>{{phone}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="联系邮箱:"
            class="inline"
          >
            <span>{{contactEmail}}</span>
          </el-form-item>
          <el-form-item
            label="执业资源:"
            class="inline"
          >
            <span>{{practiceQualification}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="业务擅长:"
            class="inline"
          >
            <span>{{goodAtBusiness}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="个人简介:"
            class="inline border-bottom"
          >
            <span>{{personalProfile}}</span>
          </el-form-item>
        </div>
      </el-form>
      <div class="enterprise">荣誉资质</div>
      <div class="marBtn">
        <el-table
      :data="honorData"
      style="width: 100%">
      <el-table-column
        prop="certificateName"
        align="center"
        label="证书名称">
      </el-table-column>
      <el-table-column
        prop="certificateType"
        label="证书类型"
        align="center">
      </el-table-column>
      <el-table-column
        prop="getTime"
        align="center"
        label="颁发时间">
      </el-table-column>
      <el-table-column
        prop="certificatePhoto"
        align="center"
        label="附件">
      <template  slot-scope="scope">
                 <span v-if="scope.row.certificatePhoto" class="themeColor smallSize cur" @click="lookPoster(scope.row)">点击查看</span>
                 <span  v-if="!scope.row.certificatePhoto" >暂无附件</span>
            </template>
             </el-table-column>
    </el-table>
      </div>
      <div class="enterprise">服务经历</div>
      <div class="marBtn">
        <el-table
      :data="serviceExperienceList"
      style="width: 100%">
      <el-table-column
        prop="companyName"
        label="公司名称"
        align="center">
      </el-table-column>
      <el-table-column
        prop="name"
        align="position"
        label="职务">
      </el-table-column>
      <el-table-column
        prop="workTime"
        align="center"
        label="入职时间">
      </el-table-column>
    </el-table>
      </div>
      <div class="enterprise">项目经验</div>
      <div class="marBtn">
        <el-table
      :data="serviceProjectExperienceList"
      style="width: 100%">
      <el-table-column
        prop="projectName"
        align="center"
        label="项目名称">
      </el-table-column>
      <el-table-column
      align="center"
        prop="companyName"
        label="公司名称">
      </el-table-column>
      <el-table-column
        prop="personalDuties"
         align="center"
        label="个人职责">
      </el-table-column>
      <el-table-column
        prop="projectTime"
        align="center"
        label="项目时间">
      </el-table-column>
    </el-table>
      </div>
      <div class="enterprise">审批</div>
      <div class="marBtn">
          <el-form :model="counselorForm" :rules="rules" ref="counselorForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="审批结果:" prop="approvalResults">
    <el-radio-group v-model="counselorForm.approvalResults">
      <el-radio label="approved">审批通过</el-radio>
      <el-radio label="approvalNotPassed">审批不通过</el-radio>
    </el-radio-group>
  </el-form-item>
  <el-form-item label="审批说明:" prop="approvalDesc">
    <el-input type="textarea" v-model="counselorForm.approvalDesc" placeholder="请填写结果描述" autosize></el-input>
  </el-form-item>
</el-form>
      </div>
      <button class="business_footer" @click="submitForm('counselorForm')" :disabled="disabled">  提交 </button>
    </div>
       <el-dialog
  :visible.sync="dialogVisible"
  width="50%">
  <img :src="certificatePhoto" alt="图片" style="width:100%">
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">返 回</el-button>
  </span>
</el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      disabled:false,
      certificatePhoto:'',
      dialogVisible:false,
        counselorForm:{
advisorAccount: "",
            approvalResults:'',
            approvalDesc:'',
        },
        serviceProjectExperienceList:[],//项目经验表格数据
        honorData:[],//荣誉资质表格数据
        serviceExperienceList:[],//服务经历表格
      personalProfile: "", //个人简介
      practiceQualification: "", //执业资质
      workingYears: "", //从业年限
      graduatedSchool: "", //毕业院校
      goodAtBusiness: "", //业务擅长
      education: "", //学历
      contactEmail: "", //联系邮箱
      phone: "",
       rules: {
          approvalResults: [
            { required: true, message: '请选择审批结果', trigger: 'change' }
          ],
          approvalDesc: [
            { required: true, message: '请填写审批说明', trigger: 'blur' }
          ]
        } //联系手机
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    //   查看附件图片
      lookPoster(row){
        //  if(!row.posterUrl){
        //      this.$message.error('此宣传没有宣传海报')
        //  }else{
         this.certificatePhoto=row.certificatePhoto
        this.dialogVisible=true
        //  }
      },
    init() {
      let _this = this;
      this.counselorForm.advisorAccount = this.$route.query.advisorAccount;
      _this.api.get({
        url: "advisorDetails",
        data: { advisorAccount: this.counselorForm.advisorAccount },
        callback: function(res) {
          // console.log(res);
          if (res.code == "0000") {
            _this.personalProfile = res.data.advisorServiceInfo.personalProfile;
            _this.graduatedSchool = res.data.advisorServiceInfo.graduatedSchool;
            _this.education = res.data.advisorServiceInfo.education;
            _this.phone = res.data.advisorServiceInfo.phone;
            _this.contactEmail = res.data.advisorServiceInfo.contactEmail;
            _this.practiceQualification = res.data.advisorServiceInfo.practiceQualification;
            _this.workingYears = res.data.advisorServiceInfo.workingYears;
            _this.goodAtBusiness = res.data.advisorServiceInfo.goodAtBusiness;
            _this.honorData = res.data.serviceHonorList;
            _this.serviceExperienceList = res.data.serviceExperienceList;
            _this.serviceProjectExperienceList = res.data.serviceProjectExperienceList;

          }
        }
      });
    },
     submitForm(formName) {
       this.disabled=true
        this.$refs[formName].validate((valid) => {
          if (valid) {
              this.api.post({
        url: "approvalAdvisorInfo",
        data: this.counselorForm ,
        callback: (res) =>{
          console.log(res);
          if (res.code == "0000") {
           this.$message({
                message: '操作成功',
                type: 'success'
              })
              this.$router.push({ name: "counselorManagement" });
              this.disabled=false

          }else{
             this.$message.error(res.result);
              this.disabled=false
              return false
          }
        }
      });
          } else {
            this.disabled=false
            return false;
          }
        });
      },
    toCounselorManagement() {
      this.$router.push({ name: "counselorManagement" });
    },
    // toEditAdvisers() {
    //   this.$router.push({ name: "editAdvisers" });
    // }
  }
};
</script>

<style lang="scss" >
.approveAdvisory {
  .el-table thead{
color: #00A041;
  }
  .el-table td, .el-table th{
    padding:unset;
  }
  .el-table__empty-block{
    min-height: 36px;
  }
  .el-table__empty-text{
    line-height: 36px;
  }
    .el-table td, .el-table th.is-leaf{
        border-right: unset;
        // border-left:1px solid rgba(65,215,135,1);
        // border-right:1px solid rgba(65,215,135,1);
    }
    .el-table th, .el-table tr{
        width: 750px;
    height: 28px;
    background: rgba(236,252,242,1);
    border-top:1px solid rgba(65,215,135,1);
    border-bottom:1px solid rgba(65,215,135,1);
    // border: 1px solid rgba(65,215,135,1);
        padding: unset;
    font-size: 12px;
    // color: #00A041;
    font-weight: 400;
    text-align: center;
    }
    .marBtn{
       margin-bottom: 30px;
    }
    .el-textarea__inner{
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
    .bodyName{
            border-left: unset;
    }
    .border-bottom{
      border-bottom:1px solid #ccc;
    }
  }

   .advisory_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      // font-size: 13px;
      border-radius: 5px;
      div:nth-child(2){
                width:88px;
             height:26px;
           background:rgba(236,252,242,1);
           border:1px solid rgba(65,215,135,1);
               border-radius:4px;
           text-align: center;
          line-height: 26px;
        font-size: 12px;
        color:#00A041;
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
    //   >span{
    //     float: right;
    //     font-size: 12px;
    //     cursor: pointer;
    //     color:#00A041;
    //     [class*=" el-icon-"], [class^=el-icon-]{
    //       font-size: 14px;
    //       vertical-align: bottom;
    //     }
    //   }
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

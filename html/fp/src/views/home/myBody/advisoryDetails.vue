<template>
  <div class="advisoryDetails">
    <div class="advisory_title">
      <div>顾问详情</div>
      <div @click="toCounselorManagement">返回列表</div>
    </div>

    <div class="advisory_content">
      <div class="enterprise">基本信息 <span @click="toEditAdvisers"> <i class="el-icon-edit-outline"></i>&nbsp;编&nbsp;辑</span></div>
      <el-form class="tableEnterprise">
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
            class="inline bodyName"
          >
            <span>{{practiceQualification}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="业务擅长:"
            class="inline"
          >
            <span>{{phgoodAtBusinessone}}</span>
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
       align="center"
        prop="certificateName"
        label="证书名称"
        width="180">
      </el-table-column>
      <el-table-column
      align="center"
        prop="certificateType"
        label="证书类型"
        width="180">
      </el-table-column>
      <el-table-column
        prop="getTime"
        align="center"
        label="颁发时间">
      </el-table-column>
       <el-table-column
       align="center"
        prop="certificatePhoto"
        label="附件">
      </el-table-column>
    </el-table>
      </div>
       <div class="enterprise">服务经历</div>
      <div class="marBtn">
        <el-table
      :data="serviceExperienceData"
      style="width: 100%">
      <el-table-column
      align="center"
        prop="companyName"
        label="公司名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="position"
        label="职务"
        align="center"
        width="180">
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
        label="项目名称"
        align="center"
        width="180">
      </el-table-column>
      <el-table-column
        prop="companyName"
        label="公司名称"
        align="center"
        width="180">
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
      <div
        class="business_footer"
        @click="toCounselorManagement"
      >
        返回
      </div>
    </div>

  </div>
</template>

<script>
export default {
  data() {
    return {
      serviceProjectExperienceList:[],
      serviceExperienceData:[],
      honorData:[],
      account: "",
      personalProfile: "", //个人简介
      practiceQualification: "", //执业资质
      workingYears: "", //从业年限
      graduatedSchool: "", //毕业院校
      phgoodAtBusinessone: "", //业务擅长
      education: "", //学历
      contactEmail: "", //联系邮箱
      phone: "" //联系手机
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      let _this = this;
      // this.account = this.$route.query.account;
       this.account = this.$route.query.account;
       console.log(this.account)
      _this.api.get({
        url: "advisorDetails",
        data: { advisorAccount: this.account },
        callback: function(res) {
          console.log(res);
          if (res.code == "0000") {
            _this.workingYears = res.data.advisorServiceInfo.workingYears;
            _this.graduatedSchool = res.data.advisorServiceInfo.graduatedSchool;
            _this.education = res.data.advisorServiceInfo.education;
            _this.phone = res.data.advisorServiceInfo.phone;
            _this.contactEmail = res.data.advisorServiceInfo.contactEmail;
            _this.practiceQualification = res.data.advisorServiceInfo.practiceQualification;
            _this.phgoodAtBusinessone = res.data.advisorServiceInfo.goodAtBusiness;
            _this.personalProfile = res.data.advisorServiceInfo.personalProfile;
            _this.honorData = res.data.serviceHonorList;
            _this.serviceExperienceData = res.data.serviceExperienceList;
            _this.serviceProjectExperienceList = res.data.serviceProjectExperienceList;

          }
        }
      });
    },
    toCounselorManagement() {
      this.$router.push({ name: "counselorManagement" });
    },
    toEditAdvisers() {
      this.$router.push({ name: "editAdvisers" });
    }
  }
};
</script>

<style lang="scss" >
.advisoryDetails {
  .el-table thead{
color: #00A041;
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
    // text-align: center;
    }
  .marBtn{
       margin-bottom: 30px;
    }
  .tableEnterprise {
      margin-bottom: 25px;
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
      font-size: 13px;
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
    width: 813px;
    padding: 21px 28px;
    .enterprise {
      margin-bottom: 16px;
      border-left: 4px solid rgb(0, 160, 65);
      font-size: 13px;
      padding: 0px 15px;
      >span{
        float: right;
        font-size: 12px;
        cursor: pointer;
        color:#00A041;
        [class*=" el-icon-"], [class^=el-icon-]{
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

<template>
  <div class="myBody">
    <div class="business_title">
      <div class=" myBusiness font16">我的机构 </div>
      <div class="business_nav">
        <div @click="toBasicInformation" v-show="isEditBody">编辑机构</div>
        <div @click="toCounselorManagement" v-show="isCounselor">专员管理</div>
        <div @click="toEnterprisePropaganda" v-show="isPublicity">企业宣传</div>
      </div>

    </div>
    <div class="business_content">
      <div class="enterprise">基本信息</div>
      <el-form class="tableEnterprise">
        <div style="display:flex">
          <el-form-item
            label="机构名称:"
            class="inline "
          >
            <span>{{orgName}}</span>
          </el-form-item>
          <el-form-item
            label="统一社会信用代码:"
            class="inline bodyName"
          >
            <span>{{orgCode}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="注册时间:"
            class="inline"
          >
            <span>{{orgRegisterTime}}</span>
          </el-form-item>
          <el-form-item
            label="业务擅长:"
            class="inline bodyName"
          >
            <span>{{orgSpeciality}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="客户偏好:"
            class="inline"
          >
            <span>{{orgHobby}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="服务机构简介:"
            class="inline"
          >
            <span>{{orgSynopsis}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="核心服务:"
            class="inline border-bottom"
          >
            <span>{{orgBusiness}}</span>
          </el-form-item>
        </div>
      </el-form>
       <div class="enterprise">机构资质</div>
            <div class="businessArea martop"> <span>业务领域</span> <span>{{businessType}}</span></div>
            <div class="businessArea ">
              <span>营业执照</span>
               <div class="businessLicense" v-for="(item, index) in honorLicense" :key="index">
               <!-- <span class="themeColor smallSize mr">{{item.awardTime}}&nbsp;获得</span> -->
               <!-- <div class="itemInfo">
                 <div>{{item.certName}}</div>
                 <div>颁发部门：{{item.awardDepart}}</div>
                </div> -->
                 <div class="businessLicenseImg"><img :src="item.fileUrl" alt=""></div>
                </div>
            </div>
             <div class="businessArea ">
              <span>企业资质/荣誉</span>
                <div class="enterpriseQualification" v-for="(item, index) in honorLicense" :key="index">
               <span class="themeColor smallSize mr">{{item.awardTime}}&nbsp;获得</span>
               <div class="itemInfo">
                 <div>{{item.certName}}</div>
                 <div>颁发部门：{{item.awardDepart}}</div>
                </div>
                 <div class="businessLicenseImg"><img :src="item.fileUrl" alt=""></div>
                </div>
            </div>
 <div class="enterprise">团队信息</div>
 <div class="service"> <span></span> 服务机构人员结构</div>
  <el-form class="tableEnterprise">
        <div style="display:flex">
          <el-form-item
            label="员工总人数（人）:"
            class="inline "
          >
            <span>{{staffCount?staffCount:'暂无信息'}} </span>
          </el-form-item>
          <el-form-item
            label="执业人员人数（人）:"
            class="inline bodyName"
          >
            <span>{{professionNum}} <i v-show="professionNum">占比({{((professionNum/staffCount)*100).toFixed(2)}}%)</i> <i v-show="!professionNum">暂无信息</i> </span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="本科（人）:"
            class="inline"
          >
           <label slot="label">本&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;科:</label>
            <span>{{bachelorNum}} <i v-show="bachelorNum">占比({{((bachelorNum/staffCount)*100).toFixed(2)}}%)</i> <i v-show="!bachelorNum">暂无信息</i></span>
          </el-form-item>
          <el-form-item
            label="硕士（人）:"
            class="inline bodyName"
          >
           <label slot="label">硕&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;士:</label>
            <span>{{masterNum}} <i v-show="masterNum">占比({{((masterNum/staffCount)*100).toFixed(2)}}%)</i> <i v-show="!masterNum">暂无信息</i></span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="博士（人）:"
            class="inline"
          >
           <label slot="label">博&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;士:</label>
            <span>{{doctorNum}} <i v-show="doctorNum">占比({{((doctorNum/staffCount)*100).toFixed(2)}}%)</i> <i v-show="!doctorNum">暂无信息</i></span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="查询:"
            class="inline border-bottom"
          >
           <label slot="label">查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;询:</label>
            <span class="themeColor smallSize cur" @click="toAgencyColleaguesList">点击查看机构人员详情&nbsp;>&nbsp;></span>
          </el-form-item>
        </div>
      </el-form>
       <div class="enterprise">联系方式</div>
  <el-form class="tableEnterprise">
        <div style="display:flex">
          <el-form-item
            label="联系人姓名:"
            class="inline "
          >
            <span>{{conName}}</span>
          </el-form-item>
          <el-form-item
            label="联系人手机:"
            class="inline bodyName"
          >
            <span>{{conPhone}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="联系人邮箱:"
            class="inline"
          >
            <span>{{conEmail}}</span>
          </el-form-item>
          <el-form-item
            label="咨询电话:"
            class="inline bodyName"
          >
            <span>{{orgPhone}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="办公地址:"
            class="inline"
          >
            <span>{{orgAddress}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item
            label="服务机构网址:"
            class="inline border-bottom"
          >
            <span class="smallSize mainColor">{{orgWeb}}</span>
          </el-form-item>
        </div>
      </el-form>
     </div>
    </div>

  <!-- </div> -->
</template>

<script>
export default {
  data() {
    return {
      isEditBody:false,
      isCounselor:false,
      isPublicity:false,
      // businessArea:'',
      honorLicense:[],
           userAccount:'',
           orgName:'',//机构名称
           orgCode:'',//统一社会信用代码
           orgRegisterTime:'',//注册时间
           orgSpeciality:'',//业务擅长
           orgHobby:'',//客户偏好
           orgSynopsis:'',//服务机构简介
           orgBusiness:'',//核心服务
           businessType:'',//业务领域
          //  awardTime:'',//颁发时间
          //  certType:'',//证书类型：1营业执照2执业资质
          //  awardDepart:'',//颁发部门
          //  fileUrl:'',//证书文件路径
           staffCount:'',//员工总人数
           professionNum:'',//执业人员人数
           bachelorNum:'',//本科学历人数
           masterNum:'',//硕士学历人数
           doctorNum:'',//博士学历人数
          //  returneeNum:'',//海归员工人数
           conName:'',//联系人姓名
           conPhone:'',//联系人电话
           conEmail:'',//联系人邮箱
           orgPhone:'',//机构咨询电话
           orgAddress:'',//公司地址
           orgWeb:'',//公司网址


    }
  },
  mounted(){
     let initArr = JSON.parse(sessionStorage.menuItems);
    initArr.forEach(v => {
      if (v.label === "我的机构") {
        v.resourcesList.forEach(i => {
          if (i.resourcesName === "发布宣传") {
            this.isPublicity = true;
          } else if (i.resourcesName === "修改机构") {
            this.isEditBody = true;
          } else if (i.resourcesName === "专员管理") {
            this.isCounselor = true;
          }
        });
      }
    });
        this.init()
  },
  methods: {
      init(){
       this.userAccount=  sessionStorage.getItem("account");
          let _this = this;
             _this.api.get({
                   url: "getMyOrgInfo",
                   data:{account :this.userAccount},
        callback: function(res) {
          console.log(res);
          if (res.data) {
            _this.orgName = res.data.orgDetailVo.orgName
            _this.orgCode = res.data.orgDetailVo.orgCode
            _this.orgRegisterTime = res.data.orgDetailVo.orgRegisterTime
            _this.orgSpeciality = res.data.orgDetailVo.orgSpeciality
            _this.orgHobby = res.data.orgDetailVo.orgHobby
            _this.orgSynopsis = res.data.orgDetailVo.orgSynopsis
            _this.orgBusiness = res.data.orgDetailVo.orgBusiness
            _this.staffCount = res.data.orgDetailVo.staffCount
            _this.businessType = res.data.orgDetailVo.businessTypeName
            _this.honorLicense=res.data.orgDetailVo.honorLicense
            // _this.awardTime = res.data.orgDetailVo.awardTime
            // _this.certType = res.data.orgDetailVo.certType
            // _this.awardDepart = res.data.orgDetailVo.awardDepart
            // _this.fileUrl = res.data.orgDetailVo.fileUrl
            _this.professionNum = res.data.orgDetailVo.professionNum
            _this.bachelorNum = res.data.orgDetailVo.bachelorNum
            _this.masterNum = res.data.orgDetailVo.masterNum
            _this.doctorNum = res.data.orgDetailVo.doctorNum
            _this.conName = res.data.orgDetailVo.conName
            _this.conPhone = res.data.orgDetailVo.conPhone
            _this.conEmail = res.data.orgDetailVo.conEmail
            _this.orgPhone = res.data.orgDetailVo.orgPhone
            _this.orgAddress = res.data.orgDetailVo.orgAddressDetail
            _this.orgWeb = res.data.orgDetailVo.orgWeb


          }
        }
      })
      },
      toAgencyColleaguesList() {
      this.$router.push({ name: "agencyColleaguesList" });
    },
    toEnterprisePropaganda() {
      this.$router.push({ name: "enterprisePropaganda" });
    },
    toRecruitmentManagement() {
      this.$router.push({ name: "recruitmentManagement" });
    },
    toCounselorManagement(){
        this.$router.push({ name: "counselorManagement" });
    },
    toBasicInformation(){
        this.$router.push({ path: "/roleCertifications/basicInformation",query:{title:'编辑机构'} });
    }
  }
};
</script>

<style lang="scss" >
.myBody {
  .mr{
    margin-right:36px;
  }
  .businessLicenseImg{
    display: inline-block;margin-left:65px;
     vertical-align: middle;
     img{
       width: 85px;
       height: 85px;
     }
  }
  .itemInfo{
    display: inline-block;
    width: 179px;
        vertical-align: middle;
        >div:nth-child(2){
          margin-top:5px;
          font-size: 10px;
          color:#666;
        }
  }
  .enterpriseQualification{
    display: inline-block;
    vertical-align: middle;
    margin-left: 80px;
  }
  .businessLicense{
    display: inline-block;
    margin-left: 110px;
    vertical-align: middle;
    // >span{
    //   display:block;
    //   margin-bottom: 5px;
    // }
  }
  .martop{
margin-top:47px;
margin-bottom: 59px;
  }
  .businessArea{
    margin-left:15px;
    margin-bottom: 23px;
    // margin-bottom: 80px;
    >span:nth-child(2){
      margin-left:110px;
    }
  }
  .service{
    margin-bottom: 20px;
    >span{
          display: inline-block;
    width: 8px;
    height: 8px;
    margin-right: 8px;
    background: #00A041;
    border-radius: 50%;
    }
  }
  .tableEnterprise {
      margin-bottom: 25px;
    .inline {
      display: inline-block;
    }
    .el-form-item__label {
      width:140px;
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

  .business_title {
    // width: 813px;
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 19px 27px;
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
    .business_nav {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 18px 0px;
      margin-right: 8px;
      border-bottom: 1px solid #ccc;
      > div {
        margin-left: 21px;
        width: 90px;
        height: 29px;
        line-height: 29px;
        border-radius: 4px;
        text-align: center;
        cursor: pointer;
      }
      div:nth-child(1) {
        color: #41d787;
        background: rgba(236, 252, 242, 1);
        border: 1px solid rgba(65, 215, 135, 1);
      }
      div:nth-child(2) {
        color: #ffbd5c;
        background: rgba(254, 245, 229, 1);
        border: 1px solid rgba(255, 189, 92, 1);
      }
      div:nth-child(3) {
        color: #ff56b6;
        background: rgba(255, 233, 246, 1);
        border: 1px solid rgba(255, 86, 182, 1);
      }
    }
    .myBusiness {
      color: #333;
      // font-size: 13px;
      padding: 25px 0px;
      // > span {
      //   color: #00a041;
      //   font-size: 10px;
      //   cursor: pointer;
      // }
    }
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
}
</style>

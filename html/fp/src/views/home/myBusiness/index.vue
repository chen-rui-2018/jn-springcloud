<template>
  <div class="business" v-loading="loading">
    <div class="business_title">
      <div class="myBusiness">我的企业 &nbsp;(<span v-show="isColleague" @click="toColleagueList">查看企业同事</span>)</div>
      <div class="business_nav">
        <div v-show="isInvite" @click="toRecruitmentManagement">招聘管理</div>
        <div v-show="isEnterprise" @click="toEditBusiness">编辑企业</div>
        <div v-show="isStaff" @click="toStaffManagement">员工管理</div>
        <div v-show="isPublicity" @click="toEnterprisePropaganda">企业宣传</div>
      </div>

    </div>
    <div class="business_content">
      <div class="enterprise">企业资料</div>
      <el-form class="tableEnterprise">
        <div style="display:flex">
          <el-form-item label="企业名称:" class="">
            <span>{{comName}}</span>
          </el-form-item>
          <el-form-item label="企业简称:" class="borr">
            <span>{{comNameShort}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="产业领域:" class="">
            <span>{{induTypeName}}</span>
          </el-form-item>
          <el-form-item label="法人:" class="borr">
            <span>{{ownerLaw}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="联系电话:" class="">
            <span>{{ownerPhone}}</span>
          </el-form-item>
          <el-form-item label="注册时间:" class="borr">
            {{foundingTime}}
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="落地时间:" class="">
            <span>{{runTime}}</span>
          </el-form-item>
          <el-form-item label="注册地址:" class="borr">
            <span>{{comAddress}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="实际经营地址:" class="">
            <span>{{addrPark}}</span>
          </el-form-item>
          <el-form-item label="固定电话:" class="borr">
            <span>{{comTele}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="注册资金（万元）:" class="">
            <span>{{regCapital}}</span>
          </el-form-item>
          <el-form-item label="企业规模（人）:" class="borr">
            <span>{{comScale}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="统一社会信用代码:" class="">
            <span>{{unifyCode}}</span>
          </el-form-item>
          <el-form-item label="企业性质:" class="borr">
            <span>{{comPropertyName}}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="所属园区:" class=" borb">
            <span>{{affiliatedName}}</span>
          </el-form-item>
          <el-form-item label="企业官网地址:" class=" borb borr">
            <span>{{comWeb}}</span>
          </el-form-item>

        </div>

      </el-form>
      <el-form class="enterprise_bottom" label-position="right" label-width="142px">
        <el-form-item label="企业LOGO:">
          <img :src="avatar" alt="LOGO图片" class="enterprise_img">
        </el-form-item>
        <el-form-item label="三证一体或营业执照:">
          <img :src="businessLicense" alt="营业执照" class="enterprise_img">
        </el-form-item>
        <el-form-item label="企业宣传图片:">
          <div class="publicity" v-for="(item,index) in  proImgs" :key="index">
            <img :src="item" alt="企业宣传图片" class="enterprise_img">
          </div>
        </el-form-item>
      </el-form>
      <div v-if="isFooter" class="business_footer" @click="toUserCenter">
        离开企业
      </div>
    </div>

  </div>
</template>

<script>
export default {
  data() {
    return {
      loading: true,
      isFooter: false,
      companyCode: "",
      parkList: [],
      isStaff: false,
      isEnterprise: false,
      isColleague: false,
      isPublicity: false,
      isInvite: false,
      resourcesList: "",
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
      ownerPhone: "", //联系电话
      regCapital: "", //注册资本 万元
      comScale: "", //企业规模
      comType: "", //企业类型
      affiliatedName: "", //园区名称
      comWeb: "", //企业官网地址
      avatar: "", //企业logo
      businessLicense: "", //营业执照
      comPropertyName: "", //企业性质名称
      proImgs: [] //企业宣传图片
    };
  },
  created() {
    this.getParkList();
  },
  mounted() {
    let initArr = JSON.parse(sessionStorage.menuItems);
    initArr.forEach(v => {
      if (v.label === "我的企业") {
        v.resourcesList.forEach(i => {
          if (i.resourcesName === "发布企业招聘信息") {
            this.isInvite = true;
          } else if (i.resourcesName === "发布宣传") {
            this.isPublicity = true;
          } else if (i.resourcesName === "同事列表") {
            this.isColleague = true;
          } else if (i.resourcesName === "编辑企业信息") {
            this.isEnterprise = true;
          } else if (i.resourcesName === "员工列表") {
            this.isStaff = true;
          }
        });
      }
    });

    this.init();
  },
  methods: {
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
    init() {
      let _this = this;
      _this.api.get({
        url: "getCompanyDetailByAccountOrCompanyId",
        data: { accountOrCompanyId: sessionStorage.companyCode },
        callback: function(res) {
          _this.loading = false;
          if (res.code == "0000") {
            if (sessionStorage.account === res.data.comAdmin) {
              _this.isFooter = false;
            } else {
              _this.isFooter = true;
            }
            _this.comName = res.data.comName;
            _this.comNameShort = res.data.comNameShort;
            _this.induTypeName = res.data.induTypeName;
            _this.comPropertyName = res.data.comPropertyName;
            _this.ownerLaw = res.data.ownerLaw;
            _this.comTele = res.data.comTele;
            _this.runTime = res.data.runTime;
            _this.unifyCode = res.data.unifyCode;
            _this.comAddress = res.data.comAddress;
            _this.addrPark = res.data.addrPark;
            _this.ownerPhone = res.data.ownerPhone;
            _this.regCapital = res.data.regCapital;
            _this.comScale = res.data.comScale;
            _this.comType = res.data.comType;
            // _this.parkBuildName = res.data.parkBuildName;
            _this.foundingTime = res.data.foundingTime;
            _this.comWeb = res.data.comWeb;
            _this.avatar = res.data.avatar;
            _this.businessLicense = res.data.businessLicense;
            _this.proImgs = res.data.propagandaPicture;
            _this.parkList.forEach(v => {
              if (v.id === res.data.affiliatedPark) {
                _this.affiliatedName = v.parkName;
              }
            });
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    toColleagueList() {
      this.$router.push({ name: "colleagueList" });
    },
    toEnterprisePropaganda() {
      this.$router.push({ name: "enterprisePropaganda" });
    },
    toRecruitmentManagement() {
      this.$router.push({ name: "recruitmentManagement" });
    },
    toStaffManagement() {
      this.$router.push({ name: "staffManagement" });
    },
    toUserCenter() {
      this.api.post({
        url: "leaveCompany",
        data: {},
        callback: (res) =>{
          console.log(res);
          if (res.code == "0000") {
            this.$message({
              message: "操作成功",
              type: "success"
            });
            this.$router.push({ path: "/home" });
          } else {
            this.$message.error(res.result);
          }
        }
      });
      // this.$router.push({ path: "/home" });
    },
    toEditBusiness() {
      this.$router.push({ name: "editBusiness" });
    }
  }
};
</script>

<style lang="scss" >
.business {
  .tableEnterprise {
    // .inline {
    //   display: inline-block;
    // }
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
        margin-left: unset;
        color: #55a6ff;
        background: rgb(228, 240, 255);
        border: 1px solid rgba(85, 166, 255, 1);
      }
      div:nth-child(2) {
        color: #41d787;
        background: rgba(236, 252, 242, 1);
        border: 1px solid rgba(65, 215, 135, 1);
      }
      div:nth-child(3) {
        color: #ffbd5c;
        background: rgba(254, 245, 229, 1);
        border: 1px solid rgba(255, 189, 92, 1);
      }
      div:nth-child(4) {
        color: #ff56b6;
        background: rgba(255, 233, 246, 1);
        border: 1px solid rgba(255, 86, 182, 1);
      }
    }
    .myBusiness {
      color: #333;
      font-size: 16px;
      padding: 25px 0px;
      // font-family: 'MicrosoftYaHei';
      > span {
        color: #00a041;
        font-size: 12px;
        cursor: pointer;
      }
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
    .publicity {
      display: inline-block;
      vertical-align: middle;
      margin-right: 20px;
    }
    .enterprise_bottom {
      .el-form-item {
        margin-top: 36px;
        font-size: 13px;
        color: #333;
      }

      .enterprise_img {
        width: 85px;
        height: 85px;
        border-radius: 6px;
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

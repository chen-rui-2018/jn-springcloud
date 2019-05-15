<template>
  <div class="homePage" :class="{pd: $store.state.needNav}">
    <div class="homePage_content" :class="{'w': $store.state.needNav}">
      <div class="homePage_typearea">
        <!-- 面包屑 -->
        <div class="homePage_breadcrumb" v-if="$store.state.needNav">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home' }">用户中心</el-breadcrumb-item>
            <el-breadcrumb-item>
              <a href="javascript:;">{{this.$route.meta.title}}</a>
            </el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 主体内容 -->
        <el-container>
          <!-- 侧边栏 -->
          <div class="slider" v-if="$store.state.needNav">
            <el-aside width="135px">
              <el-menu :default-active="this.$route.path" class="el-menu-vertical-demo" router @open="handleOpen"
                @close="handleClose" @select="handleSelect">
                <el-menu-item index="/home">
                  <span slot="title">首页</span>
                </el-menu-item>
                <el-menu-item index="/userHome">
                  <span slot="title">用户资料</span>
                </el-menu-item>
                <el-menu-item index="/myBusiness/index">
                  <span slot="title">我的企业</span>
                </el-menu-item>
                <el-menu-item index="/myBody/index">
                  <span slot="title">我的机构</span>
                </el-menu-item>
                <el-submenu index="/认证">
                  <template slot="title">
                    <span>角色认证</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/roleCertifications/investorCertification">投资人认证</el-menu-item>
                    <el-menu-item index="" @click="checkOrganization">服务顾问认证</el-menu-item>
                    <el-menu-item index="/roleCertifications/basicInformation">服务机构认证</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="/加入园区">
                  <template slot="title">
                    <span>加入园区</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/upgradeStaff">升级员工</el-menu-item>
                    <el-menu-item index="/upgradeEnterprise">升级企业</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="/servicemarket/product/productService">
                  <template slot="title">
                    <span>产品管理</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/servicemarket/product/productService/ordinaryProduct" style="padding-left: 20px;">常规服务产品</el-menu-item>
                    <el-menu-item index="/servicemarket/product/productService/specialproduct" style="padding-left: 20px;">特色服务产品</el-menu-item>
                    <el-menu-item index="/servicemarket/product/productService/myApply" style="padding-left: 20px;">我的申请</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="/needManage">
                  <template slot="title">
                    <span>需求管理</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item style="padding-left: 20px;" index="/serviceMarket/requireManagementController/forothersneed">对他人的需求</el-menu-item>
                    <el-menu-item style="padding-left: 20px;" index="/serviceMarket/requireManagementController/receivedNeed">我收到的需求</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="/evaluateManage">
                  <template slot="title">
                    <span>评价管理</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item style="padding-left: 20px;" index="/serviceMarket/comment/forOthersevaluate">对他人的评价</el-menu-item>
                    <el-menu-item style="padding-left: 20px;" index="/serviceMarket/comment/receivedEvaluate">我收到的评价</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-menu-item index="/actiManagent">
                  <span slot="title">活动管理</span>
                </el-menu-item>
                <el-menu-item index="/servicemarket/product/productService/dataReport">
                  <span slot="title">数据上报</span>
                </el-menu-item>

                <el-submenu index="/流程系统">
                  <template slot="title">
                    <span>流程系统</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/iframe?ph=http://112.94.22.222:2381/ibps" style="padding-left: 20px;">人才申报</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>

              </el-menu>
            </el-aside>
          </div>
          <!-- 主体 -->
          <div class="homePage_main userHome">
            <el-main :class="{'isMobile': isMobile}">
              <keep-alive>
                <router-view v-if="$route.meta.keepAlive" :userData="userData"></router-view>
              </keep-alive>
              <router-view v-if="!$route.meta.keepAlive" :userData="userData"></router-view>
            </el-main>
          </div>
        </el-container>
      </div>
    </div>
    <!-- 选择机构对话框 -->
    <el-dialog title="申请顾问" :visible.sync="centerDialogVisible" width="30%" center>
      <el-form :model="organizationForm" ref="organizationForm" label-width="80px" class="demo-dynamic">
        <el-form-item prop="orgId" label="服务机构" :rules="[
      { required: true, message: '请输入你要申请入驻的机构', trigger: 'change' },
    ]">
          <el-select v-model="organizationForm.orgId" filterable placeholder="请输入你要申请入驻的机构" clearable>
            <el-option v-for="item in orgArr" :key="item.orgId" :label="item.orgName" :value="item.orgId">
            </el-option>

          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button class="btn" type="primary" @click="toAdvisoryInformation">前往填写资料</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import $ from "jquery";
import { isMobile } from "@/util";
import bus from "@/util/bus";
import UserHome from "@/components/userHome";
export default {
  components: { UserHome },
  data() {
    return {
      isMobile: isMobile(),
      orgArr: [],
      organizationForm: {
        orgName: "",
        orgId: ""
      },
      centerDialogVisible: false,
      sousuo: false,
      menuFlag: false,
      userData: {
        avatar: ""
      },
      dataTop: [
        {
          name: "用户资料",
          flag: false,
          path: "/user",
          pathName: "user",
          id: 0
        }
      ]
    };
  },
  directives: {
    focus: {
      // 指令的定义
      inserted: function(el) {
        el.focus();
      }
    }
  },
  watch: {
    centerDialogVisible(val) {
      !val &&
        setTimeout(() => {
          this.$refs["organizationForm"].resetFields();
        }, 0);
    }
  },
  created() {
    bus.$on("getUserinfoF", res => {
      this.getUserExtension();
    });
  },
  mounted() {
    this.getUserExtension();
  },
  updated() {
    try {
      var iframe = document.getElementById("live");
      iframe.onload = function() {};
      iframe.onreadystatechange = function() {
        if (iframe.readyState == "complete") {
          // alert("Local iframe is now loaded.")
        }
      };
    } catch (e) {}
  },
  methods: {
    // 前往填写页面
    toAdvisoryInformation() {
      this.$refs["organizationForm"].validate(valid => {
        if (valid) {
          this.centerDialogVisible = false;
          this.$router.push({
            name: "advisoryInformation",
            query: {
              orgId: this.organizationForm.orgId
            }
          });
        } else {
          return false;
        }
      });
    },
    //获取机构列表
    query() {
      this.api.get({
        url: "selectOrgInfo",
        data: { orgName: "" },
        callback: res => {
          if (res.code == "0000") {
            if (res.data != null) {
              this.orgArr = res.data;
            }
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },

    // 弹出选择机构对话框
    checkOrganization() {
      this.orgArr = [];
      this.organizationForm.orgName = "";
      this.organizationForm.orgId = "";
      this.centerDialogVisible = true;
      this.query();
    },
    handleSearch() {},
    loginOut() {
      window.sessionStorage.removeItem("token");
      this.$router.push({ path: "/" });
    },
    dianji(i) {
      if (this.$route.name == i.pathName) {
        return;
      }
      this.$router.push(`${i.path}?account=${this.$route.query.account}`);
    },
    handleChange() {
      // this.sousuo = true;
    },
    getUserExtension() {
      let _this = this;
      this.api.get({
        url: "getUserExtension",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            if (res.data != null) {
              _this.userData = res.data;
            }
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    // 导航栏两个
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
};
</script>
<style lang="scss">
  .header.user-center {
    background-color: #fff;
    .router-link {
      color: #333;
    }
  }
.homePage {
  &.pd {
    padding-top: 66px;
  }
  background: #f3f3f3;
  .btn {
    text-align: center;
    background: rgba(236, 252, 242, 1);
    border: 1px solid rgba(65, 215, 135, 1);
    border-radius: 4px;
    color: #00a041;
    font-size: 12px;
    padding: 9px 13px;
  }
  .demo-dynamic {
    display: inline-block;
    .el-form-item__content {
      height: 33px;
      line-height: 33px;
      // width: 266px;
    }
    .el-input-group__append {
      background-color: #00a041;
      color: #fff;
      border: none;
      font-size: 13px;
      // border-bottom: 1px solid #fff;
    }
    .el-form-item {
      display: inline-block;
    }
    .el-input__inner {
      height: 33px;
      line-height: 33px;
      width: 266px;
    }
    .el-input {
      width: 266px;
    }
    .el-form-item__label {
      height: 33px;
      line-height: 33px;
    }
    .orgStyle {
      border: 1px solid rgba(65, 215, 135, 1);
      text-align: left;
      margin-bottom: 20px;
      max-height: 150px;
      overflow: auto;
      li {
        margin-left: 10px;
        cursor: pointer;
      }
    }
  }
  .el-dialog--center .el-dialog__body {
    padding: 10px 20px 0px 20px;
    text-align: center;
  }
.header {
    padding: 0px 160px;
    box-shadow: 0px 12px 12px #e6e6e6;
    background-color: #fff;
    color: black;
    .titleImg {
      width: 155px;
      height: 38px;
      padding: 18px 0;
      img {
        width: 100%;
        height: 100%;
      }
    }
    .nav {
      width: 600px;
      height: 37.6px;
      margin: 0 auto;
      > ul {
        > li {
          float: left;
          color: black;
          font-size: 14px;
          text-align: center;
          line-height: 38px;
          margin: 0 50px;
          padding: 19px 0;
        }
      }
      .sousuo {
        font-size: 18px;
        // height: 38px;
        line-height: 38px;
        // width: 397px;
        > input {
          border: none;
          width: 350px;
          height: 38px;
          font-size: 14px;
        }
        > input::-webkit-input-placeholder {
          color: #b7b7b7;
          font-size: 12px;
        }
      }
    }
    .headerRight {
      line-height: 38px;
      .imgU {
        width: 74px;
        height: 74px;
        display: inline-block;
        > img {
          width: 34px;
          height: 34px;
          border-radius: 50%;
        }
      }
      .imgU.active {
        background: #00a040;
      }
      .line {
        height: 10px;
        display: inline-block;
        background: #ccc;
        width: 1px;
        // margin: 0 10px;
        margin-left: 10px;
      }
      .avaMenu {
        position: absolute;
        box-shadow: 2px 2px 5px #eee;
        background: #fff;
        z-index: 4;
        left: 5px;
        // .avaUL{
        //   width: 150px;
        //   >li{
        //     padding:5px 15px;
        //     font-size: 13px;
        //     color:#333;
        //     cursor: pointer;
        //   }
        // }
        ul {
          width: 150px;
          > li {
            padding: 5px 15px;
            font-size: 13px;
            color: #333;
            cursor: pointer;
          }
          > li.liActi {
            background: #00a040;
            color: #fff;
          }
        }
        .bxcard .el-card__body {
          padding: 0;
        }
      }
    }
  }
  .homePage_content {
    font-size: 13px;
    color: #333;
    padding-bottom: 50px;
    .homePage_typearea {
      // 面包屑
      .homePage_breadcrumb {
        padding: 15px 0;
        font-size: 12px;
        .el-breadcrumb__item:last-child .el-breadcrumb__inner a {
          color: #00a041;
        }
      }
      // 侧边栏
      .slider {
        .el-submenu__title {
          border-top: 1px solid #eee;
          // border-bottom: 1px solid #eee;
        }
         .el-aside{
            border-radius: 5px;
          }
          .el-menu{
            border-right: none;
          }

        .el-menu-item.is-active {
          color: #00a042;
          background-color: #fff;
          border-left: 2px solid #00a042;
          &:hover {
            color: #fff;
            background-color: #00a042;
            border-left: 2px solid #00a042;
          }
        }
        .el-menu-item,
        .el-submenu__title {
          height: 52px;
          line-height: 52px;
          margin-bottom: 9px;
        }
        .el-submenu__title:hover {
          background-color: #00a042;
          color: #fff;
        }
        .el-submenu .el-menu-item {
          padding: 0;
          min-width: 0;
        }
        .el-submenu.is-active .el-submenu__title {
          // border-left: 2px solid #00a042;
          border-left: 2px solid #00a042;
        }
        .el-menu-item-group {
          background-color: #f7f7f7;
          .el-menu-item.is-active {
            border-left: none;
          }
          .el-menu-item {
            background-color: #f7f7f7;
            margin: 0;
          }
        }
        .homePage_main{
          flex: 1;
          .el-main {
            padding: 0 20px;
          }
          .el-main.isMobile{
            padding: 0;
          }
        .el-menu-item:hover {
          color: #fff;
          background-color: #00a042;
        }
      }
      }

    .isMobile {
      .el-tabs--border-card > .el-tabs__content {
        padding: 0;
      }
    }
  }
  .homePage_main {
    flex: 1;
    width: 100%;
  }
}
}

</style>

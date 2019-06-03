<template>
  <div class="homePage" :class="{pd: $store.state.hiddenNav}">
    <div class="homePage_content" :class="{'w': $store.state.hiddenNav}">
      <div class="homePage_typearea">
        <!-- 面包屑 -->
        <div class="homePage_breadcrumb" v-if="$store.state.hiddenNav">
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
          <div class="slider" v-if="$store.state.hiddenNav">
            <el-aside width="150px">
              <el-menu :default-active="this.$route.path" class="el-menu-vertical-demo" router @open="handleOpen"
                @close="handleClose" @select="handleSelect">
                <sidebar-item v-for="(item,index,key) in menuItems" :key="key" :item="item" :index="item.id" />
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
  </div>
</template>
<script>
import $ from "jquery";
import api from '@/util/api'
import SidebarItem from './common/SidebarItem'
import { isMobile } from "@/util";
import bus from "@/util/bus";
import UserHome from "@/components/userHome";
export default {
  components: { UserHome ,SidebarItem},
  //  components: { SidebarItem },
  data() {
    return {
      businessArea:'',
      menuItems:[],
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
  // watch: {
  //   centerDialogVisible(val) {
  //     !val &&
  //       setTimeout(() => {
  //         this.$refs["organizationForm"].resetFields();
  //       }, 0);
  //   }
  // },
  beforeRouteEnter(to, from, next) {
    bus.$on("getUserinfoF", res => {
      this.getUserExtension();
    });
    let token=sessionStorage.token
    api.post({
      url: "getDynamicMenu",
      headers: { token: token },
      callback: res => {
        if (res.code === "0000") {
          res.data.forEach(val=>{
            if(val.label==='门户'){
              let menuItems = val.children[0].children
              sessionStorage.menuItems= JSON.stringify(menuItems)
              console.log(menuItems)
              next(vm => {
                vm.menuItems = menuItems
                }

              )
            }
          })

        } else {
          this.$message.error(res.result);
        }
      }
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
    getBusinessArea(value){
        this.orgArr.forEach(v=>{
          if(value===v.orgId){
         this.businessArea=v.businessArea
          }
        }
        )
    },
    // 前往填写页面
    toAdvisoryInformation() {
      this.$refs["organizationForm"].validate(valid => {
        if (valid) {
          this.centerDialogVisible = false;
          this.$router.push({
            name: "advisoryInformation",
            query: {
              orgId: this.organizationForm.orgId,
              businessArea:this.businessArea
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
      console.log(keyPath);
      if(keyPath=='/roleCertifications/advisoryInformation'){
        console.log(123)
        this.checkOrganization()
      }
    }
  }
};
</script>
<style lang="scss">
 .el-main {
            padding: 0 20px;
          }
  .header.user-center {
    background-color: #fff;
    .router-link {
      color: #333;
    }
  }
.homePage {
  .el-main {
    padding: 0 20px;
    &.isMobile {
      padding: 0;
    }
  }
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
          background-color: #f7f7f7;
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
          background-color: #f7f7f7;
        }
       .el-submenu .el-menu-item.is-active{
         border-left:none;
       }
        .el-submenu.is-active .el-submenu__title {
          border-left: 2px solid #00a042;
        }
         .el-menu-item {
            //
            margin: 0;
          }
        .el-menu-item:hover {
          color: #fff;
          background-color: #00a042;
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
        .el-menu-item:hover {
          color: #fff;
          background-color: #00a042;

          .el-main.isMobile{
            padding: 0;
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
}

</style>

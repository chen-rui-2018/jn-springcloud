<template>
  <div class="homePage">
    <div class="header clearfix">
      <div class="titleImg fl"><img src="@/../static/img/login-logo.png" alt=""></div>
      <div class="headerRight fr pr">
        <i class="el-icon-search" v-if="!sousuo" @click="handleChange" style="vertical-align: middle;font-size:18px;color:#666;"></i>
        <i class="el-icon-bell" style="vertical-align: middle;margin-left:20px;font-size:18px;color:#666;"></i>
        <span class="line" style="vertical-align: middle;"></span>
        <div class="imgU" :class="{'active':menuFlag}" alt="" @click.stop="menuFlag=!menuFlag">
          <img v-if="userData.avatar" :src="userData.avatar" style="vertical-align: middle;padding:20px">
          <img v-else src="@/../static/img/smaImg.png" style="vertical-align: middle;padding:20px">
        </div>

        <div class="avaMenu" v-if="menuFlag">
          <el-card class="box-card bxcard">
            <ul class="avaUL">
              <li style="border-bottom:1px solid #eee;">您好,{{userData.account}}</li>
              <!-- <li :class="{'liActi':$route.name == i.pathName}" v-for="(i,k) in dataLeft" :key="k" @click="dianji(i)">{{i.name}}</li> -->
              <li :class="{'liActi':$route.name == i.pathName}" v-for="(i,k) in dataTop" :key="k" @click="dianji(i)">{{i.name}}</li>
              <li style="border-top:1px solid #eee;" @click.stop="loginOut">退出</li>
            </ul>
          </el-card>
        </div>
      </div>
      <div class="nav">
        <transition name="fade">
          <div class="sousuo posA" v-if="sousuo">
            <i class="el-icon-close" style="vertical-align: middle;" @click="sousuo=false"></i>
            <input type="text" v-focus @keyup.enter="handleSearch">
            <i class="el-icon-search" style="vertical-align: middle;" @click="sousuo=false"></i>
          </div>

          <ul class="clearfix posA" v-else>
            <li @click="$router.push({path:'/'})">
              <a href="javascript:void(0);">首页</a>
            </li>
            <li>
              <a href="javascript:void(0);">招商引资</a>
            </li>
            <li>
              <a href="javascript:void(0);">智慧党建</a>
            </li>
            <li @click="$router.push({path:'/enterpriseservice'})">
              <a href="javascript:void(0);">企业服务</a>
            </li>
          </ul>
        </transition>
      </div>
    </div>
    <div class="homePage_content w">
      <div class="homePage_typearea">
        <!-- 面包屑 -->
        <div class="homePage_breadcrumb">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home' }">用户中心 </el-breadcrumb-item>
            <el-breadcrumb-item>
              <a href="javascript:;">{{this.$route.meta.title}}</a>
            </el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 主体内容 -->
        <el-container>
          <!-- 侧边栏 -->
          <div class="slider">
            <el-aside width="135px">
              <el-menu
                :default-active="this.$route.path"
                class="el-menu-vertical-demo"
                router
                @open="handleOpen"
                @close="handleClose"
                @select="handleSelect"
                >
                <el-menu-item index="/servicemarket/product/userCenter">
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
                    <el-menu-item index="">认证</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="/加入园区">
                  <template slot="title">
                    <span>加入园区</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/servicemarket/product/productService/加入园区">加入园区</el-menu-item>
                    <el-menu-item index="">加入园区</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="/servicemarket/product/productService">
                  <template slot="title">
                    <span>产品管理</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/servicemarket/product/productService/ordinaryProduct" style="padding-left: 20px;">常规服务产品</el-menu-item>
                    <el-menu-item index="/servicemarket/product/productService/specialproduct" style="padding-left: 20px;">特色服务产品</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="/需求管理">
                  <template slot="title">
                    <span>需求管理</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/servicemarket/product/productService/需求管理">需求管理</el-menu-item>
                    <el-menu-item index="">需求管理</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="/评价管理">
                  <template slot="title">
                    <span>评价管理</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/servicemarket/product/productService/评价管理">评价管理</el-menu-item>
                    <el-menu-item index="">评价管理</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-menu-item index="/活动管理">
                  <span slot="title">活动管理</span>
                </el-menu-item>
                <el-menu-item index="/servicemarket/product/productService/dataReport">
                  <span slot="title">数据上报</span>
                </el-menu-item>
              </el-menu>
            </el-aside>
          </div>
          <!-- 主体 -->
          <div class="homePage_main userHome">
            <el-main>
                <router-view :userData='userData'></router-view>
            </el-main>
          </div>
        </el-container>
      </div>
    </div>
  </div>
</template>
<script>
import $ from 'jquery'
import bus from "@/util/bus";
import UserHome from '@/components/userHome'
export default {
  components:{UserHome},
  data() {
    return {
      sousuo: false,
      menuFlag: false,
      userData: {
        avatar:''
      },
      dataTop:[
        {
          name: "用户资料",
          flag: false,
          path:'/user',
          pathName: "user",
          id: 0,
        }
      ],

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
  created() {
    bus.$on("getUserinfoF", res => {
      this.getUserExtension();
    });
  },
  mounted() {
    this.getUserExtension();
  },
  updated(){
    try {
        var iframe = document.getElementById('live')
        iframe.onload = function () {
        }
      iframe.onreadystatechange = function() {
        if (iframe.readyState == "complete") {
          // alert("Local iframe is now loaded.")
        }
      }
    }catch (e) {
    }
  },
  methods: {
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
            if(res.data!=null){
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
  .homePage{
    background: #f3f3f3;
    .header {
      padding: 0px 160px;
      box-shadow: 0px 12px 12px #e6e6e6;
      background-color: #fff;
      color:black;
      .titleImg {
        width: 155px;
        height: 38px;
        padding:18px 0;
        img {
          width: 100%;
          height: 100%;
        }
      }
      .nav {
        width: 600px;
        height: 37.6px;
        margin: 0 auto;
         >ul {
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
          >input::-webkit-input-placeholder {
            color: #b7b7b7;
            font-size: 12px;
          }
        }
      }
      .headerRight {
        line-height: 38px;
        .imgU{
          width: 74px;
          height: 74px;
          display: inline-block;
          >img{
           width: 34px;
           height: 34px;
            border-radius: 50%;
          }
        }
        .imgU.active{
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
        .avaMenu{
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
          ul{
            width: 150px;
            >li{
              padding:5px 15px;
              font-size: 13px;
              color:#333;
              cursor: pointer;

            }
            >li.liActi{
              background: #00a040;
              color:#fff;
            }
          }
          .bxcard .el-card__body{
            padding:0;
          }
        }
      }
    }
    .homePage_content{
      font-size: 13px;
      color: #333;
      padding-bottom: 50px;
      .homePage_typearea{
        // 面包屑
        .homePage_breadcrumb{
          padding: 15px 0;
          font-size: 12px;
          .el-breadcrumb__item:last-child .el-breadcrumb__inner a{
            color:#00a041;
          }
        }
        // 侧边栏
        .slider{
          .el-submenu__title{
            border-top: 1px solid #eee;
            // border-bottom: 1px solid #eee;
          }

          .el-menu-item.is-active{
            color:#00a042;
            background-color:#fff;
             border-left: 2px solid #00a042;
            &:hover{
            color:#fff;
            background-color: #00a042;
            border-left: 2px solid #00a042;
            }
          }
          .el-menu-item, .el-submenu__title{
            height:52px;
            line-height: 52px;
            margin-bottom: 9px;
          }
          .el-submenu__title:hover{
            background-color: #00a042;
            color:#fff;
          }
          .el-submenu .el-menu-item{
            padding:0;
            min-width:0;
          }
          .el-submenu.is-active .el-submenu__title{
            // border-left: 2px solid #00a042;
              border-left: 2px solid #00a042;
          }
          .el-menu-item-group{
            background-color: #f7f7f7;
            .el-menu-item.is-active{
              border-left: none;
            }
            .el-menu-item{
              background-color: #f7f7f7;
              margin:0;
            }
          }
          .el-menu-item:hover{
            color:#fff;
            background-color: #00a042;
          }
        }
        .homePage_main{
          flex: 1;
          .el-main{
            padding: 0 20px;
          }
        }
      }
    }
    .homePage_main {
      flex: 1;
      width: 100%;
    }
  }
</style>

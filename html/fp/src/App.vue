<template>
  <div id="app" :class="{'h-100': $store.state.isMobile}" @click="closeM">
    <div :class="{'h-100': $store.state.isMobile}" class="s-wrapper">
      <div :class="{'h-100': $store.state.isMobile}" class="s-content">
        <!--    <router-view></router-view>-->
        <div class="right_nav" v-if="$store.state.hiddenNav">
          <ul>
            <li @click="isVisibility=true">
              <div class="right_nav_slide">
                <i class="iconfont icon-menu1"></i>
              </div>
            </li>
            <li>
              <div class="right_nav_tel" @mouseenter="telShow=true" @mouseleave="telShow=false">
                <i class="iconfont icon-phone"></i>
              </div>
            </li>
            <li>
              <div class="weixin" @mouseenter="show=true" @mouseleave="show=false">
                <i class="iconfont icon-weixin2"></i>
              </div>
            </li>
            <li>
              <div class="online_service">
                <i class="iconfont icon-kefu"></i>
              </div>
            </li>
            <li @click="toTop">
              <div class="to_top">
                <i class="iconfont icon-top1"></i>
              </div>
            </li>
          </ul>
          <!--  -->
          <transition enter-active-class='animated fadeIn' leave-active-class='animated fadeOut' name='fade'>
            <span class="weixin_img" v-if="show"><img src="@/../static/img/xiaocehngxu.png" alt=""> </span>
            <span class="tel_img" v-if="telShow">
          <span> <img src="@/../static/img/andriod.png" alt="">
            <span>android</span>
          </span>
          <span> <img src="@/../static/img/apple.png" alt="">
            <span>ios</span>
          </span>
        </span>
          </transition>
        </div>
        <!-- 网站导航侧边 -->
        <div class="serve_slide" v-if="$route.name=='serMatHp'||$route.name=='portalIndex'||$route.name=='enterpriseservice'||$route.name=='investment'">
          <el-dialog :visible.sync="isVisibility" :lock-scroll="false">
            <div class="slide_nav">
              <p @click="$router.push({path:'/'})">首页</p>
              <p @click="$router.push({path:'/parkIntroduction'})">园区介绍</p>
              <p @click="$router.push({path:'/compassView'})">行政审批</p>
              <!-- <p >智慧党建</p> -->
              <p @click="$router.push({path:'/enterpriseservice'})">企业服务</p>
              <div class="slide_nav_fence">
                <ul>
                  <!-- <li @click="$router.push({path:'/talentsService'})">人才服务</li> -->
                  <li @click="$router.push({path:'/policyCenter'})">政策中心</li>
                  <li @click="$router.push({path:'/actiCenter'})">活动中心</li>
                  <li @click="$router.push({path:'/tfindex'})">科技金融</li>
                  <li @click="$router.push({path:'/recruitmentList'})">人力资源</li>
                  <!-- <li @click="$router.push({path:'/incubatorEnterprises'})">孵化企业</li> -->
                  <!-- <li @click="$router.push({path:'/compassView'})">行政审批</li> -->
                  <li @click="$router.push({path:'/declarationCenter'})">申报中心</li>
                  <li @click="$router.push({path:'/serMatHp'})">服务超市</li>
                </ul>
              </div>
              <p @click="$router.push({path:'/talentsService'})" style="margin-top:30px">人才服务</p>
              <!-- <p @click="$router.push({path:'/declarationCenter'})">申报中心</p> -->
              <p @click="$router.push({path:'/incubatorEnterprises'})">孵化企业</p>
              <!-- <p @click="$router.push({path:'/serMatHp'})">服务超市</p> -->
            </div>

            <div class="personal_center ">
              <p @click="$router.push({path:'/home'})">用户中心</p>
              <p @click="$router.push({path:'/parkNotice'})">消息中心</p>
            </div>
          </el-dialog>
        </div>
        <!-- <app-header v-if="$route.name=='actiCenter'||$route.name=='actiDetail'||$route.name=='regData'||$route.name=='regStatus'||$route.name=='actiManagent'||$route.name=='peoDec'"></app-header> -->
        <!-- <ser-header v-if="$route.name=='actiTrain'||$route.name=='index'"></ser-header>z -->
        <!--  <adminApprove-header v-if="$route.name=='compassView'||$route.name=='rightDetail'||$route.name=='serviceDetail'||$route.name=='declarationCenter'||$route.name=='declarationPlatform'||$route.name=='declarationNoticeDetail'||$route.name=='declarationCenter'||$route.name=='talentsService'||$route.name=='talentPlatform'||$route.name=='talentsServiceDetail'"></adminApprove-header> -->
        <app-header v-if="$route.name=='actiDetail'||$route.name=='regData'||$route.name=='regStatus'"></app-header>

        <ser-header v-if="$route.name=='actiTrain'||$route.name=='actiTrainDetail'||$route.name=='actiTrainStatus'||$route.name=='serverOrg'||$route.name=='actiTrainData'||$route.name=='serverOrgDetail'||$route.name=='serverPro'||$route.name=='serverProDetail'||$route.name=='serverCon'||$route.name=='serverConDetail'||$route.name=='quickSearch'||$route.name=='aboutUs'"></ser-header>
        <technology-Header v-if="$route.name=='investor'||$route.name=='investorDetail'||$route.name=='finaInstitution'||$route.name=='finaInsDetail'||$route.name=='finaPro'||$route.name=='finaProDetail'"></technology-Header>

        <!-- <ser-header v-if="$route.name=='actiTrain'||$route.name=='serverOrg'||$route.name=='serverOrgDetail'||$route.name=='serverPro'||$route.name=='serverProDetail'||$route.name=='serverCon'||$route.name=='serverConDetail'||$route.name=='quickSearch'||$route.name=='aboutUs'"></ser-header> -->
        <!-- <technology-Header v-if="$route.name=='investor'||$route.name=='investorDetail'||$route.name=='finaInstitution'||$route.name=='finaInsDetail'"></technology-Header> -->

        <router-view class="routView" />
      </div>
      <div class="s-footer">
        <app-footer v-cloak v-if="$route.name!=='login'&&$route.name!=='register'&&$route.name!=='forgetPsw'&& $store.state.hiddenNav"></app-footer>
      </div>
    </div>
  </div>
</template>

<script>
import AppHeader from "./components/header";
import AppFooter from "./components/footer";
import SerHeader from "./components/serverHeader";
import adminApproveHeader from "./components/adminApproveHeader";
import TechnologyHeader from "./components/technologyHeader";
import "./common/font/font.css";
import { getToken, setToken } from "@/util/auth";
import { isMobile } from "@/util";
import bus from "@/util/bus";

let timer = null;

export default {
  name: "App",
  components: {
    AppHeader,
    AppFooter,
    SerHeader,
    adminApproveHeader,
    TechnologyHeader
  },
  props: {
    step: {
      type: Number,
      default: 100
    }
  },
  data() {
    return {
      isMobile: isMobile(),
      show: false,
      isVisibility: false,
      telShow: false,
      body: null
    };
  },
  mounted() {
    let vm = this;
    window.onscroll = function() {
      if (document.documentElement.scrollTop > 60) {
        vm.isActive = true;
      } else {
        vm.isActive = false;
      }
    };
    if (this.isMobile) {
      this.body = document.getElementsByTagName('body')[0]
      this.body.classList.add('app')
    }
  },
  destroyed() {
    if (this.isMobile) {
      this.body.classList.remove('app')
    }
  },
  methods: {
    toTop() {
      timer = setInterval(function() {
        let osTop =
          document.documentElement.scrollTop || document.body.scrollTop;
        let ispeed = Math.floor(-osTop / 5);
        document.documentElement.scrollTop = document.body.scrollTop =
          osTop + ispeed;
        this.isTop = true;
        if (osTop === 0) {
          clearInterval(timer);
        }
      }, 30);
    },
    closeM() {
      bus.$emit("closeKnow");
    }
  }
};
</script>

<style lang="scss">
  .s-wrapper {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
  }

  .s-content {
    flex: 1;
  }

  .s-footer {
    flex: 0;
  }
/* 引入全局样式 */
@import url(./css/animate.css);
@import url(./css/main.css);
@import url(./css/home.css);
@import url(./css/serviceMarket.css);
/*html,*/
/*body,*/
/*#app{*/
/*  width: 100%;*/
/*  height: 100%;*/
/*  overflow: auto;*/
/*}*/
[v-if],
[v-show],
[v-cloak] {
  display: none !important;
}
.app {
  .el-message-box {
    width: 90%;
    position: absolute;
    left: 5%;
    top: 50%;
    transform: translateY(-50%);

  }
}
#app {
  font-family: "Microsoft YaHei", "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  // .routView{
  //   min-height: 500px;
  // }
  .fadeIn {
    animation-duration: 0.3s;
    animation-delay: 0.4s;
  }
  .fadeOut {
    animation-duration: 0.3s;
    // animation-delay:0.3s;
  }
  .weixin_img {
    width: 171px;
    height: 170px;
    background: rgba(225, 225, 225, 0.8);
    border-radius: 11px;
    text-align: center;
    position: relative;
    right: 20px;
    display: inline-block;
    img {
      width: 80%;
      padding: 10%;
    }
  }
  .tel_img {
    width: 342px;
    height: 180px;
    background: rgba(225, 225, 225, 0.8);
    border-radius: 11px;
    text-align: center;
    position: relative;
    right: 20px;
    display: flex;
    > span {
      flex: 1;
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      align-items: center;
      img {
        height: 75%;
        margin: 8% auto;
        margin-bottom: 0;
        width: 82%;
      }
      // &:nth-child(2){
      //   img{
      //     margin-left: 0;
      //   }
      // }
      > span {
        width: 100%;
        line-height: 1;
        padding-bottom: 5px;
      }
    }
  }
  .right_nav {
    position: fixed;
    right: 0;
    top: 60%;
    z-index: 100;
    ul {
      bottom: 40px;
      float: right;
      li {
        position: relative;
        list-style: outside none none;
        height: 42px;
        width: 42px;
        cursor: pointer;
        div {
          width: 42px;
          height: 42px;
          color: #fff;
          background-color: #00a041;
          float: left;
          position: absolute;
          right: 0;
          transition: all 0.3s ease 0s;
          overflow: hidden;
          i {
            display: inline-block;
            margin: 11px;
            font-size: 19px;
          }
        }
        /* .right_nav_tel{

          }
          .weixin:hover{

          } */
      }
    }
  }
}
.el-submenu__title {
  padding-left: 30px;
  text-align: left;
}
.serve_slide {
  .slide_nav {
    color: #00a042;
    border-bottom: 1px solid #00a042;
    padding: 20px;
    p {
      padding-bottom: 37px;
      font-size: 18px;
      cursor: pointer;
    }
    p:nth-child(4) {
      padding-bottom: 0px;
    }
    .slide_nav_fence {
      font-size: 14px;
      li {
        padding-bottom: 8px;
        cursor: pointer;
        &:nth-child(1) {
          padding-top: 10px;
        }
      }
    }
  }
  .personal_center {
    padding: 30px 20px;
    p {
      padding-bottom: 15px;
      cursor: pointer;
    }
  }
  .el-dialog__headerbtn .el-dialog__close:hover {
    color: #00a041;
  }
  .el-dialog__headerbtn:hover {
    .el-dialog__headerbtn .el-dialog__close {
      color: #00a041;
    }
  }
}
.el-pagination {
  margin-top: 15px;
}
/* .el-menu-item-group__title {
  padding-left: 30px;
  text-align: left;
}
.el-submenu__title{
  padding-left: 50px;
} */
</style>

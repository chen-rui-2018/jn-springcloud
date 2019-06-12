<template>
  <div
    :class="{'h-100': $store.state.isMobile}"
    class="portalIndex">
    <div class="portalIndexImg" v-if="$store.state.hiddenNav">
      <div class="header" id="header" :class="{'headerw':isCenter||showFF}">
        <div class="headerContainer clearfix">
          <div class="titleImg fl">
            <img src="@/../static/img/login-logo.png" v-if="isCenter||showFF" class="pointer" alt="" @click="$router.push({path:'/'})">
            <img src="@/../static/img/LOGO1.png" v-else class="pointer" alt="" @click="$router.push({path:'/'})">
          </div>
          <div class="headerRight fr pr">
            <!-- <router-link to="/allMesList" class="search" v-if="isLogin">
              <i class="el-icon-bell" style="font-size:20px"></i>
            </router-link> -->
            <!-- <span v-if="isLogin" style="margin-right:10px">您好！{{accoutInfo}}</span> -->
            <!-- <div class="search pointer" v-if="luyouString.indexOf($route.name) == -1">
              <i class="el-icon-search" @click="show4=true" style="font-size:20px"></i>
            </div> -->
            <user-info></user-info>
            <!-- <div class="navlogin">
              <router-link to="/parkNotice" class="" v-if="isLogin">
              <i class="el-icon-bell" style="font-size:20px" @mouseenter="showMes=!showMes"></i>
              </router-link>
              <a @click="$router.push({path:'/login'})" v-else>登录</a>
              <span class="line">|</span>
              <a @click="$router.push({path:'/register'})">注册</a>
            </div> -->
          </div>

          <div class="nav" id="nav">
            <ul class="posA clearfix">
              <li class="">
                <router-link to="/" class="router-link" :class="{'ru-active':$route.path == '/'}" >首页</router-link>
              </li>
              <li>
                <router-link to="/investment" class="router-link" :class="{'ru-active':$route.path == '/investment'}">招商引资</router-link>
              </li>
              <li>
                <router-link to="/enterpriseservice" class="router-link" :class="{'ru-active':$route.path == '/enterpriseservice'}">企业服务</router-link>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <!-- <div class="mesage11" v-if="showMes"  @mouseleave="showMes=!showMes">
        <el-card>
          <div class="firli"><span class="color1">消息中心</span><span class="pointer">清空</span></div>
          <ul>
          <li class="pointer">[缴费提醒]您有1条企业缴费提醒</li>
          <li>[园区通知]您有2条私人订单</li>
        </ul>
        <div class="checkAll ct color1 pointer">查看全部</div>
        </el-card>
      </div> -->
      <!-- @mouseleave="show4=!show4" -->
      <div class="search_box" id="search_box" :class="{'searchbox':showFF}" @mouseleave="show4=!show4" >
        <el-collapse-transition>
          <div v-show="show4" style="width:100%">
            <div class="transition-box">
              <el-input placeholder="请输入内容" v-model="searchData">
                <template slot="append">
                  <el-button icon="el-icon-search">搜索 </el-button>
                </template>
              </el-input>
            </div>
          </div>
        </el-collapse-transition>
      </div>
    </div>

    <!--    主体内容开始-->
    <div
      :class="{'h-100': $store.state.isMobile}"
      style="position:relative;z-index: 0">
      <router-view></router-view>
    </div>

    <!--    主体内容结束-->
  </div>
</template>
<script>
  import swiper from "swiper";
  import userInfo from './common/userInfoData'
  export default {
     components: {
      userInfo
    },
    data() {
      return {
        luyouString:'portalIndex,enterpriseservice,investment,home,messageCenter',
        showMes:false,
        // sousuo: false,
        show1: false,
        show11: false,
        show22: false,
        show33: false,
        show2: false,
        show3: false,
        show4: false,
        searchData: "",
        showFF: false,
        activeNames: ['first'],
        sw:'fir',
        showBtn:false,
        // isLogin:false,
        // accoutInfo:''
      };
    },
    computed: {
      isCenter() {
        const list = 'portalIndex,enterpriseservice,investment,serMatHp,tfindex,actiCenter,incubatorEnterprises,compassView,declarationCenter,talentsService,academicExchange,policyCenter,recruitmentList,profileDetails';
        return this.$route.matched.some(item => {
          if(item.name){
            return list.indexOf(item.name) == -1
          }
        })
      }
    },
    methods: {
      showH(){
        this.show1 = true;
        // setTimeout(()=>{
        this.show11 = true;
        // },500)
      },
      showY(){
        this.show11 = false;
        // setTimeout(()=>{
        this.show1 = false;
        // },500)
      },
      handleChangeName(val) {
        console.log(val);
        if(val=='two'){
          this.sw='tw'
        } else if(val=='three'){
          this.sw='th'
        } else{
          this.sw='fir'
        }
      },
      onClick() {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
      }
    }
  };
</script>
<style lang="scss">
  @keyframes qfyfadeInLeft {
    0% {
      opacity: 0;
      transform: translateY(0);
    }
    100% {
      opacity: 1;
      transform: translateY(10%);
    }
  }
  .router-link {
    width: 100%;
    height: 100%;
    display: inline-block;
  }
  .portalIndex {
    .portalIndexImg {
      position: fixed;
      z-index: 99;
      width: 100%;
      // .header{
      //   background-color: #fff;
      //   #nav{
      //     color:#666;
      //   }
      // }
      .headerw {
        background: #fff;
        border-bottom:1px solid #eee;
        box-shadow:0 10px 10px -10px #ccc;
        color: #666;
        #nav,
        .headerRight {
          color: #666;
          // li {
          //   a {
          //     color: #666;
          //   }
          // }
          // li:nth-child(1) {
          //   background: none;
          //   border-radius: none;
          //   a {
          //     color: #00a041;
          //   }
          // }
          li:hover {
            background: none;
          }
          li:hover a{
            color:#00a041;
          }
        }
        .ru-active{
            color: #00a041;
          }
      }
      .search_box {
        background: rgba(0, 0, 0, 0.3);
        text-align: center;
        display: flex;
        justify-content: center;
        width:100%;
        .el-input-group {
          // position: relative;
          // left: 50%;
          // transform: translateX(-50%);
          border-radius: 28px;
          overflow: hidden;
          width: 50%;
          margin: 43px 0;
          .el-input {
            // width: 94px;
          }
          .el-input__inner:focus {
            border-color: #00a041;
          }
          .el-input-group__append,
          .el-input-group__prepend {
            border-radius: 28px;
          }
          .el-input-group__append {
            background: #00a041;
            color: #fff;
            right: 58px;
            .el-button {
              margin: -10px -10px;
            }
          }
          .el-input-group__prepend {
            border-top-right-radius: 0;
            border-bottom-right-radius: 0;
            background-color: #fff;
            padding: 0px 17px 0 9px;
            input {
              color: #666666;
              text-align: right;
            }
          }
        }
        .input-with-select .el-input__inner {
          border-top-left-radius: 19px;
          border-bottom-left-radius: 19px;
          border: 1px solid #00a041;
        }
      }
      .searchbox {
        background: #fff;
        box-shadow:0 10px 10px -10px #ccc;
      }
    }
  }
</style>


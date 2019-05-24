<template>
  <div class="userInfoData">
    <!-- <div class="headerRight fr"> -->
    <!-- <router-link to="/allMesList" class="search" v-if="isLogin">
              <i class="el-icon-bell" style="font-size:20px"></i>
            </router-link> -->
    <!-- <span v-if="isLogin" style="margin-right:10px">您好！{{accoutInfo}}</span>
            <div class="search pointer">
                <i class="el-icon-search" @click="show4=true" style="font-size:20px"></i>
            </div> -->
    <div class="navlogin">
      <router-link to="/parkNotice" class="" v-if="isLogin">
        <i class="el-icon-bell" style="font-size:20px" @mouseenter="showMes=!showMes"></i>
      </router-link>
      <a class="pointer" @click="$router.push({path:'/login'})" v-else>登录</a>
      <span class="line">|</span>
      <a class="pointer" @click="$router.push({path:'/register'})" v-if="!isLogin">注册</a>
      <div class="imgU" @click.stop="menuFlag=!menuFlag" v-else :class="{'active1':menuFlag}">
        <img v-if="userInfoData.avatar" :src="userInfoData.avatar" style="vertical-align: middle;">
        <img v-else src="@/../static/img/smaImg.png">
      </div>
    </div>

    <div class="avaMenu" v-if="menuFlag">
      <el-card class="box-card bxcard">
        <ul class="avaUL">
          <li style="border-bottom:1px solid #eee;">您好,{{accoutInfo}}</li>
          <!-- <li :class="{'liActi':$route.name == i.pathName}" v-for="(i,k) in dataLeft" :key="k" @click="dianji(i)">{{i.name}}</li> -->
          <!-- <li :class="{'liActi':$route.name == i.pathName}" v-for="(i,k) in dataTop" :key="k" @click="dianji(i)">{{i.name}}</li> -->
          <li style="border-top:1px solid #eee;" @click.stop="loginOut">退出</li>
        </ul>
      </el-card>
    </div>
    <div class="mesage11" v-if="showMes"  @mouseleave="showMes=!showMes">
        <el-card>
          <div class="firli"><span class="color1">消息中心</span><span class="pointer">清空</span></div>
          <ul>
          <li class="pointer">[缴费提醒]您有1条企业缴费提醒</li>
          <li>[园区通知]您有2条私人订单</li>
        </ul>
        <div class="checkAll ct color1 pointer">查看全部</div>
        </el-card>
      </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      isLogin: false,
      accoutInfo: "",
      menuFlag: false,
      showMes: false,
      userInfoData:{},
    };
  },
  created() {
    this.islogin();
  },
  methods: {
    islogin() {
      this.accoutInfo = sessionStorage.getItem("account");
      this.userInfoData=JSON.parse(sessionStorage.getItem("userInfo"))
      if (this.accoutInfo) {
        this.isLogin = true;
      }
    },
    loginOut() {
      window.sessionStorage.removeItem("token");
      window.sessionStorage.removeItem("userInfo");
      window.sessionStorage.removeItem("accout");
      this.$router.push({ path: "/login" });
    },
  }
};
</script>

<style lang="scss">
.userInfoData {
  float: right;
  .headerRight {
    li:hover {
      background: none;
    }
    li:hover a {
      color: #00a041;
    }
  }
  .imgU {
    display: inline-block;
    height: 65px;
    width: 65px;
    text-align: center;
    img {
      width: 34px;
      height: 34px;
      border-radius: 50%;
    }
  }
  .imgU.active1 {
    background: #00a040;
  }
  .mesage11 {
    position: absolute;
    right: 60%;
    width: 200px;
    color: #999;
    font-size: 12px;
    line-height: 1px;
    .el-card__body {
      padding: 0;
    }
    .el-card {
      color: #999;
    }
    .firli {
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 15px 20px;
      border-bottom: 1px solid #eee;
    }
    .checkAll {
      padding: 15px 20px;
    }
    li {
      padding: 15px 20px;
      border-bottom: 1px solid #eee;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
  }
  .avaMenu {
    position: absolute;
    box-shadow: 2px 2px 5px #eee;
    background: #fff;
    z-index: 4;
    margin-left: -21px;
    // left: 5px;
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
         line-height: 30px;
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
</style>

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

      <template v-if="!isLogin">
        <a class="pointer" @click="goLogin">登录</a>
        <span class="line">|</span>
        <a class="pointer" @click="$router.push({path:'/register'})">注册</a>
      </template>

      <template v-else>
        <a @click="$router.push('/parkNotice')" @mouseenter="showMes=!showMes,menuFlag=false" @mouseleave="showMes=!showMes">
          <i class="el-icon-bell"></i>
          <div class="mesage11" v-if="showMes">
            <el-card>
              <div class="firli">
                <span class="color1 pointer" @click="$router.push({path:'/parkNotice'})">消息中心</span>
                <span class="pointer" @click="showMesFlag=false">清空</span>
              </div>
              <ul v-if="showMesFlag">
                <li class="pointer" :class="{'act':colorFlag==i.id}" v-for="(i,k) in allList" :key="k" @click.stop="goRoute(i)" v-if="k<4" @mouseover="colorFlag=i.id">[{{i.messageTowSortName}}]{{i.messageTitle}}</li>
                <!-- <li>[园区通知]您有2条私人订单</li> -->
              </ul>
              <div class="checkAll ct color1 pointer">查看全部</div>
            </el-card>
          </div>
        </a>
        <div class="imgU" @mouseenter.stop="menuFlag=!menuFlag,showMes=false">
          <img v-if="userInfoData.avatar" :src="userInfoData.avatar" style="vertical-align: middle;">
          <img v-else src="@/../static/img/smaImg.png">
        </div>
      </template>

    </div>

    <div class="avaMenu" v-if="menuFlag" @mouseleave="menuFlag=!menuFlag">
      <el-card class="box-card bxcard">
        <ul class="avaUL">
          <li style="border-bottom:1px solid #eee;color:#333" @click="$router.push({path:'/home'})">您好,{{accoutInfo}}</li>
          <!-- <li class="homeLi" v-for="(i,k) in list" :key="k" :class="{'act':bgFlag==i.name}" @click="$router.push({path:i.path})">{{i.name}}</li> -->
          <!-- <li class="homeLi" @click="$router.push({path:'/home'})">首页</li> -->
          <!-- <li class="homeLi" @click="$router.push({path:'/userHome'})">用户资料</li>
          <li class="homeLi" @click="$router.push({path:'home/myBusiness/index'})">我的企业</li>
          <li class="homeLi" @click="$router.push({path:'/myBody/index'})">我的机构</li>
          <li class="homeLi" @click="$router.push({path:'/roleCertifications/investorCertification'})">角色认证</li>
          <li class="homeLi" @click="$router.push({path:'/upgradeStaff'})">加入园区</li>
          <li>...</li> -->
          <li style="border-top:1px solid #eee;" @click="loginOut">退出</li>
        </ul>
      </el-card>
    </div>

  </div>
</template>
<script>
import bus from "@/util/bus";
import { removeToken } from '@/util/auth'
export default {
  data() {
    return {
      colorFlag:'',
      showMesFlag:true,
      isLogin: false,
      accoutInfo: "",
      menuFlag: false,
      showMes: false,
      userInfoData: "",
      list:[
        {name:'首页',path:'/home'},
        {name:'用户资料',path:'/home'},
        {name:'我的企业',path:'home/myBusiness/index'},
        {name:'我的机构',path:'/myBody/index'},
        {name:'角色认证',path:'/roleCertifications/investorCertification'},
        {name:'加入园区',path:'/upgradeStaff'},
      ],
      allList:[],
    };
  },
  created() {
    this.islogin();
    this.findAllApp()
    let _this = this;
    bus.$on("closeKnow", msg => {
      _this.menuFlag = false;
    });
    bus.$on("upUserData", msg => {
      _this.upUserdata();
    });
    
  },
  methods: {
    goRoute(i){
      this.$router.push(this.routePath(i.messageTowSortName))
    },
    routePath(p){
      switch(p){
        case '园区通知':
          return '/parkNotice'
        break;
        case '企业邀请':
          return '/corporateInvitation'
        break;
        case '机构邀请':
          return '/institutionInvitation'
        break;
        case '企业订单':
          return '/enterpriseOrder'
        break;
        case '信息发布动态':
          return '/informationDynamics'
        break;
        case '缴费提醒':
          return '/paymentReminder'
        break;
        case '访客留言':
          return '/guestbook'
        break;
        case '数据上报提醒':
          return '/dataReminder'
        break;
      }
    },
    islogin() {
      this.accoutInfo = sessionStorage.getItem("account");
      this.userInfoData = JSON.parse(sessionStorage.getItem("userInfo"));
      if (this.userInfoData) {
        this.isLogin = true;
      } else {
        this.isLogin = false;
      }
    },
    loginOut() {
      removeToken();
      window.sessionStorage.removeItem("userInfo");
      window.sessionStorage.removeItem("account");
      this.$router.push({ path: "/" });
      this.islogin();
    },
    goLogin() {
      window.sessionStorage.setItem("PresetRoute", this.$route.fullPath);
      this.$router.push({ path: "/login" });
    },
    //获取消息
     findAllApp() {
       if(!this.userInfoData){
         return
       }
      this.api.get({
        url: "findAllApp",
        data: {
          isRead:0
        },
        callback: (res) =>{
          if (res.code == "0000") {
            this.allList=res.data
          } else {
            // this.$message.error(res.result);
          }
        }
      });
    },
    upUserdata(){
      let _this = this;
       _this.api.get({
          url: "getUserExtension",
          data: {
            // account: sessionStorage.account
          },
          dataFlag: false,
          callback: function(res) {
            if (res.code === "0000") {
              _this.userInfoData = res.data;
              sessionStorage.setItem('userInfo', JSON.stringify(res.data));
            } else {
              _this.$message.error(res.result);
            }
          }
        });
    }
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
      width: 23px;
      height: 23px;
      border-radius: 50%;
      cursor: pointer;
    }
  }
  .imgU.active1 {
    background: #00a040;
  }
  .mesage11 {
    position: absolute;
    right: 50%;
    top: 65px;
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
    li.act{
      background: #00a041 !important;
      color:#fff;
    }
  }
  .avaMenu {
    position: absolute;
    // box-shadow: 2px 2px 5px #eee;
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
    .homeLi{
      color:#999;
    }
    .homeLi:hover{
      background: #00a041 !important;
      color:#fff;
    }
    .bxcard .el-card__body {
      padding: 0;
    }
  }
  .navlogin {
    .el-icon-bell {
      font-size: 20px;
      display: inline-block;
      width: 40px;
      text-align: center;
      height: 100%;
    }
  }
}
</style>

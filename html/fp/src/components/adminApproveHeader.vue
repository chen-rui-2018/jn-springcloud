<template>
<div :class="{'Header_box':$route.name=='rightDetail'||$route.name=='serviceDetail'||$route.name=='declarationNoticeDetail'||$route.name=='declarationPlatform'||$route.name=='talentPlatform'||$route.name=='talentsServiceDetail'}">
  <div class="approveHead" @mouseleave="searchLeave">
    <div class="headContent" ref="headContent">
        <div class="bannerNav" :class="{'bannerNavAct':isActClass===true||$route.name=='rightDetail'||$route.name=='serviceDetail'||$route.name=='declarationNoticeDetail'||$route.name=='declarationPlatform'||$route.name=='talentPlatform'||$route.name=='talentsServiceDetail'}">
            <div class="w clearfix type_page">
                <div class="titleImg ">
                  <div>
                    <img src="@/../static/img/login-logo.png" alt="" class="pointer" @click="$router.push({path:'/'})" v-if="isActClass===true||$route.name=='rightDetail'||$route.name=='serviceDetail'||$route.name=='declarationNoticeDetail'||$route.name=='declarationPlatform'||$route.name=='talentPlatform'||$route.name=='talentsServiceDetail'">
                    <img src="@/../static/img/LOGO1.png" alt="" class="pointer" @click="$router.push({path:'/'})" v-else>
                  </div>
                </div>
                <div class="bannerUl">
                  <li class="active_header" :class="{'liActiv':isActClass===true}" >首页</li>
                    <li @click='$router.push({path:"/serverOrg"})'> 服务机构</li>
                    <li @click='$router.push({path:"/serverPro"})'>服务产品</li>
                    <li @click='$router.push({path:"/serverCon"})'>服务顾问</li>
                    <li @click='$router.push({path:"/actiTrain"})'>活动培训</li>
                    <li @click='$router.push({path:"/aboutUs"})'>关于我们</li>
                </div>
                <div class="headerRight">
                  <div class="search" >
                    <i class="el-icon-search" style="font-size:20px" @click="show3=true"></i>
                  </div>
                  <user-info></user-info>
                  <!-- <div class="navlogin">
                    <a href="/login">登录</a>
                    <span class="line">|</span>
                    <a href="javascript:;"> 注册</a>
                  </div>
                  <div class="navlogin">
                    <i class="el-icon-bell"></i>
                    <span class="line">|</span>
                  </div> -->
                </div>
            </div>
        </div>
    </div>
    <!-- 搜索框  ,'search_box_margin':show3-->
    <div class="search_box" :class="{'search_box_act':isActClass===true}">
      <el-collapse-transition>
          <div v-if="show3">
            <div class="transition-box">
              <el-input placeholder="请输入内容" v-model="searchData" class="input-with-select">
                <el-select v-model="select" slot="prepend" placeholder="产品" @visible-change="changeselectShow">
                  <el-option label="机构" value="1"></el-option>
                  <el-option label="产品" value="2"></el-option>
                  <el-option label="顾问" value="3"></el-option>
                  <el-option label="活动" value="3"></el-option>
                </el-select>
                <el-button slot="append" icon="el-icon-search">搜索 </el-button>
              </el-input>
            </div>
          </div>
      </el-collapse-transition>
    </div>
  </div>
</div>
</template>
<script>
import userInfo from '../views/common/userInfoData'
export default {
  components: {
      userInfo
    },
  data() {
    return {
      offsetTop:0,
      isActClass:false,
      isNavShow:true,
      show3:false,
      searchData:'',
      select:'',
      sekectShow:false,
    };
  },
  mounted () {
    window.addEventListener('scroll', this.handleScroll)    
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
  },
  methods: {
     changeselectShow(val){
      this.sekectShow=val
    },
    searchLeave() {
      if (this.sekectShow) {
        this.show3 = true
      } else {
        this.show3 = false
      }
    },
    handleScroll(){
      const osTop =
      window.pageYOffset ||
        document.documentElement.scrollTop || document.body.scrollTop;
      for (const key in this.$refs) {
        const top = this.getElementLeft(this.$refs[key]);
        if (osTop + innerHeight + 300 >= top + 100) {
          const name = this.$refs[key].dataset.class;
          this.$refs[key].classList.add(name);
        }
      }
      if (osTop>this.$refs.headContent.offsetHeight) {
      this.isActClass=true
      }else{
        this.isActClass=false
      }
    },
    getElementLeft(element) {
      var top = element.offsetTop;
      var curEle = element.offsetParent;
      while (curEle !== null) {
        top += curEle.offsetTop;
        curEle = curEle.offsetParent;
      }
      return top;
    }
  }
};
</script>

<style lang="scss">
.Header_box{
  padding-bottom: 67px;
}
.banner_box{
    width: 100%;
    position: absolute;
    top: 0;
  }
.approveHead{
  position: fixed;
  width: 100%;
  z-index: 100;
  .headContent {
    .bannerNav {
      width: 100%;
      color: #fff;
      background: rgba(255,255,225,0.1);
      .type_page{
        display: flex;
        justify-content: space-between;
        align-items: center;
        width: 84%;
      }
      .title{
        font-size: 25px;
        margin-left: 20px;
      }
      .titleImg {
        display: flex;
            width: 22%;
        div:nth-child(1){
          width: 50%;
        }
        img {
          width: 100%;
          height: 100%;
          vertical-align: middle;
        }
      }
      .bannerUl {
        list-style: none;
        line-height: 64px;
        font-size: 13px;
        display: flex;
        margin: 0 7%;
        flex: 1;
        justify-content: space-around;
        text-align: center;
          li {
          width: 16%;
          cursor: pointer;
          border-radius: 5px;
        }
        .active_header{
          background: #fff;
          color:#00a041;
        }
        .liActiv{
        }
      }
      .headerRight {
        font-size: 12px;
        display: flex;
        line-height: 65px;
        .search {
          display: inline-block;
          margin-right: 20px;
          vertical-align: middle;
          i {
            width: 20px;
            height: 20px;
          }
        }
        .navlogin {
          .line {
            display: inline-block;
            height: 12px;
            margin: 0 15px;
          }
        }
      }
    }
    .bannerNavAct{
      background-color: #fff;
      color: black;
      border-bottom: 1px solid #eee;
      box-shadow:0 10px 10px -10px #ccc;
    }
  }
  .search_box_margin{
  height: 121px;
}
.search_box{
  background: rgba(0, 0, 0,0.3);
  text-align: center;
  .el-input-group{
    border-radius: 28px;
    width:42%;
    margin:43px 0;
    .el-input{
      width:94px;
    }
    .el-input__inner:focus{
      border-color: #00a041;  
    }
    .el-input-group__append, .el-input-group__prepend{
      border-radius: 28px;
    }
    .el-input-group__append{
      background: #00a041;
      color:#fff;
      right: 58px;
      .el-button{
        margin: -10px -10px;
      }
    }
    .el-input-group__prepend{
      border-top-right-radius: 0; 
      border-bottom-right-radius: 0;
      background-color: #fff;
      padding: 0px 17px 0 9px;
      
      input{
        color:#666666;
        text-align: right;
        border-right: none;
        &:focus{
          border-left: none;
        }
      }
    }
  }
}
.search_box_act{
  background:#fff;
  box-shadow:0 10px 10px -10px #ccc;
}
  // 侧边栏
  .fadeInDown{
    animation-duration: 1s;
  }
  .fadeOutUp{
    animation-duration: 0.5s;
  }
  .nav{
    // animation: fadeInDown 3s ;
    position: absolute;
    left: 13%;
    width: 12%;
    margin-top: 14px;
    font-size: 13px;
    // border:1px solid black;
    .nav_cont{
      display: flex;
      flex-wrap: wrap;
      // a{
      // }
      .nav_cont_son {
        display: none;
        color:#fff;
        background: rgba(0, 0, 0,0.3);
        padding:20px 20px;
        cursor: pointer;
        span{
            display: inline-block;
            width: 5px;
            height: 5px;
            border-radius: 50%;
            background-color: #fff;
            margin-right: 8px;
          }
        div:hover{
          color:#00a041;
        }
        div:hover span{
          background-color: #00a041;
        }
      }
     
      &:hover .nav_cont_son {
        display: flex;
        flex-wrap: wrap;
        position: absolute;
        right: -366px;
        background: rgba(0, 0, 0,0.3);
        width: 326px;
        div{
          width: 50%;
          line-height: 40px;
        }
      }
      &:hover .hidder_son{
        display: none;
      }
      &:hover .nav_cont_father{
        background-color: #fff;
        color:#00a041;
      }
      .nav_cont_father{
        background: rgba(0, 0, 0,0.3);
        // position: relative;
        width: 100%;
        color:#fff;
        padding:20px 20px 20px 28px;
        display: flex;
        justify-content: space-between;
        cursor: pointer;
      }
    }
  }
  
}

</style>

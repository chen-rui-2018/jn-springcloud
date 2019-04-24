<template>
  <div class="appHead">
    <el-card class="box-card">
      <!-- <div id="header" :class="{'headerBg':this.$route.name=='actiCenter'}" v-if="headFlag"> -->
      <!-- <div id="header" v-if="headFlag">
        <div class="headerContainer clearfix">
          <div class="titleImg fl"><img src="@/../static/img/LOGO.png" alt=""></div>
          <div class="menu" style="display:none">
            <i class="el-icon-close"></i>
            <input type="text">
            <i class="el-icon-search"></i>
          </div>
          <div class="headerRight fr">
            <div class="search" v-if="!sousuo">
              <i class="el-icon-search" @click="handleChange" style="font-size:20px"></i>
            </div>
            <div class="navlogin" v-if="this.$route.name!=='actiManagent'">
              <a>登录</a>
              <span class="line">|</span>
              <a>注册</a>
            </div>
            <div class="navlogin" v-if="this.$route.name =='actiManagent'">
              <i class="el-icon-bell"></i>
              <span class="line">|</span>
              <img src="" alt="">
            </div>
          </div>
          <div class="nav" v-if="this.$route.name=='actiCenter'||this.$route.name=='actiDetail'||this.$route.name=='regData'||this.$route.name=='regStatus'||this.$route.name=='actiManagent'">
            <transition name="fade">
              <div class="sousuo posA" v-if="sousuo">
                <i class="el-icon-close" style="vertical-align: middle;" @click="sousuo=false"></i>
                <input type="text" v-focus @keyup.enter="handleSearch">
                <i class="el-icon-search" style="vertical-align: middle;" @click="sousuo=false"></i>
              </div>
              <ul class="posA clearfix" v-else>
                <li>
                  <a href="javascript:void(0);">首页</a>
                </li>
                <li>
                  <a href="javascript:void(0);">招商引资</a>
                </li>
                <li>
                  <a href="javascript:void(0);">智慧党建</a>
                </li>
                <li>
                  <a href="javascript:void(0);">企业服务</a>
                </li>
              </ul>
            </transition>
          </div>
        </div>
      </div> -->
      <div id="headerActi">
        <div class="headerContainer clearfix">
          <div class="titleImg fl"><img src="@/../static/img/login-logo.png" alt=""></div>
          <div class="menu" style="display:none">
            <i class="el-icon-close"></i>
            <input type="text">
            <i class="el-icon-search"></i>
          </div>
          <div class="headerRight fr">
            <div class="search" v-if="!sousuo">
              <i class="el-icon-search" @click="handleChange" style="font-size:20px"></i>
            </div>
            <div class="navlogin" v-if="this.$route.name!=='actiManagent'">
              <a>登录</a>
              <span class="line">|</span>
              <a>注册</a>
            </div>
            <div class="navlogin" v-if="this.$route.name =='actiManagent'">
              <i class="el-icon-bell"></i>
              <span class="line">|</span>
              <img src="" alt="">
            </div>
          </div>
          <div class="nav" v-if="this.$route.name=='actiCenter'||this.$route.name=='actiDetail'||this.$route.name=='regData'||this.$route.name=='regStatus'||this.$route.name=='actiManagent'">
            <transition name="fade">
              <div class="sousuo posA" v-if="sousuo">
                <i class="el-icon-close" style="vertical-align: middle;" @click="sousuo=false"></i>
                <input type="text" v-focus @keyup.enter="handleSearch">
                <i class="el-icon-search" style="vertical-align: middle;" @click="sousuo=false"></i>
              </div>
              <ul class="posA clearfix" v-else>
                <li>
                  <a href="javascript:void(0);">首页</a>
                </li>
                <li>
                  <a href="javascript:void(0);">招商引资</a>
                </li>
                <li>
                  <a href="javascript:void(0);">智慧党建</a>
                </li>
                <li>
                  <a href="javascript:void(0);">企业服务</a>
                </li>
              </ul>

            </transition>
          </div>
        </div>
      </div>
    </el-card>
  </div>

</template>

<script>
export default {
  data() {
    return {
      sousuo: false,
    };
  },
  methods: {
    handleChange() {
      this.sousuo = true;
    }
  }
};
</script>

<style lang="scss">
.appHead {
  .el-card__body {
    padding: 0;
  }
}
.headerBg {
  background-color: rgba(0, 0, 0, 0.3);
}

#headerActi {
  position: relative;
  background-color: #fff;
  padding: 0 160px;
  // box-shadow: 2px 2px 2px #ccc;
  .headerContainer {
    // position: relative;
    width: 100%;
    height: 65px;
    line-height: 65px;
    color: #666;
    font-weight: bold;
    font-size: 16px;
    box-sizing: border-box;
    // background-color: #757381;
    .titleImg {
      // width: 218px;
      // height: 54px;
      // margin-left:160px;
      width: 155px;
      height: 38px;
      img {
        width: 100%;
        height: 100%;
        vertical-align: middle;
      }
    }
    .nav {
      width: 600px;
      height: 37.6px;
      margin: 0 auto;
      > ul {
        overflow: hidden;
        li {
          float: left;
          // color: #ccc;
          font-size: 13px;
          text-align: center;
          // line-height: 52px;
          margin: 0 50px;
        }
      }
      // .sousuo {
      //   // width: 300px;
      //   height: 30px;
      //   line-height: 30px;
      //   font-size: 16px;
      //   margin-left: 150px;
      //   > input {
      //     width: 320px;
      //     height: 30px;
      //     border: none;
      //     outline: none;
      //   }
      // }
      .posA {
        position: absolute;
        left: 50%;
        transform: translateX(-50%);
        // padding: 20px 0;
      }
      .sousuo {
        font-size: 18px;
        line-height: 48px;
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
        display: inline-block;
        font-size: 13px;
        a {
          display: inline-block;
        }
        .line {
          display: inline-block;
          height: 12px;
          margin: 0 15px;
        }
        > img {
          width: 50px;
          height: 50px;
          border-radius: 50%;
        }
      }
    }
  }
}
</style>

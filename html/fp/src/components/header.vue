<template>
  <div class="apphead">
    <div class="box-card">
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
          <div class="titleImg fl"><img src="@/../static/img/login-logo.png" alt="" class="pointer" @click="$router.push({path:'/'})"></div>
          <div class="menu" style="display:none">
            <i class="el-icon-close"></i>
            <input type="text">
            <i class="el-icon-search"></i>
          </div>
          <div class="headerRight fr">
            <div class="search">
              <i class="el-icon-search" @click="show4=true" style="font-size:20px"></i>
            </div>
            <div class="navlogin" v-if="this.$route.name!=='actiManagent'">
              <a>登录</a>
              <span class="line">|</span>
              <a>注册</a>
            </div>
            <!-- <div class="navlogin" v-if="this.$route.name =='actiManagent'">
              <i class="el-icon-bell"></i>
              <span class="line">|</span>
              <img src="" alt="">
            </div> -->
          </div>
          <div class="nav" v-if="this.$route.name=='actiCenter'||this.$route.name=='actiDetail'||this.$route.name=='regData'||this.$route.name=='regStatus'||this.$route.name=='actiManagent'">
            <!-- <transition name="fade">
              <div class="sousuo posA" v-if="sousuo">
                <i class="el-icon-close" style="vertical-align: middle;" @click="sousuo=false"></i>
                <input type="text" v-focus @keyup.enter="handleSearch">
                <i class="el-icon-search" style="vertical-align: middle;" @click="sousuo=false"></i>
              </div> -->
              <ul class="posA clearfix">
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

            <!-- </transition> -->
          </div>
        </div>
      </div>
    </div>
    <div class="search_box" id="search_box" @mouseleave="show4=!show4">
      <el-collapse-transition>
        <div v-show="show4">
          <div class="transition-box">
            <el-input placeholder="请输入内容" v-model="searchData" class="input-with-select">
              <el-button slot="append" icon="el-icon-search">搜索 </el-button>
            </el-input>
          </div>
        </div>
      </el-collapse-transition>
    </div>
  </div>

</template>

<script>
export default {
  data() {
    return {
      sousuo: false,
      show4:false,
      searchData:'',
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
.apphead {
   z-index: 9;
  width: 100%;
  position: fixed;
   .search_box {
      // background: rgba(0, 0, 0, 0.3);
      width: 100%;
       background: #fff;
       box-shadow:0 10px 10px -10px #ccc;
      .el-input-group {
        border-radius: 28px;
        width: 42%;
        margin: 43px 0;
        position: relative;
        transform: translateX(-50%);
        left: 50%;
        .el-input {
          width: 94px;
        }
        .el-input__inner:focus {
          border-color: #00a041;
        }
        .el-input-group__append,
        .el-input-group__prepend {
          border-radius: 28px;
        }
        .el-input-group__append {
          /* border-top-left-radius: 0;
        border-bottom-left-radius: 0; */
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
}
.headerBg {
  background-color: rgba(0, 0, 0, 0.3);
}

#headerActi {
  // position: relative;
  background-color: #fff;
  border-bottom: 1px solid #eee;
  box-shadow: 0 10px 10px -10px #ccc;
  .headerContainer {
    // position: relative;
    padding: 0 160px;
    width: 100%;
    height: 65px;
    line-height: 65px;
    color: #666;
    // font-weight: bold;
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

<template>
  <div id="header">
    <div class="headerContainer clearfix">
      <div class="titleImg"><img src="@/../static/img/LOGO.png" alt=""></div>
      <div class="menu" style="display:none">
        <i class="el-icon-close"></i>
        <input type="text">
        <i class="el-icon-search"></i>
      </div>
      <div class="nav" v-if="this.$route.name=='actiCenter'||this.$route.name=='actiDetail'||this.$route.name=='regData'||this.$route.name=='regStatus'||this.$route.name=='actiManagent'">
        <ul v-if="this.status">
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
        <div class="sousuo" v-if="!this.status">
          <i class="el-icon-close" style="margin-right:8px;font-size:20px" @click="handClose"></i>
          <input type="text">
          <i class="el-icon-search" style="margin-left:8px;font-size:20px" @click="handClose"></i>
        </div>
      </div>
      <!-- <div class="nav" v-if="this.$route.name=='peoDec'">
        <ul v-if="this.status">
          <li>
            <a href="javascript:void(0);">首页</a>
          </li>
          <li>
            <a href="javascript:void(0);">申报平台</a>
          </li>
          <li>
            <a href="javascript:void(0);">常年申报</a>
          </li>
        </ul>
        <div class="sousuo" v-if="!this.status">
          <i class="el-icon-close" style="margin-right:8px;font-size:20px" @click="handClose"></i>
          <input type="text">
          <i class="el-icon-search" style="margin-left:8px;font-size:20px" @click="handClose"></i>
        </div>
      </div> -->
      <div class="headerRight">
        <div class="search" v-if="this.status">
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
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      status: true
    };
  },
  methods: {
    handleChange() {
      this.status = false;
    },
    handClose(){
      this.status=true
    }
  }
};
</script>

<style lang="scss" scoped>
#header {
  position: relative;
  background-color: rgba(0, 0, 0, 0.3);
  padding: 0 160px;
  .headerContainer {
    // position: relative;
    width: 100%;
    height: 91px;
    line-height: 91px;
    color: #fff;
    font-weight: bold;
    font-size: 16px;
    box-sizing: border-box;
    // background-color: #757381;
    .titleImg {
      float: left;
      width: 218px;
      height: 54px;
      // margin-left:160px;
      img {
        width: 100%;
        height: 100%;
        vertical-align: middle;
      }
    }
    .nav {
      display: inline-block;
      // width: 500px;
      // margin:0 auto;
      > ul {
        overflow: hidden;
        li {
          float: left;
          margin: 0 30px;
        }
      }
      .sousuo {
        // width: 300px;
        height: 30px;
        line-height: 30px;
        font-size: 16px;
        margin-left: 150px;
        > input {
          width: 320px;
          height: 30px;
          border: none;
          outline: none;
        }
      }
    }
    .headerRight {
      float: right;
      // margin-right:160px;
      .search {
        display: inline-block;
        margin-right: 20px;
        i {
          width: 26px;
          height: 25px;
        }
      }
      .navlogin {
        display: inline-block;
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

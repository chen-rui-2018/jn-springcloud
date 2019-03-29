<template>
  <div class="userHome" @click="menuFlag = false">
    <div class="header clearfix">
      <div class="titleImg fl"><img src="@/../static/img/login-logo.png" alt=""></div>
      <div class="headerRight fr pr">
        <i class="el-icon-search" v-if="!sousuo" @click="handleChange" style="vertical-align: middle;font-size:18px;color:#666;"></i>
        <i class="el-icon-bell" style="vertical-align: middle;margin-left:20px;font-size:18px;color:#666;"></i>
        <span class="line" style="vertical-align: middle;"></span>
        <img src="@/../static/img/smaImg.png" style="vertical-align: middle;padding:20px" :class="{'active':menuFlag}" alt="" @click.stop="menuFlag=!menuFlag">
        <div class="avaMenu" v-if="menuFlag">
          <el-card class="box-card bxcard">
            <ul>
              <li style="border-bottom:1px solid #eee;">您好，{{this.$route.query.account}}</li>
              <li :class="{'liActi':$route.name == i.pathName}" v-for="(i,k) in dataLeft" :key="k" @click="dianji(i)">{{i.name}}</li>
              <li style="border-top:1px solid #eee;" @click="loginOut">退出</li>
            </ul>
          </el-card>
        </div>
      </div>

      <div class="nav">
        <transition name="fade">
          <div class="sousuo posA" v-if="sousuo">
            <i class="el-icon-close" style="vertical-align: middle;" @click="sousuo=false"></i>
            <input type="text">
            <i class="el-icon-search" style="vertical-align: middle;" @click="sousuo=false"></i>
          </div>

          <ul class="clearfix posA" v-else>
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
        <iframe id="kskfpt" ref="iframe" src="" width="0" height="0" frameborder="0" scrolling="auto" style="visibility: hidden;"/>
      </div>
    </div>
    <div class="userContent">
      <div class="honcontent w">
        <div class="bread">
          <span style="color:#666">用户中心</span>
          <span>/</span>
          <span style="color:#009f41" v-for="(i,k) in dataLeft" :key='k' v-if="$route.name == i.pathName">{{i.name}}</span>
          <!-- <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: i.path }" v-for="(i,k) in dataLeft" :key='k'>{{i.name}}</el-breadcrumb-item>
            <el-breadcrumb-item></el-breadcrumb-item>
          </el-breadcrumb> -->
        </div>
        <div class="userContent">
          <!-- <div class="navList"></div>
          <div class="navContent"></div> -->
          <el-container>
            <el-aside style="width:150px">
              <ul>
                <li :class="{'lick':$route.name == i.pathName}" v-for="(i,k) in dataLeft" :key='k' @mouseenter='i.flag=true' @mouseleave='i.flag=false' @click="liCk(i)">
                  <span class="line" v-if="i.flag || $route.name == i.pathName"></span>
                  <span>{{i.name}}</span>
                </li>
              </ul>
            </el-aside>
            <router-view/>
          </el-container>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import $ from 'jquery'
export default {
  data() {
    return {
      sousuo: false,
      menuFlag: false,
      dataLeft: [
        {
          name: "用户资料",
          flag: false,
          path: "/user/userHome",
          pathName: "userHome",
          id: 0
        },
        {
          name: "人才申报",
          flag: false,
          path: "/user/userData",
          pathName: "userData",
          id: 1
        }
      ]
    };
  },
  mounted() {
    // 预先登录模式
    $('#kskfpt').attr('src', `http://112.94.22.222:2381/noPasswordLogin.htm?username=${this.$route.query.account}&password=123`)
  },
  methods: {
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
    liCk(i) {
      if (this.$route.name == i.pathName) {
        return;
      }
      this.$router.push(`${i.path}?account=${this.$route.query.account}`);
    },
    handleChange() {
      this.sousuo = true;
    }
    // getUserExtension() {
    //   this.api.post({
    //     url: "loginURLgetUserExtension",
    //     data: {},
    //     callback: function(res) {
    //       if (res.code == "0000") {
    //         console.log(res);
    //       } else {
    //         _this.$message.error(res.result);
    //       }
    //     }
    //   });
    // },
  }
};
</script>
<style lang="scss">
</style>

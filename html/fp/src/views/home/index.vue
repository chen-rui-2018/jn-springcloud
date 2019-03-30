<template>
  <div class="userHome" @click="menuFlag = false">
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
          /
          <span style="color:#009f41">{{titleName}}</span>
          <!-- <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: i.path }" v-for="(i,k) in dataLeft" :key='k'>{{i.name}}</el-breadcrumb-item>
            <el-breadcrumb-item></el-breadcrumb-item>
          </el-breadcrumb> -->
        </div>
        <div class="userCon">
          <!-- <div class="navList"></div>
          <div class="navContent"></div> -->
          <el-container>
            <el-aside style="width:150px">
              <ul class="yijiUl">
                <li :class="{'lick':showNum == i.id,'lihover':i.flag&&!i.hasChildren}" v-for="(i,k) in dataLeft" :key='k' @mouseenter='i.flag=true' @mouseleave='i.flag=false' @click="liCk(i)">
                  <span class="line" v-if="showNum == i.id"></span>
                  <!-- <span class="line" v-if="i.flag || $route.name == i.pathName"></span> -->
                  <span>{{i.name}}</span>
                  <i class="el-icon-arrow-down" v-if="i.hasChildren&&i.childrenShow==false" style="margin-left:25px"></i>
                  <i class="el-icon-arrow-up" v-if="i.hasChildren&&i.childrenShow==true" style="margin-left:25px"></i>
                  <ul class="zhedieUl" v-if="i.childrenShow">
                    <li :class="{'lick':showNum == item.id,'lihover':item.flag}" v-for="item in i.children" :key="item.id" @mouseenter='item.flag=true' @mouseleave='item.flag=false' @click.stop="ifs(item)">
                      <span class="line" v-if="showNum == item.id"></span>
                      <span>{{item.name}}</span>
                    </li>
                  </ul>
                </li>
              </ul>
            </el-aside>
            <user-home v-if="showNum == 0" :userData='userData'></user-home>
            <el-container v-if="iframeShow" style="background:#fff;">
              <iframe id="live" :src="iframePath" onload="this.height=this.contentWindow.document.body.scrollHeight" width="100%" frameborder="0"></iframe>
              <!-- <iframe id="live" :src="iframePath" width="100%" height="100%" scrolling="no" frameborder="0" onload="setIframeHeight(this)"></iframe> -->
            </el-container>
            <!-- <router-view :userData='userData' /> -->
          </el-container>
        </div>
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
      zhedieFlag:false,
      imgUrl: "",
      titleName:'用户资料',
      userData: {
        avatar:''
      },
      showNum:0,
      iframeShow:false,
      iframePath:'',
      dataTop:[
        {
          name: "用户资料",
          flag: false,
          path:'/user',
          pathName: "user",
          id: 0,
        }
      ],
      dataLeft: [
        {
          name: "用户资料",
          flag: false,
          hasChildren:false,
          path: "@/../components/userHome",
          pathName: "userHome",
          id: 0,
          childrenShow:false,
        },
        {
          name: "人才申报",
          flag: false,
          // path: "@/../components/userHome",
          // path: "/user/userData",
          hasChildren:true,
          pathName: "userData",
          id: 1,
          childrenShow:false,
          children: [
            {
              name: "待办事务处理",
              flag: false,
              path: "http://112.94.22.222:2381/platform/office/bpmReceivedProcess/pending.htm",
              id: 10,
            },
            {
              name: "发起人才申报",
              flag: false,
              path: "http://112.94.22.222:2381/platform/bpmn/instance/bpmInst/toStart.htm?defId=559018228462911488&proInstId=",
              id: 11,
            },
            {
              name: "我发起的流程",
              flag: false,
              path: "http://112.94.22.222:2381/platform/office/bpmInitiatedProcess/myRequest.htm",
              id: 12,
            }
          ]
        }
      ]
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
    // 预先登录模式
    $('#kskfpt').attr('src', `http://112.94.22.222:2381/noPasswordLogin.htm?username=${this.$route.query.account}&password=123`)
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
    ifs(i){
      this.iframeShow = true;
      this.titleName = i.name;
      this.showNum = i.id;
      if(i.id ===11){
        //window.open(i.path, '_blank');
        window.open (i.path, 'newwindow', 'height=600, width=1000, top=50, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no')
      }else {
        this.iframePath = i.path;
      }
    },
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
    liCk(i) {
      if (i.id == this.showNum) {
        return;
      }
      if(i.hasChildren){
        i.childrenShow = !i.childrenShow
        return
      }
      this.iframeShow = false;
      this.titleName = i.name;
      this.showNum = i.id
      // this.$router.push(`${i.path}?account=${this.$route.query.account}`);
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
    }
  }
};
</script>
<style lang="scss">
</style>

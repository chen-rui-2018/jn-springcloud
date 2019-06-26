<template>
  <div class="humanSource">
    <!-- <div class="techHeah">
      <div id="header" class="header" :class="{'headerw':showFF}">
        <div class="headerContainer clearfix">
          <div class="titleImg fl">
            <img class="pointer" src="@/../static/img/LOGO.png" v-if="!showFF" @click="$router.push({path:'/'})" alt="">
            <img src="@/../static/img/login-logo.png" v-else class="pointer" alt="" @click="$router.push({path:'/'})">
          </div>
          <div class="headerRight fr">
            <div class="search pointer">
              <i class="el-icon-search" @click="show4=true" style="font-size:20px"></i>
            </div>
            <div class="navlogin">
              <a @click="$router.push({path:'/login'})">登录</a>
              <span class="line">|</span>
              <a @click="$router.push({path:'/register'})">注册</a>
            </div>
          </div>
          <div class="nav" id="nav">
            <ul class="posA clearfix">
              <li class="posLi1">
                <a href="javascript:void(0);">人力资源</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="search_box" id="search_box" :class="{'searchbox':showFF}" @mouseleave="show4=!show4">
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
    </div> -->
    <div class="policyCon">
      <div class="banner pr">
        <div class="swiper-container">
          <div class="swiper-wrapper">
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/humenResouce.png" alt="">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/humenResouce.png" alt="">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/humenResouce.png" alt="">
            </div>
          </div>
        </div>
      </div>

      <div class="techContent w">
        <span class="pointer" @click="$router.push({path:'/enterpriseservice'})">企业服务</span>
        <span>/</span>
        <span class="mainColor">人力资源</span>
      </div>
      <div class="actiFilter w clearfix">
        <div class="timeFilter">
          <i>时间筛选:</i>
          <span :class="{'active0':timeIndexFlag == ''}" @click="timeSelect('')">不限</span>
          <span :class="{'active0':timeIndexFlag == 'week'}" @click="timeSelect('week')">最近一周</span>
          <span :class="{'active0':timeIndexFlag == 'month'}" @click="timeSelect('month')">最近一月</span>
        </div>
        <div class="timeOrder">
          <ul>
            <li @click="handleTime('time')" :class="{'active1':colorFlag == 'time'}">
              <i class="iconfont icon-clock-"></i>
              <span>时间排序</span>
            </li>
            <li @click="handleTime('hot')" :class="{'active1':colorFlag == 'hot'}">
              <i class="iconfont icon-hot"></i>
              <span>热度排序</span>
            </li>
          </ul>
        </div>
      </div>
      <div class="allActi w clearfix">
        <ul class="actiFilterUl fl clearfix">
          <li :class="{'active22':actiFilflag == ''}" @click="handleFil('')">全部</li>
          <li v-for="(v,i) in typeList" :key="i" :class="{'active22':actiFilflag == v.codeValue}" @click="handleFil(v.codeValue)">{{v.codeName}}</li>
        </ul>
        <div class="actiSearch fr">
          <input type="text" placeholder="搜索招聘" v-model="searchFiled" style="border-bottom: 1px solid #eee;">
          <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
        </div>
      </div>
      <div class="serverOrgContent w">
        <ul>
          <li class="clearfix pr" v-for="(i,k) in humanList" :key='k'>
            <div class="orgImg fl">
              <!-- <img src="@/../static/img/ins1.png" alt=""> -->
              <img :src="i.comAvatar" alt="">
            </div>
            <div class="orgCon fl">
              <div class="conTil">招聘岗位：{{i.post}}</div>
              <div class="conContent clearfix color3">
                <div class="left1 fl">
                  <p>招聘企业：
                    <span class="mainColor">{{i.comName}}</span>
                  </p>
                  <p>招聘人数：{{i.num}}</p>
                  <p>薪资待遇:
                    <span class="mainColor">{{i.salaryName}}</span>
                  </p>
                  <p>发布时间：{{i.createdTime}}</p>
                </div>
              </div>
            </div>

            <div class="orgBtn fr mainColor" @click.stop="getRecruitDetails(i.id),detailFlag=i.id">
              了解详情
            </div>
            <div class="orgBtn orgBtn1 fr mainColor" @click="onlineContat(i.comId)">
              在线联系
            </div>
            <!-- 详情弹框 -->
            <div class="detailRes" v-if="detailFlag==i.id">
              <!-- <el-card> -->
              <div class="detail">招聘详情</div>
              <p class="p1">企业名称：{{humanDetail.comName}}</p>
              <p class="p1">发布时间：{{humanDetail.createdTime}}</p>
              <p  v-html="humanDetail.details">岗位详情：</p>
              <!-- </el-card> -->
            </div>
          </li>
        </ul>
      </div>
      <div class="pagination-container">
        <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-sizes="[3, 6, 9, 12]" :page-size="row" layout="total,prev, pager, next,sizes" :total="total">
        </el-pagination>
      </div>
    </div>
    <!-- 招聘详情 -->
    <!-- <template v-if="humanDelVisible">
      <el-dialog :visible.sync="humanDelVisible" width="530px" top="30vh">
         <div class="detailTit color2">招聘详情</div>
         <p class="p1">{{humanDetail.comName}}</p>
         <p class="p1">{{humanDetail.createdTime}}</p>
         <p class="p1">{{humanDetail.details}}</p>
      </el-dialog>
    </template> -->
    <template v-if="concatVisible">
      <el-dialog :visible.sync="concatVisible" width="530px" top="30vh" :append-to-body="true" :lock-scroll="false">
        <div class="loginTip" style="text-align:center;padding-bottom:20px">
          你还未
          <span class="mainColor pointer" @click="goLogin">登录</span>
          /
          <span class="mainColor pointer" @click="$router.push({path:'/register'})">注册</span>
          账号
        </div>
      </el-dialog>
    </template>
  </div>
</template>
<script>
import swiper from "swiper";
import bus from "@/util/bus";
export default {
  data() {
    return {
      concatVisible: false,
      detailFlag: "",
      sousuo: false,
      searchData: "",
      showFF: false,
      show4: false,
      headFlag: false,
      colorFlag: "time",
      timeIndexFlag: "",
      actiFilflag: "",
      page: 1,
      row: 3,
      total: 0,
      humanList: [],
      searchFiled: "",
      typeList: [],
      type: "",
      whereTypes: "",
      sortTypes: "time",
      humanDetail: {}
    };
  },
  created() {
    let _this = this;
    bus.$on("closeKnow", msg => {
      _this.detailFlag = "";
    });
  },
  mounted() {
    window.addEventListener("scroll", this.handleScroll);
    this.getWebRecruitList();
    this.getInviteType();
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
  },
  methods: {
    goLogin() {
      window.sessionStorage.setItem("PresetRoute", this.$route.fullPath);
      this.$router.push({ path: "/login" });
    },
    //在线联系
    onlineContat(id) {
      if (!this.getUserInfo()) {
        this.concatVisible = true;
        return;
      }
      this.api.get({
        url: "getCompanyContactAccount",
        data: {
          comId: id
        },
        callback: res => {
          if (res.code == "0000") {
            // this.typeList = res.data;
            if (
              JSON.parse(this.getUserInfo()).account == res.data.account
            ) {
              this.$message.error("当前登录的账号跟聊天对象一样");
              return;
            }
            this.$router.push({
              path: "/chat",
              query: {
                fromUser: JSON.parse(this.getUserInfo()).account,
                toUser: res.data.account,
                nickName: res.data.nickName
              }
            });
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    handleFil(v) {
      this.type = v;
      this.actiFilflag = v;
      this.getWebRecruitList();
    },
    //一周、一月筛选
    timeSelect(i) {
      this.whereTypes = i;
      this.timeIndexFlag = i;
      this.page = 1;
      this.getWebRecruitList();
    },
    //时间、热度排序
    handleTime(i) {
      this.colorFlag = i;
      this.sortTypes = i;
      this.page = 1;
      this.getWebRecruitList();
    },
    handleScroll() {
      if (
        this.getScrollTop() > document.getElementById("header").clientHeight
      ) {
        this.showFF = true;
        this.show4 = false;
      } else {
        this.showFF = false;
      }
    },
    getScrollTop() {
      var scroll_top = 0;
      if (document.documentElement && document.documentElement.scrollTop) {
        scroll_top = document.documentElement.scrollTop;
      } else if (document.body) {
        scroll_top = document.body.scrollTop;
      }
      return scroll_top;
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.row = val;
      this.page = 1;
      this.getWebRecruitList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.getWebRecruitList();
    },
    handleSearchList() {
      //搜索
      this.page = 1;
      this.getWebRecruitList();
    },
    //企业招聘列表
    getWebRecruitList() {
      let _this = this;
      this.api.get({
        // url: "getWebRecruitList",
        url: "getRecruitList",
        data: {
          page: _this.page,
          rows: _this.row,
          searchFiled: _this.searchFiled,
          type: _this.type,
          sortTypes: _this.sortTypes,
          comId: _this.$route.query.comId,
          whereTypes: _this.whereTypes
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.humanList = res.data.rows;
            _this.total = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //企业招聘详情
    getRecruitDetails(id) {
      let _this = this;
      this.api.get({
        url: "getRecruitDetails",
        data: {
          recruitId: id
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.humanDetail = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //获取招聘类型
    getInviteType() {
      let _this = this;
      this.api.get({
        url: "getInviteType",
        data: {
          groupId: "recruitType"
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.typeList = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //获取招聘类型
    getCompanyContactAccount() {
      let _this = this;
      this.api.get({
        url: "getCompanyContactAccount",
        data: {
          comId: "recruitType"
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.typeList = res.data;
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
.humanSource {
  .loginTip {
    text-align: center;
    margin-bottom: 20px;
    font-size: 15px;
  }
  input::-webkit-input-placeholder {
    /* WebKit browsers*/
    color: #999;
    font-size: 13px;
  }

  input:-moz-placeholder {
    /* Mozilla Firefox 4 to 18*/
    color: #999;
    font-size: 13px;
  }

  input::-moz-placeholder {
    /* Mozilla Firefox 19+*/
    color: #999;
    font-size: 13px;
  }

  input:-ms-input-placeholder {
    /* Internet Explorer 10+*/
    color: #999;
    font-size: 13px;
  }
  #lastLi {
    float: right;
    margin-top: -26px;
  }
  .pagination-container {
    margin: 50px 0;
  }
  .techHeah {
    position: fixed;
    z-index: 9;
    width: 100%;
    .header {
      background-color: rgba(167, 167, 185, 0.5);
      width: 100%;
      z-index: 3;
      .headerContainer {
        padding: 0 160px;
        width: 100%;
        height: 65px;
        line-height: 65px;
        color: #fff;
        font-size: 16px;
        box-sizing: border-box;
        .titleImg {
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
              font-size: 14px;
              text-align: center;
              // line-height: 52px;
              padding: 0 38px;
              // width: 100px;
            }
          }
          //   .posLi1 {
          //     background: #fff;
          //     color: #00a041;
          //     border-radius: 5px;
          //   }
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
            font-size: 14px;
            a {
              display: inline-block;
              cursor: pointer;
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
    .headerw {
      background: #fff;
      border: 1px solid #eee;
      box-shadow: 0 10px 10px -10px #ccc;
      color: #666;
      #nav,
      .headerRight {
        color: #666;
        li {
          a {
            color: #00a041;
          }
        }
      }
    }
    .search_box {
      background: rgba(0, 0, 0, 0.3);
      // text-align: center;
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
    .searchbox {
      background: #fff;
      box-shadow: 0 10px 10px -10px #ccc;
    }
  }
  .policyCon {
    .banner {
      img {
        width: 100%;
        height: 100%;
      }
    }
    .techContent {
      padding: 20px 0;
      font-size: 13px;
      font-weight: bold;

      .agent {
        font-weight: bold;
      }
    }
  }
  .actiFilter {
    height: 75px;
    line-height: 75px;
    border: 1px solid #eee;

    .timeFilter {
      float: left;
      color: #797979;
      padding: 0 20px;
      > span {
        cursor: pointer;
        display: inline-block;
        width: 100px;
        height: 32px;
        line-height: 32px;
        text-align: center;
        margin-left: 20px;
        border-radius: 16px;
      }

      > span.active0 {
        color: #fff;
        background: linear-gradient(to bottom right, #35bf6d, #00a041);
      }
    }

    .timeOrder {
      float: right;
      color: #919191;
      padding: 0 20px;

      > ul {
        overflow: hidden;

        li {
          display: inline-block;
          margin-left: 20px;
          cursor: pointer;

          .iconfont {
            font-size: 18px;
          }

          .icon-menu1:hover {
            cursor: pointer;
          }

          .icon-menu {
            cursor: pointer;
            margin-left: 10px;
          }
        }

        li.active1 {
          // color: #00a041;
          background-image: -webkit-linear-gradient(
            to bottom right,
            #35bf6d,
            #00a041
          );
          // -webkit-background-clip: text;
          // color: transparent;
          -webkit-text-fill-color: #00a041;
          -webkit-background-clip: text;
        }
        .showListLi > i.active {
          color: #00a041;
        }
      }
    }
  }
  .allActi {
    padding-top: 20px;
    border-bottom: 1px solid #eee;
    line-height: 37px;
    .actiFilterUl {
      > li {
        float: left;
        padding: 0 10px;
        padding-bottom: 8px;
        margin-right: 20px;
        cursor: pointer;
        color: #333;
      }
      > li.active22 {
        border-bottom: 2px solid #00a041;
        color: #00a041;
      }
      .bottomLi {
        margin-right: 0;
      }
      .box-card {
        position: absolute;
        left: 8px;
        top: 23px;
        background-color: #fff;
        padding: 0;
        z-index: 4;
      }
      .el-card__body {
        padding: 0;
        width: 100%;
        height: 100%;
      }
      .listUl {
        width: 100%;
        height: 100%;
        padding: 0 20px;
      }
      .listUl > li {
        padding: 5px 0;
        float: left;
        width: 170px;
        cursor: pointer;
        color: #000;
      }
      .listUl > li.active {
        color: #00a041;
      }
    }
    .actiSearch {
      width: 200px;
      height: 35px;
      line-height: 35px;
      text-align: center;
      padding-right: 40px;
      border: 1px solid #eee;
      border-radius: 5px;
      background: #fff;
      > input {
        border: 0;
        height: 100%;
        width: 80%;
      }
      input,
      textarea,
      select,
      button {
        text-rendering: auto;
        color: #333;
        letter-spacing: normal;
        word-spacing: normal;
        text-transform: none;
        text-indent: 0;
        text-shadow: none;
        display: inline-block;
        text-align: start;
        margin: 0em;
        font: 400 16px Arial;
      }
      > .icon-sousuo {
        position: relative;
        top: -36px;
        right: -120px;
        cursor: pointer;
        font-size: 20px;
        display: inline-block;
        width: 40px;
        line-height: 37px;
        text-align: center;
        border-left: 1px solid #eee;
      }
    }
  }
  .serverOrgContent {
    margin-top: 20px;
    margin-bottom: 70px;
    > ul {
      > li {
        padding: 20px 0;
        border-bottom: 1px solid #eee;
        .orgImg {
          width: 200px;
          height: 130px;
          > img {
            width: 100%;
            height: 100%;
          }
        }
        .orgCon {
          margin-left: 20px;
          .conTil {
            font-size: 15px;
            color: #222;
            font-weight: bold;
            margin-bottom: 30px;
          }
          .conContent {
            font-size: 12px;
            .left1 {
              width: 300px;
              > p {
                margin-bottom: 5px;
              }
            }
            .right1 {
              // margin-left: 40px;
              > p {
                margin-bottom: 5px;
              }
              .el-rate {
                display: inline-block;
              }
              // .el-rate__icon{
              // color:#009f42 !important;
            }
          }
        }
      }
      .orgBtn {
        font-size: 13px;
        background: #ecfcf2;
        padding: 6px 20px;
        border: 1px solid #00a041;
        border-radius: 4px;
        margin-top: 50px;
        cursor: pointer;
      }
      .orgBtn1 {
        background: #00a041;
        color: #fff;
        margin-right: 10px;
      }
    }
    > li:first-child {
      padding-top: 10px;
    }
  }
  .detailTit {
    font-size: 16px;
    margin-bottom: 10px;
  }
  .p1 {
    line-height: 25px;
  }
  .el-dialog__body {
    padding: 0 20px 20px;
  }
  .detailRes {
    width: 400px;
    position: absolute;
    right: 95px;
    top: -80px;
    z-index: 3;
    text-align: left;
    padding: 20px 30px;
    background: #fff;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.5);
    .detail {
      margin-bottom: 10px;
      color: #333;
    }
    .p1 {
      font-size: 13px;
    }
    // .el-card__body {
    // padding: 20px 30px;
    // }
  }
}
</style>


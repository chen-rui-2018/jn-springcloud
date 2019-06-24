1<template>
  <div class="policyCenter0">
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
            <user-info></user-info>
          </div>
          <div class="nav" id="nav">
            <ul class="posA clearfix">
              <li class="posLi1">
                <a href="javascript:void(0);">政策中心</a>
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
              <img src="@/../static/img/policybanner.png" alt="">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/policybanner.png" alt="">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/policybanner.png" alt="">
            </div>
          </div>
        </div>
      </div>

      <div class="techContent w">
        <span class="pointer" @click="$router.push({path:'/enterpriseservice'})">企业服务</span>
        <span>/</span>
        <span class="mainColor">政策中心</span>
      </div>
      <div class="serverOrgNav w mainBorder" v-if="tableType=='allPolicy'">
        <div class="policynav">
          <div class="nav1 clearfix">
            <div class="nav1Tit fl">政策级别：</div>
            <ul class="nav1Ul fl clearfix" style="width:auto;">
              <li :class="{'active0':filterFlag == ''}" @click="handleFilter('')">不限</li>
            </ul>
            <ul class="nav1Ul fl clearfix" :class="{'sh':!flag1}">
              <li class="wid1" v-for="(i,k) in policyLevel" :key='k' @click="handleFilter(i.policyLevelCode)" :class="{'active0':filterFlag == i.policyLevelCode}">{{i.policyLevelName}}</li>
            </ul>
            <div class="fr" v-if="widFun('wid1')">
              <i class="el-icon-arrow-down" v-if="flag1" @click="flag1 = !flag1"></i>
              <i class="el-icon-arrow-up" v-else @click="flag1 = !flag1"></i>
            </div>
          </div>
          <div class="nav1 clearfix">
            <div class="nav1Tit fl">政策分类：</div>
            <!-- <div class="fl" :class="{'active':filterFlag1 == ''}" @click="handleFilter1('')">不限</div> -->
            <ul class="nav1Ul fl clearfix" style="width:auto;">
              <li :class="{'active0':filterFlag1 == ''}" @click="handleFilter1('')">不限</li>
            </ul>
            <ul class="nav1Ul fl clearfix" :class="{'sh':!flag2}">
              <li class="wid2" v-for="(i,k) in policyClass" :key='k' @click="handleFilter1(i.policyClassCode)" :class="{'active0':filterFlag1 == i.policyClassCode}">{{i.policyClassName}}</li>
            </ul>
            <div class="fr" v-if="widFun('wid2')">
              <i class="el-icon-arrow-down" v-if="flag2" @click="flag2 = !flag2"></i>
              <i class="el-icon-arrow-up" v-else @click="flag2 = !flag2"></i>
            </div>
          </div>
          <div class="nav1 clearfix">
            <div class="nav1Tit fl">政策类型：</div>
            <ul class="nav1Ul fl clearfix" :class="{'sh':!flag3}">
              <li class="wid3" @click="handleFilter2('0')" :class="{'active0':filterFlag2 == '0'}">普通政策</li>
              <li class="wid3" @click="handleFilter2('1')" :class="{'active0':filterFlag2 == '1'}">图解政策</li>
            </ul>
            <div class="fr" v-if="widFun('wid3')">
              <i class="el-icon-arrow-down" v-if="flag3" @click="flag3 = !flag3"></i>
              <i class="el-icon-arrow-up" v-else @click="flag3 = !flag3"></i>
            </div>
          </div>
          <div class="nav1 nav2 clearfix">
            <div class="nav1Tit fl">发布时间：</div>
            <ul class="nav1Ul fl clearfix" style="width:auto">
              <li :class="{'active0':filterFlag3 == ''}" @click="handleFilter3('')">不限</li>
            </ul>
            <ul class="nav1Ul fl clearfix" :class="{'sh':!flag4}">
              <li class="wid4" v-for="(i,k) in arrYear" v-if='k<9' :key='k' @click="handleFilter3(i)" :class="{'active0':filterFlag3 == i}">{{i}}年</li>
              <li class="wid4" id="lastLi" @click="handleFilter3('1')" :class="{'active0':filterFlag3 == '1'}">{{arrYear[arrYear.length-1]}}年及以前</li>
            </ul>
            <!-- <ul class="nav1Ul fl clearfix" style="width:auto">
            <li @click="handleFilter3('1')" :class="{'active':filterFlag3 == '1'}">{{arrYear[arrYear.length-1]}}年及以前</li>
          </ul> -->
            <div class="fr" v-if="widFun('wid4')">
              <i class="el-icon-arrow-down" v-if="flag4" @click="flag4 = !flag4"></i>
              <i class="el-icon-arrow-up" v-else @click="flag4 = !flag4"></i>
            </div>
          </div>
        </div>
      </div>
      <div class="policyTab  w">
        <div class="pr">
          <span class="wenzi color3">政策检索</span>
          <div class="filRight">
            <input type="text" placeholder="搜政策" v-model="policySearch">
            <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
          </div>
          <!-- <div class="search">
            <el-input placeholder="请输入活动名称">
              <el-button slot="append" icon="el-icon-search"></el-button>
            </el-input>
          </div> -->
        </div>
        <el-tabs v-model="activeName" @tab-click="handleClick" class="tabBox">
          <el-tab-pane label="政策一览" name="first">
            <ul class="fir">
              <li class="clearfix" v-for="(i,k) in policyCenterList" :key="k">
                <div class="fir1 fl pointer" @click="godetails(i)">
                  <h3 class="color4">{{i.policyTitle}}</h3>
                  <p class="p1">
                    <span>阅读次数：
                      <i class="mainColor">{{i.readNum}}</i>次</span>
                    <span>发布日期：{{i.releaseDate}}</span>
                    <span>状态：
                      <i class="mainColor" v-if="i.status=='1'">有效</i>
                      <i class="mainColor" v-if="i.status=='0'">无效</i>
                    </span>
                  </p>
                  <p class="p2">
                    <span>支持方式：
                      <i v-if="i.supportMethod=='1'">奖励</i>
                      <i v-if="i.supportMethod=='2'">其他</i>
                    </span>
                    <span>支持产业：
                      <i v-if="i.supportIndustry=='1'">所有产业</i>
                      <i v-if="i.supportIndustry=='2'">其他</i>
                    </span>
                  </p>
                  <p>发文单位：{{i.issueUnit}}</p>
                  <div class="firInfo">{{i.briefContent}}</div>
                </div>
                <div class="fir2 fr mainColor" v-if="i.isPolicyDiagram=='1'" @click="$router.push({path:'/graphicPolicy',query:{policyId:i.relationPolicyDiagramId,policyTitle:i.policyTitle}})">图解</div>
              </li>
            </ul>

          </el-tab-pane>
          <el-tab-pane label="图解政策" name="second">
            <ul class="finaUl clearfix">
              <li class="mainBorder pointer" v-for="(i,k) in policyCenterList" :key="k" @click="$router.push({path:'/graphicPolicy',query:{policyId:i.policyId,isPolicyOriginal:i.isPolicyOriginal}})">
                <!-- <img src="@/../static/img/midBan.png" alt=""> -->
                <div class="finaProItem pointer">
                  <img :src="i.policyDiagramUrl" alt="">
                </div>
                <div class="finaDiv1">
                  <div class="finaTit">{{i.policyTitle}}</div>
                  <div class="finaContent">
                    <p>阅读量：
                      <span class="mainColor">{{i.readNum }}</span>
                    </p>
                    <p>发布日期：
                      <span class="mainColor">{{i.releaseDate}}</span>
                    </p>
                  </div>
                </div>
              </li>
            </ul>
          </el-tab-pane>
          <el-tab-pane label="一号专题" name="third">
            <ul class="policyUl11 clearfix">
              <li class="mainBorder pointer" v-for="(i,k) in policyCenterList" :key="k" @click="$router.push({path:'/policyGuide',query:{policyId:i.policyId}})">
                <!-- <img src="@/../static/img/midBan.png" alt=""> -->
                <div class="finaProItem">
                  <img :src="i.policyDiagramUrl" alt="">
                </div>
                <div class="finaDiv1">
                  <div class="finaContent color4">
                    <p>图解：{{i.policyTitle}}
                    </p>
                  </div>
                </div>
              </li>
            </ul>
          </el-tab-pane>
          <el-tab-pane label="民营专题" name="fourth">
            <ul class="policyUl22 clearfix">
              <li class="mainBorder pointer" v-for="(i,k) in policyCenterList" :key="k" @click="$router.push({path:'/policyGuide',query:{policyId:i.policyId}})">
                <!-- <img src="@/../static/img/midBan.png" alt=""> -->
                <div class="finaProItem">
                  <img :src="i.policyDiagramUrl" alt="">
                </div>
                <div class="finaDiv1">
                  <div class="finaTit mainColor">{{i.policyTitle}}</div>
                  <div class="finaContent">
                    <p>阅读量：
                      <span class="mainColor">{{i.readNum }}</span>
                    </p>
                    <p>发布日期：
                      <span class="mainColor">{{i.releaseDate}}</span>
                    </p>
                  </div>
                </div>
                <p class="finaPP lejie">
                  {{i.policyIssuNum}}
                </p>
              </li>
            </ul>
          </el-tab-pane>
        </el-tabs>
      </div>
      <div class="pagination-container">
        <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-sizes="[8, 16, 24, 32]" :page-size="row" layout="total,prev, pager, next,sizes" :total="total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
import swiper from "swiper";
import userInfo from ".././common/userInfoData";
export default {
  components: {
    userInfo
  },
  data() {
    return {
      sousuo: false,
      searchData: "",
      showFF: false,
      show4: false,
      headFlag: false,
      filterFlag1: "",
      filterFlag2: "0",
      filterFlag3: "",
      filterFlag: "",
      flag1: true,
      flag2: true,
      flag3: true,
      flag4: true,
      activeName: "first",
      policyLevel: "",
      policyClass: "",
      policyCenterList: "",
      policyClassCode: "",
      policyLevelCode: "",
      policySearch: "",
      policyType: "0",
      releaseDate: "",
      tableType: "allPolicy",
      page: 1,
      row: 8,
      total: 0,
      arrYear: [],
      yearBefore: "",
      scroll_top: 0
    };
  },
  mounted() {
    window.addEventListener("scroll", this.handleScroll);
    this.getPolicyLevelList();
    this.getPolicyClassList();
    this.getPolicyCenterList();
    this.getYear();
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
  },
  methods: {
    godetails(i) {
      if (this.policyType == "1") {
        this.$router.push({
          path: "/graphicPolicy",
          query: { policyId: i.policyId }
        });
      } else {
        this.$router.push({
          path: "/policyGuide",
          query: { policyId: i.policyId }
        });
      }
    },
    handleClick(tab) {
      if (tab.name == "second") {
        this.tableType = "diagramPolicy";
        this.getPolicyCenterList();
      } else if (tab.name == "third") {
        this.tableType = "firstTopic";
        this.getPolicyCenterList();
      } else if (tab.name == "fourth") {
        this.tableType = "privateTopic";
        this.getPolicyCenterList();
      } else {
        this.tableType = "allPolicy";
        this.getPolicyCenterList();
      }
    },
    widFun(i) {
      let doc = document.getElementsByClassName(i);
      let num = 0;
      for (let it of doc) {
        num += it.offsetWidth * 1;
      }
      // console.log(num);
      if (num >= 860) {
        return true;
      } else {
        return false;
      }
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
      this.getPolicyCenterList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.getPolicyCenterList();
    },
    handleSearchList() {
      //搜索
      this.page = 1;
      this.getPolicyCenterList();
    },
    //筛选政策级别
    handleFilter(i) {
      if(this.filterFlag == i){
        return
      }
      // document.documentElement.scrollTop = document.getElementsByClassName("tabBox")[0].offsetTop;
      this.scrollTopAnimate()
      this.policyLevelCode = `${i}`;
      this.filterFlag = i;
      this.getPolicyCenterList();
    },
    //筛选政策分类
    handleFilter1(i) {
      if(this.filterFlag1 == i){
        return
      }
      // document.documentElement.scrollTop = document.getElementsByClassName("tabBox")[0].offsetTop
      this.scrollTopAnimate()
      this.policyClassCode = `${i}`;
      this.filterFlag1 = i;
      this.getPolicyCenterList();
    },
    //筛选政策类型
    handleFilter2(i) {
       if(this.filterFlag2 == i){
        return
      }
      // document.documentElement.scrollTop = document.getElementsByClassName("tabBox")[0].offsetTop
      this.scrollTopAnimate()
      this.policyType = i;
      this.filterFlag2 = i;
      this.getPolicyCenterList();
    },
    //筛选发布时间
    handleFilter3(i) {
      if(this.filterFlag3 == i){
        return
      }
      // document.documentElement.scrollTop = document.getElementsByClassName("tabBox")[0].offsetTop
      this.scrollTopAnimate()
      if (i == "1") {
        this.yearBefore = "1";
        this.filterFlag3 = i;
      } else {
        this.releaseDate = `${i}`;
        this.filterFlag3 = i;
        this.yearBefore = "";
      }
      this.getPolicyCenterList();
    },
    getScrollTop(){ //滚动条在Y轴上的滚动距离
    　　var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0;
    　　if(document.body){
    　　　　bodyScrollTop = document.body.scrollTop;
    　　}
    　　if(document.documentElement){
    　　　　documentScrollTop = document.documentElement.scrollTop;
    　　}
    　　scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;
    　　return scrollTop;
    },
    getScrollHeight(){ //文档的总高度
    　　var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;
    　　if(document.body){
    　　　　bodyScrollHeight = document.body.scrollHeight;
    　　}
    　　if(document.documentElement){
    　　　　documentScrollHeight = document.documentElement.scrollHeight;
    　　}
    　　scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;
    　　return scrollHeight;
    },
    getWindowHeight(){ //浏览器视口的高度
    　　var windowHeight = 0;
    　　if(document.compatMode == "CSS1Compat"){
    　　　　windowHeight = document.documentElement.clientHeight;
    　　}else{
    　　　　windowHeight = document.body.clientHeight;
    　　}
    　　return windowHeight;
    },
    scrollTopAnimate(){
      let times = setInterval(()=>{
        document.documentElement.scrollTop = this.getScrollTop() + 10;
        if(this.getScrollTop() + this.getWindowHeight() == this.getScrollHeight() || this.getScrollTop() >= document.getElementsByClassName("tabBox")[0].offsetTop - 100){
          clearInterval(times)
    　　}
      },1)
    },
    //政策中心首页
    getPolicyCenterList() {
      let _this = this;
      this.api.get({
        url: "getPolicyCenterList",
        data: {
          needPage: 1,
          page: _this.page,
          policyClassCode: _this.policyClassCode,
          policyLevelCode: _this.policyLevelCode,
          policySearch: _this.policySearch,
          policyType: _this.policyType,
          releaseDate: _this.releaseDate,
          rows: _this.row,
          tableType: _this.tableType,
          yearBefore: _this.yearBefore
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.policyCenterList = res.data.rows;
            _this.total = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //政策级别
    getPolicyLevelList() {
      let _this = this;
      this.api.get({
        url: "getPolicyLevelList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.policyLevel = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //政策分类
    getPolicyClassList() {
      let _this = this;
      this.api.get({
        url: "getPolicyClassList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.policyClass = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //获取最近10年的年份
    getYear() {
      var myDate = new Date();
      var thisYear = myDate.getFullYear();
      var Section = thisYear - (thisYear - 9);
      for (var i = 0; i <= Section; i++) {
        this.arrYear.push(thisYear--);
      }
    }
  }
};
</script>
<style lang="scss">
.policyCenter0 {
  #lastLi {
    float: right;
    margin-top: -26px;
  }
  .pagination-container {
    margin-top: 50px;
    margin-bottom: 10px;
  }
  // .techHeah {
  //   position: fixed;
  //   z-index: 9;
  //   width: 100%;
  //   .header {
  //     //   background-color: rgba(255, 255, 255, 0.2);
  //     background-color: #3281a9;
  //     width: 100%;
  //     z-index: 3;
  //     .headerContainer {
  //       padding: 0 160px;
  //       width: 100%;
  //       height: 65px;
  //       line-height: 65px;
  //       color: #fff;
  //       font-size: 16px;
  //       box-sizing: border-box;
  //       .titleImg {
  //         width: 155px;
  //         height: 38px;
  //         img {
  //           width: 100%;
  //           height: 100%;
  //           vertical-align: middle;
  //         }
  //       }
  //       .nav {
  //         width: 600px;
  //         height: 37.6px;
  //         margin: 0 auto;
  //         > ul {
  //           overflow: hidden;
  //           li {
  //             float: left;
  //             // color: #ccc;
  //             font-size: 14px;
  //             text-align: center;
  //             // line-height: 52px;
  //             padding: 0 38px;
  //             // width: 100px;
  //           }
  //         }
  //         //   .posLi1 {
  //         //     background: #fff;
  //         //     color: #00a041;
  //         //     border-radius: 5px;
  //         //   }
  //         .posA {
  //           position: absolute;
  //           left: 50%;
  //           transform: translateX(-50%);
  //           // padding: 20px 0;
  //         }
  //         .sousuo {
  //           font-size: 18px;
  //           line-height: 48px;
  //           > input {
  //             border: none;
  //             width: 350px;
  //             height: 38px;
  //             font-size: 14px;
  //           }
  //           > input::-webkit-input-placeholder {
  //             color: #b7b7b7;
  //             font-size: 12px;
  //           }
  //         }
  //       }
  //       .headerRight {
  //         .search {
  //           display: inline-block;
  //           margin-right: 20px;
  //           vertical-align: middle;
  //           i {
  //             width: 20px;
  //             height: 20px;
  //           }
  //         }
  //         .navlogin {
  //           display: inline-block;
  //           font-size: 14px;
  //           a {
  //             display: inline-block;
  //             cursor: pointer;
  //           }
  //           .line {
  //             display: inline-block;
  //             height: 12px;
  //             margin: 0 15px;
  //           }
  //           > img {
  //             width: 50px;
  //             height: 50px;
  //             border-radius: 50%;
  //           }
  //         }
  //       }
  //     }
  //   }
  //   .headerw {
  //     background: #fff;
  //     border: 1px solid #eee;
  //     box-shadow: 0 10px 10px -10px #ccc;
  //     color: #666;
  //     #nav,
  //     .headerRight {
  //       color: #666;
  //       li {
  //         a {
  //           color: #00a041;
  //         }
  //       }
  //     }
  //   }
  //   .search_box {
  //     background: rgba(0, 0, 0, 0.3);
  //     // text-align: center;
  //     .el-input-group {
  //       border-radius: 28px;
  //       width: 42%;
  //       margin: 43px 0;
  //       position: relative;
  //       transform: translateX(-50%);
  //       left: 50%;
  //       .el-input {
  //         width: 94px;
  //       }
  //       .el-input__inner:focus {
  //         border-color: #00a041;
  //       }
  //       .el-input-group__append,
  //       .el-input-group__prepend {
  //         border-radius: 28px;
  //       }
  //       .el-input-group__append {
  //         /* border-top-left-radius: 0;
  //     border-bottom-left-radius: 0; */
  //         background: #00a041;
  //         color: #fff;
  //         right: 58px;
  //         .el-button {
  //           margin: -10px -10px;
  //         }
  //       }
  //       .el-input-group__prepend {
  //         border-top-right-radius: 0;
  //         border-bottom-right-radius: 0;
  //         background-color: #fff;
  //         padding: 0px 17px 0 9px;
  //         input {
  //           color: #666666;
  //           text-align: right;
  //         }
  //       }
  //     }
  //     .input-with-select .el-input__inner {
  //       border-top-left-radius: 19px;
  //       border-bottom-left-radius: 19px;
  //       border: 1px solid #00a041;
  //     }
  //   }
  //   .searchbox {
  //     background: #fff;
  //     box-shadow: 0 10px 10px -10px #ccc;
  //   }
  // }
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
    .serverOrgNav {
      font-size: 13px;
      margin-bottom: 20px;
      text-align: center;
      .policynav {
        padding: 0 20px;
      }
      .nav1 {
        padding: 15px 0;
        border-bottom: 1px solid #eee;
        color: #666;

        > img {
          width: 12px;
          height: 15px;
          vertical-align: top;
        }

        // color:#666;
        .nav1Tit {
          margin-top: 5px;
        }

        .nav1Ul {
          width: 860px;
          overflow: hidden;
          height: 27px;

          // text-indent: -35px;
          // margin-left: 35px;
          > li {
            float: left;
            margin-left: 20px;
            padding: 5px 10px;
            cursor: pointer;
            line-height: 17px;
          }

          > li.active0 {
            background: #009f42;
            border-radius: 4px;
            color: #fff;
          }
        }

        .nav1Ul.sh {
          overflow: visible;
          height: auto;
        }

        .el-icon-arrow-down,
        .el-icon-arrow-up {
          font-size: 18px;
          color: #999;
        }
      }
      #nav1 {
        border: none;
      }

      .nav2 {
        border-bottom: none;
      }
    }
    .policyTab {
      .wenzi {
        position: absolute;
        right: 265px;
        top: 5px;
        font-size: 15px;
        // z-index:4;
      }
      .filRight {
        width: 200px;
        height: 30px;
        // line-height: 35px;
        text-align: center;
        padding-right: 40px;
        border: 1px solid #eee;
        border-radius: 5px;
        position: absolute;
        right: 0;
        z-index: 3;

        > input {
          border: 0;
          height: 100%;
          width: 95%;
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
          top: -31px;
          right: -120px;
          cursor: pointer;
          font-size: 20px;
          display: inline-block;
          width: 40px;
          line-height: 32px;
          text-align: center;
          border-left: 1px solid #eee;
          background: #00a041;
          border-top-right-radius: 5px;
          border-bottom-right-radius: 5px;
          color: #fff;
        }
      }
      .el-tabs__item {
        font-size: 15px;
      }
      .fir {
        li {
          text-align: left;
          font-size: 13px;
          padding: 15px 0;
          border-bottom: 1px solid #eee;
          h3 {
            font-size: 16px;
            margin-bottom: 10px;
          }
          p {
            color: #999;
            line-height: 20px;
          }
        }
        .fir1 {
          width: 90%;
        }
        .fir2 {
          text-align: center;
          font-size: 13px;
          background: #ecfcf2;
          padding: 6px 20px;
          border: 1px solid #00a041;
          border-radius: 4px;
          cursor: pointer;
          margin-top: 40px;
        }
        .firInfo {
          width: 100%;
          overflow: hidden;
          text-overflow: ellipsis;
          white-space: nowrap;
          color: #666;
          margin-top: 10px;
        }
        .p1 {
          // display: flex;
          // align-items: center;
          // justify-content: left;
          span {
            display: inline-block;
            width: 200px;
            //  margin-right: 40px;
          }
        }
        .p2 {
          // display: flex;
          // align-items: center;
          // justify-content: left;
          span {
            display: inline-block;
            width: 200px;
            //  margin-right: 40px;
          }
        }
      }
      .finaUl,
      .policyUl11,
      .policyUl22 {
        > li {
          width: 280px;
          // height: 250px;
          float: left;
          margin-right: 20px;
          margin-bottom: 30px;
          font-size: 13px;
          color: #999;
          > .finaDiv1 {
            padding: 10px 20px;
            > .finaTit {
              font-size: 16px;
              color: #222;
              margin-bottom: 15px;
              display: -webkit-box;
              -webkit-box-orient: vertical;
              -webkit-line-clamp: 2;
              overflow: hidden;
              height: 42px;
            }
            .finaContent {
              // margin: 10px 0;
            }
          }
          .finaPP {
            text-align: center;
            color: #fff;
            padding: 15px;
            height: 17px;
            // border-top: 1px solid #eee;
            background: url("../../../static/img/linerBg.png") 100% 100% / 100%
              100% no-repeat;
          }
          > .finaProItem {
            width: 280px;
            height: 150px;
            overflow: hidden;
            > img {
              width: 100%;
              // height: 100%;
            }
          }
        }
        > li:nth-child(4n) {
          margin-right: 0;
        }
        > .finaLastLi {
          padding: 20px;
          width: 240px;
          height: 299px;
          > img {
            width: 242px;
            height: 209px;
            margin: 20px 0;
          }
          > .rightInfo {
            background: #ecfcf2;
            padding: 10px;
            width: 69px;
            margin: 0 auto;
            border: 1px solid #00a041;
            border-radius: 4px;
            // margin-top: 20px;
            text-align: center;
            cursor: pointer;
            color: #00a041;
          }
        }
      }
      .policyUl11 {
      }
    }
  }
}
</style>


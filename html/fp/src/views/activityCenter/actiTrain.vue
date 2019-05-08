<template>
    <div class="actiTrain">
        <!-- <div class="fullNav clearfix">
            <div class="navLeft fl">
                <i class="iconfont icon-caidan"></i>
                <span>网站导航</span>
            </div>
            <ul class="navRight fr">
                <li>联系客服</li>
                <li class="line"></li>
                <li>下载APP</li>
                <li class="line"></li>
                <li>关注微信</li>
                <li class="line"></li>
                <li>登录</li>
                <li class="line"></li>
                <li>注册</li>
            </ul>
        </div> -->
        <div class="trainContent">
            <!-- <div class="searchNav">
                <div class="trainLogo">
                    <img src="@/../static/img/LOGO.png" alt="">
                </div>
                <div class="trainSearch pr">
                    <input type="text" placeholder="请输入搜索关键词">
                    <div class="iconSearch">
                        <i class="el-icon-search" style="font-size:20px;"></i>
                        <span>搜索</span>
                    </div>
                    <div class="keyWord">
                        <span>机构</span>
                        <span>产品</span>
                        <span>顾问</span>
                        <span>活动</span>
                    </div>
                </div>
            </div>
            <div class="bannerNav">
                <div class="w clearfix">
                    <div class="bannerSer fl">
                        <i class="iconfont icon-menu1"></i>
                        <span>帮您快速找服务</span>
                    </div>
                    <div class="bannerUl fr">
                        <li>首页</li>
                        <li>服务机构</li>
                        <li>服务产品</li>
                        <li>服务顾问</li>
                        <li>活动培训</li>
                        <li>关于我们</li>
                    </div>
                </div>
            </div> -->
            <div class="actiContent">
                <div class="actiNav">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
                        <el-breadcrumb-item>
                            <a href="/">活动中心</a>
                        </el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="actiFilter clearfix">
                    <div class="timeFilter">
                        <i>时间筛选:</i>
                        <span :class="{'active':timeIndexFlag == ''}" @click="timeSelect('','')">不限</span>
                        <span :class="{'active':timeIndexFlag == -7}" @click="timeSelect(0,-7)">最近一周</span>
                        <span :class="{'active':timeIndexFlag == -30}" @click="timeSelect(0,-30)">最近一月</span>
                    </div>
                    <div class="timeOrder">
                        <ul>
                            <li @click="handleTime('acti_start_time')" :class="{'active':colorFlag == 'acti_start_time'}">
                                <i class="iconfont icon-clock-"></i>
                                <span>时间排序</span>
                            </li>
                            <li @click="handleTime('acti_Like')" :class="{'active':colorFlag == 'acti_Like'}">
                                <i class="iconfont icon-hot"></i>
                                <span>热度排序</span>
                            </li>
                            <li class="showListLi">
                                <i class="iconfont icon-menu1" @click="handleCrosswise('icon-menu1')" :class="{'active':showListFlag == 'icon-menu1'}"></i>
                                <i class="iconfont icon-menu" @click="handleVertical('icon-menu')" :class="{'active':showListFlag == 'icon-menu'}"></i>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="allActi clearfix">
                    <ul class="actiFilterUl fl clearfix">
                        <li :class="{'active':actiFilflag == ''}" @click="handleFil('')">全部活动</li>
                        <li v-if="i<5" v-for="(v,i) in actiTypeList" :key="i" :class="{'active':actiFilflag == v.typeName}" @click="handleFil(v.typeName)">{{v.typeName}}</li>
                        <li v-if="this.actiTypeList.length>4" class="bottomLi pr">
                            <i class="iconfont icon-bottom" @click.stop="handleTypeList"></i>
                            <el-card class="box-card" v-if="showList" style="overflow:auto">
                                <ul class="listUl clearfix">
                                    <li v-if="k>4" v-for="(i,k) in actiTypeList" :key='k' :class="{'active':actiFilflag == i.typeName}" @click.stop="handleFil(i.typeName)">
                                        <i class="iconfont icon-yuandian"></i>{{i.typeName}}</li>
                                </ul>
                            </el-card>
                        </li>
                    </ul>
                    <div class="actiSearch fr">
                        <input type="text" placeholder="搜索活动" v-model="keyWord">
                        <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
                    </div>
                </div>
                <div class="actiTab">
                    <ul class="allActiUl clearfix" v-if="flag">
                        <li v-for="(item,index) in actiListSlim" :key='index'>
                            <img :src="item.actiPosterUrl" alt="活动海报图片" class="posterImg" @click="handleRout(item.id)">
                            <div class="actiInfo">
                                <p class="actiNameItem">{{item.actiName}}</p>
                                <p class="actiTimer">
                                    <i class="el-icon-time"></i>
                                    <span>{{item.actiStartTime}}-{{item.actiEndTime}}</span>
                                    <!-- <span>{{item.actiStartTime}}-{{item.actiEndTime.split(' ')[1]}}</span> -->
                                    <!-- <span>周日14：00-17：00</span> -->
                                </p>
                                <p>
                                    <i class="el-icon-location-outline"></i>
                                    <span>{{item.actiAddress}}</span>
                                </p>
                            </div>
                            <div class="actiNum clearfix">
                                <div class="avatar">
                                    <ul>
                                        <li><img src="" alt=""></li>
                                        <li><img src="" alt=""></li>
                                        <li><img src="" alt=""></li>
                                        <li><img src="" alt=""></li>
                                        <li><img src="" alt=""></li>
                                    </ul>
                                </div>
                                <i>{{item.actiNumber}}</i>
                                <span>
                                    <i class="iconfont icon-xihuan"></i>{{item.actiLike}}</span>
                            </div>
                        </li>
                    </ul>
                    <ul class="verticalUl" v-else>
                        <li class="clearfix" v-for="(item,index) in actiListSlim" :key='index'>
                            <div class="verticalLeft fl" @click="handleRout(item.id)">
                                <img :src="item.actiPosterUrl" alt="活动海报图片">
                            </div>
                            <div class="verticalMiddle fl">
                                <h3 class="verticalTit">{{item.actiName}}</h3>
                                <div class="xihuan">
                                    <i class="iconfont icon-xihuan"></i>
                                    <span>{{item.actiLike}}</span>
                                </div>
                                <p>
                                    <i class="el-icon-time"></i>
                                    <span>{{item.actiStartTime}}-{{item.actiEndTime}}</span>
                                </p>
                                <p class="location">
                                    <i class="el-icon-location-outline"></i>
                                    <span>{{item.actiAddress}}</span>
                                </p>
                                <div class="actiNum clearfix">
                                    <div class="avatar">
                                        <ul class="clearfix">
                                            <li><img src="@/../static/img/heng1.png" alt=""></li>
                                            <li><img src="@/../static/img/heng2.png" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                        </ul>
                                    </div>
                                    <i style="margin-left:10px">{{item.actiNumber}}</i>
                                </div>
                            </div>
                            <div class="verticalRight fr">
                                <el-button type="success" plain>立即报名</el-button>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="pagination-container" style="margin:50px auto;">
                <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage4" :page-sizes="[12, 24, 36, 48]" :page-size="row" layout="total, sizes, prev, pager, next, jumper" :total="total">
                </el-pagination>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      currentPage4: 1,
      checkActi: "",
      flag: true,
      showListFlag: "",
      currentPage4: 1,
      actiFilflag: "",
      colorFlag: "",
      actiListSlim: [],
      actiTypeList: [],
      page: 1, //页码
      row: 12, //每页显示多少条
      total: 0,
      keyWord: "",
      orderBy: "",
      timeIndexFlag: "",
      startTime: "",
      endTime: "",
      showList: false
    };
  },
  mounted(){
      this.initList()
      this.getActiType()
  },
  methods: {
    handleTypeList() {
      this.showList = !this.showList;
    },
    handleFil(v) {
      //筛选
      this.keyWord = v;
      this.actiFilflag = v;
      this.initList();
    },
    handleCrosswise(v) {
      //横向显示
      this.flag = true;
      this.showListFlag = "icon-menu1";
    },
    handleVertical() {
      //竖向显示
      this.flag = false;
      this.showListFlag = "icon-menu";
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.row = val;
      this.page = 1; //这里一定要把页码回归到第一页，再去请求数据
      this.initList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.initList();
    },
    handleRout(id) {
        this.$router.push({ path: "actiDetail",query: { activityId: id }});
    },
    handleSearchList() {
      //搜索
      this.page = 1;
      this.initList();
    },
    timeSelect(s, i) {
      //不限 一周 一月
      if (this.timeIndexFlag == i) {
        return;
      }
      this.timeIndexFlag = i;
      if (i == "") {
        this.startTime = "";
        this.endTime = "";
      } else {
        this.startTime = this.api.AddMinTime(new Date(), "day", s);
        this.endTime = this.api.AddMinTime(new Date(), "day", i);
      }
      this.initList();
    },
    handleTime(i) {
      //时间、热度排序
      this.colorFlag = i;
      this.orderBy = i;
      this.page = 1;
      this.initList();
    },
    initList() {
      //请求数据
      let _this = this;
      this.api.post({
        url: "activityListSlim",
        data: {
          endTime: this.endTime,
          keyWord: this.keyWord,
          orderBy: this.orderBy,
          page: this.page,
          rows: this.row,
          startTime: this.startTime,
          typeId: ""
        },
        dataFlag: false,
        callback: function(res) {
          if (res.code == "0000") {
            _this.actiListSlim = res.data.rows;
            _this.total = res.data.total;
          }
        }
      });
    },
    getActiType() {
      let _this = this;
      this.api.post({
        url: "findActivityTypeList",
        data: {},
        // dataFlag: false,
        callback: function(res) {
          console.log(res);
          if (res.code == "0000") {
            _this.actiTypeList = res.data.rows;
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.actiTrain {
  .fullNav {
    // width: 1286px;
    // margin:0 auto;
    padding: 10px 40px;
    background: #eeeeee;
    color: #9a9a9a;
    .navLeft {
    }
    .navRight {
      > li {
        float: left;
      }
      > .line {
        display: inline-block;
        height: 12px;
        width: 1px;
        margin: 0 20px;
        background-color: #9a9a9a;
        padding: 0;
        margin-top: 6px;
      }
    }
  }
  .trainContent {
    .searchNav {
      width: 1190px;
      margin: 0 auto;
      .trainLogo {
        display: inline-block;
        padding: 40px 0 20px 0;
        width: 218px;
        height: 54px;
        background-color: #ccc;
        > img {
          // width: 218px;
          // height: 54px;
        }
      }
      .trainSearch {
        display: inline-block;
        margin-left: 250px;
        > input {
          height: 40px;
          border: 2px solid #00a042;
          border-radius: 5px;
          width: 500px;
          padding-right: 90px;
          // text-indent: 15px;
        }
        input,
        textarea,
        select,
        button {
          text-rendering: auto;
          color: #d4d4d4;
          letter-spacing: normal;
          word-spacing: normal;
          text-transform: none;
          text-indent: 15px;
          text-shadow: none;
          display: inline-block;
          text-align: start;
          margin: 0em;
          font: 400 16px Arial;
        }
        .iconSearch {
          color: #fff;
          font-size: 18px;
          position: absolute;
          right: 0;
          top: 3px;
          height: 40px;
          width: 90px;
          line-height: 40px;
          text-align: center;
          background: #00a042;
          border-radius: 0 5px 5px 0;
        }
      }
    }

    .bannerNav {
      width: 100%;
      color: #fff;
      padding: 20px 0;
      background-color: #00a042;
      font-size: 16px;
      .bannerSer {
        padding: 0 40px 0 20px;
        .icon-menu1 {
          font-size: 18px;
          margin-right: 20px;
        }
      }
      .bannerUl {
        list-style: none;
        > li {
          float: left;
          padding: 0 40px;
        }
        > li:last-child {
          padding-right: 0;
        }
      }
    }
  }
//   .pagination-container {
//     width: 500px;
//   }
  .allActiUl{
      >li{
          img{
              width: 280px;
              height: 200px;
          }
      }
  }
}
</style>


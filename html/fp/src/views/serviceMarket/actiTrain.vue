<template>
    <div class="actiTrain">
        <div class="trainContent">
            <div class="actiContent">
                <div class="actiNav">
                    <span class="pointer" @click="$router.push({ path: '/enterpriseservice'})">企业服务/</span>
                    <span class="pointer" @click="$router.push({ path: '/serMatHp'})">服务超市/</span>
                    <span class="mainColor">活动培训</span>
                </div>
                <div class="actiFilter clearfix">
                    <div class="timeFilter">
                        <i>时间筛选:</i>
                        <span :class="{'active0':timeIndexFlag == ''}" @click="timeSelect('','')">不限</span>
                        <span :class="{'active0':timeIndexFlag == -7}" @click="timeSelect(0,-7)">最近一周</span>
                        <span :class="{'active0':timeIndexFlag == -30}" @click="timeSelect(0,-30)">最近一月</span>
                    </div>
                    <div class="timeOrder">
                        <ul>
                            <li @click="handleTime('acti_start_time')" :class="{'active0':colorFlag == 'acti_start_time'}">
                                <i class="iconfont icon-clock-"></i>
                                <span>时间排序</span>
                            </li>
                            <li @click="handleTime('acti_Like')" :class="{'active0':colorFlag == 'acti_Like'}">
                                <i class="iconfont icon-hot"></i>
                                <span>热度排序</span>
                            </li>
                            <li class="showListLi">
                                <i class="iconfont icon-menu1" @click="handleCrosswise('icon-menu1')" :class="{'active0':showListFlag == 'icon-menu1'}"></i>
                                <i class="iconfont icon-menu" @click="handleVertical('icon-menu')" :class="{'active0':showListFlag == 'icon-menu'}"></i>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="allActi clearfix">
                    <ul class="actiFilterUl fl clearfix">
                        <li :class="{'active0':actiFilflag == ''}" @click="handleFil('')">全部活动</li>
                        <li v-if="i<5" v-for="(v,i) in actiTypeList" :key="i" :class="{'active0':actiFilflag == v.typeId}" @click="handleFil(v.typeId)">{{v.typeName}}</li>
                        <li v-if="this.actiTypeList.length>4" class="bottomLi pr">
                            <i class="iconfont icon-bottom" @click.stop="handleTypeList"></i>
                            <el-card class="box-card" v-if="showList" style="overflow:auto">
                                <ul class="listUl clearfix">
                                    <li v-if="k>4" v-for="(i,k) in actiTypeList" :key='k' :class="{'active0':actiFilflag == i.typeId}" @click.stop="handleFil(i.typeId)">
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
                            <div style="width:100%;height:200px"><img style="width:100%;height:100%" :src="item.actiPosterUrl" alt="活动海报图片" class="posterImg" @click="handleRout(item.id)"></div>
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
                                        <li v-for="(avr,key) in item.avatarList" :key="key"><img :src="avr" alt=""></li>
                                        <!-- <li><img src="" alt=""></li>
                                        <li><img src="" alt=""></li>
                                        <li><img src="" alt=""></li>
                                        <li><img src="" alt=""></li> -->
                                    </ul>
                                </div>
                                <i>{{item.applyNum}}/{{item.actiNumber}}</i>
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
                                            <li v-for="(avr,key) in item.avatarList" :key="key"><img :src="avr" alt=""></li>
                                            <!-- <li><img src="@/../static/img/heng1.png" alt=""></li> -->
                                        </ul>
                                    </div>
                                    <i style="margin-left:10px">{{item.applyNum}}/{{item.actiNumber}}</i>
                                </div>
                            </div>
                            <div class="verticalRight fr">
                                <el-button type="success" v-if="item.actiStatus=='3'" style="background:#00a041;height:38px;width:110px">活动已结束</el-button>
                                <el-button type="success" v-if="item.actiStatus=='4'" style="background:#00a041;height:38px;width:110px">活动已取消</el-button>
                                <el-button type="success" v-if="item.actiStatus=='2'" style="background:#ecfcf2;height:38px;width:110px;border:1px solid #00a041;color:#00a041;">报名中</el-button>
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
      showList: false,
      typeId: ""
    };
  },
  mounted() {
    this.initList();
    this.getActiType();
  },
  methods: {
    //立即报名
    immediateSign(id) {
      if (!sessionStorage.userInfo) {
        this.$message.error("请先登录");
        return;
      }
      this.api.post({
        url: `springcloud-park/activity/activityApply/quickApply?activityId=${id}`,
        data: {
          activityId: id
        },
        // dataFlag: false,
        urlFlag: true,
        callback: res => {
          if (res.code == "0000") {
            // _this.actiTypeList = res.data.rows;
            this.$message(res.result);
          }
        }
      });
    },
    handleTypeList() {
      this.showList = !this.showList;
    },
    handleFil(v) {
      //筛选
      this.typeId = v;
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
      this.$router.push({ path: "actiTrainDetail", query: { activityId: id } });
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
          typeId: this.typeId
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
  padding-top: 65px;
}
</style>


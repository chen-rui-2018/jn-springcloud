<template>
  <div class="serverCon w" v-loading="conloading">
    <div class="serverOrgMenu">
      <span class="pointer" @click="$router.push({path:'/serMatHp'})">首页</span>
      <span>/</span>
      <span class="mainColor agent">服务专员</span>
    </div>
    <div class="serverOrgNav mainBorder">
      <div class="nav1 clearfix" id="nav1">
        <div class="nav1Tit fl">业务领域：</div>
        <ul class="nav1Ul fl clearfix" style="width:auto;">
          <li :class="{'active1':filterFlag == ''}" @click="handleFilter('')">不限</li>
        </ul>
        <ul class="nav1Ul fl clearfix">
          <li class="wid1" v-for="(i,k) in businessArea" :key='k' @click="handleFilter(i.id)" :class="{'active1':filterFlag == i.id}">{{i.preValue}}</li>
        </ul>
        <div class="fr" v-if="widFun('wid1')">
          <i class="el-icon-arrow-down" v-if="flag1" @click="flag1=!flag1"></i>
          <i class="el-icon-arrow-up" v-else @click="flag1=!flag1"></i>
        </div>
      </div>
    </div>
    <div class="serverOrgFilter mainBorder clearfix">
      <div class="filLeft fl" id="filLeft">排序：
        <span @click="handleFil('integrate')" :class="{'active1':colorFlag == 'integrate'}">综合</span>
        <span @click="handleFil('popularity')" :class="{'active1':colorFlag == 'popularity'}">人气</span>
        <span @click="handleFil('praise')" :class="{'active1':colorFlag == 'praise'}">好评</span>
        <span @click="handleFil('serviceNum')" :class="{'active1':colorFlag == 'serviceNum'}">服务量</span>
      </div>
      <div class="filRight fr">
        <input type="text" placeholder="搜索关键字" v-model="keyWords">
        <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
      </div>
    </div>
    <div class="serverOrgContent">
      <div v-if="serverConList.length==0&&!conloading">
        <nodata></nodata>
      </div>
      <!-- <div v-else> -->
        <ul v-else>
          <!-- <li class="clearfix" v-for="(i,k) in serverAgent" :key='k'> -->
          <li class="clearfix" v-for="(i,k) in serverConList" :key='k'>
            <div class="conImg pointer fl" @click="handleConDel(i.orgId,i.advisorAccount)">
              <img v-if="i.avatar" :src="i.avatar" alt="">
              <img v-else src="@/../static/img/touxiang.png" alt="">
            </div>
            <div class="orgCon pointer fl" @click="handleConDel(i.orgId,i.advisorAccount)">
              <div class="conTil">{{i.advisorName}}</div>
              <div class="conContent clearfix color3">
                <div class="left1 fl" id="left1">
                  <p>所属机构：{{i.orgName}}
                  </p>
                  <p>业务擅长：{{i.goodAtBusiness}}</p>
                  <p>累计
                    <span class="mainColor">{{i.transactionNum}}</span>&nbsp;笔交易</p>
                </div>
                <div class="right1 fl">
                  <p>
                    <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                    </el-rate>
                    <span class="mainColor">{{i.evaluationNum}}</span>条评价</p>
                  <p>{{i.evaluationScore}}分</p>
                </div>
              </div>
            </div>
            <div class="orgBtn fr mainColor" @click="onlineContact(i.advisorAccount,i.advisorName)">在线联系</div>
          </li>
        </ul>
      <!-- </div> -->
    </div>
    <div class="pagination-container">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage1" :page-sizes="[3, 6, 9, 12]" :page-size="row" layout="total,prev, pager, next,sizes" :total="total">
      </el-pagination>
    </div>
    <template v-if="concatVisible">
      <el-dialog :visible.sync="concatVisible" width="530px" top="30vh" :modal-append-to-body=false :lock-scroll="false">
        <div class="loginTip">
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
import nodata from "../common/noData.vue";
export default {
  components: {
    nodata
  },
  data() {
    return {
      conloading: false,
      concatVisible: false,
      filterFlag: "",
      colorFlag: "integrate",
      flag1: true,
      businessArea: [],
      keyWords: "",
      serverConList: [],
      total: 0,
      row: 3,
      currentPage1: 1,
      page: 1,
      sortTypes: "integrate",
      domain: ""
    };
  },
  mounted() {
    // this.selectIndustryList();
    this.getIndustryForMarket();
    if (this.$route.query.searchData) {
      this.keyWords = this.$route.query.searchData;
      this.initList();
    } else {
      this.initList();
    }
  },
  methods: {
    goLogin() {
      window.sessionStorage.setItem("PresetRoute", this.$route.fullPath);
      this.$router.push({ path: "/login" });
    },
    onlineContact(advisorAccount, advisorName) {
      if (!this.getUserInfo()) {
        this.concatVisible = true;
        return;
      }
      this.$router.push({
        path: "/chat",
        query: {
          fromUser: JSON.parse(this.getUserInfo()).account,
          toUser: advisorAccount,
          nickName: advisorName
        }
      });
    },
    widFun(i) {
      let doc = document.getElementsByClassName(i);
      let num = 0;
      for (let it of doc) {
        num += it.offsetWidth * 1;
      }
      if (num >= 860) {
        return true;
      } else {
        return false;
      }
    },
    handleConDel(orgId, advisorAccount) {
      this.$router.push({
        path: "serverConDetail",
        query: { orgId: orgId, advisorAccount: advisorAccount }
      });
    },
    handleSearchList() {
      this.page = 1;
      this.initList();
    },
    handleFilter(i) {
      this.domain = i;
      this.filterFlag = i;
      this.initList();
    },
    handleFil(i) {
      this.colorFlag = i;
      this.sortTypes = i;
      this.page = 1;
      this.initList();
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.row = val;
      this.page = 1;
      this.initList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.initList();
    },
    initList() {
      this.conloading = true;
      let _this = this;
      this.api.get({
        url: "getServiceConList",
        data: {
          orgId: "",
          page: _this.page,
          rows: _this.row,
          keyWords: _this.keyWords,
          sortTypes: _this.sortTypes,
          domain: _this.domain
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverConList = res.data.rows;
            _this.total = res.data.total;
            for (let it in _this.serverConList) {
              _this.serverConList[it].integratedSort =
                _this.serverConList[it].integratedSort * 1;
            }
          } else {
            _this.$message.error(res.result);
          }
          _this.conloading = false;
        }
      });
    },
     getIndustryForMarket() {
      let _this = this;
      this.api.get({
        url: "getIndustryForMarket",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.businessArea = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
  }
};
</script>
<style lang="scss" scoped>
.serverCon {
  padding-top: 65px;
  .serverOrgFilter {
    #filLeft {
      .active1 {
        color: #00a041;
      }
    }
  }
  .serverOrgContent {
    .conImg {
      width: 120px;
      height: 128px;
      img {
        width: 100%;
        height: 100%;
        border-radius: 4px;
      }
    }
  }
}
</style>

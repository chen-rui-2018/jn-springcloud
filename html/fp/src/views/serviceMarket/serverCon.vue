<template>
    <div class="serverCon w">
        <div class="serverOrgMenu">
            <span class="pointer" @click="$routet.push({path:'/serMatHp'})">首页</span>
            <span>/</span>
            <span class="mainColor agent">服务顾问</span>
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
            <ul>
                <!-- <li class="clearfix" v-for="(i,k) in serverAgent" :key='k'> -->
                <li class="clearfix" v-for="(i,k) in serverConList" :key='k'>
                    <div class="orgImg fl" @click="handleConDel(i.orgId,i.advisorAccount)">
                        <!-- <img src="@/../static/img/ins1.png" alt=""> -->
                        <img :src="i.avatar" alt="">
                    </div>
                    <div class="orgCon fl">
                        <div class="conTil">{{i.advisorName}}</div>
                        <div class="conContent clearfix color3">
                            <div class="left1 fl" id="left1">
                                <p>所属机构：{{i.orgName}}
                                </p>
                                <p>业务擅长：{{i.goodAtBusiness}}</p>
                                <p>累计
                                    <span class="mainColor">{{i.transactionNum}}</span>笔交易</p>
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
                    <div class="orgBtn fr mainColor">在线联系</div>
                </li>
            </ul>
        </div>
        <div class="pagination-container">
            <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage1" :page-sizes="[3, 6, 9, 12]" :page-size="row" layout="total,prev, pager, next,sizes" :total="total">
            </el-pagination>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      filterFlag: "",
      colorFlag: "",
      flag1: true,
      businessArea: [],
      keyWords: "",
      serverConList:[],
      total:0,
      row:3,
      currentPage1:1,
      page:1,
      sortTypes:"",
      domain:"",
    };
  },
  mounted() {
    this.selectIndustryList();
    this.initList()
  },
  methods: {
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
    handleConDel(orgId,advisorAccount){
      this.$router.push({
        path: "serverConDetail",
        query: { orgId: orgId,advisorAccount:advisorAccount }
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
      let _this = this;
      this.api.get({
        url: "getServiceConList",
        data: {
          orgId: "",
          page: _this.page,
          rows: _this.row,
          keyWords: _this.keyWords,
          sortTypes: _this.sortTypes,
          domain:_this.domain,
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
        }
      });
    },
    selectIndustryList() {
      let _this = this;
      this.api.get({
        url: "selectTeamList",
        data: {
          id: "",
          preType: "",
          preValue: ""
        },
        callback: function(res) {
          if (res.code == "0000") {
            for (let it in res.data) {
              if (res.data[it].preType == "0") {
                _this.businessArea.push(res.data[it]);
              }
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
<style lang="scss" scoped>
.serverCon{
    padding-top:65px;
}
</style>

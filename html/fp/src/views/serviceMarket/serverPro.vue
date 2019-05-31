<template>
    <div class="serverPro w" style="padding-top:65px;">
        <div class="serverOrgMenu">
            <span class="pointer" @click="$router.push({path:'/serMatHp'})">首页</span>
            <span>/</span>
            <span class="mainColor agent">服务产品</span>
        </div>
        <div class="serverOrgNav mainBorder">
            <div class="nav1 clearfix" id="nav1">
                <div class="nav1Tit fl">业务领域：</div>
                <ul class="nav1Ul fl clearfix" style="width:auto;">
                    <li :class="{'active1':filterFlag == ''}" @click="handleFilter('')">不限</li>
                </ul>
                <ul class="nav1Ul fl clearfix" :class="{'sh':!flag1}">
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
                <!-- <span @click="handleFil('integrate')" :class="{'active2':colorFlag == 'integrate'}">综合</span> -->
                <span @click="handleFil('popularity')" :class="{'active2':colorFlag == 'popularity'}">人气</span>
                <span @click="handleFil('praise')" :class="{'active2':colorFlag == 'praise'}">好评</span>
                <span @click="handleFil('serviceNum')" :class="{'active2':colorFlag == 'serviceNum'}">服务量</span>
            </div>
            <div class="filMid fl">
                筛选：
                <span :class="{'activeA':filterFlag1 == '0'}" @click="handleSort('0')">常规服务</span>
                <span :class="{'activeA':filterFlag1 == '1'}" @click="handleSort('1')">特色服务</span>
            </div>
            <div class="filRight fr">
                <input type="text" placeholder="搜索关键字" v-model="keyWords">
                <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
            </div>
        </div>
        <div class="serverOrgContent">
            <ul>
                <!-- <li class="clearfix" v-for="(i,k) in serverAgent" :key='k'> -->
                <li class="clearfix" v-for="(i,k) in serverProList" :key='k'>
                    <div class="orgImg fl" @click="handleProDel(i.productId,i.signoryId)">
                        <!-- <img src="@/../static/img/ins1.png" alt=""> -->
                        <img :src="i.pictureUrl" alt="">
                    </div>
                    <div class="orgCon fl">
                        <div class="conTil">{{i.productName}}</div>
                        <div class="conContent clearfix color3">
                            <div class="left1 fl" id="left1">
                                <p>服务机构：{{i.orgName}}
                                </p>
                                <p>服务顾问：{{i.advisorName}}</p>
                                <p>参考价格
                                    <span class="mainColor">{{i.referPrice}}</span>元</p>
                                <p>累计
                                    <span class="mainColor">{{i.transactionsNumber}}</span>笔交易</p>
                            </div>
                            <div class="right1 fl">
                                <p>
                                    <!-- <el-rate disabled text-color="#00a041" score-template="{value}">
                                    </el-rate> -->
                                    <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                                  </el-rate>
                                    <span class="mainColor">{{i.evaluationNumber}}</span>条评价</p>
                            </div>
                        </div>
                    </div>
                    <div class="orgBtn fr mainColor" @click="demandRaise(i)">提需求</div>
                </li>
            </ul>
        </div>
        <div class="pagination-container">
            <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row" layout="total,prev, pager, next,sizes" :total="total">
            </el-pagination>
        </div>
        <!-- 提需求弹框 -->
        <template v-if="serverProVisible">
            <el-dialog :visible.sync="serverProVisible" width="530px" top="30vh" :modal-append-to-body=false>
                <el-form ref="financialProform" :model="serverProform" label-position="right" label-width="100px" style="max-width:436px;">
                    <el-form-item label="需求描述:" prop="requireDetail" style="font-size:13px">
                        <el-input v-model.trim="serverProform.requireDetail" class="demandTextArea" :rows="4" type="textarea" placeholder="可不填" maxlength="100" clearable/>
                    </el-form-item>
                </el-form>
                <div class="demandLine"></div>
                <div class="serverTip mainColor">市场提醒：请务必在线订购，线下交易无法享受市场交易安全保障</div>
                <div class="demandDia" @click="demandDia()">提交需求</div>
            </el-dialog>
        </template>
    </div>
</template>
<script>
export default {
  data() {
    return {
      colorFlag: "",
      bgFlag: "",
      sortTypes: "integrate",
      filterFlag: "",
      filterFlag1: "",
      flag1: true,
      keyW: "",
      currentPage1: 1,
      page: 1,
      row: 5,
      total: 0,
      signoryId: "",
      keyWords: "",
      productType: "",
      businessArea: [],
      serverProList: [],
      serverProform: {
        requireDetail: "",
        productId: "",
        productName: ""
      },
      serverProVisible: false
    };
  },
  mounted() {
    this.selectIndustryList();
    this.initList();
    if(this.$route.query.searchData){
      this.keyW=this.$route.query.searchData
      this.initList();
    }
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
    demandRaise(i) {
       if (!sessionStorage.userInfo) {
        this.$message.error("请先登录");
        return;
      }
      this.serverProVisible = true;
      this.serverProform.requireDetail = "";
      this.serverProform.productId = i.productId;
      this.serverProform.productName = i.productName;
    },
    demandDia() {
      let _this = this;
      this.api.post({
        url: "userDemand",
        data: {
          productId: _this.serverProform.productId,
          productName: _this.serverProform.productName,
          requireDetail: _this.serverProform.requireDetail
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.$message.success("提交需求成功");
            _this.serverProVisible = false;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    handleSort(i) {
      this.productType = i;
      this.filterFlag1 = i;
      this.initList();
    },
    //排序
    handleFil(i) {
      this.colorFlag = i;
      this.sortTypes = i;
      this.page = 1;
      this.initList();
    },
    handleFilter(i) {
      this.signoryId = i;
      this.filterFlag = i;
      this.initList();
    },
    handleProDel(productId, signoryId) {
      this.$router.push({
        path: "serverProDetail",
        query: { productId: productId, signoryId: signoryId }
      });
    },
    handleSearchList() {
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
      //服务产品列表
    initList() {
      let _this = this;
      this.api.get({
        url: "findProductList",
        data: {
          orgId: "",
          page: _this.page,
          signoryId: _this.signoryId,
          rows: _this.row,
          keyWords: _this.keyWords,
          sortTypes: _this.sortTypes,
          productType: _this.productType
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverProList = res.data.rows;
            _this.total = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    selectIndustryList() {
      let _this = this;
      this.api.get({
        url: "selectIndustryProductList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            // for (let it in res.data) {
            //   if (res.data[it].preType == "0") {
            //     _this.businessArea.push(res.data[it]);
            //   }
            // }
            _this.businessArea=res.data
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
.serverPro {
  .serverOrgNav {
    #nav1 {
      border: none;
    }
  }
  .serverOrgFilter {
      #filLeft{
          color:#797979;
          >span{
              color:#919191;
          }
          >span.active2{
            color: #00a041;
          }
      }
    .filMid {
      margin-top: 6px;
      margin-left: 40px;
      color:#919191;
      > span {
        display: inline-block;
        height: 28px;
        width: 100px;
        border-radius: 14px;
        margin-right: 10px;
        text-align: center;
        line-height: 26px;
        cursor: pointer;
      }
      > span.activeA {
        color: #fff;
        background: linear-gradient(to bottom right, #35bf6d, #00a041);
      }
    }
  }
  .serverOrgContent {
    .conTil {
      margin-bottom: 30px !important;
    }
  }
  .el-rate {
    margin-top: 20px;
  }
   .el-textarea__inner:focus {
    outline: 0;
    border-color: #00a041;
}
  .serverTip {
    display: inline-block;
    font-size: 12px;
  }
  .demandDia {
    display: inline-block;
    background: #ecfcf2;
    padding: 8px 10px;
    width: 80px;
    margin: 0 auto;
    border: 1px solid #00a041;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    color: #00a041;
    margin-left: 20px;
    font-size: 12px;
  }
  .demandLine {
    height: 1px;
    width: 530px;
    position: relative;
    left: -20px;
    background: #eee;
    margin-bottom: 20px;
    margin-top: 10px;
  }
  .el-form-item__content {
    margin-left: 100px;
  }
}
</style>

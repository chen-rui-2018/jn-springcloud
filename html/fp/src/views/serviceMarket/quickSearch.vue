<template>
    <div class="quickSearch w">
        <div class="serverOrgMenu color2">
            <span>企业服务/</span>
            <span>服务超市/</span>
            <span class="mainColor agent">财税服务</span>
        </div>
        <div class="agentInfo">
            <el-card>
                <div class="agent1 clearfix">
                    <div class="agentTil fl color1">财税服务</div>
                </div>
                <div class="agent2 clearfix color2">
                    <div class="agentMid1">
                        <div class="conproduct">常规产品:</div>
                        <ul class="proItem clearfix">
                            <li>代理记账</li>
                            <li>代理记账</li>
                            <li>代理记账</li>
                        </ul>
                    </div>
                    <div class="agentMid2">
                        <ul class="clearfix">
                            <li>
                                <div class="itemImg"><img src="@/../static/img/k1.png" alt=""></div>
                                <div class="itemInfo">
                                    <p>机构</p>
                                    <p class="mainColor">256家</p>
                                </div>
                            </li>
                            <li class="line"></li>
                            <li>
                                <div class="itemImg"><img src="@/../static/img/k2.png" alt=""></div>
                                <div class="itemInfo">
                                    <p>产品</p>
                                    <p class="mainColor">256家</p>
                                </div>
                            </li>
                            <li class="line"></li>
                            <li>
                                <div class="itemImg"><img src="@/../static/img/k3.png" alt=""></div>
                                <div class="itemInfo">
                                    <p>顾问</p>
                                    <p class="mainColor">256家</p>
                                </div>
                            </li>
                            <li class="line"></li>
                            <li>
                                <div class="itemImg"><img src="@/../static/img/k4.png" alt=""></div>
                                <div class="itemInfo">
                                    <p>评价</p>
                                    <p class="mainColor">256家</p>
                                </div>
                            </li>
                            <li class="line"></li>
                            <li>
                                <div class="itemImg"><img src="@/../static/img/k5.png" alt=""></div>
                                <div class="itemInfo">
                                    <p>交易量</p>
                                    <p class="mainColor">256家</p>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </el-card>
        </div>

        <div class="agentCon">
            <div class="serverOrgFilter mainBorder clearfix">
                <div class="filLeft fl" id="filLeft">排序：
                    <!-- <span @click="handleFil('')" :class="{'active':colorFlag == ''}">综合</span> -->
                    <span @click="handleFil('popularity')" :class="{'active':colorFlag == 'popularity'}">人气</span>
                    <!-- <span>好评</span> -->
                    <span @click="handleFil('serviceNum')" :class="{'active':colorFlag == 'serviceNum'}">服务量</span>
                </div>
                <div class="filMid fl">
                    筛选：
                    <span :class="{'active':filterFlag1 == '0'}" @click="handleSort('0')">常规服务</span>
                    <span :class="{'active':filterFlag1 == '1'}" @click="handleSort('1')">特色服务</span>
                </div>
                <div class="filRight fr">
                    <input type="text" placeholder="搜索关键字" v-model="keyWords">
                    <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
                </div>
            </div>
            <el-tabs v-model="activeName" @tab-click="handleClick">
                <el-tab-pane label="服务产品" name="serverPro" @click="handleSerpro">
                    <div class="serverPro">
                        <ul class="list-imgleft">
                            <li class="list-item pr" v-for="(i,k) in serverPro" :key='k'>
                                <!-- 上架时间 begin -->
                                <div class="list-item-date"></div>
                                <!-- 上架时间 end -->
                                <!-- 左侧logo begin-->
                                <div class="list-imgleft-container product nopic">
                                    <img :src="i.pictureUrl" alt="">
                                </div>
                                <!-- 左侧logo end-->
                                <!-- 中间信息 beign -->
                                <div class="list-info-middle inner-product">
                                    <!-- 中间上半部分--标题和标签 begin -->
                                    <div class="list-info-top-title">
                                        <!-- 头部 begin -->
                                        <div class="info-top">
                                            <div class="top-title inner-product">
                                                <span>{{i.productName}}</span>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- 中间上半部分--标题和标签 end -->
                                    <!-- 中间下半部分--参考信息、交易均价和交易 begin -->
                                    <div class="list-info-bottom-detail clearfix">
                                        <!-- 参考信息、交易均价 begin -->
                                        <div class="detail-contact inner-product">
                                            <div class="search_area text-of" title="王振英 , 包美芬 , 高凤清">顾&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;问：{{i.advisorName}}</div>
                                            <div class="text-of mt5">参考价格：{{i.referPrice}}</div>
                                            <div>累计
                                                <span class="mainColor">{{i.transactionsNumber}}</span>笔交易</div>
                                        </div>
                                        <!-- 参考信息、交易均价 end -->
                                        <!-- 评价 begin -->
                                        <div class="detail-evaluate inner-product">
                                            <div class="score">
                                                <el-rate v-model="i.evaluationScore*1" disabled text-color="#00a041" :colors="['#00a041', '#00a041', '#00a041']" style="display:inline-block" score-template="{value}">
                                                </el-rate>
                                                <span class="c_default b">{{i.evaluationNumber}}</span>
                                                <span>条评价</span>
                                            </div>
                                            <div class="links mt5">
                                                {{i.evaluationScore}}分
                                            </div>
                                        </div>
                                        <!-- 评价 end -->
                                        <!-- 交易量 begin -->
                                        <div class="detail-count">
                                            <div class="orgBtn fr mainColor">提需求</div>
                                        </div>
                                        <!-- 交易量 end -->
                                    </div>
                                    <!-- 中间上半部分--参考信息、交易均价和交易 end -->
                                </div>
                                <!-- 中间信息 end -->
                                <div class="clear"></div>
                            </li>
                        </ul>
                        <div class="pagination-container">
                            <el-pagination background @size-change="handleSizeChange1" @current-change="handleCurrentChange1" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row1" layout="total,prev, pager, next,sizes" :total="total1">
                            </el-pagination>
                        </div>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="服务机构" name="serverOrgContent" @click="handleSerorg">
                    <div class="serverOrgContent">
                        <ul class="list-imgleft">
                            <li class="clearfix" v-for="(i,k) in serverAgent" :key='k'>
                                <div class="orgImg mainBorder fl" @click="handleOrgDel(i.orgId)">
                                    <!-- <img src="@/../static/img/ins1.png" alt=""> -->
                                    <img :src="i.orgLogo" alt="">
                                </div>
                                <div class="orgCon fl">
                                    <div class="conTil">{{i.orgName}}</div>
                                    <div class="conContent clearfix color3">
                                        <div class="left1 fl">
                                            <p>电话：
                                                <span class="mainColor">{{i.orgPhone}}</span>
                                            </p>
                                            <p>地址：{{i.orgAddress}}</p>
                                            <p>累计
                                                <span class="mainColor">{{i.transactionNum}}</span>笔交易</p>
                                        </div>
                                        <div class="right1 fl">
                                            <p>
                                                <el-rate v-model="i.attitudeScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                                                </el-rate>
                                                <span class="mainColor">{{i.evaluationNum}}</span>条评价</p>
                                            <p>
                                                {{i.attitudeScore}}分
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="orgBtn fr mainColor">
                                    <a href="">在线联系</a>
                                </div>
                            </li>
                        </ul>
                        <div class="pagination-container">
                            <el-pagination background @size-change="handleSizeChange2" @current-change="handleCurrentChange2" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row2" layout="total,prev, pager, next,sizes" :total="total2">
                            </el-pagination>
                        </div>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="服务顾问" name="serConsultant" @click="handleSercon">
                    <div class="serverOrgContent">
                        <ul class="list-imgleft adviser">
                            <li class="clearfix" v-for="(i,k) in serviceConsultant" :key='k'>
                                <div class="orgImg mainBorder fl" @click="handleProDel()">
                                    <!-- <img src="@/../static/img/ins1.png" alt=""> -->
                                    <img :src="i.avatar" alt="">
                                </div>
                                <div class="orgCon fl">
                                    <div class="conTil">{{i.orgName}}</div>
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
                        <div class="pagination-container">
                            <el-pagination background @size-change="handleSizeChange3" @current-change="handleCurrentChange3" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row3" layout="total,prev, pager, next,sizes" :total="total3">
                            </el-pagination>
                        </div>
                    </div>
                </el-tab-pane>

            </el-tabs>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      activeName: "serverPro",
      serverOrgDetailList: {},
      colorFlag: "",
      filterFlag1: "",
      keyWords: "",
      serverPro: [
        // {
        //   serviceTotal: "",
        //   commonTotal: "",
        //   featureTotal
        // }
      ],
      currentPage1: 1,
      row1: 5,
      page1: 1,
      total1: 0,
      serviceConsultant: [],
      row2: 5,
      page2: 1,
      total2: 0,
      serverActiList: [],
      row3: 5,
      page3: 1,
      total3: 0,
      serverAgent: [],
      evaCount: {}
    };
  },
  mounted() {
    // this.initList();
    // this.findOrgCountProductList();
    this.findProductList();
    this.selectServiceOrgList();
    this.getServiceConList();
  },
  methods: {
    handleFil(i) {
      this.colorFlag = i;
      this.sortTypes = i;
      this.page = 1;
      this.findProductList();
    },
    handleSort(i) {
      this.productType = i;
      this.filterFlag1 = i;
      this.findProductList();
    },
    handleSearchList() {
      this.page = 1;
      this.findProductList();
    },
    handleSerpro() {
      this.findProductList();
    },
    handleSercon() {
      this.getServiceConList();
    },
    handleSerorg() {
      this.selectServiceOrgList();
    },
    handleSizeChange1(val) {
      //改变每页显示多少条的回调函数
      this.row1 = val;
      this.page1 = 1;
      this.findProductList();
    },
    handleCurrentChange1(val) {
      //改变当前页码的回调函数
      this.page1 = val;
      this.findProductList();
    },
    handleSizeChange2(val) {
      //改变每页显示多少条的回调函数
      this.row2 = val;
      this.page2 = 1;
      this.selectServiceOrgList();
    },
    handleCurrentChange2(val) {
      //改变当前页码的回调函数
      this.page2 = val;
      this.selectServiceOrgList();
    },
    handleSizeChange3(val) {
      //改变每页显示多少条的回调函数
      this.row3 = val;
      this.page3 = 1;
      this.getServiceConList();
    },
    handleCurrentChange3(val) {
      //改变当前页码的回调函数
      this.page3 = val;
      this.getServiceConList();
    },
    handleClick(tab, event) {
      // console.log(tab, event);
    },
    getServiceConList() {
      //服务顾问
      let _this = this;
      this.api.get({
        url: "getServiceConList",
        data: {
          // orgId: _this.$route.query.orgId,
          //   orgId: "1001211",
          page: _this.page3,
          rows: _this.row3
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.serviceConsultant = res.data.rows;
            _this.total3 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    findProductList() {
      //服务产品
      let _this = this;
      this.api.get({
        url: "findProductList",
        data: {
          orgId: "",
          page: _this.page1,
          signoryId: "",
          rows: _this.row1,
          keyWords: _this.keyWords,
          sortTypes: _this.sortTypes,
          productType: _this.productType
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.serverPro = res.data.rows;
            _this.total1 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    selectServiceOrgList() {
      //服务机构
      let _this = this;
      let data = {
        // businessType: _this.businessType,
        // industrySector: _this.industrySector,
        // developmentStage: _this.developmentStage,
        // companyNature: _this.companyNature,
        page: _this.page2,
        rows: _this.row2
        // sortTypes: _this.sortTypes,
        // orgName: _this.keyW
      };
      console.log(data);
      this.api.get({
        url: "selectServiceOrgList",
        data: data,
        dataFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverAgent = res.data.rows;
            for (let it in _this.serverAgent) {
              _this.serverAgent[it].attitudeScore =
                _this.serverAgent[it].attitudeScore * 1;
            }
            _this.total2 = res.data.total;
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
.quickSearch {
  .serverPro,
  .serverOrgContent,
  .serConsultant {
    .pagination-container {
      margin-top: 30px;
    }
  }
  .agentInfo {
    .agent2 {
      .agentMid1 {
        padding-bottom: 20px;
        .conproduct {
          display: inline-block;
          width: auto;
          vertical-align: middle;
        }
        .proItem {
          display: inline-block;
          vertical-align: middle;
          > li {
            float: left;
            margin: 0 20px;
          }
        }
      }
      .agentMid2 {
        > ul {
          > li {
            float: left;
            padding: 0 60px;
            // border-right:1px solid #eee;
            > .itemImg {
              display: inline-block;
              vertical-align: middle;
              width: 48px;
              height: 48px;
              margin-right: 10px;
              > img {
                width: 100%;
                height: 100%;
              }
            }
            .itemInfo {
              display: inline-block;
              vertical-align: middle;
              > p {
                color: #333;
              }
              > p:nth-child(2) {
                margin-top: 5px;
                color: #00a041;
              }
            }
          }
          .line {
            height: 34px;
            width: 1px;
            padding: 0;
            background: #eee;
            margin-top: 8px;
          }
        }
      }
    }
  }
  .agentCon {
    margin-top: 30px;
    .serverOrgFilter {
      #filLeft {
        color: #797979;
        > span {
          color: #919191;
        }
        >span.active{
            color:#00a041;
        }
      }
      .filMid {
        margin-top: 6px;
        margin-left: 40px;
        color: #919191;
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
        > span.active {
          color: #fff;
          background: linear-gradient(to bottom right, #35bf6d, #00a041);
        }
      }
    }
  }
}
</style>

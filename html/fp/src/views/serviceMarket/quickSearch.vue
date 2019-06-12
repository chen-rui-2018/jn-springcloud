<template>
  <div class="quickSearch w">
    <div class="serverOrgMenu color2">
      <span class="pointer" @click="$router.push({path:'/enterpriseservice'})">企业服务/</span>
      <span class="pointer" @click="$router.push({path:'/serMatHp'})">服务超市/</span>
      <span class="mainColor agent">{{$route.query.preValue}}</span>
    </div>
    <div class="agentInfo">
      <el-card>
        <div class="agent1 clearfix">
          <div class="agentTil fl color1">{{$route.query.preValue}}</div>
        </div>
        <div class="agent2 clearfix color2">
          <div class="agentMid1">
            <div class="conproduct">常规产品:</div>
            <ul class="proItem clearfix">
              <li v-for="(i,k) in commentList" :key="k">{{i.productName}}</li>
            </ul>
          </div>
          <div class="agentMid2">
            <ul class="clearfix">
              <li>
                <div class="itemImg"><img src="@/../static/img/k1.png" alt=""></div>
                <div class="itemInfo">
                  <p>机构</p>
                  <p class="mainColor">{{businessAreaNum.orgNum}}家</p>
                </div>
              </li>
              <li class="line"></li>
              <li>
                <div class="itemImg"><img src="@/../static/img/k2.png" alt=""></div>
                <div class="itemInfo">
                  <p>产品</p>
                  <p class="mainColor">{{businessAreaNum.productNum}}家</p>
                </div>
              </li>
              <li class="line"></li>
              <li>
                <div class="itemImg"><img src="@/../static/img/k3.png" alt=""></div>
                <div class="itemInfo">
                  <p>专员</p>
                  <p class="mainColor">{{businessAreaNum.advisorNum}}家</p>
                </div>
              </li>
              <li class="line"></li>
              <li>
                <div class="itemImg"><img src="@/../static/img/k4.png" alt=""></div>
                <div class="itemInfo">
                  <p>评价</p>
                  <p class="mainColor">{{businessAreaNum.evaluateNum}}家</p>
                </div>
              </li>
              <li class="line"></li>
              <li>
                <div class="itemImg"><img src="@/../static/img/k5.png" alt=""></div>
                <div class="itemInfo">
                  <p>交易量</p>
                  <p class="mainColor">{{businessAreaNum.transactionNum}}家</p>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </el-card>
    </div>

    <div class="agentCon">
      <div class="serverOrgFilter mainBorder clearfix" v-if="flag1">
        <div class="filLeft fl" id="filLeft">排序：
          <!-- <span @click="handleFil('')" :class="{'active':colorFlag == ''}">综合</span> -->
          <span @click="handleFil('popularity')" :class="{'active2':colorFlag == 'popularity'}">人气</span>
          <!-- <span>好评</span> -->
          <span @click="handleFil('serviceNum')" :class="{'active2':colorFlag == 'serviceNum'}">服务量</span>
        </div>
        <div class="filMid fl">
          筛选：
          <span :class="{'active2':filterFlag1 == '0'}" @click="handleSort('0')">常规服务</span>
          <span :class="{'active2':filterFlag1 == '1'}" @click="handleSort('1')">特色服务</span>
        </div>
        <div class="filRight fr">
          <input type="text" placeholder="搜索关键字" v-model="keyWords">
          <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
        </div>
      </div>
      <div class="serverOrgFilter mainBorder clearfix" v-if="flag2">
        <div class="filLeft fl" id="filLeft">排序：
          <span @click="handleFil1('')" :class="{'active2':colorFlag1 == ''}">综合</span>
          <span @click="handleFil1('popularity')" :class="{'active2':colorFlag1 == 'popularity'}">人气</span>
          <span @click="handleFil1('attitudeScore')" :class="{'active2':colorFlag1 == 'attitudeScore'}">好评</span>
          <span @click="handleFil1('serviceNum')" :class="{'active2':colorFlag1 == 'serviceNum'}">服务量</span>
        </div>
        <div class="filRight fr">
          <input type="text" placeholder="搜索关键字" v-model="keyWords">
          <i class="iconfont icon-sousuo" @click="handleSearchList1"></i>
        </div>
      </div>
      <div class="serverOrgFilter mainBorder clearfix" v-if="flag3">
        <div class="filLeft fl" id="filLeft">排序：
          <span @click="handleFil2('integrate')" :class="{'active2':colorFlag2 == 'integrate'}">综合</span>
          <span @click="handleFil2('popularity')" :class="{'active2':colorFlag2 == 'popularity'}">人气</span>
          <span @click="handleFil2('praise')" :class="{'active2':colorFlag2 == 'praise'}">好评</span>
          <span @click="handleFil2('serviceNum')" :class="{'active2':colorFlag2 == 'serviceNum'}">服务量</span>
        </div>
        <div class="filRight fr">
          <input type="text" placeholder="搜索关键字" v-model="keyWords">
          <i class="iconfont icon-sousuo" @click="handleSearchList2"></i>
        </div>
      </div>
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="服务产品" name="serverPro">
          <div class="serverPro">
            <ul class="list-imgleft">
              <li class="list-item pr" v-for="(i,k) in serverPro" :key='k'>
                <!-- 上架时间 begin -->
                <div class="list-item-date"></div>
                <!-- 上架时间 end -->
                <!-- 左侧logo begin-->
                <div class="list-imgleft-container product nopic pointer" @click="$router.push({path:'serverProDetail',query:{productId:i.productId,signoryId:i.signoryId}})">
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
                      <div class="orgBtn fr mainColor" @click="demandRaise(i)">提需求</div>
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
        <el-tab-pane label="服务机构" name="serverOrgContent">
          <div class="serverOrgContent">
            <ul class="list-imgleft">
              <li class="clearfix" v-for="(i,k) in serverAgent" :key='k'>
                <div class="orgImg mainBorder fl pointer" @click="$router.push({ path: '/serverOrgDetail', query: { orgId: i.orgId } })">
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
                  <a href="javascript:;" @click="onlineContact(i.orgAccount,i.orgName)">在线联系</a>
                </div>
              </li>
            </ul>
            <div class="pagination-container">
              <el-pagination background @size-change="handleSizeChange2" @current-change="handleCurrentChange2" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row2" layout="total,prev, pager, next,sizes" :total="total2">
              </el-pagination>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane label="服务专员" name="serConsultant">
          <div class="serverOrgContent">
            <ul class="list-imgleft adviser">
              <li class="clearfix" v-for="(i,k) in serviceConsultant" :key='k'>
                <div class="orgImg mainBorder fl pointer" @click="$router.push({path:'serverConDetail',query:{orgId: i.orgId,advisorAccount:i.advisorAccount}})">
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
                <div class="orgBtn fr mainColor pointer" @click="onlineContact(i.advisorAccount,i.advisorName)">在线联系</div>
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
    <!-- 提需求弹框 -->
    <template v-if="proVisible">
      <el-dialog :visible.sync="proVisible" width="530px" top="30vh" :modal-append-to-body="false" :lock-scroll="false">
        <div v-if="islogin">
          <el-form ref="financialProform" :model="serverProform" label-position="right" label-width="100px" style="max-width:436px;">
            <el-form-item label="需求描述:" prop="requireDetail" style="font-size:13px">
              <el-input v-model.trim="serverProform.requireDetail" class="demandTextArea" :rows="4" type="textarea" placeholder="可不填" maxlength="100" clearable/>
            </el-form-item>
          </el-form>
          <div class="demandLine"></div>
          <div class="serverTip mainColor">市场提醒：请务必在线订购，线下交易无法享受市场交易安全保障</div>
          <div class="demandDia" @click="demandDia()">提交需求</div>
        </div>
        <div v-else class="loginTip">
          你还未
          <span class="mainColor pointer" @click="$router.push({path:'/login'})">登录</span>
          /
          <span class="mainColor pointer" @click="$router.push({path:'/register'})">注册</span>
          企业账号
        </div>
      </el-dialog>
    </template>
    <template v-if="concatVisible">
      <el-dialog :visible.sync="concatVisible" width="530px" top="30vh" :modal-append-to-body="false" :lock-scroll="false">
        <div class="loginTip">
          你还未
          <span class="mainColor pointer" @click="$router.push({path:'/login'})">登录</span>
          /
          <span class="mainColor pointer" @click="$router.push({path:'/register'})">注册</span>
          账号
        </div>
      </el-dialog>
    </template>
  </div>
</template>
<script>
export default {
  data() {
    return {
      islogin: true,
      concatVisible: false,
      proVisible: false,
      serverProform: {
        requireDetail: "",
        productId: "",
        productName: ""
      },
      flag1: true,
      flag2: false,
      flag3: false,
      activeName: "serverPro",
      serverOrgDetailList: {},
      colorFlag: "",
      colorFlag1: "",
      colorFlag2: "integrate",
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
      evaCount: {},
      businessAreaNum: {},
      commentList: {}
    };
  },
  mounted() {
    // this.initList();
    // this.findOrgCountProductList();
    this.findProductList();
    // this.selectServiceOrgList();
    // this.getServiceConList();
    this.selectBusinessAreaNum();
    this.commentProductList();
  },
  methods: {
    //判断是否登录
    isLogin() {
      if (!sessionStorage.userInfo) {
        this.islogin = false;
      }
    },
    onlineContact(advisorAccount, advisorName) {
      if (!sessionStorage.userInfo) {
        this.concatVisible = true;
        return
      }
      this.$router.push({
        path: "/chat",
        query: {
          fromUser: JSON.parse(sessionStorage.userInfo).account,
          toUser: advisorAccount,
          nickName: advisorName
        }
      });
    },
    demandRaise(i) {
      this.isLogin();
      this.proVisible = true;
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
            _this.proVisible = false;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    handleClick(tab, event) {
      if (tab.name == "serverOrgContent") {
        (this.flag2 = true), (this.flag1 = false);
        this.flag3 = false;
        this.selectServiceOrgList();
      } else if (tab.name == "serConsultant") {
        this.flag3 = true;
        this.flag1 = false;
        this.flag2 = false;
        this.getServiceConList();
      } else {
        this.flag1 = true;
        this.flag2 = false;
        this.flag3 = false;
        this.findProductList();
      }
    },
    handleFil(i) {
      this.colorFlag = i;
      this.sortTypes = i;
      this.page = 1;
      this.findProductList();
    },
    handleFil1(i) {
      this.colorFlag1 = i;
      this.sortTypes = i;
      this.page = 1;
      this.selectServiceOrgList();
    },
    handleFil2(i) {
      this.colorFlag2 = i;
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
      this.page1 = 1;
      this.findProductList();
    },
    handleSearchList1() {
      this.page2 = 1;
      this.selectServiceOrgList();
    },
    handleSearchList2() {
      this.page3 = 1;
      this.getServiceConList();
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
    selectBusinessAreaNum() {
      //根据业务领域查询服务超市统计数据
      let _this = this;
      this.api.get({
        url: "selectBusinessAreaNum",
        data: {
          // orgId: _this.$route.query.orgId,
          //   orgId: "1001211",
          businessType: _this.$route.query.signoryId,
          productId: ""
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.businessAreaNum = res.data;
            // _this.total3 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    getServiceConList() {
      //服务专员
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
          signoryId: _this.$route.query.signoryId,
          rows: _this.row1,
          keyWords: _this.keyWords,
          sortTypes: _this.sortTypes,
          productType: _this.productType
        },
        callback: function(res) {
          if (res.code == "0000") {
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
    },
    //常规产品
    commentProductList() {
      let _this = this;
      this.api.get({
        url: "findProductList",
        data: {
          signoryId: _this.$route.query.signoryId,
          productType: "0"
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.commentList = res.data.rows;
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
            // padding: 0 60px;
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
            margin: 0 80px;
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
        > span.active {
          color: #00a041;
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
}
</style>

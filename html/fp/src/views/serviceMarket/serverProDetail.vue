<template>
    <div class="serverProDetail w">
        <div class="serverOrgMenu">
            <span class="pointer" @click="$routet.push({path:'/serMatHp'})">首页/</span>
            <span class="pointer" @click="$routet.push({path:'/serverPro'})">服务产品</span>
            <span>/</span>
            <span class="mainColor agent">服务产品详情</span>
        </div>
        <div class="agentInfo">
            <el-card>
                <div class="agent1 clearfix">
                    <div class="agentTil fl">{{proDelInfo.productName}}</div>
                    <div class="orgBtn fr mainColor" @click="demandRaise('')">提需求</div>
                </div>
                <div class="agent2 clearfix color2">
                    <div class="agentImg fl">
                        <!-- <img src="@/../static/img/ins1.png" alt=""> -->
                        <img :src="proDelInfo.pictureUrl" alt="">
                    </div>
                    <div class="agent2Info fl">
                        <p>服务机构：{{proDelInfo.orgName}}</p>
                        <p>服务顾问：{{proDelInfo.advisorName}}</p>
                        <p>参考价格：
                            <span class="mainColor">{{proDelInfo.referPrice}}</span>元
                        </p>
                        <p>服务周期：{{proDelInfo.serviceCycle}}</p>
                        <p class="proNum">产品编号：
                            <span class="mainColor">{{proDelInfo.serialNumber}}</span>
                        </p>
                        <p class="lastP color3">
                            <span>交易量：{{proDelInfo.transactionsNumber}}</span>
                            <span>浏览：{{proDelInfo.viewCount}}</span>
                            <span>服务评分：{{proDelInfo.evaluationScore}}</span>
                        </p>
                    </div>
                </div>
            </el-card>
        </div>
        <div class="proDel">
            <div class="agentDelTit">产品详情</div>
            <div class="agentDelCon pr">
                <el-card>
                    <div class="agent1 clearfix">
                        <div class="agentTil mainColor fl">服务内容</div>
                        <div class="orgBtn fr mainColor">
                            <div class="mainColor shouqi pointer" v-if="zankaiFlag" @click='zankaiFlag=!zankaiFlag'>
                                收起
                                <i class="el-icon-arrow-up"></i>
                            </div>
                            <div class="mainColor shouqi zhankai pointer" v-else @click='zankaiFlag=!zankaiFlag'>
                                <i class="el-icon-arrow-down"></i>
                            </div>
                        </div>
                    </div>
                    <div class="agent2 color2" v-if="zankaiFlag">
                        <div class="agent2Con" id="agent2Con" :class="{'showMore':showMoreFlag}">
                            {{proDelInfo.productDetails}}
                        </div>
                        <!-- <div class="agent2Con" v-if="proDelInfo.productDetails">
                            {{proDelInfo.productDetails}}
                        </div>
                        <div class="agent2Con" v-else>
                            暂无内容！
                        </div> -->
                        <div class="orgBtn1 mainColor tx pointer" v-if="showMoreFlag" @click="showMoreFlag=false">查看更多</div>
                    </div>
                </el-card>
            </div>
        </div>
        <div class="agentCon">
            <div class="agentFil mainBorder">
                <ul class="select-list clearfix" v-if="showFlag">
                    <li>
                        <a href="javascript:;">筛选：</a>
                    </li>
                    <li class="list-item current" :class="{'active3':flag1==''}" @click="screenPro('')">
                        <a href="javascript:;" data="%">全部({{proDelInfo.sameTypeNum}})</a>
                    </li>
                    <li class="list-item " :class="{'active3':flag1=='0'}" @click="screenPro('0')">
                        <a href="javascript:;" data="常规服务">常规服务({{proDelInfo.commentNum}})</a>
                    </li>
                    <li class="list-item " :class="{'active3':flag1=='1'}" @click="screenPro('1')">
                        <a href="javascript:;" data="特色服务">特色服务({{proDelInfo.featureNum}})</a>
                    </li>
                </ul>
                <ul class="select-list clearfix" v-else>
                    <li>
                        <a href="javascript:;">筛选：</a>
                    </li>
                    <li class="list-item current" :class="{'active3':flag2==''}" @click="handleEvaluation('')">
                        <a href="javascript:;" data="%">全部({{evaCount.evaluationTotal}})</a>
                    </li>
                    <li class="list-item " :class="{'active3':flag2=='praise'}" @click="handleEvaluation('praise')">
                        <a href="javascript:;" data="好评">好评({{evaCount.praiseNum}})</a>
                    </li>
                    <li class="list-item " :class="{'active3':flag2=='average'}" @click="handleEvaluation('average')">
                        <a href="javascript:;" data="中评">中评({{evaCount.averageNum}})</a>
                    </li>
                    <li class="list-item" :class="{'active3':flag2=='badReview'}" @click="handleEvaluation('badReview')">
                        <a href="javascript:;" data="差评">差评({{evaCount.badReviewNum}})</a>
                    </li>
                </ul>
            </div>
            <el-tabs v-model="activeName1" @tab-click="handleClick">
                <el-tab-pane name="samePro">
                    <span slot="label">同类产品({{total1}})</span>
                    <div class="serverPro">
                        <ul class="list-imgleft">
                            <li class="list-item pr" v-for="(i,k) in sameTypeProList" :key='k'>
                                <!-- 上架时间 begin -->
                                <div class="list-item-date"></div>
                                <!-- 上架时间 end -->
                                <!-- 左侧logo begin-->
                                <div class="list-imgleft-container product nopic pointer" @click="$router.push({path: 'serverProDetail',query: { productId: i.productId, signoryId: i.signoryId }})">
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
                                            <div class="search_area text-of">服务机构：{{i.orgName}}</div>
                                            <div class="text-of mt5">服务顾问：{{i.advisorName }}</div>
                                            <div class="text-of mt5">参考价格：{{i.referPrice}}元</div>
                                            <div>累计
                                                <span class="mainColor">{{i.transactionsNumber}}</span>笔交易</div>
                                        </div>
                                        <!-- 参考信息、交易均价 end -->
                                        <!-- 评价 begin -->
                                        <div class="detail-evaluate inner-product">
                                            <div class="score">
                                                <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                                                </el-rate>
                                                <span class="c_default b">{{i.evaluationNumber}}</span>
                                                <span>条评价</span>
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
                            <el-pagination background @size-change="handleSizeChange1" @current-change="handleCurrentChange1" :current-page="currentPage1" :page-sizes="[3, 6, 9, 12]" :page-size="row1" layout="total,prev, pager, next,sizes" :total="total1">
                            </el-pagination>
                        </div>
                    </div>
                </el-tab-pane>
                <el-tab-pane name="relateEva">
                    <span slot="label">相关评价({{total4}})</span>
                    <div class="serEvaluation">
                        <ul class="list-imgleft">
                            <li class="list-item pr" v-for="(i,k) in serviceRatingList" :key='k'>
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
                                            <div class="search_area text-of" title="王振英 , 包美芬 , 高凤清">服务顾问：{{i.advisorName}}</div>
                                            <!-- <div class="text-of mt5">参考价格：1000-10000元</div> -->
                                            <span class="evaluate-container">
                                                <span class="arrow-container">{{i.evaluationDesc}}</span>
                                            </span>
                                        </div>
                                        <!-- 参考信息、交易均价 end -->
                                        <!-- 评价 begin -->
                                        <div class="detail-evaluate inner-product">
                                            <div class="score">
                                                <el-rate :model="parseInt(i.evaluationScore)" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                                                </el-rate>
                                                <span class="c_default b">1</span>
                                                <span>条评价</span>
                                            </div>
                                            <div class="links mt5">
                                                {{i.evaluationScore}}分
                                            </div>
                                        </div>
                                        <!-- 评价 end -->
                                        <!-- 交易量 begin -->
                                        <div class="detail-count" clearfix>
                                            <div class="list-item-info fr">
                                                <p>{{i.evaluationAccount}}</p>
                                                <p>{{i.evaluationTime}}</p>
                                            </div>
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
                            <el-pagination background @size-change="handleSizeChange4" @current-change="handleCurrentChange4" :current-page="currentPage1" :page-sizes="[3, 6, 9, 12]" :page-size="row4" layout="total,prev, pager, next,sizes" :total="total4">
                            </el-pagination>
                        </div>
                    </div>
                </el-tab-pane>
            </el-tabs>
        </div>
        <!-- 提需求弹框 -->
        <template v-if="serverProVisible">
            <el-dialog :visible.sync="serverProVisible" width="530px" top="30vh">
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
      showMoreFlag:false,
      zankaiFlag: true,
      activeName1: "samePro",
      currentPage1: 1,
      total1: 0,
      row1: 3,
      page1: 1,
      total4: 0,
      row4: 3,
      page4: 1,
      proDelInfo: {},
      sameTypeProList: [],
      serviceRatingList: [],
      serverProVisible:false,
      serverProform: {
        requireDetail: "",
        productId: "",
        productName: ""
      },
      showFlag:true,
      flag1:'',
      flag2:'',
      ratingType:'',
      productType:'',
      evaCount:{},
    };
  },
  mounted() {
    this.findProductDetails();
    this.sameTypeProductList();
    this.getServiceRatingInfo();
    this.getEvaluationCountInfo()
  },
  methods: {
    screenPro(i){
        this.productType=i,
        this.flag1=i,
        this.page1=1,
        this.sameTypeProductList();
    },
    handleEvaluation(i){
        this.ratingType=i,
        this.flag4=i,
        this.page4=1,
        this.getServiceRatingInfo();
    },
    demandRaise(i) {
      this.serverProVisible = true;
      if(i==''){
       this.serverProform.productId = proDelInfo.productId;
       this.serverProform.productName = proDelInfo.productName;
      } else{
         this.serverProform.productId = i.productId;
        this.serverProform.productName = i.productName;
      }
     
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
            if(_this.serverProform.requireDetail==''){
                // _this.$message.error("您还没填写需求");
                _this.serverProVisible = false;
                return
              } else{
               _this.$message.success("提交需求成功");
               _this.serverProVisible = false;
              }
            
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    handleClick(tab, event) {
      if(tab.name=='relateEva'){
        this.showFlag=false
        this.getServiceRatingInfo();
        this.getEvaluationCountInfo()
      } else{
        this.showFlag=true;
        this.sameTypeProductList();
      }
    },
    handleSizeChange1(val) {
      //改变每页显示多少条的回调函数
      this.row1 = val;
      this.page1 = 1;
      this.sameTypeProductList();
    },
    handleCurrentChange1(val) {
      //改变当前页码的回调函数
      this.page1 = val;
      this.sameTypeProductList();
    },
    handleSizeChange4(val) {
      //改变每页显示多少条的回调函数
      this.row4 = val;
      this.page4 = 1;
      this.getServiceRatingInfo();
    },
    handleCurrentChange4(val) {
      //改变当前页码的回调函数
      this.page4 = val;
      this.getServiceRatingInfo();
    },
    getEvaluationCountInfo() {
      //服务评价统计信息
      let _this = this;
      this.api.get({
        url: "getEvaluationCountInfo",
        data: {
          productId: _this.$route.query.productId,
          needPage: 1,
          isPublicPage: 0,
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.EvaluationCountInfo = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    getServiceRatingInfo() {
      //服务评价
      let _this = this;
      this.api.get({
        url: "getServiceRatingInfo",
        data: {
          productId: _this.$route.query.productId,
          needPage: 1,
          isPublicPage: 0,
          page: _this.page4,
          rows: _this.row4
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serviceRatingList = res.data.rows;
            _this.total4 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
       getEvaluationCountInfo() {
      //服务评价统计信息
      let _this = this;
      this.api.get({
        url: "getEvaluationCountInfo",
        data: {
          productId: _this.$route.query.productId,
          // orgId: "1001211",
          needPage: 1,
          isPublicPage: 0,
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.evaCount = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    sameTypeProductList() {
      //同类产品
      let _this = this;
      this.api.get({
        url: "sameTypeProductList",
        data: {
          signoryId: _this.$route.query.signoryId,
          page:_this.page1,
          rows:_this.row1,
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.sameTypeProList = res.data.rows;
            _this.total1 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    findProductDetails() {
      //服务产品详情
    //   let _this = this;
      this.api.get({
        url: "findProductDetails",
        data: {
          productId: this.$route.query.productId
        },
        callback: (res)=>{
          if (res.code == "0000") {
            this.proDelInfo = res.data.info;
            // console.log(document.getElementById('agent2Con').clientHeight)
            // console.log(window.getComputedStyle(document.getElementById('agent2Con')).height)
            setTimeout(()=>{
             if(document.getElementById('agent2Con').clientHeight>=50){
                 debugger
                 this.showMoreFlag=true;
             }
            },0)
          } else {
            this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.serverProDetail {
  .pagination-container {
    margin-top: 50px;
    margin-bottom: 0;
  }
  .agentInfo {
    .lastP {
      margin-top: 0 !important;
    }
    .agent2Info {
      > p {
        margin-bottom: 5px !important;
      }
      .proNum {
        margin-top: 20px;
        margin-bottom: 0 !important;
      }
    }
  }
  .proDel {
    .agentDelTit {
      padding: 20px 0;
    }
    .agentDelCon {
      .el-card__body {
        padding: 20px 30px;
      }
      .agent1 {
        padding: 10px 0;
        border-bottom: 1px solid #eee;
      }
      .agent2 {
        padding: 10px 0;
        .agent2Con {
          transition: .2s all;
        }
        .agent2Con.showMore {
          height: 50px;
          overflow: hidden;
        //   overflow: hidden;
        }
        .orgBtn1 {
          font-size: 13px;
          background: #ecfcf2;
          padding: 6px 20px;
          width: 60px;
          margin: 0 auto;
          border: 1px solid #00a041;
          border-radius: 4px;
          margin-top: 20px;
          cursor: pointer;
        }
      }
    }
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

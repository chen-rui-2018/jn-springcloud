<template>
    <div class="serverConDetail w">
        <div class="serverOrgMenu color2">
            <span class="pointer" @click="$router.push({path:'/serMatHp'})">首页/</span>
            <span class="pointer" @click="$router.push({path:'/serverCon'})">服务顾问</span>
            <span>/</span>
            <span class="mainColor agent">服务顾问详情</span>
        </div>
        <div class="agentInfo">
            <el-card v-if="serverConDetailList">
                <div class="agent1 clearfix">
                    <div class="agentTil fl color1">{{serverConDetailList.advisorIntroduction.advisorName}}</div>
                    <div class="orgBtn fr mainColor" @click="onlineContact(serverConDetailList.advisorServiceInfo.advisorAccount,serverConDetailList.advisorServiceInfo.advisorName)">在线联系</div>
                </div>
                <div class="agent2 clearfix color2">
                    <div class="agentImg fl">
                        <img :src="serverConDetailList.advisorIntroduction.avatar" alt="">
                    </div>
                    <div class="agent2Info fl color2">
                        <p>所属机构：{{serverConDetailList.advisorIntroduction.orgName}}</p>
                        <p>从业年限：{{serverConDetailList.advisorIntroduction.workingYears}}</p>
                        <p>执业资质：{{serverConDetailList.advisorIntroduction.practiceQualification}}</p>
                        <p>业务擅长：{{serverConDetailList.advisorIntroduction.goodAtBusiness}}</p>
                        <p class="lastP color3">
                            <span>交易量：{{serverConDetailList.advisorIntroduction.transactionNum}}</span>
                            <span>浏览：{{serverConDetailList.advisorIntroduction.pageViews}}</span>
                            <span>服务评分：{{serverConDetailList.advisorIntroduction.evaluationScore}}</span>
                        </p>
                    </div>
                </div>
            </el-card>
        </div>
        <div class="agentDel">
            <div class="agentDelTit">机构详情</div>
            <div class="agentDelCon pr color1">
                <div class="mainColor shouqi pointer" v-if="zankaiFlag" @click='handleZd'>
                    收起
                    <i class="el-icon-arrow-up"></i>
                </div>
                <div class="mainColor shouqi zhankai pointer" v-else @click='handleZk'>
                    <i class="el-icon-arrow-down"></i>
                </div>
                <el-card>
                    <el-tabs v-model="activeName" @tab-click="handleClick">
                        <el-tab-pane label="基本信息" name="baseInfo">
                            <div class="basicInfo" v-if="zankaiFlag">
                                <table class="table-orgspace mainBorder">
                                    <tr>
                                        <td class="table-orgspace-title">业务领域：</td>
                                        <td class="table-orgspace-detail" width="300px" colspan="2">
                                            <div>{{serverConDetailList.advisorServiceInfo.businessArea}}</div>
                                        </td>
                                        <td class="table-orgspace-title">从业年限：</td>
                                        <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                                            <div>{{serverConDetailList.advisorServiceInfo.workingYears}}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="table-orgspace-title">毕业学校：</td>
                                        <td class="table-orgspace-detail" width="300px" colspan="2">
                                            <div>{{serverConDetailList.advisorServiceInfo.graduatedSchool}}</div>
                                        </td>
                                        <td class="table-orgspace-title">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历：</td>
                                        <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                                            <div>{{serverConDetailList.advisorServiceInfo.education}}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="table-orgspace-title">个人简介：</td>
                                        <td class="table-orgspace-detail" colspan="4">
                                            <div class="table-orgspace-col table-orgspace-detail-container">{{serverConDetailList.advisorServiceInfo.personalProfile}}</div>
                                        </td>
                                    </tr>
                                    <!-- <tr><td class="table-orgspace-title">个人简介：</td><td class="table-orgspace-detail" colspan="4"><div class="table-orgspace-detail-container">&lt;p&gt;曾在中瑞岳华会计师事务所任职多年，从事企业IPO审计、内控审计、尽职调查审计、专项资金审计、税务鉴定审计。&lt;/p&gt;&lt;p&gt;近年来，致立于园区企业服务，累计服务企业千余家，熟悉园区内科技型企业、软件企业等税收政策，协助企业完成税收争议抗辩、新三版企业财务规范、内控优化，能够为企业提供全方面的财税咨询服务。&lt;/p&gt;</div></td></tr> -->
                                </table>
                            </div>
                        </el-tab-pane>
                        <el-tab-pane label="荣誉资质" name="honor">
                            <div class="honor clearfix" v-if="zankaiFlag">
                                <ul>
                                    <li class="" v-for="(i,k) in serverConDetailList.serviceHonorList" :key="k">
                                        <div class="honorImg"><img :src="i.certificatePhoto" alt="证书图片"></div>
                                        <div class="dataCircle"><img src="@/../static/img/yuandian.png" alt=""></div>
                                        <div class="honorTime">{{i.getTime}}获得</div>
                                        <div class="honorName">{{i.certificateName}}
                                            <p>颁发部门：{{i.issuing_agency}}</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </el-tab-pane>
                        <el-tab-pane label="服务经历" name="teamInfo">
                            <div class="honor clearfix" v-if="zankaiFlag">
                                <ul>
                                    <li class="" v-for="(i,k) in serverConDetailList.serviceExperienceList" :key="k">
                                        <div class="dataCircle"><img src="@/../static/img/yuandian.png" alt=""></div>
                                        <div class="honorTime">{{i.workTime}}获得</div>
                                        <div class="honorName">{{i.companyName}}
                                            <span>{{i.position}}</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </el-tab-pane>
                        <el-tab-pane label="项目经验" name="contactInfo">
                            <div class="honor clearfix" v-if="zankaiFlag">
                                <ul>
                                    <li class="" v-for="(i,k) in serverConDetailList.serviceProjectExperienceList" :key="k">
                                        <div class="dataCircle"><img src="@/../static/img/yuandian.png" alt=""></div>
                                        <div class="honorTime">{{i.projectTime}}</div>
                                        <div class="honorName">项目：{{i.projectName}} 公司名称：{{i.companyName}}
                                            <p>个人职责：{{i.personalDuties}}</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>

                        </el-tab-pane>
                    </el-tabs>
                </el-card>
            </div>
        </div>
        <div class="agentCon">
            <div class="agentFil mainBorder">
                <ul class="select-list clearfix" v-if="serverPro&&serverPro.length>0,showFlag==true">
                    <li>
                        <a href="javascript:;">筛选：</a>
                    </li>
                    <li class="list-item current" :class="{'active3':flag1==''}" @click="screenPro('')">
                        <a href="javascript:;" data="%">全部({{serverPro[0].serviceTotal}})</a>
                    </li>
                    <li class="list-item" :class="{'active3':flag1=='0'}" @click="screenPro('0')">
                        <a href="javascript:;" data="常规服务">常规服务({{serverPro[0].commonTotal}})</a>
                    </li>
                    <li class="list-item" :class="{'active3':flag1=='1'}" @click="screenPro('1')">
                        <a href="javascript:;" data="特色服务">特色服务({{serverPro[0].featureTotal}})</a>
                    </li>
                </ul>
                <ul class="select-list clearfix" v-else>
                    <li>
                        <a href="javascript:;">筛选：</a>
                    </li>
                    <li class="list-item current" :class="{'active3':flag2==''}" @click="handleEvaluation('')">
                        <a href="javascript:;" data="%">全部({{evaluationCountInfo.evaluationTotal}})</a>
                    </li>
                    <li class="list-item " :class="{'active3':flag2=='praise'}" @click="handleEvaluation('praise')">
                        <a href="javascript:;" data="好评">好评({{evaluationCountInfo.praiseNum}})</a>
                    </li>
                    <li class="list-item " :class="{'active3':flag2=='average'}" @click="handleEvaluation('average')">
                        <a href="javascript:;" data="中评">中评({{evaluationCountInfo.averageNum}})</a>
                    </li>
                    <li class="list-item " :class="{'active3':flag2=='badReview'}" @click="handleEvaluation('badReview')">
                        <a href="javascript:;" data="差评">差评({{evaluationCountInfo.badReviewNum}})</a>
                    </li>
                </ul>
            </div>
            <el-tabs v-model="activeName1" @tab-click="handleClick">
                <el-tab-pane name="serverPro">
                    <span slot="label">服务产品({{total1}})</span>
                    <div class="serverPro">
                        <ul class="list-imgleft">
                            <li class="list-item pr" v-for="(i,k) in serverPro" :key='k'>
                                <!-- 上架时间 begin -->
                                <div class="list-item-date"></div>
                                <!-- 上架时间 end -->
                                <!-- 左侧logo begin-->
                                <div class="list-imgleft-container product nopic" @click="$router.push({path: 'serverProDetail',query: { productId: i.productId, signoryId: i.signoryId }})">
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
                                            <div class="search_area text-of">服务顾问：{{i.advisorName}}</div>
                                            <div class="text-of mt5">参考价格：{{i.referPrice}}元</div>
                                            <div>累计
                                                <span class="mainColor">{{i.transactionsNumber}}</span>笔交易</div>
                                        </div>
                                        <!-- 参考信息、交易均价 end -->
                                        <!-- 评价 begin -->
                                        <div class="detail-evaluate inner-product">
                                            <div class="score">
                                                <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" style="display:inline-block" score-template="{value}">
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
                <el-tab-pane name="serEvaluation">
                    <span slot="label">服务评价({{evaluationCountInfo.evaluationTotal}})</span>
                    <div class="serEvaluation" v-if="serviceRatingList">
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
                                                <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" style="display:inline-block" score-template="{value}">
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
                            <el-pagination background @size-change="handleSizeChange2" @current-change="handleCurrentChange2" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row2" layout="total,prev, pager, next,sizes" :total="total2">
                            </el-pagination>
                        </div>
                    </div>
                </el-tab-pane>
            </el-tabs>
        </div>
        <!-- 提需求弹框 -->
        <template v-if="serverConVisible">
            <el-dialog :visible.sync="serverConVisible" width="530px" top="30vh" :modal-append-to-body=false>
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
      zankaiFlag: false,
      activeName: "baseInfo",
      activeName1: "serverPro",
      serverConDetailList: "",
      serverPro: "",
      currentPage1: 1,
      row1: 5,
      page1: 1,
      total1: 0,
      row2: 5,
      page2: 1,
      total2: 0,
      serviceRatingList: "",
      evaluationCountInfo: "",
      serverConVisible: false,
      flag1: "",
      flag2: "",
      productType: "",
      ratingType: "",
      showFlag: true,
      serverProform: {
        requireDetail: "",
        productId: "",
        productName: ""
      }
    };
  },
  mounted() {
    this.initList();
    this.advisorProductList();
    this.getServiceRatingInfo();
    this.getEvaluationCountInfo();
  },
  methods: {
    onlineContact(advisorAccount, advisorName) {
      if (!sessionStorage.userInfo) {
        this.$message.error("请先登录");
        return;
      }
      this.$router.push({
        path: "/chat",
        query: {fromUser:JSON.parse(sessionStorage.userInfo).account, toUser: advisorAccount, nickName: advisorName }
      });
    },
    demandRaise(i) {
      if (!sessionStorage.userInfo) {
        this.$message.error("请先登录");
        return;
      }
      this.serverConVisible = true;
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
            if (_this.serverProform.requireDetail == "") {
              // _this.$message.error("您还没填写需求");
              _this.serverConVisible = false;
              return;
            } else {
              _this.$message.success("提交需求成功");
              _this.serverConVisible = false;
            }
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    handleZk() {
      this.zankaiFlag = true;
    },
    handleZd() {
      this.zankaiFlag = false;
    },
    screenPro(i) {
      (this.productType = i),
        (this.flag1 = i),
        (this.page1 = 1),
        this.advisorProductList();
    },
    handleEvaluation(i) {
      (this.ratingType = i),
        (this.flag2 = i),
        (this.page2 = 1),
        this.getServiceRatingInfo();
    },
    handleSizeChange1(val) {
      //改变每页显示多少条的回调函数
      this.row1 = val;
      this.page1 = 1;
      this.advisorProductList();
    },
    handleCurrentChange1(val) {
      //改变当前页码的回调函数
      this.page1 = val;
      this.advisorProductList();
    },
    handleSizeChange2(val) {
      //改变每页显示多少条的回调函数
      this.row2 = val;
      this.page2 = 1;
      this.getServiceRatingInfo();
    },
    handleCurrentChange2(val) {
      //改变当前页码的回调函数
      this.page2 = val;
      this.getServiceRatingInfo();
    },
    handleClick(tab, event) {
      if (tab.name == "serEvaluation") {
        this.showFlag = false;
        this.getServiceRatingInfo();
        this.getEvaluationCountInfo();
      } else {
        this.showFlag = true;
        this.advisorProductList();
      }
    },
    getEvaluationCountInfo() {
      //服务评价统计信息
      let _this = this;
      this.api.get({
        url: "getEvaluationCountInfo",
        data: {
          advisorAccount: _this.$route.query.advisorAccount,
          needPage: 1,
          isPublicPage: 0
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.evaluationCountInfo = res.data;
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
          advisorAccount: _this.$route.query.advisorAccount,
          needPage: 1,
          isPublicPage: 0,
          page: _this.page2,
          rows: _this.row2,
          ratingType: _this.ratingType
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serviceRatingList = res.data.rows;
            _this.total2 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    advisorProductList() {
      //顾问-服务产品
      let _this = this;
      this.api.get({
        url: "advisorProductList",
        data: {
          advisorAccount: _this.$route.query.advisorAccount,
          page: _this.page1,
          rows: _this.row1,
          productType: _this.productType,
          praise: ""
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
    initList() {
      //获取顾问详情
      let _this = this;
      this.api.get({
        url: "getServiceAdvisorInfo",
        data: {
          advisorAccount: _this.$route.query.advisorAccount
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverConDetailList = res.data;
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
.serverConDetail {
  .agentCon {
    .pagination-container {
      margin-top: 50px;
    }
  }
  .agentDel {
    .table-orgspace-detail-container {
      line-height: 22px;
      padding: 12px 0px;
    }
    .table-orgspace-title {
      width: 80px;
    }
    .honor {
      // padding: 20 0px;
      font-size: 14px;

      > ul {
        > li {
          margin-bottom: 20px;

          // font-size: 0;
          // .honorImg {
          //   width: 130px;
          //   height: 80px;
          //   display: inline-block;
          //   vertical-align: middle;

          //   >img {
          //     width: 100%;
          //     height: 100%;
          //   }
          // }

          .dataCircle {
            width: 20px;
            height: 20px;
            margin: 0 40px;
            display: inline-block;
            vertical-align: middle;

            > img {
              width: 100%;
              height: 100%;
            }
          }

          .honorTime {
            display: inline-block;
            vertical-align: middle;
          }

          .honorName {
            margin-left: 40px;
            display: inline-block;
            vertical-align: middle;
          }
        }

        > li:last-child {
          margin-bottom: 0;
        }
      }

      .dataLeft {
        > div {
          margin-bottom: 20px;
          width: 130px;
          height: 80px;

          > img {
            width: 100%;
            height: 100%;
          }
        }
      }

      .dataMid {
        margin: 0 50px;
        margin-top: 30px;

        .dataCircle {
          width: 20px;
          height: 20px;
          border-radius: 50%;
          border: 1px solid #ccc;
          background: #00a041;
        }

        .dataLine {
          width: 2px;
          height: 80px;
          margin-left: 10px;
          background-color: #00a041;
        }
      }

      .dataMid2 {
        margin-top: 35px;
        margin-right: 30px;

        > div {
          margin-bottom: 80px;
        }

        > div:last-child {
          margin-bottom: 0px;
        }
      }

      .dataRight {
        margin-top: 30px;

        > div {
          margin-bottom: 60px;
        }

        > div:last-child {
          margin-bottom: 0px;
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
}
</style>

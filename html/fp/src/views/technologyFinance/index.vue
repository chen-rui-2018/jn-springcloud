<template>
  <div ref="box" data-class="left" class="TechnologyFinance">
    <div class="techHeah">
        <div id="header" class="header" :class="{'headerw':showFF}">
          <div class="headerContainer clearfix">
            <div class="titleImg fl">
              <img  class="pointer" src="@/../static/img/LOGO1.png" v-if="!showFF"  @click="$router.push({path:'/'})" alt="">
              <img src="@/../static/img/login-logo.png" v-else class="pointer" alt="" @click="$router.push({path:'/'})">
              </div>
            <div class="menu" style="display:none">
              <i class="el-icon-close"></i>
              <input type="text">
              <i class="el-icon-search"></i>
            </div>
            <div class="headerRight fr">
              <div class="search pointer">
                <i class="el-icon-search" @click="show4=true" style="font-size:20px"></i>
              </div>
              <div class="navlogin">
                <a @click="$router.push({path:'/login'})">登录</a>
                <span class="line">|</span>
                <a @click="$router.push({path:'/register'})">注册</a>
              </div>
            </div>
            <div class="nav" id="nav">
              <!-- <transition name="fade"> -->
                <!-- <div class="sousuo posA" v-if="sousuo">
                  <i class="el-icon-close" style="vertical-align: middle;" @click="sousuo=false"></i>
                  <input type="text" v-focus @keyup.enter="handleSearch">
                  <i class="el-icon-search" style="vertical-align: middle;" @click="sousuo=false"></i>
                </div> -->
                <ul class="posA clearfix">
                  <li class="posLi1">
                    <a href="javascript:void(0);">首页</a>
                  </li>
                  <li>
                    <a href="javascript:void(0);">投资人</a>
                  </li>
                  <li>
                    <a href="javascript:void(0);">金融产品</a>
                  </li>
                  <li>
                    <a href="javascript:void(0);">金融机构</a>
                  </li>
                </ul>

              <!-- </transition> -->
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
    </div>
    
    <!-- <div id="headerW" v-if="headFlag">
      <div class="headerContainer clearfix">
        <div class="titleImg fl"><img  class="pointer" src="@/../static/img/login-logo.png" @click="$router.push({path:'/'})" alt=""></div>
        <div class="menu" style="display:none">
          <i class="el-icon-close"></i>
          <input type="text">
          <i class="el-icon-search"></i>
        </div>
        <div class="headerRight fr">
          <div class="search" v-if="!sousuo">
            <i class="el-icon-search" @click="handleChange" style="font-size:20px"></i>
          </div>
          <div class="navlogin">
            <a @click="$router.push({path:'/login'})">登录</a>
            <span class="line">|</span>
            <a @click="$router.push({path:'/register'})">注册</a>
          </div>
        </div>
        <div class="nav">
          <transition name="fade">
            <div class="sousuo posA" v-if="sousuo">
              <i class="el-icon-close" style="vertical-align: middle;" @click="sousuo=false"></i>
              <input type="text" v-focus @keyup.enter="handleSearch">
              <i class="el-icon-search" style="vertical-align: middle;" @click="sousuo=false"></i>
            </div>
            <ul class="posA clearfix" v-else>
              <li>
                <a href="javascript:void(0);">首页</a>
              </li>
              <li>
                <a href="javascript:void(0);">投资人</a>
              </li>
              <li>
                <a href="javascript:void(0);">金融产品</a>
              </li>
              <li>
                <a href="javascript:void(0);">金融机构</a>
              </li>
            </ul>

          </transition>
        </div>
      </div>
    </div> -->
    <div class="techCon">
      <div class="banner pr">
          <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/techBan.png" alt="">
                        </div>
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/techBan.png" alt="">
                        </div>
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/techBan.png" alt="">
                        </div>                  
                    </div>
                    <!-- 如果需要分页器 -->
                         <!-- <div class="swiper-pagination"></div> -->

                        <!-- 如果需要导航按钮 -->
                        <!-- <div class="swiper-button-prev" @mouseenter="showBtn=!showBtn" @mouseleave="showBtn=!showBtn">
                            <i class="iconfont icon-leftarrow pointer" v-show="showBtn"></i>
                        </div>
                        <div class="swiper-button-next"  @mouseenter="showBtn=!showBtn" @mouseleave="showBtn=!showBtn">
                            <i class="iconfont icon-rightarrow pointer" v-show="showBtn"></i>
                        </div> -->
          </div>
          <!-- <div class="quickEnter">
                    <ul>
                        <li>
                            <span>人才申报</span>
                            <p>PEOPLE&nbsp;DECLARE</p>
                            <img src="@/../static/img/right-arrow.png" alt="">
                        </li>
                        <li>
                            <span>高新企业</span>
                            <p>HIGH-TECH&nbsp;ENTERPRISE</p>
                            <img src="@/../static/img/right-arrow.png" alt="">
                        </li>
                        <li>
                            <span>孵化企业</span>
                            <p>INCUBATION&nbsp;ENTERPRISE</p>
                            <img src="@/../static/img/right-arrow.png" alt="">
                        </li>
                        <li>
                            <span>行政审批</span>
                            <p>ADMINISTRATIVE&nbsp;EXAMINATIO</p>
                            <img src="@/../static/img/right-arrow.png" alt="">
                        </li>
                    </ul>
          </div> -->
      </div>
      <div class="techContent w">
        <div class="techNav">
          <!-- <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
            <el-breadcrumb-item>
              <a class="mainColor">科技金融</a>
            </el-breadcrumb-item>
          </el-breadcrumb> -->
          <span class="pointer" @click="$router.push({path:'/enterpriseservice'})">企业服务</span>
          <span>/</span>
          <span class="mainColor">科技金融</span>
        </div>
        <div class="techList">
          <el-card>
            <ul class="techUl">
              <li>
                <img src="@/../static/img/tech1.png" alt="">
                <div class="liInfo">
                  <span>投资人</span>
                  <p class="mainColor">{{investorsNum}}
                    <span>名</span>
                  </p>
                </div>
              </li>
              <li>
                <img src="@/../static/img/tech2.png" alt="">
                <div class="liInfo">
                  <span>金融产品</span>
                  <p class="mainColor">
                    {{financialProductNum}}
                    <span>个</span>
                  </p>
                </div>
              </li>
              <li>
                <img src="@/../static/img/tech3.png" alt="">
                <div class="liInfo">
                  <span>金融机构</span>
                  <p class="mainColor">
                    {{financialOrgNum}}
                    <span>个</span>
                  </p>
                </div>
              </li>
            </ul>
          </el-card>
        </div>
        <div class="techGroud">
          <div class="investor">
            <div class="inverTil clearfix">
              <p class="fl color1">投资人</p>
              <span class="fr color3">MORE
                <i class="el-icon-arrow-right"></i>
              </span>
            </div>
            <ul class="inverUl">
              <li class="clearfix">
                <div class="liLeft fl">
                  <div class="intorImgLar" v-if="InvestorInfoList.length > 0">
                    <img :src="InvestorInfoList[0].avatar" alt="">
                  </div>
                  <div class="leftInfo" v-if="InvestorInfoList.length > 0">
                    <span class="color1">{{InvestorInfoList[0].investorName}}/{{InvestorInfoList[0].position}}</span>
                    <p class="color3">{{InvestorInfoList[0].orgName}}</p>
                    <i class="color3">{{InvestorInfoList[0].position}}</i>
                  </div>
                </div>
                <div class="liRight fr">
                  <ul class="clearfix">
                    <li v-if="k<5&&k>0" v-for="(i,k) in InvestorInfoList" :key="k">
                      <div class="intorImgSma">
                        <img :src="i.avatar" alt="头像">
                      </div>
                      <div class="rightInfo">
                        <span class="color1">{{i.investorName}}/{{i.position}}</span>
                        <p class="color3">{{i.orgName}}</p>
                        <i class="color3">{{i.position}}</i>
                      </div>
                    </li>
                    <!-- <li>
                      <div class="intorImgSma">
                        <img src="@/../static/img/smallImg.png" alt="">
                      </div>
                      <div class="rightInfo">
                        <span class="color1">郭龙华/总经理</span>
                        <p class="color3">苏州万隆永鼎会计事务所有限公司</p>
                        <i class="color3">合伙人</i>
                      </div>
                    </li>
                    <li>
                      <div class="intorImgSma">
                        <img src="@/../static/img/smallImg.png" alt="">
                      </div>
                      <div class="rightInfo">
                        <span class="color1">郭龙华/总经理</span>
                        <p class="color3">苏州万隆永鼎会计事务所有限公司</p>
                        <i class="color3">合伙人</i>
                      </div>
                    </li> -->
                    <!-- <li class="lastLi mainColor">
                      <img src="@/../static/img/xiao.png" alt="">
                      <div class="rightInfo">认证投资人></div>
                    </li> -->
                  </ul>
                </div>
              </li>
            </ul>
            <ul class="inverUl inverUl11" v-if="InvestorInfoList.length > 5">
              <li class="clearfix">
                <div class="liLeft fl">
                  <div class="intorImgLar">
                    <img :src="InvestorInfoList[5].avatar" alt="">
                  </div>
                  <div class="leftInfo" v-if="InvestorInfoList.length > 5">
                    <span class="color1">{{InvestorInfoList[5].investorName}}/{{InvestorInfoList[5].position}}</span>
                    <p class="color3">{{InvestorInfoList[5].orgName}}</p>
                    <i class="color3">{{InvestorInfoList[5].position}}</i>
                  </div>
                </div>
                <div class="liRight fr">
                  <ul class="clearfix">
                    <li v-if="k<9&&k>5" v-for="(i,k) in InvestorInfoList" :key="k">
                      <div class="intorImgSma">
                        <img :src="i.avatar" alt="头像">
                      </div>
                      <div class="rightInfo">
                        <span class="color1">{{i.investorName}}/{{i.position}}</span>
                        <p class="color3">{{i.orgName}}</p>
                        <i class="color3">{{i.position}}</i>
                      </div>
                    </li>
                    <!-- <li>
                      <div class="intorImgSma">
                        <img src="@/../static/img/smallImg.png" alt="">
                      </div>
                      <div class="rightInfo">
                        <span class="color1">郭龙华/总经理</span>
                        <p class="color3">苏州万隆永鼎会计事务所有限公司</p>
                        <i class="color3">合伙人</i>
                      </div>
                    </li>
                    <li>
                      <div class="intorImgSma">
                        <img src="@/../static/img/smallImg.png" alt="">
                      </div>
                      <div class="rightInfo">
                        <span class="color1">郭龙华/总经理</span>
                        <p class="color3">苏州万隆永鼎会计事务所有限公司</p>
                        <i class="color3">合伙人</i>
                      </div>
                    </li> -->
                    <li class="lastLi mainColor">
                      <img src="@/../static/img/xiao.png" alt="">
                      <div class="rightInfo">认证投资人></div>
                    </li>
                  </ul>
                </div>
              </li>
            </ul>
            <div class="bannerImg">
              <img src="@/../static/img/smallBanner.png" alt="">
            </div>
          </div>
          <div class="investor financialPro pr">
            <div class="inverTil clearfix">
              <p class="fl color1">金融产品</p>
              <span class="fr color3">MORE
                <i class="el-icon-arrow-right"></i>
              </span>
            </div>
            <i class="iconfont icon-leftarrow pointer" @click="leftPage"></i>
            <i class="iconfont icon-rightarrow pointer" @click="rightPage"></i>
            <ul class="finaUl clearfix">
              <li class="mainBorder" v-if="k<8" v-for="(i,k) in FinancialProList" :key="k">
                <!-- <img src="@/../static/img/midBan.png" alt=""> -->
                <div class="finaProItem">
                  <img :src="i.pictureUrl" alt="">
                </div>
                <div class="finaDiv1">
                  <div class="finaTit">{{i.productName}}</div>
                  <div class="finaContent">
                    <p>服务机构：{{i.orgName}}</p>
                    <p>参考利率范围：
                      <span class="mainColor">{{i.refRateMin}}%—{{i.refRateMax}}%</span>
                    </p>
                    <p>贷款期限：{{i.loanTermMin}}个月—{{i.loanTermMax}}个月</p>
                    <p>担保方式：{{i.assureMethodName}}</p>
                  </div>
                </div>
                <p class="clearfix finaPP">
                  <span class="fl">贷款额度：
                    <i class="mainColor">{{i.loanAmountMin}}万元-{{i.loanAmountMax}}万元</i>
                  </span>
                  <span class="mainColor fr" @click="raiseDemand(i)">提需求</span>
                </p>
              </li>
              <!-- <li class="mainBorder">
                <div class="finaProItem">
                  <img src="@/../static/img/midBan.png" alt="">
                </div>
                <div class="finaDiv1">
                  <div class="finaTit">货币基金</div>
                  <div class="finaContent">
                    <p>服务机构：中国民生银行（华夏路支行）</p>
                    <p>参考利率范围：
                      <span class="mainColor">2%——8%</span>
                    </p>
                    <p>贷款期限：6个月以下</p>
                    <p>担保方式：担保人/不动产</p>
                  </div>
                </div>
                <p class="clearfix finaPP">
                  <span class="fl">贷款额度：
                    <i class="mainColor">10_100W</i>
                  </span>
                  <span class="mainColor fr" @click="raiseDemand">提需求</span>
                </p>
              </li> -->
              <!-- <li class="finaLastLi  mainBorder">
                <img src="@/../static/img/da.png" alt="">
                <div class="rightInfo" @click="raiseDemand">提需求></div>
              </li> -->
            </ul>
            <div class="bannerImg">
              <img src="@/../static/img/smallBanner.png" alt="">
            </div>
          </div>
          <div class="investor financialPro financialIns">
            <div class="inverTil clearfix">
              <p class="fl color1">金融机构</p>
              <span class="fr color3">MORE
                <i class="el-icon-arrow-right"></i>
              </span>
            </div>
                  <!-- <img src="@/../static/img/ins1.png" alt=""> -->
            <ul class="finaInsUl finaUl clearfix" id="finaInsUl">
              <li class="finaInsLi pr" v-for="(i,k) in ServiceOrgList" :key='k'>
                <div class="finaInsItem">
                  <img :src="i.orgLogo" alt="">
                </div>
                <div class="finaDiv1">
                  <!-- <div class="finaTit"></div> -->
                  <!-- <div class="finaTit">{{i.orgName}}</div> -->
                  <div class="finaContent">
                    <p class="finaPhone">电话：
                      <span class="mainColor">{{i.orgPhone}}</span>
                    </p>
                    <p class="finaAddress">地址：{{i.orgAddress}}</p>
                  </div>
                </div>
                <p class="finaPP lejie">
                  <span class="">累计
                    <i class="mainColor">{{i.transactionNum}}</i>
                    笔交易
                  </span>
                  <span class="mainColor" style="margin-left:60px">了解详情</span>
                </p>
              </li>
              <!-- <li class="finaInsLi">
                <div class="finaInsItem">
                  <img src="@/../static/img/ins1.png" alt="">
                </div>
                <div class="finaDiv1">
                  <div class="finaTit">苏州中合会计事务所</div>
                  <div class="finaContent">
                    <p class="finaPhone">电话：
                      <span class="mainColor">0510-87654321</span>
                    </p>
                    <p class="finaAddress">地址：江苏省南京市白下高新园区A座1306</p>
                  </div>
                </div>
                <p class="clearfix finaPP">
                  <span class="fl">累计
                    <i class="mainColor">35</i>
                    笔交易
                  </span>
                  <span class="mainColor fr">了解详情</span>
                </p>
              </li> -->
            </ul>
          </div>
        </div>
      </div>
    </div>
    
    <!-- 提需求弹框 -->
    <template v-if="financialProVisible">
      <el-dialog :visible.sync="financialProVisible" width="600px">
        <el-form ref="financialProform" :rules="rules" :model="financialProform" label-position="right" label-width="150px" style="max-width:500px;">
          <el-form-item label="融资金额(万元):" prop="financingAmount">
            <el-input v-model.trim="financialProform.financingAmount" placeholder="请输入融资金额" maxlength="100" clearable/>
          </el-form-item>
          <el-form-item label="融资期限(月):" prop="financingPeriod">
            <el-select v-model="financialProform.financingPeriod" placeholder="请选择" style="width:100%">
              <el-option v-for="(item,index) in options" :key="index" :label="item.label" :value="item.value" />
              <!-- <el-option value="3个月及以下"/>
              <el-option value="6个月及以下"/>
              <el-option value="12个月及以下"/>
              <el-option value="36个月及以下"/>
              <el-option value="36个月以上"/> -->
            </el-select>
          </el-form-item>

          <el-form-item label="资金需求日期:" prop="expectedDate">
            <el-input v-model.trim="financialProform.expectedDate" placeholder="请输入需求日期，如2019-04-10" maxlength="100" clearable/>
          </el-form-item>
          <el-form-item label="资金需求说明:" prop="fundsReqDesc">
            <el-input v-model.trim="financialProform.fundsReqDesc" class="demandTextArea" :rows="4" type="textarea" placeholder="可不填" maxlength="100" clearable/>
          </el-form-item>
        </el-form>
        <div class="demandLine"></div>
        <div class="demandDia" @click="demandDia()">提交需求</div>
      </el-dialog>
    </template>
  </div>
</template>
<script>
import swiper from "swiper";
export default {
  data() {
    return {
      sousuo: false,
      searchData:'',
      showFF:false,
      show4:false,
      headFlag: false,
      financialOrgNum: "",
      financialProductNum: "",
      investorsNum: "",
      total1: 0,
      page: 1,
      rows: 8,
      financialProVisible: false,
      financialProform: {
        financingAmount: "",
        financingPeriod: "",
        financingPeriodMax: "",
        financingPeriodMin: "",
        expectedDate: "",
        fundsReqDesc: "",
        productId: "",
        productName: ""
      },
      options: [
        {
          value: 0,
          label: "3个月及以下"
        },
        {
          value: 1,
          label: "6个月及以下"
        },
        {
          value: 2,
          label: "12个月及以下"
        },
        {
          value: 3,
          label: "36个月及以下"
        },
        {
          value: 4,
          label: "36个月以上"
        }
      ],
      arr: [
        {
          loanTermMax: 3,
          loanTermMin: ""
        },
        {
          loanTermMax: 6,
          loanTermMin: ""
        },
        {
          loanTermMax: 12,
          loanTermMin: ""
        },
        {
          loanTermMax: 36,
          loanTermMin: ""
        },
        {
          loanTermMax: "",
          loanTermMin: 36
        }
      ],
      InvestorInfoList: [],
      FinancialProList: [],
      ServiceOrgList: [],
      rules: {
        financingAmount: [
          { required: true, message: "请输入融资金额", trigger: "blur" }
        ],
        financingPeriod: [
          { required: true, message: "请选择融资期限", trigger: "change" }
        ],
        expectedDate: [
          { required: true, message: "请输入需求日期", trigger: "blur" }
        ]
      }
    };
  },
  mounted() {
    this.techInit()
    console.dir(this.$refs.box)
  
    this.$router.afterEach((to, from, next) => {
        window.scrollTo(0, 0)
    })
    window.addEventListener("scroll", this.handleScroll, true);
    this.init();
    this.getInvestorInfoList();
    this.getFinancialProList();
    this.selectServiceOrgList();
    this.selectIndustryList();
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
  },
  methods: {
     techInit() {
      var mySwiper = new swiper(".swiper-container", {
        direction: "horizontal", // 垂直切换选项
        loop: true, // 循环模式选项

        // 如果需要分页器
        pagination: {
          el: ".swiper-pagination"
        },
        // 如果需要前进后退按钮
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
        },

        // 如果需要滚动条
        scrollbar: {
          el: ".swiper-scrollbar"
        }
      });
    },
    //金融产品左翻页
    leftPage() {
      if (this.page <= 1) {
        this.$message.error("已经是第一页了");
        return;
      }
      this.page--;
      this.getFinancialProList();
    },
    handleScroll() {
      const osTop = document.documentElement.scrollTop || document.documentElement.scrollTop
      // console.dir(this.$refs)
      for (const key in this.$refs) {
        if (osTop >= this.$refs[key].scrollTop) {
          // console.dir(node.scrollTop)
          const name = this.$refs[key].dataset.class
          this.$refs[key].classList.add(name)
        }
      }
      // console.log(this.getScrollTop())
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
    //金融产品右翻页
    rightPage() {
      if (this.page >= this.total1) {
        this.$message.error("没有更多数据了");
        return;
      }
      this.page++;
      this.getFinancialProList();
    },
    //用户提需求
    demandDia() {
      let _this = this;
      let max = this.arr[this.financialProform.financingPeriod].loanTermMax;
      let min = this.arr[this.financialProform.financingPeriod].loanTermMin;
      this.api.post({
        url: "userDemandTechnology",
        data: {
          expectedDate: _this.financialProform.expectedDate,
          financingAmount: _this.financialProform.financingAmount,
          financingPeriodMax: max,
          financingPeriodMin: min,
          productId: _this.financialProform.productId,
          productName: _this.financialProform.productName,
          fundsReqDesc: _this.financialProform.fundsReqDesc
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.$message.success("提交需求成功");
            _this.financialProVisible = false;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //提需求
    raiseDemand(i) {
      // this.financialProVisible = true;
      this.financialProform.expectedDate = "";
      this.financialProform.financingAmount = "";
      this.financialProform.financingPeriodMax = "";
      this.financialProform.financingPeriodMin = "";
      this.financialProform.financingPeriod = "";
      this.financialProform.fundsReqDesc = "";
      this.financialProform.productId = i.productId;
      this.financialProform.productName = i.productName;
    },
    handleChange() {
      // this.sousuo = true;
    },
    //投资人列表
    getInvestorInfoList() {
      let _this = this;
      this.api.get({
        url: "getInvestorInfoList",
        data: {
          needPage: 1
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.InvestorInfoList = res.data.rows;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //金融产品列表
    getFinancialProList() {
      let _this = this;
      this.api.get({
        url: "getFinancialProList",
        data: {
          needPage: 1,
          rows: _this.rows,
          page: _this.page
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.FinancialProList = res.data.rows;
            _this.total1 = Math.ceil(res.data.total / _this.rows);
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //金融机构列表
    selectServiceOrgList() {
      let _this = this;
      this.api.get({
        url: "selectServiceOrgList",
        data: {
          businessType: "technology_finance"
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.ServiceOrgList = res.data.rows;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //机构字典
    selectIndustryList() {
      let _this = this;
      this.api.get({
        url: "selectIndustryList",
        data: {
          id: "",
          preType: "0",
          preValue: ""
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    init() {
      let _this = this;
      this.api.get({
        url: "getTechnologyInfoNum",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.financialOrgNum = res.data.financialOrgNum;
            _this.financialProductNum = res.data.financialProductNum;
            _this.investorsNum = res.data.investorsNum;
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
.TechnologyFinance {
  .techHeah{
    position: fixed;
    z-index: 99999 !important;
    width: 100%;
   .header {
    // position: fixed;
    // padding: 0 160px;
    // background-color: #e9a536;
    // width: 84%;
    background-color: rgba(255, 255, 255, 0.2);
    width: 100%;
    z-index: 3;
    .headerContainer {
      padding: 0 160px;
      width: 100%;
      height: 65px;
      line-height: 65px;
      color: #fff;
      // font-weight: bold;
      font-size: 16px;
      box-sizing: border-box;
      .titleImg {
        width: 155px;
        height: 38px;
        img {
          width: 100%;
          height: 100%;
          vertical-align: middle;
        }
      }
      .nav {
        width: 600px;
        height: 37.6px;
        margin: 0 auto;
        > ul {
          overflow: hidden;
          li {
            float: left;
            // color: #ccc;
            font-size: 14px;
            text-align: center;
            // line-height: 52px;
            padding: 0 38px;
            // width: 100px;
          }
        }
        .posLi1{
          background: #fff;
           color: #00a041;
          border-radius: 5px;
        }
        .posA {
          position: absolute;
          left: 50%;
          transform: translateX(-50%);
          // padding: 20px 0;
        }
        .sousuo {
          font-size: 18px;
          line-height: 48px;
          > input {
            border: none;
            width: 350px;
            height: 38px;
            font-size: 14px;
          }
          > input::-webkit-input-placeholder {
            color: #b7b7b7;
            font-size: 12px;
          }
        }
      }
      .headerRight {
        .search {
          display: inline-block;
          margin-right: 20px;
          vertical-align: middle;
          i {
            width: 20px;
            height: 20px;
          }
        }
        .navlogin {
          display: inline-block;
          font-size: 14px;
          a {
            display: inline-block;
            cursor: pointer;
          }
          .line {
            display: inline-block;
            height: 12px;
            margin: 0 15px;
          }
          > img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
          }
        }
      }
    }
   }
   .headerw{
      background: #fff;
      border: 1px solid #eee;
      box-shadow:0 10px 10px -10px #ccc;
      color: #666;
      #nav,.headerRight{
        color: #666;
        li{
          a{
            color:#666;
          }
        }
        li:nth-child(1){
          background: none;
          border-radius: none;
          a{
            color:#00a041;
          }
        }
        li:hover{
          background: none;
          color: #00a041;
        }
         li:hover a{
            color:#00a041;
        }
      }
    }
    .search_box {
      background: rgba(0, 0, 0, 0.3);
      // text-align: center;
      .el-input-group {
        border-radius: 28px;
        width: 42%;
        margin: 43px 0;
        position: relative;
        transform: translateX(-50%);
        left: 50%;
        .el-input {
          width: 94px;
        }
        .el-input__inner:focus {
          border-color: #00a041;
        }
        .el-input-group__append,
        .el-input-group__prepend {
          border-radius: 28px;
        }
        .el-input-group__append {
          /* border-top-left-radius: 0;
      border-bottom-left-radius: 0; */
          background: #00a041;
          color: #fff;
          right: 58px;
          .el-button {
            margin: -10px -10px;
          }
        }
        .el-input-group__prepend {
          border-top-right-radius: 0;
          border-bottom-right-radius: 0;
          background-color: #fff;
          padding: 0px 17px 0 9px;
          input {
            color: #666666;
            text-align: right;
          }
        }
        
      }
      .input-with-select .el-input__inner{
          border-top-left-radius: 19px;
          border-bottom-left-radius: 19px;
          border: 1px solid #00a041;
        }
    }
    .searchbox{
      background: #fff;
      box-shadow:0 10px 10px -10px #ccc;
    }
  }
   .techCon{}
  // .techImg {
  //   height: 454px;
  //   background: url("../../../static/img/techbanner.png") 100% 100% / 100% 100%
  //     no-repeat;
  // }
  .techContent {
    // width: 1190px;
    // margin: 0 auto;
    .techNav {
      margin: 20px 0;
      font-size: 16px;
    }
    .techList {
      width: 100%;
      .techUl {
        padding: 0 20px;
        display: flex;
        justify-content: space-between;
        > li {
          > img {
            display: inline-block;
            // width: 90px;
            // height: 68px;
            width: 100px;
            height: 80px;
          }
          .liInfo {
            display: inline-block;
            vertical-align: top;
            margin-top: 5px;
            margin-left: 5px;
            font-size: 20px;
            color: #666;
            > p {
              font-size: 30px;
              margin-top: 5px;
              >span{
                font-size: 22px;
              }
            }
          }
        }
      }
    }
    .techGroud {
      .investor {
        .inverTil {
          padding: 40px 0;
          padding-bottom: 32px;
          > p {
            font-size: 20px;
          }
          > span {
            font-size: 13px;
            cursor: pointer;
          }
        }
        .inverUl {
          .liLeft {
            padding: 28px;
            border: 1px solid #dedede;
            // margin-right:16px;
            width: 35.8%;
            .leftInfo {
              display: inline-block;
              vertical-align: top;
              margin: 30px 8px 0 30px;
              font-size: 12px;
              > p {
                margin-top: 18px;
                margin-bottom: 6px;
              }
              > span {
                font-size: 15px;
              }
            }
            > .intorImgLar {
              display: inline-block;
              width: 130px;
              height: 130px;

              > img {
                width: 100%;
                height: 100%;
                border-radius: 50%;
              }
            }
          }
          .liRight {
            //   width: 780px;
            width: 57.4%;
            > ul {
              > li {
                padding: 9px 33px;
                border: 1px solid #dedede;
                float: left;
                margin-right: 20px;
                // margin-bottom: 16px;
                width: 259px;
                height: 68px;
                > .intorImgSma {
                  display: inline-block;
                  width: 64px;
                  height: 64px;

                  > img {
                    width: 100%;
                    height: 100%;
                    border-radius: 50%;
                  }
                }
                > .rightInfo {
                  display: inline-block;
                  vertical-align: top;
                  margin-left: 10px;
                  font-size: 12px;
                  > p {
                    margin-top: 11px;
                  }
                  > span {
                    font-size: 13px;
                  }
                }
              }
              > li:nth-child(2n) {
                margin-right: 0;
              }
              > li:nth-child(1) {
                margin-bottom: 16px;
              }
              > li:nth-child(2) {
                margin-bottom: 16px;
              }
              .lastLi {
                > .rightInfo {
                  background: #ecfcf2;
                  padding: 10px;
                  border: 1px solid #00a041;
                  border-radius: 4px;
                  margin-top: 20px;
                  cursor: pointer;
                }
                > img {
                  width: 153px;
                }
              }
            }
          }
        }
        .inverUl11{
          margin-top: 20px;
        }
        .bannerImg {
          width: 1190px;
          margin: 20px 0;
          margin-top: 40px;
          > img {
            width: 100%;
          }
        }
      }
      .financialPro {
        > .finaUl {
          > li {
            width: 280px;
            height: 339px;
            float: left;
            margin-right: 20px;
            margin-bottom: 30px;
            font-size: 13px;
            color: #999;
            > .finaDiv1 {
              padding: 10px 20px;
              > .finaTit {
                font-size: 18px;
                color: #222;
                margin-bottom: 15px;
              }
              .finaContent {
                // margin: 10px 0;
              }
            }
            .finaPP {
              padding: 20px;
              border-top: 1px solid #eee;
              > span:nth-child(2) {
                cursor: pointer;
              }
            }
            > .finaProItem {
              width: 280px;
              height: 150px;
              > img {
                width: 100%;
                height: 100%;
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
        > .icon-leftarrow {
          position: absolute;
          left: -55px;
          font-size: 34px;
          height: 34px;
          color: #d0d0d0;
          top: 440px;
        }
        > .icon-rightarrow {
          position: absolute;
          right: -55px;
          font-size: 34px;
          height: 34px;
          color: #d0d0d0;
          top: 440px;
        }
      }
      .financialIns {
        margin-bottom: 100px;
        #finaInsUl {
          > .finaInsLi {
            width: 220px;
            height: 253px;
            float: left;
            margin-right: 20px;
            margin-bottom: 28px;
            font-size: 12px;
            border: 1px solid #dedede;
            > .finaInsItem {
              // width: 60%;
              // height: 114px;
              // margin: 10px 44px;
                  width: 86%;
    height: 114px;
    margin: 15px auto;
              > img {
                width: 100%;
                height: 100%;
              }
            }
            > .finaDiv1 {
              > .finaTit {
                font-size: 16px;
                text-align: center;
                color: #333;
              }
              > .finaContent {
                .finaPhone {
                  font-size: 15px;
                }
              }
              .finaAddress {
                text-indent: -35px;
                margin-left: 35px;
                font-size: 15px;
              }
            }
            > .finaPP {
              padding: 10px;
            }
            .lejie{
              position: absolute;
              bottom:0;
              width: 91%;
            }
          }
          > .finaInsLi:nth-child(5n) {
            margin-right: 0px;
          }
        }
      }
    }
  }
  .demandDia {
    background: #ecfcf2;
    padding: 8px 10px;
    width: 80px;
    margin: 0 auto;
    border: 1px solid #00a041;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    color: #00a041;
  }
  .demandLine {
    height: 1px;
    width: 600px;
    position: relative;
    left: -20px;
    background: #eee;
    margin-bottom: 20px;
    margin-top: 10px;
  }
  .demandTextArea {
    .el-textarea__inner {
      background: #fff;
    }
  }
}
</style>


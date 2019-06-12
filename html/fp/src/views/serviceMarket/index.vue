<template>
<div>
  <!-- @mouseleave="show3=false" -->
  <div class="indexHeader" @mouseleave="searchLeave" ref="indexHeader">
    <!-- 头部 -->
    <div class="headContent" ref="headContent">
        <div class="bannerNav" :class="{'bannerNavAct':isActClass===true}">
            <div class="w clearfix type_page">
                <div class="titleImg ">
                  <div>
                    <img src="@/../static/img/LOGO1.png" alt="" class="pointer" @click="$router.push({path:'/'})" v-if="isActClass===false">
                    <img src="@/../static/img/login-logo.png" alt="" class="pointer" @click="$router.push({path:'/'})" v-else>
                  </div>
                  <div class="title">服务超市</div>
                </div>
                <div class="bannerUl">
                  <li class="active_header" :class="{'liActiv':isActClass===true}" >首页</li>
                    <li @click='$router.push({path:"/serverOrg"})'> 服务机构</li>
                    <li @click='$router.push({path:"/serverPro"})'>服务产品</li>
                    <li @click='$router.push({path:"/serverCon"})'>服务专员</li>
                    <li @click='$router.push({path:"/actiTrain"})'>活动培训</li>
                    <li @click='$router.push({path:"/aboutUs"})'>关于我们</li>
                    <li @click='$router.push({path:"/register"})'>加入我们</li>
                </div>
                <div class="headerRight pr">
                  <div class="search" >
                    <i class="el-icon-search" style="font-size:20px" @click="show3=true"></i>
                  </div>
                  <user-info></user-info>
                  <!-- <div class="navlogin">
                    <a href="javascript:;">登录</a>
                    <span class="line">|</span>
                    <a href="javascript:;"> 注册</a>
                  </div>
                  <div class="navlogin">
                    <i class="el-icon-bell"></i>
                    <span class="line">|</span>
                  </div> -->
                </div>
            </div>
        </div>
    </div>
    <!-- 搜索框  ,'search_box_margin':show3-->
    <div class="search_box" :class="{'search_box_act':isActClass===true}">
      <el-collapse-transition>
          <div v-if="show3">
            <div class="transition-box">
              <el-input placeholder="请输入内容" v-model="searchData" class="input-with-select">
                <el-select v-model="select" slot="prepend" placeholder="选择" @visible-change="changeselectShow">
                  <el-option label="机构" value="1"></el-option>
                  <el-option label="产品" value="2"></el-option>
                  <el-option label="专员" value="3"></el-option>
                  <el-option label="活动" value="4"></el-option>
                </el-select>
                <el-button slot="append" icon="el-icon-search" @click="goSearch">搜索 </el-button>
              </el-input>
            </div>
          </div>
      </el-collapse-transition>
    </div>
    <!-- 侧边栏 -->
    <transition name='fade' appear  enter-active-class='animated fadeInDown' leave-active-class='animated fadeOutUp'>
      <div class="nav" v-if="!show3&&isNavShow">
        <div class="nav_cont" v-for="(slideitem,slideindex) in sliderData " :key="slideindex">
          <div class="nav_cont_father" @click="$router.push({path:'/quickSearch',query:{signoryId:slideitem.id,preValue:slideitem.preValue}})">{{slideitem.preValue}} <i class="el-icon-arrow-right"></i></div>
          <div class="nav_cont_son" :class="{'hidder_son':slideitem.products.length===0} ">  
            <div v-for="(item,index) in slideitem.products" :key="index" @click="$router.push({path:'/serverProDetail',query:{productId:item.productId,signoryId:slideitem.id}})">
              <span></span>
              {{item.productName}}
            </div>
          </div>
        </div>
      </div>
    </transition>
  </div>
  <div class="service_market">
    <!-- 大图 -->
    <div class="banner" ref="banner">
      <div class="swiper-container">
          <div class="swiper-wrapper">
              <div class="swiper-slide" v-for="(item,index) in bannerList" :key="index"> <img :src="item.posterUrl" alt=""> </div>
          </div>
          <!-- 如果需要分页器 -->
          <div class="swiper-pagination"></div>
          <!-- 如果需要导航按钮 -->
          <div class="swiper-button-prev">
            <i class="el-icon-arrow-left"></i>
          </div>
          <div class="swiper-button-next">
            <i class="el-icon-arrow-right"></i>
          </div>
      </div>
      <div class="shadow ">
        <img src="@/../static/img/down-arrow.png" alt="" class="animate-bounce-up">
      </div>
    </div>
    <div class="market_content"><!-- 版心 -->
      <div class="market_breadcrumb">
          <span class="pointer" @click="$router.push({path:'/enterpriseservice'})">企业服务</span>
          <span>/</span>
          <span class="mainColor">服务超市</span>
      </div>
      <div class="market_navicon" ref="market_navicon2" data-class="allFade">
        <a href="javascript:;">
          <div class="nav_icon"><i class="iconfont icon-jigou2"></i></div>
          <div class="nav_discribe"> <span>入住企业数<span class="">{{navData.comNum}}</span>个</span> </div>
          <div class="nav_todo"><span @click="$router.push({path:'/upgradeEnterprise'})">申请注册</span></div>
        </a>
        <a href="javascript:;">
          <div class="nav_icon"><i class="iconfont icon-jigou1"></i></div>
          <div class="nav_discribe"> <span>已入住服务机构 <span>{{navData.orgNum}}</span>家</span> </div>
          <div class="nav_todo"><span>机构入驻</span></div>
        </a>
        <a href="javascript:;">
          <div class="nav_icon"><i class="iconfont icon-huodong"></i></div>
          <div class="nav_discribe"> <span>累计举办活动<span>{{navData.activityNum}}</span>场</span> </div>
          <div class="nav_todo"><span @click='$router.push({path:"/actiTrain"})'>近期活动</span></div>
        </a>
        <a href="javascript:;">
          <div class="nav_icon"><i class="iconfont icon-jigou11"></i></div>
          <div class="nav_discribe"> <span>已入住服务专员<span>{{navData.advisorNum}}</span>人</span> </div>
          <div class="nav_todo" @click="isVisibility=true"><span>申请专员</span></div>
        </a>
      </div>
      <!-- 申请专员弹窗 -->
      <el-dialog title="申请专员" :visible.sync="isVisibility" center>
        <el-form :model="counselorform" label-width="80px">
          <el-form-item label="服务机构">
            <el-input v-model="counselorform.orgname" autocomplete="off" placeholder="请输入你要申请入住的机构"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="isVisibility = false">前往填写资料</el-button>
        </div>
      </el-dialog>
      <!-- 最新活动 -->
      <div class="new_active" ref="new_active2" data-class="allFade">
        <div class="active_title">
          <span>最新活动</span>
          <span class="pointer" @click="$router.push({path:'/actiTrain'})">MORE<i class="iconfont icon-you"></i></span>
        </div>
        <div class="active_list">
          <div class="active_btn to_left" @click="prev"><span class="iconfont icon-zuo" ></span></div>
          <el-carousel indicator-position="none" arrow="never" loop :autoplay="false">
            <el-carousel-item v-for="(pageItem,pageIndex) in pageNum" :key='pageIndex'>
              <div class="actiTab">
                <ul class="allActiUl clearfix">
                  <li v-for="(item,index) in actiListSlim" :key='index' @click="$router.push({path:'actiDetail',query:{activityId:item.id}})">
                    <div class="postImgItem"><img :src="item.actiPosterUrl" alt="活动海报图片" class="postImg">
                    </div>
                    <div class="actiInfo">
                      <p class="actiNameItem">{{item.actiName}}</p> 
                      <p class="actiTimer"><i class="el-icon-time"></i> <span>{{item.actiStartTime}}-{{item.actiEndTime}}</span></p> 
                      <p><i class="el-icon-location-outline"></i> <span>{{item.actiAddress}}</span></p>
                    </div> 
                    <div class="actiNum clearfix">
                      <div class="avatar">
                        <ul>
                          <!-- <li v-for="(i,k) in item.avatarList" v-if="i<5" :key='k'><img :src="i" alt=""></li> -->
                        </ul>
                      </div> 
                      <i>{{item.applyNum}}/{{item.actiNumber}}</i> 
                      <span><i class="iconfont icon-xihuan"></i>{{item.actiLike}}</span>
                    </div>
                    </li>
                </ul>
              </div>
            </el-carousel-item>
          </el-carousel>
          <div class="active_btn to_right" @click="next"><span class="iconfont icon-you" ></span></div>
        </div>
      </div>
      <!-- 热门产品 -->
      <div>
        <div class="hot_product" ref="hot_product2" data-class="allFade">
          <div class="hot_titile">
            <span>热门产品</span>
            <span class="pointer" @click="$router.push({path:'/serverPro'})">MORE<i class="iconfont icon-you"></i></span>
          </div>
          <div class="hot_list">
            <ul class="clearfix">
              <li v-for="(item,index) in hotActiveList" :key="index" @click="$router.push({path:'/serverProDetail',query:{productId:item.productId,signoryId:item.signoryId}})" >
                <div class="hot_img">
                  <img :src="item.pictureUrl" alt="">
                </div>
                <div class="hot_info">
                  <div class="hot_name">{{item.productName}}</div>
                  <div class="hot_detail">
                    <span>机构  {{item.orgCount}}</span>
                    <span>专员  {{item.advisorCount}}</span>
                    <span>评价 {{item.ratingCount}}</span>
                  </div>
                  <div class="hot_price">
                    <span>参考价格：</span>
                    <span>{{item.referPrice}}</span>元
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <!-- 战略合作伙伴 -->
      <div class="partner" ref="partner2" data-class="allFade">
        <div class="partner_titile">战略合作伙伴</div>
        <div class="partner_box">
          <div class="partner_list">
            <ul class="partner_list_ul">
              <li  v-for="(item,index) in partnerLogo" :key="index" > <img :src="item.orgLogo" alt=""></li>
            </ul>
            <ul class="partner_list_ul2" ></ul>
          </div>
        </div>
      </div>
      <!-- 优质专员 -->
      <div class="counselor" ref="counselor2" data-class="allFade">
        <div class="counselor_title">
          <span>优质专员</span>
          <span class="pointer" @click="$router.push({path:'/serverCon'})">MORE<i class="iconfont icon-you"></i></span>
        </div>
        <div class="conselor_introduce">
          <ul class="conselor_tab clearfix">
            <li :class="{'conseloractive':domain === ''}" @click="changedomain('')">全部</li>
            <li v-for="(counseloitem,counseloindex) in sliderData" :key="counseloindex" :class="{'conseloractive':domain === counseloitem.id}" @click="changedomain(counseloitem.id)">{{counseloitem.preValue}}</li>
          </ul>
          <div class="conselor_info">
            <ul>
              <!-- v-show控制前两个大图 -->
              <li class="conselor_left">
                <div v-for="(counselorinfoItem,counselorinfoindex) in counselorList" :key="counselorinfoindex" v-if="counselorinfoindex<2"  @click="$router.push({path:'/serverConDetail',query:{orgId: counselorinfoItem.orgId,advisorAccount:counselorinfoItem.advisorAccount}})">
                  <a href="javascript:;">
                    <div class="info_img">
                      <div>
                        <!-- <img src="../../assets/image/test2.png" alt=""> -->
                        <img :src="counselorinfoItem.avatar" alt="">
                      </div>
                      
                    </div>
                    <div class="info_all">
                      <div class="info_name"><span>{{counselorinfoItem.advisorName}}</span>/<span>{{counselorinfoItem.position}} </span></div>
                      <div class="info_detail">
                        <p>{{counselorinfoItem.orgName}}</p>
                        <p>从业年限：{{counselorinfoItem.workingYears}}年</p>
                      </div>
                    </div>
                  </a>
                </div>
              </li>
              <li class="conselor_mid">
                <div v-for="(counselorinfoItem2,counselorinfoindex2) in counselorList" :key="counselorinfoindex2" class="conselor_mid_list" v-if="counselorinfoindex2>=2&&counselorinfoindex2<10" @click="$router.push({path:'/serverConDetail',query:{orgId: counselorinfoItem2.orgId,advisorAccount:counselorinfoItem2.advisorAccount}})">
                  <a href="javascript:;">
                    <!-- <div class="info_img"><img src="../../assets/image/test2.png" alt=""></div> -->
                    <div class="info_img"><img :src="counselorinfoItem2.avatar" alt=""></div>
                    <div class="info_all">
                      <div class="info_name"><span>{{counselorinfoItem2.advisorName}}</span>/<span>{{counselorinfoItem2.position}} </span></div>
                      <div class="info_detail">
                        <p>{{counselorinfoItem2.orgName}}</p>
                        <p>从业年限：{{counselorinfoItem2.workingYears}}年</p>
                      </div>
                    </div>
                  </a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <!-- 机构 -->
      <div class="team" ref="team2" data-class="allFade">
        <div class="team_liveness">
          <div class="liveness_titile">机构活跃度</div>
          <div class="liveness_list">
            <ul class="team_tab clearfix">
              <li :class="{'teamactive':isActive === ''}" @click="changeindustry('')">全部</li>
              <li v-for="(teamitem,teamindex) in teamIndustryList" :key="teamindex" @click="changeindustry(teamitem.id)" :class="{'teamactive':isActive === teamitem.id}" >{{teamitem.preValue}}</li>
            </ul>
            <ul class="team_tab clearfix">
              <li>筛选</li>
              <li @click="handlesort('integrate')" :class="{'activesort':sortTypes === 'integrate'}">综合</li> 
              <li @click="handlesort('serviceNum')" :class="{'activesort':sortTypes === 'serviceNum'}">服务</li>
              <li @click="handlesort('popularity')" :class="{'activesort':sortTypes === 'popularity'}">人气</li>
            </ul>
            <div class="liveness_info">
              <ul>
                <li v-for="(item,index) in serviceOrgList " :key="index" @click="$router.push({path:'/serverOrgDetail',query:{orgId:item.orgId}})">
                  <a href="javascript:;">
                    <div class="liveness_img">
                      <img :src="item.orgLogo" alt="">
                    </div>
                    <div class="liveness_detail">
                      <p>{{item.orgName}}</p>
                      <p>{{item.orgSpeciality}}</p>
                      <p>
                        <el-rate v-model="item.attitudeScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041">
                        </el-rate>
                      </p>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="new_comment">
          <div class="liveness_titile">最新评价</div>
          <div class="comment_box">
            <div class="comment_list" >
              <ul class="comment_list_ul">
                <li v-for="(item,index) in RatingList" :key="index">
                    <p>{{item.evaluationAccount|hiddentel}} ：@ <span>{{item.orgName}}</span>@{{item.advisorName}}</p>
                    <p>              
                      <span :class="[item.evaluationScore>=1?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span>
                      <span :class="[item.evaluationScore>=2?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span> 
                      <span :class="[item.evaluationScore>=3?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span> 
                      <span :class="[item.evaluationScore>=4?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span> 
                      <span :class="[item.evaluationScore>=5?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span> 
                    </p>
                    <p><span>评分（{{item.evaluationScore}}）</span></p>
                    <p>"{{item.evaluationDesc}}"</p>
                    <p>{{item.createdTime}}2019-02-25  15:28:30</p>
                </li>
              </ul>
              <ul class="comment_list_ul2"></ul>
            </div>
          </div>
        </div>
      </div>
    </div><!-- 版心 -->
  </div>
</div>
</template>
<script>
import Swiper from 'swiper'
import userInfo from '../common/userInfoData'
export default {
  components: {
      userInfo
    },
  data() {
    return {
      actiTypeList:[],
      actiListSlim:[],//最新活动
      hotActiveList:[],//热门活动
      counselorList:[],//优质专员
      page:1,
      row:4,
      typeId:"a29e14a21352473ebf26420ddffb1c60",//类型带确认
      total:'',
      pageNum:'',
      IndustryList:[],//专员领域列表
      domain:'',//专员领域
      teamIndustryList:[],//机构业务领域列表
      serviceOrgList:[],//机构列表
      isActive:"",//机构类别id
      sortTypes:"",//机构排序关键词 
      RatingList:[],//最新评价列表
      isVisibility:false,
      counselorform:{
        orgname:''
      },
       offsetTop:0,
       isActClass:false,
       isNavShow:true,
       show3:false,
       searchData:'',
       select:'',
       menuShow:true,
       sliderData:[],
       sekectShow:false,
       partnerLogo:[],
       bannerList:[],
       navData:{}
    };
  },
  filters: {
    hiddentel(evaluationAccount){
      let tel=evaluationAccount.substr(0,3)+"****"+evaluationAccount.substr(7)
      return tel
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.swiperInit()  
    })
    this.getActiType()
    this.getNewActive()
    this.getHotActive()
    //专员领域列表、
    this.getIndustryList()
    //专员列表
    this.getCounselorList()
    //机构业务领域
    this.getSelectTeamList()
    //机构列表
    this.getServiceList()
    //最新评价
    this.getRatingList()
    this.selectIndustryProductList()
    window.addEventListener('scroll', this.handleScroll)
    this.getBannarList()
    this.getPartner()
    // 图标数据
    this.getNavData()
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
  },
  methods: {
    // 图标数据
    getNavData(){
      this.api.get({
        url: "getDataStatistics",
        data: { },
        dataFlag: false,
        callback: res=> {
          if (res.code == "0000") {
            this.navData=res.data
          }
        }
      });
    },
    // 轮播图列表
    getBannarList(){
      this.api.get({
        url: "getPromotionList",
        data: {
          issuePlatform:'1',
          needPage:'1',
          propagandaArea:'top',
          propagandaType:'market_banner'
        },
        callback: res=>{
          this.bannerList=res.data.rows
        }
      });
    },
    // 搜索
    goSearch(){
      if(this.select==='1'){
        this.$router.push({path:'/serverOrg',query:{searchData:this.searchData}})
      }else if(this.select==='2'){
        this.$router.push({path:'/serverPro',query:{searchData:this.searchData}})
      }else if(this.select==='3'){
        this.$router.push({path:'/serverCon',query:{searchData:this.searchData}})
      }else if(this.select==='4'){
        this.$router.push({path:'/actiTrain',query:{searchData:this.searchData}})
      }
    },
    searchLeave() {
      if (this.sekectShow) {
        this.show3 = true
      } else {
        this.show3 = false
      }
    },
    changeselectShow(val){
      this.sekectShow=val
    },
    // 合作伙伴无限滚动
    scrollpartner(){
      let speed = 50;
      let demo=document.querySelector('.partner_list');
      let demo2=document.querySelector('.partner_list_ul2');
      let demo1=document.querySelector('.partner_list_ul');
          demo2.innerHTML = demo1.innerHTML;
      function Marquee(){
        if(demo.scrollTop>=demo1.offsetHeight){
          demo.scrollTop=0;
        }
        else{
          demo.scrollTop=demo.scrollTop+1;
        }
      }
      let MyMar=setInterval(Marquee,speed);
      demo.onmouseover=function(){clearInterval(MyMar)};
      demo.onmouseout=function(){MyMar=setInterval(Marquee,speed); };
    },
    // 列表无限滚动
    scrollList(){
      let speed = 50;
      let demo=document.querySelector('.comment_list');
      let demo2=document.querySelector('.comment_list_ul2');
      let demo1=document.querySelector('.comment_list_ul');;
          demo2.innerHTML = demo1.innerHTML;
          function Marquee(){if(demo.scrollTop>=demo1.offsetHeight){
                  demo.scrollTop=0;
              }
              else{
                  demo.scrollTop=demo.scrollTop+1;
              }
          }
          let MyMar=setInterval(Marquee,speed);
          demo.onmouseover=function(){clearInterval(MyMar)};
          demo.onmouseout=function(){MyMar=setInterval(Marquee,speed); };
    },
    // 初始化swiper
    swiperInit(){
        var mySwiper = new Swiper ('.swiper-container', {
        // direction: 'horizontal', // 垂直切换选项
        loop: true, // 循环模式选项
        // 如果需要分页器
        pagination: {
          el: '.swiper-pagination',
        },
        // 如果需要前进后退按钮
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        },
      })
    },
    // 屏幕滚动
    handleScroll(){
      const osTop =
      window.pageYOffset ||
        document.documentElement.scrollTop || document.body.scrollTop;
      for (const key in this.$refs) {
        const top = this.getElementLeft(this.$refs[key]);
        if (osTop + innerHeight + 300 >= top + 100) {
          const name = this.$refs[key].dataset.class;
          this.$refs[key].classList.add(name);
        }
      }
      if (osTop>this.$refs.headContent.offsetHeight) {
      this.isActClass=true
      }else{
        this.isActClass=false
      }
      if (osTop>this.$refs.banner.offsetHeight-513-this.$refs.headContent.offsetHeight-14) {
        this.isNavShow=false
      }else{
        this.isNavShow=true
      }
    },
    getElementLeft(element) {
      var top = element.offsetTop;
      var curEle = element.offsetParent;
      while (curEle !== null) {
        top += curEle.offsetTop;
        curEle = curEle.offsetParent;
      }
      return top;
    },
    // 获取活动类型id
    getActiType() {
      let _this = this;
      this.api.post({
        url: "findActivityTypeList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.actiTypeList = res.data.rows;
          }
        }
      });
    },
    // 最新活动
    getNewActive(){
       let _this = this;
      this.api.post({
        url: "activityListSlim",
        data: {
          page: this.page,
          rows: this.row,
          typeId:this.typeId
        },
        dataFlag: false,
        callback: function(res) {
          // console.log(res);
          if (res.code == "0000") {
            _this.actiListSlim = res.data.rows;
            _this.total = res.data.total;
            _this.pageNum= Math.ceil(_this.total/_this.row) 
          }
        }
      });
    },
    // 上一页】
    prev(){
      this.page--
      if(this.page<1){
        this.$message.info("已经是第一页")
        this.page=1
        // this.page=this.pageNum
        // this.getNewActive()
      }else{
        this.getNewActive()
      }
    },
    // 下一页
    next(){
      this.page++
      if(this.page>this.pageNum){
        this.$message.info("已经是最后一页")
        this.page=this.pageNum
      }else{
        this.getNewActive()
      }
    },
    //热门产品
    getHotActive(){
      let _this = this;
      this.api.get({
        url: "findHotProducts",
        data: {
          page: this.page,
          rows: this.row
        },
        callback: function(res) {
          // console.log(res);
          if(res.code==="0000"){
            _this.hotActiveList = res.data.rows;
          }
        }
      });
    },
    // 获取专员领域
    getIndustryList(){
      let _this = this;
      this.api.get({
        url: "selectIndustryList",
        data: { },
        callback: function(res) {
          // console.log(res)
          if (res.code == "0000") {
            _this.IndustryList = res.data.rows;
          }
        }
      });
    },
    //改变专员领域列表
    changedomain(domain){
      this.domain=domain
      this.getCounselorList()
    },
    //机构业务领域
    getSelectTeamList(){
      let _this = this;
      this.api.get({
        url: "selectTeamList",
        data: {
          preType:0
         },
        dataFlag: false,
        callback: function(res) {
          // console.log(res);
          if (res.code == "0000") {
            _this.teamIndustryList = res.data;
          }
        }
      });
    },
    // 优质专员列表
    getCounselorList(){
      let _this = this;
      this.api.get({
        url: "getServiceConList",
        data: {
          domain:this.domain,
          page:1,
          rows:10
         },
        callback: function(res) {
          // console.log(res);
          if (res.code == "0000") {
            _this.counselorList = res.data.rows;
          }
        }
      });
    },
    //机构领域切换
    changeindustry(id){
      this.isActive=id
      this.getServiceList()
    },
    // 机构排序
    handlesort(sortTypes){
      this.sortTypes=sortTypes
      this.getServiceList()
    },
    // 获取服务机构列表
    getServiceList(){
      let _this = this;
      this.api.get({
        url: "selectServiceOrgList",
        data: {
          businessType:this.isActive,
          page:1,
          rows:8,
          sortTypes:this.sortTypes
         },
        callback: function(res) {
          // console.log(res);
            _this.serviceOrgList = res.data.rows;
        }
      });
    },
    //合作伙伴logo
    getPartner(){
      let _this = this;
      this.api.get({
        url: "selectServiceOrgList",
        data: {
          businessType:'',
          page:1,
          rows:50,
          sortTypes:''
         },
        callback: function(res) {
          if(res.code==='0000'){
            _this.partnerLogo = res.data.rows;
            _this.$nextTick(()=>{
              _this.scrollpartner()              
            })
          }
        }
      });
    },
    // 获取最新评价
    getRatingList(){
      let _this = this;
      this.api.get({
        url: "getServiceRatingInfo",
        data: {
          // 后台接口修改后advisorAccount不要传
          isPublicPage :1,
          needPage:1,
          page:1,
          rows:10
         },
        callback: function(res) {
          _this.RatingList = res.data.rows;
           _this.$nextTick(()=>{
              _this.scrollList()
            })
        }
      });
    },
    // 侧边导航
    selectIndustryProductList(){
      let _this = this;
      this.api.get({
        url: "selectIndustryProductList",
        data: {
      
         },
        callback: function(res) {
          _this.sliderData = res.data;
        }
      });
    }
  }
};
</script>
<style lang="scss">
.el-select-dropdown__item.selected{
  color:#00a041;
}
// 搜索弹窗
.search_box_margin{
  height: 121px;
}
.search_box{
  background: rgba(0, 0, 0,0.3);
  text-align: center;
  .el-input-group{
   
    border-radius: 28px;
    width:42%;
    margin:43px 0;
    .el-input{
      width:94px;
    }
    .el-input__inner:focus{
      border-color: #00a041;
      
    }
    .el-input-group__append, .el-input-group__prepend{
      border-radius: 28px;
    }
    .el-input-group__append{
      /* border-top-left-radius: 0;
      border-bottom-left-radius: 0; */
      background: #00a041;
      color:#fff;
      right: 58px;
      .el-button{
        margin: -10px -10px;
      }
    }
    .el-input-group__prepend{
      border-top-right-radius: 0; 
      border-bottom-right-radius: 0;
      background-color: #fff;
      padding: 0px 17px 0 9px;
      
      input{
        color:#666666;
        text-align: right;
        border-right: none;
        &:focus{
          border-left: none;
        }
      }
    }
  }
}
.search_box_act{
  background:#fff;
  box-shadow:0 10px 10px -10px #ccc;
}
// 主体
.service_market{
  .banner{
    position: relative;
    &:hover{
      .swiper-button-prev, .swiper-button-next{
        // display: block
      }
    }
    .swiper-button-prev, .swiper-button-next{
      display: block;
      width: 43px;
      height: 43px;
      border: 1px solid #fff;
      border-radius: 50%;
      background-size: 0 0;
      text-align: center;
      i{
        font-size: 36px;
        line-height: 44px;
        color:#fff;
      }
    }
    .swiper-button-next{
      right: 95px;
    }
    .swiper-button-prev{
      left:95px;
    }
  }
  .swiper-container-horizontal > .swiper-pagination-bullets .swiper-pagination-bullet{
    margin: 5px 4px;
  }
  .swiper-pagination-bullet{
    background-color: #fff;
    opacity: 0.5;
  }
   .swiper-pagination-fraction, .swiper-pagination-custom, .swiper-container-horizontal > .swiper-pagination-bullets{
      position: absolute;
      right: 152px;
      top: 0;
      left: auto;
      width: 1%;
      }
    .swiper-container{
      img{
        width:100%;
        vertical-align: middle;
      }
      .swiper-pagination{
        display: flex;
        flex-direction: column;
        justify-content: center;
      }
      .swiper-pagination-bullet-active{
        border-radius: 5px;
        height: 50px;
        background: #fff;
        opacity: 1;
      }
    }
    @keyframes bounce-up {
    25% {
        transform: translateY(5px);
    }
    50%, 100% {
        transform: translateY(0);
    }
    75% {
        transform: translateY(-5px);
        }
    }
    .animate-bounce-up{
      animation: bounce-up 2s linear infinite;
    }
    .shadow{
      text-align: center;
      position: absolute;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 20%;
      bottom: 0;
      z-index: 10;
      width: 100%;
      background: linear-gradient(to bottom, rgba(0, 0, 0, 0), rgba(0,0,0,0.4));
      img{
        height: 29%;
      }
    }
    // 版心
    .market_content{
      .market_navicon,.new_active,.hot_product,.partner,.counselor,.team{
        opacity: 0;
      }
      .allFade{
        animation: fadeInUp 3s ease 1s forwards;
      }
      width: 1190px;
      margin: 0 auto;
      .market_breadcrumb{
        margin: 15px 0;
        font-size: 16px;
      }
      .market_navicon{
        display: flex;
        margin-top: 44px;
        margin-bottom: 68px;
        a{
          &:hover{
             transform: translateY(-12px);
            }
            transition: all 0.5s;
          flex:1;
          text-align: center;
          .nav_icon{
            width:77px;
            height: 77px;
            border: 1px solid #e0dfdf;
            border-radius: 50%;
            line-height: 77px;
            margin: 0 auto;
            
            
            i{
              font-size: 36px;
              color: #00a041;
            }
          }
          .nav_discribe{
            margin:31px 0 25px 0;
            font-size: 18px;
            span>span{
              font-size: 22px;
              color: #00a041;
              margin: 0px 6px;
            }
          }
          .nav_todo{
            span{
              color:#00a041;
              font-size: 12px;
              display: block;
              width: 70px;
              height: 26px;
              border: 1px solid #00a041;
              border-radius: 16px;
              line-height: 26px;
              margin: 0 auto;
              transition: all 0.6s;
              &:hover{
                background: #ebfdf2;
                transform: scale(1.1)
              }
            }
          }
        }
      }
      //最新活动
      .new_active{
        position: relative;
        .active_title{
          display: flex;
          justify-content: space-between;
          align-items: center;
          span:nth-child(1){
            font-size: 20px;
            color:#333333;
          }
          span:nth-child(2){
            font-size: 12px;
            color:#999999;
            i{
              font-size: 12px;
            }
          }
        }
        .active_list{
          margin-top: 28px;
          .el-carousel__container{
            height: 347px;
          }
          .active_btn{
            width: 34px;
            height: 34px;
            border: 2px solid #D0D0D0;
            border-radius: 50%;
            line-height: 34px;
            text-align: center;
            span{
              color:#D0D0D0;
            }
          }
          .to_left{
            position: absolute;
            left: -5%;
            top: 44%;
          }
          .to_right{
            position: absolute;
            right: -5%;
            top: 44%;
          }
          .actiTab {
            .allActiUl {
              >li {
              &:hover img{
                transform: scale(1.3)
              }
                float: left;
                width: 280px;
                height: 345px;
                border: 1px solid #eee;
                margin-right: 20px;
                margin-bottom: 30px;
                transition: all 0.6s;
               
                &:hover{
                  box-shadow: 0px 0px 14px 3px rgba(0, 0, 0, 0.09)  
                }
                .postImgItem{
                  display: inline-block;
                  width: 100%;
                  height: 192px;
                     overflow: hidden;

                  .postImg {
                    transition: all 0.6s;
                    height: 100%;
                    width: 100%;
                  }
                }
                

                .actiNum {
                  padding: 10px;
                  border-top: 1px solid #eee;
                  color: #999;
                  font-size: 12px;
                  .avatar {
                    float: left;
                    padding-left: 10px;

                    >ul {
                      display: inline-block;

                      li {
                        float: left;
                        width: 18px;
                        height: 18px;
                        border: 1px solid #ccc;
                        border-radius: 50%;
                        margin-left: -10px;

                        img {
                          width: 100%;
                          height: 100%;
                          border-radius: 50%;
                        }
                      }
                    }
                  }

                  >i {
                    margin-left: 10px;
                  }

                  >span {
                    float: right;

                    .icon-xihuan {
                      margin-right: 5px;
                    }
                  }
                }

                .actiInfo {
                  padding: 10px;
                  color:#999;
                  font-size: 13px;
                  >.actiNameItem{
                    color:#222;
                    font-size: 16px;
                  }

                  .actiTimer {
                    text-indent: -10px;
                    margin:10px 0 5px 18px;
                  }
                }
              }

              li:nth-child(4n) {
                margin-right: 0;
              }
            }

            // 竖向排列样式
            .verticalUl {
              margin-bottom: 50px;

              >li {
                padding: 20px 0;
                border-bottom: 1px solid #ccc;

                .verticalLeft {
                  margin-right: 30px;
                  width: 304px;
                  height: 185px;

                  >img {
                    width: 100%;
                    height: 100%;
                  }
                }

                .verticalMiddle {
                  .verticalTit {
                    color: #333;
                  }

                  .xihuan {
                    margin: 15px 0;
                  }

                  .location {
                    margin: 18px 0;
                  }

                  .actiNum {
                    .avatar {
                      float: left;
                      padding-left: 10px;

                      >ul {
                        display: inline-block;

                        li {
                          float: left;
                          width: 22px;
                          height: 22px;
                          border: 1px solid #ccc;
                          border-radius: 50%;
                          margin-left: -10px;

                          img {
                            width: 100%;
                            height: 100%;
                            border-radius: 50%;
                          }
                        }
                      }
                    }

                    >.btn {
                      float: right;
                    }
                  }
                }

                .verticalRight {
                  margin-top: 145px;
                }
              }

              >li:first-child {
                padding-top: 0;
              }
            }
          }
        }
      }
      // 热门产品
      .hot_product{
        margin-top: 84px;
        margin-bottom: 87px;
        .hot_titile{
          display: flex;
          justify-content: space-between;
          align-items: center;
          span:nth-child(1){
            font-size: 20px;
            color:#333333;
          }
          span:nth-child(2){
            font-size: 12px;
            color:#999999;
            i{
              font-size: 12px;
            }
          }
        }
        .hot_list{
          margin-top: 28px;
          ul{
            display: flex;
          }
          li{
            margin-right: 2%;
            width: 24%;
            &:hover img{
              transform: scale(1.3)
            }
          }
          li:last-child{
            margin-right: 0;
          }
          .hot_img{
            display: inline-block;
            width: 100%;
            height: 192px;
            overflow: hidden;
            border-radius: 5px;
            img{
              height: 100%;
              width: 100%;
              border-radius: 5px;
              transition: all 0.6s;
            }
          }
          .hot_info{
            padding: 10px;
            color: #999;
            font-size: 12px;
            .hot_name{
              color: #222;
              font-size: 16px;
            }
            .hot_detail{
              margin: 17px 0 5px 0;
              span{
                padding-right: 7px;
              }
            }
            .hot_price{
              span:nth-child(2){
                color:#00a041;
              }
            }
          }
        }
      }
      // 合作伙伴
      .partner{
        .partner_titile{
          font-size: 28px;
          text-align: center;
        }
        .partner_box{
          width: 100%;
          border: 1px solid #dedede;
          border-radius: 10px;
          margin-top: 28px;
        }
        .partner_list{
          margin: 30px 0;
          overflow: hidden;
          height: 228px;
          padding: 13px 0;
          ul{
            display: flex;
            // justify-content: space-between;
            flex-wrap: wrap;
            // margin-bottom: 27px;
            li{
              border:1px solid #dedede;
              padding:5px 14px;
              transition: all 0.5s;
              margin-bottom: 17px;
              margin-left: 20px;
              &:hover{
                box-shadow: 0px 0px 12px 1px rgba(0, 0, 0, 0.07);     
                transform: translateY(-5px)
              }
              img{
                width:137px;
                display: block;
                // padding: 7px 10px;
                margin: 0 auto;
                height: 43px;
              }
            }
          }
        }
      }
      // 优质专员
      .counselor{
        margin-top: 73px;
        .counselor_title{
          display: flex;
          justify-content: space-between;
          align-items: center;
          span:nth-child(1){
            font-size: 20px;
            color:#333333;
          }
          span:nth-child(2){
            font-size: 12px;
            color:#999999;
            i{
              font-size: 12px;
            }
          }
        }
        .conselor_introduce{
          margin-top: 32px;
          .conselor_tab{
              li{
                float: left;
                margin-right: 17px;
                color:#666666;
                font-size: 13px;
                padding:0 5px 5px 5px;
                cursor: pointer;
              }
              .conseloractive{
                border-bottom: 3px solid #00a041;
                color:#00a041;
              }
            }
          }
          .conselor_info{
            ul{
              display: flex;
              .conselor_left{
                width: 36%;
                a{
                  border: 1px solid #dedede;
                  display: flex;
                  margin-top: 20px;
                  transition: all 0.5s;
                  &:hover{
                    box-shadow: 0px 0px 12px 1px rgba(0, 0, 0, 0.07);
                    transform: translateY(-6px);
                  }
                  .info_img{
                    width:46%;
                    div{
                      width: 157px;
                      margin: 20px auto;
                      overflow: hidden;
                      border-radius: 50%;
                    }
                    img{
                      transition: all 0.6s;
                      width: 100%;
                      border-radius: 50%;
                      display: block;
                      // margin: 20px auto;
                      width:157px;
                      height: 157px;
                    }
                  }
                  .info_all{
                    margin: auto 0;
                    .info_name{
                      padding-bottom: 18px;
                    }
                    .info_detail{
                      font-size: 12px;
                      color: #999;
                    }
                  }
                }
              }
              .conselor_mid{
                width: 63%;
                .conselor_mid_list{
                  float: left;
                  width: 50%;
                }
                a{
                  border: 1px solid #dedede;
                  display: flex;
                  margin-top: 20px;
                  margin-left: 20px;
                  transition: all 0.6s;
                  &:hover{
                    box-shadow: 0px 0px 12px 1px rgba(0, 0, 0, 0.07);
                    transform: translateY(-6px);
                  }
                  .info_img{
                    width: 27%;
                    img{
                      width: 75px;
                      height: 75px;
                      border-radius: 75px;
                      display: block;
                      margin: 6px auto;
                    }
                  }
                  .info_all{
                    margin: auto 10px;
                    .info_name{
                      padding-bottom: 18px;
                    }
                    .info_detail{
                      font-size: 12px;
                      color: #999;
                    }
                  }
                }
              }
            }
          }
        }

      }
      // 机构
      .team{
        margin-top: 187px;
        display: flex;
        margin-bottom: 200px;
        .team_liveness{
          width: 73%;
          .liveness_titile{
            font-size: 20px;
          }
          .liveness_list{
            margin-top: 32px;
            .team_tab{
              margin-bottom: 9px;
              li{
                  float: left;
                  margin-right: 17px;
                  color:#666666;
                  font-size: 13px;
                  padding:0 5px 5px 5px;
                  cursor: pointer;
                }
                .teamactive{
                  border-bottom: 3px solid #00a041;
                  color:#00a041;
                }
                .activesort{
                  color:#00a041;
                }
              }
            }
            .liveness_info{
              ul{
                display: flex;
                flex-wrap: wrap;
                li{
                  width: 20%;
                  border: 1px solid #dedede;
                  margin-right: 17px;
                  padding: 0 13px;
                  &:nth-child(4n){
                    margin-right:0;
                  }
                  &:nth-child(n+5){
                    margin-top:17px;
                  }
                  &:hover img{
                    transform: scale(1.3)
                  }
                  .liveness_img{
                    overflow: hidden;
                    margin-bottom: 15px;
                    height: 113px;
                    img{
                      margin: 0 auto;
                      width: 85%;
                      padding-top: 20px;
                      transition: all 0.6s;
                      margin: 0 auto;
                      display: block;
                    }
                  }
                  .liveness_detail{
                    text-align: center;
                    p:nth-child(1){
                      font-size: 16px;
                    }
                    p:nth-child(2){
                      font-size: 12px;
                      color: #ccc;
                      margin: 12px 0;
                       height: 32px;
                      // width:100%;
                      // display: inline-block;
                      overflow: hidden;
                      text-overflow: ellipsis;
                      display: -webkit-box;
                      -webkit-line-clamp:2;
                      -webkit-box-orient: vertical;
                    }
                    p:nth-child(3){
                      padding-bottom: 28px;
                      padding-top: 5px;
                      span{
                        padding-right: 6px;
                        color:#e1e1e1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        .new_comment{
          
          flex:1;
          margin-left: 9px;
          .liveness_titile{
            font-size: 20px;
          }
          .comment_box{
            width: 100%;
            border: 1px solid #dedede;
            margin-top: 24px;
            .comment_list{
              height: 572px;
              width:95%;
              overflow: hidden;
              margin: 17px auto;
              ul{
                display: flex;
                padding: 5px 15px;
                flex-wrap: wrap;
                li{
                  border-bottom: 1px solid #dedede;
                  width: 100%;
                  margin-bottom: 7px;
                  &:last-child {
                    border-bottom:none;
                    p:nth-child(5){
                      padding-bottom: 2px;
                    }
                  }
                  
                  p:nth-child(1){
                    font-size: 14px;
                    // padding-top: 13px;
                  }
                  p:nth-child(2){
                    font-size: 14px;
                    padding-top:7px;
                    color:#e1e1e1;
                    .brightstar{
                      color: #00a041;
                    }
                    span{
                      font-size: 14px;
                      padding-right: 2px;
                    }
                  }
                  p:nth-child(3){
                    color:#999999;
                    font-size: 12px;
                    padding:8px 0;
                  }
                  p:nth-child(4){
                    font-size: 14px;
                    color:#00a041;
                    margin-bottom: 7px;
                    height: 19px;
                    overflow: hidden;
                    text-overflow: ellipsis;
                    display: -webkit-box;
                    -webkit-line-clamp: 1;
                    -webkit-box-orient: vertical;
                  }
                  p:nth-child(5){
                    color:#999999;
                    font-size: 12px;
                    padding-bottom: 10px;
                  }
                }
              }
            }
          }
          // .swiper-container {
          //   width: 100%;
          //   height: 100%;
          // }
          // .swiper-slide {
          //   // width:100%;
          //   height: 100%;
          //   box-sizing: border-box;
          //   padding: 30px;
          // }
        }
    }
.el-carousel__container{
    height: 388px;
}
// 头部
.indexHeader {
  position: fixed;
  width: 100%;
  z-index: 100;
  .headContent {
    .bannerNav {
      width: 100%;
      color: #fff;
      background: rgba(255,255,225,0.1);
      .type_page{
        display: flex;
        justify-content: space-between;
        align-items: center;
        width: 84%;
      }
      .title{
        font-size: 25px;
        margin-left: 20px;
      }
      .titleImg {
        display: flex;
            width: 22%;
        div:nth-child(1){
          width: 50%;
        }
        img {
          width: 100%;
          height: 100%;
          vertical-align: middle;
        }
      }
      .bannerUl {
        list-style: none;
        line-height: 64px;
        font-size: 13px;
        display: flex;
        margin: 0 7%;
        flex: 1;
        justify-content: space-around;
        text-align: center;
          li {
          width: 16%;
          cursor: pointer;
          border-radius: 5px;
        }
        .active_header{
          background: #fff;
          color:#00a041;
        }
        .liActiv{
          // background-color:#00a041;
          // color:#00a041;
        }
      }
      .headerRight {
        font-size: 12px;
        display: flex;
        line-height: 65px;
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
          .line {
            display: inline-block;
            height: 12px;
            margin: 0 15px;
          }
        }
      }
    }
    .bannerNavAct{
      background-color: #fff;
      color: black;
      border-bottom: 1px solid #eee;
      box-shadow:0 10px 10px -10px #ccc;
    }
  }
  // 侧边栏
  .fadeInDown{
    animation-duration: 1s;
  }
  .fadeOutUp{
    animation-duration: 0.5s;
  }
  .nav{
    // animation: fadeInDown 3s ;
    position: absolute;
    left: 13%;
    width: 12%;
    margin-top: 14px;
    font-size: 13px;
    // border:1px solid black;
    .nav_cont{
      display: flex;
      flex-wrap: wrap;
      // a{
      // }
      .nav_cont_son {
        display: none;
        color:#fff;
        background: rgba(0, 0, 0,0.3);
        padding:20px 20px;
        cursor: pointer;
        span{
            display: inline-block;
            width: 5px;
            height: 5px;
            border-radius: 50%;
            background-color: #fff;
            margin-right: 8px;
          }
        div:hover{
          color:#00a041;
        }
        div:hover span{
          background-color: #00a041;
        }
      }
     
      &:hover .nav_cont_son {
        display: flex;
        flex-wrap: wrap;
        position: absolute;
        right: -366px;
        background: rgba(0, 0, 0,0.3);
        width: 326px;
        div{
          width: 50%;
          line-height: 40px;
        }
      }
      &:hover .hidder_son{
        display: none;
      }
      &:hover .nav_cont_father{
        background-color: #fff;
        color:#00a041;
      }
      .nav_cont_father{
        background: rgba(0, 0, 0,0.3);
        // position: relative;
        width: 100%;
        color:#fff;
        padding:20px 20px 20px 28px;
        display: flex;
        justify-content: space-between;
        cursor: pointer;
      }
    }
  }
  
}
</style>

<template>
  <div class="service_market">
    <!-- 大图 -->
    <div class="navImg"></div>
    <div class="market_content"><!-- 版心 -->
      <div class="market_breadcrumb">
          <!-- <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
            <el-breadcrumb-item>
              <a href="/">服务超市</a>
            </el-breadcrumb-item>
          </el-breadcrumb> -->
          <span class="pointer" @click="$router.push({path:'/enterpriseservice'})">企业服务</span>
          <span>/</span>
          <span class="mainColor">服务超市</span>
      </div>
      <div class="market_navicon">
        <a href="javascript:;">
          <div class="nav_icon"><i class="iconfont icon-jigou2"></i></div>
          <div class="nav_discribe"> <span>已注册买家<span class="">8929</span>个</span> </div>
          <div class="nav_todo"><span>申请注册</span></div>
        </a>
        <a href="javascript:;">
          <div class="nav_icon"><i class="iconfont icon-jigou1"></i></div>
          <div class="nav_discribe"> <span>已入驻机构 <span>1057</span>家</span> </div>
          <div class="nav_todo"><span>机构入驻</span></div>
        </a>
        <a href="javascript:;">
          <div class="nav_icon"><i class="iconfont icon-huodong"></i></div>
          <div class="nav_discribe"> <span>累计举办活动<span>378</span>场</span> </div>
          <div class="nav_todo"><span>近期活动</span></div>
        </a>
        <a href="javascript:;">
          <div class="nav_icon"><i class="iconfont icon-jigou11"></i></div>
          <div class="nav_discribe"> <span>已入驻顾问<span>3786</span>人</span> </div>
          <div class="nav_todo" @click="isVisibility=true"><span>申请顾问</span></div>
        </a>
        <a href="javascript:;">
          <div class="nav_icon"><i class="iconfont icon-shangwuqianbiqian"></i></div>
          <div class="nav_discribe"> <span>已入驻投资人<span>956</span>人</span> </div>
          <div class="nav_todo"><span>投资人入驻</span></div>
        </a>
      </div>
      <!-- 申请顾问弹窗 -->
      <el-dialog title="申请顾问" :visible.sync="isVisibility" center>
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
      <div class="new_active" >
        <div class="active_title">
          <span>最新活动</span>
          <span>MORE<i class="iconfont icon-you"></i></span>
        </div>
        <div class="active_list">
          <div class="active_btn to_left" @click="prev"><span class="iconfont icon-zuo" ></span></div>
          <el-carousel indicator-position="none" arrow="never" loop :autoplay="false">
            <el-carousel-item v-for="(pageItem,pageIndex) in pageNum" :key='pageIndex'>
              <div class="actiTab">
                <ul class="allActiUl clearfix">
                  <li v-for="(item,index) in actiListSlim" :key='index'>
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
                          <li v-for="(i,k) in item.avatarList" v-if="i<5" :key='k'><img :src="i" alt=""></li>
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
        <div class="hot_product">
          <div class="hot_titile">
            <span>热门产品</span>
            <span>MORE<i class="iconfont icon-you"></i></span>
          </div>
          <div class="hot_list">
            <ul class="clearfix">
              <li v-for="(item,index) in hotActiveList" :key="index">
                <div class="hot_img">
                  <img :src="item.pictureUrl" alt="">
                </div>
                <div class="hot_info">
                  <div class="hot_name">{{item.productName}}</div>
                  <div class="hot_detail">
                    <span>机构  {{item.orgCount}}</span>
                    <span>顾问  {{item.advisorCount}}</span>
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
      <div class="partner">
        <div class="partner_titile">战略合作伙伴</div>
        <div class="partner_list">
          <ul>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>             
          </ul>
          <ul>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>             
          </ul>
          <ul>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>
            <li> <img src="../../assets/image/testsn.png" alt=""> </li>             
          </ul>
        </div>
      </div>
      <!-- 优质顾问 -->
      <div class="counselor">
        <div class="counselor_title">
          <span>优质顾问</span>
          <span>MORE<i class="iconfont icon-you"></i></span>
        </div>
        <div class="conselor_introduce">
          <ul class="conselor_tab clearfix">
            <li :class="{'active':domain === ''}" @click="changedomain('')">全部</li>
            <li v-for="(counseloitem,counseloindex) in IndustryList" :key="counseloindex" :class="{'active':domain === counseloitem.id}" @click="changedomain(counseloitem.id)">{{counseloitem.preValue}}</li>
          </ul>
          <div class="conselor_info">
            <ul>
              <!-- v-show控制前两个大图 -->
              <li class="conselor_left">
                <div v-for="(counselorinfoItem,counselorinfoindex) in counselorList" :key="counselorinfoindex" v-show="counselorinfoindex<2">
                  <a href="javascript:;">
                    <div class="info_img"><img src="../../assets/image/test2.png" alt=""></div>
                    <!-- <div class="info_img"><img :src="counselorinfoItem.avatar" alt=""></div> -->
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
                <div v-for="(counselorinfoItem2,counselorinfoindex2) in counselorList" :key="counselorinfoindex2" class="conselor_mid_list" v-show="counselorinfoindex2>=2&&counselorinfoindex2<10">
                  <a href="javascript:;">
                    <div class="info_img"><img src="../../assets/image/test2.png" alt=""></div>
                    <!-- <div class="info_img"><img :src="counselorinfoItem.avatar" alt=""></div> -->
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
      <div class="team">
        <div class="team_liveness">
          <div class="liveness_titile">机构活跃度</div>
          <div class="liveness_list">
            <ul class="team_tab clearfix">
              <li :class="{'active':isActive === ''}" @click="changeindustry('')">全部</li>
              <li v-for="(teamitem,teamindex) in teamIndustryList" :key="teamindex" @click="changeindustry(teamitem.id)" :class="{'active':isActive === teamitem.id}" >{{teamitem.preValue}}</li>
            </ul>
            <ul class="team_tab clearfix">
              <li>筛选</li>
              <li @click="handlesort('integrate')" :class="{'activesort':sortTypes === 'integrate'}">综合</li> 
              <li @click="handlesort('serviceNum')" :class="{'activesort':sortTypes === 'serviceNum'}">服务</li>
              <li @click="handlesort('popularity')" :class="{'activesort':sortTypes === 'popularity'}">人气</li>
            </ul>
            <div class="liveness_info">
              <ul>
                <li v-for="(item,index) in serviceOrgList " :key="index">
                  <a href="javascript:;">
                    <div class="liveness_img">
                      <!-- <img :src="item.orgLogo" alt=""> -->
                      <img src="../../assets/image/test3.png" alt="">
                    </div>
                    <div class="liveness_detail">
                      <p>{{item.orgName}}</p>
                      <p>{{item.orgSpeciality}}</p>
                      <p><span class="iconfont icon-xing" v-for="(item,index) in 5" :key="index"></span></p>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="new_comment">
          <div class="liveness_titile">最新评价</div>
          <div class="comment_list">
            <ul>
              <li v-for="(item,index) in RatingList" :key="index">
                <p>{{item.evaluationAccount|hiddentel}} ：@ <span>{{item.orgName}}</span>@{{item.advisorName}}</p>
                <p>
                  <span :class="[item.evaluationScore>=1?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span>
                  <span :class="[item.evaluationScore>=2?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span> 
                  <span :class="[item.evaluationScore>=3?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span> 
                  <span :class="[item.evaluationScore>=4?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span> 
                  <span :class="[item.evaluationScore>=5?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span> 
                  <!-- <span  v-for="(staritem,starindex) in 5" :key="starindex" :class="[starindex>=item.evaluationScore?'iconfont icon-xing brightstar':'iconfont icon-xing']"></span> -->
                  <!-- <span  v-for="(staritem,starindex) in 5" :key="starindex" class="iconfont icon-xing brightstar" v-show="starindex<=item.evaluationScore"></span>
                  <span  v-for="(staritem,starindex) in 5" :key="starindex" class="iconfont icon-xing" v-show="starindex>=item.evaluationScore"></span> -->
                </p>
                <p><span>评分（{{item.evaluationScore}}）</span></p>
                <p>"{{item.evaluationDesc}}"</p>
                <p>{{item.createdTime}}2019-02-25  15:28:30</p>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div><!-- 版心 -->
  </div>
</template>
<script>
export default {
  data() {
    return {
      actiTypeList:[],
      actiListSlim:[],//最新活动
      hotActiveList:[],//热门活动
      counselorList:[],//优质顾问
      page:1,
      row:4,
      typeId:"a29e14a21352473ebf26420ddffb1c60",//类型带确认
      total:'',
      pageNum:'',
      IndustryList:[],//顾问领域列表
      domain:'',//顾问领域
      teamIndustryList:[],//机构业务领域列表
      serviceOrgList:[],//机构列表
      isActive:"",//机构类别id
      sortTypes:"",//机构排序关键词 
      RatingList:[],//最新评价列表
      isVisibility:false,
      counselorform:{
        orgname:''
      }
    };
  },
  filters: {
    hiddentel(evaluationAccount){
      let tel=evaluationAccount.substr(0,3)+"****"+evaluationAccount.substr(7)
      return tel
    }
  },
  mounted() {
    this.getActiType()
    this.getNewActive()
    this.getHotActive()
    //顾问领域列表、
    this.getIndustryList()
    //顾问列表
    this.getCounselorList()
    //机构业务领域
    this.getSelectTeamList()
    //机构列表
    this.getServiceList()
    //最新评价
    this.getRatingList()
  },
  methods: {
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
          console.log(res);
          _this.hotActiveList = res.data.rows;
        }
      });
    },
    // 获取顾问领域
    getIndustryList(){
      let _this = this;
      this.api.get({
        url: "selectIndustryList",
        data: { },
        callback: function(res) {
          // console.log(res);
          if (res.code == "0000") {
            _this.IndustryList = res.data.rows;
          }
        }
      });
    },
    //改变顾问领域列表
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
    // 优质顾问列表
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
          rows:4
         },
        callback: function(res) {
          // console.log(res);
          _this.RatingList = res.data.rows;
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
  .service_market{
    .navImg{
        height: 454px;
        background: url("../../../static/img/banner.png") 100% 100% no-repeat;
        background-size: 100% 100%;
    }
    .market_content{
      width: 1190px;
      margin: 0 auto;
      .market_breadcrumb{
        margin: 15px 0;
        font-size: 16px;
      }
      .market_navicon{
        display: flex;
        margin-top: 44px;
        a{
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
            }
          }
        }
      }
      //最新活动
      .new_active{
        margin-top: 68px;
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
            // margin-bottom: 30px;
            .allActiUl {
              // overflow: hidden;
              >li {
                float: left;
                width: 280px;
                height: 345px;
                border: 1px solid #eee;
                margin-right: 20px;
                margin-bottom: 30px;
                .postImgItem{
                  display: inline-block;
                  width: 100%;
                  height: 192px;
                  .postImg {
                    
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
      // 热门活动
      .hot_product{
        margin-top: 84px;
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
            // float: left;
            // width: 275px;
            // height: 345px;
                margin-right: 2%;
                width: 24%;
          }
              li:last-child{
                margin-right: 0;
              }
          .hot_img{
            display: inline-block;
            width: 100%;
            height: 192px;
            img{
              height: 100%;
              width: 100%;
              border-radius: 5px;
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
        margin-top: 87px;
        .partner_titile{
          font-size: 28px;
          text-align: center;
        }
        .partner_list{
          margin-top: 39px;
          ul{
            display: flex;
            justify-content: space-between;
            margin-bottom: 27px;
            li{
              border:1px solid #dedede;
              padding:5px 14px;
              img{
                width:77%;
                display: block;
                padding: 7px 10px;
                margin: 0 auto;
              }
            }
          }
        }
      }
      // 优质顾问
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
              }
              .active{
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
                  .info_img{
                    width:46%;
                    img{
                      width: 80%;
                      border-radius: 50%;
                      display: block;
                      margin: 20px auto;
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
                  .info_img{
                    width: 27%;
                    img{
                      width: 79%;
                      border-radius: 50%;
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
                }
                .active{
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
                  .liveness_img{
                    height: 113px;
                    img{
                      margin-left: 57px;
                      height: 63%;
                      padding-top: 20px;
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
          .comment_list{
            margin-top: 33px;
            border: 1px solid #dedede;
            ul{
              padding: 0 15px;
              li{
                border-bottom: 1px solid #dedede;
                height: 142px;
                &:last-child{
                   border-bottom:none;
                }
                p:nth-child(1){
                  font-size: 14px;
                  padding-top: 13px;
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
    }
  .el-carousel__container{
    height: 388px;
  }
</style>

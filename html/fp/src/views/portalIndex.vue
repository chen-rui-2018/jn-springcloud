<template>
  <div class="portalIndex1 ">
    <div class="portalCon1 w">
      <div class="bannerangPark">
        <div class="bannerImg pr">
          <el-carousel indicator-position="outside" @change='changImg' arrow="always">
            <el-carousel-item v-for="(banner, index) in bannerList" :key="index">
              <img :src="banner.posterUrl" alt="">
            </el-carousel-item>
          </el-carousel>
          <div class="bannerText color3">
            <ul :style="`top:${ulTopNum}px;${hastrFlag ? 'transition: all 0.5s;' : ''}`">
              <li v-for="banner in bannerList">{{banner.propagandaTitle}}</li>
              <li v-for="(banner, index) in bannerList" :key="index" v-if="index == bannerList.length - 1">{{banner.propagandaTitle}}</li>
            </ul>
          </div>
          <!-- <div class="swiper-container"> -->
          <!-- <div class="swiper-wrapper"> -->
          <!-- <div class="swiper-slide swiper-no-swiping" > -->
          <!-- <div class="swiper-slide" v-for="(banner, index) in bannerList" :key="index">
              <img :src="banner.posterUrl" alt="">
            </div> -->

          <!-- <div class="swiper-slide" style="width:100%" v-for="(banner, index) in bannerList" :key="index">
                <img :src="banner.posterUrl" alt="">
              </div> -->
          <!-- <div class="swiper-slide" style="width:100%">
                <img src="@/../static/img1/banner.png" alt="">
              </div>
              <div class="swiper-slide" style="width:100%">
                <img src="@/../static/img1/banner.png" alt="">
              </div> -->
          <!-- </div> -->
          <!-- 如果需要分页器 -->
          <!-- <div class="swiper-pagination"></div> -->

          <!-- 如果需要导航按钮 -->
          <!-- <div class="swiper-button-prev">
            </div>
            <div class="swiper-button-next">
            </div> -->

          <!-- 如果需要滚动条 -->
          <!-- <div class="swiper-scrollbar"></div> -->
          <!-- </div> -->
        </div>
        <div class="parkNotice">
        </div>
      </div>
      <div class="parkandpolicy pr">
        <div class="moreList pointer color3" @click.stop.prevent="handleTab">MORE
          <i class="el-icon-arrow-right"></i>
        </div>
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="园区资讯" name="first">
            <div class="noticeList">
              <ul>
                <li class="noticeLi pointer" v-if="k<4" v-for="(i,k) in noticeList" :key="k" @click="$router.push({path:'/announcementDetails',query:{noticeId:i.id}})">
                  <div class="date" v-if="i.createdTime">
                    <div class="year">{{i.createdTime.slice(0,4)}}</div>
                    <div class="month color3">{{i.createdTime.slice(5,10)}}</div>
                  </div>
                  <div class="noticeCon">
                    <div class="clearfix">
                      <h5 class="fl">{{i.title}}</h5>
                      <span class="fr mainColor" v-if="i.isStick=='1'">置顶</span>
                    </div>
                    <p class="color3">{{i.noticeBiref}}</p>
                  </div>
                </li>
              </ul>
            </div>
          </el-tab-pane>
          <el-tab-pane label="政策指南" name="second">
            <div class="noticeList">
              <ul>
                <li class="noticeLi pointer" v-for="(i,k) in policyCenterList" :key="k" @click="$router.push({path:'/policyGuide',query:{policyId:i.id}})">
                  <div class="date" v-if="i.createdTime">
                    <div class="year">{{i.createdTime.slice(0,4)}}</div>
                    <div class="month color3">{{i.createdTime.slice(5,10)}}</div>
                  </div>
                  <div class="noticeCon">
                    <div class="clearfix">
                      <h5 class="fl">{{i.title}}</h5>
                      <span class="fr mainColor" v-if="i.isStick=='1'">置顶</span>
                    </div>
                    <p class="color3">{{i.noticeBiref}}</p>
                  </div>
                </li>
              </ul>
            </div>
          </el-tab-pane>
          <el-tab-pane label="热门活动" name="third">
            <div class="noticeList">
              <ul>
                <li class="noticeLi pointer" v-for="(i,k) in actiListSlim" :key="k" @click="$router.push({ path: '/actiDetail', query: { activityId: i.id } })">
                  <div class="date" v-if="i.createdTime">
                    <div class="year">{{i.createdTime.slice(0,4)}}</div>
                    <div class="month color3">{{i.createdTime.slice(5,10)}}</div>
                  </div>
                  <div class="noticeCon">
                    <div class="clearfix">
                      <h5 class="fl">{{i.title}}</h5>
                      <span class="fr mainColor" v-if="i.isStick=='1'">置顶</span>
                    </div>
                    <p class="color3">{{i.noticeBiref}}</p>
                  </div>
                </li>
              </ul>
            </div>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
    <div class="portalCon2">
      <div class="parkCon w1">
        <div class="parkTitle w clearfix">
          <h5 class="fl">白下高新区介绍</h5>
          <div class="moreList pointer color3 fr" @click="$router.push({path:'/parkIntroduction'})">MORE
            <i class="el-icon-arrow-right"></i>
          </div>
        </div>
        <div class="parksList">
          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div class="swiper-slide" style="width:100%" v-for="(item,index) in enterpriseList" :key="index">
                <ul class="parkUl w clearfix">
                  <li class="fl pointer" v-for="(i,k) in item" :key="k" :data-path="`/parkIntroductionChild?id=${i.id}`">
                    <div class="imgItem">
                      <img :src="i.mainPicture" alt="">
                    </div>
                    <div class="licon">
                      <h5>{{i.parkName}}</h5>
                      <div class="liBerif">
                        {{i.shortIntroduce}}
                      </div>
                      <div class="liDetail mainBorder pointer" @click="$router.push({path:'/parkIntroductionChild',query:{id:i.id}})">了解详情</div>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
            <div class="swiper-pagination" style="display:none"></div>
            <div class="swiper-button-prev" v-show="enterpriseList.length>1"></div>
            <div class="swiper-button-next" v-show="enterpriseList.length>1"></div>
          </div>
          <!-- <ul class="parkUl">
            <li v-for="(i,k) in enterpriseList" v-if="k<4" :key="k">
              <div class="imgItem">
                <img :src="i.mainPicture" alt="">
              </div>
              <div class="licon">
                <h5>{{i.parkName}}</h5>
                <div class="liBerif">
                  园区将以军民融合为产业核心，努力搭建军 民融合产业发展平台，集聚“军转民、民..
                </div>
                <div class="liDetail mainBorder pointer">了解详情</div>
              </div>
            </li>
          </ul> -->
        </div>
        <div class="parkInfo w">
          <ul class="infoUl">
            <li v-for="(i,k) in advantages" :key="k" @click="$router.push({path:'/parkAdvantage',query:{activeName:i.actiName}})">
              <img :src='"@/../static/img1/"+i.id+".png"' alt="">
              <p class="color3">{{i.name}}</p>
            </li>
          </ul>
          <div class="infoMes">
            <div class="ad">
              <img src="@/../static/img1/dizhi01.png" alt="">
              <span class="color2">地址：中国南京秦淮区紫丹路9号</span>
            </div>
            <div class="phone1">
              <img src="@/../static/img1/dianhua.png" alt="">
              <span class="color2">招商热线：
                <i>86-025-58815888</i>
              </span>
            </div>
            <div class="phone1">
              <img src="@/../static/img1/dianhua.png" alt="">
              <span class="color2">服务热线：
                <i>86-025-69978843</i>
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="enterpriseList w">
      <div class="parkTitle clearfix">
        <h5 class="fl">白下高新区企业</h5>
        <div class="moreList pointer color3 fr" @click="$router.push({path:'/companyProfile'})">MORE
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>
      <div class="enterpriseCon">
        <ul class="enterpriseUl">
          <li class="pointer" v-for="(i,k) in companyList" :key="k" @click="$router.push({path:'/companyProfile',query:{id:i.id}})">
            <img :src='"@/../static/img1/"+i.id+".png"' alt="">
            <p>{{i.name}}</p>
          </li>
        </ul>
      </div>
    </div>
    <div class="enterprisePro">
      <div class="productCon w">
        <div class="parkTitle clearfix">
          <h5 class="fl">企业产品</h5>
          <div class="moreList pointer color3 fr" @click="$router.push({path:'/serverPro'})">MORE
            <i class="el-icon-arrow-right"></i>
          </div>
        </div>
        <div class="proList">
          <ul class="proUl">
            <li v-for="(i,k) in hotActiveList" class="pointer" :key="k" @click="$router.push({path:'/serverProDetail',query:{productId:i.productId,signoryId:i.signoryId}})">
              <div class="imgItem">
                <img :src="i.pictureUrl" alt="">
              </div>
              <div class="licon clearfix">
                <h5>{{i.productName}}</h5>
                <div class="liBerif">
                  {{i.productBrief}}
                </div>
                <div class="liDetail mainBorder pointer fr" @click="$router.push({path:'/serverProDetail',query:{productId:i.productId,signoryId:i.signoryId}})">了解详情</div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="link w clearfix">
      <h5 class="tit fl">链接:</h5>
      <ul class="linkUl fl clearfix">
        <li>
          <a href="http://ids.nanjing.gov.cn:8081/12345/regedit/regedit.html" target="_blank">12345注册</a>
        </li>
        <li class="line"></li>
        <li>
          <a href="http://nj.jszwfw.gov.cn/" target="_blank">南京市政务服务网</a>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
import swiper from "swiper";
export default {
  data() {
    return {
      activeName: "first",
      companyList: [
        { id: "bigData_intelligence", name: "大数据与人工智能" },
        { id: "internet_of_things", name: "物联网" },
        { id: "internet", name: "互联网" },
        { id: "modern_service", name: "现代服务业" },
        { id: "electronic_information", name: "电子信息" },
        { id: "biomedicine", name: "生物医药" },
        { id: "new_materials_energy", name: "新材料与新能源" },
        { id: "intelligence_equipment", name: "智能制造与高端装备制造" }
      ],
      advantages: [
        { id: "diqiu", name: "地理优势",actiName:'1' },
        { id: "guihuasheji", name: "规划定位",actiName:'2' },
        { id: "qiyexinxiguanli_huaban", name: "基础设施" ,actiName:'3'},
        { id: "xiaochengxu", name: "招商优势" ,actiName:'4'}
      ],
      enterpriseList: [],
      noticeList: [],
      bannerList: [],
      policyCenterList: [],
      actiListSlim: [],
      hotActiveList: [],
      imgIndex: 0,
      ulTopNum: 0,
      hastrFlag: true,
      tabFlag: "first"
    };
  },
  mounted() {
    // this.swiperInit();
    // this.getCompanyList();
    this.getBusinessAdContent();
    this.showNoticeList();
    this.getBannerList();
    // this.getPolicyCenterList();
    // this.getActiList();
    this.getHotActive();
    this.$router.afterEach((to, from, next) => {
      window.scrollTo(0, 0);
    });
    const calrousel = document.getElementsByClassName("el-carousel")[0];
    // const calrousel = document.querySelector(".el-carousel")
    calrousel.style.height = calrousel.scrollHeight;
  },
  methods: {
    swiperinit() {
      let _this = this;
      new swiper(".swiper-container", {
        loop: true, // 循环模式选项
        noSwiping: true,
        autoplay: true,
        autoplay: {
          delay: 5000
        },
        observer: false,
        // 如果需要分页器
        pagination: {
          el: ".swiper-pagination"
        },
        // 如果需要前进后退按钮
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
        },
        on: {
          click: function(e) {
            if(e.path[2].getAttribute("data-path") == null){
                return
            }
            let path = e.path[2].getAttribute("data-path");
            _this.$router.push(path);
          }
        },
        // 如果需要滚动条
        scrollbar: {
          el: ".swiper-scrollbar"
        }
      });
    },
    formatArr(arr, n) {
      const len = arr.length;
      let lineNum = len % 4 === 0 ? len / 4 : Math.floor(len / 4 + 1);
      const result = [];
      for (let i = 0; i < lineNum; i++) {
        // slice() 方法返回一个从开始到结束（不包括结束）选择的数组的一部分浅拷贝到一个新数组对象。且原始数组不会被修改。
        let temp = arr.slice(i * n, i * n + n);
        result.push(temp);
      }
      return result;
    },
    handleTab() {
      if (this.tabFlag == "first") {
        this.$router.push({ path: "/noticeList" });
      } else if (this.tabFlag == "second") {
        this.$router.push({ path: "/policyCenter" });
      } else {
        this.$router.push({ path: "/actiCenter" });
      }
    },
    changImg(i, h) {
      if (this.bannerList.length <= 1) {
        return;
      }
      if (h == this.bannerList.length - 1 && i != h - 1) {
        this.imgIndex = h + 1;
        this.ulTopNum = this.imgIndex * -20;
        setTimeout(() => {
          this.hastrFlag = false;
          this.imgIndex = 0;
          this.ulTopNum = 0;
          setTimeout(() => {
            this.hastrFlag = true;
          }, 250);
        }, 700);
        return;
      }
      this.imgIndex = i;
      this.ulTopNum = i * -20;
    },
    handleClick(tab) {
      this.tabFlag = tab.name;
    },
    swiperInit() {
      new swiper(".swiper-container", {
        loop: true, // 循环模式选项
        noSwiping: true,
        autoplay: true,
        autoplay: {
          delay: 5000
        },
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
    // 首页轮播图
    getBannerList() {
      // return new Promise((resolve, reject) => {
      this.api.get({
        url: "getPromotionList",
        data: {
          issuePlatform: 2,
          // propagandaType: 'home_banner_pc',//没有图片，暂时先用招商的测试
          propagandaType: "home_banner",
          needPage: 0
        },
        callback: res => {
          if (res.code === "0000") {
            res.data.rows = res.data.rows.concat(res.data.rows);
            res.data.rows = res.data.rows.concat(res.data.rows);
            this.bannerList = res.data.rows;
          } else {
            this.$message.error(res.result);
          }
        }
      });
      // });
    },
    //园区公告
    showNoticeList() {
      let _this = this;
      this.api.get({
        url: "integrationList",
        data: {
          // page: 1,
          // rows: 4
        },
        callback: function(res) {
          if (res.code == "0000") {
            for (let it in res.data) {
              if (res.data[it].type == "1") {
                _this.noticeList.push(res.data[it]);
              } else if (res.data[it].type == "2") {
                _this.policyCenterList.push(res.data[it]);
              } else if (res.data[it].type == "3") {
                _this.actiListSlim.push(res.data[it]);
              } else {
                // _this.enterpriseNature.push(res.data[it]);
              }
            }
            // _this.noticeList = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    // 园区介绍
    getBusinessAdContent() {
      let _this = this;
      this.api.get({
        url: "getParkList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            // _this.enterpriseList = res.data;
            _this.enterpriseList = _this.formatArr(res.data, 4);
            setTimeout(() => {
              _this.swiperinit();
            }, 0);
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //热门产品
    getHotActive() {
      let _this = this;
      this.api.get({
        url: "findHotProducts",
        data: {
          page: 1,
          rows: 4
        },
        callback: function(res) {
          if (res.code === "0000") {
            _this.hotActiveList = res.data.rows;
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.portalIndex1 {
  @keyframes qfyfadeInLeft {
    0% {
      opacity: 0;
      transform: translateY(0);
    }
    100% {
      opacity: 1;
      transform: translateY(10%);
    }
  }
  @keyframes topa {
    from {
      transform: translateX(0);
    }
    to {
      transform: translateX(5%);
    }
  }
  .el-tabs__nav-wrap::after {
    height: 1px;
  }
  // .el-tabs__active-bar {
  //   width: 30px !important;
  //   transform: translateX(14px) !important;
  // }
  .el-tabs__header {
    margin: 0;
  }
  .el-tabs__item {
    color: #999;
  }
  .el-tabs__item:hover {
    color: #00a041;
    cursor: pointer;
  }

  .el-tabs__item.is-active {
    color: #00a041;
  }
  .portalCon1 {
    padding-top: 120px;
    display: flex;
    // align-items: center;
    justify-content: space-between;
    .el-carousel {
      // height: 391px;
      overflow: hidden;
      text-align: right;
    }
    .el-carousel__container {
      height: 350px;
    }
    .el-carousel__indicators--outside {
      height: 40px;
      position: relative;
      display: inline-block;
      left: 0;
      bottom: 0;
    }
    .el-carousel__indicator {
      padding: 14px 4px;
    }
    .el-carousel__indicator:nth-child(1) {
      // margin-left: 476px;
    }
    .el-carousel__button {
      width: 12px;
      height: 12px;
      border-radius: 50%;
    }
    .el-carousel__indicator.is-active button {
      background: #fff;
      border: 1px solid #00a041;
    }
    .el-carousel__arrow {
      background: none;
      top: 106%;
      color: #999;
      height: unset;
      width: unset;
      font-size: 15px;
    }
    .el-carousel__arrow--left {
      left: 0;
    }
    .el-carousel__arrow--right {
      left: 20px;
    }
    .bannerangPark,
    .parkandpolicy {
      width: 48%;
      img {
        width: 100%;
      }
    }
    .bannerImg {
      .bannerText {
        position: absolute;
        bottom: 10px;
        height: 20px;
        overflow: hidden;
        margin-left: 50px;
        width: 60%;
        ul {
          position: relative;
          li {
            font-size: 14px;
            height: 20px;
            line-height: 20px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
          }
        }
      }
      .el-carousel__item {
        width: 571px;
        height: 350px;
      }
      img {
        width: 100%;
        height: 100%;
      }
    }
    .parkandpolicy {
      .moreList {
        position: absolute;
        right: 0;
        top: 10px;
        z-index: 3;
        font-size: 15px;
      }
      .el-icon-arrow-right {
        margin-left: 5px;
      }
      .noticeList {
        .noticeLi {
          display: flex;
          justify-content: space-between;
          border-bottom: 1px solid #eee;
          padding: 20px 0;
          transition: all 0.5s;
        }
        .noticeLi:hover {
          // background: #f5f5f5;
          h5 {
            color: #00a041;
            font-weight: bold;
          }
        }
        .noticeLi:nth-child(1) {
          // padding-top: 0;
        }
        .date {
          width: 10%;
          border-right: 1px solid #eee;
          text-align: left;
          .year {
            font-size: 20px;
            color: #666;
          }
          .month {
            font-size: 13px;
            // text-align: center;
          }
        }
        .noticeCon {
          width: 87%;
          > div {
            font-size: 15px;
          }
          h5 {
            color: #333;
            font-size: 15px;
          }
          p {
            font-size: 13px;
            margin-top: 5px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            height: 17px;
            text-align: left !important;
          }
        }
      }
    }
  }
  .portalCon2 {
    background: #f5f5f5;
    padding: 40px 0;
    .w1 {
      width: 1290px;
      margin: 0 auto;
    }
    .parkTitle {
      h5 {
        font-size: 18px;
        color: #333;
      }
      .moreList {
        font-size: 15px;
      }
      .el-icon-arrow-right {
        margin-left: 5px;
      }
    }
    .parksList {
      margin: 20px 0 30px;
      .swiper-button-next,
      .swiper-container-rtl .swiper-button-prev {
        background: url("../../static/img1/tubiaozhizuo.png") 100% 100% / 100%
          100% no-repeat;
        right: 0px;
        left: auto;
        width: 17px;
        height: 31px;
      }
      .swiper-button-prev,
      .swiper-container-rtl .swiper-button-next {
        background: url("../../static/img1/tubiaozhizuo-.png") 100% 100% / 100%
          100% no-repeat;
        left: 0px;
        right: auto;
        width: 17px;
        height: 31px;
      }
      .parkUl {
        // display: flex;
        // justify-content: space-between;
        margin: 10px auto;
        li {
          // width: 24%;
          // margin-right: 30px;
          background: #fff;
          border: 1px solid #eee;
          width: 23%;
          // margin: 0 auto;
          margin-right: 29px;
          transition: all 0.5s;
        }
        li:hover {
          box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.06);
          transform: translateY(-6px);
          transition: all 0.5s;
          .liDetail {
            background: rgba(0, 160, 65, 1);
            border-radius: 20px;
            color: #fff;
          }
        }
        li:last-child {
          margin-right: 0;
        }
        .imgItem {
          width: 100%;
          height: 280px;
          img {
            width: 100%;
            height: 100%;
          }
        }
        .licon {
          padding: 15px;
          color: #999;
          font-size: 13px;
          h5 {
            font-size: 15px;
            color: #222;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
          }
          .liBerif {
            margin: 20px 0;
            height: 35px;
            // display: -webkit-box;
            // -webkit-box-orient: vertical;
            // -webkit-line-clamp: 2;
            // overflow: hidden;
            // width: 100%;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 2;
            overflow: hidden;
          }
          .liDetail {
            padding: 8px 20px;
            text-align: center;
            width: 55px;
            // margin-top: 20px;
          }
        }
      }
    }
    .parkInfo {
      display: flex;
      justify-content: space-between;
      font-size: 13px;
      .infoUl {
        width: 77%;
        display: flex;
        align-items: center;
        justify-content: space-between;
        li {
          box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.02);
          border-radius: 4px;
          padding: 15px 0;
          width: 24%;
          margin-right: 30px;
          text-align: center;
          cursor: pointer;
          background: #fff;
          transition: all 0.5s;
          p {
            margin-top: 10px;
          }
        }
        li:hover {
          box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.06);
          animation: topa 0.5s;
        }
      }
      .infoMes {
        width: 23%;
        font-size: 13px;
        img {
          vertical-align: middle;
          margin-right: 5px;
        }
        .phone1 {
          margin-top: 10px;
          i {
            color: #0066cc;
          }
        }
      }
    }
  }
  .enterpriseList {
    padding: 30px 0 20px;
    .parkTitle {
      h5 {
        font-size: 18px;
        color: #333;
      }
      .moreList {
        font-size: 15px;
      }
      .el-icon-arrow-right {
        margin-left: 5px;
      }
    }
    .enterpriseCon {
      margin-top: 30px;
      .enterpriseUl {
        display: flex;
        justify-content: space-between;
        align-items: center;
        flex-wrap: wrap;
        li {
          width: 23%;
          margin-right: 20px;
          margin-bottom: 30px;
          text-align: center;
          padding: 20px 0;
          background: linear-gradient(
            180deg,
            rgba(247, 214, 93, 1),
            rgba(246, 170, 4, 1)
          );
          border: NaNpx solid rgba(238, 238, 238, 1);
          border-radius: 4px;
          font-size: 15px;
          color: #fff;
          transition: all 0.5s;
          p {
            margin-top: 20px;
          }
        }
        li:hover {
          // animation: topa .5s;
          box-shadow: 2px 5px 5px rgba(0, 0, 0, 0.1);
          transform: translateY(-6px);
          transition: all 0.5s;
        }
        li p:hover {
          animation: qfyfadeInLeft 1s ease-out;
        }
        li:nth-child(2) {
          background: linear-gradient(
            180deg,
            rgba(242, 82, 221, 1),
            rgba(193, 8, 165, 1)
          );
        }
        li:nth-child(3) {
          background: linear-gradient(
            180deg,
            rgba(245, 102, 87, 1),
            rgba(212, 45, 18, 1)
          );
        }
        li:nth-child(4) {
          background: linear-gradient(
            180deg,
            rgba(1, 194, 232, 1),
            rgba(84, 135, 240, 1)
          );
        }
        li:nth-child(5) {
          background: linear-gradient(
            180deg,
            rgba(78, 202, 254, 1),
            rgba(26, 168, 234, 1)
          );
        }
        li:nth-child(6) {
          background: linear-gradient(
            180deg,
            rgba(41, 207, 115, 1),
            rgba(7, 171, 80, 1)
          );
        }
        li:nth-child(7) {
          background: linear-gradient(
            180deg,
            rgba(79, 134, 254, 1),
            rgba(84, 100, 240, 1)
          );
        }
        li:nth-child(8) {
          background: linear-gradient(
            180deg,
            rgba(41, 207, 115, 1),
            rgba(7, 171, 80, 1)
          );
        }
        li:nth-child(4n) {
          margin-right: 0;
        }
      }
    }
  }
  .enterprisePro {
    background: #f5f5f5;
    padding: 40px 0;
    .parkTitle {
      h5 {
        font-size: 18px;
        color: #333;
      }
      .moreList {
        font-size: 15px;
      }
      .el-icon-arrow-right {
        margin-left: 5px;
      }
    }
    .proList {
      margin: 30px 0 20px;
      .proUl {
        display: flex;
        justify-content: space-between;
        li {
          width: 24%;
          margin-right: 30px;
          border: 1px solid #eee;
          background: #fff;
          transition: all 0.5s;
        }
        li:hover {
          box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.06);
          transform: translateY(-6px);
          transition: all 0.5s;
          .liDetail {
            background: rgba(0, 160, 65, 1);
            border-radius: 20px;
            color: #fff;
          }
        }
        li:last-child {
          margin-right: 0;
        }
        .imgItem {
          width: 100%;
          height: 150px;
          img {
            width: 100%;
            height: 100%;
          }
        }
        .licon {
          padding: 15px;
          color: #999;
          font-size: 13px;
          h5 {
            font-size: 15px;
            color: #222;
          }
          .liBerif {
            margin: 20px 0;
            height: 35px;
            // display: -webkit-box;
            // -webkit-box-orient: vertical;
            // -webkit-line-clamp: 2;
            // overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 2;
            overflow: hidden;
          }
          .liDetail {
            padding: 8px 20px;
            text-align: center;
            width: 55px;
          }
        }
      }
    }
  }
  .link {
    margin-bottom: 20px;
    margin-top: 100px;
    font-size: 13px;
    .tit {
      font-size: 13px;
    }
    .linkUl {
      li {
        float: left;
        padding: 0 20px;
        border-right: 1px solid #999;
        a {
          color: #333;
          cursor: pointer;
        }
        a:hover {
          text-decoration: underline;
        }
      }
      // .line{
      //   width: 1px;
      //   height: 10px;
      //   background: #999;
      //   margin:0 20px;
      //   line-height: 10px;
      // }
      li:last-child {
        border: none;
      }
    }
  }
}
</style>

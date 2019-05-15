<template>
  <div class="portalIndex">
    <div class="portalIndexImg" v-if="$store.state.needNav">
      <div class="header" id="header" :class="{'headerw':showFF, 'user-center': isCenter}">
        <div class="headerContainer clearfix">
          <div class="titleImg fl">
            <img src="@/../static/img/login-logo.png" v-if="showFF || isCenter" class="pointer" alt="" @click="$router.push({path:'/'})">
            <img src="@/../static/img/LOGO1.png" v-else="!showFF" class="pointer" alt="" @click="$router.push({path:'/'})">
          </div>
          <div class="headerRight fr">
            <router-link to="/messageCenter" class="search">
              <i class="el-icon-bell" style="font-size:20px"></i>
            </router-link>
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
            <ul class="posA clearfix">
              <li class="">
                <router-link to="/" class="router-link">首页</router-link>
              </li>
              <li>
                <router-link to="/investment" class="router-link">招商引资</router-link>
              </li>
              <li>
                <router-link to="" class="router-link">智慧党建</router-link>
              </li>
              <li>
                <router-link to="/enterpriseservice" class="router-link">企业服务</router-link>
              </li>
            </ul>
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

    <!--    主体内容开始-->
    <router-view></router-view>
    <!--    主体内容结束-->
  </div>
</template>
<script>
  import swiper from "swiper";
  export default {
    data() {
      return {
        // sousuo: false,
        show1: false,
        show11: false,
        show22: false,
        show33: false,
        show2: false,
        show3: false,
        show4: false,
        searchData: "",
        showFF: false,
        activeNames: ['first'],
        sw:'fir',
        showBtn:false,
      };
    },
    computed: {
      isCenter() {
        return this.$route.matched.some(item => {
          return item.name === 'home'
        })
      }
    },
    mounted() {
      this.swiperinit();
      window.addEventListener("scroll", this.handleScroll);
    },
    destroyed() {
      window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
    },
    methods: {
      showH(){
        this.show1 = true;
        // setTimeout(()=>{
        this.show11 = true;
        // },500)
      },
      showY(){
        this.show11 = false;
        // setTimeout(()=>{
        this.show1 = false;
        // },500)
      },
      handleChangeName(val) {
        console.log(val);
        if(val=='two'){
          this.sw='tw'
        } else if(val=='three'){
          this.sw='th'
        } else{
          this.sw='fir'
        }
      },
      swiperinit() {
        var mySwiper = new swiper(".swiper-container", {
          direction: "horizontal", // 垂直切换选项
          loop: true, // 循环模式选项
          noSwiping: true,
          // autoplay: true,
          // autoplay: {
          //   delay: 5000,
          // },

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
      onClick() {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
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
      getScrollOffset(){
        // 除IE8及更早版本
        if( window.pageXOffset != null ){
          return {
            x : window.pageXOffset,
            y : window.pageYOffset
          }
        }
        // 标准模式下的IE
        if( document.compatMode == "css1Compat" ){
          return {
            x : document.documentElement.scrollLeft,
            y : document.documentElement.scrollTop
          }
        }
        // 怪异模式下的浏览器
        return {
          x : document.body.scrollLeft,
          y : document.body.scrollTop
        }
      },
      handleScroll() {
        const osTop = this.getScrollOffset().y;

        // const arr = document.getElementsByClassName('.animation-dom')
        for (const key in this.$refs) {
          const top = this.getElementLeft(this.$refs[key]);

          // console.dir(top);
          if (osTop + innerHeight + 300 >= top + 100) {
            const name = this.$refs[key].dataset.class;
            this.$refs[key].classList.add(name);

          }
        }
        if (
          this.getScrollTop() > document.getElementById("header").clientHeight
        ) {
          this.showFF = true;
          this.show4 = false;
        } else {
          this.showFF = false;
        }
        //    if (
        //     this.getScrollTop() > document.getElementById("search_box").clientHeight
        //   ) {
        //     this.show4 = false;
        //   }
        // console.log(this.getScrollTop())HAOhao
        // if (
        //   this.getScrollTop() > document.getElementById("header").clientHeight
        // ) {
        //   this.headFlag = true;
        // } else {
        //   this.headFlag = false;
        // }
      },
      getScrollTop() {
        var scroll_top = 0;
        if (document.documentElement && document.documentElement.scrollTop) {
          scroll_top = document.documentElement.scrollTop;
        } else if (document.body) {
          scroll_top = document.body.scrollTop;
        }
        return scroll_top;
      }
    }
  };
</script>
<style lang="scss">
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
  .router-link {
    width: 100%;
    height: 100%;
    display: inline-block;
  }
  .portalIndex {

    .portalCon{
      .portalNotice,
      .policyGuide,
      .popularActi,
      .districtGardens,
      .enterpriseinfo,
      .enterprisesPark {
        opacity: 0;
      }
    }
    .enterPark {
      li {
        opacity: 0;
      }
    }
    .bottom {
      animation: fadeInUp 2s ease forwards;
    }
    .bottom1 {
      animation: fadeInUp 2s ease 0.5s forwards;
    }
    .bottom2 {
      animation: fadeInUp 2s ease 1s forwards;
    }
    .bottom3 {
      animation: fadeInUp 1s ease 1.5s forwards;
    }
    .bottom4 {
      animation: fadeInUp 1s ease 2s forwards;
    }
    .bottom5 {
      animation: fadeInUp 1s ease 2.5s forwards;
    }
    .bottom6 {
      animation: fadeInUp 1s ease 3s forwards;
    }
    .bottom7 {
      animation: fadeInUp 1s ease 3.5s forwards;
    }
    .bottom8 {
      animation: fadeInUp 1s ease 4s forwards;
    }
    .portalIndexImg {
      position: fixed;
      z-index: 99;
      width: 100%;
      .headerw {
        background: #fff;
        border-bottom:1px solid #eee;
        box-shadow:0 10px 10px -10px #ccc;
        color: #666;
        #nav,
        .headerRight {
          color: #666;
          li {
            a {
              color: #666;
            }
          }
          li:nth-child(1) {
            background: none;
            border-radius: none;
            a {
              color: #00a041;
            }
          }
          li:hover {
            background: none;
          }
          li:hover a{
            color:#00a041;
          }
        }
      }
      .search_box {
        background: rgba(0, 0, 0, 0.3);
        .el-input-group {
          border-radius: 28px;
          width: 42%;
          margin: 43px 0;
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
        .input-with-select .el-input__inner {
          border-top-left-radius: 19px;
          border-bottom-left-radius: 19px;
          border: 1px solid #00a041;
        }
      }
      .searchbox {
        background: #fff;
        box-shadow:0 10px 10px -10px #ccc;
      }
    }
    .portalCon {
      .banner {
        .swiper-wrapper {
          .swiper-slide {
            width: 100%;
          }
          img {
            width: 100%;
            vertical-align: middle;
          }
        }
        .swiper-button-prev,
        .swiper-button-next {
          background: none;
          width: 34px;
          height: 34px;
          color: #fff;
          font-size: 60px;
          .icon-leftarrow,
          .icon-rightarrow {
            font-size: 45px;
          }
        }
        .swiper-button-prev {
          left: 60px;
        }
        .swiper-button-next {
          right: 60px;
        }
        .swiper-pagination {
          bottom: 40%;
          left: 92%;
          .swiper-pagination-bullet {
            display: block;
            margin-bottom: 10px;
            opacity: 1;
            background: #ccc;
          }
          .swiper-pagination-bullet-active {
            background: #fff;
            height: 50px;
            border-radius: 4px;
          }
        }
      }
    }
    #qiehuan1 {
      margin: 20px 0;
      > li {
        display: inline-block;
        width: 190px;
        height: 210px;
        padding: 30px 10px;
        font-size: 12px;
        text-align: left;
        margin-right: 15px;
        vertical-align: middle;
        background-color: rgba(255, 255, 255, 0.2);
        .liTit {
          font-size: 14px;
          text-align: center;
        }
        .liInfo {
          margin: 40px 0 50px 0;
        }
        .liBom {
          padding: 0 15px;
          > i {
            margin-right: 8px;
          }
        }
      }
      > li:hover {
        transition: 0.3s all;
        transform: scale(1.1);
      }
    }
    .portalNotice {
      .left {
        text-align: left;
        .leftLine {
          position: absolute;
          width: 2px;
          height: 100%;
          background: #000;
        }
        .el-collapse,
        .el-collapse-item__header,
        .el-collapse-item__wrap {
          border: none;
        }
        .el-collapse-item__wrap {
          // text-indent: 3.5em;
        }
        .el-collapse-item__arrow {
          display: none;
        }
      }
    }
    .policyGuide {
      .swiper-container {
        padding-bottom: 60px;
      }
      // .swiper-pagination-bullet {
      //   background: red;
      // }
      // .swiper-pagination-bullet-active {
      //   background: #fff;
      // }
      .swiper-pagination-bullet {
        //   display: block;
        margin-bottom: 10px;
        opacity: 1;
        background: #97ecc8;
      }
      .swiper-pagination-bullet-active {
        background: #fff;
        //   height: 65px;
        border-radius: 4px;
      }
      .el-carousel__button {
        width: 9px;
        height: 9px;
        border-radius: 50%;
      }
      .el-carousel__arrow {
        background: none;
        font-size: 30px;
        top: 40%;
      }
      .el-carousel__arrow--left {
        left: 64px;
      }
      .el-carousel__arrow--right {
        right: 64px;
      }
      .fenye1 {
        .swiper-button-prev,
        .swiper-button-next {
          width: 17px;
          height: 31px;
          top: 48%;
        }
        .swiper-button-prev,
        .swiper-container-rtl .swiper-button-next {
          background: url("../../static/img/zuo1.png") 100% 100% / 100% 100%
          no-repeat;
          left: 90px;
          right: auto;
        }
        .swiper-button-next,
        .swiper-container-rtl .swiper-button-prev {
          background: url("../../static/img/you1.png") 100% 100% / 100% 100%
          no-repeat;
          right: 100px;
          left: auto;
        }
      }
    }
    .popularActi {
      .swiper-button-prev,
      .swiper-button-next {
        width: 34px;
        height: 34px;
      }
    }

    .districtGardens {
      .card {
        .swiper-container {
          padding: 30px 0;
        }
      }
      .swiper-button-next,
      .swiper-container-rtl .swiper-button-prev {
        background: url("../../static/img/you2.png") 100% 100% / 100% 100% no-repeat;
        right: 95px;
        left: auto;
        width: 17px;
        height: 31px;
      }
      .swiper-button-prev,
      .swiper-container-rtl .swiper-button-next {
        background: url("../../static/img/zuo2.png") 100% 100% / 100% 100% no-repeat;
        left: 95px;
        right: auto;
        width: 17px;
        height: 31px;
      }
      .cardUl {
        > li {
          transition: all 0.6s;
        }
        > li:hover {
          transform: scale(1.1);
          box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.2);
        }
      }
    }
    .enterpriseinfo {
      .enterPriseCon {
        .con1 {
          overflow: hidden;
        }
        .con1 img {
          transition: all 0.6s;
        }
        .con1 img:hover {
          transform: scale(1.1);
        }
        .con2 {
          .conlef1 {
            overflow: hidden;
            img {
              transition: all 0.6s;
            }
            img:hover {
              transform: scale(1.1);
            }
          }
        }
      }
    }
  }
</style>


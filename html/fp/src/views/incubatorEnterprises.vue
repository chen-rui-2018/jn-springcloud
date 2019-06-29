<template>
  <div class="incubatorEnterprises">
    <div class="enterpriseBan">
      <div class="bannerEnt pr">
        <div class="swiper-container">
          <div class="swiper-wrapper">
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/createspace.png" alt="">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/createspace.png" alt="">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/createspace.png" alt="">
            </div>
          </div>
          <!-- 如果需要分页器 -->
          <!-- <div class="swiper-pagination"></div> -->

          <!-- 如果需要导航按钮 -->
          <!-- <div class="swiper-button-prev">
                        <i class="iconfont icon-leftarrow pointer"></i>
                    </div>
                    <div class="swiper-button-next">
                        <i class="iconfont icon-rightarrow pointer"></i>
                    </div> -->
        </div>
      </div>
    </div>
    <div class="enterpriseCon w">
      <div class="incubatorNav">
        <span class="pointer" @click="$router.push({path:'/'})">首页</span>
        <span>/</span>
        <span class="mainColor">孵化企业</span>
      </div>
      <div class="incubatorCon">
        <ul class="conul">
          <li class="conLi mainBorder pr" v-for="(i,k) in incubatorList" :key="k">
            <h3 class="liTit ct">{{i.incubatorName}}</h3>
            <div class="tit1">
              <h4>空间特色</h4>
              <p v-html="i.spatialCharacter"></p>
            </div>
            <div class="tit1">
              <h4>入驻标准</h4>
              <p v-html="i.entryCriteria"></p>
            </div>
            <div class="tit1">
              <h4>数据特色</h4>
              <p v-html="i.advantageIntroduct"></p>
            </div>
            <div class="tit1 tit2">
              <h4>申请入驻</h4>
              <p>电话：{{i.phone}}</p>
            </div>
            <a class="footLi pointer" :href='ibpsUrl+"ibps/platform/bpmn/instance/bpmInst/toStart.htm?defId=581462319721086976"'>申请入驻</a>
            <!-- <a class="footLi pointer" href="http://112.94.22.222:2384/ibps/platform/bpmn/instance/bpmInst/toStart.htm?defId=581462319721086976">申请入驻</a> -->
          </li>
        </ul>
      </div>
    </div>
    <div class="pagination-container">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-sizes="[3, 6, 9, 12]" :page-size="rows" layout="total,prev, pager, next,sizes" :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import swiper from "swiper";
import { IBPS_URL } from "@/util/url";
export default {
  data() {
    return {
      page: 1,
      rows: 3,
      total: 0,
      incubatorList: [],
      ibpsUrl: IBPS_URL
    };
  },
  mounted() {
    this.swiperinit();
    this.getIncubatorList();
  },
  methods: {
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
    //获取首页列表信息
    getIncubatorList() {
      let _this = this;
      this.api.get({
        url: "getIncubatorList",
        data: {
          page: _this.page,
          rows: _this.rows
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.incubatorList = res.data.rows;
            _this.total = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.rows = val;
      this.page = 1;
      this.getIncubatorList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.getIncubatorList();
    }
  }
};
</script>
<style lang="scss">
.incubatorEnterprises {
  .bannerEnt {
    .swiper-button-prev,
    .swiper-button-next {
      background-image: none;
    }
    .swiper-button-prev {
      left: 60px;
    }
    .swiper-button-next {
      right: 60px;
    }
    .icon-leftarrow,
    .icon-rightarrow {
      color: #fff;
      display: inline-block;
      width: 34px;
      height: 34px;
      font-size: 34px;
    }
    .swiper-pagination-bullet {
      //   display: block;
      margin-bottom: 10px;
      opacity: 1;
      background: #ccc;
    }
    .swiper-pagination-bullet-active {
      background: #fff;
      width: 40px;
      border-radius: 4px;
    }
    img {
      width: 100%;
      height: 100%;
    }
  }
  .incubatorNav {
    padding: 15px 0;
    font-size: 13px;
    font-weight: bold;
  }
  .incubatorCon {
    margin-bottom: 50px;
    .conul {
      display: flex;
      // justify-content: space-between;
      justify-content:flex-start;
      // align-items: center;
      flex-wrap: wrap;
      display: -webkit-flex;
    }
    .conLi {
      margin-right: 35px;
      // margin-bottom:30px;
      width: 31%;
      padding-bottom: 36px;
    }
    .conLi:nth-child(3n) {
      margin-right: 0;
    }
    // .conLi:nth-child(4n) {
    //   margin-right: 0;
    // }
    .liTit {
      font-size: 15px;
      padding: 10px;
      color: #333;
    }
    .tit1 {
      padding: 0 10px;
    }
    .tit2 {
      margin-bottom: 10px;
    }
    h4 {
      font-size: 13px;
      color: #333;
      margin-bottom: 10px;
    }
    p {
      font-size: 12px;
      color: #666;
      line-height: 20px;
    }
    .footLi {
      position: absolute;
      bottom: 0;
      width: 100%;
      // display: block;
      height: 36px;
      line-height: 36px;
      font-size: 13px;
      color: #fff;
      text-align: center;
      background: url("../../static/img/linerBg.png") 100% 100% / 100% 100%
        no-repeat;
    }
  }
  .pagination-container {
    margin-bottom: 50px;
  }
}
</style>

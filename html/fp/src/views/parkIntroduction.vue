<template>
  <div class="parkIntroduction">
    <div class="parkDetai w">
      <div class="park clearfix">
        <div class="imgItm fl">
          <!-- <img src="@/../static/img1/c05.png" alt=""> -->
          <img :src="basicInfo.mainPicture" alt="">
        </div>
        <div class="parkInfo fl">
          <div class="tit color1">南京白下高新技术产业园区</div>
          <!-- <p class="color3">
            白下高新区重点发展软件和信息技术服务、智能制造产业。截至2018年11月，招商载体面积128万平方米，拥有企业1200余家，其中，高新技术企业63家，主板上市企业1家，新三板挂牌企业9家，省级以上研发机构79家。截至目前，集聚科技创业人才274人，其中“两院”院士、国家“千人计划”专家14人。核心区2006年被认定为省级开发区，2015年纳入省级高新区管理，是南京主城区第一个省级高新区。 白下高新区将坚持“一区引领、多园发力、平台支持”的工作原则，按照市委工作要求，重点围绕“两落地一融合”，依托原有秦淮实践，注入秦淮元素，勇作秦淮标杆，全力打造“活力彰显、动力强劲、生态优化”的创新名园区，建设全国有知名度的高新技术产业集聚区。
          </p> -->
          <p class="color3">
            {{basicInfo.shortIntroduce}}
          </p>
        </div>
      </div>
    </div>
    <div class="morePark">
      <div class="parkCon w1">
        <div class="parkTitle w clearfix">
          <h5 class="fl color1">多园介绍</h5>
          <!-- <div class="moreList pointer color3 fr">MORE
            <i class="el-icon-arrow-right"></i>
          </div> -->
        </div>
        <div class="parksList">
          <!-- <ul class="parkUl">
            <li v-for="(i,k) in enterpriseList" v-if="k<4" :key="k">
              <div class="imgItem">
                <img :src="i.mainPicture" alt="">
              </div>
              <div class="licon">
                <h5>{{i.parkName}}</h5>
                <div class="liDetail mainBorder pointer" @click="$router.push({path:'/subparkIntroduction'})">了解详情</div>
              </div>
            </li>
          </ul> -->
          <!-- <el-carousel :interval="5000" arrow="always">
            <el-carousel-item v-for="item in 4" :key="item">
              <ul class="parkUl">
                <li v-for="(i,k) in enterpriseList" v-if="k<4" :key="k">
                  <div class="imgItem">
                    <img :src="i.mainPicture" alt="">
                  </div>
                  <div class="licon">
                    <h5>{{i.parkName}}</h5>
                    <div class="liDetail mainBorder pointer" @click="$router.push({path:'/subparkIntroduction'})">了解详情</div>
                  </div>
                </li>
              </ul>
            </el-carousel-item>
          </el-carousel> -->
          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div class="swiper-slide" style="width:100%" v-for="(item,index) in enterpriseList" :key="index">
                <ul class="parkUl w clearfix">
                  <li class="fl pointer" v-for="(i,k) in item" :key="k" :data-path="`/parkIntroductionChild?id=${i.id}`" >
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
            <div class="swiper-button-prev" v-show="enterpriseList.length>1"></div>
            <div class="swiper-button-next" v-show="enterpriseList.length>1"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import swiper from "swiper";
export default {
  data() {
    return {
      enterpriseList: [],
      basicInfo: {}
    };
  },
  mounted() {
    this.getBusinessAdContent();
    this.getBasic();
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
    // 园区介绍
    getBusinessAdContent() {
      let _this = this;
      this.api.get({
        url: "getParkList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
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
    //获取园区概况
    getBasic() {
      this.api.get({
        url: "basic",
        callback: res => {
          if (res.code === "0000") {
            this.basicInfo = res.data;
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
.parkIntroduction {
  padding-top: 120px;
  .el-carousel__container {
    height: 410px;
  }
  .el-carousel__indicators {
    display: none;
  }
  .parkDetai {
    margin-bottom: 40px;
    .park {
      border: NaNpx solid rgba(238, 238, 238, 1);
      box-shadow: 0px 1px 11px 0px rgba(4, 0, 0, 0.05);
      border-radius: 7px;
      padding: 30px;
      .imgItm {
        width: 316px;
        height: 316px;
        img {
          width: 100%;
          height: 100%;
        }
      }
    }
    .parkInfo {
      margin-left: 40px;
      width: 67%;
      .tit {
        font-size: 20px;
        margin-bottom: 20px;
        font-family: "MicrosoftYaHei";
      }
      p {
        font-size: 14px;
        line-height: 25px;
        height: 280px;
        //  display: -webkit-box;
        //     -webkit-box-orient: vertical;
        //     -webkit-line-clamp: 11;
        //     overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 11;
        overflow: hidden;
      }
    }
  }
  .morePark {
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
        font-family: "MicrosoftYaHei";
        font-weight: normal;
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
        // align-items:
        // width: 100%;
        margin: 10px auto;
        li {
          width: 23%;
          margin: 0 auto;
          margin-right: 29px;
          border: 1px solid #eee;
          background: #fff;
          transition: all 0.5s;
          // height: 410px;
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
            height: 38px;
            // display: -webkit-box;
            // -webkit-box-orient: vertical;
            // -webkit-line-clamp: 2;
            // overflow: hidden;

            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 2;
            overflow: hidden;
            font-size: 14px;
          }
          .liDetail {
            padding: 8px 20px;
            text-align: center;
            width: 55px;
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
          padding: 10px 0;
          width: 24%;
          margin-right: 30px;
          text-align: center;
          background: #fff;
          p {
            margin-top: 10px;
          }
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
}
</style>

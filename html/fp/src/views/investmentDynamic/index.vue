<template>
  <div class="policyCenter0">
    <div class="policyCon">
      <div class="banner pr">
        <div class="swiper-container">
          <div class="swiper-wrapper">
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/investment-dynamic.png" alt="">
            </div>
          </div>
        </div>
      </div>

      <div class="techContent w">
        <span class="pointer" @click="$router.push({path:'/investment'})">招商引资</span>
        <span>/</span>
        <span class="mainColor">招商动态</span>
      </div>
      <div class="policyTab  w">
        <div class="pr">
          <span class="wenzi color3">动态</span>
          <div class="filRight">
            <input type="text" placeholder="请输入关键字" v-model="policySearch">
            <i class="iconfont icon-sousuo"></i>
          </div>
        </div>
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="全部" name="first">
            <ul class="fir">
              <li class="list-row" v-for="(i,k) in policyCenterListSearchResult" :key="k">
                <div class="list-row-l">
                  <div class="list-adcover list-row-cell" :style="{backgroundImage: 'url(' + i.adCover + ')'}"></div>
                  <div class="list-row-cell pointer" @click="$router.push({path:'/investmentDynamicDetail',query:{id:i.id}})">
                    <h3 class="color4">{{i.title}}</h3>
                    <p class="p1">
                      <span class="tag-list">发布日期：{{i.startTime}}</span>
                      <span class="tag-list">
                        <span>状态：</span>
                        <span v-if="isValid(i.endTime)" class="mainColor">有效</span>
                        <span v-else="isValid(i.endTime)">无效</span>
                      </span>
                    </p>
                    <div class="firInfo">{{i.briefContent}}</div>
                  </div>
                </div>
                <div class="fir2 list-row-cell mainColor" @click="$router.push({path:'/investmentDynamicDetail',query:{id:i.id}})">详情</div>
              </li>
            </ul>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </div>
</template>
<script>
  import swiper from "swiper";
  import userInfo from '.././common/userInfoData'
  export default {
    components: {
      userInfo
    },
    data() {
      return {
        sousuo: false,
        searchData: "",
        showFF: false,
        show4: false,
        headFlag: false,
        filterFlag1: "",
        filterFlag2: "0",
        filterFlag3: "",
        filterFlag: "",
        flag1: true,
        flag2: true,
        flag3: true,
        flag4: true,
        activeName: "first",
        policyLevel: "",
        policyClass: "",
        policyCenterList: "",
        policyClassCode: "",
        policyLevelCode: "",
        policySearch: "",
        policyType: "0",
        releaseDate: "",
        tableType: "allPolicy",
        page: 1,
        row: 8,
        total: 0,
        arrYear: [],
        yearBefore: ""
      };
    },
    mounted() {
      window.addEventListener("scroll", this.handleScroll);
      this.getPolicyCenterList();
    },
    computed: {
      policyCenterListSearchResult() {
        if (this.policySearch === '') {
          return this.policyCenterList
        }
        return this.policyCenterList.filter(item => item.title.indexOf(this.policySearch) > -1)
      }
    },
    destroyed() {
      window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
    },
    methods: {
      handleClick(tab) {},
      widFun(i) {
        let doc = document.getElementsByClassName(i);
        let num = 0;
        for (let it of doc) {
          num += it.offsetWidth * 1;
        }
        // console.log(num);
        if (num >= 860) {
          return true;
        } else {
          return false;
        }
      },
      handleScroll() {
        if (
          this.getScrollTop() > document.getElementById("header").clientHeight
        ) {
          this.showFF = true;
          this.show4 = false;
        } else {
          this.showFF = false;
        }
      },
      isValid(str) {
        return new Date(str) >= new Date(new Date().toLocaleDateString()).getTime()
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
      //政策中心首页
      getPolicyCenterList() {
        let _this = this;
        this.api.get({
          url: "getBusinessAdDynamic",
          callback: function(res) {
            if (res.code == "0000") {
              _this.policyCenterList = res.data;
            } else {
              _this.$message.error(res.result);
            }
          }
        });
      },
      //政策级别
      getPolicyLevelList() {
        let _this = this;
        this.api.get({
          url: "getPolicyLevelList",
          data: {},
          callback: function(res) {
            if (res.code == "0000") {
              _this.policyLevel = res.data;
            } else {
              _this.$message.error(res.result);
            }
          }
        });
      },
      //政策分类
      getPolicyClassList() {
        let _this = this;
        this.api.get({
          url: "getPolicyClassList",
          data: {},
          callback: function(res) {
            if (res.code == "0000") {
              _this.policyClass = res.data;
            } else {
              _this.$message.error(res.result);
            }
          }
        });
      },
      //获取最近10年的年份
      getYear() {
        var myDate = new Date();
        var thisYear = myDate.getFullYear();
        var Section = thisYear - (thisYear - 9);
        for (var i = 0; i <= Section; i++) {
          this.arrYear.push(thisYear--);
        }
      }
    }
  };
</script>
<style lang="scss">
  @import "~@/css/r-common";
  .policyCenter0 {
    .list-row {
      @include flex($h: space-between, $v: flex-start);
      list-row-cell {
        margin-top: 6px;
      }
      .list-row-l {
        @include flex($h: flex-start, $v: flex-start);
      }
    }
    .list-adcover {
      width: 162px;
      height: 110px;
      margin-right: 13px;
      background-size: cover;
    }
    #lastLi {
      float: right;
      margin-top: -26px;
    }
    .pagination-container {
      margin-top: 50px;
      margin-bottom: 10px;
    }
    .policyCon {
      .banner {
        img {
          width: 100%;
          height: 100%;
        }
      }
      .techContent {
        padding: 20px 0;
        font-size: 13px;
        font-weight: bold;

        .agent {
          font-weight: bold;
        }
      }
      .serverOrgNav {
        padding: 0 20px;
        font-size: 13px;
        margin-bottom: 20px;
        text-align: center;

        .nav1 {
          padding: 15px 0;
          border-bottom: 1px solid #eee;
          color: #666;

          > img {
            width: 12px;
            height: 15px;
            vertical-align: top;
          }

          // color:#666;
          .nav1Tit {
            margin-top: 5px;
          }

          .nav1Ul {
            width: 860px;
            overflow: hidden;
            height: 27px;

            // text-indent: -35px;
            // margin-left: 35px;
            > li {
              float: left;
              margin-left: 20px;
              padding: 5px 10px;
              cursor: pointer;
              line-height: 17px;
            }

            > li.active0 {
              background: #009f42;
              border-radius: 4px;
              color: #fff;
            }
          }

          .nav1Ul.sh {
            overflow: visible;
            height: auto;
          }

          .el-icon-arrow-down,
          .el-icon-arrow-up {
            font-size: 18px;
            color: #999;
          }
        }
        #nav1 {
          border: none;
        }

        .nav2 {
          border-bottom: none;
        }
      }
      .policyTab {
        .wenzi {
          position: absolute;
          right: 265px;
          top: 5px;
          // z-index:4;
        }
        .filRight {
          width: 200px;
          height: 30px;
          // line-height: 35px;
          text-align: center;
          padding-right: 40px;
          border: 1px solid #eee;
          border-radius: 5px;
          position: absolute;
          right: 0;
          z-index: 3;

          > input {
            border: 0;
            height: 100%;
            width: 95%;
          }

          input,
          textarea,
          select,
          button {
            text-rendering: auto;
            color: #333;
            letter-spacing: normal;
            word-spacing: normal;
            text-transform: none;
            text-indent: 0;
            text-shadow: none;
            display: inline-block;
            text-align: start;
            margin: 0em;
            font: 400 16px Arial;
            font-size: 12px;
          }

          > .icon-sousuo {
            position: relative;
            top: -31px;
            right: -120px;
            cursor: pointer;
            font-size: 20px;
            display: inline-block;
            width: 40px;
            line-height: 32px;
            text-align: center;
            border-left: 1px solid #eee;
            background: #00a041;
            border-top-right-radius: 5px;
            border-bottom-right-radius: 5px;
            color: #fff;
          }
        }
        .el-tabs__item {
          font-size: 15px;
        }
        .fir {
          li {
            text-align: left;
            font-size: 13px;
            padding: 15px 0;
            border-bottom: 1px solid #eee;
            h3 {
              font-size: 16px;
              margin-bottom: 10px;
            }
            p {
              color: #999;
              line-height: 20px;
            }
          }
          .fir2 {
            align-self: center;
            text-align: center;
            font-size: 13px;
            background: #ecfcf2;
            padding: 6px 20px;
            border: 1px solid #00a041;
            border-radius: 4px;
            cursor: pointer;
          }
          .firInfo {
            width: 100%;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            color: #666;
            margin-top: 10px;
          }
          .p1 {
            // display: flex;
            // align-items: center;
            // justify-content: left;
            span.tag-list {
              display: inline-block;
              /*width: 200px;*/
              //  margin-right: 40px;
            }
          }
          .p2 {
            // display: flex;
            // align-items: center;
            // justify-content: left;
            span {
              display: inline-block;
              width: 200px;
              //  margin-right: 40px;
            }
          }
        }
        .finaUl,
        .policyUl11,
        .policyUl22 {
          > li {
            width: 280px;
            // height: 250px;
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
              text-align: center;
              color: #fff;
              padding: 15px;
              height: 17px;
              // border-top: 1px solid #eee;
              background: url("../../../static/img/linerBg.png") 100% 100% / 100%
              100% no-repeat;
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
        .policyUl11 {
        }
      }
    }
  }
</style>


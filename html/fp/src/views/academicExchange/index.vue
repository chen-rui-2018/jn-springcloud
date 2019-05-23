<template>
    <div class="academicExchange">
        <div class="enterpriseBan">
            <div class="bannerEnt pr">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/scient.png" alt="">
                        </div>
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/scient.png" alt="">
                        </div>
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/scient.png" alt="">
                        </div>
                    </div>
                    <!-- 如果需要分页器 -->
                    <div class="swiper-pagination"></div>

                    <!-- 如果需要导航按钮 -->
                    <div class="swiper-button-prev">
                        <i class="iconfont icon-leftarrow pointer"></i>
                    </div>
                    <div class="swiper-button-next">
                        <i class="iconfont icon-rightarrow pointer"></i>
                    </div>
                </div>
            </div>
        </div>
        <div class="enterpriseCon w">
            <div class="incubatorNav">
                <span class="pointer" @click="$router.push({path:'/'})">首页</span>
                <span>/</span>
                <span class="mainColor">学术科技</span>
            </div>
            <div class="serverOrgNav mainBorder">
                <div id="nav1" class="nav1 clearfix">
                    <div class="nav1Tit fl">所有类别：</div>
                    <ul class="nav1Ul fl clearfix">
                        <li class="wid1" :class="{'active1':flag1=='science'}" @click="handleFilter('science')">学术</li>
                        <li class="wid1" :class="{'active1':flag1=='technology'}" @click="handleFilter('technology')">科技</li>
                    </ul>
                </div>
            </div>
            <div class="incubatorCon">
                <div class="con1 clearfix">
                    <div class="con1Tit fl mainColor">全部</div>
                    <div class="filRight fr">
                        <input type="text" placeholder="搜学术" v-model="searchTitle">
                        <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
                    </div>
                </div>
                <div class="con2">
                    <ul class="fir">
                        <li class="clearfix" v-for="(i,k) in achievementList" :key="k">
                            <div class="fir1 fl">
                                <h3 class="color4">{{i.title}}</h3>
                                <p class="p1">
                                    <span>阅读次数：
                                        <i class="mainColor">{{i.viewCount}}</i>次</span>
                                    <span>发布日期：{{i.createdTime}}</span>
                                    <span style="margin-left:50px;">状态:</span>
                                </p>
                                <p class="p2">
                                    成果类型：
                                </p>
                                <p class="color22">{{i.details}}</p>
                                <!-- <div class="firInfo">{{i.briefContent}}</div> -->
                            </div>
                            <div class="fir2 fr mainColor"  @click="$router.push({path:'/technologyDetails',query:{achievementId:i.achievementId}})">详情</div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="pagination-container">
            <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-sizes="[5, 10, 15, 20]" :page-size="rows" layout="total,prev, pager, next,sizes" :total="total">
            </el-pagination>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      page: 1,
      rows: 5,
      total: 0,
      flag1: "",
      type:'',
      achievementList:[],
      searchTitle:'',
    };
  },
  mounted() {
      this.getAchievementList()
  },
  methods: {
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.rows = val;
      this.page = 1;
      this.getAchievementList()
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.getAchievementList()
    },
    handleFilter(i) {
        this.type=i
        this.flag1=i
        this.getAchievementList()
    },
    handleSearchList() {
        this.page = 1;
        this.getAchievementList();
    },
       //学术交流，科技成果
    getAchievementList() {
      let _this = this;
      this.api.get({
        url: "getAchievementList",
        data: {
            page:_this.page,
            rows:_this.rows,
            type:_this.type
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.achievementList = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
  }
};
</script>
<style lang="scss">
.academicExchange {
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

        > li.active1 {
          background: #009f42;
          border-radius: 4px;
          color: #fff;
        }
      }

      .el-icon-arrow-down,
      .el-icon-arrow-up {
        font-size: 18px;
        color: #999;
      }
    }
  }
  .incubatorCon {
    .con1 {
      border-bottom: 1px solid #eee;
    }
    .con1Tit {
      padding: 10px;
      border-bottom: 2px solid #00a041;
      font-size: 13px;
    }
    .filRight {
      width: 200px;
      height: 30px;
      text-align: center;
      padding-right: 40px;
      border: 1px solid #eee;
      border-radius: 5px;
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
        .fir1 {
          width: 90%;
          .color22{
              color:#666;
          }
        }
        .fir2 {
          text-align: center;
          font-size: 13px;
          background: #ecfcf2;
          padding: 6px 20px;
          border: 1px solid #00a041;
          border-radius: 4px;
          cursor: pointer;
          margin-top: 40px;
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
          span {
            display: inline-block;
            width: 200px;
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
  }
  .pagination-container{
      margin:50px 0;
  }
}
</style>

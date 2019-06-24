<template>
  <div class="investor w" id="investor" v-loading="investorLoading">
    <div class="investorMenu">
      <span class="pointer" @click="$router.push({path:'/tfindex'})">首页</span>
      <span>/</span>
      <span class="mainColor agent">投资人</span>
    </div>
    <div class="investorNav mainBorder">
      <div class="nav1 clearfix" id="nav1">
        <div class="nav1Tit fl">主投领域：</div>
        <ul class="nav1Ul fl clearfix" style="width:auto;">
          <li :class="{'active4':filterFlag == ''}" @click="handleFilter('')">全部</li>
        </ul>
        <ul class="nav1Ul fl clearfix" :class="{'sh':!flag1}">
          <li class="wid1" v-for="(i,k) in investorMainArea" :key="k" :class="{'active4':filterFlag == i.mainCode}" @click="handleFilter(i.mainCode)">{{i.mainName}}</li>
        </ul>
        <div class="fr" v-if="widFun('wid1')">
          <i class="el-icon-arrow-down" v-if="flag1" @click="flag1=!flag1"></i>
          <i class="el-icon-arrow-up" v-else @click="flag1=!flag1"></i>
        </div>
      </div>
    </div>
    <div class="investorFilter mainBorder clearfix">
      <div class="filLeft fl" id="filLeft">共有
        <span class="mainColor">{{total}}</span>个符合条件的结果</div>
      <div class="filRight fr">
        <input type="text" placeholder="搜索关键字" v-model="keyWords">
        <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
      </div>
    </div>
    <div class="investorContent">
      <div v-if="investorInfoList.length==0&&!investorLoading">
        <nodata></nodata>
      </div>
      <ul v-else>
        <li v-for="(i,k) in investorInfoList" :key='k' class="pointer" @click="handleDel(i.investorAccount)">
          <div class="liImg pointer">
            <img v-if="i.avatar" :src="i.avatar" alt="">
            <img v-else src="@/../static/img/touxiang.png" alt="">
          </div>
          <div class="liCont">
            <div class="tit color4">{{i.investorName}}</div>
            <p>所属机构：{{i.orgName}}</p>
            <p>职务：{{i.position}}</p>
          </div>
          <div class="liArea">
            <i>主投领域</i>
            <div class="spanArea" v-if="i.mainAreaList!=null&&i.mainAreaList.length>0">
              <span v-for="(item,k) in i.mainAreaList.split(',')" :key="k">{{item}}</span>
            </div>
          </div>
        </li>
      </ul>
    </div>
    <div class="pagination-container">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage1" :page-sizes="[3, 6, 9, 12]" :page-size="row" layout="total,prev, pager, next,sizes" :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import nodata from "../common/noData.vue";
export default {
  components: {
    nodata
  },
  data() {
    return {
      investorLoading: false,
      total: 0,
      page: 1,
      row: 3,
      currentPage1: 1,
      keyWords: "",
      flag1: true,
      filterFlag: "",
      investorInfoList: [],
      investorMainArea: [],
      mainCode: ""
    };
  },
  mounted() {
    this.getInvestorInfoList();
    this.getInvestorMainArea();
  },
  methods: {
    widFun(i) {
      let doc = document.getElementsByClassName(i);
      let num = 0;
      for (let it of doc) {
        num += it.offsetWidth * 1;
      }
      if (num >= 860) {
        return true;
      } else {
        return false;
      }
    },
    handleFilter(i) {
      this.mainCode = i;
      this.filterFlag = i;
      this.getInvestorInfoList();
    },
    handleSearchList() {
      this.page = 1;
      this.getInvestorInfoList();
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.row = val;
      this.page = 1;
      this.getInvestorInfoList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.getInvestorInfoList();
    },
    handleDel(investorAccount) {
      this.$router.push({
        path: "investorDetail",
        query: { investorAccount: investorAccount }
      });
    },
    getInvestorInfoList() {
      //投资人列表
      this.investorLoading = true;
      let _this = this;
      this.api.get({
        url: "getInvestorInfoList",
        data: {
          needPage: 1,
          mainCode: _this.mainCode,
          page: _this.page,
          rows: _this.row,
          keyWords: _this.keyWords
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.investorInfoList = res.data.rows;
            _this.total = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
          _this.investorLoading = false;
        }
      });
    },
    getInvestorMainArea() {
      //查询投资人主投领域
      let _this = this;
      this.api.get({
        url: "getInvestorMainArea",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.investorMainArea = res.data;
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
#investor {
  padding-top: 65px;
}
.investor {
  .investorMenu {
    padding: 20px 0;
    font-size: 13px;
    font-weight: bold;
  }
  .investorNav {
    padding: 0 20px;
    font-size: 14px;
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

        > li.active4 {
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

  .investorFilter {
    padding: 10px;
    font-size: 14px;

    .filLeft {
      margin-top: 10px;
      color: #797979;
      margin-left: 10px;

      > span {
        // margin-right: 20px;
        cursor: pointer;
        // color: #999;
      }

      > span.active {
        color: #00a041;
      }
    }

    .filRight {
      width: 200px;
      height: 36px;
      line-height: 35px;
      text-align: center;
      padding-right: 40px;
      border: 1px solid #eee;
      border-radius: 5px;

      > input {
        border: 0;
        height: 100%;
        width: 80%;
      }
      input::-webkit-input-placeholder {
        /* WebKit browsers*/
        color: #999;
        font-size: 13px;
      }

      input:-moz-placeholder {
        /* Mozilla Firefox 4 to 18*/
        color: #999;
        font-size: 13px;
      }

      input::-moz-placeholder {
        /* Mozilla Firefox 19+*/
        color: #999;
        font-size: 13px;
      }

      input:-ms-input-placeholder {
        /* Internet Explorer 10+*/
        color: #999;
        font-size: 13px;
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
        top: -36px;
        right: -120px;
        cursor: pointer;
        font-size: 20px;
        display: inline-block;
        width: 40px;
        line-height: 37px;
        text-align: center;
        border-left: 1px solid #eee;
        background: #00a041;
        color: #fff;
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px;
      }
    }
  }
  .investorContent {
    padding: 10px 0;
    > ul {
      > li {
        padding: 15px 0;
        border-bottom: 1px solid #eee;
        font-size: 13px;
        .liImg,
        .liCont,
        .liArea {
          display: inline-block;
          vertical-align: middle;
        }
        .liImg {
          width: 120px;
          height: 128px;
          > img {
            width: 100%;
            height: 100%;
            border-radius: 4px;
          }
        }
        .liCont {
          vertical-align: top;
          margin-left: 20px;
          // margin-right: 50px;
          width: 250px;
          .tit {
            font-size: 16px;
            margin-bottom: 40px;
          }
          > p {
            color: #999;
            line-height: 20px;
          }
        }
        .liArea {
          padding-left: 50px;
          width: 60%;
          color: #999;
          > i {
            margin-right: 20px;
          }
          .spanArea {
            display: inline-block;
            vertical-align: middle;
            width: 89%;
            > span {
              display: inline-block;
              padding: 5px 20px;
              border: 1px solid #41d787;
              background: #ecfcf2;
              border-radius: 4px;
              color: #00a041;
              vertical-align: middle;
              text-align: center;
              margin-right: 20px;
              margin-bottom: 15px;
            }
          }
        }
      }
    }
  }
  .pagination-container {
    margin-top: 50px;
    margin-bottom: 60px;
  }
}
</style>

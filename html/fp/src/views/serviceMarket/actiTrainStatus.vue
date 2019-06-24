<template>
  <div class="actiTrainStatus w">
    <div class="regNav">
      <span class="pointer" @click="$router.push({ path: '/serMatHp'})">首页/</span>
      <span class="pointer" @click="$router.push({ path: '/actiTrain'})">活动培训/</span>
      <span class="pointer" @click="$router.push({ path: '/actiTrainDetail',query:{activityId:$route.query.activityId}})">活动详情/</span>
      <span class="mainColor">报名情况</span>
    </div>
    <el-card>
      <div class="regContent">
        <ul class="clearfix">
          <li class="pointer" v-for="(i,k) in statusList" :key="k" @click="handleInfo(i.account)">
            <div class="imgItem"><img :src="i.avatar" alt=""></div>

            <p class="p1">{{i.name}}
              <i v-if="i.sex==0" class="iconfont icon-xingbienv"></i>
              <i v-if="i.sex==1" class="iconfont icon-xingbienan"></i>
            </p>
            <p class="p2 color2">{{i.post}}</p>
            <p class="p3" v-if="i.signStatus==0">未签到</p>
            <p class="p4" v-if="i.signStatus==1">已签到</p>
            <p class="p5 color3">{{i.company}}</p>
          </li>
        </ul>
      </div>
    </el-card>
    <div class="pagination-container">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage4" :page-sizes="[15, 30, 45, 60]" :page-size="row" layout="total,prev, pager, next,sizes" :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      currentPage4: 1,
      page: 1,
      row: 15,
      total: 0,
      statusList: []
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.row = val;
      this.page = 1;
      this.init();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.init();
    },
    handleInfo(account) {
      this.$router.push({
        path: "actiTrainData",
        query: { account: account, activityId: this.$route.query.activityId }
      });
    },
    init() {
      let _this = this;
      this.api.post({
        url: "activityApplyList",
        data: {
          activityId: this.$route.query.activityId,
          page: _this.page,
          rows: _this.row
        },
        callback: function(res) {
          if (res.code == "0000") {
          }
          _this.total = res.data.total;
          _this.statusList = res.data.rows;
        }
      });
    }
  }
};
</script>
<style lang="scss">
.actiTrainStatus {
  padding-top: 65px;
  .el-pagination.is-background .el-pager li:not(.disabled).active {
    background-color: #00a040;
    color: #fff;
  }
  .el-pager li:hover {
    color: #00a040;
  }
  .regNav {
    margin: 20px 0;
    font-size: 13px;
    font-weight: bold;
  }
  .regContent {
    text-align: center;
    > ul {
      > li {
        width: 138px;
        margin: 0 auto;
        margin-right: 30px;
        margin-bottom: 20px;
        float: left;
        text-align: center;
        font-size: 13px;
        .imgItem {
          width: 50px;
          height: 50px;
          border-radius: 50%;
          margin: 0 auto;
          margin-bottom: 10px;
          img {
            width: 100%;
            height: 100%;
            vertical-align: middle;
            border-radius: 50%;
            box-shadow: 0 5px 5px 2px #eee;
          }
        }
      }
      > li:nth-child(7n) {
        margin-right: 0;
      }
    }
    .icon-xingbienv {
      color: #e72e60;
    }
    .icon-xingbienan {
      color: #7c90f6;
    }
    p {
      font-size: 12px;
      line-height: 20px;
    }
    .p1 {
      font-size: 15px;
      color: #333;
    }
    .p3 {
      color: #fe6464;
    }
    .p4 {
      color: #00a041;
    }
  }
  > .pagination-container {
    margin: 100px 0;
    text-align: center;
  }
}
</style>

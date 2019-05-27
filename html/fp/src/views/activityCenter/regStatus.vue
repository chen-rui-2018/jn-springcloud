<template>
  <div class="regStatus w">
    <div class="regNav">
      <!-- <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
                <el-breadcrumb-item>
                    <a href="/">活动中心</a>
                </el-breadcrumb-item>
                <el-breadcrumb-item class="mainColor">活动详情</el-breadcrumb-item>
                <el-breadcrumb-item class="mainColor">报名情况</el-breadcrumb-item>
            </el-breadcrumb> -->
      <span class="pointer" @click="$router.push({ path: '/enterpriseservice'})">企业服务/</span>
      <span class="pointer" @click="$router.push({ path: '/actiDetail'})">活动详情/</span>
      <span class="mainColor">报名情况</span>
    </div>
    <el-card>
      <div class="regContent">
        <ul class="clearfix">
          <li v-for="(i,k) in statusList" :key="k" @click="handleInfo(i.account)">
            <img :src="i.avatar" alt="">
            <p>{{i.name}}
              <i v-if="i.sex==2" class="iconfont icon-xingbienv"></i>
              <i v-if="i.sex==1" class="iconfont icon-xingbienan"></i>
            </p>
            <p>{{i.post}}</p>
            <p v-if="i.signStatus==0">未签到</p>
            <p v-if="i.signStatus==1">已签到</p>
            <p>{{i.company}}</p>
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
      this.$router.push({ path: "regData", query: { account: account } });
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
        dataFlag: false,
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
.regStatus {
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
      }
      > li:nth-child(7n) {
        margin-right: 0;
      }
    }
  }
  > .pagination-container {
    margin: 100px 0;
    text-align: center;
  }
}
</style>


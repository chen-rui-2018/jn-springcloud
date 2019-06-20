<template>
  <div class="regData w">
    <div class="regDataNav">
      <!-- <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
                <el-breadcrumb-item>
                    <a href="/">活动中心</a>
                </el-breadcrumb-item>
                <el-breadcrumb-item class="mainColor">活动详情</el-breadcrumb-item>
                <el-breadcrumb-item class="mainColor">报名情况</el-breadcrumb-item>
                <el-breadcrumb-item class="mainColor">报名人资料</el-breadcrumb-item>
            </el-breadcrumb> -->
      <span class="pointer" @click="$router.push({ path: '/serMatHp'})">首页/</span>
      <span class="pointer" @click="$router.push({ path: '/actiTrain'})">活动培训/</span>
      <span class="pointer" @click="$router.push({ path: '/actiTrainDetail',query:{activityId:$route.query.activityId}})">活动详情/</span>
      <span class="pointer" @click="$router.push({ path: '/regStatus',query:{activityId:$route.query.activityId}})">报名情况/</span>
      <span class="mainColor">报名人资料</span>
    </div>
    <div class="regDataContent">
      <el-card>
        <div class="dataImg">
          <div class="imgItem">
            <img :src="actiInfo.avatar" alt="">
          </div>
          <div class="dataName">{{actiInfo.name}}</div>
          <div class="age">
            <i v-if="actiInfo.sex=='1'" class="iconfont icon-xingbienan">
            </i>
            <i v-else class="iconfont icon-xingbienv">
            </i>
            <span class="ageNum">{{actiInfo.age}}</span>

          </div>
          <p class="sign">个性签名：
            <span>{{actiInfo.signature}}</span>
          </p>
        </div>
        <div class="dataInfo">
          <!-- <div class="dataLeft fl">
            <div>所属公司</div>
            <div>担任职务</div>
            <div>兴趣爱好</div>
          </div>
          <div class="dataMid fl">
            <div class="dataCircle"></div>
            <div class="dataLine"></div>
            <div class="dataCircle"></div>
            <div class="dataLine"></div>
            <div class="dataCircle"></div>
          </div>
          <div class="dataRight fl">
            <div>{{actiInfo.company}}</div>
            <div>{{actiInfo.position}}</div>
            <div>
              <span class="hobbryb" v-for="(item,k) in actiInfo.hobbys" :key="k">{{item}}</span>
            </div>
          </div> -->
          <div class="info1 clearfix">
            <span class="fl color1">所属公司</span>
            <div class="dataCircle fl">
              <img src="@/../static/img/yuandian.png" alt="">
            </div>
            <span class="fl color2">{{actiInfo.company}}</span>
          </div>
          <div class="dataLine"></div>
          <div class="info1 clearfix">
            <span class="fl color1">担任职务</span>
            <div class="dataCircle fl">
              <img src="@/../static/img/yuandian.png" alt="">
            </div>
            <span class="fl color2">{{actiInfo.position}}</span>
          </div>
          <div class="dataLine"></div>
          <div class="info1 clearfix">
            <span class="fl color1">兴趣爱好</span>
            <div class="dataCircle fl">
              <img src="@/../static/img/yuandian.png" alt="">
            </div>
            <div class="fl color2">
              <span class="hobbryb" v-for="(item,k) in actiInfo.hobbys" :key="k">{{item}}</span>
            </div>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      actiInfo: {}
    };
  },
  mounted() {
    console.log(this.$route.query.account);
    this.init();
  },
  methods: {
    init() {
      let _this = this;
      this.api.post({
        url: `springcloud-park/activity/activityApply/activityApplyInfo?account=${
          this.$route.query.account
        }`,
        data: {
          account: this.$route.query.account
        },
        urlFlag: true,
        dataFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.actiInfo = res.data;
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
.regData {
  .el-card__body {
    padding: 0;
  }
  .hobbryb {
    margin-right: 10px;
  }
  padding-top: 65px;
  .regDataNav {
    margin: 20px 0;
    font-size: 13px;
    font-weight: bold;
  }
  .regDataContent {
    margin-bottom: 100px;
    .dataImg {
      height: 300px;
      text-align: center;
      background: url("../../../static/img/applyData.png") 100% 100% / 100% 100%
        no-repeat;
      color: #fff;
      .age {
        margin: 5px 0;
        color: #e72e60;
      }
      .icon-xingbienv {
        color: #e72e60;
        font-size: 20px;
        display: inline-block;
        vertical-align: middle;
      }
      .icon-xingbienan {
        color: #7c90f6;
        font-size: 20px;
        display: inline-block;
        vertical-align: middle;
      }
      .ageNum {
        font-size: 13px;
        display: inline-block;
        vertical-align: middle;
      }
      .sign {
        font-size: 13px;
      }
      .dataName {
        font-size: 16px;
      }
    }
    .imgItem {
      width: 120px;
      height: 120px;
      margin: 0 auto;
      border-radius: 50%;
      margin-bottom: 10px;
      padding-top: 40px;
      img {
        width: 100%;
        height: 100%;
        vertical-align: middle;
        border-radius: 50%;
      }
    }
    .dataInfo {
      padding: 30px 30px 50px;
      font-size: 13px;
      .dataCircle {
        width: 15px;
        height: 15px;
        margin: 0 20px;
        img {
          width: 100%;
          height: 100%;
        }
      }
      .dataLine {
        width: 2px;
        height: 40px;
        margin-left: 78px;
        background-color: #00a041;
      }
      .dataLeft {
        font-size: 13px;
        color: #333;
        > div {
          margin-bottom: 44px;
        }
      }
      .dataMid {
        margin: 0 50px;
        .dataCircle {
          width: 18px;
          height: 18px;
          border-radius: 50%;
          border: 1px solid #ccc;
          background: #00a041;
        }
        // .dataLine {
        //   width: 2px;
        //   height: 40px;
        //   margin-left: 9px;
        //   background-color: #00a041;
        // }
      }
      .dataRight {
        font-size: 13px;
        color: #666;
        > div {
          margin-bottom: 44px;
        }
      }
    }
  }
}
</style>

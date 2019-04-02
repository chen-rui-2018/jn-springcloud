<template>
    <div class="regData w">
        <div class="regDataNav">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
                <el-breadcrumb-item>
                    <a href="/">活动中心</a>
                </el-breadcrumb-item>
                <el-breadcrumb-item class="mainColor">活动详情</el-breadcrumb-item>
                <el-breadcrumb-item class="mainColor">报名情况</el-breadcrumb-item>
                <el-breadcrumb-item class="mainColor">报名人资料</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="regDataContent">
            <el-card>
                <div class="dataImg">
                    <img :src="this.actiInfo.avatar" alt="">
                    <div class="dataName">{{this.actiInfo.name}}</div>
                    <i class="iconfont icon-xingbienv">{{this.actiInfo.age}}</i>
                    <p>个性签名：
                        <span>唯爱与美食不可辜负</span>
                    </p>
                </div>
                <div class="dataInfo clearfix">
                    <div class="dataLeft fl">
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
                        <div>{{this.actiInfo.companyName}}11</div>
                        <div>{{this.actiInfo.post}}</div>
                        <div>南京莱斯信息技术股份有限公司</div>
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
      actiInfo:{}
    };
  },
  mounted(){
    console.log(this.$route.query.account)
    this.init()
  },
  methods: {
    init(){
      let _this = this;
      this.api.post({
        url: `springcloud-park/activity/activityApply/activityApplyInfo?account=${this.$route.query.account}`,
        data: {
          account: this.$route.query.account
        },
        urlFlag: true,
        dataFlag:true,
        callback: function(res) {
          if (res.code == "0000") {
           console.log(res)
           _this.actiInfo=res.data
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
  .regDataNav {
    margin: 20px 0;
  }
  .regDataContent {
    margin-bottom: 100px;
    .dataImg {
      height: 300px;
      text-align: center;
    }
    .dataInfo {
      padding: 30px;
      .dataLeft {
        > div {
          margin-bottom: 30px;
        }
      }
      .dataMid {
        margin: 0 50px;
        .dataCircle {
          width: 20px;
          height: 20px;
          border-radius: 50%;
          border: 1px solid #ccc;
          background: #00a041;
        }
        .dataLine {
          width: 2px;
          height: 30px;
          margin-left: 10px;
          background-color: #00a041;
        }
      }
      .dataRight {
        > div {
          margin-bottom: 30px;
        }
      }
    }
  }
}
</style>


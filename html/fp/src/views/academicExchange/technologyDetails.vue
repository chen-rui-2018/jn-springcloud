<template>
    <div class="technologyDetails w">
        <div class="incubatorNav">
            <span class="pointer" @click="$router.push({path:'/'})">首页</span>
            <span>/</span>
            <span class="pointer" @click="$router.push({path:'/academicExchange'})">学术科技</span>
            <span>/</span>
            <span class="mainColor">学术科技详情</span>
        </div>
        <div class="announcement1 pr">
            <el-card>
                <div class="tit color4">{{achDetails.title}}</div>
                <div class="type1">
                    <div class="span1">
                        成果类型：<span v-if="achDetails.type=='technology'">科技</span><span v-if="achDetails.type=='science'">学术</span>
                    </div>
                    <!-- <div class="span2">
                        成果类型：
                    </div> -->
                </div>
                <div class="timer">
                    <span>阅读量：{{achDetails.viewCount}}</span>
                    <span style="margin-left:20px">发布时间：<i class="mainColor">{{achDetails.createdTime}}</i></span>
                </div>
            </el-card>
        </div>
        <div class="announcement2">
            <div class="title color1">学术/科技详情</div>
            <el-card>
                <p v-html="achDetails.details"></p>
            </el-card>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      achDetails: {}
    };
  },
  mounted() {
    this.achievementDetails();
  },
  methods: {
    //成果详情
    achievementDetails() {
      this.api.get({
        url: "achievementDetails",
        data: {
            achievementId :this.$route.query.achievementId 
        },
        callback: (res)=> {
          if (res.code == "0000") {
            this.achDetails = res.data;
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
.technologyDetails {
  padding-top: 65px;
  .incubatorNav {
    padding: 15px 0;
    font-weight: bold;
    font-size: 13px;
  }
  .announcement1 {
    // text-align: center;
    margin-bottom: 20px;
    font-size: 13px;
    .tit {
      font-size: 18px;
      padding-bottom: 10px;
      border-bottom:1px solid #eee;
    }
    .span1,
    .span2 {
      display: inline-block;
      text-align: center;
      vertical-align: middle;
      margin-right: 20px;
      img {
        width: 13px;
        height: 13px;
        vertical-align: middle;
      }
    }
    .type1{
        margin:20px 0 40px;
    }
    .timer{
        position:absolute;
        right:30px;
        bottom:20px;
    }
  }
  .announcement2 {
      color: #333;
      margin-bottom:50px;
    .title {
      margin: 10px 0;
    }
  }
}
</style>

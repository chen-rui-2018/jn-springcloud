<template>
    <div class="announcementDetails w">
        <div class="incubatorNav">
            <span class="pointer" @click="$router.push({path:'/'})">首页</span>
            <span>/</span>
            <span class="pointer" @click="$router.push({path:'/noticeList'})">公告列表</span>
            <span>/</span>
            <span class="mainColor">公告详情</span>
        </div>
        <div class="announcement1">
            <el-card>
                <div class="tit color4">{{noticeDetails.noticeTitle}}</div>
                <div class="timer">
                    <div class="span1">
                        <img src="@/../static/img/shijian00.png" alt="">&nbsp;{{noticeDetails.createdTime}}
                    </div>
                    <!-- <div class="span2">
                        <img src="@/../static/img/zuozhe.png" alt=""> 本站
                    </div> -->
                </div>
            </el-card>
        </div>
        <div class="announcement2">
            <div class="title">详情</div>
            <el-card>
                <p v-html="noticeDetails.noticeDetails"></p>
            </el-card>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      noticeDetails: {}
    };
  },
  mounted() {
    this.findNoticeDetails();
  },
  methods: {
    //公告详情
    findNoticeDetails() {
      this.api.get({
        url: "findNoticeDetails",
        data: {
        //   noticeId: "536d4e9c22a1465dbb1f1644f793e900"
            noticeId :this.$route.query.noticeId
        },
        callback: (res)=> {
          if (res.code == "0000") {
            this.noticeDetails = res.data;
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
.announcementDetails {
  padding-top: 65px;
  .incubatorNav {
    padding: 15px 0;
    font-size: 13px;
    font-weight: bold;
  }
  .announcement1 {
    text-align: center;
    margin-bottom: 20px;
    .tit {
      font-size: 18px;
      margin-bottom: 10px;
    }
    .span1,
    .span2 {
      display: inline-block;
      text-align: center;
      font-size: 13px;
      vertical-align: middle;
      margin-right: 20px;
      img {
        width: 13px;
        height: 13px;
        vertical-align: middle;
      }
    }
  }
  .announcement2 {
     
      margin-bottom:50px;
    .title {
      border-left: 5px solid #00a041;
      margin: 10px 0;
      padding-left: 3px;
       color: #333;
    }
  }
}
</style>

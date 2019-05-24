<template>
    <div class="enterpriseInfoDetails w">
        <div class="delnav">
            <span class="pointer" @click="$router.push({path:'/'})">首页</span>
            <span>/</span>
            <span class="pointer" @click="$router.push({path:'/enterpriseInformation'})">企业资讯</span>
            <span>/</span>
            <span class="mainColor">资讯详情</span>
        </div>
        <div class="delinfo">
            <el-card style="overflow:visible">
                <div class="infotop pr">
                    <img class="infoImg" :src="getDetails.mainPicture" alt="">
                    <div class="infotitle">
                        <div class="tit color4">
                            龙虎网“黑科技”亮相融交南京市第六届金梧桐奖颁奖 典礼
                        </div>
                        <div class="infoTime">
                            <span>
                                <i class="el-icon-time"></i>21342243</span>
                            <span class="mainColor infoNum">
                                <i class="el-icon-view"></i>21342243</span>
                        </div>
                        <div class="infoWeb">
                            <img src="@/../static/img/zuozhe.png" alt="">
                            <span>龙虎网</span>
                        </div>
                        <div class="infoImgItem">
                            <img src="@/../static/img/图层 4.png" alt="">
                        </div>
                    </div>
                </div>
            </el-card>
        </div>
        <div class="delbody">
            <div class="delTil">详情</div>
            <el-card>
                <div class="delContent">
                    <p v-html="getDetails.parkIntroduce"></p>
                </div>
            </el-card>
        </div>
        <div class="delbody delMore">
            <div class="delTil">更多</div>
            <el-card>
                <ul>
                    <li class="clearfix moreLi">
                        <div class="fl">
                            <i></i>
                            <span class="color1" style="text-align:left">{{i.propagandaTitle}}</span>
                            <p>
                                <img src="@/../static/img/图层 4.png" alt="">
                                <span>{{i.createdTime}}</span>
                            </p>
                        </div>
                        <p class="fr mainColor pointer">MORE</p>
                    </li>
                </ul>
            </el-card>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      getDetails: {}
    };
  },
  created() {},
  mounted() {
    this.getParkDetails();
  },
  methods: {
    getParkDetails() {
      let _this = this;
      this.api.get({
        url: "getParkDetails",
        data: {
          id: "570295002484178944"
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.getDetails = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>
<style lang='scss'>
.enterpriseInfoDetails {
  width: 1190px;
  margin: 0 auto;
  padding-top: 65px;
  .delnav {
    padding: 20px 0;
    font-size: 13px;
  }
  .delinfo {
    margin-top: 40px;
    .el-card__body {
      padding: 30px;
    }
    .infotop {
      height: 220px;
      .infoImg {
        width: 500px;
        height: 270px;
        position: relative;
        left: -70px;
        top: -70px;
        border-radius: 10px;
      }
      .infotitle {
        position: absolute;
        left: 460px;
        top: 20px;
        .tit {
          font-size: 20px;
          margin-bottom: 30px;
        }
        .infoTime {
          .el-icon-time {
            font-size: 19px;
          }
          .infoNum {
            margin-left: 100px;
          }
        }
        .infoWeb {
          margin: 10px 0;
          img {
            width: 16px;
            height: 16px;
          }
        }
        .delAddress {
          margin-top: 10px;
        }
        .userImg {
          margin-top: 30px;
          > ul {
            li {
              float: left;
              height: 20px;
              width: 20px;
              border: 1px solid #eee;
              border-radius: 50%;
            }
          }
          > a {
            margin-left: 60px;
          }
        }
      }
    }
  }
  .delbody {
    margin-top: 40px;
    margin-bottom: 20px;
    .delTil {
      padding-left: 10px;
      border-left: 5px solid #00a041;
      margin-bottom: 20px;
    }
    .delContent {
      > p {
        margin: 50px 0;
      }
    }
  }
  .delMore{
      .moreLi{
          >.contop1 {
            >div {
              >i {
                display: inline-block;
                vertical-align: middle;
                width: 5px;
                height: 5px;
                border-radius: 50%;
                background: #00a041;
              }

              >span {
                font-size: 14px;
              }

              >p {
                font-size: 13px;
                color: #b6b6b6;
                text-align: left;
                margin-top: 5px;

                >img {
                  width: 45px;
                  width: 33px;
                  display: inline-block;
                  vertical-align: middle;
                }
              }
            }

            >p {
              font-size: 12px;
              margin-top: 5px;
            }
          }
      }
  }
}
</style>


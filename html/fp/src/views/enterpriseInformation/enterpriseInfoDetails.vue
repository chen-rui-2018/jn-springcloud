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
          <img class="infoImg" :src="getDetails.posterUrl" alt="">
          <div class="infotitle">
            <div class="tit color4">
              {{getDetails.propagandaTitle}}
            </div>
            <div class="infoTime">
              <span>
                <i class="el-icon-time"></i>&nbsp;{{getDetails.createdTime}}</span>
              <span class="mainColor infoNum">
                <i class="el-icon-view"></i>&nbsp;{{getDetails.viewCount}}</span>
            </div>
            <div class="infoWeb">
              <img src="@/../static/img/zuozhe.png" alt="">
              <span></span>
            </div>
            <div class="infoImgItem">
              <!-- <img src="@/../static/img/图层 4.png" alt=""> -->
            </div>
          </div>
        </div>
      </el-card>
    </div>
    <div class="delbody">
      <div class="delTil">详情</div>
      <el-card>
        <div class="delContent">
          <p>{{getDetails.propagandaDetails}}</p>
        </div>
      </el-card>
    </div>
    <div class="delbody delMore">
      <div class="delTil">更多</div>
      <el-card>
        <ul>
          <li class="clearfix moreLi" v-for="(i,k) in recruitmentTable" :key="k">
            <div class="fl">
              <i></i>
              <span class="color1" style="text-align:left">{{i.propagandaTitle}}</span>
              <p>
                <!-- <img src="@/../static/img/图层 4.png" alt=""> -->
                <span class="crearTime">{{i.createdTime}}</span>
              </p>
            </div>
            <p class="fr mainColor pointer" @click="$router.push({ path: 'enterpriseInfoDetails', query: { propagandaId : i.id } })">MORE</p>
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
      getDetails: {},
      recruitmentTable: []
    };
  },
  created() {},
  mounted() {
    this.getBusinessPromotionDetails();
    this.getBusinessPromotionList();
  },
  methods: {
    //详情
    getBusinessPromotionDetails() {
      let _this = this;
      this.api.get({
        url: "getPromotionDetails",
        data: {
          propagandaId: _this.$route.query.propagandaId
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.getDetails = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //(门户各首页企业宣传列表查询)
    getBusinessPromotionList() {
      let _this = this;
      this.api.get({
        url: "getPromotionList",
        data: {
          page: 1,
          rows: 5,
          issuePlatform: 2,
          needPage: "1",
          propagandaType: "business_news"
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.recruitmentTable = res.data.rows;
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
    font-weight: bold;
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
    margin-bottom: 50px;
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
  .delMore {
    .moreLi {
      padding: 20px 40px 0;
      > div {
        > i {
          display: inline-block;
          vertical-align: middle;
          width: 5px;
          height: 5px;
          border-radius: 50%;
          background: #00a041;
        }

        > span {
          font-size: 14px;
          margin-left:10px;
        }

        > p {
          font-size: 13px;
          color: #b6b6b6;
          text-align: left;
          margin-top: 5px;

          > img {
            width: 45px;
            width: 33px;
            display: inline-block;
            vertical-align: middle;
          }
        }
      }

      > p {
        font-size: 12px;
        margin-top: 5px;
      }
      .crearTime{
        margin-left:18px;
      }
    }
  }
}
</style>


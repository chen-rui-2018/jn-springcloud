<template>
  <div class="parkDetails w">
    <div class="delnav">
      <span class="pointer" @click="$router.push({path:'/investment'})">招商引资</span>
      <span>/</span>
      <span class="mainColor">园区概况</span>
    </div>
    <div class="delinfo">
      <el-card style="overflow:visible">
        <div class="infotop pr">
          <img class="infoImg" :src="detail.mainPicture" alt="">
          <div class="infotitle">
            <div class="tit color4">园区概况</div>
            <div class="eng mainColor">PARK PROFILE</div>
            <div class="line"></div>
          </div>
        </div>
      </el-card>
    </div>
    <div class="delbody">
      <div class="delTil">详情</div>
      <el-card>
        <div class="delContent">
          <p v-html="detail.parkIntroduce"></p>
        </div>
      </el-card>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        detail: {}
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
          url: "basic",
          callback: function(res) {
            if (res.code == "0000") {
              _this.detail = res.data;
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
  .parkDetails {
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
        height: 310px;
        .infoImg {
          width: 548px;
          height: 323px;
          position: relative;
          left: -70px;
          top: -70px;
          border-radius: 10px;
        }
        .infotitle {
          position: absolute;
          left: 510px;
          top: 20px;
          .tit {
            font-size: 20px;
            margin-bottom:80px;
          }
          .eng {
            font-size: 42px;
            font-weight: 100;
          }
          .line {
            width: 33px;
            height: 1px;
            background: #00a041;
            //   margin: 0 auto;
            margin-top: 5px;
            margin-bottom: 20px;
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
  }
</style>


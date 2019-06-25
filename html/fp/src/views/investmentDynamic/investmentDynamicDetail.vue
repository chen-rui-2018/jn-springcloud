<template>
  <div class="policyGuide0">
    <div class="graphicCon w">
      <div class="techContent w">
        <span class="pointer" @click="$router.push({path:'/investmentDynamic'})">招商动态</span>
        <span>/</span>
        <span class="mainColor">招商动态详情</span>
      </div>
      <div class="agentInfo">
        <el-card>
          <div class="agent1">
            <div class="agentTil">{{getGuideDetal.title}}</div>
          </div>
          <div class="agent2 clearfix color2">
            <div>
              <p>
                <span class="tag-list">
                  <span>状态：</span>
                  <span v-if="isValid(getGuideDetal.endTime)" class="mainColor">有效</span>
                  <span v-else="isValid(getGuideDetal.endTime)">无效</span>
                </span>
              </p>
            </div>
            <div class="agent2Info fr">
              <p class="lastP color3">
                <span>发布时间：<i class="mainColor">{{getGuideDetal.startTime}}</i></span>
              </p>
            </div>
          </div>
        </el-card>
      </div>
      <div class="proDel">
        <div class="agentDelTit">动态详情</div>
        <div class="agentDelCon pr">
          <el-card>
            <div class="agent1 clearfix">
              <div class="agentTil mainColor fl">动态内容</div>
              <div class="orgBtn fr mainColor">
                <div class="mainColor shouqi pointer" v-if="zankaiFlag" @click='zankaiFlag=!zankaiFlag'>
                  收起
                  <i class="el-icon-arrow-up"></i>
                </div>
                <div class="mainColor shouqi zhankai pointer" v-else @click='zankaiFlag=!zankaiFlag'>
                  <i class="el-icon-arrow-down"></i>
                </div>
              </div>
            </div>
            <div class="agent2 color2" v-if="zankaiFlag">
              <div class="agent2Con" v-html="getGuideDetal.content"></div>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import userInfo from '.././common/userInfoData'
export default {
  components: {
      userInfo
    },
  data() {
    return {
      zankaiFlag: true,
      show4:false,
      searchData:'',
      getGuideDetal:'',
    };
  },
  mounted() {
    this.getPolicyDetails();
  },
  methods: {
    //政策指南详情
    getPolicyDetails() {
      let _this = this;
      this.api.get({
        url: "getBusinessAdDynamicInfo",
        data: {
          id: this.$route.query.id
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.getGuideDetal=res.data
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    isValid(str) {
      return new Date(str) >= new Date(new Date().toLocaleDateString()).getTime()
    },
  }
};
</script>
<style lang="scss">
.policyGuide0 {
  .techContent {
    padding: 20px 0;
  }
  padding-top: 65px;
  #headerActi {
    // position: relative;
    background-color: #fff;
    border-bottom: 1px solid #eee;
    box-shadow: 0 10px 10px -10px #ccc;
    .headerContainer {
      // position: relative;
      padding: 0 160px;
      width: 100%;
      height: 65px;
      line-height: 65px;
      color: #666;
      // font-weight: bold;
      font-size: 16px;
      box-sizing: border-box;
      // background-color: #757381;
      .titleImg {
        // width: 218px;
        // height: 54px;
        // margin-left:160px;
        width: 155px;
        height: 38px;
        img {
          width: 100%;
          height: 100%;
          vertical-align: middle;
        }
      }
      .nav {
        width: 600px;
        height: 37.6px;
        margin: 0 auto;
        > ul {
          overflow: hidden;
          li {
            float: left;
            // color: #ccc;
            font-size: 13px;
            text-align: center;
            // line-height: 52px;
            margin: 0 50px;
          }
        }
        // .sousuo {
        //   // width: 300px;
        //   height: 30px;
        //   line-height: 30px;
        //   font-size: 16px;
        //   margin-left: 150px;
        //   > input {
        //     width: 320px;
        //     height: 30px;
        //     border: none;
        //     outline: none;
        //   }
        // }
        .posA {
          position: absolute;
          left: 50%;
          transform: translateX(-50%);
          // padding: 20px 0;
          li {
            // > a {
            //   color: #000;
            // }
          }
        }
        .sousuo {
          font-size: 18px;
          line-height: 48px;
          > input {
            border: none;
            width: 350px;
            height: 38px;
            font-size: 14px;
          }
          > input::-webkit-input-placeholder {
            color: #b7b7b7;
            font-size: 12px;
          }
        }
      }
      .headerRight {
        .search {
          display: inline-block;
          margin-right: 20px;
          vertical-align: middle;
          i {
            width: 20px;
            height: 20px;
          }
        }
        .navlogin {
          display: inline-block;
          font-size: 13px;
          a {
            display: inline-block;
          }
          .line {
            display: inline-block;
            height: 12px;
            margin: 0 15px;
          }
          > img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
          }
        }
      }
    }
  }
  .graphicCon {
    .serverOrgMenu {
      padding: 20px 0;
      font-size: 13px;
      font-weight: bold;

      .agent {
        font-weight: bold;
      }
    }
    .agentInfo {
      .el-card__body {
        padding: 30px;
      }

      .agent1 {
        padding-bottom: 10px;
        border-bottom: 1px solid #eee;

        .agentTil {
          color: #333;
          margin-top: 6px;
          font-size: 20px;
        }

        .orgBtn {
          font-size: 13px;
          background: #ecfcf2;
          padding: 6px 20px;
          border: 1px solid #00a041;
          border-radius: 4px;
          cursor: pointer;
        }
      }

      .agent2 {
        margin-top: 20px;
        font-size: 13px;

        span.tag-list {
          display: inline-block;
          width: 200px;
         }

        .agent2Info {
          margin-left: 20px;

          > p {
            margin-bottom: 7px;
          }

          .lastP {
            // position: absolute;
            // margin-top: 20px;
            // margin-left: 630px;

            > span {
              margin-right: 20px;
            }
          }
        }
      }
    }
    .proDel {
      margin-bottom: 80px;
      .agentDelTit {
        padding: 20px 0;
      }
      .agentDelCon {
        .el-card__body {
          padding: 20px 30px;
        }
        .agent1 {
          //   padding: 10px 0;
          border-bottom: 1px solid #eee;
          .agentTil {
            padding: 10px 0;
            border-bottom: 2px solid #00a041;
          }
        }
        .agent2 {
          padding: 10px 0;
          .agent2Content {
            max-height: 400px;
            overflow: auto;
          }
          .orgBtn1 {
            font-size: 13px;
            background: #ecfcf2;
            padding: 6px 20px;
            width: 60px;
            margin: 0 auto;
            border: 1px solid #00a041;
            border-radius: 4px;
            margin-top: 20px;
            cursor: pointer;
          }
        }
      }
    }
  }
}
</style>

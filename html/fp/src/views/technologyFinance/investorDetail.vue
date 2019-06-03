<template>
    <div class="investorDetail w">
        <div class="investorMenu">
            <span class="pointer" @click="$router.push({path:'/tfindex'})">首页</span>
            <span>/</span>
            <span class="pointer" @click="$router.push({path:'/investor'})">投资人</span>
            <span>/</span>
            <span class="mainColor agent">投资人详情</span>
        </div>
        <div class="investorInfo">
            <el-card>
                <div class="agent1 clearfix">
                    <div class="agentTil fl">{{investorInfoDetails.investorName}}</div>
                    <div class="orgBtn fr mainColor pointer" @click="onlineContat(investorInfoDetails.investorAccount,investorInfoDetails.investorName)">在线联系</div>
                </div>
                <div class="agent2 clearfix color2">
                    <div class="agentImg fl">
                        <!-- <img src="@/../static/img/ins1.png" alt=""> -->
                        <img :src="investorInfoDetails.avatar" alt="">
                    </div>
                    <div class="agent2Info fl">
                        <p>所属单位：{{investorInfoDetails.orgName}}</p>
                        <p>职务：{{investorInfoDetails.position}}</p>
                        <p class="proNum">主投领域：
                            <span class="mainColor" v-for="(i,k) in mainAreaList" :key="k">{{i.mainName}}</span>
                        </p>
                        <!-- <p class="lastP color3">
                            <span>交易量：{{investorInfoDetails.investorBaseInfoShow.orgName}}</span>
                            <span>浏览：{{investorInfoDetails.investorBaseInfoShow.orgName}}</span>
                            <span>服务评分：1</span>
                        </p> -->
                    </div>
                </div>
            </el-card>
        </div>
        <div class="investorDel">
            <div class="agentDelTit">投资人详情</div>
            <div class="agentDelCon pr">
                <el-card>
                    <div class="agent1 clearfix">
                        <div class="agentTil mainColor fl">个人简介</div>
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
                        <div class="agent2Con" v-if="flag1" :class="{showall:true,active:showall}">
                            {{investorInfoDetails.personalProfile}}
                        </div>
                        <div class="agent2Con" v-else>
                            暂无内容！
                        </div>
                        <div class="orgBtn1 mainColor tx" v-if="flag2" :class="{'active':showall}" @click="showall=!showall;flag2=!flag2">
                            <i class="el-icon-arrow-down"></i>
                        </div>
                    </div>
                </el-card>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      zankaiFlag: true,
      flag1: true,
      flag2: true,
      showall: false,
      investorInfoDetails:{},
      mainAreaList:'',
    };
  },
  mounted() {
    this.getInvestorInfoDetails();
  },
  methods: {
     //在线联系
    onlineContat(investorAccount,investorName){
       if (!sessionStorage.userInfo) {
        this.$message.error("请先登录");
        return;
      }
      this.$router.push({path:'/chat',query:{fromUser:sessionStorage.userInfo.account,toUser:investorAccount,nickName:investorName}})
    },
    getInvestorInfoDetails() {
      //投资人详情
      let _this = this;
      this.api.get({
        url: "getInvestorInfoDetails",
        data: {
          investorAccount : _this.$route.query.investorAccount,
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.investorInfoDetails = res.data.investorBaseInfoShow;
            _this.mainAreaList=res.data.mainAreaList
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
.investorDetail {
  padding-top:65px;
  .investorMenu {
    padding: 20px 0;
    font-size: 13px;
    font-weight: bold;

    .agent {
      font-weight: bold;
    }
  }
  .investorInfo {
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

      .agentImg {
        width: 150px;
        height: 120px;

        > img {
          width: 100%;
          height: 100%;
        }
      }

      .agent2Info {
        margin-left: 20px;

        > p {
          margin-bottom: 7px;
        }

        .lastP {
          position: absolute;
          margin-left: 630px;

          > span {
            margin-right: 20px;
          }
        }
        .proNum {
            margin-top: 20px;
          > span {
            display: inline-block;
            font-size: 13px;
            background: #ecfcf2;
            padding: 6px 20px;
            border: 1px solid #00a041;
            border-radius: 4px;
            // margin-top: 20px;
            margin-right:30px;
          }
        }
      }
    }
  }

  .investorDel {
    font-size: 14px;
    margin-bottom: 60px;

    .agentDelTit {
      padding: 20px 0;
      font-size: 18px;
      color: #333;
    }

    .agentDelCon {
      font-size: 12px;
      .el-card__body {
        padding-bottom: 10px;
      }
      > .shouqi {
        position: absolute;
        right: 25px;
        top: 30px;
        font-size: 13px;
        z-index: 2;
        text-align: center;
      }

      > .zhankai {
        width: 30px;
      }
      .agent1 {
        border-bottom: 1px solid #eee;
        .agentTil {
          padding-bottom: 10px;
          border-bottom: 2px solid #00a041;
          font-size: 15px;
        }
      }
      .agent2 {
        padding-top: 10px;
        .agent2Con {
          height: 150px;
          overflow: hidden;
          font-size: 13px;
        }
      }
      .orgBtn1 {
        text-align: center;
      }
      .orgBtn1.active {
        height: auto;
        min-height: 150px;
      }
    }
  }
}
</style>

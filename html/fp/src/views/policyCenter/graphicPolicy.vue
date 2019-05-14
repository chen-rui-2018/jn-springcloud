<template>
    <div class="graphicPolicy">
        <div class="apphead">
            <div class="box-card">
                <div id="headerActi">
                    <div class="headerContainer clearfix">
                        <div class="titleImg fl"><img src="@/../static/img/login-logo.png" alt="" class="pointer" @click="$router.push({path:'/'})"></div>
                        <div class="menu" style="display:none">
                            <i class="el-icon-close"></i>
                            <input type="text">
                            <i class="el-icon-search"></i>
                        </div>
                        <div class="headerRight fr">
                            <div class="search">
                                <i class="el-icon-search" @click="show4=true" style="font-size:20px"></i>
                            </div>
                            <div class="navlogin" v-if="this.$route.name!=='actiManagent'">
                                <a>登录</a>
                                <span class="line">|</span>
                                <a>注册</a>
                            </div>
                        </div>
                        <div class="nav">
                            <ul class="posA clearfix">
                                <li>
                                    <a href="javascript:void(0);">政策中心</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="search_box" id="search_box" @mouseleave="show4=!show4">
                <el-collapse-transition>
                    <div v-show="show4">
                        <div class="transition-box">
                            <el-input placeholder="请输入内容" v-model="searchData" class="input-with-select">
                                <el-button slot="append" icon="el-icon-search">搜索 </el-button>
                            </el-input>
                        </div>
                    </div>
                </el-collapse-transition>
            </div>
        </div>
        <div class="graphicCon w">
            <div class="serverOrgMenu">
                <span>首页/</span>
                <span class="mainColor agent">图解政策详情</span>
            </div>
            <div class="agentInfo">
                <el-card>
                    <div class="agent1">
                        <div class="agentTil">{{getDetal.policyTitle}}</div>
                    </div>
                    <div class="agent2 clearfix color2">
                        <div class="agentImg">
                            政策原文：<span class="mainColor">《》</span>
                        </div>
                        <div class="agent2Info fr">
                            <p class="lastP color3">
                                <span>阅读量：{{getDetal.readNum}}</span>
                                <span>发布时间：<i class="mainColor">{{getDetal.releaseDate}}</i></span>
                            </p>
                        </div>
                    </div>
                </el-card>
            </div>
            <div class="proDel">
                <div class="agentDelTit">政策详情</div>
                <div class="agentDelCon pr">
                    <el-card>
                        <div class="agent1 clearfix">
                            <div class="agentTil mainColor fl">图解内容</div>
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
                            <div class="agent2Con">
                                {{getDetal.policyDiagramUrl}}
                            </div>
                            <!-- <div class="agent2Con" v-else>
                            暂无内容！
                        </div> -->
                        </div>
                    </el-card>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      zankaiFlag: true,
      show4:false,
      searchData:'',
      getDetal:'',
    };
  },
  mounted(){
    this.getPolicyDiagramDetails()
  },
    methods: {
    //政策指南详情
    getPolicyDiagramDetails() {
      let _this = this;
      this.api.get({
        url: "getPolicyDiagramDetails",
        data: {
          policyId: _this.$route.query.policyId
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.getDetal=res.data
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
.graphicPolicy {
  padding-top: 65px;
  .apphead {
    z-index: 9;
    width: 100%;
    position: fixed;
    top: 0;
    .search_box {
      // background: rgba(0, 0, 0, 0.3);
      width: 100%;
      background: #fff;
      box-shadow: 0 10px 10px -10px #ccc;
      .el-input-group {
        border-radius: 28px;
        width: 42%;
        margin: 43px 0;
        position: relative;
        transform: translateX(-50%);
        left: 50%;
        .el-input {
          width: 94px;
        }
        .el-input__inner:focus {
          border-color: #00a041;
        }
        .el-input-group__append,
        .el-input-group__prepend {
          border-radius: 28px;
        }
        .el-input-group__append {
          /* border-top-left-radius: 0;
        border-bottom-left-radius: 0; */
          background: #00a041;
          color: #fff;
          right: 58px;
          .el-button {
            margin: -10px -10px;
          }
        }
        .el-input-group__prepend {
          border-top-right-radius: 0;
          border-bottom-right-radius: 0;
          background-color: #fff;
          padding: 0px 17px 0 9px;
          input {
            color: #666666;
            text-align: right;
          }
        }
      }
      .input-with-select .el-input__inner {
        border-top-left-radius: 19px;
        border-bottom-left-radius: 19px;
        border: 1px solid #00a041;
      }
    }
  }
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
            > a {
              color: #000;
            }
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

        .agentImg {
        //   width: 150px;
        //   height: 120px;
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
          .agentTil{
            padding: 10px 0;
            border-bottom: 2px solid #00a041;
          }
        }
        .agent2 {
          padding: 10px 0;
          .agent2Con {
            height: 150px;
            width: 80%;
            overflow: hidden;
            // white-space: nowrap;
            // text-overflow: ellipsis;
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

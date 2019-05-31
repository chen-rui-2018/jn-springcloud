<template>
  <div class="profileDetails">
    <div class="banner">
      <div class="swiper-container">
        <div class="swiper-wrapper">
          <div class="swiper-slide" style="width:100%">
            <img src="@/../static/img/company1.png" alt="">
          </div>
          <div class="swiper-slide" style="width:100%">
            <img src="@/../static/img/company2.png" alt="">
          </div>
          <div class="swiper-slide" style="width:100%">
            <img src="@/../static/img/company3.png" alt="">
          </div>
        </div>
        <!-- 如果需要分页器 -->
        <div class="swiper-pagination"></div>

        <!-- 如果需要导航按钮 -->
        <div class="swiper-button-prev" style="display:none">
        </div>
        <div class="swiper-button-next" style="display:none">
        </div>
      </div>
    </div>
    <div class="serverOrgMenu w color2">
      <span class="pointer" @click="$router.push({path:'/'})">首页/</span>
      <span class="pointer" @click="$router.push({path:'/companyProfile'})">企业简介</span>
      <span>/</span>
      <span class="mainColor agent">企业简介详情</span>
    </div>
    <div class="agentInfo w">
      <el-card>
        <div class="agent1 clearfix">
          <div class="agentTil fl color1">{{companyDetail.comName}}</div>
          <div class="orgBtn fr mainColor">
            <span class="span1 span2" @click="onlineContact">在线联系</span>
            <span class="span1" @click="$router.push({path:'/recruitmentList',query:{comId:companyDetail.id}})">热招职位</span>
            <span class="span1 span3">+关注</span>
          </div>
        </div>
        <div class="agent2 clearfix color2 pr">
          <div class="agentImg fl">
            <img :src="companyDetail.avatar" alt="">
            <!-- <img src="@/../static/img/ins1.png" alt=""> -->
          </div>
          <div class="agent2Info fl color2">
            <p>官网地址：
              <span class="mainColor">{{companyDetail.comWeb}}</span>
            </p>
            <p>所属园区：{{companyDetail.affiliatedName}}</p>
            <p>我的服务：{{companyDetail.comServer}}</p>
            <p>我的需求：{{companyDetail.comDemand}}</p>
            <p class="comInfo">
              <span class="mainColor">{{companyDetail.comTypeName}}</span>| {{companyDetail.comPerSonNumber}}人 |{{companyDetail.foundingTime}} | {{companyDetail.city}}</p>
            <p class="lastP color3 fr">
              <span>关注数：{{companyDetail.careNumber}}</span>
              <span>浏览：{{companyDetail.browseNumber}}</span>
              <span>合作留言：{{companyDetail.commentNumber}}</span>
            </p>
          </div>
        </div>
      </el-card>
    </div>
    <div class="agentDel w">
      <div class="agentDelTit">企业资料</div>
      <div class="agentDelCon pr color1">
        <div class="mainColor shouqi pointer" v-if="zankaiFlag" @click='handleZd'>
          收起
          <i class="el-icon-arrow-up"></i>
        </div>
        <div class="mainColor shouqi zhankai pointer" v-else @click='handleZk'>
          <i class="el-icon-arrow-down"></i>
        </div>
        <el-card>
          <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="公司概况" name="baseInfo">
              <div class="basicInfo" v-if="zankaiFlag">
                <p>公司简介</p>
                <p class="short">{{companyDetail.comSynopsis}}
                </p>
                <p class="p1">工作地址：{{companyDetail.addrPark}}</p>
                <p class="p1">企业网址：
                  <span class="mainColor">{{companyDetail.comWeb}}</span>
                </p>
                <p class="p1">联系电话：
                  <span class="mainColor">{{companyDetail.conTele}}</span>
                </p>
              </div>
            </el-tab-pane>
            <el-tab-pane label="法人资料" name="businessinfo">
              <div class="businessinfo" v-if="zankaiFlag">
                <table class="table-orgspace mainBorder">
                  <tr>
                    <td class="table-orgspace-title">姓名:</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div>{{companyDetail.ownerLaw}}</div>
                    </td>
                    <td class="table-orgspace-title">联系电话：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div>{{companyDetail.ownerPhone}}</div>
                    </td>
                  </tr>
                  <!-- <tr>
                                        <td class="table-orgspace-title">毕业学校：</td>
                                        <td class="table-orgspace-detail" width="300px" colspan="2">
                                            <div>冻结</div>
                                        </td>
                                        <td class="table-orgspace-title">学历：</td>
                                        <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                                            <div>
                                                <div>呃呃呃</div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="table-orgspace-title">个人简介：</td>
                                        <td class="table-orgspace-detail" colspan="4">
                                            <div class="table-orgspace-col">说的对吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼吼</div>
                                        </td>
                                    </tr> -->
                </table>
              </div>
            </el-tab-pane>
            <el-tab-pane label="产品" name="honor">
              <div class="honor clearfix" v-if="zankaiFlag">
                <ul class="clearfix">
                  <li class="">
                    <span class="contact-detail-img mr5"></span>{{companyDetail.products}}
                  </li>
                  <!-- <li class="">
                                        <span class="contact-detail-img mr5"></span>联系人信息
                                    </li>
                                    <li class="">
                                        <span class="contact-detail-img mr5"></span>联系人信息
                                    </li> -->
                </ul>
              </div>
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </div>
    </div>
    <div class="delmessage w">
      <div class="mesTil">留言</div>
      <el-card>
        <div class="mesContent">
          <el-input type="textarea" :rows="3" placeholder="请输入留言" v-model="textData">
          </el-input>
          <el-button type="success" style="background:#00a040;height:38px;width:90px" round @click="leaveMessage(companyDetail.companyId)">留言</el-button>
        </div>
      </el-card>
    </div>
    <div class="delcomment w">
      <div class="comTil">全部评论</div>
      <el-card>
        <div class="comContent">
          <ul>
            <li v-for="(item,key) in commentInfo" :key="key">
              <div class="clearfix">
                <div class="liLeft">
                  <img :src="item.avatar" alt="">
                  <div style="display:inline-block;margin-bottom: 20px;margin-left: 20px">
                    <span>{{item.creatorAccount}}</span><br>
                    <span>{{item.comContent}}</span>
                  </div>
                </div>
                <div class="liRight">
                  <p>{{item.createdTime}}</p>
                  <p>
                    <i class="iconfont" :class="item.isCommentLike == 'true'?'icon-dianzan1 mainColor':'icon-iconfontdianzan'" style="cursor:pointer" @click="comLike(item)">&nbsp;赞
                      <span>{{item.likeNum}}</span>
                    </i>
                    <!-- <i class="iconfont icon-dianzan1 mainColor" style="cursor:pointer" v-if="isClick==1" @click="comCancleLike(item)">&nbsp;赞
                    </i>
                    <span>{{item.likeNum}}</span> -->
                    <i class="iconfont icon-liuyan" v-if="inFlag == item.id" style="cursor:pointer" @click="inFlag = '';">&nbsp;收起回复</i>
                    <i class="iconfont icon-liuyan" v-else style="cursor:pointer" @click="replyFlag(item.id)">&nbsp;回复</i>

                  </p>
                </div>
              </div>
              <div v-if="inFlag == item.id">
                <el-input type="textarea" :rows="3" placeholder="请输入留言" v-model.trim="textMessage"></el-input>
                <el-button type="success" @click="replycom(item)" style="background:#00a040;height:38px;width:90px;margin-left: 1014px;margin-top: 10px;" round>回复</el-button>
              </div>
              <div class="reply" v-if="k<5" v-for="(i,k) in item.childList" :key="k">
                <img :src="i.avatar" alt="">
                <div class="replyinfo">
                  {{i.creatorAccount}}
                  <p>回复@{{i.parentAccount}}：{{i.comContent}}</p>
                </div>
                <span>{{i.createdTime}}</span>
              </div>
            </li>
          </ul>
          <div class="pagination-container" style="margin-top:50px">
            <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row" layout="total, sizes, prev, pager, next, jumper" :total="total">
            </el-pagination>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>
<script>
import swiper from "swiper";
export default {
  data() {
    return {
      zankaiFlag: false,
      inFlag: "",
      activeName: "baseInfo",
      companyDetail: {},
      commentInfo: [],
      textData: "",
      textMessage: "",
      page: 1,
      row: 5,
      total: 0
    };
  },
  created() {
    this.swiperinit();
    this.getCompanyDetail();
    this.getComCommentInfo();
  },
  methods: {
    //留言
    leaveMessage(id) {
      if (!sessionStorage.userInfo) {
        this.$message.error("请先登录");
        return;
      }
      let _this = this;
      this.api.post({
        url: "getcommentActivity",
        data: {
          comContent: _this.textData,
          comType: 3,
          rootId: id,
          pId: id
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.textData = "";
            _this.getComCommentInfo();
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //点击评论回复
    replyFlag(i) {
      if (this.inFlag == i) {
        return;
      }
      this.textMessage = "";
      this.inFlag = i;
    },
    //回复评论
    replycom(item) {
      if (!sessionStorage.userInfo) {
        this.$message.error("请先登录");
        return;
      }
      this.inFlag = "";
      let _this = this;
      this.api.post({
        url: "getcommentActivity",
        data: {
          comContent: _this.textMessage,
          comType: item.comType,
          pId: item.id,
          rootId: item.rootId
        },
        // urlFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.getComCommentInfo();
          }
          _this.$message(res.result);
        }
      });
    },
    //在线联系
    onlineContact() {
      if (!sessionStorage.userInfo) {
        this.$message.error("请先登录");
        return;
      }
      this.$router.push({ path: "chat" });
    },
    swiperinit() {
      // if (this.policyCenterList.length <= 1 ) {
      //   return
      // }
      var mySwiper = new swiper(".swiper-container", {
        direction: "horizontal", // 垂直切换选项
        loop: true, // 循环模式选项
        noSwiping: true,
        autoplay: true,
        autoplay: {
          delay: 2000
        },

        // 如果需要分页器
        pagination: {
          el: ".swiper-pagination"
        },
        // 如果需要前进后退按钮
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
        },

        // 如果需要滚动条
        scrollbar: {
          el: ".swiper-scrollbar"
        }
      });
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.row2 = val;
      this.page2 = 1;
      //   this.getServiceConList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page2 = val;
      //   this.getServiceConList();
    },
    handleZk() {
      this.zankaiFlag = true;
    },
    handleZd() {
      this.zankaiFlag = false;
    },
    handleClick(tab, event) {
      // console.log(tab, event);
    },
    //根据用户账号查询企业信息
    getCompanyDetail() {
      let _this = this;
      this.api.get({
        url: "getCompanyDetails",
        data: {
          companyId: this.$route.query.id
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.companyDetail = res.data.companyInfoShow;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //获取评论/留言
    getComCommentInfo() {
      let _this = this;
      this.api.get({
        url: "getComCommentInfo",
        data: {
          activityId: this.$route.query.id,
          page: this.page,
          rows: this.row
        },
        callback: res => {
          if (res.code == "0000") {
            this.commentInfo = res.data.rows;
            this.total = res.data.total;
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
.profileDetails {
  .banner {
    .swiper-pagination {
      //   bottom: 40%;
      //   left: 92%;
      .swiper-pagination-bullet {
        margin-bottom: 10px;
        opacity: 1;
        background: #ccc;
      }
      .swiper-pagination-bullet-active {
        background: #fff;
        border-radius: 4px;
      }
    }
  }
  table {
    border-collapse: collapse;
    border-spacing: 0;
  }

  .el-tabs__item.is-active {
    color: #00a041;
  }

  .el-tabs__active-bar {
    background: #00a041;
  }

  .el-tabs__item:hover {
    color: #00a041;
  }

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
        .span1 {
          display: inline-block;
          font-size: 13px;
          width: 52px;
          background: #ecfcf2;
          padding: 6px 20px;
          border: 1px solid #00a041;
          border-radius: 4px;
          cursor: pointer;
          margin-left: 20px;
          text-align: center;
        }
        .span2 {
          color: #55a6ff;
          border: 1px solid #55a6ff;
          background: rgba(228, 240, 255, 1);
        }
        .span3 {
          color: #ffbd5c;
          border: 1px solid #ffbd5c;
          background: rgba(254, 245, 229, 1);
        }
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
        .comInfo {
          margin-bottom: 0;
          margin-top: 15px;
        }
        .lastP {
          position: absolute;
          bottom: -14px;
          right: 0;

          > span {
            margin-right: 20px;
          }
        }
      }
    }
  }

  .agentDel {
    font-size: 14px;

    .agentDelTit {
      padding: 20px 0;
      font-size: 16px;
      color: #333;
    }

    .agentDelCon {
      font-size: 12px;

      .el-tabs__item {
        font-size: 15px;
        color: #333;
      }

      > .shouqi {
        position: absolute;
        right: 25px;
        top: 30px;
        font-size: 14px;
        z-index: 2;
        text-align: center;
      }

      > .zhankai {
        width: 30px;
      }

      .basicInfo,
      .businessinfo,
      .teamInfo,
      .contactInfo {
        .table-orgspace {
          width: 100%;

          tr td {
            padding: 0px 14px;
            line-height: 50px;
            font-size: 14px;
            border: 1px solid #e4e4e4;
          }

          .table-orgspace-title {
            color: #666;
            background-color: #f8f8f8;
            font-size: 13px;
          }

          .table-orgspace-detail {
            color: #333;
            font-size: 13px;
          }

          .table-orgspace-col {
            color: #333;
            padding: 10px 0px;
            line-height: 22px;
            text-align: justify;
            font-size: 13px;
          }
        }
      }

      .businessinfo {
        .table-orgspace-title {
          width: 146px;
        }
      }

      .honor {
        // padding: 20 0px;
        font-size: 14px;

        > ul {
          > li {
            margin-bottom: 20px;
            float: left;
            width: 45%;
            .honorImg {
              width: 130px;
              height: 80px;
              display: inline-block;
              vertical-align: middle;

              > img {
                width: 100%;
                height: 100%;
              }
            }

            .dataCircle {
              width: 20px;
              height: 20px;
              margin: 0 40px;
              display: inline-block;
              vertical-align: middle;

              > img {
                width: 100%;
                height: 100%;
              }
            }

            .honorTime {
              display: inline-block;
              vertical-align: middle;
            }

            .honorName {
              margin-left: 40px;
              display: inline-block;
              vertical-align: middle;
            }
          }

          > li:last-child {
            margin-bottom: 0;
          }
        }

        .dataLeft {
          > div {
            margin-bottom: 20px;
            width: 130px;
            height: 80px;

            > img {
              width: 100%;
              height: 100%;
            }
          }
        }

        .dataMid {
          margin: 0 50px;
          margin-top: 30px;

          .dataCircle {
            width: 20px;
            height: 20px;
            border-radius: 50%;
            border: 1px solid #ccc;
            background: #00a041;
          }

          .dataLine {
            width: 2px;
            height: 80px;
            margin-left: 10px;
            background-color: #00a041;
          }
        }

        .dataMid2 {
          margin-top: 35px;
          margin-right: 30px;

          > div {
            margin-bottom: 80px;
          }

          > div:last-child {
            margin-bottom: 0px;
          }
        }

        .dataRight {
          margin-top: 30px;

          > div {
            margin-bottom: 60px;
          }

          > div:last-child {
            margin-bottom: 0px;
          }
        }
      }

      .teamInfo,
      .contactInfo {
        .contact-title {
          padding: 0px 0px 16px;
          color: #333;
          font-weight: bold;
        }

        .mt20 {
          margin-top: 20px;
        }

        .mr5 {
          margin-right: 5px;
        }

        .contact-detail-img {
          display: inline-block;
          height: 10px;
          width: 10px;
          line-height: 15px;
          border-radius: 50%;
          background: #00a041;
        }
      }
    }
  }
  .delmessage {
    margin-top: 40px;
    margin-bottom: 20px;
    .mesTil {
      padding-left: 10px;
      border-left: 5px solid #00a041;
      margin-bottom: 20px;
    }
    .mesContent {
      padding: 20px;
      // border: 1px solid #ccc;
      > .el-button {
        margin-top: 20px;
        margin-left: 1020px;
      }
    }
  }
  .delcomment {
    margin-top: 30px;
    margin-bottom: 80px;
    .comTil {
      padding-left: 10px;
      border-left: 5px solid #00a041;
      margin-bottom: 20px;
    }
    .comContent {
      padding: 20px;
      // border: 1px solid #ccc;
      > ul {
        > li {
          border-bottom: 1px solid #eee;
          padding: 20px 0;
          .liLeft {
            float: left;
            > img {
              display: inline-block;
              width: 50px;
              height: 50px;
            }
          }
          .liRight {
            float: right;
          }
          .reply {
            padding: 30px;
            background: #f9f9f9;
            width: 88%;
            margin-left: 70px;
            margin-top: 10px;
            > span {
              float: right;
            }
            .replyinfo {
              display: inline-block;
              margin-left: 20px;
            }
          }
        }
      }
    }
    .el-textarea {
      width: 93.5%;
      margin-left: 70px;
    }
  }
  .short {
    margin: 20px 0;
  }
  .p1 {
    margin-bottom: 10px;
  }
}
</style>

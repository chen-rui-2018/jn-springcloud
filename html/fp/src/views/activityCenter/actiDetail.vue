<template>
  <div class="actiDetail w">
    <div class="delnav">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/actiCenter' }">
          <a href="/actiCenter.vue">活动中心</a>
        </el-breadcrumb-item>
        <el-breadcrumb-item>
          <a href="javascript:void(0)" style="color:#00a042;font-weight:bold">活动详情</a>
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="delinfo">
      <el-card style="overflow:visible">
        <div class="infotop pr">
          <img class="infoImg" :src="this.activityDetail.actiPosterUrl" alt="">
          <div class="infotitle">
            <span>{{this.activityDetail.actiName}}</span>
            <i class="iconfont  like" :class="accountIsLike ? 'icon-miaojiesellerlike mainColor' : 'icon-xihuan'" @click="handleLike(activityDetail.id)">&nbsp;
              <span>{{this.activityDetail.actiLike}}</span>
            </i>
            <!-- <i class="iconfont like" v-else @click="cancleLike(activityDetail.id)">&nbsp;
              <span>{{this.activityDetail.actiLike}}</span>
            </i> -->
            <p>
              <i class="el-icon-time"></i>
              <span>{{this.activityDetail.actiStartTime}}-{{this.activityDetail.actiEndTime}}</span>
              <i class="iconfont icon-mianfei free">&nbsp;免费</i>
            </p>
            <div class="delAddress">
              <i class="el-icon-location-outline"></i>
              <span>{{this.activityDetail.actiAddress}}</span>
            </div>
            <div class="userImg">
              <ul>
                <li><img src="" alt=""></li>
              </ul>
              <span>{{this.activityDetail.applyNum}}/{{this.activityDetail.actiNumber}}</span>
              <a href="javascript:void(0)" class="mainColor" @click="handCheck(activityDetail.id)">查看报名情况</a>
            </div>
          </div>
        </div>
        <div class="infobottom">
          <p style="margin-top:10px">发布时间：{{this.activityDetail.issueTime}}</p>
          <p>主办方：{{this.activityDetail.actiOrganizer}}</p>
          <p>报名截止时间：{{this.activityDetail.applyEndTime}}
            <span class="resdeadline">报名截止还有&nbsp;3天18小时59分59秒</span>
            <!-- <span class="resdeadline">报名截止还有&nbsp;{{this.sysTemTime-this.activityDetail.applyEndTime}}</span> -->
          </p>
          <div class="delshare">
            <el-button type="success" v-if="this.activityDetail.actiStatus=='2'&&this.activityDetail.isApply=='1'" style="background:#00a040;height:38px;width:110px" round @click="quickApply(activityDetail.id)">立即报名</el-button>
            <el-button type="success" v-if="this.activityDetail.actiStatus=='2'&&this.activityDetail.isApply=='0'" style="background:#00a040;height:38px;width:110px" round @click="stopApply(activityDetail.id)">停止报名</el-button>
            <el-button type="success" class="atten" round icon="iconfont icon-xihuan">&nbsp;关注&nbsp;3</el-button>
            <span class="shareto">
              分享到
              <i class="iconfont icon-weixin"></i>
              <i class="iconfont icon-12sina"></i>
            </span>
          </div>
        </div>
      </el-card>
    </div>
    <div class="delbody">
      <div class="delTil">详情</div>
      <el-card>
        <div class="delContent">
          <!-- <img src="@/../static/img/detail1.png" alt=""> -->
          <p>{{this.activityDetail.actiDetail}}</p>
          <!-- <img src="@/../static/img/detail2.png" alt=""> -->
        </div>
      </el-card>
    </div>
    <div class="delmessage">
      <div class="mesTil">留言</div>
      <el-card>
        <div class="mesContent">
          <el-input type="textarea" :rows="3" placeholder="请输入留言" v-model="textarea">
          </el-input>
          <el-button type="success" style="background:#00a040;height:38px;width:90px" round>留言</el-button>
        </div>
      </el-card>
    </div>
    <div class="delcomment">
      <div class="comTil">全部评论</div>
      <el-card>
        <div class="comContent">
          <ul>
            <li v-for="(item,key) in commentList" :key="key">
              <div class="clearfix">
                <div class="liLeft">
                  <img :src="item.avatar" alt="">
                  <div style="display:inline-block;margin-bottom: 20px">
                    <span>{{item.creatorAccount}}</span><br>
                    <span>{{item.comContent}}</span>
                  </div>
                </div>
                <div class="liRight">
                  <p>{{item.createdTime}}</p>
                  <p>
                    <i class="iconfont" :class="isCommentLike?'icon-dianzan1 mainColor':'icon-iconfontdianzan'" style="cursor:pointer" @click="comLike(item)">&nbsp;赞
                      <span>{{item.likeNum}}</span>
                    </i>
                    <!-- <i class="iconfont icon-dianzan1 mainColor" style="cursor:pointer" v-if="isClick==1" @click="comCancleLike(item)">&nbsp;赞
                    </i>
                    <span>{{item.likeNum}}</span> -->
                    <i class="iconfont icon-liuyan" style="cursor:pointer" @click="replyFlag()">&nbsp;回复</i>
                  </p>
                </div>
              </div>

              <div class="reply" v-if="k<5" v-for="(i,k) in item.childList" :key="k">
                <img :src="i.avatar" alt="">
                <div class="replyinfo">
                  {{i.creatorAccount}}
                  <p>回复@{{i.parentAccount}}：{{i.comContent}}</p>
                </div>
                <span>{{i.createdTime}}</span>
              </div>
              <div v-if="inFlag">
                <el-input type="textarea" :rows="3" placeholder="请输入留言" v-model="textarea"></el-input>
                <el-button type="success" @click="replycom(item)" style="background:#00a040;height:38px;width:90px;margin-left: 1014px;margin-top: 10px;" round>回复</el-button>
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
export default {
  data() {
    return {
      inFlag: false,
      textarea: "",
      activityDetail: {},
      currentPage1: 1,
      page: 1,
      row: 5,
      total: 0,
      commentList: [],
      sysTemTime:"",
      accountIsLike: false,
      isCommentLike: false
    };
  },
  created(){
    this.init();
    this.getCommentInfo();
  },
  mounted() {    
    this.countdown()
  },
  methods: {
    replyFlag() {
      this.inFlag = true;
    },
    handleReply(comContent, comType, pId, rootId) {
      //回复评论
      let _this = this;
      this.api.post({
        url: "commentActivity",
        data: {
          comContent: comContent,
          comType: comType,
          pId: pId,
          rootId: rootId
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.getCommentInfo();
          }
        }
      });
    },
    replycom(item) {
      //回复评论
      this.inFlag = false;
      let _this = this;
      this.api.post({
        url: "springcloud-park/comment/review/commentActivity",
        data: {
          comContent: item.comContent,
          comType: item.comType,
          pId: item.pId,
          rootId: item.rootId
        },
        // urlFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    comLike(item) {
      //评论点赞
      let url = "";
      if (this.isCommentLike) {
        //如果是已经点赞了就取消点赞
        url = `springcloud-park/comment/review/commentActivityCancelLike?id=${
          item.id
        }`;
      } else {
        //如果是没点赞就点赞
        url = `springcloud-park/comment/review/commentActivityLike?id=${
          item.id
        }`;
      }
      let _this = this;
      this.api.post({
        url: url,
        data: {
          id: item.id
        },
        dataFlag: true,
        urlFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            if (_this.isCommentLike) {
              //如果是已经点赞了就取消点赞
              item.likeNum -= 1;
              _this.$message.success("取消点赞成功");
              _this.isCommentLike = false;
            } else {
              //如果是没点赞就点赞
              item.likeNum = item.likeNum * 1 + 1;
              _this.$message.success("点赞成功");
              _this.isCommentLike = true;
            }
          } else {
            _this.$message.error(res.result);
          }
        }
      });
      // let _this = this;
      // this.api.post({
      //   url: `springcloud-park/comment/review/commentActivityLike?id=${item.id}`,
      //   data: {
      //     id: item.id
      //   },
      //   dataFlag: true,
      //   urlFlag: true,
      //   callback: function(res) {
      //     if (res.code == "0000") {
      //       item.likeNum = item.likeNum * 1 + 1;
      //       _this.$message.success("点赞成功");
      //     } else {
      //       _this.$message.error(res.result);
      //     }
      //   }
      // });
    },
    handleSizeChange(val) {
      this.row = val;
      this.page = 1;
      // this.init()
      this.getCommentInfo();
    },
    handleCurrentChange(val) {
      this.page = val;
      // this.init()
      this.getCommentInfo();
    },
    handCheck(id) {
      //跳转报名人列表
      this.$router.push({ path: "regStatus", query: { activityId: id } });
    },
    quickApply(id) {
      //立即报名
      let _this = this;
      this.api.post({
        url: `springcloud-park/activity/activityApply/quickApply?activityId=${id}`,
        data: {
          activityId: id
        },
        urlFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.$message.success("报名成功");
            console.log(res);
            _this.init();
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    stopApply(id) {
      //停止报名
      let _this = this;
      this.api.post({
        url: `springcloud-park/activity/activityApply/cancelApply?activityId=${id}`,
        data: {
          activityId: id
        },
        dataFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.$message.success("取消报名成功");
            _this.init();
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    handleLike(id) {
      //活动点赞
      let url = "";
      if (this.accountIsLike) {
        //如果是已经点赞了就取消点赞
        url = `springcloud-park/activity/activityLike/cancelLike?activityId=${id}`;
      } else {
        //如果是没点赞就点赞
        url = `springcloud-park/activity/activityLike/activityLike?activityId=${id}`;
      }
      let _this = this;
      this.api.post({
        url: url,
        data: {
          activityId: id
        },
        dataFlag: true,
        urlFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            if (_this.accountIsLike) {
              //如果是已经点赞了就取消点赞
              _this.activityDetail.actiLike -= 1;
              _this.$message.success("取消点赞成功");
              _this.accountIsLike = false;
            } else {
              //如果是没点赞就点赞
              _this.activityDetail.actiLike =
                _this.activityDetail.actiLike * 1 + 1;
              _this.$message.success("点赞成功");
              _this.accountIsLike = true;
            }
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    // campareTime(){ //时间比较
    //   var t1=new Date(this.sysTemTime)
    //   var t2=new Date(this.activityDetail.applyEndTime)

    // },
    //报名倒计时
    countdown(){
      console.log(this.sysTemTime)
      var s1=new Date(this.sysTemTime);
      var s2=new Date(this.activityDetail.applyEndTime);
      var s3 = s2.getTime() - s1.getTime();
      console.log(s3)
    },
    init() {
      //数据初始化
      let _this = this;
      this.api.post({
        url: "getActivityDetails",
        data: {
          activityId: this.$route.query.activityId
        },
        dataFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.activityDetail = res.data.activityDetail;
            _this.sysTemTime=res.data.sysTemTime;
            _this.accountIsLike = res.data.accountIsLike;
          }
        }
      });
    },
    getCommentInfo() {
      //获取评论信息
      let _this = this;
      this.api.post({
        url: "getCommentInfo",
        data: {
          activityId: this.$route.query.activityId,
          page: this.page,
          rows: this.row
        },
        // dataFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.total = res.data.total;
            for (let it in res.data.rows) {
              res.data.rows[it].inFlag = false;
            }
            _this.commentList = res.data.rows;
          }
        }
      });
    }
  }
};
</script>
<style lang='scss'>
.actiDetail {
  width: 1190px;
  margin: 0 auto;
  .delnav {
    padding: 20px 0;
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
        left: 537px;
        top: 20px;
        width: 42%;
        > span {
          font-size: 22px;
          font-weight: bold;
          color: #2a2a2a;
        }
        .like {
          position: absolute;
          right: -130px;
          font-size: 20px;
        }
        > p {
          margin-top: 30px;
          .free {
            margin-left: 70px;
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
          > span {
            margin-left: 30px;
          }
          > a {
            margin-left: 60px;
          }
        }
      }
    }
    .infobottom {
      border-top: 1px solid #eee;
      padding-bottom: 10px;
      > p {
        line-height: 30px;
      }
      .delshare {
        margin-top: 20px;
        .atten {
          background: #ebfcf1;
          color: #009f42;
          height: 38px;
          width: 110px;
          line-height: 10px;
          .icon-xihuan{
            font-size: 20px;
          }
        }
        .shareto {
          float: right;
          .icon-weixin {
            font-size: 20px;
          }
          .icon-12sina {
            font-size: 18px;
          }
        }
      }
      .resdeadline {
        margin-left: 20px;
        font-size: 14px;
        color: red;
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
            width: 90%;
            margin-left: 50px;
            > span {
              float: right;
            }
            .replyinfo {
              display: inline-block;
            }
          }
        }
      }
    }
  }
}
</style>


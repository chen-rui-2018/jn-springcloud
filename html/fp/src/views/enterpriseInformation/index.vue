<template>
  <div class="enterpriseInformation w">
    <div class="actiContent">
      <div class="actiNav">
        <span>首页/</span>
        <span class="mainColor">企业资讯</span>
      </div>
      <div class="changeIcon clearfix">
        <div class="fr">
          <i class="iconfont icon-menu1 pointer" @click="handleCrosswise('icon-menu1')" :class="{'active0':showListFlag == 'icon-menu1'}"></i>
          <i class="iconfont icon-menu pointer" @click="handleVertical('icon-menu')" :class="{'active0':showListFlag == 'icon-menu'}"></i>
        </div>
      </div>
      <div class="actiTab">
        <ul class="allActiUl clearfix" v-if="flag">
          <li v-for="(item,index) in recruitmentTable" :key='index'>
            <div class="postImgItem pointer" @click="handleRout(item.id)">
              <img :src="item.posterUrl" class="postImg" alt="企业图片">
            </div>
            <div class="actiInfo">
              <p class="actiNameItem">
                {{item.propagandaTitle}}
              </p>
              <p class="detail1">
                {{item.propagandaDetails}}
              </p>
            </div>
            <div class="actiNum clearfix">
              <div class="avatar">
                <img src="@/../static/img/图层 9.png" alt="">
                <i class="avaTime">{{item.createdTime}}</i>
              </div>
              <span class="mainColor">
                <i class="el-icon-view"></i>&nbsp;</span>
            </div>
          </li>
        </ul>
        <ul class="verticalUl" v-else>
          <li class="clearfix" v-for="(item,index) in recruitmentTable" :key='index'>
            <div class="verticalLeft fl pointer" @click="handleRout(item.id)">
              <img :src="item.posterUrl" alt="企业图片">
            </div>
            <div class="verticalMiddle fl">
              <h3 class="verticalTit">{{item.propagandaTitle}}</h3>
              <div class="xihuan mainColor">
                <i class="el-icon-view"></i>&nbsp;111
              </div>
              <p class="detail1">
                {{item.propagandaDetails}}
              </p>
              <div class="actiNum clearfix">
                <div class="avatar">
                  <img src="@/../static/img/图层 9.png" alt="">
                  <span>{{item.createdTime}}</span>
                </div>
                <!-- <i>{{item.applyNum}}/{{item.actiNumber}}</i> -->
              </div>
            </div>
            <div class="verticalRight fr">
              <el-button type="success" style="width:112px;border:1px solid #00a042;background:#ebfdf1;color:#00a042" @click="handleRout(item.id)">查看详情</el-button>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <div class="pagination-container">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage4" :page-sizes="[12, 24, 36, 48]" :page-size="row" layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      flag: true,
      showListFlag: "icon-menu1",
      currentPage4: 1,
      actiFilflag: "",
      colorFlag: "",
      page: 1, //页码
      row: 12, //每页显示多少条
      total: 0,
      showList: false,
      recruitmentTable: []
    };
  },
  mounted() {
    // this.initList();
    this.getBusinessPromotionList();
  },
  methods: {
    handleCrosswise(v) {
      //横向显示
      this.flag = true;
      this.showListFlag = "icon-menu1";
    },
    handleVertical() {
      //竖向显示
      this.flag = false;
      this.showListFlag = "icon-menu";
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.row = val;
      this.page = 1; //这里一定要把页码回归到第一页，再去请求数据
      this.getBusinessPromotionList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.getBusinessPromotionList();
    },
    handleRout(id) {
      this.$router.push({
        path: "enterpriseInfoDetails",
        query: { propagandaId: id }
      });
    },
    //(门户各首页企业宣传列表查询)  缺阅读量跟图标
    getBusinessPromotionList() {
      let _this = this;
      this.api.get({
        url: "getPromotionList",
        data: {
          page: this.page,
          rows: this.row,
          issuePlatform: 2,
          needPage: "1",
          propagandaType: "business_news"
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.recruitmentTable = res.data.rows;
            _this.total = res.data.total;
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
.enterpriseInformation {
  margin-bottom: 100px;
  padding-top: 65px;
  .actiNav {
    margin: 20px 0;
    font-size: 13px;
  }
  .changeIcon {
    padding-bottom: 20px;
    border-bottom: 1px solid #eee;
    .iconfont.active0 {
      color: #00a041;
    }
  }
  .actiTab {
    margin-top: 20px;
    margin-bottom: 30px;

    .allActiUl {
      // overflow: hidden;

      > li {
        float: left;
        width: 280px;
        // height: 290px;
        border: 1px solid #eee;
        margin-right: 20px;
        margin-bottom: 30px;

        .postImgItem {
          display: inline-block;
          width: 100%;
          height: 192px;

          .postImg {
            height: 100%;
            width: 100%;
          }
        }

        .actiNum {
          padding: 10px;
          border-top: 1px solid #eee;
          color: #999;
          font-size: 12px;

          .avatar {
            float: left;
            padding-left: 10px;
            > img {
              width: 77px;
              height: 21px;
            }
            .avaTime {
              display: inline-block;
              vertical-align: middle;
            }

            > ul {
              display: inline-block;

              li {
                float: left;
                width: 18px;
                height: 18px;
                border: 1px solid #ccc;
                border-radius: 50%;
                margin-left: -10px;

                img {
                  width: 100%;
                  height: 100%;
                  border-radius: 50%;
                }
              }
            }
          }

          > i {
            margin-left: 10px;
          }

          > span {
            float: right;

            .icon-xihuan {
              margin-right: 5px;
            }
          }
        }

        .actiInfo {
          padding: 10px;
          color: #999;
          font-size: 13px;

          > .actiNameItem {
            color: #222;
            font-size: 16px;
            margin-bottom: 10px;
          }

          .actiTimer {
            text-indent: -10px;
            margin: 10px 0 5px 18px;
          }
        }
      }

      li:nth-child(4n) {
        margin-right: 0;
      }
    }

    // 竖向排列样式
    .verticalUl {
      margin-bottom: 50px;

      > li {
        padding: 20px 0;
        border-bottom: 1px solid #ccc;

        .verticalLeft {
          margin-right: 30px;
          width: 304px;
          height: 185px;

          > img {
            width: 100%;
            height: 100%;
          }
        }

        .verticalMiddle {
          width: 55%;
          .verticalTit {
            color: #333;
          }

          > p {
            > span {
              color: #999;
            }
          }

          .xihuan {
            margin: 15px 0;
          }

          .location {
            margin: 18px 0;
          }

          .actiNum {
            margin-top: 20px;
            > i {
              color: #999;
              margin-left: 10px;
              font-size: 12px;
            }

            .avatar {
              float: left;

              > ul {
                display: inline-block;

                li {
                  float: left;
                  width: 22px;
                  height: 22px;
                  border: 1px solid #ccc;
                  border-radius: 50%;
                  margin-left: -10px;

                  img {
                    width: 100%;
                    height: 100%;
                    border-radius: 50%;
                  }
                }
              }
            }

            > .btn {
              float: right;
            }
          }
        }

        .verticalRight {
          margin-top: 70px;
        }
      }

      > li:first-child {
        padding-top: 0;
      }
    }
    .detail1 {
      height: 33px;
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 2;
      overflow: hidden;
      color: #999;
      font-size: 13px;
    }
  }
}
</style>

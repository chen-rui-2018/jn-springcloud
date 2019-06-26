<template>
  <div class="enterpriseProduct" v-loading="loading">
    <div class="ordinary_title">
      <div class="font16">{{this.$route.meta.title}}</div>
      <div @click="toPublishingPropaganda">发布宣传</div>
    </div>
    <div class="ordinary_main">
      <div class="search">
        <div class="search_type">
          <span :class="approvalStatus==='4'?'active':''" @click="approvalPending">未付款</span>
          <span :class="approvalStatus==='6'?'active':''" @click="disapprove ">已发布</span>
          <span :class="approvalStatus==='0'?'active':''" @click="noFeedback ">未审批</span>
          <span :class="approvalStatus==='1'?'active':''" @click="approvalIn ">审批中</span>
          <span :class="approvalStatus==='3'?'active':''" @click="denied ">审批不通过</span>
        </div>
        <el-input placeholder="请输入产品名称" v-model="searchContent" clearable>
          <el-button slot="append" icon="el-icon-search" @click="initList()"></el-button>
        </el-input>
      </div>
      <div class="ordinary_table">
        <el-table :data="recruitmentTable" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}"
          style="width: 100%">
          <el-table-column prop="propagandaTitle" label="宣传产品" align="center"> </el-table-column>
          <el-table-column prop="issuePlatform" label="发布平台" align="center">
            <template slot-scope="scope">
              <span v-if="scope.row.issuePlatform==='1'">App</span>
              <span v-if="scope.row.issuePlatform==='2'">门户</span>
              <span v-if="scope.row.issuePlatform==='3'">其它</span>
            </template>
          </el-table-column>
          <el-table-column prop="effectiveDate" label="生效日期" align="center"> </el-table-column>
          <el-table-column prop="invalidDate" label="失效日期" align="center"> </el-table-column>
          <el-table-column prop="posterUrl" label="宣传海报" align="center">
            <template slot-scope="scope">
              <span v-if="scope.row.posterUrl" class="posterUrlBtn" @click="lookPoster(scope.row)">点击查看</span>
              <span v-if="!scope.row.posterUrl">暂无海报图片</span>
            </template>
          </el-table-column>
          <el-table-column prop="propagandaFee" label="宣传费用(元)" align="center"> </el-table-column>
          <el-table-column label="操作" align="center" min-width="120">
            <template slot-scope="scope">
              <!-- <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)" class="greenColor"><span>编辑</span>
              </el-button>  -->
              <el-button size="mini" type="text" class="greenColor" @click="toPropagandaDetails(scope.row)"><span>详情</span>
              </el-button>
               <el-button size="mini" v-show="scope.row.approvalStatus==='4'"  type="text" @click="goPayment( scope.row)" class="greenColor"><span>去付款</span>
              </el-button>
              <el-button v-show="scope.row.approvalStatus==='0'" size="mini" type="text" class="greenColor" @click="submitAudit(scope.row)"><span>提交审核</span>
              </el-button>
              <el-button size="mini" v-show="scope.row.approvalStatus==='4'||scope.row.approvalStatus==='0'" type="text" @click="cancelApprove( scope.row)" class="redColor"><span>撤消申请</span>
              </el-button>

            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
    <el-dialog title="海报图片" :visible.sync="dialogVisible" :modal-append-to-body="false" width="39%">
      <img :src="posterUrl" alt="海报图片" style="width:100%;">
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">返 回</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      loading: true,
      posterUrl: "",
      dialogVisible: false,
      approvalStatus: "0",
      page: 1,
      rows: 10,
      total: "",
      searchContent: "",
      status: "1",
      recruitmentTable: []
    };
  },
  mounted() {
      if(this.$route.query.status){
            this.approvalStatus=this.$route.query.status
    }
    this.initList();
  },
  methods: {
    // 提交审核
    submitAudit(row) {
      this.$confirm(`此操作将提交审核这条数据, 是否继续?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.loading = true;
      this.api.post({
        url: "submitAudit",
        data: { propagandaId: row.id },
        dataFlag: true,
        callback: res => {
          this.loading = false;
          if (res.code == "0000") {
            this.$message({
              message: "提交成功,请等待后台审核",
              type: "success"
            });
            this.initList();
          } else {
            this.$message.error(res.result);
          }
        }
      });
        })
        .catch(() => {});

    },
    //   查看海报图片
    lookPoster(row) {
      if (!row.posterUrl) {
        this.$message.error("此宣传没有宣传海报");
      } else {
        this.posterUrl = row.posterUrl;
        this.dialogVisible = true;
      }
    },
    // 撤消申请
    cancelApprove(row) {
      let _this = this;
      this.$confirm(`此操作将撤消这条申请, 是否继续?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.api.post({
            url: "cancelApprove",
            data: { propagandaId: row.id },
            dataFlag: true,
            callback: function(res) {
              console.log(res);
              if (res.code === "0000") {
                _this.$message({
                  message: "操作成功",
                  type: "success"
                });
                _this.initList();
              } else {
                _this.$message.error(res.result);
              }
            }
          });
        })
        .catch(() => {});
    },
    toPropagandaDetails(row) {
      this.$router.push({
        name: "propagandaDetails",
        query: { propagandaId: row.id,status:row.approvalStatus }
      });
    },
    toPublishingPropaganda() {
      this.$router.push({ name: "publishingPropaganda" });
    },
    goPayment(){
 console.log(123)
    },
    approvalPending() {
      this.approvalStatus = "4";
      this.initList();
    },
    disapprove() {
      this.approvalStatus = "6";
      this.initList();
    },
    noFeedback() {
      this.approvalStatus = "0";
      this.initList();
    },
    denied() {
      this.approvalStatus = "3";
      this.initList();
    },
    approvalIn(){
this.approvalStatus = "1";
      this.initList();
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.rows = val;
      // this.page = 1;
      this.initList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.initList();
    },
    // 初始化页面

    initList() {
      let _this = this;
      this.api.get({
        url: "getBusinessPromotionList",
        data: {
          page: this.page,
          rows: this.rows,
          searchContent: this.searchContent,
          approvalStatus: this.approvalStatus,
          needPage: "1"
        },
        // dataFlag:true,
        callback: function(res) {
          _this.loading = false;
          if (res.code == "0000") {
            console.log(res);
            _this.recruitmentTable = res.data.rows;
            // for (let it in _this.serverAgent) {
            //   _this.serverAgent[it].attitudeScore =
            //     _this.serverAgent[it].attitudeScore * 1;
            // }
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
.enterpriseProduct {
  .el-table {
    font-size: 12px;
  }
  .posterUrlBtn {
    color: #00a041;
    width: 46px;
    height: 11px;
    font-size: 11px;
    font-family: MicrosoftYaHei;
    font-weight: 400;
    color: rgba(0, 160, 65, 1);
    line-height: 20px;
    cursor: pointer;
  }
  width: 100%;
  .ordinary_title {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 17px;
    // font-size: 13px;
    border-radius: 5px;
    div:nth-child(2) {
      width: 88px;
      height: 26px;
      background: rgba(236, 252, 242, 1);
      border: 1px solid rgba(65, 215, 135, 1);
      border-radius: 4px;
      text-align: center;
      line-height: 26px;
      font-size: 12px;
      color: #00a041;
      cursor: pointer;
    }
  }
  .ordinary_main {
    margin-top: 14px;
    background-color: #fff;
    padding: 17px;
    // 输入框
    .search {
      position: relative;
      // display: flex;
      // justify-content: space-between;
      //     .el-checkbox-button.is-checked:first-child .el-checkbox-button__inner{
      //         border: none;
      // background: #fff;
      // color: #00A041;
      // border-radius: unset;
      // border-bottom: 3px solid rgb(0, 160, 65);
      //     }
      .search_type {
        span {
          display: inline-block;
          width: 77px;
          text-align: center;
          padding: 0px 0px 13px 0px;
          cursor: pointer;
        }
      }
      .active {
        border: none;
        background: #fff;
        color: #00a041;
        border-radius: unset;
        border-bottom: 3px solid rgb(0, 160, 65);
      }
      .el-input-group {
        width: 24%;
        position: absolute;
        // width: 20%;
        top: -5px;
        right: 0px;
      }
      .el-input__inner {
        height: 27px;
        line-height: 27px;
        border: 1px solid #eee;
      }
      .el-input-group__append {
        background-color: #00a041;
        color: #fff;
        border: none;
        font-size: 13px;
        // border-bottom: 1px solid #fff;
      }
    }
    // 表格
    .ordinary_table {
      // margin-top: 11px;
      padding-top: 30px;
      border-top: 1px solid #eee;
      .redColor {
        color: #ff0000;
      }
      .greenColor {
        color: #00a041;
      }
    }
  }
}
</style>

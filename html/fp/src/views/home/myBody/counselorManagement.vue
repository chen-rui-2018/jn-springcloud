<template>
  <div class="counselorManagement">
    <div class="ordinary_title font16">
      <div>专员管理</div>
      <div @click="toInviteAdviser" v-show="isShow">邀请专员</div>
    </div>
    <div class="ordinary_main">
      <div class="search">
        <div class="search_type">
          <span :class="approvalStatus==='pending'?'active':''" @click="approvalPending">待审批</span>
          <span :class="approvalStatus==='approvalNotPassed'?'active':''" @click="disapprove ">审批不通过</span>
          <span :class="approvalStatus==='noFeedBack'?'active':''" @click="noFeedback ">未反馈</span>
          <span :class="approvalStatus==='rejected'?'active':''" @click="denied ">已拒绝</span>
        </div>
        <el-input placeholder="请输入专员姓名" v-model="advisorName" clearable>
          <el-button slot="append" icon="el-icon-search" @click="initList()"></el-button>
        </el-input>
      </div>
      <div class="ordinary_table">
        <el-table :data="recruitmentTable" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}"
          style="width: 100%">
          <el-table-column prop="advisorName" label="姓名" align="center"> </el-table-column>
          <el-table-column prop="advisorAccount" label="注册手机/邮箱" width="120" align="center"> </el-table-column>
          <el-table-column prop="position" label="职务" align="center"> </el-table-column>
          <el-table-column prop="workingYears" label="从业年限" align="center"> </el-table-column>
          <el-table-column prop="graduatedSchool" label="毕业学校" align="center"> </el-table-column>
          <el-table-column prop="education" label="学历" align="center"> </el-table-column>
          <el-table-column prop="createdTime" label="入职日期" width="140" align="center"> </el-table-column>
          <el-table-column prop="graduatedSchool" label="毕业学校" align="center"> </el-table-column>
          <el-table-column prop="approvalStatus" label="邀请状态" align="center">
            <template slot-scope="scope">
              <span v-if="scope.row.approvalStatus==='pending'">待审批</span>
              <span v-if="scope.row.approvalStatus==='approvalNotPassed'">审批不通过</span>
              <span v-if="scope.row.approvalStatus==='noFeedBack'">未反馈</span>
              <span v-if="scope.row.approvalStatus==='rejected'">已拒绝</span>
              <!-- <span v-if="scope.row.approvalStatus==='-1'">未接受</span>
              <span v-if="scope.row.approvalStatus==='-1'">审批通过</span> -->
            </template>
          </el-table-column>
          <el-table-column label="操作" align="center" width="120">
            <template slot-scope="scope">
              <el-button v-if="scope.row.approvalStatus==='pending'" size="mini" type="text" @click="handleConsent( scope.row)"
                class="mainColor"><span>审批</span>
              </el-button>
              <el-button v-if="scope.row.approvalStatus==='rejected'" size="mini" type="text" @click="handleAgainInvite( scope.row)"
                class="redColor"><span>再次邀请</span>
              </el-button>
              <el-button size="mini" type="text" @click="handleDetails( scope.row)"
                class="mainColor"><span>详情</span>
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="pagination-container">
        <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="page"
          :page-sizes="[10, 20, 30, 50]" :page-size="rows" layout="total, sizes, prev, pager, next, jumper" :total="total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      isShow:false,
      page: 1,
      rows: 10,
      total: 0,
      advisorName: "",
      approvalStatus: "pending",
      recruitmentTable: []
    };
  },
  mounted() {
    if(this.$route.query.approvalStatus){
      this.approvalStatus=this.$route.query.approvalStatus
    }
     let initArr = JSON.parse(sessionStorage.menuItems);
    initArr.forEach(v => {
      if (v.label === "我的机构") {
        v.resourcesList.forEach(i => {
          if (i.resourcesName === "邀请专员") {
            this.isShow = true;
          }
        });
      }
    });
    this.initList();
  },
  methods: {
    //   跳转到详情页
    handleDetails(row) {
      this.$router.push({
        name: "advisoryDetails",
        query: { account: row.advisorAccount,approvalStatus: this.approvalStatus}
      });
    },
    // 再次邀请
    handleAgainInvite(row) {
      let _this = this;
      this.$confirm(`此操作将再次发送邀请, 是否继续?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.api.post({
            url: "inviteAgain",
            data: { advisorAccount: row.advisorAccount },
            dataFlag: true,
            callback: function(res) {
              console.log(res);
              if (res.code == "0000") {
                _this.$message({
                  message: "操作成功",
                  type: "success"
                });
                _this.initList();
              } else {
                this.$message.error("操作失败");
              }
            }
          });
        })
        .catch(() => {});
    },
    // 拒绝
    handleRefuse(row) {
      let _this = this;
      this.$confirm(`此操作将拒绝邀请, 是否继续?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.api.post({
            url: "reviewStaff",
            data: { checkStatus: "-1", staffId: row.staffId },
            // dataFlag:true,
            callback: function(res) {
              if (res.code == "0000") {
                _this.$message({
                  message: "操作成功",
                  type: "success"
                });
                _this.initList();
              }
            }
          });
        })
        .catch(() => {});
    },
    // 点击审批 跳转到审批专员页面
    handleConsent(row) {
      this.$router.push({
        name: "approveAdvisory",
        query: { advisorAccount: row.advisorAccount }
      });
    },
    toInviteAdviser() {
      this.$router.push({ name: "inviteAdviser" });
    },
    approvalPending() {
      this.approvalStatus = "pending";
      this.initList();
    },
    disapprove() {
      this.approvalStatus = "approvalNotPassed";
      this.initList();
    },
    noFeedback() {
      this.approvalStatus = "noFeedBack";
      this.initList();
    },
    denied() {
      this.approvalStatus = "rejected";
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
    initList() {
      let _this = this;
      this.api.get({
        url: "getAdvisorManagementInfo",
        data: {
          page: this.page,
          rows: this.rows,
          approvalStatus: this.approvalStatus,
          advisorName: this.advisorName,
          needPage: "1"
        },
        // dataFlag:true,
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
.counselorManagement {
  width: 100%;
  .el-table {
    font-size: 12px;
  }
  .el-table__empty-block{
    min-height: 40px;
  }
  .el-table__empty-text{
    line-height: 40px;
  }
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
        width: 26%;
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
    }
  }
}
</style>

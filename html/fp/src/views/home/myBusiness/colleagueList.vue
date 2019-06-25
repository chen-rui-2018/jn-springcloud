<template>
  <div class="colleagueProduct">
    <div class="ordinary_title font16">
      <div>企业同事</div>
    </div>

    <div class="ordinary_main">
      <div class="search">
        <div></div>
        <el-input placeholder="请输入真实姓名或手机号" v-model="searchFiled" clearable  @keyup.enter.native="initList">
          <el-button slot="append" icon="el-icon-search" @click="initList"></el-button>
        </el-input>
      </div>
      <div class="ordinary_table">
        <el-table :data="recruitmentTable" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}"
          style="width: 100%">
          <el-table-column prop="nickName" label="昵称" align="center"> </el-table-column>
          <el-table-column prop="name" label="真实姓名" align="center"> </el-table-column>
          <el-table-column prop="phone" label="联系手机" align="center"> </el-table-column>
          <el-table-column prop="birthday" label="出生年月" align="center"> </el-table-column>
          <el-table-column prop="roleName" label="企业身份" align="center"> </el-table-column>
          <el-table-column prop="checkTime" label="入驻日期" align="center" min-width="130"> </el-table-column>
          <el-table-column label="操作" align="center" v-if="isShow=='1'">
            <template slot-scope="scope">
              <el-button v-if=" scope.row.roleName==='企业联系人'" size="mini" type="text" @click="handleCancel(scope.row)"
                class="greenColor"><span>取消联系人</span>
              </el-button>
              <el-button v-if=" scope.row.roleName==='企业员工'" size="mini" type="text" @click="handleSetContact( scope.row)"
                class="greenColor"><span>设为联系人</span>
              </el-button>
              <el-button v-if=" scope.row.roleName!=='企业管理员'" size="mini" type="text" @click="handleDelete(scope.row)"
                class="redColor"><span>删除</span>
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
import { getUserInfo } from '@/util/auth'
export default {
  data() {
    return {
      isShow: "",
      account: "",
      page: 1,
      rows: 10,
      searchFiled: "",
      total: 0,
      recruitmentTable: []
    };
  },
  mounted() {
    this.initList();
  },
  methods: {
    //   删除数据
    handleDelete(row) {
      console.log(row);
      let _this = this;
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, "删除提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.api.post({
            url: "delColleague",
            data: { accounts: row.account },
            dataFlag: true,
            callback: function(res) {
              if (res.code === "0000") {
                console.log(res);
                _this.$message({
                  message: "删除成功",
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
    //   取消联系人
    handleCancel(row) {
      let _this = this;
      this.$confirm(`此操作将取消这个联系人, 是否继续?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.api.post({
            url: "cancelContact",
            data: { account: row.account },
            dataFlag: true,
            callback: function(res) {
              if (res.code === "0000") {
                _this.$message({
                  message: "取消成功",
                  type: "success"
                });
                _this.initList();
              } else {
                _this.$message.error("取消失败" + res.result);
              }
            }
          });
        })
        .catch(() => {});
    },
    // 设为联系人
    handleSetContact(row) {
      let _this = this;
      this.$confirm(`此操作将设为联系人, 是否继续?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.api.post({
            url: "setContact",
            data: { account: row.account },
            dataFlag: true,
            callback: function(res) {
              if (res.code === "0000") {
                _this.$message({
                  message: "设置成功",
                  type: "success"
                });
                _this.initList();
              } else {
                _this.$message.error("设置失败   " + res.result);
              }
            }
          });
        })
        .catch(() => {});
    },
    toInviteEmployees() {
      this.$router.push({ name: "InviteEmployees" });
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
    // 初始话页面
    initList() {
      this.account = JSON.parse(getUserInfo()).account;
      let _this = this;
      this.api.get({
        url: "getColleagueList",
        data: {
          page: this.page,
          rows: this.rows,
          searchFiled: this.searchFiled,
          needPage: 1
        },
        // dataFlag:true,
        callback: function(res) {
          if (res.code === "0000") {
            console.log(res);
            _this.recruitmentTable = res.data.data.rows;
            _this.isShow = res.data.isShow;
            _this.total = res.data.data.total;
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
.colleagueProduct {
  width: 100%;
  .ordinary_title {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 17px;
    // font-size: 13px;
    border-radius: 5px;
  }
  .ordinary_main {
    margin-top: 14px;
    background-color: #fff;
    padding: 13px 17px;
    // 输入框
    .search {
      // margin-top:10px;
      display: flex;
      justify-content: space-between;
      .search_type {
        span {
          display: inline-block;
          width: 77px;
          text-align: center;
          margin-bottom: 10px;
          cursor: pointer;
        }
      }
      .el-input-group {
        width: 29%;
        margin-bottom: 13px;
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
      // margin-top: 13px;
      padding-top: 34px;
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

<template>
  <div class="actiManagent">
    <div class="ordinary_title">
      <div class="sigeIn">
        <span :class="{'active':borderFlag=='1'}" @click="handleFil('1')">已报名</span>
        <span :class="{'active':borderFlag=='2'}" @click="handleFil('2')">报名待审批</span>
      </div>
      <div class="search">
        <el-input placeholder="请输入活动名称" v-model="actiName">
          <el-button slot="append" icon="el-icon-search" @click='handleSea'></el-button>
        </el-input>
      </div>
    </div>
    <div class="ordinary_main">
      <div class="ordinary_table">
        <el-table :data="tableData" stripe :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%" border fit>
          <el-table-column prop="actiName" align="center" label="活动名称">
          </el-table-column>
          <el-table-column prop="typeName" align="center" label="活动类型">
          </el-table-column>
          <el-table-column align="center" label="活动费用">
            <template slot-scope="scope">
              <el-button v-if="scope.row.actiCost===0" type="text" class="operation">免费
              </el-button>
            </template>
          </el-table-column>
          <el-table-column prop="actiOrganizer" align="center" label="主办方">
          </el-table-column>
          <el-table-column prop="parkName" align="center" label="活动园区">
          </el-table-column>
          <el-table-column prop="actiAddress" align="center" label="活动地点">
          </el-table-column>
          <el-table-column prop="actiStartTime" align="center" label="活动时间">
          </el-table-column>
          <el-table-column fit label="活动状态" align="center" width="auto">
            <template slot-scope="scope">
              <el-button v-if="scope.row.actiStatus==='2'" type="text" class="operation">报名中
              </el-button>
              <el-button v-if="scope.row.actiStatus==='3'" type="text" class="operation">活动结束
              </el-button>
              <el-button v-if="scope.row.actiStatus==='4'" type="text" class="operation">活动取消
              </el-button>
            </template>
          </el-table-column>
          <!-- <el-table-column fit label="操作" align="center" width="auto" min-width="200"> -->
          <el-table-column fit label="操作" align="center" width="auto">
            <template slot-scope="scope">
              <el-button v-if="scope.row.actiStatus==='2'" type="text" style="color:red" class="operation" @click="cancelApply(scope.$index,scope.row)">取消报名
              </el-button>
            </template>
          </el-table-column>
          <el-table-column prop="address" align="center" label="详情">
            <template slot-scope="scope">
              <i class="el-icon-arrow-right pointer" @click="jump(scope.row.id)"></i>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <!-- 分页 -->
      <div class="ordinary_paging">
        <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-sizes="[8, 16, 24, 32]" :page-size="100" layout="total,prev, pager, next,sizes" :total="total">
        </el-pagination>
      </div>
    </div>
    <!-- <el-container>
            <el-header>
                <span>已报名</span>
                <span>报名待审批</span>
                <div style="float:right;z-index:12;">
                    <el-input placeholder="搜索活动" v-model="input" style="height:32px;line-height:32px;">
                        <i slot="prefix" class="el-input__icon el-icon-search"></i>
                    </el-input>
                </div>
            </el-header>
            <el-main>
                <el-table :data="tableData" style="width: 100%" border fit>
                    <el-table-column prop="actiName" label="活动名称">
                    </el-table-column>
                    <el-table-column prop="actiType" label="活动类型">
                    </el-table-column>
                    <el-table-column prop="actiCost" label="活动费用">
                    </el-table-column>
                    <el-table-column prop="address" label="主办方">
                    </el-table-column>
                    <el-table-column prop="address" label="活动园区">
                    </el-table-column>
                    <el-table-column prop="actiAddress" label="活动地点">
                    </el-table-column>
                    <el-table-column prop="actiTime" label="活动时间">
                    </el-table-column>
                    <el-table-column prop="actiStatus" label="活动状态">
                    </el-table-column>
                    <el-table-column fit label="操作" align="center" width="auto" min-width="200">
                    </el-table-column>
                    <el-table-column prop="address" label="详情">
                        <i class="el-icon-arrow-right"></i>
                    </el-table-column>
                </el-table>
            </el-main>
        </el-container> -->
  </div>
</template>
<script>
export default {
  data() {
    return {
      input: "",
      tableData: [],
      account: "",
      applyStatus: "1",
      actiName: "",
      page: 1,
      row: 8,
      total: 0,
      borderFlag: "1"
    };
  },
  mounted() {
    this.getuserAccount();
  },
  methods: {
    cancelApply(index,row) {
      //取消报名
      this.$confirm("是否取消报名?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let _this = this;
          this.api.post({
            url: "cancelApply",
            data: {
              activityId: row.id
            },
            dataFlag:true,
            callback: function(res) {
              if (res.code == "0000") {
                this.$message({
                  type: "success",
                  message: "删除成功!"
                });
                _this.tableData.splice(index, 1)
              }
            }
          });
        })
        .catch(() => {
          this.$message({
            // type: "info",
            // message: "已取消删除"
          });
        });
    },
    handleSea() {
      //搜索
      this.page = 1;
      this.findActivityRegistration();
    },
    handleFil(i) {
      this.applyStatus = i;
      this.borderFlag = i;
      this.findActivityRegistration();
    },
    jump(id) {
      this.$router.push({ path: "actiDetail", query: { activityId: id } });
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.row = val;
      this.page = 1;
      this.findActivityRegistration();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.findActivityRegistration();
    },
    // 获取当前用户账号
    getuserAccount() {
      let _this = this;
      this.api.get({
        url: "getUserExtension",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.account = res.data.account;
            _this.$nextTick(() => {
              _this.findActivityRegistration();
            });
          }
        }
      });
    },
    // 获取活动列表
    findActivityRegistration() {
      let _this = this;
      this.api.get({
        url: "findActivityRegistration",
        data: {
          applyStatus: _this.applyStatus,
          account: _this.account,
          page: _this.page,
          rows: _this.row,
          actiName: _this.actiName
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.tableData = res.data.rows;
            _this.total = res.data.total;
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.actiManagent {
  width: 100%;
  .operation {
    color: #666;
  }
  .ordinary_title {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 17px;
    font-size: 13px;
    border-radius: 5px;
    .sigeIn {
      span {
        display: inline-block;
        padding: 17px 10px;
        margin-right: 20px;
        cursor: pointer;
      }
      span.active {
        border-bottom: 2px solid #00a041;
      }
    }
    .search {
      display: flex;
      justify-content: space-between;
      .el-input-group {
        width: 100%;
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
  }
  .ordinary_main {
    margin-top: 14px;
    background-color: #fff;
    padding: 17px;

    // 表格
    .ordinary_table {
      // margin-top: 11px;
      // padding-top: 14px;
      // border-top: 1px solid #eee;
      text-align: center;
      .redColor {
        color: #ff0000;
      }
      .greenColor {
        color: #00a041;
      }
      .ordinarybth {
        display: flex;
        span {
          display: block;
          width: 33%;

          &:nth-child(1) {
            color: #00a041;
          }
          &:nth-child(2) {
            color: #ff0000;
          }
          cursor: pointer;
        }
      }
    }
    //分页
    .ordinary_paging {
      text-align: center;
      margin: 51px 0 76px 0;
      .el-pagination.is-background .btn-prev,
      .el-pagination.is-background .btn-next {
        border: 1px solid #eee;
        background-color: #fff;
      }
      .el-pagination.is-background .el-pager li {
        background-color: #fff;
        border: 1px solid #eee;
      }
      .el-pagination.is-background .el-pager li:not(.disabled):hover {
        color: #fff;
      }
      .el-pagination.is-background .el-pager li:not(.disabled).active {
        background-color: #00a041;
        color: #fff;
      }
      .el-pagination__sizes .el-input .el-input__inner:hover {
        border-color: #00a041;
      }
      .el-select .el-input__inner:focus {
        border-color: #00a041;
      }
    }
  }
}
</style>


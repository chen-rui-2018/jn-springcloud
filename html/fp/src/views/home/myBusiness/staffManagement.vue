<template>
  <div class="staffProduct" v-loading="loading">
    <div class="ordinary_title font16">
      <div>员工管理</div>
      <div @click="toInviteEmployees" v-show="isShow">邀请员工</div>
    </div>
    <div class="ordinary_main">
      <div class="search">
    <div class="search_type">
      <span :class="status===''?'active':''" @click="allList">全部</span>
      <span :class="status==='0'?'active':''" @click="approvalPending">待审批</span>
      <span :class="status==='-1'?'active':''" @click="disapprove ">审批不通过</span>
      <span :class="status==='5'?'active':''" @click="noFeedback ">已邀请</span>
      <span :class="status==='7'?'active':''" @click="denied ">已拒绝</span>
    </div>
        <el-input placeholder="请输入真实姓名或手机号" v-model="searchFiled" clearable>
          <el-button slot="append" icon="el-icon-search" @click="initList()"></el-button>
        </el-input>
      </div>
      <div class="ordinary_table">
        <el-table :data="recruitmentTable" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%">
          <el-table-column prop="nickName" label="名号" align="center"> </el-table-column>
          <el-table-column prop="name" label="真实姓名" align="center"> </el-table-column>
          <el-table-column prop="phone" label="联系手机" align="center"> </el-table-column>
          <el-table-column prop="birthday" label="出生年月" align="center"> </el-table-column>
          <el-table-column prop="checkTime" label="申请日期" align="center" min-width="120"> </el-table-column>
          <el-table-column prop="statusShow" label="邀请状态" align="center">
               <!-- <template  slot-scope="scope"> -->
                 <!-- <span v-if="scope.row.statusShow==='0'">待审批</span>
                 <span v-if="scope.row.statusShow==='1'">审批不通过</span>
                 <span v-if="scope.row.statusShow==='2'">未反馈</span>
                 <span v-if="scope.row.statusShow==='3'">已拒绝</span> -->
            <!-- </template> -->
            </el-table-column>
          <el-table-column label="操作" align="center" v-if="status===''||status==='0'">
            <template slot-scope="scope" >
              <el-button
              v-if="scope.row.statusShow==='待审批'"
                size="mini"
                 type="text"
                @click="handleConsent( scope.row)" class="greenColor"><span>同意</span>
              </el-button>
              <el-button
               v-if="scope.row.statusShow==='待审批'"
                size="mini"
                type="text"
                @click="handleRefuse( scope.row)" class="redColor"><span>拒绝</span>
              </el-button>
              <!-- <el-button
               v-if="scope.row.statusShow==='已拒绝'"
                size="mini"
                type="text"
                @click="handleAgainInvite( scope.row)" class="greenColor"><span>再次邀请</span>
              </el-button> -->
            </template>
          </el-table-column>
        </el-table>
      </div>
       <div class="pagination-container">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="page" :page-sizes="[10, 20, 30, 50]" :page-size="rows" layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      loading:false,
      isShow:false,
      page:1,
      rows:10,
      total:0,
        searchFiled:'',
        status:'',
      recruitmentTable:[],
    }
  },
  mounted(){
     let initArr = JSON.parse(sessionStorage.menuItems);
    initArr.forEach(v => {
      if (v.label === "我的企业") {
        v.resourcesList.forEach(i => {
          if (i.resourcesName === "邀请员工") {
            this.isShow = true;
          }
        });
      }
    });
    this.initList()
  },
  methods: {
    // 再次邀请
    // handleAgainInvite(row){
    //     let _this = this;
    //     this.$confirm(`此操作将再次发送邀请, 是否继续?`, '提示', {
    //     confirmButtonText: '确定',
    //     cancelButtonText: '取消',
    //     type: 'warning'
    //   })
    //     .then(() => {
    //   this.api.post({
    //     url: "inviteStaffAgain",
    //     data: {staffId:row.staffId},
    //     dataFlag:true,
    //     callback: function(res) {
    //       console.log(res)
    //       if (res.code == "0000") {
    //          _this.$message({
    //             message: '操作成功',
    //             type: 'success'
    //           })
    //         _this.initList()
    //       }else{
    //          this.$message.error('操作失败')
    //       }
    //     }
    //   });
    // })
    //     .catch(() => {

    //     })
    // },
    // 拒绝
    handleRefuse(row){
     let _this = this;
     this.$confirm(`此操作将拒绝邀请, 是否继续?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
      this.api.post({
        url: "reviewStaff",
        data: {checkStatus:'-1',staffId:row.staffId},
        // dataFlag:true,
        callback: function(res) {
          if (res.code == "0000") {
_this.$message({
                message: '操作成功',
                type: 'success'
              })
            _this.initList()
          }
        }
      });
       })
        .catch(() => {

        })
    },
    // 点击同意邀请
    handleConsent(row){
      let _this = this;
         this.$confirm(`此操作将同意邀请, 是否继续?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
      this.api.post({
        url: "reviewStaff",
        data: {checkStatus:'1',staffId:row.staffId},
        // dataFlag:true,
        callback: function(res) {
          if (res.code == "0000") {
             _this.$message({
                message: '操作成功',
                type: 'success'
              })
            _this.initList()
          }else{
             this.$message.error(res.result)
          }
        }
      });
      })
        .catch(() => {

        })
    },
    toInviteEmployees(){
      this.$router.push({name:'InviteEmployees'})
    },
    approvalPending(){
       this.status='0'
       this.initList()
    },
     allList(){
       this.status=''
       this.initList()
    },
    disapprove(){
       this.status='-1'
       this.initList()
    },
    noFeedback(){
       this.status='5'
       this.initList()
    },
    denied(){
       this.status='7'
       this.initList()
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
    initList(){
      let _this = this;
      this.loading=true
      this.api.get({
        url: "getStaffList",
        data: {page:this.page,rows:this.rows,status:this.status,searchFiled:this.searchFiled,needPage:'1'},
        // dataFlag:true,
        callback: function(res) {
          _this.loading=false
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
}
</script>

<style lang="scss">
  .staffProduct{
    width: 100%;
    .ordinary_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      // font-size: 13px;
      border-radius: 5px;
      div:nth-child(2){
                width:88px;
height:26px;
background:rgba(236,252,242,1);
border:1px solid rgba(65,215,135,1);
border-radius:4px;
text-align: center;
line-height: 26px;
        font-size: 12px;
        color:#00A041;
        cursor: pointer;
      }
    }
    .ordinary_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      // 输入框
      .search{
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
    .search_type{
        span{
            display: inline-block;
            width: 77px;
            text-align: center;
            padding:0px 0px 13px 0px;
            cursor: pointer;
        }
    }
        .active{
               border: none;
    background: #fff;
    color: #00A041;
    border-radius: unset;
    border-bottom: 3px solid rgb(0, 160, 65);
        }
        .el-input-group{
          // width:24%;
              position: absolute;
    width: 29%;
    top: -5px;
    right: 0px;
        }
        .el-input__inner{
          height: 27px;
          line-height: 27px;
          border: 1px solid #eee;
        }
        .el-input-group__append{
          background-color:#00a041;
          color:#fff;
          border:none;
          font-size: 13px;
          // border-bottom: 1px solid #fff;
        }
      }
      // 表格
      .ordinary_table{
        // margin-top: 11px;
        padding-top: 30px;
        border-top: 1px solid #eee;
        .redColor{
          color:#ff0000
        }
        .greenColor{
          color:#00a041
        }
      }
    }
  }
</style>

<template>
  <div class="agencyColleaguesList">
    <div class="ordinary_title font16">
      <div>机构同事</div>
      <!-- <div @click="toInviteEmployees">邀请员工</div> -->
    </div>

    <div class="ordinary_main">
        <div class="search">
        <div></div>
        <el-input placeholder="请输入姓名" v-model="searchFiled" clearable @keyup.enter.native="initList">
          <el-button slot="append" icon="el-icon-search" @click="initList"></el-button>
        </el-input>
      </div>
      <div class="ordinary_table">
        <el-table :data="recruitmentTable" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%">
          <el-table-column prop="account" label="姓名" align="center"> </el-table-column>
          <el-table-column prop="phone" label="联系手机" align="center"> </el-table-column>
          <el-table-column prop="email" label="联系邮箱" align="center"  width="150"> </el-table-column>
          <el-table-column prop="graduatedSchool" label="毕业学校" align="center"> </el-table-column>
          <el-table-column prop="education" label="学历" align="center"> </el-table-column>
          <el-table-column prop="position" label="担任职务" align="center" > </el-table-column>
          <el-table-column prop="orgIdentity" label="机构身份" align="center"> </el-table-column>
          <el-table-column prop="entryDate" label="入驻日期" align="center" width="100"> </el-table-column>
          <el-table-column label="操作" align="center" width='120'  >
            <template slot-scope="scope">
              <el-button
              v-if=" scope.row.orgIdentity==='机构联系人'"
                size="mini"
                 type="text"
                @click="handleCancel(scope.row)" class="greenColor"><span>取消联系人</span>
              </el-button>
              <el-button
               v-if=" scope.row.orgIdentity==='机构专员'"
                size="mini"
                 type="text"
                @click="handleSetContact( scope.row)" class="greenColor"><span>设为联系人</span>
              </el-button>
              <el-button
               v-if=" scope.row.orgIdentity==='机构专员'|| scope.row.orgIdentity==='机构联系人'"
                size="mini"
                type="text"
                @click="handleDetails(scope.row)" class="greenColor"><span>详情</span>
              </el-button>
              <el-button
               v-if=" scope.row.orgIdentity==='机构专员'|| scope.row.orgIdentity==='机构联系人'"
                size="mini"
                type="text"
                @click="handleDelete(scope.row)" class="redColor"><span>删除</span>
              </el-button>

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
      // isShow:'',
     account:'',
      page:1,
      rows:10,
      searchFiled:'',
            total:0,
      recruitmentTable:[],
    }
  },
  mounted(){
    this.initList()
  },
  methods: {
    handleDetails(row){
      console.log(row)
      // return
       this.$router.push({name:'advisoryDetails',query:{
         account:row.account
       }})
    },
    //   删除数据
    handleDelete(row){
        console.log(row)
       let _this = this;
        this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
      this.api.post({
        url: "deleteContactOrAdvisor",
        data: [row.account],
        callback: function(res) {
          if (res.code === "0000") {
            console.log(res)
              _this.$message({
                message: '删除成功',
                type: 'success'
              })
        _this.initList()
          } else {
            _this.$message.error( res.result);
          }
        }
      });
      })
        .catch(() => {

        })
    },
 //   取消联系人
    handleCancel(row){
       let _this = this;
        this.$confirm(`此操作将取消这个联系人, 是否继续?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
      this.api.post({
        url: "cancelAsContact",
        data:{account:row.account} ,
         dataFlag:true,
        callback: function(res) {
          if (res.code === "0000") {
              _this.$message({
                message: '操作成功',
                type: 'success'
              })
        _this.initList()
          } else {
            _this.$message.error( res.result);
          }
        }
      });
      })
        .catch(() => {

        })
    },
    // 设为联系人
handleSetContact(row){
       let _this = this;
        this.$confirm(`此操作将设为联系人, 是否继续?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
      this.api.post({
        url: "setAsContact",
        data: {account:row.account},
         dataFlag:true,
        callback: function(res) {
          if (res.code === "0000") {
              _this.$message({
                message: '设置成功',
                type: 'success'
              })
        _this.initList()
          } else {
            _this.$message.error( res.result);
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
    initList(){
      let _this = this;
      this.api.get({
        url: "getOrgColleagueList",
        data: {page:this.page,rows:this.rows,searchFiled:this.searchFiled,needPage:1},
        // dataFlag:true,
        callback: function(res) {
          if (res.code === "0000") {
            console.log(res)
            _this.recruitmentTable = res.data.rows;
            // _this.isShow = res.data.isShow;
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
  .agencyColleaguesList{
    .el-table{
      font-size: 12px;
    }
    width: 100%;
    .ordinary_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      // font-size: 13px;
      border-radius: 5px;
    }
    .ordinary_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 13px 17px;
      // 输入框
      .search{
          // margin-top:10px;
        display: flex;
        justify-content: space-between;
    .search_type{
        span{
            display: inline-block;
            width: 77px;
            text-align: center;
            margin-bottom:10px;
            cursor: pointer;
        }
    }
        .el-input-group{
          width:24%;
          margin-bottom: 13px;
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
        // margin-top: 13px;
        padding-top: 34px;
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

<template>
  <div class="recruitmentProduct">
    <div class="ordinary_title font16">
      <div>我的招聘</div>
      <div @click="toPostJob">发布招聘</div>
    </div>
    <div class="ordinary_main">
      <div class="search">
    <div class="search_type">
      <span :class="status==='1'?'active':''" @click="putaway">已上架</span>
      <span :class="status==='0'?'active':''" @click="soldOut ">已下架</span>
      <span :class="status==='2'?'active':''" @click="allList ">全部</span>
    </div>
        <el-input placeholder="请输入岗位" v-model="searchFiled" clearable>
          <el-button slot="append" icon="el-icon-search" @click="initList()"></el-button>
        </el-input>
      </div>
      <div class="ordinary_table">
        <el-table :data="recruitmentTable" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%">
          <el-table-column prop="post" label="招聘岗位" align="center"> </el-table-column>
          <el-table-column prop="salaryName" label="薪资待遇" align="center"> </el-table-column>
          <el-table-column prop="num" label="招聘人数  (名)" align="center"> </el-table-column>
          <el-table-column prop="typeName" label="招聘类型" align="center"> </el-table-column>
          <el-table-column prop="createdTime" label="发布时间" align="center"> </el-table-column>
          <el-table-column label="状态" align="center">
              <template slot-scope="scope">
             <span v-if="scope.row.approvalStatus==='0'">未审批</span>
             <span v-if="scope.row.approvalStatus==='1'">审批中</span>
             <span v-if="scope.row.approvalStatus==='2'" class="greenColor">审批通过</span>
             <span v-if="scope.row.approvalStatus==='3'" class="redColor">未通过审批</span>

   </template>
          </el-table-column>
          <el-table-column label="操作" align="center" width="120" >
            <template slot-scope="scope">
              <el-button
                size="mini"
                  type="text"
                  v-if="scope.row.approvalStatus==='2'"
                @click="handleEdit( scope.row)" class="greenColor"><span>编辑</span>
              </el-button>
              <el-button
              v-if="scope.row.status==='1'&&scope.row.approvalStatus==='2'"
                size="mini"
                type="text"
                @click="handleSoldOut(scope.row)" class="redColor"><span>下架</span>
              </el-button>
              <el-button
              v-if="scope.row.status==='0'&&scope.row.approvalStatus==='2'"
                size="mini"
                type="text"
                @click="handleSoldOut(scope.row)" class="redColor"><span>上架</span>
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
      total:0,
            page:1,
      rows:10,
        searchFiled:'',
        status:'1',
      recruitmentTable:[],
    }
  },
  mounted(){
    this.initList()
  },
  methods: {
    // 跳转编辑页面
    handleEdit(row){
      this.$router.push({name:'editRecruit',query:{id:row.id}})
    },
    // 跳转页面
    toPostJob(){
      this.$router.push({name:'postJob'})
    },
    // 切换状态
    putaway(){
       this.status='1'
       this.initList()
    },
    // 切换状态
    soldOut(){
       this.status='0'
       this.initList()
    },
    allList(){
       this.status='2'
       this.initList()
    },
    // 点击上下架
    handleSoldOut(row){
  console.log(row)
      let _this = this;
        this.$confirm(`是否进行上下架操作, 是否继续?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
            this.api.post({
        url: "underRecruit",
        data: {id:row.id,status:row.status},
        // dataFlag:true,
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res)
            _this.initList()
          } else {
            _this.$message.error(res.result);
          }
        }
      });
      })
        .catch(() => {

        })

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
     initList(){
      let _this = this;
      this.api.get({
        url: "getWebRecruitList",
        data: {page:this.page,rows:this.rows,searchFiled:this.searchFiled,status:this.status},
        // dataFlag:true,
        callback: function(res) {
          console.log(res)
          if (res.code == "0000") {
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
}
</script>

<style lang="scss">
  .recruitmentProduct{
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
      padding: 20px;
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
            padding: 0px 0px 13px 0px;
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
          width:24%;
           position: absolute;
        // width: 20%;
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
        padding-top: 35px;
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

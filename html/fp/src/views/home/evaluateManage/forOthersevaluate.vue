<template>
  <div class="forOthersevaluate">
    <!-- 大标题 -->
    <div class="forOthersevaluate_title">
      <div>{{this.$route.meta.title}}</div>
    </div>
    <div class="forOthersevaluate_main">
      <div class="searh_tab">
        <el-input placeholder="请输入服务机构" v-model="sendData.orgName" class="input-with-select" clearable>
        </el-input>
        <el-input placeholder="请输入服务产品" v-model="sendData.productName" class="input-with-select" clearable>
        </el-input>
        <el-input placeholder="请输入服务顾问" v-model="sendData.advisorAccount" class="input-with-select" clearable>
        </el-input>
        <span class="confirm" @click="confirm">确定</span>
        <span class="reset" @click="reset">重置</span>
      </div>
      <div class="forOthersevaluate_table">
        <el-table :data="othersValuateList" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%">
          <el-table-column prop="id" label="评价编号" align="center" width="170"> </el-table-column>
          <el-table-column prop="orgName" label="服务机构" align="center"> </el-table-column>
          <el-table-column prop="orgTelephone" label="机构电话" align="center"> </el-table-column>
          <el-table-column prop="productName" label="服务产品" align="center"> </el-table-column>
          <el-table-column prop="advisorName" label="服务顾问" align="center"> </el-table-column>
          <el-table-column prop="issueTime" label="提需求日期" align="center" width="160"> </el-table-column>
          <el-table-column prop="handleTime" label="处理日期" align="center" width="160"> </el-table-column>
          <el-table-column label="评价状态" align="center"> 
            <template slot-scope="scope">
              <span>{{scope.row.isComment|status}} </span>
            </template>
          </el-table-column>
          <el-table-column label="操作" align="center" >
            <template slot-scope="scope">
              <div class="forOthersevaluatebth" >
                <span class="greenColor" v-show="scope.row.isComment==='0'" @click="toEvaluate(scope.row)">评价</span>
                <span @click="goDetail(scope.row)" class="greenColor" v-show="scope.row.isComment==='1'">详情</span>
              </div>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="forOthersevaluate_paging">
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :page-sizes="[8, 16, 24, 32]"
          :page-size="100"
          layout="total,prev, pager, next,sizes"
          :total="total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      othersValuateList:[],
      total:0,
      sendData:{
        advisorAccount:"",
        orgName:"",
        productName:"",
        page:1,
        rows:8
      }
    }
  },
  filters: {
    status(status){
      if(status==='1'){
        return "已评价"
      }else {
        return "待评价"
      }
    }
  },
  mounted () {
    this.getValuateList()
  },
  methods: {
    // 对他人的评价列表
    getValuateList(){
      let _this = this;
      this.api.get({
      url: "getGiveOthersCommentList",
      data: this.sendData,
      callback: function(res) {
        if (res.code == "0000") {
            // console.log(res)
            _this.othersValuateList=res.data.rows
            _this.total=res.data.total
          }
        }
      })
    },
    // 去评价
    toEvaluate(row){
      this.$router.push({path:'/serviceMarket/comment/toEvaluate',query:{id:row.id,businessId:row.businessId}})
    },
    //去详情
    goDetail(row){
      this.$router.push({path:'/serviceMarket/comment/evaluateDetail',query:{id:row.id,businessId:row.businessId}})
    },
    confirm(){
      this.getValuateList()
    },
    reset(){
      this.sendData.advisorAccount=''
      this.sendData.orgName=''
      this.sendData.productName=''
    },
    handleSizeChange(val) {
      this.sendData.rows=val
      this.getValuateList()
    },
    //翻页
    handleCurrentChange(val) {
      this.sendData.page=val
      this.getValuateList()
    },
  }
}
</script>

<style lang="scss">
.el-select-dropdown__item.selected{
  color:#00a041;
}
  .forOthersevaluate{
    
     width: 100%;
    .forOthersevaluate_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      font-size: 16px;
      border-radius: 5px;
    }
    .forOthersevaluate_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      .searh_tab{
        display: flex;
        align-items: center;
        justify-content: space-between;
        input:focus{
          border-color: #00a041;
        }
        .el-input{
          width: 25%;
        }
        .el-select>.el-input{
          width:100%;
        }
        .el-input-group{
          width:26%;
        }
        .el-input__inner{
          height: 30px;
          line-height: 30px;
          border-color:#eee;
        }
        .el-input__icon{
          line-height: 30px;
          width: 40px;
        }
        .el-input__suffix{
          // border-left: 1px solid #eee;
        }
        .confirm{
          background-color: #ecfcf2;
          border-radius: 5px;
          border: solid 1px #41d787;
          padding: 5.5px 20px;
          font-size: 12px;
          color:#00a041;
          cursor: pointer;
        }
        .reset{
          color:#fff;
          padding: 6px 20px;
          border-radius: 5px;
          background-color: #00a041;
          cursor: pointer;
        }
      }
      .forOthersevaluate_table{
        margin-top: 12px;
        padding-top: 25px;
        border-top: 1px solid #eee;
        .redColor{
          color:#ff0000
        }
        .greenColor{
          color:#00a041
        }
        .forOthersevaluatebth{
          span{
            cursor: pointer;
          }
        }
      }
      .forOthersevaluate_paging{
        text-align: center;
        margin: 51px 0 76px 0;
        .el-pagination__sizes .el-input .el-input__inner:hover{
          border-color: #00a041;
        }
        .el-select .el-input__inner:focus{
          border-color:#00a041;
        }
      }
    }
  }
</style>


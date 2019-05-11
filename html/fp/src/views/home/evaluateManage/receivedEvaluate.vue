<template>
  <div class="receivedEvaluate">
    <!-- 大标题 -->
    <div class="receivedEvaluate_title">
      <div>{{this.$route.meta.title}}</div>
    </div>
    <div class="receivedEvaluate_main">
      <div class="searh_tab">
        <el-input placeholder="请输入需求人" v-model="sendData.issueAccount" class="input-with-select" clearable>
        </el-input>
        <el-input placeholder="请输入服务产品" v-model="sendData.advisorName" class="input-with-select" clearable>
        </el-input>
        <el-input placeholder="请输入服务顾问" v-model="sendData.advisorId" class="input-with-select" clearable>
        </el-input>
        <span class="confirm" @click="confirm">确定</span>
        <span class="reset" @click="reset">重置</span>
      </div>
      <div class="receivedEvaluate_table">
        <el-table :data="receiveList" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%">
          <el-table-column prop="id" label="评价编号" align="center" width="170"> </el-table-column>
          <el-table-column prop="orgName" label="服务机构" align="center"> </el-table-column>
          <el-table-column prop="orgTelephone" label="机构电话" align="center"> </el-table-column>
          <el-table-column prop="productName" label="服务产品" align="center"> </el-table-column>
          <el-table-column prop="advisorName" label="服务顾问" align="center"> </el-table-column>
          <el-table-column prop="issueTime" label="提需求日期" align="center" width="160"> </el-table-column>
          <el-table-column prop="handleTime" label="处理日期" align="center" width="160"> </el-table-column>
          <el-table-column prop="commentTime" label="评价日期" align="center" width="160"> </el-table-column>
          <el-table-column label="操作" align="center" >
            <template slot-scope="scope">
              <div class="receivedEvaluatebth" >
                <span @click="goDetail(scope.row)" class="greenColor">详情</span>
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
      total:0,
      sendData:{
        advisorName:"",
        issueAccount:"",
        productName:"",
        page:1,
        rows:8
      },
      receiveList:[]
    }
  },
  mounted () {
    this.getReceivedValuate()
  },
  methods: {
    getReceivedValuate(){
      let _this = this;
      this.api.get({
      url: "getGiveMeCommentList",
      data: this.sendData,
      callback: function(res) {
        if (res.code == "0000") {
            // console.log(res)
            _this.receiveList=res.data.rows
            _this.total=res.data.total
          }
        }
      })
    },
    goDetail(row){
      this.$router.push({path:'/serviceMarket/comment/evaluateDetail',query:{id:row.id,}})
    },
    confirm(){
      this.getReceivedValuate()
    },
    reset(){
      this.sendData.advisorId=''
      this.sendData.issueAccount=''
      this.sendData.productName=''
    },
    handleSizeChange(val) {
      this.sendData.rows=val
      this.getReceivedValuate()
    },
    //翻页
    handleCurrentChange(val) {
      this.sendData.page=val
      this.getReceivedValuate()
    },
  }
}
</script>


<style lang="scss">
.el-select-dropdown__item.selected{
  color:#00a041;
}
  .receivedEvaluate{
     width: 100%;
    .receivedEvaluate_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      font-size: 16px;
      border-radius: 5px;
    }
    .receivedEvaluate_main{
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
      .receivedEvaluate_table{
        margin-top: 12px;
        padding-top: 25px;
        border-top: 1px solid #eee;
        .redColor{
          color:#ff0000
        }
        .greenColor{
          color:#00a041
        }
        .receivedEvaluatebth{
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


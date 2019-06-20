<template>
  <div class="receivedNeed">
    <!-- 大标题 -->
    <div class="receivedNeed_title">
      <div>{{this.$route.meta.title}}</div>
    </div>
    <div class="receivedNeed_main">
      <div class="searh_tab">
        <span>需求人：</span>
        <el-input placeholder="请输入需求人" v-model="sendData.requirePerson" class="input-with-select" clearable>
        </el-input>
        <span>意向产品：</span>
        <el-input placeholder="请输入意向产品" v-model="sendData.intentProduct" class="input-with-select" clearable>
        </el-input>
        <span>对接结果：</span>
        <el-select v-model="sendData.handleResult" placeholder="请选择对接结果" clearable >
          <el-option label="对接成功" value="1"></el-option>
          <el-option label="对接失败" value="2"></el-option>
          <el-option label="企业需求撤销" value="3"></el-option>
          <el-option label="未对接" value="4"></el-option>
        </el-select>
        <span class="confirm" @click="confirm">确定</span>
        <span class="reset" @click="reset">重置</span>
      </div>
      <div class="receivedNeed_table">
        <el-table :data="receivedtList" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%">
           <el-table-column prop="reqNum" label="需求单号" align="center" width="170"> </el-table-column>
          <el-table-column prop="orgName" label="意向机构" align="center" width="120"> </el-table-column>
          <el-table-column prop="businessArea" label="业务领域" align="center"> </el-table-column>
          <el-table-column prop="productName" label="意向产品" align="center" width="100"> </el-table-column>
          <el-table-column prop="advisorName" label="意向专员" align="center"  width="100"> </el-table-column>
          <el-table-column prop="requireTime" label="提需求日期" align="center" width="120"> </el-table-column>
          <el-table-column prop="status" label="需求状态" align="center"> </el-table-column>
          <el-table-column prop="handleResult" label="对接结果" align="center" width="110"> </el-table-column>
          <el-table-column label="操作" align="center" >
            <template slot-scope="scope">
              <div class="receivedNeedbth" >
                <span @click="goDetail(scope.row)" class="greenColor" v-show="scope.row.status==='已处理'" >详情</span>
                <span @click="goButt(scope.row)" v-show="scope.row.status==='待处理'" class="greenColor">对接</span>
              </div>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="receivedNeed_paging">
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
      receivedtList:[],
      total:0,
      sendData:{
        handleResult:"",
        intentProduct:"",
        needPage:1,
        page:1,
        rows:8,
        requirePerson:''
      }
    }
  },
  mounted () {
    this.getreceivedtList()
  },
  methods: {
    getreceivedtList(){
      let _this = this;
      this.api.get({
      url: "getRequireReceivedList",
      data: this.sendData,
      callback: function(res) {
        if (res.code == "0000") {
            // console.log(res)
            _this.receivedtList=res.data.rows
            _this.total=res.data.total
          }
        }
      })
    },
    //确定
    confirm(){
      this.getreceivedtList()
    },
    reset(){
      this.sendData.handleResult=''
      this.sendData.intentProduct=''
      this.sendData.requirePerson=''
    },
    //去详情
    goDetail(row){
      this.$router.push({path:'/serviceMarket/requireManagementController/receivedNeedDetail',query:{reqNum:row.reqNum,businessId:row.businessId}})
    },
     //去对接
    goButt(row){
      if(row.businessId==='technology_finance'){
        this.$router.push({path:'/serviceMarket/requireManagementController/buttNeedFinancial',query:{reqNum:row.reqNum}})
      }else{
        this.$router.push({path:'/serviceMarket/requireManagementController/buttNeed',query:{reqNum:row.reqNum}})
      }
    },
    handleSizeChange(val) {
      this.sendData.rows=val
      this.getreceivedtList()
    },
    //翻页
    handleCurrentChange(val) {
      this.sendData.page=val
      this.getreceivedtList()

    },
  }
}
</script>

<style lang="scss">
  .receivedNeed{
    width: 100%;
    .receivedNeed_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      font-size: 16px;
      border-radius: 5px;
    }
    .receivedNeed_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      border-radius: 5px;
      .searh_tab{
        display: flex;
        align-items: center;
        justify-content: space-between;
        input:focus{
          border-color: #00a041;
        }
        .el-input{
          width: 17%;
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
          border-left: 1px solid #eee;
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
      .receivedNeed_table{
        margin-top: 12px;
        padding-top: 25px;
        border-top: 1px solid #eee;
        .receivedNeedbth{
          span{
            cursor: pointer;
          }
        }
        .redColor{
          color:#ff0000
        }
        .greenColor{
          color:#00a041
        }
      }
      .receivedNeed_paging{
        text-align: center;
        margin: 51px 0 76px 0;
        .el-pagination.is-background .btn-prev,.el-pagination.is-background .btn-next{
          border: 1px solid #eee;
          background-color: #fff;
        }
        .el-pagination.is-background .el-pager li{
          background-color: #fff;
          border: 1px solid #eee;
        }
        .el-pagination.is-background .el-pager li:not(.disabled).active{
          background-color: #00a041;
          color: #fff;
        }
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


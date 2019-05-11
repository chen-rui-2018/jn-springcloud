<template>
  <div class="receiveDetail">
    <div class="receive_title">
      <div>{{this.$route.meta.title}}</div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <!-- 主体 -->
    <div class="receiveDetail_main">
      <div class="receiveDetail_form" v-if="businessId!='technology_finance'">
        <el-form label-position="right" label-width="120px" >
          <div :model="receiveDetail" class="">
            <el-form-item label="企业名称：">
              <span></span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="需求单号：">
              <span>{{receiveDetail.reqNum}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="发布时间：">
              <span>{{receiveDetail.issueTime}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="意向机构：">
              <span class="greenColor">{{receiveDetail.orgName}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="意向顾问：">
              <span>{{receiveDetail.advisorName}} </span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="意向产品：">
              <span>{{receiveDetail.productName}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人姓名：">
              <span>{{receiveDetail.reqName}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人手机：">
              <div>{{receiveDetail.reqPhone}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人邮箱：">
              <div>{{receiveDetail.reqEmail}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="需求描述：">
              <div>{{receiveDetail.requireDetail}}</div>
            </el-form-item>
          </div>
        </el-form>
      </div>
      <div class="receiveDetail_form" v-else>
        <el-form label-position="right" label-width="140px" >
          <div :model="receiveDetail" class="">
            <el-form-item label="企业名称：">
              <span>{{receiveDetail.companyName}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="需求单号：">
              <span>{{receiveDetail.reqNum}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="发布时间：">
              <span>{{receiveDetail.issueTime}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="融资金额：">
              <span >{{receiveDetail.financingAmount}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="融资期限：">
              <span>{{receiveDetail.financingPeriod}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="资金需求日期：">
              <span>{{receiveDetail.expectedDate}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="意向机构：">
              <span>{{receiveDetail.serviceCycle}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="意向产品：">
              <div>{{receiveDetail.orgName}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="资金需求说明：">
              <div>{{receiveDetail.fundsReqDesc}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人姓名：">
              <div>{{receiveDetail.reqName}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人手机：">
              <span>{{receiveDetail.reqPhone}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人邮箱：">
              <span>{{receiveDetail.reqEmail}}</span>
            </el-form-item>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      receiveDetail:{},
      reqNum:"",
      businessId:'',
    }
  },
  mounted () {
    this.reqNum =this.$route.query.reqNum
    this.businessId=this.$route.query.businessId
    this.getDetail()
  },
  methods: {
    getDetail(){
      let _this = this;
      this.api.get({
      url: "getReceivedRequireDetails",
      data: {reqNum:this.reqNum},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          _this.receiveDetail= res.data
          }
        }
      })
    }
  }
}
</script>

<style lang="scss">
    .redColor{
      color:#ff0000
    }
    .greenColor{
      color:#00a041
    }
  .receiveDetail{
    width: 100%;
    .receive_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      font-size: 16px;
      border-radius: 5px;
      div:nth-child(2){
        background-color: #ecfcf2;
        border-radius: 5px;
        border: solid 2px #41d787;
        padding:8px 11px;
        font-size: 12px;
        cursor: pointer;
        color:#00a041;
      }
    }
    // 主体
    .receiveDetail_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      .receiveDetail_form{
        width: 43%;
        margin: 25px auto;
        margin-bottom: 153px;
        .el-form-item__label{
          padding: 0 25px 0 0;
          line-height:25px;
        }
        .el-select{
          display: block;
        }
        .el-form-item__content{
          color:#999999;
          line-height:25px;
        }
        .el-select-dropdown__item{
          color:#999999;
        }
        .el-select .el-input.is-focus .el-input__inner{
          border-color:#00a041;
        }
        .el-form-item{
          margin-bottom: 11px;
        }
      }
    }
  }
</style>

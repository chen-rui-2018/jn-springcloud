<template>
  <div class="forothersneedDetail">
    <div class="others_title">
      <div>{{this.$route.meta.title}}</div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <!-- 主体 -->
    <div class="othersDetail_main">
      <div class="othersDetail_form" v-if="businessId!='technology_finance'">
        <el-form label-position="right" label-width="120px" >
          <div :model="othersDetail" class="">
            <el-form-item label="企业名称：">
              <span>{{othersDetail.companyName}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="需求单号：">
              <span>{{othersDetail.reqNum}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="发布时间：">
              <span>{{othersDetail.issueTime|time}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="意向机构：">
              <span class="greenColor">{{othersDetail.orgName}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="意向专员：">
              <span>{{othersDetail.advisorName}} </span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="意向产品：">
              <span>{{othersDetail.productName}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人姓名：">
              <span>{{othersDetail.reqName}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人手机：">
              <div>{{othersDetail.reqPhone}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人邮箱：">
              <div>{{othersDetail.reqEmail}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="需求描述：">
              <div>{{othersDetail.requireDetail}}</div>
            </el-form-item>
          </div>
        </el-form>
      </div>
      <div class="othersDetail_form" v-else>
        <el-form label-position="right" label-width="140px" >
          <div :model="othersDetail" class="">
            <el-form-item label="企业名称：">
              <span>{{othersDetail.companyName}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="需求单号：">
              <span>{{othersDetail.reqNum}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="发布时间：">
              <span>{{othersDetail.issueTime|time}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="融资金额：">
              <span >{{othersDetail.financingAmount}}万元</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="融资期限：">
              <span>{{othersDetail.financingPeriod}}个月</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="资金需求日期：">
              <span>{{othersDetail.expectedDate|time}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="意向机构：">
              <span>{{othersDetail.orgName}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="意向产品：">
              <div>{{othersDetail.productName}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="资金需求说明：">
              <div>{{othersDetail.fundsReqDesc}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人姓名：">
              <div>{{othersDetail.reqName}}</div>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人手机：">
              <span>{{othersDetail.reqPhone}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="联系人邮箱：">
              <span>{{othersDetail.reqEmail}}</span>
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
      othersDetail:{},
      reqNum:"",
      businessId:'',
    }
  },
  filters: {
    time(time){
      if(time){
        let dateee = new Date(time).toJSON();
        return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
      }
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
      url: "getOtherRequireDetails",
      data: {reqNum:this.reqNum},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          _this.othersDetail= res.data
          }
        }
      })
    }
  }
}
</script>

<style lang="scss">
  .forothersneedDetail{
    .redColor{
          color:#ff0000
        }
        .greenColor{
          color:#00a041
        }
    width: 100%;
    .others_title{
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
    .othersDetail_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      .othersDetail_form{
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

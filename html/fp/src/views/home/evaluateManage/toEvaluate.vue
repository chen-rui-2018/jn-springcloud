<template>
  <div class="toEvaluate">
    <div class="toEvaluate_title">
      <div>{{this.$route.meta.title}}</div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <!-- 主体 -->
    <div class="toEvaluate_main">
      <div class="toEvaluate_form" v-if="businessId!='technology_finance'">
        <el-form label-position="right" label-width="120px" >
          <el-form-item label="企业名称：">
            <span>{{sevaluateDetail.companyName}} </span>
          </el-form-item>
            <el-form-item label="需求单号：">
              <span>{{sevaluateDetail.reqNum}} </span>
            </el-form-item>
            <el-form-item label="发布时间：">
              <span>{{sevaluateDetail.issueTime|time}}</span>
            </el-form-item>
            <el-form-item label="意向机构：">
              <span class="greenColor">{{sevaluateDetail.orgName}}</span>
            </el-form-item>
            <el-form-item label="意向专员：">
              <span>{{sevaluateDetail.advisorName}} </span>
            </el-form-item>
            <el-form-item label="意向产品：">
              <span>{{sevaluateDetail.productName}}</span>
            </el-form-item>
            <el-form-item label="联系人姓名：">
              <span>{{sevaluateDetail.reqName}}</span>
            </el-form-item>
            <el-form-item label="联系人手机：">
              <div>{{sevaluateDetail.reqPhone}}</div>
            </el-form-item>
            <el-form-item label="联系人邮箱：">
              <div>{{sevaluateDetail.reqEmail}}</div>
            </el-form-item>
            <el-form-item label="需求描述：">
              <div>{{sevaluateDetail.reqDetail}}</div>
            </el-form-item>
            <el-form-item label="合同总金额：">
              <div>{{sevaluateDetail.contractAmount}}元</div>
            </el-form-item>
            <el-form-item label="结果描述：">
              <div> {{sevaluateDetail.resultDetail}}</div>
            </el-form-item>
            <el-form-item label="服务评分："  :rules="{ required: true, message: '评分不能为空', trigger: 'blur' }">
              <el-rate
                v-model="sendData.attitudeScore"
                text-color="#00a041"
                :colors="['#00a041', '#00a041', '#00a041']"
                >
              </el-rate>
            </el-form-item>
            <el-form-item label="服务评价描述：" class="btoEvaluate_discrib">
              <el-input
                type="textarea"
                placeholder="请输入内容"
                v-model="sendData.evaluationDesc">
              </el-input>
            </el-form-item>
        </el-form>
      </div>
      <div class="toEvaluate_form" v-else>
        <el-form label-position="right" label-width="140px" >
          <el-form-item label="企业名称：">
              <span>{{sevaluateDetail.companyName}}</span>
            </el-form-item>
            <el-form-item label="需求单号：">
              <span>{{sevaluateDetail.reqNum}}</span>
            </el-form-item>
            <el-form-item label="发布时间：">
              <span>{{sevaluateDetail.issueTime|time}}</span>
            </el-form-item>
            <el-form-item label="融资金额：">
              <span >{{sevaluateDetail.financingAmount}}万元</span>
            </el-form-item>
            <el-form-item label="融资期限：">
              <span>{{sevaluateDetail.financingPeriod}}个月</span>
            </el-form-item>
            <el-form-item label="资金需求日期：">
              <span>{{sevaluateDetail.expectedDate}}</span>
            </el-form-item>
            <el-form-item label="意向机构：">
              <span>{{sevaluateDetail.orgName}}</span>
            </el-form-item>
            <el-form-item label="意向产品：">
              <div>{{sevaluateDetail.productName}}</div>
            </el-form-item>
            <el-form-item label="资金需求说明：">
              <div>{{sevaluateDetail.fundsReqDesc}}</div>
            </el-form-item>
            <el-form-item label="联系人姓名：">
              <div>{{sevaluateDetail.reqName}}</div>
            </el-form-item>
            <el-form-item label="联系人手机：">
              <span>{{sevaluateDetail.reqPhone}}</span>
            </el-form-item>
            <el-form-item label="联系人邮箱：">
              <span>{{sevaluateDetail.reqEmail}}</span>
            </el-form-item>
            <el-form-item label="实际贷款金额：">
              <span>{{sevaluateDetail.actualLoanAmount}}万元</span>
            </el-form-item>
            <el-form-item label="结果描述：">
              <span>{{sevaluateDetail.resultDetail}}</span>
            </el-form-item>  
            <el-form-item label="服务评分："  :rules="{ required: true, message: '评分不能为空', trigger: 'blur' }">
              <el-rate
                v-model="sendData.attitudeScore"
                text-color="#00a041"
                :colors="['#00a041', '#00a041', '#00a041']"
                >
              </el-rate>
            </el-form-item>
            <el-form-item label="服务评价描述：" class="btoEvaluate_discrib">
              <el-input
                type="textarea"
                placeholder="有一星评价时，服务评论描述必填"
                v-model="sendData.evaluationDesc">
              </el-input>
            </el-form-item>
        </el-form>
      </div>
      <div class="toEvaluate_submit" @click="submit">提交</div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      businessId:'',
      sevaluateDetail:{},
      sendData:{
        attitudeScore:"",
        evaluationDesc:"",
        id:""
      }
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
    this.sendData.id =this.$route.query.id
    this.businessId=this.$route.query.businessId
    this.getSevaluateDetail()
  },
  methods: {
    getSevaluateDetail(){
      let _this = this;
      this.api.get({
      url: "getRatingCommentDetail",
      data: {id:this.sendData.id},
      callback: function(res) {
        if (res.code == "0000") {
          _this.sevaluateDetail= res.data
          }
        }
      })
    },
    submit(){
      let _this = this;
      this.api.post({
      url: "saveRatingComment",
      data: this.sendData,
      callback: function(res) {
        if (res.code == "0000") {
          _this.$message.success("评价成功")
          _this.$router.go(-1)
          }else{
            _this.$message.error(res.result)
          }
        }
      })
    }    
  }
}
</script>

<style lang="scss">
  .toEvaluate{
    .redColor{
          color:#ff0000
        }
        .greenColor{
          color:#00a041
        }
    width: 100%;
    .toEvaluate_title{
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
    .toEvaluate_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      .toEvaluate_form{
        width: 43%;
        margin: 25px auto;
        margin-bottom: 41px;
        .btoEvaluate_discrib{
          .el-textarea__inner{
            background-color: #fff;
            resize: none;
            line-height: 3.5;
          }
          textarea:focus{
            border-color: #00a041;
          }
        }
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
          margin-bottom: 14px;
        }
      }
      .toEvaluate_submit{
        background-color: #ecfcf2;
        border-radius: 5px;
        border: solid 2px #41d787;
        padding:7px 31px;
        font-size: 12px;
        cursor: pointer;
        width:5%;
        text-align: center;
        color:#00a041;
        margin:30px auto 15px;
      }
    }
  }
</style>


<template>
  <div class="buttNeedFinancial">
    <div class="buttNeedFinancial_title">
      <div>{{this.$route.meta.title}}</div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <div class="buttNeedFinancial_main">
      <div class="buttNeedFinancial_form">
        <el-form label-position="right" label-width="140px"  :model="sendData" >
            <el-form-item label="企业名称：" >
              <span>{{receiveDetail.companyName}}</span>
            </el-form-item>
            <el-form-item label="需求单号：">
              <span>{{receiveDetail.reqNum}}</span>
            </el-form-item>
            <el-form-item label="发布时间：">
              <span>{{receiveDetail.issueTime}}</span>
            </el-form-item>
            <el-form-item label="融资金额：">
              <span >{{receiveDetail.financingAmount}}</span>
            </el-form-item>
            <el-form-item label="融资期限：">
              <span>{{receiveDetail.financingPeriod}}</span>
            </el-form-item>
            <el-form-item label="资金需求日期：">
              <span>{{receiveDetail.expectedDate}}</span>
            </el-form-item>
            <el-form-item label="意向机构：">
              <span>{{receiveDetail.serviceCycle}}</span>
            </el-form-item>
            <el-form-item label="意向产品：">
              <div>{{receiveDetail.orgName}}</div>
            </el-form-item>
            <el-form-item label="资金需求说明：">
              <div>{{receiveDetail.fundsReqDesc}}</div>
            </el-form-item>
            <el-form-item label="联系人姓名：">
              <div>{{receiveDetail.reqName}}</div>
            </el-form-item>
            <el-form-item label="联系人手机：">
              <span>{{receiveDetail.reqPhone}}</span>
            </el-form-item>
            <el-form-item label="联系人邮箱：">
              <span>{{receiveDetail.reqEmail}}</span>
            </el-form-item>
            <el-form-item label="实际贷款金额：" prop="actualLoanAmount" :rules="[
              { required: true, message: '合同总金额不能为空',trigger: 'blur'},
              { type: 'number', message: '合同总金额必须为数字值'}
        ]">
              <el-input v-model.number="sendData.actualLoanAmount" placeholder="请填写合同总金额"></el-input>
            </el-form-item>
            <el-form-item label="对接结果：" >
              <el-radio-group v-model="sendData.handleResult">
                <el-radio :label="1">对接成功</el-radio>
                <el-radio :label="2">对接失败</el-radio>
                <el-radio :label="3">需求撤销</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="结果描述：" class="butt_discrib">
              <el-input
                type="textarea"
                placeholder="请输入内容"
                v-model="sendData.resultDetail">
              </el-input>
            </el-form-item>
          <el-form-item label="合同首页：" >
            <el-upload
              action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
              list-type="picture-card"
              :on-success="homePageuploadsuccess"
              :headers="headers"
              :file-list="fileList"
              >
              <i class="el-icon-plus"></i>
            </el-upload>
          </el-form-item>
            <el-form-item label="合同尾页：">
              <el-upload
              action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
              list-type="picture-card"
              :on-success="endPageuploadsuccess"
              :headers="headers"
              :file-list="fileList2"
              >
              <i class="el-icon-plus"></i>
            </el-upload>
            </el-form-item>
        </el-form>
      </div>
      <div class="buttNeedFinancial_submit" @click="submit">提交</div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      receiveDetail:{},
      headers:{token: sessionStorage.token},
      fileList:[],
      fileList2:[],
      sendData:{
        actualLoanAmount: '',
        contractAmount: '',
        contractEndPage: '',
        contractHomePage: '',
        handleResult: '',
        isTechnology: 1,
        reqNum: '',
        resultDetail: '',
      }
    }
  },
  mounted () {
    this.sendData.reqNum =this.$route.query.reqNum
    this.getDetail()
  },
  methods: {
    getDetail(){
      let _this = this;
      this.api.get({
      url: "getReceivedRequireDetails",
      data: {reqNum:this.sendData.reqNum},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          _this.receiveDetail= res.data
          }
        }
      })
    },
    submit(){
      let _this = this;
      this.api.post({
      url: "handleRequire",
      data: this.sendData,
      callback: function(res) {
        if (res.code == "0000") {
            _this.$message.success("对接成功")
            _this.$router.go(-1)
          }
        }
      })
    },
    homePageuploadsuccess(file, fileList){
      this.sendData.contractHomePage=file.data
    },
    endPageuploadsuccess(file, fileList){
      this.sendData.contractEndPage=file.data
    }
  }
}
</script>

<style lang="scss">
   .buttNeedFinancial{
    width: 100%;
    .buttNeedFinancial_title{
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
    .buttNeedFinancial_main{
      .redColor{
        color:#ff0000
      }
      .greenColor{
        color:#00a041
      }
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      .buttNeedFinancial_form{
        width: 48%;
        margin: 25px auto;
        .el-upload--picture-card{
            width: 100px;
            height: 100px;
            line-height: 100px;
          }
          .el-upload--picture-card:hover, .el-upload:focus{
            border-color: #00a041;
            color: #00a041;
          }
          .el-upload-list--picture-card .el-upload-list__item{
          width:100px;
          height: 100px;
          }
        .el-form-item__label{
          padding: 0 25px 0 0;
          line-height:25px;
        }
        .el-form-item__content{
          color:#999999;
          line-height:25px;
        }
        .el-input__inner{
          height: 37px;
          line-height: 37px;
        }
        .el-form-item{
          margin-bottom: 14px;
        }
        img{
          width: 100px;
          height: 100px;
        }
        input:focus{
          border-color:#00a041;
        }
        .butt_discrib{
          .el-textarea__inner{
            background-color: #fff;
            resize: none;
            line-height: 3.5;
          }
          textarea:focus{
            border-color: #00a041;
          }
        }
        .el-radio__input.is-checked .el-radio__inner{
          background-color: #00a041;
          border-color: #00a041;
        }
        .el-radio__inner:hover{
          border-color: #00a041;
        }
        .el-radio__input.is-checked+.el-radio__label{
          color:#00a041;
        }

      }
      .buttNeedFinancial_submit{
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


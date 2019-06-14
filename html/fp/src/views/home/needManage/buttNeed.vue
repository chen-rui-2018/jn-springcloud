<template>
  <div class="buttNeed">
    <div class="buttNeed_title">
      <div>{{this.$route.meta.title}}</div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <div class="buttNeed_main">
      <div class="buttNeed_form">
        <el-form label-position="right" label-width="120px" >
          <div  class="">
            <el-form-item label="企业名称：">
              <span>{{receiveDetail.companyName}} </span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="需求单号：">
              <span>{{receiveDetail.reqNum}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="发布时间：">
              <span>{{receiveDetail.issueTime|time}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="意向机构：">
              <span class="greenColor">{{receiveDetail.orgName}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="意向专员：">
              <span>{{receiveDetail.advisorName}}</span>
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
          <div class="">
            <el-form-item label="合同总金额：">
              <el-input v-model="sendData.contractAmount" placeholder="请填写合同总金额"></el-input>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="对接结果：">
              <el-radio-group v-model="sendData.handleResult" >
                <el-radio :label="1">对接成功</el-radio>
                <el-radio :label="2">对接失败</el-radio>
                <el-radio :label="3">需求撤销</el-radio>
              </el-radio-group>
            </el-form-item>
          </div>
          <div class="butt_discrib">
            <el-form-item label="结果描述：">
              <el-input
                type="textarea"
                placeholder="请输入内容"
                v-model="sendData.resultDetail">
              </el-input>
            </el-form-item>
          </div>
          <el-form-item label="合同首页：" >
            <el-upload
              :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
              list-type="picture-card"
              :on-success="homePageuploadsuccess"
              :headers="headers"
              :limit="1"
              :on-exceed="handleExceed"
              :on-remove="deletHome"
              :file-list="fileList"
              >
              <i class="el-icon-plus"></i>
            </el-upload>
          </el-form-item>
            <el-form-item label="合同尾页：">
              <el-upload
              :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
              
              :on-success="endPageuploadsuccess"
              :headers="headers"
              :limit="1"
              :on-exceed="handleExceed"
              :on-remove="deletEnd"
              :file-list="fileList2"
              >
              <i class="el-icon-plus"></i>
            </el-upload>
            </el-form-item>
        </el-form>
      </div>
      <div class="buttNeed_submit" @click="submit">提交</div>
    </div>
  </div>
</template>
<script>
import { getToken, removeToken } from '@/util/auth'
export default {
  data () {
    return {
      baseUrl: this.api.host,
      receiveDetail:{},
      headers:{token: getToken()},
      fileList:[],
      fileList2:[],
      sendData:{
        actualLoanAmount: '',
        contractAmount: '',
        contractEndPage: '',
        contractHomePage: '',
        handleResult: '',
        isTechnology: 0,
        reqNum: '',
        resultDetail: '',
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
    //提交对接
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
    deletHome(file, fileList){
      this.sendData.contractHomePage=""
    },
    endPageuploadsuccess(file, fileList){
      this.sendData.contractEndPage=file.data
    },
    deletEnd(file, fileList){
      this.sendData.contractEndPage=""
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件`);
    },
  }
}
</script>

<style lang="scss">
  .buttNeed{
    width: 100%;
    .buttNeed_title{
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
    .buttNeed_main{
      .redColor{
        color:#ff0000
      }
      .greenColor{
        color:#00a041
      }
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      .buttNeed_form{
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
      .buttNeed_submit{
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


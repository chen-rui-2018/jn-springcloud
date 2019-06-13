<template>
  <div class="specialEdit">
    <div class="specialEdit_title">
      <div>新增特色产品</div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <div class="specialEdit_main">
      <div class="specialEdit_form" v-if="businessType!='technology_finance'" >
        <el-form label-position="right" label-width="150px">
          <div :model="specialEditData" class="finance_data_container">
            <el-form-item label="业务领域：">
              <span >{{signoryName}} </span>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="服务专员：" >
              <el-select v-model="specialEditData.advisorAccount" placeholder="请选择">
                <el-option :label="counseloritem.advisorName" :value="counseloritem.advisorAccount" v-for="(counseloritem,counselorindex) in counselorList" :key="counselorindex">
                </el-option>
              </el-select>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="产品名称：" >
              <el-input v-model="specialEditData.productName" placeholder="请输入产品名称" type="text" clearable/>
            </el-form-item>
          </div>
            <el-form-item label="参考价格：" >
              <el-input v-model="specialEditData.referPrice" placeholder="请输入最低价格" type="text" clearable > <template slot="suffix">元</template> </el-input>
            </el-form-item>
          <div class="product_img">
            <el-form-item label="产品图片：" >
              <el-upload
                :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
                list-type="picture-card"
                :on-success="uploadsuccess"
                :headers="headers"
                :file-list="fileList"
                >
                <img v-if="imageUrl" :src="imageUrl" class="avatar"> 
                <i v-else class="el-icon-plus"></i>
              </el-upload>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="服务周期：" >
              <el-input v-model="specialEditData.serviceCycle" placeholder="请提供该产品服务的通常完成周期" type="text" clearable/>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="产品描述：">
              <div class="content_textarea">
                <el-input
                  type="textarea"
                  placeholder="请输入产品详情描述"
                  v-model="specialEditData.productDetails">
                </el-input>
              </div>
            </el-form-item>
          </div>
        </el-form>
      </div>
      <div class="specialEdit_form" v-else>
        <el-form label-position="right" label-width="150px">
          <div class="finance_data_container">
            <el-form-item label="产品名称：">
              <el-input v-model="addFinancialProduct.productName" placeholder="请输入产品名称" type="text" clearable/>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="参考利率范围：" >
              <el-input v-model="addFinancialProduct.refRateMin" placeholder="请输入最低价格" type="text" clearable > <template slot="suffix">%</template> </el-input><span> -</span>
              <el-input v-model="addFinancialProduct.refRateMax" placeholder="请输入最高价格" type="text" clearable> <template slot="suffix">%</template> </el-input>
              <span></span>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="是否网贷直联：" >
              <el-select v-model="addFinancialProduct.isOnlineLoan" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="是否政策性产品：" >
              <el-select v-model="addFinancialProduct.isPolicyPro" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="是否通用产品：" >
              <el-select v-model="addFinancialProduct.isGeneralPro" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="是否人民币：" >
              <el-select v-model="addFinancialProduct.isRmb" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="贷款类别：" >
              <el-select v-model="addFinancialProduct.loanCategoryName" placeholder="请选择">
                <el-option
                  v-for="(item,index) in LoanTypeList "
                  :key="index"
                  :label="LoanTypeList[index].loanName"
                  :value="LoanTypeList[index].loanCode"
                  @click.native="changeloanCategoryName(LoanTypeList[index].loanCode) "
                />
              </el-select>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="贷款额度：" >
              <el-input v-model="addFinancialProduct.loanAmountMin" placeholder="请输入最小额度" type="text" clearable> <template slot="suffix">万元</template> </el-input>
              <span>-</span>
              <el-input v-model="addFinancialProduct.loanAmountMax" placeholder="请输入最大额度" type="text" clearable> <template slot="suffix">万元</template> </el-input>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="贷款期限：" >
              <el-input v-model="addFinancialProduct.loanTermMin" placeholder="请输入最小期限" type="text" clearable> <template slot="suffix">个月</template> </el-input>
              <span>-</span>
              <el-input v-model="addFinancialProduct.loanTermMax" placeholder="请输入最大期限" type="text" clearable> <template slot="suffix">个月</template> </el-input>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="担保方式：" >
              <el-select v-model="addFinancialProduct.assureMethodName" placeholder="请选择">
                <el-option
                  v-for="(item,index) in AssureTypeList "
                  :key="index"
                  :label="AssureTypeList[index].assureName"
                  :value="AssureTypeList[index].assureCode"
                  @click.native="changeassure(AssureTypeList[index].assureCode) "
                />
              </el-select>
            </el-form-item>
          </div>
          <div class="product_img">
            <el-form-item label="产品图片：" >
              <!-- <el-upload
                :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
                list-type="picture-card"
                :on-success="uploadsuccess"
                :headers="headers"
                :file-list="fileList"
                >
                <img v-if="imageUrl" :src="imageUrl" class="avatar">
                <i v-else class="el-icon-plus"></i>
              </el-upload> -->
              <el-upload
                :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
                list-type="picture-card"
                :on-success="uploadsuccess"
                :headers="headers"
                :file-list="fileList">
                <img v-if="imageUrl" :src="imageUrl" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="产品特点：">
              <div class="content_textarea">
                <el-input
                  type="textarea"
                  placeholder="请输入内容"
                  v-model="addFinancialProduct.productFeature">
                </el-input>
              </div>
            </el-form-item>
          </div>
        </el-form>
      </div>
      <div class="submit" @click="submit">提交申请</div>
    </div>
  </div>
</template>
<script>
import { getToken } from '@/util/auth'
export default {
  data () {
    return {
      baseUrl: this.api.host,
      specialEditData:{
        advisorAccount:'',
        orgId:"",
        pictureUrl:"",
        productDetails:"",
        productId:"",
        productName:"",
        productType:1,
        referPrice:"",
        serialNumber:"",
        serviceCycle:"",
        signoryId:"",
        signoryName:""
      },
      imageUrl:"",
      orgId:'',
      signoryId:'',
      signoryName:'',
      counselorList:[],
      headers:{token: getToken()},
      fileList:[],
      businessType:'',
      productId:"b1c22cd7bc794ea6ba11fc869e17101e",
      LoanTypeList:[],//金融产品贷款类别
      AssureTypeList:[],//金融产品担保方式
      addFinancialProduct:{
        applicableCust: "",
        applyCondition: "",
        assureMethodCode:"",
        assureMethodName: "",
        isGeneralPro: "",
        isOnlineLoan: "",
        isPolicyPro: "",
        isRmb: "",
        loanAmountMax: "",
        loanAmountMin: "",
        loanCategoryCode: "",
        loanCategoryName: "",
        loanTermMax: "",
        loanTermMin: "",
        pictureUrl:"",
        productFeature: "",
        productId:"",
        productName: "",
        productType: 1,
        refRateMax:"",
        refRateMin: "",
        serialNumber: "",
        signoryId: "technology_finance",
        signoryName: "科技金融",
        submitMaterial: ""
      }
    }
  },
  mounted () {
    this.specialEditData.orgId=this.$route.query.orgid
    this.orgId=this.$route.query.orgid
    this.specialEditData.orgId=this.$route.query.orgid
    // this.orgId=this.$route.query.orgid
    this.addFinancialProduct.orgId=this.$route.query.orgid
    this.productId=this.$route.query.productId
    this.getType()
    // this.getProductSerialNumber()
  },
  methods: {
    //判断机构类型
    getType(){
      let _this = this;
      this.api.get({
      url: "getActivityDetailsFm",
      data: {orgId:this.orgId},
      callback: function(res) {
        if (res.code == "0000") {
          _this.businessType= res.data.businessType
          _this.signoryId=res.data.businessType
          _this.signoryName=res.data.businessTypeName
          /* _this.specialEditData.signoryId=res.data.businessType
          _this.specialEditData.signoryName=res.data.businessTypeName
          _this.addFinancialProduct.signoryId=res.data.businessType */
          if( _this.businessType!='technology_finance'){
            _this.getServiceConsultantList()
            _this.getProductDetails()
          }else{
            _this.getFinancialProductDetails()
            _this.getLoanType()
            _this.AssureType()
          }
          }
        }
      })
    },
    //产品编号获取
    /* getProductSerialNumber(){
      let _this = this;
      this.api.get({
      url: "getProductSerialNumber",
      data: {productType:1},
      callback: function(res) {
        if (res.code == "0000") {
            // console.log(res)
          _this.specialEditData.serialNumber= res.data
          _this.addFinancialProduct.serialNumber=res.data
          }
        }
      })
    }, */
    // 获取服务产品详情（非科技金融）
    getProductDetails(){
      let _this = this;
      this.api.get({
      url: "findProductDetails",
      data: {productId:this.productId},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          // _this.specialEditData = res.data.info
          fun( _this.specialEditData, res.data.info)
          function fun (originArr, targetArr) {
            for (const key in  originArr) {
            if (targetArr.hasOwnProperty(key)) {
              originArr[key] = targetArr[key]
            }
          }
          }
          _this.specialEditData.signoryId=_this.signoryId
          _this.specialEditData.signoryName=_this.signoryName
          _this.imageUrl=res.data.info.pictureUrl
          }
        }
      })
    },
    // 获取服务产品详情（科技金融）
    getFinancialProductDetails(){
      let _this = this;
      this.api.get({
      url: "getFinancialProductDetails",
      data: {productId:this.productId},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          fun(_this.addFinancialProduct, res.data)
          function fun (originArr, targetArr) {
            for (const key in  originArr) {
            if (targetArr.hasOwnProperty(key)) {
              originArr[key] = targetArr[key]
            }
          }
          }
          // _this.addFinancialProduct= res.data
          _this.addFinancialProduct.signoryId=_this.signoryId
          _this.imageUrl=res.data.pictureUrl
          }
        }
      })
    },
    //金融产品贷款类别
    getLoanType(){
      let _this = this;
      this.api.get({
      url: "getFinancialProductLoanType",
      data: {},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          _this.LoanTypeList= res.data
          }
        }
      })
    },
    //担保方式
    AssureType(){
      let _this = this;
      this.api.get({
      url: "getFinancialProductAssureType",
      data: {},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          _this.AssureTypeList= res.data
          }
        }
      })
    },
    //专员列表获取
    getServiceConsultantList(){
      let _this = this;
      this.api.get({
      url: "getServiceConsultantList",
      data: {orgId:this.orgId},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          _this.counselorList= res.data.rows
          }
        }
      })
    },
    //改变 贷款类别
    changeloanCategoryName(code){
      this.addFinancialProduct.loanCategoryCode=code
    },
    // 改变担保方式
    changeassure(code){
      this.addFinancialProduct.assureCode=code
    },
    uploadsuccess(file, fileList){
      if(this.businessType==='technology_finance'){
        this.addFinancialProduct.pictureUrl=file.data
        debugger
        this.imageUrl=file.data
      }else{
        this.specialEditData.pictureUrl=file.data
        debugger
        this.imageUrl=file.data
      }
    },
    //提交编辑
    submit(){
      if(this.businessType==='technology_finance'){
        let _this = this;                                  
        this.api.post({               
        url: "modifyFeatureProduct",
        data: this.addFinancialProduct,
        callback: function(res) {
          if (res.code == "0000") {
              console.log(res)
              _this.$message.success("编辑成功")
              _this.$router.go(-1)
            }
          }
        }) 
      }else {
        let _this = this;
        this.api.post({               
        url: "updateFeatureProduct",
        data: this.specialEditData,
        callback: function(res) {
          if (res.code == "0000") {
              // console.log(res)
              _this.$message.success("编辑成功")
              _this.$router.go(-1)
            }
          }
        }) 
      }
    }
  }
}
</script>

<style lang="scss">
 .el-select-dropdown__item.selected{
          color:#00a041;
        }
  .specialEdit{
    width: 100%;
    // 大标题
    .specialEdit_title{
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
        padding:5px 22px;
        font-size: 14px;
        cursor: pointer;
        color:#00a041;
      }
    }
    // 主体
    .specialEdit_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      border-radius: 5px;
      .specialEdit_form{
        width: 50%;
        margin: 0 auto;
        input:focus{
          border-color: #00a041;
        }
        .double_input{
          .el-input{
            width:47%;
            input:focus{
              border:1px solid #00a041;
            }
          }
        }
        .product_img{
          .el-upload--picture-card{
            width: 100px;
            height: 100px;
            line-height: 100px;
          }
          .el-upload-list--picture-card .el-upload-list__item{
          width:100px;
          height: 100px;
        }
          .avatar-uploader-icon {
            font-size: 28px;
            color: #8c939d;
           width:100px;
          height: 100px;
            line-height: 100px;
            text-align: center;
          }
          .avatar {
            width:100px;
          height: 100px;
            display: block;
          }
        }
        .content_textarea{
          textarea{
            padding: 8px 15px;
            resize: none;
            height: 96px;
            border-radius: 5px;
            background: #fff;
            &:focus{
              border:1px solid #00a041;
            }
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
          // line-height:25px;
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
        .el-select .el-input__inner:focus{
          border-color:#00a041;
        }
      }
      .submit{
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



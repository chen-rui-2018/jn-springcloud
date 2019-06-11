<template>
  <div class="addScience" v-loading="loading">
    <div class="putaway_title">
      <div>新增特色产品</div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <div class="addScience_main">
      <div class="addScience_form" v-show="businessType!='technology_finance'" >
        <el-form label-position="right" label-width="160px"  :rules="addScienceDatarules" :model="addScienceData">
            <el-form-item label="业务领域：">
              <span >{{addScienceData.signoryName}} </span>
            </el-form-item>
      
            <el-form-item label="服务专员：" >
              <el-select v-model="addScienceData.advisorAccount" placeholder="请选择">
                <el-option :label="counseloritem.advisorName" :value="counseloritem.advisorAccount" v-for="(counseloritem,counselorindex) in counselorList" :key="counselorindex">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="产品名称：" prop="productName">
              <el-input v-model="addScienceData.productName" placeholder="请输入产品名称" type="text" clearable/>
            </el-form-item>
            <el-form-item label="参考价格：" prop="referPrice">
              <el-input v-model="addScienceData.referPrice" placeholder="请输入参考价格价格,例10-100" type="text" clearable > <template slot="suffix">元</template> </el-input><!-- <span> -</span> -->
              <!-- <el-input v-model="referPriceMax" placeholder="请输入最高价格" type="text" clearable> <template slot="suffix">元</template> </el-input> -->
              <span></span>
            </el-form-item>
            <el-form-item label="产品图片：" >
              <el-upload
                :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
                list-type="picture-card"
                :on-success="uploadsuccess"
                :headers="headers"
                :file-list="fileList"
                >
                <i class="el-icon-plus"></i>
              </el-upload>
            </el-form-item>
            <el-form-item label="服务周期：" prop="serviceCycle">
              <el-input v-model="addScienceData.serviceCycle" placeholder="请提供该产品服务的通常完成周期" type="text" clearable/>
            </el-form-item>
            <el-form-item label="产品描述：">
              <div class="content_textarea">
                <el-input
                  type="textarea"
                  placeholder="请输入产品详情描述"
                  v-model="addScienceData.productDetails">
                </el-input>
              </div>
            </el-form-item>
        </el-form>
      </div>
      <div class="addScience_form" v-show="businessType==='technology_finance'">
        <el-form label-position="right" label-width="150px" :model="addFinancialProduct" :rules="addFinancialProductrules">
            <el-form-item label="产品名称：" prop="productName">
              <el-input v-model="addFinancialProduct.productName" placeholder="请输入产品名称" type="text" clearable/>
            </el-form-item>
            <el-form-item label="参考利率范围：" class="double_input" prop="refRateMin">
              <el-input v-model="addFinancialProduct.refRateMin" placeholder="请输入最低价格" type="text" clearable > <template slot="suffix">%</template> </el-input><span> -</span>
              <el-input v-model="addFinancialProduct.refRateMax" placeholder="请输入最高价格" type="text" clearable> <template slot="suffix">%</template> </el-input>
              <span></span>
            </el-form-item>
            <el-form-item label="是否网贷直联：" prop="isOnlineLoan">
              <el-select v-model="addFinancialProduct.isOnlineLoan" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
            <el-form-item label="是否政策性产品：" prop="isPolicyPro">
              <el-select v-model="addFinancialProduct.isPolicyPro" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
            <el-form-item label="是否通用产品：" prop="isGeneralPro">
              <el-select v-model="addFinancialProduct.isGeneralPro" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
            <el-form-item label="是否人民币：" prop="isRmb" >
              <el-select v-model="addFinancialProduct.isRmb" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
            <el-form-item label="贷款类别：" prop="loanCategoryCode">
              <el-select v-model="addFinancialProduct.loanCategoryCode" placeholder="请选择">
                <el-option
                  v-for="(item,index) in LoanTypeList "
                  :key="index"
                  :label="LoanTypeList[index].loanName"
                  :value="LoanTypeList[index].loanCode"
                  @click.native="changeloanCategoryName(LoanTypeList[index].loanName) "
                />
              </el-select>
            </el-form-item>
            <el-form-item label="贷款额度：" class="double_input" prop="loanAmountMin">
              <el-input v-model="addFinancialProduct.loanAmountMin" placeholder="请输入最小额度" type="text" clearable> <template slot="suffix">万元</template> </el-input>
              <span>-</span>
              <el-input v-model="addFinancialProduct.loanAmountMax" placeholder="请输入最大额度" type="text" clearable> <template slot="suffix">万元</template> </el-input>
            </el-form-item>
            <el-form-item label="贷款期限：" class="double_input"  prop="loanTermMin">
              <el-input v-model="addFinancialProduct.loanTermMin" placeholder="请输入最小期限" type="text" clearable> <template slot="suffix">个月</template> </el-input>
              <span>-</span>
              <el-input v-model="addFinancialProduct.loanTermMax" placeholder="请输入最大期限" type="text" clearable> <template slot="suffix">个月</template> </el-input>
            </el-form-item>
            <el-form-item label="担保方式：" prop="assureMethodCode" >
              <el-select v-model="addFinancialProduct.assureMethodCode" placeholder="请选择">
                <el-option
                  v-for="(item,index) in AssureTypeList "
                  :key="index"
                  :label="AssureTypeList[index].assureName"
                  :value="AssureTypeList[index].assureCode"
                  @click.native="changeassure(AssureTypeList[index].assureName) "
                />
              </el-select>
            </el-form-item>
            <el-form-item label="产品图片：" class="product_img">
              <el-upload
                :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
                list-type="picture-card"
                :on-success="uploadsuccess"
                :headers="headers"
                :file-list="fileList"
                >
                <i class="el-icon-plus"></i>
              </el-upload>
            </el-form-item>
            <el-form-item label="产品特点：">
              <div class="content_textarea">
                <el-input
                  type="textarea"
                  placeholder="请输入内容"
                  v-model="addFinancialProduct.productFeature">
                </el-input>
              </div>
            </el-form-item>
        </el-form>
      </div>
      <div class="submit" @click="submit">提交申请</div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
        baseUrl: this.api.host,
        addScienceData:{
        advisorAccount:'',
        orgId:"",
        pictureUrl:"",
        productDetails:"",
        productName:"",
        productType:1,
        referPrice:"",
        serialNumber:"",
        serviceCycle:"",
        signoryId:"",
        signoryName:""
      },
      loading:false,
      counselorList:[],
      headers:{token: sessionStorage.token},
      fileList:[],
      businessType:'',
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
        orgId:"",
        orgName:"",
        pictureUrl:"",
        productFeature: "",
        productName: "",
        productType: 1,
        refRateMax:"",
        refRateMin: "",
        serialNumber: "",
        signoryId: "technology_finance",
        signoryName: "科技金融",
        submitMaterial: ""
      },
      addScienceDatarules:{
        productName:[
          { required: true, message: '产品名称不能为空', trigger: 'blur'},
        ],
        referPrice:[
          { required: true, message: '参考价格不能为空', trigger: 'blur'},
        ],
        serviceCycle:[
          { required: true, message: '服务周期不能为空', trigger: 'blur'},
        ],
      },
      addFinancialProductrules:{
        productName:[
          { required: true, message: '产品名称不能为空', trigger: 'blur'},
        ],
        refRateMin:[
          { required: true, message: '参考利率不能为空', trigger: 'blur'},
        ],
        isOnlineLoan:[
          { required: true, message: '是否网贷直联不能为空', trigger: 'blur'},
        ],
        isPolicyPro:[
          { required: true, message: '是否政策性产品不能为空', trigger: 'blur'},
        ],
        isGeneralPro:[
          { required: true, message: '是否通用产品不能为空', trigger: 'blur'},
        ],
        isRmb:[
          { required: true, message: '是否人民币不能为空', trigger: 'blur'},
        ],
        loanCategoryCode :[
          { required: true, message: '贷款类别不能为空', trigger: 'change'},
        ],
        loanAmountMin:[
          { required: true, message: '贷款额度不能为空', trigger: 'blur'},
        ],
        loanTermMin :[
          { required: true, message: '贷款期限不能为空', trigger: 'blur'},
        ],
        assureMethodCode:[
          { required: true, message: '担保方式不能为空', trigger: 'change'},
        ],
      },
    }
  },
  mounted () {
    this.addScienceData.orgId=this.$route.query.orgid
    this.addFinancialProduct.orgId=this.$route.query.orgid
    this.getType()
    this.getProductSerialNumber()
  
    
  },
  methods: {
    //判断机构类型
    getType(){
      let _this = this;
      this.api.get({
      url: "getActivityDetailsFm",
      data: {orgId:this.addScienceData.orgId},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          _this.businessType= res.data.businessType
          _this.addScienceData.signoryName=res.data.businessTypeName
          _this.addScienceData.signoryId=res.data.businessType
          _this.addFinancialProduct.signoryId= res.data.businessType
          _this.addFinancialProduct.orgName=res.data.orgName
          if( _this.businessType!='technology_finance'){
            _this.getServiceConsultantList()
          }else{
            _this.getLoanType()
            _this.AssureType()
          }
          }
        }
      })
    },
    //产品编号获取
    getProductSerialNumber(){
      let _this = this;
      this.api.get({
      url: "getProductSerialNumber",
      data: {productType:1},
      callback: function(res) {
        if (res.code == "0000") {
            // console.log(res)
          _this.addScienceData.serialNumber= res.data
          _this.addFinancialProduct.serialNumber=res.data
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
      data: {orgId:this.addScienceData.orgId},
      callback: function(res) {
        if (res.code == "0000") {
          _this.counselorList= res.data.rows
          }
        }
      })
    },
    //改变 贷款类别
    changeloanCategoryName(name){
      this.addFinancialProduct.loanCategoryName=name
    },
    // 改变担保方式
    changeassure(name){
      this.addFinancialProduct.assureMethodName=name
    },
    uploadsuccess(file, fileList){
      // console.l
      if(this.businessType==='technology_finance'){
        this.addFinancialProduct.pictureUrl=file.data
      }else{
        this.addScienceData.pictureUrl=file.data
      }
    },
    //提交新增
    submit(){
      if(this.businessType==='technology_finance'){
        this.loading=true
        let _this = this;                                  
        this.api.post({               
        url: "upShelfFeatureProduct",
        data: this.addFinancialProduct,
        callback: function(res) {
          if (res.code == "0000") {
              _this.$message.success("新增成功")
               _this.loading=false 
              _this.$router.go(-1)
            }else{
             _this.$message.error(res.result)
             _this.loading=false 
            }
          }
        }) 
      }else {
        let _this = this; 
        this.loading=true
        this.api.post({               
        url: "addFeatureService",
        data: this.addScienceData,
        callback: function(res) {
          if (res.code == "0000") {
              // console.log(res)
              _this.$message.success("新增成功")
               _this.loading=false 
              _this.$router.go(-1)
            }else{
             _this.$message.error(res.result)
             _this.loading=false 
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
  .addScience{
    width: 100%;
    // 大标题
    .putaway_title{
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
    .addScience_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      border-radius: 5px;
      .addScience_form{
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
 
          .el-upload--picture-card{
            width: 100px;
            height: 100px;
            line-height: 100px;
          }
          .el-upload-list--picture-card .el-upload-list__item{
          width:100px;
          height: 100px;
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
          line-height:40px;
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
          margin-bottom: 25px;
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

<template>
  <div class="productPutaway" v-loading="loading">
    <div class="putaway_title">
      <div>{{this.$route.meta.title}}</div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <div class="putaway_main">
      <div class="putaway_form" v-if="businessType!='technology_finance'">
        <el-form label-position="right" label-width="100px" >
          <div :model="productDetail" class="">
            <el-form-item label="业务领域：">
              <span>{{businessTypeName}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="服务专员：">
              <el-select v-model="advisorAccount" multiple placeholder="请选择">
                <el-option :label="counseloritem.advisorName" :value="counseloritem.advisorAccount" v-for="(counseloritem,counselorindex) in counselorList" :key="counselorindex">
                </el-option>
              </el-select>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="产品名称：">
              <el-select v-model="templateId" placeholder="请选择产品名称" clearable @change="changeProname">
                <el-option :label="proitem.productName" :value="proitem.productId" v-for="(proitem,proindex) in productNameList" :key="proindex"></el-option>
              </el-select>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="产品编号：">
              <span>{{productDetail.serialNumber}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="参考价格：">
              <span>{{productDetail.referPrice}} </span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="产品图片：">
              <img :src="productDetail.pictureUrl" alt="">
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="服务周期：">
              <span>{{productDetail.serviceCycle}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="产品描述：">
              <div v-html="productDetail.productDetails"></div>
            </el-form-item>
          </div>
        </el-form>
      </div>
      <div class="putaway_form" v-else>
        <el-form label-position="right" label-width="150px" >
          <div :model="productDetail" class="">
            <el-form-item label="业务领域：">
              <span>{{productDetail.signoryName}} </span>
            </el-form-item>
          </div>
           <div>
            <el-form-item label="产品名称：">
              <el-select v-model="templateId" placeholder="请选择产品名称" clearable @change="changeProname">
                <el-option :label="proitem.productName" :value="proitem.productId" v-for="(proitem,proindex) in productNameList" :key="proindex"></el-option>
              </el-select>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品编号：">
              <span >{{productDetail.serialNumber}}</span>
            </el-form-item>
          </div>
         <div :model="productDetail" class="">
            <el-form-item label="参考利率范围：">
              <span>{{productDetail.refRateMin}}%-{{productDetail.refRateMax}}%</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否网贷直联：">
              <span>{{productDetail.isOnlineLoan|status}} </span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否政策性产品：">
              <span>{{productDetail.isPolicyPro|status}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否通用产品：">
              <span>{{productDetail.isGeneralPro|status}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否人民币：">
              <span>{{productDetail.isRmb|status}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="贷款类别：">
              <span>{{productDetail.loanCategoryName}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="贷款期限：">
              <span>{{productDetail.loanTermMin}}个月-{{productDetail.loanTermMax}}个月</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="担保方式：">
              <span>{{productDetail.assureMethodName}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否政策性产品：">
              <span>{{productDetail.isPolicyPro|status}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品图片：">
              <img :src="productDetail.pictureUrl" alt="">
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品特点：">
              <span>{{productDetail.productFeature}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="申请条件：">
              <div>{{productDetail.applyCondition}}</div>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="提交材料：">
              <span>{{productDetail.submitMaterial}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品特点：">
              <span>{{productDetail.productFeature}}</span>
            </el-form-item>
          </div>
        </el-form>
      </div>
      <div class="submit" @click="submit">提交</div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      productDetail:{},//产品详情
      counselorList:[],//服务专员列表
      productName:'',//产品名称
      // territory:0,
      productNameList:[],//产品名称列表
      advisorAccount:'',
      orgId:'',
      templateId:'',
      businessType:'',
      businessTypeName:"",
      loading:false
    }
  },
   filters: {
    status(status){
      if(status==="1"){
        return "是"
      }else{
        return "否"
      }
    }
  },
  mounted () {
    this.orgId=this.$route.query.orgid
    this.getType()
  },
  //territory为0是科技金融，为1是非科技金融
  methods: {
    //通过id判断是否科技金融
    getType(){
      let _this = this;
      this.api.get({
      url: "getActivityDetailsFm",
      data: {orgId:this.orgId},
      callback: function(res) {
        if (res.code == "0000") {
          _this.businessType= res.data.businessType
          _this.businessTypeName= res.data.businessTypeName
          if(_this.businessType=='technology_finance'){
            _this.getShelfProductList()
          }else{
            _this.getShelfProductList()
            _this.getServiceConsultantList()
          }
          }
        }
      })
    },
    // 获取产品名称列表公用
    getShelfProductList(){
      let _this = this;
      this.api.get({
      url: "getShelfProductList",
      data: {orgId:this.orgId},
      callback: function(res) {
        if (res.code == "0000") {
          if(res.data.length!=0){
            _this.productNameList= res.data
            _this.templateId=res.data[0].productId
            if(_this.businessType=='technology_finance'){
                _this.getFinancialProductDetails()
              }else{
                _this.getProductDetails()
              }
            }
          }
        }
      })
      
    },
    // 获取服务专员列表（非科技金融）
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
    // 获取服务产品详情（非科技金融）
    getProductDetails(){
      let _this = this;
      this.api.get({
      url: "findProductDetails",
      data: {productId:this.templateId},
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          _this.productDetail= res.data.info
          }
        }
      })
    },
    // 获取服务产品详情（科技金融）
    getFinancialProductDetails(){
      let _this = this;
      this.api.get({
      url: "getFinancialProductDetails",
      data: {productId:this.templateId},
      callback: function(res) {
        if (res.code == "0000") {
          _this.productDetail= res.data
          }
        }
      })
    },
    //改变产品名称
    changeProname(val){
      if(this.templateId===''){
        this.productDetail={}
      }else{
        if(this.businessType=='technology_finance'){
          //调用科技金融接口
          this.getFinancialProductDetails()
        }else{
          this.getProductDetails()
        }
      }
    },
    //上架
    submit(){
      this.loading=true
      if(this.businessType=='technology_finance'){
        let _this = this
        this.api.post({
        url: "upShelfCommonProduct",
        data: {
          orgId:this.orgId,
          templateId:this.templateId
        },
        callback: function(res) {
          if (res.code == "0000") {
              _this.loading=false
              _this.$message.success("上架成功")
              _this.$router.back(-1)
            }else{
            _this.loading=false 
             _this.$message.error(res.result)
            }
          }
        })
      }else{
        let _this = this
        _this.templateId.toString()
        this.api.post({
        url: "upShelfCommonService",
        data: {
          advisorAccount:this.advisorAccount.toString(),
          orgId:this.orgId,
          templateId:this.templateId
        },
        callback: function(res) {
          if (res.code == "0000") {
              _this.loading=false
              _this.$message.success("上架成功")
              _this.$router.back(-1)
            }else{
               _this.loading=false 
             _this.$message.error(res.result)
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
  .productPutaway{
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
        padding:8px 11px;
        font-size: 14px;
        color:#00a041;
        cursor: pointer;
      }
    }
    // 主体
    .putaway_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      border-radius: 5px;
      // 表单
      .putaway_form{
        width: 43%;
        margin: 0 auto;
        img{
          width: 100px;
          height: 100px;
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
        input:focus{
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



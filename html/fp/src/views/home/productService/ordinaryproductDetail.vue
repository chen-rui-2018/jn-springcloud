<template>
  <div class="ordinary_product_detial"  >
    <div class="detial_title">
      <div>{{this.$route.meta.title}}</div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <div class="detial_main">
      <div class="detial_form" v-if="businessType!='technology_finance'">
        <el-form label-position="right" label-width="100px" >
          <div :model="productDetail" class="">
            <el-form-item label="业务领域：">
              <span>{{signoryName}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="服务专员：">
              <span>{{productDetail.advisorName}}</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="产品名称：">
              <span>{{productDetail.productName}}</span>
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
      <div class="detial_form" v-else>
        <el-form label-position="right" label-width="150px" >
          <div :model="productDetail" class="">
            <el-form-item label="业务领域：">
              <span>{{productDetail.signoryName}} </span>
            </el-form-item>
          </div>
           <div>
            <el-form-item label="产品名称：">
              <span>{{productDetail.productName}} </span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品编号：">
              <span>{{productDetail.serialNumber}}</span>
            </el-form-item>
          </div>
         <div :model="productDetail" class="">
            <el-form-item label="参考利率范围：">
              <span>{{productDetail.refRateMin}}-{{productDetail.refRateMax}} </span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否网贷直联：">
              <span>{{productDetail.isOnlineLoan}} </span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否政策性产品：">
              <span>{{productDetail.isPolicyPro}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否通用产品：">
              <span>{{productDetail.isGeneralPro}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否人民币：">
              <span>{{productDetail.isRmb}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="贷款类别：">
              <span>{{productDetail.loanCategoryName}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="贷款期限：">
              <span>{{productDetail.loanTermMin}}-{{productDetail.loanTermMax}} </span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="担保方式：">
              <span>{{productDetail.assureMethodName}}</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否政策性产品：">
              <span>{{productDetail.isPolicyPro}}</span>
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
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      // loading:true,
      productDetail:{},//产品详情
      productNameList:[],//产品名称列表
      advisorAccount:'',
      orgId:'',
      templateId:0,
      businessType:'',
      signoryName:''
    }
  },
  mounted () {
    this.orgId=this.$route.query.orgid
    this.templateId=this.$route.query.productId
    this.signoryName=this.$route.query.signoryName
    this.getType()
  },
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
          if(_this.businessType==='technology_finance'){
            _this.getFinancialProductDetails()
          }else{
            _this.getProductDetails()
          }
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
          if(res.data!==null){
            _this.productDetail= res.data.info
          }
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
          // console.log(res)
          _this.productDetail= res.data
          }
        }
      })
    }
  }
}
</script>
<style lang="scss">
    .el-select-dropdown__item.selected{
      color:#00a041;
    }
  .ordinary_product_detial{
    width: 100%;
    // 大标题
    .detial_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      font-size: 13px;
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
    .detial_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      border-radius: 5px;
      // 表单
      .detial_form{
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
    }
  }
</style>

<template>
  <div class="ordinary_product_edit"  >
    <div class="edit_title">
      <div>{{this.$route.meta.title}} </div>
      <div @click="$router.go(-1)">返回列表</div>
    </div>
    <div class="edit_main">
      <div class="edit_form">
        <el-form label-position="right" label-width="100px" >
          <div :model="productDetail" class="">
            <el-form-item label="业务领域：">
              <span>非科技金融</span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="服务顾问：">
              <el-select v-model="advisorAccount" multiple placeholder="请选择">
                <el-option :label="counseloritem.advisorName" :value="counseloritem.advisorAccount" v-for="(counseloritem,counselorindex) in counselorList" :key="counselorindex">
                </el-option>
              </el-select>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="产品名称：">
              <span>{{productDetail.productName}}</span>
            </el-form-item>
          </div>
          <div class="">
            <el-form-item label="产品编号">
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
      <div class="submit" @click="submit">提交</div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      // loading:true,
      productDetail:{},//产品详情
      counselorList:[],//服务顾问列表
      productName:'',//产品名称
      advisorAccount:'',
      orgId:'',
      templateId:0,
      businessType:''
    }
  },
  mounted () {
    this.orgId=this.$route.query.orgid
    this.templateId=this.$route.query.productId
    this.getServiceConsultantList()
    this.getProductDetails()
  },
  methods: {
    //顾问
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
    //编辑
    submit(){
      let _this = this
      _this.templateId.toString()
      this.api.post({
      url: "updateCommonProduct",
      data: {
        advisorAccount:this.advisorAccount.toString(),
        productId:this.templateId
      },
      callback: function(res) {
        if (res.code == "0000") {
            _this.$message.success("编辑成功")
            _this.$router.back(-1)
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
  .ordinary_product_edit{
    width: 100%;
    // 大标题
    .edit_title{
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
    .edit_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      border-radius: 5px;
      // 表单
      .edit_form{
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

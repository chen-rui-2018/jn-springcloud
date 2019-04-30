<template>
  <div class="productPutaway">
    <div class="putaway_title">
      <div>常规产品上架</div>
      <div>返回列表</div>
    </div>
    <div class="putaway_main">
      <div class="putaway_form" v-if="territory===1">
        <el-form label-position="right" label-width="100px" >
          <div :model="productDetail" class="">
            <el-form-item label="业务领域：">
              <span></span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="服务顾问：">
              <span></span>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="产品名称：">
              <span></span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品编号">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="参考价格：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品图片：">
              <img src="@/assets/image/test2.png" alt="">
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="服务周期：">
              <span>848</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品描述：">
              <div>机构接受企业委托，对其核算的研发项目研究开发费用归集明细表进行鉴证，就其研发费用的发生和能否 税前加计扣除进行鉴证，并出具专项鉴证报告</div>
            </el-form-item>
          </div>
        </el-form>
      </div>
      <div class="putaway_form" v-else>
        <el-form label-position="right" label-width="150px" >
          <div :model="productDetail" class="">
            <el-form-item label="业务领域：">
              <span></span>
            </el-form-item>
          </div>
           <div>
            <el-form-item label="产品名称：">
              <span></span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品编号：">
              <span>55</span>
            </el-form-item>
          </div>
         <div :model="productDetail" class="">
            <el-form-item label="参考利率范围：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否网贷直联：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否政策性产品：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="* 是否通用产品：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="* 是否人民币：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="* 贷款类别：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="* * 贷款期限：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="* 担保方式：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="是否政策性产品：">
              <span>55</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品图片：">
              <img src="@/assets/image/test2.png" alt="">
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品特点：">
              <span>848</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="申请条件：">
              <div>机构接受企业委托，对其核算的研发项目研究开发费用归集明细表进行鉴证，就其研发费用的发生和能否 税前加计扣除进行鉴证，并出具专项鉴证报告</div>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="提交材料：">
              <span>848</span>
            </el-form-item>
          </div>
          <div :model="productDetail" class="">
            <el-form-item label="产品特点：">
              <span>848</span>
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
      productDetail:{},
      counselor:{ },//服务顾问
      productName:'',//产品名称
      territory:0
    }
  }
}
</script>
<style lang="scss">
  .productPutaway{
    width: 100%;
    // 大标题
    .putaway_title{
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
    .putaway_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      // 表单
      .putaway_form{
        width: 43%;
        margin: 0 auto;
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

<template>
  <div class="propagandaDetails">
    <div class="ordinary_title font16">
      <div>宣传详情</div>
    </div>
    <div class="ordinary_content">
       <el-form label-width="140px" class="postJobInfo">
  <el-form-item label="发布平台:" prop="post">
    <span>{{issuePlatform}}</span>
  </el-form-item>
  <el-form-item label="生效日期:">
    <span>{{effectiveDate}}</span>
  </el-form-item>
  <el-form-item label="失效日期:">
   <span>{{invalidDate}}</span>
  </el-form-item>
  <el-form-item label="宣传产品:" >
    <span>{{propagandaTitle}}</span>
  </el-form-item>
  <el-form-item label="宣传详情:" >
     <span>{{propagandaDetails}}</span>
  </el-form-item>
  <el-form-item label="宣传海报:" >
      <span v-if="posterUrl" class="posterUrlBtn" @click="lookPoster(posterUrl)">点击查看</span>
      <span v-if="!posterUrl"  >暂无海报图片</span>
     <!-- <span>{{posterUrl}}</span> -->
  </el-form-item>
  <el-form-item label="宣传区域:" >
      <img :src="propagandaAreaUrl" alt="">
  </el-form-item>
   <el-form-item label="宣传费用（元）:" >
    <span>{{propagandaFee}}</span>
  </el-form-item>
 <div class="business_footer" @click="toEnterprisePropaganda">
    返回
  </div>
</el-form>
    </div>
    <el-dialog
  title="海报图片"
  :visible.sync="dialogVisible"
  width="50%">
  <img :src="posterUrl" alt="海报图片" style="width:100%;height:200px;">
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">返 回</el-button>
  </span>
</el-dialog>
  </div>
</template>
<script>
export default {
  data () {
    return {
        dialogVisible:false,
        propagandaId:'',
      issuePlatform:'',
        effectiveDate:'',
        invalidDate:'',
        propagandaTitle:'',
        propagandaDetails:'',
        posterUrl:'',
        propagandaAreaUrl:'',
       propagandaFee :''
    }
  },
  mounted(){
      this.initList()
  },
  methods: {
    //   初始化
      initList(){
         this.propagandaId=this.$route.query.propagandaId
          this.api.get({
     url:'getBusinessPromotionDetails',
     data:{propagandaId :this.propagandaId},
     callback:(res=>{
         console.log(res)
         this.issuePlatform=res.data.issuePlatform
         this.effectiveDate=res.data.effectiveDate
         this.invalidDate=res.data.invalidDate
         this.propagandaTitle=res.data.propagandaTitle
         this.propagandaDetails=res.data.propagandaDetails
         this.posterUrl=res.data.posterUrl
         this.propagandaAreaUrl=res.data.propagandaAreaUrl
         this.propagandaFee=res.data.propagandaFee
     })
 })
      },
    //   查看海报图片
      lookPoster(posterUrl){
         if(!posterUrl){
             this.$message.error('此宣传没有宣传海报')
         }else{
        this.dialogVisible=true
         }
      },
    toEnterprisePropaganda(){
      this.$router.push({name:'enterprisePropaganda'})
    }
  }
}
</script>

<style lang="scss">
  .propagandaDetails{
    width: 100%;
    color:#999;
    .el-form-item__label{
        margin-right:30px;
        line-height: 26px;
    }
    .posterUrlBtn{
        color:#00A041;
        width:46px;
height:11px;
font-size:11px;
font-family:MicrosoftYaHei;
font-weight:400;
color:rgba(0,160,65,1);
line-height:20px;
cursor: pointer;
    }
    .ordinary_title{
      background-color: #fff;

      padding:24px 28px;
      // font-size: 13px;
      border-radius: 5px;
    }
    .ordinary_content{
        margin-top:14px;
        background: #fff;
        padding:36px 0px;
        .postJobInfo{
            width: 50%;
            margin: 0 auto;

            .el-form-item__content,.el-select{
                width: 266px;
            }
             .el-textarea__inner{
                 width: 348px;
                min-height: 100px !important;
                background: #fff;
            }
            .el-form-item__content{
                line-height: 26px;
            }
        }
         .business_footer {
    margin: 0 auto;
    margin-top: 58px;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    height: 29px;
    line-height: 29px;
    width: 90px;
    color: #41d787;
    background: rgba(236, 252, 242, 1);
    border: 1px solid rgba(65, 215, 135, 1);
    margin-bottom: 17px;
  }
    }
  }
</style>

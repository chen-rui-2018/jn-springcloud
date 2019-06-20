<template>
  <div class="publictyProduct">
    <div class="ordinary_title font16">
      <div>宣传费用规则</div>
    </div>
    <div class="ordinary_content">
        <div style=" border-bottom: 1px solid #ccc;"><span class="active">费用规则</span> </div>
        <div v-html="proFeeRuleDetails" class=" Costrules"></div>
    <!-- <div class=" Costrules">
        一、《实施意见》出台的背景意义<br>
  <span></span>  为落实“产业兴市”战略，加快推进新旧动能转换，聚焦新技术、新产业、新业态、新模式，突出创新引领和高成长性，帮助和支持科技创新型企
业实现快速膨胀，尽快成长为骨干企业、领军企业，形成引领全市经济发展的新动能。根据市领导要求，在参照先进市的经验、广泛征求意见的基础上
出台了《实施意见》
</div><div class=" Costrules">
二、《实施意见》的主要内容<br>
 <span></span>  《实施意见》从提高社会荣誉、支持创新发展、优化发展环境、培植服务机制等八个方面，整合资源要素、政策措施、领导精力等向“创新50强”
企业聚集，强调实行梯次培育，针对不同发展阶段的科技创新型企业，提供差异化服务，切实解决企业最关注的发展资金和空间等痛点难点问题，帮助
和支持创新型企业建立新型科研体制、运行机制，实现规模的快速膨胀，带动全市科技创新型企业的发展。
    </div> -->
 <div class="business_footer" @click="toPublishingPropaganda">
        返回
  </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
        proFeeRuleDetails:''

    }
  },
 mounted () {
   this.initList()
 },
  methods: {

    toPublishingPropaganda(){
      this.$router.push({name:'publishingPropaganda'})
    },
    initList(){
        this.proFeeRuleDetails=this.$route.query.proFeeRuleDetails
        console.log(this.proFeeRuleDetails)
          // this.api.get({
          //         url:'getPropagandaFeeRulesList',
          //       //  data:{recruitId : this.jobForm.id},
          //        callback:(res=>{
          //            console.log(res)
          //       // this.jobForm.post=res.data.post
          //       // this.jobForm.num=res.data.num
          //       // this.jobForm.details=res.data.details
          //       // this.jobForm.salary=res.data.salaryName
          //       // this.jobForm.type=res.data.typeName
          //         })
          //     })
      }
  }
}
</script>

<style lang="scss">
   .active{
            //    border: none;
            margin-top:14px;
            font-size: 13px;
            padding:9px 8px 14px 8px;
            display: inline-block;
    background: #fff;
    color: #00A041;
    border-radius: unset;
    border-bottom: 3px solid rgb(0, 160, 65);
        }
        .Costrules{
            margin-top:22px;
            color:#333;
            line-height: 21px;
            margin-bottom: 20px;
            >span{
              display:inline-block;
              width:20px;
              height:10px;
            }
        }
  .publictyProduct{
    width: 100%;
    .ordinary_title{
      background-color: #fff;

      padding:24px 28px;
      // font-size: 13px;
      border-radius: 5px;
    }
    .ordinary_content{
        margin-top:14px;
        background: #fff;
        padding:0px 29px 30px 29px;
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

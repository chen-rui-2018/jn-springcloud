<template>
  <div class="dpInfo">
    <header>{{ title }}</header>
    <p>全省排名 : 第<span>{{ ranking }}</span>名/共 <span>12452</span>家 </p>
    <p>今年新增 : <span>xxx</span>家 </p>
    <p>年度目标 : <span>xxxx</span>家 </p>
    <el-row :gutter="10">
      <el-col :span="16" ><div class="grid-content bg-purple chart_left" ><i/></div></el-col>
      <el-col :span="8"><div class="grid-content bg-purple chart_right">
      <pie-chart :piedata="piedata" width="100%" height="120px"/> </div></el-col>
    </el-row>
  </div>
</template>

<script>
import PieChart from './pieChart'
export default {
  components: {
    PieChart
  },
  props: {
    // props的验证规则
    title: { type: String, default: '' },
    ranking: { type: String, default: '' },
    piedata: {
      type: Array,
      default: function() {
        return []
      }
    }
  }
}
</script>

<style lang="scss" scoped>
   .dpInfo{
       padding: 20px;
       border-right: 1px solid #eee;
       border-bottom: 1px solid #eee;
       header{
           padding-bottom: 20px;
           font-size: 18px;
           color: #2ca9f8
       }
       p{
           line-height: 24px;
           color: #666;
       }
       .chart_left{
           margin-top: 10px;
           position: relative;
           background: url('../../../assets/images/cpa-1.jpg') repeat;
        //    width: 190px;
           height: 120px;
           background-size: 10% 25%;
           i{
               position: absolute;
               top: -2px;
               left: 0;
               width: 10%;
               height: 31px;

             background: url('../../../assets/images/cpa-2.jpg') center center / 100% 31px no-repeat;
           }
       }
       .chart_right{
           padding-top: 20px;
       }
   }
</style>

<template>
  <div class="dpInfo">
    <header>{{ title }}</header>
    <p>全省排名 : 第<span>{{ ranking }}</span>名/共 <span>{{ countNumber }}</span>家 </p>
    <p>今年新增 : <span>xxx</span>家 </p>
    <p>年度目标 : <span>xxxx</span>家 </p>
    <el-row :gutter="10">
      <el-col :span="16" ><div ref="box" class="grid-content bg-purple chart_left" ><i :style="styleObj" /></div></el-col>
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
    },
    countNumber: {
      type: String, default: '12452'
    }
  },
  data() {
    return {
      styleObj: {
        left: 0,
        top: 0
      }
    }
  },
  mounted() {
    // 获取排名和所有公司的比例     *30是因为有30个小人  用来判断换行
    const lf = Math.floor(parseInt(this.ranking) / parseInt(this.countNumber) * 30)
    // console.log(this.$refs.box.offsetWidth)
    // console.log(this.ranking)
    // console.log(this.countNumber)
    // const width = this.$refs.box.offsetWidth * 0.1 // 获取元素的宽度  *0.1是每个小人占宽度的10%
    if (lf <= 10) { // 第一行
      this.styleObj.left = lf * 19 + 'px'
    } else if (lf > 10 && lf <= 20) { // 第二行
      this.styleObj.left = (lf - 10) * 19 + 'px'
      this.styleObj.top = 40 + 'px'
    } else if (lf > 20) { // 第三行
      this.styleObj.left = (lf - 20) * 19 + 'px'
      this.styleObj.top = 83 + 'px'
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
           width: 190px;
           height: 120px;
           background-size: 10% 35%;
          //  width: 190px;
           i{
               position: absolute;
               top: -2px;
               left: 0;
               width: 10%;
                // width: 19px;
               height: 40px;

             background: url('../../../assets/images/cpa-2.jpg') center center / 100% 40px no-repeat;
           }
       }
       .chart_right{
           padding-top: 20px;
       }
   }
</style>

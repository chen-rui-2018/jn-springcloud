<template>
  <div class="development">
    <!-- 标题 -->
    <div class="development-title">
      <el-row :gutter="20">
        <el-col :span="18">
          <div class="grid-content bg-purple title">白下智慧园区发展综合评分 :
            <span>96</span>分
            <i class="el-icon-star-on" />
            <i class="el-icon-star-on" />
            <i class="el-icon-star-on" />
            <i class="el-icon-star-on" />
            <i class="el-icon-star-off" />
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <div class="block text-right" >
              <el-date-picker v-model="value" type="month" />
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="development_chart">
      <el-row :gutter="15">
        <!-- 名次走势图 -->
        <el-col :xs="24" :sm="24" :lg="12" :md="12" :span="12"><div class="grid-content bg-purple bgc">
          <!-- 标题组件 -->
          <title-chart :message1="title1"/>
          <trend-chart/>
        </div>
        </el-col>
        <!-- 发展排名图 -->
        <el-col :xs="24" :sm="24" :lg="12" :md="12" :span="12"><div class="grid-content bg-purple-light bgc">
          <!-- 标题组件 -->
          <title-chart :message2="title2"/>
          <ranking-chart/>
        </div>
        </el-col>
      </el-row>
    </div>
    <div class="development_content ">
      <el-row>
        <el-col v-for="(item,index) in dataList " :key="index" :xs="12" :sm="12" :lg="8" >
          <div class="grid-content bg-purple">
            <dpInfo :title="item.title" :piedata="item.piedata" :ranking="item.ranking"/>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import TrendChart from './components/trendChart'
import TitleChart from './components/titleChart'
import RankingChart from './components/rankingChart'
import DpInfo from './components/dpInfo'
export default {
  components: {
    TrendChart,
    TitleChart,
    RankingChart,
    DpInfo
  },
  data() {
    return {
      value: '2018-5',
      title1: '综合发展名次走势',
      title2: '综合发展TOP20 排名',
      // 在交互中  设置为空值  然后通过computed计算属性 给他重新赋值
      dataList: [
        { title: '园区招商', ranking: '132', piedata: [{ value: 335, name: '' }, { value: 310, name: '' }] },
        { title: '孵化企业', ranking: '14', piedata: [{ value: 315, name: '' }, { value: 310, name: '' }] },
        { title: '发展高新技术企业', ranking: '20', piedata: [{ value: 155, name: '' }, { value: 310, name: '' }] },
        { title: '新上市企业', ranking: '35', piedata: [{ value: 90, name: '' }, { value: 310, name: '' }] },
        { title: '研发投入占比销售收入', ranking: '20', piedata: [{ value: 655, name: '' }, { value: 310, name: '' }] },
        { title: '科技拨款占比财政支出', ranking: '20', piedata: [{ value: 315, name: '' }, { value: 310, name: '' }] },
        { title: '高新技术收入占比', ranking: '20', piedata: [{ value: 65, name: '' }, { value: 310, name: '' }] },
        { title: '企业本科以上学历占比', ranking: '20', piedata: [{ value: 95, name: '' }, { value: 310, name: '' }] },
        { title: '今年新增专利', ranking: '20', piedata: [{ value: 135, name: '' }, { value: 310, name: '' }] },
        { title: '科技成果转移', ranking: '20', piedata: [{ value: 125, name: '' }, { value: 310, name: '' }] },
        { title: '万元增量能耗', ranking: '20', piedata: [{ value: 455, name: '' }, { value: 310, name: '' }] },
        { title: '今年企业已纳税额', ranking: '20', piedata: [{ value: 400, name: '' }, { value: 310, name: '' }] }
      ]

    }
  }
}
</script>

<style lang="scss" scoped>
.development {
  padding: 15px;
  background-color: #f2f2f2;
  .development-title {
    .title {
      font-size: 34px;
      span {
        color: #2ca9f8;
      }
      i {
        color: #ffb800;
      }
    }
  }
  .development_content{
    background-color: #fff;
  }
  .development_chart{
      margin: 15px 0;

  }
}
</style>

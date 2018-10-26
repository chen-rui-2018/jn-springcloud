
<template>

  <div class="chart-container">
    <div class="c-box">
      <el-form ref="form" :model="form" label-width="40px">
        <el-form-item label="时间">
          <el-col :span="3">
            <el-date-picker v-model="value" type="date" placeholder="选择日期" style="width: 100%;"/>
          </el-col>
        </el-form-item>
      </el-form>
    </div>
    <div class="c-box">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>照明用电昨夜分时统计</span>
          <div style="float:right;">昨夜同比去年同期节约用电<span class="text-green">{{ economize }}</span>°，下降<span class="text-green">{{ rate }}</span>，截至目前，累计节约<span class="text-green">{{ total }}°</span></div>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{ '列表内容12s1 ' + o }}
        </div>
      </el-card>
    </div>
    <chart height="100%" width="100%"/>
  </div>
</template>

<script>
import Chart from '@/components/Charts/mixChart'

export default {
  name: 'MixChart',
  components: { Chart },
  data() {
    return {

      economize: 614,
      rate: '5%',
      total: '10万'

    }
  }
}
</script>

<style scoped>
.text-green {
  color: #5fca09;
}
.c-box {
  margin: 15px;
}

.chart-container {
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
}
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}
</style>


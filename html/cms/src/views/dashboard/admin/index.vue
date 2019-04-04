<template>
  <div class="dashboard-editor-container">

    <github-corner style="position: absolute; top: 0px; border: 0; right: 0;"/>
    <!-- 四小块 -->
    <panel-group @handleSetLineChartData="handleSetLineChartData"/>

    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
      <!-- //曲线图 -->
      <line-chart :chart-data="lineChartData"/>
      <line-chart :chart-data="lineChartData2"/>
      <line-chart :chart-data="lineChartData3"/>
      <line-chart :chart-data="lineChartData4"/>
    </el-row>
    <!-- 三个表格图 -->
    <el-row :gutter="32">
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <raddar-chart/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart/>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <bar-chart/>
        </div>
      </el-col>
    </el-row>

    <el-row :gutter="8">
      <el-col :xs="{span: 24}" :sm="{span: 24}" :md="{span: 24}" :lg="{span: 12}" :xl="{span: 12}" style="padding-right:8px;margin-bottom:30px;">
        <transaction-table/>
      </el-col>
      <el-col :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 6}" style="margin-bottom:30px;">
        <todo-list/>
      </el-col>
      <el-col :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 6}" style="margin-bottom:30px;">
        <box-card/>
      </el-col>
    </el-row>

  </div>
</template>

<script>
import GithubCorner from '@/components/GithubCorner'
import PanelGroup from './components/PanelGroup'
import LineChart from './components/LineChart'
import RaddarChart from './components/RaddarChart'
import PieChart from './components/PieChart'
import BarChart from './components/BarChart'
import TransactionTable from './components/TransactionTable'
import TodoList from './components/TodoList'
import BoxCard from './components/BoxCard'

const lineChartData = {
  newVisitis: {
    expectedData: [100, 120, 161, 134, 105, 160, 165],
    actualData: [120, 82, 91, 154, 162, 140, 145]
  },
  messages: {
    expectedData: [200, 192, 120, 144, 160, 130, 140],
    actualData: [180, 160, 151, 106, 145, 150, 130]
  },
  purchases: {
    expectedData: [80, 100, 121, 104, 105, 90, 100],
    actualData: [120, 90, 100, 138, 142, 130, 130]
  },
  shoppings: {
    expectedData: [130, 140, 141, 142, 145, 150, 160],
    actualData: [120, 82, 91, 154, 162, 140, 130]
  }
}

export default {
  name: 'DashboardAdmin',
  components: {
    GithubCorner,
    PanelGroup,
    LineChart,
    RaddarChart,
    PieChart,
    BarChart,
    TransactionTable,
    TodoList,
    BoxCard
  },
  data() {
    return {
      lineChartData: lineChartData.newVisitis,
      lineChartData2: lineChartData.messages,
      lineChartData3: lineChartData.purchases,
      lineChartData4: lineChartData.shoppings
    }
  },
  methods: {
    handleSetLineChartData(type) {
      this.lineChartData = lineChartData[type]
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}
</style>

<!--
<template>
  <div class="dashboard-editor-container">
    <div id="loading">正在加载中...</div>
    <iframe id="kskfpt" ref="iframe" src="" width="100%" height="0" frameborder="0" scrolling="auto" style="visibility: hidden;"/>
  </div>
</template>
<script>
import $ from 'jquery'
export default {
  mounted() {
    // iframe 自适应高度
    $('#kskfpt').height($(document.body).height() - 120)
    // 预先登录模式
    $('#kskfpt').attr('src', 'http://112.94.22.222:2381/noPasswordLogin.htm?username=' + localStorage.getItem('account') + '&password=123')
    let iframeNum = 0
    // iframe加载完成打开工作台
    var iframe = document.getElementById('kskfpt')
    if (iframe.attachEvent) {
      iframe.attachEvent('onload', function() {
      })
    } else {
      iframe.onload = function() {
        if (iframeNum === 0) {
          $('#kskfpt').attr('src', 'http://112.94.22.222:2381/platform/console/home.htm')
        } else {
          $('#kskfpt').css('visibility', 'visible')
          $('#loading').css('display', 'none')
        }
        iframeNum = iframeNum + 1
      }
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .dashboard-editor-container {
    padding: 1px;
    background-color: rgb(240, 242, 245);
    .chart-wrapper {
      background: #fff;
      padding: 1px 1px 0;
      margin-bottom: 1px;
    }
  }
</style>
-->

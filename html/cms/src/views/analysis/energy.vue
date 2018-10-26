<template>
  <div class="energy">
    <!-- 日期选择器 -->
    <div class="block">
      <el-date-picker v-model="value8" type="date" placeholder="选择日期" />
    </div>
    <!-- 照明统计图 -->
    <div class="zhaoming">
      <el-row class="count">
        <el-col :span="6">
          <div class="grid-content bg-purple ">照明用电昨夜分时统计</div>
        </el-col>
        <el-col :span="18" class="text-right">
          <div class="grid-content bg-purple-light " />昨夜同比去年同期节约用电
          <span>614°</span> ,下降
          <span>66%</span> ,截止目前,累计节约
          <span>20万°</span>
        </el-col>
      </el-row>
      <div class="chart-wrapper">
        <bar-chart/>
      </div>
    </div>
    <div class="yongdian">
      <el-row class="Info">
        <el-col :span="8">
        <div class="grid-content bg-purple" />用电分布一览</el-col>
        <el-col :span="8">
          <div class="grid-content bg-purple-light today">今日耗能
            <span>1293</span>
          </div>
        </el-col>
        <el-col :span="8" class="tubiao text-right">
          <span :class="[current1==1?'active':'']" @click="toChart">图</span>
          <span :class="[current1==0?'active':'']" @click="toTab">表</span>
          <!-- <el-radio-group v-model="tabPosition" style="margin-bottom: 30px;">
            <el-radio-button label="top">图</el-radio-button>
            <el-radio-button label="right">表</el-radio-button>
          </el-radio-group>
        </el-col> -->
        </el-col>
      </el-row>
      <div v-show="isshow1">
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="kongtiao" label="空调" />
          <el-table-column prop="zhaoming" label="照明" />
          <el-table-column prop="dianti" label="电梯" />
        </el-table>
      </div>
      <el-row v-show="!isshow1" :gutter="32">
        <!-- 用电类型图 -->
        <el-col :xs="24" :sm="24" :lg="12">
          <div class="chart-wrapper">
            <raddar-chart/>
          </div>
        </el-col>
        <!-- 公共用电 -->
        <el-col :xs="24" :sm="24" :lg="12">
          <div class="chart-wrapper">
            <pie-chart height="300px" />
          </div>
        </el-col>
      </el-row>
    </div>
    <!-- 十年用电统计 -->
    <div class="tenCount">
      <el-row class="Info">
        <el-col :span="12">
        <div class="grid-content bg-purple" />十年用电统计</el-col>
        <el-col :span="12" class="tubiao text-right">
          <span :class="[current2==1?'active':'']" @click="totenChart">图</span>
          <span :class="[current2==0?'active':'']" @click="totenTab">表</span>
        </el-col>
      </el-row>
      <div v-show="isshow2">
        <el-table :data="tableData2" border style="width: 100%">
          <el-table-column prop="2008" label="2008" />
          <el-table-column prop="2009" label="2009" />
          <el-table-column prop="2010" label="2010" />
          <el-table-column prop="2011" label="2011" />
          <el-table-column prop="2012" label="2012" />
          <el-table-column prop="2013" label="2013" />
          <el-table-column prop="2014" label="2014" />
          <el-table-column prop="2015" label="2015" />
          <el-table-column prop="2016" label="2016" />
          <el-table-column prop="2017" label="2017" />
        </el-table>
      </div>
      <div v-show="!isshow2" class="chart-wrapper">
        <tendar-chart />
      </div>
    </div>
    <!-- 楼宇用电 -->
    <div class="louyuyongdian">
      <el-row class="Info">
        <el-col :span="12">
        <div class="grid-content bg-purple" />楼宇用电实时排行</el-col>
        <el-col :span="12" class="tubiao text-right">
          <span :class="[current3==1?'active':'']" @click="tolouChart">图</span>
          <span :class="[current3==0?'active':'']" @click="tolouTab">表</span>
        </el-col>
      </el-row>
      <div v-show="isshow3">
        <el-table :data="tableData3" :span-method="objectSpanMethod" border style="width: 100%">
          <el-table-column prop="楼宇" label="楼宇" />
          <el-table-column prop="楼层" label="楼层" />
          <el-table-column prop="用电量" label="用电量" />
          <el-table-column prop="昨日环比" label="上月同期同比" />
          <el-table-column prop="上月同期同比" label="上月同期同比" />

        </el-table>
      </div>
      <el-row v-show="!isshow3" :gutter="32">
        <!-- 楼层用电类型图表-->
        <el-col :xs="24" :sm="24" :lg="12">
          <div class="chart-wrapper">
            <loudar-chart />
          </div>
        </el-col>
        <!-- 楼层用电图片 -->
        <el-col :xs="24" :sm="24" :lg="12" class="louyuImg" >
          <img src="@/assets/images/energy-1.jpg" alt="图片">
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
import RaddarChart from './components/RaddarChart'
import PieChart from './components/PieChart'
import BarChart from './components/BarChart'
import TendarChart from './components/TendarChart'
import LoudarChart from './components/LoudarChart'
export default {
  components: {
    RaddarChart,
    PieChart,
    BarChart,
    TendarChart,
    LoudarChart
  },
  data() {
    return {
      current1: 1,
      value8: '2018-10-20',
      isshow1: false,
      isshow2: false,
      isshow3: false,
      current2: 1,
      current3: 1,
      tableData: [
        {
          kongtiao: '1111',
          zhaoming: '323',
          dianti: '1656'
        }
      ],
      tableData2: [
        {
          2008: '1111',
          2009: '323',
          2010: '1656',
          2011: '1656',
          2012: '1656',
          2013: '1656',
          2014: '1656',
          2015: '1656',
          2016: '1656',
          2017: '1656'
        }
      ],
      tableData3: [
        {
          楼宇: '1号楼',
          楼层: '1层',
          用电量: '200度',
          昨日环比: '12%',
          上月同期同比: '12%'
        }, {
          楼宇: '1号楼',
          楼层: '2层',
          用电量: '200度',
          昨日环比: '12%',
          上月同期同比: '12%'
        }, {
          楼宇: '1号楼',
          楼层: '3层',
          用电量: '200度  ',
          昨日环比: '12%',
          上月同期同比: '12%'
        }, {
          楼宇: '1号楼',
          楼层: '4层',
          用电量: '200度',
          昨日环比: '12%',
          上月同期同比: '12%'
        }
      ]
    }
  },
  methods: {
    objectSpanMethod({ row, column, rowIndex, columnIndex }) {
      if (columnIndex === 0) {
        if (rowIndex === 0) {
          return [4, 1]
        } else {
          return {
            rowspan: 0,
            colspan: 0
          }
        }
      }
    },

    // 显示用电类型图
    toChart() {
      this.isshow1 = false
      this.current1 = 1
    },
    // 用电类型表
    toTab() {
      this.isshow1 = true
      this.current1 = 0
      console.log(this.current)
    },
    // 显示十年用电图
    totenChart() {
      this.isshow2 = false
      this.current2 = 1
    },
    // 显示使用用电表
    totenTab() {
      this.isshow2 = true
      this.current2 = 0
    },
    // 显示楼宇用电图
    tolouChart() {
      this.isshow3 = false
      this.current3 = 1
    },
    // 楼宇用电表
    tolouTab() {
      this.isshow3 = true
      this.current3 = 0
    }
  }
}
</script>

<style  lang="scss" scoped>
.energy {
  padding: 15px;
  background-color: #f2f2f2;
  .Info {
      padding: 15px;
      .tubiao {
        font-size: 0;
        span {
          display: inline-block;
          text-align: center;
          line-height: 30px;
          font-size: 16px;
          margin-left: -1px;
          width: 50px;
          height: 30px;
          border: 1px solid #ccc;
        }
      }
      .today {
        font-size: 20px;
        font-weight: 700;
        text-align: center;
        span {
          color: #f33;
        }
      }
    }
    .active {
      background-color: #2ca9f8;
      color: #fff;
    }
  .zhaoming {
    margin: 15px 0;
    background-color: #fff;

    .count {
      border-bottom: 1px solid #f6f6f6;
      padding: 15px;
      span {
        color: #5fca09;
      }
    }
  }
  .yongdian {
    background-color: #fff;
  }
  .tenCount {
    margin: 15px 0;
    background-color: #fff;
  }
  .louyuyongdian {
    background-color: #fff;
    .Info {
      padding: 15px;
      border-bottom: 1px solid #f6f6f6;
    }
    .louyuImg {
      margin-top: 60px;
      img{
        display: block;
        width: 100%;
      }
    }
  }
}
</style>

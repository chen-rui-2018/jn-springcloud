<template>
  <div class="index">
    <header>
      <el-row :gutter="20">
        <el-col :span="19">
          <div class="grid-content bg-purple">
            <el-button :type="current1==0?'primary':''" round @click="rankUp">诚信信用最高TOP5</el-button>
            <el-button :type="current1==1?'primary':''" round @click="rankDown">诚信信用最低TOP5</el-button>
          </div>
        </el-col>
        <el-col :span="5">
          <div class="grid-content bg-purple">
            <el-input id="input" v-model="input21" placeholder="搜索公司名称">
              <i slot="suffix" class="el-input__icon el-icon-search" />
            </el-input>
          </div>
        </el-col>
      </el-row>
    </header>
    <!-- Corporate_rk  企业排名的缩写 -->
    <div class="Corporate_rk">
      <el-row type="flex" class="row-bg ">
        <el-col v-for="(item,index) in enterpriseData " :key="index" class="Corporate_content">
          <div class="Corporate_Info">
            <img :src="item.enterpriseLogo" alt="企业logo">
            <span>{{ item.enterpriseName }}</span>
          </div>
          <p>
          <span>{{ item.enterpriseScale }}</span>分</p>
          <h4>
            园区排名 : 第<!--
           --><span>{{ item.enterpriseRanking }}</span>名</h4>
          <div class="Corporate_ft" @click="toDetails">详细
            <i class="el-icon-arrow-right" />
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="Corporate_chart">
      <div class="chart_title">
        <el-row>
          <el-col :span="10">
            <div>信用分值</div>
          </el-col>
          <el-col :span="10">
            <div>企业信用排行</div>
          </el-col>
          <el-col :span="4">
            <div class="text-right" @click="toDetails">查看表格
              <i class="el-icon-arrow-right" />
            </div>
          </el-col>
        </el-row>
      </div>
      <line-chart/>
    </div>
  </div>
</template>

<script>
import lineChart from './lineChart'
export default {
  components: {
    lineChart
  },
  data() {
    return {
      input21: '',
      current1: 0,
      enterpriseData: []
    }
  },
  mounted() {
    const upList = [
      {
        enterpriseName: '云创大数据',
        enterpriseLogo: '/static/corporate/logo/1-1.png',
        enterpriseScale: '125',
        enterpriseRanking: '1'
      },
      {
        enterpriseName: '紫光西部数据',
        enterpriseLogo: '/static/corporate/logo/1-2.png',
        enterpriseScale: '115',
        enterpriseRanking: '2'
      },
      {
        enterpriseName: '艾科朗克',
        enterpriseLogo: '/static/corporate/logo/1-4.png',
        enterpriseScale: '113',
        enterpriseRanking: '3'
      },
      {
        enterpriseName: '拓视普',
        enterpriseLogo: '/static/corporate/logo/2-3.png',
        enterpriseScale: '112',
        enterpriseRanking: '4'
      },
      {
        enterpriseName: '佳汇科技',
        enterpriseLogo: '/static/corporate/logo/2-4.png',
        enterpriseScale: '111',
        enterpriseRanking: '5'
      }

    ]
    this.enterpriseData = upList
  },
  methods: {
    toDetails() {
      this.$router.push({
        name: 'details',
        params: {
          dataObj: { enterpriseName: '云创大数据', NegativeRecord: '10', frontRecord: '85', enterpriseRank: '93', score: '125', percentage: '15%', icon: 'el-icon-sort-up', assessTime: '2018年5月1日', count: '726' }
        }})
    },
    rankUp() {
      var upList = [
        {
          enterpriseName: '云创大数据',
          enterpriseLogo: '/static/corporate/logo/1-1.png',
          enterpriseScale: '125',
          enterpriseRanking: '1'
        },
        {
          enterpriseName: '紫光西部数据',
          enterpriseLogo: '/static/corporate/logo/1-2.png',
          enterpriseScale: '115',
          enterpriseRanking: '2'
        },
        {
          enterpriseName: '艾科朗克',
          enterpriseLogo: '/static/corporate/logo/1-4.png',
          enterpriseScale: '113',
          enterpriseRanking: '3'
        },
        {
          enterpriseName: '拓视普',
          enterpriseLogo: '/static/corporate/logo/2-3.png',
          enterpriseScale: '112',
          enterpriseRanking: '4'
        },
        {
          enterpriseName: '佳汇科技',
          enterpriseLogo: '/static/corporate/logo/2-4.png',
          enterpriseScale: '111',
          enterpriseRanking: '5'
        }

      ]
      this.enterpriseData = upList
      this.current1 = 0
    },
    rankDown() {
      var downList = [
        {
          enterpriseName: '云创大',
          enterpriseLogo: '/static/corporate/logo/1-1.png',
          enterpriseScale: '125',
          enterpriseRanking: '1'
        },
        {
          enterpriseName: '紫光据',
          enterpriseLogo: '/static/corporate/logo/1-2.png',
          enterpriseScale: '115',
          enterpriseRanking: '2'
        },
        {
          enterpriseName: '艾科克',
          enterpriseLogo: '/static/corporate/logo/1-4.png',
          enterpriseScale: '113',
          enterpriseRanking: '3'
        },
        {
          enterpriseName: '视普',
          enterpriseLogo: '/static/corporate/logo/2-3.png',
          enterpriseScale: '112',
          enterpriseRanking: '4'
        },
        {
          enterpriseName: '佳汇科技',
          enterpriseLogo: '/static/corporate/logo/2-4.png',
          enterpriseScale: '111',
          enterpriseRanking: '5'
        }

      ]
      this.enterpriseData = downList
      this.current1 = 1
    }
  }
  // computed: {
  //   chartdata() {
  //     const opt=
  //   }
  // }

}
</script>

<style lang="scss" scoped>
@media screen and (max-width: 960px) {
  .row-bg {
    flex-wrap: wrap;
  }
  .Corporate_content {
    width: 31.33%;
    margin-bottom: 20px;
  }
  .Corporate_content:nth-child(3n) {
    margin-right: 0 !important;
  }
}
.index {
  padding: 15px;
  background-color: #f2f2f2;
  i {
    font-size: 20px;
  }
  .Corporate_chart {
    background-color: #fff;
    .chart_title {
      padding: 20px;
      .el-col:nth-child(2) {
        font-size: 18px;
        color: #999;
      }
      .el-col:nth-child(3) {
        color: #2ca8e7;
      }
    }
  }
  .Corporate_content,
  .Corporate_chart {
    &:hover {
      box-shadow: 0 0 10px #2ca8e7;
      transform: translateY(-3px);
    }
  }
  .Corporate_rk {
    margin: 15px 0;
    color: #666;

    .Corporate_content {
      background-color: #fff;
      margin-right: 20px;
      border-radius: 8px;
      transition: all 0.5s ease;
      .Corporate_Info {
        padding: 10px;
        > img {
          width: 100%;
          display: block;
        }
        > span {
          text-align: center;
          display: block;
          padding: 5px;
          font-size: 20px;
        }
      }
      > p {
        padding: 30px 15px 40px 15px;
        text-align: center;
        > span {
          font-size: 80px;
          color: #2ca8e7;
        }
      }
      h4 {
        padding: 20px 0;
        font-size: 20px;
        text-align: center;
        color: #999;
      }
      .Corporate_ft {
        padding: 20px 15px;
        border-top: 1px solid #ccc;
        text-align: center;
        color: #2ca8e7;
        font-size: 20px;
        overflow: hidden;
        i {
          float: right;
        }
      }
    }
  }
}
</style>
<style lang="scss">
#input {
  border-radius: 18px;
}
</style>

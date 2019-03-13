<template>
  <div class="details">
    <header class="bgc">
      <el-row>
        <el-col :span="10">
          <!-- 头部左边 -->
          <el-row class="header_left">
            <!-- Credit_Score 信用评分 -->
            <div class="Credit_Score">
              <p class="score">{{ dataList.score }}</p>
              <svg id="图层_1" style="width:106px;height:75px;" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 106 75" xml:space="preserve">
                <polygon style="fill:#F40B4E;" points="77.542,34.527 77.167,34.041 91.214,24.765 91.511,25.291 " />
                <linearGradient id="SVGID_7_" gradientUnits="userSpaceOnUse" x1="0.0604" y1="37.0005" x2="105.2842" y2="37.0005">
                  <stop offset="0" style="stop-color:#55F7FF" />
                  <stop offset="0.1072" style="stop-color:#51F5FC" />
                  <stop offset="0.2063" style="stop-color:#46F1F5" />
                  <stop offset="0.3021" style="stop-color:#33E9E8" />
                  <stop offset="0.3954" style="stop-color:#19DED6" />
                  <stop offset="0.4664" style="stop-color:#00D4C5" />
                  <stop offset="1" style="stop-color:#22007F" />
                </linearGradient>
                <path
                  style="fill:url(#SVGID_7_);"
                  d="M16.574,68.534c-2.046-4.77-3.183-10.022-3.183-15.541c0-21.793,17.666-39.459,39.459-39.459
                              S92.309,31.2,92.309,52.993c0,5.366-1.076,10.479-3.016,15.143l11.83,5.381c2.678-6.31,4.161-13.251,4.161-20.538
                           c0-29.057-23.555-52.612-52.612-52.612C23.616,0.367,0.06,23.922,0.06,52.979c0,7.333,1.504,14.313,4.214,20.655
                         C6.774,72.617,11.94,70.468,16.574,68.534z" />
                <path style="fill:#2CA9F8;" d="M16.068,69.021" />
                <linearGradient id="SVGID_8_" gradientUnits="userSpaceOnUse" x1="13.3908" y1="40.917" x2="92.3088" y2="40.917">
                  <stop offset="0.0049" style="stop-color:#00BFBC" />
                  <stop offset="0.1879" style="stop-color:#00B9BE" />
                  <stop offset="0.4232" style="stop-color:#00A9C2" />
                  <stop offset="0.687" style="stop-color:#008FC9" />
                  <stop offset="0.9698" style="stop-color:#006AD3" />
                  <stop offset="1" style="stop-color:#0066D4" />
                </linearGradient>
                <path
                  style="fill:url(#SVGID_8_);"
                  d="M25.535,64.379c-1.496-3.539-2.324-7.43-2.324-11.515c0-16.344,13.25-29.594,29.594-29.594
                            S82.4,36.52,82.4,52.864c0,3.941-0.777,7.699-2.175,11.138l9.039,4.083c1.96-4.684,3.045-9.824,3.045-15.218
                            c0-21.793-17.666-39.459-39.459-39.459S13.391,31.075,13.391,52.868c0,5.525,1.14,10.783,3.191,15.557L25.535,64.379z" />
                <g style="opacity:0.22;">
                  <rect x="13.391" y="52.993" transform="matrix(0.9996 0.0278 -0.0278 0.9996 1.4914 -0.4879)" style="fill:#FFFFFF;" width="9.816" height="0.841" />
                  <rect x="16.565" y="38.308" transform="matrix(0.8942 0.4476 -0.4476 0.8942 19.6078 -5.5152)" style="fill:#FFFFFF;" width="9.816" height="0.841" />
                  <rect x="25.648" y="26.34" transform="matrix(0.6213 0.7836 -0.7836 0.6213 32.5426 -13.8083)" style="fill:#FFFFFF;" width="9.816" height="0.841" />
                  <rect x="38.937" y="19.332" transform="matrix(0.2319 0.9727 -0.9727 0.2319 52.8927 -27.4779)" style="fill:#FFFFFF;" width="9.816" height="0.841" />
                  <rect x="53.943" y="18.597" transform="matrix(-0.2009 0.9796 -0.9796 -0.2009 89.3072 -34.8117)" style="fill:#FFFFFF;" width="9.816" height="0.841" />
                  <rect x="67.854" y="24.273" transform="matrix(-0.5961 0.8029 -0.8029 -0.5961 135.9633 -19.0067)" style="fill:#FFFFFF;" width="9.816" height="0.841" />
                  <rect x="77.938" y="35.421" transform="matrix(-0.8796 0.4757 -0.4757 -0.8796 172.767 27.9541)" style="fill:#FFFFFF;" width="9.816" height="0.841" />
                  <rect x="82.344" y="49.892" transform="matrix(-0.9982 0.0594 -0.0594 -0.9982 177.3401 95.3505)" style="fill:#FFFFFF;" width="9.816" height="0.841" />
                </g>
                <g id="chart-board" transform="rotate(-30,52,53)">
                  <rect x="52" y="53" transform="translate(30 0)" style="fill:#F40B4E;" width="18" height="1" />
                </g>
              </svg>
              <span>信用良好</span>
            </div>
            <!-- assess 评估 -->
            <div class="assess">
              <div>
              <span>{{ dataList.enterpriseName }}</span>企业信用</div>
              <div class="assessResult">高于园内企业平均水平
                <span>{{ dataList.percentage }}</span>
                <i class="fa fa-long-arrow-up" />
              </div>
              <div class="assessTime">评估时间:
                <span>{{ dataList.assessTime }}</span>
              </div>
            </div>

          </el-row>
        </el-col>
        <el-col :span="10">
          <!-- 头部中间 -->
          <div class="header_content">
            <div class="credit_rank">信用等级 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <i class="el-icon-star-on" />
              <i class="el-icon-star-on" />
              <i class="el-icon-star-on" />
              <i class="el-icon-star-on" />
              <i class="el-icon-star-off" />
            </div>
            <el-row type="flex" class="row-bg" justify="space-between">
              <el-col :span="10">
                <div class="grid-content bg-purple">园区企业信用排名</div>
              </el-col>
              <el-col :span="6">
                <div class="grid-content bg-purple">{{ dataList.count }}家</div>
              </el-col>
            </el-row>
            <div class="dib rate-2">
              <svg style="display: none;" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" view-box="0 0 420 23">
                <defs>
                  <polygon id="rate-chart" points="420,23 0,23 0,0 420,23 " />
                </defs>
                <symbol id="rate-chart-default">
                  <use xlink:href="#rate-chart" fill="#e4e8ea" />
                </symbol>
                <symbol id="rate-chart-active">
                  <use xlink:href="#rate-chart" fill="#81c2f7" />
                </symbol>
              </svg>
              <svg>
                <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#rate-chart-default" />
              </svg>
              <div class="active" style="width:5%;overflow: hidden;">
                <svg>
                  <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#rate-chart-active" />
                </svg>
              </div>
            </div>
            <div class="rank">
              <span>第</span>{{ dataList.enterpriseRank }}名
              <i class="fa fa-long-arrow-up" />
            </div>
          </div>
        </el-col>
        <el-col :span="4">
          <div class="header_right">
            <div class="front text-right">
            <i class="fa fa-thumbs-o-up " /> 正面记录:{{ dataList.frontRecord }}</div>
            <div class="negative text-right">
            <i class="fa fa-thumbs-o-down " /> 负面记录:{{ dataList.NegativeRecord }}</div>
          </div>
        </el-col>
      </el-row>
    </header>
    <el-row :gutter="20">
      <el-col :span="8">
        <div class="grid-content bg-purple"/>
        <el-table :data="tableData" class="text-center" style="width: 100%">
          <el-table-column class="text-center" prop="date" label="指标" />
          <el-table-column class="text-center" prop="name" label="总分" />
          <el-table-column class="text-center" prop="address" label="记录数" />
          <el-table-column class="text-center" prop="qushi" label="趋势">
            <template >
              <i class="fa fa-long-arrow-up" />
            </template>
          </el-table-column>
        </el-table>

      </el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple-light" />
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dataList: {},
      tableData: [
        {
          date: '园区评价',
          name: '-12',
          address: '3',
          qushi: ``
        },
        {
          date: '银行信贷',
          name: '0',
          address: '39',
          qushi: 'up'
        },
        {
          date: '企业运营',
          name: '-2',
          address: '上海市',
          qushi: 'up'
        },
        {
          date: '员工评价',
          name: '21',
          address: '上海市',
          qushi: 'up'
        },
        {
          date: '员工评价',
          name: '21',
          address: '上海市',
          qushi: 'up'
        },
        {
          date: '员工评价',
          name: '21',
          address: '上海市',
          qushi: 'up'
        },
        {
          date: '员工评价',
          name: '21',
          address: '上海市',
          qushi: 'up'
        },
        {
          date: '员工评价',
          name: '21',
          address: '上海市',
          qushi: 'up'
        },
        {
          date: '员工评价',
          name: '21',
          address: '上海市',
          qushi: 'up'
        }
      ]
    }
  },
  mounted() {
    // 调用方法
    this.getParams()
  },
  methods: {
    getParams() {
      // 取到路由带过来的参数
      const routerquery = this.$route.params.dataObj
      // 将数据放在当前组件的数据内
      this.dataList = routerquery
    }
  }
}
</script>

<style lang="scss" scoped>
.details {
  header {
    padding: 15px;
    margin-bottom: 20px;
    .header_left {
      display: flex;
      .Credit_Score {
        width: 107px;
        position: relative;
        p {
          margin: 0;
        }
        .score {
          position: absolute;
          left: -2px;
          bottom: 35px;
          width: 100%;
          font-size: 24px;
          text-align: center;
        }
        span {
          display: block;
          text-align: center;
        }
      }
      .assess {
        flex: 1;
        margin-left: 10px;
        .assessResult {
          margin-top: 10px;
        }
        .assessTime {
          padding: 10px 0;
        }
      }
    }
    .header_content {
      .credit_rank {
        padding-bottom: 5px;
        i {
          font-size: 20px;
          color: #ffb800;
        }
      }
      .rank {
        color: #f00;
      }
      .row-bg {
        color: #2ca9f8;
      }
      .dib {
        height: 23px;
        position: relative;
        margin: 5px 0;
        > .active {
          position: absolute;
          top: 0;
          left: 0;
          height: 23px;
          z-index: 2;
        }
      }
    }
    .header_right {
      .front,
      .negative {
        padding: 15px 5px;
      }
      .fa-thumbs-o-up {
        font-size: 20px;
        color: #00b050;
      }
      .fa-thumbs-o-down {
        font-size: 20px;
        color: #c00000;
      }
    }
  }
}
</style>

<template>
  <div class="report-entrance">
<!--    <div class="en-header">-->
<!--      <div class="en-banner">-->
<!--        <div class="swiper-container">-->
<!--          <div class="swiper-wrapper">-->
<!--            <div class="swiper-slide" v-for="(img, index) in adUrls" :key="index">-->
<!--              <img :src="img" class="swiper-slide-img" alt="">-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
    <div class="en-body">
      <el-tabs type="border-card">
        <el-tab-pane label="本月上报数据">
          <div class="en-card-bg">
            <div class="en-card" v-for="(item, index) in willFillList">
              <div class="en-card-t">{{ item.modelName }}</div>
              <div class="en-card-m tc" v-html="formatYearMonth(item)"></div>
              <div class="tc" v-if="item.isOverdue === '0'">
                还有
                <span class="en-warning">{{ item.residueDays }}天</span>
                逾期
              </div>
              <div class="tc" v-else>
                已经逾期
                <span class="en-warning">{{ item.overdueDays }}天</span>
              </div>
              <div class="en-tips">{{ item.fillInFormDeadline | formatDate }}</div>
              <div class="en-card-b">
                <div class="en-card-b-c" @click="toFillData(item.fillId)">我要上报</div>
                <div class="en-card-b-r">
                  <i class="el-icon-time"></i>
                </div>
              </div>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane label="历史上报数据">
          <div>
            <el-button v-for="(item, index) in reportType" :key="index" :type="filledType === index ? 'primary' : ''" size="mini" @click="filledTypeChange(item.data, index)">{{ item.name }}</el-button>
          </div>
          <div class="en-card-bg">
            <div class="en-card" v-for="(item, index) in filledList" :key="index">
              <div class="en-card-t">{{ item.modelName }}</div>
              <div class="en-card-m tc" v-html="formatYearMonth(item)"></div>
              <div class="tc">
                逾期
                <span class="en-warning">{{ item.overdueDays }}天</span>
              </div>
              <div class="en-tips">{{ item.fillInFormDeadline | formatDate }}</div>
              <div class="en-card-b">
                <div class="en-card-b-c" @click="toFillData(item.fillId)">我要上报</div>
                <div class="en-card-b-r">
                  <i class="el-icon-time"></i>
                </div>
              </div>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
  import Swiper from 'swiper'
  export default {
    name: "reportEntry",
    mounted() {
      this.init()
    },
    data() {
      return {
        adUrls: [],
        filledType: 0,
        reportType: [{
          name: '全部',
          data: {
            modelCycle: null,
            page: 1
          }

        },{
          name: '年报',
          data: {
            modelCycle: '1',
            page: 1
          }
        },{
          name: '月报',
          data: {
            modelCycle: '0',
            page: 1
          }
        }],
        willFillList: [], // 要填表的列表
        filledList: [], // 填报的历史列表
        filledData: {
          modelCycle: null, // 填报周期/报表类型(1：年，0：月)
          page: 1,
          rows: 20
        },
      }
    },
    filters: {
      formatDate(time) {
        const date = new Date(time)
        const y = date.getFullYear()
        const m = date.getMonth() + 1
        const d = date.getDate()
        return `上报截止日期：${y}年${m}月${d}号`
      },
    },
    methods: {
      init() {
        this.getData()
        this.getFilledData()
        this.getPcAd()
          .then(() => {
            new Swiper('.swiper-container', {
              slidesPerView: 'auto',
              spaceBetween: 10,
              pagination: {
                el: '.swiper-pagination',
                clickable: true
              }
            })
          })
      },
      filledTypeChange(data, index) {
        // 历史上报数据切换全部/年/月报
        this.filledData = Object.assign(this.filledData, data)
        this.filledType = index
        this.getFilledData()
      },
      getData() {
        const _this = this
        this.api.post({
          url: 'enterpriseGetForm',
          callback(res) {
            if (res.code === "0000") {
              _this.willFillList = res.data
            } else {
              _this.$message.error(res.result)
            }
          }
        })
      },
      getFilledData() {
        const _this = this
        this.api.post({
          url: 'enterpriseGetFormed',
          data: this.filledData,
          callback(res) {
            if (res.code === "0000") {
              _this.filledList = res.data.rows
            } else {
              _this.$message.error(res.result)
            }
          }
        })
      },
      toFillData(id) {
        this.$router.push({
          path:'/servicemarket/product/productService/dataReportEntrance',
          query:{
            id: id
          }
        })
      },
      formatYearMonth(data) {
        if (data.modelCycle === 0) {
          return (`<span class="en-card-m-l">${ data.formTime.substring(5,6) }</span>
          <span class="en-card-m-r">月</span>`)
        } else {
          return (`<span class="en-card-m-l">${ data.formTime.substring(0,4) }</span>
          <span class="en-card-m-r">年</span>`)
        }
      },
      getPcAd() {
        return new Promise((resolve, reject) => {
          const _this = this
          this.api.get({
            url: 'enterpriseGetPcAd',
            callback(res) {
              if (res.code === "0000") {
                _this.adUrls = res.data.adUrls
                resolve()
              } else {
                _this.$message.error(res.result)
                reject()
              }
            }
          })
        })
      }
    }
  }
</script>

<style lang="scss">
  @import "~@/css/r-common";
  .report-entrance {
    $primary-color: #409EFF;
    .en-card-bg {
      @include flex($h: flex-start, $v: flex-start);
      padding: 15px 0;
    }
    .tab-btns {
      margin: 25px auto 10px;
    }
    .en-card {
      width: 220px;
      border-radius: 4px;
      font-size: 14px;
      box-shadow: 0 0.5em 1em 0 rgba(0, 0, 0, 0.1);
      background-color: #fff;
      overflow: hidden;
      margin-right: 15px;
      .en-card-t {
        padding: 10px;
        text-align: center;
      }
      .en-card-m {
        margin: 10px auto;
        .en-card-m-l {
          color: #409EFF;
          font-size: 60px;
        }
        .en-card-m-r {
          font-size: 20px;
          color: #666;
        }
      }
      .en-card-b {
        @include  flex($h: flex-end);
        background-color: $primary-color;
        color: #fff;
        padding: 10px;
        .en-card-b-c {
          width: 50%;
          text-align: center;
          cursor: pointer;
        }
        .en-card-b-r {
          width: 25%;
          text-align: right;
          font-size: 22px;
        }
      }
      .en-warning {
        color: #FF2222;
      }
      .en-tips {
        font-size: 12px;
        color: #999;
        text-align: center;
        padding:6px;
        margin-bottom: 10px;
      }
    }
    .swiper-slide {
      width: auto;
      img {
        /*width: 100%;*/
      }
    }
  }
</style>

<template>
  <div class="report-entrance">
    <div class="en-header">
      <div class="en-banner">
<!--        <div class="swiper-container">-->
<!--          <div class="swiper-wrapper">-->
<!--            <div class="swiper-slide" v-for="(img, index) in adUrls" :key="index">-->
<!--              <img :src="img" class="swiper-slide-img" alt="">-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
      </div>
    </div>
    <div class="en-body">
      <el-tabs type="border-card" style="background-color: #f5f5f5">
        <el-tab-pane label="本月上报数据">
          <div
            v-loading="willFillListLoading"
            v-if="willFillList.length === 0"
            class="show-no-data">
            <no-data></no-data>
          </div>
<!--          <div v-loading="willFillListLoading" v-if="willFillList.length === 0" class="no-data">暂无数据</div>-->
          <div v-else>
            <div class="en-card-bg">
              <div
                   v-for="(item, index) in willFillList"
                   class="en-card"
                   @click="toFillData(item, 'form')">
                <div class="card-cell">
                  <div class="en-card-t" :title="item.modelName">{{ item.modelName }}</div>
                  <div class="en-card-m tc" v-html="formatYearMonth(item)"></div>
                  <div class="tc" v-if="item.isOverdue === '0'">

                    <div v-if="Number(item.residueDays) === 0">
                      <span class="en-warning">今天</span>逾期
                    </div>
                    <div v-else-if="Number(item.residueDays) === 1">
                      <span class="en-warning">明天</span>逾期
                    </div>
                    <div v-else-if="Number(item.residueDays) === 2">
                      <span class="en-warning">后天</span>逾期
                    </div>
                    <div v-else>
                      还有
                      <span class="en-warning">{{ item.residueDays }}天</span>
                      逾期
                    </div>
                  </div>
                  <div class="tc" v-else>
                    已经逾期
                    <span class="en-warning">{{ item.overdueDays }}天</span>
                  </div>
                  <div class="en-tips">{{ item.fillInFormDeadline | formatDate }}</div>
                  <div class="en-card-b">
                    <div class="en-card-b-c">我要上报</div>
                    <div class="en-card-b-r">
                      <i class="el-icon-time"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane label="历史上报数据">
          <div class="search-row">
            <div class="search-row-cell">
              <el-button v-for="(item, index) in reportType" :key="index" :type="filledType === index ? 'primary' : ''" size="mini" @click="filledTypeChange(item.data, index)">{{ item.name }}</el-button>
            </div>
            <div class="search-row-cell">
              <el-input
                v-model="searchFilled"
                placeholder="请输入内容"
                prefix-icon="el-icon-search">
              </el-input>
            </div>
          </div>
          <div
            v-loading="filledListLoading"
            v-if="filledList.length === 0"
            class="show-no-data">
            <no-data></no-data>
          </div>
          <div
            v-if="filledListSearchResult.length === 0 && filledList.length > 0"
            class="show-no-data">
            <no-data title="暂无筛选结果，换个搜索条件试试吧"></no-data>
          </div>
          <div v-else>
            <div class="en-card-bg">
              <div
                   v-for="(item, index) in filledListSearchResult"
                   :class="formatReported(item).class"
                   :key="index"
                   class="en-card"
                   @click="toSelectFillData(item)">
                <div class="card-cell">
                  <div class="en-card-t" :title="item.modelName">{{ item.modelName }}</div>
                  <div class="en-card-m tc" v-html="formatYearMonth(item)"></div>
                  <div class="tc" v-if="formatReported(item).title === '我已上报'">
                    <span>已于</span>
                    <span class="en-success">{{ item.upTime | getDate }}</span>
                    <span>填期</span>
                  </div>
                  <div class="tc" v-else-if="formatReported(item).title === '我要补报'">
                    <span>已逾期</span>
                    <span class="en-warning">{{ item.overdueDays }}</span>
                    <span>天</span>
                  </div>
                  <div class="tc" v-else>
                    <span class="en-warning">逾期</span>
                    <span>已补报</span>
                  </div>
                  <div class="en-tips" v-if="item.status === 1">{{ item.fillInFormDeadline | formatDate }}</div>
                  <div class="en-tips" v-else>感谢您对园区工作的支持</div>
                  <div class="en-card-b">
                    <div class="en-card-b-c">{{ formatReported(item).title }}</div>
                    <div class="en-card-b-r">
                      <i class="el-icon-success" v-if="formatReported(item).title === '我已上报'"></i>
                      <i class="el-icon-time" v-else-if="formatReported(item).title === '我要补报'"></i>
                      <i class="el-icon-info" v-else-if="formatReported(item).title === '我已补报'"></i>
                    </div>
                  </div>
                </div>
                </div>
            </div>
          </div>
          <div class="filled-pagination">
            <el-pagination
              background
              :page-size="filledData.rows"
              layout="prev, pager, next"
              :total="filledListTotal"
              @current-change="filledDataChange">
            </el-pagination>
          </div>

        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
  import { isMobile } from '@/util'
  import Swiper from 'swiper'
  import noData from '../common/noData'
  export default {
    components: {
      noData
    },
    activated() {
      this.$nextTick(() => {
        this.init()
      })
    },
    data() {
      return {
        willFillListLoading: true,
        filledListLoading: false,
        isMobile: isMobile(),
        searchFilled: '',
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
        filledListTotal: 0, // 历史填报总条数
        filledData: {
          modelCycle: null, // 填报周期/报表类型(1：年，0：月)
          page: 1,
          rows: 20
        },
      }
    },
    computed: {
      filledListSearchResult() {
        if (this.searchFilled === '') {
          return this.filledList
        }
        return this.filledList.filter(item => item.modelName.indexOf(this.searchFilled) > -1)
      }
    },
    filters: {
      getDate(str) {
        const date = new Date(str)
        const y = date.getFullYear()
        let m = date.getMonth() + 1
        m = m > 10 ? m : '0' + m
        let d = date.getDate()
        d = d > 10 ? d : '0' + d
        return y + '/'+ m + '/' + d
      },
      formatDate(time) {
        const date = new Date(time)
        const y = date.getFullYear()
        const m = date.getMonth() + 1
        const d = date.getDate()
        return `上报截止日期：${y}年${m}月${d}号`
      }
    },
    methods: {
      init() {
        this.getData()
        this.getFilledData()
        this.getPcAd()
          .then(() => {
            // let options
            // if (this.isMobile) {
            //   options = {
            //     autoplay:true,
            //     loop:true
            //   }
            // } else {
            //   options = {
            //     slidesPerView: 'auto',
            //     spaceBetween: 10,
            //     pagination: {
            //       el: '.swiper-pagination',
            //       clickable: true
            //     }
            //   }
            // }
            // new Swiper('.swiper-container', options)
          })
      },
      filledTypeChange(data, index) {
        // 历史上报数据切换全部/年/月报
        this.filledData = Object.assign(this.filledData, data)
        this.filledType = index
        this.getFilledData()
      },
      getData() {
        this.willFillListLoading = true
        const _this = this
        this.api.post({
          url: 'enterpriseGetForm',
          callback(res) {
            if (res.code === "0000") {
              _this.willFillList = res.data || []
            } else {
              _this.$message.error(res.result)
            }
            _this.willFillListLoading = false
          }
        })
      },
      getFilledData() {
        this.filledListLoading = true
        const _this = this
        this.api.post({
          url: 'enterpriseGetFormed',
          data: this.filledData,
          callback(res) {
            if (res.code === "0000") {
              _this.filledList = res.data.rows || []
              _this.filledListTotal = res.data.total
            } else {
              _this.$message.error(res.result)
            }
            _this.filledListLoading = false
          }
        })
      },
      filledDataChange(page) {
        this.filledData.page = page
        this.getFilledData()
      },
      toSelectFillData(item) {
        let type = 'formed'
        if (this.formatReported(item).title === '我要补报') {
          type = 'form'
        }
        this.toFillData(item, type)
      },
      toFillData(item, type) {
        let query = {
          fileId: item.fillId,
          type: type
        }
        if (this.$route.query.iframe) {
          query.iframe = 1
        }
        this.$router.push({
          path:'/servicemarket/product/productService/report',
          query: query
        })
      },
      formatReported(item) {
        const status = item.status
        if (status === 0) {
          if (item.isOverdue === '0') {
            return {
              title: '我已上报',
              class: 'en-success'
            }
          } else {
            return {
              title: '我已补报',
              class: 'en-info'
            }
          }
        } else {
          return {
            title: '我要补报',
            class: 'en-warning'
          }
        }
      },
      formatYearMonth(data) {
        if (data.modelCycle === 0) {
          return (`<span class="en-card-m-l">${ parseInt(data.formTime.substring(4,6)) }</span>
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
    $success-color: #00a041;
    $warning-color: #FF2222;
    $info-color: #ebebeb;
    .en-body {
      margin-top: 6px;
    }
    .en-card-bg {
      flex-wrap: wrap;
      padding: 15px 0;
      @include flex($h: flex-start, $v: flex-start);
    }
    .tab-btns {
      margin: 25px auto 10px;
    }
    .search-row {
      @include flex($h:space-between);
      flex-wrap: wrap;
      margin-bottom: 10px;
    }
    .en-card {
      width: 25%;
      /*min-width: 220px;*/
      /*max-width: 250px;*/
      padding: 15px;
      font-size: 14px;
      background-color: #f5f5f5;
      box-sizing: border-box;
      cursor: pointer;
      .card-cell {
        width: 100%;
        border-radius: 4px;
        overflow: hidden;
        background-color: #fff;
        transform: translateY(0);
        transition: .2s ease-in;
        &:hover {
          box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
          transform: translateY(-6px);
          transition: .2s ease-out;
        }
      }

      &.en-success {
        .en-card-m .en-card-m-l {
          color: $success-color;
        }
        .en-card-b {
          background-color: $success-color;
          &:hover {
            opacity: .9;
          }
        }
      }
      &.en-warning {
        .en-card-m .en-card-m-l {
          color: $warning-color;
        }
        .en-card-b {
          background-color: $warning-color;
        }
      }
      &.en-info {
        .en-card-m .en-card-m-l {
          color: $info-color;
        }
        .en-card-b {
          background-color: $info-color;
        }
      }
      .en-card-t {
        padding: 10px;
        overflow: hidden;
        text-overflow:ellipsis;
        white-space: nowrap;
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
        }
        .en-card-b-r {
          width: 25%;
          text-align: right;
          font-size: 22px;
        }
      }
      .en-warning {
        color: $warning-color;
      }
      .en-success {
        color: $success-color;
      }
      .en-tips {
        font-size: 12px;
        color: #999;
        text-align: center;
        padding:6px;
        margin-bottom: 10px;
        overflow: hidden;
        text-overflow:ellipsis;
        white-space: nowrap;
      }
    }
    .swiper-slide {
      width: auto;
      img {
        width: 100%;
        max-height: 400px;
      }
    }
    .filled-pagination {
      margin: 20px auto;
      text-align: right;
    }
    .show-no-data {

    }
  }
  .isMobile {
    .en-card {
      width: 50%;
      padding: 4px;
    }
    .search-row {
      padding: 0 10px;
    }
    .search-row-cell {
      margin-top: 10px;
    }
  }
</style>

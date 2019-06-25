<template>
  <div class="investment">
    <div class="investment-header">
<!--      <div class="search-row">-->
<!--        <icon class="search-row-icon" type="search"></icon>-->
<!--        <input v-model="keywords" placeholder="搜索招商信息" class="search-input" type="text" />-->
<!--      </div>-->
      <div class="swiper-container investment-banner">
        <div class="swiper-wrapper">
          <div
            v-for="(banner, index) in bannerList"
            :key="index"
            class="swiper-slide">
            <img class="swiper-img" :src="banner.posterUrl" alt="">
          </div>
        </div>
      </div>
    </div>
    <div class="investment-main">
      <div class="investment-block">
        <div class="investment-block-title">
          <div
            class="block-title"
            @click="$linkTo({path:'/parkProfile', appPath: api.host + '#/parkProfile'})"
          >南京白下高新技术产业园区</div>
        </div>
        <div class="investment-block-content investment-park">
          <div class="park-profile-desc">{{  parkDesc | formatParkDesc }}</div>
          <div
            class="more-desc main-color"
            @click="$linkTo({path:'/parkProfile', appPath: api.host + '#/parkProfile'})"
          >查看详情</div>
        </div>
      </div>

      <div class="investment-block">
        <div class="investment-block-title br-b">
          <div class="block-title">多园介绍</div>
        </div>
        <div class="investment-block-content">
          <div
            v-for="(item, index) in parkList"
            :key="index"
            class="card-list"
            @click="$linkTo({path:'/parkDetails', appPath: api.host + '#/parkDetails?id=' + item.id, query:{id: item.id}})"
          >
            <div class="card-list-poster" :style="{backgroundImage: 'url(' + item.mainPicture + ')'}">
            </div>
            <div class="card-list-content">
              <div class="card-list-title">{{ item.parkName }}</div>
              <div class="card-list-text">{{ item.shortIntroduce }}</div>
              <div class="card-list-tips">
                <span class="main-color">查看详情</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Swiper from 'swiper'
import moreBtn from './common/moreBtn'
import tagBtn from './common/tagBtn'
import nowLoading from '@/views/common/nowLoading'
import noMore from '@/views/common/noMore'
export default {
  name: 'Investment',
  components: {
    moreBtn,
    tagBtn,
    nowLoading,
    noMore
  },
  data () {
    return {
      keywords: '',
      showMore: false,
      parkDesc: '为充分发挥省级高新区服务管理及品牌优势，形成市场、政府“两只手”齐发力，使社会园区开发建设更快、产业集聚更优、经济效益更好，入驻企业更满意，秦淮区委、区政府启动高新区创新转型的秦淮实践。经历了三个阶段的改革创新。',
      activePark: 0,
      bannerList: [],
      businessAdDynamic: [],
      businessAdPolicy: [],
      parkList: [],
      activeItem: {}
    }
  },
  mounted () {
    this.$nextTick(() => {
      this.init()
    })
  },
  filters: {
    formatParkDesc (str) {
      return str.substring(0, 50) + '...'
    }
  },
  methods: {
    init () {
      this.getPartList()
      this.getBanner()
        .then(() => {
          const swiper = new Swiper('.swiper-container', {
            autoplay: true
          })
          console.dir(swiper)
        })
    },
    getBanner () {
      return new Promise((resolve, reject) => {
        this.api.get({
          url: 'getPromotionList',
          data: {
            approvalStatus: 6,
            status: 1,
            propagandaType: 'investment_banner',
            needPage: 0
          },
          callback: (res) => {
            if (res.code === '0000') {
              this.bannerList = res.data.rows
              resolve()
            } else {
              reject(res.data)
            }
          }
        })
      })
    },
    getPartList () {
      return new Promise((resolve, reject) => {
        this.api.get({
          url: 'parkList',
          callback: (res) => {
            if (res.code === '0000') {
              this.parkList = res.data
              resolve()
            } else {
              reject(res)
            }
          }
        })
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  @import '~@/assets/styles/common';
  .investment {
    padding-top: 30px;
    @include image($url:'~@/assets/image/investment-bg.png', $bg: #fff);
    .tc-row {
      padding: 20px;
      text-align: center;
      font-size: 28px;
    }
    .no-more-row {
      padding: 20px;
      @include flex;
      height: 200px;
      font-size: 12px;
    }
    .read-more {
      height: 120px;
      @include flex-center;
      font-size: 30px;
      background-color: #fafafa;
      .read-more-icon {
        font-size: 30px;
        color: #999;
      }
    }
    .investment-header {
      padding: 0 30px;
    }
    .card-list {
      margin: 4px auto;
      display: flex;
      align-items: center;
      padding: 15px 30px;
      background-color: #fff;
      cursor: pointer;
    }
    .card-list-poster {
      background-size: cover;
      width: 180px;
      height: 220px;
      overflow: hidden;
      border-radius: 4px;
      flex: none;
      img {
        height: 100%;
      }
    }
    .card-list-content {
      padding: 18px;
      font-size: 28px;
      color:rgba(51,51,51,1);
      flex: 1;
    }
    .card-list-title {
      width: 100%;
      height: 30px;
      font-size: 32px;
      font-weight:bold;
      color: rgba(34,34,34,1);
      @include clamp(1);
    }
    .card-list-text {
      width: 100%;
      height: 100px;
      line-height: 36px;
      margin: 20px 0 10px;
      @include clamp(3);
      color: #666666;
    }
    .card-list-tips {
      display: flex;
      justify-content: flex-end;
      align-items:center;
      margin-top: 8px;
      font-size: 24px;
      color:rgba(153,153,153,1);
    }
    .main-color {
      color: $--color-primary;
    }
    .view-icon {
      font-size: 28px;
    }
    .card-list-warning {
      margin-left: 8px;
    }
    .investment-main {

    }
    .investment-block {
      border-bottom: 4px solid #fafafa;
      background-color: #fff;
      &.br-n {
        border-bottom: none;
      }
      &:last-of-type {
        border-bottom: none;
      }
      .investment-park {
        line-height: 40px;
        letter-spacing: 4px;
        padding: 0 40px;
        .park-profile-desc {
          font-size: 26px;
          text-indent: 2em;
        }
      }
      .investment-block-title {
        padding: 20px 40px;
        @include flex($h: space-between);
        cursor: pointer;
        &.br-b {
          border-bottom: 4px solid #fafafa;
        }
        .block-title {
          font-size: 34px;
        }
        .block-more {
          align-self: flex-end;
          @include flex($h: flex-start);
          color: #999;
          font-size: 28px;
        }
      }
      .investment-block-content {
        position: relative;
        font-size: 32px;
        color: #999;
      }
      .tag-row {
        @include flex($h: flex-start);
        .tag-list {
          margin-right: 10px;
        }
      }
      .tab-nav {
        padding: 0 40px;
        .vux-tab .vux-tab-item {
          font-size: 28px;
        }
      }
      .more-desc {
        position: absolute;
        right: 40px;
        bottom: 0;
        font-size: 24px;
        cursor: pointer;
      }
    }
    .investment-banner {
      margin: 0 auto 16px;
      .swiper-img {
        width: 100%;
        border-radius: 16px;
      }
    }
    .search-row {
      width: 100%;
      $h: 64px;
      position: relative;
      border-radius: $h;
      height: $h;
      background-color: rgba(255, 255, 255, .3);
      color: #fff;
      .search-row-icon {
        position: absolute;
        top: 50%;
        left: 20px;
        transform: translateY(-50%);
        color: #fff;
        font-size: 26px;
      }
      .search-input {
        padding-left: 60px;
        height: 100%;
        width: 100%;
        font-size: 26px;
        -webkit-appearance: none;
        background-color: transparent;
        background-image: none;
        border-radius: 4px;
        box-sizing: border-box;
        display: inline-block;
        color: #fff;
        transition: border-color .2s cubic-bezier(.645,.045,.355,1);
      }
      @mixin fs () {
        font-size: 26px;
        color: #fff;
        line-height: 100%;
      }
      ::-webkit-input-placeholder { /* WebKit browsers */
        @include fs;
      }
      :-moz-placeholder { /* Mozilla Firefox 4 to 18 */
        @include fs;
      }
      ::-moz-placeholder { /* Mozilla Firefox 19+ */
        @include fs;
      }
      :-ms-input-placeholder { /* Internet Explorer 10+ */
        @include fs;
      }
    }
  }
</style>

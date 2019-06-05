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
          <div class="block-title">园区概况</div>
          <div
            class="block-more"
            @click="$router.push({path:'/parkProfile'})"
          >
            <span>查看详情</span>
            <i class="icon iconfont icon-jiantou"></i>
          </div>
        </div>
        <div class="investment-block-content investment-park">
          <div v-if="!showMore">{{  parkDesc | formatParkDesc}}</div>
          <div v-else>{{ parkDesc }}</div>
          <more-btn v-if="!showMore" class="more-desc" @click.native="showMore = true"></more-btn>
        </div>
      </div>

      <div class="investment-block">
        <div class="investment-block-title">
          <div class="block-title">招商政策</div>
          <div
            class="block-more"
            @click="$router.push({path:'/investmentPolicy'})"
          >
            <span>更多</span>
            <i class="icon iconfont icon-jiantou"></i>
          </div>
        </div>
        <div class="investment-block-content">
          <div
            v-for="(item, index) in businessAdPolicy"
            :key="index"
            class="card-list"
            @click="$router.push({path:'/investmentPolicyDetail',query:{id: item.id}})"
          >
            <div class="card-list-poster" :style="{backgroundImage: 'url(' + item.adCover + ')'}">
            </div>
            <div class="card-list-content">
              <div class="card-list-title">{{ item.title }}</div>
              <div class="card-list-text">{{ item.subTitle }}</div>
              <div class="card-list-tips">
                <span>{{ item.startTime }}</span>
                <span class="flex-center">
                  <i class="view-icon icon iconfont icon-view"></i>
                  <span class="card-list-warning">{{ item.viewCount }}</span>
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="investment-block">
        <div class="investment-block-title">
          <div class="block-title">招商动态</div>
          <div
            class="block-more"
            @click="$router.push({path:'/investmentDynamic'})"
          >
            <span>更多</span>
            <i class="icon iconfont icon-jiantou"></i>
          </div>
        </div>
        <div class="investment-block-content">
          <div
            v-for="(item, index) in businessAdDynamic"
            :key="index"
            class="card-list"
            @click="$router.push({path:'/investmentDynamicDetail',query:{id: item.id}})"
          >
            <div class="card-list-poster" :style="{backgroundImage: 'url(' + item.adCover + ')'}"></div>
            <div class="card-list-content">
              <div class="card-list-title">{{ item.title }}</div>
              <div class="card-list-text">{{ item.content }}</div>
              <div class="card-list-tips">
                <span>{{ item.startTime }}</span>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="investment-block br-n">
        <div class="investment-block-title">
          <div class="block-title">一区多园</div>
          <div class="block-more">
            <span>{{ parkList.length }}个园区</span>
          </div>
        </div>
        <div class="investment-block-content">
          <div class="tab-nav">
            <tab
              v-model="activePark"
              bar-active-color="#00a041"
              :line-width="1"
            >
              <tab-item
                v-for="(park, parkIndex) in parkList"
                :key="parkIndex"
                @on-item-click="tabPark"
              >{{ park.parkName }}</tab-item>
            </tab>
          </div>
          <div
            v-show="activePark === parkIndex"
            v-for="(park, parkIndex) in parkList"
            :key="parkIndex">
            <div v-if="park.list && park.list.length > 0">
              <div
                v-for="(item, index) in park.list"
                :key="index"
                class="card-list"
                @click="$router.push({path:'/investmentInfoDetail',query:{id: item.id}})"
              >
                <div class="card-list-poster" :style="{backgroundImage: 'url('+ item.adCover +')'}">
                </div>
                <div class="card-list-content">
                  <div class="card-list-title">{{ item.title }}</div>
                  <div class="card-list-text">{{ item.subTitle }}</div>
                  <div class="card-list-tips">
                    <div class="tag-row">
                      <tag-btn
                        v-if="index < 2"
                        v-for="(tag, index) in item.adFlag.split(',')"
                        :key="index"
                        :title="tag"
                        class="tag-list"
                      ></tag-btn>
                      <span v-if="item.adFlag.split(',').length > 1" class="main-color">...</span>
                    </div>
                    <div class="main-color">立即考察</div>
                  </div>
                </div>
              </div>
              <div v-if="park.loadMore && park.loading" class="tc-row">正在加载...</div>
              <div v-if="park.loadMore && park.noMore" class="tc-row">已加载完所有信息</div>
            </div>
            <div class="no-more-row" v-else>暂无相关信息</div>
            <div
              v-if="!park.loadMore"
              class="read-more"
              @click="loadMore(park)"
            >
              <span>更多</span>
              <i class="read-more-icon icon iconfont icon-jiantou"></i>
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
export default {
  name: 'Investment',
  components: {
    moreBtn,
    tagBtn
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
    tabPark (index) {
      this.activeItem = this.parkList[index]
    },
    handleScroll () {
      window.onscroll = () => {
        // 文档内容实际高度（包括超出视窗的溢出部分）
        const scrollHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight)
        // 滚动条滚动距离
        const scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
        // 窗口可视范围高度
        const clientHeight = window.innerHeight || Math.min(document.documentElement.clientHeight, document.body.clientHeight)
        if (clientHeight + scrollTop >= scrollHeight - 10) {
          // 到底部加载信息
          this.getMore()
        }
      }
    },
    getMore () {
      // tab的查看更多被点击且不是加载中状态且没有全部加载完再执行
      if (this.activeItem.loadMore && !this.activeItem.loading && !this.activeItem.noMore) {
        // 如果当前没有选中的tab，则取第一个
        if (!this.activeItem.hasOwnProperty('query')) {
          this.activeItem = this.parkList[this.activePark]
        }
        this.activeItem.query.page++
        this.getPartDetail(this.activeItem)
      }
    },
    init () {
      this.getPartList()
        .then(() => {
          this.parkList.forEach((item, index) => {
            const query = {
              parkId: item.id,
              page: 1,
              rows: 10
            }
            // 在tab对象上set属性
            this.$set(item, 'noMore', false)
            this.$set(item, 'loading', false)
            this.$set(item, 'query', query)
            this.$set(item, 'allList', [])
            this.$set(item, 'list', [])
            this.$set(item, 'loadMore', false)
            this.$nextTick(() => {
              this.getPartDetail(item)
                .then((data) => {
                  const rows = data.rows
                  let list
                  let flag
                  if (rows.length > 2) {
                    list = rows.slice(0, 2)
                    flag = false
                  } else {
                    list = rows
                    flag = true
                  }
                  item.list = list
                  item.loadMore = flag
                })
            })
          })
        })
      Promise.all([
        this.getBanner(),
        this.getBusinessAdDynamic(),
        this.getBusinessAdPolicy()
      ])
        .then(() => {
          const swiper = new Swiper('.swiper-container', {
            autoplay: true
          })
          console.dir(swiper)
          this.handleScroll()
        })
    },
    loadMore (park) {
      // 点击查看按钮
      park.loadMore = true
      park.list = park.allList
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
    getBusinessAdDynamic () {
      return new Promise((resolve, reject) => {
        this.api.get({
          url: 'getBusinessAdDynamic',
          callback: (res) => {
            if (res.code === '0000') {
              this.businessAdDynamic = res.data
              resolve()
            } else {
              reject(res.data)
            }
          }
        })
      })
    },
    getBusinessAdPolicy () {
      return new Promise((resolve, reject) => {
        this.api.get({
          url: 'getBusinessAdPolicy',
          callback: (res) => {
            if (res.code === '0000') {
              this.businessAdPolicy = res.data
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
    },
    getPartDetail (item) {
      return new Promise((resolve, reject) => {
        item.loading = true
        this.api.get({
          url: 'getBusinessAdContent',
          data: item.query,
          callback: (res) => {
            if (res.code === '0000') {
              const rows = res.data.rows
              item.loading = false
              if (res.data.rows.length < item.query.rows) {
                item.noMore = true
              }
              item.allList = item.allList.concat(rows)
              resolve(res.data)
            } else {
              reject(res.data)
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
    padding-top: 150px;
    @include image($url:'~@/assets/image/investment-bg.png', $bg: #fff);
    .tc-row {
      padding: 20px;
      text-align: center;
      font-size: 12px;
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
      padding: 0 40px;
    }
    .card-list {
      margin: 4px auto;
      display: flex;
      align-items: center;
      padding: 31px 40px;
      background-color: #fff;
    }
    .card-list-poster {
      background-size: cover;
      width: 180px;
      height: 180px;
      overflow: hidden;
      border-radius: 8px;
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
      font-size: 32px;
      font-weight:bold;
      color:rgba(34,34,34,1);
      @include clamp(1);
    }
    .card-list-text {
      width: 100%;
      height: 72px;
      line-height: 36px;
      margin: 10px 0;
      @include clamp(2);
      color: #666666;
    }
    .card-list-tips {
      display: flex;
      justify-content: space-between;
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
      border-bottom: 40px solid #fafafa;
      background-color: #fff;
      &.br-n {
        border-bottom: none;
      }
      &:last-of-type {
        border-bottom: none;
      }
      .investment-park {
        line-height: 50px;
        letter-spacing: 4px;
        padding: 0 40px;
      }
      .investment-block-title {
        padding: 20px 40px;
        @include flex($h: space-between);
        .block-title {
          font-size: 40px;
          font-weight: 600;
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
      }
      .more-desc {
        position: absolute;
        right: 0;
        bottom: 0;
      }
    }
    .investment-banner {
      margin: 40px auto;
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

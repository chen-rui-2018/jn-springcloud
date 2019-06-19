<template>
  <div class="investmentPolicy">
    <div
      v-for="(item, index) in list"
      :key="index"
      class="card-list"
      @click="$router.push({path:'/enterpriseInformation',query:{propagandaId: item.id}})"
    >
      <div class="card-list-poster" :style="{backgroundImage: 'url(' + item.posterUrl + ')'}">
      </div>
      <div class="card-list-content">
        <div class="card-list-title">{{ item.propagandaTitle }}</div>
        <div class="card-list-text">{{ item.propagandaDetails }}</div>
        <div class="card-list-tips">
          <span>{{ item.createdTime }}</span>
          <span class="flex-center">
              <i class="view-icon icon iconfont icon-view"></i>
              <span class="card-list-warning">{{ item.viewCount }}</span>
            </span>
        </div>
      </div>
    </div>
    <now-loading v-show="loading"></now-loading>
    <no-more v-show="noMore"></no-more>
  </div>
</template>

<script>
import nowLoading from '@/views/common/nowLoading'
import noMore from '@/views/common/noMore'
export default {
  components: {
    nowLoading,
    noMore
  },
  mounted () {
    this.init()
  },
  data () {
    return {
      list: [],
      query: {
        needPage: 1,
        page: 1,
        rows: 10
      },
      loading: false,
      noMore: false
    }
  },
  methods: {
    init () {
      this.getData()
      this.handleScroll()
    },
    getData () {
      this.loading = true
      this.api.get({
        url: 'getPromotionList',
        data: this.query,
        callback: res => {
          if (res.code === '0000') {
            const rows = res.data.rows
            this.list = this.list.concat(rows)
            if (rows.length < this.query.rows) {
              this.noMore = true
            }
          }
          this.loading = false
        }
      })
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
      if (!this.loading && !this.noMore) {
        // 如果当前没有选中的tab，则取第一个
        this.query.page++
        this.getData()
      }
    }
  }
}
</script>

<style lang="scss" scoped>
  @import '~@/assets/styles/common';
  .card-list {
    margin: 4px auto;
    display: flex;
    align-items: center;
    padding: 31px 40px;
    background-color: #fff;
    cursor: pointer;
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
</style>

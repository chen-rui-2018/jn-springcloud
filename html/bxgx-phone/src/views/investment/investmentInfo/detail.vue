<template>
  <div class="investment-policy">
    <div class="investment-policy-header">
      <div class="investment-policy-title">{{ detail.title }}</div>
      <div class="investment-flex-row">
        <div>
          <span>发布时间</span>
          <span>{{ detail.startTime }}</span>
        </div>
        <div>
          <span>阅读次数</span>
          <span>{{ detail.viewCount }}次</span>
        </div>
      </div>
    </div>
    <div class="investment-policy-main">
      <div class="investment-policy-title">【详情】</div>
      <div class="investment-policy-desc">{{ detail.subTitle }}</div>
      <div class="tag-row">
        <tag-btn
          v-for="(tag, index) in detail.adFlag.split(',')"
          :key="index"
          :title="tag"
          class="tag-list"
        ></tag-btn>
      </div>
      <img :src="detail.adCover" class="detail-image"  alt="">
      <!--    <div class="park-poster" :style="{backgroundImage: 'url(' + detail.adCover + ')'}"></div>-->
      <div class="investment-policy-content" v-html="detail.content"></div>
    </div>
  </div>
</template>

<script>
import tagBtn from '../common/tagBtn'
export default {
  components: {
    tagBtn
  },
  data () {
    return {
      detail: {}
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    init () {
      this.getPolicyDetails()
    },
    getPolicyDetails () {
      this.api.get({
        url: 'getBusinessAdContentInfo',
        data: {
          id: this.$route.query.id
        },
        callback: res => {
          if (res.code === '0000') {
            this.detail = res.data
          } else {

          }
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  @import '~@/assets/styles/common';
  .investment-policy {
    margin-bottom: 40px;
    .tag-row {
      margin-bottom: 20px;
      @include flex($h: flex-start);
      .tag-list {
        margin-right: 10px;
      }
    }
    .investment-policy-main {
      padding: 20px;
      .investment-policy-content {
        margin: 20px auto;
        line-height: 40px;
      }
      .detail-image {
        width: 100%;
        border-radius: 10px;
      }
    }
    .investment-policy-header {
      padding: 20px;
      border-top: 1px solid rgba(238,238,238,1);
      border-bottom: 1px solid rgba(238,238,238,1);
    }
    .investment-policy-desc {
      color: #666;
      font-size: 28px;
      text-indent: 2em;
      line-height: 38px;
      margin-bottom: 20px;
    }
    .investment-policy-title {
      line-height: 40px;
      font-size: 30px;
      font-weight:bold;
      color:rgba(51,51,51,1);
      color: #333333;
      padding: 30px 0 20px;
    }
    .park-poster {
      height: 300px;
      background-size: cover;
      background-repeat: no-repeat;
      border-radius: 10px;
      overflow: hidden;
    }
  }
  .investment-flex-row {
    @include flex($h: space-between);
    color: #999;
  }
</style>

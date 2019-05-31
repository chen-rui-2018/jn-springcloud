<template>
    <div class="investmentPolicy">
      <div
        v-for="(item, index) in list"
        :key="index"
        class="card-list"
        @click="$router.push({path:'/investmentInfoDetail',query:{id: item.id}})"
      >
        <div class="card-list-poster" :style="{backgroundImage: 'url(' + item.adCover + ')'}">
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
    </div>
</template>

<script>
import tagBtn from '../common/tagBtn'
export default {
  components: {
    tagBtn
  },
  mounted () {
    this.init()
  },
  data () {
    return {
      list: [],
      query: {
        page: 1,
        rows: 500,
        parkId: '',
        keyWords: ''
      }
    }
  },
  methods: {
    init () {
      this.getData()
    },
    getData () {
      this.api.get({
        url: 'getBusinessAdContent',
        data: this.query,
        callback: res => {
          if (res.code === '0000') {
            this.list = res.data.rows
            this.total = res.data.total
          } else {
            this.$message.error(res.result);
          }
        }
      })
    }

  }
}
</script>

<style lang="scss" scoped>
  @import '~@/assets/styles/common';
  .tag-row {
    @include flex($h: flex-start);
    .tag-list {
      margin-right: 10px;
    }
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
</style>

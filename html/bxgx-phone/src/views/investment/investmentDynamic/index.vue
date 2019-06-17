<template>
    <div class="investmentPolicy">
      <div
        v-for="(item, index) in list"
        :key="index"
        class="card-list"
        @click="$router.push({path:'/investmentDynamicDetail',query:{id: item.id}})"
      >
        <div class="card-list-poster" :style="{backgroundImage: 'url(' + item.adCover + ')'}">
        </div>
        <div class="card-list-content">
          <div class="card-list-title">{{ item.title }}</div>
          <div class="card-list-text">{{ item.content }}</div>
          <div class="card-list-tips">
            <span>{{ item.startTime }}</span>
            <span class="flex-center">
                  <span class="card-list-warning">{{ item.viewCount }}</span>
                </span>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
export default {
  mounted () {
    this.init()
  },
  data () {
    return {
      list: []
    }
  },
  methods: {
    init () {
      this.getData()
    },
    getData () {
      this.api.get({
        url: 'getBusinessAdDynamic',
        callback: res => {
          if (res.code === '0000') {
            this.list = res.data
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

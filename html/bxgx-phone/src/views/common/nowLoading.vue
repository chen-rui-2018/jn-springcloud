<template>
  <div class="tc-row">
    <loadingSpinner/>
    <div class="tc-row-title">{{ title }}</div>
  </div>
</template>

<script>
import loadingSpinner from './loadingSpinner'
export default {
  name: 'NowLoading',
  components: {
    loadingSpinner
  },
  props: {
    title: {
      type: [String, Number],
      required: false,
      default: '正在加载...'
    }
  }
}
</script>

<style lang="scss" scoped>
  @import '~@/assets/styles/common';
  .tc-row {
    @include flex;
    padding: 30px;
    text-align: center;
    font-size: 28px;
    color: #666;
    .tc-row-title {
      margin-left: 10px;
    }
  }
</style>

<template>
    <span class="more-btn">
      <span>详细</span><i class="icon iconfont icon-jiantou"></i>
    </span>
</template>

<script>
export default {
  name: "MoreBtn"
}
</script>

<style lang="scss" scoped>
  @import '~@/assets/styles/common';
  .more-btn {
    @include flex($h: flex-satrt);
    color: $--color-primary;
    cursor: pointer;
  }
</style>

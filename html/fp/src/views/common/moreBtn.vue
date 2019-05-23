<template>
    <span class="more-btn">
      <span>MORE</span><i class="el-icon-arrow-right"></i>
    </span>
</template>

<script>
    export default {
        name: "MoreBtn"
    }
</script>

<style lang="scss" scoped>
  @import "~@/css/common";
  .more-btn {
    color: $--color-primary;
    cursor: pointer;
  }
</style>

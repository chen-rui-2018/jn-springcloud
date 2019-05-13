<template>
  <div class="notice-bg">
    <div class="notice-header">
      <span class="space-dot"></span>
      <span class="notice-title">企业邀请</span>
    </div>
    <div class="notice-main">
      <div class="notice-dot"></div>
      <slot/>
    </div>
  </div>
</template>

<script>
export default {
  name: "notcie"
}
</script>

<style lang="scss" scoped>
@import "~@/css/r-common";
@import "~@/css/common";
.notice-bg {
  background-color: #fff;
  padding: trsw(40);
  .notice-header {
    @include flex($h: flex-start, $v: center);
    .space-dot {
      display: inline-block;
      width: trsw(5);
      height: trsw(19);
      background-color: $--color-primary;
      margin-right: trsw(15);
    }
    .notice-title {

    }
  }
  .notice-main {
    width: 100%;
    height: trsw(74);
    padding: trsw(23);
    margin-top: trsw(21);
    background-color: #F2F6F3;
    border-radius: 5px;
    @include flex($h: flex-start, $v: center);
    .notice-dot {
      width: trsw(9);
      height: trsw(9);
      margin-right: 6px;
      border-radius: 50%;
      background-color: $--color-primary;
    }
  }
}
</style>

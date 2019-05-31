<template>
  <div class="arrow-down-bg" :class="{line: line}">
    <div class="arrow-down">
      <i class="el-icon-arrow-down"> </i>
    </div>
  </div>
</template>

<script>
export default {
   name: "arrowDown",
  props: {
     line: {
       type: Boolean,
       default: false,
       required: false
     }
  }
 }
</script>

<style lang="scss" scoped>
  @import "~@/css/common";
  @import "~@/css/r-common";
  $ize: 36px;
  .arrow-down-bg {
    height: $ize;
    &.line {
      /*border-top: 1px solid #eee;*/
      width: 100%;
      @include flex-center;
    }
  }
  .arrow-down {
    width: $ize;
    height: $ize;
    transform: translateY(-50%);
    background-color: #fff;
    @include flex-center;
    border-radius: 50%;
    overflow: hidden;
    box-shadow: 0 1px 6px 1px rgba(144,144,144,0.73);
    color: $--color-primary;
  }
</style>

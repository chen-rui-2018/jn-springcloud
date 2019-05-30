<template>
  <div class="target-frame">
    <div class="target-frame-l">
      <slot name="left"/>
    </div>
    <div class="target-frame-r">
      <slot name="right"/>
    </div>
  </div>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
  @import "~@/styles/r-common";
  .target-frame {
    $gray: #ebebeb;
    min-height: 100%;
    border: 1px solid $gray;
    @include flex($v: flex-start);
    background-color: #fff;
    align-items: stretch;
    .target-frame-l {
      max-height: 500px;
      overflow: auto;
      width: 200px;
      padding: 10px;
      flex: none;
    }
    .target-frame-r {
      min-height: 100%;
      width: calc(100% - 200px);
      padding: 15px;
      border-left: 1px solid $gray;
      .target-row {
        margin: 5px auto;
      }
    }
    .submit-row {
      margin: 20px 10px;
    }
  }
</style>

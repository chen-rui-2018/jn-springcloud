<template>
  <div class="table-row bg-gray">
    <div class="row-l">{{ title }}</div>
    <div class="row-r">
      <slot/>
    </div>
  </div>
</template>

<script>

export default {
  name: '',
  props: {
    title: {
      type: String,
      default() {
        return '标题'
      }
    }
  }
}
</script>

<style lang="scss" scoped>
  @import "~@/styles/r-common";
  $gray: #ccc;
  .table-row {
    width: 100%;
    @include  flex($v: stretch);
    border: 1px solid $gray;
    .row-l {
      width: 10%;
      padding: 10px;
      @include flex-center;
      border-right: $gray;
      color: #A8A8A8;
    }
    .row-r {
      @include flex($v: flex-start, $d: column);
      width: 90%;
      padding: 20px;
      font-size: 14px;
      background-color: #fff;
    }
  }
</style>

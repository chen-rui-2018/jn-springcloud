<template>
  <div class="tip" :class="type">{{ text }}</div>
</template>

<script>
  export default {
    name: "Tips",
    props: {
      type: {
        type: String,
        required: false,
        default: 'left'
      },
      text: {
        type: String,
        required: true
      },
    },
  }
</script>

<style lang="scss" scoped>
  @import "~@/css/r-common";
  @import "~@/css/common";
  $br: transparent;
  .tip {
    position: relative;
    display: inline-block;
    padding: 10px;
    min-width: 10px;
    min-height: 19px;
    background-color: #F3F3F3;
    color: #333;
    text-align: left;
    border-radius: 4px;
    word-break: break-all;
    &.right {
      background-color: $--color-primary;
    }
  }
  .tip:after {
    content: '';
    position: absolute;
    width: 0;
    height: 0;
    color: $br;
    border: 6px solid;
  }
  .right:after {
    color: $br;
    border-left-color: $--color-primary;
    left: 100%;
    top: 14px;
  }
  .left:after {
    color: $br;
    border-right-color: #F3F3F3;
    top: 14px;
    right: 100%;
  }
</style>

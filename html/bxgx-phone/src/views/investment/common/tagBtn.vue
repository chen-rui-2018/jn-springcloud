<template>
    <div class="tab-btn">{{ title }}</div>
</template>

<script>
export default {
  name: 'TagBtn',
  props: {
    title: {
      type: [String, Number],
      default: '标题',
      required: false
    }
  }
}
</script>

<style lang="scss" scoped>
  @import '~@/assets/styles/common';
  .tab-btn {
    padding: 10px;
    background-color: #ECFCF2;
    color: #41D787;
    border: 1px solid #41D787;
    border-radius: 10px;
    cursor: pointer;
  }
</style>

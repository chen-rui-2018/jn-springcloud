<template>
  <div class="tc-row">{{ title }}</div>
</template>

<script>
export default {
  name: 'NoMore',
  props: {
    title: {
      type: [String, Number],
      required: false,
      default: '已加载完所有信息'
    }
  }
}
</script>

<style lang="scss" scoped>
  .tc-row {
    padding: 30px;
    text-align: center;
    font-size: 28px;
    color: #666;
  }
</style>

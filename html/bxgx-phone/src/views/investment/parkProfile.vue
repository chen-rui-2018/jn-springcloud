<template>
  <div class="park-profile">
    <div class="park-profile-title">[详情]</div>
  </div>
</template>

<script>
export default {
  name: 'ParkProfile',
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
  .park-profile {
    .park-profile-title {
      font-size: 30px;
      color: #333333;
    }
  }
</style>

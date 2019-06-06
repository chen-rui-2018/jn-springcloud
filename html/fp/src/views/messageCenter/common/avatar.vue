<template>
  <img :src="url || '@/../static/img/touxiang.png'" alt="" class="chat-avatar" :class="size">
</template>

<script>
export default {
  name: "Avatar",
  props: {
    size: {
      type: String,
      required: false,
      default: 'middle'
    },
    url: {
      type: String,
      required: false,
      default: ''
    }
  }
}
</script>

<style lang="scss" scoped>
  img {
    display: block;
    border-radius: 50%;
    &.middle {
      width: 42px;
      height: 42px;
    }
    &.small {
      width: 32px;
      height: 32px;
    }
  }
</style>

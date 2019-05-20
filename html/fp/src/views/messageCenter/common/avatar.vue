<template>
  <img :src="url" alt="" class="chat-avatar" :class="size">
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
      default: 'http://img.52z.com/upload/news/image/20180801/20180801112618_87503.jpg'
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

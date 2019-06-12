<template>
  <div class="text" v-html="text">

  </div>
</template>
<script>
export default {
  data () {
    return {
      text: ''
    }
  },
  mounted () {
    this.text = this.$route.query.text
  }
}
</script>
<style lang="scss">
  .text{
    padding:20px 20px;
  }
</style>

<template>
  <div >
    {{ message1 }}{{ message2 }}
  </div>
</template>

<script>
export default {
  props: {
    message1: { type: String,
      default: ''
    },
    message2: { type: String,
      default: '' }
  }
}
</script>

<style lang="scss" scoped>
   div{

       padding: 15px;
       border-bottom: 1px solid #f6f6f6;
   }
</style>

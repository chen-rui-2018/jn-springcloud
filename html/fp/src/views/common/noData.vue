<template>
    <div class="no-data-bg">
      <img class="no-data-pic" src="@/../static/img/no-data.png" alt="">
      <div class="no-data-desc">{{ title }}</div>
    </div>
</template>

<script>
  export default {
    name: "NoData",
    props: {
      title: {
        type: [String, Number],
        required: false,
        default: '抱歉，没有找到相关信息'
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "~@/css/common";
  .no-data-bg {
    width: 100%;
    background-color: #fff;
    .no-data-pic {
      width: 100%;
      max-height: 500px;
      display: block;
    }
    .no-data-desc {
      padding: 20px;
      text-align: center;
      font-weight:500;
      color:rgba(102,102,102,1);
    }
  }
</style>

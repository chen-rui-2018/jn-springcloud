<template>
  <div class="notice-bg">
    <div class="notice-header">
      <span class="space-dot"></span>
      <span class="notice-title">{{ title }}</span>
    </div>
    <div class="notice-main">
      <div class="notice-main-cell" :class="type" v-if="content">
<!--        <div class="notice-dot"></div>-->
        <slot v-if="slotContent"/>
        <div v-else v-html="content"></div>
      </div>
      <div class="no-message" v-else>暂无信息</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "notcie",
  props: {
    title: {
      type: String,
      default: '标题',
      required: false
    },
    slotContent: {
      type: Boolean,
      default: false,
      required: false
    },
    type: {
      type: String,
      default: 'primary',
      required: false
    },
    content: {
      type: [String, Boolean, Number],
      default: '',
      required: false
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~@/css/r-common";
@import "~@/css/common";
.notice-bg {
  background-color: #fff;
  padding: 18px 25px;
  margin: 6px auto;
  border-radius: 3px;
  .notice-header {
    @include flex($h: flex-start, $v: center);
    .space-dot {
      display: inline-block;
      width: trsw(5);
      height: trsw(19);
      background-color: $--color-primary;
      margin-right: trsw(15);
    }
    .notice-title {

    }
  }
  .notice-main {
    width: 100%;
    margin-top: trsw(21);
    border-radius: 5px;
    box-sizing: border-box;
    .notice-main-cell {
      padding: 18px 24px;
      &.primary {
        background-color: #F2F6F3;
      }
      &.info {
        background-color: #FBF8F4;
      }
    }
    .no-message {
      width: 100%;
      margin: 0 auto;
      color: #999;
      border-top:1px solid rgba(238,238,238,1);
      text-align: center;
      padding: 10px 0;
    }
    .notice-dot {
      width: trsw(9);
      height: trsw(9);
      margin-right: 6px;
      border-radius: 50%;
      background-color: $--color-primary;
    }
  }
}
</style>

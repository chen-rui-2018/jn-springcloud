<template>
  <div class="r-tag" :class="type">{{ title }}</div>
</template>

<script>
 export default {
   name: "tag",
   props: {
     type: {
       type: String,
       required: true
     },
     title: {
       type: String,
       required: false,
       default: '标题'
     }
   }
 }
</script>

<style lang="scss" scoped>
  @import "~@/css/r-common";
  .r-tag {
    width: trsw(127);
    height: trsw(41);
    border-radius: 5px;
    font-size: 12px;
    cursor: pointer;
    &:hover {
      opacity: .8;
    }
  @include flex-center;
  &.blue {
    $color: #55A6FF;
    color: $color;
    background:rgba(228,240,255,1);
    border:2px solid rgba(85,166,255,1);
   }
    &.green {
      $color: #41D787;
      color: $color;
      background:rgba(236,252,242,1);
      border:2px solid rgba(65,215,135,1);
    }
    &.orange {
      $color: #FFBD5C;
      color: $color;
      background:rgba(254,245,229,1);
      border:2px solid rgba(255,189,92,1);
    }
    &.purple {
      $color: #FF56B6;
      color: $color;
      background:rgba(255,233,246,1);
      border:2px solid rgba(255,86,182,1);
    }
  }
</style>

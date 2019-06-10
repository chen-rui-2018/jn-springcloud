<template>
  <div class="adniministrativeHeader">
    <x-header :left-options="{backText: ''}">{{this.$route.meta.title}}</x-header>

  </div>
</template>
<script>
import { XHeader } from 'vux'
export default {
  components: {
    XHeader
  }
}
</script>
<style lang="scss">
  .adniministrativeHeader{
    z-index: 10;
    position: fixed;
    top:0;
    width: 100%;
    background: #fff;
    padding:30px 34px;
    .vux-header{
      background-color: #fff;
      text-align: center;
      .vux-header-title,.vux-header-left{
        font-size: 32px;
        color:#333333;
      }
      .vux-header-left .left-arrow:before{
        content: "";
        border-color:#333;
        width:20px;
        height: 20px;
      }
      .vux-header-right{
        color:#333333;
        font-size: 26px;
      }
    }
  }
</style>

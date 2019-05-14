<template>
  <div class="adniministrativeHeader">
    <!-- <x-header></x-header> -->
    <x-header :left-options="{backText: ''}">{{this.$route.meta.title}} <span slot="right" v-if="this.$route.name==='serviceDetail'||this.$route.name==='declarationDetail'">咨询</span></x-header>
  </div>
</template>
<script>

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

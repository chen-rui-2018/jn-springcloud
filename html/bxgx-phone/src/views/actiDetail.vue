<template>
    <div class="actiDetail">
        <div class="navTit">
            <i class="mint-toast-icon mintui mintui-back"></i>
            <span class="detail">详情</span>
        </div>
        <div class="actiMain">
            <div class="actiImg">
                <img src="" alt="">
            </div>
            <div class="actiTit">白下高新园区重阳登高</div>
        </div>
    </div>
</template>
<script>
// import { Toast } from 'mint-ui'
export default {
  data () {
    return {}
  },
  methods: {}
}
</script>
<style lang="scss" scoped>
.actiDetail {
  .navTit {
    padding: 30px 37px;
    display: flex;
    // justify-content: space-around;
    align-items: center;
    font-size: 32px;
    color: #333;
    .mint-toast-icon {
      font-size: 32px;
      margin-right: 290px;
    }
  }
  .actiMain {
    .actiImg {
      height: 357px;
      margin-left: 3px;
      width: 100%;
      background: #00a041;
      img {
        height: 100%;
        width: 100%;
      }
    }
    .actiTit {
      padding: 39px;
      color: #42454a;
      font-size: 36px;
    }
  }
}
</style>

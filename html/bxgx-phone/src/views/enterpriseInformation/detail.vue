<template>
    <div class="policyDetails">
        <div class="policyTitle">
            <p class="anTitle">《{{detail.propagandaTitle}}》</p>
            <div class="anTime">
                <span>{{detail.createdTime}}</span>
                <span>{{detail.viewCount}}人浏览</span>
            </div>
        </div>
        <div class="anContent" v-html="detail.propagandaDetails"></div>
    </div>
</template>
<script>
export default {
  data () {
    return {
      detail: {}
    }
  },
  mounted () {
    this.getPolicyDetails()
  },
  methods: {
    // 政策指南详情
    getPolicyDetails () {
      let _this = this
      this.api.get({
        url: 'getPromotionDetails',
        data: {
          propagandaId: this.$route.query.propagandaId
        },
        callback: function (res) {
          if (res.code === '0000') {
            _this.detail = res.data
          } else {
            _this.$vux.toast.text(res.result)
          }
        }
      })
    }
  }
}
</script>
<style lang="scss">
.policyDetails {
  background: #f5f5f5;
  .policyTitle,.anContent {
    background: #fff;
    text-indent: 2em;
  }
  .anTitle{
      color:#333;
      font-size: 34px;
      padding:20px;
      font-weight: bold;
      line-height: 50px;
  }
  .anTime{
      display: flex;
      justify-content: space-between;
      align-items: center;
      font-size: 24px;
      color:#A2A2A2;
      padding:20px;
  }
  .level{
      border-top:1px solid #eee;
      padding:20px;
      font-size: 24px;
      color:#666;
      font-weight: bold;
      >span{
          margin-right:30px;
          display: inline-block;
          line-height: 40px;
      }
  }
  .anContent{
      margin-top:20px;
      padding:20px;
      color:#333;
      font-size: 26px;
      line-height: 40px;
  }
}
</style>

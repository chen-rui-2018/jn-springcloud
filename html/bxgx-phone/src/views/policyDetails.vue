<template>
    <div class="policyDetails">
        <div class="policyTitle">
            <p class="anTitle">《{{getGuideDetal.policyTitle}}》</p>
            <div class="anTime">
                <span>{{getGuideDetal.releaseDate}}</span>
                <span>{{getGuideDetal.readNum}}人浏览</span>
            </div>
            <div class="level">
                <span>级别：{{getGuideDetal.policyLevelName}}</span>
                <span>支持方式：<span v-if="getGuideDetal.supportMethod==1">奖励</span><span v-if="getGuideDetal.supportMethod==2">其他</span></span>
                <span>支持产业：<span v-if="getGuideDetal.supportIndustry==1">所有产业</span><span v-if="getGuideDetal.supportIndustry==2">其他</span></span>
                <span>发文单位：{{getGuideDetal.issueUnit}}</span>
            </div>
        </div>
        <div class="anContent" v-html="getGuideDetal.policyContent"></div>
    </div>
</template>
<script>
export default {
  data () {
    return {
      getGuideDetal: {}
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
        url: 'getPolicyDetails',
        data: {
          policyId: this.$route.query.policyId
        },
        callback: function (res) {
          if (res.code === '0000') {
            _this.getGuideDetal = res.data
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
  // padding-top: 130px;
  background: #f5f5f5;
  .policyTitle,.anContent {
    // margin-top: 20px;
    background: #fff;
    // padding:20px;
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
      // max-width:100%
      // width: 100%;
      // overflow: hidden;
  }
}
</style>

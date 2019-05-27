<template>
  <div class="declarationDetail">
    <div class="declarationDetail_main">
      <div class="declarationDetail_top">
        <div class="declarationDetail_title">
          <p>{{detailData.rangeName}} </p>
          <p><span>{{detailData.browseTimes}}次阅读 </span><span>{{detailData.createdTime|time}}</span></p>
        </div>
      </div>
      <div class="declarationDetail_middle">
        <span v-html="detailData.announcementContent"></span>
      </div>
      <div class="declarationDetail_downLoad">
        <div class="downLoad_title">附件下载</div>
        <!-- fileUrl字段可能是多个 -->
        <div class="accessory" >
          <span>附件</span>
          <span>下载<i class="iconfont icon-jiantou"></i></span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      id: '',
      detailData: {}
    }
  },
  filters: {
    time (time) {
      if (time) {
        // return time.split("T")[0]
        let dateee = new Date(time).toJSON()
        return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
      }
    }
  },
  mounted () {
    this.id = this.$route.query.id
    this.getDetail()
    this.addView()
  },
  methods: {
    getDetail () {
      this.api.get({
        url: 'talentsDetail',
        data: {id: this.id},
        callback: res => {
          if (res.code === '0000') {
            this.detailData = res.data
          }
        }
      })
    },
    addView () {
      this.api.get({
        url: 'talentsVolume',
        data: {id: this.id},
        callback: res => {
          if (res.code === '0000') {
            // this.detailData = res.data
          }
        }
      })
    }

  }
}
</script>
<style lang="scss">
  .declarationDetail{
    height: 100vh;
    background-color: #f5f5f5;
    margin-top: 110px;
    .declarationDetail_main{
      padding-top:26px;
      .declarationDetail_top{
        background-color: #fff;
        .declarationDetail_title{
          padding: 0 34px;
          border-bottom: 3px solid #efefef;
          p:nth-child(1){
            font-size: 34px;
            padding:28px 0;
          }
          p:nth-child(2){
            padding-top: 6px;
            padding-bottom: 24px;
            font-size: 23px;
            color:#999;
            display: flex;
            justify-content: space-between;
          }
        }
        .time_node{
          margin: 0 34px;
          padding-bottom: 29px;
          div{
            padding-top:30px;
            font-size: 34px;
          }
          p{
            border-bottom: 2px solid #efefef;
            padding:30px 68px;
            font-size: 26px;
            &:last-child{
              border-bottom: none;
            }
            i{
              color:#07ab50;
              font-size: 30px;
              padding-right: 19px;
            }
          }
        }
      }
      .declarationDetail_middle{
        margin-top: 26px;
        background-color: #fff;
        padding:61px 34px 51px 34px;
      }
      .declarationDetail_downLoad{
        margin-top: 26px;
        padding:0 34px;
        background-color: #fff;

        .downLoad_title{
          font-size: 34px;
          padding-top: 30px;
          padding-bottom: 10px;
        }
        .accessory{
          display: flex;
          justify-content: space-between;
          font-size: 26px;
          border-bottom: 2px solid #efefef;
          &:last-child{
            border-bottom: none;
          }
          span{
            padding:35px 0;
          }
          span:nth-child(2){
            color:#999999;
            font-size: 22px;
          }
        }
      }
    }
  }
</style>

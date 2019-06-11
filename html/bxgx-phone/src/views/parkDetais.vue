<template>
    <div class="announcementDetails">
        <div class="announcementTitle">
            <div class="anTitle">{{noticeDetail.noticeTitle}}</div>
            <div class="anTime">{{noticeDetail.createdTime}}</div>
        </div>
        <div class="anContent" v-html="noticeDetail.noticeDetails"></div>
    </div>
</template>
<script>
export default {
  data () {
    return {
      noticeDetail: {}
    }
  },
  mounted () {
    this.findNoticeDetails()
  },
  methods: {
    // 公告详情
    findNoticeDetails () {
      this.api.get({
        url: 'findNoticeDetails',
        data: {
          // noticeId: '536d4e9c22a1465dbb1f1644f793e900'
          noticeId: this.$route.query.noticeId
        },
        callback: res => {
          if (res.code === '0000') {
            this.noticeDetail = res.data
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
.announcementDetails {
  // padding-top:120px;
  // padding:120px 20px 20px;
  padding:0 20px;
  .announcementTitle{
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom:20px;
  }
 .anTitle{
     font-size: 30px;
     color:#333;
 }
 .anTime{
     font-size: 24px;
     color:#A2A2A2;
 }
 .anContent{
     font-size: 26px;
     color:#666;
 }
}
</style>

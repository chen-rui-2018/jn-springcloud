<template>
<div>
  <!-- <div class="declarationDetailHeader" v-if="isShow===1">
    <x-header :left-options="{backText: ''}">{{this.$route.meta.title}} <span slot="right" @click="$router.push({path: '/guest/pd/consult'})"></span></x-header>
  </div> -->
  <div class="declarationDetail">
    <div class="declarationDetail_main">
      <div class="declarationDetail_top">
        <div class="declarationDetail_title">
          <p>{{detailData.titleName}}</p>
          <p><span>{{detailData.browseTimes}}次阅读 </span><span>{{detailData.createdTime|time}}</span></p>
        </div>
        <div class="time_node">
          <div>时间节点</div>
          <p v-if="detailData.deadline!=null"><i class="iconfont icon-clock-"></i>{{detailData.deadline|time}}反馈表递交截止</p>
          <p v-else>暂无</p>
        </div>
      </div>
      <div class="declarationDetail_middle">
        <span v-html="detailData.announcementContent"></span>
      </div>
      <div class="declarationDetail_downLoad">
        <div class="downLoad_title">附件下载</div>
        <!-- fileUrl字段可能是多个 -->
        <div class="accessory" v-if="fileList.length===0">
          <a href="javascript:;">
            <span>附件: 暂无</span>
          </a>
        </div>
        <div v-else  class="accessory" v-for="(item,index) in fileList" :key="index" @click="download(item.filePath)">
          <!-- <a :href="item.filePath"> {{item.fileName}}-->
            <span>附件：{{item.fileName}}</span>
            <span>下载<i class="iconfont icon-jiantou"></i></span>
          <!-- </a> -->
        </div>
      </div>
      <div class="declaration_consult" @click="goConsult">预约申报</div>
    </div>
  </div>
</div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      id: '',
      detailData: {},
      isShow: 1,
      fileList: []
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
  created () {
    this.addView()
  },
  mounted () {
    this.id = this.$route.query.id
    if (this.$route.query.isShow === '0') {
      this.isShow = this.$route.query.isShow
    }
    this.getDetail()
  },
  methods: {
    getDetail () {
      this.api.get({
        url: 'selectByTalentNotice',
        data: {id: this.id},
        callback: res => {
          if (res.code === '0000') {
            this.detailData = res.data
            if (res.data.fileUrl !== '') {
              this.fileList = JSON.parse(res.data.fileUrl)
            } else {
              this.$vux.toast.text(res.result)
            }
          }
        }
      })
    },
    addView () {
      this.api.get({
        url: 'trafficVolume',
        data: {id: this.id},
        callback: res => {
          if (res.code === '0000') {
            // this.detailData = res.data
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    download (item) {
      axios.get(`${this.api.host}${this.api.apiURL.downLoadAttachment}`, {
        params: {
          title: item.title,
          url: item.url
        },
        headers: {
          token: sessionStorage.token
        }
      })
        .then(res => {
          window.location.href = res.request.responseURL
        })
    },
    goConsult () {
      let myDate = new Date()
      let myDateStr = myDate.getFullYear() + '' + (myDate.getMonth() + 1 > 10 ? myDate.getMonth() + 1 : '0' + (myDate.getMonth() + 1)) + '' + myDate.getDate() + '' + (myDate.getHours() > 10 ? myDate.getHours() : '0' + myDate.getHours()) + (myDate.getMinutes() > 10 ? myDate.getMinutes() : '0' + myDate.getMinutes()) + (myDate.getSeconds() > 10 ? myDate.getSeconds() : '0' + myDate.getSeconds())
      let time = new Date(this.detailData.preliminaryDeadline).toJSON()
      let deadline = new Date(+new Date(time) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '').replace(/[^0-9]/ig, '')
      if (myDateStr < deadline) {
        this.$router.push({path: '/guest/pd/consult', query: {id: this.id}})
      } else {
        this.$vux.toast.text('您申报的项目已经截止', 'middle')
      }
    }
  }
}
</script>
<style lang="scss">
 .declarationDetailHeader{
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
.margin_top{
  margin-top: 110px;
}
  .declarationDetail{
    color:#333333;
    height: 100vh;
    background-color: #f5f5f5;
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
            color:#333333;
          &:last-child{
            border-bottom: none;
          }
          span{
            padding:35px 0;
            font-size: 36px;
          }
          span:nth-child(2){
            color:#999999;
            font-size: 22px;
          }
          span:nth-child(1){
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            width: 77%;
          }
        }
      }
      .declaration_consult{
        display: flex;
        justify-content: center;
        margin:30px;
        align-items: center;
        background-color: #ecfcf2;
        border-radius: 41px;
        border: solid 1.5px #009966;
        color:#07ab50;
        font-size: 30px;
        padding: 26px 30px;
      }
    }
  }
</style>

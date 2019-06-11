import request from './../../utils/http'
var app = getApp()
Page({
  data: {
    nvabarData: {
      title: '首页',
    },
    noticeLise:[],
    noticeSend:{
      page:1,
      rows:10
    },
    hotList:[],
    hotSend:{
      page:1,
      rows:2
    },
    bannarSend:{
      issuePlatform:'1',
      needPage:'0',
      propagandaArea:'top',
      propagandaType:"home_banner"
    },
    bannarList:[],
    imgBaseUrl:''
  },
  onLoad: function (options) {
    this.setData({
      imgBaseUrl:app.globalData.imgBaseUrl
    })
  
   },
  onReady: function () { },
  onShow: function () { 
    this.getNotice()
    this.hotList()
    this.getBannar()
  },
  onHide: function () { },
  onPullDownRefresh: function () {
    this.onShow()
  },
  onReachBottom: function () { },
  // 轮播图
  getBannar(){
    request.send({
      url: '/springcloud-enterprise/guest/businessHomePageController/getBusinessPromotionList',
      data: this.data.bannarSend,
      method: 'GET',
    }).then(res=>{
      // console.log(res)
      if(res.data.code==='0000'){
        this.setData({
          bannarList:res.data.data.rows,
        })
      }
    })
  },
  // 轮播广告
  getNotice(){
    request.send({
      url: '/springcloud-park/guest/park/notice/web/showNoticeListForApp',
      data: this.data.sendData,
      method: 'GET',
    }).then(res=>{
      // console.log(res)
      if(res.data.code==='0000'){
        this.setData({
          noticeLise:res.data.data.rows,
        })
      }
    })
  },
  hotList(){
    request.send({
      url: '/springcloud-park/guest/activity/activityListSlim',
      data: this.data.hotSend,
      method: 'POST',
    }).then(res=>{
      // console.log(res)
      if(res.data.code==='0000'){
        this.setData({
          hotList:res.data.data.rows,
        })
        wx.stopPullDownRefresh
      }
    })
  },
  goDetail(e){
    wx.navigateTo({
      url: './actiDetail/actiDetail?id='+e.currentTarget.dataset.id
    })
  }
})
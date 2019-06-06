// pages/index/payComplete/payComplete.js
var app =  getApp();

Page({
  data: {
    error:'',
    imgBaseUrl:'',
    isSuccess:1
  },

  onLoad: function (options) {
    this.setData({
      imgBaseUrl:app.globalData.imgBaseUrl
    })
    this.setData({
      isSuccess:options.isSuccess
    })
   },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onPullDownRefresh: function () {
  },
  onReachBottom: function () { },
})
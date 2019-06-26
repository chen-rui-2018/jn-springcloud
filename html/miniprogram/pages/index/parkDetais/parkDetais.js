// pages/home/aboutUs/aboutUs.js
var app = getApp()
Page({
  data: {
    url:"",
    noticeId:"",
    token:""
  },
  onLoad: function (options) {
    this.setData({
      noticeId:options.noticeid,
      token:wx.getStorageSync("token"),
      url:app.globalData.h5Url+"parkDetais"
    })
  },
 onReady: function () { },
 onShow: function () { },
 onHide: function () { },
 onPullDownRefresh: function () { },
 onReachBottom: function () { },
})
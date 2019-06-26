// pages/home/aboutUs/aboutUs.js
var app = getApp()
Page({
  data: {
    url:"",
    token:""
  },
  onLoad: function (options) {
    this.setData({
      token:wx.getStorageSync("token"),
      url:app.globalData.h5Url+"policyGuide"
    })
  },
 onReady: function () { },
 onShow: function () { },
 onHide: function () { },
 onPullDownRefresh: function () { },
 onReachBottom: function () { },
})
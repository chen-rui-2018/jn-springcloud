// pages/home/aboutUs/aboutUs.js
var app = getApp()
Page({
  data: {
    url:"",
    id:""
  },
  onLoad: function (options) {
    this.setData({
      id:options.id,
      token:wx.getStorageSync("token"),
      url:app.globalData.h5Url+"actiDetail"
    })
  },
 onReady: function () { },
 onShow: function () { },
 onHide: function () { },
 onPullDownRefresh: function () { },
 onReachBottom: function () { },
})
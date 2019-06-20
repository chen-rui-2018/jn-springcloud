// pages/home/aboutUs/aboutUs.js
Page({
  data: {
    url:"http://112.94.22.222:8002/#/moreActi",
    token:''
  },
  onLoad: function (options) {
    this.setData({
      token:wx.getStorageSync("token")
    })
  },
 onReady: function () { },
 onShow: function () { },
 onHide: function () { },
 onPullDownRefresh: function () { },
 onReachBottom: function () { },
})
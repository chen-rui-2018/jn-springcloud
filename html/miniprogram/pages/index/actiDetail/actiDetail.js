// pages/home/aboutUs/aboutUs.js
Page({
  data: {
    url:"http://112.94.22.222:8002/#/actiDetail",
    id:""
  },
  onLoad: function (options) {
    this.setData({
      id:options.id,
      token:wx.getStorageSync("token")
    })
  },
 onReady: function () { },
 onShow: function () { },
 onHide: function () { },
 onPullDownRefresh: function () { },
 onReachBottom: function () { },
})
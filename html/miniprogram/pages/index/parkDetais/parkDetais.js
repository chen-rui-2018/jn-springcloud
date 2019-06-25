// pages/home/aboutUs/aboutUs.js
Page({
  data: {
    url:"http://112.94.22.222:8002/#/parkDetais",
    noticeId:""
  },
  onLoad: function (options) {
    this.setData({
      noticeId:options.noticeid
    })
  },
 onReady: function () { },
 onShow: function () { },
 onHide: function () { },
 onPullDownRefresh: function () { },
 onReachBottom: function () { },
})
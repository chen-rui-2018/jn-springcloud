// pages/meeting/meetingPerson/meetingPerson.js
Page({
  data: {
    nvabarData: {
      title: '会议主题',
    },
    title:''
  },
  changeTitle(e){
    this.setData({
      title:e.detail.value
    })
  },
  goback(){
    let pages = getCurrentPages();
    let prevPage = pages[pages.length - 2];
    prevPage.setData({
      title: this.data.title,
    })
    wx.navigateBack({
      delta: 1,
    })
  },
  onLoad: function (options) { },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onPullDownRefresh: function () { },
  onReachBottom: function () { },
})
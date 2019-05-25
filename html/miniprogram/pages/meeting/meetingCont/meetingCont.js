// pages/meeting/meetingPerson/meetingPerson.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    nvabarData: {
      title: '会议内容', //导航栏 中间的标题
    },
    cont:''
  },
  changeCont(e){
    this.setData({
      cont:e.detail.value
    })
  },
  goback(){
    let pages = getCurrentPages();
    let prevPage = pages[pages.length - 2];
    prevPage.setData({
      oaMeetingContent: this.data.cont,
    })
    wx.navigateBack({
      delta: 1,
    })
  },
})
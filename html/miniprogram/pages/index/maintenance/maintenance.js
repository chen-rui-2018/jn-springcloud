// pages/index/maintenance/maintenance.js
const app = getApp();
const wxHttp = app.globalData.wxHttp;
const formatEmpty = app.globalData.formatEmpty
Page({

  /**
   * 页面的初始数据
   */
  data: {
    equipmentList: [],
    query: {
      page: 1,
      rows: 100
    },
    loading: false,
    noMore: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wxHttp.send({
      url: '/springcloud-park/asset/maintain/maintainList',
      method: 'GET',
      data: this.data.query
    })
      .then(res => {
        this.setData({
          equipmentList: res.data.data.rows
        })
      })
  },
  onPageScroll: function (e) {
    // console.log(e);//{scrollTop:99}
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
  formatEmpty
})
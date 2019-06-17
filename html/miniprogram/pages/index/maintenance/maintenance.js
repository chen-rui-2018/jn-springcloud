// pages/index/maintenance/maintenance.js
const app = getApp()
const wxHttp = app.globalData.wxHttp
const imgBaseUrl = app.globalData.imgBaseUrl
const formatEmpty = app.globalData.formatEmpty
Page({

  /**
   * 页面的初始数据
   */
  data: {
    equipmentList: [],
    query: {
      page: 1,
      rows: 10
    },
    imgBaseUrl,
    loading: false,
    noMore: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getData()
  },
  getData() {
    this.setData({
      loading: true
    })
    wx.showLoading({
      title: '加载列表中',
      duration: 2000
    })
    wxHttp.send({
      url: '/springcloud-park/asset/maintain/maintainList',
      method: 'GET',
      data: this.data.query
    })
      .then(res => {
        if (res.data.data.rows.length < this.data.query.rows) {
          this.setData({
            noMore: true
          })
        }
        this.setData({
          equipmentList: this.data.equipmentList.concat(res.data.data.rows),
          loading: false
        })
        wx.hideLoading()
      })
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
    if (!this.data.loading && !this.data.noMore) {
      let page = this.data.query.page
      page++
      this.setData({
        'query.page': page
      })
      this.getData()
    }
   
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
  formatEmpty
})
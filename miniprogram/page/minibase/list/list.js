// pages/list/list.js
Page({

  /*
   * http://localhost:1101/springcloud-wechat-mini-program/guest/area/http://localhost:1101/springcloud-wechat-mini-program/guest/area/
   * 页面的初始数据
   */
  data: {
    list: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    console.log(options)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    const that = this
    wx.request({
      url: 'http://127.0.0.1:1101/springcloud-wechat-mini-program/guest/miniprogram/area/listarea',
      method: 'GET',
      data: {},
      success(res) {
        const list = res.data.data
        if (list == null) {
          const toastText = '获取数据失败' + res.data.result
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000 // 弹出时间
          })
        } else {
          that.setData({
            list
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {
  },
  addArea() {
    wx.navigateTo({
      url: '../operation/operation'
    })
  },
  deleteArea(e) {
    const that = this

    wx.showModal({
      title: '提示',
      content: '确定要删除[' + e.target.dataset.areaname + ']吗？',
      success(sm) {
        if (sm.confirm) {
          wx.request({
            url: 'http://127.0.0.1:1101/springcloud-wechat-mini-program/guest/miniprogram/area/removearea',
            data: {areaId: e.target.dataset.areaid},
            method: 'GET',
            success(res) {
              const result = res.data.data
              let toastText = '删除成功'
              if (result !== true) {
                toastText = '删除失败'
              } else {
                that.data.list.splice(e.target.dataset.index, 1)
                that.setData({
                  list: that.data.list
                })
              }
              wx.showToast({
                title: toastText,
                icon: '',
                duration: 2000
              })
            }
          })
        }
      }
    })
  }
})

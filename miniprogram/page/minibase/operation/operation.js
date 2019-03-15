// pages/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    areaId: null,
    areaName: '',
    priority: '',
    addUrl: 'http://127.0.0.1:1101/springcloud-wechat-mini-program/guest/miniprogram/area/addarea',
    modifyUrl: 'http://127.0.0.1:1101/springcloud-wechat-mini-program/guest/miniprogram/area/modifyarea'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    const that = this
    if (options.areaId === undefined) {
      return
    }
    that.setData({
      areaId: options.areaId,
    })
    wx.request({
      url: 'http://127.0.0.1:1101/springcloud-wechat-mini-program/guest/miniprogram/area/getareabyid',
      data: {areaId: options.areaId},
      method: 'GET',
      success(res) {
        const area = res.data.data
        if (area === undefined) {
          const text = '获取数据失败' + res.data.result
          wx.showToast({
            title: text,
            icon: '',
            duration: 2000
          })
        } else {
          that.setData({
            areaName: area.areaName,
            priority: area.priority
          })
        }
      }
    })
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

  /**
   * 表单功能
   */
  formSubmit(e) {
    const that = this
    const formData = e.detail.value // 获取表数据
    let url = that.data.addUrl // 默认url
    if (that.data.areaId !== undefined) {
      formData.areaId = that.data.areaId
      url = that.data.modifyUrl
    }
    wx.request({
      url,
      data: JSON.stringify(formData),
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success(res) {
        const result = res.data.success
        let toastText = '操作成功'
        if (result !== true) {
          toastText = '操作失败！' + res.data.result
        }
        wx.showToast({
          title: toastText,
          icon: '',
          duration: 3000
        })
        wx.redirectTo({
          url: '../list/list',
        })
        // if(that.data.areaId=undefined){
        //   wx.redirectTo({
        //     url: '../list/list',
        //   })
        // }
      }
    })
  }
})

// pages/index/maintenance/maintenance.js
const app = getApp();
const wxHttp = app.globalData.wxHttp;
const baseUrl = app.globalData.baseUrl;
const deepClone = app.globalData.deepClone;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    formData: {
      assetNumber: null,
      message: '',
      imgUrl: []
    },
    mainTainData: {}
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const assetNumber = options.assetNumber
    assetNumber && this.getData(assetNumber)
  },
  getData(assetNumber) {
    wxHttp.send({
      url: '/springcloud-park/asset/maintain/getMaintain',
      method: 'GET',
      data: {
        assetNumber
      }
    })
      .then(res => {
        if (res.data.code === '0000') {
          wx.showToast({
            title: '获取信息成功',
            icon: 'success',
            duration:0
          })
          this.setData({
            ['formData.assetNumber']: assetNumber,
            mainTainData: res.data.data
          })
        } else {
          wx.showToast({
            title: res.data.result,
            icon: 'none',
            duration: 0
          })
        }
      })
  },
  uploadFile(event) {
    wx.chooseImage({
      success: (res) => {
        wx.showLoading({
          title: '上传中',
          duration: 0
        })
        let failTimes = 0
        const tempFilePaths = res.tempFilePaths
        const token = wx.getStorageSync('token')
        const requestList = []
        for (const tempFilePath of tempFilePaths) {
          const p = new Promise((resolve, reject) => {
            wx.uploadFile({
              headers: {
                'content-type': 'multipart/form-data',
                'token': token
              },
              url: baseUrl + '/springcloud-app-fastdfs/guest/upload/fastUpload',
              filePath: tempFilePath,
              name: 'file',
              success: (res) => {
                const data = JSON.parse(res.data)
                if (data.code === '0000') {
                  resolve(data.data)
                } else {
                  failTimes++
                  reject()
                }
              }
            })
          })
          requestList.push(p)
        }
        Promise.all(requestList)
          .then(fileList => {
            const formData = this.data.formData
            formData.imgUrl = formData.imgUrl.concat(fileList)
            this.setData({
              formData
            })
            wx.hideLoading()
            if (failTimes > 0) {
              wx.showToast({
                title: failTimes + '个文件上传失败',
                icon: 'none',
                duration: 0
              })
            }
          })
      }
    })
  },
  picRemove(event) {
    const index = event.currentTarget.dataset.index
    const formData = this.data.formData
    formData.imgUrl.splice(index, 1)
    this.setData({
      formData
    })
  },
  scan () {
    wx.scanCode({
      success: (res) => {
        console.dir(res)
        this.getData(res.result)
      }
    })
  },
  submit () {
    if (!this.data.formData.message) {
      wx.showModal({
        title: '提示',
        content: '请填写备注',
        success(res) {}
      })
      return
    }
    
    const formData = deepClone(this.data.formData)
    formData.imgUrl = formData.imgUrl.join(',')
    console.dir(formData)
    wxHttp.send({
      url: '/springcloud-park/asset/maintain/addRecord',
      method: 'POST',
      data: formData
    })
      .then(res => {
        if (res.data.code === '0000') {
          wx.showToast({
            title: '提交成功',
            icon: 'success',
            duration: 2000
          })
          setTimeout(() => {
            // 关闭当前页面，跳转到应用内的某个页面。
            wx.redirectTo({
              url: '/pages/index/maintenance/maintenance'
            })
          }, 2500)
         
        } else {
          wx.showToast({
            title: res.data.result,
            icon: 'none',
            duration: 2000
          })
        }
      })
  },
  bindKeyInput: function (e) {
    const data = this.data
    data.formData.message = e.detail.value
    this.setData(data)
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

  }
})
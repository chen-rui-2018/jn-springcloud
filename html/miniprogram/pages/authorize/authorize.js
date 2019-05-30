const app = getApp()

Page({
  data: {
    // 判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  onLoad() {
    const that = this
    // 查看是否授权
    wx.getSetting({
      success(res) {
        if (res.authSetting['scope.userInfo']) {
          wx.getUserInfo({
            success(res) {
              console.log(res)
              // 从数据库获取用户信息
              that.queryUsreInfo()
              // 用户已经授权过
              wx.redirectTo({
                url: '/pages/index/index'
              })
            }
          })
        }
      }
    })
  },
  login() {
    return new Promise((resolve, reject) => {
      // 登录
      wx.login({
        success: res => {
          // 发送 res.code 到后台换取 openId, sessionKey, unionId
          resolve(res.code)
          // console.log(res)
        },
        fail: err => {
          reject(err)
        }
      })
    })
  },
  bindGetUserInfo(e) {
    if (e.detail.userInfo) {
      // 用户按了允许授权按钮
      // const that = this
      app.globalData.userInfo = e.detail.userInfo
      const userInfo = e.detail.userInfo
      wx.setStorage({
        key: 'userInfo',
        data: JSON.stringify(userInfo)
      })
      // 插入登录的用户的相关信息到数据库
      wx.showLoading({
        title: '跳转中',
        duration: 0
      })
      this.login()
        .then(code => {
          wx.request({
            url: app.globalData.wechatPath + 'guest/mini/user/checkCodeAndGetToken',
            method: 'POST',
            data: {
              code,
              ...userInfo
            },
            header: {
              'content-type': 'application/json'
            },
            success(res) {
              // 从数据库获取用户信息
              // that.queryUsreInfo();
              wx.hideLoading()
              const code = res.data.code
              if (code === '1400304') {
                wx.showModal({
                  title: '提示',
                  content: '您还未绑定信息，现在去绑定吗？',
                  cancelText: '暂不绑定',
                  confirmText: '马上绑定',
                  success(res) {
                    if (res.confirm) {
                      // 如果未注册
                      wx.redirectTo({
                        url: '/pages/register/register'
                      })
                    }
                  }
                })
               
              } else if (code === '0000') {
                // 授权成功后，成功获取到token之后，跳转进入小程序首页
                wx.setStorage({
                  key: 'token',
                  data: res.data.data
                })
                wx.switchTab({
                  url: '/pages/index/index'
                })
              }
            }
          })
        })
      
    } else {
      // 用户按了拒绝按钮
      wx.showModal({
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!',
        showCancel: false,
        confirmText: '返回授权',
        success(res) {
          if (res.confirm) {
            console.log('用户点击了"返回授权"')
          }
        }
      })
    }
  },
  // 获取用户信息接口
  queryUsreInfo() {
    // wx.request({
    //   url: app.globalData.wechatPath + 'guest/mini/user/info',
    //   data: {
    //     openid: app.globalData.openid
    //   },
    //   header: {
    //     'content-type': 'application/json'
    //   },
    //   success(res) {
    //     app.globalData.userInfo = res.data
    //   }
    // })
  },

})

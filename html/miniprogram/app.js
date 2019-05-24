const openIdUrl = require('./config').openIdUrl
App({
  onLaunch(opts) {
    // console.log('App Launch', opts)
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        // console.log(res)
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
              // console.log('=====>' + res.userInfo)
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
          // 授权成功后，跳转进入小程序首页
          wx.switchTab({
            url: '/pages/index/index'
          })
        } else {
          wx.reLaunch({
            url: '/pages/authorize/authorize',
          })
        }
      }
    })
  },
  onShow(opts) {
    this.getToken()
  },
  onHide() {
    // console.log('App Hide')
  },
 
  // lazy loading openid
  getUserOpenId(callback) {
    const self = this

    if (self.globalData.openid) {
      callback(null, self.globalData.openid)
    } else {
      wx.login({
        success(data) {
          wx.request({
            url: openIdUrl,
            data: {
              code: data.code
            },
            success(res) {
              // console.log('拉取openid成功', res)
              self.globalData.openid = res.data.openid
              callback(null, self.globalData.openid)
            },
            fail(res) {
              // console.log('拉取用户openid失败，将无法正常使用开放接口等服务', res)
              callback(res)
            }
          })
        },
        fail(err) {
          // console.log('wx.login 接口调用失败，将无法正常使用开放接口等服务', err)
          callback(err)
        }
      })
    }
  },
  getToken(){
    wx.request({
      url: 'http://192.168.10.31:1101/springcloud-app-system/login',
      data: {
        account:"wangsong",
        password:"wangsong"
      },
      header: {'content-type':'application/json'},
      method: 'POST',
      dataType: 'json',
      success: (res)=>{
        if(res.data.code==='0000'){
          this.globalData.token= res.data.data
          if (this.userInfoReadyCallback) {
            this.userInfoReadyCallback(res)
          }
        }
      }
    })
  },
  globalData: {
    hasLogin: false,
    openid: null,
    urlPath: 'http://sw8cyn.natappfree.cc/springcloud-wechat-miniprogram/',
  }
})

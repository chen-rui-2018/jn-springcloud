const openIdUrl = require('./config').openIdUrl
import wxHttp from './utils/http.js'
import { baseUrl, wechatPath } from './utils/http.js'
import util from './utils/util.js'
App({
  onLaunch(opts) {
    // console.log('App Launch', opts)
    Promise.all([
      this.login(),
      this.getSetting()
    ])
      .then(res => {
        wx.redirectTo({
          url: '/pages/index/index'
        })
        // 登录获取到code和获取到用户信息之后，传到后台
        // wxHttp.getToken()
        // .then(() => {
          // 授权成功后，跳转进入小程序首页
        // wx.switchTab({
        //   url: '/pages/index/index'
        // })
        // })
        // console.dir(res)
      })
  },
  login() {
    return new Promise((resolve, reject) => {
      // 登录
      wx.login({
        success: res => {
          // 发送 res.code 到后台换取 openId, sessionKey, unionId
          // wx.setStorage({
          //   key: 'wxcode',
          //   data: res.code
          // })
          resolve(res)
          // console.log(res)
        },
        fail: err => {
          reject(err)
        }
      })
    })
  },
  getSetting() {
    return new Promise((resolve, reject) => {
      // 获取用户信息
      wx.getSetting({
        success: res => {
          if (res.authSetting['scope.userInfo']) {
            // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
            wx.getUserInfo({
              success: res => {
                // 可以将 res 发送给后台解码出 unionId
                this.globalData.userInfo = res.userInfo
                wx.setStorage({
                  key: 'userInfo',
                  data: JSON.stringify(res.userInfo)
                })
                // console.log('=====>' + res.userInfo)
                // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
                // 所以此处加入 callback 以防止这种情况
                if (this.userInfoReadyCallback) {
                  this.userInfoReadyCallback(res)
                }
                resolve(res)
              }
            })
          } else {
            wx.reLaunch({
              url: '/pages/authorize/authorize',
            })
          }
        },
        fail: err => {
          reject(err)
        }
      })
    })
  },
  onShow(opts) {
   
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
  globalData: {
    hasLogin: false,
    openid: null,
    wechatPath,
    wxHttp,
    baseUrl,
    ...util
  }
})

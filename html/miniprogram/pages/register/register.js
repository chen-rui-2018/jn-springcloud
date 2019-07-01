// 获取应用实例
const app = getApp()
import {
  baseUrl
} from '../../utils/http.js'
// 验证码重新获取时间,单位秒
let countdown = 60
// 是否需要注册标识true:需要注册绑定false:已注册绑定
let flag = false
// openId
const openId = 'oKHKB0XxayNQWcyxz3AEKK6A8LQM'
// unionId
const unionId = 'oKHKB0XxayNQWcyxz3AEKK6A8LQM1'

// 页面的初始数据
Page({
  data: {
    // 手机号
    phone: '',
    // 验证码
    code: '',
    // 验证码倒计时
    last_time: '',
    // 验证码是否显示标志，true：显示获取验证码   false:显示验证码倒计时
    is_show: true,
    // 倒计时数
    countdown: 60,
    // 是否隐藏  false 为隐藏  true 为显示
    allShow: true
  },

  // 生命周期函数--监听页面加载
  onLoad() {
    // 1.调用接口获取用户的openId和相关头像等信息
    console.log(app.globalData.userInfo)
    // 2.判断openId是否已绑定，若是没有绑定，需要注册登录，若是已绑定，直接跳转到考勤界面 
    /*wx.request({
      url: app.globalData.urlPath + 'isBindingOpenId',
      data: {'openId': openId},
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'post',
      success: res => {
        // 没有绑定
        if (res.data.code === '0000' && res.data.data === 0) {
          this.setData({
            allShow: true
          })
          flag = true
        } else if (res.data.code === '0000' && res.data.data === 1) {
          // 已绑定，跳转到考勤界面
        } else {
          wx.showToast({
            title: '网络异常，请稍后重试！',
            icon: 'none',
            duration: 1500
          })
        }
      }
    })*/
  },
  // 验证码倒计时
  settime(that) {
    const t = this
    if (countdown === 0) {
      that.setData({
        is_show: true
      })
      countdown = 60
      return
    } else {
      that.setData({
        is_show: false,
        last_time: countdown
      })
      countdown--
    }
    setTimeout(function() {
      t.settime(that)
    }, 1000)
  },
  // 获取用户输入的手机
  userPhoneInput(e) {
    this.setData({
      phone: e.detail.value
    })
  },
  // 验证码
  userCodeInput(e) {
    this.setData({
      code: e.detail.value
    })
  },

  // 验证码
  getCode() {
    this.setData({
      flag: true
    })
    const phone = this.data.phone
    console.log(phone)
    const myreg = /^1[3|4|5|7|8|6][0-9]{9}$/
    if (!myreg.test(phone)) {
      wx.showToast({
        title: '手机号有误！',
        icon: 'none',
        duration: 1500
      })
    } else {
      wx.request({
        url: app.globalData.baseUrl + '/springcloud-user/guest/miniProgram/miniProgramRegisterController/getCode',
        data: {
          'phone': phone
        },
        method: 'GET',
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        success: res => {
          if (res.data.code === '0000') {
            wx.showToast({
              title: '发送成功！',
              icon: 'success',
              duration: 1500
            })
            // 将获取验证码按钮隐藏60s，60s后再次显示
            this.setData({
              is_show: (!this.data.is_show)
            })
            this.settime(this)
          }
          if (res.data.code === 1) {
            wx.showToast({
              title: '发送失败！',
              icon: 'none',
              duration: 1500
            })
          }
        },
        error() {
          wx.showToast({
            title: '发送失败！',
            icon: 'none',
            duration: 1500
          })
        }
      })
    }
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
  // 点击完成按钮后的操作
  finishRegister() {
    // 手机号
    const phone = this.data.phone
    // 验证码
    const phoneCode = this.data.code
    this.login()
      .then(code => {
        if (phoneCode === '' || phone === '') {
          wx.showToast({
            title: '手机号或验证码填写有误请重新填写！',
            icon: 'none',
            duration: 1500
          })
          return
        }
        // 注册
        wx.request({
          url: app.globalData.baseUrl + 'springcloud-wechat-miniprogram/guest/mini/user/registerUserAndGetToken',
          data: {
            phone,
            phoneCode,
            code
          },
          method: 'POST',
          header: {
            'Content-Type': 'application/json'
          },
          success: res => {
            console.dir(res)
            if (res.data.code === '0000') {
              wx.showToast({
                title: '注册绑定成功！',
                icon: 'success',
                duration: 1500
              })
              // 跳转到首页
              setTimeout(function () {
                wx.switchTab({
                  url: '/pages/index/index'
                })
              }, 1500)
            } else {
              wx.showToast({
                title: res.data.result == null ? '验证码错误或验证码已过期' : res.data.result,
                icon: 'none',
                duration: 1500
              })
            }
          }
        })
      })
  },
})
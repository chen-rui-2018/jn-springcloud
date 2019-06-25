// http.js
const baseUrl = 'https://njbxq.mynatapp.cc'
const wechatPath = 'https://njbxq.mynatapp.cc/springcloud-wechat-miniprogram/'
const imgBaseUrl = 'https://njbxq.mynatapp.cc/h5/imgs/'
const h5Url="https://22d2325e.cpolar.io/#/"
class WxHttp {
  constructor() {
    // 设置 post、put 默认 Content-Type
      this.header = {
        'Content-Type': 'application/json'
      }
  }

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
  }

  getToken() {
    return new Promise((resolve, reject) => {
      const token = wx.getStorageSync('token')
      if (!token) {
        this.login()
          .then(loginData => {
            const wxcode = loginData
            let userInfo = wx.getStorageSync('userInfo')
            userInfo = userInfo ? JSON.parse(userInfo) : userInfo
            wx.request({
              url: wechatPath + 'guest/mini/user/checkCodeAndGetToken',
              method: 'POST',
              data: {
                ...userInfo,
                code: wxcode
              },
              header: this.header,
              success: (res) => {
                if (res.data.code === '0000') {
                  const token = res.data.data
                  wx.setStorage({
                    key: 'token',
                    data: token
                  })
                  this.header.token = token
                  resolve(res)
                }
                else {
                  reject()
                }
              }
            })
          })
      } else {
        this.header.token = token
        resolve()
      }
    })
  }

  // 添加请求拦截器
  request(data) {
    return data
  }

  // 添加响应拦截器
  response(data) {
    return data
  }

  send(params = {}) {
    return new Promise((resolve, reject) => {
      let time = 0
      const config = this.request(params)
      if (config.header) {
        config.header = Object.assign({}, this.header, config.header)
      } else {
        config.header = Object.assign({}, this.header)
      }
      const _operationRequest = requestData => {
        this.getToken()
          .then(() => {
            requestData.header.token = this.header.token
            wx.request({
              url: baseUrl + requestData.url, // 仅为示例，并非真实的接口地址
              method: requestData.method,
              data: requestData.data,
              header: requestData.header,
              success: (res) => {
                if (res.data.code === 'index' && time < 3) {
                  wx.removeStorage({
                    key: 'token',
                    success(res) {
                      // console.log(res)
                    }
                  })
                  _operationRequest(requestData)
                  time++
                } else {
                  resolve(this.response(res))
                }
              }
            })
          })
      }
      _operationRequest(config)
    })
  }
}

export {
  baseUrl,
  wechatPath,
  imgBaseUrl,
  h5Url
}
export default new WxHttp()

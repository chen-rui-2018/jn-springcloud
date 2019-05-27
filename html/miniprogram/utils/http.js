// http.js
const baseUrl = 'http://192.168.10.31:1101'
class WxHttp {
  constructor() {
    // 设置 post、put 默认 Content-Type
      this.header = {
        'Content-Type': 'application/json'
      }
  }
  getToken() {
    return new Promise((resolve, reject) => {
      const token = wx.getStorageSync('token')
      if (!token) {
        wx.request({
          url: baseUrl + '/springcloud-app-system/login',
          method: 'POST',
          data: {
            account: "wangsong",
            password: "wangsong"
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
              resolve()
            } 
            else {
              reject()
            }
          }
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
    let time = 0
    return new Promise((resolve, reject) => {
      this.getToken()
        .then(() => {
          const config = this.request(params)
          let header
          if (config.header) {
            header = Object.assign({}, this.header, config.header)
          } else {
            header = Object.assign({}, this.header)
          }
          wx.request({
            url: baseUrl + config.url, // 仅为示例，并非真实的接口地址
            method: config.method,
            data: config.data,
            header: header,
            success: (res) => {
              if (res.data.code === 'index' && time < 3) {
                wx.removeStorage({
                  key: 'token',
                  success(res) {
                    // console.log(res)
                  }
                })
                this.send(params)
                time++
              } else {
                resolve(this.response(res))
              }
            }
          })
        })
    })
  }
}

export default new WxHttp()

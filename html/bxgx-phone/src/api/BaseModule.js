// BaseModule.js
import axios from 'axios'
import qs from 'query-string'

class BaseModule {
  constructor () {
    this.$http = axios.create({
      baseUrl: 'localhost'
    })
    // 设置 post、put 默认 Content-Type
    // this.$http.defaults.headers.post['Content-Type'] = 'application/json'
    // this.$http.defaults.headers.put['Content-Type'] = 'application/json'

    this.dataMethodDefaults = {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      transformRequest: [function (data) {
        return qs.stringify(data)
      }]
    }

    // 添加请求拦截器
    this.$http.interceptors.request.use(
      (config) => {
        if (config.method === 'post' || config.method === 'put') {
          // post、put 提交时，将对象转换为string, 为处理Java后台解析问题
          config.data = JSON.stringify(config.data)
        }
        // 请求发送前进行处理
        return config
      },
      (error) => {
        // 请求错误处理
        return Promise.reject(error)
      }
    )

    // 添加响应拦截器
    this.$http.interceptors.response.use(
      (response) => {
        let {data} = response
        return data
      },
      (error) => {
        let info = {}, {status, statusText, data} = error.response
        if (!error.response) {
          info = {
            code: 5000,
            msg: 'Network Error'
          }
        } else {
          // 此处整理错误信息格式
          info = {
            code: status,
            data: data,
            msg: statusText
          }
        }
      }
    )
  }

  get (url, config = {}) {
    return this.$http.get(url, config)
  }

  post (url, data = undefined, config = {}) {
    return this.$http.post(url, data, {...this.dataMethodDefaults, ...config})
  }

  put (url, data = undefined, config = {}) {
    return this.$http.put(url, data, {...this.dataMethodDefaults, ...config})
  }

  delete (url, config = {}) {
    return this.$http.delete(url, config)
  }
}

export default BaseModule

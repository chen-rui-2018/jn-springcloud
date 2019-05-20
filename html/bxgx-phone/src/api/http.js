import Axios from 'axios'
// import vue from 'vue'
// baseUrl
const api = 'http://47.96.188.121:807'

const axios = Axios.create({
  baseURL: api
  // timeout: 10000
})
// 添加请求拦截器
axios.interceptors.request.use(
  (config) => {
    // if (config.method === 'post' || config.method === 'put') {
    //   // post、put 提交时，将对象转换为string, 为处理Java后台解析问题
    //   config.data = JSON.stringify(config.data)
    // }
    // 请求发送前进行处理
    return config
  },
  (error) => {
    // 请求错误处理
    return Promise.reject(error)
  }
)
// 设置 post、put 默认 Content-Type
// axios.defaults.headers.post['Content-Type'] = 'multipart/form-data'
// axios.defaults.headers.post['token'] = vue.$route.query.id
// axios.defaults.headers.get['token'] = vue.$route.query.id
// this.$http.defaults.headers.put['Content-Type'] = 'application/json'
// const api = 'http://172.16.0.113/zhiyun/public'
// import qs from 'qs'
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
// axios.defaults.transformRequest = [function (data) {
//     return qs.stringify(data)
// }]

/**
 * get 请求方法
 * @param url
 * @param params
 * @return {Promise}
 */
function get (data) {
  return new Promise((resolve, reject) => {
    axios.get(data.url, {
      params: data.data
    })
      .then(response => {
        resolve(response.data)
      })
      .catch(err => {
        reject(err)
      })
  })
}

/**
 * post 请求方法
 * @param url
 * @param data
 * @return {Promise}
 */
function post (data) {
  return new Promise((resolve, reject) => {
    // axios.post(data.url, data.data, {
    //   headers: {
    //     'Content-Type': 'multipart/form-data'
    //   }
    // })
    axios.post(data.url, data.data)
      .then(response => {
        resolve(response.data)
      })
      .catch(err => {
        reject(err)
      })
  })
}

export {
  api,
  get,
  post,
  axios
}

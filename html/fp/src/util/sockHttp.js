import http from 'axios'
import ElementUI from 'element-ui'
// baseUrl
const api = 'http://192.168.10.31:8888'

const axios = http.create({
    baseURL: api
    // timeout: 10000
})
// 全局请求拦截
axios.interceptors.response.use(function (response) {
  // 处理响应数据
  return response
}, function (error) {
  // 处理响应失败
  // ElementUI.Message.error(error.message)
  return Promise.reject(error)
})
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
function get (url, data = {}) {
    return new Promise((resolve, reject) => {
        axios.get(url, {
            params: data
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
function post (url, data = {}) {
    return new Promise((resolve, reject) => {
        axios.post(url, data)
            .then(response => {
                resolve(response.data)
            })
            .catch(err => {
                reject(err)
            })
    })
}
const sockHttp = {
  post,
  get
}
export default sockHttp

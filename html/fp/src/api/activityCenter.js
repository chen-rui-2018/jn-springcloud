import axios from 'axios'
const baseURL = 'http://192.168.10.31:1101/springcloud-park/'
// 设置默认的基准路径
axios.defaults.baseURL = baseURL
// 设置axios拦截器  config:可以进行请求头的设置，通过headers属性
axios.interceptors.request.use(function (config) {
  // Do something before request is sent
  // 获取token
  var token = localStorage.getItem('mytoken')
  if (token) {
    config.headers['Authorization'] = token
  }
  return config
}, function (error) {
  // Do something with request error
  return Promise.reject(error)
})
// 查询活动类型列表
export const findActivityTypeList = () => {
  return axios.post('guest/findActivityTypeList').then((res) => {
    return res.data
  })
}
// 获取用户数据
export const getAllUserList = (pa) => {
  return axios.get('users', {params: pa}).then((res) => {
    return res.data
  })
}

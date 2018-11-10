import axios from 'axios'
// import store from '@/store'
// import { getToken } from '@/utils/auth'
// 配置基准路径
const baseURL = 'http://192.168.2.112/springcloud-app-system/'
// 设置默认的基准路径
axios.defaults.baseURL = baseURL
// axios.interceptors.request.use(function(config) {
//   // Do something before request is sent:在请求之前需要做的事情就在这个位置写
//   // 1.获取token
//   // var token = store.state.token
//   if (store.getters.token) {
//   // 2.写入请求头
//     config.headers['Authorization'] = getToken
//   }
//   return config
// }, function(error) {
//   // Do something with request error：请求失败了的处理在这里写
//   return Promise.reject(error)
// })
// 获取所有用户数据
export const getAllUserList = (pa) => {
  return axios.post('system/sysUser/findSysUserByPage',
    pa,
    {
      headers: {
        'token': '6eab3e82-f94f-4e1c-bdb4-1a81c1fcb772'
      }
    }).then((res) => {
    return res.data
  })
}


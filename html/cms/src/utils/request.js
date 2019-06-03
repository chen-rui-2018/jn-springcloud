import axios from 'axios'
import $ from 'jquery'
import { getToken, setToken, removeToken } from '@/utils/auth'

// create an axios instance
const BASE_API = process.env.BASE_API
const service = axios.create({
  baseURL: BASE_API, // api 的 base_url
  timeout: 1000 // request timeout
})
// request interceptor
service.interceptors.request.use(
  config => {
    // Do something before request is sent
    // console.log('================>getToken：' + getToken() + '<1>' + !getToken())
    if (!getToken()) {
      $.ajax({
        url: BASE_API + 'springcloud-app-system/authLogin',
        type: 'POST',
        async: false,
        data: {
        },
        dataType: 'json',
        beforeSend: function(xhr) {
        },
        success: function(data, textStatus, jqXHR) {
          // console.log('================>authLogin请求返回data：' + data)
          if (data.code === '0000') {
            if (data.data !== null) {
              // console.log('================>authLogin请求返回：' + data.data)
              setToken(data.data)
            }
          }
        },
        error: function(xhr, textStatus) {
        },
        complete: function() {
        }
      })
    }
    // console.log('================>getToken：' + getToken() + '<2>' + !getToken())
    if (getToken() != null) {
      // 让每个请求携带token-- ['X-Token']为自定义key 请根据实际情况自行修改
      config.headers['token'] = getToken()
      // console.log('================>请求带token：' + getToken())
    } else {
      // console.log('================>请求不带token：' + getToken())
    }
    return config
  },
  error => {
    // Do something with request error
    console.log(error) // for debug
    Promise.reject(error)
  }
)

service.interceptors.response.use(response => {
  const res = response.data
  // console.log('================>请求返回code：' + res.code)
  if (res.code === 'index') {
    removeToken()
    location.href = 'http://112.94.22.222:2384/ibps/logout.htm'
  } else {
    return response
  }
}, error => {
  removeToken()
  console.log('请重新登录：' + error)
  location.href = 'http://112.94.22.222:2384/ibps/logout.htm'
  return Promise.reject(error)
})

// response interceptor
// service.interceptors.response.use(
//   console.log(123),
//   response => response,
/**
   * 下面的注释为通过在response里，自定义code来标示请求状态
   * 当code返回如下情况则说明权限有问题，登出并返回到登录页
   * 如想通过 xmlhttprequest 来状态码标识 逻辑可写在下面error中
   * 以下代码均为样例，请结合自生需求加以修改，若不需要，则可删除
   */
// response => {
//   const res = response.data
//   if (res.code !== 20000) {
//     Message({
//       message: res.message,
//       type: 'error',
//       duration: 5 * 1000
//     })
//     // 50008:非法的token; 50012:其他客户端登录了;  50014:Token 过期了;
//     if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
//       // 请自行在引入 MessageBox
//       // import { Message, MessageBox } from 'element-ui'
//       MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
//         confirmButtonText: '重新登录',
//         cancelButtonText: '取消',
//         type: 'warning'
//       }).then(() => {
//         store.dispatch('FedLogOut').then(() => {
//           location.reload() // 为了重新实例化vue-router对象 避免bug
//         })
//       })
//     }
//     return Promise.reject('error')
//   } else {
//     return response.data
//   }
// },
// error => {
//   console.log('err' + error) // for debug
//   Message({
//     message: error.message,
//     type: 'error',
//     duration: 5 * 1000
//   })
//   return Promise.reject(error)
// }
// )

export default service

import request from '@/utils/request'
var baseurl = 'http://112.94.22.222:8000/springcloud-oa/'
// var baseurl = 'http://localhost:1101/springcloud-oa/'
export function api(url, query) {
  return request({
    url: baseurl + url,
    method: 'post',
    data: query
  })
}
export function paramApi(url, query, parameter) {
  const param = new URLSearchParams()
  param.append(parameter, query)
  return request({
    url: baseurl + url,
    method: 'post',
    data: param
  })
}
// 获取所有用户列表
export function userAllList(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-app-system/system/sysUser/getUserAll',
    method: 'post',
    data: query
  })
}
// 获取用户信息
export function getUserInfo(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-app-system/system/sysUser/getUserInfo',
    method: 'post',
    data: query
  })
}

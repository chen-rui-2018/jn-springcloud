import request from '@/utils/request'
// 'http://192.168.2.139:1101/springcloud-app-system/system/sysUser/findSysUserByPage

export function userList(query) {
  return request({
    url: '/permission/user',
    method: 'get',
    params: query
  })
}
export function userCreate(data) {
  return request({
    url: '/permission/userCreate',
    method: 'post',
    data
  })
}

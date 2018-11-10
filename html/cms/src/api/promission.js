import request from '@/utils/request'
// 'http://192.168.2.139:1101/springcloud-app-system/system/sysUser/findSysUserByPage
// url: '/permission/user'

export function userList(query) {
  return request({
    url: 'system/sysUser/findSysUserByPage',
    method: 'post',
    data: query
  })
}
export function userCreate(query) {
  return request({
    url: 'system/sysUser/addSysUser',
    method: 'post',
    data: query
  })
}

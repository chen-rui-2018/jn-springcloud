import request from '@/utils/request'
// 'http://192.168.2.139:1101/springcloud-app-system/system/sysUser/findSysUserByPage
// url: '/permission/user'

// 获取用户组所有数据
export function groupList(query) {
  return request({
    url: 'system/sysGroup/list',
    method: 'post',
    data: query
  })
}
// 新增用户组
export function addgroupList(query) {
  return request({
    url: 'system/sysGroup/add',
    method: 'post',
    data: query
  })
}
// 编辑用户组
export function editgroupList(query) {
  return request({
    url: 'system/sysGroup/update',
    method: 'post',
    data: query
  })
}
// 删除用户组

export function deleteUsergroupById(query) {
  return request({
    url: 'system/sysGroup/delete',
    method: 'post',
    data: query
  })
}

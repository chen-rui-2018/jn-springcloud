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
  const param = new URLSearchParams()
  param.append('groupIds', query)
  return request({
    url: 'system/sysGroup/delete',
    method: 'post',
    data: param
  })
}
// 校验用户组名称是否存在,success表示用户名可用,false不可用
export function checkGroupName(query) {
  const param = new URLSearchParams()
  param.append('groupName', query)
  return request({
    url: 'system/sysGroup/checkGroupName',
    method: 'post',
    data: param
  })
}
// 根据用户组id获取用户组具有的用户信息和其他用户
export function getAllUserInfo(query) {
  return request({
    url: 'system/sysGroup/findOtherUserByPage',
    method: 'post',
    data: query
  })
}
// 用户组授权用户
export function updataUser(query) {
  return request({
    url: 'system/sysGroup/userGroupAuthorization',
    method: 'post',
    data: query
  })
}
// 根据用户组id获取权限具有的角色信息和其他角色
export function getRoleInfo(query) {
  return request({
    url: 'system/sysGroup/selectGroupRoleAndOtherRole',
    method: 'post',
    data: query
  })
}
// 用户组授权角色(更新数据)
export function updataRole(query) {
  return request({
    url: 'system/sysGroup/roleGroupAuthorization',
    method: 'post',
    data: query
  })
}

import request from '@/utils/request'
// 'http://192.168.2.139:1101/springcloud-app-system/system/sysUser/findSysUserByPage
// url: '/permission/user'
// 获取用户列表
export function userList(query) {
  return request({
    url: 'system/sysUser/findSysUserByPage',
    method: 'post',
    data: query
  })
}
// 新增用户
export function userCreate(query) {
  return request({
    url: 'system/sysUser/addSysUser',
    method: 'post',
    data: query
  })
}
// 删除用户
export function deleteSysUser(query) {
  return request({
    url: 'system/sysUser/deleteSysUser',
    method: 'post',
    data: query
  })
}
// 获取用户组所有数据
export function groupList(query) {
  return request({
    url: 'system/sysGroup/list',
    method: 'post',
    data: query
  })
}
// 校验用户账号是否存在,success表示用户名可用,false不可用
export function checkUserName(query) {
  return request({
    url: 'system/sysUser/checkUserName?account=' + query,
    method: 'post'
  })
}
// 获取部门数据
export function findSysDepartmentAll(query) {
  return request({
    url: 'system/sysDepartment/findSysDepartmentAll',
    method: 'post',
    data: query
  })
}

// 获取部门数据树
export function findDepartmentAllByLevel(query) {
  return request({
    url: 'system/sysDepartment/findDepartmentAllByLevel',
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
// 新增文件组
export function addFilegroupList(query) {
  return request({
    url: 'system/sysGroup/add',
    method: 'post',
    data: query
  })
}

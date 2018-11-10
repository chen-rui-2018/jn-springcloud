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
// 新增文件组
export function addFilegroupList(query) {
  return request({
    url: 'system/sysGroup/add',
    method: 'post',
    data: query
  })
}
export function findSysDepartmentAll(query) {
  return request({
    url: 'system/sysDepartment/findSysDepartmentAll',
    method: 'post',
    data: query
  })
}

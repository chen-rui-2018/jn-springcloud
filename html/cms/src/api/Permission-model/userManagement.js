import request from '@/utils/request'
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
// 编辑用户
export function editUser(query) {
  return request({
    url: 'system/sysUser/updateSysUser',
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
export function getDepartment(query) {
  return request({
    url: 'system/sysDepartment/findDepartmentAllByLevel',
    method: 'post',
    data: query
  })
}

// 查询所有岗位
export function findSysPostAll(query) {
  return request({
    url: 'system/sysPost/findSysPostAll',
    method: 'post',
    data: query
  })
}
// 根据用户id查询用户已经具有的岗位部门信息
export function findDepartmentandPostByUserId(query) {
  return request({
    url: 'system/sysUser/findDepartmentandPostByUserId?userId=' + query,
    method: 'post'
  })
}
// 为用户添加部门岗位
export function saveDepartmentandPostOfUser(query) {
  return request({
    url: 'system/sysUser/saveDepartmentandPostOfUser',
    method: 'post',
    data: query
  })
}
// 更新用户
export function updateSysUser(query) {
  return request({
    url: 'system/sysUser/updateSysUser',
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
// 根据用户id获取权限具有的角色信息和其他角色
export function getRoleInfo(query) {
  return request({
    url: 'system/sysUser/findSysRoleByUserId',
    method: 'post',
    data: query
  })
}
// 用户授权角色(更新数据)
export function updataRole(query) {
  return request({
    url: 'system/sysUser/saveSysRoleToSysUser',
    method: 'post',
    data: query
  })
}
// 根据用户id获取权限具有的用户组信息和其他用户组
export function getUserGroupInfo(query) {
  return request({
    url: 'system/sysUser/findSysGroupByUserId',
    method: 'post',
    data: query
  })
}
// 用户授权用户组(更新数据)
export function updataUserGroup(query) {
  return request({
    url: 'system/sysUser/saveSysGroupToSysUser',
    method: 'post',
    data: query
  })
}
// 导出功能
export function exportExcel() {
  return request({
    url: 'system/sysUser/exportExcelUserInfo',
    method: 'get',
    // data: query,
    responseType: 'blob'
  })
}

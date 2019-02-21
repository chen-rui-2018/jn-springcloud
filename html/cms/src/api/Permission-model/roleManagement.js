// import request from '@/utils/request'
// 获取角色所有数据
// export function roleList(query) {
//   return request({
//     url: 'system/sysRole/list',
//     method: 'post',
//     data: query
//   })
// }
// 新增角色
// export function addRoleList(query) {
//   return request({
//     url: 'system/sysRole/add',
//     method: 'post',
//     data: query
//   })
// }
// 校验角色名称是否存在,success表示角色名可用,false不可用
// export function checkRoleName(query) {
//   const param = new URLSearchParams()
//   param.append('roleName', query)
//   return request({
//     url: 'system/sysRole/checkRoleName',
//     method: 'post',
//     data: param
//   })
// }
// 编辑角色
// export function editRoleList(query) {
//   return request({
//     url: 'system/sysRole/update',
//     method: 'post',
//     data: query
//   })
// }
// 删除角色
// export function deleteRoleById(query) {
//   const param = new URLSearchParams()
//   param.append('ids', query)
//   return request({
//     url: 'system/sysRole/delete',
//     method: 'post',
//     data: param
//   })
// }
// 根据角色id获取角色具有的用户信息和其他用户
// export function getAllUserInfo(query) {
//   return request({
//     url: 'system/sysRole/findUserOfRoleAndOtherUser',
//     method: 'post',
//     data: query
//   })
// }
// 角色授权用户
// export function updataUser(query) {
//   return request({
//     url: 'system/sysRole/userRoleAuthorization',
//     method: 'post',
//     data: query
//   })
// }
// 根据角色id获取角色具有的用户组信息和其他用户组
// export function getUserGroupInfo(query) {
//   return request({
//     url: 'system/sysRole/findUserGroupOfRoleAndOtherGroup',
//     method: 'post',
//     data: query
//   })
// }
// 角色授权用户组
// export function updataUserGroup(query) {
//   return request({
//     url: '/system/sysRole/userGroupRoleAuthorization',
//     method: 'post',
//     data: query
//   })
// }
// 根据角色id获取角色具有的权限信息和其他权限
// export function getAuthorityInfo(query) {
//   return request({
//     url: 'system/sysRole/findPermissionOrRoleAndOtherPermission',
//     method: 'post',
//     data: query
//   })
// }
// 角色授权权限
// export function updataAuthority(query) {
//   return request({
//     url: 'system/sysRole/rolePermissionAuthorization',
//     method: 'post',
//     data: query
//   })
// }

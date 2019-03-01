// import request from '@/utils/request'
// 获取权限所有数据
// export function getPermissionList(query) {
//   return request({
//     url: 'system/sysPermission/list',
//     method: 'post',
//     data: query
//   })
// }
// 新增权限
// export function addPermissionList(query) {
//   return request({
//     url: 'system/sysPermission/add',
//     method: 'post',
//     data: query
//   })
// }
// 编辑权限
// export function editPermissionList(query) {
//   return request({
//     url: 'system/sysPermission/update',
//     method: 'post',
//     data: query
//   })
// }
// 删除权限
// export function deletePermissionById(query) {
//   const param = new URLSearchParams()
//   param.append('ids', query)
//   return request({
//     url: 'system/sysPermission/delete',
//     method: 'post',
//     data: param
//   })
// }
// 校验权限名称是否存在,success表示权限名可用,false不可用
// export function checkPermissionName(query) {
//   const param = new URLSearchParams()
//   param.append('permissionName', query)
//   return request({
//     url: 'system/sysPermission/checkPerssionName',
//     method: 'post',
//     data: param
//   })
// }
// 根据权限id获取权限具有的角色信息和其他角色
// export function getRoleInfo(query) {
//   return request({
//     url: 'system/sysPermission/findRoleOfPermission',
//     method: 'post',
//     data: query
//   })
// }
// 权限授权角色
// export function updataRole(query) {
//   return request({
//     url: 'system/sysPermission/addRoleToPermission',
//     method: 'post',
//     data: query
//   })
// }
// // 权限授权菜单
// export function updataMenu(query) {
//   return request({
//     url: 'system/sysPermission/addMenuToPermission',
//     method: 'post',
//     data: query
//   })
// }
// 根据权限id获取权限具有的文件组信息和其他文件组
// export function getFileGroupInfo(query) {
//   return request({
//     url: 'system/sysPermission/findFileGroupOfPermission',
//     method: 'post',
//     data: query
//   })
// }
// 权限授权文件组(更新数据)
// export function updataFileGroup(query) {
//   return request({
//     url: 'system/sysPermission/addFileGroupToPermission',
//     method: 'post',
//     data: query
//   })
// }
// // 根据权限id获取权限具有的页面信息和其他页面功能
// export function getPageInfo(query) {
//   return request({
//     url: 'system/sysPermission/findResourcesOfPermission',
//     method: 'post',
//     data: query
//   })
// }
// // 权限授权页面(更新数据)
// export function updataPage(query) {
//   return request({
//     url: 'system/sysPermission/addResounceToPermission',
//     method: 'post',
//     data: query
//   })
// }
// 获取权限拥有的菜单和功能
// export function getAllList(query) {
//   const param = new URLSearchParams()
//   param.append('permissionId', query)
//   return request({
//     url: 'system/sysPermission/getMenuAndResources',
//     method: 'post',
//     data: param
//   })
// }
// 权限授权页面(更新数据)
// export function updataAllData(query) {
//   return request({
//     url: 'system/sysPermission/addMenuAndResourcesToPermission',
//     method: 'post',
//     data: query
//   })
// }

import request from '@/utils/request'
// 获取菜单所有数据
export function getMenuList() {
  return request({
    url: 'system/sysMenu/list',
    method: 'post'
  })
}
// 校验菜单名称是否存在,success表示菜单名可用,fail不可用
export function checkMenuName(query) {
  return request({
    url: 'system/sysMenu/checkMenuName',
    method: 'post',
    data: query
  })
}
// 新增目录
export function createMenuDir(query) {
  return request({
    url: 'system/sysMenu/addMenuDir',
    method: 'post',
    data: query
  })
}
// 新增文件
export function createMenu(query) {
  return request({
    url: 'system/sysMenu/addMenu',
    method: 'post',
    data: query
  })
}
// 编辑菜单
export function updateMenu(query) {
  return request({
    url: 'system/sysMenu/update',
    method: 'post',
    data: query
  })
}
// 删除菜单
export function deleteMenuById(query) {
  const param = new URLSearchParams()
  param.append('id', query)
  return request({
    url: 'system/sysMenu/delete',
    method: 'post',
    data: param
  })
}
// 批量编辑菜单
export function updateAllMenu(query) {
  return request({
    url: 'system/sysMenu/updateBatch',
    method: 'post',
    data: query
  })
}
// 新增功能
export function addResources(query) {
  return request({
    url: 'system/sysResources/add',
    method: 'post',
    data: query
  })
}
// 编辑菜单
export function editResources(query) {
  return request({
    url: 'system/sysResources/update',
    method: 'post',
    data: query
  })
}
// 根据页面id获取所有功能
export function getAllResources(query) {
  const param = new URLSearchParams()
  param.append('menuId', query)
  return request({
    url: 'system/sysResources/findResourcesByMenuId',
    method: 'post',
    data: param
  })
}
// 删除功能
export function deleteResourcesById(query) {
  const param = new URLSearchParams()
  param.append('ids', query)
  return request({
    url: 'system/sysResources/delete',
    method: 'post',
    data: param
  })
}
// 校验功能名称是否存在,success表示功能名可用,fail不可用
export function checkResourcesName(query) {
  return request({
    url: 'system/sysResources/checkResourceName',
    method: 'post',
    data: query
  })
}
// 根据菜单id获取当前Id所具有的子菜单
export function getOldData(query) {
  const param = new URLSearchParams()
  param.append('parentId', query)
  return request({
    url: 'system/sysMenu/getChildrenMenuByParentId',
    method: 'post',
    data: param
  })
}

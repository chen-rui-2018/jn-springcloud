import request from '@/utils/request'
// 获取部门所有数据
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
// 删除部门
export function deleteMenuById(query) {
  const param = new URLSearchParams()
  param.append('id', query)
  return request({
    url: 'system/sysMenu/delete',
    method: 'post',
    data: param
  })
}

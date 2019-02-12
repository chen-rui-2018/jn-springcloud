import request from '@/utils/request'
// 获取模块列表
export function getModuleList(query) {
  return request({
    url: 'system/sysModule/list',
    method: 'post',
    data: query
  })
}
// 新增
export function addModule(query) {
  return request({
    url: 'system/sysModule/add',
    method: 'post',
    data: query
  })
}
// 编辑
export function editModule(query) {
  return request({
    url: 'system/sysModule/update',
    method: 'post',
    data: query
  })
}
// 删除
export function deleteModule(query) {
  const param = new URLSearchParams()
  param.append('moduleId', query)
  return request({
    url: 'system/sysModule/delete',
    method: 'post',
    data: param
  })
}

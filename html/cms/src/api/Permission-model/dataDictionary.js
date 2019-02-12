import request from '@/utils/request'
// 获取数据字典所有数据
export function getList(query) {
  return request({
    url: 'system/sysDict/list',
    method: 'post',
    data: query
  })
}
// 获取全部模块
export function getAllModule() {
  return request({
    url: 'system/sysModule/getAll',
    method: 'post'
  })
}
// 新增数据字典
export function addDictionary(query) {
  return request({
    url: 'system/sysDict/add',
    method: 'post',
    data: query
  })
}
// 编辑数据字典
export function editDictionary(query) {
  return request({
    url: 'system/sysDict/update',
    method: 'post',
    data: query
  })
}
// 删除数据字典
export function deleteDictionary(query) {
  const param = new URLSearchParams()
  param.append('dictId', query)
  return request({
    url: 'system/sysDict/delete',
    method: 'post',
    data: param
  })
}
// 分组排序
export function groupSort(query) {
  return request({
    url: 'system/sysDict/sortByGroup',
    method: 'post',
    data: query
  })
}
// 数据字典调用
// export function getDict(query) {
//   return request({
//     url: 'system/sysDict/getDict',
//     method: 'post',
//     data: query
//   })
// }
export function sortSearch(query) {
  return request({
    url: 'system/sysDict/sortSearch',
    method: 'post',
    data: query
  })
}

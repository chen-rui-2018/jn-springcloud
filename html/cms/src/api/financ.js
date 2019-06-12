import request from '@/utils/request'
// 获取用户列表
var financUrl = 'springcloud-park/'
export function api(url, query, mothod) {
  return request({
    url: financUrl + url,
    method: mothod,
    data: query
  })
}
// 导入
export function importBdDeptdoc(url, query, mothod) {
  return request({
    url: financUrl + url,
    method: mothod,
    data: query,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}
// 导出功能
// export function exportExcel(query) {
//   return request({
//     url: financUrl,
//     method: 'get'
//   })
// }

import request from '@/utils/request'
// var financUrl = 'springcloud-park/'
export function api(url, query, mothod) {
  return request({
    url: url,
    method: mothod,
    data: query
  })
}
// 导入
export function Inventor(url, query, mothod) {
  return request({
    url: url,
    method: mothod,
    data: query,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}
export function paramApi(url, query, parameter) {
  const param = new URLSearchParams()
  param.append(parameter, query)
  return request({
    url: url,
    method: 'post',
    data: param
  })
}
// 导出功能
// export function exportExcel(query) {
//   return request({
//     // url: systemUrl + `system/sysUser/exportExcelUserInfo?name=${query.name}&postOrTypeName=${query.postOrTypeName}&recordStatus=${query.recordStatus}`,
//     method: 'get'
//   })
// }

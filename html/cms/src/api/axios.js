import request from '@/utils/request'
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

/**
 * get 请求方法
 * @param url
 * @param params
 * @return {Promise}
 */
export function get(url, params = {}) {
  return new Promise((resolve, reject) => {
    request.get(url, {
      params: params
    })
      .then(response => {
        resolve(response.data)
      })
      .catch(err => {
        reject(err)
      })
  })
}

/**
 * post 请求方法
 * @param url
 * @param data
 * @return {Promise}
 */
export function post(url, data = {}) {
  return new Promise((resolve, reject) => {
    request.post(url, data)
      .then(response => {
        resolve(response.data)
      })
      .catch(err => {
        reject(err)
      })
  })
}
// 导出功能
// export function exportExcel(query) {
//   return request({
//     // url: systemUrl + `system/sysUser/exportExcelUserInfo?name=${query.name}&postOrTypeName=${query.postOrTypeName}&recordStatus=${query.recordStatus}`,
//     method: 'get'
//   })
// }

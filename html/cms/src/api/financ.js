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

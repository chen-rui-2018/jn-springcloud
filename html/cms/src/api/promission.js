import request from '@/utils/request'

export function userList(query) {
  return request({
    url: '/permission/user',
    method: 'get',
    params: query
  })
}

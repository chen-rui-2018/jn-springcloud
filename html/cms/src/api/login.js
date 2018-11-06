import request from '@/utils/request'

export function loginByUsername(account, password) {
  const data = {
    account,
    password
  }
  // 'http://192.168.2.127/springcloud-app-system/login
  return request({
    url: 'http://192.168.2.139/springcloud-app-system/login',
    method: 'post',
    data
  })
}

export function logout() {
  return request({
    url: '/login/logout',
    method: 'post'
  })
}

export function getUserInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}


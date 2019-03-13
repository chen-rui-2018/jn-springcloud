import request from '@/utils/request'
var systemUrl = 'springcloud-app-system/'
export function loginByUsername(account, password) {
  localStorage.setItem('account', account)
  const data = {
    account,
    password
  }
  return request({
    url: systemUrl + 'login',
    method: 'post',
    data
  })
}
export function getUsername() {
  return request({
    url: systemUrl + 'system/sysUser/getUserInfo',
    method: 'post'
  })
}

export function logout() {
  return request({
    url: systemUrl + '/login/logout',
    method: 'post'
  })
}

export function getUserInfo(token) {
  return request({
    url: systemUrl + 'system/sysMenu/getDynamicMenu',
    method: 'post',
    params: { token }
  })
}


import request from '@/utils/request'

export function loginByUsername(account, password) {
  localStorage.setItem('account', account)
  const data = {
    account,
    password
  }
  return request({
    url: 'login',
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
    url: 'system/sysMenu/getDynamicMenu',
    method: 'post',
    params: { token }
  })
}


import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'

export function getToken() {
  return Cookies.get(TokenKey, { domain: 'bxgxq.com', path: '/' })
}

export function setToken(token) {
  return Cookies.set(TokenKey, token, { domain: 'bxgxq.com', path: '/' })
}

export function removeToken() {
  return Cookies.remove(TokenKey, { domain: 'bxgxq.com', path: '/' })
}

const UserInfo = 'User-Info'

export function setUserInfo(info) {
  return Cookies.set(UserInfo, info, { path: '/' })
}

export function getUserInfo() {
  return Cookies.get(UserInfo, { path: '/' })
}
export function removeUserInfo() {
  return Cookies.remove(UserInfo, { path: '/' })
}

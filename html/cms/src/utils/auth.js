import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'

export function getToken() {
  return Cookies.get(TokenKey, { path: '/' })
}

export function setToken(token) {
  return Cookies.set(TokenKey, token, { path: '/' })
}

export function removeToken() {
  return Cookies.remove(TokenKey, { path: '/' })
}

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

const LastTokenKey = 'Last-Admin-Token'

export function setLastToken(token) {
  return Cookies.set(LastTokenKey, token, { path: '/' })
}

export function getLastToken(token) {
  return Cookies.get(LastTokenKey, { path: '/' })
}
export function removeLastToken() {
  return Cookies.remove(LastTokenKey, { path: '/' })
}

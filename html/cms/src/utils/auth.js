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
export function isMobile() {
  const flag = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i)
  return flag
}

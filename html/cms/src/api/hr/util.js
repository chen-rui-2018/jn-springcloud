import request from '@/utils/request'
const baseurl = 'springcloud-hr/'
const baseUserurl = 'springcloud-app-system/'

export function getApi(url, query) {
  let params = ''
  if (query) {
    for (const i in query) {
      params += `&${i}=${query[i]}`
    }
  }
  return request({
    url: baseurl + `${url}?q=a${params}`,
    method: 'get'
  })
}

export function postApi(url, query) {
  return request({
    url: baseurl + `${url}`,
    method: 'post',
    data: query
  })
}

export function postUserApi(url, query) {
  return request({
    url: baseUserurl + `${url}`,
    method: 'post',
    data: query
  })
}

export function postApi2(url, query) {
  return request({
    url: `${url}`,
    method: 'post',
    data: query
  })
}

export function paramApi(url, query, parameter) {
  const param = new URLSearchParams()
  param.append(parameter, query)
  return request({
    url: baseurl + url,
    method: 'post',
    data: param
  })
}

export function getCode(query) {
  return request({
    url: 'springcloud-app-system/system/sysDict/getDict',
    method: 'post',
    data: query
  })
}

// 获取组织架构
export function getDepartMents() {
  return request({
    url: baseurl + `hr/employeeDepartment/getEmployeeDepartments`,
    method: 'get'
  })
}

export function isvalidMobile(str) {
  const reg = /^1[3|4|5|7|8][0-9]\d{8}$/
  return reg.test(str)
}

export function isvalidPhone(str) {
  const reg = /^0\d{2,3}-?\d{7,8}$/
  return reg.test(str)
}

export function isvalidName(str) {
  const reg = /^[\u4e00-\u9fa5\w]{1,30}$/
  return reg.test(str)
}

export function isvalidZjhm(str) {
  const reg = /^[\w]{1,20}$/
  return reg.test(str)
}

export function formatDate(objDate, format) {
  var o = {
    'M+': objDate.getMonth() + 1, // month
    'd+': objDate.getDate(), // day
    'h+': objDate.getHours(), // hour
    'm+': objDate.getMinutes(), // minute
    's+': objDate.getSeconds(), // second
    'q+': Math.floor((this.getMonth() + 3) / 3), // quarter
    'S': objDate.getMilliseconds() // millisecond
  }
  if (/(y+)/i.test(format)) {
    format = format.replace(RegExp.$1, (objDate.getFullYear() + '').substr(4 - RegExp.$1.length))
  }
  for (var k in o) {
    if (new RegExp('(' + k + ')').test(format)) {
      format = format.replace(RegExp.$1, RegExp.$1.length === 1 ? o[k] : ('00' + o[k]).substr(('' + o[k]).length))
    }
  }
  return format
}

export const uploadUrl = baseurl + `hr/common/uploadAttachment`

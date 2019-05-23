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
const aCity = { 11: '北京', 12: '天津', 13: '河北', 14: '山西', 15: '内蒙古', 21: '辽宁', 22: '吉林', 23: '黑龙江', 31: '上海', 32: '江苏', 33: '浙江', 34: '安徽', 35: '福建', 36: '江西', 37: '山东', 41: '河南', 42: '湖北', 43: '湖南', 44: '广东', 45: '广西', 46: '海南', 50: '重庆', 51: '四川', 52: '贵州', 53: '云南', 54: '西藏', 61: '陕西', 62: '甘肃', 63: '青海', 64: '宁夏', 65: '新疆', 71: '台湾', 81: '香港', 82: '澳门', 91: '国外' }

export function isvalidZjhm(sId) {
  var iSum = 0
  if (!/^\d{17}(\d|x)$/i.test(sId)) return '你输入的身份证长度或格式错误'
  sId = sId.replace(/x$/i, 'a')
  if (aCity[parseInt(sId.substr(0, 2))] == null) return '你的身份证地区非法'
  const sBirthday = sId.substr(6, 4) + '-' + Number(sId.substr(10, 2)) + '-' + Number(sId.substr(12, 2))
  var d = new Date(sBirthday.replace(/-/g, '/'))
  if (sBirthday !== (d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate())) return '身份证上的出生日期非法'
  for (var i = 17; i >= 0; i--) iSum += (Math.pow(2, i) % 11) * parseInt(sId.charAt(17 - i), 11)
  if (iSum % 11 !== 1) return '你输入的身份证号非法'
  // aCity[parseInt(sId.substr(0,2))]+","+sBirthday+","+(sId.substr(16,1)%2?"男":"女");//此次还可以判断出输入的身份证号的人性别
  return true
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

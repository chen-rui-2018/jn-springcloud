import request from '@/utils/request'
const baseurl = 'springcloud-hr/'
// 查询列表
export function api(url, query) {
  return request({
    url: baseurl + url,
    method: 'post',
    data: query
  })
}

export function apiGet(url) {
  return request({
    url: baseurl + url,
    method: 'get'
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
export function downloadTempExcel(url) {
  return request({
    url: baseurl + url,
    method: 'get'
  })
}

export function exportExcelByObj(url, parameter) {
  let params = ''
  for (const i in parameter) {
    params += `&${i}=${parameter[i]}`
  }
  return request({
    url: baseurl + url + `?q=a${params}`,
    method: 'get'
  })
}

export function exportExcel(url) {
  return request({
    url: baseurl + url,
    method: 'get'
  })
}
// 导入excel
export function importDatabase(formData, url) {
  return request({
    url: baseurl + url,
    method: 'post',
    data: formData
  })
}
// 返回
export function goBack(view, newView) {
  this.$store.dispatch('delView', view).then(({ visitedViews }) => {
    if (this.isActive(view)) {
      this.$router.push(newView)
    }
  })
}

/**
 * 获取上一个月
 *
 * @date 格式为yyyy-mm-dd的日期，如：2014-01-25
 */
export function getPreMonth(date) {
  const arr = date.split('-')
  const year = arr[0] // 获取当前日期的年份
  const month = arr[1] // 获取当前日期的月份
  const day = arr[2] // 获取当前日期的日
  // const days = new Date(year, month, 0)
  // days = days.getDate() // 获取当前日期中月的天数
  let year2 = year
  let month2 = parseInt(month) - 1
  if (month2 === 0) {
    year2 = parseInt(year2) - 1
    month2 = 12
  }
  let day2 = day
  let days2 = new Date(year2, month2, 0)
  days2 = days2.getDate()
  if (day2 > days2) {
    day2 = days2
  }
  if (month2 < 10) {
    month2 = '0' + month2
  }
  const t2 = year2 + '-' + month2
  return t2
}

/**
 * 获取下一个月
 *
 * @date 格式为yyyy-mm-dd的日期，如：2014-01-25
 */
export function getNextMonth(date) {
  const arr = date.split('-')
  const year = arr[0] // 获取当前日期的年份
  const month = arr[1] // 获取当前日期的月份
  const day = arr[2] // 获取当前日期的日
  // const days = new Date(year, month, 0)
  // days = days.getDate() // 获取当前日期中的月的天数
  let year2 = year
  let month2 = parseInt(month) + 1
  if (month2 === 13) {
    year2 = parseInt(year2) + 1
    month2 = 1
  }
  let day2 = day
  let days2 = new Date(year2, month2, 0)
  days2 = days2.getDate()
  if (day2 > days2) {
    day2 = days2
  }
  if (month2 < 10) {
    month2 = '0' + month2
  }
  return year2 + '-' + month2
}

export function systemApi(url, query) {
  return request({
    url: 'springcloud-app-system/' + url,
    method: 'post',
    data: query
  })
}

export function accAdd(num1, num2) {
  let r1
  let r2
  try { r1 = num1.toString().split('.')[1].length } catch (e) { r1 = 0 }
  try { r2 = num2.toString().split('.')[1].length } catch (e) { r2 = 0 }
  const m = 10 ** Math.max(r1, r2)
  const n = (r1 >= r2) ? r1 : r2
  return ((num1 * m + num2 * m) / m).toFixed(n)
}
export function accSub(num1, num2) {
  let r1
  let r2
  try { r1 = num1.toString().split('.')[1].length } catch (e) { r1 = 0 }
  try { r2 = num2.toString().split('.')[1].length } catch (e) { r2 = 0 }
  const n = (r1 >= r2) ? r1 : r2
  const m = 10 ** Math.max(r1, r2)
  return ((num1 * m - num2 * m) / m).toFixed(n)
}
export function accMul(num1, num2) {
  let m = 0
  try { m += num1.toString().split('.')[1].length } catch (e) { m += 0 }
  try { m += num2.toString().split('.')[1].length } catch (e) { m += 0 }
  return (Number(num1.toString().replace('.', '')) * Number(num2.toString().replace('.', ''))) / (10 ** m)
}
export function accDiv(arg1, arg2) {
  let t1
  let t2
  try { t1 = arg1.toString().split('.')[1].length } catch (e) { t1 = 0 }
  try { t2 = arg2.toString().split('.')[1].length } catch (e) { t2 = 0 }
  const r1 = Number(arg1.toString().replace('.', ''))
  const r2 = Number(arg2.toString().replace('.', ''))
  return (r1 / r2) * (10 ** (t2 - t1))
}

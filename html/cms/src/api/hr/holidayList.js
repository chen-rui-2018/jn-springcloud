import request from '@/utils/request'
var baseurl = 'springcloud-hr/'
export function api(url, query) {
  return request({
    url: baseurl + url,
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

// 导出假期列表
export function exportExcel(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/holidayRule/exportEmployeHoliday?q=a${params}`,
    method: 'get'
  })
}

// 获取组织架构
export function getDepartMents() {
  return request({
    url: baseurl + `hr/employeeDepartment/getEmployeeDepartments`,
    method: 'get'
  })
}

// 查询假期规则
export function getHolidayRuleList(query) {
  return request({
    url: baseurl + `hr/holidayRule/getHolidayRules`,
    method: 'post',
    data: query
  })
}

// 新增假期规则
export function addHolidayRule(query) {
  return request({
    url: baseurl + `hr/holidayRule/addHolidayRule`,
    method: 'post',
    data: query
  })
}

// 编辑假期规则
export function updateHolidayRule(query) {
  return request({
    url: baseurl + `hr/holidayRule/updateHolidayRule`,
    method: 'post',
    data: query
  })
}

// 删除假期规则
export function deleteHolidayRule(ruleId) {
  return request({
    url: baseurl + `hr/holidayRule/deleteHolidayRule?id=${ruleId}`,
    method: 'get'
  })
}

//假期修改

export function updateVacation(query) {
  return request({
    url: baseurl + `hr/holidayRule/updateVacationManage`,
    method: 'post',
    data: query
  })
}


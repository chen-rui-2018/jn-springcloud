import request from '@/utils/request'
var baseurl = 'springcloud-oa/'
var parkBaseurl = 'springcloud-park'
export function api(url, query) {
  return request({
    url: baseurl + url,
    method: 'post',
    data: query
  })
}
// export function paramApi(url, query, parameter) {
//   const param = new URLSearchParams()
//   param.append(parameter, query)
//   return request({
//     url: baseurl + url,
//     method: 'post',
//     data: param
//   })
// }
// 获取所有用户列表
// export function userAllList(query) {
//   return request({
//     url: 'springcloud-app-system/system/sysUser/getUserAll',
//     method: 'post',
//     data: query
//   })
// }
// 获取用户列表
// export function userList(query) {
//   return request({
//     url: baseurl + '/oa/addressBook/list',
//     method: 'post',
//     data: query
//   })
// }
// 获取用户信息
// export function getUserInfo(query) {
//   return request({
//     url: 'springcloud-app-system/system/sysUser/getUserInfo',
//     method: 'post',
//     data: query
//   })
// }
// 导出功能
// export function exportExcel(query) {
//   return request({
//     url: baseurl + `oa/oaMeeting/exportExcelMeeting?meetingRoomName=${query.meetingRoomName}&meetingStatus=${query.meetingStatus}&departmentName=${query.departmentName}&startTime=${query.startTime}&endTime=${query.endTime}`,
//     method: 'get'
//   })
// }
// // 获取平台类型
// export function getCode(query) {
//   return request({
//     url: 'springcloud-app-system/system/sysDict/getDict',
//     method: 'post',
//     data: query
//   })
// }
// 获取组织部门列表
export function getAllDepartment() {
  return request({
    url: parkBaseurl + '/finance/expenses/selectDepartment',
    method: 'get'
  })
}

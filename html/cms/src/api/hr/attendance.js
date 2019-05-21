import request from '@/utils/request'
var baseurl = 'springcloud-hr/'

// 查询考勤列表
export function list(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/attendanceManagementList`,
    method: 'post',
    data: query
  })
}

//导出考勤列表
export function exportAttendanceList(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/AttendanceManagement/exportAttendanceManagement?q=a${params}`,
    method: 'get'
  })
}


// 查询旷工明细
export function absenceDetailList(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/absenceDetailList`,
    method: 'post',
    data: query
  })
}

// 查询迟到明细
export function comeLateDetailList(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/comeLateDetailList`,
    method: 'post',
    data: query
  })
}

// 查询早退明细
export function leaveEarlyDetailList(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/leaveEarlyDetailList`,
    method: 'post',
    data: query
  })
}

// 查询缺卡明细
export function notCardDetailList(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/notCardDetailList`,
    method: 'post',
    data: query
  })
}

// 查询请假明细
export function leaveDetailist(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/leaveDetailist`,
    method: 'post',
    data: query
  })
}


// 查询班次
export function attendanceTimeSetList() {
  return request({
    url: baseurl + `hr/AttendanceManagement/attendanceTimeSetList`,
    method: 'post'
  })
}


// 添加班次
export function addAttendanceTimeSet(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/addAttendanceTimeSet`,
    method: 'post',
    data: query
  })
}

// 修改班次
export function updateAttendanceTimeSet(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/updateAttendanceTimeSet`,
    method: 'post',
    data: query
  })
}

// 删除班次
export function deleteAttendanceTimeSet(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/deleteAttendanceTimeSet`,
    method: 'post',
    data: query
  })
}

// 排班管理查询
export function scheduDetailistPage(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/scheduDetailistPage`,
    method: 'post',
    data: query
  })
}

// 导入排班管理
export function importScheduDetailist(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/importScheduDetailist`,
    method: 'post',
    data: query
  })
}

// 排班明细查询
export function scheduDetailist(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/scheduDetailist`,
    method: 'post',
    data: query
  })
}


// 排班明细导出
export function exportScheduDetailist(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/AttendanceManagement/exportScheduDetailist?q=a${params}`,
    method: 'get'
  })
}

// 排班明细修改
export function updateScheduDetailist(query) {
  return request({
    url: baseurl + `hr/AttendanceManagement/updateScheduDetailist`,
    method: 'post',
    data: query
  })
}

//导出旷工明细
export function exportAbsenceDetailList(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/AttendanceManagement/exportAbsenceDetailList?q=a${params}`,
    method: 'get'
  })
}

//导出迟到明细
export function exportComeLateDetailList(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/AttendanceManagement/exportComeLateDetailList?q=a${params}`,
    method: 'get'
  })
}

//导出早退明细
export function exportLeaveEarlyDetailList(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/AttendanceManagement/exportLeaveEarlyDetailList?q=a${params}`,
    method: 'get'
  })
}

//导出缺卡明细
export function exportNotCardDetailList(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/AttendanceManagement/exportNotCardDetailList?q=a${params}`,
    method: 'get'
  })
}

//导出请假明细
export function exportLeaveDetailist(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/AttendanceManagement/exportLeaveDetailist?q=a${params}`,
    method: 'get'
  })
}





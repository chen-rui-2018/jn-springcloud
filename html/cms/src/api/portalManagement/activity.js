import request from '@/utils/request'
// 获取活动管理页面所有数据
export function getActivityList(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/selectActivityList',
    method: 'post',
    data: query
  })
}
// 获取活动管理类型所有数据
export function getActivityType(query) {
  return request({
    // url: 'http://192.168.10.31:1101/springcloud-park/guest/findActivityTypeList',
    url: 'http://192.168.10.31:1101/springcloud-park/guest/activity/findActivityTypeList',
    method: 'post',
    data: query
  })
}
// 取消活动
export function cancelActivity(query) {
  const param = new URLSearchParams()
  param.append('activityId', query)
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/cancelActivity',
    method: 'post',
    data: param
  })
}
// 删除非草稿活动
export function deleteActivity(query) {
  const param = new URLSearchParams()
  param.append('activityId', query)
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/deleteActivity',
    method: 'post',
    data: param
  })
}
// 删除草稿活动
export function deleteDraftActivity(query) {
  const param = new URLSearchParams()
  param.append('activityId', query)
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/deleteDraftActivity',
    method: 'post',
    data: param
  })
}
// 停止报名
export function cancelApply(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/updateActivityApply',
    method: 'post',
    data: query
  })
}
// 停止报名
// export function pushMessage(query) {
//   const param = new URLSearchParams()
//   param.append('activityId', query)
//   return request({
//     url: 'http://192.168.10.31:1101/springcloud-park/activity/sendMsgForActivate',
//     method: 'post',
//     data: param
//   })
// }
// 获取活动海报
// export function getEventPoster(query) {
//   const param = new URLSearchParams()
//   param.append('typeId', query)
//   return request({
//     url: 'http://192.168.10.31:1101/springcloud-park/activity/activityType/findActivityType',
//     method: 'post',
//     data: param
//   })
// }
// 园区字典表
export function getParkCodeByType(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/parkCode/getParkCodeByType',
    method: 'post',
    data: query
  })
}
// 保存草稿
// export function saveActivityDraft(query) {
//   return request({
//     url: 'http://192.168.10.31:1101/springcloud-park/activity/saveActivityDraft',
//     method: 'post',
//     data: query
//   })
// }
// 发布
export function publishActivity(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/publishActivity',
    method: 'post',
    data: query
  })
}
// 活动报名列表
export function getApplyActivityList(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/applyActivityList',
    method: 'post',
    data: query
  })
}
// 下载签到二维码
// export function downloadSignCodeImg(query) {
//   return request({
//     url: 'http://192.168.10.31:1101/springcloud-park/activity/downloadSignCodeImg?activityId=' + query.activityId,
//     method: 'post',
//     data: query
//   })
// }
// 在线签到
export function signInActivity(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityApply/signInActivity',
    method: 'post',
    data: query
  })
}
// 后台签到
export function signInActivityBackend(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityApply/signInActivityBackend',
    method: 'post',
    data: query
  })
}
// 报名审核接口
export function signInActivityCheck(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityApply/signInActivityCheck',
    method: 'post',
    data: query
  })
}
// 活动报名人数导出
export function exportDataExcel(query) {
  return request({
    url: `http://localhost/springcloud-park/activity/exportDataExcel?activityId=${query.activityId}&exportColName=${query.exportColName}&exportTitle=${query.exportTitle}&page=${query.page}&rows=${query.rows}`,
    method: 'get'
  })
}
// 获取活动详情
// export function getActivityDetailsForManage(query) {
//   const param = new URLSearchParams()
//   param.append('activityId', query)
//   return request({
//     url: 'http://192.168.10.31:1101/springcloud-park/activity/getActivityDetailsForManage',
//     method: 'post',
//     data: param
//   })
// }

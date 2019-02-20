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
    url: 'http://192.168.10.31:1101/springcloud-park/guest/findActivityTypeList',
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
// 删除非草稿活动
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
export function pushMessage(query) {
  const param = new URLSearchParams()
  param.append('activityId', query)
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/sendMsgForActivate',
    method: 'post',
    data: param
  })
}
// 获取活动海报
export function getEventPoster(query) {
  const param = new URLSearchParams()
  param.append('typeId', query)
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityType/findActivityType',
    method: 'post',
    data: param
  })
}
// 园区字典表
export function getParkCodeByType(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/parkCode/getParkCodeByType',
    method: 'post',
    data: query
  })
}
// 保存草稿
export function saveActivityDraft(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/saveActivityDraft',
    method: 'post',
    data: query
  })
}
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
export function downloadSignCodeImg(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/downloadSignCodeImg',
    method: 'post',
    data: query
  })
}

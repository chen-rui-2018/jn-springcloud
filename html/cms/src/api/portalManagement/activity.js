import request from '@/utils/request'
// 获取活动管理页面所有数据
export function getActivityList(query) {
  return request({
    url: 'http://localhost/springcloud-park/activity/selectActivityList',
    method: 'post',
    data: query
  })
}
// 获取活动管理类型所有数据
export function getActivityType(query) {
  return request({
    url: 'http://localhost/springcloud-park/guest/findActivityTypeList',
    method: 'post',
    data: query
  })
}
// 取消活动
export function cancelActivity(query) {
  const param = new URLSearchParams()
  param.append('activityId', query)
  return request({
    url: 'http://localhost/springcloud-park/activity/cancelActivity',
    method: 'post',
    data: param
  })
}
// 删除非草稿活动
export function deleteActivity(query) {
  const param = new URLSearchParams()
  param.append('activityId', query)
  return request({
    url: 'http://localhost/springcloud-park/activity/deleteActivity',
    method: 'post',
    data: param
  })
}
// 删除非草稿活动
export function deleteDraftActivity(query) {
  const param = new URLSearchParams()
  param.append('activityId', query)
  return request({
    url: 'http://localhost/springcloud-park/activity/deleteDraftActivity',
    method: 'post',
    data: param
  })
}
// 停止报名
export function cancelApply(query) {
  return request({
    url: 'http://localhost/springcloud-park/activity/updateActivityApply',
    method: 'post',
    data: query
  })
}
// 停止报名
export function pushMessage(query) {
  const param = new URLSearchParams()
  param.append('activityId', query)
  return request({
    url: 'http://localhost/springcloud-park/activity/sendMsgForActivate',
    method: 'post',
    data: param
  })
}

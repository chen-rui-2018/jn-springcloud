import request from '@/utils/request'
// 获取活动管理页面所有数据
export function getTypeList(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityType/findActivityTypeList',
    method: 'post',
    data: query
  })
}
// 根据ID 获取当前活动类型内容
export function findActivityType(query) {
  const param = new URLSearchParams()
  param.append('typeId', query)
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityType/findActivityType',
    method: 'post',
    data: param
  })
}
// 删除活动类型
export function deleteActivityTypeList(query) {
  const param = new URLSearchParams()
  param.append('typeId', query)
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityType/deleteActivityTypeList',
    method: 'post',
    data: param
  })
}
// 增加活动类型
export function activityTypeAdd(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityType/add',
    method: 'post',
    data: query
  })
}
// 编辑活动类型
export function updateActivityType(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityType/updateActivityType',
    method: 'post',
    data: query
  })
}

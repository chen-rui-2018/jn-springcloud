import request from '@/utils/request'
// 获取活动管理页面所有数据
export function getTypeList(query) {
  return request({
    url: 'http://192.168.10.31:1101/springcloud-park/activity/activityType/findActivityTypeList',
    method: 'post',
    data: query
  })
}
// // 获取活动管理类型所有数据
// export function getActivityType(query) {
//   return request({
//     url: 'http://localhost/springcloud-park/guest/findActivityTypeList',
//     method: 'post',
//     data: query
//   })
// }

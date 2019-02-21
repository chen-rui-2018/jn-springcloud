// import request from '@/utils/request'
// 获取岗位所有数据
// export function getAllList(query) {
//   return request({
//     url: 'system/sysPost/list',
//     method: 'post',
//     data: query
//   })
// }
// 新增岗位
// export function addPostList(query) {
//   return request({
//     url: 'system/sysPost/add',
//     method: 'post',
//     data: query
//   })
// }
// 校验岗位名称是否存在,success表示角色名可用,false不可用
// export function checkPostName(query) {
//   const param = new URLSearchParams()
//   param.append('postName', query)
//   return request({
//     url: 'system/sysPost/checkPostName',
//     method: 'post',
//     data: param
//   })
// }
// 编辑岗位
// export function editPostList(query) {
//   return request({
//     url: 'system/sysPost/update',
//     method: 'post',
//     data: query
//   })
// }
// 删除岗位
// export function deletePostById(query) {
//   const param = new URLSearchParams()
//   param.append('postIds', query)
//   return request({
//     url: 'system/sysPost/delete',
//     method: 'post',
//     data: param
//   })
// }
// 获取所有岗位类型
// export function getAllPostType(query) {
//   return request({
//     url: 'system/sysPostType/getPostTypeAll',
//     method: 'post',
//     data: query
//   })
// }

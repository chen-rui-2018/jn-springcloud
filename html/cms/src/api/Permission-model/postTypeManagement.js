// import request from '@/utils/request'

// 获取岗位类型所有数据
// export function getPostTypeList(query) {
//   return request({
//     url: 'system/sysPostType/list',
//     method: 'post',
//     data: query
//   })
// }

// 编辑岗位类型
// export function editPostTypeList(query) {
//   return request({
//     url: 'system/sysPostType/update',
//     method: 'post',
//     data: query
//   })
// }
// 新增岗位类型
// export function addPostTypeList(query) {
//   return request({
//     url: 'system/sysPostType/add',
//     method: 'post',
//     data: query
//   })
// }
// 校验文件组名称是否存在,success表示文件组名可用,false不可用
// export function checkPostTypeName(query) {
//   const param = new URLSearchParams()
//   param.append('postTypeName', query)
//   return request({
//     url: 'system/sysPostType/checkPostTypeName',
//     method: 'post',
//     data: param
//   })
// }
// 删除角色
// export function deletePostTypeById(query) {
//   const param = new URLSearchParams()
//   param.append('postTypeId', query)
//   return request({
//     url: 'system/sysPostType/delete',
//     method: 'post',
//     data: param
//   })
// }

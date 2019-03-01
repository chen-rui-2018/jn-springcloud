// import request from '@/utils/request'

// 获取文件组所有数据
// export function allFileGroupList(query) {
//   return request({
//     url: 'system/sysFileGroup/list',
//     method: 'post',
//     data: query
//   })
// }

// 编辑文件组
// export function updataFileGroup(query) {
//   return request({
//     url: 'system/sysFileGroup/update',
//     method: 'post',
//     data: query
//   })
// }
// 新增文件组
// export function addFileGroupList(query) {
//   return request({
//     url: 'system/sysFileGroup/add',
//     method: 'post',
//     data: query
//   })
// }
// 校验文件组名称是否存在,success表示文件组名可用,false不可用
// export function checkFileGroupName(query) {
//   const param = new URLSearchParams()
//   param.append('fileGroupName', query)
//   return request({
//     url: 'system/sysFileGroup/checkFileGroupName',
//     method: 'post',
//     data: param
//   })
// }
// 删除角色
// export function deleteFileGroupById(query) {
//   const param = new URLSearchParams()
//   param.append('ids', query)
//   return request({
//     url: 'system/sysFileGroup/delete',
//     method: 'post',
//     data: param
//   })
// }

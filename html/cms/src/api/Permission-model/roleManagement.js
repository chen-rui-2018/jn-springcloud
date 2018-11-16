import request from '@/utils/request'
// 获取角色所有数据
export function roleList(query) {
  return request({
    url: 'system/sysRole/list',
    method: 'post',
    data: query
  })
}
// 新增角色
export function addRoleList(query) {
  return request({
    url: 'system/sysRole/add',
    method: 'post',
    data: query
  })
}
// 校验角色名称是否存在,success表示角色名可用,false不可用
export function checkroleName(query) {
  const param = new URLSearchParams()
  param.append('roleName', query)
  return request({
    url: 'system/sysGroup/checkGroupName',
    method: 'post',
    data: param
  })
}

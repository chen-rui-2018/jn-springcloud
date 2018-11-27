import request from '@/utils/request'
// 获取部门所有数据
export function getDepartment() {
  return request({
    url: 'system/sysDepartment/findDepartmentAllByLevel',
    method: 'post'
  })
}
// 新增部门
export function createDepartment(query) {
  return request({
    url: 'system/sysDepartment/add',
    method: 'post',
    data: query
  })
}
// 编辑部门
export function updateDepartment(query) {
  return request({
    url: 'system/sysDepartment/update',
    method: 'post',
    data: query
  })
}
// 校验部门名称是否存在,success表示部门名可用,fail不可用
export function checkDepartmentName(query) {
  const param = new URLSearchParams()
  param.append('departmentName', query)
  return request({
    url: 'system/sysDepartment/checkDepartmentName',
    method: 'post',
    data: param
  })
}
// 删除部门
export function deleteDepartmentById(query) {
  const param = new URLSearchParams()
  param.append('departmentIds', query)
  return request({
    url: 'system/sysDepartment/delete',
    method: 'post',
    data: param
  })
}

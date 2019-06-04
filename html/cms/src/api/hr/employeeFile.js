import request from '@/utils/request'
const baseurl = 'springcloud-hr/'

// 新增员工档案分类
export function addEmployeeFileClass(query) {
  return request({
    url: baseurl + `hr/employeeFileClass/addEmployeeFileClass`,
    method: 'post',
    data: query
  })
}

// 编辑员工档案分类
export function updateEmployeeFileClass(query) {
  return request({
    url: baseurl + `hr/employeeFileClass/updateEmployeeFileClass`,
    method: 'post',
    data: query
  })
}

// 删除员工档案分类
export function deleteEmployeeFileClass(id) {
  return request({
    url: baseurl + `hr/employeeFileClass/deleteEmployeeFileClass?id=${id}`,
    method: 'get'
  })
}

// 查询员工档案分类树
export function getTreeList() {
  return request({
    url: baseurl + `hr/employeeFileClass/getTreeList`,
    method: 'get'
  })
}

// 新增员工档案
export function addEmployeeFile(query) {
  return request({
    url: baseurl + `hr/employeeFile/addEmployeeFile`,
    method: 'post',
    data: query
  })
}

// 编辑员工档案
export function updateEmployeeFile(query) {
  return request({
    url: baseurl + `hr/employeeFile/updateEmployeeFile`,
    method: 'post',
    data: query
  })
}

// 查询员工档案列表
export function list(query) {
  return request({
    url: baseurl + `hr/employeeFile/list`,
    method: 'post',
    data: query
  })
}

// 查询员工档案详情
export function getEmployeeFile(id) {
  return request({
    url: baseurl + `hr/employeeFile/getEmployeeFile?id=${id}`,
    method: 'get'
  })
}

// 删除员工档案
export function deleteEmployeeFile(id) {
  return request({
    url: baseurl + `hr/employeeFile/deleteEmployeeFile?id=${id}`,
    method: 'get'
  })
}

// 附件上传
export function uploadAttachment(query) {
  return request({
    url: 'zuul/' + baseurl + `hr/employeeFile/uploadAttachment`,
    method: 'post',
    data: query
  })
}

// 附件删除
export function deleteAttachment(id) {
  return request({
    url: baseurl + `hr/employeeFile/deleteAttachment?id=${id}`,
    method: 'get'
  })
}

// 导入员工档案excel
export function importEmployeeFile(formData) {
  return request({
    url: baseurl + `hr/employeeFile/importEmployeeFile`,
    method: 'post',
    data: formData
  })
}

// 导出员工档案
export function exportEmployeeFile(query) {
  let params = ''
  for (const i in query) {
    params += `&${i}=${query[i]}`
  }
  return request({
    url: baseurl + `hr/employeeFile/exportEmployeeFile?q=a${params}`,
    method: 'get'
  })
}

// 下载员工档案excel模板
export function downLoadEmployeeFileExcelTemplate() {
  return request({
    url: baseurl + `hr/employeeFile/downLoadEmployeeFileExcelTemplate`,
    method: 'get'
  })
}

// 分页查询员工档案附件列表
export function getEmployeeFileAttachmentById(query) {
  return request({
    url: baseurl + `hr/employeeFile/getEmployeeFileAttachmentById`,
    method: 'post',
    data: query
  })
}

// 员工档案附件名称修改
export function updateEmployeeFileAttachment(query) {
  return request({
    url: baseurl + `hr/employeeFile/updateEmployeeFileAttachment`,
    method: 'post',
    data: query
  })
}

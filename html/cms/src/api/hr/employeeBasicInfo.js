import request from '@/utils/request'
var baseurl = 'springcloud-hr/'


// 新增组织架构
export function addEmployeeDepartment(query) {
  return request({
    url: baseurl + `hr/employeeDepartment/addEmployeeDepartment`,
    method: 'post',
    data: query
  })
}

// 编辑组织架构
export function updateEmployeeDepartment(query) {
  return request({
    url: baseurl + `hr/employeeDepartment/updateEmployeeDepartment`,
    method: 'post',
    data: query
  })
}

// 删除组织架构
export function deleteEmployeeDepartment(id) {
  return request({
    url: baseurl + `hr/employeeDepartment/deleteEmployeeDepartment?id=${id}`,
    method: 'get'
  })
}

// 查询组织架构树
export function getTreeList() {
  return request({
    url: baseurl + `hr/employeeDepartment/getEmployeeDepartments`,
    method: 'get'
  })
}


// 新增员工花名册
export function addEmployeeBasicInfo(query) {
  return request({
    url: baseurl + `hr/employeeBasicInfo/addEmployeeBasicInfo`,
    method: 'post',
    data: query
  })
}


// 编辑员工花名册
export function updateEmployeeBasicInfo(query) {
  return request({
    url: baseurl + `hr/employeeBasicInfo/updateEmployeeBasicInfo`,
    method: 'post',
    data: query
  })
}

// 查询员工花名册列表
export function list(query) {
  return request({
    url: baseurl + `hr/employeeBasicInfo/list`,
    method: 'post',
    data: query
  })
}

// 查询员工花名册详情
export function getEmployeeBasicInfo(id) {
  return request({
    url: baseurl + `hr/employeeBasicInfo/getEmployeeBasicInfo?id=${id}`,
    method: 'get'
  })
}


// 删除员工花名册
export function deleteEmployeeBasicInfo(id) {
  return request({
    url: baseurl + `hr/employeeBasicInfo/deleteEmployeeBasicInfo?id=${id}`,
    method: 'get'
  })
}


// 导入员工花名册excel
export function importEmployeeBasicInfo(formData) {
  return request({
    url: baseurl + `hr/employeeBasicInfo/importEmployeeBasicInfo`,
    method: 'post',
    data: formData
  })
}

// 导出员工花名册
export function exportEmployeeBasicInfo(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/employeeBasicInfo/exportEmployeeBasicInfo?q=a${params}`,
    method: 'get'
  })
}

// 下载员工花名册excel模板
export function downLoadEmployeeBasicInfoExcelTemplate() {
  return request({
    url: baseurl + `hr/employeeBasicInfo/downLoadEmployeeBasicInfoExcelTemplate`,
    method: 'get'
  })
}

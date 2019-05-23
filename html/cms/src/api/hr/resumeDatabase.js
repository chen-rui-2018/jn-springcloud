import request from '@/utils/request'
var baseurl = 'springcloud-hr/'

// 查询员工简历库
export function getResumeDatabaseList(query) {
  return request({
    url: baseurl + `hr/resumeData/list`,
    method: 'post',
    data: query
  })
}

// 新增员工简历库
export function addResumeDatabase(query) {
  return request({
    url: baseurl + `hr/resumeData/addResumeData`,
    method: 'post',
    data: query
  })
}

// 编辑员工简历库
export function updateResumeDatabase(query) {
  return request({
    url: baseurl + `hr/resumeData/updateResumeData`,
    method: 'post',
    data: query
  })
}

// 删除员工简历库
export function deleteResumeDatabase(ruleId) {
  return request({
    url: baseurl + `hr/resumeData/delete?id=${ruleId}`,
    method: 'get'
  })
}

// 查询员工简历库详情
export function getResumeDatabaseById(ruleId) {
  return request({
    url: baseurl + `hr/resumeData/getResumeDatabaseById?id=${ruleId}`,
    method: 'get'
  })
}

// 导出简历库
export function exportResumeDatabase(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/resumeData/exportResumeDatabase?q=a${params}`,
    method: 'get'
  })
}

// 下载员工简历库excel模板
export function downloadResumeDatabaseExcel() {
  return request({
    url: baseurl + `hr/resumeData/downLoadResumeDatabaseExcelTemplate`,
    method: 'get'
  })
}

// 导入简历库excel
export function importResumeDatabase(formData) {
  return request({
    url: baseurl + `hr/resumeData/importResumeDatabase`,
    method: 'post',
    data: formData
  })
}

// 通过简历
export function passResumeDatabase(id) {
  return request({
    url: baseurl + `hr/resumeData/passResumeDatabase?id=${id}`,
    method: 'get'
  })
}
// 淘汰简历
export function notPassResumeDatabase(id) {
  return request({
    url: baseurl + `hr/resumeData/notPassResumeDatabase?id=${id}`,
    method: 'get'
  })
}

// 完成背景调查
export function finishBackgroundInvest(query) {
  return request({
    url: baseurl + `hr/resumeData/finishBackgroundInvest`,
    method: 'post',
    data: query
  })
}

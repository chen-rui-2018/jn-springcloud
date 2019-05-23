import request from '@/utils/request'
var baseurl = 'springcloud-hr/'

// 新增试题库
export function addExamSendExam(query) {
  return request({
    url: baseurl + `hr/exam/addExaminaManagement`,
    method: 'post',
    data: query
  })
}
// 试题库列表
export function examSelectExaminaManagementList(query) {
  return request({
    url: baseurl + `hr/exam/selectExaminaManagementList`,
    method: 'post',
    data: query
  })
}

// 试题详情
export function examSelectExamInfo(query) {
  return request({
    url: baseurl + `hr/exam/selectExamInfo`,
    method: 'post',
    data: query
  })
}
// 删除试卷
export function examDeleteExamInfo(query) {
  return request({
    url: baseurl + `hr/exam/deleteExamInfo`,
    method: 'post',
    data: query
  })
}

// 删除试卷
export function examSelectResultList(query) {
  return request({
    url: baseurl + `hr/exam/selectResultList`,
    method: 'post',
    data: query
  })
}
// 登录考试
export function examLoginManagement(query) {
  return request({
    url: baseurl + `hr/exam/loginManagement`,
    method: 'post',
    data: query
  })
}
// 提交考试
export function examInsterAnswerCard(query) {
  return request({
    url: baseurl + `hr/exam/insterAnswerCard`,
    method: 'post',
    data: query
  })
}
// 提交考试
export function examSelectExamAndAnswerCard(query) {
  return request({
    url: baseurl + `hr/exam/selectExamAndAnswerCard`,
    method: 'post',
    data: query
  })
}

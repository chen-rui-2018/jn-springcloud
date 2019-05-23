import request from '@/utils/request'
var baseurl = 'springcloud-hr/'

export function api(url, query) {
  return request({
    url: baseurl + url,
    method: 'post',
    data: query
  })
}
export function paramApi(url, query, parameter) {
  const param = new URLSearchParams()
  param.append(parameter, query)
  return request({
    url: baseurl + url,
    method: 'post',
    data: param
  })
}

// 新建课程
export function addManagement(query) {
  return request({
    url: 'hr/train/list/addManagement',
    method: 'post',
    data: query
  })
}

// 结束课程
export function deleteManagement(query) {
  return request({
    url: 'hr/train/list/deleteManagement',
    method: 'post',
    data: query
  })
}

// 邮件发送培训通知
export function emailList(query) {
  return request({
    url: 'hr/train/list/emailList',
    method: 'post',
    data: query
  })
}

// 导出培训记录
export function exportExcel(query) {
  let params = ''
  for (const i in query) {
    params += `&${i}=${query[i]}`
  }
  return request({
    url: baseurl + `hr/train/list/exportManagement?${params}`,
    method: 'get'
  })
}

// 培训列表分页查询
export function managementList(query) {
  return request({
    url: 'hr/train/list/managementList',
    method: 'post',
    data: query
  })
}

// 课程详情
export function selectManagement(query) {
  return request({
    url: 'hr/train/list/selectManagement',
    method: 'post',
    data: query
  })
}

// 获取通知人员列表
export function selectUserList(query) {
  return request({
    url: 'hr/train/list/selectUserList',
    method: 'post',
    data: query
  })
}

// 修改课程
export function updateManagement(query) {
  return request({
    url: 'hr/train/list/updateManagement',
    method: 'post',
    data: query
  })
}

// 培训记录分页查询
export function managemenRecordtList(query) {
  return request({
    url: 'hr/train/list/managemenRecordtList',
    method: 'post',
    data: query
  })
}

/** *调研部分******************************************** */

// web端-新增答题记录
export function addAnswerInfo(query) {
  return request({
    url: 'hr/train/addAnswerInfo',
    method: 'post',
    data: query
  })
}

// 新建项目-项目信息
export function addInvestiage(query) {
  return request({
    url: 'hr/train/addInvestiage',
    method: 'post',
    data: query
  })
}

// 新建项目及题目
export function addInvestiageAndQuestion(query) {
  return request({
    url: 'hr/train/addInvestiageAndQuestion',
    method: 'post',
    data: query
  })
}

// 新建项目-问题信息
export function addQuestion(query) {
  return request({
    url: 'hr/train/addQuestion',
    method: 'post',
    data: query
  })
}

// 结束调研
export function daleteInvestigate(query) {
  return request({
    url: 'hr/train/daleteInvestigate',
    method: 'post',
    data: query
  })
}

// 调研项目信息列表
export function listInvestigate(query) {
  return request({
    url: 'hr/train/listInvestigate',
    method: 'post',
    data: query
  })
}

// 调研登陆页
export function loginInvestiage(query) {
  return request({
    url: 'hr/train/loginInvestiage',
    method: 'post',
    data: query
  })
}

// 汇总统计
export function questionAnswerList(query) {
  return request({
    url: 'hr/train/questionAnswerList',
    method: 'post',
    data: query
  })
}

// 项目详情
export function selectInvestigatet(query) {
  return request({
    url: 'hr/train/selectInvestigatet',
    method: 'post',
    data: query
  })
}

// 单人统计详情
export function selectSurveyResult(query) {
  return request({
    url: 'hr/train/selectSurveyResult ',
    method: 'post',
    data: query
  })
}

// 发放调研
export function sendInvestiage(query) {
  return request({
    url: 'hr/train/sendInvestiage',
    method: 'post',
    data: query
  })
}

// 单人统计列表
export function surveyResultList(query) {
  return request({
    url: 'hr/train/surveyResultList',
    method: 'post',
    data: query
  })
}

// 编辑项目
export function update(query) {
  return request({
    url: 'hr/train/update',
    method: 'post',
    data: query
  })
}

// 编辑项目
export function updateInvestiage(query) {
  return request({
    url: 'hr/train/updateInvestiage',
    method: 'post',
    data: query
  })
}

// 编辑调研项目问题
export function updateQuestion(query) {
  return request({
    url: 'hr/train/updateQuestion',
    method: 'post',
    data: query
  })
}

/* 问卷部分*************************************************************** */

// web端/app 新增答题记录
export function addAnswerInfoQuest(query) {
  return request({
    url: 'hr/train/quest/addAnswerInfoQuest',
    method: 'post',
    data: query
  })
}

// 新建项目及问题信息
export function addInvestiageAndQuestionQuest(query) {
  return request({
    url: 'hr/train/quest/addInvestiageAndQuestionQuest',
    method: 'post',
    data: query
  })
}

// 删除调研
export function daleteInvestigateQuest(query) {
  return request({
    url: 'hr/train/quest/daleteInvestigateQuest',
    method: 'post',
    data: query
  })
}

// 编辑问卷项目题目-删除
export function deleteQuestionQuest(query) {
  return request({
    url: 'hr/train/quest/deleteQuestionQuest',
    method: 'post',
    data: query
  })
}

// 结束调研
export function endInvestiageQuest(query) {
  return request({
    url: 'hr/train/quest/endInvestiageQuest',
    method: 'post',
    data: query
  })
}

// 调研项目信息列表
export function listInvestigateQuest(query) {
  return request({
    url: 'hr/train/quest/listInvestigateQuest',
    method: 'post',
    data: query
  })
}

// 调研登陆页
export function loginInvestiageQuest(query) {
  return request({
    url: 'hr/train/quest/loginInvestiageQuest',
    method: 'post',
    data: query
  })
}

// 汇总统计
export function questionAnswerListQuest(query) {
  return request({
    url: 'hr/train/quest/questionAnswerListQuest',
    method: 'post',
    data: query
  })
}

//  项目详情
export function selectInvestigateQuest(query) {
  return request({
    url: 'hr/train/quest/selectInvestigateQuest',
    method: 'post',
    data: query
  })
}

// 单人统计-详情页
export function selectSurveyResultQuest(query) {
  return request({
    url: 'hr/train/quest/selectSurveyResultQuest',
    method: 'post',
    data: query
  })
}

// 发放调研
export function sendInvestiageQuest(query) {
  return request({
    url: 'hr/train/quest/sendInvestiageQuest',
    method: 'post',
    data: query
  })
}

// 单人统计-列表
export function surveyResultListQuest(query) {
  return request({
    url: 'hr/train/quest/surveyResultListQuest',
    method: 'post',
    data: query
  })
}

// 编辑项目
export function updateInvestiageQuest(query) {
  return request({
    url: 'hr/train/quest/updateInvestiageQuest',
    method: 'post',
    data: query
  })
}

// 编辑问卷项目题目-更新及修改
export function updateQuestionQuest(query) {
  return request({
    url: 'hr/train/quest/updateQuestionQuest',
    method: 'post',
    data: query
  })
}

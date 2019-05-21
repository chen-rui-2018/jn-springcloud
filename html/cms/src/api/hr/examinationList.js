import request from '@/utils/request'
let baseurl = 'springcloud-hr/'

// 新增试题库
export function addExaminationBank(query) {
  return request({
    url: baseurl + `hr/exam/addExaminaBank`,
    method: 'post',
    data: query
  })
}

// 编辑试题库
export function updateExaminationbank(query) {
  return request({
    url: baseurl + `hr/exam/updateExaminabank`,
    method: 'post',
    data: query
  })
}

// 删除试题库
export function deleteExaminaBank(query) {
  return request({
    url: baseurl + `hr/exam/deleteExaminaBank`,
    method: 'post',
    data:query
  })
}



// 查询试题库列表
export function selectBankList(query) {
  return request({
    url: baseurl + `hr/exam/selectBankList`,
    method: 'post',
    data:query
  })
}

// 查询试题库详情
export function selectExaminabank(query) {
  return request({
    url: baseurl + `hr/exam/selectExaminabank`,
    method: 'post',
    data:query
  })
}


// 导出试题库
export function exportExaminabank(query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `hr/exam/exportExaminabank?q=a${params}`,
    method: 'get'
  })
}

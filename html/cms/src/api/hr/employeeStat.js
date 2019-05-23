import request from '@/utils/request'
var baseurl = 'springcloud-hr/'

// 导出假期列表
export function getApi(url,query) {
  let params='';
  for(const i in query){
    params+=`&${i}=${query[i]}`;
  }
  return request({
    url: baseurl + `${url}?q=a${params}`,
    method: 'get'
  })
}


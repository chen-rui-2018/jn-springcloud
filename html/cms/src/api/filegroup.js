import request from '@/utils/request'
// 'http://192.168.2.139:1101/springcloud-app-system/system/sysUser/findSysUserByPage
// url: '/permission/user'

// 获取文件组所有数据
export function allfilegroupList(query) {
  return request({
    url: 'system/sysFileGroup/list',
    method: 'post',
    data: query
  })
}

// 编辑文件组
export function updataFilegroup(query) {
  return request({
    url: 'system/sysGroup/add',
    method: 'post',
    data: query
  })
}
// 新增文件组
export function addFilegroupList(query) {
  return request({
    url: 'system/sysGroup/add',
    method: 'post',
    data: query
  })
}

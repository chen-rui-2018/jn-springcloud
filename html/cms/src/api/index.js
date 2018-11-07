import axios from 'axios'
// 配置基准路径
const baseURL = 'http://192.168.2.139/springcloud-app-system/'
// 设置默认的基准路径
axios.defaults.baseURL = baseURL
// 获取所有用户数据
export const getAllUserList = (pa) => {
  return axios.post('system/sysUser/findSysUserByPage',
    pa,
    {
      headers: {
        'token': 'e994adfe-11d8-4ccb-9eb2-d29ef703a568'
      }
    }).then((res) => {
    return res
  })
}


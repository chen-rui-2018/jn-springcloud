import axios from 'axios'
// 配置基准路径
const baseURL = 'http://192.168.2.139:1101/springcloud-app-system/'
// 设置默认的基准路径
axios.defaults.baseURL = baseURL
// 获取所有用户数据
export const getAllUserList = (pa) => {
  return axios.post('sysUser/findSysUserByPage', { params: pa }).then((res) => {
    return res
  })
}


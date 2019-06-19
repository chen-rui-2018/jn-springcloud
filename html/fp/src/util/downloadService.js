import axios from 'axios'
import { BASE_URL } from './url'
const downloadService = axios.create({
  baseURL: BASE_URL,
  timeout: 10000, // 请求超时时间
})
downloadService.interceptors.response.use(
  response => {
    // 导出
    return response
  },
  error => {
    return Promise.reject(error)
  }
)

const download = (data, name) => {
  return new Promise(resolve => {
    const blob = new Blob([data])
    const fileName = name || 'download'
    if ('download' in document.createElement('a')) { // 非IE下载
      const elink = document.createElement('a')
      elink.setAttribute('download', fileName + '.xlsx')
      elink.style.display = 'none'
      elink.href = URL.createObjectURL(blob)
      document.body.appendChild(elink)
      elink.click()
      URL.revokeObjectURL(elink.href) // 释放URL 对象
      document.body.removeChild(elink)
    } else { // IE10+下载
      navigator.msSaveBlob(blob, fileName)
    }
    resolve()
  })
}
export { downloadService, download}

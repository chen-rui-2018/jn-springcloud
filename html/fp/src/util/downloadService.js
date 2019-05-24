import axios from 'axios'
const downloadService = axios.create({
  baseURL: 'http://112.94.22.222:8000/',
  timeout: 10000, // 请求超时时间
})
downloadService.interceptors.response.use(
  response => {
    // 导出
    const headers = response.headers
    if (headers['content-type'] === 'application/vnd.ms-excel;charset=UTF-8') {
      return response.data
    }
  },
  error => {
    return Promise.reject(error)
  }
)

const download = (data, name) => {
  return new Promise(resolve => {
    const blob = new Blob([data])
    // const fileName = name
    if ('download' in document.createElement('a')) { // 非IE下载
      const elink = document.createElement('a')
      elink.setAttribute('download', name + '.xlsx')
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

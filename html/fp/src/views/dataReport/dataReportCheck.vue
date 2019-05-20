<template>
<div class="data-report-check">
  <div class="btn-row">
    <el-button type="primary" @click="exportData">导出</el-button>
  </div>
  <data-report-form ref="form"></data-report-form>
</div>
</template>

<script>
import dataReportForm from './dataReportForm'
import { downloadService, download} from '@/util/downloadService'
export default {
  name: 'DataReportCheck',
  components: {
    dataReportForm
  },
  methods: {
    exportData() {
      const formData = this.$refs.form.getFormData()
      const modelId = formData.modelId
      const taskBatch = formData.taskInfo.taskBatch
      let url
      if (formData.modelName !== '园区管委会目标') {
        url = `springcloud-enterprise/data/garden/getCompanyExcel?modelid=${modelId}&taskbatch=${taskBatch}`
      } else {
        url = `springcloud-enterprise/data/garden/getDescribeExcel?modelid=${modelId}&taskbatch=${taskBatch}`
      }
      downloadService({
        method: 'get',
        url: url,
        responseType: 'blob',
        headers: {
          token: sessionStorage.token
        }
      }).then(response => {
        download(response, '导出模板')
          .then(() => {
            this.$message.success('导出成功')
          })
      }).catch((error) => {

      })
    }
  }
}
</script>
<style lang="scss">
  .data-report-check {
    padding-top: 100px;
    background-color: #f5f5f5;
    .btn-row {
      padding: 20px;
      text-align: right;
    }
  }
</style>

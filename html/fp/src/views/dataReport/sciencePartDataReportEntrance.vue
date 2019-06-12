<template>
  <div class="science-part">
    <div class="search-row">
      <div class="search-row-cell">
        <div class="search-row-cell-form">
          <span>账期：</span>
          <el-date-picker
            v-model="queryParams.formTime"
            type="date"
            placeholder="选择日期"
            style="width: 160px;margin-right: 10px"
            disabled
            clearable
          ></el-date-picker>
        </div>
        <div class="search-row-cell-form">
          <span>纳税人名称：</span>
          <el-input v-model="queryParams.companyName" style="width: 160px" placeholder="请输入内容" clearable></el-input>
        </div>
      </div>
      <div class="search-row-cell tr">
        <el-button type="primary" size="small" @click="queryData">查询</el-button>
        <el-button type="primary" size="small" @click="importExcel">下载模板</el-button>
        <el-button :disabled="tableData.length > 0" type="primary" size="small" style="position: relative">
          <span>导入</span>
          <input v-if="tableData.length === 0" type="file" class="upload-file" @change="upload"/>
        </el-button>
        <el-button type="primary" size="small" @click="exportExcel">导出</el-button>
      </div>
    </div>
    <el-table
      :data="tableData"
      stripe
      header-cell-class-name="science-part-table-header"
      style="width: 100%">
      <el-table-column
        v-for="(column, index) in columns"
        :label="column.text"
        :key="column.value"
        :prop="column.value"
      >
      </el-table-column>
    </el-table>
    <div class="science-part-pagination">
      <el-button type="primary" size="small" @click="back">返回</el-button>
      <el-pagination
        background
        :page-size="queryData.rows"
        layout="prev, pager, next"
        :total="total"
        @current-change="pageChange">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  import { getToken, removeToken } from '@/util/auth'
  import { downloadService, download} from '@/util/downloadService'
  export default {
    name: "sciencePartDataReportEntrance",
    props: {
      modelId: String,
      formTime: String,
      taskInfo: Object
    },
    data() {
      return {
        query: {
          fillId: this.$route.query.fileId,
          companyName: null,
          page: 1,
          rows: 20
        },
        total: 0,
        queryParams: {
          formTime: null,
          companyName: null
        },
        columns: [],
        formData: null,
        tableData: [],
        formDataInfo: null
      }
    },
    mounted() {
      this.init()
    },
    methods: {
      init() {
        this.getData()
        this.getColumns()
          .then(data => {
            this.formData = data
            this.treeMerge(data.inputFormats, data.targets)
            const targetList = this.formData.targets
            targetList.sort((a, b) => {
              return a.orderNumber - b.orderNumber
            })
            this.formatColumns(targetList)
          }, err => {
            console.dir(err)
          })
        this.$nextTick(() => {
          let formTime = this.formTime
          if (formTime.length === 4) {
            this.queryParams.formTime = new Date(formTime)
          } else {
            this.queryParams.formTime = new Date(formTime.slice(0, 4) + '-' + formTime.slice(4, 6))
          }
        })
      },
      importExcel() {
        downloadService({
          method: 'get',
          url: `springcloud-enterprise/data/garden/getScienceHeaderExcel?modelid=${this.modelId}&taskbatch=${this.taskInfo.taskBatch}`,
          responseType: 'blob',
          headers: {
            token: getToken()
          }
        }).then(response => {
          download(response, '下载模板')
            .then(() => {
              this.$message.success('下载成功')
            })
        }).catch((error) => {

        })
      },
      exportExcel() {
        downloadService({
          method: 'get',
          url: `springcloud-enterprise/data/garden/getScienceExcel?modelid=${this.modelId}&taskbatch=${this.taskInfo.taskBatch}`,
          responseType: 'blob',
          headers: {
            token: getToken()
          }
        }).then(response => {
          download(response, '导出模板')
            .then(() => {
              this.$message.success('导出成功')
            })
        }).catch((error) => {

        })
      },
      formatTableData(data) {
        const arr = []
        const rows = data.rows
        for (const key in rows) {
          let obj = {}
          for (const item of rows[key]) {
            obj[item.targetId + item.formId] = item.data ? item.data : ''
          }
          arr.push(obj)
        }
        this.tableData = arr
      },
      formatColumns(targetList) {
        return new Promise(resolve => {
          for (const target of targetList) {
            for (const formRow of target.inputFormatModel) {
              for (const form of formRow) {
                let text, value = form.targetId + form.formId
                if (form.formName) {
                  text = form.formName
                } else {
                  text = target.text
                }
                this.columns.push({
                  text,
                  value
                })
              }
            }
            if (target.hasOwnProperty('children') && target.children.length > 0) {
              this.formatColumns(target.children)
            }
          }
          resolve()
        })
      },
      treeMerge(formModels, tree) {
        // 递归选中的指标树节点和获取到的填报格式数组比对，寻找对应的填报格式，并挂载到指标节点中
        for (const target of tree) {
          if (!target.hasOwnProperty('inputFormatModel')) {
            this.$set(target, 'inputFormatModel', [[]])
          } else {
            target.inputFormatModel = [[]]
          }
          for (const item of formModels) {
            if (target.id === item.targetId) {
              target.inputFormatModel[0].push(item)
            }
          }
          // 指标按行号升序
          for (const list of target.inputFormatModel) {
            list.sort((a, b) => {
              return a['orderNumber'] - b['orderNumber']
            })
          }
          if (target.hasOwnProperty('children') && target.children.length > 0) {
            this.treeMerge(formModels, target.children)
          }
        }
      },
      queryData() {
        this.query = Object.assign(this.query, this.queryParams)
        this.query.page = 1
        const formTime = this.query.formTime
        if (formTime) {
          const date = new Date(this.query.formTime)
          const year = date.getFullYear()
          let month = date.getMonth()
          month = month > 10 ? month : '0' + month
          this.query.formTime = year + month
        }
        if (this.query.companyName === '') {
          this.query.companyName = null
        }
        this.getData()
      },
      getColumns() {
        return new Promise((resolve, reject) => {
          const _this = this
          this.api.get({
            url: `enterpriseGetScientTabHeader`,
            data: {
              fillId: _this.$route.query.fileId
            },
            callback(res) {
              if (res.code === "0000") {
                resolve(res.data)
              } else {
                _this.$message.error(res.result)
              }
            }
          })
        })
      },
      upload(event) {
        const _this = this
        const file = event.target.files[0]
        if (file.name.substr(file.name.lastIndexOf('.')) !== '.xlsx') {
          this.$message.warning('文件格式错误,仅支持xlsx格式文件')
          return
        }
        let form = new FormData()
        form.append('file', file)
        form.append('formTime', this.formTime)
        form.append('modelId', this.modelId)
        form.append('fillId', this.$route.query.fileId)
        this.api.post({
          url: `enterpriseImportData`,
          data: form,
          headerType: 'multipart/form-data',
          callback(res) {
            if (res.code === "0000") {
              _this.getData()
              _this.$message.success('导入成功')
            } else {
              _this.$message.error(res.result)
            }
          }
        })
      },
      getData() {
        return new Promise((resolve, reject) => {
          const _this = this
          this.api.post({
            url: `enterpriseGetImportData`,
            data: this.query,
            callback(res) {
              if (res.code === "0000") {
                _this.formatTableData(res.data)
                resolve(res.data)
              } else {
                _this.$message.error(res.result)
                reject(res.result)
              }
            }
          })
        })
      },
      pageChange(page) {
        this.queryData.page = page
        this.getData()
      },
      back() {
        this.$router.push({
          path: '/servicemarket/product/productService/dataReport'
        })
      },
      uploadDone(res, file, fileList) {
        this.tempFileUrl = res.data
      },
      beforeUpload(file) {
        // // 判断上传文件类型
        const isAccept = this.acceptType.indexOf(file.name.substring(file.name.lastIndexOf('.') + 1).toLowerCase())
        if (isAccept < 0) {
          this.$message.warning(`只支持${this.acceptType.join(',')}文件类型`)
          return false
        }
        if (file.size / 1024 / 1024 > 20) {
          this.$message.warning('文件不能大于20M')
          return false
        }
      },
      handleRemove(file, fileList) {
      },
      handleError(e) {
        throw new Error(e)
      },
      handleExceed(files, fileList) {
        this.$message.warning(`最多只能上传1个附件`)
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "~@/css/r-common";
  @import "~@/css/common";

  .science-part {
    min-height: 400px;
    background-color: #fff;

    .search-row {
      background-color: #f5f5f5;
      padding: 10px;

      .search-row-cell {
        @include flex($h: flex-start);
        flex-wrap: wrap;
      }
    }

    .science-part-pagination {
      padding: 20px;
      margin: 10px auto;
      @include flex($h: space-between);
    }

    .el-pagination {
      margin-top: 0;
    }

    .upload-file {
      width: 56px;
      height: 34px;
      opacity: 0;
      position: absolute;
      top: 0;
      left: 0;
      z-index: 1;
      cursor: pointer;
    }

    .search-row {
      @include flex($h: space-between);
      flex-wrap: wrap;
    }
  }
</style>
<style lang="scss">
  .science-part {
    .science-part-table-header {
      background-color: #00a041;
      color: #333;
    }
  }

  .isMobile {
    .en-card {
      width: 50%;
      padding: 4px;
    }

    .search-row {
      padding: 0 10px;
    }

    .search-row-cell {
      margin-top: 10px;

      .search-row-cell-form {
        width: 100%;
        margin-top: 10px;

        &:first-of-type {
          margin-top: 0;
        }
      }
    }
  }
</style>

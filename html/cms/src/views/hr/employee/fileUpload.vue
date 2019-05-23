<template>
  <el-dialog
    :title="title"
    :visible.sync="dialogVisible"
    :modal-append-to-body="false"
    :close-on-click-modal="false"
    :before-close="handleClose"
    class="dialog-import">
    <div>
      <el-upload
        ref="upload"
        :action="importUrl"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :on-exceed="onExceed"
        :before-upload="beforeUpload"
        :auto-upload="false"
        :on-success="uploadSuccess"
        :on-error="uploadError"
        :limit="limit"
        :multiple="true"
        :on-change="fileChange"
        :file-list="fileList"
        class="upload-demo">
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传</el-button>
      </el-upload>
      <div v-if="templatePath!=''" class="download-template">
        <a :href="templatePath" class="btn-download">下载模板</a>
      </div>
      <div :class="{'import-failure': importFlag === 2, 'hide-dialog': importFlag !== 2}">
        <div class="failure-reason">
          <h4><i class="el-icon-warning"/>&nbsp;文件导入失败,原因</h4>
          <ul>
            <li v-for="(error,index) in errorResults" :key="index">{{ error }}</li>
          </ul>
        </div>
      </div>
    </div>
  </el-dialog>
</template>

<script>
import {
  postApi2
} from '@/api/hr/util'
export default {
  name: 'FileUpload',
  props: {
    importUrl: {
      type: String,
      required: true
    },
    title: {
      type: String,
      default: ''
    },
    acceptType: {
      type: String,
      default: 'xls,xlsx'
    },
    limit: {
      type: Number,
      default: 1
    },
    dialogVisible: {
      type: Boolean,
      default: false
    },
    templatePath: {
      type: String,
      default: ''
    }
  },
  data() {
    return {
      errorResults: [],
      importFlag: 1,
      fileList: []
    }
  },
  methods: {
    handleClose() {
      this.importFlag = 1
      this.errorResults = []
      this.fileList = []
      this.$emit('closeDialog')
    },
    onExceed() {
      this.$message.error(`最多只能上传${this.limit}个文件!`)
    },
    submitUpload() {
      console.log('beforUpload')
      if (this.fileList.length === 0) {
        this.$message.error(`请至少上传1个文件!`)
        return
      }
      const formData = new FormData()
      this.fileList.forEach(file => {
        formData.append('file', file.raw, file.raw.name)
      })
      postApi2(this.importUrl, formData).then(res => {
        this.uploadSuccess(res.data)
      }).catch(err => {
        console.log(err)
        this.uploadError(err)
      })
    },
    handlePreview(file) {
      const link = document.createElement('a')
      link.setAttribute('href', file.url)
      link.setAttribute('download', file.name)
      link.style.visibility = 'hidden'
      document.body.appendChild(link)
      link.click()
      document.body.removeChild(link)
    },
    handleRemove(file, fileList) {
      this.fileList = fileList
    },
    fileChange(file, fileList) {
      console.log('fileChange')
      if (file.size > 1024 * 1024 * 6) {
        this.$message.error('导入文件不能超过6M')
        fileList.pop()
      }
      const fileExtend = file.name.substring(file.name.lastIndexOf('.') + 1).toLowerCase()
      if (this.acceptType.indexOf(fileExtend) === -1) {
        this.$message.error('文件格式错误')
        fileList.pop()
      }
      const existFile = fileList.slice(0, fileList.length - 1).find(f => f.name === file.name)
      if (existFile) {
        this.$message.error('当前文件已经存在!')
        fileList.pop()
      }
      this.fileList = fileList
    },
    beforeUpload(file) {

    },
    uploadSuccess(response, file, fileList) {
      console.log('uploadSuccess')
      if (response.code === '0000') {
        if (response.data === '导入成功') {
          this.importFlag = 3
          this.$message.info(response.data)
          this.handleClose()
          this.$emit('uploadSuccess')
        } else {
          this.importFlag = 2
          if (response.data) {
            this.errorResults = response.data.split(';')
          } else {
            this.errorResults.push(response.result)
          }
        }
      } else {
        this.$message.error(response.result)
      }
    },
    uploadError(err, file, fileList) {
      console.log(err)
      this.$message.error('文件导入失败')
    }
  }

}
</script>

<style scoped>
  .hide-dialog {
    display: none;
  }

  .download-template {
    margin-top: 20px;
  }
  .download-template a:hover{
    color:red
  }
  .failure-reason h4{
    margin: 10px 0;
    line-height:20px;
    font-size:14px;
    color:red;

  }
  .failure-reason ul{
    padding:0 0;
    margin: 0 0;
  }

  .failure-reason ul li {
    color: red;
    line-height:20px;
  }

</style>

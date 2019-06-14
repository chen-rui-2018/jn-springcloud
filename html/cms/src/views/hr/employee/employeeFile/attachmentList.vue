<template>

  <div>

    <el-form :model="listQuery" :inline="true" class="info-form">

      <div class="attach-head">
        <el-button class="filter-item" type="primary" round @click="back">返回
        </el-button>

        <span class="attach-head-span">附件属性</span>
        <hr>
      </div>

      <h3>常规</h3>
      <hr>
      <el-form-item label="档号:" label-width="54px">
        <el-input
          v-model="listQuery.fileId"
          disabled
          maxlength="20"
          placeholder=""
          class="filter-item"
          clearable
          style="width:150px;"/>
      </el-form-item>
      <el-form-item label="题名:" label-width="54px">
        <el-input
          v-model="listQuery.titleName"
          disabled
          maxlength="20"
          placeholder=""
          class="filter-item"
          clearable
          style="width:150px;"/>
      </el-form-item>

    </el-form>
    <h3>附件列表</h3>
    <hr>
    <el-button
      type="primary"
      style="width:80px;float:right;margin-right:10px;margin-bottom:10px;border-radius: 20px; "
      @click="showUploadForm">上传
    </el-button>
    <el-table
      v-loading="listLoading"
      ref="multipleTable"
      :data="attachmentList"
      border
      fit
      highlight-current-row
      style="width: 100%;">
      <el-table-column type="index" width="60" label="序号" align="center"/>
      <el-table-column label="文件名称" align="center" prop="fileName"/>
      <el-table-column label="类型" align="center" prop="fileType"/>
      <el-table-column label="大小" align="center" prop="fileSize"/>
      <el-table-column label="创建人" align="center" prop="founder"/>
      <el-table-column label="时间" align="center" prop="createTime"/>
      <el-table-column label="操作" align="center" min-width="100" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" @click="downloadAttachment(scope.row)">下载</el-button>
          <el-button type="text" @click="updateAttachment(scope.row)">编辑</el-button>
          <el-button type="text" @click="deleteAttachment(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      v-show="total>0"
      :current-page="listQuery.page"
      :page-sizes="[5,10,20,30, 50]"
      :page-size="listQuery.rows"
      :total="total"
      class="tablePagination"
      background
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"/>

    <el-dialog
      :visible.sync="dialogImportVisible"
      :modal-append-to-body="false"
      :close-on-click-modal="false"
      :before-close="handleClose"
      title="员工档案附件上传"
      class="dialog-import">
      <div>
        <el-upload
          ref="upload"
          :action="importUrl"
          :headers="importHeaders"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :on-change="fileChange"
          :before-upload="beforeUpload"
          :auto-upload="false"
          :on-success="uploadSuccess"
          :multiple="true"
          :file-list="fileList"
          class="upload-demo">
          <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
        </el-upload>
      </div>
    </el-dialog>

    <template v-if="attachFormVisible">
      <el-dialog :visible.sync="attachFormVisible" title="员工档案附件" width="450px">
        <el-form
          ref="attachForm"
          :rules="rules"
          :model="attachForm"
          label-position="right"
          label-width="130px"
          style="max-width:400px;margin-left:20px">
          <el-form-item label="附件名称:" prop="fileName">
            <el-input
              v-model.trim="attachForm.fileName"
              maxlength="200"
              style="width: 200px"
              placeholder="请输入文件名称"
              clearable/>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button type="primary" @click="submitAttach">保存</el-button>
          <el-button @click="cancelAttach">取消</el-button>
        </div>
      </el-dialog>
    </template>

  </div>

</template>

<script>
import {
  getEmployeeFileAttachmentById, uploadAttachment, deleteAttachment, updateEmployeeFileAttachment, downloadEmployeeFileAttachment
} from '@/api/hr/employeeFile'
import { getToken } from '@/utils/auth'
import {
  isvalidName
} from '@/api/hr/util'

export default {
  data() {
    var checkName = (rule, value, callback) => {
      if (!isvalidName(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }

    return {
      importHeaders: {
        enctype: 'multipart/form-data',
        token: getToken()
      },
      importUrl: process.env.BASE_API + 'springcloud-hr/hr/employeeFile/uploadAttachment',
      fileList: [],
      dialogImportVisible: false,
      attachmentList: [],
      isDisabled: false,
      listLoading: false,
      listQuery: {
        titleName: '',
        fileId: '',
        page: 1,
        rows: 10
      },
      total: 0,
      attachFormVisible: false,
      attachForm: {
        fileName: '',
        id: ''
      },
      rules: {
        fileName: [{ required: true, message: '请输入分类名称', trigger: 'blur' }, { validator: checkName, trigger: 'blur' }]
      }

    }
  },
  mounted() {
    this.listQuery.fileId = this.$route.query.fileId
    this.listQuery.titleName = this.$route.query.titleName
    this.initList()
  },
  methods: {
    back() {
      this.$router.push('employeeFileList')
    },
    initList() {
      console.log('查询员工档案附件。。。')
      this.listLoading = true
      getEmployeeFileAttachmentById(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.attachmentList = res.data.data.fileAttachmentList.rows
          this.total = res.data.data.fileAttachmentList.total
          if (this.attachmentList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    downloadAttachment(row) {
      downloadEmployeeFileAttachment(row).then(res => {
        window.location.href = res.request.responseURL
      })
    },
    updateAttachment(row) {
      this.attachForm.id = row.id
      this.attachForm.fileName = row.fileName
      this.attachFormVisible = true
    },
    deleteAttachment(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteAttachment(row.id).then(res => {
          if (res.data.code === '0000') {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            if (this.listQuery.page > 1 && this.total % this.listQuery.rows === 1) {
              this.listQuery.page = this.listQuery.page - 1
            }
            this.initList()
          } else {
            this.$message.error(res.data.result)
          }
        })
      })
    },
    showUploadForm() {
      this.dialogImportVisible = true
    },
    handleClose() {
      this.fileList = []
      this.dialogImportVisible = false
    },
    submitUpload() {
      console.log('submitUpload')
      if (this.fileList.length === 0) {
        this.$message.error(`请至少上传1个文件!`)
        return
      }
      const fd = new FormData()
      fd.append('fileId', this.listQuery.fileId)
      this.fileList.forEach(e => {
        fd.append('file', e.raw, e.raw.name)
      })
      uploadAttachment(fd).then((res) => {
        debugger
        if (res.data.code === '0000') {
          this.$message.success('文件上传成功')
          this.dialogImportVisible = false
          this.fileList = []
          this.initList()
        } else {
          this.$message.error(`文件上传失败!`)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error(`文件上传失败!`)
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
      const existFile = fileList.slice(0, fileList.length - 1).find(f => f.name === file.name)
      if (existFile) {
        this.$message.error('当前文件已经存在!')
        fileList.pop()
      }
      this.fileList = fileList
    },
    beforeUpload(file) {

    },
    uploadSuccess() {
      console.log('上传成功回调')
    },
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    },
    cancelAttach() {
      this.attachFormVisible = false
    },
    submitAttach() {
      this.$refs['attachForm'].validate(valid => {
        if (valid) {
          updateEmployeeFileAttachment(this.attachForm).then(
            res => {
              if (res.data.code === '0000') {
                this.$message.success('保存成功')
              } else {
                this.$message.error(res.data.result)
              }
              this.$refs['attachForm'].resetFields()
              this.attachFormVisible = false
              this.initList()
            }
          )
        }
      })
    }
  }

}
</script>

<style scoped>
  .attach-head {

  }

  .attach-head-span {
    display: inline-block;
    margin-left: 40%;
  }
</style>

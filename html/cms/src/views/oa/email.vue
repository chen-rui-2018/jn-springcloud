<template>
  <div v-loading="listLoading" class="email">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-radio-group v-model="listQuery.sendStatus">
        <el-radio-button label="">全部</el-radio-button>
        <el-radio-button label= "1">未发送</el-radio-button>
        <el-radio-button label="2">发送成功</el-radio-button>
        <el-radio-button label="3">发送失败</el-radio-button>
      </el-radio-group>
      <el-form-item label="邮件标题:" style="margin-left:50px;">
        <el-input v-model="listQuery.title" placeholder="邮件名称" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>

      <el-form-item label="发起人:">
        <el-input v-model="listQuery.creator" placeholder="发起人" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>

      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="emailList" border fit highlight-current-row style="width: 100%;">
      <el-table-column label="序列" type="index" align="center" width="60"/>
      <el-table-column label="邮件标题" prop="title" align="center">
        <template slot-scope="scope">
          <el-button type="text" @click="handleLook(scope.row)">{{ scope.row.title }}</el-button>
        </template>
      </el-table-column>
      <el-table-column :show-overflow-tooltip="true" label="接收人列表" prop="userNames" align="center" />
      <el-table-column label="发起人" prop="creator" align="center" />
      <el-table-column label="发起时间" prop="createdTime" align="center" min-width="120" />
      <el-table-column label="是否定时发送" prop="isDelay" align="center" >
        <template slot-scope="scope">
          <span :class="scope.row.isDelay==1 ? 'text-green' : 'text-red'">{{ scope.row.isDelay==1?'是':'否' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="邮件预览" prop="email" align="center">
        <template slot-scope="scope">
          <el-button type="text" @click="handlePreview(scope.row)">预览</el-button>
        </template>
      </el-table-column>
      <el-table-column label="状态" prop="sendStatus" align="center" >
        <template slot-scope="scope">
          <span v-if="scope.row.sendStatus==='2'" class="text-green">发送成功</span>
          <span v-if="scope.row.sendStatus==='1'" class="text-green" >未发送</span>
          <span v-if="scope.row.sendStatus==='3'" class="text-red">发送失败</span>
        </template>
      </el-table-column>
      <el-table-column label="发送时间" prop="sendTime" align="center" min-width="120" />
      <el-table-column fit label="操作" align="center" min-width="150" >
        <template slot-scope="scope">
          <el-button v-if="scope.row.sendStatus==='1'" type="text" @click="handleSend(scope.row)">一键发送</el-button>
          <el-button v-if="scope.row.sendStatus==='3'" type="text" @click="handleSend(scope.row)">再次发送</el-button>
          <el-button type="text" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button type="text" @click="handleDelete(scope.row)" >删除</el-button>
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
      style="margin-top:15px;"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"/>
    <!-- 预览的弹框 -->
    <template v-if="deDialogVisible">
      <el-dialog :visible.sync="deDialogVisible" title="邮件预览" width="800px">
        <strong>{{ emailName }}</strong>
        <div class="userNames">收件人 :{{ userNames }}</div>
        <div class="editor-container">
          <UE ref="ue" :default-msg="defaultMsg" :config="config"/>
        </div>
        <fieldset class="fieldest">
          <legend>附件</legend>
          <a v-show="downloadUrl" href="javascript:;" download="" @click="download"> <i class="fa fa-file-text-o"/> {{ fileName }}</a>
        </fieldset>
        <span slot="footer" class="dialog-footer">
          <el-button @click="deDialogVisible = false">关闭</el-button>
        </span>
      </el-dialog>
    </template>

  </div>
</template>

<script>
import {
  api, paramApi
} from '@/api/axios'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      downloadUrl: '',
      fileName: '',
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 200
      },
      userNames: '',
      emailName: '',
      deDialogVisible: false,
      listLoading: false,
      listQuery: {
        sendStatus: '',
        title: '',
        creator: '',
        page: 1,
        rows: 10
      },
      total: 0,
      emailList: []
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    download() {
      api(`${this.GLOBAL.oaUrl}oa/common/downLoadAttachment?title=${this.fileName}&url=${this.downloadUrl}`, '', 'get').then(res => {
        window.location.href = res.request.responseURL
      })
    },
    handleSend(row) {
      paramApi(`${this.GLOBAL.oaUrl}oa/email/sendEmailManual`, row.id, 'emailId').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.$message({
            message: '发送成功',
            type: 'success'
          })
          this.initList()
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 点击编辑按钮
    handleUpdate(row) {
      this.$router.push({ name: 'editemail', query: { title: '一键Email编辑', emailId: row.id }})
    },
    // 点击右键标题查看
    handleLook(row) {
      this.$router.push({ name: 'lookemail', query: { title: '一键Email详情', emailId: row.id }})
    },
    // 删除
    handleDelete(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi(`${this.GLOBAL.oaUrl}oa/email/deleteBatch`, row.id, 'emailIds').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.listQuery.rows === 1) {
                this.listQuery.page = this.listQuery.page - 1
              }
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {
        })
    },
    //   点击新增
    handleCreate() {
      this.$router.push({ name: 'addemail', query: { title: '一键Email新增', workOrderNum: 'GGGL' }})
    },
    //   点击预览邮件内容
    handlePreview(row) {
      this.defaultMsg = ''
      this.emailName = ''
      this.userNames = ''
      this.fileName = ''
      this.downloadUrl = ''
      this.deDialogVisible = true
      this.defaultMsg = row.emailContent
      this.emailName = row.title
      this.userNames = row.userNames
      if (row.attachment) {
        JSON.parse(row.attachment).forEach(val => {
          this.fileName = val.title
          this.downloadUrl = val.url
        })
      }
      // this.fileName
    },
    // 初始化表格数据
    initList() {
      this.listLoading = true
      api(`${this.GLOBAL.oaUrl}oa/email/list?creator=${this.listQuery.creator}&page=${this.listQuery.page}&rows=${this.listQuery.rows}&sendStatus=${this.listQuery.sendStatus}&title=${this.listQuery.title}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.emailList = res.data.data.rows
          this.total = res.data.data.total
          if (this.emailList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 分页数更改
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    },
    // 查询数据
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    }
  }
}
</script>

<style lang="scss">
.email{
.userNames{
  padding: 15px  0px;
}
strong{
     color: black;
    font-size: 22px;
    font-weight: 800;
}
.fieldest{
    border: 1px solid #e5e5e5;
    margin-top:15px;
        padding: 10px 15px 15px;
}
.el-dialog{
      height: 550px;
      overflow: auto;
      margin-top: 8vh !important;
    }
  .el-dialog__body{
    padding: 0px 30px 20px !important;
  }
}
</style>

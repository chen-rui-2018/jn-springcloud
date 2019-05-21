<template>
  <div v-loading="listLoading" class="assessmentList">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-button class="filter-item" type="primary" icon="el-icon-plus" @click="handleCreate">发起考核</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="assessmanagementList" border fit highlight-current-row style="width: 100%;height:100%;margin-top: 10px;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column :show-overflow-tooltip="true" label="考核名称" align="center" prop="assessmentName" />
      <el-table-column label="考核开始时间" align="center" prop="assessmentStartTime"/>
      <el-table-column label="考核结束时间" align="center" prop="assessmentEndTime"/>
      <el-table-column :show-overflow-tooltip="true"  label="考核对象" align="center" prop="assessmentObject"/>
      <el-table-column label="考核人" align="center" prop="assessmentPeople" />
      <el-table-column label="待归档人数" width="120" align="center" prop="archiveNumber"/>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span v-if="scope.row.status==0">未开始</span>
          <span v-if="scope.row.status==1">考核中</span>
          <span v-if="scope.row.status==2">已结束</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" @click="viewassessment(scope.row)">查看</el-button>
          <!--<el-button type="text" @click="editassessment(scope.row)">再次发起</el-button>-->
          <el-button type="text" @click="delayassessment(scope.row)">延期</el-button>
          <!--考核中不能删除-->
          <el-button
            v-if="scope.row.status==='3'"
            type="text"
            class="operation"
            @click="delassessment(scope.row)">删除
          </el-button>
          <el-button type="text" @click="downassessment(scope.row)">导出</el-button>
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
      @current-change="handleCurrentChange" />
    <!-- 延期弹出框 -->
    <template v-if="delayDialogFormVisible">
      <el-dialog :visible.sync="delayDialogFormVisible" :title="dialogTitle" width="650px">
        <el-form label-position="right" label-width="80px">
          <el-form-item label="延期至:">
            <el-date-picker type="datetime" v-model="delayTime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="" style="width: 100%;" @change="getDelayTime" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button type="primary" @click="delayassessmentsubmit">保存</el-button>
          <el-button @click="handleCancle">取消</el-button>
        </div>
      </el-dialog>
    </template>
    <!-- 延期弹出框 -->
  </div>
</template>
<script>
import {
  api, paramApi, exportExcelByObj
} from '@/api/hr/common'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      dialogFormVisible: false,
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      delayTime:'',
      assessmanagementList: [],
      delayLow:{},
      delayDialogFormVisible: false,
      total: 0,
      listLoading: false,
      listQuery: {
        page: 1,
        rows: 10
      },
      code: {
        groupCode: 'platform_type',
        moduleCode: 'springcloud-hr',
        parentGroupCode: 'assess'
      }
    }
  },
  watch: {
  },
  mounted() {
    this.initList()
  },
  methods: {

    getDelayTime(val) {
      this.delayTime = val
    },
    handlePreview(row) {
      this.dialogFormVisible = true
      this.defaultMsg = row.noticeContent
    },
    editassessment() {

    },
    downassessment(row) {
      exportExcelByObj('hr/AssessmentManagement/exportAssessment',row).then(res => {
        window.location.href = res.request.responseURL
      })
    },
    getEndtime() {},
    // 取消
    handleCancle() {
      this.delayDialogFormVisible = false
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('assessment-list')
        }
      })
    },
    // 删除数据
    delassessment(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const delRow = {
          id:row.id,
          assessmentName:row.assessmentName,
          assessmentStartTime:row.assessmentStartTime,
          assessmentEndTime:row.assessmentEndTime,
          assessmentObject:row.assessmentObject,
          assessmentPeople:row.assessmentPeople,
          status:row.status,
          templateId:row.templateId,
          templateName:row.templateName,
          jobNumber:row.jobNumber,
        }
          api('hr/AssessmentManagement/deleteAssessmentRecord', delRow).then(res => {
            if (res.data.code === '0000') {
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
    // 查看
    viewassessment(row) {
      this.$router.push({ name: 'assessment-detail', query: { title: '查看详情',row: row}})
    },
    //延期
    delayassessment(row){
      this.dialogTitle = '考核延期'
      this.delayDialogFormVisible = true
      this.delayLow = row
    },
    delayassessmentsubmit() {
      let obj = {
        assessmentId: this.delayLow.assessmentId,
        assessmentEndTime:this.delayTime
      }
      if (new Date(this.delayTime.replace(/-/g, '\/')) < new Date(this.delayLow.assessmentStartTime.replace(/-/g, '\/'))) {
        alert('考核开始时间为：'+this.delayLow.assessmentStartTime+'延期时间必须大于生效时间,请重新选择')
        this.isDisabled = false
        return false
      }
      api('hr/AssessmentManagement/assessmentExtension', obj).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.delayDialogFormVisible = false
          this.initList()
        } else {
          this.$message.error(res.data.result)
          this.delayDialogFormVisible = false
          this.initList()
        }
      })
    },
    // 点击新增按钮的时候
    handleCreate() {
      this.$router.push({ name: 'assessment-add', query: { title: '发起考核'}})
    },
    // 表格分页功能
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    // 表格分页功能
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    },
    // 查询数据
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 初始化
    initList() {
      this.listLoading = true
      api('hr/AssessmentManagement/paginationInquireAssessManage',this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.assessmanagementList = res.data.data.rows
          console.log(this.assessmanagementList)
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    }
  }
}
</script>

<style lang="scss"  scoped>
.setCursor{
  cursor: auto;
}
    .el-pagination{
      margin-top:15px;
    }

</style>
<style lang="scss">
.noticeContent{
.el-dialog{
      height: 550px;
      overflow: auto;
    }
}
</style>

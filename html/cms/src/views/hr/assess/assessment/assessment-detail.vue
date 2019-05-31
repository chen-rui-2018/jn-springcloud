<template>
  <div v-loading="listLoading" class="assessmentList">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-button type="primary" @click="goBack($route)" >返回</el-button>
      <el-button type="primary" @click="finishAssess()" >结束考核</el-button>

    </el-form>
    <!-- 表格 -->
    <el-table :data="assessmentDetailList" border fit highlight-current-row style="width: 100%;height:100%; margin-top: 10px;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column label="考核名称" align="center" prop="assessmentName" />
      <el-table-column label="部门" align="center" prop="departmentName" />
      <el-table-column label="考核开始时间" align="center" prop="assessmentStartTime"/>
      <el-table-column label="考核结束时间" align="center" prop="assessmentEndTime"/>
      <el-table-column label="考核对象" align="center" prop="assessmentObject"/>
      <el-table-column label="考核状态" align="center" prop="status">
        <template slot-scope="scope">
          <!--<span>{{ scope.row.recordStatus==1?'考核中':'已结束' }}</span>-->
          <span v-if="scope.row.status==1">未开始</span>
          <span v-if="scope.row.status==2">待归档</span>
          <span v-if="scope.row.status==3">已结束</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.status=='1' && (new Date(scope.row.assessmentEndTime.replace(/-/g, '\/')) > new Date())"
            type="text"
            class="operation"
            @click="beginassessment(scope.row)">开始考核
          </el-button>
          <el-button type="text" @click="viewassessobj(scope.row)">查看详情</el-button>
          <el-button
            v-if="scope.row.status=='2'"
            type="text"
            class="operation"
            @click="endAarchive(scope.row)">归档生效
          </el-button>
          <el-button type="text" @click="delassessmentobj(scope.row)">删除</el-button>
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
  </div>
</template>

<script>
import {
  api
} from '@/api/hr/common'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      finishAssessmentVisible: false,
      dialogFormVisible: false,
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      assessmentDetailList: [],
      total: 0,
      listLoading: false,
      listQuery: {
        page: 1,
        rows: 10
      },
      prePageRow: {},
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
    finishAssess() {
      api('hr/AssessmentManagement/assessmentEnd', this.prePageRow).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: res.data.data,
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 删除数据
    delassessmentobj(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          api('hr/AssessmentManagement/deleteAppraisedPersonRecord', row).then(res => {
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
    // 开始考核
    beginassessment(row) {
      this.$router.push({ name: 'assessmentsub-add', query: { title: '开始考核', row: row, prePageRow: this.prePageRow }})
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
    viewassessobj(row) {
      this.$router.push({ name: 'assessmentsub-detail', query: { title: '查看考核详情', row: row }})
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
      this.prePageRow = this.$route.query.row
      const param = this.prePageRow
      param.rows = this.listQuery.rows
      param.page = this.listQuery.page
      this.listLoading = false
      this.assessmentDetailList = []
      api('hr/AssessmentManagement/viewPageInfo', param).then(res => {
        if (res.data.code === '0000') {
          this.assessmentDetailList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 归档生效
    endAarchive(row) {
      // api('hr/AssessmentManagement/updateAssessment', row).then(res => {
      api('hr/AssessmentManagement/finishAndArchive', row).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '归档生效成功',
            type: 'success'
          })
          this.initList()
        } else {
          this.$message.error(res.data.result)
        }
        this.isDisabled = false
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

<template>
  <div v-loading="listLoading" class="train-record">
    <!-- 表单 -->
    <!-- <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="课程名称:">
        <el-input
          v-model="listQuery.courseTitle"
          maxlength="20"
          placeholder="请输入课程名称"
          class="filter-item"
          clearable
        />
      </el-form-item>
      <el-form-item label="培训时间:" style="margin:0px 30px;">
        <el-date-picker v-model="listQuery.trainStartTime" type="datetime" placeholder="请选择开始时间" />
        至
        <el-date-picker v-model="listQuery.trainEndTime" type="datetime" placeholder="请选择结束时间" />
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-upload" @click="exportText">导出</el-button>
    </el-form> -->
    <el-row style="margin:20px auto;"><el-button class="filter-item" type="primary" icon="el-icon-upload" @click="exportText">导出</el-button></el-row>
    <!-- 表格 -->
    <el-table :data="courseList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column label="部门" align="center" prop="trainerDepartment"/>
      <el-table-column label="姓名" align="center" prop="trainerName"/>
      <el-table-column label="课程名称" align="center" prop="courseTitle"/>
      <el-table-column label="培训开始时间" min-width="180" align="center" prop="trainStartTime"/>
      <el-table-column label="培训结束时间" min-width="180" align="center" prop="trainEndTime"/>
      <el-table-column label="培训老师" align="center" prop="trainTeacher"/>
      <el-table-column label="发布人" align="center" prop="modifierAccount"/>
      <el-table-column label="发布时间" align="center" prop="modifiedTimeStr"/>
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
      @current-change="handleCurrentChange" />
    <!-- 返回 -->
    <el-row type="flex" justify="center" style="margin-top:20px;">
      <el-button type="primary" @click="goBack($route)">返回</el-button>
    </el-row>
  </div>
</template>

<script>
import store from '@/store'
import {
  api, paramApi, exportExcel
} from '@/api/hr/train'
export default {
  data() {
    return {
      listLoading: false,
      listQuery: {
        courseTitle: '',
        trainStartTime: '',
        trainEndTime: '',
        page: 1,
        rows: 10
      },
      courseList: [],
      total: 1,
    }
  },
  created() {
      this.init()
  },
  methods: {
    //初始化
    init() {
      this.listLoading = true
      this.listQuery['id'] = this.$route.query.id
      api('hr/train/list/managemenRecordtList', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.courseList = res.data.data.rows
          this.total = res.data.data.total
          if (this.courseList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.init()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 表格分页功能
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.init()
    },
    // 导出
    exportText() {
      exportExcel(this.listQuery).then(res => {
        window.location.href = res.request.responseURL
      })
    },
    // 返回
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          const latestView = visitedViews.slice(-1)[0]
          if (latestView) {
            this.$router.push('train-list')
          } else {
            this.$router.push('/')
          }
        }
      })
    },
    isActive(route) {
      return route.path === this.$route.path
    }
  }
}
</script>

<style lang="scss"  scoped>
.setCursor {
  cursor: pointer;
}
.el-pagination {
  margin-top: 15px;
}
</style>
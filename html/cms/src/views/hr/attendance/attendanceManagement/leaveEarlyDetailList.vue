<template>

  <div>
    <el-form :model="listQuery" class="info-form">

      <el-button class="filter-item left-btn" type="primary" @click="exportExcel">导出</el-button>
      <el-button class="filter-item right-btn" type="primary" @click="cancel">返回</el-button>
    </el-form>

    <div class="cl"></div>

    <el-table v-loading="listLoading" ref="multipleTable" :data="leaveEarlyDetailList" border fit highlight-current-row
              style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center"/>
      <el-table-column label="部门" align="center" prop="department"/>
      <el-table-column label="姓名" align="center" prop="name"/>
      <el-table-column label="日期" align="center" prop="absenceDate"/>
      <el-table-column label="签退时间" align="center" prop="absenceDate"/>
    </el-table>

    <!--<el-pagination
      v-show="total>0"
      :current-page="listQuery.page"
      :page-sizes="[5,10,20,30, 50]"
      :page-size="listQuery.rows"
      :total="total"
      class="tablePagination"
      background
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"/>-->
  </div>

</template>

<script>

  import {
    leaveEarlyDetailList,exportLeaveEarlyDetailList
  } from '@/api/hr/attendance'

  export default {
    data() {
      return {
        leaveEarlyDetailList: [],
        listQuery: {
          page: 1,
          rows: 10,
          jobNumber: '',
          userId:'',
          startTime:'',
          endTime:'',
          departmentId: '',
          name: '',
          department: ''
        },
        listLoading: false,
        total: 0
      }
    },
    methods: {
      cancel() {
        this.$router.push({
          name: 'attendanceList', query: {
            jobNumber: this.listQuery.jobNumber, userId: this.listQuery.userId,
            startTime: this.listQuery.startTime, endTime: this.listQuery.endTime,
            departmentId: this.listQuery.departmentId,
            department: this.listQuery.department,
            name: this.listQuery.name
          }
        })
      },
      exportExcel() {
        exportLeaveEarlyDetailList(this.listQuery).then(res => {
          console.log("导出。。。")
          window.location.href = res.request.responseURL
        })
      },
      initList() {
        console.log('查询旷工明细。。。')
        this.listLoading = true
        leaveEarlyDetailList(this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.leaveEarlyDetailList = res.data.data
            /*this.total = res.data.data.total
            if (this.leaveEarlyDetailList.length === 0 && this.total > 0) {
              this.listQuery.page = 1
              this.initList()
            }*/
          } else {
            this.$message.error(res.data.result)
          }
          this.listLoading = false
        })
      },
      handleSizeChange(val) {
        this.listQuery.rows = val
        this.initList()
      },
      handleCurrentChange(val) {
        this.listQuery.page = val
        this.initList()
      }
    },
    mounted() {
      this.listQuery.jobNumber = this.$route.query.jobNumber
      this.listQuery.userId = this.$route.query.userId
      this.listQuery.startTime = this.$route.query.startTime
      this.listQuery.endTime = this.$route.query.endTime
      this.listQuery.departmentId = this.$route.query.departmentId
      this.listQuery.department = this.$route.query.department
      this.listQuery.name = this.$route.query.name
      this.initList()

    }
  }
</script>

<style scoped>
  .left-btn {
    float: left;
    margin-bottom: 20px;
  }

  .right-btn {
    float: right;
    margin-bottom: 20px;
  }
  .cl{
    clear:both
  }
</style>


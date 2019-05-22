<template>

  <div class="scheduList">
    <el-form :model="listQuery" class="info-form" :inline="true">
      <el-form-item label="日期:" lable-position="right" label-width="80px">
        <el-date-picker
          v-model="listQuery.startDate"
          type="month"
          placeholder="选择开始日期："
          format="yyyyMM"
          value-format="yyyyMM"
          style="width: 200px" clearable>
        </el-date-picker>
        至
        <el-date-picker
          v-model="listQuery.endDate"
          type="month"
          placeholder="选择结束日期："
          format="yyyyMM"
          value-format="yyyyMM"
          style="width: 200px" clearable>
        </el-date-picker>

        <el-button class="filter-item" type="primary" @click="importExcel" style="margin-left:30px;">导入</el-button>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      </el-form-item>

    </el-form>


    <el-table v-loading="listLoading" ref="multipleTable" :data="scheduList" border fit highlight-current-row
              style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center"/>
      <el-table-column label="月度" align="center" prop="schedulMonth"/>
      <el-table-column label="操作" align="center" min-width="100" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" @click="queryDetail(scope.row)">详情</el-button>
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

    <file-upload :title="'排班导入'" :importUrl="importUrl" :dialogVisible="dialogImportVisible"
                 :templatePath="'/static/file/排班导入模板.xlsx'" :limit="1"
                 @uploadSuccess="uploadSuccess" @closeDialog="dialogImportVisible=false"/>


  </div>


</template>

<script>
  import {
    scheduDetailistPage, importScheduDetailist
  } from '@/api/hr/attendance'


  import FileUpload from '@/views/hr/employee/fileUpload'

  import moment from 'moment'

  export default {
    data() {
      return {
        scheduList: [],
        listQuery: {
          startDate: '',
          endDate: '',
          page: 1,
          rows: 10
        },
        total: 0,
        listLoading: false,
        dialogImportVisible: false,
        importUrl: process.env.BASE_API + 'springcloud-hr/hr/AttendanceManagement/importScheduDetailist'
      }
    },
    components: {
      FileUpload
    },
    methods: {
      uploadSuccess() {
        this.$message({
          message: '导入成功',
          type: 'success'
        })
        this.dialogImportVisible = false
        this.initList()
      },
      importExcel() {
        this.dialogImportVisible = true
      },
      queryDetail(row) {
        this.$router.push({name: 'scheduDetailist', query: {schedulMonth: row.schedulMonth}})
      },

      initList() {
        console.log('查询排班。。。')
        if (!this.listQuery.startDate || this.listQuery.startDate == '') {
          this.$message.error('开始时间不能为空')
          return
        }
        if (!this.listQuery.endDate || this.listQuery.endDate == '') {
          this.$message.error('结束时间不能为空')
          return
        }
        this.listLoading = true

        scheduDetailistPage(this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.scheduList = res.data.data.rows
            this.total = res.data.data.total
            if (this.scheduList.length === 0 && this.total > 0) {
              this.listQuery.page = 1
              this.initList()
            }
          } else {
            this.$message.error(res.data.result)
          }
          this.listLoading = false
        })
      },
      handleFilter() {
        this.listQuery.page = 1
        this.initList()
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
      }
    },
    mounted() {
      //初始化开始时间为6月前,结束时间为下月
      //let currDate=new Date()
      if(!this.listQuery.startDate || this.listQuery.startDate==''){
        this.listQuery.startDate=moment().subtract(6, 'months').startOf('month').format('YYYYMM')
      }
      if(!this.listQuery.endDate || this.listQuery.endDate==''){
        this.listQuery.endDate=moment().add(1, 'months').startOf('month').format('YYYYMM')
      }

      this.initList()

      this.initList()
    }
  }
</script>

<style scoped>

</style>

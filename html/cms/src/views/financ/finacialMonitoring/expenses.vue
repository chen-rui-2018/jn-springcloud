<template>
  <div class="budget">
    <el-radio-group v-model="status" style="margin-bottom: 20px;">
      <el-radio-button label="1">支出录入</el-radio-button>
      <el-radio-button label="2">支出录入历史查看</el-radio-button>
    </el-radio-group>
    <div class="queryCondition">
      <el-form :inline="true" :model="listQuery">
        <div class="queryCondition-top">
          <el-form-item label="数据月份:">
            <el-date-picker
              v-model="listQuery.startMonth"
              type="month"
              value-format="yyyyMM"
              placeholder="开始月份"/>
            至
            <el-date-picker
              v-model="listQuery.endMonth"
              type="month"
              value-format="yyyyMM"
              placeholder="结束月份"/>
          </el-form-item>
          <el-form-item label="部门:" style="margin-left:20px;">
            <el-select v-model="listQuery.departmentId" placeholder="请选择" clearable >
              <el-option v-for="item in departmentOptions" :key="item.departmentId" :label="item.departmentName" :value="item.departmentId" />
            </el-select>
          </el-form-item>
          <el-button type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
          <el-button type="primary">支出导入</el-button>
        </div>

      </el-form>
    </div>
    <!-- 表格 -->
    <el-table :data="budgetList" border fit highlight-current-row style="width: 100%;">
      <el-table-column label="序列" type="index" align="center" width="60"/>
      <el-table-column label="月份" prop="account" align="center" width="100" />
      <el-table-column label="支出金额" prop="name" align="center" width="100" />
      <el-table-column label="支出类型(打标后)" prop="departmentName" align="center"/>
      <el-table-column label="操作日期" prop="departmentName" align="center"/>
      <el-table-column label="部门" prop="departmentName" align="center"/>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      v-show="total>10"
      :current-page="listQuery.page"
      :page-sizes="[10,20,30, 50]"
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
import global from '@/api/global'
import {
  api
} from '@/api/financ'
export default {
  data() {
    return {
      // code: global.code,
      listLoading: false,
      budgetList: [],
      total: 0,
      status: '1',
      listQuery: {
        startMonth: '201901',
        orderByClause: '',
        endMonth: '201904',
        rows: 10,
        page: 1,
        departmentId: '',
        financeTypeId: ''
      },
      departmentOptions: [],
      financeTypeOptions: [],
      budgetTypeOptions: [
        { id: '0', value: '年初预算' },
        { id: '1', value: '临时预算' }

      ]
    }
  },
  mounted() {
    this.initList()
    // this.getDepartment()
  },
  methods: {
    // 初始化页面
    initList() {
      console.log(global.code)
      this.listLoading = true
    //   api(`finance/budget/selectTotalBudget?costTypeId=${this.listQuery.financeTypeId}&departmentId=${this.listQuery.departmentId}&endMonth=${this.listQuery.endMonth}&startMonth=${this.listQuery.startMonth}&orderByClause=${this.listQuery.orderByClause}&page=${this.listQuery.page}&rows=${this.listQuery.rows}`, '', 'get').then(res => {
    //     if (res.data.code === global.code) {
    //       console.log(res)
    //       // this.userList = res.data.data.rows
    //       this.total = res.data.data.total
    //       if (this.budgetList.length === 0 && this.total > 0) {
    //         this.listQuery.page = 1
    //         this.initList()
    //       }
    //     } else {
    //       this.$message.error(res.data.result)
    //     }
    //     this.listLoading = false
    //   })
    },
    // 查询数据
    handleFilter() {
      if (this.listQuery.startMonth === '' || this.listQuery.startMonth === null) {
        alert('请选择开始日期')
        return false
      } else if (this.listQuery.endMonth === '' || this.listQuery.endMonth === null) {
        alert('请选择结束日期')
        return false
      }
      console.log(this.listQuery)
      this.listQuery.page = 1
      // this.initList()
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
    handleCreate() {

    },
    // 获取部门信息
    getDepartment() {
      api('finance/documents/getDepartment', '', 'post').then(res => {
        if (res.data.code === '0000') {
          console.log(res)
          this.departmentOptions = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
//   .queryCondition{
//     //   margin-top: 20px;
//       .queryCondition-top{
//        display: flex;
//        justify-content: space-between;
//       }
//   }
</style>

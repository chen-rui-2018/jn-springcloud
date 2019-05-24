<template>
  <div v-loading="listLoading" class="autonomouslyInsuranceList">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-button class="filter-item" type="primary" icon="el-icon-plus" @click="handleCreate">添加参保方案</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="autonomouslyInsuranceList" border fit highlight-current-row style="width: 100%;height:100%;margin-top: 10px;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column :show-overflow-tooltip="true" label="方案名称" align="center" prop="schemeName" />
      <el-table-column label="参保城市" align="center" prop="insuredCityName"/>
      <el-table-column label="个人社保" align="center" prop="personalSocialSecurity"/>
      <el-table-column label="公司社保" align="center" prop="companySocialSecurity"/>
      <el-table-column label="个人公积金" align="center" prop="personalAccumulationFund" />
      <el-table-column label="公司公积金" width="120" align="center" prop="companyAccumulationFund"/>
      <el-table-column label="使用人数" width="120" align="center" prop="number"/>
      <el-table-column label="操作" align="center" min-width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" @click="updateAutonomouslyInsurance(scope.row)">修改</el-button>
          <el-button type="text" @click="delAutonomouslyInsurance(scope.row)">删除</el-button>
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
      dialogFormVisible: false,
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      delayTime: '',
      autonomouslyInsuranceList: [],
      total: 0,
      listLoading: false,
      listQuery: {
        page: 1,
        rows: 10
      },
      code: {
        groupCode: 'platform_type',
        moduleCode: 'springcloud-hr',
        parentGroupCode: 'welfareManagement'
      }
    }
  },
  watch: {
  },
  mounted() {
    this.initList()
  },
  methods: {

    // 删除数据
    delAutonomouslyInsurance(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        api('hr/SalaryWelfareManagement/deleteInsurancescheme', row).then(res => {
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
    // 修改
    updateAutonomouslyInsurance(row) {
      this.$router.push({ name: 'insurance-edit', query: { title: '修改参保方案', row: row }})
    },
    // 点击新增按钮的时候
    handleCreate() {
      this.$router.push({ name: 'insurance-add', query: { title: '新增参保方案' }})
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
      api('hr/SalaryWelfareManagement/paginationInquireInsurance', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.autonomouslyInsuranceList = res.data.data.rows
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

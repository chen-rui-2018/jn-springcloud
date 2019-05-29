<template>
  <div class="vacationList">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="姓名:">
        <el-input v-model="listQuery.name" maxlength="20" placeholder="请输入姓名" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="部门">
        <el-cascader
          ref="departRef"
          :options="departmentList"
          v-model="currentDepartmentIds"
          change-on-select
          placeholder="请选择"
          clearable
          @change="handleChangeDepartment"
        />
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table v-loading="listLoading" ref="multipleTable" :data="vacationList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="工号" align="center" prop="jobNumber" />
      <el-table-column label="部门" align="center" prop="departmentName" />
      <el-table-column label="职位" align="center" prop="jobName" />
      <el-table-column label="联系电话" align="center" prop="phone" />
      <el-table-column label="假期类型" align="center" prop="vacationType">
        <template slot-scope="scope">
          {{ scope.row.vacationType | formatVacationType }}
        </template>
      </el-table-column>
      <el-table-column label="假期(小时)" align="center" prop="vacationTime"/>
      <el-table-column label="操作" align="center" min-width="100" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" @click="update(scope.row)">编辑</el-button>
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

    <template v-if="updateFormVisible">
      <el-dialog :visible.sync="updateFormVisible" title="假期修改" width="450px">
        <el-form
          ref="addForm"
          :rules="rules"
          :model="addForm"
          label-position="right"
          label-width="130px"
          style="max-width:400px;margin-left:20px">
          <el-form-item label="假期(小时):" prop="vacationTime">
            <el-input-number v-model="addForm.vacationTime" :min="0" :max="3000" label=""/>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button type="primary" @click="submitForm">保存</el-button>
          <el-button @click="cancelForm">取消</el-button>
        </div>
      </el-dialog>
    </template>

  </div>
</template>

<script>
import {
  postapi, updateVacation
} from '@/api/hr/holidayList'
import {
  api
} from '@/api/axios'
export default {
  filters: {
    formatVacationType(val) {
      if (val === '1') {
        return '年假'
      } else if (val === '2') {
        return '补休'
      } else if (val === '3') {
        return '事假'
      } else if (val === '4') {
        return '病假'
      } else if (val === '5') {
        return '婚假'
      } else if (val === '6') {
        return '产假'
      } else if (val === '7') {
        return '陪产假'
      } else if (val === '8') {
        return '工伤假'
      } else if (val === '9') {
        return '丧假'
      } else {
        return '未知'
      }
    }
  },
  data() {
    return {
      departmentList: [],
      vacationList: [],
      listLoading: false,
      listQuery: {
        name: '',
        page: 1,
        rows: 10,
        departmentId: ''
      },
      total: 0,
      addForm: {
        id: '',
        jobNumber: '',
        vacationType: '',
        vacationTime: ''
      },
      updateFormVisible: false,
      rules: {
        vacationTime: [{ required: true, message: '请输入假期', trigger: 'blur' }]
      }
    }
  },
  mounted() {
    this.initDepartMents()
    this.initList()
  },
  methods: {
    handleChangeDepartment(value) {
      this.listQuery.departmentId = this.currentDepartmentIds[this.currentDepartmentIds.length - 1]
    },
    initDepartMents() {
      this.departmentListLoading = true
      api(`${this.GLOBAL.systemUrl}system/sysDepartment/findDepartmentAllByLevel`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.departmentList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.departmentListLoading = false
      })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    initList() {
      console.log('查询。。。')
      this.listLoading = true
      postapi('hr/holidayRule/inquireVacationManage', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.vacationList = res.data.data.rows
          this.total = res.data.data.total
          if (this.vacationList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
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
    update(row) {
      this.addForm.id = row.id
      this.addForm.jobNumber = row.jobNumber
      this.addForm.vacationType = row.vacationType
      this.addForm.vacationTime = row.vacationTime
      this.updateFormVisible = true
    },
    submitForm() {
      this.$refs['addForm'].validate(valid => {
        if (valid) {
          updateVacation(this.addForm).then(
            res => {
              if (res.data.code === '0000') {
                this.$message.success('保存成功')
              } else {
                this.$message.error(res.data.result)
              }
              this.$refs['addForm'].resetFields()
              this.updateFormVisible = false
              this.initList()
            }
          )
        }
      })
    },
    cancelForm() {
      this.addForm.id = ''
      this.addForm.jobNumber = ''
      this.addForm.vacationType = ''
      this.addForm.vacationTime = ''
      this.updateFormVisible = false
    }
  }
}
</script>

<style scoped>
  .el-pagination{
    margin-top:15px;
  }

</style>

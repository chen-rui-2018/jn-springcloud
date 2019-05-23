<template>
  <div>
    <el-form>
      <el-form-item label="模板名称：" prop="id">
        <el-input v-model="templateName" style="width: 205px;"/>
      </el-form-item>
      <el-form-item :inline="true" class="filter-bar">
        <el-button class="filter-item" type="primary" icon="el-icon-plus" @click="addRow()">添加</el-button>
        <el-button class="filter-item" type="primary" icon="el-icon-plus" @click="delData()">删除</el-button>
      </el-form-item>
      <div>
        <el-table ref="table" :data="tableData" tooltip-effect="dark" border stripe style="width: 95%" @selection-change="selectRow">
          <el-table-column type="selection" width="45" align="center"/>
          <el-table-column label="目标类别" align="center">
            <template slot-scope="scope">
              <el-input v-model="scope.row.targetCategory"/>
            </template>
          </el-table-column>
          <el-table-column label="序号">
            <template slot-scope="scope">
              <el-input v-model="scope.row.serialNumber"/>
            </template>
          </el-table-column>
          <el-table-column label="考核目标">
            <template slot-scope="scope">
              <el-input v-model="scope.row.assessmentTarget"/>
            </template>
          </el-table-column>
          <el-table-column label="分值">
            <template slot-scope="scope">
              <el-input v-model="scope.row.score"/>
            </template>
          </el-table-column>
          <el-table-column label="评分细则">
            <template slot-scope="scope">
              <el-input v-model="scope.row.scoreRubric"/>
            </template>
          </el-table-column>
          <el-table-column label="牵头考核部门">
            <template slot-scope="scope">
              <el-input v-model="scope.row.leadAssessmentDepartment"/>
            </template>
          </el-table-column>
          <el-table-column label="得分">
            <template slot-scope="scope">
              <el-input v-model="scope.row.assessmentScore"/>
            </template>
          </el-table-column>
          <el-table-column label="扣分原因">
            <template slot-scope="scope">
              <el-input v-model="scope.row.causeDeduction"/>
            </template>
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-form-item>
                <el-button type="primary" @click="submitRow(scope.row)">保存</el-button>
              </el-form-item>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-form-item style="margin-top: 10px;">
        <el-button :disabled="isDisabled" type="primary" @click="submitForm()">提交</el-button>
        <el-button type="primary" @click="goBack($route)" >取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import {
  api
} from '@/api/hr/common'
export default {
  data() {
    return {
      tableData: [{
        rowNum: 0,
        templateName: '',
        targetCategory: '',
        serialNumber: '',
        score: '',
        scoreRubric: '',
        leadAssessmentDepartment: '',
        assessmentScore: '',
        assessmentTarget: '',
        causeDeduction: ''
      }],
      templateName: '',
      isDisabled: false,
      selectlistRow: [],
      commitRows: [],
      oneRow: [],
      rowIndex: 1
    }
  },
  methods: {
    // 获取表格选中时的数据
    selectRow(val) {
      this.selectlistRow = val
    },
    // 增加行
    addRow() {
      var list = {
        rowNum: this.rowIndex,
        templateName: '',
        targetCategory: this.targetCategory,
        serialNumber: this.serialNumber,
        score: this.score,
        scoreRubric: this.scoreRubric,
        leadAssessmentDepartment: this.leadAssessmentDepartment,
        assessmentScore: this.assessmentScore,
        assessmentTarget: this.assessmentTarget,
        causeDeduction: this.causeDeduction
      }
      this.rowIndex = this.rowIndex + 1
      this.tableData.unshift(list)
    },
    // 删除方法
    // 删除选中行
    delData() {
      for (let i = 0; i < this.selectlistRow.length; i++) {
        const val = this.selectlistRow
        // 获取选中行的索引的方法
        // 遍历表格中tableData数据和选中的val数据，比较它们的rowNum,相等则输出选中行的索引
        // rowNum的作用主要是为了让每一行有一个唯一的数据，方便比较，可以根据个人的开发需求从后台传入特定的数据
        val.forEach((val, index) => {
          this.tableData.forEach((v, i) => {
            if (val.rowNum === v.rowNum) {
              this.tableData.splice(i, 1)
            }
          })
        })
      }
      // 删除完数据之后清除勾选框
      this.$refs.tableData.clearSelection()
    },
    submitForm() {
      if (this.templateName === '') {
        this.$message.error('请填写模板名称')
        return
      }
      if (this.selectlistRow.length < 1) {
        this.$message.error('至少填写并勾选一项考核指标')
        return
      }
      for (let i = 0; i < this.selectlistRow.length; i++) {
        const val = this.selectlistRow[i]
        // val.templateName=this.templateName
        delete val.rowNum
        this.commitRows.push(val)
      }
      const rows = { templateName: this.templateName, recordList: this.commitRows }
      api('hr/AssessmentManagement/addAssessmentTemplate', rows).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.commitRows = []
          this.goBack(this.$route)
        } else {
          this.$message.error(res.data.result)
          this.commitRows = []
        }
        this.isDisabled = false
      })
    },
    submitRow(row) {
      if (this.templateName === '') {
        this.$message.error('请填写模板名称')
        return
      }
      row.templateName = this.templateName
      delete row.rowNum
      this.oneRow = [{
        'targetCategory': row.targetCategory,
        'serialNumber': row.serialNumber,
        'score': row.score,
        'scoreRubric': row.scoreRubric,
        'leadAssessmentDepartment': row.leadAssessmentDepartment,
        'assessmentScore': row.assessmentScore,
        'assessmentTarget': row.assessmentTarget,
        'causeDeduction': row.causeDeduction
      }]

      const rows = { templateName: this.templateName, recordList: this.oneRow }

      api('hr/AssessmentManagement/addAssessmentTemplate', rows).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.oneRow.splice(0, 1)
        } else {
          this.$message.error(res.data.result)
          this.oneRow.splice(0, 1)
        }
        this.isDisabled = false
      })
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('assessmenttemp-list')
        }
      })
    }
  }
}

</script>
<style lang="less" scoped>
  .assessmenttempadd{
    display: flex;
  }

</style>

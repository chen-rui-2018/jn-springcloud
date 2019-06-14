<template>
  <div>
    <el-form>
      <el-form-item label="模板名称：" prop="id">
        <el-input v-model="templateName" style="width: 205px;"/>
      </el-form-item>
      <el-form-item :inline="true" class="filter-bar">
        <el-button class="filter-item" type="primary" icon="el-icon-plus" @click="addRow()">添加</el-button>
        <el-button class="filter-item" type="primary" icon="el-icon-minus" @click="delData()">删除</el-button>
      </el-form-item>
      <div>
        <el-form ref="assessmentTempListForm" :rules="model.rules" :model="model">
          <el-table ref="table" :data="model.assessmentTempList" tooltip-effect="dark" border stripe style="width: 95%" @selection-change="selectRow">
            <el-table-column type="selection" width="45" align="center"/>
            <el-table-column label="目标类别" align="center">
              <template slot-scope="scope">
                <el-form-item :prop="'assessmentTempList.' + scope.$index + '.targetCategory'" :rules="model.rules.targetCategory">
                  <el-input v-model="scope.row.targetCategory"/>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="序号">
              <template slot-scope="scope">
                <el-form-item :prop="'assessmentTempList.' + scope.$index + '.serialNumber'" :rules="model.rules.serialNumber">
                  <el-input v-model="scope.row.serialNumber" :maxlength="11" oninput = "value=value.replace(/[^\d]/g,'')"/>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="考核目标">
              <template slot-scope="scope">
                <el-form-item :prop="'assessmentTempList.' + scope.$index + '.assessmentTarget'" :rules="model.rules.assessmentTarget">
                  <el-input v-model="scope.row.assessmentTarget"/>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="分值">
              <template slot-scope="scope">
                <el-form-item :prop="'assessmentTempList.' + scope.$index + '.score'" :rules="model.rules.score">
                  <el-input v-model="scope.row.score" :maxlength="11" oninput = "value=value.replace(/[^\d]/g,'')"/>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="评分细则">
              <template slot-scope="scope">
                <el-form-item :prop="'assessmentTempList.' + scope.$index + '.scoreRubric'" :rules="model.rules.scoreRubric">
                  <el-input v-model="scope.row.scoreRubric"/>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="牵头考核部门">
              <template slot-scope="scope">
                <el-form-item :prop="'assessmentTempList.' + scope.$index + '.scoreRubric'" :rules="model.rules.leadAssessmentDepartment">
                  <el-cascader
                    :options="departmentList"
                    v-model="scope.row.leadAssessmentDepartmentS"
                    change-on-select
                    placeholder="请选择"
                    clearable
                    @change="handleChangeDepartment(scope.row)"
                  />
                </el-form-item>
              <!--</el-form-item>-->
              </template>
            </el-table-column>
            <el-table-column label="得分">
              <template slot-scope="scope">
                <el-form-item>
                  <el-input v-model="scope.row.assessmentScore" disabled="disabled"/>
                </el-form-item>
              </template>
            </el-table-column>
            <el-table-column label="扣分原因">
              <template slot-scope="scope">
                <el-form-item>
                  <el-input v-model="scope.row.causeDeduction" disabled="disabled"/>
                </el-form-item>
              </template>
            </el-table-column>
          </el-table>
        </el-form>
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
  api, systemApi
} from '@/api/hr/common'
export default {
  data() {
    return {
      departmentListLoading: false,
      departmentList: [],
      model: {
        rules: {
          targetCategory: { type: 'string', required: true, message: '请填写目标类别', trigger: 'blur' },
          serialNumber: { type: 'string', required: true, message: '请填写序号', trigger: 'blur' },
          assessmentTarget: { type: 'string', required: true, message: '请填写考核目标', trigger: 'blur' },
          score: { type: 'string', required: true, message: '请填写分值', trigger: 'blur' },
          scoreRubric: { type: 'string', required: true, message: '请填写评分细则', trigger: 'blur' },
          leadAssessmentDepartment: { type: 'string', required: true, message: '请填写牵头考核部门', trigger: 'change' }
        },
        assessmentTempList: []
      },
      tableData: [{
        rowNum: 0,
        templateName: '',
        targetCategory: '',
        serialNumber: '',
        score: '',
        scoreRubric: '',
        leadAssessmentDepartmentS: [],
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
  mounted() {
    this.getAllDepartment()
  },
  methods: {
    // 获取所有部门列表
    getAllDepartment() {
      this.departmentListLoading = true
      systemApi('system/sysDepartment/findDepartmentAllByLevel').then(res => {
        if (res.data.code === '0000') {
          this.departmentList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.departmentListLoading = false
      })
    },
    // 选择部门（新增用户对话框）
    handleChangeDepartment(row) {
      row.leadAssessmentDepartment = row.leadAssessmentDepartmentS[row.leadAssessmentDepartmentS.length - 1]
    },
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
        leadAssessmentDepartmentS: [],
        assessmentScore: this.assessmentScore,
        assessmentTarget: this.assessmentTarget,
        causeDeduction: this.causeDeduction
      }
      this.rowIndex = this.rowIndex + 1
      this.model.assessmentTempList.unshift(list)
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
          this.model.assessmentTempList.forEach((v, i) => {
            if (val.rowNum === v.rowNum) {
              this.model.assessmentTempList.splice(i, 1)
            }
          })
        })
      }
      // 删除完数据之后清除勾选框
      this.$refs.model.assessmentTempList.clearSelection()
    },
    submitForm() {
      this.isDisabled = true
      if (this.templateName === '') {
        this.$message.error('请填写模板名称')
        this.isDisabled = false
        return
      }
      const temps = this.model.assessmentTempList
      if (temps.length < 1) {
        alert('至少填写一项考核项目')
        this.isDisabled = false
        return false
      }

      this.$refs['assessmentTempListForm'].validate(valid => {
        if (valid) {
          let valid = true
          for (let i = 0; i < temps.length; i++) {
            const val = temps[i]
            if (val.leadAssessmentDepartmentS < 1) {
              alert('请选择牵头考核部门')
              this.isDisabled = false
              valid = false
              break
            }
          }
          if (!valid) {
            return false
          }
          for (let i = 0; i < temps.length; i++) {
            const row = temps[i]
            const leadAssessmentDepartment = row.leadAssessmentDepartmentS[row.leadAssessmentDepartmentS.length - 1]
            row.leadAssessmentDepartment = leadAssessmentDepartment
            this.commitRows.push(row)
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
        } else {
          this.isDisabled = false
        }
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
        'leadAssessmentDepartment': row.leadAssessmentDepartmentS[row.leadAssessmentDepartmentS.length - 1],
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

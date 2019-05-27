<template>
  <div v-loading="listLoading" class="assessmentList">
    <el-form :inline="true" class="filter-bar">
      <el-form-item label="考核名称" prop="assessmentName" class="inline">
        <el-input v-model="assessmentSubObj.assessmentName" disabled="disabled" clearable placeholder />
      </el-form-item>
      <el-form-item label="考核对象" prop="assessmentObject" class="inline">
        <el-input v-model="assessmentSubObj.assessmentObject" disabled="disabled" clearable placeholder style="width: 150px"/>
      </el-form-item>
      <el-form-item label="考核人" prop="assessmentPeople" class="inline">
        <el-input v-model="assessmentSubObj.assessmentPeople" disabled="disabled" clearable placeholder style="width: 150px"/>
      </el-form-item>
      <el-form-item>
        <div v-show="operateBtVisible">
          <el-button class="filter-item" type="primary" @click="endAarchive">结束并归档</el-button>
        </div>
      </el-form-item>
      <el-form-item>
        <el-button class="filter-item" type="primary" @click="goBack($route)">返回</el-button>
      </el-form-item>
    </el-form>
    <!-- 表格 -->
    <el-form :rules="model.rules" :model="model" :ref="assessmentSubListForm">
      <el-table ref="table" :data="model.assessmentSubList" tooltip-effect="dark" border stripe style="width: 95%" @selection-change="selectRow">
        <el-table-column type="selection" width="45" align="center"/>
        <el-table-column label="目标类别" align="center">
          <template slot-scope="scope">
            <el-form-item>
              <el-input v-model="scope.row.targetCategory" disabled="disabled"/>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="序号">
          <template slot-scope="scope">
            <el-form-item>
              <el-input v-model="scope.row.serialNumber" disabled="disabled"/>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="考核目标">
          <template slot-scope="scope">
            <el-form-item>
              <el-input v-model="scope.row.assessmentTarget" disabled="disabled"/>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="分值">
          <template slot-scope="scope">
            <el-form-item>
              <el-input v-model="scope.row.score" disabled="disabled"/>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="评分细则">
          <template slot-scope="scope">
            <el-form-item>
              <el-input v-model="scope.row.scoreRubric" disabled="disabled"/>
          <el-form-item/></el-form-item></template>
        </el-table-column>
        <el-table-column label="牵头考核部门">
          <template slot-scope="scope">
            <el-form-item>
              <el-input v-model="scope.row.leadAssessmentDepartment" disabled="disabled"/>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="得分">
          <template slot-scope="scope">
            <el-form-item :prop="'assessmentSubList.' + scope.$index + '.assessmentScore'" :rules="model.rules.assessmentScore">
              <el-input :disabled="!operateBtVisible" v-model="scope.row.assessmentScore" :max="99999999999" :min="0" type="number" oninput = "value=value.replace(/[^\d]/g,'')"/>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="扣分原因">
          <template slot-scope="scope">
            <el-form-item :prop="'assessmentSubList.' + scope.$index + '.causeDeduction'" :rules="model.rules.causeDeduction">
              <el-input :disabled="!operateBtVisible" v-model="scope.row.causeDeduction" :maxlength = "500"/>
            </el-form-item>
          </template>
        </el-table-column>
        <!--<el-table-column v-if="operateBtVisible" label="操作" align="center" min-width="100" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button type="text" @click="editAssessmentSub(scope.row)">编辑</el-button>
            <el-button type="text" @click="saveAssessmentSub(scope.row)">保存</el-button>
            <el-button type="text" @click="cancelAssessmentSub(scope.row)">取消</el-button>
          </template>
        </el-table-column>-->
      </el-table>
    </el-form>
    <div v-show="operateBtVisible" style="margin-top: 20px">
      <el-button :disabled="isDisabled" type="primary" @click="submitForm()">提交</el-button>
      <el-button type="primary" @click="goBack($route)">取消</el-button>
    </div>

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
      isDisabled: false,
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      assessmentSubObj: {
        assessmentName: '',
        assessmentObject: '',
        assessmentPeople: ''
      },
      assessmentSubListForm: {
        assessmentScore: '',
        causeDeduction: ''
      },
      model: {
        rules: {
          assessmentScore: { type: 'string', required: true, message: '请填写得分', trigger: 'blur' },
          causeDeduction: { type: 'string', required: true, message: '请填写扣分原因', trigger: 'blur' }
        },
        assessmentSubList: []
      },
      operateBtVisible: false,
      total: 0,
      listLoading: false,
      selectlistRow: [],
      commitRows: [],
      jobNumber: '',
      templateId: '',
      templateName: '',
      prePageRow: {},
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
    this.getPrePageRow()
  },
  methods: {
    selectRow(val) {
      this.selectlistRow = val
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
    getPrePageRow() {
      this.prePageRow = this.$route.query.row
    },
    // 初始化
    initList() {
      const title = this.$route.query.title
      this.assessmentSubObj.assessmentPeople = this.$route.query.row.assessmentPeople
      this.assessmentSubObj.assessmentName = this.$route.query.row.assessmentName
      this.assessmentSubObj.assessmentObject = this.$route.query.row.assessmentObject
      let url = ''
      if (title === '开始考核') {
        this.operateBtVisible = true
        url = 'hr/AssessmentManagement/startAssessmentPageDetails'
        // url = 'hr/AssessmentManagement/viewAssessmentDetails'
      } else { // 查看考核
        this.operateBtVisible = false
        url = 'hr/AssessmentManagement/viewAssessmentDetails'
      }
      this.listQuery = this.$route.query.row
      this.listQuery.rows = 10
      this.listQuery.page = 1

      api(url, this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.model.assessmentSubList = res.data.data
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push({ name: 'assessment-detail', query: { row: this.prePageRow }})
        }
      })
    },
    endAarchive() {
      this.listQuery.jobNumber = this.jobNumber
      delete this.listQuery.rows
      delete this.listQuery.page
      api('hr/AssessmentManagement/finishAndArchive', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '结束归档成功',
            type: 'success'
          })
          this.goBack(this.$route)
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    submitForm() {
      this.isDisabled = true
      let commitObj = {}
      commitObj = this.prePageRow
      commitObj.templateDetailList = this.model.assessmentSubList
      // this.model.assessmentSubList.forEach(val => {
      let flag = true
      for (let i = 0; i < this.model.assessmentSubList.length; i++) {
        if (this.model.assessmentSubList[i].assessmentScore === '' || this.model.assessmentSubList[i].assessmentScore === null) {
          alert('考核得分必填')
          this.isDisabled = false
          flag = false
          break
        }
        if (this.model.assessmentSubList[i].causeDeduction === '' || this.model.assessmentSubList[i].causeDeduction === 'null') {
          alert('扣分原因必填')
          this.isDisabled = false
          flag = false
          break
        }
      }
      if (!flag) {
        return false
      }
      api('hr/AssessmentManagement/saveStartAssessmentPage', commitObj).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.commitRows = []
          // this.goBack(this.$route)
        } else {
          this.$message.error(res.data.result)
          this.commitRows = []
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

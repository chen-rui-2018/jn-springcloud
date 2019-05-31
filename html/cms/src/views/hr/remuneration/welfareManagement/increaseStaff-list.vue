<template>
  <div v-loading="listLoading" class="increaseStaffList">
    <el-form :inline="true" class="filter-bar">
      <el-button class="filter-item" type="primary" @click="goBack($route)" >返回</el-button>
      <el-button class="filter-item" type="primary" @click="increaseStaffAdd">添加增减员计划</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="increaseStaffList" border fit highlight-current-row style="width: 100%;height:100%;margin-top: 10px;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column :show-overflow-tooltip="true" label="类型" align="center" prop="planType" />
      <el-table-column :show-overflow-tooltip="true" label="参保月份" align="center" prop="insuredMonth"/>
      <el-table-column :show-overflow-tooltip="true" label="姓名" align="center" prop="name"/>
      <el-table-column :show-overflow-tooltip="true" label="参保城市" align="center" prop="insuredCityName"/>
      <el-table-column :show-overflow-tooltip="true" label="参保方案" align="center" prop="insuredProgrammeName" />
      <el-table-column :show-overflow-tooltip="true" label="个人缴费" align="center" prop="personalPayment"/>
      <el-table-column :show-overflow-tooltip="true" label="公司缴费" align="center" prop="companyPayment"/>
      <el-table-column label="操作" align="center" min-width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button v-if="scope.row.planType == '增员'" type="text" @click="stopInsurance(scope.row)">取消</el-button>
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

    <!--添加增减员计划对话框-->
    <template v-if="increaseStaffAddFormVisible">
      <el-dialog :visible.sync="increaseStaffAddFormVisible" title="增减员计划" width="750px">
        <el-form ref="increaseStaffAddForm" :rules="increaseStaffAddFormRules" :model="increaseStaffAddFromData" label-width="150px">
          <el-form-item label="姓名" prop="jobNumber" class="inline">
            <multi-cascader-ext ref="assessmentObjectRef" v-model="increaseStaffAddFromData.jobNumberList" :data="deptEmployeeList" :only-last="true" :show-leaf-label="true" style="width: 350px" @change="nameSel"/>
            <!--
            <el-cascader-multi ref="assessmentObjectRef" v-model="increaseStaffAddFromData.jobNumberList" :data="deptEmployeeList" :only-last="true" :show-leaf-label="true" style="width: 350px" @change="nameSel"/>
-->
            <!--<el-input v-model="increaseStaffAddFromData.name" type="textarea" style="width: 350px;" readonly="readonly"/>
            <el-button type="text" @click="openStaffNamePage">选择</el-button>-->
          </el-form-item>
          <el-form-item label="参保月份" prop="insuredMonth" class="inline">
            <el-date-picker v-model="increaseStaffAddFromData.insuredMonth" value-format="yyyy-MM" type="month" placeholder="选择参保月份" style="width: 200px;"/>
          </el-form-item>
          <el-form-item label="参保方案" prop="insuredProgrammeId" class="inline">
            <el-select v-model="increaseStaffAddFromData.insuredProgrammeId" style="width: 200px;" placeholder="请选择参保方案" filterable @change="insuredProgrammeIdSel">
              <el-option v-for="item in insuredProgrammeList" :key="item.schemeId" :label="item.schemeName" :value="item.schemeId" />
            </el-select>
          </el-form-item>
          <el-form-item label="社保基数" prop="socialInsuranceBase" class="inline">
            <el-input v-model="socialInsuranceBaseData" type="textarea" style="width: 350px;" readonly="readonly"/>
            <el-button v-if="socialInsuranceBaseData !== ''" type="text" @click="socialInsuranceBaseFormPage">编辑各项目基数</el-button>
          </el-form-item>
          <el-form-item label="公积金基数" prop="reserveBase" class="inline">
            <!--<el-input type="text" style="width: 200px;"  v-model="increaseStaffAddFromData.increaseStaffAddFromReserveBase"/>
            <p style="height: 12px;margin-top: 0px;color:dodgerblue">基数范围[0-99999]</p>-->
            <el-input v-model="increaseStaffAddFromReserveBaseData" type="textarea" style="width: 350px;" readonly="readonly"/>
            <el-button v-if="increaseStaffAddFromReserveBaseData !== ''" type="text" @click="accumulationFundPageVisible">编辑各项目基数</el-button>
          </el-form-item>
          <el-form-item>
            <el-button :disabled="saveIncreaseStaffDisable" type="primary" @click="saveIncreaseStaff()">确定</el-button>
            <el-button type="primary" @click="cancelIncreaseStaffAddFormVisible" >取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </template>

    <!--获取参保人员信息对话框-->
    <el-dialog :visible.sync="openStaffNamePageVisible" title="员工信息" style="width: 950px;" >
      <div style="width: 100%;height: 320px;overflow: auto">
        <el-input
          v-model="filterText"
          placeholder="输入员工名字"/>
        <el-tree
          ref="rootTree"
          :data="rootData"
          :filter-node-method="filterNode"
          show-checkbox
          node-key="value"
        />
        <el-button type="primary" @click="getKeys">确定</el-button>
        <el-button @click="closeDialog" >取消</el-button>
      </div>
    </el-dialog>

    <!--编辑各项目基数对话框-->
    <template v-if="socialInsuranceBasePageVisibleVisible">
      <el-dialog :visible.sync="socialInsuranceBasePageVisibleVisible" title="各项目基数" width="650px">
        <el-form ref="socialInsuranceBaseForm" :model="socialInsuranceBaseFormData" class="auto_form">
          <el-form-item label="参保方案" prop="insuredProgrammeId" class="inline">
            <el-input v-model="selInsuredScheme.schemeName" style="width: 200px;" disabled="disabled"/>
          </el-form-item>
          <el-form-item v-for="(domain) in socialInsuranceBasePageInit" :prop="domain.prop" :label="domain.label" :key="domain.key">
            <!--<el-input v-model="domain.value" type="number" oninput = "value=value.replace(/[^\d\.]/g,'')" style="width: 200px;"/>-->
            <el-input-number v-model="domain.value" :min="1" :max="99999" style="width: 200px"/>
            <p style="height: 12px;margin-top: 0px;color:dodgerblue">基数范围[0-99999]</p>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="saveSocialInsuranceBase('social')">确定</el-button>
            <el-button type="primary" @click="cancelSocialInsuranceBasePage" >上一步</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </template>
    <!--编辑公积金各项基数-->
    <template v-if="accumulationFundPageVisibleVisible">
      <el-dialog :visible.sync="accumulationFundPageVisibleVisible" title="各项目基数" width="650px">
        <el-form ref="socialInsuranceBaseForm" :model="accumulationFundPageVisibleVisibleData" class="auto_form">
          <el-form-item label="参保方案" prop="insuredProgrammeId" class="inline">
            <el-input v-model="selInsuredScheme.schemeName" style="width: 200px;" disabled="disabled"/>
          </el-form-item>
          <el-form-item v-for="(domain) in reserveBasePageInit" :prop="domain.prop" :label="domain.label" :key="domain.key">
            <!--<el-input v-model="domain.value" type="text" style="width: 200px;"/>-->
            <el-input-number v-model="domain.value" :min="1" :max="99999" style="width: 200px"/>
            <p style="height: 12px;margin-top: 0px;color:dodgerblue">基数范围[0-99999]</p>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="saveSocialInsuranceBase('reserve')">确定</el-button>
            <el-button type="primary" @click="cancelAccumulationFundPage" >上一步</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </template>

  </div>
</template>
<script>
import {
  api, apiGet
} from '@/api/hr/common'
import multiCascaderExt from '@/components/MultiCascaderExt2/multi-cascader-ext.vue'

import UE from '@/components/ue.vue'
export default {
  components: { UE, multiCascaderExt },
  data() {
    return {
      increaseStaffAddFormRules: {
        jobNumber: [{ required: true, message: '请选择增员名称', trigger: 'change' }],
        insuredMonth: [{ required: true, message: '请选择参保月份', trigger: 'change' }],
        insuredProgrammeId: [{ required: true, message: '请选择参保方案', trigger: 'change' }]
      },
      // 新部门员工树
      deptEmployeeList: [],
      checkList: [],
      // 新部门员工树 end
      socialInsuranceBaseData: '',
      increaseStaffAddFromReserveBaseData: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      saveIncreaseStaffDisable: false,
      // 员工选择对话框
      filterText: '',
      rootData: [],
      openStaffNamePageVisible: false,
      socialInsuranceBasePageVisibleVisible: false,
      accumulationFundPageVisibleVisible: false,
      socialInsuranceBasePageInit: [],
      reserveBasePageInit: [],
      insuredProgrammeList: [],
      staffName: '',
      insuredProgrammeId: [],
      insuranceBaseData: {
      },
      selInsuredScheme: {
        schemeId: '',
        schemeName: ''
      },
      socialInsuranceBaseFormData: {
      },
      accumulationFundPageVisibleVisibleData: {

      },
      insuredProgrammes: [],
      increaseStaffAddFromData: {
        insuredMonth: '',
        jobNumber: '',
        name: '',
        jobNumberList: [],
        insuredProgrammeId: '',
        insuredProgrammeName: ''
      },
      increaseStaffAddFormVisible: false,
      increaseStaffList: [],
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
    filterText(val) {
      this.$refs.rootTree.filter(val)
    }
  },
  mounted() {
    this.initList()
    this.getDeptEmployeeList()
  },
  methods: {
    nameSel() {
      const selectedNodes = this.$refs['assessmentObjectRef'].selectedNodes
      this.increaseStaffAddFromData.jobNumber = ''
      for (let i = 0; i < selectedNodes.length; i++) {
        if (!selectedNodes[i].flag) {
          this.increaseStaffAddFromData.jobNumber = this.increaseStaffAddFromData.jobNumber + selectedNodes[i].jobNumber + ','
        }
      }
      if (this.increaseStaffAddFromData.jobNumber.length > 0) {
        this.increaseStaffAddFromData.jobNumber = this.increaseStaffAddFromData.jobNumber.substring(0, this.increaseStaffAddFromData.jobNumber.length - 1)
      }
    },
    getDeptEmployeeList() {
      apiGet('hr/employeeBasicInfo/selectDepartEmployee', {}).then(res => {
        if (res.data.code === '0000') {
          this.deptEmployeeList = JSON.parse(res.data.data)
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    cancelIncreaseStaffAddFormVisible() {
      this.increaseStaffAddFormVisible = false
    },
    filterNode(value, data) {
      if (!value) return true
      return data.label.indexOf(value) !== -1
    },

    socialInsuranceBaseFormPage() {
      this.socialInsuranceBasePageVisibleVisible = true
    },
    accumulationFundPageVisible() {
      this.accumulationFundPageVisibleVisible = true
    },
    cancelAccumulationFundPage() {
      this.accumulationFundPageVisibleVisible = false
    },
    cancelSocialInsuranceBasePage() {
      this.socialInsuranceBasePageVisibleVisible = false
    },
    saveSocialInsuranceBase(obj) { // 保存修改社保基数
      this.insuranceBaseData.schemeId = this.selInsuredScheme.schemeId
      this.insuranceBaseData.schemeName = this.selInsuredScheme.schemeName
      const insuredSchemeDetailedList = []
      if (obj === 'reserve') { // 公积金
        this.increaseStaffAddFromReserveBaseData = ''
        this.reserveBasePageInit.forEach(e => {
          this.increaseStaffAddFromReserveBaseData = this.increaseStaffAddFromReserveBaseData + e.label + ':' + e.value + ','
          insuredSchemeDetailedList.push(
            { defaultCardinalNumber: e.value,
              projectId: e.key })
        })
        this.increaseStaffAddFromReserveBaseData = this.increaseStaffAddFromReserveBaseData.substr(0, this.increaseStaffAddFromReserveBaseData.length - 1)
      } else { // 社保
        this.socialInsuranceBaseData = ''
        this.socialInsuranceBasePageInit.forEach(e => {
          this.socialInsuranceBaseData = this.socialInsuranceBaseData + e.label + ':' + e.value + ','
          insuredSchemeDetailedList.push(
            { defaultCardinalNumber: e.value,
              projectId: e.key })
        })
        this.socialInsuranceBaseData = this.socialInsuranceBaseData.substr(0, this.socialInsuranceBaseData.length - 1)
      }
      this.insuranceBaseData.insuredSchemeDetailedList = insuredSchemeDetailedList
      api('hr/SalaryWelfareManagement/updateInsuredCardinalNumber', this.insuranceBaseData).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '修改成功',
            type: 'success'
          })
          this.socialInsuranceBasePageVisibleVisible = false
          this.accumulationFundPageVisibleVisible = false
        } else {
          this.$message.error('社保基数修改失败')
        }
      })
    },
    initInsuranceBase(insuredSchemeDetailedList) {
      let index = 1
      this.socialInsuranceBaseData = ''
      this.increaseStaffAddFromReserveBaseData = ''
      this.socialInsuranceBasePageInit = []
      this.reserveBasePageInit = []
      insuredSchemeDetailedList.forEach(e => {
        if (e.projectType === 1) {
          this.socialInsuranceBasePageInit.push({
            label: e.projectName + '基数',
            key: e.projectId,
            prop: 'defaultCardinalNumber' + index,
            value: e.defaultCardinalNumber
          })
          index = index + 1
          // 回显
          this.socialInsuranceBaseData = this.socialInsuranceBaseData + e.projectName + '基数' + ':' + e.defaultCardinalNumber + ','
        } else { // 公积金
          this.reserveBasePageInit.push({
            label: e.projectName + '基数',
            key: e.projectId,
            prop: 'defaultCardinalNumber' + index,
            value: e.defaultCardinalNumber
          })
          index = index + 1
          // 回显
          this.increaseStaffAddFromReserveBaseData = this.increaseStaffAddFromReserveBaseData + e.projectName + '基数' + ':' + e.defaultCardinalNumber + ','
        }
      })
      if (this.socialInsuranceBaseData !== '') {
        this.socialInsuranceBaseData = this.socialInsuranceBaseData.substring(0, this.socialInsuranceBaseData.length - 1)
      }
      if (this.increaseStaffAddFromReserveBaseData !== '') {
        this.increaseStaffAddFromReserveBaseData = this.increaseStaffAddFromReserveBaseData.substring(0, this.increaseStaffAddFromReserveBaseData.length - 1)
      }
    },

    insuredProgrammeIdSel(val) {
      this.selInsuredScheme.schemeId = val
      const param = {
        rows: 10000,
        page: 1,
        schemeId: val
      }
      let autonomouslyInsurance = {}
      api('hr/SalaryWelfareManagement/insuranceSchemeDetailed', param).then(res => {
        if (res.data.code === '0000') {
          autonomouslyInsurance = res.data.data
          this.selInsuredScheme.schemeName = autonomouslyInsurance.schemeName
          const insuredSchemeDetailedList = res.data.data.insuredSchemeDetailedList
          this.initInsuranceBase(insuredSchemeDetailedList)
        } else {
          this.$message.error(res.data.result)
        }
      })
      console.log(this.selInsuredScheme)
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
      api('hr/SalaryWelfareManagement/inquireAttritionPlan', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.increaseStaffList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result == null ? '查询失败' : res.data.result)
        }
        this.listLoading = false
      })
    },
    // 停止参保
    stopInsurance(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          api('hr/SalaryWelfareManagement/deleteAttritionPlan', row).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: res.data.data,
                type: 'success'
              })
              if (this.total % this.listQuery.rows === 1) {
                this.listQuery.page = this.listQuery.page - 1
              }
              this.initList()
            } else {
              this.$message.error(res.data.data)
            }
          })
        })
        .catch(() => {
        })
    },
    increaseStaffAdd() {
      this.increaseStaffAddFormVisible = true
      api('hr/SalaryWelfareManagement/paginationInquireInsurance', { page: 1, rows: 10000 }).then(res => {
        if (res.data.code === '0000') {
          this.insuredProgrammeList = res.data.data.rows
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    saveIncreaseStaff() { // 保存增员计划
      this.saveIncreaseStaffDisable = true
      const param = {
        insuredMonth: this.increaseStaffAddFromData.insuredMonth,
        insuredProgrammeId: this.increaseStaffAddFromData.insuredProgrammeId,
        jobNumber: this.increaseStaffAddFromData.jobNumber
      }
      this.$refs['increaseStaffAddForm'].validate(valid => {
        if (valid) {
          api('hr/SalaryWelfareManagement/addOrDeleteAttritionPlan', param).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加增员计划成功',
                type: 'success'
              })
              this.increaseStaffAddFormVisible = false
              this.saveIncreaseStaffDisable = false
              this.increaseStaffAddFromData.jobNumber = ''
              this.checkList = []
              this.increaseStaffAddFromData = {
                insuredMonth: '',
                jobNumber: '',
                name: '',
                insuredProgrammeId: '',
                insuredProgrammeName: ''
              }
              this.socialInsuranceBasePageInit = []
              this.reserveBasePageInit = []
              this.socialInsuranceBaseData = ''
              this.increaseStaffAddFromReserveBaseData = ''
              this.initList()
            } else {
              this.$message.error('添加增员计划失败')
              this.saveIncreaseStaffDisable = false
            }
          })
        } else {
          this.saveIncreaseStaffDisable = false
        }
      })
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('insurancemanagement-list')
        }
      })
    },
    getDepartmentTree() {
      api('hr/AssessmentManagement/ObtainDepartmentTree', {}).then(res => {
        if (res.data.code === '0000') {
          this.rootData = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    openStaffNamePage() {
      this.openStaffNamePageVisible = true
      this.getDepartmentTree()
    },
    closeDialog() {
      this.openStaffNamePageVisible = false
    },
    getKeys(key) {
      const nodes = this.$refs.rootTree.getCheckedNodes()
      let arr = ''
      let name = ''
      for (var j = 0; j < nodes.length; j++) {
        if (nodes[j].parent !== -1) {
          arr = arr + nodes[j].value + ','
          name = name + nodes[j].label + ','
        }
      }
      if (arr !== '') {
        arr = arr.substring(0, arr.length - 1)
      }
      this.increaseStaffAddFromData.jobNumber = arr
      if (name !== '') {
        this.increaseStaffAddFromData.name = name.substring(0, name.length - 1)
      }
      this.openStaffNamePageVisible = false
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

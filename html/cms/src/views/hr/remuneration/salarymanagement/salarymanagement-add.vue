<template>
  <div>
    <div style="border:1px solid #00a0e9">
      <el-form ref="salaryInfoAdd" :model="salaryInfoAdd" :rules="rules" label-width="200px">
        <div align="left">
          <div style="height: 45px;line-height:45px; color: black;background-color: #00a2d4">
            员工薪资薪资
          </div>
          <div style="margin-left: 30px;">
            员工基本信息：
            <div style="display:flex">
              <el-form-item label="姓名">
                <el-input v-model="employeeBasicInfo.name" :disabled="editFlag" :style="{width:(editFlag==true?'205px':'170px')}"/>
                <el-button v-if="!editFlag" type="text" @click="selJobNumber">选择</el-button>
              </el-form-item>
              <el-form-item label="部门">
                <el-input v-model="employeeBasicInfo.departmentName" disabled="disabled" style="width: 205px;"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="职级">
                <el-input v-model="employeeBasicInfo.rankName" disabled="disabled" style="width: 205px;"/>
              </el-form-item>
              <el-form-item label="职位">
                <el-input v-model="employeeBasicInfo.jobName" disabled="disabled" style="width: 205px;"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="证件号">
                <el-input v-model="employeeBasicInfo.certificateNumber" disabled="disabled" style="width: 205px;"/>
              </el-form-item>
              <el-form-item label="入职时间">
                <el-input v-model="employeeBasicInfo.entryDate" disabled="disabled" style="width: 205px;"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="试用期工资">
                <el-input v-model="changeTrialPeriodWagesComp" disabled="disabled" style="width: 205px;"/>
              </el-form-item>
              <el-form-item label="转正工资">
                <el-input v-model="changePositiveWageComp" disabled="disabled" style="width: 205px;"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="当前工资">
                <el-input v-model="changeCurrentSalaryComp" disabled="disabled" style="width: 205px;"/>
              </el-form-item>
            </div>
          </div>
        </div>
        <div align="left">
          <div style="height: 45px;line-height:45px; color: black;background-color: #00a2d4">
            试用期工资组成
            <el-button v-show="trialPeriodWagesFlag" type="text" style="font-weight: bold;color: black" @click="onHideObj('trialPeriodWagesFlag')">隐藏</el-button>
            <el-button v-show="!trialPeriodWagesFlag" type="text" style="font-weight: bold;color: black" @click="onHideObj('trialPeriodWagesFlag')">显示</el-button>
          </div>
          <div v-show="trialPeriodWagesFlag" id="trialPeriodWagesDiv" style="margin-left: 30px; margin-top: 3px;">
            基本工资组成：
            <div style="display:flex">
              <el-form-item label="基础工资" prop="probationBasicWage" class="inline">
                <el-input v-model="salaryInfoAdd.probationBasicWage" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="职务津贴" prop="probationDutyAllowance" class="inline">
                <el-input v-model="salaryInfoAdd.probationDutyAllowance" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="职称津贴" prop="probationProfessionalTitleAllowance" class="inline">
                <el-input v-model="salaryInfoAdd.probationProfessionalTitleAllowance" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="工龄工资" prop="probationSeniorityWage" class="inline">
                <el-input v-model="salaryInfoAdd.probationSeniorityWage" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="学历津贴" prop="probationEducationAllowance" class="inline">
                <el-input v-model="salaryInfoAdd.probationEducationAllowance" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="工资性补贴" prop="probationWorkSubsidy" class="inline">
                <el-input v-model="salaryInfoAdd.probationWorkSubsidy" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
            其他：
            <div style="display:flex">
              <el-form-item label="绩效奖金" prop="probationAchievementBonus" class="inline">
                <el-input v-model="salaryInfoAdd.probationAchievementBonus" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="单项奖励" prop="probationSingleReward" class="inline">
                <el-input v-model="salaryInfoAdd.probationSingleReward" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
          </div>
        </div>

        <div align="left" style="margin-top: 5px;">
          <div style="height: 45px;line-height:45px; color: black;background-color: #00a2d4">
            转正工资组成
            <el-button v-show="positiveWageFlag" type="text" style="font-weight: bold;color: black" @click="onHideObj('positiveWageFlag')">隐藏</el-button>
            <el-button v-show="!positiveWageFlag" type="text" style="font-weight: bold;color: black" @click="onHideObj('positiveWageFlag')">显示</el-button>
            <!--          <img v-show="!positiveWageFlag" src="@/assets/images/search_up.gif" alt="图片">-->
            <!--          <img v-show="positiveWageFlag" src="@/assets/images/search_down.gif" alt="图片">-->
          </div>
          <div v-show="positiveWageFlag" id="positiveWageDiv" style="margin-left: 30px; margin-top: 3px;">
            基本工资组成：
            <div style="display:flex">
              <el-form-item label="基础工资" prop="conversionBasicWage" class="inline">
                <el-input v-model="salaryInfoAdd.conversionBasicWage" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="职务津贴" prop="conversionDutyAllowance" class="inline">
                <el-input v-model="salaryInfoAdd.conversionDutyAllowance" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="职称津贴" prop="conversionProfessionalTitleAllowance" class="inline">
                <el-input v-model="salaryInfoAdd.conversionProfessionalTitleAllowance" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="工龄工资" prop="conversionSeniorityWage" class="inline">
                <el-input v-model="salaryInfoAdd.conversionSeniorityWage" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="学历津贴" prop="conversionEducationAllowance" class="inline">
                <el-input v-model="salaryInfoAdd.conversionEducationAllowance" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="工资性补贴" prop="conversionWorkSubsidy" class="inline">
                <el-input v-model="salaryInfoAdd.conversionWorkSubsidy" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
            其他：
            <div style="display:flex">
              <el-form-item label="绩效奖金" prop="conversionAchievementBonus" class="inline">
                <el-input v-model="salaryInfoAdd.conversionAchievementBonus" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="单项奖励" prop="conversionSingleReward" class="inline">
                <el-input v-model="salaryInfoAdd.conversionSingleReward" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
          </div>
        </div>
        <div align="left" style="margin-top: 5px;">
          <div style="height: 45px;line-height:45px; color: black;background-color: #00a2d4">
            当前工资组成
            <el-button v-show="currentSalaryFlag" type="text" style="font-weight: bold;color: black" @click="onHideObj('currentSalaryFlag')">隐藏</el-button>
            <el-button v-show="!currentSalaryFlag" type="text" style="font-weight: bold;color: black" @click="onHideObj('currentSalaryFlag')">显示</el-button>
          <!--<img v-show="!currentSalaryFlag" src="@/assets/images/search_up.gif" alt="图片">
          <img v-show="currentSalaryFlag" src="@/assets/images/search_down.gif" alt="图片">-->
          </div>
          <div v-show="currentSalaryFlag" id="currentSalaryDiv" style="margin-left: 30px;margin-top: 3px;">
            基本工资组成：
            <div style="display:flex">
              <el-form-item label="基础工资" prop="currentBasicWage" class="inline">
                <el-input v-model="salaryInfoAdd.currentBasicWage" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="职务津贴" prop="currentDutyAllowance" class="inline">
                <el-input v-model="salaryInfoAdd.currentDutyAllowance" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="职称津贴" prop="currentProfessionalTitleAllowance" class="inline">
                <el-input v-model="salaryInfoAdd.currentProfessionalTitleAllowance" :disabled="disableAll" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="工龄工资" prop="currentSeniorityWage" class="inline">
                <el-input v-model="salaryInfoAdd.currentSeniorityWage" :disabled="disableAll" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
            <div style="display:flex">
              <el-form-item label="学历津贴" prop="currentEducationAllowance" class="inline">
                <el-input v-model="salaryInfoAdd.currentEducationAllowance" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="工资性补贴" prop="currentWorkSubsidy" class="inline">
                <el-input v-model="salaryInfoAdd.currentWorkSubsidy" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
            其他：
            <div style="display:flex">
              <el-form-item label="绩效奖金" prop="currentAchievementBonus" class="inline">
                <el-input v-model="salaryInfoAdd.currentAchievementBonus" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
              <el-form-item label="单项奖励" prop="currentSingleReward" class="inline">
                <el-input v-model="salaryInfoAdd.currentSingleReward" :disabled="disableAll" type="number" clearable placeholder="" maxlength="20"/>
              </el-form-item>
            </div>
          </div>
        </div>
      </el-form>
    </div>
    <div class="primaryList" style="margin-top: 20px;">
      <el-button v-if="isupdatesalary" :disabled="isDisabled" type="primary" @click="title==='新增薪资'?submitForm():updateData()">提交</el-button>
      <el-button v-if="isupdatesalary" type="primary" @click="goBack($route)" >返回</el-button>
    </div>
    <!-- 用户信息选择框 -->
    <template v-if="employeeBasicInfoFormVisible">
      <el-dialog :visible.sync="employeeBasicInfoFormVisible" :title="dialogTitle" width="850px">
        <el-table :data="employeeBasicInfoList" border fit highlight-current-row style="width: 100%;height:100%;">
          <el-table-column type="index" width="60" label="序号" align="center" />
          <el-table-column label="姓名" align="center" prop="name" />
          <el-table-column label="部门" align="center" prop="departmentName"/>
          <el-table-column label="职级" align="center" prop="rankName"/>
          <el-table-column label="职位" align="center" prop="jobName"/>
          <el-table-column label="证件号" align="center" prop="certificateNumber" />
          <el-table-column label="入职时间" width="120" align="center" prop="entryDate"/>
          <el-table-column label="操作" align="center" min-width="100" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button type="text" @click="chooseemployeeBasicInfo(scope.row)">选择</el-button>
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页 -->
        <el-pagination
          v-show="empTotal>0"
          :current-page="empListQuery.page"
          :page-sizes="[5,10,20,30, 50]"
          :page-size="empListQuery.rows"
          :total="empTotal"
          class="tablePagination"
          background
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleEmpSizeChange"
          @current-change="handleEmpCurrentChange" />
      </el-dialog>
    </template>
    <!-- 用户信息选择框 -->
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
    // var checknoticeTitle = (rule, value, callback) => {
    //   const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
    //   if (!reg.test(value)) {
    //     callback(new Error('名称只允许数字、中文、字母及下划线'))
    //   } else {
    //     callback()
    //   }
    // }
    return {
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      departmentList: [],
      total: 0,
      empTotal: 0,
      listQuery: {
        page: 1,
        rows: 10
      },
      empListQuery: {
        page: 1,
        rows: 10
      },
      preRowData: {},
      trialPeriodWagesFlag: false,
      positiveWageFlag: false,
      currentSalaryFlag: false,
      employeeBasicInfoFormVisible: false,
      isShow: false,
      isDisabled: false,
      title: '',
      isupdatesalary: true,
      editFlag: false,
      employeeBasicInfo: {
      },
      disableAll: false,
      employeeBasicInfoList: [],
      salaryInfoAdd: {
        jobNumber: 0,
        conversionAchievementBonus: 0,
        conversionBasicWage: 0,
        conversionDutyAllowance: 0,
        conversionEducationAllowance: 0,
        conversionProfessionalTitleAllowance: 0,
        conversionSeniorityWage: 0,
        conversionSingleReward: 0,
        conversionWorkSubsidy: 0,
        currentAchievementBonus: 0,
        currentBasicWage: 0,
        currentDutyAllowance: 0,
        currentEducationAllowance: 0,
        currentProfessionalTitleAllowance: 0,
        currentSeniorityWage: 0,
        currentSingleReward: 0,
        currentWorkSubsidy: 0,
        probationAchievementBonus: 0,
        probationBasicWage: 0,
        probationDutyAllowance: 0,
        probationEducationAllowance: 0,
        probationProfessionalTitleAllowance: 0,
        probationSeniorityWage: 0,
        probationSingleReward: 0,
        probationWorkSubsidy: 0
      },
      code: {
        groupCode: 'platform_type',
        moduleCode: 'springcloud-oa',
        parentGroupCode: 'assess'
      },
      rules: {
        probationBasicWage: [{ required: true, message: '请填写基础工资(试用期)', trigger: 'blur' }],
        probationDutyAllowance: [{ required: true, message: '请填写职务津贴(试用期)', trigger: 'blur' }],
        probationProfessionalTitleAllowance: [{ required: true, message: '请填写职称津贴(试用期)', trigger: 'blur' }],
        probationSeniorityWage: [{ required: true, message: '请填写工龄工资(试用期)', trigger: 'blur' }],
        probationEducationAllowance: [{ required: true, message: '请填写学历津贴(试用期)', trigger: 'blur' }],
        probationWorkSubsidy: [{ required: true, message: '请填写工作性补贴(试用期)', trigger: 'blur' }]
      }
    }
  },
  computed: {
    changeTrialPeriodWagesComp: function() {
      return parseInt((this.salaryInfoAdd.probationBasicWage == null || this.salaryInfoAdd.probationBasicWage === '') ? 0 : this.salaryInfoAdd.probationBasicWage) +
        parseInt((this.salaryInfoAdd.probationDutyAllowance == null || this.salaryInfoAdd.probationDutyAllowance === '') ? 0 : this.salaryInfoAdd.probationDutyAllowance) +
        parseInt((this.salaryInfoAdd.probationProfessionalTitleAllowance == null || this.salaryInfoAdd.probationProfessionalTitleAllowance === '') ? 0 : this.salaryInfoAdd.probationProfessionalTitleAllowance) +
        parseInt((this.salaryInfoAdd.probationSeniorityWage == null || this.salaryInfoAdd.probationSeniorityWage === '') ? 0 : this.salaryInfoAdd.probationSeniorityWage) +
        parseInt((this.salaryInfoAdd.probationEducationAllowance == null || this.salaryInfoAdd.probationEducationAllowance === '') ? 0 : this.salaryInfoAdd.probationEducationAllowance) +
        parseInt((this.salaryInfoAdd.probationWorkSubsidy == null || this.salaryInfoAdd.probationWorkSubsidy === '') ? 0 : this.salaryInfoAdd.probationWorkSubsidy) +
        parseInt((this.salaryInfoAdd.probationAchievementBonus == null || this.salaryInfoAdd.probationAchievementBonus === '') ? 0 : this.salaryInfoAdd.probationAchievementBonus) +
        parseInt((this.salaryInfoAdd.probationSingleReward == null || this.salaryInfoAdd.probationSingleReward === '') ? 0 : this.salaryInfoAdd.probationSingleReward)
    },
    changePositiveWageComp: function() {
      return parseInt((this.salaryInfoAdd.conversionBasicWage === null || this.salaryInfoAdd.conversionBasicWage === '') ? 0 : this.salaryInfoAdd.conversionBasicWage) +
        parseInt((this.salaryInfoAdd.conversionDutyAllowance === null || this.salaryInfoAdd.conversionDutyAllowance === '') ? 0 : this.salaryInfoAdd.conversionDutyAllowance) +
        parseInt((this.salaryInfoAdd.conversionProfessionalTitleAllowance === null || this.salaryInfoAdd.conversionProfessionalTitleAllowance === '') ? 0 : this.salaryInfoAdd.conversionProfessionalTitleAllowance) +
        parseInt((this.salaryInfoAdd.conversionSeniorityWage === null || this.salaryInfoAdd.conversionSeniorityWage === '') ? 0 : this.salaryInfoAdd.conversionSeniorityWage) +
        parseInt((this.salaryInfoAdd.conversionEducationAllowance === null || this.salaryInfoAdd.conversionEducationAllowance === '') ? 0 : this.salaryInfoAdd.conversionEducationAllowance) +
        parseInt((this.salaryInfoAdd.conversionWorkSubsidy === null || this.salaryInfoAdd.conversionWorkSubsidy === '') ? 0 : this.salaryInfoAdd.conversionWorkSubsidy) +
        parseInt((this.salaryInfoAdd.conversionAchievementBonus === null || this.salaryInfoAdd.conversionAchievementBonus === '') ? 0 : this.salaryInfoAdd.conversionAchievementBonus) +
        parseInt((this.salaryInfoAdd.conversionSingleReward === null || this.salaryInfoAdd.conversionSingleReward === '') ? 0 : this.salaryInfoAdd.conversionSingleReward)
    },
    changeCurrentSalaryComp: function() {
      return parseInt((this.salaryInfoAdd.currentBasicWage === null || this.salaryInfoAdd.currentBasicWage === '') ? 0 : this.salaryInfoAdd.currentBasicWage) +
        parseInt((this.salaryInfoAdd.currentDutyAllowance === null || this.salaryInfoAdd.currentDutyAllowance === '') ? 0 : this.salaryInfoAdd.currentDutyAllowance) +
        parseInt((this.salaryInfoAdd.currentProfessionalTitleAllowance == null || this.salaryInfoAdd.currentProfessionalTitleAllowance === '') ? 0 : this.salaryInfoAdd.currentProfessionalTitleAllowance) +
        parseInt((this.salaryInfoAdd.currentSeniorityWage === null || this.salaryInfoAdd.currentSeniorityWage === '') ? 0 : this.salaryInfoAdd.currentSeniorityWage) +
        parseInt((this.salaryInfoAdd.currentEducationAllowance === null || this.salaryInfoAdd.currentEducationAllowance === '') ? 0 : this.salaryInfoAdd.currentEducationAllowance) +
        parseInt((this.salaryInfoAdd.currentWorkSubsidy === null || this.salaryInfoAdd.currentWorkSubsidy === '') ? 0 : this.salaryInfoAdd.currentWorkSubsidy) +
        parseInt((this.salaryInfoAdd.currentAchievementBonus === null || this.salaryInfoAdd.currentAchievementBonus === '') ? 0 : this.salaryInfoAdd.currentAchievementBonus) +
        parseInt((this.salaryInfoAdd.currentSingleReward === null || this.salaryInfoAdd.currentSingleReward === '') ? 0 : this.salaryInfoAdd.currentSingleReward)
    }
  },
  created() {
    this.getPreRows()
    this.initList()
    // this.getDepartmentList()
  },
  methods: {
    getPreRows() {
      this.preRowData = this.$route.query.row
    },
    // getDepartmentList(){
    //   apiGet('hr/employeeDepartment/getEmployeeDepartments').then(res => {
    //     if (res.data.code === '0000') {
    //       this.departmentList = res.data.data
    //     } else {
    //       this.$message.error(res.data.result)
    //     }
    //   })
    // },
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

    // 员工表格分页功能
    handleEmpSizeChange(val) {
      this.empListQuery.rows = val
      this.selJobNumber()
    },
    // 表格分页功能
    handleEmpCurrentChange(val) {
      this.empListQuery.page = val
      this.selJobNumber()
    },

    // 新增提交表单
    submitForm() {
      this.isDisabled = true
      if (this.salaryInfoAdd.jobNumber != null && this.salaryInfoAdd.jobNumber !== '' && this.salaryInfoAdd.jobNumber !== 0) {
        console.log(123)
      } else {
        this.$message.error('请选择员工信息')
        return
      }
      this.$refs['salaryInfoAdd'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          delete
          api('hr/SalaryWelfareManagement/addSalaryInfo', this.salaryInfoAdd).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              this.goBack(this.$route)
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('salarymanagement-list')
        }
      })
    },
    selJobNumber() {
      this.employeeBasicInfoFormVisible = true
      this.dialogTitle = '用户信息列表'
      this.getEmployeeObj(this.empListQuery)
    },
    getEmployeeObj(listQuery) {
      api('hr/SalaryWelfareManagement/paginationInquireSalaryInfo', listQuery).then(res => {
        if (res.data.code === '0000') {
          this.employeeBasicInfoList = res.data.data.rows
          this.empTotal = res.data.data.total
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    onHideObj(id) {
      if (id === 'trialPeriodWagesFlag') {
        this.trialPeriodWagesFlag = !this.trialPeriodWagesFlag
      } else if (id === 'positiveWageFlag') {
        this.positiveWageFlag = !this.positiveWageFlag
      } else if (id === 'currentSalaryFlag') {
        this.currentSalaryFlag = !this.currentSalaryFlag
      }
    },
    chooseemployeeBasicInfo(row) {
      this.employeeBasicInfo = row
      this.salaryInfoAdd.jobNumber = this.employeeBasicInfo.jobNumber
      this.employeeBasicInfoFormVisible = false
    },
    // 编辑表单
    updateData() {
      this.isDisabled = true
      this.$refs['salaryInfoAdd'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api('hr/SalaryWelfareManagement/updateSalaryInfo', this.salaryInfoAdd).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              this.goBack(this.$route)
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    // 页面初始化
    initList() {
      debugger
      const query = this.$route.query
      this.title = query.title
      if (this.title === '查看') {
        this.isupdatesalary = false
        this.salaryInfoAdd = query.row
      }
      if (this.title === '修改' || this.title === '查看') {
        this.editFlag = true// 选择按钮显示与否
      }
      if (this.title === '查看') { // 其他项目是否disable
        this.disableAll = true
      }
      if (this.title !== '新增薪资') { // 查询用户基本信息
        this.salaryInfoAdd = this.preRowData
        this.empListQuery.jobNumber = this.$route.query.row.jobNumber
        api('hr/SalaryWelfareManagement/paginationInquireSalaryInfo', this.empListQuery).then(res => {
          if (res.data.code === '0000') {
            this.employeeBasicInfo = res.data.data.rows[0]
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    }
  }
}
</script>

<style lang="scss">
.addsalaryInfoAdd {
  .header {
    color: cadetblue;
    background: #f0f0f0;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: Center;
    padding: 20px 0px;
    border:1px solid #ccc;
  }
  .inline {
    display: inline-block;
  }
  .el-form-item__label {
    width: 120px;
    padding: 15px 0;
    display: inline-block;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .el-form-item {
    margin-bottom: 0px;
    flex: 1;
    display: flex;
  }
  .el-input--medium{
    width: 300px;
  }
  .el-form-item__content {
    flex: 1;
    // line-height: 36px;
    display: inline-block;
    padding:  15px;
    border: 1px solid #ccc;
  }
  #setheight{
    .el-form-item__content {
      line-height: 36px;
    }
  }
  .primaryList {
    margin-top: 30px;
    text-align: center;
  }
  .el-form-item__error{
    left:22px;
    top:unset;
    padding-top: unset;
  }
    .el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
    line-height: 22px;
  }
}
</style>

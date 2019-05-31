<template>
  <div>
    <el-form>
      <el-row>
        <el-col :span="12">
          <el-form-item label="参保城市：" prop="insuredCityId">
            <el-cascader
              ref="assessmentPeopleRef"
              :options="provinceCityList"
              v-model="provinceCity"
              change-on-select
              placeholder="请选择"
              clearable
              @change="provinceCitySel"
            />
            <!--<el-input v-model="addInsuranceData.insuredCityName" style="width: 205px;" @focus="insuranceCityPageOpen"/>-->
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="方案名称：" prop="schemeName">
            <el-input v-model="addInsuranceData.schemeName" style="width: 205px;"/>
          </el-form-item>
        </el-col>
      </el-row>

      <div>
        <div style="width: 100%; height: 30px;">
          <span style="font-weight: bold;color: blue;margin-left: 5px; line-height: 30px;">社保</span>
          <span style="width: 220px;float: right;display:inline-block">
            <el-button type="primary" icon="el-icon-plus" @click="addSocialSecurityRow()">添加</el-button>
            <el-button type="primary" icon="el-icon-minus" @click="delSocialSecurityData()">删除</el-button>
          </span>
        </div>
        <div style="margin-left: 5px; margin-top: 10px;">
          <el-table ref="socialSecurityTable" :data="addInsuranceData.socialSecurityTableData" tooltip-effect="dark" border stripe style="width: 100%" @selection-change="selectSocialSecurityRow">
            <el-table-column type="selection" width="45" align="center"/>
            <el-table-column label="项目" align="center" width="150">
              <template slot-scope="scope">
                <el-input v-model="scope.row.projectName"/>
              </template>
            </el-table-column>
            <el-table-column label="默认基数">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.defaultCardinalNumber" :min="0" :max="99999" style="width: 160px"/>
              </template>
            </el-table-column>
            <el-table-column label="可选基数范围起">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.optionalBaseStart" :min="0" :max="99999" style="width: 160px" @blur="checkOptionalBaseValid(scope.row)"/>
              </template>
            </el-table-column>
            <el-table-column label="可选基数范围止">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.optionalBaseEnd" :min="1" :max="99999" style="width: 160px" @blur="checkOptionalBaseValid(scope.row)"/>
              </template>
            </el-table-column>
            <el-table-column label="公司缴纳比例">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.corporateContributionRatio" :min="0" :max="99" style="width: 160px"/>
              </template>
            </el-table-column>
            <el-table-column label="个人缴纳比例">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.individualContributionRatio" :min="0" :max="99" style="width: 160px"/>
              </template>
            </el-table-column>
            <el-table-column label="公司金额" width="150">
              <template slot-scope="scope">
                {{ getSocialSecurityCompanyAmount(scope.row) }}
              </template>
            </el-table-column>
            <el-table-column label="个人金额" width="150">
              <template slot-scope="scope">
                {{ getSocialSecurityPersonalAmount(scope.row) }}
              </template>
            </el-table-column>
          </el-table>
        </div>
        <div style="height: 50px; margin-top: 8px;">
          <span style="float: right; color: #666666;width: 300px">
            社保公司总计:{{ companySocialSecurityCom }}   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   社保个人总计:{{ personalSocialSecurityCom }}
          </span>
        </div>
      </div>

      <div style="margin-top: 10px;">
        <div style="width: 100%; height: 30px;">
          <span style="font-weight: bold;color: blue;margin-left: 5px; line-height: 30px;">公积金
            <el-checkbox v-model="checked" @change="delAllData()">不缴公积金</el-checkbox>
          </span>
          <span style="width: 220px;float: right;display:inline-block">
            <el-button type="primary" icon="el-icon-plus" @click="addRow()">添加</el-button>
            <el-button type="primary" icon="el-icon-minus" @click="delData()">删除</el-button>
          </span>
        </div>
        <div style="margin-left: 5px; margin-top: 10px;">
          <el-table ref="table" :data="addInsuranceData.tableData" tooltip-effect="dark" border stripe style="width: 100%" @selection-change="selectRow">
            <el-table-column type="selection" width="45" align="center"/>
            <el-table-column label="项目" align="center" width="150">
              <template slot-scope="scope">
                <el-input v-model="scope.row.projectName" :disabled="accumulationFundDisabled" style="width: 100%"/>
              </template>
            </el-table-column>
            <el-table-column label="默认基数">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.defaultCardinalNumber" :min="0" :max="99999"/>
              </template>
            </el-table-column>
            <el-table-column label="可选基数范围起">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.optionalBaseStart" :min="0" :max="99999" style="width: 160px" @blur="checkOptionalBaseValid(scope.row)"/>
              </template>
            </el-table-column>
            <el-table-column label="可选基数范围止">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.optionalBaseEnd" :min="1" :max="99999" style="width: 160px" @blur="checkOptionalBaseValid(scope.row)"/>
              </template>
            </el-table-column>
            <el-table-column label="公司缴纳比例">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.corporateContributionRatio" :min="0" :max="99" style="width: 160px"/>
              </template>
            </el-table-column>
            <el-table-column label="个人缴纳比例">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.individualContributionRatio" :min="0" :max="99" style="width: 160px"/>
              </template>
            </el-table-column>
            <el-table-column label="公司金额" style="background: #666666" width="150">
              <template slot-scope="scope">
                {{ getProvidentFundCompanyAmount(scope.row) }}
              </template>
            </el-table-column>
            <el-table-column label="个人金额" width="150">
              <template slot-scope="scope">
                {{ getProvidentFundPersonalAmount(scope.row) }}
              </template>
            </el-table-column>
          </el-table>
        </div>
        <div style="height: 50px; margin-top: 8px;">
          <span style="float: right; color: #666666;width: 300px">
            公积金公司总计:{{ companyAccumulationFundCom }}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  公积金个人总计:{{ personalAccumulationFundCom }}
          </span>
        </div>
      </div>
      <div style="margin-top: 10px;">
        <el-form-item>
          <el-button :disabled="isDisabled" type="primary" @click="title==='新增参保方案'?submitForm():updateData()">提交</el-button>
          <el-button type="primary" @click="goBack($route)" >取消</el-button>
        </el-form-item>
      </div>
    </el-form>
  </div>
</template>
<script>
import {
  api, accDiv, accMul
} from '@/api/hr/common'
import {
  findNodeById
} from '@/api/hr/util'

import province from '@/api/hr/city_code'

export default {
  data() {
    return {
      isOptionalBaseValid: true,
      nodes: [],
      accumulationFundDisabled: false,
      checked: false,
      addInsuranceData: {
        insuredCityName: '',
        insuredCityId: '',
        schemeName: '',
        tableData: [],
        socialSecurityTableData: []
      },
      provinceCityList: [],
      provinceCity: [],
      templateName: '',
      isDisabled: false,
      selectSocialSecuritylistRow: [],
      commitSocialSecurityRows: [],
      socialSecurityRowIndex: 6,
      selectlistRow: [],
      commitRows: {},
      rowIndex: 2
    }
  },
  computed: {
    getProvidentFundCompanyAmount(row) {
      return function(row) {
        const number = accMul((row.defaultCardinalNumber == null || row.defaultCardinalNumber === '') ? 0 : row.defaultCardinalNumber, (row.corporateContributionRatio == null || row.corporateContributionRatio === '') ? 0 : row.corporateContributionRatio)
        return accDiv(number, 100)
      }
    },
    getProvidentFundPersonalAmount(row) {
      return function(row) {
        const number = accMul((row.defaultCardinalNumber == null || row.defaultCardinalNumber === '') ? 0 : row.defaultCardinalNumber, (row.individualContributionRatio == null || row.individualContributionRatio === '') ? 0 : row.individualContributionRatio)
        return accDiv(number, 100)
      }
    },
    getSocialSecurityCompanyAmount(row) {
      return function(row) {
        const number = accMul((row.defaultCardinalNumber == null || row.defaultCardinalNumber === '') ? 0 : row.defaultCardinalNumber, (row.corporateContributionRatio == null || row.corporateContributionRatio === '') ? 0 : row.corporateContributionRatio)
        return accDiv(number, 100)
      }
    },
    getSocialSecurityPersonalAmount(row) {
      return function(row) {
        const number = accMul((row.defaultCardinalNumber == null || row.defaultCardinalNumber === '') ? 0 : row.defaultCardinalNumber, (row.individualContributionRatio == null || row.individualContributionRatio === '') ? 0 : row.individualContributionRatio)
        return accDiv(number, 100)
      }
    },
    companyAccumulationFundCom: function() { // 公司公积金总计
      let companyAccumulationFund = 0
      if (this.accumulationFundDisabled === false) {
        if (this.addInsuranceData.tableData.length > 0) {
          this.addInsuranceData.tableData.forEach((v, i) => {
            companyAccumulationFund = companyAccumulationFund + accDiv(accMul((v.defaultCardinalNumber == null || v.defaultCardinalNumber === '') ? 0 : v.defaultCardinalNumber, (v.corporateContributionRatio == null || v.corporateContributionRatio === '') ? 0 : v.corporateContributionRatio), 100)
          })
        }
      }
      return companyAccumulationFund
    },
    personalAccumulationFundCom: function() { // 个人公积金
      let personalAccumulationFund = 0
      if (this.accumulationFundDisabled === false) {
        if (this.addInsuranceData.tableData.length > 0) {
          this.addInsuranceData.tableData.forEach((v, i) => {
            personalAccumulationFund = personalAccumulationFund + accDiv(accMul((v.defaultCardinalNumber == null || v.defaultCardinalNumber === '') ? 0 : v.defaultCardinalNumber, (v.individualContributionRatio == null || v.individualContributionRatio === '') ? 0 : v.individualContributionRatio), 100)
          })
        }
      }
      return personalAccumulationFund
    },
    companySocialSecurityCom: function() {
      let companySocialSecurity = 0
      if (this.addInsuranceData.socialSecurityTableData.length > 0) {
        this.addInsuranceData.socialSecurityTableData.forEach((v, i) => {
          companySocialSecurity = companySocialSecurity + accDiv(accMul((v.defaultCardinalNumber == null || v.defaultCardinalNumber === '') ? 0 : v.defaultCardinalNumber, (v.corporateContributionRatio == null || v.corporateContributionRatio === '') ? 0 : v.corporateContributionRatio), 100)
        })
      }
      return companySocialSecurity
    },
    personalSocialSecurityCom: function() {
      let personalSocialSecurity = 0
      if (this.addInsuranceData.socialSecurityTableData.length > 0) {
        this.addInsuranceData.socialSecurityTableData.forEach((v, i) => {
          personalSocialSecurity = personalSocialSecurity + accDiv(accMul((v.defaultCardinalNumber == null || v.defaultCardinalNumber === '') ? 0 : v.defaultCardinalNumber, (v.individualContributionRatio == null || v.individualContributionRatio === '') ? 0 : v.individualContributionRatio), 100)
        })
      }
      return personalSocialSecurity
    }

  },
  mounted() {
    this.initProvinceCityTree()
    this.initList()
  },
  methods: {
    initProvinceCityTree() {
      const tree = []
      province.province.forEach(item => {
        const province = {}
        province.label = item.label
        province.value = item.value
        province.parentId = '-1'
        if (item.children && item.children.length > 0) {
          const childrens = item.children
          const childrensTree = []
          childrens.forEach(item => {
            childrensTree.push({
              label: item.label,
              value: item.value,
              parentId: province.value
            })
          })
          province.children = childrensTree
        }
        tree.push(province)
      })
      this.provinceCityList = tree
      this.getProvinceCity(this.nodes, this.provinceCityList)
    },
    getProvinceCity(nodes, children) {
      children.forEach(item => {
        nodes.push({
          'id': item.value,
          'value': item.value,
          'label': item.label,
          'parentId': item.parentId
        })
        if (item.children && item.children.length > 0) {
          this.getProvinceCity(nodes, item.children)
        }
      })
    },
    provinceCitySel() {
      const provinceCityId = this.provinceCity[this.provinceCity.length - 1]
      const currNode = findNodeById(this.nodes, provinceCityId)
      this.addInsuranceData.insuredCityName = currNode.label
      this.addInsuranceData.insuredCityId = currNode.value
    },
    checkOptionalBaseValid(row) {
      if (row.optionalBaseStart > row.optionalBaseEnd) {
        alert('可选基数范围开始值应小于可选基数范围结束值')
        this.isOptionalBaseValid = false
      } else {
        this.isOptionalBaseValid = true
      }
    },
    initAddData() {
      this.addInsuranceData.tableData = [{
        rowNum: 0,
        projectName: '公积金',
        defaultCardinalNumber: '5000',
        optionalBaseStart: '0',
        optionalBaseEnd: '99999',
        corporateContributionRatio: '8',
        individualContributionRatio: '8',
        companyAmount: 0,
        personalAmount: 0,
        projectType: 2
      }]
      this.addInsuranceData.socialSecurityTableData = [{
        rowNum: 1,
        projectName: '养老保险',
        defaultCardinalNumber: '0',
        optionalBaseStart: '0',
        optionalBaseEnd: '99999',
        corporateContributionRatio: '8',
        individualContributionRatio: '8',
        companyAmount: 0,
        personalAmount: 0,
        projectType: 1
      }, {
        rowNum: 2,
        projectName: '医疗保险',
        defaultCardinalNumber: '0',
        optionalBaseStart: '0',
        optionalBaseEnd: '99999',
        corporateContributionRatio: '8',
        individualContributionRatio: '8',
        companyAmount: 0,
        personalAmount: 0,
        projectType: 1

      }, {
        rowNum: 3,
        projectName: '失业保险',
        defaultCardinalNumber: '0',
        optionalBaseStart: '0',
        optionalBaseEnd: '99999',
        corporateContributionRatio: '8',
        individualContributionRatio: '8',
        companyAmount: 0,
        personalAmount: 0,
        projectType: 1

      }, {
        rowNum: 4,
        projectName: '工伤保险',
        defaultCardinalNumber: '0',
        optionalBaseStart: '0',
        optionalBaseEnd: '99999',
        corporateContributionRatio: '8',
        individualContributionRatio: '8',
        companyAmount: 0,
        personalAmount: 0,
        projectType: 1

      }, {
        rowNum: 5,
        projectName: '生育保险',
        defaultCardinalNumber: '0',
        optionalBaseStart: '0',
        optionalBaseEnd: '99999',
        corporateContributionRatio: '8',
        individualContributionRatio: '8',
        companyAmount: 0,
        personalAmount: 0,
        projectType: 1

      }]
    },
    initEditData(row) {
      this.addInsuranceData.insuredCityName = row.insuredCityName
      this.addInsuranceData.insuredCityId = row.insuredCityId
      const currNode = findNodeById(this.nodes, row.insuredCityId)
      this.provinceCity = [currNode.parentId, row.insuredCityId]
      this.addInsuranceData.schemeName = row.schemeName
      api('hr/SalaryWelfareManagement/insuranceSchemeDetailed', row).then(res => {
        if (res.data.code === '0000') {
          const insuredSchemeDetailedList = res.data.data.insuredSchemeDetailedList
          insuredSchemeDetailedList.forEach((val, index) => {
            if (val.projectType === 1) { // 社保
              val.rowNum = this.socialSecurityRowIndex
              this.addInsuranceData.socialSecurityTableData.push(val)
              this.socialSecurityRowIndex = this.socialSecurityRowIndex + 1
            } else { // 公积金
              val.rowNum = this.rowIndex
              this.addInsuranceData.tableData.push(val)
              this.rowIndex = this.rowIndex + 1
            }
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    initList() {
      const query = this.$route.query
      this.title = query.title
      if (this.title === '修改参保方案') {
        this.prePageRow = this.$route.query.row
        this.initEditData(query.row)
      } else {
        this.initAddData()
      }
    },
    insuranceCitySubmit() {
      this.addInsuranceData.insuredCityId = this.insuranceCityKeyArr.sheng + '/' + this.insuranceCityKeyArr.shi
      // +"/"+this.insuranceCityKeyArr.qu
      this.addInsuranceData.insuredCityName = this.insuranceCityKeyArrName.sheng + '/' + this.insuranceCityKeyArrName.shi
      // +"/"+this.insuranceCityKeyArrName.qu
      this.insuranceCityFormVisible = false
    },
    insuranceCityPageOpen() {
      this.insuranceCityFormVisible = true
    },
    handleCancleInsuranceCityFormVisible() {
      this.insuranceCityFormVisible = false
    },

    // 获取表格选中时的数据
    selectRow(val) {
      this.selectlistRow = val
    },
    selectSocialSecurityRow(val) {
      this.selectSocialSecuritylistRow = val
    },
    // 增加行
    addRow() {
      var list = {
        rowNum: this.rowIndex,
        projectName: '',
        defaultCardinalNumber: '',
        optionalBaseStart: '',
        optionalBaseEnd: '',
        corporateContributionRatio: '',
        individualContributionRatio: '',
        companyAmount: '',
        personalAmount: '',
        projectType: 2
      }
      this.rowIndex = this.rowIndex + 1
      this.addInsuranceData.tableData.unshift(list)
    },

    // 增加行
    addSocialSecurityRow() {
      const list = {
        rowNum: this.socialSecurityRowIndex,
        projectName: '',
        defaultCardinalNumber: '',
        optionalBaseStart: '',
        optionalBaseEnd: '',
        corporateContributionRatio: '',
        individualContributionRatio: '',
        companyAmount: '',
        personalAmount: '',
        projectType: 1
      }
      this.socialSecurityRowIndex = this.socialSecurityRowIndex + 1
      this.addInsuranceData.socialSecurityTableData.unshift(list)
    },
    delAllData() {
      this.accumulationFundDisabled = !this.accumulationFundDisabled
    },
    // 删除方法
    delData() {
      if (this.addInsuranceData.tableData.length < 1) {
        this.$message.error('必须有一条公积金记录，如果不参保，请勾选不参保选项')
        return
      }
      for (let i = 0; i < this.selectlistRow.length; i++) {
        const val = this.selectlistRow
        // 获取选中行的索引的方法
        // 遍历表格中tableData数据和选中的val数据，比较它们的rowNum,相等则输出选中行的索引
        // rowNum的作用主要是为了让每一行有一个唯一的数据，方便比较，可以根据个人的开发需求从后台传入特定的数据
        val.forEach((val, index) => {
          this.addInsuranceData.tableData.forEach((v, i) => {
            if (val.rowNum === v.rowNum) {
              this.addInsuranceData.tableData.splice(i, 1)
            }
          })
        })
      }
      // 删除完数据之后清除勾选框
      this.$refs.tableData.clearSelection()
    },
    // 删除方法
    delSocialSecurityData() {
      if (this.addInsuranceData.socialSecurityTableData.length < 1) {
        this.$message.error('暂时无法删除社保记录')
        return
      }
      for (let i = 0; i < this.selectSocialSecuritylistRow.length; i++) {
        const val = this.selectSocialSecuritylistRow
        // 获取选中行的索引的方法
        // 遍历表格中tableData数据和选中的val数据，比较它们的rowNum,相等则输出选中行的索引
        // rowNum的作用主要是为了让每一行有一个唯一的数据，方便比较，可以根据个人的开发需求从后台传入特定的数据
        val.forEach((val, index) => {
          this.addInsuranceData.socialSecurityTableData.forEach((v, i) => {
            if (val.rowNum === v.rowNum) {
              this.addInsuranceData.socialSecurityTableData.splice(i, 1)
            }
          })
        })
      }
      // 删除完数据之后清除勾选框
      this.$refs.socialSecurityTableData.clearSelection()
    },
    updateData() { // 修改保存
      this.isDisabled = true
      let flag = true
      if (!this.isOptionalBaseValid) {
        alert('可选基数范围开始值不能小于可选基数范围结束值')
        this.isDisabled = false
        return false
      }
      if (this.addInsuranceData.insuredCityId === '' || this.addInsuranceData.insuredCityId.trim() === '/') {
        this.$message.error('请填写要参保的城市')
        flag = false
        this.isDisabled = false
        return false
      }
      if (this.addInsuranceData.schemeName === '') {
        this.$message.error('请填写参保名称')
        flag = false
        this.isDisabled = false
        return false
      }
      if (this.addInsuranceData.socialSecurityTableData.length < 1) {
        this.$message.error('至少填写一项社保项目')
        flag = false
        this.isDisabled = false
        return false
      }
      for (let i = 0; i < this.addInsuranceData.socialSecurityTableData.length; i++) {
        if (this.addInsuranceData.socialSecurityTableData[i].defaultCardinalNumber === '') {
          alert('社保默认基数为必填项，请检查')
          flag = false
          break
        }
      }
      if (!flag) {
        this.isDisabled = false
        return false
      }
      if (this.addInsuranceData.tableData.length > 0 && this.accumulationFundDisabled === false) {
        for (let i = 0; i < this.addInsuranceData.tableData.length; i++) {
          if (this.addInsuranceData.tableData[i].defaultCardinalNumber === '') {
            alert('公积金默认基数为必填项，请检查')
            flag = false
            break
          }
        }
      }
      if (!flag) {
        this.isDisabled = false
        return false
      }
      this.commitRows.schemeId = this.prePageRow.schemeId
      this.commitRows.socialSecurityId = this.prePageRow.socialSecurityId
      this.commitRows.accumulationFundId = this.prePageRow.accumulationFundId
      this.commitRows.schemeName = this.addInsuranceData.schemeName
      this.commitRows.insuredCityId = this.addInsuranceData.insuredCityId
      this.commitRows.insuredCityName = this.addInsuranceData.insuredCityName
      const insuredSchemeDetailedList = []
      this.addInsuranceData.socialSecurityTableData.forEach((v, i) => {
        insuredSchemeDetailedList.push(v)
      })

      if (this.accumulationFundDisabled === false) {
        this.addInsuranceData.tableData.forEach((v, i) => {
          insuredSchemeDetailedList.push(v)
        })
      }
      this.commitRows.insuredSchemeDetailedList = insuredSchemeDetailedList
      if (flag) {
        api('hr/SalaryWelfareManagement/updateInsurancescheme', this.commitRows).then(res => {
          if (res.data.code === '0000') {
            this.$message({
              message: '修改成功',
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
      }
    },
    submitForm() {
      let flag = true
      this.isDisabled = true
      if (!this.isOptionalBaseValid) {
        alert('可选基数范围开始值不能小于可选基数范围结束值')
        this.isDisabled = false
        return false
      }
      if (this.addInsuranceData.insuredCityId === '' || this.addInsuranceData.insuredCityId === '/') {
        this.$message.error('请填写要参保的城市')
        flag = false
        this.isDisabled = false
        return false
      }
      if (this.addInsuranceData.schemeName === '') {
        this.$message.error('请填写参保名称')
        flag = false
        this.isDisabled = false
        return false
      }
      if (this.addInsuranceData.socialSecurityTableData.length < 1) {
        this.$message.error('至少填写一项社保项目')
        flag = false
        this.isDisabled = false
        return false
      }
      for (let i = 0; i < this.addInsuranceData.socialSecurityTableData.length; i++) {
        if (this.addInsuranceData.socialSecurityTableData[i].defaultCardinalNumber === '') {
          flag = false
          alert('社保默认基数为必填项，请检查')
          break
        }
      }
      if (!flag) {
        this.isDisabled = false
        return false
      }
      if (this.addInsuranceData.tableData.length > 0 && this.accumulationFundDisabled === false) {
        for (let i = 0; i < this.addInsuranceData.tableData.length; i++) {
          if (this.addInsuranceData.tableData[i].defaultCardinalNumber === '') {
            flag = false
            alert('公积金默认基数为必填项，请检查')
            break
          }
        }
      }
      if (!flag) {
        this.isDisabled = false
        return false
      }
      this.commitRows.insuredCityId = this.addInsuranceData.insuredCityId
      this.commitRows.insuredCityName = this.addInsuranceData.insuredCityName
      this.commitRows.schemeName = this.addInsuranceData.schemeName
      const insuredSchemeDetailedList = []
      this.addInsuranceData.socialSecurityTableData.forEach((v, i) => {
        insuredSchemeDetailedList.push(v)
      })
      if (this.accumulationFundDisabled === false) {
        this.addInsuranceData.tableData.forEach((v, i) => {
          insuredSchemeDetailedList.push(v)
        })
      }
      this.commitRows.insuredSchemeDetailedList = insuredSchemeDetailedList
      if (flag) {
        api('hr/SalaryWelfareManagement/addInsurancescheme', this.commitRows).then(res => {
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
      }
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('autonomouslyInsure-list')
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

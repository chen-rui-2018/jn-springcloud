<template>
  <div>
    <el-form>
      <el-row>
        <el-col :span="12">
          <el-form-item label="参保城市：" prop="insuredCityId">
            <el-input v-model="addInsuranceData.insuredCityName" style="width: 205px;" @focus="insuranceCityPageOpen"/>
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
            <el-button type="primary" @click="addSocialSecurityRow()">添加</el-button>
            <el-button type="primary" @click="delSocialSecurityData()">删除</el-button>
          </span>
        </div>
        <div style="margin-left: 5px; margin-top: 10px;">
          <el-table ref="socialSecurityTable" :data="addInsuranceData.socialSecurityTableData" tooltip-effect="dark" border stripe style="width: 100%" @selection-change="selectSocialSecurityRow">
            <el-table-column type="selection" width="45" align="center"/>
            <el-table-column label="项目" align="center">
              <template slot-scope="scope">
                <el-input v-model="scope.row.projectName"/>
              </template>
            </el-table-column>
            <el-table-column label="默认基数">
              <template slot-scope="scope">
                <el-input v-model="scope.row.defaultCardinalNumber"/>
              </template>
            </el-table-column>
            <el-table-column label="可选基数范围起">
              <template slot-scope="scope">
                <el-input v-model="scope.row.optionalBaseStart"/>
              </template>
            </el-table-column>
            <el-table-column label="可选基数范围止">
              <template slot-scope="scope">
                <el-input v-model="scope.row.optionalBaseEnd"/>
              </template>
            </el-table-column>
            <el-table-column label="公司缴纳比例">
              <template slot-scope="scope">
                <el-input v-model="scope.row.corporateContributionRatio"/>
              </template>
            </el-table-column>
            <el-table-column label="个人缴纳比例">
              <template slot-scope="scope">
                <el-input v-model="scope.row.individualContributionRatio"/>
              </template>
            </el-table-column>
            <el-table-column label="公司金额">
              <template slot-scope="scope">
                {{ getSocialSecurityCompanyAmount(scope.row) }}
              </template>
            </el-table-column>
            <el-table-column label="个人金额">
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
            <el-button type="primary" @click="addRow()">添加</el-button>
            <el-button type="primary" @click="delData()">删除</el-button>
          </span>
        </div>
        <div style="margin-left: 5px; margin-top: 10px;">
          <el-table ref="table" :data="addInsuranceData.tableData" tooltip-effect="dark" border stripe style="width: 100%" @selection-change="selectRow">
            <el-table-column type="selection" width="45" align="center"/>
            <el-table-column label="项目" align="center">
              <template slot-scope="scope">
                <el-input v-model="scope.row.projectName" :disabled="accumulationFundDisabled"/>
              </template>
            </el-table-column>
            <el-table-column label="默认基数">
              <template slot-scope="scope">
                <el-input v-model="scope.row.defaultCardinalNumber" :disabled="accumulationFundDisabled"/>
              </template>
            </el-table-column>
            <el-table-column label="可选基数范围起">
              <template slot-scope="scope">
                <el-input v-model="scope.row.optionalBaseStart" :disabled="accumulationFundDisabled"/>
              </template>
            </el-table-column>
            <el-table-column label="可选基数范围止">
              <template slot-scope="scope">
                <el-input v-model="scope.row.optionalBaseEnd" :disabled="accumulationFundDisabled"/>
              </template>
            </el-table-column>
            <el-table-column label="公司缴纳比例">
              <template slot-scope="scope">
                <el-input v-model="scope.row.corporateContributionRatio" :disabled="accumulationFundDisabled"/>
              </template>
            </el-table-column>
            <el-table-column label="个人缴纳比例">
              <template slot-scope="scope">
                <el-input v-model="scope.row.individualContributionRatio" :disabled="accumulationFundDisabled"/>
              </template>
            </el-table-column>
            <el-table-column label="公司金额" style="background: #666666">
              <template slot-scope="scope">
                {{ getProvidentFundCompanyAmount(scope.row) }}
              </template>
            </el-table-column>
            <el-table-column label="个人金额">
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

    <template v-if="insuranceCityFormVisible">
      <el-dialog :visible.sync="insuranceCityFormVisible" title="参保城市" width="700px">
        <div class="linkage">
          <el-select
            v-model="sheng"
            placeholder="省级地区"
            @change="choseProvince">
            <el-option
              v-for="item in province"
              :key="item.id"
              :label="item.value"
              :value="item.id"/>
          </el-select>
          <el-select
            v-model="shi"
            placeholder="市级地区"
            @change="choseCity">
            <el-option
              v-for="item in shi1"
              :key="item.id"
              :label="item.value"
              :value="item.id"/>
          </el-select>
          <!--          <el-select-->
          <!--            v-model="qu"-->
          <!--            @change="choseBlock"-->
          <!--            placeholder="区级地区">-->
          <!--            <el-option-->
          <!--              v-for="item in qu1"-->
          <!--              :key="item.id"-->
          <!--              :label="item.value"-->
          <!--              :value="item.id">-->
          <!--            </el-option>-->
          <!--          </el-select>-->
        </div>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button type="primary" @click="insuranceCitySubmit">确定</el-button>
          <el-button @click="handleCancleInsuranceCityFormVisible">取消</el-button>
        </div>
      </el-dialog>
    </template>

  </div>
</template>
<script>
import {
  api, getJson
} from '@/api/hr/common'

export default {
  data() {
    return {
      accumulationFundDisabled: false,
      checked: false,
      insuranceCityKeyArr: {
        sheng: '',
        shi: '',
        qu: ''
      },
      insuranceCityKeyArrName: {
        sheng: '',
        shi: '',
        qu: ''
      },
      insuranceCityFormVisible: false,
      province: '',
      sheng: '',
      shi: '',
      shi1: [],
      qu: '',
      qu1: [],
      city: '',
      block: '',
      addInsuranceData: {
        insuredCityName: '',
        insuredCityId: '',
        schemeName: '',
        tableData: [],
        socialSecurityTableData: []
      },
      templateName: '',
      isDisabled: false,
      selectSocialSecuritylistRow: [],
      commitSocialSecurityRows: [],
      socialSecurityRowIndex: 6,
      selectlistRow: [],
      commitRows: {},
      rowIndex: 2,
      rules: {
        assessmentName: [{ required: true, message: '请输考核名称', trigger: 'blur' }],
        templateId: [{ required: true, message: '请选择考核模板', trigger: 'change' }],
        // assessmentTime: [{ required: true, message: '请选择考核时间', trigger: 'change' }],
        assessmentObject: [{ required: true, message: '请选择考核对象', trigger: 'change' }],
        assessmentPeople: [{ required: true, message: '请选择考核人', trigger: 'change' }]
      }
    }
  },
  computed: {
    getProvidentFundCompanyAmount(row) {
      return function(row) {
        return parseInt(row.defaultCardinalNumber) * parseInt(row.corporateContributionRatio) / 100
      }
    },
    getProvidentFundPersonalAmount(row) {
      return function(row) {
        return parseInt(row.defaultCardinalNumber) * parseInt(row.individualContributionRatio) / 100
      }
    },
    getSocialSecurityCompanyAmount(row) {
      return function(row) {
        return parseInt(row.defaultCardinalNumber) * parseInt(row.corporateContributionRatio) / 100
      }
    },
    getSocialSecurityPersonalAmount(row) {
      return function(row) {
        return parseInt(row.defaultCardinalNumber) * parseInt(row.individualContributionRatio) / 100
      }
    },
    companyAccumulationFundCom: function() { // 公司公积金总计
      let companyAccumulationFund = 0
      if (this.accumulationFundDisabled === false) {
        if (this.addInsuranceData.tableData.length > 0) {
          this.addInsuranceData.tableData.forEach((v, i) => {
            companyAccumulationFund = companyAccumulationFund + parseInt(v.defaultCardinalNumber) * parseInt(v.corporateContributionRatio) / 100
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
            personalAccumulationFund = personalAccumulationFund + parseInt(v.defaultCardinalNumber) * parseInt(v.individualContributionRatio) / 100
          })
        }
      }
      return personalAccumulationFund
    },
    companySocialSecurityCom: function() {
      let companySocialSecurity = 0
      if (this.addInsuranceData.socialSecurityTableData.length > 0) {
        this.addInsuranceData.socialSecurityTableData.forEach((v, i) => {
          companySocialSecurity = companySocialSecurity + parseInt(v.defaultCardinalNumber) * parseInt(v.corporateContributionRatio) / 100
        })
      }
      return companySocialSecurity
    },
    personalSocialSecurityCom: function() {
      let personalSocialSecurity = 0
      if (this.addInsuranceData.socialSecurityTableData.length > 0) {
        this.addInsuranceData.socialSecurityTableData.forEach((v, i) => {
          personalSocialSecurity = personalSocialSecurity + parseInt(v.defaultCardinalNumber) * parseInt(v.individualContributionRatio) / 100
        })
      }
      return personalSocialSecurity
    }

  },
  created: function() {
    this.getCityData()
  },
  mounted() {
    this.initList()
  },
  methods: {
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
    // 加载china地点数据，三级
    getCityData() {
      const that = this
      const data = getJson()
      that.province = []
      that.city = []
      that.block = []
      // 省市区数据分类
      for (const item in data) {
        if (item.match(/0000$/)) { // 省
          that.province.push({ id: item, value: data[item], children: [] })
        } else if (item.match(/00$/)) { // 市
          that.city.push({ id: item, value: data[item], children: [] })
        } else { // 区
          that.block.push({ id: item, value: data[item] })
        }
      }
      // 分类市级
      for (const index in that.province) {
        for (var index1 in that.city) {
          if (that.province[index].id.slice(0, 2) === that.city[index1].id.slice(0, 2)) {
            that.province[index].children.push(that.city[index1])
          }
        }
      }
      // 分类区级
      for (const item1 in that.city) {
        for (var item2 in that.block) {
          if (that.block[item2].id.slice(0, 4) === that.city[item1].id.slice(0, 4)) {
            that.city[item1].children.push(that.block[item2])
          }
        }
      }
    },
    // 选省
    choseProvince(e) {
      this.insuranceCityKeyArr.sheng = e
      for (const index2 in this.province) {
        if (e === this.province[index2].id) {
          this.insuranceCityKeyArrName.sheng = this.province[index2].value
          this.shi1 = this.province[index2].children
          this.shi = this.province[index2].children[0].value
          // 设置地市默认值
          this.insuranceCityKeyArr.shi = this.province[index2].children[0].id
          this.insuranceCityKeyArrName.shi = this.province[index2].children[0].value

          this.qu1 = this.province[index2].children[0].children
          this.qu = this.province[index2].children[0].children[0].value
          // 设置区默认值
          this.insuranceCityKeyArr.qu = this.province[index2].children[0].children[0].id
          this.insuranceCityKeyArrName.qu = this.province[index2].children[0].children[0].value

          this.E = this.qu1[0].id
        }
      }
    },
    // 选市
    choseCity(e) {
      this.insuranceCityKeyArr.shi = e
      // for (var index3 in this.city) {
      //   if (e === this.city[index3].id) {
      //     this.insuranceCityKeyArrName.shi = this.city[index3].value
      //     this.qu1 = this.city[index3].children
      //     this.qu = this.city[index3].children[0].value
      //     this.insuranceCityKeyArrName.qu = this.city[index3].children[0].value
      //     this.E = this.qu1[0].id
      //   }
      // }
    },
    // 选区
    choseBlock(e) {
      this.insuranceCityKeyArr.qu = e
      for (const index4 in this.city) {
        if (e === this.qu1[index4].id) {
          this.insuranceCityKeyArrName.qu = this.qu1[index4].value
        }
      }
      this.E = e
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
      let flag = true
      if (this.addInsuranceData.insuredCityId === '') {
        this.$message.error('请填写要参保的城市')
        flag = false
        return
      }
      if (this.addInsuranceData.schemeName === '') {
        this.$message.error('请填写参保名称')
        flag = false
        return
      }
      if (this.addInsuranceData.socialSecurityTableData.length < 1) {
        this.$message.error('至少填写一项社保项目')
        flag = false
        return
      }
      if (this.addInsuranceData.socialSecurityTableData.length > 0) {
        this.addInsuranceData.socialSecurityTableData.forEach((v, i) => {
          if (v.defaultCardinalNumber === '') {
            flag = false
          }
        })
        if (!flag) {
          this.$message.error('社保默认基数为必填项，请检查')
          return
        }
      }
      if (this.addInsuranceData.tableData.length > 0 && this.accumulationFundDisabled === false) {
        this.addInsuranceData.tableData.forEach((v, i) => {
          if (v.defaultCardinalNumber === '') {
            flag = false
          }
        })
        if (!flag) {
          this.$message.error('公积金默认基数为必填项，请检查')
          return
        }
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
      if (this.addInsuranceData.insuredCityId === '') {
        this.$message.error('请填写要参保的城市')
        flag = false
        return
      }
      if (this.addInsuranceData.schemeName === '') {
        this.$message.error('请填写参保名称')
        flag = false
        return
      }
      if (this.addInsuranceData.socialSecurityTableData.length < 1) {
        this.$message.error('至少填写一项社保项目')
        flag = false
        return
      }
      if (this.addInsuranceData.socialSecurityTableData.length > 0) {
        this.addInsuranceData.socialSecurityTableData.forEach((v, i) => {
          if (v.defaultCardinalNumber === '') {
            flag = false
          }
        })
        if (!flag) {
          this.$message.error('社保默认基数为必填项，请检查')
          return
        }
      }
      if (this.addInsuranceData.tableData.length > 0 && this.accumulationFundDisabled === false) {
        this.addInsuranceData.tableData.forEach((v, i) => {
          if (v.defaultCardinalNumber === '') {
            flag = false
          }
        })
        if (!flag) {
          this.$message.error('公积金默认基数为必填项，请检查')
          return
        }
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

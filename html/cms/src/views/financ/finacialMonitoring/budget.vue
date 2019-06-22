<template>
  <div class="budget">
    <el-radio-group v-model="status" style="margin-bottom: 20px;">
      <el-radio-button label="1">预算录入</el-radio-button>
      <el-radio-button label="2">预算录入历史查看</el-radio-button>
    </el-radio-group>
    <div class="queryCondition">
      <el-form :inline="true" :model="listQuery">
        <div class="queryCondition-top">
          <el-form-item label="财务类型:">
            <el-select v-model="listQuery.financeTypeId" placeholder="请选择" clearable >
              <el-option v-for="item in financeTypeOptions" :key="item.id" :label="item.financeName" :value="item.id" />
            </el-select>
          </el-form-item>
          <el-form-item label="部门:">
            <el-select v-model="listQuery.departmentId" placeholder="请选择" clearable >
              <el-option v-for="item in departmentOptions" :key="item.departmentId" :label="item.departmentName" :value="item.departmentId" />
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button v-show="status==='1'" type="primary" @click="startYear">年初预算导入</el-button>
          <el-button v-show="status==='1'" type="primary" @click="temporary ">临时预算导入</el-button></el-form-item>
        </div>
        <div class="queryCondition-top">
          <el-form-item label="数据月份:" class="budgetWidth">
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
          <el-form-item v-show="status==='2'" label="录入类型:" style="margin-left:-169px;">
            <el-select v-model="listQuery.budgetType" placeholder="请选择" clearable >
              <el-option v-for="item in budgetTypeOptions" :key="item.id" :label="item.value" :value="item.id" />
            </el-select>
          </el-form-item>
        <el-button type="primary" style="float:right;margin-right:10px;height:40px;" icon="el-icon-search" @click="handleFilter">查询</el-button></div>
      </el-form>
    </div>
    <!-- 表格 -->
    <el-table :data="budgetList" :default-sort = "{ order: 'descending'}" border fit highlight-current-row style="width: 100%;">
      <el-table-column label="序列" type="index" align="center" width="60"/>
      <el-table-column label="财务类型" prop="costTypeName" align="center" />
      <el-table-column v-for="(item, index) in tableHeader" :key="index" :label="item" prop="budgetMoneyModels" align="center" min-width="100">
        <template slot-scope="scope">
          <span>￥{{ scope.row.budgetMoneyModels[index].money }}元</span>
        </template>
      </el-table-column>
      <el-table-column v-if="isShow" label="录入时间" prop="createdTime" min-width="120" sortable align="center"/>
      <el-table-column v-if="isShow" label="录入类型" prop="budgetTypeName" align="center"/>
      <el-table-column label="部门" prop="departmentName" align="center"/>
    </el-table>
    <!-- 点击导入按钮的弹框 -->
    <template v-if="dialogVisible">
      <el-dialog :visible.sync="dialogVisible" title="导入" width="400px" >
        <div style="display:flex;justify-content: space-between;" class="demo">
          <el-button type="success" @click="submit($event)">{{ softtype }}</el-button>
          <a class="download" href="/static/file/budgetTemplate.xlsx" download >下载模板</a>
          <!-- <a class="download" href="javascript:;" @click="download" >下载模板</a> -->
        </div>
        <div>
          <p>注意:</p>
          <p>1:年初预算，只能够导入一次</p>
          <p>2:请先导出模板，并按照模板填入批量数据，保存后点击上传即可</p>
        </div>
        <div>
          <input type="file" @change="getFile($event)">
        </div>
      </el-dialog>
    </template>
    <template v-if=" selectDepartmentdialogVisible">
      <el-dialog :visible.sync="selectDepartmentdialogVisible" title="选择部门" width="400px">
        <el-form label-width="100px" class="demo-ruleForm">
          <el-form-item label="部门:" >
            <el-select v-model="departmentId" placeholder="请选择部门" @change="changeDepartment">
              <el-option v-for="item in departmentOptions" :key="item.departmentId" :label="item.departmentName" :value="item.departmentId" />
            </el-select>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="selectDepartment">确 定</el-button>
          <el-button @click="selectDepartmentdialogVisible = false">取 消</el-button>
        </span>
      </el-dialog>
    </template>
  </div>
</template>

<script>
// import global from '@/api/global'
import {
  api, Inventor
} from '@/api/axios'
export default {
  data() {
    return {
      // depOptions: [],
      isShow: false,
      softtype: '',
      departmentId: '',
      departmentName: '',
      selectDepartmentdialogVisible: false,
      file: '',
      fileList: [],
      dialogVisible: false,
      moneyData: [],
      tableHeader: [],
      listLoading: false,
      budgetList: [],
      status: '1',
      listQuery: {
        startMonth: '',
        orderByClause: '',
        endMonth: '',
        departmentId: '',
        financeTypeId: '',
        budgetType: ''
      },
      departmentOptions: [],
      financeTypeOptions: [],
      budgetTypeOptions: [
        { id: '0', value: '年初预算' },
        { id: '1', value: '临时预算' }
      ]
    }
  },
  watch: {
    status: function(newVal, oldVal) {
      if (this.status === '2') {
        this.listQuery.budgetType = ''
        this.isShow = true
      } else {
        this.isShow = false
      }
      this.getDate()
      this.listQuery.financeTypeId = ''
      this.listQuery.departmentId = ''
      this.initList()
    }
  },
  mounted() {
    this.getDate()
    this.initList()
    this.getDepartment()
    this.getFinanceType()
  },
  methods: {
    // 获取时间
    getDate() {
      const date = new Date()
      const month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1
      this.listQuery.startMonth = date.getFullYear() + '01'
      this.listQuery.endMonth = (date.getFullYear()).toString() + month.toString()
    },
    // 改变弹框选择的部门
    changeDepartment(value) {
      this.departmentId = value
      this.departmentOptions.forEach(val => {
        if (val.departmentId === value) {
          this.departmentName = val.departmentName
        }
      })
    },
    // 确定选中部门触发
    selectDepartment() {
      if (!this.departmentId) {
        alert('请选择部门')
        return
      }
      this.dialogVisible = true
      this.selectDepartmentdialogVisible = false
      this.file = ''
    },
    getFile: function(event) {
      this.file = event.target.files[0]
    },
    submit: function(event) {
      if (this.file === '' || this.file === undefined) {
        this.$message({
          message: '请先选择文件',
          type: 'error'
        })
        return false
      }
      if (this.file.name.substr(this.file.name.lastIndexOf('.')) !== '.xlsx') {
        this.$message({
          message: '文件格式错误,请选择模板文件',
          type: 'error'
        })
        return false
      }
      const formData = new FormData()
      formData.append('file', this.file)
      // 调用导入文件接口
      Inventor(`${this.GLOBAL.parkUrl}finance/budget/add?budgetType=${this.listQuery.budgetType}&departmentId=${this.departmentId}&departmentName=${this.departmentName}`, formData, 'post')
        .then(res => {
          if (res.data.code === this.GLOBAL.code) {
            this.$message({
              message: '导入成功',
              type: 'success'
            })
            this.dialogVisible = false
          } else {
            this.$message.error('导入失败' + res.data.result)
          }
          this.initList()
        })
    },
    // 临时导入
    temporary() {
      this.softtype = '临时导入'
      this.departmentId = ''
      this.selectDepartmentdialogVisible = true
      this.listQuery.budgetType = '1'
    },
    // 年初预算导入
    startYear() {
      this.softtype = '年初预算导入'
      this.departmentId = ''
      this.selectDepartmentdialogVisible = true
      this.listQuery.budgetType = '0'
    },
    // 初始化页面
    initList() {
      this.listLoading = true
      if (this.status === '1') {
        api(`${this.GLOBAL.parkUrl}finance/budget/selectTotalBudget?costTypeId=${this.listQuery.financeTypeId}&departmentId=${this.listQuery.departmentId}&endMonth=${this.listQuery.endMonth}&startMonth=${this.listQuery.startMonth}&orderByClause=${this.listQuery.orderByClause}`, '', 'get').then(res => {
          if (res.data.code === this.GLOBAL.code) {
            this.tableHeader = res.data.data.dynamicHeadList
            this.budgetList = res.data.data.rows
          } else {
            this.$message.error(res.data.result)
            this.tableHeader = []
            this.budgetList = []
          }
          this.listLoading = false
        })
      } else {
        api(`${this.GLOBAL.parkUrl}finance/budget/selectBudgetHistory?costTypeId=${this.listQuery.financeTypeId}&departmentId=${this.listQuery.departmentId}&endMonth=${this.listQuery.endMonth}&startMonth=${this.listQuery.startMonth}&orderByClause=${this.listQuery.orderByClause}&budgetType=${this.listQuery.budgetType}`, '', 'get').then(res => {
          if (res.data.code === this.GLOBAL.code) {
            this.tableHeader = res.data.data.dynamicHeadList
            this.budgetList = res.data.data.rows
          } else {
            this.$message.error(res.data.result)
            this.tableHeader = []
            this.budgetList = []
          }
          this.listLoading = false
        })
      }
    },
    // 查询数据
    handleFilter() {
      if (this.listQuery.startMonth === '' || this.listQuery.startMonth === undefined) {
        alert('请选择开始日期')
        return false
      } else if (this.listQuery.endMonth === '' || this.listQuery.endMonth === undefined) {
        alert('请选择结束日期')
        return false
      }
      this.initList()
    },
    // 获取部门信息
    getDepartment() {
      api(`${this.GLOBAL.parkUrl}finance/documents/getUserDepartment`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          if (res.data.data) {
            res.data.data.forEach(val => {
              if (val.departmentName === '财务部') {
                api(`${this.GLOBAL.parkUrl}finance/expenses/selectDepartment`, '', 'get').then(res => {
                  if (res.data.code === this.GLOBAL.code) {
                    this.departmentOptions = res.data.data
                  } else {
                    this.$message.error(res.data.result)
                  }
                })
              } else {
                this.departmentOptions = res.data.data
              }
            })
          } else {
            this.departmentOptions = []
          }
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取财务类型
    getFinanceType() {
      api(`${this.GLOBAL.parkUrl}finance/expenses/selectFinanceType`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.financeTypeOptions = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  .queryCondition{
    //   margin-top: 20px;
      .queryCondition-top{
       display: flex;
       justify-content: space-between;
      }
  }
</style>
<style lang="scss">
.download{
      display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    color: rgb(96, 98, 102);
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    font-weight: 500;
    user-select: none;
    font-size: 14px;
    background: rgb(255, 255, 255);
    border-width: 1px;
    border-style: solid;
    border-color: rgb(220, 223, 230);
    border-image: initial;
    outline: none;
    margin: 0px;
    transition: all 0.1s ease 0s;
    padding: 12px 20px;
    border-radius: 4px;
    color: rgb(255, 255, 255);
    background-color: rgb(64, 158, 255);
    border-color: rgb(64, 158, 255);
}
.budgetWidth{
  .el-date-editor.el-input, .el-date-editor.el-input__inner {
    width: 204px;
}
}
.demo> a:hover{
  color:#fff !important;
}
</style>

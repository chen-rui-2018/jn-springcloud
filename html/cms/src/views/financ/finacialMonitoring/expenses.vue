<template>
  <div class="budget">
    <el-radio-group v-model="status" style="margin-bottom: 20px;">
      <el-radio-button label="1">支出录入</el-radio-button>
      <el-radio-button label="2">支出录入历史查看</el-radio-button>
    </el-radio-group>
    <div class="queryCondition">
      <el-form :inline="true" :model="listQuery">
        <div class="queryCondition-top">
          <el-form-item label="数据月份:">
            <el-date-picker
              v-model="listQuery.startTime"
              type="month"
              value-format="yyyyMM"
              placeholder="开始月份"/>
            至
            <el-date-picker
              v-model="listQuery.endTime"
              type="month"
              value-format="yyyyMM"
              placeholder="结束月份"/>
          </el-form-item>
          <el-form-item label="部门:" style="margin-left:20px;">
            <el-select v-model="listQuery.departmentId" placeholder="请选择" clearable >
              <el-option v-for="item in departmentOptions" :key="item.departmentId" :label="item.departmentName" :value="item.departmentId" />
            </el-select>
          </el-form-item>
          <el-form-item v-show="status=='2'" label="费用流水号" prop="costId">
            <el-input v-model="listQuery.costId" clearable/>
          </el-form-item>
          <el-button type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
          <el-button v-show="status==='1'" type="primary" @click="expenses ">支出导入</el-button>
        </div>

      </el-form>
    </div>
    <!-- 表格 -->
    <el-table :data="budgetList" :default-sort = "{prop: 'date', order: 'descending'}" border fit highlight-current-row style="width: 100%;" @sort-change="sortChange">
      <!-- <el-table-column type="selection" align="center" width="60"/> -->
      <el-table-column label="序列" type="index" align="center" width="60"/>
      <el-table-column label="月份" prop="costHappendTime" sortable="custom" align="center" width="100" >
        <template slot-scope="scope">
          <span>{{ scope.row.costHappendTime.slice(0,4)+'年' + scope.row.costHappendTime.slice(4,6)+'月' }}</span>
        </template>
      </el-table-column>
      <el-table-column v-if="isShow" label="费用流水号" prop="costId" align="center" />
      <el-table-column label="支出金额" prop="cost" sortable="custom" align="center" />
      <el-table-column v-if="isShow" label="支出类型(打标前)" prop="costBeforeTypeName" align="center"/>
      <el-table-column label="支出类型(打标后)" prop="costAfterTypeName" align="center"/>
      <el-table-column label="操作日期" prop="modifiedTime" sortable="custom" align="center"/>
      <el-table-column label="部门" prop="departmentName" align="center"/>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      v-show="total>0"
      :current-page="listQuery.page"
      :page-sizes="[10,20,30, 50]"
      :page-size="listQuery.rows"
      :total="total"
      class="tablePagination"
      background
      layout="total, sizes, prev, pager, next, jumper"
      style="margin-top:15px;"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />
    <!-- 点击导入按钮的弹框 -->
    <template v-if="dialogVisible">
      <el-dialog :visible.sync="dialogVisible" title="导入" class="daoru" >
        <div style="display:flex;justify-content: space-between;" class="demo">
          <el-button :disabled="disabled" type="success" @click="submit($event)">{{ softtype }}</el-button>
          <a href="/static/file/expendTemplate.xlsx" class="download" download >下载模板</a>
        </div>
        <div>
          <p>注意:</p>
          <p>请先导出模板，并按照模板填入批量数据，保存后点击上传即可</p>
        </div>
        <div>
          <input type="file" @change="getFile($event)">
        </div>
      </el-dialog>
    </template>
    <!-- 导入之后的表格弹框 -->
    <template v-if="markingDialogVisible">
      <el-dialog :visible.sync="markingDialogVisible" class="dabiao" >
        <el-table ref="multipleTable" :data="newArr" border fit highlight-current-row style="width: 100%;" @selection-change="handleSelectionChange">
          <el-table-column type="selection" align="center" width="60"/>
          <el-table-column label="序列" type="index" align="center" width="60"/>
          <el-table-column label="月份" prop="costHappendTime" align="center" width="100" >
            <template slot-scope="scope">
              <span>{{ scope.row.costHappendTime.slice(0,4)+'年' + scope.row.costHappendTime.slice(4,6)+'月' }}</span>
            </template>
          </el-table-column>
          <el-table-column label="费用流水号" prop="costId" align="center" />
          <el-table-column label="支出金额" prop="cost" align="center" />
          <el-table-column label="支出类型(打标前)" prop="costBeforeTypeName" align="center"/>
          <el-table-column label="支出类型(打标后)" prop="costAfterTypeName" align="center" min-width="120">
            <template slot-scope="scope">
              <!-- <span :class="scope.row.costAfterTypeName ? 'text-green' : 'text-red'">{{ scope.row.costAfterTypeName?scope.row.costAfterTypeName:'未打标' }}</span> -->
              <el-select v-model="scope.row.costAfterTypeId" placeholder="未打标" @change="changecostAfterTypeId">
                <el-option v-for="item in markOptions" :key="item.id" :label="item.financeName" :value="item.id" />
              </el-select>

            </template>
          </el-table-column>
          <el-table-column label="部门" prop="departmentName" align="center"/>
          <!-- <el-table-column fit label="操作" align="center">
            <template slot-scope="scope">
              <el-button type="text" @click="handleMark(scope.row)">打标</el-button>
            </template>
          </el-table-column> -->
        </el-table>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="batchMark">批量打标</el-button>
          <el-button :disabled="disabled" type="primary" @click="subMark">提交</el-button>
          <el-button @click="cencalMark">取 消</el-button>
        </span>
      </el-dialog>
    </template>
    <!-- 打标弹框 -->
    <template v-if=" markdialogVisible">
      <el-dialog :visible.sync="markdialogVisible" title="打标类型" width="400px">
        <el-form label-width="100px" class="demo-ruleForm">
          <!-- <el-form-item label="打标前类型:" >
            <span>{{ costBeforeTypeName }}</span>
          </el-form-item> -->
          <el-form-item label="打标后类型:" >
            <el-select v-model="costAfterTypeId" placeholder="请选择类型" @change="changecostAfterTypeId">
              <el-option v-for="item in markOptions" :key="item.id" :label="item.financeName" :value="item.id" />
            </el-select>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="submitMark">确 定</el-button>
          <el-button @click="markdialogVisible=false">取 消</el-button>
        </span>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import {
  api, importBdDeptdoc
} from '@/api/financ'
export default {
  data() {
    return {
      disabled: false,
      multipleSelection: [],
      selectIndex: '',
      newArr: [],
      costAfterTypeId: '',
      costAfterTypeName: '',
      costBeforeTypeName: '',
      markOptions: [],
      markdialogVisible: false,
      isShow: false,
      markList: [],
      markingDialogVisible: false,
      file: '',
      dialogVisible: false,
      softtype: '',
      listLoading: false,
      budgetList: [],
      total: 0,
      status: '1',
      listQuery: {
        // startMonth: '201901',
        orderByClause: '',
        // endMonth: '201904',
        endTime: '',
        startTime: '',
        rows: 10,
        page: 1,
        costId: '',
        departmentId: '',
        financeTypeId: ''
      },
      departmentOptions: [],
      financeTypeOptions: []
    }
  },
  watch: {
    status: function(newVal, oldVal) {
      if (this.status === '2') {
        this.isShow = true
      } else {
        this.isShow = false
      }
      this.listQuery.financeTypeId = ''
      this.listQuery.departmentId = ''
      this.getDate()
      this.initList()
      this.listQuery.costId = ''
    }
  },
  mounted() {
    this.getDate()
    this.initList()
    this.getDepartment()
  },
  methods: {
    // 下载模板文件
    // download() {
    //   window.location.href = '/static/file/支出录入.xlsx'
    // },
    // 批量打标
    batchMark() {
      if (this.multipleSelection.length === 0) {
        alert('请先选择数据')
        return false
      }
      this.$confirm(`此操作将对这几条数据进行同样的打标操作, 是否继续?`, '打标提示', {
        cancelButtonText: '取消',
        confirmButtonText: '确定',
        type: 'warning'
      })
        .then(() => {
          this.markdialogVisible = true
          // this.costBeforeTypeName = row.costBeforeTypeName
          // if (row.costAfterTypeId) {
          //   this.costAfterTypeId = row.costAfterTypeId
          //   this.costAfterTypeName = row.costAfterTypeName
          // } else {
          this.costAfterTypeId = ''
          this.costAfterTypeName = ''
          // }
          // this.selectIndex = this.multipleSelection.indexNum
          this.getFinanceType()
        })
        .catch(() => {
        })
    },
    // 获取选中的数据
    handleSelectionChange(val) {
      this.multipleSelection = val
    },
    // 取消打标
    cencalMark() {
      this.newArr = []
      this.markingDialogVisible = false
    },
    // 获取时间
    getDate() {
      const date = new Date()
      const month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1
      this.listQuery.startTime = date.getFullYear() + '01'
      this.listQuery.endTime = (date.getFullYear()).toString() + month.toString()
    },
    // 全部打标后提交
    subMark() {
      this.disabled = true
      for (let i = 0; i < this.newArr.length; i++) {
        if (!this.newArr[i].costAfterTypeId) {
          alert('请对所有数据进行打标后在提交')
          this.disabled = false
          return
        }
      }
      api('finance/expenses/saveMarkData', this.newArr, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.$message({
            message: '导入成功',
            type: 'success'
          })
          this.markingDialogVisible = false
          this.newArr = []
          this.initList()
        } else {
          this.$message.error('导入失败' + res.data.result)
        }
        this.disabled = false
      })
    },
    // 改变弹框选择的打标类型
    changecostAfterTypeId(value) {
      this.costAfterTypeId = value
      this.markOptions.forEach(val => {
        if (val.id === value) {
          this.costAfterTypeName = val.financeName
        }
      })
    },
    // 确定打标
    submitMark() {
      if (!this.costAfterTypeId) {
        alert('请选择类型')
        return
      }
      this.multipleSelection.forEach(val => {
        val.costAfterTypeId = this.costAfterTypeId
        val.costAfterTypeName = this.costAfterTypeName
      })
      // this.newArr[this.selectIndex].costAfterTypeId = this.costAfterTypeId
      // this.newArr[this.selectIndex].costAfterTypeName = this.costAfterTypeName
      this.$refs.multipleTable.clearSelection()
      this.markdialogVisible = false
    },
    // 获取财务类型
    getFinanceType() {
      api('finance/expenses/selectFinanceType', '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.markOptions = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
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
      this.listLoading = true
      this.newArr = []
      const formData = new FormData()
      formData.append('file', this.file)
      // 调用导入文件接口
      importBdDeptdoc(`finance/expenses/importData`, formData, 'post')
        .then(res => {
          if (res.data.code === this.GLOBAL.code) {
            this.dialogVisible = false
            this.markingDialogVisible = true
            this.markList = res.data.data
            this.markList.forEach((val, index) => {
              this.newArr.push(
                Object.assign({}, val, { indexNum: index })
              )
            })
            this.getFinanceType()
          } else {
            this.$message.error('导入失败,' + res.data.result)
          }
          this.listLoading = false
          this.disabled = false
          // this.initList()
        })
    },
    // 支出导入
    expenses() {
      this.softtype = '支出导入'
      this.file = ''
      this.dialogVisible = true
    },
    // 获取排序字段
    sortChange: function(column, prop, order) {
      if (column.prop !== null) {
        if (column.order === 'descending') {
          this.listQuery.orderByClause = column.prop + ' ' + column.order.slice(0, 4)
        } else {
          this.listQuery.orderByClause = column.prop + ' ' + column.order.slice(0, 3)
        }
        this.initList()
      }
    },
    // 初始化页面
    initList() {
      this.listLoading = true
      if (this.status === '1') {
        this.getTableData('finance/expenses/findAll')
      } else {
        this.getTableData('finance/expenses/findHistoryAll')
      }
    },
    // 获取表格数据
    getTableData(url) {
      api(`${url}?departmentId=${this.listQuery.departmentId}&&orderByClause=${this.listQuery.orderByClause}&page=${this.listQuery.page}&costId=${this.listQuery.costId}&rows=${this.listQuery.rows}&startTime=${this.listQuery.startTime}&endTime=${this.listQuery.endTime}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.budgetList = res.data.data.rows
          this.total = res.data.data.total
          // this.listQuery.costId = ''
          if (this.budgetList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
          this.tableHeader = []
          this.budgetList = []
          this.total = 0
        }
        this.listLoading = false
      })
    },
    // 查询数据
    handleFilter() {
      if (this.listQuery.startMonth === '' || this.listQuery.startMonth === null) {
        alert('请选择开始日期')
        return false
      } else if (this.listQuery.endMonth === '' || this.listQuery.endMonth === null) {
        alert('请选择结束日期')
        return false
      }
      this.listQuery.page = 1
      this.initList()
    },
    // 分页数更改
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    },
    // 获取部门信息
    getDepartment() {
      api('finance/expenses/selectDepartment', '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.departmentOptions = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss">
//   .queryCondition{
//     //   margin-top: 20px;
//       .queryCondition-top{
//        display: flex;
//        justify-content: space-between;
//       }
//   }
.daoru{
  .el-dialog{
    width: 400px;
  }
}
.dabiao{
.el-dialog{
    width: 1000px;
    height: 500px ;
    overflow: auto;
    .el-dialog__header{
      display: none;
      button{
        display: none;
      }
    }
  }
}
</style>

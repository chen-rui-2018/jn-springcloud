<template>
  <div class="scheduDetail">

    <el-form :model="listQuery" :inline="true" class="info-form">
      <el-form-item label="日期:" lable-position="right" label-width="80px">

        <el-date-picker
          v-model="listQuery.schedulMonth"
          type="month"
          placeholder="选择开始日期："
          format="yyyyMM"
          value-format="yyyyMM"
          style="width: 200px"
          clearable
          disabled/>

      </el-form-item>

      <el-form-item label="部门:" lable-position="right" label-width="80px">
        <el-select
          v-model="listQuery.departmentId"
          placeholder="请选择"
          clearable
          style="width: 200px"
          class="filter-item">
          <el-option label="请选择" value=""/>
          <el-option
            v-for="item in departmentList"
            :key="item.departmentId"
            :label="item.departmentName"
            :value="item.departmentId"/>
        </el-select>
      </el-form-item>

      <el-form-item label="姓名:" lable-position="right" label-width="80px">
        <el-input
          v-model.trim="listQuery.name"
          maxlength="200"
          style="width: 200px"
          placeholder=""
          clearable/>
      </el-form-item>

      <div class="btn-group">
        <el-form-item class="form-btn">
          <el-button class="filter-item" type="primary" @click="handleFilter">查询</el-button>
          <el-button class="filter-item" type="primary" @click="exportExcel">导出</el-button>
          <el-button :disabled="listQuery.schedulMonth<nextMonth" class="filter-item" type="primary" @click="update">修改</el-button>
          <el-button :disabled="!canSave" class="filter-item" type="primary" @click="save">保存</el-button>
          <el-button class="filter-item" type="primary" @click="cancel">取消</el-button>
        </el-form-item>
      </div>
    </el-form>

    <!-- 表格 -->
    <el-table
      v-loading="listLoading"
      ref="multipleTable"
      :data="scheduDetailist"
      border
      fit
      highlight-current-row
      style="width: 100%;height:100%;"
      class="selecttable"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55"/>
      <el-table-column type="index" width="60" label="序号" align="center"/>
      <el-table-column label="部门" align="center" width="200">
        <template slot-scope="scope">
          <el-select
            v-if="!scope.row.disabled"
            v-model="scope.row.departmentId"
            :disabled="scope.row.disabled"
            placeholder="请选择"
            clearable
            class="filter-item"
            @change="setDepartMentName(scope.row,scope.$index)">
            <el-option label="请选择" value=""/>
            <el-option
              v-for="item in departmentList"
              :key="item.departmentId"
              :label="item.departmentName"
              :value="item.departmentId"/>
          </el-select>
          <span v-else>{{ scope.row.departmentName }}</span>
        </template>
      </el-table-column>

      <el-table-column label="姓名" align="center" prop="name" width="150">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.name"
            :disabled="scope.row.disabled"
            maxlength="100"
            placeholder="请输入姓名"
            clearable />
          <span v-else>{{ scope.row.name }}</span>
        </template>
      </el-table-column>

      <el-table-column label="1号" align="center" prop="number1">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number1"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number1 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="2号" align="center" prop="number2">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number2"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number2 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="3号" align="center" prop="number3">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number3"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number3 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="4号" align="center" prop="number4">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number4"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number4 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="5号" align="center" prop="number5">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number5"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number5 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="6号" align="center" prop="number6">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number6"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number6 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="7号" align="center" prop="number7">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number7"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number7 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="8号" align="center" prop="number8">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number8"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number8 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="9号" align="center" prop="number9">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number9"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number9 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="10号" align="center" prop="number10">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number10"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number10 }}</span>
        </template>
      </el-table-column>

      <el-table-column label="11号" align="center" prop="number11">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number11"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number11 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="12号" align="center" prop="number12">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number12"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number12 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="13号" align="center" prop="number13">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number13"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number13 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="14号" align="center" prop="number14">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number14"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number14 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="15号" align="center" prop="number15">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number15"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number15 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="16号" align="center" prop="number16">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number16"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number16 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="17号" align="center" prop="number17">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number17"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number17 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="18号" align="center" prop="number18">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number18"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number18 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="19号" align="center" prop="number19">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number19"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number19 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="20号" align="center" prop="number20">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number20"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number20 }}</span>
        </template>
      </el-table-column>

      <el-table-column label="21号" align="center" prop="number21">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number21"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number21 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="22号" align="center" prop="number22">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number22"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number22 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="23号" align="center" prop="number23">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number23"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number23 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="24号" align="center" prop="number24">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number24"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number24 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="25号" align="center" prop="number25">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number25"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number25 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="26号" align="center" prop="number26">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number26"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number26 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="27号" align="center" prop="number27">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number27"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number27 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="28号" align="center" prop="number28">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number28"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number28 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="29号" align="center" prop="number29">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number29"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number29 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="30号" align="center" prop="number30">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number30"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number30 }}</span>
        </template>
      </el-table-column>

      <el-table-column label="31号" align="center" prop="number31">
        <template slot-scope="scope">
          <el-input
            v-if="!scope.row.disabled"
            v-model.trim="scope.row.number31"
            :disabled="scope.row.disabled"
            maxlength="50"
            placeholder=""
            onkeypress="return event.keyCode>=48&&event.keyCode<=49" />
          <span v-else>{{ scope.row.number31 }}</span>
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
      @current-change="handleCurrentChange"/>

    <div class="bf-tip">
      <p>注：</p>
      <p>0：休息日</p>
      <p>1：日常考勤 09:00-17:00</p>
    </div>

  </div>
</template>

<script>

import {
  scheduDetailist, exportScheduDetailist, updateScheduDetailist
} from '@/api/hr/attendance'

import {
  getTreeList
} from '@/api/hr/employeeBasicInfo'

import moment from 'moment'

export default {
  data() {
    return {
      listQuery: {
        page: 1,
        rows: 10,
        name: '',
        departmentId: '',
        schedulMonth: ''
      },
      total: 0,
      listLoading: false,
      selectRows: [],
      scheduDetailist: [],
      departmentList: [],
      canSave: false,
      nextMonth: ''
    }
  },
  mounted() {
    this.nextMonth = moment().add(1, 'months').startOf('month').format('YYYYMM')
    this.listQuery.schedulMonth = this.$route.query.schedulMonth
    this.initDepartMentList()
    this.initList()
  },
  methods: {
    initList() {
      console.log('排班明细查询')
      this.listLoading = true
      scheduDetailist(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.scheduDetailist = res.data.data.rows
          this.scheduDetailist.forEach(item => {
            Object.assign(item, { disabled: true })
          })
          this.total = res.data.data.total
          if (this.scheduDetailist.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    initDepartMentList() {
      getTreeList().then(res => {
        if (res.data.code === '0000') {
          this.departmentList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    setDepartMentName(row, index) {
      const depart = this.departmentList.find(item => item.departmentId === row.departmentId)
      if (depart) {
        row.departmentName = depart['departmentName']
        this.scheduDetailist.splice(index, 1, row)
      }
    },
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    exportExcel() {
      exportScheduDetailist(this.listQuery).then(res => {
        console.log('导出。。。')
        window.location.href = res.request.responseURL
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
    handleSelectionChange(row) {
      console.log('select row', row)
      this.selectRows = row
    },
    update() {
      if (this.selectRows.length === 0) {
        this.$message.error('请至少选择一条记录')
        return
      }
      this.canSave = true
      this.scheduDetailist.forEach((item, index) => {
        if (this.selectRows) {
          if (this.selectRows.find(row => row.jobNumber === item.jobNumber)) {
            item.disabled = false
          } else {
            item.disabled = true
          }
        } else {
          item.disabled = true
        }
        this.scheduDetailist.splice(index, 1, item)
      })
    },
    save() {
      if (this.selectRows.length === 0) {
        this.$message.error('请至少选择一条记录')
        return
      }
      const array = this.scheduDetailist.filter(item => {
        return this.selectRows.find(row => row.jobNumber === item.jobNumber)
      })
      const flag = array.some(item => {
        if (item.departmentId === '') {
          return false
        }
        if (item.name === '') {
          return false
        }
        return true
      })
      if (!flag) {
        this.$message.error('必填参数为空或参数输入不合法')
        return
      }

      updateScheduDetailist({ 'attendanceSchedulList': array }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '修改成功',
            type: 'success'
          })
          this.initList()
          this.canSave = false
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    cancel() {
      this.$router.push({ name: 'schedulist' })
    }
  }
}
</script>

<style lang="scss" scoped>
  .scheduDetail .btn-group {
    float: right;
    margin-right: 20px;
  }

  .scheduDetail .bf-tip {
    margin-top: 20px;
    border:1px solid black;
    color:red;
  }
  .scheduDetail .bf-tip p{
    padding-left: 20px;
  }
  .selecttable /deep/ .el-table__body-wrapper{
    min-height: 200px;
  }
  input::-webkit-outer-spin-button,
  input::-webkit-inner-spin-button {
    -webkit-appearance: none;
  }
  input[type="number"]{
    -moz-appearance: textfield;
  }
</style>

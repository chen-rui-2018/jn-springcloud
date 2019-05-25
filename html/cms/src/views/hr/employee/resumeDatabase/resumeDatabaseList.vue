<template>
  <div class="resumeDatabaseList">
    <el-form :model="listQuery" class="info-form">
      <el-form-item label="学历:" lable-position="right" label-width="129px">
        <el-button-group>
          <el-button :type="listQuery.educationId==''?'primary':''" @click="setEducationId('')">全部</el-button>
          <el-button
            v-for="item in educationList"
            :type="listQuery.educationId==item.key?'primary':''"
            :key="item.key"
            @click="setEducationId(item.key)">{{ item.lable }}
          </el-button>
        </el-button-group>
      </el-form-item>

      <el-form-item label="应聘结果:" lable-position="right" label-width="129px">
        <el-button-group>
          <el-button :type="listQuery.applicationResult==''?'primary':''" @click="setApplicationResult('')">全部
          </el-button>
          <el-button :type="listQuery.applicationResult=='1'?'primary':''" @click="setApplicationResult('1')">通过
          </el-button>
          <el-button :type="listQuery.applicationResult=='3'?'primary':''" @click="setApplicationResult('3')">等待结果
          </el-button>
          <el-button :type="listQuery.applicationResult=='2'?'primary':''" @click="setApplicationResult('2')">淘汰
          </el-button>
        </el-button-group>
      </el-form-item>

      <el-form-item label="是否完成背景调查:" lable-position="right" label-width="129px">
        <el-button-group>
          <el-button :type="listQuery.isBackgroundInvest==''?'primary':''" @click="setIsBackgroundInvest('')">全部
          </el-button>
          <el-button :type="listQuery.isBackgroundInvest=='1'?'primary':''" @click="setIsBackgroundInvest('1')">是
          </el-button>
          <el-button :type="listQuery.isBackgroundInvest=='2'?'primary':''" @click="setIsBackgroundInvest('2')">否
          </el-button>
        </el-button-group>
      </el-form-item>
      <el-form-item>
        <el-button class="filter-item" type="primary" @click="add">新增</el-button>
        <el-button class="filter-item" type="primary" @click="importExcel">导入</el-button>
        <el-button class="filter-item" type="primary" @click="exportExcel">导出</el-button>
        <el-button class="filter-item" type="primary" @click="handleFilter">查询</el-button>
        <el-input
          v-model="listQuery.name"
          maxlength="20"
          style="width:200px;float:right;margin-right:10px;"
          placeholder="请输入姓名"
          class="filter-item"
          clearable
          @keyup.enter.native="handleFilter"/>
      </el-form-item>

    </el-form>
    <!-- 表格 -->
    <el-table
      v-loading="listLoading"
      ref="multipleTable"
      :data="resumeDatabaseList"
      border
      fit
      highlight-current-row
      style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center"/>
      <el-table-column label="姓名" align="center" prop="name"/>
      <el-table-column label="性别" align="center" prop="sexStr"/>
      <el-table-column label="手机号码" align="center" prop="phone"/>
      <el-table-column label="个人邮箱" align="center" prop="mailbox"/>
      <el-table-column label="应聘部门" align="center" prop="departmentName"/>
      <el-table-column label="应聘职位" align="center" prop="jobName"/>
      <el-table-column label="证件类型" align="center" prop="certificateType"/>
      <el-table-column label="证件号" align="center" prop="certificateNumber"/>
      <el-table-column label="学历" align="center" prop="educationName"/>
      <el-table-column label="毕业院校" align="center" prop="graduaAcademy"/>
      <el-table-column label="简历信息" align="center" prop="resumeInfo">
        <template slot-scope="scope">
          <el-button v-if="scope.row.resumeInfo" type="text" @click="downloadResumeDatabase(scope.row)">下载</el-button>
        </template>
      </el-table-column>
      <el-table-column label="是否完成背景调查" align="center" prop="isBackgroundInvestStr">
        <template slot-scope="scope">
          <span :class="scope.row.isBackgroundInvest==1 ? 'text-green' : 'text-red'">{{ scope.row.isBackgroundInvestStr }}</span>
          <el-button v-if="scope.row.isBackgroundInvest==2" type="text" @click="completeBackgroundShow(scope.row.id)">
            去完成
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="应聘结果" align="center" prop="applicationResultStr"/>
      <el-table-column label="操作" align="center" min-width="100" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button v-if="scope.row.applicationResult===3" type="text" @click="pass(scope.row)">通过</el-button>
          <el-button v-if="scope.row.applicationResult===3" type="text" @click="notPass(scope.row)">淘汰</el-button>
          <el-button type="text" @click="update(scope.row)">编辑</el-button>
          <el-button type="text" @click="queryDetail(scope.row)">详情</el-button>
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

    <template v-if="bgFormVisible">
      <el-dialog :visible.sync="bgFormVisible" title="背景调查" width="450px">
        <el-form
          ref="bgForm"
          :rules="rules"
          :model="bgForm"
          label-position="right"
          label-width="130px"
          style="max-width:400px;margin-left:20px">
          <el-form-item label="身份核查:" prop="identityCheck">
            <el-select v-model="bgForm.identityCheck" placeholder="请选择" style="width: 200px">
              <el-option label="请选择" value=""/>
              <el-option label="核查属实" value="1"/>
              <el-option label="核查不属实" value="2"/>
            </el-select>
          </el-form-item>
          <el-form-item label="学历核查:" prop="educationCheck">
            <el-select v-model="bgForm.educationCheck" placeholder="请选择" style="width: 200px">
              <el-option label="请选择" value=""/>
              <el-option label="核查属实" value="1"/>
              <el-option label="核查不属实" value="2"/>
            </el-select>
          </el-form-item>
          <el-form-item label="上家公司名称:" prop="corporateName">
            <el-input
              v-model.trim="bgForm.corporateName"
              maxlength="200"
              style="width: 200px"
              placeholder="请输入上家公司名称"
              clearable/>
          </el-form-item>
          <el-form-item label="上家公司职位:" prop="corporateJob">
            <el-input
              v-model.trim="bgForm.corporateJob"
              maxlength="200"
              style="width: 200px"
              placeholder="请输入上家公司职位"
              clearable/>
          </el-form-item>
          <el-form-item label="上家公司证明人:" prop="companyCertifier">
            <el-input
              v-model.trim="bgForm.companyCertifier"
              maxlength="200"
              style="width: 200px"
              placeholder="请输入上家公司证明人"
              clearable/>
          </el-form-item>
          <!-- <el-form-item label="核查人:" prop="inspectors">
            <el-input v-model.trim="bgForm.inspectors" :rows="2" type="textarea" maxlength="200" clearable/>
          </el-form-item>
          <el-form-item label="核查人联系电话:" prop="inspectorsPhone">
            <el-input
              v-model.trim="bgForm.inspectorsPhone"
              :rows="2"
              type="textarea"
              maxlength="200"
              style="width: 200px"
              placeholder="请输入核查人联系电话"
              clearable/>
          </el-form-item> -->
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button :disabled="isDisabled" type="primary" @click="completeBackground">保存</el-button>
          <el-button @click="cancelBackground">取消</el-button>
        </div>
      </el-dialog>
    </template>

    <file-upload
      :title="'简历库导入'"
      :import-url="importUrl"
      :dialog-visible="dialogImportVisible"
      :template-path="'/static/file/简历库模板.xlsx'"
      :limit="1"
      @uploadSuccess="uploadSuccess"
      @closeDialog="dialogImportVisible=false"/>

  </div>

</template>

<script>
import {
  getResumeDatabaseList, exportResumeDatabase,
  passResumeDatabase, notPassResumeDatabase, finishBackgroundInvest

} from '@/api/hr/resumeDatabase'
import {
  getCode, isvalidName, isvalidMobile, isvalidPhone
} from '@/api/hr/util'

import FileUpload from '@/views/hr/employee/fileUpload'

export default {
  components: {
    FileUpload
  },
  data() {
    var checkName = (rule, value, callback) => {
      if (!isvalidName(value)) {
        callback(new Error('姓名只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }
    // eslint-disable-next-line no-unused-vars
    var validPhone = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入联系电话'))
      } else if (!isvalidPhone(value) && !isvalidMobile(value)) {
        callback(new Error('请输入正确的联系电话'))
      } else {
        callback()
      }
    }
    return {
      importUrl: process.env.BASE_API + 'springcloud-hr/hr/resumeData/importResumeDatabase',
      dialogImportVisible: false,
      isDisabled: false,
      rules: {
        identityCheck: [{ required: true, message: '请选择身份核查', trigger: 'change' }],
        educationCheck: [{ required: true, message: '请选择学历核查', trigger: 'change' }],
        corporateName: [{ required: true, message: '请输入上家公司名称', trigger: 'blur' }, {
          validator: checkName,
          trigger: 'blur'
        }],
        corporateJob: [{ required: true, message: '请输入上家公司职位', trigger: 'blur' }, {
          validator: checkName,
          trigger: 'blur'
        }],
        companyCertifier: [{ required: true, message: '请输入上家公司证明人', trigger: 'blur' },
          { validator: checkName, trigger: 'blur' }]
        // inspectors: [{ required: true, message: '请输入核查人', trigger: 'blur' }, { validator: checkName, trigger: 'blur' }],
        // inspectorsPhone: [{ required: true, message: '请输入核查人联系电话', trigger: 'blur' }, {
        //   validator: validPhone,
        //   trigger: 'blur'
        // }]
      },
      bgFormVisible: false,
      educationList: [],
      resumeDatabaseList: [],
      listLoading: false,
      listQuery: {
        name: '',
        page: 1,
        rows: 10,
        educationId: '',
        applicationResult: '',
        isBackgroundInvest: ''
      },
      total: 0,
      bgForm: {
        id: '',
        identityCheck: '',
        educationCheck: '',
        corporateName: '',
        corporateJob: '',
        companyCertifier: '',
        inspectors: '',
        inspectorsPhone: ''
      }
    }
  },
  mounted() {
    this.initList()
    this.initEducationList()
  },
  methods: {
    uploadSuccess() {
      this.$message({
        message: '导入成功',
        type: 'success'
      })
      this.dialogImportVisible = false
      this.initList()
    },
    importExcel() {
      this.dialogImportVisible = true
    },
    downloadResumeDatabase(row) {
      const fileName = row.resumeInfo.substring(row.resumeInfo.lastIndexOf('.') + 1)
      const link = document.createElement('a')
      link.setAttribute('href', row.resumeInfo)
      link.setAttribute('download', fileName)
      link.style.visibility = 'hidden'
      document.body.appendChild(link)
      link.click()
      document.body.removeChild(link)
    },
    cancelBackground() {
      this.$refs['bgForm'].resetFields()
      this.bgFormVisible = false
    },
    completeBackgroundShow(id) {
      this.bgFormVisible = true
      this.bgForm.id = id
    },
    completeBackground() {
      console.log('完成背景调查')
      this.isDisabled = true
      this.$refs['bgForm'].validate(valid => {
        if (valid) {
          finishBackgroundInvest(this.bgForm).then(
            res => {
              if (res.data.code === '0000') {
                this.$message.success('保存成功')
              } else {
                this.$message.error(res.data.result)
              }
              this.isDisabled = false
              this.$refs['bgForm'].resetFields()
              this.bgFormVisible = false
              this.initList()
            }
          )
        } else {
          this.isDisabled = false
        }
      })
    },
    exportExcel() {
      exportResumeDatabase(this.listQuery).then(res => {
        console.log('导出。。。')
        window.location.href = res.request.responseURL
      })
    },
    add() {
      this.$router.push({ name: 'resumeDatabaseAdd', query: { title: '新增简历库' }})
    },
    update(row) {
      this.$router.push({ name: 'resumeDatabaseUpdate', query: { id: row.id, title: '编辑简历库' }})
    },
    pass(row) {
      console.log('通过' + row)
      passResumeDatabase(row.id).then(
        res => {
          if (res.data.code === '0000') {
            this.$message.success('通过简历成功')
            this.initList()
          } else {
            this.$message.error(res.data.result)
          }
        }
      )
    },
    notPass(row) {
      console.log('不通过' + row)
      notPassResumeDatabase(row.id).then(
        res => {
          if (res.data.code === '0000') {
            this.$message.success('淘汰简历成功')
            this.initList()
          } else {
            this.$message.error(res.data.result)
          }
        }
      )
    },
    queryDetail(row) {
      console.log('查看详情' + row)
      this.$router.push({ name: 'resumeDatabaseDetail', query: { title: '简历库详情', id: row.id }})
    },
    setEducationId(educationId) {
      this.listQuery.educationId = educationId
      this.handleFilter()
    },
    setApplicationResult(applicationResult) {
      this.listQuery.applicationResult = applicationResult
      this.handleFilter()
    },
    setIsBackgroundInvest(isBackgroundInvest) {
      this.listQuery.isBackgroundInvest = isBackgroundInvest
      this.handleFilter()
    },
    initEducationList() {
      getCode({ 'groupCode': 'education', 'parentGroupCode': 'employee', 'moduleCode': 'springcloud_hr' }).then(res => {
        if (res.data.code === '0000') {
          this.educationList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    initList() {
      console.log('查询简历库。。。')
      this.listLoading = true
      getResumeDatabaseList(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.resumeDatabaseList = res.data.data.rows
          this.total = res.data.data.total
          if (this.resumeDatabaseList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
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
    }
  }
}
</script>

<style lang="scss">
  .el-table .cell {
    white-space: pre-line;
  }

  .el-pagination {
    margin-top: 15px;
  }
</style>

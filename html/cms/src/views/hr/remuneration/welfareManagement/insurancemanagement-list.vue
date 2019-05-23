<template>
  <div v-loading="listLoading" class="insureManagementList">
    <el-form :inline="true" class="filter-bar">
      <el-button
        class="filter-item"
        type="primary"
        icon="el-icon-circle-plus-outline"
        style="margin-left:10px;"
        @click="inquireAttritionPlan">增减员计划
      </el-button>
      <!--<el-button class="filter-item" type="primary" @click="addNextMonth">添加次月账单</el-button>-->
      <el-button class="filter-item" type="primary" @click="importExcel">导入历史参保记录</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="insureManagementList" border fit highlight-current-row style="width: 100%;height:100%;margin-top: 10px;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column label="参保月份" align="center" prop="insuredMonth">
        <template slot-scope="scope">
          <el-button type="text" @click="insuredDetail(scope.row)">{{ scope.row.insuredMonth }}</el-button>
        </template>
      </el-table-column>
      <el-table-column :show-overflow-tooltip="true" label="参保人数" align="center" prop="insuredNumber"/>
      <el-table-column :show-overflow-tooltip="true" label="社会缴费" align="center" prop="socialSecurity"/>
      <el-table-column :show-overflow-tooltip="true" label="公积金缴费" align="center" prop="accumulationFund"/>
      <el-table-column :show-overflow-tooltip="true" label="本月增员人数" align="center" prop="increaseInsuranceNumber" />
      <el-table-column :show-overflow-tooltip="true" label="本月停保人数" align="center" prop="stopInsuranceNumber"/>
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

    <el-dialog
      :visible.sync="dialogImportVisible"
      :modal-append-to-body="false"
      :close-on-click-modal="false"
      title="导入历史参保记录"
      class="dialog-import">
      <div :class="{'import-content': importFlag === 1, 'hide-dialog': importFlag !== 1}">
        <el-upload
          :action="importUrl"
          :headers="importHeaders"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :before-upload="beforeUpload"
          :on-error="uploadFail"
          :on-success="uploadSuccess"
          :file-list="fileList"
          class="upload-demo">
          <!-- 是否支持发送cookie信息 -->
          <el-button :disabled="processing" size="small" type="primary">{{ uploadTip }}</el-button>
          <div slot="tip" class="el-upload__tip">只能上传excel文件</div>
        </el-upload>
        <div class="download-template">
          <a class="btn-download" href="/static/file/参保明细.xlsx">
          <i class="el-icon-download"/>下载模板</a>
        </div>
      </div>
      <div :class="{'import-failure': importFlag === 2, 'hide-dialog': importFlag !== 2}">
        <div class="failure-tips">
          <i class="el-icon-warning"/>导入失败
        </div>
        <div class="failure-reason">
          <h4>失败原因</h4>
          <li v-for="(error,index) in errorResults" :key="index">{{ error }}</li>
        </div>
      </div>
    </el-dialog>

    <!--添加次月账单-->
    <template v-if="addNextMonthVisible">
      <el-dialog :visible.sync="addNextMonthVisible" title="添加次月账单" width="650px">
        <el-form ref="addNextMonthForm" :model="addNextMonthFormData" label-width="150px">
          <el-form-item label="参保月份" class="inline">
            <el-date-picker v-model="addNextMonthFormData.insuredMonth" value-format="yyyy-MM" type="month" placeholder="选择参保月份" style="width: 200px;"/>
          </el-form-item>
          <el-form-item label="参保人数" class="inline">
            <el-input v-model="addNextMonthFormData.insuredNumber" type="text" style="width: 200px;"/>
          </el-form-item>
          <el-form-item label="企业缴费" class="inline">
            <el-input v-model="addNextMonthFormData.enterprisesPayCost" type="text" style="width: 200px;"/>
          </el-form-item>
          <el-form-item label="个人缴费" class="inline">
            <el-input v-model="addNextMonthFormData.individualPayCost" type="text" style="width: 200px;"/>
          </el-form-item>
          <el-form-item label="合计" class="inline">
            <el-input v-model="summationNextMonth" type="text" style="width: 200px;" readonly="readonly"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="saveAddNextMonth()">确定</el-button>
            <el-button type="primary" @click="cancelAddNextMonthPage" >返回</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </template>

  </div>
</template>
<script>
import {
  api, downloadTempExcel
} from '@/api/hr/common'
import { getToken } from '@/utils/auth'

import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      insureManagementList: [],
      addNextMonthVisible: false,
      errorResults: [],
      addNextMonthFormData: {
        insuredMonth: '',
        insuredNumber: '',
        enterprisesPayCost: '',
        individualPayCost: '',
        summation: ''
      },
      processing: false,
      uploadTip: '点击上传',
      importFlag: 1,
      importHeaders: {
        enctype: 'multipart/form-data',
        token: getToken()
      },
      fileList: [],
      importUrl: process.env.BASE_API + 'springcloud-hr/hr/SalaryWelfareManagement/importHistoryInsuranceRecord',
      dialogImportVisible: false,
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
  computed: {
    summationNextMonth: function() {
      return parseInt(this.addNextMonthFormData.insuredNumber === '' ? 0 : this.addNextMonthFormData.insuredNumber) *
        (parseInt(this.addNextMonthFormData.enterprisesPayCost === '' ? 0 : this.addNextMonthFormData.enterprisesPayCost) +
          parseInt(this.addNextMonthFormData.individualPayCost === '' ? 0 : this.addNextMonthFormData.individualPayCost))
    }
  },
  watch: {
  },
  mounted() {
    this.initList()
  },
  methods: {
    saveAddNextMonth() {

    },
    cancelAddNextMonthPage() {
      this.addNextMonthVisible = false
    },
    insuredDetail(row) {
      this.$router.push({ name: 'insuredDetail-list', query: { title: '参保明细', row: row }})
    },
    handlePreview(file) {

    },
    handleRemove(file, fileList) {

    },
    beforeUpload(file) {
      // 上传前配置
      const excelfileExtend = '.xls,.xlsx'// 设置文件格式
      const fileExtend = file.name.substring(file.name.lastIndexOf('.')).toLowerCase()
      if (excelfileExtend.indexOf(fileExtend) <= -1) {
        this.$message.error('文件格式错误')
        return false
      }
      this.uploadTip = '正在处理中...'
      this.processing = true
    },
    uploadFail(err, file, fileList) {
      this.uploadTip = '点击上传'
      this.processing = false
      this.$message.error(err)
    },
    uploadSuccess(response, file, fileList) {
      this.uploadTip = '点击上传'
      this.processing = false
      if (response.code === '0000') {
        if (response.data === '导入成功') {
          this.importFlag = 3
          this.dialogImportVisible = false
          this.$message.info(response.data)
          this.initList()
        } else {
          this.importFlag = 2
          if (response.data) {
            this.errorResults = response.data.split(';')
          } else {
            this.errorResults.push(response.result)
          }
          this.initList()
        }
      } else {
        this.dialogImportVisible = false
        this.$message.error(response.result)
      }
      this.fileList = []
    },
    importExcel() {
      this.importFlag = 1
      this.fileList = []
      this.uploadTip = '点击上传'
      this.processing = false
      this.dialogImportVisible = true
    },
    // 增减员计划
    inquireAttritionPlan() {
      this.$router.push({ name: 'increaseStaff-list', query: { title: '增减员计划' }})
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
      // this.insureManagementList=[
      //   {
      //     "accumulationFund": 0,
      //     "cellStyleMap": {
      //     },
      //     "increaseInsuranceNumber": 0,
      //     "insuredMonth": "2019-05",
      //     "insuredNumber": 0,
      //     "socialSecurity": 0,
      //     "stopInsuranceNumber": 0
      //   }
      // ]

      this.listLoading = true
      api('hr/SalaryWelfareManagement/paginationInquireWelfareInfo', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.insureManagementList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result == null ? '查询失败' : res.data.result)
        }
        this.listLoading = false
      })
    },
    downloadExcelTemplate() {
      downloadTempExcel('hr/SalaryManagement/downLoadSalaryInfoExcelTemplate').then(res => {
        window.location.href = res.request.responseURL
      })
    },
    addNextMonth() {
      this.addNextMonthVisible = true
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

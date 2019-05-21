<template>
  <div>
    <el-form>
      <el-form-item>
        <el-button type="primary" @click="goBack($route)" >返回</el-button>
      </el-form-item>
      <el-form-item label="模板名称：" prop="id">
        <el-input style="width: 205px;" disabled="disabled" v-model="templateName"/>
      </el-form-item>
      <div>
        <el-table :data="tableData" ref="table" tooltip-effect="dark" border stripe style="width: 95%">
          <el-table-column label="目标类别" align="center" prop="targetCategory"></el-table-column>
          <el-table-column label="序号" prop="serialNumber" />
          <el-table-column label="考核目标" prop="assessmentTarget"></el-table-column>
          <el-table-column label="分值" prop="score"></el-table-column>
          <el-table-column label="评分细则" :show-overflow-tooltip="true" prop="scoreRubric"></el-table-column>
          <el-table-column label="牵头考核部门" :show-overflow-tooltip="true" prop="leadAssessmentDepartment"></el-table-column>
          <el-table-column label="得分" prop="assessmentScore" :show-overflow-tooltip="true"></el-table-column>
          <el-table-column label="扣分原因" prop="causeDeduction" :show-overflow-tooltip="true"></el-table-column>
        </el-table>
      </div>
    </el-form>
  </div>
</template>
<script>
  import {
    api, paramApi
  } from '@/api/hr/common'
  export default {
    data () {
      return {
        tableData: [],
        templateName:'',
        isDisabled: false,
        commitRows: [],
        oneRow:[],
        rowIndex:1
      }
    },
    created() {
      this.initList()
    },
    methods: {
      isActive(route) {
        return route.path === this.$route.path
      },
      goBack(view) {
        this.$store.dispatch('delView', view).then(({ visitedViews }) => {
          if (this.isActive(view)) {
            this.$router.push('assessmenttemp-list')
          }
        })
      },
      initList(){
        api('hr/AssessmentManagement/assessmentTemplateDetails', this.$route.query.row).then(res => {
          if (res.data.code === '0000') {
            this.tableData = res.data.data.recordList
            this.templateName = res.data.data.templateName
          } else {
            this.$message.error(res.data.result)
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

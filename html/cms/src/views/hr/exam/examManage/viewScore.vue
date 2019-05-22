<template>
  <div>
    <el-form :model="listQuery" class="info-form" :inline="true">
      <el-form-item label="姓名:" lable-position="right" label-width="120px">
        <el-input v-model="listQuery.examinationQuestion"  maxlength="20" placeholder="" class="filter-item"
                  clearable style="width:150px;"/>
      </el-form-item>
      <el-button class="filter-item" type="primary" @click="searchList" style="margin-left:30px;">查询</el-button>
      <el-button class="filter-item" type="primary" @click="exportList">导出</el-button>
      <el-button class="filter-item" type="primary" >人工评卷</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table v-loading="listLoading" ref="multipleTable" :data="examList" border fit highlight-current-row
              style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center"/>
      <el-table-column label="试题内容" align="center" prop="examinationQuestion">
        <template slot-scope="scope">
          {{scope.row.examinationQuestion | formatStr}}
        </template>
      </el-table-column>
      <el-table-column label="题型" align="center" prop="testQuestionTypeStr"/>
      <el-table-column label="试题难度" align="center" prop="examinationDifficultyStr"/>
      <el-table-column label="标准答案" align="center" prop="standardAnswer"/>
      <el-table-column label="分数" align="center" prop="fraction"/>
      <el-table-column label="创建时间" align="center" prop="createdTime"/>
      <el-table-column label="操作" align="center" min-width="100" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" @click="updateExam(scope.row)" >修改</el-button>
          <el-button type="text" @click="deleteExam(scope.row)" >删除</el-button>
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
  </div>
</template>

<script>

  import {
    deleteExaminaBank, selectBankList, exportExaminabank
  } from '@/api/hr/examinationList'
import {
		examSelectResultList
	} from '@/api/hr/examManage'

    export default {
        data() {
            return {
              listQuery: {
                page: 1,
                rows: 10,
                examinaId: '',
              },
              total: 0,
              listLoading: false,
              examList: []
            }
        },
      filters: {
        formatStr: function (value) {
          if(value.length>30){
            return value.substring(0,30)+'...'
          }
          return value;
        }
      },
      methods: {
          addExam(){
            this.$router.push({name: 'examinationAdd', query: {title: '新增试题'}})
          },
          searchList(){
            this.initList()
          },
          exportList(){
            exportExaminabank(this.listQuery).then(res => {
              window.location.href = res.request.responseURL
            })
          },
          updateExam(row){
            this.$router.push({name: 'examinationAdd', query: {title: '编辑试题',testQuestionId:row.testQuestionId}})
          },
          deleteExam(row){
            console.log('删除' + row)
            this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              deleteExaminaBank({testQuestionId:row.testQuestionId}).then(res => {
                if (res.data.code === '0000') {
                  this.$message({
                    message: '删除成功',
                    type: 'success'
                  })
                  if (this.listQuery.page > 1 && this.total % this.listQuery.rows === 1) {
                    this.listQuery.page = this.listQuery.page - 1
                  }
                  this.initList()
                } else {
                  this.$message.error(res.data.result)
                }
              })
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
          initList(){
            console.log('查询试题库')
            this.listLoading = true
            examSelectResultList(this.listQuery).then(res => {
              if (res.data.code === '0000') {
                this.examList = res.data.data.rows
                this.total = res.data.data.total
                if (this.examList.length === 0 && this.total > 0 && this.listQuery.page != 1) {
                  this.listQuery.page = 1
                  this.initList()
                }
              } else {
                this.$message.error(res.data.result)
              }
              this.listLoading = false
            })
          }
        },
        mounted() {
        	this.listQuery.examinaId=this.$route.query.examinaId
          this.initList()
        }
    }
</script>

<style scoped>

</style>

<template>
	<!--试题库弹出框-->
  <div>
    <el-form :model="listQuery" class="info-form" :inline="true">
      <el-form-item label="试题内容:" lable-position="right" label-width="120px">
        <el-input v-model="listQuery.examinationQuestion"  maxlength="20" placeholder="" class="filter-item"
                  clearable style="width:150px;"/>
      </el-form-item>

      <el-form-item label="试题类型:" lable-position="right" label-width="120px">
        <el-select v-model="listQuery.testQuestionType" placeholder="请选择" clearable style="width: 150px"
                   class="filter-item">
          <el-option label="请选择" value=""/>
          <el-option label="单选" value="1"/>
          <el-option label="多选" value="2"/>
          <el-option label="问答题" value="3"/>
          <el-option label="判断题" value="4"/>
        </el-select>
      </el-form-item>
      <el-button class="filter-item" type="primary" @click="searchList" style="margin-left:30px;">查询</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table v-loading="listLoading" ref="multipleTable" :data="examList" border fit highlight-current-row
              style="width: 100%;height:100%;overflow: auto;" max-height="600px" @selection-change="changeFun">
               <el-table-column
      type="selection"
      width="55"  @selection-change="changeFun">
    </el-table-column>
      <el-table-column type="index" width="60" label="序号" align="center"/>
      <el-table-column label="试题内容" align="center" prop="examinationQuestion" show-overflow-tooltip="true"/>
      <el-table-column label="题型" align="center" prop="testQuestionTypeStr"/>
      <el-table-column label="试题难度" align="center" prop="examinationDifficultyStr"/>
      <el-table-column label="标准答案" align="center" prop="standardAnswer"/>
      <el-table-column label="分数" align="center" prop="fraction"/>
      <el-table-column label="创建时间" align="center" prop="createdTime"/>
    </el-table>
    <div slot="footer" class="dialog-footer" style="text-align: center;margin-top: 20px;">
						<el-button @click="confirmOption(0)">取 消</el-button>
						<el-button type="primary" @click="confirmOption(1)">确 定</el-button>
					</div>
  </div>
</template>

<script>

  import {
    deleteExaminaBank, selectBankList, exportExaminabank
  } from '@/api/hr/examinationList'

    export default {
        data() {
            return {
            	multipleSelection:[],//选中题目
              listQuery: {
                page: 1,
                rows: 100000,
                examinationQuestion: '',
                startDateStr: '',
                endDateStr: '',
                testQuestionType: ''
              },
              total: 0,
              listLoading: false,
              examList: []
            }
        },
        methods: {
        	changeFun(val){
        		console.log(val)
        		this.multipleSelection = val;
        	},
        	confirmOption(type){
        		this.$emit('confirmOption',{type:type,multipleSelection:this.multipleSelection});
        	},
          addExam(){
            this.$router.push({name: 'examinationAdd', query: {title: '新增试题'}})
          },
          searchList(){
            this.initList()
          },
          initList(){
            console.log('查询试题库')
            this.listLoading = true
            selectBankList(this.listQuery).then(res => {
              if (res.data.code === '0000') {
                this.examList = res.data.data.rows
                this.total = res.data.data.total
                if (this.examList.length === 0 && this.total > 0) {
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
          this.initList()
        }
    }
</script>

<style scoped>

</style>

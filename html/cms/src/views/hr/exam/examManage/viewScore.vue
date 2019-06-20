<template>
  <div>
    <el-form :model="listQuery" :inline="true" class="info-form">
      <el-form-item label="姓名:" lable-position="right" label-width="120px">
        <el-input v-model="listQuery.name" maxlength="20" placeholder="" class="filter-item" clearable style="width:150px;" />
      </el-form-item>
      <el-button class="filter-item" type="primary" style="margin-left:30px;" @click="searchList">查询</el-button>
      <el-button class="filter-item" type="primary" @click="exportList">导出</el-button>
      <!--<el-button class="filter-item" type="primary" >人工评卷</el-button>-->
    </el-form>
    <el-row class="headAllInfo">
      <el-col :span="3">
        <div class="grid-content bg-purple">
          <p>参加人次</p>
          <p>{{ examInfo.countStr }}</p>
        </div>
      </el-col>
      <el-col :span="3">
        <div class="grid-content bg-purple">
          <p>及格人数</p>
          <p>{{ examInfo.yesAdoptCountStr }}</p>
        </div>
      </el-col>
      <el-col :span="3">
        <div class="grid-content bg-purple">
          <p>不及格人数</p>
          <p>{{ examInfo.notAdoptCountStr }}</p>
        </div>
      </el-col>
      <el-col :span="4">
        <div class="grid-content bg-purple">
          <p>通过率</p>
          <p>{{ examInfo.yesAdoptRateStr }}</p>
        </div>
      </el-col>
      <el-col :span="4">
        <div class="grid-content bg-purple">
          <p>最高分</p>
          <p>{{ examInfo.maxStr }}</p>
        </div>
      </el-col>
      <el-col :span="4">
        <div class="grid-content bg-purple">
          <p>最低分</p>
          <p>{{ examInfo.minStr }}</p>
        </div>
      </el-col>
      <el-col :span="3">
        <div class="grid-content bg-purple">
          <p>平均分</p>
          <p>{{ examInfo.avgStr }}</p>
        </div>
      </el-col>
    </el-row>
    <!-- 表格 -->
    <el-table v-loading="listLoading" ref="multipleTable" :data="examList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column label="姓名" align="center" prop="name"/>
      <el-table-column label="开始时间/交卷时间" width="300" align="center" prop="examinaStartEndTimeStr"/>
      <el-table-column label="用时(分钟)" align="center" prop="useTime" />
      <el-table-column label="总分/及格分数" align="center" prop="totalAndPassScore" />
      <el-table-column label="成绩" align="center" prop="achievement" />
      <el-table-column label="是否通过" align="center" prop="isAdoptStr" />
      <el-table-column label="考试方式" align="center" prop="examinaMethodStr" />
      <el-table-column label="排名" align="center" prop="rank" />
      <el-table-column label="操作" align="center" min-width="100" width="210" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" @click="updateExam(scope.row,'see')">查看答卷</el-button>
          <el-button type="text" @click="updateExam(scope.row,'edit')">人工评卷</el-button>

          <el-button type="text" @click="deleteExam(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[5,10,20,30, 50]" :page-size="listQuery.rows" :total="total" class="tablePagination" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    <el-footer style="text-align: center;">
      <!-- <el-button type="primary" @click="submitForm('ruleForm')">保存 & 去设计试卷</el-button> -->
      <el-button @click="$router.go(-1)">返回</el-button>
    </el-footer>
  </div>
</template>

<script>
import {
  examSelectResultList,
  examDeleteResult,
  examExportResultList
} from '@/api/hr/examManage'

export default {
  filters: {
    formatStr: function(value) {
      if (value.length > 30) {
        return value.substring(0, 30) + '...'
      }
      return value
    }
  },
  data() {
    return {
      examInfo: {},
      listQuery: {
        page: 1,
        rows: 10,
        name: '',
        examinaId: ''
      },
      total: 0,
      listLoading: false,
      examList: []
    }
  },
  created() {
    this.listQuery.examinaId = this.$route.query.examinaId
    this.initList()
  },
  methods: {
    addExam() {
      this.$router.push({
        name: 'examinationAdd',
        query: {
          title: '新增试题'
        }
      })
    },
    searchList() {
      this.initList()
    },
    exportList() {
      examExportResultList(this.listQuery).then(res => {
        window.location.href = res.request.responseURL
      })
    },
    updateExam(row, type) {
      let title = '查看试卷'
      if (type === 'edit') {
        title = '人工评卷'
      }
      this.$router.push({
        name: 'seeAxam',
        query: {
          title: title,
          id: row.id,
          jobNumber: row.jobNumber
        }
      })
    },
    deleteExam(row) {
      console.log('删除' + row)
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        examDeleteResult({
          resultId: row.resultId
        }).then(res => {
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
    initList() {
      this.listLoading = true
      examSelectResultList(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          /* 和后台约定好取第一条*/
          if (res.data.data.rows.length > 0) {
            this.examInfo = res.data.data.rows[0]
          }
          this.examList = res.data.data.rows
          this.total = res.data.data.total
          if (this.examList.length === 0 && this.total > 0 && this.listQuery.page !== 1) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    }
  }

}
</script>

<style lang="scss" scoped>
	.headAllInfo {
		margin-bottom: 20px;
		.grid-content {
			background-color: #fff;
			border: 1px solid #ddd;
			padding: 5px;
			text-align: center;
		}
	}
</style>

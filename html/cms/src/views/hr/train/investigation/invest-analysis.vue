<template>
  <div v-loading="listLoading" class="invest-analysis">
    <!-- 表单 -->
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="调研项目:">
        <el-input
          v-model="listQuery.researchProject"
          maxlength="20"
          placeholder="请输入调研项目"
          class="filter-item"
          clearable
        />
      </el-form-item>
      <el-form-item label="调研时间:" style="margin:0px 30px;">
        <el-date-picker
          v-model="listQuery.effectiveTimeStart"
          type="datetime"
          value-format="yyyy-MM-dd HH:mm:ss"
          placeholder="请选择开始时间"
        />至
        <el-date-picker
          v-model="listQuery.effectiveTimeEnd"
          type="datetime"
          value-format="yyyy-MM-dd HH:mm:ss"
          placeholder="请选择结束时间"
        />
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-plus" @click="handleAddOrEdict">新增</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="investList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center"/>
      <el-table-column
        :show-overflow-tooltip="true"
        label="调研项目"
        align="center"
        prop="researchProject"
      >
        <template slot-scope="scope">
          <el-button
            class="setCursor"
            type="text"
            @click="handleAddOrEdict(scope.row)"
          >{{ scope.row.researchProject }}</el-button>
        </template>
      </el-table-column>
      <el-table-column label="开始时间" min-width="120" align="center" prop="effectiveTimeStartStr"/>
      <el-table-column label="结束时间" min-width="120" align="center" prop="effectiveTimeEndStr"/>
      <el-table-column label="新建人" align="center" prop="creatorAccount"/>
      <el-table-column label="状态" align="center" prop="statusStr"/>
      <el-table-column
        label="操作"
        align="center"
        min-width="200"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button type="text" @click="handleEnd(scope.row.projectId)">结束调研</el-button>
          <el-button type="text" @click="handleGive(scope.row)">发放调研</el-button>
          <el-button type="text" @click="handleResult(scope.row)">调研结果</el-button>
          <el-button type="text" style="color:red;" @click="handleDelete(scope.row)">删除</el-button>
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
      @current-change="handleCurrentChange"
    />
  </div>
</template>

<script>
import { api } from '@/api/hr/train'
export default {
  data() {
    return {
      listLoading: false,
      listQuery: {
        researchProject: '',
        effectiveTimeStartStr: '',
        effectiveTimeEndStr: '',
        page: 1,
        rows: 10
      },
      investList: [],
      total: 100
    }
  },
  created() {
    this.init()
  },
  methods: {
    // 初始化
    init() {
      this.listLoading = true
      api('hr/train/listInvestigate', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.investList = res.data.data.rows
          this.total = res.data.data.total
          if (this.investList.length === 0 && this.total > 0) {
            this.page = 1
            this.init()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 搜素功能的实现
    handleFilter() {
      this.listQuery.page = 1
      this.init()
    },
    // 表格分页功能
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.init()
    },
    // 新增/编辑
    handleAddOrEdict(row) {
      if (row && row.projectId) {
        this.$router.push({
          name: 'invest-edit',
          query: { id: row.projectId, title: '编辑项目' }
        })
      } else {
        this.$router.push({ name: 'invest-add', query: { title: '新建项目' }})
      }
    },
    // 发放调研
    handleGive(row) {
      this.$router.push({
        name: 'invest-give',
        query: {
          id: row.projectId,
          researchProject: row.researchProject,
          status: row.status,
          title: '发放调研'
        }
      })
    },
    // 调研结果
    handleResult(row) {
      this.$router.push({
        name: 'invest-result',
        query: { id: row.projectId, title: '调研结果' }
      })
    },
    // 删除
    handleDelete(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          const data = { projectId: row.projectId }
          api('hr/train/daleteInvestigate', data).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.listQuery.rows === 1) {
                this.listQuery.page = this.listQuery.page - 1
              }
              this.init()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {})
    },
    // 结束调研
    handleEnd(projectId) {
      const data = {
        projectId: projectId
      }
      api('hr/train/endInvestiage', data).then(res => {
        if (res.data.code === '0000') {
          this.$message.success('结束调研成功！')
          this.init()
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss"  scoped>
.setCursor {
  cursor: pointer;
}
.el-pagination {
  margin-top: 15px;
}
</style>

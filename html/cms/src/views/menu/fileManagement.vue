<template>
  <div class="fileManagement">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="文件名称:">
          <el-input v-model="listQuery.fileName" placeholder="请输入文件名称" class="filter-item" maxlength="20" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-form-item label="文件组名称:">
          <el-input v-model="listQuery.fileGroupName" placeholder="请输入文件组名称" class="filter-item" maxlength="20" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.status" placeholder="请选择" clearable class="filter-item" @change="selecteFileStatus">
            <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
      </el-form>
    </div>
    <!-- 表格 -->
    <el-table v-loading="fileListLoading" :data="fileList" border fit highlight-current-row style="width: 100%;height:100%">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" label="序号" width="60" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="文件名称" align="center" prop="fileName" />
      <el-table-column :show-overflow-tooltip="true" label="归属文件组" align="center" prop="fileGroupNameList">
        <template slot-scope="scope">
          {{ scope.row.fileGroupNameList.join('、') }}
        </template>
      </el-table-column>
      <el-table-column label="文件路径" align="center" prop="fileUrl" min-width="100"/>
      <el-table-column label="创建时间" width="150" align="center" prop="creationTime">
        <template slot-scope="scope">
          {{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status==0?'未生效':'生效' }}</span>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10, 20, 30, 40]" :page-size="listQuery.rows" :total="total" class="tablePagination" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
  </div>
</template>

<script>
import {
  getFileList

} from '@/api/Permission-model/fileManagement'
export default {
  data() {
    return {
      fileList: [],
      total: 0,
      statusOptions: ['未生效', '生效'],
      listQuery: {
        fileName: undefined,
        fileGroupName: undefined,
        status: undefined,
        page: 1,
        rows: 10
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    // 状态改变时触发
    selecteFileStatus(value) {
      this.listQuery.status = value
    },
    // 搜素功能实现
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 项目初始化
    initList() {
      this.fileListLoading = true
      getFileList(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.fileList = res.data.data.rows
          this.total = res.data.data.total
          if (this.fileList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.fileListLoading = false
      })
    },
    // 分页功能
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
   .filter-container {
    .el-form-item {
      margin-bottom: 0;
    }
  }
</style>

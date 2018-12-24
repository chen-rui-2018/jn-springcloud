<template>
  <div>
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="类型名称:">
          <el-input v-model="listQuery.typeName" maxlength="20" placeholder="请输入类型名称" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.status" placeholder="请选择状态" clearable class="filter-item" @change="selecteUserStatus">
            <el-option v-for="(item,index) in statusOptions" :key="item" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>

    <!-- 表格 -->
    <el-table v-loading="listLoading" :data="typeList" border fit highlight-current-row style="width: 100%;height:100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" width="60" label="序号" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="类型名称" align="center" prop="typeName" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status==0?'无效':'有效' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteUsergroup(scope.row)">删除</el-button>
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
      @current-change="handleCurrentChange" />
    <!-- 弹出的活动类型对话框 -->
    <el-dialog :visible.sync="activityTypedialogFormVisible" :title="dialogStatus" width="400px">
      <el-form ref="activityTypeForm" :rules="rules" :model="activityTypeForm" label-position="right" label-width="80px" style="max-width:300px;margin-left:20px">
        <el-form-item label="类型名称:" prop="typeName">
          <el-input v-model.trim="activityTypeForm.typeName" maxlength="20" clearable/>
        </el-form-item>
        <el-form-item label="状态:" prop="status">
          <el-select v-model="activityTypeForm.status" placeholder="请选择" class="filter-item" clearable>
            <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增活动类型'?createUserData():updateData()">提交</el-button>
        <el-button @click="userGroupdialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  getTypeList
} from '@/api/portalManagement/activityType'
export default {
  data() {
    return {
      dialogStatus: undefined,
      activityTypedialogFormVisible: false,
      total: undefined,
      typeList: [],
      listLoading: false,
      statusOptions: ['无效', '有效'],
      listQuery: {
        status: undefined,
        typeName: undefined,
        page: 1,
        rows: 10

      }
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    //   搜素功能的实现
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    selecteUserStatus(value) {
      this.listQuery.status = value
    },
    handleCreate() {},
    // 项目初始化
    initList() {
      this.listLoading = true
      getTypeList(this.listQuery).then(res => {
        console.log(res)
        if (res.data.code === '0000') {
          this.typeList = res.data.data.rows
          this.total = res.data.data.total
          if (this.typeList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
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

<style scoped>

</style>

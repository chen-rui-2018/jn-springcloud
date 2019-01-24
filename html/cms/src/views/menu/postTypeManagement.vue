<template>
  <div v-loading="listLoading" class="postTypeManagegement">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="岗位类型名称:">
          <el-input v-model="listQuery.postTypeName" placeholder="请输入名称" maxlength="20" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable class="filter-item" @change="selectePostStatus">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>
    <!-- 表格 -->
    <el-table :data="postTypeList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" align="center" label="序号" width="60" />
      <el-table-column label="岗位类型名称" align="center" prop="postTypeName" />
      <el-table-column label="创建时间" align="center" prop="creationTime">
        <template slot-scope="scope">
          {{ scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="recordStatus">
        <template slot-scope="scope">
          <span :class="scope.row.recordStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.recordStatus==1?'生效':'未生效' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deletePostType(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="pagination-container  tablePagination">
      <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[5,10,20,30, 50]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <!-- 弹出的新增岗位对话框 -->
    <el-dialog :visible.sync="postTypeDialogFormVisible" :title="dialogStatus" width="400px">
      <el-form ref="postTypeForm" :rules="rules" :model="postTypeForm" label-position="right" label-width="120px" style="max-width:300px;margin-left:20px">
        <el-form-item label="岗位类型名称" prop="postTypeName">
          <el-input v-model.trim="postTypeForm.postTypeName" maxlength="20" clearable/>
        </el-form-item>
        <el-form-item label="状态" prop="recordStatus">
          <el-select v-model="postTypeForm.recordStatus" placeholder="请选择" class="filter-item" >
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增岗位类型'?createPostTypeData():updateData()">提交</el-button>
        <el-button @click="postTypeDialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getPostTypeList, addPostTypeList, editPostTypeList, deletePostTypeById, checkPostTypeName } from '@/api/Permission-model/postTypeManagement'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.oldPostTypeName !== this.postTypeForm.postTypeName) {
          checkPostTypeName(this.postTypeForm.postTypeName).then(res => {
            if (res.data.code === '0000') {
              if (res.data.data === 'success') {
                callback()
              } else {
                callback(new Error('岗位类型名称已使用'))
              }
            }
          })
        } else {
          callback()
        }
      }
    }
    return {
      postTypeForm: {
        id: undefined,
        postTypeName: undefined,
        recordStatus: undefined
      },
      isDisabled: false,
      dialogStatus: undefined,
      postTypeDialogFormVisible: false,
      total: 0,
      listLoading: false,
      postTypeList: [],
      statusOptions: [{
        value: '1',
        label: '生效'
      }, {
        value: '2',
        label: '未生效'
      }],
      listQuery: {
        postTypeName: undefined,
        recordStatus: undefined,
        page: 1,
        rows: 10
      },
      rules: {
        postTypeName: [
          { required: true, message: '请输入岗位类型名称', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        recordStatus: [{ required: true, message: '请选择状态', trigger: 'change' }]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    // 删除岗位功能实现
    deletePostType(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deletePostTypeById(id).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.listQuery.rows === 1) {
                this.listQuery.page = this.listQuery.page - 1
              }
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        }).catch(() => {

        })
    },
    // 弹出编辑岗位类型对话框
    handleUpdate(row) {
      // 显示对话框
      this.postTypeDialogFormVisible = true
      this.oldPostTypeName = row.postTypeName
      //   添加默认数据
      this.dialogStatus = '编辑岗位类型'
      this.postTypeForm.id = row.id
      this.postTypeForm.postTypeName = row.postTypeName
      this.postTypeForm.recordStatus = row.recordStatus.toString()
      this.$nextTick(() => {
        this.$refs['postTypeForm'].clearValidate()
      })
    },
    // 编辑岗位类型的功能实现
    updateData() {
      this.$refs['postTypeForm'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          // // 调用接口发送请求
          editPostTypeList(this.postTypeForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 将对话框隐藏
            this.postTypeDialogFormVisible = false
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 实现新增岗位类型功能
    createPostTypeData() {
      this.isDisabled = true
      this.$refs['postTypeForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          addPostTypeList(this.postTypeForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 将对话框隐藏
            this.postTypeDialogFormVisible = false
            // 重置表单元素的数据
            this.$refs['postTypeForm'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    // 显示新增岗位类型对话框
    handleCreate() {
      this.postTypeForm.postTypeName = undefined
      this.postTypeForm.recordStatus = undefined
      this.postTypeForm.id = undefined
      this.dialogStatus = '新增岗位类型'
      this.postTypeDialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['postTypeForm'].clearValidate()
      })
    },
    // 查询功能
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 状态改变
    selectePostStatus(value) {
      this.listQuery.recordStatus = value
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
      getPostTypeList(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.postTypeList = res.data.data.rows
          this.total = res.data.data.total
          if (this.postTypeList.length === 0 && this.total > 0) {
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

<style lang="scss">
   .filter-container {
    .el-form-item {
      margin-bottom: 0;
    }
  }
</style>

<template>
  <div class="postManagement">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="岗位名称:">
          <el-input v-model="listQuery.postName" placeholder="请输入名称" style="width: 150px" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.status" placeholder="请选择" clearable class="filter-item" @change="selectePostStatus">
            <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>
    <!-- 表格 -->
    <el-table v-loading="listLoading" :data="postList" border fit highlight-current-row style="width: 100%;height:100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="岗位名称" align="center" prop="postName" />
      <el-table-column label="创建时间" width="150" align="center" prop="creationTime">
        <template slot-scope="scope">
          {{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="描述" align="center" prop="describe" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status | statusFilter }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deletePost(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="pagination-container">
      <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[5,10,20,30, 50]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <!-- 弹出的新增岗位对话框 -->
    <el-dialog :visible.sync="postdialogFormVisible" :title="dialogStatus" width="400px">
      <el-form ref="postform" :rules="rules" :model="postform" label-position="right" label-width="100px" style="max-width:300px;margin-left:20px">
        <el-form-item label="岗位名称" prop="postName">
          <el-input v-model.trim="postform.postName" max-length="20" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="postform.status" class="filter-item" >
            <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="dialogStatus==='新增岗位'?createPostData():updateData()">提交</el-button>
        <el-button @click="cancelEdit()">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  getAllList, addPostList, checkPostName, editPostList, deletePostById
} from '@/api/Permission-model/postManagement'
export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        0: '未生效',
        1: '生效'
      }
      return statusMap[status]
    }
  },
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /[a-zA-Z]|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入字母或汉字组成的岗位名称'))
      } else {
        if (this.oldPostName !== this.postform.postName) {
          checkPostName(this.postform.postName).then(response => {
            const result = response.data.data
            if (result === 'success') {
              callback()
            } else {
              callback(new Error('岗位名称已重复'))
            }
          })
        } else {
          callback()
        }
      }
    }
    return {
      oldPostName: undefined,
      postform: {
        id: '',
        postName: undefined,
        status: undefined
      },
      dialogStatus: '',
      postdialogFormVisible: false,
      total: 0,
      postList: [],
      listLoading: false,
      listQuery: {
        postName: undefined,
        status: undefined,
        page: 1,
        rows: 10
      },
      statusOptions: ['未生效', '生效'],
      rules: {
        postName: [
          { required: true, message: '请输入用户组名称', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        status: [{ required: true, message: '请选择状态', trigger: 'blur' }]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    // 删除岗位功能实现
    deletePost(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deletePostById(id).then(res => {
            console.log(res)
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              this.initList()
            } else {
              this.$message.error('删除失败')
            }
          })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
    // 取消编辑
    cancelEdit() {
      this.$nextTick(() => {
        this.$refs['postform'].clearValidate()
      })
      this.postdialogFormVisible = false
    },
    // 弹出编辑岗位对话框
    handleUpdate(row) {
      // 显示对话框
      this.postdialogFormVisible = true
      this.oldPostName = row.postName
      //   添加默认数据
      this.dialogStatus = '编辑岗位'
      this.postform.id = row.id
      this.postform.postName = row.postName
      this.postform.status = parseInt(row.status)
    },
    // 编辑岗位的功能实现
    updateData() {
      this.$refs['postform'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.postdialogFormVisible = false
          // // 调用接口发送请求
          editPostList(this.postform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            }
            // 将对话框隐藏
            this.postdialogFormVisible = false
            // 重置表单元素的数据
            this.$refs['postform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.$message({
            message: '请修改数据',
            type: 'error'
          })
        }
      })
    },
    // 查询功能
    handleFilter() { this.initList() },
    selectePostStatus(value) {
      this.listQuery.status = value
    },
    // 实现新增岗位功能
    createPostData() {
      this.$refs['postform'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.postdialogFormVisible = false
          // 调用接口发送请求
          addPostList(this.postform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            }
            // 重置表单元素的数据
            this.$refs['postform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.$message({
            message: '请输入内容',
            type: 'error'
          })
        }
      })
    },
    // 显示新增岗位对话框
    handleCreate() {
      this.resetuserGroupform()
      this.dialogStatus = '新增岗位'
      this.postdialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['postform'].clearValidate()
      })
    },
    // 清空信息
    resetuserGroupform() {
      this.postform = {
        postName: undefined,
        status: undefined
      }
    },
    // 项目初始化
    initList() {
      this.listLoading = true
      getAllList(this.listQuery).then(response => {
        console.log(response)
        this.postList = response.data.data.rows
        this.total = response.data.data.total
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

<style lang="scss" scoped>
.postManagement {
  .filter-container {
    margin-left: 20px;
  }
}
</style>

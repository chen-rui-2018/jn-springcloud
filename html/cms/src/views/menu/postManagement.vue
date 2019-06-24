<template>
  <div v-loading="listLoading" class="postManagement">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="岗位名称:">
          <el-input v-model="listQuery.postName" placeholder="请输入岗位名称" maxlength="20" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-form-item label="岗位类型">
          <el-select v-model="listQuery.postTypeId" placeholder="请选择岗位类型" class="filter-item" clearable>
            <el-option v-for="(item,index) in postTypeNameOptions" :key="index" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable class="filter-item" @change="selectePostStatus">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
        <el-button class="filter-item" style="margin-left: 10px" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>
    <!-- 表格 -->
    <el-table :data="postList" border fit highlight-current-row style="width: 100%;height:100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" label="序号" width="60" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="岗位名称" align="center" prop="postName" />
      <el-table-column label="岗位类型" align="center" prop="postTypeName" />
      <el-table-column label="创建时间" align="center" min-width="120" prop="createdTime"/>
      <el-table-column label="等级" align="center" prop="rank"/>
      <el-table-column label="状态" align="center" prop="recordStatus">
        <template slot-scope="scope">
          <span :class="scope.row.recordStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.recordStatus | statusFilter }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deletePost(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="pagination-container  tablePagination">
      <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[5,10,20,30, 50]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <!-- 弹出的新增岗位对话框 -->
    <el-dialog :visible.sync="postdialogFormVisible" :title="dialogStatus" width="400px">
      <el-form ref="postform" :rules="rules" :model="postform" label-position="right" label-width="100px" style="max-width:300px;margin-left:20px">
        <el-form-item label="岗位名称" prop="postName">
          <el-input v-model.trim="postform.postName" maxlength="20" clearable/>
        </el-form-item>
        <el-form-item label="岗位类型">
          <el-select v-model="postform.postTypeId" placeholder="请选择" class="filter-item" clearable>
            <el-option v-for="(item,index) in postTypeNameOptions" :key="index" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="等级" prop="rank">
          <el-input v-model="postform.rank" maxlength="10" clearable/>
        </el-form-item>
        <el-form-item label="状态" prop="recordStatus">
          <el-select v-model="postform.recordStatus" placeholder="请选择" class="filter-item" >
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增岗位'?createPostData():updateData()">提交</el-button>
        <el-button @click="postdialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { api, paramApi } from '@/api/axios'
export default {
  filters: {
    statusFilter(recordStatus) {
      const statusMap = {
        2: '未生效',
        1: '生效'
      }
      return statusMap[recordStatus]
    }
  },
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.dialogStatus === '新增岗位') {
          paramApi(`${this.GLOBAL.systemUrl}system/sysPost/checkPostName`, this.postform.postName, 'postName').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              if (res.data.data === 'success') {
                callback()
              } else {
                callback(new Error('岗位名称已重复'))
              }
            }
          })
        } else {
          if (this.oldPostName !== this.postform.postName) {
            paramApi(`${this.GLOBAL.systemUrl}system/sysPost/checkPostName`, this.postform.postName, 'postName').then(res => {
              if (res.data.code === this.GLOBAL.code) {
                if (res.data.data === 'success') {
                  callback()
                } else {
                  callback(new Error('岗位名称已重复'))
                }
              }
            })
          } else {
            callback()
          }
        }
      }
    }
    var checkRank = (rule, value, callback) => {
      const reg = /^[1-9][0-9]*$/
      if (!reg.test(value)) {
        callback('请输入大于0的数字')
      } else {
        callback()
      }
    }
    return {
      postTypeNameOptions: [],
      isDisabled: false,
      oldPostName: undefined,
      postform: {
        id: '',
        postName: undefined,
        postTypeId: undefined,
        recordStatus: undefined,
        rank: undefined
      },
      dialogStatus: '',
      postdialogFormVisible: false,
      total: 0,
      postList: [],
      listLoading: false,
      listQuery: {
        postTypeName: undefined,
        postName: undefined,
        recordStatus: undefined,
        page: 1,
        rows: 10
      },
      statusOptions: [{
        value: '1',
        label: '生效'
      }, {
        value: '2',
        label: '未生效'
      }],
      rules: {
        postName: [
          { required: true, message: '请输入岗位名称', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        rank: [{ required: true, message: '请输入等级', trigger: 'blur' },
          { validator: checkRank, trigger: 'blur' }
        ],
        recordStatus: [{ required: true, message: '请选择状态', trigger: 'change' }]
      }
    }
  },
  created() {
    this.initList()
    this.getPostType()
  },
  methods: {
    // 获取岗位类型
    getPostType() {
      api(`${this.GLOBAL.systemUrl}system/sysPostType/getPostTypeAll`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          res.data.data.forEach(val => {
            this.postTypeNameOptions.push({
              value: val.id,
              label: val.postTypeName
            })
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 删除岗位功能实现
    deletePost(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi(`${this.GLOBAL.systemUrl}system/sysPost/delete`, id, 'postIds').then(res => {
            if (res.data.code === this.GLOBAL.code) {
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
    // 弹出编辑岗位对话框
    handleUpdate(row) {
      // 显示对话框
      this.postdialogFormVisible = true
      this.oldPostName = row.postName
      //   添加默认数据
      this.dialogStatus = '编辑岗位'
      this.postform.id = row.id
      this.postform.rank = row.rank
      this.postform.postName = row.postName
      this.postform.recordStatus = row.recordStatus.toString()
      this.postform.postTypeId = row.postTypeId
      this.$nextTick(() => {
        this.$refs['postform'].clearValidate()
      })
    },
    // 编辑岗位的功能实现
    updateData() {
      this.$refs['postform'].validate(valid => {
        if (valid) {
          // 避免重复点击提交
          this.isDisabled = true
          // // 调用接口发送请求
          api(`${this.GLOBAL.systemUrl}system/sysPost/update`, this.postform, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 将对话框隐藏
            this.postdialogFormVisible = false
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 查询功能
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    selectePostStatus(value) {
      this.listQuery.recordStatus = value
    },
    // 实现新增岗位功能
    createPostData() {
      this.isDisabled = true
      this.$refs['postform'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api(`${this.GLOBAL.systemUrl}system/sysPost/add`, this.postform, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 将对话框隐藏
            this.postdialogFormVisible = false
            // 重置表单元素的数据
            this.$refs['postform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    // 显示新增岗位对话框
    handleCreate() {
      // this.resetuserGroupform()
      this.postform.postName = undefined
      this.postform.recordStatus = undefined
      this.postform.postTypeId = undefined
      this.postform.rank = undefined
      this.dialogStatus = '新增岗位'
      this.postdialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['postform'].clearValidate()
      })
    },
    // 项目初始化
    initList() {
      this.listLoading = true
      api(`${this.GLOBAL.systemUrl}system/sysPost/list`, this.listQuery, 'post').then(response => {
        if (response.data.code === this.GLOBAL.code) {
          this.postList = response.data.data.rows
          this.total = response.data.data.total
          if (this.postList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(response.data.result)
        }
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
  .pagination-container{
    margin-top:15px;
  }
  .filter-container {
    margin-left: 20px;
    .el-form-item{
      margin-bottom: 0px;
    }
  }
  .el-dialog{
  .el-form-item{
    margin-bottom: 32px;
  }
}
}
</style>

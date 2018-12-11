<template>
  <div class="file-group-management">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="文件组名称:">
          <el-input v-model="listQuery.fileGroupName" placeholder="请输入文件组名称" maxlenth="20" class="filter-item" clearable @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.status" placeholder="请选择" clearable class="filter-item" @change="selecteFileGroupStatus">
            <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>
    <el-table v-loading="listLoading" :data="fileGroupList" border fit highlight-current-row style="width: 100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" label="序号" width="60"/>
      <!-- 表格第二列  姓名 -->
      <el-table-column label="文件组名称" align="center" prop="fileGroupName" />
      <el-table-column label="创建时间" width="150" align="center" prop="creationTime">
        <template slot-scope="scope">
          {{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="描述" prop="fileGroupDescribe" align="center" />
      <el-table-column label="状态" align="center" prop="status" >
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status==0?'未生效':'生效' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteFileGroup(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10, 20, 30, 40]" :page-size="listQuery.rows" :total="total" class="tablePagination" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    <!-- 新增文件组弹框 -->
    <el-dialog :visible.sync="fileGroupdialogFormVisible" :title="dialogStatus" width="400px">
      <el-form
        ref="temp"
        :rules="rules"
        :model="temp"
        label-position="right"
        label-width="100px" >
        <el-form-item label="文件组名称:" prop="fileGroupName">
          <el-input v-model.trim="temp.fileGroupName" maxlength="20"/>
        </el-form-item>
        <el-form-item label="描述:" prop="fileGroupDescribe">
          <el-input v-model.trim="temp.fileGroupDescribe" type="textarea"/>
        </el-form-item>
        <el-form-item label="状态:" prop="status" >
          <el-select v-model="temp.status" class="filter-item" placeholder="请选择">
            <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增文件组'?createFileGroupData():updateData()">提交</el-button>
        <el-button @click="fileGroupdialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { addFileGroupList, updataFileGroup, allFileGroupList, checkFileGroupName, deleteFileGroupById } from '@/api/Permission-model/filegroup'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,16}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.oldName !== this.temp.fileGroupName) {
          checkFileGroupName(this.temp.fileGroupName).then(res => {
            if (res.data.code === '0000') {
              if (res.data.data === 'success') {
                callback()
              } else {
                callback(new Error('文件组名称已重复'))
              }
            }
          })
        } else {
          callback()
        }
      }
    }
    var checkoutDescribe = (rule, value, callback) => {
      if (value && value.length > 50) {
        callback(new Error('描述的长度不能超过50个字符'))
      } else {
        callback()
      }
    }
    return {
      oldName: undefined,
      isDisabled: false,
      listQuery: {
        page: 1,
        rows: 10,
        fileGroupName: '',
        status: ''
      },
      statusOptions: ['未生效', '生效'],
      fileGroupdialogFormVisible: false,
      dialogStatus: '',
      temp: {
        id: undefined,
        fileGroupName: undefined,
        status: undefined,
        fileGroupDescribe: undefined
      },
      listLoading: false,
      fileGroupList: [],
      total: 0,
      rules: {
        fileGroupName: [
          { required: true, message: '文件组名称不能为空', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        status: [
          { required: true, message: '请选择状态', trigger: 'blur' }
        ],
        fileGroupDescribe: [{ validator: checkoutDescribe, trigger: 'change' }]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
  //  按条件查询
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 选中时发生改变的值
    selecteFileGroupStatus(value) {
      this.listQuery.status = value
    },
    // 清空信息
    resetTemp() {
      this.temp = {
        filegroupName: undefined,
        filegroupstatus: undefined,
        fileGroupDescribe: undefined
      }
    },
    // 显示新增文件组对话框
    handleCreate() {
      this.resetTemp()
      this.dialogStatus = '新增文件组'
      this.fileGroupdialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['temp'].clearValidate()
      })
    },
    // 实现新增文件组信息
    createFileGroupData() {
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisabled = false
      }, 500)
      this.$refs['temp'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          addFileGroupList(this.temp).then(res => {
            console.log(res)
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            // 将对话框隐藏
            this.fileGroupdialogFormVisible = false
            // 重置表单元素的数据
            this.$refs['temp'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 显示编辑文件组对话框
    handleUpdate(row) {
      this.temp.id = row.id
      this.dialogStatus = '编辑文件组'
      this.oldName = row.fileGroupName
      this.temp.fileGroupDescribe = row.fileGroupDescribe
      this.fileGroupdialogFormVisible = true
      this.temp.fileGroupName = row.fileGroupName
      this.temp.status = parseInt(row.status)
      this.$nextTick(() => {
        this.$refs['temp'].clearValidate()
      })
    },
    // 编辑文件组信息
    updateData() {
      this.isDisabled = true
      setTimeout(() => {
        this.isDisabled = false
      }, 1000)
      this.$refs['temp'].validate(valid => {
        if (valid) {
          // 通过验证
          updataFileGroup(this.temp).then(res => {
            if (res.data.code === '0000') {
              console.log(res)
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.fileGroupdialogFormVisible = false
            this.initList()
          })
        }
      })
    },
    // 删除角色功能实现
    deleteFileGroup(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deleteFileGroupById(id).then(res => {
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
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
    // 项目初始化
    initList() {
      this.listLoading = true
      allFileGroupList(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.fileGroupList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 改变每页的数据时触发
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    // 改变当前页码触发
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
  .el-dialog{
  .el-textarea__inner{
    min-height: 100px !important;
  }
  }
</style>

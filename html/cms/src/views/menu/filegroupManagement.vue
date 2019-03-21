<template>
  <div v-loading="listLoading" class="file-group-management">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="文件组名称:">
          <el-input v-model="listQuery.fileGroupName" placeholder="请输入文件组名称" maxlength="20" class="filter-item" clearable @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable class="filter-item" @change="selecteFileGroupStatus">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>
    <el-table :data="fileGroupList" border fit highlight-current-row style="width: 100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" label="序号" width="60"/>
      <!-- 表格第二列  姓名 -->
      <el-table-column label="文件组名称" align="center" prop="fileGroupName" />
      <el-table-column label="创建时间" align="center" prop="createdTime"/>
      <el-table-column label="描述" prop="fileGroupDescribe" align="center" />
      <el-table-column label="状态" align="center" prop="recordStatus" >
        <template slot-scope="scope">
          <span :class="scope.row.recordStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.recordStatus==1?'生效':'未生效' }}</span>
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
          <el-input v-model.trim="temp.fileGroupName" maxlength="20" clearable/>
        </el-form-item>
        <el-form-item label="描述:" prop="fileGroupDescribe">
          <el-input v-model.trim="temp.fileGroupDescribe" type="textarea" maxlength="150" clearable/>
        </el-form-item>
        <el-form-item label="状态:" prop="recordStatus" >
          <el-select v-model="temp.recordStatus" class="filter-item" placeholder="请选择" style="width:100%">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
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
import { api, paramApi } from '@/api/Permission-model/userManagement'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.dialogStatus === '新增文件组') {
          paramApi('system/sysFileGroup/checkFileGroupName', this.temp.fileGroupName, 'fileGroupName').then(res => {
            if (res.data.code === '0000') {
              if (res.data.data === 'success') {
                callback()
              } else {
                callback(new Error('文件组名称已重复'))
              }
            }
          })
        } else {
          if (this.oldName !== this.temp.fileGroupName) {
            paramApi('system/sysFileGroup/checkFileGroupName', this.temp.fileGroupName, 'fileGroupName').then(res => {
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
    }
    var checkoutDescribe = (rule, value, callback) => {
      if (value && value.length > 150) {
        callback(new Error('描述的长度不能超过150个字符'))
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
        recordStatus: ''
      },
      statusOptions: [{
        value: '1',
        label: '生效'
      }, {
        value: '2',
        label: '未生效'
      }],
      fileGroupdialogFormVisible: false,
      dialogStatus: '',
      temp: {
        id: undefined,
        fileGroupName: undefined,
        recordStatus: undefined,
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
        recordStatus: [
          { required: true, message: '请选择状态', trigger: 'change' }
        ],
        fileGroupDescribe: [{ validator: checkoutDescribe, trigger: 'blur' }]
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
      this.listQuery.recordStatus = value
    },
    // 显示新增文件组对话框
    handleCreate() {
      // this.resetTemp()
      this.temp.fileGroupName = undefined
      this.temp.recordStatus = undefined
      this.temp.fileGroupDescribe = undefined
      this.dialogStatus = '新增文件组'
      this.fileGroupdialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['temp'].clearValidate()
      })
    },
    // 实现新增文件组信息
    createFileGroupData() {
      this.isDisabled = true
      this.$refs['temp'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api('system/sysFileGroup/add', this.temp).then(res => {
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
            this.fileGroupdialogFormVisible = false
            // 重置表单元素的数据
            this.$refs['temp'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.isDisabled = false
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
      this.temp.recordStatus = row.recordStatus.toString()
      this.$nextTick(() => {
        this.$refs['temp'].clearValidate()
      })
    },
    // 编辑文件组信息
    updateData() {
      this.isDisabled = true
      this.$refs['temp'].validate(valid => {
        if (valid) {
          // 通过验证
          api('system/sysFileGroup/update', this.temp).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            this.fileGroupdialogFormVisible = false
            this.initList()
          })
        } else {
          this.isDisabled = false
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
          paramApi('system/sysFileGroup/delete', id, 'ids').then(res => {
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
    // 项目初始化
    initList() {
      this.listLoading = true
      api('system/sysFileGroup/list', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.fileGroupList = res.data.data.rows
          this.total = res.data.data.total
          if (this.fileGroupList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
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
  .el-pagination{
    margin-top: 10px;
  }
</style>

<template>
  <div class="file-group-management">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="名称:">
          <el-input v-model="listQuery.filegroupname" placeholder="请输入名称" style="width: 150px;" class="filter-item" clearable />
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.status" placeholder="请选择" style="width: 150px;" clearable class="filter-item" @change="selecteUserStatus">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>
    <el-table v-loading="listLoading" :data="fileList" border fit highlight-current-row style="width: 100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="文件组名称" align="center" prop="filegroupName" />
      <el-table-column label="文件组编码" prop="filegroupCoding" align="center" />
      <el-table-column label="创建时间" prop="creationTime" width="120" align="center" />
      <el-table-column label="描述" prop="describe" align="center" />
      <el-table-column label="状态" prop="filegroupstatus" align="center" />
      <el-table-column label="操作" align="center" min-width="180" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteUser(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination v-show="total>0" :current-page="page" :page-sizes="[10, 20, 30, 40]" :page-size="rows" :total="total" layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    <!-- 新增文件组弹框 -->
    <el-dialog :visible.sync="filegroupdialogFormVisible" width="30%" title="新增文件组">
      <el-form
        ref="temp"
        :rules="rules"
        :model="temp"
        label-position="left"
        style="max-width:300px;margin:0 auto;"
        label-width="80px" >
        <el-form-item label="文件组" prop="filegroupName">
          <el-input v-model.trim="temp.filegroupName" />
        </el-form-item>
        <el-form-item label="状态" prop="filegroupstatus">
          <el-select v-model="temp.filegroupstatus" class="filter-item">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="dialogStatus==='create'?createUserData('temp'):updateData('temp')">提交</el-button>
        <el-button @click="filegroupdialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { addFilegroupList, updataFilegroup, allfilegroupList } from '@/api/filegroup'
export default {
  data() {
    return {
      listQuery: {
        filegroupname: '',
        status: ''
      },
      statusOptions: [
        { value: '1', label: '有效' },
        { value: '0', label: '无效' }
      ],
      filegroupdialogFormVisible: false,
      dialogStatus: '',
      temp: { filegroupName: '', filegroupstatus: '' },
      listLoading: false,
      fileList: [],
      page: 1,
      rows: 10,
      total: 0,
      rules: {
        filegroupName: [
          { required: true, message: '文件组名称不能为空', trigger: 'blur' }
        ],
        filegroupstatus: [
          { required: true, message: '状态不能为空', trigger: '' }
        ]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
  //  按条件查询
    handleFilter() {},
    // 选中时发生改变的值
    selecteUserStatus(value) {
      this.listQuery.status = value
    },
    // 清空信息
    resetTemp() {
      this.temp = {
        filegroupName: '',
        filegroupstatus: ''
      }
    },
    // 显示新增用户组对话框
    handleCreate() {
      this.resetTemp()
      this.dialogStatus = 'create'
      this.filegroupdialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['temp'].clearValidate()
      })
    },
    // 实现新增用户组信息
    createFliegroupData(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          addFilegroupList(this.temp).then(res => {
            console.log(res)
            // if (res.meta.status === 201) {
            //   this.$message({
            //     message: '添加成功',
            //     type: 'success'
            //   })
            // }
            // 将对话框隐藏
            this.adddialogFormVisible = false
            // 重置表单元素的数据
            this.$refs[formName].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.$message({
            message: '输入数据不合法',
            type: 'error'
          })
        }
      })
    },
    // 显示编辑用户组对话框
    handleUpdate(row) {
      this.dialogStatus = 'update'
      this.filegroupdialogFormVisible = true
      this.temp.filegroupName = row.filegroupName
      this.temp.filegroupstatus = row.filegroupstatus
    },
    // 编辑文件组信息
    updateData(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          // 通过验证
          updataFilegroup(this.temp).then(res => {
            if (res.meta.status === 200) {
              console.log(res)
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              this.filegroupdialogFormVisible = false
              this.initList()
            }
          })
        } else {
          this.$message({
            message: '输入数据不合法',
            type: 'error'
          })
        }
      })
    },
    // 删除文件
    deleteUser() {},
    // // 项目初始化
    // initList() {
    //   const list = [
    //     {
    //       filegroupName: '张三',
    //       filegroupCoding: 'zhansan',
    //       describe: '10000',
    //       creationTime: '2018/8/5 14:30',
    //       filegroupstatus: '生效'
    //     },
    //     {
    //       filegroupName: '李四',
    //       filegroupCoding: '李四',
    //       describe: '1235466d',
    //       creationTime: '2018/8/6 14:30',
    //       filegroupstatus: '生效'
    //     },
    //     {
    //       filegroupName: '测试1',
    //       filegroupCoding: 'ceshi',
    //       describe: '1235',
    //       creationTime: '2018/8/9 14:30',
    //       filegroupstatus: '失效'
    //     },
    //     {
    //       filegroupName: '张三',
    //       filegroupCoding: 'zhansan',
    //       describe: '123df',
    //       creationTime: '2018/8/5 14:30',
    //       filegroupstatus: '生效'
    //     }
    //   ]
    //   this.fileList = list
    // },
    // 项目初始化
    initList() {
      this.listLoading = true
      allfilegroupList({ page: 2, rows: 2 }).then(response => {
        console.log(response)
        // this.userList = response.data.data.rows
        // this.total = response.data.data.total
        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false
        }, 2000)
      })
    },
    // 改变每页的数据时触发
    handleSizeChange(val) {
      this.rows = val
    },
    // 改变当前页码触发
    handleCurrentChange(val) {
      this.page = val
    }
  }
}
</script>

<style lang="scss" scoped>
.file-group-management {
  padding: 20px;
  .fixed-width .el-button--mini {
    width: auto;
  }
}
.el-pagination{
  margin-top:20px;
}
</style>

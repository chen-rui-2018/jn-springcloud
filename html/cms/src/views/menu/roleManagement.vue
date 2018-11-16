<template>
  <div class="rolemanagement">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="角色名称:">
          <el-input v-model="listQuery.roleName" placeholder="请输入名称" style="width: 150px" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.status" placeholder="请选择" clearable class="filter-item" @change="selecteUserStatus">
            <el-option v-for="(item,index) in statusOptions" :key="item" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>
    <!-- 表格 -->
    <el-table v-loading="rolelistLoading" :data="roleList" border fit highlight-current-row style="width: 100%;height:100%">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="角色名称" align="center" prop="roleName"/>
      <el-table-column :show-overflow-tooltip="true" label="拥有用户" align="center" min-width="100" prop="sysUserRoles">
        <template slot-scope="scope">
          {{ scope.row.sysUserRoles.join('、') }}
      </template></el-table-column>
      <el-table-column :show-overflow-tooltip="true" label="权限" align="center" prop="sysRolePermissions" min-width="100">
        <template slot-scope="scope">
          {{ scope.row.sysRolePermissions.join('、') }}
        </template>
      </el-table-column>
      <el-table-column label="创建时间" width="150" align="center" prop="creationTime">
        <template slot-scope="scope">
          {{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.statusDesc }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="360" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button type="primary" size="mini" @click="showManagementDialog(scope.row)">授权用户</el-button>
          <el-button type="primary" size="mini" @click="showGroupmanagementDialog(scope.row)">授权用户组</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteUser(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10, 20, 30, 40]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />

    <!-- 新增角色 -->
    <el-dialog :visible.sync="roledialogFormVisible" title="添加角色" width="400px">
      <el-form ref="roleform" :rules="rules" :model="roleform" label-position="right" label-width="80px" style="max-width:300px;margin-left:20px">
        <el-form-item label="名称" prop="roleName">
          <el-input v-model="roleform.roleName" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="roleform.status" class="filter-item">
            <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="dialogStatus==='新增角色'?createUserData():updateData()">提交</el-button>
        <el-button @click="roledialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>
    <!-- 弹出的授权用户对话框 -->
    <el-dialog :visible.sync="managementdialogVisible" title="授权用户">
      <el-transfer
        v-model="value1"
        :data="managementdata"
        :titles="['用户名称', '用户名称']"
        filterable
        filter-placeholder="请输入用户名称" />
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="managementdialogVisible = false">确 定</el-button>
        <el-button @click="managementdialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>
    <!-- 弹出的授权用户组对话框 -->
    <el-dialog :visible.sync="groupManagementdialogVisible" title="授权用户组">
      <el-transfer
        v-model="value2"
        :data="groupManagementdata"
        :titles="['用户组名称', '用户组名称']"
        filterable
        filter-placeholder="请输入用户组名称" />
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="groupManagementdialogVisible = false">确 定</el-button>
        <el-button @click="groupManagementdialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  roleList, addRoleList, checkroleName
} from '@/api/Permission-model/roleManagement'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的用户组名称'))
      } else {
        checkroleName(this.roleform.roleName).then(response => {
          const result = response.data.data
          if (result === 'success') {
            callback()
          } else {
            callback(new Error('角色名称已重复'))
          }
        })
      }
    }
    return {
      dialogStatus: undefined,
      rolelistLoading: false,
      listQuery: {
        roleName: undefined,
        status: undefined,
        rows: 10,
        page: 1
      },
      statusOptions: ['不生效', '生效'],
      total: 0,
      value1: [],
      value2: [],
      roleList: [],
      managementdata: [{ key: 1, label: '张三' }, { key: 2, label: '李四' }, { key: 3, label: '李2' }],
      groupManagementdata: [{ key: 1, label: '用户组1' }, { key: 2, label: '用户组2' }, { key: 3, label: '用户组3' }],
      roledialogFormVisible: false,
      managementdialogVisible: false,
      groupManagementdialogVisible: false,
      roleform: {
        id: '',
        roleName: undefined,
        status: undefined
      },
      rules: {
        roleName: [
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
    // 清空信息
    resetuserGroupform() {
      this.roleform = {
        roleName: undefined,
        status: undefined
      }
    },
    // 弹出编辑角色对话框
    handleUpdate(row) {
      this.dialogStatus = '编辑角色'
      // 显示对话框
      this.roledialogFormVisible = true
      //   添加默认数据
      this.roleform.roleName = row.roleName
      if (row.status === '1') {
        this.roleform.status = '生效'
      } else if (row.status === '0') {
        this.roleform.status = '不生效'
      }
      this.roleform.id = row.id
    },
    // 编辑角色
    updateData() {},
    // 新增角色
    createUserData() {
      this.$refs['roleform'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.roledialogFormVisible = false
          // 调用接口发送请求
          addRoleList(this.roleform).then(res => {
            console.log(res)
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error('添加数据失败')
            }
            // 重置表单元素的数据
            this.$refs['roleform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.$message({
            message: '请输入数据',
            type: 'error'
          })
        }
      })
    },
    // 显示新增角色对话框
    handleCreate() {
      this.resetuserGroupform()
      this.dialogStatus = '新增角色'
      this.roledialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['roleform'].clearValidate()
      })
    },
    // 状态改变时触发
    selecteUserStatus(value) {
      this.listQuery.status = value
    },
    // 搜素功能实现
    handleFilter() {
      this.initList()
    },
    // 删除用户功能实现
    deleteUser(id) {
      this.$confirm(
        `此操作将永久删除id号为${id}的数据, 是否继续?`,
        '删除提示',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }
      )
        .then(() => {
          // deleteUserById(id).then(res => {
          //   if (res.meta.status === 200) {
          this.$message({
            message: '删除成功', //    res.meta.msg,
            type: 'success'
          })
          // this.initList()
          // } else {
          //   this.$message({
          //     message: res.meta.msg,
          //     type: 'success'
          //   })
          // }
          // })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
    // 显示授权用户对话框
    showManagementDialog(row) {
      console.log(row)
      this.managementdialogVisible = true
      this.managementdata.forEach((val, index) => {
        if (this.managementdata[index].label === row.name) {
          console.log(index)
          this.value1.push(index)
        }
      })
    },
    // 显示授权用户组对话框
    showGroupmanagementDialog(row) {
      console.log(row)
      this.groupManagementdialogVisible = true
      this.groupManagementdata.forEach((val, index) => {
        if (this.groupManagementdata[index].label === row.groupname) {
          console.log(index)
          this.value2.push(index)
        }
      })
    },
    //  显示编辑角色对话框
    showEditDialog(row) {
      console.log(row)
      // 显示对话框
      this.editdialogFormVisible = true
      //   添加默认数据
      this.editform.rolename = row.rolename
      this.editform.status = row.status
    },
    editUserSubmit() {

    },
    // 项目初始化
    initList() {
      this.rolelistLoading = true
      roleList(this.listQuery).then(res => {
        console.log(res)
        if (res.data.code === '0000') {
          this.roleList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error('获取数据失败')
        }
        this.rolelistLoading = false
      })
    },
    // 分页功能
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`)
    }
  }
}
</script>

<style lang="scss" scoped>
.rolemanagement {
  padding: 20px;
  .fixed-width .el-button--mini {
    width: auto;
  }
}
</style>

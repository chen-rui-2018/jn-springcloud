<template>
  <div class="management">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="用户组名称:">
          <el-input v-model="listQuery.groupName" placeholder="请输入名称" style="width: 150px" class="filter-item" clearable @keyup.enter.native="handleFilter" />
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
    <el-table v-loading="listLoading" :key="tableKey" :data="usergroupList" border fit highlight-current-row style="width: 100%;height:100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="用户组名称" align="center" prop="groupName" />
      <el-table-column :show-overflow-tooltip="true" label="拥有用户" align="center" min-width="100" prop="sysTUserList">
        <template slot-scope="scope">
          {{ scope.row.sysTUserList.join('、') }}
      </template></el-table-column>
      <el-table-column :show-overflow-tooltip="true" label="角色名称" align="center" prop="sysRoleList" min-width="120">
        <template slot-scope="scope">
          {{ scope.row.sysRoleList.join('、') }}
        </template>
      </el-table-column>
      <el-table-column label="创建时间" width="150" align="center" prop="creationTime">
        <template slot-scope="scope">
          {{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status | statusFilter }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button type="primary" size="mini" @click="showuserGruopDialog(scope.row)">授权用户</el-button>
          <el-button type="primary" size="mini" @click="showRoleDialog(scope.row.id)">角色</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteUsergroup(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="pagination-container">
      <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[5,10,20,30, 50]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <!-- 弹出的用户组对话框 -->
    <el-dialog :visible.sync="userGroupdialogFormVisible" :title="dialogStatus" width="400px">
      <el-form ref="userGroupform" :rules="rules" :model="userGroupform" label-position="right" label-width="100px" style="max-width:300px;margin-left:20px">
        <el-form-item label="用户组" prop="groupName">
          <el-input v-model.trim="userGroupform.groupName" max-length="20" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="userGroupform.status" class="filter-item">
            <el-option v-for="(item,index) in statusOptions" :key="item" :label="item" :value="index" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="dialogStatus==='新增用户组'?createUserData():updateData()">提交</el-button>
        <el-button @click="cancelEdit()">取消</el-button>
      </div>
    </el-dialog>
    <!-- 弹出的角色对话框 -->
    <el-dialog :visible.sync="roledialogVisible" title="授权角色" width="561px">
      <el-transfer v-loading="roleLoading" v-model="roleIds" :data="roleData" :titles="['其他角色', '用户组拥有角色']" filterable filter-placeholder="请输入角色名称" @change="handleRoleChange" />
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitRoledata">确 定</el-button>
        <el-button @click="roledialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>

    <!-- 弹出的授權用户对话框 -->
    <el-dialog :visible.sync="userdialogVisible" title="授权用户" width="800px">
      <el-transfer v-loading="userLoading" v-model="userIds" :data="userData" :titles="['其他用户', '用户组拥有用户']" target-order="unshift" filterable filter-placeholder="请输入用户名称" class="box" @change="handleUserChange">
        <span slot="left-footer" size="small">
          <el-pagination :page-size="userRows" :current-page="userPage" :pager-count="5" :total="userTotal" background layout="prev, pager, next" @current-change="handleUserCurrentChange" />
        </span>
        <span slot="right-footer" size="small" />
      </el-transfer>
      <!-- <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitUserdata">提 交</el-button>
        <el-button @click="cancelUpdata()">取 消</el-button>
      </span> -->
    </el-dialog>

  </div>

</template>

<script>
import {
  groupList,
  addgroupList,
  editgroupList,
  deleteUsergroupById,
  checkGroupName,
  getAllRole,
  updataRole,
  updataUser,
  // getAllUser,
  getAllUserInfo
} from '@/api/Permission-model/userGroup'
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
      const reg = /[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的用户组名称'))
      } else {
        if (this.oldGroupName !== this.userGroupform.groupName) {
          checkGroupName(this.userGroupform.groupName).then(response => {
            const result = response.data.data
            if (result === 'success') {
              callback()
            } else {
              callback(new Error('用户组名称已重复'))
            }
          })
        } else {
          callback()
        }
      }
    }
    return {
      oldOwnUser: [],
      moveArr: 0,
      oldGroupName: undefined,
      userGroupId: undefined,
      userTotal: null,
      userIds: [],
      userData: [],
      userLoading: false,
      roleLoading: false,
      groupId: undefined,
      dialogStatus: undefined,
      tableKey: 0,
      userRows: 10,
      userPage: 1,
      listLoading: false,
      roleData: [],
      roleIds: [],
      total: null,
      usergroupList: [],
      listQuery: {
        groupName: undefined,
        status: undefined,
        rows: 10,
        page: 1
      },
      userGroupdialogFormVisible: false,
      userdialogVisible: false,
      roledialogVisible: false,
      statusOptions: ['未生效', '生效'],
      userGroupform: {
        id: '',
        groupName: undefined,
        status: undefined
      },
      rules: {
        groupName: [
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
    // 显示角色对话框
    showRoleDialog(id) {
      this.roleLoading = true
      this.groupId = id
      this.roledialogVisible = true
      getAllRole(id).then(res => {
        const allRoledata = []
        const result = res.data.data.sysRoleAll
        const checkResult = res.data.data.roleAllOfGroup
        const checkRoledata = []
        result.forEach((val, index) => {
          allRoledata.push({
            label: val.roleName,
            key: val.id,
            index: index
          })
        })
        checkResult.forEach((val, index) => {
          checkRoledata.push(val.id)
        })
        this.roleData = allRoledata
        this.roleIds = checkRoledata
        this.roleLoading = false
      })
    },
    // 提交授权后的角色
    submitRoledata() {
      updataRole({ groupId: this.groupId, roleIds: this.roleIds }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error('授权失败')
        }
        this.roledialogVisible = false
        this.initList()
      })
    },
    // 显示授权用户对话框
    showuserGruopDialog(row) {
      this.userPage = 1
      this.userLoading = true
      this.userGroupId = row.id
      this.userdialogVisible = true
      this.getUser()
    },
    // 根据用户组id获取用户组拥有的用户和其他用户
    getUser() {
      getAllUserInfo({ groupId: this.userGroupId, page: this.userPage, rows: this.userRows }).then(res => {
        res.data.data.rows.userAllOfGroup.forEach((val) => {
          this.oldOwnUser.push(val.id)
        })
        const userData = []
        const checkUser = []
        this.userTotal = res.data.data.total
        res.data.data.rows.userList.forEach((val, index) => {
          userData.push({
            label: val.name,
            key: val.id
          })
        })
        res.data.data.rows.userAllOfGroup.forEach((val, index) => {
          checkUser.push(val.id)
        })
        this.userData = userData
        this.userIds = checkUser
        this.userLoading = false
      })
    },
    // 授权用户分页功能
    handleUserCurrentChange(val) {
      if (this.userTotal - this.moveArr > (val - 1) * this.userRows) {
        this.userPage = val
      } else {
        this.userPage = val - 1
      }
      this.userLoading = true
      this.getUser()
    },
    // 取消更改
    // cancelUpdata() {
    //   this.userdialogVisible = false
    //   updataUser({ groupId: this.userGroupId, userIds: Array.from(new Set(this.oldOwnUser)) }).then(
    //     res => {
    //       if (res.data.code === '0000') {
    //         this.$message({
    //           message: '取消授权成功',
    //           type: 'success'
    //         })
    //       }
    //       this.initList()
    //     }
    //   )
    //   this.oldOwnUser = []
    // },
    // 提交授权后的用户
    // submitUserdata() {
    //   this.userdialogVisible = false
    //   // this.initList()
    // },
    // 改变授权用户穿梭框时获取选中的用户
    handleUserChange(value, direction, movedKeys) {
      this.userIds = value
      if (direction === 'left') {
        this.moveArr = -(movedKeys.length)
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      updataUser({ groupId: this.userGroupId, userIds: this.userIds }).then(
        res => {
          if (res.data.code === '0000') {
            this.$message({
              message: '授权成功',
              type: 'success'
            })
          } else {
            this.$message.error('授权失败')
          }
          // this.userdialogVisible = false
          this.initList()
        }
      )
    },
    selecteUserStatus(value) {
      this.listQuery.status = value
    },
    //   搜素功能的实现
    handleFilter() {
      this.initList()
    },
    // 清空信息
    resetuserGroupform() {
      this.userGroupform = {
        groupName: undefined,
        status: undefined
      }
    },
    // 显示新增用户组对话框
    handleCreate() {
      this.resetuserGroupform()
      this.dialogStatus = '新增用户组'
      this.userGroupdialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['userGroupform'].clearValidate()
      })
    },
    // 实现添加用户功能
    createUserData() {
      this.$refs['userGroupform'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          addgroupList(this.userGroupform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            }
            // 将对话框隐藏
            this.userGroupdialogFormVisible = false
            // 重置表单元素的数据
            this.$refs['userGroupform'].resetFields()
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
    // 取消编辑
    cancelEdit() {
      this.$nextTick(() => {
        this.$refs['userGroupform'].clearValidate()
      })
      this.userGroupdialogFormVisible = false
    },
    // 弹出编辑对话框
    handleUpdate(row) {
      this.oldGroupName = row.groupName
      // 显示对话框
      this.userGroupdialogFormVisible = true
      //   添加默认数据
      this.dialogStatus = '编辑用户组'
      this.userGroupform.groupName = row.groupName
      this.userGroupform.status = parseInt(row.status)
      this.userGroupform.id = row.id
    },
    // 编辑用户的功能实现
    updateData() {
      this.$refs['userGroupform'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.userGroupdialogFormVisible = false
          // 调用接口发送请求
          editgroupList(this.userGroupform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            }
            // 重置表单元素的数据
            this.$refs['userGroupform'].resetFields()
            this.$nextTick(() => {
              this.$refs['userGroupform'].clearValidate()
            })
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
    // 改变穿梭框的值触发
    handleRoleChange(value) {
      this.roleIds = value
    },

    // 删除用户功能实现
    deleteUsergroup(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deleteUsergroupById(id).then(res => {
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
    // 项目初始化
    initList() {
      this.listLoading = true
      groupList(this.listQuery).then(response => {
        this.usergroupList = response.data.data.rows
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

<style lang="scss">
.management {
  display: flex;
  flex-direction: column;
  // height: 100%;
  .fixed-width .el-button--mini {
    width: auto;
  }
}
.box {
  .el-transfer-panel {
    width: 320px;
  }
  .el-transfer-panel .el-transfer-panel__footer {
    position: relative;
  }
}
.el-dialog{

.el-dialog__footer{
  text-align: center ;
}
}
</style>

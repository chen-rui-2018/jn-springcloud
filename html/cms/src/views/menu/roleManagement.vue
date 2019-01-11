<template>
  <div v-loading="rolelistLoading" class="rolemanagement">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="角色名称:">
          <el-input v-model="listQuery.roleName" placeholder="请输入名称" maxlength="20" class="filter-item" clearable @keyup.enter.native="handleFilter" />
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
    <el-table :data="roleList" border fit highlight-current-row style="width: 100%;height:100%">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" label="序号" width="60"/>
      <!-- 表格第二列  姓名 -->
      <el-table-column label="角色名称" align="center" prop="roleName" />
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
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status==0?'未生效':'生效' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="400" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button type="primary" size="mini" @click="showUserDialog(scope.row.roleId)">授权用户</el-button>
          <el-button type="primary" size="mini" @click="showUserGroupDialog(scope.row.roleId)">授权用户组</el-button>
          <el-button type="primary" size="mini" @click="showAuthorityDialog(scope.row.roleId)">授权权限</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteRole(scope.row.roleId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10, 20, 30, 40]" :page-size="listQuery.rows" :total="total" class="tablePagination" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />

    <!-- 新增角色 -->
    <template v-if="roledialogFormVisible">
      <el-dialog :visible.sync="roledialogFormVisible" :title="dialogStatus" width="400px">
        <el-form ref="roleform" :rules="rules" :model="roleform" label-position="right" label-width="80px" style="max-width:300px;margin-left:20px">
          <el-form-item label="名称:" prop="roleName">
            <el-input v-model="roleform.roleName" maxlength="20"/>
          </el-form-item>
          <el-form-item label="状态:" prop="status" >
            <el-select v-model="roleform.status" placeholder="请选择" class="filter-item">
              <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增角色'?createUserData():updateData()">提交</el-button>
          <el-button @click="roledialogFormVisible = false">取消</el-button>
        </div>
      </el-dialog>
    </template>
    <!-- 弹出的授权用户对话框 -->
    <template v-if="userdialogVisible">
      <el-dialog :visible.sync="userdialogVisible" title="授权用户" width="800px">
        <el-transfer v-loading="userLoading" v-model="userId" :data="userData" :titles="['其他用户', '角色拥有用户']" filterable filter-placeholder="请输入用户名称" class="box" @change="handleUserChange">
          <span slot="left-footer" size="small">
            <el-pagination :current-page="userPage" :pager-count="5" :total="userTotal" background layout="prev, pager, next" @current-change="handleUserCurrentChange" />
          </span>
          <span slot="right-footer" size="small" />
        </el-transfer>
      </el-dialog>
    </template>
    <!-- 弹出的授权用户组对话框 -->
    <template v-if="userGroup.userGroupdialogVisible">
      <el-dialog :visible.sync="userGroup.userGroupdialogVisible" title="授权用户组" width="800px">
        <el-transfer v-loading="userGroup.userGroupLoading" v-model="userGroup.userGroupId" :data="userGroup.userGroupData" :titles="['其他用户组', '角色拥有用户组']" filterable filter-placeholder="请输入用户组名称" class="box" @change="handleUserGroupChange">
          <span slot="left-footer" size="small">
            <el-pagination :current-page="userPage" :pager-count="5" :total="userTotal" background layout="prev, pager, next" @current-change="handleUserGroupCurrentChange" />
          </span>
          <span slot="right-footer" size="small" />
        </el-transfer>
      </el-dialog>
    </template>
    <!-- 弹出的授权权限对话框 -->
    <template v-if="authoritydialogVisible">
      <el-dialog :visible.sync="authoritydialogVisible" title="授权权限" width="800px">
        <el-transfer v-loading="authorityLoading" v-model="authorityIds" :data="authorityData" :titles="['其他权限', '角色拥有权限']" filterable filter-placeholder="请输入权限名称" class="box" @change="handleAuthorityChange">
          <span slot="left-footer" size="small">
            <el-pagination :current-page="authorityPage" :pager-count="5" :total="authorityTotal" background layout="prev, pager, next" @current-change="handleAuthorityCurrentChange" />
          </span>
          <span slot="right-footer" size="small" />
        </el-transfer>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import {
  roleList,
  addRoleList,
  checkRoleName,
  editRoleList,
  deleteRoleById,
  getAllUserInfo,
  updataUser,
  getUserGroupInfo, updataUserGroup, getAuthorityInfo, updataAuthority
} from '@/api/Permission-model/roleManagement'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.oldRoleName !== this.roleform.roleName) {
          checkRoleName(this.roleform.roleName).then(res => {
            // if (res.data.code === '0000') {
            if (res.data.data === 'success') {
              callback()
            } else {
              callback(new Error('角色名称已重复'))
            }
            // }
          })
        } else {
          callback()
        }
      }
    }
    return {
      isDisabled: false,
      authorityPage: 1,
      authorityRows: 10,
      authorityData: [],
      authorityIds: [],
      authorityLoading: false,
      authorityTotal: undefined,
      authoritydialogVisible: false,
      userGroup: {
        userGroupdialogVisible: false,
        userGroupLoading: false,
        userGroupId: [],
        userGroupData: []
      },
      moveArr: 0,
      oldOwnUser: [],
      roleId: undefined,
      userPage: 1,
      userRows: 10,
      userTotal: null,
      userLoading: false,
      oldRoleName: undefined,
      dialogStatus: undefined,
      rolelistLoading: false,
      listQuery: {
        roleName: undefined,
        status: undefined,
        rows: 10,
        page: 1
      },
      statusOptions: ['未生效', '生效'],
      total: 0,
      userId: [],
      roleList: [],
      userData: [],
      roledialogFormVisible: false,
      userdialogVisible: false,
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
        status: [{ required: true, message: '请选择状态', trigger: 'change' }]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    // 授权权限分页功能
    handleAuthorityCurrentChange(val) {
      if (this.authorityTotal - this.moveArr > (val - 1) * this.authorityRows) {
        this.authorityPage = val
      } else {
        this.authorityPage = val - 1
      }
      this.authoritydialogVisible = true
      this.getAuthority()
    },
    // 改变授权权限穿梭框时获取选中的权限
    handleAuthorityChange(value, direction, movedKeys) {
      this.authorityIds = value
      if (direction === 'left') {
        this.moveArr = -movedKeys.length
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      updataAuthority({ roleId: this.roleId, permissionId: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.initList()
      })
    },
    // 显示授权权限对话框
    showAuthorityDialog(id) {
      this.authorityPage = 1
      this.authorityLoading = true
      this.roleId = id
      this.authoritydialogVisible = true
      this.getAuthority()
    },
    getAuthority() {
      getAuthorityInfo({
        roleId: this.roleId,
        page: this.authorityPage,
        rows: this.authorityRows
      }).then(res => {
        if (res.data.code === '0000') {
          const authorityData = []
          const checkAuthority = []
          this.authorityTotal = res.data.data.total
          res.data.data.rows.otherPermissionList.forEach((val, index) => {
            authorityData.push({
              label: val.permissionName,
              key: val.id
            })
          })
          res.data.data.rows.permissionOfRoleList.forEach(val => {
            checkAuthority.push(val.id)
          })
          this.authorityData = authorityData
          this.authorityIds = checkAuthority
        } else {
          this.$message.error(res.data.result)
        }

        this.authorityLoading = false
      })
    },

    // 改变授权用户组穿梭框时获取选中的用户组
    handleUserGroupChange(value, direction, movedKeys) {
      this.userGroup.userGroupId = value
      if (direction === 'left') {
        this.moveArr = -movedKeys.length
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      updataUserGroup({ roleId: this.roleId, userGroupId: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 授权用户组分页功能
    handleUserGroupCurrentChange(val) {
      if (this.userTotal - this.moveArr > (val - 1) * this.userRows) {
        this.userPage = val
      } else {
        this.userPage = val - 1
      }
      this.userGroup.userGroupLoading = true
      this.getUserGroup()
    },
    // 显示授权用户组对话框
    showUserGroupDialog(id) {
      this.userPage = 1
      this.userGroup.userGroupLoading = true
      this.roleId = id
      this.userGroup.userGroupdialogVisible = true
      this.getUserGroup()
    },
    getUserGroup() {
      getUserGroupInfo({
        roleId: this.roleId,
        page: this.userPage,
        rows: this.userRows
      }).then(res => {
        if (res.data.code === '0000') {
          const userGroupData = []
          const checkUserGroup = []
          this.userTotal = res.data.data.total
          res.data.data.rows.otherUserGroupList.forEach((val, index) => {
            userGroupData.push({
              label: val.groupName,
              key: val.groupId
            })
          })
          res.data.data.rows.userGroupOfRoleList.forEach(val => {
            checkUserGroup.push(val.groupId)
          })
          this.userGroup.userGroupData = userGroupData
          this.userGroup.userGroupId = checkUserGroup
        } else {
          this.$message.error(res.data.result)
        }

        this.userGroup.userGroupLoading = false
      })
    },
    getUser() {
      getAllUserInfo({
        roleId: this.roleId,
        page: this.userPage,
        rows: this.userRows
      }).then(res => {
        if (res.data.code === '0000') {
          res.data.data.rows.userOfRoleList.forEach(val => {
            this.oldOwnUser.push(val.id)
          })
          const userData = []
          const checkUser = []
          this.userTotal = res.data.data.total
          res.data.data.rows.otherUserList.forEach((val, index) => {
            userData.push({
              label: val.name,
              key: val.id
            })
          })
          res.data.data.rows.userOfRoleList.forEach((val, index) => {
            checkUser.push(val.id)
          })
          this.userData = userData
          this.userId = checkUser
        } else {
          this.$message.error(res.data.result)
        }

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
    // 改变授权用户穿梭框时获取选中的用户
    handleUserChange(value, direction, movedKeys) {
      this.userId = value
      if (direction === 'left') {
        this.moveArr = -movedKeys.length
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      updataUser({ roleId: this.roleId, userId: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.initList()
      })
    },
    // 显示授权用户对话框
    showUserDialog(id) {
      this.userPage = 1
      this.userLoading = true
      this.roleId = id
      this.userdialogVisible = true
      this.getUser()
    },
    // 清空信息
    resetuserGroupform() {
      this.roleform = {
        roleName: undefined,
        status: undefined
      }
    },
    // 弹出编辑角色对话框
    handleUpdate(row) {
      // 显示对话框
      this.roledialogFormVisible = true
      this.dialogStatus = '编辑角色'
      //   添加默认数据
      this.oldRoleName = row.roleName
      this.roleform.roleName = row.roleName
      this.roleform.status = parseInt(row.status)
      this.roleform.id = row.roleId
      this.$nextTick(() => {
        this.$refs['roleform'].clearValidate()
      })
    },
    // 编辑角色
    updateData() {
      this.$refs['roleform'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          // // 调用接口发送请求
          editRoleList(this.roleform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 重置表单元素的数据
            this.$refs['roleform'].resetFields()
            // 将对话框隐藏
            this.roledialogFormVisible = false
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 新增角色
    createUserData() {
      this.isDisabled = true
      this.$refs['roleform'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          addRoleList(this.roleform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 重置表单元素的数据
            this.$refs['roleform'].resetFields()
            // 将对话框隐藏
            this.roledialogFormVisible = false
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.isDisabled = false
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
      this.listQuery.page = 1
      this.initList()
    },
    // 删除角色功能实现
    deleteRole(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deleteRoleById(id).then(res => {
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
      this.rolelistLoading = true
      roleList(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.roleList = res.data.data.rows
          this.total = res.data.data.total
          if (this.roleList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.rolelistLoading = false
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

<style lang="scss" >
.rolemanagement {
  .filter-container {
    .el-form-item {
      margin-bottom: 0;
    }
  }
  .fixed-width .el-button--mini {
    width: auto;
  }
}
.el-tooltip__popper{
   text-align: center;
    width:260px;
}
.box {
   .el-transfer-panel {
    height: 440px;
    width: 320px;
  }
  .el-transfer-panel .el-transfer-panel__footer {
    position: relative;
  }
  .el-transfer-panel__body.is-with-footer{
    height: 350px;
  }
  .el-transfer-panel__list.is-filterable{
    height: 310px;
  }
}
</style>

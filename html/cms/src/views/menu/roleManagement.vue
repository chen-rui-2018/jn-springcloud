<template>
  <div v-loading="rolelistLoading" class="rolemanagement">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="角色名称:">
          <el-input v-model="listQuery.roleName" placeholder="请输入名称" maxlength="20" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable class="filter-item" @change="selecteUserStatus">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
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
      <el-table-column label="创建时间" min-width="200" align="center" prop="createdTime">
        <!-- <template slot-scope="scope">
          {{ scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template> -->
      </el-table-column>
      <el-table-column label="状态" align="center" prop="recordStatus">
        <template slot-scope="scope">
          <span :class="scope.row.recordStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.recordStatus==1?'生效':'未生效' }}</span>
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
            <el-input v-model="roleform.roleName" maxlength="20" clearable/>
          </el-form-item>
          <el-form-item label="状态:" prop="recordStatus" >
            <el-select v-model="roleform.recordStatus" placeholder="请选择" class="filter-item" style="width:100%">
              <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
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
        <div class=" transfer-search el-transfer-panel__filter el-input el-input--small el-input--prefix"><!----><input v-model="userName" type="text" autocomplete="off" placeholder="请输入用户名称" class="el-input__inner" clearable><span class="el-input__prefix"><i class="el-input__icon el-icon-search"/><!----></span><!----><!----></div>
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
        <div class=" transfer-search el-transfer-panel__filter el-input el-input--small el-input--prefix"><!----><input v-model="userGroupName" type="text" autocomplete="off" placeholder="请输入用户组名称" class="el-input__inner" clearable><span class="el-input__prefix"><i class="el-input__icon el-icon-search"/><!----></span><!----><!----></div>
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
        <div class=" transfer-search el-transfer-panel__filter el-input el-input--small el-input--prefix">
          <input v-model="permissionName" type="text" autocomplete="off" placeholder="请输入权限名称" class="el-input__inner" clearable>
          <span class="el-input__prefix">
            <i class="el-input__icon el-icon-search"/>
          </span>
        </div>
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
import { api, paramApi } from '@/api/axios'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.dialogStatus === '新增角色') {
          paramApi(`${this.GLOBAL.systemUrl}system/sysRole/checkRoleName`, this.roleform.roleName, 'roleName').then(res => {
            // if (res.data.code === '0000') {
            if (res.data.data === 'success') {
              callback()
            } else {
              callback(new Error('角色名称已重复'))
            }
            // }
          })
        } else {
          if (this.oldRoleName !== this.roleform.roleName) {
            paramApi(`${this.GLOBAL.systemUrl}system/sysRole/checkRoleName`, this.roleform.roleName, 'roleName').then(res => {
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
    }
    return {
      permissionName: '',
      userGroupName: '',
      userName: '',
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
        recordStatus: undefined,
        rows: 10,
        page: 1
      },
      statusOptions: [{
        value: '1',
        label: '生效'
      }, {
        value: '2',
        label: '未生效'
      }],
      total: 0,
      userId: [],
      roleList: [],
      userData: [],
      roledialogFormVisible: false,
      userdialogVisible: false,
      roleform: {
        id: '',
        roleName: undefined,
        recordStatus: undefined
      },
      rules: {
        roleName: [
          { required: true, message: '请输入用户组名称', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        recordStatus: [{ required: true, message: '请选择状态', trigger: 'change' }]
      }
    }
  },
  watch: {
    userName: function(newVal, oldVal) {
      this.userPage = 1
      this.getUser()
    },
    userGroupName: function(newVal, oldVal) {
      this.userPage = 1
      this.getUserGroup()
    },
    permissionName: function(newVal, oldVal) {
      this.authorityPage = 1
      this.getAuthority()
    }
  },
  created() {
    this.initList()
  },
  methods: {
    // 授权权限分页功能
    handleAuthorityCurrentChange(val) {
      if (this.authorityTotal > (val - 1) * this.authorityRows) {
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
      this.authorityTotal = this.authorityTotal - this.moveArr
      if (this.authorityTotal > (this.authorityPage - 1) * this.authorityRows) {
        this.authorityPage = this.authorityPage
      } else {
        this.authorityPage = this.authorityPage - 1
      }
      api(`${this.GLOBAL.systemUrl}system/sysRole/rolePermissionAuthorization`, { roleId: this.roleId, permissionId: value }, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.initList()
        this.getAuthority()
      })
    },
    // 显示授权权限对话框
    showAuthorityDialog(id) {
      this.authorityPage = 1
      this.authorityLoading = true
      this.roleId = id
      this.permissionName = ''
      this.authoritydialogVisible = true
      this.getAuthority()
    },
    getAuthority() {
      api(`${this.GLOBAL.systemUrl}system/sysRole/findPermissionOrRoleAndOtherPermission`, {
        roleId: this.roleId,
        page: this.authorityPage,
        rows: this.authorityRows,
        permissionName: this.permissionName
      }, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
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
      this.userTotal = this.userTotal - this.moveArr
      if (this.userTotal > (this.userPage - 1) * this.userRows) {
        this.userPage = this.userPage
      } else {
        this.userPage = this.userPage - 1
      }
      api(`${this.GLOBAL.systemUrl}/system/sysRole/userGroupRoleAuthorization`, { roleId: this.roleId, userGroupId: value }, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.initList()
        this.getUserGroup()
      })
    },
    // 授权用户组分页功能
    handleUserGroupCurrentChange(val) {
      if (this.userTotal > (val - 1) * this.userRows) {
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
      this.userGroupName = ''
      this.userGroup.userGroupdialogVisible = true
      this.getUserGroup()
    },
    getUserGroup() {
      api(`${this.GLOBAL.systemUrl}system/sysRole/findUserGroupOfRoleAndOtherGroup`, {
        roleId: this.roleId,
        page: this.userPage,
        rows: this.userRows,
        userGroupName: this.userGroupName
      }, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
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
      api(`${this.GLOBAL.systemUrl}system/sysRole/findUserOfRoleAndOtherUser`, {
        roleId: this.roleId,
        page: this.userPage,
        rows: this.userRows,
        userName: this.userName
      }, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
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
      if (this.userTotal > (val - 1) * this.userRows) {
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
      this.userTotal = this.userTotal - this.moveArr
      if (this.userTotal > (this.userPage - 1) * this.userRows) {
        this.userPage = this.userPage
      } else {
        this.userPage = this.userPage - 1
      }
      api(`${this.GLOBAL.systemUrl}system/sysRole/userRoleAuthorization`, { roleId: this.roleId, userId: value }, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.initList()
        this.getUser()
      })
    },
    // 显示授权用户对话框
    showUserDialog(id) {
      this.userPage = 1
      this.userLoading = true
      this.roleId = id
      this.userName = ''
      this.userdialogVisible = true
      this.getUser()
    },
    // 弹出编辑角色对话框
    handleUpdate(row) {
      // 显示对话框
      this.roledialogFormVisible = true
      this.dialogStatus = '编辑角色'
      //   添加默认数据
      this.oldRoleName = row.roleName
      this.roleform.roleName = row.roleName
      this.roleform.recordStatus = row.recordStatus.toString()
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
          api(`${this.GLOBAL.systemUrl}system/sysRole/update`, this.roleform, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
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
          api(`${this.GLOBAL.systemUrl}system/sysRole/add`, this.roleform, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
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
      this.roleform.roleName = ''
      this.roleform.recordStatus = ''
      this.dialogStatus = '新增角色'
      this.roledialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['roleform'].clearValidate()
      })
    },
    // 状态改变时触发
    selecteUserStatus(value) {
      this.listQuery.recordStatus = value
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
          paramApi(`${this.GLOBAL.systemUrl}system/sysRole/delete`, id, 'ids').then(res => {
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
    // 项目初始化
    initList() {
      this.rolelistLoading = true
      api(`${this.GLOBAL.systemUrl}system/sysRole/list`, this.listQuery, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
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
   >.el-pagination{
    margin-top:15px;
  }
  .filter-container {
    .el-form-item {
      margin-bottom: 0;
    }
  }
  .fixed-width .el-button--mini {
    width: auto;
  }
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

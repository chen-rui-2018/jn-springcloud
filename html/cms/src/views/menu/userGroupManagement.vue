<template>
  <div v-loading="listLoading" class="management">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="用户组名称:">
          <el-input v-model="listQuery.groupName" maxlength="20" placeholder="请输入名称" class="filter-item" clearable @keyup.enter.native="handleFilter" />
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
    <el-table :key="tableKey" :data="usergroupList" border fit highlight-current-row style="width: 100%;height:100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" width="60" label="序号" align="center" />
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
      <el-table-column label="创建时间" min-width="200" align="center" prop="createdTime"/>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.recordStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.recordStatus | statusFilter }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="300" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button type="primary" size="mini" @click="showuserGruopDialog(scope.row)">授权用户</el-button>
          <el-button type="primary" size="mini" @click="showRoleDialog(scope.row.id)">授权角色</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteUsergroup(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      v-show="total>0"
      :current-page="listQuery.page"
      :page-sizes="[5,10,20,30, 50]"
      :page-size="listQuery.rows"
      :total="total"
      class="tablePagination"
      background
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />

    <!-- 弹出的用户组对话框 -->
    <template v-if="userGroupdialogFormVisible">
      <el-dialog :visible.sync="userGroupdialogFormVisible" :title="dialogStatus" width="400px">
        <el-form ref="userGroupform" :rules="rules" :model="userGroupform" label-position="right" label-width="80px" style="max-width:300px;margin-left:20px">
          <el-form-item label="用户组:" prop="groupName">
            <el-input v-model.trim="userGroupform.groupName" maxlength="20" clearable/>
          </el-form-item>
          <el-form-item label="状态:" prop="recordStatus">
            <el-select v-model="userGroupform.recordStatus" placeholder="请选择" class="filter-item" clearable style="width:100%">
              <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增用户组'?createUserData():updateData()">提交</el-button>
          <el-button @click="userGroupdialogFormVisible = false">取消</el-button>
        </div>
      </el-dialog>
    </template>
    <!-- 弹出授权角色对话框 -->
    <template v-if="roledialogVisible">
      <el-dialog :visible.sync="roledialogVisible" title="授权角色" width="800px">
        <div class=" transfer-search el-transfer-panel__filter el-input el-input--small el-input--prefix">
          <input v-model="roleName" type="text" autocomplete="off" placeholder="请输入角色名称" class="el-input__inner" clearable>
          <span class="el-input__prefix">
            <i class="el-input__icon el-icon-search"/>
          </span>
        </div>
        <el-transfer
          v-loading="roleLoading"
          v-model="roleIds"
          :data="roleData"
          :titles="['其他角色', '用户组拥有角色']"
          filterable
          filter-placeholder="请输入角色名称"
          class="box"
          @change="handleRoleChange">
          <span slot="left-footer" size="small">
            <el-pagination :current-page="numberPage" :pager-count="5" :total="numberTotal" background layout="prev, pager, next" @current-change="handleRoleCurrentChange" />
          </span>
          <span slot="right-footer" size="small" />
        </el-transfer>
      </el-dialog>
    </template>
    <!-- 弹出的授權用户对话框   -->
    <template v-if="userdialogVisible">
      <el-dialog :visible.sync="userdialogVisible" title="授权用户" width="800px">
        <div class=" transfer-search el-transfer-panel__filter el-input el-input--small el-input--prefix">
          <input v-model="name" type="text" autocomplete="off" placeholder="请输入用户名称" class="el-input__inner" clearable>
          <span class="el-input__prefix">
            <i class="el-input__icon el-icon-search"/>
          </span>
        </div>
        <el-transfer v-loading="userLoading" v-model="userIds" :data="userData" :titles="['其他用户', '用户组拥有用户']" target-order="unshift" filterable filter-placeholder="请输入用户名称" class="box" @change="handleUserChange">
          <span slot="left-footer" size="small">
            <el-pagination :page-size="userRows" :current-page="userPage" :pager-count="5" :total="userTotal" background layout="prev, pager, next" @current-change="handleUserCurrentChange" />
          </span>
          <span slot="right-footer" size="small" />
        </el-transfer>
      </el-dialog>
    </template>
  </div>

</template>

<script>
import { api, paramApi } from '@/api/Permission-model/userManagement'
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
        if (this.dialogStatus === '新增用户组') {
          paramApi('system/sysGroup/checkGroupName', this.userGroupform.groupName, 'groupName').then(res => {
            if (res.data.code === '0000') {
              if (res.data.data === 'success') {
                callback()
              } else {
                callback(new Error('用户组名称已重复'))
              }
            }
          })
        } else {
          if (this.oldGroupName !== this.userGroupform.groupName) {
            paramApi('system/sysGroup/checkGroupName', this.userGroupform.groupName, 'groupName').then(res => {
              if (res.data.code === '0000') {
                if (res.data.data === 'success') {
                  callback()
                } else {
                  callback(new Error('用户组名称已重复'))
                }
              }
            })
          } else {
            callback()
          }
        }
      }
    }
    return {
      name: '',
      roleName: '',
      isDisabled: false,
      numberTotal: 0,
      numberRows: 10,
      numberPage: 1,
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
        recordStatus: undefined,
        rows: 10,
        page: 1
      },
      userGroupdialogFormVisible: false,
      userdialogVisible: false,
      roledialogVisible: false,
      statusOptions: [{
        value: '1',
        label: '生效'
      }, {
        value: '2',
        label: '未生效'
      }],
      userGroupform: {
        id: '',
        groupName: undefined,
        recordStatus: '生效'
      },
      rules: {
        groupName: [
          { required: true, message: '请输入用户组名称', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        recordStatus: [{ required: true, message: '请选择状态', trigger: 'change' }]
      }
    }
  },
  watch: {
    roleName: function(newVal, oldVal) {
      this.numberPage = 1
      this.getRole()
    },
    name: function(newVal, oldVal) {
      this.userPage = 1
      this.getUser()
    }
  },
  created() {
    this.initList()
  },
  methods: {
    // 授权角色分页功能
    handleRoleCurrentChange(val) {
      if (this.numberTotal > (val - 1) * this.numberRows) {
        this.numberPage = val
      } else {
        this.numberPage = val - 1
      }
      this.roledialogVisible = true
      this.getRole()
    },
    // 改变授权角色穿梭框时获取选中的角色
    handleRoleChange(value, direction, movedKeys) {
      this.roleIds = value
      if (direction === 'left') {
        this.moveArr = -movedKeys.length
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      this.numberTotal = this.numberTotal - this.moveArr
      if (this.numberTotal > (this.numberPage - 1) * this.numberRows) {
        this.numberPage = this.numberPage
      } else {
        this.numberPage = this.numberPage - 1
      }
      api('system/sysGroup/roleGroupAuthorization', { groupId: this.groupId, roleIds: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.initList()
        this.getRole()
      })
    },
    // 显示授权角色对话框
    showRoleDialog(id) {
      this.numberPage = 1
      this.roleLoading = true
      this.groupId = id
      this.roledialogVisible = true
      this.roleName = ''
      this.getRole()
    },
    getRole() {
      api('system/sysGroup/selectGroupRoleAndOtherRole', {
        groupId: this.groupId,
        page: this.numberPage,
        rows: this.numberRows,
        roleName: this.roleName
      }).then(res => {
        if (res.data.code === '0000') {
          const roleData = []
          const checkRole = []
          this.numberTotal = res.data.data.total
          res.data.data.rows.otherRoleList.forEach((val, index) => {
            roleData.push({
              label: val.roleName,
              key: val.id
            })
          })
          res.data.data.rows.roleOfGroupList.forEach(val => {
            checkRole.push(val.id)
          })
          this.roleData = roleData
          this.roleIds = checkRole
          this.roleLoading = false
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 显示授权用户对话框
    showuserGruopDialog(row) {
      this.userPage = 1
      this.userLoading = true
      this.userGroupId = row.id
      this.userdialogVisible = true
      this.name = ''
      this.getUser()
    },

    // 根据用户组id获取用户组拥有的用户和其他用户
    getUser() {
      api('system/sysGroup/findOtherUserByPage', { groupId: this.userGroupId, page: this.userPage, rows: this.userRows, name: this.name }).then(res => {
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
      if (this.userTotal > (val - 1) * this.userRows) {
        this.userPage = val
      } else {
        this.userPage = val - 1
      }
      this.getUser()
      this.userLoading = true
    },
    // 改变授权用户穿梭框时获取选中的用户
    handleUserChange(value, direction, movedKeys) {
      this.userIds = value
      if (direction === 'left') {
        this.moveArr = -(movedKeys.length)
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      this.userTotal = this.userTotal - this.moveArr
      if (this.userTotal > (this.userPage - 1) * this.userRows) {
        this.userPage = this.userPage
      } else {
        this.userPage = this.userPage - 1
      }
      api('system/sysGroup/userGroupAuthorization', { groupId: this.userGroupId, userIds: value }).then(
        res => {
          if (res.data.code === '0000') {
            this.$message({
              message: '授权成功',
              type: 'success'
            })
          } else {
            this.$message.error(res.data.result)
          }
          this.initList()
          this.getUser()
        }
      )
    },
    selecteUserStatus(value) {
      this.listQuery.recordStatus = value
    },
    //   搜素功能的实现
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 清空信息
    resetuserGroupform() {
      this.userGroupform = {
        groupName: undefined,
        recordStatus: undefined
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
      this.isDisabled = true
      this.$refs['userGroupform'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api('system/sysGroup/add', this.userGroupform).then(res => {
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
            this.userGroupdialogFormVisible = false
            // 重置表单元素的数据
            // this.$refs['userGroupform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    // 弹出编辑对话框
    handleUpdate(row) {
      this.oldGroupName = row.groupName
      // 显示对话框
      this.userGroupdialogFormVisible = true
      //   添加默认数据
      this.dialogStatus = '编辑用户组'
      this.userGroupform.groupName = row.groupName
      this.userGroupform.recordStatus = row.recordStatus.toString()
      this.userGroupform.id = row.id
      this.$nextTick(() => {
        this.$refs['userGroupform'].clearValidate()
      })
    },
    // 编辑用户的功能实现
    updateData() {
      this.$refs['userGroupform'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          // 将对话框隐藏
          this.userGroupdialogFormVisible = false
          // 调用接口发送请求
          api('system/sysGroup/update', this.userGroupform).then(res => {
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
            // this.$refs['userGroupform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 删除用户功能实现
    deleteUsergroup(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi('system/sysGroup/delete', row.id, 'groupIds').then(res => {
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

        })
    },
    // 项目初始化
    initList() {
      this.listLoading = true
      api('system/sysGroup/list', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.usergroupList = res.data.data.rows
          this.total = res.data.data.total
          if (this.usergroupList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
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

<style lang="scss">
.tablePagination{
  margin-top:15px;
}
.management {
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
.el-dialog {
  .el-dialog__footer {
    text-align: center;
  }
}
</style>

<template>
  <div v-loading="listLoading" class="flex-box-cloumn">
    <el-row>
      <el-col :span="3"><el-button class="filter-item" @click="showDepartment()">{{ title?'显示部门':'全部用户' }}</el-button></el-col>
      <el-col :span="21"><div class="filter-container">
        <el-form :inline="true" :model="listQuery" class="filter-bar">
          <el-form-item label="姓名">
            <el-input v-model="listQuery.name" maxlength="20" placeholder="请输入姓名" style="width: 150px;" class="filter-item" clearable @keyup.enter.native="handleFilter"/>
          </el-form-item>
          <el-form-item label="状态">
            <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable style="width: 150px" class="filter-item" @change="selecteUserStatus">
              <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="岗位">
            <el-input v-model="listQuery.postOrTypeName" maxlength="20" placeholder="请输入岗位或岗位类型" style="width: 200px;" class="filter-item" clearable @keyup.enter.native="handleFilter"/>
          </el-form-item>
          <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
          <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
          <el-button type="primary" class="filter-item" @click="handleExcel">导出</el-button>

        </el-form>
      </div></el-col>
    </el-row>
    <!-- 主体部分 -->
    <div class="userManagement-content">
      <div v-if="isShow" class="userManagement-content-left">
        <el-tree v-loading="departmentListLoading" :data="departmentList" :expand-on-click-node="false" :props="defaultProps" default-expand-all @node-click="handleNodeClick"/>
      </div>
      <div class="userManagement-content-right">
        <el-table :key="tableKey" :data="userList" border fit highlight-current-row style="width: 100%;">
          <el-table-column label="序列" type="index" align="center" width="60"/>
          <el-table-column label="账号" prop="account" align="center" width="100" />
          <el-table-column label="姓名" prop="name" align="center" width="100" />
          <el-table-column label="部门" prop="departmentName" align="center" width="100" />
          <el-table-column label="岗位" prop="postName" align="center" width="85" />
          <el-table-column label="岗位类型" prop="postTypeName" align="center" width="85" />
          <el-table-column label="邮箱" prop="email" align="center" width="150" />
          <el-table-column label="手机" prop="phone" align="center" width="120" />
          <el-table-column label="微信" prop="wechatAccount" align="center" width="120" />
          <el-table-column :show-overflow-tooltip="true" label="备注" prop="remark" align="center" width="120"/>
          <el-table-column label="创建时间" prop="createdTime" align="center" width="200">
            <!-- <template slot-scope="scope">
              {{ scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}') }}
            </template> -->
          </el-table-column>
          <el-table-column label="状态" prop="recordStatus" align="center" width="70">
            <template slot-scope="scope">
              <span :class="scope.row.recordStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.recordStatus | statusFilter }}</span>
            </template>
          </el-table-column>
          <el-table-column fit label="操作" align="center" width="560">
            <template slot-scope="scope">
              <el-button type="primary" size="mini" @click="handleSectorUpdata(scope.row)">部门岗位</el-button>
              <el-button type="primary" size="mini" @click="showRoleDialog(scope.row.id)">授权角色</el-button>
              <el-button type="primary" size="mini" @click="showUserGroupDialog(scope.row.id)">授权用户组</el-button>
              <el-button type="primary" size="mini" @click="handleResetPasswordDialog(scope.row)">重置密码</el-button>
              <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
              <el-button type="danger" size="mini" @click="handleDelete(scope.row)" >删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="pagination-container">
          <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10,20,30,50]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
        </div>
      </div>
    </div>

    <!-- S 新增弹窗 -->
    <template v-if="dialogFormVisible">
      <el-dialog :visible.sync="dialogFormVisible" :title="addDialogTitle" width="450px" class="addUser">
        <el-form ref="dataForm" :rules="addUserDialogRules" :model="temp" label-position="right" label-width="80px" style="max-width:320px;margin-left:20px;">
          <el-form-item label="账号" prop="account">
            <el-input v-model="temp.account" :disabled="isAbled" maxlength="16" clearable/>
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model.trim="temp.name" maxlength="16" clearable />
          </el-form-item>
          <el-form-item label="状态" prop="recordStatus">
            <el-select v-model="temp.recordStatus" class="filter-item" placeholder="请选择" style="max-width:280px;">
              <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="temp.email" clearable />
          </el-form-item>
          <el-form-item label="手机" prop="phone">
            <el-input v-model="temp.phone" maxlength="11" minlenght="11" clearable />
          </el-form-item>
          <el-form-item label="微信" prop="wechatAccount">
            <el-input v-model="temp.wechatAccount" maxlength="20" clearable />
          </el-form-item>
          <el-form-item label="备注" prop="remark">
            <el-input :rows="2" v-model="temp.remark" type="textarea" maxlength="100" clearable/>
          </el-form-item>
          <el-form-item v-if="Visible" label="部门">
            <el-cascader
              :options="departmentList"
              v-model="currentDepartmentIds"
              change-on-select
              placeholder="请选择"
              clearable
              @change="handleChangeDepartment"
            />
          </el-form-item>
          <el-form-item v-if="Visible" label="岗位">
            <el-select v-model="temp.postId" class="filter-item" placeholder="请选择" clearable>
              <el-option v-for="(item,index) in positionOptions" :key="index" :label="item.label" :value="item.value" />
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='create'?createUserData():updateData()">确认</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </div>
      </el-dialog>
    </template>
    <!-- E 新增弹窗 -->
    <!-- S 部门岗位 -->
    <el-dialog :visible.sync="dialogSectorVisible" title="部门岗位" class="sector-dialog">
      <el-table v-loading="sectorLoading" :data="userPositionData" border fit style="width: 100%">
        <el-table-column label="部门" align="center" width="280">
          <template slot-scope="scope">
            <el-cascader v-model="userPositionData[scope.$index].department" :options="departmentList" placeholder="请选择部门" change-on-select style="width:100%;" />
          </template>
        </el-table-column>
        <el-table-column label="岗位" align="center" width="180">
          <template slot-scope="scope">
            <el-select v-model="userPositionData[scope.$index].position" placeholder="请选择">
              <el-option v-for="(item,index) in positionOptions" :key="index" :label="item.label" :value="item.value" />
            </el-select>
          </template>
        </el-table-column>
        <el-table-column label="默认" align="center" width="180">
          <template slot-scope="scope">
            <el-button v-if="scope.row.status==='default'" type="success" size="small">默认岗位</el-button>
            <el-button v-else-if="scope.row.status!=='default' && scope.row.department && scope.row.position" size="small" @click="setDefaultPosition(scope.$index, scope.row)">设为默认岗位</el-button>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-button v-if="scope.row.department && scope.row.position" size="mini" type="danger" @click="handleUserSectorDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="saveDepartmentandPostOfUser()">提交</el-button>
        <el-button @click="dialogSectorVisible = false">取消</el-button>
      </div>
    </el-dialog>
    <!-- E 部门岗位 -->
    <!-- 授权角色 -->
    <template v-if="roledialogVisible">
      <el-dialog :visible.sync="roledialogVisible" title="授权角色" class="roleBox" width="800px">
        <div class=" transfer-search el-transfer-panel__filter el-input el-input--small el-input--prefix"><!----><input v-model="roleName" type="text" autocomplete="off" placeholder="请输入角色名称" class="el-input__inner" clearable><span class="el-input__prefix"><i class="el-input__icon el-icon-search"/><!----></span><!----><!----></div>
        <el-transfer v-loading="roleLoading" v-model="roleIds" :data="roleData" :titles="['其他角色', '用户拥有角色']" filterable filter-placeholder="请输入角色名称" class="box" @change="handleRoleChange">
          <span slot="left-footer" size="small">
            <el-pagination :current-page="numberPage" :pager-count="5" :total="numberTotal" background layout="prev, pager, next" @current-change="handleRoleCurrentChange" />
          </span>
          <span slot="right-footer" size="small" />
        </el-transfer>
      </el-dialog>
    </template>
    <!-- S 重置密码 -->
    <el-dialog :visible.sync="dialogResetPasswordVisible" title="重置密码" width="400px">
      <el-form ref="resetPassword" :model="resetPassword" :rules="passwordRule" label-width="60px">
        <el-form-item label="密码" prop="password">
          <el-input v-model="resetPassword.password" :type="passwordType" maxlength="16" />
          <span class="show-pwd" @click="showPwd">
            <svg-icon icon-class="eye" />
          </span>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="handlerResetPassword">重置密码</el-button>
        <el-button @click="dialogResetPasswordVisible = false">取消</el-button>
      </div>
    </el-dialog>
    <!-- E 重置密码 -->
    <!-- 弹出的授权用户组对话框 -->
    <!-- <template v-if="userGroup.userGroupdialogVisible"> -->
    <el-dialog :visible.sync="userGroup.userGroupdialogVisible" title="授权用户组" class="groupBox" width="800px">
      <div class=" transfer-search el-transfer-panel__filter el-input el-input--small el-input--prefix"><!----><input v-model="userGroupName" type="text" autocomplete="off" placeholder="请输入用户组名称" class="el-input__inner" clearable><span class="el-input__prefix"><i class="el-input__icon el-icon-search"/><!----></span><!----><!----></div>
      <el-transfer v-loading="userGroup.userGroupLoading" v-model="userGroup.userGroupId" :data="userGroup.userGroupData" :titles="['其他用户组', '用户拥有用户组']" filterable filter-placeholder="请输入用户组名称" class="box" @change="handleUserGroupChange">
        <span slot="left-footer" size="small">
          <el-pagination :current-page="userPage" :pager-count="5" :total="userTotal" background layout="prev, pager, next" @current-change="handleUserGroupCurrentChange" />
        </span>
        <span slot="right-footer" size="small" />
      </el-transfer>
    </el-dialog>
    <!-- </template> -->
  </div>
</template>

<script>
import {
  api,
  paramApi,
  // userCreate,
  // getDepartment,
  // deleteSysUser,
  // checkUserName,
  // findSysPostAll,
  // findDepartmentandPostByUserId,
  // saveDepartmentandPostOfUser,
  // updateSysUser,
  // editUser,
  // getRoleInfo,
  // updataRole,
  // getUserGroupInfo,
  // updataUserGroup,
  exportExcel
} from '@/api/Permission-model/userManagement'
// import initList from './components/components'
export default {
  name: 'UserManagement',
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
      const reg = /[A-Za-z0-9]{6,16}$/
      if (!reg.test(value)) {
        callback(new Error('请输入6到16位长度字符的数字及字母'))
      } else {
        if (this.dialogStatus === 'create') {
          paramApi('system/sysUser/checkUserName', this.temp.account, 'account').then(response => {
            const result = response.data.data
            if (result === 'success') {
              callback()
            } else {
              callback(new Error('账号已使用'))
            }
          })
        } else {
          callback()
        }
      }
    }
    var checkName = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,16}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }
    var checkPhoneNumber = (rule, value, callback) => {
      const reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的手机号码'))
      } else {
        callback()
      }
    }
    var checkPassword = (rule, value, callback) => {
      const reg = /^[a-zA-Z0-9_!~&@]{6,16}$/
      if (!reg.test(value)) {
        callback(new Error('请输入6到16位由字母或数字组成的密码'))
      } else {
        callback()
      }
    }
    var checkWechatAccount = (rule, value, callback) => {
      if (value !== '' && value !== null) {
        const reg = /^[a-zA-Z0-9][-_a-zA-Z0-9]{5,19}$/
        if (!reg.test(value)) {
          callback(new Error('请输入6到20位字母或数字'))
        } else {
          callback()
        }
      } else {
        callback()
      }
    }
    return {
      userGroupName: '',
      roleName: '',
      currentDepartmentIds: undefined,
      Visible: true,
      isShow: false,
      title: true,
      departmentListLoading: false,
      userPage: 1,
      userRows: 10,
      userTotal: null,
      userGroup: {
        userGroupdialogVisible: false,
        userGroupLoading: false,
        userGroupId: [],
        userGroupData: []
      },
      roleIds: [],
      roleData: [],
      roleLoading: false,
      roledialogVisible: false,
      numberTotal: 0,
      numberRows: 10,
      numberPage: 1,
      moveArr: 0,
      isAbled: false,
      passwordType: 'password',
      isDisabled: false,
      userId: undefined,
      checkedDepartment: undefined,
      addDialogTitle: '新增',
      tableKey: 0,
      userList: null,
      total: null,
      listLoading: true,
      sectorLoading: true,
      listQuery: {
        page: 1,
        rows: 10,
        recordStatus: '',
        departmentId: '',
        position: '',
        name: '',
        departmentIds: undefined,
        postOrTypeName: ''
      },
      statusOptions: [{
        value: '1',
        label: '生效'
      }, {
        value: '2',
        label: '未生效'
      }],
      positionOptions: [],
      temp: {
        name: '',
        account: '',
        recordStatus: '',
        email: '',
        phone: '',
        id: '',
        departmentId: '',
        postId: '',
        wechatAccount: ''
      },
      dialogFormVisible: false,
      dialogStatus: '',
      dialogSectorVisible: false,
      dialogResetPasswordVisible: false,
      addUserDialogRules: {
        name: [
          { required: true, message: '姓名不能为空', trigger: 'blur' },
          { validator: checkName, trigger: 'blur' }
        ],
        account: [
          { required: true, message: '账号不能为空', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        recordStatus: [
          {
            required: true,
            message: '请选择状态',
            trigger: 'change'
          }
        ],
        email: [
          { required: true, message: '邮箱不能为空', trigger: 'blur' },
          { type: 'email', message: '请输入正确格式的邮箱', trigger: 'blur' }
        ],
        phone: [
          { required: true, message: '手机号不能为空', trigger: 'blur' },
          { validator: checkPhoneNumber, trigger: 'blur' }
        ],
        wechatAccount: [
          { required: false, validator: checkWechatAccount, trigger: 'blur' }
        ]
      },
      passwordRule: {
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' },
          { validator: checkPassword, trigger: 'blur' }
        ]
      },
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      userPositionData: [],
      departmentList: undefined,
      resetPassword: {
        id: '',
        password: ''
      },
      remark: ''
    }
  },
  computed: {
    userDepartmentPostList: function() {
      // 部门和岗位的数据
      const userPositionData = this.userPositionData
      const sysDepartmentPostList = userPositionData.map(function(item) {
        // 选中的部门数组
        const departmentArr = item.department
        item.departmentId = departmentArr[departmentArr.length - 1]
        item.isDefault = item.status === 'default' ? '1' : '0'
        item.postId = item.position
        return item
      })
      return {
        sysDepartmentPostList,
        userId: this.userId
      }
    }
  },
  watch: {
    userPositionData: {
      handler: function() {
        const userPosition = this.userPositionData.filter(function(item) {
          return item.department !== '' && item.position
        })
        if (this.userPositionData.length < userPosition.length + 2) {
          this.userPositionData.push({
            department: [],
            position: '',
            status: undefined,
            postId: undefined
          })
        }
      },
      deep: true
    },
    roleName: function(newVal, oldVal) {
      this.numberPage = 1
      this.getRole()
    },
    userGroupName: function(newVal, oldVal) {
      this.numberPage = 1
      this.getUserGroup()
    }
  },
  mounted() {
    this.initList()
    this.getAllDepartment()
    this.findSysPostAll()
  },
  methods: {
    // 导出功能
    handleExcel() {
      exportExcel(this.listQuery).then(res => {
        window.location.href = res.request.responseURL
      })
    },
    // 选择部门（新增用户对话框）
    handleChangeDepartment(value) {
      // // 提交的时候拿到的部门id等于提取出来的最后一个id
      this.temp.departmentId = this.currentDepartmentIds[this.currentDepartmentIds.length - 1]
    },
    // 切换部门树
    showDepartment() {
      this.title = !this.title
      this.isShow = !this.isShow
      if (!this.isShow) {
        this.listQuery.page = 1
        this.listQuery.departmentId = undefined
        this.initList()
      }
    },
    // 点击部门树的节点
    handleNodeClick(data) {
      this.listQuery.page = 1
      this.listQuery.departmentId = data.value
      this.initList()
    },
    // 改变授权用户组穿梭框时获取选中的用户组
    handleUserGroupChange(value, direction, movedKeys) {
      this.userGroup.userGroupId = value
      if (direction === 'left') {
        this.moveArr = -movedKeys.length
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      api('system/sysUser/saveSysGroupToSysUser', { userId: this.userId, groupIds: value }).then(res => {
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
      this.userId = id
      this.userGroupName = ''
      this.userGroup.userGroupdialogVisible = true
      this.getUserGroup()
    },
    getUserGroup() {
      api('system/sysUser/findSysGroupByUserId', {
        userId: this.userId,
        page: this.userPage,
        rows: this.userRows,
        userGroupName: this.userGroupName
      }).then(res => {
        const userGroupData = []
        const checkUserGroup = []
        this.userTotal = res.data.data.total
        res.data.data.rows.otherGroupList.forEach((val, index) => {
          userGroupData.push({
            label: val.groupName,
            key: val.groupId
          })
        })
        res.data.data.rows.sysGroupOfUserList.forEach(val => {
          checkUserGroup.push(val.groupId)
        })
        this.userGroup.userGroupData = userGroupData
        this.userGroup.userGroupId = checkUserGroup
        this.userGroup.userGroupLoading = false
      })
    },
    // 授权角色分页功能
    handleRoleCurrentChange(val) {
      if (this.numberTotal - this.moveArr > (val - 1) * this.numberRows) {
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
      api('system/sysUser/saveSysRoleToSysUser', { userId: this.userId, roleIds: value }).then(res => {
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
    // 显示授权角色对话框
    showRoleDialog(id) {
      this.numberPage = 1
      this.roleLoading = true
      this.userId = id
      this.roledialogVisible = true
      this.roleName = ''
      this.getRole()
    },
    getRole() {
      api('system/sysUser/findSysRoleByUserId', {
        userId: this.userId,
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
          res.data.data.rows.sysRoleOfUserList.forEach(val => {
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
    // 显示密码
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
    },
    // 改变状态
    selecteUserStatus(value) {
      console.log(value)
      this.listQuery.recordStatus = value
    },
    // 获取所有部门列表
    getAllDepartment() {
      this.departmentListLoading = true
      api('system/sysDepartment/findDepartmentAllByLevel').then(res => {
        if (res.data.code === '0000') {
          this.departmentList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.departmentListLoading = false
      })
    },
    // 获取所有岗位
    findSysPostAll() {
      api('system/sysPost/findSysPostAll').then(res => {
        if (res.data.code === '0000') {
          const data = res.data.data
          this.positionOptions = data.map(function(item) {
            return {
              label: item.postName,
              value: item.id
            }
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取用户列表
    initList() {
      this.listLoading = true
      api('system/sysUser/findSysUserByPage', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          console.log(res)
          this.userList = res.data.data.rows
          this.total = res.data.data.total
          if (this.userList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 显示编辑用户部门和岗位
    handleSectorUpdata(row) {
      this.dialogSectorVisible = true
      this.userPositionData = []
      this.sectorLoading = true
      this.userId = row.id
      // 发请求获取用户具有的部门和岗位
      paramApi('system/sysUser/findDepartmentandPostByUserId', row.id, 'userId').then(response => {
        if (response.data.code === '0000') {
          this.sectorLoading = false
          const data = response.data.data
          const sectorArr = []
          data.map(function(item, index) {
            const departmentIds = item.departmentId.split(',')
            sectorArr.push({
              department: departmentIds,
              position: item.postId,
              postId: item.postId,
              status: item.isDefault === '1' ? 'default' : ''
            })
          })
          this.userPositionData = sectorArr
        } else {
          this.$message.error(response.data.result)
        }
      })
    },
    // 查询数据
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 分页数更改
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    },
    // 显示新增用户对话框
    handleCreate() {
      this.temp = {
        account: '',
        name: '',
        phone: '',
        email: '',
        recordStatus: '',
        wechatAccount: undefined
      }
      this.Visible = true
      this.isAbled = false
      this.dialogStatus = 'create'
      this.addDialogTitle = '新增'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    // 新增用户
    createUserData() {
      this.isDisabled = true
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          // this.isDisabled = true
          api('system/sysUser/addSysUser', this.temp).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '新增用户成功',
                type: 'success'
              })
              this.dialogFormVisible = false
              // 重置表单元素的数据
              this.$refs['dataForm'].resetFields()
              this.currentDepartmentIds = []
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    // 显示编辑用户对话框
    handleUpdate(row) {
      // 打开用户信息更新弹窗
      this.Visible = false
      this.isAbled = true
      this.dialogStatus = 'update'
      this.addDialogTitle = '编辑'
      this.temp.account = row.account
      this.temp.id = row.id
      this.temp.name = row.name
      this.temp.email = row.email
      this.temp.phone = row.phone
      this.temp.wechatAccount = row.wechatAccount
      this.temp.remark = row.remark
      this.temp.recordStatus = row.recordStatus.toString()
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    // 编辑用户
    updateData() {
      // 更换用户信息
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          // // 调用接口发送请求
          api('system/sysUser/updateSysUser', this.temp).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              // 刷新页面显示
              this.initList()
              this.dialogFormVisible = false
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
          })
        }
      })
    },
    // 删除用户
    handleDelete(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          api('system/sysUser/deleteSysUser', { userIds: [row.id] }).then(res => {
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
    // 设置默认部门和岗位
    setDefaultPosition(index, row) {
      var currentIndex = index
      this.userPositionData = this.userPositionData.map(function(item, index) {
        if (currentIndex === index) {
          item.status = 'default'
        } else {
          item.status = undefined
        }
        return item
      })
    },
    // 编辑用户部门和岗位
    saveDepartmentandPostOfUser() {
      const userDepartmentPostList = this.userDepartmentPostList
      for (const it of userDepartmentPostList.sysDepartmentPostList) {
        if (it.departmentId || it.postId) {
          if (!it.departmentId) {
            return this.$message.error('请选择部门')
          }
          if (!it.postId) {
            return this.$message.error('请选择岗位')
          }
        }
      }
      // 清除空的数据
      const filterList = userDepartmentPostList.sysDepartmentPostList.filter(
        function(item) {
          return item.department && item.position
        }
      )
      userDepartmentPostList.sysDepartmentPostList = filterList
      if (userDepartmentPostList.sysDepartmentPostList.length > 0) {
        var count = 0
        userDepartmentPostList.sysDepartmentPostList.forEach((val, index) => {
          if (val.isDefault === '1') {
            count = count + 1
          }
        })
        if (count !== 1) {
          userDepartmentPostList.sysDepartmentPostList[0].isDefault = '1'
        }
      }
      api('system/sysUser/saveDepartmentandPostOfUser', userDepartmentPostList).then(response => {
        if (response.data.code === '0000') {
          this.$message({
            message: '修改部门和岗位成功',
            type: 'success'
          })
        } else {
          this.$message.error(response.data.result)
        }
        this.dialogSectorVisible = false
        this.initList()
      })
    },
    // 删除用户部门和岗位
    handleUserSectorDelete(index, row) {
      this.userPositionData.splice(index, 1, {
        department: [],
        position: '',
        status: undefined,
        postId: undefined
      })
    },
    // 显示重置密码对话框
    handleResetPasswordDialog(row) {
      this.dialogResetPasswordVisible = true
      this.resetPassword.id = row.id
      this.resetPassword.password = ''
      this.$nextTick(() => {
        this.$refs['resetPassword'].clearValidate()
      })
    },
    // 重置密码
    handlerResetPassword() {
      this.$refs['resetPassword'].validate(valid => {
        if (valid) {
          api('system/sysUser/updateSysUser', this.resetPassword).then(res => {
            if (res.data.code === '0000') {
              this.dialogResetPasswordVisible = false
              this.$message({
                message: '重置密码成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
          })
        }
      })
    }
  }
}
</script>
<style lang="scss">
.el-tooltip__popper{
   text-align: center;
    max-width: 260px;
    word-break: break-all;
}
.userManagement-content{
  display: flex;
  .userManagement-content-left{
    margin-top:15px;
    margin-right:30px;
    .el-button{
      margin-bottom: 10px;
    }
  }
}
.roleBox,.groupBox{
   .el-dialog__body{
     height: 500px;
  }
}
.box {
  .el-transfer-panel {
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
.flex-box-column {
  display: flex;
  flex-direction: column;
}
.pagination-container {
  margin-top: 10px;
}
.sector-dialog {
  .el-dialog {
  min-width: 800px;
  }
  .item-box {
    padding: 5px;
    border: 1px solid #d7d7d7;
  }
}
  .el-transfer {
    display: inline-block;
    white-space: nowrap;
  }
  .el-dialog{
    .el-dialog__footer{
      text-align: center;
    }
  }
.addUser {
  .el-dialog{
    margin-top: 5vh !important;
    .el-cascader .el-input, .el-cascader .el-input__inner{
      width: 240px;
    }
    .el-select>.el-input{
      width: 240px;
    }
  }
 .el-dialog__body{
    padding-bottom: 0px;
  }
}
.filter-container {
  padding-bottom: 0;
}
 .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: #889aa4;
    cursor: pointer;
    user-select: none;
  }
</style>


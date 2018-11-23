<template>
  <div class="flex-box-cloumn">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery" class="filter-bar">
        <el-form-item label="姓名">
          <el-input v-model="listQuery.name" placeholder="请输入姓名" style="width: 150px;" class="filter-item" maxlength="16" clearable @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="listQuery.status" placeholder="请选择" clearable style="width: 90px" class="filter-item" @change="selecteUserStatus">
            <el-option v-for="(item,index) in userStatusOptions" :key="item" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-form-item label="部门">
          <el-popover placement="bottom" trigger="click" width="400">
            <div>
              <el-tree ref="departmentList" :data="departmentList" :default-expanded-keys="[2, 3]" :default-checked-keys="[5]" :props="defaultProps" show-checkbox node-key="value" @check-change="getDepartment()" />
            </div>
            <el-input slot="reference" v-model="checkedDepartment" placeholder="请选择部门" clearable @clear="resetCheckedDepartment" />
          </el-popover>
        </el-form-item>
        <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-circle-plus-outline" @click="handleCreate">新增用户</el-button>
      </el-form>
    </div>
    <el-table v-loading="listLoading" :key="tableKey" :data="userList" border fit highlight-current-row style="width: 100%;">
      <el-table-column label="序列" type="index" align="center" min-width="60"/>
      <el-table-column label="姓名" prop="name" align="center" />
      <el-table-column label="账号" prop="account" align="center" min-width="100" />
      <el-table-column label="邮箱" prop="email" align="center" min-width="150" />
      <el-table-column label="手机" prop="phone" align="center" min-width="120" />
      <el-table-column label="创建时间" prop="createTime" align="center" min-width="150">
        <template slot-scope="scope">
          {{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="部门" prop="departmentName" align="center" min-width="80" />
      <el-table-column label="岗位" prop="postName" align="center" min-width="75" />
      <el-table-column label="状态" prop="status" align="center" min-width="70">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status | statusFilter }}</span>
        </template>
      </el-table-column>
      <el-table-column fit label="操作" align="center" width="auto" min-width="400">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleSectorUpdata(scope.row)">部门岗位</el-button>
          <el-button type="primary" size="mini" @click="handleRoleUpdata(scope.row)">角色</el-button>
          <el-button type="primary" size="mini" @click="handleResetPasswordDialog(scope.row)">重置密码</el-button>
          <el-button type="primary" icon="el-icon-edit" size="mini" @click="handleUpdate(scope.row)" />
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDelete(scope.row)" />
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10,20,30, 50]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <!-- S 新增弹窗 -->
    <el-dialog :visible.sync="dialogFormVisible" :title="addDialogTitle">
      <el-form ref="dataForm" :rules="addUserDialogRules" :model="temp" label-position="left" label-width="60px" style="max-width:300px;margin-left:20px;">
        <el-form-item label="账号" prop="account">
          <el-input v-model="temp.account" maxlength="20" clearable />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="temp.name" maxlength="20" clearable />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="temp.status" class="filter-item" placeholder="请选择">
            <el-option v-for="(item,index) in userStatusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="temp.email" clearable />
        </el-form-item>
        <el-form-item label="手机" prop="phone">
          <el-input v-model="temp.phone" maxlength="11" minlenght="11" clearable />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='create'?createUserData():updateData()">确认</el-button>
        <el-button @click="dialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>
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
        <el-button @click="dialogSectorVisible = false">取消</el-button>
        <el-button type="primary" @click="saveDepartmentandPostOfUser()">提交</el-button>
      </div>
    </el-dialog>
    <!-- E 部门岗位 -->
    <!-- S 角色岗位 -->
    <el-dialog :visible.sync="dialogRoleVisible" title="角色" class="role-dialog">
      <el-transfer :filter-method="filterMethod" :titles="[ '角色列表', '已选中角色' ]" :data="data2" v-model="value2" filterable filter-placeholder="请输入角色拼音" />
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogRoleVisible = false">取消</el-button>
        <el-button type="primary">确认</el-button>
      </div>
    </el-dialog>
    <!-- E 角色岗位 -->
    <!-- S 重置密码 -->
    <el-dialog :visible.sync="dialogResetPasswordVisible" title="重置密码">
      <el-form ref="resetPassword" :model="resetPassword" :rules="passwordRule" label-width="70px">
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
  </div>
</template>

<script>
import {
  userList,
  userCreate,
  findDepartmentAllByLevel,
  deleteSysUser,
  checkUserName,
  findSysPostAll,
  findDepartmentandPostByUserId,
  saveDepartmentandPostOfUser,
  updateSysUser,
  editUser
} from '@/api/Permission-model/userManagement'
import waves from '@/directive/waves' // 水波纹指令

export default {
  name: 'UserManagement',
  directives: {
    waves
  },
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
      const reg = /^[a-zA-Z0-9]{4,16}$/
      if (!reg.test(value)) {
        callback(new Error('账号只允许4-16位数字及字母'))
      } else {
        if (this.dialogStatus === 'create') {
          checkUserName(this.temp.account).then(response => {
            const result = response.data.data
            if (result === 'success') {
              callback()
            } else {
              callback(new Error('用户已经使用'))
            }
          })
        } else {
          callback()
        }
      }
    }
    var checkName = (rule, value, callback) => {
      const reg = /[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的名字格式'))
      } else {
        callback()
      }
    }
    var checkPhoneNumber = (rule, value, callback) => {
      // const reg = /^1[34578]\d{9}$/
      const reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/
      if (!reg.test(value)) {
        callback(new Error('请输入正确手机号码'))
      } else {
        callback()
      }
    }
    var checkPassword = (rule, value, callback) => {
      const reg = /^[a-zA-Z0-9_!~&@]{6,14}$/
      if (!reg.test(value)) {
        callback(new Error('请输入6到14位由字母或数字组成的密码'))
      } else {
        callback()
      }
    }
    const generateData2 = _ => {
      const data = []
      const cities = [
        '角色一',
        '角色二',
        '角色三',
        '角色四',
        '角色五',
        '角色六',
        '角色七'
      ]
      const pinyin = [
        'juese1',
        'juese2',
        'juese3',
        'juese4',
        'juese5',
        'juese6',
        'juese7'
      ]
      cities.forEach((city, index) => {
        data.push({
          label: city,
          key: index,
          pinyin: pinyin[index]
        })
      })
      return data
    }
    return {
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
        status: undefined,
        position: undefined,
        departmentName: undefined,
        departmentIds: undefined
      },
      userStatusOptions: ['未生效', '生效'],
      departmentOptions: [],
      positionOptions: [],
      sortOptions: [
        { label: 'ID Ascending', key: '+id' },
        { label: 'ID Descending', key: '-id' }
      ],
      temp: {
        name: undefined,
        account: undefined,
        status: '',
        email: undefined,
        phone: undefined,
        id: undefined
      },
      dialogFormVisible: false,
      dialogStatus: '',
      dialogSectorVisible: false,
      dialogRoleVisible: false,
      dialogResetPasswordVisible: false,
      addUserDialogRules: {
        name: [
          { required: true, message: '用户名不能为空', trigger: 'blur' },
          { validator: checkName, trigger: 'blur' }
        ],
        account: [
          { required: true, message: '账号不能为空', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        status: [
          {
            required: true,
            message: '状态不能为空',
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
      data2: generateData2(),
      value2: [],
      filterMethod(query, item) {
        return item.pinyin.indexOf(query) > -1
      },
      resetPassword: {
        id: '',
        password: ''
      }
    }
  },
  computed: {
    userDepartmentPostList: function() {
      const userPositionData = this.userPositionData
      const sysDepartmentPostList = userPositionData.map(function(item) {
        const departmentArr = item.department
        item.departmentId = departmentArr[departmentArr.length - 1]
        item.isDefault = item.status === 'default' ? 1 : 0
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
    }
  },
  created() {
    this.getUserList()
    this.findDepartmentAllByLevel()
    this.findSysPostAll()
  },
  methods: {
    // 显示密码
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
    },
    selecteUserStatus(value) {
      this.listQuery.userStatus = value
    },
    selecteDepartment(value) {
      this.listQuery.department = value
    },
    findDepartmentAllByLevel() {
      // 获取所有部门列表
      findDepartmentAllByLevel().then(response => {
        const data = response.data.data
        this.departmentList = data
      })
    },
    findSysPostAll() {
      // 获取所有岗位
      findSysPostAll().then(response => {
        const data = response.data.data
        this.positionOptions = data.map(function(item) {
          return {
            label: item.postName,
            value: item.id
          }
        })
      })
    },
    getUserList() {
      // 获取用户列表
      this.listLoading = true
      userList(this.listQuery).then(response => {
        const data = response.data.data
        this.userList = data.rows
        this.total = data.total
        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false
        }, 5e2)
      })
    },
    handleSectorUpdata(row) {
      // 编辑用户岗位
      this.dialogSectorVisible = true
      this.userPositionData = null
      this.sectorLoading = true
      this.userId = row.id
      findDepartmentandPostByUserId(row.id).then(response => {
        this.sectorLoading = false
        const data = response.data.data
        const sectorArr = []
        data.map(function(item, index) {
          const departmentIds = item.departmentId.split(',')
          sectorArr.push({
            department: departmentIds,
            position: item.postId,
            postId: item.postId,
            status: index === 0 ? 'default' : ''
          })
        })

        this.userPositionData = sectorArr
      })
    },
    handleRoleUpdata(row) {
      this.dialogRoleVisible = true
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getUserList()
    },
    handleSizeChange(val) {
      // 分页数更改
      this.listQuery.rows = val
      this.getUserList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.getUserList()
    },
    handleCreate() {
      this.temp = {
        account: '',
        name: '',
        phone: '',
        email: '',
        status: ''
      }
      this.dialogStatus = 'create'
      this.addDialogTitle = '新增'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    // 新增用户
    createUserData() {
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisable = false
      }, 5000)

      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          userCreate(this.temp).then(response => {
            this.dialogFormVisible = false
            this.$message({
              message: '新增用户成功',
              type: 'success'
            })
            this.getUserList()
          })
        }
      })
    },
    // 编辑用户
    handleUpdate(row) {
      // 打开用户信息更新弹窗
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
      console.log(row)
      this.dialogStatus = 'update'
      this.addDialogTitle = '编辑'
      this.temp.account = row.account
      this.temp.id = row.id
      this.temp.name = row.name
      this.temp.email = row.email
      this.temp.phone = row.phone
      this.temp.status = parseInt(row.status)
      this.dialogFormVisible = true
    },
    updateData() {
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisable = false
      }, 5000)
      // 更换用户信息
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          this.dialogFormVisible = false
          // // 调用接口发送请求
          editUser(this.temp).then(res => {
            console.log(res)
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error('编辑失败')
            }
            // 重置表单元素的数据
            this.$refs['dataForm'].resetFields()
            // 刷新页面显示
            this.getUserList()
          })
        }
      })
    },
    handleDelete(row) {
      // 删除用户
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deleteSysUser({ userIds: [row.id] }).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              this.getUserList()
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
    setDefaultPosition(index, row) {
      // 设置默认岗位
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
    getDepartment() {
      this.listQuery.departmentIds = this.$refs.departmentList.getCheckedKeys()
      this.checkedDepartment = this.$refs.departmentList
        .getCheckedNodes()
        .map(function(item) {
          return item.label
        })
    },
    resetCheckedDepartment() {
      // 清空所选部门
      this.$refs.departmentList.setCheckedKeys([])
    },
    saveDepartmentandPostOfUser() {
      const userDepartmentPostList = this.userDepartmentPostList
      // 清除空的数据
      const filterList = userDepartmentPostList.sysDepartmentPostList.filter(
        function(item) {
          return item.department !== '' && item.postId
        }
      )
      userDepartmentPostList.sysDepartmentPostList = filterList
      saveDepartmentandPostOfUser(userDepartmentPostList).then(response => {
        this.dialogSectorVisible = false
        this.$notify({
          title: '成功',
          message: '修改部门岗位成功',
          type: 'success',
          duration: 2000
        })
        this.getUserList()
      })
    },
    handleUserSectorDelete(index, row) {
      // 删除用户部门
      this.userPositionData.splice(index, 1, {
        department: [],
        position: '',
        status: undefined,
        postId: undefined
      })
    },
    // 显示重置密码对话框
    handleResetPasswordDialog(row) {
      this.$nextTick(() => {
        this.$refs['resetPassword'].clearValidate()
      })
      this.dialogResetPasswordVisible = true
      this.resetPassword.id = row.id
      this.resetPassword.password = ''
    },
    // 重置密码
    handlerResetPassword() {
      this.$refs['resetPassword'].validate(valid => {
        if (valid) {
          updateSysUser(this.resetPassword).then(response => {
            this.dialogResetPasswordVisible = false
            this.$message({
              message: '重置密码成功',
              type: 'success'
            })
          })
        }
      })
    }
  }
}
</script>
<style lang="scss">
.flex-box-column {
  display: flex;
  flex-direction: column;
}
.el-dialog {
  width: 90%;
  max-width: 400px;
}
.pagination-container {
  margin-top: 10px;
}
.sector-dialog {
  .el-dialog {
    max-width: 800px;
  }
  .item-box {
    padding: 5px;
    border: 1px solid #d7d7d7;
  }
}
.role-dialog {
  .el-dialog {
    max-width: 540px;
  }
  .el-transfer {
    display: inline-block;
    white-space: nowrap;
  }
}
.el-dialog__body {
  padding-top: 10px;
  padding-bottom: 0;
}
.filter-bar .el-form-item {
  margin-bottom: 0;
}
.filter-container {
  padding-bottom: 0;
}
.el-dialog{

.el-dialog__footer{
  text-align: center ;
}
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


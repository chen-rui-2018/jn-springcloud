<template>
  <div class="permissionManagement">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="权限名称:">
          <el-input v-model="listQuery.permissionName" placeholder="请输入权限名称" style="width: 150px;" class="filter-item" clearable @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.status" placeholder="请选择" style="width: 150px;" clearable class="filter-item" @change="selecteUserStatus">
            <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>
    <!-- 表格 -->
    <el-table v-loading="permissionLoading" :data="permissionList" border fit highlight-current-row style="width: 100%;height:100%">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="权限名称" align="center" prop="permissionName" />
      <el-table-column label="创建时间" min-width="150" align="center" prop="creationTime">
        <template slot-scope="scope">
          {{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status==0?'未生效':'生效' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="320" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button type="primary" size="mini" @click="showRoleDialog(scope.row.id)">授权角色</el-button>
          <el-button type="primary" size="mini" @click="showMenuDialog(scope.row.id)">授权菜单</el-button>
          <el-button type="primary" size="mini" @click="showPageDialog(scope.row.id)">授权页面</el-button>
          <el-button type="primary" size="mini" @click="showFileGroupDialog(scope.row.id)">授权文件组</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deletePermission(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10, 20, 30, 40]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    <!-- 新增权限对话框 -->
    <el-dialog :visible.sync="permissiondialogFormVisible" :title="dialogStatus" width="400px" >
      <el-form ref="permissionform" :rules="rules" :model="permissionform" label-position="right" label-width="80px" style="max-width:300px;margin-left:20px">
        <el-form-item label="名称" prop="permissionName">
          <el-input v-model="permissionform.permissionName" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="permissionform.status" class="filter-item">
            <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="dialogStatus==='新增权限'?createPermissionData():updateData()">提交</el-button>
        <el-button @click="cancelEdit()">取消</el-button>
      </div>
    </el-dialog>
    <!-- 弹出授权角色对话框 -->
    <el-dialog :visible.sync="roledialogVisible" title="授权角色" width="800px">
      <el-transfer v-loading="roleLoading" v-model="roleIds" :data="roleData" :titles="['其他角色', '权限拥有角色']" filterable filter-placeholder="请输入角色名称" class="box" @change="handleRoleChange">
        <span slot="left-footer" size="small">
          <el-pagination :current-page="numberPage" :pager-count="5" :total="numberTotal" background layout="prev, pager, next" @current-change="handleRoleCurrentChange" />
        </span>
        <span slot="right-footer" size="small" />
      </el-transfer>
    </el-dialog>
    <!-- 弹出授权菜单对话框 -->
    <el-dialog :visible.sync="menudialogVisible" title="授权菜单" width="800px">
      <el-transfer v-loading="menuLoading" v-model="menuIds" :data="menuData" :titles="['其他菜单', '权限拥有菜单']" filterable filter-placeholder="请输入菜单名称" class="box" @change="handleMenuChange">
        <span slot="left-footer" size="small">
          <el-pagination :current-page="numberPage" :pager-count="5" :total="numberTotal" background layout="prev, pager, next" @current-change="handleMenuCurrentChange" />
        </span>
        <span slot="right-footer" size="small" />
      </el-transfer>
    </el-dialog>
    <!-- 弹出授权文件组对话框 -->
    <el-dialog :visible.sync="fileGroupdialogVisible" title="授权文件组" width="800px">
      <el-transfer v-loading="fileGroupLoading" v-model="fileGroupIds" :data="fileGroupData" :titles="['其他文件组', '权限拥有文件组']" filterable filter-placeholder="请输入文件组名称" class="box" @change="handleFileGroupChange">
        <span slot="left-footer" size="small">
          <el-pagination :current-page="numberPage" :pager-count="5" :total="numberTotal" background layout="prev, pager, next" @current-change="handleFileGroupCurrentChange" />
        </span>
        <span slot="right-footer" size="small" />
      </el-transfer>
    </el-dialog>
    <!-- 弹出授权页面功能对话框 -->
    <el-dialog :visible.sync="pagedialogVisible" title="授权页面功能" width="800px">
      <el-transfer v-loading="pageLoading" v-model="pageIds" :data="pageData" :titles="['其他页面功能', '权限拥有页面功能']" filterable filter-placeholder="请输入页面名称" class="box" @change="handlePageChange">
        <span slot="left-footer" size="small">
          <el-pagination :current-page="numberPage" :pager-count="5" :total="numberTotal" background layout="prev, pager, next" @current-change="handlePageCurrentChange" />
        </span>
        <span slot="right-footer" size="small" />
      </el-transfer>
    </el-dialog>
  </div>
</template>

<script>
import {
  getPermissionList,
  addPermissionList,
  editPermissionList,
  checkPermissionName,
  getRoleInfo,
  updataRole,
  deletePermissionById,
  getMenuInfo,
  updataMenu,
  getFileGroupInfo,
  updataFileGroup,
  updataPage,
  getPageInfo
} from '@/api/Permission-model/permissionManagement'
export default {

  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的权限名称'))
      } else {
        if (this.oldPermissionName !== this.permissionform.permissionName) {
          checkPermissionName(this.permissionform.permissionName).then(response => {
            const result = response.data.data
            if (result === 'success') {
              callback()
            } else {
              callback(new Error('权限名称已重复'))
            }
          })
        } else {
          callback()
        }
      }
    }
    return {
      pageData: [],
      pageIds: [],
      pageLoading: false,
      pagedialogVisible: false,
      fileGroupData: [],
      fileGroupIds: [],
      fileGroupLoading: false,
      fileGroupdialogVisible: false,
      menuData: [],
      menuIds: [],
      menudialogVisible: false,
      menuLoading: false,
      moveArr: 0,
      numberPage: 1,
      numberRows: 10,
      numberTotal: 0,
      permissionId: undefined,
      roleData: [],
      roleIds: [],
      roleLoading: false,
      roledialogVisible: false,
      oldPermissionName: undefined,
      permissionform: {
        id: '',
        permissionName: undefined,
        status: undefined
      },
      dialogStatus: undefined,
      permissiondialogFormVisible: false,
      permissionList: [],
      permissionLoading: false,
      listQuery: {
        page: 1,
        rows: 10,
        permissionName: undefined,
        status: undefined
      },
      total: undefined,
      statusOptions: ['未生效', '生效'],
      rules: {
        permissionName: [{ required: true, message: '请输入权限名称', trigger: 'blur' },
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
    // 授权页面分页功能
    handlePageCurrentChange(val) {
      if (this.numberTotal - this.moveArr > (val - 1) * this.numberRows) {
        this.numberPage = val
      } else {
        this.numberPage = val - 1
      }
      this.pagedialogVisible = true
      this.getPage()
    },
    // 改变授权页面功能穿梭框时获取选中的页面功能
    handlePageChange(value, direction, movedKeys) {
      this.pageIds = value
      if (direction === 'left') {
        this.moveArr = -movedKeys.length
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      updataPage({ permissionId: this.permissionId, resourcesIds: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error('授权失败')
        }
        this.initList()
      })
    },
    // 显示授权页面功能对话框
    showPageDialog(id) {
      this.numberPage = 1
      this.pageLoading = true
      this.permissionId = id
      this.pagedialogVisible = true
      this.getPage()
    },
    getPage() {
      getPageInfo({
        permissionId: this.permissionId,
        page: this.numberPage,
        rows: this.numberRows
      }).then(res => {
        const pageData = []
        const checkPage = []
        this.numberTotal = res.data.data.total
        res.data.data.rows.otherResourceList.forEach((val, index) => {
          pageData.push({
            label: val.resourcesName,
            key: val.id
          })
        })
        res.data.data.rows.sysResourcesOfPermissionList.forEach(val => {
          checkPage.push(val.id)
        })
        this.pageData = pageData
        this.pageIds = checkPage
        this.pageLoading = false
      })
    },
    // 授权文件组分页功能
    handleFileGroupCurrentChange(val) {
      if (this.numberTotal - this.moveArr > (val - 1) * this.numberRows) {
        this.numberPage = val
      } else {
        this.numberPage = val - 1
      }
      this.fileGroupdialogVisible = true
      this.getFileGroup()
    },
    // 改变授权文件组穿梭框时获取选中的文件组
    handleFileGroupChange(value, direction, movedKeys) {
      this.fileGroupIds = value
      if (direction === 'left') {
        this.moveArr = -movedKeys.length
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      updataFileGroup({ permissionId: this.permissionId, fileGroupIds: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error('授权失败')
        }
        this.initList()
      })
    },
    // 显示授权文件组对话框
    showFileGroupDialog(id) {
      this.numberPage = 1
      this.fileGroupLoading = true
      this.permissionId = id
      this.fileGroupdialogVisible = true
      this.getFileGroup()
    },
    getFileGroup() {
      getFileGroupInfo({
        permissionId: this.permissionId,
        page: this.numberPage,
        rows: this.numberRows
      }).then(res => {
        const fileGroupData = []
        const checkFileGroup = []
        this.numberTotal = res.data.data.total
        res.data.data.rows.otherFileGroupList.forEach((val, index) => {
          fileGroupData.push({
            label: val.fileGroupName,
            key: val.id
          })
        })
        res.data.data.rows.sysFileGroupOfPermissionList.forEach(val => {
          checkFileGroup.push(val.id)
        })
        this.fileGroupData = fileGroupData
        this.fileGroupIds = checkFileGroup
        this.fileGroupLoading = false
      })
    },

    // 授权菜单分页功能
    handleMenuCurrentChange(val) {
      if (this.numberTotal - this.moveArr > (val - 1) * this.numberRows) {
        this.numberPage = val
      } else {
        this.numberPage = val - 1
      }
      this.menudialogVisible = true
      this.getMenu()
    },
    // 改变授权菜单穿梭框时获取选中的菜单
    handleMenuChange(value, direction, movedKeys) {
      this.menuIds = value
      if (direction === 'left') {
        this.moveArr = -movedKeys.length
      } else if (direction === 'right') {
        this.moveArr = movedKeys.length
      }
      updataMenu({ permissionId: this.permissionId, menuIds: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error('授权失败')
        }
        this.initList()
      })
    },
    // 显示授权菜单对话框
    showMenuDialog(id) {
      this.numberPage = 1
      this.menuLoading = true
      this.permissionId = id
      this.menudialogVisible = true
      this.getMenu()
    },
    getMenu() {
      getMenuInfo({
        permissionId: this.permissionId,
        page: this.numberPage,
        rows: this.numberRows
      }).then(res => {
        const menuData = []
        const checkMenu = []
        this.numberTotal = res.data.data.total
        res.data.data.rows.otherMenuList.forEach((val, index) => {
          menuData.push({
            label: val.menuName,
            key: val.id
          })
        })
        res.data.data.rows.sysMenuOfPermissionList.forEach(val => {
          checkMenu.push(val.id)
        })
        this.menuData = menuData
        this.menuIds = checkMenu
        this.menuLoading = false
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
      updataRole({ permissionId: this.permissionId, roleIds: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error('授权失败')
        }
        this.initList()
      })
    },
    // 显示授权角色对话框
    showRoleDialog(id) {
      this.numberPage = 1
      this.roleLoading = true
      this.permissionId = id
      this.roledialogVisible = true
      this.getRole()
    },
    getRole() {
      getRoleInfo({
        permissionId: this.permissionId,
        page: this.numberPage,
        rows: this.numberRows
      }).then(res => {
        const roleData = []
        const checkRole = []
        this.numberTotal = res.data.data.total
        res.data.data.rows.otherRoleList.forEach((val, index) => {
          roleData.push({
            label: val.roleName,
            key: val.id
          })
        })
        res.data.data.rows.roleOfPermissionList.forEach(val => {
          checkRole.push(val.id)
        })
        this.roleData = roleData
        this.roleIds = checkRole
        this.roleLoading = false
      })
    },
    // 删除权限功能实现
    deletePermission(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deletePermissionById(id).then(res => {
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
    // 编辑权限
    updateData() {
      this.$refs['permissionform'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.permissiondialogFormVisible = false
          // // 调用接口发送请求
          editPermissionList(this.permissionform).then(res => {
            console.log(res)
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            }
            // 重置表单元素的数据
            this.$refs['permissionform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 弹出编辑权限对话框
    handleUpdate(row) {
      // 显示对话框
      this.permissiondialogFormVisible = true
      this.dialogStatus = '编辑权限'
      //   添加默认数据
      this.oldPermissionName = row.permissionName
      this.permissionform.permissionName = row.permissionName
      this.permissionform.status = parseInt(row.status)
      this.permissionform.id = row.id
    },
    // 取消编辑
    cancelEdit() {
      this.$nextTick(() => {
        this.$refs['permissionform'].clearValidate()
      })
      this.permissiondialogFormVisible = false
    },
    // 新增权限
    createPermissionData() {
      this.$refs['permissionform'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.permissiondialogFormVisible = false
          // 调用接口发送请求
          addPermissionList(this.permissionform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error('添加数据失败')
            }
            // 重置表单元素的数据
            this.$refs['permissionform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 显示新增權限对话框
    handleCreate() {
      this.resetPermissionform()
      this.dialogStatus = '新增权限'
      this.permissiondialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['permissionform'].clearValidate()
      })
    },
    // 清空信息
    resetPermissionform() {
      this.permissionform = {
        rpermissionName: undefined,
        status: undefined
      }
    },

    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    selecteUserStatus(value) {
      this.listQuery.status = value
    },
    // 项目初始化
    initList() {
      this.permissionLoading = true
      getPermissionList(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.permissionList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error('获取数据失败')
        }
        this.permissionLoading = false
      })
    },
    // 分页功能
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    }
  }
}
</script>

<style lang="scss" >
.permissionManagement {
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
    width: 320px;
  }
  .el-transfer-panel .el-transfer-panel__footer {
    position: relative;
  }
}
</style>

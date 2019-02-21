<template>
  <div v-loading="permissionLoading" class="permissionManagement">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="权限名称:">
          <el-input v-model="listQuery.permissionName" placeholder="请输入权限名称" maxlength="20" class="filter-item" clearable @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable class="filter-item" @change="selecteUserStatus">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>
    <!-- 表格 -->
    <el-table :data="permissionList" border fit highlight-current-row style="width: 100%;height:100%">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" label="序号" width="60" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="权限名称" align="center" prop="permissionName" />
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
      <el-table-column label="操作" align="center" min-width="280" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button type="primary" size="mini" @click="showRoleDialog(scope.row.id)">授权角色</el-button>
          <el-button type="primary" size="mini" @click="showMenuDialog(scope.row.id)">授权菜单</el-button>
          <el-button type="primary" size="mini" @click="showFileGroupDialog(scope.row.id)">授权文件组</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deletePermission(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10, 20, 30, 40]" :page-size="listQuery.rows" :total="total" class="tablePagination" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    <!-- 新增权限对话框 -->
    <template v-if="permissiondialogFormVisible">
      <el-dialog :visible.sync="permissiondialogFormVisible" :title="dialogStatus" width="400px" >
        <el-form ref="permissionform" :rules="rules" :model="permissionform" label-position="right" label-width="80px" style="max-width:300px;margin-left:20px">
          <el-form-item label="权限名称" prop="permissionName">
            <el-input v-model="permissionform.permissionName" maxlength="20" clearable/>
          </el-form-item>
          <el-form-item label="状态" prop="recordStatus">
            <el-select v-model="permissionform.recordStatus" class="filter-item" placeholder="请选择" style="width:100%" >
              <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增权限'?createPermissionData():updateData()">提交</el-button>
          <el-button @click="permissiondialogFormVisible = false">取消</el-button>
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
        <el-transfer v-loading="roleLoading" v-model="roleIds" :data="roleData" :titles="['其他角色', '权限拥有角色']" filterable filter-placeholder="请输入角色名称" class="box" @change="handleRoleChange">
          <span slot="left-footer" size="small">
            <el-pagination :current-page="numberPage" :pager-count="5" :total="numberTotal" background layout="prev, pager, next" @current-change="handleRoleCurrentChange" />
          </span>
          <span slot="right-footer" size="small" />
        </el-transfer>
      </el-dialog>
    </template>
    <!-- 弹出授权文件组对话框 -->
    <template v-if="fileGroupdialogVisible">
      <el-dialog :visible.sync="fileGroupdialogVisible" title="授权文件组" width="800px">
        <div class=" transfer-search el-transfer-panel__filter el-input el-input--small el-input--prefix">
          <input v-model="fileGroupName" type="text" autocomplete="off" placeholder="请输入文件组名称" class="el-input__inner" clearable>
          <span class="el-input__prefix">
            <i class="el-input__icon el-icon-search"/>
          </span>
        </div>
        <el-transfer v-loading="fileGroupLoading" v-model="fileGroupIds" :data="fileGroupData" :titles="['其他文件组', '权限拥有文件组']" filterable filter-placeholder="请输入文件组名称" class="box" @change="handleFileGroupChange">
          <span slot="left-footer" size="small">
            <el-pagination :current-page="numberPage" :pager-count="5" :total="numberTotal" background layout="prev, pager, next" @current-change="handleFileGroupCurrentChange" />
          </span>
          <span slot="right-footer" size="small" />
        </el-transfer>
      </el-dialog>
    </template>
    <!-- 授权菜单 -->
    <el-dialog :visible.sync="menuDialogVisible" title="授权菜单和功能" width="500px">
      <el-tree
        v-loading="menuLoading"
        ref="tree"
        :data="data2"
        :default-checked-keys="data3"
        :props="defaultProps"
        node-key="id"
        show-checkbox>
        <span slot-scope="{ node }" class="custom-tree-node">
          <span>
            <i :class="node.icon" style="margin-right:3px"/>{{ node.label }}
          </span>
        </span>
      </el-tree>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="getCheckedKeys">确 定</el-button>
        <el-button @click="menuDialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { api, paramApi } from '@/api/Permission-model/userManagement'
// import {
//   getPermissionList,
//   addPermissionList,
//   editPermissionList,
//   checkPermissionName,
//   getRoleInfo,
//   updataRole,
//   deletePermissionById,
//   getAllList,
//   updataAllData,
//   getFileGroupInfo,
//   updataFileGroup
// } from '@/api/Permission-model/permissionManagement'
export default {

  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.dialogStatus === '新增权限') {
          paramApi('system/sysPermission/checkPerssionName', this.permissionform.permissionName, 'permissionName').then(res => {
            if (res.data.code === '0000') {
              if (res.data.data === 'success') {
                callback()
              } else {
                callback(new Error('权限名称已重复'))
              }
            }
          })
        } else {
          if (this.oldPermissionName !== this.permissionform.permissionName) {
            paramApi('system/sysPermission/checkPerssionName', this.permissionform.permissionName, 'permissionName').then(res => {
              if (res.data.code === '0000') {
                if (res.data.data === 'success') {
                  callback()
                } else {
                  callback(new Error('权限名称已重复'))
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
      fileGroupName: '',
      roleName: '',
      isDisabled: false,
      data3: [],
      data2: [],
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      fileGroupData: [],
      fileGroupIds: [],
      fileGroupLoading: false,
      fileGroupdialogVisible: false,
      menuDialogVisible: false,
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
        recordStatus: undefined
      },
      dialogStatus: undefined,
      permissiondialogFormVisible: false,
      permissionList: [],
      permissionLoading: false,
      listQuery: {
        page: 1,
        rows: 10,
        permissionName: undefined,
        recordStatus: undefined
      },
      total: undefined,
      statusOptions: [{
        value: '1',
        label: '生效'
      }, {
        value: '2',
        label: '未生效'
      }],
      rules: {
        permissionName: [{ required: true, message: '请输入权限名称', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        recordStatus: [{ required: true, message: '请选择状态', trigger: 'blur' }]
      }
    }
  },
  watch: {
    roleName: function(newVal, oldVal) {
      this.numberPage = 1
      this.getRole()
    },
    fileGroupName: function(newVal, oldVal) {
      this.numberPage = 1
      this.getFileGroup()
    }
  },
  created() {
    this.initList()
  },
  methods: {

    diguiquchu(datas, arr, v, i, needdelarr) {
      // 递归找出半选中的数据
      arr.map((item, index) => {
        if (item.id === v && item.children) {
          // datas.splice(i, 1);//因为每次截取会改变原数组，所以不能这样
          needdelarr.push(v)
          this.diguiquchu(datas, item.children, v, i, needdelarr)
        } else if (item.id !== v && item.children) {
          this.diguiquchu(datas, item.children, v, i, needdelarr)
        }
      })
    },
    getCheckedKeys() {
      const checkData = this.$refs.tree.getCheckedKeys().concat(this.$refs.tree.getHalfCheckedKeys())
      api('system/sysPermission/addMenuAndResourcesToPermission', { menuAndResourcesIds: checkData, permissionId: this.permissionId }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.menuDialogVisible = false
        // this.initList()
      })
    },
    showMenuDialog(id) {
      this.permissionId = id
      this.menuDialogVisible = true
      this.menuLoading = true
      // 获取权限具有的菜单和功能
      paramApi('system/sysPermission/getMenuAndResources', id, 'permissionId').then(res => {
        if (res.data.code === '0000') {
          this.data2 = res.data.data.sysMenuTreeVOList
          var rules = res.data.data.menuAndResourcesIds
          var needDelArr = []
          rules.map((v, i) => {
            this.diguiquchu(res.data.data.menuAndResourcesIds, res.data.data.sysMenuTreeVOList, v, i, needDelArr)
          })
          rules = rules.filter(item => !needDelArr.includes(item))
          this.data3 = rules
        } else {
          this.$message.error(res.data.result)
        }
        this.menuLoading = false
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
      api('system/sysPermission/addFileGroupToPermission', { permissionId: this.permissionId, fileGroupIds: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
        // this.initList()
      })
    },
    // 显示授权文件组对话框
    showFileGroupDialog(id) {
      this.numberPage = 1
      this.fileGroupLoading = true
      this.permissionId = id
      this.fileGroupdialogVisible = true
      this.fileGroupName = ''
      this.getFileGroup()
    },
    getFileGroup() {
      api('system/sysPermission/findFileGroupOfPermission', {
        permissionId: this.permissionId,
        page: this.numberPage,
        rows: this.numberRows,
        fileGroupName: this.fileGroupName
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
      api('system/sysPermission/addRoleToPermission', { permissionId: this.permissionId, roleIds: value }).then(res => {
        if (res.data.code === '0000') {
          this.$message({
            message: '授权成功',
            type: 'success'
          })
        } else {
          this.$message.error(res.data.result)
        }
        // this.initList()
      })
    },
    // 显示授权角色对话框
    showRoleDialog(id) {
      this.numberPage = 1
      this.roleLoading = true
      this.permissionId = id
      this.roledialogVisible = true
      this.roleName = ''
      this.getRole()
    },
    getRole() {
      api('system/sysPermission/findRoleOfPermission', {
        permissionId: this.permissionId,
        page: this.numberPage,
        rows: this.numberRows,
        roleName: this.roleName
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
          paramApi('system/sysPermission/delete', id, 'ids').then(res => {
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
    // 编辑权限
    updateData() {
      this.isDisabled = true
      this.$refs['permissionform'].validate(valid => {
        if (valid) {
          // // 调用接口发送请求
          api('system/sysPermission/update', this.permissionform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 将对话框隐藏
            this.permissiondialogFormVisible = false
            // 重置表单元素的数据
            this.$refs['permissionform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.isDisabled = false
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
      this.permissionform.recordStatus = row.recordStatus.toString()
      this.permissionform.id = row.id
      this.$nextTick(() => {
        this.$refs['permissionform'].clearValidate()
      })
    },
    // 新增权限
    createPermissionData() {
      this.isDisabled = true
      this.$refs['permissionform'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api('system/sysPermission/add', this.permissionform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              // 将对话框隐藏
              this.permissiondialogFormVisible = false
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 重置表单元素的数据
            this.$refs['permissionform'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.isDisabled = false
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
        permissionName: undefined,
        recordStatus: undefined
      }
    },

    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    selecteUserStatus(value) {
      this.listQuery.recordStatus = value
    },
    // 项目初始化
    initList() {
      this.permissionLoading = true
      api('system/sysPermission/list', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.permissionList = res.data.data.rows
          this.total = res.data.data.total
          if (this.permissionList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
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
.el-dialog {
  .el-dialog__footer {
    text-align: center;
  }
  .el-tree{
    height: 360px;
    overflow: auto;
  }
}
</style>

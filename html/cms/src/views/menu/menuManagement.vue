<template>
  <div v-loading="listLoading" class="menuManagement">
    <div class="menu-left">
      <el-tree :data="menuList" :expand-on-click-node="false" node-key="id" @node-click="handleNodeClick">
        <span slot-scope="{ node, data }" class="custom-tree-node">
          <span>
            <i :class="node.icon" style="margin-right:3px"/>{{ node.label }}
          </span>
          <span style="margin-left:20px;padding-right:18px">
            <i
              class="el-icon-plus"
              @click="() => addMenu(data)"/>
            <i
              class="el-icon-edit"
              @click="() => editMenu( data)"/>
            <i
              class="el-icon-delete"
              @click="() => deleteMenu( data.id)"/>
          </span>
        </span>
      </el-tree>
    </div>
    <div v-show="isRight" class="menu-right bgc">
      <div v-if="isData" class="noData">没有子菜单</div>
      <div v-show="isShowInfo" class="menuInfo">
        <div class="menuInfo-title" style="margin-bottom:20px;">下级菜单</div>
        <div class="menu-content">
          <span>{{ currentMenuName }}</span>
          <el-form v-if="isMove" ref="subForm" :rules="rules" :model="subForm" label-width="100px">
            <el-form-item
              v-for="(item,index) in subForm.menuData"
              :key="index"
              :prop="'menuData.'+index+'.label'"
              :rules="menuDataRules.label"
            >
              <el-input v-model="item.label" @blur="checkoutSubName"/><a href="javascript:;" class="fa fa-long-arrow-up" @click="menuUp(item,index)"/><a href="javascript:;" class="fa fa-long-arrow-down" @click="menuDown(item,index)"/>
            </el-form-item>
            <el-form-item>
              <el-button :disabled="isDisabled" type="primary" @click="submitMenuInfo('subForm')" >保存</el-button>
              <el-button @click="cencalEdit('subForm')" >取消</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
      <div v-show="isShowMenuDir" class="menuDirInfo">
        <div> <span>页面名称：</span> {{ dataForm.menuName }}</div>
        <div class="urlAddress"> <span>url地址：</span> {{ dataForm.menuUrl }}</div>
        <div class="menuDirInfo-content">
          <el-button class="filter-item" type="primary" icon="el-icon-plus" @click="handleCreate">新增功能</el-button>
          <el-table :data="tableData" fit border style="width: 100%">
            <el-table-column prop="resourcesName" align="center" label="功能名称" />
            <el-table-column prop="resourcesUrl" align="center" min-width="200" label="链接" />
            <el-table-column label="操作" align="center" min-width="100">
              <template slot-scope="scope">
                <!-- 编辑按钮 -->
                <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
                <!-- 删除按钮 -->
                <el-button size="mini" type="danger" @click="deleteResourcesName(scope.row.id)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </div>
    </div>
    <!-- 弹出的新增菜单和编辑菜单对话框 -->
    <template v-if="menuDialogVisible">
      <el-dialog :visible.sync="menuDialogVisible" :title="dialogStatus" width="500px">
        <el-form ref="menuForm" :rules="rules" :model="menuForm" label-width="100px" @submit.native.prevent>
          <el-form-item v-show="visible" label="新增位置:" prop="location">
            <el-radio v-model="location" label="1">同级菜单</el-radio>
            <el-radio v-model="location" label="0">子菜单</el-radio>
          </el-form-item>
          <el-form-item v-show="!isTrue" label="菜单类型:" prop="type">
            <el-radio v-model="radio" label="1">目录</el-radio>
            <el-radio v-model="radio" label="2">页面</el-radio>
          </el-form-item>
          <el-form-item label="菜单名称:" prop="menuName">
            <el-input v-model="menuForm.menuName" style="width:340px;" maxlength="20"/>
          </el-form-item>
          <el-form-item v-if="isShow" label="url地址:" prop="menuUrl">
            <el-input v-model="menuForm.menuUrl" style="width:340px;" maxlength="150" />
          </el-form-item>
          <el-form-item class="footer" label-width="0px">
            <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增'?createData():updateData()">保存</el-button>
            <el-button @click="menuDialogVisible = false">取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </template>
    <!-- 新增功能和编辑功能弹框 -->
    <el-dialog :visible.sync="resourcesDialogVisible" :title="dialogStatus" width="500px">
      <el-form ref="resourcesForm" :rules="rules" :model="resourcesForm" label-width="100px" class="resourcesBox">
        <el-form-item label="功能名称:" prop="resourcesName">
          <el-input v-model="resourcesForm.resourcesName" maxlength="20" />
        </el-form-item>
        <el-form-item label="功能地址:" prop="resourcesUrl">
          <el-input v-model="resourcesForm.resourcesUrl" style="width:340px;" maxlength="150"/>
        </el-form-item>
        <el-form-item class="footer" label-width="0px">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增功能'?createResources():updateResources()">保存</el-button>
          <el-button @click="resourcesDialogVisible = false">取消</el-button>
        </el-form-item>
      </el-form>

    </el-dialog>
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
        if (this.dialogStatus === '新增') {
          api(`${this.GLOBAL.systemUrl}system/sysMenu/checkMenuName`, { menuName: value, parentId: this.menuForm.parentId }, 'post').then(response => {
            if (response.data.data === 'fail') {
              callback(new Error('菜单名称已重复'))
            } else {
              callback()
            }
          })
        } else {
          if (this.oldMenuName !== this.menuForm.menuName) {
            api(`${this.GLOBAL.systemUrl}system/sysMenu/checkMenuName`, { menuName: value, parentId: this.menuForm.parentId }, 'post').then(response => {
              if (response.data.data === 'fail') {
                callback(new Error('菜单名称已重复'))
              } else {
                callback()
              }
            })
          } else {
            callback()
          }
        }
      }
    }
    var checkResources = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.dialogStatus === '新增') {
          api(`${this.GLOBAL.systemUrl}system/sysResources/checkResourceName`, { resourceName: this.resourcesForm.resourcesName, menuId: this.resourcesForm.menuId }, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              if (res.data.data === 'success') {
                callback()
              } else {
                callback(new Error('功能名称已重复'))
              }
            }
          })
        } else {
          if (this.oldResourcesName !== this.resourcesForm.resourcesName) {
            api(`${this.GLOBAL.systemUrl}system/sysResources/checkResourceName`, { resourceName: this.resourcesForm.resourcesName, menuId: this.resourcesForm.menuId }, 'post').then(res => {
              if (res.data.code === this.GLOBAL.code) {
                if (res.data.data === 'success') {
                  callback()
                } else {
                  callback(new Error('功能名称已重复'))
                }
              }
            })
          } else {
            callback()
          }
        }
      }
    }
    var checkoutUrl = (rule, value, callback) => {
      if (value && value.length > 150) {
        callback(new Error('url路径的长度不能超过150个字符'))
      } else {
        callback()
      }
    }
    var checkLabel = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        var count = 0
        // 循环整个数组 判断有没有重名的字段
        this.subForm.menuData.forEach((val, index) => {
          if (value === val.label) {
            count = count + 1
          }
        })
        if (count > 1) {
          callback(new Error('菜单名称已重复'))
        } else {
          callback()
        }
      }
    }
    return {
      currentData: undefined,
      currentId: undefined,
      isRight: true,
      checkoutId: undefined,
      checkoutParentId: undefined,
      parentId: undefined,
      oldResourcesName: undefined,
      resourcesForm: {
        id: undefined,
        resourcesName: undefined,
        resourcesUrl: undefined,
        menuId: undefined
      },
      resourcesDialogVisible: false,
      tableData: [],
      isShowMenuDir: false,
      dataForm: {
        menuName: undefined,
        menuUrl: undefined
      },
      isMove: true,
      isData: false,
      isShowInfo: false,
      isTrue: false,
      subForm: {
        menuData: []
      },
      currentMenuName: undefined,
      location: '1',
      visible: true,
      isShow: false,
      oldMenuName: undefined,
      isDisabled: false,
      radio: '1',
      menuId: undefined,
      menuForm: {
        id: undefined,
        parentId: undefined,
        menuName: undefined,
        menuUrl: '/'
      },
      dialogStatus: undefined,
      menuDialogVisible: false,
      listLoading: false,
      menuList: [],
      rules: {
        menuName: [
          { required: true, message: '请输入菜单名称', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        menuUrl: [{ required: true, message: 'url不能为空', trigger: 'blur' }, { validator: checkoutUrl, trigger: 'blur' }],
        resourcesUrl: [{ required: true, message: 'url不能为空', trigger: 'blur' }, { validator: checkoutUrl, trigger: 'blur' }],
        resourcesName: [
          { required: true, message: '请输入功能名称', trigger: 'blur' },
          { validator: checkResources, trigger: 'blur' }]
      },
      menuDataRules: {
        label: [{ required: true, message: '请输入菜单名称', trigger: 'blur' }, { validator: checkLabel, trigger: 'blur' }]
      }
    }
  },
  watch: {
    // 如果 `radio` 发生改变，这个函数就会运行
    'radio': function() {
      if (this.radio === '1') {
        this.isShow = false
      } else if (this.radio === '2') {
        this.isShow = true
      }
    },
    'location': function() {
      if (this.location === '1') {
        this.menuForm.parentId = this.checkoutParentId
      } else if (this.location === '0') {
        this.menuForm.parentId = this.checkoutId
      }
    }
  },
  created() {
    this.initList()
  },
  mounted() {
    // this.defaultRightData()
  },
  methods: {
    // 失去焦点的时候判断子菜单的名字是否有重复
    checkoutSubName() {
      const arr = []
      this.subForm.menuData.forEach(val => {
        arr.push(val.label)
      })
      if ((new Set(arr)).size === arr.length) {
        this.$refs['subForm'].clearValidate()
      }
    },
    // 删除页面的功能
    deleteResourcesName(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi(`${this.GLOBAL.systemUrl}system/sysResources/delete`, id, 'ids').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              this.defaultLeft()
              this.getResources()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {
        })
    },
    // 实现编辑功能
    updateResources() {
      // 避免重复点击提交
      this.$refs['resourcesForm'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          // 调用接口发送请求
          api(`${this.GLOBAL.systemUrl}system/sysResources/update`, this.resourcesForm, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 将对话框隐藏
            this.resourcesDialogVisible = false
            // 重置表单元素的数据
            this.$refs['resourcesForm'].resetFields()
            this.defaultLeft()
            this.getResources()
          })
        }
      })
    },
    // 显示编辑功能对话框
    handleUpdate(row) {
      this.oldResourcesName = row.resourcesName
      this.resourcesDialogVisible = true
      this.dialogStatus = '编辑功能'
      this.resourcesForm.id = row.id
      this.resourcesForm.resourcesName = row.resourcesName
      this.resourcesForm.menuId = row.menuId
      this.resourcesForm.resourcesUrl = row.resourcesUrl
      this.$refs['resourcesForm'].clearValidate()
    },
    // 实现添加功能
    createResources() {
      this.isDisabled = true
      this.$refs['resourcesForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api(`${this.GLOBAL.systemUrl}system/sysResources/add`, this.resourcesForm, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else { this.$message.error(res.data.result) }
            this.isDisabled = false
            // 将对话框隐藏
            this.resourcesDialogVisible = false
            // 重置表单元素的数据
            this.$refs['resourcesForm'].resetFields()
            this.defaultLeft()
            this.getResources()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    // 获取所有功能
    getResources() {
      paramApi(`${this.GLOBAL.systemUrl}system/sysResources/findResourcesByMenuId`, this.resourcesForm.menuId, 'menuId').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.tableData = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },

    // 显示新增功能对话框
    handleCreate() {
      this.resourcesForm.resourcesName = undefined
      this.resourcesForm.resourcesUrl = undefined
      this.dialogStatus = '新增功能'
      this.resourcesDialogVisible = true
      this.$nextTick(() => {
        this.$refs['resourcesForm'].clearValidate()
      })
    },
    cencalEdit() {
      if (this.parentId === undefined || null) {
        this.parentId = '1'
      }
      paramApi(`${this.GLOBAL.systemUrl}system/sysMenu/getChildrenMenuByParentId`, this.parentId, 'parentId').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.subForm.menuData = res.data.data
          this.$refs['subForm'].clearValidate()
        } else {
          this.$message.error(res.data.result)
        }
        this.defaultLeft()
      // this.initList()
      })
    },
    // 点击向下移动的时候
    menuDown(item, index) {
      if (index === this.subForm.menuData.length - 1) {
        alert('已经是最下面了')
      } else {
        const downIndex = this.subForm.menuData[index + 1]
        this.subForm.menuData[index + 1] = this.subForm.menuData[index]
        this.subForm.menuData[index] = downIndex
        const downSort = this.subForm.menuData[index + 1].sort
        this.subForm.menuData[index + 1].sort = this.subForm.menuData[index].sort
        this.subForm.menuData[index].sort = downSort
        this.isMove = false
        this.$nextTick(() => {
          this.isMove = true
        })
      }
    },
    // 点击向上移动
    menuUp(item, index) {
      if (index === 0) {
        alert('已经是最上面了')
      } else {
        const upIndex = this.subForm.menuData[index - 1]
        const upSort = this.subForm.menuData[index - 1].sort
        this.subForm.menuData[index - 1].sort = this.subForm.menuData[index].sort
        this.subForm.menuData[index].sort = upSort
        this.subForm.menuData[index - 1] = this.subForm.menuData[index]
        this.subForm.menuData[index] = upIndex
        this.isMove = false
        this.$nextTick(() => {
          this.isMove = true
        })
      }
    },
    // 点击保存的时候
    submitMenuInfo(formName) {
      const newData = []
      // 对数组进行遍历 得到与后台要求的数据一样
      this.subForm.menuData.forEach((val) => {
        newData.push({
          id: val.id,
          menuName: val.label,
          menuUrl: val.menuUrl,
          sort: val.sort
        })
      })
      this.$refs['subForm'].validate(valid => {
        this.isDisabled = true
        if (valid) {
          // 调用接口发送请求 进行批量更新
          api(`${this.GLOBAL.systemUrl}system/sysMenu/updateBatch`, { sysMenuSortList: newData }, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '保存成功',
                type: 'success'
              })
            } else { this.$message.error(res.data.result) }
            this.isDisabled = false
            // 刷新页面显示
            this.defaultLeft()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    handleNodeClick(data) {
      this.currentId = data.id
      this.isRight = true
      this.parentId = data.id
      if (data.isDir === '1') {
        this.currentMenuName = data.label
        this.isShowMenuDir = false
        this.subForm.menuData = data.children

        if (data.children === null) {
          this.isShowInfo = false
          this.isData = true
        } else {
          this.isData = false
          this.isShowInfo = true
        }
      } else if (data.isDir === '0') {
        this.tableData = data.resourcesList
        this.isData = false
        this.isShowMenuDir = true
        this.isShowInfo = false
        this.isShowTable = true
        this.dataForm.menuName = data.label
        this.dataForm.menuUrl = data.menuUrl
        this.resourcesForm.menuId = data.id
      }
      const arr = []
      if (this.subForm.menuData) {
        this.subForm.menuData.forEach(val => {
          arr.push(val.label)
        })
      }
      if ((new Set(arr)).size === arr.length) {
        this.$refs['subForm'].clearValidate()
      }
    },
    // 删除菜单实现
    deleteMenu(id) {
      this.$confirm(`此操作将永久删除这个菜单的数据及其子菜单数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi(`${this.GLOBAL.systemUrl}system/sysMenu/delete`, id, 'id').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '删除成功',
                type: 'success'
              })

              this.defaultLeft()
              if (this.currentId === id) {
                this.isRight = false
              } else {
                this.isRight = true
              }
            } else {
              this.$message.error(res.data.result)
            }
          })
        }).catch(() => {

        })
    },
    // 编辑菜单的实现
    updateData() {
      this.$refs['menuForm'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          // // 调用接口发送请求
          api(`${this.GLOBAL.systemUrl}system/sysMenu/update`, this.menuForm, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              if (this.currentData.isDir === '0') {
                this.dataForm.menuName = this.menuForm.menuName
                this.dataForm.menuUrl = this.menuForm.menuUrl
              } else if (this.currentData.isDir === '1') {
                this.currentMenuName = this.menuForm.menuName
              }
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 重置表单元素的数据
            this.$refs['menuForm'].resetFields()
            // 将对话框隐藏
            this.menuDialogVisible = false
            // 刷新页面显示
            this.defaultLeft()
          })
        }
      })
    },
    // 显示编辑对话框
    editMenu(data) {
      this.isTrue = true
      this.dialogStatus = '编辑'
      this.currentData = data
      this.visible = false
      this.oldMenuName = data.label
      this.menuForm.id = data.id
      this.menuDialogVisible = true
      this.menuForm.menuName = data.label
      if (data.parentName) {
        this.menuForm.parentId = data.parentId
      } else {
        this.menuForm.parentId = '1'
      }
      if (data.isDir === '1') {
        this.isShow = false
        this.menuForm.menuUrl = data.menuUrl
      } else if (data.isDir === '0') {
        this.isShow = true
        this.menuForm.menuUrl = data.menuUrl
      }
      this.$nextTick(() => {
        this.$refs['menuForm'].clearValidate()
      })
    },
    // 实现新增菜单
    createData() {
      this.$refs['menuForm'].validate(valid => {
        // 避免重复点击提交
        this.isDisabled = true
        if (valid) {
          // 判断用户选择的是目录还是页面
          if (this.radio === '1') {
            api(`${this.GLOBAL.systemUrl}system/sysMenu/addMenuDir`, { menuName: this.menuForm.menuName, menuUrl: this.menuForm.menuUrl, parentId: this.menuForm.parentId }, 'post').then(res => {
              if (res.data.code === this.GLOBAL.code) {
                this.$message({
                  message: '添加成功',
                  type: 'success'
                })
                // 刷新页面显示
                this.defaultLeft()
                this.updataRight()
              } else {
                this.$message.error(res.data.result)
              }
              this.isDisabled = false
            })
          } else if (this.radio === '2') {
            api(`${this.GLOBAL.systemUrl}system/sysMenu/addMenu`, { menuName: this.menuForm.menuName, menuUrl: this.menuForm.menuUrl, parentId: this.menuForm.parentId }, 'post').then(res => {
              if (res.data.code === this.GLOBAL.code) {
                this.$message({
                  message: '添加成功',
                  type: 'success'
                })
                // 刷新页面显示
                this.defaultLeft()
                this.updataRight()
              } else {
                this.$message.error(res.data.result)
              }
              this.isDisabled = false
            })
          }
          // 重置表单元素的数据
          this.$refs['menuForm'].resetFields()
          // 将对话框隐藏
          this.menuDialogVisible = false
        } else {
          this.isDisabled = false
        }
      })
    },
    // 更新右侧页面
    updataRight() {
      if (this.location === '0') {
        paramApi(`${this.GLOBAL.systemUrl}system/sysMenu/getChildrenMenuByParentId`, this.checkoutId, 'parentId').then(res => {
          if (res.data.code === this.GLOBAL.code) {
            this.subForm.menuData = res.data.data
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    // 显示新增弹框
    addMenu(data) {
      this.radio = '1'
      this.location = '1'
      this.isTrue = false
      this.isShow = false
      this.dialogStatus = '新增'
      this.menuDialogVisible = true
      this.menuForm.menuName = undefined
      this.menuId = data.id
      this.checkoutId = data.id
      this.checkoutParentId = data.parentId
      if (data.parentName) {
        this.menuForm.parentId = data.parentId
      } else {
        this.menuForm.parentId = '1'
      }
      if (data.isDir === '0') {
        this.visible = false
      } else if (data.isDir === '1') {
        this.visible = true
      }
      this.menuForm.menuUrl = ''
      this.$nextTick(() => {
        this.$refs['menuForm'].clearValidate()
      })
    },
    defaultLeft() {
      this.listLoading = true
      api(`${this.GLOBAL.systemUrl}system/sysMenu/list`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.menuList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 初始化项目
    initList() {
      this.listLoading = true
      api(`${this.GLOBAL.systemUrl}system/sysMenu/list`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.menuList = res.data.data
          this.isShowInfo = true
          this.subForm.menuData = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    }
  }
}
</script>

<style lang="scss" >
.menuManagement{
  // height: 100%;
  padding:15px;
  display: flex;
  background-color: #fff;
  .resourcesBox{
    .el-input--medium .el-input__inner{
      height: 40px;
      line-height: 40px;
    }
    .el-input{
      width: 340px;
    }
  }
 .menu-left{
    height: 100%;
  .el-tree{
    height: 100%;
    // width: 270px;
  // padding: 20px;
  // overflow: auto;
  }
}
.menu-right{
  // height: 100%;
  // overflow: auto;
  margin-left:20px;
  flex:1;
  // padding :20px;
  .menu-content{
    display: flex;
    align-items: center;
    >span{
      margin-right: 100px;
    }
  }
  .el-input--medium{
    width: 188px;
  }
  .urlAddress{
    margin:10px 0px;
  }
}
.footer{
  text-align: center;}
.el-form-item{
  margin-bottom: 20px;
  .fa-long-arrow-up{
    margin: auto 10px;
    color: green;
  }
  .fa-long-arrow-down{
       color: red;
      margin: auto 10px;
   }
   .hint{
     color: red;
   }
}
}
 .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
  }
</style>

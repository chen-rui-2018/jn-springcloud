<template>
  <div v-loading="listLoading" class="menuManagement">
    <div class="menu-left">
      <el-tree :data="menuList" :expand-on-click-node="false" node-key="id" @node-click="handleNodeClick">
        <span slot-scope="{ node, data }" class="custom-tree-node">
          <span>
            <i :class="node.icon" style="margin-right:3px"/>{{ node.label }}
          </span>
          <span>
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
    <div class="menu-right bgc">
      <div v-if="isData" class="noData">没有子菜单</div>
      <div v-show="isShowInfo" class="menuInfo">
        <div class="menuInfo-title">下级菜单</div>
        <div class="menu-content">
          <span>{{ currentMenuName }}</span>
          <el-form v-if="isMove" ref="subForm" :rules="rules" :model="subForm" label-width="100px">
            <el-form-item
              v-for="(item,index) in subForm.menuData"
              :key="index"
              :prop="'menuData.'+index+'.label'"
              :rules="menuDataRules.label">
              <el-input v-model="item.label" @focus="checkOldName(item.label)" @blur="checkoutName(item.label)" /><a href="javascript:;" class="fa fa-long-arrow-up" @click="menuUp(item,index)"/><a href="javascript:;" class="fa fa-long-arrow-down" @click="menuDown(item,index)"/> <span v-show="isError" class="hint">名称已重复</span>
            </el-form-item>
            <el-form-item>
              <el-button :disabled="isDisabled" type="primary" @click="submitMenuInfo(subForm)" >保存</el-button>
              <el-button @click="cencalEdit('subForm')" >取消</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
      <div v-show="isShowMenuDir" class="menuDirInfo">
        <el-form :model="dataForm" label-position="right" label-width="80px">
          <el-form-item label="页面名称" >
          <el-input v-model="dataForm.menuName" disabled style="width: 300px"/></el-form-item>
          <el-form-item label="url地址" >
            <el-input v-model="dataForm.menuUrl" disabled style="width: 300px"/>
          </el-form-item>
        </el-form>
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
    <el-dialog :visible.sync="menuDialogVisible" :title="dialogStatus" width="400px">
      <el-form ref="menuForm" :rules="rules" :model="menuForm" label-width="100px">
        <el-form-item v-show="visible" label="新增位置:" prop="location">
          <el-radio v-model="location" label="1">同级菜单</el-radio>
          <el-radio v-model="location" label="0">子菜单</el-radio>
        </el-form-item>
        <el-form-item v-show="!isTrue" label="菜单类型:" prop="type">
          <el-radio v-model="radio" label="1">目录</el-radio>
          <el-radio v-model="radio" label="2">页面</el-radio>
        </el-form-item>
        <el-form-item label="菜单名称:" prop="menuName">
          <el-input v-model="menuForm.menuName" style="width:200px;" />
        </el-form-item>
        <el-form-item v-show="isShow" label="url地址:">
          <el-input v-model="menuForm.menuUrl" style="width:200px;" />
        </el-form-item>
        <el-form-item>
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增'?createData():updateData()">保存</el-button>
          <el-button @click="menuDialogVisible = false">取消</el-button>
        </el-form-item>
      </el-form>

    </el-dialog>
    <!-- 新增功能和编辑功能弹框 -->
    <el-dialog :visible.sync="resourcesDialogVisible" :title="dialogStatus" width="500px">
      <el-form ref="resourcesForm" :rules="rules" :model="resourcesForm" label-width="100px">
        <el-form-item label="功能名称:" prop="resourcesName">
          <el-input v-model="resourcesForm.resourcesName" style="width:300px;" />
        </el-form-item>
        <el-form-item label="功能地址:">
          <el-input v-model="resourcesForm.resourcesUrl" style="width:300px;" />
        </el-form-item>
        <el-form-item>
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增功能'?createResources():updateResources()">保存</el-button>
          <el-button @click="resourcesDialogVisible = false">取消</el-button>
        </el-form-item>
      </el-form>

    </el-dialog>
  </div>
</template>

<script>
import {
  getMenuList, checkMenuName, createMenu, createMenuDir, updateMenu, deleteMenuById, updateAllMenu, addResources, editResources, deleteResourcesById, getAllResources, checkResourcesName
} from '@/api/Permission-model/menuManagement'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的菜单名称'))
      } else {
        if (this.oldMenuName !== this.menuForm.menuName) {
          checkMenuName({ menuName: value, parentId: this.menuForm.parentId }).then(response => {
            const result = response.data.data
            if (result === 'success') {
              callback()
            } else {
              callback(new Error('菜单名称已重复'))
            }
          })
        } else {
          callback()
        }
      }
    }
    var checkResources = (rule, value, callback) => {
      const reg = /[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的功能名称'))
      } else {
        if (this.oldResourcesName !== this.resourcesForm.resourcesName) {
          checkResourcesName({ resourceName: this.resourcesForm.resourcesName, menuId: this.resourcesForm.menuId }).then(response => {
            const result = response.data.data
            if (result === 'success') {
              callback()
            } else {
              callback(new Error('功能名称已重复'))
            }
          })
        } else {
          callback()
        }
      }
    }
    var checkLabel = (rule, value, callback) => {
      const reg = /[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的菜单名称'))
      } else {
        // console.log(this.oldSubName, this.currentSubMenuName)
        // var count = 0
        // this.subForm.menuData.forEach((val, index) => {
        //   if (value === val.label) {
        //     count = count + 1
        //     console.log(count)
        //     if (count > 1) {
        //       console.log(value)
        //       callback(new Error('菜单名称已重复'))
        //       console.log('1')
        checkMenuName({ menuName: value, parentId: this.currentParentId }).then(response => {
          const result = response.data.data
          if (result === 'success') {
            callback()
            // this.isDisabled = false
          } else {
            console.log(123)
            // alert(123)
            callback(new Error('菜单名称已重复'))
            this.isDisabled = true
          }
          // })
          // } else {
          //   callback()
          // }
          // }
        })
      }
    }
    return {
      currentSubMenuName: undefined,
      currentParentId: undefined,
      oldSubName: undefined,
      isError: false,
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
      oldMenuData: [],
      isMove: true,
      isData: false,
      isShowInfo: false,
      isTrue: false,
      subForm: {
        menuData: [{ label: '' }]
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
        url: [{ required: true, message: '请填写url', trigger: 'blur' }],
        resourcesName: [
          { required: true, message: '请输入功能名称', trigger: 'blur' },
          { validator: checkResources, trigger: 'blur' }]
        // ],
        // label: [{ required: true, message: '请输入菜单名称', trigger: 'blur' },
        //   { validator: checkLabel, trigger: 'blur' }]
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
    }
  },
  created() {
    this.initList()
  },
  methods: {
    checkOldName(oldName) {
      this.oldSubName = oldName
      console.log(this.oldSubName)
    },
    // 当input框失去焦点的时候判断名称有没有重复
    checkoutName(value) {
      this.currentSubMenuName = value
      // console.log(this.currentSubMenuName)
      // console.log(value)
    //   debugger
    //   // console.log(name)
    //   // console.log(this.menuData)
    //   // for (let i = 0; i <= this.menuData.length; i++) {
    //   //   console.log(i, this.menuData[i])
    //   //   if (this.menuData[i] === name) {
    //   //   }
    //   // }
    //   var count = 0
    //   this.subForm.menuData.forEach((val, index) => {
    //     if (value === val.label) {
    //       count = count + 1
    //       console.log(count)
    //       if (count > 1) {
    //         this.isError = index
    //       } else {
    //         this.isError = false
    //       }
    //     }
    //   })
    },
    // 删除页面的功能
    deleteResourcesName(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deleteResourcesById(id).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              this.getResources()
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
    // 实现编辑功能
    updateResources() {
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisabled = false
      }, 1000)
      this.$refs['resourcesForm'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.resourcesDialogVisible = false
          // 调用接口发送请求
          editResources(this.resourcesForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error('编辑失败')
            }
            // 重置表单元素的数据
            this.$refs['resourcesForm'].resetFields()
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
    },
    // 实现添加功能
    createResources() {
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisabled = false
      }, 1000)
      this.$refs['resourcesForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          addResources(this.resourcesForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else { this.$message.error('添加失败') }
            // 将对话框隐藏
            this.resourcesDialogVisible = false
            // 重置表单元素的数据
            this.$refs['resourcesForm'].resetFields()
            this.getResources()
          })
        }
      })
    },
    // 获取所有功能
    getResources() {
      getAllResources(this.resourcesForm.menuId).then(res => {
        if (res.data.code === '0000') {
          this.tableData = res.data.data
        } else {
          this.$message.error('获取数据失败')
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
    cencalEdit(formName) {
      console.log(this.subForm.menuData)
      console.log(this.oldMenuData)
      // this.subForm.menuData = this.oldMenuData
      this.$refs[formName].clearValidate()
      this.isDisabled = false
      // this.initList()
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
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisabled = false
      }, 500)
      const newData = []
      this.subForm.menuData.forEach((val) => {
        newData.push({
          id: val.id,
          menuName: val.label,
          menuUrl: val.menuUrl,
          sort: val.sort
        })
      })
      // 调用接口进行批量更新
      updateAllMenu({ sysMenuSortList: newData }).then(res => {
        console.log(res)
        if (res.data.code === '0000') {
          this.$message({
            message: '保存成功',
            type: 'success'
          })
        } else {
          this.$message.error('res.result')
        }
        // this.$refs[formName].clearValidate()
        // 刷新页面显示
        this.initList()
      })
    },
    handleNodeClick(data) {
      if (data.isDir === '1') {
        this.currentParentId = data.id
        this.currentMenuName = data.label
        this.isShowMenuDir = false
        this.subForm.menuData = data.children

        if (data.children === null) {
          this.isShowInfo = false
          this.isData = true
        } else {
          this.isData = false
          this.isShowInfo = true
          const arr = []
          data.children.forEach(val => {
            arr.push({
              id: val.id,
              label: val.label,
              menuUrl: val.menuUrl,
              sort: val.sort
            })
          })
          this.oldMenuData = Array.from(new Set(arr))
          console.log(this.oldMenuData)
        }
      } else if (data.isDir === '0') {
        this.tableData = data.resourcesList
        this.isShowMenuDir = true
        this.isShowInfo = false
        this.isShowTable = true
        this.dataForm.menuName = data.label
        this.dataForm.menuUrl = data.menuUrl
        this.resourcesForm.menuId = data.id
      }
    },
    // 删除菜单实现
    deleteMenu(id) {
      this.$confirm(`此操作将永久删除这个菜单及其子菜单, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deleteMenuById(id).then(res => {
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
    // 编辑部门功能的实现
    updateData() {
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisabled = false
      }, 500)
      this.$refs['menuForm'].validate(valid => {
        if (valid) {
          // 将对话框隐藏
          this.menuDialogVisible = false
          // // 调用接口发送请求
          updateMenu(this.menuForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error('res.result')
            }
            // 重置表单元素的数据
            this.$refs['menuForm'].resetFields()
            // 刷新页面显示
            this.initList()
          })
        }
      })
    },
    // 显示编辑对话框
    editMenu(data) {
      this.isTrue = true
      this.dialogStatus = '编辑'
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
        this.menuForm.menuUrl = '/'
      } else if (data.isDir === '0') {
        this.isShow = true
        this.menuForm.menuUrl = data.menuUrl
      }
    },
    // 实现新增菜单
    createData(data) {
      // 避免重复点击提交
      this.isDisabled = true
      setTimeout(() => {
        this.isDisabled = false
      }, 500)
      this.$refs['menuForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          // 判断用户选择的是目录还是页面
          if (this.radio === '1') {
            // 判断用户选择的是同级菜单还是子菜单
            if (this.location === '0') {
              this.menuForm.parentId = this.menuId
            }
            createMenuDir(this.menuForm).then(res => {
              if (res.data.code === '0000') {
                this.$message({
                  message: '添加成功',
                  type: 'success'
                })
              } else {
                this.$message.error(res.data.result)
              }
              // 重置表单元素的数据
              this.$refs['menuForm'].resetFields()
              // 刷新页面显示
              this.initList()
            })
          } else if (this.radio === '2') {
            // 判断用户选择的是同级菜单还是子菜单
            if (this.location === '0') {
              this.menuForm.parentId = this.menuId
            }
            createMenu(this.menuForm).then(res => {
              if (res.data.code === '0000') {
                this.$message({
                  message: '添加成功',
                  type: 'success'
                })
              } else {
                this.$message.error(res.data.result)
              }
              // 重置表单元素的数据
              this.$refs['menuForm'].resetFields()
              // 刷新页面显示
              this.initList()
            })
          }
          // 将对话框隐藏
          this.menuDialogVisible = false
        }
      })
    },
    // 显示新增弹框
    addMenu(data) {
      this.radio = '1'
      this.location = '1'
      this.dialogStatus = '新增'
      this.menuDialogVisible = true
      this.menuForm.menuName = undefined
      this.menuId = data.id
      if (data.parentName) {
        this.menuForm.parentId = data.parentId
      } else {
        this.menuForm.parentId = '1'
      }
      if (data.isDir === '0') {
        // this.isShow = true
        this.visible = false
      } else if (data.isDir === '1') {
        // this.isShow = false
        this.visible = true
      }
      this.menuForm.menuUrl = '/'
      this.$nextTick(() => {
        this.$refs['menuForm'].clearValidate()
      })
    },
    // 初始化项目
    initList() {
      this.listLoading = true
      getMenuList().then(res => {
        if (res.data.code === '0000') {
          this.menuList = res.data.data
        } else {
          this.$message.error('获取数据失败')
        }
        this.listLoading = false
      })
    }
  }
}
</script>

<style lang="scss" >
.menuManagement{
  display: flex;
  // background-color: #fff;
 .menu-left{
   width: 30%;
    height: 100%;
  .el-tree{
    height: 100%;
  padding: 20px;
  overflow: auto;
  }
}
.menu-right{
  margin-left:20px;
  flex:1;
  padding :20px;
  .menu-content{
    display: flex;
    align-items: center;
  }
  .el-input--medium{
    width: 188px;
  }
}

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

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
      <div v-show="isShowInfo" class="menuInfo">
        <div class="menuInfo-title">下级菜单</div>
        <div class="menu-content">
          <span>{{ currentMenuName }}</span>
          <el-form ref="dataForm" :model="dataForm" :rules="rules" label-width="100px">
            <el-form-item v-for="(item,index) in menuData" :key="index" prop="subName">
              <el-input v-model="item.label"/><i style="margin-right:10px;" class="fa fa-long-arrow-up"/><i class="fa fa-long-arrow-down"/>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" >保存</el-button>
              <el-button >取消</el-button>
            </el-form-item>
        </el-form></div>
      </div>
    </div>
    <!-- 弹出的新增和编辑对话框 -->
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
  </div>
</template>

<script>
import {
  getMenuList, checkMenuName, createMenu, createMenuDir, updateMenu, deleteMenuById
} from '@/api/Permission-model/menuManagement'
export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/
      if (!reg.test(value)) {
        callback(new Error('请输入正确的菜单名称'))
      } else {
        if (this.oldMenuName !== this.menuForm.menuName) {
          checkMenuName({ menuName: this.menuForm.menuName, parentId: this.menuForm.parentId }).then(response => {
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
    return {
      isShowInfo: false,
      dataForm: {
        subName: undefined
      },
      isTrue: false,
      menuData: [],
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
        url: [{ required: true, message: '请填写url', trigger: 'blur' }]
      }
    }
  },
  watch: {
    // 如果 `menuForm.radio` 发生改变，这个函数就会运行
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
    handleNodeClick(data) {
      console.log(data)
      if (data.isDir === '1') {
        this.isShowInfo = true
        this.currentMenuName = data.label
        this.menuData = data.children
      }
    },
    // 删除部门功能实现
    deleteMenu(id) {
      this.$confirm(`此操作将永久删除这个部门及其子部门, 是否继续?`, '删除提示', {
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
    // 实现新增功能
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
        this.isShow = true
        this.visible = false
      } else if (data.isDir === '1') {
        this.isShow = false
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

<style lang="scss" scoped>
.menuManagement{
  display: flex;
  // background-color: #fff;
 .menu-left{
   width: 40%;
  .el-tree{
  padding: 20px;
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

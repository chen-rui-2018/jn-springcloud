<template>
  <div class="rolemanagement">
    <div class="filter-container">
      <!-- input搜索框 -->
      名称：
      <el-input v-model="listQuery.title" placeholder="请输入名称" style="width: 200px;" class="filter-item" @keyup.enter.native="searchListdata" />
      <!-- 第一个下拉菜单 -->
      状态：
      <el-select v-model="listQuery.status" placeholder="请选择状态" clearable class="filter-item">
        <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />
      </el-select>

      <!-- 搜索按钮 -->
      <el-button class="filter-item" type="primary" round>查询</el-button>
      <!-- 新增按钮 -->
      <el-button class="filter-item" round style="margin-left: 10px;" type="primary" @click="adddialogFormVisible=true">新增</el-button>
    </div>
    <!-- 表格 -->
    <el-table :data="userList" border fit highlight-current-row style="width: 100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="角色名称" align="center" prop="roleName"/>
      <el-table-column label="用户" align="center" prop="name" />
      <el-table-column label="权限" width="170" align="center" prop="describe"/>
      <el-table-column label="创建时间" width="120" align="center" prop="creationTime"/>
      <el-table-column label="状态" align="center" prop="roleStatus"/>
      <el-table-column label="操作" align="center" width="360" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="showEditDialog(scope.row)">编辑</el-button>
          <el-button type="primary" size="mini" @click="showManagementDialog(scope.row)">授权用户</el-button>
          <el-button type="primary" size="mini" @click="showGroupmanagementDialog(scope.row)">授权用户组</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteUser(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination :current-page="pagenum" :page-sizes="[1, 2, 3, 4]" :page-size="pagesize" :total="total" layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />

    <!-- 新增角色 -->
    <el-dialog :visible.sync="adddialogFormVisible" title="添加角色">
      <el-form ref="addform" :rules="rules" :model="addform" label-position="right" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="名称" prop="username">
          <el-input v-model="addform.username" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="addform.status" class="filter-item">
            <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="addUserSubmit('addform')">提交</el-button>
        <el-button @click="adddialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>
    <!-- 编辑角色 -->
    <el-dialog :visible.sync="editdialogFormVisible" title="编辑角色">
      <el-form ref="editform" :rules="rules" :model="editform" label-position="right" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="角色名称" prop="rolename">
          <el-input v-model="editform.rolename" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="editform.status" class="filter-item">
            <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="editUserSubmit('editform')">提交</el-button>
        <el-button @click="editdialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>
    <!-- 弹出的授权用户对话框 -->
    <el-dialog :visible.sync="managementdialogVisible" title="授权用户">
      <el-transfer
        v-model="value1"
        :data="managementdata"
        :titles="['用户名称', '用户名称']"
        filterable
        filter-placeholder="请输入用户名称" />
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="managementdialogVisible = false">确 定</el-button>
        <el-button @click="managementdialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>
    <!-- 弹出的授权用户组对话框 -->
    <el-dialog :visible.sync="groupManagementdialogVisible" title="授权用户组">
      <el-transfer
        v-model="value2"
        :data="groupManagementdata"
        :titles="['用户组名称', '用户组名称']"
        filterable
        filter-placeholder="请输入用户组名称" />
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="groupManagementdialogVisible = false">确 定</el-button>
        <el-button @click="groupManagementdialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>

export default {
  data() {
    return {
      listQuery: {
        title: '',
        status: ''
      },
      statusOptions: ['有效', '失效'],
      pagesize: 1,
      pagenum: 10,
      total: 0,
      value1: [],
      value2: [],
      userList: [],
      managementdata: [{ key: 1, label: '张三' }, { key: 2, label: '李四' }, { key: 3, label: '李2' }],
      groupManagementdata: [{ key: 1, label: '用户组1' }, { key: 2, label: '用户组2' }, { key: 3, label: '用户组3' }],
      adddialogFormVisible: false,
      editdialogFormVisible: false,
      managementdialogVisible: false,
      groupManagementdialogVisible: false,
      addform: {
        id: '',
        username: '',
        status: ''
      },
      editform: {
        id: '',
        rolename: '',
        status: ''
      },
      rules: {
        username: [{ required: true, message: '请输入姓名', trigger: 'blur' }]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    // 删除用户功能实现
    deleteUser(id) {
      this.$confirm(
        `此操作将永久删除id号为${id}的数据, 是否继续?`,
        '删除提示',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }
      )
        .then(() => {
          // deleteUserById(id).then(res => {
          //   if (res.meta.status === 200) {
          this.$message({
            message: '删除成功', //    res.meta.msg,
            type: 'success'
          })
          // this.initList()
          // } else {
          //   this.$message({
          //     message: res.meta.msg,
          //     type: 'success'
          //   })
          // }
          // })
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
    // 显示授权用户对话框
    showManagementDialog(row) {
      console.log(row)
      this.managementdialogVisible = true
      this.managementdata.forEach((val, index) => {
        if (this.managementdata[index].label === row.name) {
          console.log(index)
          this.value1.push(index)
        }
      })
    },
    // 显示授权用户组对话框
    showGroupmanagementDialog(row) {
      console.log(row)
      this.groupManagementdialogVisible = true
      this.groupManagementdata.forEach((val, index) => {
        if (this.groupManagementdata[index].label === row.groupname) {
          console.log(index)
          this.value2.push(index)
        }
      })
    },
    //  显示编辑角色对话框
    showEditDialog(row) {
      console.log(row)
      // 显示对话框
      this.editdialogFormVisible = true
      //   添加默认数据
      this.editform.rolename = row.rolename
      this.editform.status = row.status
    },
    editUserSubmit() {

    },
    // 项目初始化
    initList() {
      const list = [
        {
          name: '张三',
          roleName: 'zhansan',
          describe: '10000',
          creationTime: '2018/8/5 14:30',
          roleStatus: '生效'
        },
        {
          name: '李四',
          roleName: '李四',
          describe: '1235466d',
          creationTime: '2018/8/6 14:30',
          roleStatus: '生效'
        },
        {
          name: '测试1',
          roleName: 'ceshi',
          describe: '1235',
          creationTime: '2018/8/9 14:30',
          roleStatus: '失效'
        },
        {
          name: '张三',
          roleName: 'zhansan',
          describe: '123df',
          creationTime: '2018/8/5 14:30',
          roleStatus: '生效'
        }
      ]
      this.userList = list
    },
    // 分页功能
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`)
    }
  }
}
</script>

<style lang="scss" scoped>
.rolemanagement {
  padding: 20px;
  .fixed-width .el-button--mini {
    width: auto;
  }
}
</style>

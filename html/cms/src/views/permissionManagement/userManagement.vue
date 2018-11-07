<template>
  <div>
    <div class="filter-container">
      <el-form :inline="true" :model="formInline" >
        <el-form-item label="姓名" >
          <el-input v-model="listQuery.name" placeholder="请输入姓名" style="width: 150px;" class="filter-item" clearable />
        </el-form-item>
        <el-form-item label="状态">
          <el-select
            v-model="listQuery.userStatus"
            placeholder="请选择"
            clearable
            style="width: 90px"
            class="filter-item"
            @change="selecteUserStatus" >
            <el-option v-for="item in userStatusOptions" :key="item" :label="item" :value="item"/>
          </el-select>
        </el-form-item>
        <el-form-item label="部门">
          <el-select
            v-model="listQuery.department"
            placeholder="请选择"
            clearable
            style="width: 90px"
            class="filter-item"
            @change="selecteDepartment" >
            <el-option v-for="item in departmentOptions" :key="item" :label="item" :value="item"/>
          </el-select>
        </el-form-item>
        <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-circle-plus-outline" @click="handleCreate">新增用户</el-button>
      </el-form>
    </div>
    <el-table
      v-loading="listLoading"
      :key="tableKey"
      :data="userList"
      border
      fit
      max-height="500"
      highlight-current-row
      style="width: 100%;">
      <el-table-column label="序列" prop="id" align="center" width="65"/>
      <el-table-column label="姓名" prop="name" align="center" width="65"/>
      <el-table-column label="账号" prop="account" align="center" width="130"/>
      <el-table-column label="邮箱" prop="email" align="center" width="200"/>
      <el-table-column label="创建时间" prop="creation_time" align="center" width="200"/>
      <el-table-column label="部门" prop="department" align="center" width="65"/>
      <el-table-column label="岗位" prop="position" align="center" width="65"/>
      <el-table-column label="人员状态" prop="userStatus" align="center" width="65"/>
      <el-table-column
        fit
        label="操作"
        align="center"
        width="auto"
        min-width="400">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleSectorUpdate(scope.row)">部门岗位</el-button>
          <el-button type="primary" size="mini">角色</el-button>
          <el-button type="primary" size="mini">重置密码</el-button>
          <el-button type="primary" icon="el-icon-edit" size="mini" @click="handleUpdate(scope.row)"/>
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDelete(scope.row)"/>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <el-pagination
        v-show="total>0"
        :current-page="listQuery.page"
        :page-sizes="[10,20,30, 50]"
        :page-size="listQuery.limit"
        :total="total"
        background
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange" />
    </div>
    <!-- 新增弹窗 -->
    <el-dialog :visible.sync="dialogFormVisible" title="新增">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="60px" style="max-width:300px;margin-left:20px;">
        <el-form-item label="账号" prop="account" >
          <el-input
            v-model="temp.account"
            maxLength="20"
            clearable
          />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input
            v-model="temp.name"
            maxLength="20"
            clearable
          />
        </el-form-item>
        <el-form-item label="状态" prop="userStatus">
          <el-select v-model="temp.userStatus" class="filter-item" placeholder="请选择" >
            <el-option v-for="(item,index) in userStatusOptions" :key="index" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input
            v-model="temp.email"
            clearable
          />
        </el-form-item>
        <el-form-item label="手机" prop="phonenumber" >
          <el-input
            v-model.number="temp.phonenumber"
            :maxLength="11"
            minLength="11"
            clearable
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogStatus==='create'?createUserData():updateData()">确认</el-button>
      </div>
    </el-dialog>
    <!---->
    <!-- 部门岗位 -->
    <el-dialog :visible.sync="dialogSectorVisible" title="部门岗位" >
      <el-botton type="primary" size="mini">分配</el-botton>
      <el-form ref="dataForm" :rules="rules" :model="temp2" label-position="left" label-width="60px" style="max-width:300px;margin-left:20px;">
        <el-form-item label="账号" prop="account" >
          <el-input
            v-model="temp.account"
            maxLength="20"
            clearable
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogStatus==='create'?createUserData():updateData()">确认</el-button>
      </div>
    </el-dialog>
    <!---->
  </div>
</template>

<script>
import { userList, userCreate } from '@/api/promission'
import waves from '@/directive/waves' // 水波纹指令
import { parseTime } from '@/utils'

export default {
  name: 'UserManagement',
  directives: {
    waves
  },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'info',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    var checkAccount = (rule, value, callback) => {
      const reg = /^[a-zA-Z0-9_-]{4,16}$/
      if (!reg.test(value)) {
        callback(new Error('4到16位(字母，数字，下划线，减号)'))
      } else {
        callback()
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
      const reg = /^1[34578]\d{9}$/
      if (!reg.test(value)) {
        callback(new Error('请输入正确手机号码'))
      } else {
        callback()
      }
    }
    return {
      tableKey: 0,
      userList: null,
      total: null,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        importance: undefined,
        title: undefined,
        type: undefined,
        sort: '+id',
        userStatus: undefined,
        position: undefined,
        department: undefined
      },
      userStatusOptions: ['生效', '不生效'],
      departmentOptions: ['A部门', '销售部', '研发部', '市场部'],
      sortOptions: [
        { label: 'ID Ascending', key: '+id' },
        { label: 'ID Descending', key: '-id' }
      ],
      statusOptions: ['published', 'draft', 'deleted'],
      showReviewer: false,
      temp: {
        name: undefined,
        account: undefined,
        userStatus: undefined,
        email: undefined,
        phonenumber: undefined,
        id: undefined
      },
      dialogFormVisible: false,
      dialogStatus: '',
      dialogPvVisible: false,
      dialogSectorVisible: false,
      rules: {
        name: [
          { required: true, message: '用户名不能为空', trigger: 'blur' },
          { validator: checkName, trigger: 'blur' }
        ],
        account: [
          { required: true, message: '账号不能为空', trigger: 'blur' },
          { validator: checkAccount, trigger: 'blur' }
        ],
        userStatus: [
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
        phonenumber: [
          { required: true, message: '手机号不能为空', trigger: 'blur' },
          { validator: checkPhoneNumber, trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getUserList()
  },
  methods: {
    selecteUserStatus(value) {
      this.listQuery.userStatus = value
    },
    selecteDepartment(value) {
      this.listQuery.department = value
    },
    getUserList() {
      this.listLoading = true
      userList(this.listQuery).then(response => {
        this.userList = response.data.items
        this.total = response.data.total

        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
    },
    handleSectorUpdate(row) {
      this.dialogSectorVisible = true
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getUserList()
    },
    handleSizeChange(val) {
      this.listQuery.limit = val
      this.getUserList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.getUserList()
    },
    handleModifyStatus(row, status) {
      this.$message({
        message: '操作成功',
        type: 'success'
      })
      row.status = status
    },
    resetTemp() {
      this.temp = {
        id: undefined,
        importance: 1,
        remark: '',
        timestamp: new Date(),
        title: '',
        status: 'published',
        type: ''
      }
    },
    handleCreate() {
      this.resetTemp()
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    createUserData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          this.temp.id = parseInt(Math.random() * 100) + 1024 // mock a id
          userCreate(this.temp).then(() => {
            this.userList.unshift(this.temp)
            this.dialogFormVisible = false
            this.$notify({
              title: '成功',
              message: '新增用户成功',
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    handleUpdate(row) {
      this.temp = Object.assign({}, row) // copy obj
      this.temp.timestamp = new Date(this.temp.timestamp)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    updateData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          const tempData = Object.assign({}, this.temp)
          tempData.timestamp = +new Date(tempData.timestamp) // change Thu Nov 30 2017 16:41:05 GMT+0800 (CST) to 1512031311464
          userCreate(tempData).then(() => {
            for (const v of this.userList) {
              if (v.id === this.temp.id) {
                const index = this.userList.indexOf(v)
                this.userList.splice(index, 1, this.temp)
                break
              }
            }
            this.dialogFormVisible = false
            this.$notify({
              title: '成功',
              message: '更新成功',
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    handleDelete(row) {
      this.$notify({
        title: '成功',
        message: '删除成功',
        type: 'success',
        duration: 2000
      })
      const index = this.userList.indexOf(row)
      this.userList.splice(index, 1)
    },
    formatJson(filterVal, jsonData) {
      return jsonData.map(v =>
        filterVal.map(j => {
          if (j === 'timestamp') {
            return parseTime(v[j])
          } else {
            return v[j]
          }
        })
      )
    }
  }
}
</script>
<style lang="scss" >
  .el-dialog {
    width:90%;
    max-width:400px;
  }
  .el-dialog__body{padding-top:10px;padding-bottom:0;}
</style>


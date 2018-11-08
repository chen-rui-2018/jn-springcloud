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
      <el-table-column label="序列" prop="id" align="center" width="120"/>
      <el-table-column label="姓名" prop="name" align="center" width="65"/>
      <el-table-column label="账号" prop="account" align="center" width="130"/>
      <el-table-column label="邮箱" prop="email" align="center" width="200"/>
      <el-table-column label="创建时间" prop="creationTime" align="center" width="200"/>
      <el-table-column label="部门" prop="department" align="center" width="65"/>
      <el-table-column label="岗位" prop="position" align="center" width="65"/>
      <el-table-column label="人员状态" prop="status" align="center" width="65"/>
      <el-table-column
        fit
        label="操作"
        align="center"
        width="auto"
        min-width="400">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleSectorUpdate(scope.row)">部门岗位</el-button>
          <el-button type="primary" size="mini" @click="handleRoleUpdate(scope.row)">角色</el-button>
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
    <!-- S 新增弹窗 -->
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
    <!-- E 新增弹窗 -->
    <!-- S 部门岗位 -->
    <el-dialog
      :visible.sync="dialogSectorVisible"
      title="部门岗位"
      class="sector-dialog">
      <el-table
        :data="userPositionData"
        border
        fit
        style="width: 100%">
        <el-table-column
          label="部门"
          align="center"
          width="280">
          <template slot-scope="scope">
            <el-cascader
              v-model="userPositionData[scope.$index].department"
              :options="departmentList"
              change-on-select
              style="width:100%;"
            />
          </template>
        </el-table-column>
        <el-table-column
          label="岗位"
          align="center"
          width="180">
          <template scope="scope">
            <el-select v-model="userPositionData[scope.$index].position" placeholder="请选择">
              <el-option
                v-for="(item,index) in positionOptions"
                :key="index"
                :label="item"
                :value="item"
              />
            </el-select>
          </template>
        </el-table-column>
        <el-table-column
          label="默认"
          align="center"
          width="180">
          <template slot-scope="scope">
            <el-button v-if="scope.row.status==='default'" type="success" size="small" >默认岗位</el-button>
            <el-button v-else-if="scope.row.status!=='default' && scope.row.department && scope.row.position" size="small" @click="setDefaultPosition(scope.$index, scope.row)">设为默认岗位</el-button>
          </template>
        </el-table-column>
        <el-table-column
          label="操作"
          align="center">
          <template slot-scope="scope">
            <el-button
              v-if="scope.row.department && scope.row.position"
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogStatus==='create'?createUserData():updateData()">确认</el-button>
      </div>
    </el-dialog>
    <!-- E 部门岗位 -->
    <!-- S 角色岗位 -->
    <el-dialog
      :visible.sync="dialogRoleVisible"
      title="角色"
      class="role-dialog">
      <el-transfer
        :filter-method="filterMethod"
        :titles="[ '角色列表', '已选中角色' ]"
        :data="data2"
        v-model="value2"
        filterable
        filter-placeholder="请输入角色拼音"
      />
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogRoleVisible = false">取消</el-button>
        <el-button type="primary" @click="test">确认</el-button>
      </div>
    </el-dialog>
    <!-- E 角色岗位 -->
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
    const generateData2 = _ => {
      const data = []
      const cities = ['角色一', '角色二', '角色三', '角色四', '角色五', '角色六', '角色七']
      const pinyin = ['juese1', 'juese2', 'juese3', 'juese4', 'juese5', 'juese6', 'juese7']
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
      positionOptions: ['经理', '美工', '开发', '推广', '策划'],
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
      dialogSectorVisible: false,
      dialogRoleVisible: false,
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
      },
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      userPositionData: [
        {
          department: ['test2', '22', 'yizhi'],
          position: '美工',
          status: 'default'
        }, {
          department: '',
          position: '',
          status: undefined
        }, {
          department: '',
          position: '',
          status: undefined
        }
      ],
      departmentList: [
        {
          value: 'zhinan',
          label: '指南',
          children: [{
            value: 'shejiyuanze',
            label: '设计原则',
            children: [{
              value: 'yizhi',
              label: '一致'
            }, {
              value: 'fankui',
              label: '反馈'
            }, {
              value: 'xiaolv',
              label: '效率'
            }, {
              value: 'kekong',
              label: '可控'
            }]
          }]
        },
        {
          value: 'test2',
          label: '一级部门',
          children: [{
            value: '22',
            label: '二级部门',
            children: [{
              value: 'yizhi',
              label: '三级部门'
            }, {
              value: 'fankui',
              label: '三级部门'
            }]
          }]
        }
      ],
      data2: generateData2(),
      value2: [],
      filterMethod(query, item) {
        return item.pinyin.indexOf(query) > -1
      }
    }
  },
  watch: {
    userPositionData: {
      handler: function() {
        const userPosition = this.userPositionData.filter(function(item) {
          return item.department && item.position
        })
        if (this.userPositionData.length < userPosition.length + 2) {
          this.userPositionData.push({
            department: '',
            position: '',
            status: undefined
          })
        }
      },
      deep: true
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
      userList({ page: 2, rows: 2 }).then(response => {
        this.userList = response.data.data.rows
        this.total = response.data.data.total
        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false
        }, 1e3)
      })
    },
    handleSectorUpdate(row) {
      this.dialogSectorVisible = true
    },
    handleRoleUpdate(row) {
      this.dialogRoleVisible = true
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
    },
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
    }
  }
}
</script>
<style lang="scss" >
  .el-dialog {
    width:90%;max-width:400px;
  }
  .sector-dialog{
    .el-dialog{max-width: 800px;}
    .item-box{padding:5px;border:1px solid #d7d7d7;}
  }
  .role-dialog{
     .el-dialog{max-width:540px;}
     .el-transfer{display:inline-block;white-space: nowrap;}
  }
  .el-dialog__body{padding-top:10px;padding-bottom:0;}
  .el-form-item{margin-bottom:0;}
  .filter-container{padding-bottom:0;}
</style>


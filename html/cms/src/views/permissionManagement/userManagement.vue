<template>
  <div class="flex-box-cloumn">
    <div class="filter-container">
      <el-form
        :inline="true"
        :model="listQuery"
        class="filter-bar" >
        <el-form-item label="姓名" >
          <el-input
            v-model="listQuery.name"
            placeholder="请输入姓名"
            style="width: 150px;"
            class="filter-item"
            maxlength="16"
            clearable />
        </el-form-item>
        <el-form-item label="状态">
          <el-select
            v-model="listQuery.status"
            placeholder="请选择"
            clearable
            style="width: 90px"
            class="filter-item"
            @change="selecteUserStatus" >
            <el-option v-for="(item,index) in userStatusOptions" :key="item" :label="item" :value="index"/>
          </el-select>
        </el-form-item>
        <el-form-item label="部门">
          <el-select
            v-model="listQuery.departmentIds"
            multiple
            collapse-tags
            clearable
            placeholder="请选择"
            class="filter-item"
            @change="selecteDepartment" >
            <el-option v-for="item in departmentOptions" :key="item" :label="item.departmentName" :value="item.id"/>
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
      highlight-current-row
      style="width: 100%;">
      <el-table-column label="序列" type="index" align="center" width="50"/>
      <el-table-column label="姓名" prop="name" align="left" width="100"/>
      <el-table-column label="账号" prop="account" align="left" width="130"/>
      <el-table-column label="邮箱" prop="email" align="left" width="200"/>
      <el-table-column label="手机" prop="phone" align="center" width="120"/>
      <el-table-column
        label="创建时间"
        prop="createTime"
        align="center"
        width="150">
        <template slot-scope="scope">
          {{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="部门" prop="departmentName" align="center" width="65"/>
      <el-table-column label="岗位" prop="postName" align="center" width="65"/>
      <el-table-column label="人员状态" prop="status" align="center" width="90">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'" >{{ scope.row.status | statusFilter }}</span>
        </template>
      </el-table-column>
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
        :page-size="listQuery.rows"
        :total="total"
        background
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange" />
    </div>
    <!-- S 新增弹窗 -->
    <el-dialog :visible.sync="dialogFormVisible" :title="addDialogTitle">
      <el-form
        ref="dataForm"
        :rules="addUserDialogRules"
        :model="temp"
        label-position="left"
        label-width="60px"
        style="max-width:300px;margin-left:20px;">
        <el-form-item label="账号" prop="account" >
          <el-input
            v-model="temp.account"
            maxlength="20"
            clearable
          />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input
            v-model="temp.name"
            maxlength="20"
            clearable
          />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="temp.status" class="filter-item" placeholder="请选择" >
            <el-option v-for="(item,index) in userStatusOptions" :key="index" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input
            v-model="temp.email"
            clearable
          />
        </el-form-item>
        <el-form-item label="手机" prop="phone" >
          <el-input
            v-model="temp.phone"
            maxlength="11"
            minlenght="11"
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
            <el-button
              v-if="scope.row.status==='default'"
              type="success"
              size="small" >默认岗位</el-button>
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
              @click="handleUserSectorDelete(scope.$index, scope.row)">删除</el-button>
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
        <el-button type="primary" >确认</el-button>
      </div>
    </el-dialog>
    <!-- E 角色岗位 -->
  </div>
</template>

<script>
import { userList, userCreate, findDepartmentAllByLevel, deleteSysUser, checkUserName } from '@/api/promission'
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
        checkUserName(this.temp.account).then(response => {
          const result = response.data.data
          if (result === 'success') {
            callback()
          } else {
            callback(new Error('用户已经使用'))
          }
        })
        // userCreate(this.temp).then( response => {
        //   let result = response.data.result
        //   console.log(response)
        //   if (result!=="OK") {
        //     // 输入格式验证不通过
        //     result = JSON.parse(result.slice(0,-1))
        //     callback(new Error(result.account))
        //   } else {

        //     if (!response.data.data) {
        //       // 用户已存在提示
        //       callback(new Error(response.data.data))
        //     } else {
        //       callback()
        //     }
        //   }
        // })
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
      addDialogTitle: '新增',
      tableKey: 0,
      userList: null,
      total: null,
      listLoading: true,
      listQuery: {
        page: 1,
        rows: 10,
        sort: '+id',
        status: undefined,
        position: undefined,
        departmentName: undefined,
        departmentIds: undefined
      },
      userStatusOptions: ['未生效', '生效'],
      departmentOptions: [],
      positionOptions: ['经理', '美工', '开发', '推广', '策划'],
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
    this.getSysDepartmentAll()
  },
  mounted() {
    // console.log(this.$refs.userList.offsetHeight)
  },
  methods: {
    selecteUserStatus(value) {
      this.listQuery.userStatus = value
    },
    selecteDepartment(value) {
      this.listQuery.department = value
    },
    getSysDepartmentAll() {
      findDepartmentAllByLevel().then(response => {
        // const data = response.data.data
        // data = JSON.stringify(data)
      })
      // findSysDepartmentAll().then(response => {
      //   console.log(response)
      //   const data = response.data.data
      //   this.departmentOptions = data
      // })
    },
    getUserList() {
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
      this.listQuery.rows = val
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
    createUserData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          userCreate(this.temp).then(response => {
            // this.userList.unshift(this.temp)
            this.dialogFormVisible = false
            this.$notify({
              title: '成功',
              message: '新增用户成功',
              type: 'success',
              duration: 2000
            })
            this.getUserList()
          })
        }
      })
    },
    handleUpdate(row) {
      this.temp = Object.assign({}, row) // copy obj
      this.dialogStatus = 'update'
      this.addDialogTitle = '编辑'
      this.temp.status = this.userStatusOptions[this.temp.status]
      this.dialogFormVisible = true

      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    updateData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          const tempData = Object.assign({}, this.temp)
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
      deleteSysUser({ userIds: [row.id] }).then((response) => {
        this.$notify({
          title: '成功',
          message: '删除成功',
          type: 'success',
          duration: 2000
        })
        const index = this.userList.indexOf(row)
        this.userList.splice(index, 1)
      })
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
<style lang="scss">
  .flex-box-column{
    display:flex;flex-direction: column;
  }
  .el-dialog {
    width:90%;max-width:400px;
  }
 .pagination-container{margin-top:10px;}
  .sector-dialog{
    .el-dialog{max-width: 800px;}
    .item-box{padding:5px;border:1px solid #d7d7d7;}
  }
  .role-dialog{
     .el-dialog{max-width:540px;}
     .el-transfer{display:inline-block;white-space: nowrap;}
  }
  .el-dialog__body{padding-top:10px;padding-bottom:0;}
  .filter-bar .el-form-item{margin-bottom:0; }
  .filter-container{padding-bottom:0;}
</style>


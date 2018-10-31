<template>
  <div class="app-container">
    <div class="filter-container">
      <!-- input搜索框 -->
      名称：
      <el-input v-model="listQuery.title" placeholder="请输入名称" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />
      <!-- 第一个下拉菜单 -->
      状态：
      <el-select v-model="listQuery.importance" placeholder="请选择" clearable style="width: 90px" class="filter-item">
        <el-option v-for="item in importanceOptions" :key="item" :label="item" :value="item" />
      </el-select>
      <!-- 第二个下拉菜单 -->
      部门：
      <el-select v-model="listQuery.type" placeholder="请选择" clearable class="filter-item" style="width: 130px">
        <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name+'('+item.key+')'" :value="item.key" />
      </el-select>
      <!-- 搜索按钮 -->
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">{{ $t('table.search') }}</el-button>
      <!-- 新增按钮 -->
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
    </div>

    <!-- 表格 -->
    <el-table v-loading="listLoading" :key="tableKey" :data="list" border fit highlight-current-row style="width: 100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column :label="$t('table.id')" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <!-- 表格第二列  姓名 -->
      <el-table-column label="姓名" align="center">
        <template slot-scope="scope">
          <span class="link-type">{{ scope.row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column label="账号" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.username }}</span>
        </template>
      </el-table-column>
      <el-table-column label="邮箱" width="150" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.email }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" width="120" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.timestamp }}</span>
        </template>
      </el-table-column>
      <el-table-column label="部门" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.bumen }}</span>
        </template>
      </el-table-column>

      <el-table-column label="岗位" align="center" >
        <template slot-scope="scope">
          <span>{{ scope.row.gangwei }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" >
        <template slot-scope="scope">
          <span>{{ scope.row.status }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('table.actions')" align="center" width="300" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">{{ $t('table.edit') }}</el-button>
          <el-button type="primary" size="mini" @click="handleBumen(scope.row)">部门岗位</el-button>
          <el-button type="primary" size="mini" @click="handleRole(scope.row)">角色</el-button>
          <!-- 删除按钮 -->
          <el-button v-if="scope.row.status!='deleted'" size="mini" type="danger" @click="handleModifyStatus(scope.row,'deleted')">{{ $t('table.delete') }}
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="pagination-container">
      <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10,20,30, 50]" :page-size="listQuery.limit" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <!-- 弹出的添加用户对话框 -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="addform" :rules="rules" :model="addform" label-position="right" label-width="70px" style="width: 400px; margin-left:50px;">
        <el-form-item label="账号" prop="username">
          <el-input v-model="addform.username" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="addform.name" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="addform.email" />
        </el-form-item>
        <el-form-item label="手机" prop="mobile">
          <el-input v-model="addform.mobile" />
        </el-form-item>
        <el-form-item label="部门" prop="bumen">
          <el-input v-model="addform.bumen" />
        </el-form-item>
        <el-form-item label="岗位" prop="gangwei">
          <el-input v-model="addform.gangwei" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="addform.status" class="filter-item">
            <el-option v-for="item in importanceOptions" :key="item" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="角色" prop="juese">
          <el-input v-model="addform.juese" />
        </el-form-item>
        <el-form-item label="用户组" prop="yonghuzu">
          <el-input v-model="addform.yonghuzu" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="addUserSubmit('addform')">确定</el-button>
      </div>
    </el-dialog>

    <!-- 弹出的角色对话框 -->
    <el-dialog
      :visible.sync="RoledialogVisible"
      title="角色"
    >
      <el-transfer
        :render-content="renderFunc"
        :titles="['角色名称', '角色名称']"
        :button-texts="['到左边', '到右边']"
        :format="{
          noChecked: '${total}',
          hasChecked: '${checked}/${total}'
        }"
        :data="roledata"
        filterable
        @change="handleroleChange"/>
      <span slot="footer" class="dialog-footer">
        <el-button @click="RoledialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="RoledialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog :visible.sync="dialogPvVisible" title="Reading statistics">
      <el-table :data="pvData" border fit highlight-current-row style="width: 100%">
        <el-table-column prop="key" label="Channel" />
        <el-table-column prop="pv" label="Pv" />
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogPvVisible = false">{{ $t('table.confirm') }}</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
import {
  // fetchList,
  // fetchPv,
  createArticle,
  updateArticle
} from '@/api/article'
import waves from '@/directive/waves' // 水波纹指令
import { parseTime } from '@/utils'

const calendarTypeOptions = [
  { key: 'CN', display_name: 'China' },
  { key: 'US', display_name: 'USA' },
  { key: 'JP', display_name: 'Japan' },
  { key: 'EU', display_name: 'Eurozone' }
]

// arr to obj ,such as { CN : "China", US : "USA" }
const calendarTypeKeyValue = calendarTypeOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'ComplexTable',
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
    },
    typeFilter(type) {
      return calendarTypeKeyValue[type]
    }
  },
  data() {
    const generateData = _ => {
      const data = []
      for (let i = 1; i <= 15; i++) {
        data.push({
          key: i,
          label: `备选项 ${i}`,
          disabled: i % 4 === 0
        })
      }
      return data
    }
    return {
      roledata: generateData(),
      renderFunc(h, option) {
        return <span>{ option.key } - { option.label }</span>
      },
      tableKey: 0,
      list: null,
      total: null,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        importance: undefined,
        title: undefined,
        type: undefined,
        sort: '+id'
      },
      importanceOptions: ['有效', '失效'],
      calendarTypeOptions,
      //   sortOptions: [
      //     { label: 'ID Ascending', key: '+id' },
      //     { label: 'ID Descending', key: '-id' }
      //   ],
      statusOptions: ['published', 'draft', 'deleted'],
      showReviewer: false,
      addform: {
        id: undefined,
        bumen: '',
        gangwei: '',
        name: '',
        email: '',
        username: '',
        mobile: '',
        status: '',
        juese: '',
        yonghuzu: ''
      },
      dialogFormVisible: false,
      RoledialogVisible: false,
      dialogStatus: '',
      textMap: {
        update: '编辑用户',
        create: '添加用户'
      },
      dialogPvVisible: false,
      pvData: [],
      rules: {
        name: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        mobile: [
          { required: true, message: '请输入手机号', trigger: 'blur' }
        ],
        email: [{ required: true, message: '请输入邮箱地址', trigger: 'blur' },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur,change' }]
      },
      downloadLoading: false
    }
  },
  created() {
    this.getList()
  },
  methods: {
    // 弹出角色对话框
    handleroleChange(value, direction, movedKeys) {
      console.log(value, direction, movedKeys)
    },
    handleRole() {
      this.RoledialogVisible = true
    },
    getList() {
      this.listLoading = false
      // fetchList(this.listQuery).then(response => {
      //   this.list = response.data.items
      //   this.total = response.data.total
      //   console.log(this.list)
      //   // Just to simulate the time of the request
      //   setTimeout(() => {
      //     this.listLoading = false
      //   }, 1.5 * 1000)
      const list = [
        {
          id: '5',
          name: '张三',
          username: 'zhansan',
          email: '123dfdf@163.com',
          timestamp: '2018/8/5 14:30',
          bumen: '销售部',
          gangwei: '经理岗',
          status: '生效'
        },
        {
          id: '2',
          name: '李四',
          username: '李四',
          email: '1235466dfdf@163.com',
          timestamp: '2018/8/6 14:30',
          bumen: 'A部门',
          gangwei: '研发岗',
          status: '生效'
        },
        {
          id: '3',
          name: '测试1',
          username: 'ceshi',
          email: '12356dfdf@163.com',
          timestamp: '2018/8/9 14:30',
          bumen: '销售部',
          gangwei: '经理岗',
          status: '失效'
        },
        {
          id: '4',
          name: '张三',
          username: 'zhansan',
          email: '123dfdf@163.com',
          timestamp: '2018/8/5 14:30',
          bumen: '销售部',
          gangwei: '经理岗',
          status: '生效'
        }
      ]
      this.list = list
      // })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleSizeChange(val) {
      this.listQuery.limit = val
      this.getList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.getList()
    },
    handleModifyStatus(row, status) {
      this.$message({
        message: '操作成功',
        type: 'success'
      })
      row.status = status
    },
    resetAddform() {
      this.addform = {
        id: undefined,
        name: '',
        username: '',
        bumen: '',
        gangwei: '',
        mobile: '',
        email: '',
        zhangtai: '',
        juese: '',
        yonghuzu: ''
      }
    },
    // 添加用户
    addUserSubmit(addform) {
      console.log(this.$refs[addform])
      this.$refs[addform].validate(valid => {
        if (valid) {
          console.log(this.$refs[addform])
          console.log(addform)

          // 将对话框隐藏
          this.dialogFormVisible = false
          // 重置表单元素的数据
          this.$refs[addform].resetFields()
        } else {
          this.$message({
            message: '输入数据不合法',
            type: 'error'
          })
        }
      })
    },
    handleCreate() {
      this.resetAddform()
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['addform'].clearValidate()
      })
    },
    createData() {
      this.$refs['addform'].validate(valid => {
        if (valid) {
          createArticle(this.addform).then(() => {
            this.list.unshift(this.addform)
            this.dialogFormVisible = false
            this.$notify({
              title: '成功',
              message: '创建成功',
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    handleUpdate(row) {
      console.log(row)
      console.log(Object)

      this.addform = Object.assign({}, row) // copy obj
      this.addform.timestamp = new Date(this.temp.timestamp)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['addForm'].clearValidate()
      })
    },
    updateData() {
      this.$refs['addform'].validate(valid => {
        if (valid) {
          const tempData = Object.assign({}, this.addform)
          tempData.timestamp = +new Date(tempData.timestamp) // change Thu Nov 30 2017 16:41:05 GMT+0800 (CST) to 1512031311464
          updateArticle(tempData).then(() => {
            for (const v of this.list) {
              if (v.id === this.temp.id) {
                const index = this.list.indexOf(v)
                this.list.splice(index, 1, this.temp)
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
      const index = this.list.indexOf(row)
      this.list.splice(index, 1)
    },
    // handleFetchPv(pv) {
    //   fetchPv(pv).then(response => {
    //     this.pvData = response.data.pvData
    //     this.dialogPvVisible = true
    //   })
    // },
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

<style lang="scss" scoped>
.filter-container {
  color: #0a2b3a;

  .filter-item {
    margin-right: 30px;
    vertical-align: inherit;
  }
}
</style>

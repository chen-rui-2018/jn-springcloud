<template>
  <div class="management">
    <div class="filter-container">
      <el-form :inline="true" :model="formInline" >
        <el-form-item label="姓名" >
          <el-input v-model="listQuery.name" placeholder="请输入姓名" style="width: 150px;" class="filter-item" clearable />
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.status" placeholder="请选择" style="width: 150px;" clearable class="filter-item" @change="selecteUserStatus">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="部门" >
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

    <!-- 表格 -->
    <el-table v-loading="listLoading" :data="userList" border fit highlight-current-row style="width: 100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="姓名" align="center" prop="name"/>
      <el-table-column label="账号" align="center" prop="account"/>
      <el-table-column label="邮箱" width="170" align="center" prop="email"/>
      <el-table-column label="创建时间" width="120" align="center" prop="creationTime" />
      <el-table-column label="部门" align="center" prop="department"/>
      <el-table-column label="岗位" align="center" prop="position"/>
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" width="360" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="showBumenDialog(scope.row)">部门岗位</el-button>
          <el-button type="primary" size="mini" @click="showRoleDialog(scope.row)">角色</el-button>
          <el-button type="primary" size="mini" @click="showrestDialog(scope.row)">重置密码</el-button>
          <el-button type="primary" size="mini" icon="el-icon-edit" @click="showEditDialog(scope.row)"/>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" icon="el-icon-delete" @click="deleteUser(scope.row.id)"/>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination :current-page="page" :page-sizes="[1, 2, 3, 4]" :page-size="rows" :total="total" layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    <!-- 弹出的添加用户对话框 -->
    <el-dialog :visible.sync="adddialogFormVisible" title="添加用户">
      <el-form ref="addform" :rules="rules" :model="addform" label-position="right" label-width="70px" style="width: 400px; margin-left:50px;">
        <el-form-item label="账号" prop="username">
          <el-input v-model.trim="addform.username" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model.trim="addform.name" />
        </el-form-item>
        <el-form-item
          label="邮箱"
          prop="email">
          <el-input v-model="addform.email" />
        </el-form-item>
        <el-form-item label="手机" prop="mobile">
          <el-input v-model.trim="addform.mobile" />
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

    <!-- 编辑用户对话框 -->
    <el-dialog :visible.sync="editdialogFormVisible" title="编辑用户">
      <el-form ref="editform" :rules="rules" :model="editform" label-position="right" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="账号" prop="username">
          <el-input v-model="editform.username" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="editform.email" />
        </el-form-item>
        <el-form-item label="手机" prop="mobile">
          <el-input v-model="editform.mobile" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="editform.status" class="filter-item">
            <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="editUserSubmit('editform')">提交</el-button>
          <el-button @click="editdialogFormVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 部门岗位对话框 -->
    <el-dialog :visible.sync="bumendialogFormVisible" title="部门、岗位">
      <el-button type="primary" size="mini">分配</el-button>
      <el-button size="mini" type="danger" @click="deleteUser(scope.row.id)">删除
      </el-button>
      <el-table ref="multipleTable" :data="tableData3" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="部门" width="210" align="center" prop="bumen">
          <template slot-scope="scope">
            <el-cascader :options="options" v-model="selectedOptions" placeholder="请选择部门" filterable />
          </template>
        </el-table-column>
        <el-table-column label="岗位" width="140" align="center" prop="gangwei">
          <template slot-scope="scope">
            <el-select v-model="scope.row.name" filterable placeholder="请选择岗位">
              <el-option v-for="item in gangweioptions" :key="item.value" :label="item.label" :value="item.value" />
            </el-select>
          </template>
        </el-table-column>
        <el-table-column prop="address" label="默认" align="center">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" round>设置为默认</el-button>
          </template>
        </el-table-column>

      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button @click="bumendialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="bumendialogFormVisible = false">确 定</el-button>
    </span></el-dialog>
    <!-- 弹出重置密码对话框 -->
    <el-dialog :visible.sync="restdialogVisible" title="重置密码" width="30%">
      <el-form ref="ruleForm2" :model="ruleForm2" :rules="rules2" status-icon label-width="100px" class="demo-ruleForm">
        <el-form-item label="密码" prop="pass">
          <el-input v-model.trim="ruleForm2.pass" type="password" auto-complete="off" />
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
          <el-input v-model.trim="ruleForm2.checkPass" type="password" auto-complete="off" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="Restsubmit('ruleForm2')">提交</el-button>
          <el-button @click="restdialogVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 弹出的角色对话框 -->
    <el-dialog :visible.sync="roledialogVisible" title="角色">
      <el-transfer v-model="value1" :data="roledata" :titles="['角色名称', '角色名称']" />
      <span slot="footer" class="dialog-footer">
        <el-button @click="roledialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="roledialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>

</template>

<script>
import { userList } from '@/api/promission'
export default {
  data() {
    // 密码验证
    const validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.ruleForm2.checkPass !== '') {
          this.$refs.ruleForm2.validateField('checkPass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.ruleForm2.pass) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      listLoading: false,
      selectedOptions: [],
      ruleForm2: { pass: '', checkPass: '' },
      roledata: [{ key: 0, label: '管理员' }, { key: 1, label: '经理' }, { key: 2, label: '报表角色' }, { key: 3, label: '超级管理员' }],
      value1: [0],
      page: 1,
      total: 0,
      rows: 1,
      userList: [],
      options: [
        {
          value: 'zhinan',
          label: '指南',
          children: [
            {
              value: 'shejiyuanze',
              label: '设计原则',
              children: [
                {
                  value: 'yizhi',
                  label: '一致'
                },
                {
                  value: 'fankui',
                  label: '反馈'
                },
                {
                  value: 'xiaolv',
                  label: '效率'
                },
                {
                  value: 'kekong',
                  label: '可控'
                }
              ]
            },
            {
              value: 'daohang',
              label: '导航',
              children: [
                {
                  value: 'cexiangdaohang',
                  label: '侧向导航'
                },
                {
                  value: 'dingbudaohang',
                  label: '顶部导航'
                }
              ]
            }
          ]
        },
        {
          value: 'zujian',
          label: '组件',
          children: [
            {
              value: 'basic',
              label: 'Basic',
              children: [
                {
                  value: 'layout',
                  label: 'Layout 布局'
                },
                {
                  value: 'color',
                  label: 'Color 色彩'
                },
                {
                  value: 'typography',
                  label: 'Typography 字体'
                },
                {
                  value: 'icon',
                  label: 'Icon 图标'
                },
                {
                  value: 'button',
                  label: 'Button 按钮'
                }
              ]
            },
            {
              value: 'form',
              label: 'Form',
              children: [
                {
                  value: 'radio',
                  label: 'Radio 单选框'
                },
                {
                  value: 'checkbox',
                  label: 'Checkbox 多选框'
                },
                {
                  value: 'input',
                  label: 'Input 输入框'
                },
                {
                  value: 'input-number',
                  label: 'InputNumber 计数器'
                },
                {
                  value: 'select',
                  label: 'Select 选择器'
                },
                {
                  value: 'cascader',
                  label: 'Cascader 级联选择器'
                },
                {
                  value: 'switch',
                  label: 'Switch 开关'
                },
                {
                  value: 'slider',
                  label: 'Slider 滑块'
                },
                {
                  value: 'time-picker',
                  label: 'TimePicker 时间选择器'
                },
                {
                  value: 'date-picker',
                  label: 'DatePicker 日期选择器'
                },
                {
                  value: 'datetime-picker',
                  label: 'DateTimePicker 日期时间选择器'
                },
                {
                  value: 'upload',
                  label: 'Upload 上传'
                },
                {
                  value: 'rate',
                  label: 'Rate 评分'
                },
                {
                  value: 'form',
                  label: 'Form 表单'
                }
              ]
            },
            {
              value: 'data',
              label: 'Data',
              children: [
                {
                  value: 'table',
                  label: 'Table 表格'
                },
                {
                  value: 'tag',
                  label: 'Tag 标签'
                },
                {
                  value: 'progress',
                  label: 'Progress 进度条'
                },
                {
                  value: 'tree',
                  label: 'Tree 树形控件'
                },
                {
                  value: 'pagination',
                  label: 'Pagination 分页'
                },
                {
                  value: 'badge',
                  label: 'Badge 标记'
                }
              ]
            },
            {
              value: 'notice',
              label: 'Notice',
              children: [
                {
                  value: 'alert',
                  label: 'Alert 警告'
                },
                {
                  value: 'loading',
                  label: 'Loading 加载'
                },
                {
                  value: 'message',
                  label: 'Message 消息提示'
                },
                {
                  value: 'message-box',
                  label: 'MessageBox 弹框'
                },
                {
                  value: 'notification',
                  label: 'Notification 通知'
                }
              ]
            },
            {
              value: 'navigation',
              label: 'Navigation',
              children: [
                {
                  value: 'menu',
                  label: 'NavMenu 导航菜单'
                },
                {
                  value: 'tabs',
                  label: 'Tabs 标签页'
                },
                {
                  value: 'breadcrumb',
                  label: 'Breadcrumb 面包屑'
                },
                {
                  value: 'dropdown',
                  label: 'Dropdown 下拉菜单'
                },
                {
                  value: 'steps',
                  label: 'Steps 步骤条'
                }
              ]
            },
            {
              value: 'others',
              label: 'Others',
              children: [
                {
                  value: 'dialog',
                  label: 'Dialog 对话框'
                },
                {
                  value: 'tooltip',
                  label: 'Tooltip 文字提示'
                },
                {
                  value: 'popover',
                  label: 'Popover 弹出框'
                },
                {
                  value: 'card',
                  label: 'Card 卡片'
                },
                {
                  value: 'carousel',
                  label: 'Carousel 走马灯'
                },
                {
                  value: 'collapse',
                  label: 'Collapse 折叠面板'
                }
              ]
            }
          ]
        },
        {
          value: 'ziyuan',
          label: '资源',
          children: [
            {
              value: 'axure',
              label: 'Axure Components'
            },
            {
              value: 'sketch',
              label: 'Sketch Templates'
            },
            {
              value: 'jiaohu',
              label: '组件交互文档'
            }
          ]
        }
      ],
      gangweioptions: [
        {
          value: '选项1',
          label: '经理'
        },
        {
          value: '选项2',
          label: '工程师'
        },
        {
          value: '选项3',
          label: '蚵仔煎'
        },
        {
          value: '选项4',
          label: '龙须面'
        },
        {
          value: '选项5',
          label: '北京烤鸭'
        }
      ],
      tableData3: [
        {
          bumen: '',
          gangwei: ''
        }
      ],
      multipleSelection: [],
      listQuery: {
        name: '',
        status: '',
        department: ''
      },
      adddialogFormVisible: false,
      editdialogFormVisible: false,
      bumendialogFormVisible: false,
      roledialogVisible: false,
      restdialogVisible: false,
      statusOptions: [
        { value: '1', label: '有效' },
        { value: '0', label: '无效' }
      ],
      departmentOptions: ['研发部', '工程部', '维修部', '人力部', '财务部'],
      departmentdata: [
        { bumen: '研发部', gangwei: '经理' },
        { bumen: '工程部', gangwei: '工程师' }
      ],
      addform: {
        id: '',
        username: '',
        name: '',
        email: '',
        mobile: '',
        status: '',
        role: '',
        bumen: '',
        gangwei: ''
      },
      editform: {
        id: '',
        username: '',
        email: '',
        mobile: '',
        status: ''
      },
      rules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
        username: [{ required: true, message: '请输入账户名', trigger: 'blur' }],
        mobile: [{ required: true, message: '请输入正确手机号', trigger: 'blur' }, { required: true, pattern: /^1\d{10}$/, message: '请输入正确手机号', trigger: 'blur' }],
        email: [
          { required: true, message: '请输入邮箱地址', trigger: 'blur' },
          // { required: true, pattern: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/, message: '请输入正确的邮箱地址', trigger: 'blur' }
          { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur' }
        ]
      },
      rules2: {
        pass: [{ validator: validatePass, trigger: 'blur' }],
        checkPass: [{ validator: validatePass2, trigger: 'blur' }]
      }
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    handleFilter() {},
    selecteUserStatus(value) {
      this.listQuery.status = value
    },
    //   查询数据的方法
    searchListdata() {},
    // 实现添加用户功能
    addUserSubmit(addform) {},
    // 弹出编辑对话框
    showEditDialog(row) {
      console.log(row)
      // 显示对话框
      this.editdialogFormVisible = true
      //   添加默认数据
      this.editform.username = row.username
      this.editform.mobile = row.mobile
      this.editform.email = row.email

      this.editform.status = row.status
    },
    // 编辑用户的功能实现
    editUserSubmit(editform) {},
    // 添加部门对话框
    showBumenDialog(row) {
      console.log(row)
      this.bumendialogFormVisible = true
      this.selectedOptions.push(row.bumen)
      // this.tableData3[0].bumen = row.bumen
      // this.tableData3[0].gangwei = row.gangwei
    },
    // 部门岗位的操作
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val
    },
    // 显示重置密码对话框
    showrestDialog(row) {
      this.restdialogVisible = true
    },
    Restsubmit(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.$message({
            message: '恭喜你，重置密码成功',
            type: 'success'
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
      // 隐藏对话框
      this.restdialogVisible = false
      // 移除表单的验证结果和重置表单字段
      this.$refs[formName].resetFields()
    },
    // 显示角色对话框
    showRoleDialog(row) {
      console.log(row)
      this.roledialogVisible = true
      // for(let index=0;index<this.roledata.length;index++){
      //   if(this.roledata[index].lable==row.role){
      //     console.log(index);

      //   }
      // }
      console.log(this.roledata)
      this.roledata.forEach((val, index) => {
        if (this.roledata[index].label === row.role) {
          console.log(index)
          this.value1.push(index)
        }
      })
      console.log(this.value1)
      // this.value1.push(row.role)
      // console.log(this.value1)
      // console.log(this.roledata)
      // console.info(this.roledata.indexOf(row.role))
    },
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
    // 项目初始化
    //   获取动态数据
    initList() {
      this.listLoading = true
      userList({ page: this.page, rows: this.rows }).then(response => {
        console.log(response)
        this.userList = response.data.data.rows
        this.total = response.data.data.total
        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false
        }, 1e3)
      })
      // this.userList = res.data.rows
      // this.total = res.data.total
    },

    // 分页功能
    // 当用户切换每面显示记录数时触发
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`)
      this.rows = val
      this.initList()
    },
    // 当前页码变化的时候触发的操作
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`)
      this.page = val
      this.initList()
    }
  }
}
</script>

<style lang="scss" scoped>
.management {
  padding: 20px;
  .fixed-width .el-button--mini {
    width: auto;
  }
}
</style>

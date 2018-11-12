<template>
  <div class="management">
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <el-form-item label="用户组名称:">
          <el-input v-model="listQuery.groupname" placeholder="请输入名称" style="width: 150px;" class="filter-item" clearable />
        </el-form-item>
        <el-form-item label="状态:">
          <el-select v-model="listQuery.status" placeholder="请选择" clearable class="filter-item" @change="selecteUserStatus">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
      </el-form>
    </div>

    <!-- 表格 -->
    <el-table v-loading="listLoading" :key="tableKey" :data="usergroupList" border fit highlight-current-row style="width: 100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="用户组名称" align="center" prop="groupName" />
      <el-table-column label="拥有用户" align="center" min-width="120" prop="sysTUserList">
        <template slot-scope="scope">
          <span v-for="item in scope.row.sysTUserList" :key="item.id" >{{ item.name }}</span>
      </template></el-table-column>
      <el-table-column label="角色名称" align="center" prop="sysRoleList" min-width="120" >
        <template slot-scope="scope">
          {{ scope.row.sysRoleList }}
          <span v-for="item in scope.row.sysRoleList" :key="item.id" >{{ item.roleName }}</span>
      </template></el-table-column>
      <el-table-column label="创建时间" width="150" align="center" prop="creationTime">
        <template slot-scope="scope">
          {{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status | statusFilter }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="showEditDialog(scope.row)">编辑</el-button>
          <el-button type="primary" size="mini" @click="showRoleDialog(scope.row)">角色</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteUser(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination :current-page="listQuery.page" :page-sizes="[5,10, 20, 30, 40]" :page-size="listQuery.rows" :total="total" layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    <!-- 弹出的添加用户组对话框 -->
    <el-dialog :visible.sync="adddialogFormVisible" title="添加用户组">
      <el-form ref="addform" :rules="rules" :model="addform" label-position="right" label-width="100px" style="max-width:300px;margin-left:20px;">
        <el-form-item label="用户组" prop="groupName">
          <el-input v-model.trim="addform.groupName" max-length="20" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="addform.status" class="filter-item">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="addUserSubmit('addform')">提交</el-button>
        <el-button @click="adddialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>

    <!-- 编辑用户组对话框 -->
    <el-dialog :visible.sync="editdialogFormVisible" title="编辑用户组">
      <el-form ref="editform" :rules="rules" :model="editform" label-position="right" label-width="80px" style="max-width:300px;margin-left:20px;">
        <el-form-item label="用户组" prop="groupName">
          <el-input v-model="editform.groupName" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="editform.status" class="filter-item">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="editUserSubmit('editform')">提交</el-button>
          <el-button @click="editdialogFormVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 弹出的角色对话框 -->
    <el-dialog :visible.sync="roledialogVisible" title="选择角色">
      <el-transfer v-model="value1" :data="rloedata" :titles="['角色1', '角色2']" />
      <span slot="footer" class="dialog-footer">
        <el-button @click="roledialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="roledialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>

</template>

<script>
import { groupList, addgroupList } from '@/api/userGroup'
export default {
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
    // 角色相关信息
    const generateData = _ => {
      const data = []
      const roles = ['管理员', '超级管理员', '超管理员', '超级理员']
      roles.forEach((role, index) => {
        data.push({
          label: role,
          key: index
        })
      })
      return data
    }
    return {
      dialogStatus: undefined,
      tableKey: 0,
      listLoading: false,
      ruleForm2: { pass: '', checkPass: '' },
      rloedata: generateData(),
      value1: [],
      total: null,
      usergroupList: [],
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
      listQuery: {
        groupname: undefined,
        status: undefined,
        rows: 10,
        page: 1
      },
      adddialogFormVisible: false,
      editdialogFormVisible: false,
      bumendialogFormVisible: false,
      roledialogVisible: false,
      statusOptions: [
        { value: '1', label: '有效' },
        { value: '0', label: '无效' }
      ],
      departmentdata: [
        { bumen: '研发部', gangwei: '经理' },
        { bumen: '工程部', gangwei: '工程师' }
      ],
      addform: {
        id: '',
        groupName: undefined,
        status: undefined
      },
      editform: {
        id: '',
        username: '',
        email: '',
        mobile: '',
        status: ''
      },
      rules: {
        groupName: [
          { required: true, message: '请输入用户组', trigger: 'blur' }
        ],
        miaoshu: [{ required: true, message: '请输入描述', trigger: 'blur' }]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    selecteUserStatus(value) {
      this.listQuery.status = value
    },
    //   查询数据的方法
    handleFilter() {
      this.initList()
    },
    // 清空信息
    resetaddform() {
      this.addform = {
        groupName: '',
        status: ''
      }
    },
    // 显示新增用户组对话框
    handleCreate() {
      this.resetaddform()
      this.dialogStatus = 'create'
      this.adddialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['addform'].clearValidate()
      })
    },
    // 实现添加用户功能
    addUserSubmit(addform) {
      this.$refs[addform].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          addgroupList({
            groupName: this.addform.groupName,
            status: this.addform.status
          }).then(res => {
            console.log(res)
            if (res.meta.status === 201) {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            }
            // 将对话框隐藏
            this.adddialogFormVisible = false
            // 重置表单元素的数据
            this.$refs[addform].resetFields()
            // 刷新页面显示
            this.initList()
          })
        } else {
          this.$message({
            message: '输入数据不合法',
            type: 'error'
          })
        }
      })
    },
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
    // 显示角色对话框
    showRoleDialog(row) {
      console.log(row)
      this.roledialogVisible = true
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
    initList() {
      this.listLoading = true
      groupList(this.listQuery).then(response => {
        console.log(response)
        this.usergroupList = response.data.data.rows
        this.total = response.data.data.total
        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false
        }, 1e3)
      })
    },
    // 分页功能
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`)
      this.listQuery.rows = val
      this.initList()
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`)
      this.listQuery.page = val
      this.initList()
    }
  }
}
</script>

<style lang="scss" scoped>
.management {
  display: flex;
  flex-direction: column;
  // height:100%;
  .fixed-width .el-button--mini {
    width: auto;
  }
}
</style>

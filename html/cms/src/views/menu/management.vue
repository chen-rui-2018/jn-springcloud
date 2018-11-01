<template>
  <div class="management">
    <div class="filter-container">
      <!-- input搜索框 -->
      名称：
      <el-input v-model="listQuery.title" placeholder="请输入名称" style="width: 200px;" class="filter-item" @keyup.enter.native="searchListdata" />
      <!-- 第一个下拉菜单 -->
      状态：
      <el-select v-model="listQuery.status" placeholder="请选择" clearable style="width: 90px" class="filter-item">
        <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />
      </el-select>
      <!-- 第二个下拉菜单 -->
      部门：
      <el-select v-model="listQuery.department" placeholder="请选择" clearable class="filter-item" style="width: 130px">
        <el-option v-for="item in departmentOptions" :key="item" :label="item" :value="item" />
      </el-select>
      <!-- 搜索按钮 -->
      <el-button class="filter-item" type="primary" icon="el-icon-search">搜索</el-button>
      <!-- 新增按钮 -->
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="adddialogFormVisible = true">添加用户</el-button>
    </div>

    <!-- 表格 -->
    <el-table :data="userList" border fit highlight-current-row style="width: 100%;">
      <!-- 表格第一列  序号 -->
      <el-table-column type="index" align="center" />
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
      <el-table-column label="邮箱" width="180" align="center">
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

      <el-table-column label="岗位" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.gangwei }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.status }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="300" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="showEditDialog(scope.row)">编辑</el-button>
          <el-button type="primary" align="center" size="mini" @click="showBumenDialog(scope.row)">部门岗位</el-button>
          <el-button type="primary" size="mini" @click="showRoleDialog(scope.row)">角色</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteUser(scope.row.id)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination :current-page="pagenum" :page-sizes="[1, 2, 3, 4]" :page-size="pagesize" :total="total" layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    <!-- 弹出的添加用户对话框 -->
    <el-dialog :visible.sync="adddialogFormVisible" title="添加用户">
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
            <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="角色" prop="juese">
          <el-input v-model="addform.juese" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="addUserSubmit('addform')">提交</el-button>
        <el-button @click="adddialogFormVisible = false">取消</el-button>

      </div>
    </el-dialog>

    <!-- 编辑用户对话框 -->
    <el-dialog :visible.sync="editdialogFormVisible" title="编辑用户">
      <el-form ref="editform" :rules="rules" :model="editform" label-position="right" label-width="70px" style="width: 400px; margin-left:50px;">
        <el-form-item label="账号" prop="username">
          <el-input v-model="editform.username" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="editform.name" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="editform.email" />
        </el-form-item>
        <el-form-item label="手机" prop="mobile">
          <el-input v-model="editform.mobile" />
        </el-form-item>
        <el-form-item label="部门" prop="bumen">
          <el-input v-model="editform.bumen" />
        </el-form-item>
        <el-form-item label="岗位" prop="gangwei">
          <el-input v-model="editform.gangwei" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="editform.status" class="filter-item">
            <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="角色" prop="juese">
          <el-input v-model="editform.juese" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="editdialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="editUserSubmit('editform')">确定</el-button>
      </div>
    </el-dialog>

    <!-- 部门岗位对话框 -->
    <el-dialog :visible.sync="bumendialogFormVisible" title="部门、岗位">
      <el-button type="primary" round>分配</el-button>
      <el-table ref="multipleTable" :data="tableData3" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="部门" width="210" align="center">
          <template slot-scope="scope">
            <el-cascader :options="options" placeholder="请选择部门" filterable />
          </template>
        </el-table-column>
        <el-table-column label="岗位" width="140" align="center">
          <template slot-scope="scope">
            <el-select v-model="scope.row.name2" placeholder="请选择岗位">
              <el-option v-for="item in gangweioptions" :key="item.value" :label="item.label" :value="item.value" />
            </el-select>
          </template>

          <template>
            <div>
              <slot :row="data"/>
            </div>
          </template>

        </el-table-column>
        <el-table-column prop="address" label="默认" align="center">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" round>设置为默认</el-button>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <!-- 删除按钮 -->
            <el-button size="mini" type="danger" @click="deleteUser(scope.row.id)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <span slot="footer" class="dialog-footer">
        <el-button @click="bumendialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="bumendialogFormVisible = false">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 弹出的角色对话框 -->
    <el-dialog
      :visible.sync="roledialogVisible"
      title="角色">
      <el-transfer v-model="value1" :data="data"/>
      <span slot="footer" class="dialog-footer">
        <el-button @click="roledialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="roledialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>

</template>

<script>
export default {
  data() {
    // 角色相关信息
    const generateData = _ => {
      const data = []
      for (let i = 1; i <= 15; i++) {
        data.push({
          key: i,
          label: `备选项 ${i}`
        })
      }
      return data
    }
    return {
      data: generateData(),
      value1: [1, 4],
      pagesize: 1,
      total: 0,
      pagenum: 1,
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
          date: '2016-05-03',
          address: ''
        },
        {
          date: '2016-05-02',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-04',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-01',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-08',
          address: '上海市普陀区金沙江路 1518 弄'
        }
      ],
      multipleSelection: [],
      listQuery: {
        title: '',
        status: '',
        department: ''
      },
      adddialogFormVisible: false,
      editdialogFormVisible: false,
      bumendialogFormVisible: false,
      roledialogVisible: false,
      statusOptions: ['有效', '失效'],
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
        name: '',
        email: '',
        mobile: '',
        status: '',
        role: '',
        bumen: '',
        gangwei: ''
      },
      rules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'change' }],
        mobile: [{ required: true, message: '请输入手机号', trigger: 'blur' }],
        email: [
          { required: true, message: '请输入邮箱地址', trigger: 'blur' },
          {
            type: 'email',
            message: '请输入正确的邮箱地址',
            trigger: 'blur,change'
          }
        ]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
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
      this.editform.name = row.name
      this.editform.username = row.username
      this.editform.mobile = row.mobile
      this.editform.email = row.email
      this.editform.role = row.role
      this.editform.status = row.status
      this.editform.gangwei = row.gangwei
      this.editform.bumen = row.bumen
    },
    // 编辑用户的功能实现
    editUserSubmit(editform) {},
    // 添加部门对话框
    showBumenDialog() {
      this.bumendialogFormVisible = true
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

    // 显示角色对话框
    showRoleDialog(row) {
      console.log(row)
      this.roledialogVisible = true
    },
    // 删除用户功能实现
    deleteUser() {},
    // 项目初始化
    initList() {
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
.management {
  padding: 20px;
}
</style>

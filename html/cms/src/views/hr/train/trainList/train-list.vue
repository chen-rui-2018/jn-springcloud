<template>
  <div v-loading="listLoading" class="trainList">
    <!-- 表单 -->
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="课程名称:">
        <el-input
          v-model="listQuery.courseTitle"
          maxlength="20"
          placeholder="请输入课程名称"
          class="filter-item"
          clearable
        />
      </el-form-item>
      <el-form-item label="培训时间:" style="margin:0px 30px;">
        <el-date-picker
          v-model="listQuery.trainStartTime"
          type="datetime"
          value-format="yyyy-MM-dd HH:mm:ss"
          placeholder="请选择开始时间"
        />至
        <el-date-picker
          v-model="listQuery.trainEndTime"
          type="datetime"
          value-format="yyyy-MM-dd HH:mm:ss"
          placeholder="请选择结束时间"
        />
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button
        class="filter-item"
        type="primary"
        icon="el-icon-plus"
        @click="handleAddOrEdict()"
      >制定课程</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="investList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center"/>
      <el-table-column
        :show-overflow-tooltip="true"
        label="课程名称"
        min-width="180"
        align="center"
        prop="courseTitle"
      >
        <template slot-scope="scope">
          <el-button
            class="setCursor"
            type="text"
            @click="handleDetail(scope.row)"
          >{{ scope.row.courseTitle }}</el-button>
        </template>
      </el-table-column>
      <el-table-column label="培训开始时间" min-width="180" align="center" prop="trainStartTimeStr"/>
      <el-table-column label="培训结束时间" min-width="180" align="center" prop="trainEndTimeStr"/>
      <el-table-column label="培训讲师" align="center" prop="trainTeacher"/>
      <el-table-column label="地址" align="center" prop="trainVenue"/>
      <el-table-column label="培训人数" align="center" prop="managementTrainRecord">
        <template slot-scope="scope">
          <el-button
            class="setCursor"
            type="text"
            @click="handleRecord(scope.row)"
          >{{ scope.row.managementTrainRecord===undefined?0:scope.row.managementTrainRecord }}</el-button>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="statusStr"/>
      <el-table-column
        label="操作"
        align="center"
        min-width="200"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button type="text" @click="sendMessage(scope.row)">发送通知</el-button>
          <el-button type="text" @click="handleAddOrEdict(scope.row)">修改</el-button>
          <el-button type="text" style="color:red;" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      v-show="total>0"
      :current-page="listQuery.page"
      :page-sizes="[5,10,20,30, 50]"
      :page-size="listQuery.rows"
      :total="total"
      class="tablePagination"
      background
      layout="total, sizes, prev, pager, next, jumper"
      @current-change="handleCurrentChange"
    />
    <!-- 弹窗 -->
    <template v-if="dialogFormVisible">
      <el-dialog :visible.sync="dialogFormVisible" class="dialog" title="发送通知" width="30%">
        <el-form :model="messageForm">
          <el-form-item label="课程名称" label-width="80px">
            <el-input v-model="messageForm.courseTitle" disabled/>
          </el-form-item>
          <el-form-item label="通知人员" label-width="80px">
            <!-- <el-button type="primary" @click="selectStaff">选择</el-button> -->
            <el-cascader-multi v-model="checkList" :data="options" :only-last="true" :show-leaf-label="true"/>
          </el-form-item>
          <!-- <el-form-item label-width="80px">
            <el-tree
              :data="treeData"
              :props="defaultProps"
              style="height:186px;overflow:auto;border:1px solid #dcdfe6;"
              show-checkbox
              @check-change="handleNodeSelect"
            />
          </el-form-item> -->
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="confirmSend">确 定</el-button>
        </div>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import { api } from '@/api/hr/train'
export default {
  data() {
    return {
      listLoading: false,
      // 表单
      listQuery: {
        courseTitle: '',
        trainStartTime: '',
        trainEndTime: '',
        rows: 5,
        page: 1
      },
      // 分页
      total: 1,
      // 表格
      investList: [],
      // 弹窗
      dialogFormVisible: false,
      messageForm: {
        courseTitle: ''
      },
      // 树结构
      treeData: [],
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      // 层级树
      options: [{
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
        }, {
          value: 'daohang',
          label: '导航',
          children: [{
            value: 'cexiangdaohang',
            label: '侧向导航'
          }, {
            value: 'dingbudaohang',
            label: '顶部导航'
          }]
        }]
      }, {
        value: 'zujian',
        label: '组件',
        children: [{
          value: 'basic',
          label: 'Basic',
          children: [{
            value: 'layout',
            label: 'Layout 布局'
          }, {
            value: 'color',
            label: 'Color 色彩'
          }, {
            value: 'typography',
            label: 'Typography 字体'
          }, {
            value: 'icon',
            label: 'Icon 图标'
          }, {
            value: 'button',
            label: 'Button 按钮'
          }]
        }, {
          value: 'form',
          label: 'Form',
          children: [{
            value: 'radio',
            label: 'Radio 单选框'
          }, {
            value: 'checkbox',
            label: 'Checkbox 多选框'
          }, {
            value: 'input',
            label: 'Input 输入框'
          }, {
            value: 'input-number',
            label: 'InputNumber 计数器'
          }, {
            value: 'select',
            label: 'Select 选择器'
          }, {
            value: 'cascader',
            label: 'Cascader 级联选择器'
          }, {
            value: 'switch',
            label: 'Switch 开关'
          }, {
            value: 'slider',
            label: 'Slider 滑块'
          }, {
            value: 'time-picker',
            label: 'TimePicker 时间选择器'
          }, {
            value: 'date-picker',
            label: 'DatePicker 日期选择器'
          }, {
            value: 'datetime-picker',
            label: 'DateTimePicker 日期时间选择器'
          }, {
            value: 'upload',
            label: 'Upload 上传'
          }, {
            value: 'rate',
            label: 'Rate 评分'
          }, {
            value: 'form',
            label: 'Form 表单'
          }]
        }, {
          value: 'data',
          label: 'Data',
          children: [{
            value: 'table',
            label: 'Table 表格'
          }, {
            value: 'tag',
            label: 'Tag 标签'
          }, {
            value: 'progress',
            label: 'Progress 进度条'
          }, {
            value: 'tree',
            label: 'Tree 树形控件'
          }, {
            value: 'pagination',
            label: 'Pagination 分页'
          }, {
            value: 'badge',
            label: 'Badge 标记'
          }]
        }, {
          value: 'notice',
          label: 'Notice',
          children: [{
            value: 'alert',
            label: 'Alert 警告'
          }, {
            value: 'loading',
            label: 'Loading 加载'
          }, {
            value: 'message',
            label: 'Message 消息提示'
          }, {
            value: 'message-box',
            label: 'MessageBox 弹框'
          }, {
            value: 'notification',
            label: 'Notification 通知'
          }]
        }, {
          value: 'navigation',
          label: 'Navigation',
          children: [{
            value: 'menu',
            label: 'NavMenu 导航菜单'
          }, {
            value: 'tabs',
            label: 'Tabs 标签页'
          }, {
            value: 'breadcrumb',
            label: 'Breadcrumb 面包屑'
          }, {
            value: 'dropdown',
            label: 'Dropdown 下拉菜单'
          }, {
            value: 'steps',
            label: 'Steps 步骤条'
          }]
        }, {
          value: 'others',
          label: 'Others',
          children: [{
            value: 'dialog',
            label: 'Dialog 对话框'
          }, {
            value: 'tooltip',
            label: 'Tooltip 文字提示'
          }, {
            value: 'popover',
            label: 'Popover 弹出框'
          }, {
            value: 'card',
            label: 'Card 卡片'
          }, {
            value: 'carousel',
            label: 'Carousel 走马灯'
          }, {
            value: 'collapse',
            label: 'Collapse 折叠面板'
          }]
        }]
      }, {
        value: 'ziyuan',
        label: '资源',
        children: [{
          value: 'axure',
          label: 'Axure Components'
        }, {
          value: 'sketch',
          label: 'Sketch Templates'
        }, {
          value: 'jiaohu',
          label: '组件交互文档'
        }]
      }],
      checkList: []
    }
  },
  created() {
    this.init()
  },
  methods: {
    // 1.初始化
    init() {
      this.listLoading = true
      api('hr/train/list/managementList', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.investList = res.data.data.rows
          this.total = res.data.data.total
          if (this.investList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.init()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 搜素功能的实现
    handleFilter() {
      this.listQuery.page = 1
      this.init()
    },
    // 表格分页功能
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.init()
    },
    // 新增/编辑--制定课程
    handleAddOrEdict(row) {
      if (row && row.id) {
        this.$router.push({
          name: 'train-addOrEdict',
          query: { id: row.id, title: '编辑课表' }
        })
      } else {
        this.$router.push({
          name: 'train-addOrEdict',
          query: { title: '新增课表' }
        })
      }
    },
    // 详情--课程详情
    handleDetail(row) {
      if (row.id) {
        this.$router.push({
          name: 'train-detail',
          query: { id: row.id, title: '课程详情' }
        })
      }
    },
    // 删除
    handleDelete(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          const data = { id: row.id }
          api('hr/train/list/deleteManagement', data).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.listQuery.rows === 1) {
                this.listQuery.page = this.listQuery.page - 1
              }
              this.init()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {})
    },
    // 培训记录
    handleRecord(row) {
      this.$router.push({
        name: 'train-record',
        query: { id: row.id, title: '培训记录' }
      })
    },
    // 发送通知--树结构
    handleNodeSelect(data, checked) {
      if (!data.children && checked) {
        this.messageForm.employeeBasicInfoList = []
        // delete data.label
        this.messageForm.employeeBasicInfoList.push(data)
      }
    },
    confirmSend() {
      this.dialogFormVisible = false
      api('hr/train/list/emailList', this.messageForm).then(res => {
        if (res.data.code === '0000') {
          this.$message.success('邮件发送成功')
          this.checkList = []
          this.init()
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 人员列表
    selectStaff() {
      api('hr/train/list/selectUserList', this.messageForm).then(res => {
        if (res.data.code === '0000') {
          const list = res.data.data
          const vm = this
          // 遍历一级
          list.forEach((item, index) => {
            const labelData = {
              label: item.departmentName,
              children: []
            }
            vm.treeData.push(labelData)
            // 遍历二级
            item.employeeBasicInfoList.forEach((item2, index2) => {
              const childrenData = {
                label: item2.name + '-' + item2.jobNumber,
                workMailbox: item2.workMailbox,
                jobNumber: item2.jobNumber,
                name: item2.name,
                departmentName: item.departmentName
              }
              vm.treeData[index].children.push(childrenData)
            })
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    sendMessage(row) {
      this.dialogFormVisible = true
      this.messageForm = row
    }
  }
}
</script>

<style>
/* global styles */
.trainList .el-dialog__header {
  text-align: center;
}
.trainList .el-dialog__title {
  color: #409eff;
}
.trainList .el-dialog label {
  font-weight: normal;
}
</style>
<style lang="scss" scoped>
/* local styles */
.setCursor {
  cursor: pointer;
}
.el-pagination {
  margin-top: 15px;
}
</style>

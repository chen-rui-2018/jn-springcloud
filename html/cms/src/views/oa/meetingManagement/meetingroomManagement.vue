<template>
  <div class="meetingroomManagement">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="会议室名称:">
        <el-input v-model="listQuery.name" maxlength="20" placeholder="请输入会议室名称" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="会议室状态">
        <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable style="width: 150px" class="filter-item" @change="selecteRecordStatus">
          <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table ref="multipleTable" :data="meetingroomList" border fit highlight-current-row style="width: 100%;height:100%;">
      <!-- <el-table-column
        type="selection"
        width="55"/> -->
      <el-table-column type="index" width="60" label="序号" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="会议室名称" align="center" prop="name" />
      <el-table-column label="会议室位置" align="center" prop="position" />
      <el-table-column label="创建人" align="center" prop="userName" />
      <el-table-column label="部门" align="center" prop="departmentName" />
      <el-table-column label="会议室容量" align="center" prop="capacity" />
      <el-table-column label="会议室说明" align="center" prop="explains" />
      <el-table-column label="会议室状态" align="center" prop="recordStatus">
        <template slot-scope="scope">
          <span :class="scope.row.recordStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.recordStatus===1?'可用':'不可用' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button
            v-if="scope.row.creatorAccount!==userID"
            type="text"
            class="operation"
            @click="look(scope.row)">查看
          </el-button>
          <el-button v-if="scope.row.creatorAccount===userID" type="text" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button v-if="scope.row.creatorAccount===userID" type="text" @click="deleteMeetingroom(scope.row)">删除</el-button>
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
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />
  </div>
</template>

<script>
import store from '@/store'
import {
  api, paramApi
} from '@/api/oa/meetingManagement'
export default {
  data() {
    return {
      isDisabled: false,
      dialogImageUrl: '',
      lookMeetingroom: false,
      addMeetingroom: false,
      title: '',
      dialogFormVisible: false,
      userID: '',
      meetingroomList: [],
      listLoading: false,
      listQuery: {
        name: '',
        page: 1,
        rows: 10
      },
      total: 0,
      meetingroomForm: {
        name: '',
        building: '',
        floor: '',
        roomNumber: '',
        capacity: '',
        recordStatus: '',
        explains: ''

      },
      statusOptions: [
        {
          value: '1',
          label: '可用'
        },
        {
          value: '2',
          label: '不可用'
        }
      ]
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    uploadDone(res, file, fileList) {
      console.log(res)
      console.log(file)
      console.log(fileList)
      this.meetingroomForm.imgArr.push({ 'imgUrl': res.data.temp_path })
    },
    // 限制最多只能传3张图片
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传3张图片`)
    },
    // 删除图片
    handleRemove(file, fileList) {
      console.log(file, fileList)
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    // 获取token
    getToken() {
      console.log(store.getters.token)
      var token = store.getters.token
      return { 'token': token }
    },
    // 编辑会议室
    handleUpdate(row) {
      console.log(row)
      this.$router.push({ name: 'editMeetingroom', query: { id: row.id, title: '编辑会议室' }})
    },
    // 查看会议室
    look(row) {
      this.$router.push({ name: 'lookMeetingroom', query: { id: row.id, title: '查看会议室' }})
    },
    // 删除会议室
    deleteMeetingroom(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi('oa/oaMeetingRoom/delete', row.id, 'ids').then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.listQuery.rows === 1) {
                this.listQuery.page = this.listQuery.page - 1
              }
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {
        })
    },
    // 点击新增跳转到新增会议室页面
    handleCreate() {
      this.$router.push({ name: 'addMeetingroom', query: { title: '新增会议室' }})
    },
    selecteRecordStatus(value) {
      this.listQuery.recordStatus = value
    },
    //   搜素功能的实现
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 项目初始化
    initList() {
      this.listLoading = true
      api('oa/oaMeetingRoom/list', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          console.log(res)
          this.meetingroomList = res.data.data.rows
          this.total = res.data.data.total
          if (this.meetingroomList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
          this.userID = localStorage.getItem('id')
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },

    // 表格分页功能
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    // 表格分页功能
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    }
  }
}
</script>

<style lang="scss">
.addMeetingroom {
  .el-dialog{
    margin-top:5vh !important;
    width: 80vw;
    .el-upload--picture-card {
      width: 60px;
    height: 60px;
    line-height: 64px;
    }
  }
  .header {
    color: cadetblue;
    background: #f0f0f0;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: Center;
    padding: 20px 0px;
    border:1px solid #ccc;
  }
  .inline {
    display: inline-block;
  }
  .el-form-item__label {
    width: 120px;
    padding: 15px 0;
    display: inline-block;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .el-form-item {
    margin-bottom: 0px;
    flex: 1;
    display: flex;
  }
  .el-form-item__content {
    flex: 1;
    display: inline-block;
    padding: 15px;
    border: 1px solid #ccc;
  }
  .primaryList {
    margin-top: 30px;
    text-align: center;
  }
  .el-form-item__error{
    left:22px;
    top:unset;
    padding-top: unset;
  }
}
</style>

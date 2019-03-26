<template>
  <div v-loading="listLoading" class="meetingManagement">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-radio-group v-model="listQuery.meetingStatus" style="width:40%">
        <el-radio-button label="">全部</el-radio-button>
        <el-radio-button label= "1">进行中</el-radio-button>
        <el-radio-button label="2">已完成</el-radio-button>
        <el-radio-button label="3">已取消</el-radio-button>
        <el-radio-button label="0">待开始</el-radio-button>
      </el-radio-group>
      <el-form-item label="会议室名称:" class="meetingName" >
        <el-input v-model="listQuery.meetingRoomName" maxlength="20" placeholder="请输入会议室名称" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-button class="filter-item" type="primary" style="float:right; margin-right:20px;" @click="handleAppointment">会议预约</el-button>
      <div>
        <el-form-item label="申请人部门:" style="width:39%;" class="meetingName">
          <el-input v-model="listQuery.departmentName" maxlength="20" placeholder="请输入部门" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        </el-form-item>
        <el-form-item label="会议时间:">
          <el-date-picker v-model="listQuery.startTime" value-format="yyyy/MM/dd" type="date" placeholder="选择开始日期"/>
          至
          <el-date-picker v-model="listQuery.endTime" type="date" value-format="yyyy/MM/dd" placeholder="选择结束日期" />
        </el-form-item>
        <div class="right_button">
          <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button class="filter-item" type="primary" @click="exportText">导出</el-button></div></div>
    </el-form>
    <!-- 表格 -->
    <el-table :data="meetingList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column label="会议" align="center">
        <el-table-column type="index" width="60" label="序号" align="center" />
        <!-- 表格第二列  姓名 -->
        <el-table-column label="名称" align="center" prop="title" />
        <el-table-column label="会议室" align="center" prop="tbOaMeetingRoom.name" />
        <el-table-column label="日期" align="center" prop="startDate" />
        <el-table-column label="开始时间" align="center" prop="startTime" />
        <el-table-column label="结束时间" align="center" prop="endTime" />
      </el-table-column>
      <el-table-column label="人员" align="center">
        <el-table-column label="组织方" align="center" class-name="small-padding fixed-width" width="150">
          <template slot-scope="scope">
            <div>部门:{{ scope.row.departmentName? scope.row.departmentName:'无' }}</div>
            <div>组织人:{{ scope.row.userName }}</div>
            <div>预约人:{{ scope.row.userName }}</div>
          </template>
        </el-table-column>
        <el-table-column label="预计人数" align="center" prop="department" min-width="120">
          <template slot-scope="scope">
            <span>预计人数:{{ scope.row.participantList.length?scope.row.participantList.length:'0' }} 人</span>
          </template>
        </el-table-column>
        <el-table-column label="签到人数" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <div>正常:{{ scope.row.status }}0人</div>
            <div>迟到:{{ scope.row.status }}0人</div>
            <div>未到:{{ scope.row.status }}0人</div>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="meetingStatus">
        <template slot-scope="scope">
          <span v-if="scope.row.meetingStatus==='0'" >待开始</span>
          <span v-if="scope.row.meetingStatus==='1'" >进行中</span>
          <span v-if="scope.row.meetingStatus==='2'" >已完成</span>
          <span v-if="scope.row.meetingStatus==='3'" >已取消</span>
          <!-- <span :class="scope.row.meetingStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.recordStatus===1?'可用':'不可用' }}</span> -->
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" min-width="240">
        <template slot-scope="scope">
          <el-button
            type="text"
            class="operation"
            @click="lookDetails(scope.row)">查看详情
          </el-button>
          <el-button
            v-if="scope.row.meetingStatus==='0'"
            type="text"
            class="operation"
            @click="handleCancel(scope.row)">取消会议
          </el-button>
          <el-button
            v-if="scope.row.meetingStatus==='1'"
            type="text"
            class="operation"
            @click="handleDeleteActivity(scope.row)">结束会议
          </el-button>
          <el-button
            type="text"
            class="operation"
            @click="handleErweima(scope.row)">签到二维码
          </el-button>
          <el-button
            v-if="scope.row.meetingStatus==='0'"
            type="text"
            class="operation"
            @click="handleEdit(scope.row)">编辑
          </el-button>
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
    <!-- 弹出的二维码 -->

    <el-dialog
      :visible.sync="erweimaDialogVisible"
      class="erweima"
      title="请扫描二维码"
      width="40%">
      <img :src="imgurl" alt="二维码图片">
      <!-- <img src="/static/images/timg.jpg" alt="二维码图片"> -->
    </el-dialog>
  </div>
</template>

<script>
import {
  api, paramApi, exportExcel
} from '@/api/oa/meetingManagement'
export default {
  data() {
    return {
      imgurl: '',
      erweimaDialogVisible: false,
      total: 0,
      meetingList: [],
      listLoading: false,
      listQuery: {
        meetingStatus: '',
        page: 1,
        rows: 10,
        meetingRoomName: '',
        startTime: '',
        endTime: '',
        departmentName: ''
      }
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    // 导出
    exportText() {
      exportExcel(this.listQuery).then(res => {
        window.location.href = res.request.responseURL
      })
    },
    // 点击二维码
    handleErweima(row) {
      this.erweimaDialogVisible = true
      this.imgurl = row.signInQr
    },
    // 结束会议
    handleDeleteActivity(row) {
      this.$confirm(`此操作将结束当前会议, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi('oa/oaMeeting/finishOaMeeting', row.id, 'id').then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '结束会议成功',
                type: 'success'
              })
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {
        })
    },
    // 编辑会议
    handleEdit(row) {
      this.$router.push({ name: 'editmeetingApplication', query: { id: row.id, title: '编辑会议' }})
    },
    // 查看详情
    lookDetails(row) {
      this.$router.push({ name: 'lookmeetingApplication', query: { id: row.id, title: '查看会议' }})
    },
    // 取消会议
    handleCancel(row) {
      this.$confirm(`此操作将放弃当前会议, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi('oa/oaMeeting/cancelOaMeeting', row.id, 'id').then(res => {
          // api('oa/oaMeeting/delete', { id: [row.id] }).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '取消会议成功',
                type: 'success'
              })
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {
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
    },
    // 查询数据
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 跳转到会议预约页面
    handleAppointment() {
      this.$router.push({ name: 'conferenceReservation' })
    },
    // 获取会议列表
    initList() {
      this.listLoading = true
      api('oa/oaMeeting/list', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.meetingList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    }
  }
}
</script>

<style lang="scss" >
  .erweima{
    .el-dialog{
      height: 400px;
      img{
           width: 60%;
    display: block;
    border-style: none;
    margin: 0 auto;
      }
    }
  }
  .meetingName{
    .el-input--medium .el-input__inner{
      width: 180px;
    }
  }
  .meetingManagement{
    .el-pagination{
      margin-top:15px;
    }

  .filter-bar{
    .el-date-editor.el-input, .el-date-editor.el-input__inner{
      width: 180px;
    }
    .el-radio-button--medium .el-radio-button__inner,.el-button--medium{

         padding:10px;
    }
  }
  }
  .right_button{
  float:right;
  margin-right:20px;
  }
</style>

<template>
  <div v-loading="listLoading" class="meetingManagement">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-radio-group v-model="listQuery.approvalStatus">
        <el-radio-button label="">全部</el-radio-button>
        <el-radio-button label= "1">审核中</el-radio-button>
        <el-radio-button label="2">审核通过</el-radio-button>
        <el-radio-button label="3">审核不通过</el-radio-button>
        <el-radio-button label="0">已取消</el-radio-button>
      </el-radio-group>
      <el-form-item label="会议名称:" style="margin-left: 20px;">
        <el-input v-model="listQuery.title" maxlength="20" placeholder="请输入会议名称" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <!-- <el-form-item label="会议时间:">
        <el-date-picker
          v-model="listQuery.time"
          type="datetimerange"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"/>
      </el-form-item> -->

      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <!-- <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button> -->
      <el-button class="filter-item" style="margin-left: 10px" type="primary" @click="handleAppointment">会议预约</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="meetingList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column label="会议" align="center">
        <el-table-column type="index" width="60" label="序号" align="center" />
        <!-- 表格第二列  姓名 -->
        <el-table-column label="名称" align="center" prop="title" />
        <el-table-column label="会议室" align="center" prop="meetingName" />
        <el-table-column label="日期" align="center" prop="startDate" />
        <el-table-column label="开始时间" align="center" prop="startTime" />
        <el-table-column label="结束时间" align="center" prop="endTime" />
      </el-table-column>
      <el-table-column label="人员" align="center">
        <el-table-column label="组织方" align="center" class-name="small-padding fixed-width" width="150">
          <template slot-scope="scope">
            <div>部门:{{ scope.row.departmentName }}</div>
            <div>组织人:{{ scope.row.userName }}</div>
            <div>预约人:{{ scope.row.userName }}</div>
          </template>
        </el-table-column>
        <el-table-column label="预计人数" align="center" prop="department">
          <template slot-scope="scope">
            <span>预计人数:{{ scope.row.departmentNam }} 0人</span>
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
      <el-table-column label="审核状态" align="center" prop="approvalStatus">
        <template slot-scope="scope">
          <span v-if="scope.row.approvalStatus==='0'" >已取消</span>
          <span v-if="scope.row.approvalStatus==='1'" >审核中</span>
          <span v-if="scope.row.approvalStatus==='2'" >审核通过</span>
          <span v-if="scope.row.approvalStatus==='3'" >审核不通过</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            type="text"
            class="operation"
            @click="lookDetails(scope.row)">查看详情
          </el-button>
          <el-button
            v-if="scope.row.approvalStatus==='1'"
            type="text"
            class="operation"
            @click="handleCancel(scope.row)">取消会议
          </el-button>
          <el-button
            v-if="scope.row.approvalStatus==='2' && scope.row.meetingStatus !=='2'"
            type="text"
            class="operation"
            @click="handleDeleteActivity(scope.row)">结束会议
          </el-button>
          <el-button
            v-if="scope.row.approvalStatus==='2'"
            type="text"
            class="operation"
            @click="handleErweima(scope.row)">签到二维码
          </el-button>
          <el-button
            v-if="scope.row.approvalStatus==='3'"
            type="text"
            class="operation"
            @click="handleEdit(scope.row)">编辑
          </el-button>
          <!-- <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button> -->
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
    </el-dialog>
  </div>
</template>

<script>
import {
  api, paramApi
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
        approvalStatus: '',
        page: 1,
        rows: 10,
        title: ''
        // time: ''
      },
      meetingStatusOptions: ['可用', '不可用']
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    // 点击二维码
    handleErweima(row) {
      console.log(row)
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
    handleSizeChange() {},
    handleCurrentChange() {},
    // 查询数据
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    handleCreate() {},
    handleAppointment() {
      this.$router.push({ name: 'conferenceReservation' })
    },
    // 获取会议列表
    initList() {
      this.listLoading = true
      console.log(this.listQuery)
      api('oa/oaMeeting/list', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          console.log(res)
          this.meetingList = res.data.data.rows
          this.total = res.data.data.total
          // if (this.userList.length === 0 && this.total > 0) {
          //   this.listQuery.page = 1
          //   this.initList()
          // }
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
      margin-top: 8vh !important;
    }
  }
</style>

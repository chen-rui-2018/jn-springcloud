<template>
  <div v-loading="listLoading" class="meetingManagement">
    <div class="filter-container">
      <el-col :span="10">
        <el-radio-group v-model="listQuery.status">
          <el-radio-button label="">全部</el-radio-button>
          <el-radio-button label= "1">审核中</el-radio-button>
          <el-radio-button label="2">审核通过</el-radio-button>
          <el-radio-button label="3">审核不通过</el-radio-button>
          <el-radio-button label="4">已取消</el-radio-button>
        </el-radio-group>
      </el-col>
      <el-col :span="14">
        <el-form :inline="true" :model="listQuery">
          <el-form-item label="会议室名称:">
            <el-input v-model="listQuery.meetingName" maxlength="20" placeholder="请输入会议室名称" class="filter-item" clearable @keyup.enter.native="handleFilter" />
          </el-form-item>
          <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
          <el-button class="filter-item" style="margin-left: 10px" type="primary" @click="handleAppointment">会议预约</el-button>
        </el-form>
      </el-col>
    </div>
    <!-- 表格 -->
    <el-table :data="usergroupList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column label="会议室" align="center">
        <el-table-column type="index" width="60" label="序号" align="center" />
        <!-- 表格第二列  姓名 -->
        <el-table-column label="名称" align="center" prop="meetingName" />
        <el-table-column label="会议室" align="center" prop="meetingName" />
        <el-table-column label="日期" align="center" prop="createName" />
        <el-table-column label="开始时间" align="center" prop="department" />
        <el-table-column label="结束时间" align="center" prop="department" />
      </el-table-column>
      <el-table-column label="人员" align="center">
        <el-table-column label="组织方" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <div>部门:{{ scope.row.status }}</div>
            <div>组织人:{{ scope.row.status }}</div>
            <div>预约人:{{ scope.row.status }}</div>
          </template>
        </el-table-column>
        <el-table-column label="预计人数" align="center" prop="department" />
        <el-table-column label="签到人数" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <div>正常:{{ scope.row.status }}</div>
            <div>迟到:{{ scope.row.status }}</div>
            <div>未到:{{ scope.row.status }}</div>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status | statusFilter }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审核状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status | statusFilter }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <!-- 删除按钮 -->
          <el-button size="mini" type="danger" @click="deleteUsergroup(scope.row)">删除</el-button>
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
export default {
  data() {
    return {
      total: 0,
      usergroupList: [],
      listLoading: false,
      listQuery: {
        page: 1,
        rows: 10,
        meetingName: '',
        meetingstatus: ''
      },
      meetingStatusOptions: ['可用', '不可用']
    }
  },
  methods: {
    handleSizeChange() {},
    handleCurrentChange() {},
    handleFilter() {},
    handleCreate() {},
    handleAppointment() {
      this.$router.push({ name: 'conferenceReservation' })
    }
  }
}
</script>

<style scoped>

</style>

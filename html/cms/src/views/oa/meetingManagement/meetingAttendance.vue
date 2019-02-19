<template>
  <div v-loading="listLoading" class="meetingAttendance">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="姓名:">
        <el-input v-model="listQuery.meetingroomName" maxlength="20" placeholder="请输入姓名" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="状态:">
        <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable style="width: 150px" class="filter-item" @change="selecteUserStatus">
          <el-option v-for="(item,index) in userStatusOptions" :key="item" :label="item" :value="index" />
        </el-select>
      </el-form-item>
      <el-form-item label="会议主题:">
        <el-input v-model="listQuery.meetingroomName" maxlength="20" placeholder="请输入会议主题" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="会议时间:">
        <el-date-picker v-model="listQuery.actiStartTime" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始时间" @change="getStarttime" />
        至
        <el-date-picker v-model="listQuery.actiEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间" @change="getEndtime" />
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="usergroupList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="会议室" align="center" prop="meetingName" />
      <el-table-column label="会议时间" align="center" prop="meetingName" />
      <el-table-column label="会议主题" align="center" prop="createName" />
      <el-table-column label="姓名" align="center" prop="createName" />
      <el-table-column label="部门" align="center" prop="department" />
      <el-table-column label="会议参与打卡" align="center" prop="department" />
      <el-table-column label="会议散会打卡" align="center" prop="department" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status }}</span>
        </template>
      </el-table-column>
      <el-table-column label="详情" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">查看</el-button>
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
        actiEndTime: '',
        actiStartTime: '',
        page: 1,
        rows: 10,
        meetingName: '',
        meetingstatus: ''
      },
      userStatusOptions: ['可用', '不可用']
    }
  },
  methods: {
    getEndtime() {},
    getStarttime() {},
    selecteUserStatus() {},
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

<style lang="scss">
.meetingAttendance{
 .el-date-editor.el-input, .el-date-editor.el-input__inner{
    width:150px;
  }
  .el-input--medium .el-input__inner{
    width:150px;
  }
}
</style>

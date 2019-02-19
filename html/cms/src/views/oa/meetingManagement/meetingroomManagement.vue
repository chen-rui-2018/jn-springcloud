<template>
  <div class="meetingroomManagement">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-form-item label="会议室名称:">
        <el-input v-model="listQuery.meetingroomName" maxlength="20" placeholder="请输入会议室名称" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="会议室状态">
        <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable style="width: 150px" class="filter-item" @change="selecteUserStatus">
          <el-option v-for="(item,index) in userStatusOptions" :key="item" :label="item" :value="index" />
        </el-select>
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="usergroupList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="会议室名称" align="center" prop="meetingName" />
      <el-table-column label="会议室位置" align="center" prop="meetingName" />
      <el-table-column label="创建人" align="center" prop="createName" />
      <el-table-column label="部门" align="center" prop="department" />
      <el-table-column label="会议室容量" align="center" prop="department" />
      <el-table-column label="会议室说明" align="center" prop="department" />
      <el-table-column label="会议室状态" align="center" prop="status">
        <template slot-scope="scope">
          <span :class="scope.row.status==1 ? 'text-green' : 'text-red'">{{ scope.row.status }}</span>
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
      listQuery: {
        recordStatus: '',
        meetingroomName: ''
      },
      userStatusOptions: ['可用', '不可用']
    }
  },
  methods: {
    handleCreate() {
      this.$router.push({ name: 'addMeetingroom' })
    }
  }
}
</script>

<style scoped>

</style>

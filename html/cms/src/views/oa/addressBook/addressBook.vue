<template>
  <div v-loading="listLoading" class="flex-box-cloumn addressBook">
    <el-row>
      <el-col :span="3"><el-button class="filter-item" @click="showDepartment()">{{ title?'显示部门':'全部用户' }}</el-button></el-col>
      <el-col :span="21"><div class="filter-container">
        <el-form :inline="true" :model="listQuery" class="filter-bar">
          <el-form-item label="姓名:">
            <el-input v-model="listQuery.name" maxlength="20" placeholder="请输入姓名" class="filter-item" clearable @keyup.enter.native="handleFilter"/>
          </el-form-item>
          <el-form-item label="手机号:">
            <el-input v-model="listQuery.phone" maxlength="11" placeholder="请输入手机号码" class="filter-item" clearable @keyup.enter.native="handleFilter"/>
          </el-form-item>
          <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
        </el-form>
      </div></el-col>
    </el-row>
    <!-- 主体部分 -->
    <div class="addressBook-content">
      <div v-if="isShow" class="addressBook-left">
        <el-tree v-loading="departmentListLoading" :data="departmentList" :expand-on-click-node="false" :props="defaultProps" default-expand-all @node-click="handleNodeClick"/>
      </div>
      <div class="addressBook-right">
        <el-table :data="addressList" border fit highlight-current-row>
          <el-table-column label="序列" type="index" align="center" width="60"/>
          <el-table-column label="姓名" prop="name" align="center" />
          <el-table-column label="部门" prop="departmentName" align="center" />
          <el-table-column label="岗位" prop="postName" align="center" />
          <el-table-column label="岗位类型" prop="postTypeName" align="center" />
          <el-table-column label="邮箱" prop="email" align="center" />
          <el-table-column label="联系方式" prop="phone" align="center" />
          <el-table-column label="微信" prop="wechatAccount" align="center"/>
          <el-table-column fit label="操作" align="center">
            <template slot-scope="scope">
              <el-button type="text" @click="handlelooking(scope.row)" >查看</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="pagination-container">
          <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10,20,30,50]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
        </div>
      </div>
    </div>

    <!-- S 新增弹窗 -->
    <template v-if="dialogFormVisible">
      <el-dialog :visible.sync="dialogFormVisible" title="查看通讯录" margin-top="10vh" width="500px">
        <el-form ref="dataForm" :model="addressListForm" label-position="right" label-width="80px" style="max-width:320px;margin-left:20px;">
          <el-form-item label="姓名" >
            <el-input v-model="addressListForm.name" :disabled="looking"/>
          </el-form-item>
          <el-form-item label="部门">
            <el-input v-model="addressListForm.departmentName" :disabled="looking"/>
          </el-form-item>
          <el-form-item label="岗位">
            <el-input v-model="addressListForm.postName" :disabled="looking"/>
          </el-form-item>
          <el-form-item label="岗位类型">
            <el-input v-model="addressListForm.postTypeName" :disabled="looking"/>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="addressListForm.email" :disabled="looking"/>
          </el-form-item>
          <el-form-item label="手机">
            <el-input v-model="addressListForm.phone" :disabled="looking"/>
          </el-form-item>
          <el-form-item label="微信">
            <el-input v-model="addressListForm.wechatAccount" :disabled="looking"/>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">返回</el-button>
        </div>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import {
  api
} from '@/api/oa/meetingManagement'
export default {

  data() {
    return {
      dialogFormVisible: false,
      listLoading: false,
      total: 0,
      addressList: [],
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      looking: false,
      addressListForm: {
        name: '',
        postName: '',
        phone: '',
        email: '',
        departmentName: '',
        wechatAccount: '',
        postTypeName: ''
      },
      departmentList: [],
      departmentListLoading: false,
      isShow: false,
      title: true,
      listQuery: {
        page: 1,
        rows: 10,
        departmentId: '',
        name: '',
        phone: ''
      }
    }
  },
  mounted() {
    this.initList()
    this.getAllDepartment()
  },
  methods: {
    // 查看数据
    handlelooking(row) {
      console.log(row)
      this.dialogFormVisible = true
      this.looking = true
      this.addressListForm.name = row.name
      this.addressListForm.postName = row.postName
      this.addressListForm.postTypeName = row.postTypeName
      this.addressListForm.phone = row.phone
      this.addressListForm.email = row.email
      this.addressListForm.departmentName = row.departmentName
      this.addressListForm.wechatAccount = row.wechatAccount
    },
    // 点击部门树的节点
    handleNodeClick(data) {
      this.listQuery.page = 1
      this.listQuery.departmentId = data.value
      this.initList()
    },
    // 获取所有部门列表
    getAllDepartment() {
      this.departmentListLoading = true
      api('oa/addressBook/getDeptTree').then(res => {
        if (res.data.code === '0000') {
          this.departmentList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.departmentListLoading = false
      })
    },
    // 切换部门树
    showDepartment() {
      this.title = !this.title
      this.isShow = !this.isShow
      if (!this.isShow) {
        this.listQuery.page = 1
        this.listQuery.departmentId = undefined
        this.initList()
      }
    },
    // 查询数据
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 初始化页面
    initList() {
      this.listLoading = true
      api('oa/addressBook/list', this.listQuery).then(res => {
        console.log(res)
        if (res.data.code === '0000') {
          this.addressList = res.data.data.rows
          this.total = res.data.data.total
          if (this.addressList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 分页数更改
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    }
  }
}
</script>

<style scoped lang="scss">
.el-row{

.el-form-item{
  margin-bottom: 0px;
}
}
.addressBook-content{
  display: flex;
  .addressBook-left{
          margin-top:15px;
    margin-right:30px;
  }
  .addressBook-right{
   flex: 1;
   width: 80%;
  }
}
.dialog-footer{
    text-align: center;
}
</style>
<style lang="scss">
.addressBook{
  .el-dialog{
    margin-top:8vh !important;
  }
  .el-input.is-disabled .el-input__inner{
    color:unset;
  }
}
</style>

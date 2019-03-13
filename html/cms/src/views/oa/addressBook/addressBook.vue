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
      <el-dialog :visible.sync="dialogFormVisible" title="通讯录详情" width="600px">
        <div class="userInfo">
          <div class="addressBook-top">
            <div class="userName">
              <span :style="`background:rgb${aaa}`">{{ addressListForm.lastName }}</span>
              <span>{{ addressListForm.name }}</span>
            </div>
            <div class="userContact">
              <div>联 系 方 式: <span>{{ addressListForm.phone }}</span></div>
              <div>邮 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;箱: <span>{{ addressListForm.email }}</span></div>
              <div>微&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 信: <span>{{ addressListForm.wechatAccount }}</span></div>
            </div>
          </div>
          <div v-for="(item, index) in userPosition" :key="index" class="userPosition">
            <div>部门: <span :class="index===0? 'defaultColor':''">{{ item.departmentName }}</span></div>
            <div>岗位: <span :class="index===0? 'defaultColor':''">{{ item.postName }}</span></div>
            <div>岗位类型: <span :class="index===0? 'defaultColor':''">{{ item.postTypeName }}</span></div>
          </div>
        </div>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import {
  api, paramApi
} from '@/api/oa/meetingManagement'
export default {

  data() {
    return {
      aaa: '',
      userPosition: [],
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
        lastName: '',
        name: '',
        phone: '',
        email: '',
        wechatAccount: ''
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
      this.aaa = this.randomColor()
      console.log(row)
      paramApi('oa/addressBook/getUserInfo', row.account, 'userAccount').then(res => {
        if (res.data.code === '0000') {
          this.dialogFormVisible = true
          if (res.data.data.name) {
            this.addressListForm.name = res.data.data.name
            this.addressListForm.lastName = res.data.data.name.charAt((res.data.data.name).length - 1)
          }
          console.log(this.addressListForm.lastName)
          if (res.data.data.sysDepartmentPostVO) {
            this.userPosition = res.data.data.sysDepartmentPostVO
          }
          this.addressListForm.phone = res.data.data.phone
          this.addressListForm.email = res.data.data.email
          // this.addressListForm.departmentName = row.departmentName
          this.addressListForm.wechatAccount = res.data.data.wechatAccount
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 点击部门树的节点
    handleNodeClick(data) {
      this.listQuery.page = 1
      this.listQuery.departmentId = data.value
      this.initList()
    },
    randomColor() { // rgb颜色随机
      var r = Math.floor(Math.random() * 256)
      var g = Math.floor(Math.random() * 256)
      var b = Math.floor(Math.random() * 256)
      var rgb = '(' + r + ',' + g + ',' + b + ')'
      return rgb
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
  .userInfo{
    padding:20px 30px;
  }
  .addressBook-top{
    display:flex;
    justify-content:space-between;
  }
  .userContact{
    margin-right:40px;
    >div{
    margin:15px 0px ;
    color:rgb(169,169,169);
    >span{
      color:black;
    }
    }
  }
  .userName span{
    color: black;
    font-size: 20px;
  }
  .userName span:nth-child(1){
    display: inline-block;
    width: 70px;
    height: 70px;
    text-align: center;
    border-radius: 50%;
    // background: aqua;
    line-height: 70px;
    color: #fff;
    font-size: 30px;
    margin-right: 15px;
  }
  .defaultColor{
    color:blueviolet !important;
  }
  .userPosition{
        display: flex;
    padding: 20px 0;
    flex: 1;
    >div{
      flex:1;
      color:rgb(169,169,169);
      >span{
        color:black;
      }
    }
  }
}
</style>

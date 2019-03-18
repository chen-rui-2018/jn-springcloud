<template>
  <div v-loading="listLoading" class="noticeManagement">
    <el-form :inline="true" :model="listQuery" class="filter-bar">
      <el-radio-group v-model="listQuery.recordStatus">
        <el-radio-button label="">全部</el-radio-button>
        <el-radio-button label= "1">有效</el-radio-button>
        <el-radio-button label="2">失效</el-radio-button>
      </el-radio-group>
      <el-form-item label="公告标题:" style="margin-left: 30px;" >
        <el-input v-model="listQuery.noticeTitle" maxlength="20" placeholder="请输入标题" class="filter-item" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="发布平台:" style="margin:0px 30px;">
        <el-select v-model="listQuery.platformType" placeholder="请选择平台类型" clearable class="filter-item">
          <el-option v-for="item in codeOptions" :key="item.Key" :label="item.lable" :value="item.key" />
        </el-select>
      </el-form-item>
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table :data="noticeList" border fit highlight-current-row style="width: 100%;height:100%;">
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column label="公告标题" align="center" prop="noticeTitle">
        <template slot-scope="scope">
          <el-button class="setCursor" type="text">{{ scope.row.noticeTitle }}</el-button>
        </template>
      </el-table-column>
      <el-table-column :show-overflow-tooltip="true" label="发布平台" align="center" prop="platformType">
        <template slot-scope="scope">
          <span>{{ disposePlatformType(JSON.parse(scope.row.platformType)) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="起止时间" min-width="180" align="center" prop="startAndEndTime"/>
      <el-table-column label="发布人" align="center" prop="creator"/>
      <el-table-column :show-overflow-tooltip="true" label="公告内容" align="center" prop="noticeContent">
        <template slot-scope="scope">
          <el-button type="text" @click="handlePreview(scope.row)">预览</el-button>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" min-width="120" prop="createdTime"/>
      <el-table-column label="状态" align="center" prop="recordStatus">
        <template slot-scope="scope">
          <span :class="scope.row.recordStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.recordStatus==1?'有效':'失效' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button type="text" @click="deletenotice(scope.row)">删除</el-button>
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
    <!-- S 新增弹窗 -->
    <template v-if="dialogFormVisible">
      <el-dialog :visible.sync="dialogFormVisible" title="公告内容" width="700px">
        <div class="editor-container">
          <UE ref="ue" :default-msg="defaultMsg" :config="config"/>
        </div>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import {
  api, getCode, paramApi
} from '@/api/oa/meetingManagement'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      dialogFormVisible: false,
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      dataList: [{ 'key': '1', 'value': '协同办公' }, { 'key': '2', 'value': '外部系统' }],
      noticeList: [],
      codeOptions: [],
      total: 0,
      listLoading: false,
      listQuery: {
        recordStatus: '',
        page: 1,
        rows: 10,
        noticeTitle: '',
        platformType: []
      },
      code: {
        groupCode: 'platform_type',
        moduleCode: 'springcloud-oa',
        parentGroupCode: 'notice'
      }
    }
  },
  mounted() {
    this.initList()
    this.getCode()
  },
  methods: {
    // 预览公告内容
    handlePreview(row) {
      this.dialogFormVisible = true
      this.defaultMsg = row.noticeContent
    },
    // 删除数据
    deletenotice(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi('oa/notice/delete', row.id, 'noticeId').then(res => {
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
    // 编辑数据
    handleUpdate(row) {
      this.$router.push({ name: 'editnoticeManagement', query: { title: '编辑公告', id: row.id }})
    },
    // 点击新增按钮的时候
    handleCreate() {
      this.$router.push({ name: 'addnoticeManagement', query: { title: '新增公告', workOrderNum: 'GGGL' }})
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
    // 初始化
    initList() {
      this.listLoading = true
      // this.listQuery.recordStatus = Number(this.listQuery.recordStatus)
      api('oa/notice/list', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.noticeList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    disposePlatformType(data) {
      const PlatformTypeArr = []
      data.forEach(val => {
        PlatformTypeArr.push(val.lable)
      })
      return PlatformTypeArr.join('、')
    },
    // // 改变状态
    // selecteCodeStatus(value) {
    //   console.log(value)
    //   this.listQuery.recordStatus = value
    // },
    // 获取平台类型
    getCode() {
      getCode(this.code).then(res => {
        if (res.data.code === '0000') {
          this.codeOptions = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss"  scoped>
.setCursor{
  cursor: auto;
}
    .el-pagination{
      margin-top:15px;
    }
</style>

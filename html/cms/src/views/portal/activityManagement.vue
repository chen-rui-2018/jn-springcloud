<template>
  <div v-loading="listLoading" class="activity">
    <el-row>
      <el-col :span="5"><div class="grid-content bg-purple">
        <el-radio-group v-model="listQuery.status">
          <el-radio-button label="">全部</el-radio-button>
          <el-radio-button label= "1">待发布</el-radio-button>
          <el-radio-button label="2">报名中</el-radio-button>
          <el-radio-button label="3">已结束</el-radio-button>
        </el-radio-group>
      </div></el-col>
      <el-col :span="5"><div class="grid-content bg-purple-light">
        <el-radio-group v-model="listQuery.isIndex">
          <el-radio-button label="">全部</el-radio-button>
          <el-radio-button label="1">首页展示</el-radio-button>
          <el-radio-button label="0">首页不展示</el-radio-button>
        </el-radio-group>
      </div></el-col>
      <el-col :span="14"><div class="grid-content bg-purple"><el-form :inline="true" :model="listQuery" class="filter-bar">
        <el-form-item label="类型">
          <el-select v-model="listQuery.actiType" placeholder="请选择类型" clearable class="filter-item" @change="selecteType">
            <el-option v-for="item in typeOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="名称">
          <el-input v-model="listQuery.actiName" maxlength="20" placeholder="请输入名称" class="filter-item" clearable />
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left: 10px;" icon="el-icon-plus" type="primary" @click="handleCreate">新增</el-button>
        <el-button type="primary" class="filter-item" @click="handleBatchDeleteActivity()">批量删除</el-button>
      </el-form></div></el-col>
    </el-row>
    <el-table :data="activityList" border fit highlight-current-row style="width: 100%;" @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="40"
      />
      <el-table-column label="序列" type="index" align="center" width="60"/>
      <el-table-column label="名称" prop="actiName" align="center" min-width="100" />
      <el-table-column label="类型" prop="typeName" align="center" min-width="100" />
      <el-table-column label="海报" prop="actiPosterUrl" align="center" min-width="150">
        <template slot-scope="scope">
          <img :src="scope.row.actiPosterUrl" alt="海报图片" style="width: 50px;height: 50px">
        </template>
      </el-table-column>
      <el-table-column label="活动时间" align="center" min-width="100">
        <template slot-scope="scope">
          <span>{{ scope.row.actiStartTime }}</span>-<span>{{ scope.row.actiEndTime.substr(-8) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="活动园区" prop="parkName" align="center" min-width="120" />
      <el-table-column label="地点" prop="actiAddress" align="center" min-width="120" />
      <el-table-column label="主办方" prop="actiOrganizer" align="center" min-width="100" />
      <el-table-column label="费用" prop="actiCost" align="center" min-width="85" />
      <el-table-column label="排序" prop="actiOrder" align="center" min-width="85" />
      <el-table-column label="是否展示报名人数" prop="showApplyNum" align="center" min-width="85">
        <template slot-scope="scope">
          <span v-if="scope.row.showApplyNum==='0'">--</span>
          <span v-if="scope.row.showApplyNum==='1'">是</span>
        </template>
      </el-table-column>
      <el-table-column label="首页展示" prop="isIndex" align="center" min-width="85">
        <template slot-scope="scope">
          <span v-if="scope.row.isIndex==='0'">--</span>
          <span v-if="scope.row.isIndex==='1'">是</span>
        </template>
      </el-table-column>
      <el-table-column label="感兴趣人数" prop="actiLike" align="center" min-width="85">
        <template slot-scope="scope">
          <span>{{ scope.row.actiLike }}人</span>
        </template>
      </el-table-column>
      <el-table-column label="活动人数" prop="actiNumber" align="center" min-width="85">
        <template slot-scope="scope">
          <span>{{ scope.row.actiNumber }}人</span>
        </template>
      </el-table-column>
      <el-table-column label="报名人数" prop="applyNum" align="center" min-width="85">
        <template slot-scope="scope">
          <span>{{ scope.row.applyNum }}人</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" prop="state" align="center" min-width="85">
        <template slot-scope="scope">
          <span v-if="scope.row.status==='1'">待发布</span>
          <span v-if="scope.row.status==='2'">报名中</span>
          <span v-if="scope.row.status==='3'|| scope.row.status==='4'|| scope.row.status==='5'">已结束</span>
        </template>
      </el-table-column>
      <el-table-column fit label="操作" align="center" width="auto" min-width="200">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.status==='1'|| scope.row.status==='2'"
            type="text"
            class="operation"
            @click="editDo(scope.row)">编辑
          </el-button>
          <el-button
            v-if="scope.row.status==='2'&& scope.row.isApply==='1'"
            type="text"
            class="operation"
            @click="cancelApply(scope.row)">停止报名
          </el-button>
          <el-button
            v-if="scope.row.status==='2'&& scope.row.isApply==='0'"
            type="text"
            class="operation"
            @click="recoverApply(scope.row)">恢复报名
          </el-button>
          <el-button
            v-if="scope.row.status==='2'"
            type="text"
            class="operation"
            @click="handleCancelActivity(scope.row)">取消活动
          </el-button>
          <el-button
            v-if="scope.row.status==='3'|| scope.row.status==='4'|| scope.row.status==='5'"
            type="text"
            class="operation"
            @click="editDo(scope.row)">查看
          </el-button>
          <el-button
            v-if="scope.row.status==='1'||scope.row.status==='3'|| scope.row.status==='4'|| scope.row.status==='5'"
            type="text"
            class="operation"
            @click="handleDeleteActivity(scope.row)">删除
          </el-button>
          <el-button
            v-if="scope.row.isSendMessage==='1'"
            type="text"
            class="operation"
            @click="handlePushMessage(scope.row)">推送
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[10,20,30,50]" :page-size="listQuery.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
  </div>
</template>

<script>
import {
  getActivityList, getActivityType, cancelActivity, deleteActivity, cancelApply, pushMessage
} from '@/api/portalManagement/activity'
export default {
  data() {
    return {
      checkActivity: [],
      selectionActivity: [],
      createTime: [],
      typeOptions: [],
      listLoading: false,
      activityList: [],
      total: 0,
      listQuery: {
        actiName: undefined,
        actiType: undefined,
        page: 1,
        rows: 10,
        status: undefined,
        isIndex: undefined
      }
    }
  },
  mounted() {
    this.initList()
    this.getActivityType()
  },
  methods: {
    // 推送消息
    handlePushMessage(row) {
      this.$confirm(`是否推送消息？`, '取消提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          pushMessage(row.id).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '推送消息成功',
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
    // 恢复报名
    recoverApply(row) {
      this.$confirm(`是否恢复报名？`, '取消提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          cancelApply({ activityId: row.id, status: '1' }).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '恢复报名成功',
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
    // 停止报名
    cancelApply(row) {
      console.log(row)
      this.$confirm(`是否停止报名？`, '取消提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          cancelApply({ activityId: row.id, status: '0' }).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '停止报名成功',
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
    // 批量删除
    handleBatchDeleteActivity() {
      if (this.checkActivity.length > 0) {
        this.$confirm(`是否删除这些活动？`, '取消提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        })
          .then(() => {
            deleteActivity(this.checkActivity).then(res => {
              if (res.data.code === '0000') {
                this.$message({
                  message: '删除成功',
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
      } else {
        alert('请选择要删除的活动')
      }
    },
    handleSelectionChange(val) {
      this.selectionActivity = val
      var checkId = []
      this.selectionActivity.forEach(val => {
        checkId.push(val.id)
      })
      this.checkActivity = checkId.join(',')
    },
    // 删除活动
    handleDeleteActivity(row) {
      console.log(row)
      this.$confirm(`是否删除此活动？`, '取消提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deleteActivity(row.id).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
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
    // 取消活动
    handleCancelActivity(row) {
      console.log(row)
      this.$confirm(`是否取消此活动？`, '取消提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          cancelActivity(row.id).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '取消成功',
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
    handleCreate() {
      this.$router.push({ name: 'activityAdd' })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    // 获取活动类型
    getActivityType() {
      getActivityType().then(res => {
        if (res.data.code === '0000') {
          res.data.data.rows.forEach(val => {
            this.typeOptions.push({
              value: val.typeId,
              label: val.typeName
            })
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 项目初始化
    initList() {
      this.listLoading = true
      getActivityList(this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.activityList = res.data.data.rows
          this.total = res.data.data.total
          if (this.activityList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    selecteType(value) {
      this.listQuery.actiType = value
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
 .el-button+.el-button{
       margin-left: 0px;
}
.el-button--medium{
         padding:10px;
}
.operation{
         padding:0px;
}
.el-radio-group{
  .el-radio-button--medium .el-radio-button__inner{
    padding: 10px;
  }
}
</style>

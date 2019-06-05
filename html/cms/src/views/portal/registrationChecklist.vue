<template>
  <div class="registrationChecklist">
    <el-row type="flex" justify="space-between">
      <el-col :span="18"/>
      <el-col :span="6">
        <div class="grid-content bg-purple-light">
          <el-button class="filter-item" type="primary" round @click="handleExport">导出Excel</el-button>
          <el-button class="filter-item" type="primary" round @click="handleReturn">返回</el-button>
        </div>
      </el-col>
    </el-row>
    <table cellspacing="0" cellpadding="10" style="border-collapse: collapse;width:100%">
      <thead>
        <tr>
          <template v-for="(i,k) in tableHeadArr">
            <th v-if="i.inputFlag" :key="k">
              <el-checkbox v-model="i.inputCheck">{{ i.name }}</el-checkbox>
            </th>
            <th v-else :key="k">{{ i.name }}</th>
          </template>
        </tr>
      </thead>
      <tbody class="write">
        <template v-for="(i,ky) in actiListData">
          <tr :key="ky">
            <td>{{ i.name }}</td>
            <td>{{ i.sex }}</td>
            <td>{{ i.age }}</td>
            <td>{{ i.company }}</td>
            <td>{{ i.post }}</td>
            <td>{{ i.phone }}</td>
            <!-- <td>
              <template>
                <span v-if="i.signStatus==='0'">未签到</span>
                <span v-if="i.signStatus==='1'">已签到</span>
              </template>
            </td> -->
            <td>
              <template>
                <el-button
                  type="text"
                  class="operation"
                  @click="handleSign(i.id)">允许报名
                </el-button>
              </template>
            </td>
          </tr>
        </template>
      </tbody>
    </table>
    <div class="pagination-container">
      <el-pagination :current-page="actiList.page" :page-sizes="[10, 20, 30, 40]" :page-size="actiList.rows" :total="total" layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <!-- 下载签到二维码弹框 -->
    <template v-if="signincodeDialogVisible">
      <el-dialog :visible.sync="signincodeDialogVisible" title="二维码签到" width="400px">
        <div class="erweima"><img :src="src" alt="二维码签到"></div>
      </el-dialog>
    </template>
  </div>
</template>
<script>
// import {
//   getApplyActivityList,
//   // downloadSignCodeImg,
//   signInActivityBackend,
//   exportDataExcel
// } from '@/api/portalManagement/activity'
import {
  api
} from '@/api/axios'
export default {
  data() {
    return {
      baseUrl: process.env.BASE_API,
      total: 0,
      signincodeDialogVisible: false,
      src: '',
      actiListData: [],
      arrFlag: ['', 'name', 'sex', 'age', 'company', 'post', 'phone'],
      actiList: {
        activityId: '',
        // exportColName: [],
        // exportTitle: [],
        page: 1,
        rows: 10,
        applyStatus: '2'
      },
      tableHeadArr: [
        {
          name: '姓名',
          inputFlag: true,
          inputCheck: false
        },
        {
          name: '姓别',
          inputFlag: true,
          inputCheck: false
        },
        {
          name: '年龄',
          inputFlag: true,
          inputCheck: false
        },
        {
          name: '公司名称',
          inputFlag: true,
          inputCheck: false
        },
        {
          name: '岗位',
          inputFlag: true,
          inputCheck: false
        },
        {
          name: '手机号',
          inputFlag: true,
          inputCheck: false
        },
        {
          name: '操作',
          inputFlag: false,
          inputCheck: false
        }
      ]
    }
  },
  mounted() {
    this.getApplyActivityList()
  },
  methods: {
    // 根据报名状态查询活动报名列表
    getApplyActivityList() {
      const data = {
        activityId: this.$route.query.activityId,
        applyStatus: '2',
        page: this.actiList.page,
        rows: this.actiList.rows
      }
      api(`${this.GLOBAL.parkUrl}activity/applyActivityListByApplyStatus?activityId=${data.activityId}&applyStatus=${data.applyStatus}&page=${data.page}&rows=${data.rows}`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.actiListData = res.data.data.rows
          this.total = res.data.data.total
        }
      })
    },
    // 分页数更改
    handleSizeChange(val) {
      this.actiList.rows = val
      this.getApplyActivityList()
    },
    handleCurrentChange(val) {
      this.actiList.page = val
      this.getApplyActivityList()
    },
    handleExport() {
      const exportColName = []
      const exportTitle = []
      for (const it in this.tableHeadArr) {
        if (this.tableHeadArr[it].inputCheck) {
          // exportColName.push(this.tableHeadArr[it].name)
          // exportTitle.push(this.arrFlag[it])
          exportTitle.push(this.tableHeadArr[it].name)
          exportColName.push(this.arrFlag[it])
        }
      }
      const data = {
        activityId: this.$route.params.id,
        exportColName: [exportColName.join(',')],
        exportTitle: [exportTitle.join(',')],
        page: this.actiList.page,
        rows: this.actiList.rows
      }
      api(`${this.GLOBAL.parkUrl}activity/exportDataExcel?activityId=${data.activityId}&exportColName=${data.exportColName}&exportTitle=${data.exportTitle}&page=${data.page}&rows=${data.rows}`, '', 'get').then(res => {
        window.location.href = res.request.responseURL
      })
    },
    handleReturn() {
      this.$router.push({ name: 'applyActivityList', params: { id: this.$route.params.activityId }})
    },
    // 报名审核接口
    handleSign(id) {
      const data = {
        applyId: id
      }
      api(`${this.GLOBAL.parkUrl}activity/activityApply/signInActivityCheck?applyId=${id}`, data, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.$message.success('审批完成')
          this.getApplyActivityList()
        } else {
          this.$message(res.data.result)
        }
      })
    }
  }
}
</script>
<style lang="scss" scoped>
.el-row{
  margin-bottom:10px
}
td{
    border:1px solid #ccc;
  }
table,table tr th{
  border:1px solid #a3d9f4;
  font-weight: normal;
  text-align: center
  }
  th{
    background-color: #e0f1fc;
  }
  .erweima{
    img{
      width: 100%;
      height: 100%;
    }
  }
</style>

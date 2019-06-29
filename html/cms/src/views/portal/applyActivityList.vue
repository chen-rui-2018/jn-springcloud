<template>
  <div class="actiList">
    <el-row type="flex" justify="space-between">
      <el-col :span="15"/>
      <el-col :span="9">
        <div class="grid-content bg-purple-light">
          <!-- <el-button class="filter-item" type="primary" round @click="ApproveApplicant">审批报名人</el-button> -->
          <el-button v-if="$route.query.applyCheck == '1'" class="filter-item" type="primary" round @click="ApproveApplicant">审批报名人</el-button>
          <el-button class="filter-item" type="primary" round @click="handleRegistration">下载签到二维码</el-button>
          <el-button class="filter-item" type="primary" round @click="handleExport">导出Excel</el-button>
          <el-button class="filter-item" type="primary" round @click="handleReturn">返回</el-button>
        </div>
      </el-col>
    </el-row>
    <!-- <el-table :data="actiListData" border fit highlight-current-row style="width: 100%">
      <el-table-column checkbox label="序列" type="index" align="center" width="60"/>
      <el-table-column prop="account" label="姓名" align="center" width="120" />
      <el-table-column prop="sex" label="性别" align="center" width="120" />
      <el-table-column prop="age" label="年龄" align="center"/>
      <el-table-column prop="company" label="公司名称" align="center"/>
      <el-table-column prop="post" label="岗位" align="center"/>
      <el-table-column prop="phone" label="手机号" align="center"/>
      <el-table-column label="状态" prop="applyStatus" align="center" min-width="85">
        <template slot-scope="scope">
          <span v-if="scope.row.applyStatus==='1'">未签到</span>
          <span v-if="scope.row.applyStatus==='2'">已签到</span>
          <span v-if="scope.row.applyStatus==='3'">未审批</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.applyStatus==='1'"
            type="text"
            class="operation"
            @click="handleSign(scope.row)">签到
          </el-button>
          <el-button
            v-if="scope.row.applyStatus==='2'"
            type="text"
            class="operation"
            @click="handleSign(scope.row)"/>
          <el-button
            v-if="scope.row.applyStatus==='3'"
            type="text"
            class="operation"
            @click="handleAllowSign(scope.row)">允许报名
          </el-button>
        </template>
      </el-table-column>
    </el-table> -->
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
            <td>{{ ky+1 }}</td>
            <td>{{ i.name }}</td>
            <td><span v-if="i.sex=='0'">女</span><span v-if="i.sex=='1'">男</span></td>
            <td>{{ i.age }}</td>
            <td>{{ i.company }}</td>
            <td>{{ i.post }}</td>
            <td>{{ i.phone }}</td>
            <td>
              <template>
                <span v-if="i.signStatus==='0'">未签到</span>
                <span v-if="i.signStatus==='1'">已签到</span>
              </template>
            </td>
            <td>
              <template>
                <el-button
                  v-if="i.signStatus==='0'"
                  type="text"
                  class="operation"
                  @click="handleSign(i.id)">签到
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
        exportColName: [],
        exportTitle: [],
        page: 1,
        rows: 10,
        applyStatus: '1'
      },
      tableHeadArr: [
        {
          name: '序列',
          inputFlag: false,
          inputCheck: false
        },
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
          name: '状态',
          inputFlag: false,
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
    ApproveApplicant() {
      this.$router.push({ path: `registrationChecklist`, query: { activityId: this.$route.query.id }})
    },
    getApplyActivityList() {
      this.actiList.activityId = this.$route.query.id
      api(`${this.GLOBAL.parkUrl}activity/applyActivityList`, this.actiList, 'post').then(res => {
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
    handleRegistration() {
      this.signincodeDialogVisible = true
      // console.log(`${this.baseUrl}${this.GLOBAL.parkUrl}activity/downloadSignCodeImg?activityId=${this.$route.params.id}`)
      this.src = `${this.baseUrl}${this.GLOBAL.parkUrl}activity/downloadSignCodeImg?activityId=${this.$route.query.id}`
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
      this.$router.push({ name: 'activityManagement', params: { id: this.$route.params.id }})
    },
    handleSign(id) {
      const data = {
        applyId: id
      }
      api(`${this.GLOBAL.parkUrl}activity/activityApply/signInActivityBackend?applyId=${id}`, data, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.getApplyActivityList()
          this.$message.success('签到成功')
        } else {
          this.$message(res.data.result)
        }
      })
    },
    handleAllowSign(i) {}
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

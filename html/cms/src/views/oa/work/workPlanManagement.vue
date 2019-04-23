<template>
  <div
    v-loading="listLoading"
    class="workManagement"
  >
    <el-form
      :inline="true"
      :model="listQuery"
      class="filter-bar"
    >
      <el-radio-group
        v-model="workPlanStatus"
        @change="checkWorkStatus"
      >
        <el-radio-button label="">全部</el-radio-button>
        <el-radio-button label="0">未开始</el-radio-button>
        <el-radio-button label="1">进行中</el-radio-button>
        <el-radio-button label="2">已暂停</el-radio-button>
        <el-radio-button label="3">已完成</el-radio-button>
      </el-radio-group>
      <!---->
      <el-select
        v-model="workStatus"
        clearable
        class="setWidth"
        placeholder="更多"
        @change="checkStatus"
      >
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
          clearable
        />
      </el-select>
      <el-form-item
        label="任务名称:"
        class="workPlanName"
        min-width="60"
      >
        <el-input
          v-model="listQuery.workPlanName"
          placeholder="请输入名称"
          class="filter-item"
          clearable
          @keyup.enter.native="handleFilter"
        />
      </el-form-item>
      <el-form-item label="项目:">
        <el-select
          v-model="listQuery.itemId"
          clearable
          placeholder="请选择项目"
        >
          <el-option
            v-for="item in itemOptions"
            :key="item.id"
            :label="item.itemName"
            :value="item.id"
          />
        </el-select>
      </el-form-item>

      <el-button
        class="filter-item"
        type="primary"
        icon="el-icon-search"
        @click="handleFilter"
      >查询</el-button>
      <el-button
        class="filter-item"
        type="primary"
        icon="el-icon-plus"
        @click="handleCreate"
      >新增</el-button>
      <el-button
        class="filter-item"
        type="primary"
        @click="tolead"
      >导入</el-button>
      <el-button
        class="filter-item"
        type="primary"
        @click="exportText"
      >导出</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table
      :data="workList"
      border
      fit
      highlight-current-row
      style="width: 100%"
    >
      <el-table-column
        type="index"
        width="60"
        label="序号"
        align="center"
      />
      <el-table-column
        :show-overflow-tooltip="true"
        label="项目名称"
        align="center"
        prop="itemName"
        width="100"
      >
        <template slot-scope="scope">
          {{ scope.row.itemName }}
        </template>
      </el-table-column>
      <el-table-column
        :show-overflow-tooltip="true"
        label="任务名称"
        width="100"
        align="center"
        prop="workPlanName"
      >
        <template slot-scope="scope">
          <el-button type="text" @click="handleDetails(scope.row)">{{ scope.row.workPlanName }}</el-button>
        </template>
      </el-table-column>
      <el-table-column
        label="开始时间"
        align="center"
        prop="planStartTime"
      >
        <!-- <template slot-scope="scope">
          <span :class="scope.row.signInAttendanceTime?'':'text-red'">{{ scope.row.signInAttendanceTime?scope.row.signInAttendanceTime:'未签到' }}</span>
        </template> -->
      </el-table-column>
      <el-table-column
        label="截止时间"
        align="center"
        prop="planEndTime"
      >
        <template slot-scope="scope">
          <span :class="scope.row.isExpire==='0'?'':'planEndStyle'">{{ scope.row.planEndTime }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="任务状态"
        align="center"
        prop="workPlanStatusMessage"
      >
        <template slot-scope="scope">
          <span v-if="scope.row.workPlanStatusMessage==='未开始'" >未开始</span>
          <span v-if="scope.row.workPlanStatusMessage==='进行中'" class="text-red" >进行中</span>
          <span v-if="scope.row.workPlanStatusMessage==='已暂停'" style="color:rgb(248, 180, 102)" >已暂停</span>
          <span v-if="scope.row.workPlanStatusMessage==='已完成'" class="text-green" >已完成</span>
        </template>
      </el-table-column>
      <el-table-column
        label="负责人"
        align="center"
        prop="responsibleUserName"
      />
      <el-table-column
        label="预计 (小时)"
        align="center"
        prop="planTime"
      />
      <el-table-column
        label="消耗 (小时)"
        align="center"
        prop="totalConsumeTime"
      />
      <el-table-column
        label="剩余 (小时)"
        align="center"
        prop="totalRemainTime"
      />
      <el-table-column
        label="操作"
        align="center"
        min-width="180"
      >
        <template slot-scope="scope">
          <el-button
            :disabled="scope.row.workPlanStatus!=='0'"
            type="text"
            @click="startWork(scope.row)"
          >开始 </el-button>
          <el-button
            :disabled="scope.row.workPlanStatus==='2'||scope.row.workPlanStatus==='3'"
            type="text"
            @click="pauseWork(scope.row)"
          >暂停 </el-button>
          <el-button
            :disabled="scope.row.workPlanStatus==='3'"
            type="text"
            @click="handlEdit(scope.row)"
          >编辑</el-button>
          <el-button
            :disabled="scope.row.workPlanStatus==='3'"
            type="text"
            @click="completeWork(scope.row)"
          >完成</el-button>
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
      style="margin-top:15px;"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
    <!-- 点击导入按钮的弹框 -->
    <template v-if="dialogVisible">
      <el-dialog
        :visible.sync="dialogVisible"
        title="导入"
        class="daoru"
      >
        <div
          style="display:flex;justify-content: space-between;"
          class="demo"
        >
          <el-button
            :disabled="disabled"
            type="success"
            @click="submit($event)"
          >导入文件</el-button>
          <a
            href="/static/file/workplanTemplate.xlsx"
            class="download"
          >下载模板</a>
        </div>
        <!-- <div>
          <p>注意:</p>
          <p>请先导出模板，并按照模板填入批量数据，保存后点击上传即可</p>
        </div> -->
        <div style="margin-top:30px;">
          <input
            type="file"
            @change="getFile($event)"
          >
        </div>
      </el-dialog>
    </template>
    <!-- 点击开始按钮的弹框 -->
    <template v-if="startdialogVisible">
      <el-dialog
        :visible.sync="startdialogVisible"
        :title=" workPlanName+' > '+ titleText"
        class="workContent"
      >
        <el-form
          id="startWork"
          ref="workform"
          :model="workform"
          label-width="80px"
          size="mini"
        >
          <el-form-item v-if="titleText==='开始'" label="实际开始">
            <el-date-picker
              v-model="workform.startTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
            />
          </el-form-item>
          <el-form-item v-show="titleText==='完成'" label="已消耗">
            <span>{{ workform.totalConsumeTime }}工时</span>
          </el-form-item>
          <el-form-item v-show="titleText==='开始'||titleText==='完成'" label="总消耗">
            <el-input v-model="workform.totalConsumeTime">
              <template slot="append">小时</template>
            </el-input>
          </el-form-item>
          <el-form-item v-if="titleText==='完成'" label="完成时间">
            <el-date-picker
              v-model="workform.endTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
            />
          </el-form-item>
          <el-form-item v-show="titleText==='开始'" label="预计剩余">
            <el-input v-model="workform.totalRemainTime">
              <template slot="append">小时</template>
            </el-input>
          </el-form-item>
          <el-form-item v-show="titleText==='完成'" label="附件(50M)" class="accessory">
            <el-upload
              :on-error="handleError"
              :headers="{token: $store.getters.token}"
              :on-remove="handleRemove"
              :before-upload="beforeUpload"
              :on-success="uploadDone"
              :on-exceed="handleExceed"
              :limit="1"
              :action="baseUrl+'zuul/'+oaUrl+'oa/common/uploadAttachment'">
              <el-button size="small" type="primary">选择文件</el-button>
              <div slot="tip" class="el-upload__tip">附件大小不能超过50M</div>
            </el-upload>

          </el-form-item>
          <el-form-item
            label="备注"
            class="beizhu"
          >
            <UE
              ref="ue"
              :default-msg="defaultMsg"
              :config="config"
            />
          </el-form-item>
          <el-form-item class="start">
            <span @click="submitStatus()">{{ titleText }}</span>
          </el-form-item>
        </el-form>
        <fieldset class="fieldest">
          <legend> <strong>历史记录</strong><a
            v-show="unbtn"
            href="javascript:;"
            class="history_a"
            @click="unfoldText"
          > <i class="iconfont">&#xe636;</i></a>
            <a
              v-show="!unbtn"
              href="javascript:;"
              class="history_a"
              @click="unfoldText"
            > <i class="iconfont">&#xe608;</i></a>
          </legend>
          <ul
            v-show="history.length>0"
            style="margin:unset;padding:unset"
          >
            <li
              v-for="(item,index) in history"
              :key="index"
            >
              <span v-html="(index+1)+'.  '+item.operateRecode +'' ">{{ (index+1)+'. '+ item.operateRecode }}
              </span>
              <span > <a v-show="unbtn" href="javascript:;" class="history_a" @click="unfoldText">
                <i class="iconfont">&#xe636;</i>
              </a>
                <a v-show="!unbtn" href="javascript:;" class="history_a" @click="unfoldText" >
                  <i class="iconfont">&#xe608;</i>
              </a></span>
              <div
                class="historyInfo"
              >
                <div v-show="unfold" v-html="item.operateDetails">{{ item.operateDetails }}</div>
                <div v-html="item.remark">{{ item.remark }}</div>
              </div>
            </li>
          </ul>
        </fieldset>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import { api, Inventor } from '@/api/axios'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      workPlanName: '',
      oaUrl: this.GLOBAL.oaUrl,
      baseUrl: process.env.BASE_API,
      titleText: '',
      unbtn: true,
      unfold: false,
      history: [],
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 150
      },
      workform: {
        startTime: '',
        totalConsumeTime: '',
        totalRemainTime: '',
        content: '',
        id: '',
        workPlanStatus: '',
        attachment: '',
        endTime: ''
      },
      startdialogVisible: false,
      disabled: false,
      // oaUrl: this.GLOBAL.oaUrl,
      // baseUrl: process.env.BASE_API,
      file: '',
      dialogVisible: false,
      workList: [],
      itemOptions: [],
      workStatus: '',
      options: [
        {
          value: '4',
          label: '已延期'
        },
        {
          value: 'myTask',
          label: '我的任务'
        },
        {
          value: 'myComplete',
          label: '我完成'
        }
      ],
      account: '',
      workPlanStatus: '',
      userAccount: '',
      total: 0,
      meetingList: [],
      listLoading: false,
      listQuery: {
        itemId: '',
        workPlanName: '',
        page: 1,
        rows: 10
      }
    }
  },
  mounted() {
    this.getUserInfo()
    this.getItem()
    this.initList()
  },
  methods: {
    handleDetails(row) {
      this.$router.push({ name: 'workPlanDetails', query: {
        id: row.id
      }})
    },
    handlEdit(row) {
      this.$router.push({ name: 'editWorkPlan', query: {
        id: row.id
      }})
    },
    // 上传成功
    uploadDone(res, file, fileList) {
      this.workform.attachment = res.data
    },
    // 删除
    handleRemove(file, fileList) {
      this.workform.attachment = ''
    },
    // 上传失败
    handleError(e) {
      this.$message.error('上传文件失败!')
    },
    // 上传限制
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传1个附件`)
    },
    // 上传之前
    beforeUpload(file) {
      if (file.size / 1024 / 1024 > 50) {
        this.$message.warning('附件大小不能超过50M')
        return false
      }
    },
    // 获取时间
    getDate() {
      var date = new Date()
      var sign1 = '-'
      var sign2 = ':'
      var year = date.getFullYear() // 年
      var month = date.getMonth() + 1 // 月
      var day = date.getDate() // 日
      var hour = date.getHours() // 时
      var minutes = date.getMinutes() // 分
      var seconds = date.getSeconds() // 秒
      // 给一位数数据前面加 “0”
      if (month >= 1 && month <= 9) {
        month = '0' + month
      }
      if (day >= 0 && day <= 9) {
        day = '0' + day
      }
      if (hour >= 0 && hour <= 9) {
        hour = '0' + hour
      }
      if (minutes >= 0 && minutes <= 9) {
        minutes = '0' + minutes
      }
      if (seconds >= 0 && seconds <= 9) {
        seconds = '0' + seconds
      }
      var currentTime = year + sign1 + month + sign1 + day + ' ' + hour + sign2 + minutes + sign2 + seconds
      return currentTime
    },
    // 点击完成的弹框
    completeWork(row) {
      this.workform.endTime = this.getDate()
      this.titleText = '完成'
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/getWorkPlanById?workPlanId=${row.id}`,
        '',
        'get'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.history = res.data.data.workPlanHistorys
          this.workform.id = res.data.data.id
          // if (res.data.data.content) {
          //   this.defaultMsg = res.data.data.content
          // }
          this.workform.totalConsumeTime = res.data.data.totalConsumeTime
        } else {
          this.$message.error(res.data.result)
        }
      })
      this.startdialogVisible = true
    },
    //  暂停的提交
    // submitPause() {
    //   this.workform.workPlanStatus = '2'
    //   this.workform.Uecontent = this.$refs.ue.getUEContent()
    //   api(
    //     `${this.GLOBAL.oaUrl}oa/workPlan/updateWorkPlanStatus`,
    //     this.workform,
    //     'post'
    //   ).then(res => {
    //     if (res.data.code === this.GLOBAL.code) {
    //       this.workform.workPlanStatus = ''
    //       this.startdialogVisible = false
    //       this.initList()
    //     } else {
    //       this.$message.error(res.data.result)
    //     }
    //   })
    // },
    // 点击暂停的弹框
    pauseWork(row) {
      this.titleText = '暂停'
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/getWorkPlanById?workPlanId=${row.id}`,
        '',
        'get'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.history = res.data.data.workPlanHistorys
          this.workform.id = res.data.data.id
          this.workPlanName = res.data.data.workPlanName
          // if (res.data.data.content) {
          //   this.defaultMsg = res.data.data.content
          // }
        } else {
          this.$message.error(res.data.result)
        }
      })
      this.startdialogVisible = true
      // this.defaultMsg=row.
    },
    // 点击开始的提交
    submitStatus() {
      if (this.titleText === '开始') {
        this.workform.workPlanStatus = '1'
      } else if (this.titleText === '暂停') {
        this.workform.workPlanStatus = '2'
      } else if (this.titleText === '完成') {
        this.workform.workPlanStatus = '3'
      }
      this.workform.remark = this.$refs.ue.getUEContent()
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/updateWorkPlanStatus`,
        this.workform,
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.workform.workPlanStatus = ''
          this.startdialogVisible = false
          this.initList()
        }
      })
    },
    // 点击展开和收起
    unfoldText() {
      this.unbtn = !this.unbtn
      this.unfold = !this.unfold
    },
    // 点击开始弹框
    startWork(row) {
      this.titleText = '开始'
      this.unbtn = true
      this.workform.startTime = this.getDate()
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/getWorkPlanById?workPlanId=${row.id}`,
        '',
        'get'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.history = res.data.data.workPlanHistorys
          this.workPlanName = res.data.data.workPlanName
          this.workform.totalConsumeTime = res.data.data.totalConsumeTime
          this.workform.totalRemainTime = res.data.data.totalRemainTime
          this.workform.id = res.data.data.id
          this.workform.workPlanStatus = res.data.data.workPlanStatus
          // if (res.data.data.content) {
          //   this.defaultMsg = res.data.data.content
          // }
        } else {
          this.$message.error(res.data.result)
        }
      })
      this.startdialogVisible = true
    },
    // 新增操作
    handleCreate() {
      this.$router.push({ name: 'addWorkPlan' })
    },
    // 选择状态
    checkWorkStatus(val) {
      this.workStatus = ''
      this.userAccount = ''
      this.workPlanStatus = val
      this.initList()
    },
    // 选择更多里面的状态
    checkStatus(val) {
      this.workPlanStatus = ''
      if (val === '4') {
        this.userAccount = ''
        this.workPlanStatus = '4'
        this.initList()
      } else if (val === 'myTask') {
        this.userAccount = this.account
        this.initList()
      } else if (val === 'myComplete') {
        this.userAccount = this.account
        this.workPlanStatus = '3'
        this.initList()
      } else {
        this.userAccount = ''
        this.workPlanStatus = ''
      }
    },
    getFile: function(event) {
      this.file = event.target.files[0]
    },
    submit: function(event) {
      if (this.file === '' || this.file === undefined) {
        this.$message({
          message: '请先选择文件',
          type: 'error'
        })
        return false
      }
      if (this.file.name.substr(this.file.name.lastIndexOf('.')) !== '.xlsx') {
        this.$message({
          message: '文件格式错误,请选择模板文件',
          type: 'error'
        })
        return false
      }
      this.listLoading = true
      this.newArr = []
      const formData = new FormData()
      formData.append('file', this.file)
      // 调用导入文件接口
      Inventor(
        `zuul/${this.GLOBAL.oaUrl}oa/workPlan/importExcelWorkPlanInfo`,
        formData,
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.dialogVisible = false
        } else {
          this.$message.error('导入失败,' + res.data.result)
        }
        this.listLoading = false
        this.disabled = false
        // this.initList()
      })
    },
    //   点击导入
    tolead() {
      this.dialogVisible = true
    },
    // 导出
    exportText() {
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/exportExcelWorkPlanInfo?itemId=${
          this.listQuery.itemId
        }&workPlanName=${
          this.listQuery.workPlanName
        }&workPlanStatus=${this.workPlanStatus}`,
        '',
        'get'
      ).then(res => {
        window.location.href = res.request.responseURL
        // this.$router.push({ name: 'editWorkPlan' })
      })
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
    // 初始化页面表格数据
    initList() {
      this.listLoading = true
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/list?itemId=${
          this.listQuery.itemId
        }&page=${this.listQuery.page}&rows=${this.listQuery.rows}&userAccount=${
          this.userAccount
        }&workPlanName=${this.listQuery.workPlanName}&workPlanStatus=${
          this.workPlanStatus
        }`,
        '',
        'get'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.workList = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 获取登陆用户信息
    getUserInfo() {
      api(
        `${this.GLOBAL.systemUrl}system/sysUser/getUserInfo`,
        '',
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.account = res.data.data.account
        }
      })
    },
    //  获取项目
    getItem() {
      api(`${this.GLOBAL.oaUrl}oa/workPlan/getItemAll`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.itemOptions = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss" >
.planEndStyle{
  color:#fff;
  background: rgb(232, 78, 15);
  padding: 5px;
}
.el-tooltip__popper{
   text-align: center;
    max-width: 260px;
    word-break: break-all;
}
.daoru {
  .el-dialog {
    width: 400px;
  }
  .el-dialog__body {
    padding: 20px 30px 30px 30px;
    color: #141414 !important;
    font-size: 13px;
  }
}

.historyInfo {
  background: #fbfbfb;
  padding: 4px 10px 6px;
  min-height: 20px;
  margin-left: 20px;
  border: 1px solid #f5f5f5;
}
.workManagement{
.fieldest {
  border: 1px solid #e5e5e5;
  margin-top: 15px;
  padding: 10px 15px 15px;
  legend {
    width: auto;
    margin: 0 0 0 -5px;
    font-size: 13px;
    font-weight: bold;
    border-bottom: 0;
    padding: 0 5px;
    color: #333;
  }
  .history_a {
    background: #f1f1f1;
    color: #666 !important;
    //  border: 1px solid #ccc;
    margin-left:4px;
    padding: 2px;
    /* height: 18px; */
   line-height: 16px;
    width: 18px;
    > i {
      border-radius: 2px;
      display: inline-block;
      // width: 20px;
      // border: 0;
      // background: 0;
      // padding: 0;
      // color: #4d90fe!important;
      text-align: center;
    }
  }
}
}
.workContent{
.el-dialog{
    margin-top:8vh!important;
      height: 600px;
      overflow: auto;
    }
}
#startWork {
  .start {
    .el-form-item__content {
      width: auto !important;
    }
    span {
      display: inline-block;
      padding: 5px 10px;
      font-size: 12px;
      background: rgb(26, 78, 133);
      color: #fff;
      cursor: pointer;
    }
  }
  .el-form-item__content {
    width: 220px ;
  }
  .accessory{
    .accessoryStyle{
      border:1px solid #ccc;height:28px;line-height:28px;padding-left:5px;display: inline-block;
      margin:5px 0px;
     input{
        outline: none;
        border: none;
      }
    }
    .el-form-item__content {
    width: 100%;
  }
  }
  .el-form-item--mini.el-form-item,
  .el-form-item--small.el-form-item {
    margin-bottom: 10px;
  }
  .el-form-item--mini .el-form-item__content,
  .el-form-item--mini .el-form-item__label {
    line-height: 20px;
  }
}
.beizhu {
  .el-form-item__content {
    width: 80% !important;
  }
}
.workManagement {
  .el-dialog__body {
    color: #141414 !important;
    font-size: 13px;
    padding: 0px 20px 20px 20px;
  }
  .el-dialog__title {
    line-height: 24px;
    font-size: 15px;
    color: black;
    font-weight: 600;
  }
  .el-radio-button--medium .el-radio-button__inner {
    padding: 10px;
  }
  .setWidth {
    input::-webkit-input-placeholder,
    textarea::-webkit-input-placeholder {
      color: #606266;
      font-size: 14px;
    }

    input:-moz-placeholder,
    textarea:-moz-placeholder {
      color: #606266;
      font-size: 14px;
    }

    input::-moz-placeholder,
    textarea::-moz-placeholder {
      color: #606266;
      font-size: 14px;
    }

    input:-ms-input-placeholder,
    textarea:-ms-input-placeholder {
      color: #606266;
      font-size: 14px;
    }
    .el-input--medium .el-input__inner {
      width: 100px;
    }
  }
  .el-select .el-input__inner {
    padding-right: unset;
  }
}
</style>

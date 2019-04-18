<template>
  <div class="workPlanDetails write">
    <h3>{{ workForm.workPlanName }}</h3>
    <div class="editWorkPlan-content">
      <div class="editWorkPlan-left">
        <el-form
          ref="workForm"
          :model="workForm"
          label-width="100px"
          size="mini"
        >
          <div
            class=""
            style="margin-left:15px;font-size: 17px;"
          >基本信息:</div>
          <el-form-item label="任务名称:" prop="workPlanName">
            <span>{{ workForm.workPlanName }}</span>
            <!-- <el-input
              v-model="workForm.workPlanName"
              placeholder="请输入任务名称"
            /> -->
          </el-form-item>
          <el-form-item label="所属项目:">
            <span>{{ workForm.itemName }}</span>
            <!-- <el-select
              v-model="workForm.itemId"
              clearable
              placeholder="请选择项目"
            >
              <el-option
                v-for="item in itemOptions"
                :key="item.id"
                :label="item.itemName"
                :value="item.id"
              />
            </el-select> -->
          </el-form-item>
          <el-form-item label="负责人:">
            <span>{{ workForm.responsibleUserAccount }}</span>
            <!-- <el-select
              v-model="userAccount"
              multiple
              style="width: 100%;"
              clearable
              filterable
              placeholder="请选择负责人"
            >
              <el-option
                v-for="item in userOptions"
                :key="item.userId"
                :label="item.name"
                :value="item.account"
              />
            </el-select> -->
          </el-form-item>
          <el-form-item label="任务状态:" prop="workPlanStatus">
            <span v-show="workForm.workPlanStatus==='0'">未开始</span>
            <span v-show="workForm.workPlanStatus==='1'">进行中</span>
            <span v-show="workForm.workPlanStatus==='2'">已暂停</span>
            <span v-show="workForm.workPlanStatus==='3'">已完成</span>
            <!-- <el-select
              v-model="workForm.workPlanStatus"
              style="width: 100%;"
              clearable
              placeholder="请选择任务状态"
            >
              <el-option
                v-for="item in statusOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              />
            </el-select> -->
          </el-form-item>
          <div style="margin-left:15px;margin-top:20px; font-size: 17px;">工时信息:</div>
          <el-form-item label="预计开始:" prop="planStartTime">
            <span>{{ workForm.planStartTime }}</span>
            <!-- <el-date-picker
              v-model="workForm.planStartTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
              style="width: 100%;"
            /> -->
          </el-form-item>
          <el-form-item label="截止时间:" prop="planEndTime">
            <span>{{ workForm.planEndTime }}</span>
            <!-- <el-date-picker
              v-model="workForm.planEndTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
              style="width: 100%;"
            /> -->
          </el-form-item>
          <el-form-item label="实际开始:">
            <span>{{ workForm.startTime }}</span>
            <!-- <el-date-picker
              v-model="workForm.startTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
              style="width: 100%;"
            /> -->
          </el-form-item>
          <el-form-item label="实际结束:">
            <span>{{ workForm.endTime }}</span>
            <!-- <el-date-picker
              v-model="workForm.endTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
              style="width: 100%;"
            /> -->
          </el-form-item>
          <el-form-item label="预计工时:" prop="planTime">
            <span>{{ workForm.planTime }}工时</span>
            <!-- <el-input v-model="workForm.planTime"><template slot="append">小时</template></el-input> -->
          </el-form-item>
          <el-form-item label="总消耗:" prop="totalConsumeTime">
            <span>{{ workForm.totalConsumeTime }}工时</span>
            <!-- <el-input v-model="workForm.totalConsumeTime"><template slot="append">小时</template></el-input> -->
          </el-form-item>
          <el-form-item label="剩余工时:" prop="totalRemainTime">
            <span>{{ workForm.totalRemainTime }}工时</span>
            <!-- <el-input v-model="workForm.totalRemainTime"><template slot="append">小时</template></el-input> -->
          </el-form-item>
        </el-form>
      </div>
      <div class="editWorkPlan-right">
        <fieldset class="fieldest">
          <legend><strong>任务描述</strong></legend>
          <div class="editor-container" v-html="workForm.Uecontent">
            <!-- <UE
              ref="ue"
              :default-msg="defaultMsg"
              :config="config"
            /> -->
          </div>
        </fieldset>
        <fieldset class="fieldest">
          <legend><strong>需求描述</strong></legend>
          <div v-html="workForm.demandDescribe"/>
          <!-- <el-input
            v-model="workForm.demandDescribe"
            placeholder="请输入需求描述"
            type="textarea"
          /> -->
        </fieldset>
        <fieldset class="fieldest">
          <legend>附件</legend>
          <ul v-show="attachment.length>0" style="margin:unset;padding:unset">
            <li v-for="(item,index) in attachment" :key="index" style="margin: 5px 0px;"><a href="javascript:;" download="" @click="download(item)"> <i class="fa fa-file-text-o"/> {{ item.title }}</a></li>
          </ul>

        </fieldset>
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
              <span> <a
                v-show="unbtn"
                href="javascript:;"
                class="history_a"
                @click="unfoldText"
              >
                <i class="iconfont">&#xe636;</i>
              </a>
                <a
                  v-show="!unbtn"
                  href="javascript:;"
                  class="history_a"
                  @click="unfoldText"
                >
                  <i class="iconfont">&#xe608;</i>
              </a></span>
              <div class="historyInfo">
                <div
                  v-show="unfold"
                  v-html="item.operateDetails"
                >{{ item.operateDetails }}</div>
                <div v-html="item.remark">{{ item.remark }}</div>
              </div>
            </li>
          </ul>
        </fieldset>
        <div class="footer">
          <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="jobLogging"><i class="iconfont">&#xe612;</i> 工作记录</a>
          <a v-show="workForm.workPlanStatus==='0'" href="javascript:;" @click="handleStart"><i class="iconfont">&#xe642;</i> 开始</a>
          <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="handlePasue"><i class="iconfont">&#xe61f;</i>{{ statusText }}</a>
          <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="handleComplete"><i class="iconfont">&#xe68b;</i> 完成</a>
          <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="handleDelete"><i class="iconfont">&#xe716;</i> 删除</a>
          <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="isShowRemark = true"><i class="iconfont">&#xe61e;</i> 备注</a>
          <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="handleEdit"><i class="iconfont">&#xe795;</i> 编辑</a>
          <a href="javascript:;" @click="goBack($route)"><i class="iconfont">&#xe641;</i> 返回</a>
        </div>
        <fieldset v-if="isShowRemark" class="fieldest">
          <legend>备注</legend>

          <UE
            ref="ue"
            :default-msg="defaultMsg"
            :config="config"
          />
          <div class="remark-btn">
            <el-button size="mini" class="submitRemark" @click="submitRemark" >保存</el-button>
            <el-button size="mini" @click="isShowRemark=false" >返回</el-button>
          </div>
        </fieldset>

      </div>
    </div>
    <!-- 编辑工时记录的弹框 -->
    <template v-if="recordDialogVisible">
      <el-dialog :visible.sync="recordDialogVisible" title="编辑工时  >" width="700px">
        <el-form ref="recordForm" :model="recordForm" :rules="rules" class="recordForm" label-width="100px">
          <el-form-item label="日期" prop="recordDate">
            <el-date-picker v-model="recordForm.recordDate" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"/>
          </el-form-item>
          <el-form-item label="工时" prop="consumeTime">
            <el-input v-model="recordForm.consumeTime"/>
          </el-form-item>
          <el-form-item label="预计剩余" prop="remainTime">
            <el-input v-model="recordForm.remainTime"/>
          </el-form-item>
          <el-form-item label="活动形式" >
            <el-input v-model="recordForm.remark" type="textarea"/>
          </el-form-item>
          <el-form-item>
            <el-button :disabled="isDisabled" type="primary" @click="submitRecord('recordForm')">保存</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </template>
    <!-- 点击工作记录的弹框 -->
    <template v-if="jobLoggingDialogVisible">
      <el-dialog
        :visible.sync="jobLoggingDialogVisible"
        width="800px"
      >
        <div class="record">
          <div class="record-title">{{ workForm.workPlanName }}&nbsp;&nbsp;<span>></span>&nbsp;&nbsp; 记录工时</div>
          <el-table v-show="historyData.length>0" :data="historyData" :header-cell-style="{background:'rgb(242, 242, 242)'}" style="width: 100%">
            <el-table-column label="序列" type="index" width="60" align="center"/>
            <el-table-column label="日期" width="230" align="center" prop="recordDate"/>
            <el-table-column label="工时" width="80" align="center" prop="consumeTime"/>
            <el-table-column label="剩余" width="80" align="center" prop="remainTime"/>
            <el-table-column label="备注" align="center" prop="remark" />
            <el-table-column fit label="操作" align="center" width="80">
              <template slot-scope="scope">
                <el-button type="text" size="mini" icon="el-icon-edit" @click="handleRecord(scope.row)" />
                <el-button type="text" size="mini" icon="el-icon-close" @click="handleDelRecord(scope.row)"/>
              </template>
            </el-table-column>
          </el-table>
          <el-table :data="timeData" :header-cell-style="{background:'rgb(242, 242, 242)'}" style="width: 100%">
            <el-table-column label="序列" type="index" width="60" align="center"/>
            <el-table-column label="日期" align="center" width="230">
              <template slot-scope="scope">
                <el-date-picker
                  v-model="timeData[scope.$index].recordDate"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  clearable
                  type="datetime"/>
              </template>
            </el-table-column>
            <el-table-column label="工时" width="80" align="center">
              <template slot-scope="scope">
                <el-input v-model="timeData[scope.$index].consumeTime" />
              </template>
            </el-table-column>
            <el-table-column label="剩余" width="80" align="center" >
              <template slot-scope="scope">
                <el-input v-model="timeData[scope.$index].remainTime" />
              </template>
            </el-table-column>
            <el-table-column prop="date" label="备注" align="center" >
              <template slot-scope="scope">
                <el-input v-model="timeData[scope.$index].remark" type="textarea"/>
              </template>
            </el-table-column>
          </el-table>
          <div class="remark-btn">
            <el-button size="mini" class="submitRemark" @click="submitAddRecord()" >保存</el-button>
          </div>
        </div>
      </el-dialog>
    </template>
    <!-- 点击暂停或继续、开始、完成的弹框 -->
    <template v-if="statusDialogVisible">
      <el-dialog
        :visible.sync="statusDialogVisible"
        :title="workForm.workPlanName+' > '+ titleText"
      >
        <el-form
          id="startWork"
          ref="workStatusForm"
          :model="workStatusForm"
          :rules="rules"
          label-width="80px"
          size="mini"
        >
          <el-form-item v-if="titleText==='开始'" label="实际开始">
            <el-date-picker
              v-model="workStatusForm.startTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
            />
          </el-form-item>
          <!-- <el-form-item v-if="titleText==='继续'||titleText==='开始'" label="总消耗">
            <el-input v-model="workForm.totalConsumeTime">
              <template slot="append">小时</template>
            </el-input>
          </el-form-item> -->
          <el-form-item v-if="titleText==='完成'" label="已消耗">
            <span>{{ workStatusForm.totalConsumeTime }}工时</span>
          </el-form-item>
          <el-form-item v-if="titleText==='开始'||titleText==='完成'||titleText==='继续'" label="总消耗" prop="totalConsumeTime">
            <el-input v-model="workStatusForm.totalConsumeTime">
              <template slot="append">小时</template>
            </el-input>
          </el-form-item>
          <el-form-item v-if="titleText==='完成'" label="完成时间" prop="endTime">
            <el-date-picker
              v-model="workStatusForm.endTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
            />
          </el-form-item>
          <el-form-item v-if="titleText==='开始'||titleText==='继续'" label="预计剩余" prop="totalRemainTime">
            <el-input v-model="workStatusForm.totalRemainTime">
              <template slot="append">小时</template>
            </el-input>
          </el-form-item>
          <el-form-item v-show="titleText==='完成'" label="附件(50M)" class="accessory">
            <div
              style="border: 1px solid #ccc;
    padding: 5px 0px 5px 10px;
    font-size: 14px;">
              <input
                type="file"
                @change="getFile($event)"
              >
            </div>

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
            <span :disabled="isDisabled" @click="submitStatus(workStatusForm)">{{ titleText }}</span>
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
import { api, paramApi, Inventor } from '@/api/axios'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      recordForm: {
        recordDate: '',
        remainTime: '',
        consumeTime: '',
        remark: '',
        workPlanId: '',
        id: ''
      },
      recordList: [],
      recordDialogVisible: false,
      historyData: [],
      timeData: [
        { workPlanId: '',
          id: '',
          recordDate: '',
          remainTime: '',
          consumeTime: '',
          remark: ''
        },
        {
          workPlanId: '',
          id: '',
          recordDate: '',
          remainTime: '',
          consumeTime: '',
          remark: ''
        },
        {
          workPlanId: '',
          id: '',
          recordDate: '',
          remainTime: '',
          consumeTime: '',
          remark: ''
        }
      ],
      addRemark: '',
      isShowRemark: false,
      file: '',
      workStatusForm: {
        attachment: '',
        remark: '',
        endTime: '',
        startTime: '',
        workPlanName: '',
        // planEndTime: '',
        // planStartTime: '',
        planTime: '',
        workPlanStatus: '',
        totalConsumeTime: '',
        totalRemainTime: '',
        id: ''
      },
      titleText: '',
      statusDialogVisible: false,
      statusText: '',
      jobLoggingDialogVisible: false,
      attachment: [],
      // downloadUrl: '',
      // fileName: '',
      history: [],
      isDisabled: false,
      oaUrl: this.GLOBAL.oaUrl,
      baseUrl: process.env.BASE_API,
      statusOptions: [
        { value: '0', label: '未开始' },
        { value: '1', label: '进行中' },
        { value: '2', label: '已暂停' },
        { value: '3', label: '已完成' }
      ],
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 150
      },
      unbtn: true,
      unfold: false,
      workForm: {
        Uecontent: '',
        attachment: '',
        demandDescribe: '',
        endTime: '',
        startTime: '',
        itemName: '',
        id: '',
        planEndTime: '',
        planStartTime: '',
        planTime: '',
        remark: '',
        responsibleUserAccount: '',
        totalConsumeTime: undefined,
        totalRemainTime: undefined,
        workPlanName: '',
        workPlanStatus: ''
      },
      rules: {
        recordDate: [
          { required: true, message: '请选择日期', trigger: 'change' }
        ],
        remainTime: [
          { required: true, message: '请输入工时', trigger: 'blur' }
        ],
        consumeTime: [
          { required: true, message: '请输入剩余工时', trigger: 'blur' }
        ],
        totalRemainTime: [
          { required: true, message: '请输入预计剩余时间', trigger: 'blur' }
        ],
        totalConsumeTime: [
          { required: true, message: '请输入总消耗时间', trigger: 'blur' }
        ],
        endTime: [
          { required: true, message: '请选择完成时间', trigger: 'change' }
        ]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    submitAddRecord() {
      for (let i = 0; i < this.timeData.length; i++) {
        this.timeData[i].workPlanId = this.workForm.id
        if (this.timeData[i].remainTime || this.timeData[i].consumeTime || this.timeData[i].recordDate) {
          if (!this.timeData[i].recordDate) {
            return this.$message.error('请选择日期')
          } else if (!this.timeData[i].consumeTime) {
            return this.$message.error('请输入工时')
          } else if (!this.timeData[i].remainTime) {
            return this.$message.error('请输入剩余时间')
          }
        }
        if (this.timeData[i].recordDate) {
          this.recordList.push(this.timeData[i])
        }
      }
      api(
        `${this.GLOBAL.oaUrl}oa/workPlanRecord/addBatch`,
        this.recordList,
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.$message({
            message: '添加工时成功',
            type: 'success'
          })
          this.jobLoggingDialogVisible = false
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 提交编辑的工时记录
    submitRecord() {
      this.isDisabled = true
      this.$refs['recordForm'].validate(valid => {
        if (valid) {
          api(`${this.GLOBAL.oaUrl}oa/workPlanRecord/update`, this.recordForm, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '编辑工时成功',
                type: 'success'
              })
              this.recordDialogVisible = false
              this.initList()
              // 重置表单元素的数据
              this.$refs['recordForm'].resetFields()
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    // 点击编辑工时记录
    handleRecord(row) {
      this.recordForm.remark = row.remark
      this.recordForm.consumeTime = row.consumeTime
      this.recordForm.recordDate = row.recordDate
      this.recordForm.remainTime = row.remainTime
      this.recordForm.workPlanId = row.workPlanId
      this.recordForm.id = row.id
      this.recordDialogVisible = true
      this.jobLoggingDialogVisible = false
    },
    // 删除工时
    handleDelRecord(row) {
      this.$confirm(`是否删除这条工时记录, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi(`${this.GLOBAL.oaUrl}oa/workPlanRecord/delete`, row.id, 'workPlanRecordId').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              this.jobLogging()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {
        })
    },
    getFile: function(event) {
      this.file = event.target.files[0]
      if (this.file.size / 1024 / 1024 > 50) {
        alert('附件大小不能超过50M')
        return false
      }
    },
    // 备注提交
    submitRemark() {
      this.addRemark = this.$refs.ue.getUEContent()
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/addRemark`,
        { id: this.workForm.id, remark: this.addRemark },
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.$message({
            message: '添加备注成功',
            type: 'success'
          })
          this.isShowRemark = false
          this.initList()
        } else {
          this.$message({
            message: '添加备注失败',
            type: 'error'
          })
        }
      })
    },
    // 编辑
    handleEdit() {
      this.$router.push({ name: 'editWorkPlan', query: {
        id: this.workForm.id
      }})
    },
    // 删除
    handleDelete() {
      paramApi(
        `${this.GLOBAL.oaUrl}oa/workPlan/deleteBatch`,
        this.workForm.id,
        'workPlanId'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.$message({
            message: '删除成功',
            type: 'success'
          })
          this.goBack(this.$route)
        } else {
          this.$message({
            message: '删除失败',
            type: 'error'
          })
        }
      })
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
    // 点击弹框里面的提交
    submitStatus(workStatusForm) {
      this.isDisabled = true
      this.$refs['workStatusForm'].validate((valid) => {
        if (valid) {
          if (this.titleText === '开始') {
            this.workStatusForm.workPlanStatus = '1'
          } else if (this.titleText === '暂停') {
            this.workStatusForm.workPlanStatus = '2'
          } else if (this.titleText === '继续') {
            this.workStatusForm.workPlanStatus = '6'
          }
          // this.submitData(workStatusForm)
          // this.isDisabled = false
          if (this.titleText === '完成') {
            if (this.file.size) {
              this.newArr = []
              const formData = new FormData()
              formData.append('file', this.file)
              // 调用导入文件接口
              Inventor(
                `zuul/${this.GLOBAL.oaUrl}oa/common/uploadAttachment`,
                formData,
                'post'
              ).then(res => {
                if (res.data.code === this.GLOBAL.code) {
                  this.workStatusForm.attachment = res.data.data
                  this.workStatusForm.workPlanStatus = '3'
                  this.submitData(workStatusForm)
                }
                this.isDisabled = false
              })
            } else {
              this.workStatusForm.workPlanStatus = '3'
              this.submitData(workStatusForm)
              this.isDisabled = false
            }
          } else {
            this.submitData(workStatusForm)
            this.isDisabled = false
          }
        } else {
          this.isDisabled = false
          return false
        }
      })
    },
    submitData(workStatusForm) {
      this.workStatusForm.remark = this.$refs.ue.getUEContent()
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/updateWorkPlanStatus`,
        this.workStatusForm,
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.statusDialogVisible = false
          this.initList()
        }
      })
      this.isDisabled = false
    },
    // 点击完成
    handleComplete() {
      this.titleText = '完成'
      if (this.workForm.endTime) {
        this.workStatusForm.endTime = this.workForm.endTime
      } else {
        this.workStatusForm.endTime = this.getDate()
      }
      this.workStatusForm.totalConsumeTime = this.workForm.totalConsumeTime
      this.statusDialogVisible = true
    },
    // 点击暂停或继续
    handlePasue() {
      if (this.statusText === '暂停') {
        this.titleText = '暂停'
      } else if (this.statusText === '继续') {
        this.titleText = '继续'
        this.workStatusForm.totalConsumeTime = this.workForm.totalConsumeTime
        this.workStatusForm.totalRemainTime = this.workForm.totalRemainTime
      }
      this.statusDialogVisible = true
    },
    // 点击开始状态的弹框
    handleStart() {
      this.titleText = '开始'
      if (this.workForm.startTime) {
        this.workStatusForm.startTime = this.workForm.startTime
      } else {
        this.workStatusForm.startTime = this.getDate()
      }
      this.workStatusForm.totalConsumeTime = this.workForm.totalConsumeTime
      this.workStatusForm.totalRemainTime = this.workForm.totalRemainTime
      this.statusDialogVisible = true
    },
    // 点击工作记录
    jobLogging() {
      api(
        `${this.GLOBAL.oaUrl}oa/workPlanRecord/list?workPlanId=${
          this.workForm.id
        }`,
        '',
        'get'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.historyData = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
      this.jobLoggingDialogVisible = true
    },
    download(item) {
      api(`${this.GLOBAL.oaUrl}oa/common/downLoadAttachment?title=${item.title}&url=${item.url}`, '', 'get').then(res => {
        window.location.href = res.request.responseURL
      })
    },
    // 点击展开和收起
    unfoldText() {
      this.unbtn = !this.unbtn
      this.unfold = !this.unfold
    },
    // 页面初始化
    initList() {
      var query = this.$route.query
      this.workForm.id = query.id
      this.workStatusForm.id = query.id
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/getWorkPlanById?workPlanId=${
          query.id
        }`,
        '',
        'get'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          var data = res.data.data
          this.workForm.demandDescribe = data.demandDescribe
          if (data.endTime) {
            this.workForm.endTime = data.endTime
          }
          if (data.startTime) {
            this.workForm.startTime = data.startTime
          }
          if (data.attachment) {
            this.attachment = JSON.parse(data.attachment)
          }
          this.workForm.startTime = data.startTime
          this.workForm.itemName = data.itemName
          this.workForm.planEndTime = data.planEndTime
          this.workForm.planStartTime = data.planStartTime
          this.workForm.planTime = data.planTime
          this.workForm.totalConsumeTime = data.totalConsumeTime
          this.workForm.totalRemainTime = data.totalRemainTime
          this.workForm.workPlanName = data.workPlanName
          this.workForm.workPlanStatus = data.workPlanStatus
          if (data.workPlanStatus !== '2') {
            this.statusText = '暂停'
          } else if (data.workPlanStatus === '2') {
            this.statusText = '继续'
          }
          this.history = data.workPlanHistorys
          this.workForm.responsibleUserAccount = data.responsibleUserAccount
          if (data.content) {
            this.workForm.Uecontent = data.content
          }
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    // 关闭当前页面
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('workPlanManagement')
        }
      })
    }
  }
}
</script>

<style lang="scss">
 .record{
  //   .el-date-editor.el-input, .el-date-editor.el-input__inner {
  //   width: 100% ;
  // }
  .el-input--suffix .el-input__inner{
    padding-right: unset;
  }
  .el-table thead.has-gutter th{
    border:none;
  }
  .el-table td, .el-table th.is-leaf{
     border:none;
  }
  .record-title{
    margin-bottom: 20px;
    color:black;
    font-size: 15px;
    font-weight: 600;
    >span{
      font-size: 13px;
      color:#333;
      font-weight: normal;
    }
  }
  [class*=" el-icon-"], [class^=el-icon-]{
    font-size: 16px;
  }
  .el-date-editor.el-input, .el-date-editor.el-input__inner{
    width: 200px;
  }
  }
.workPlanDetails {
   .recordForm{
     .el-input--medium{
       width: 220px ;
     }
     .el-date-editor.el-input, .el-date-editor.el-input__inner {
    width: 220px!important ;
   }
   }
  padding: 5px 20px 20px 20px;
  .editWorkPlan-content {
    display: flex;
    .editWorkPlan-left {
      width: 287px;
      margin-right: 60px;
      .el-form-item--mini.el-form-item,
      .el-form-item--small.el-form-item {
        margin-bottom: 14px;
      }
    }
    .editWorkPlan-right{
      flex: 1;
    }
  }
  .beizhu {
  .el-form-item__content {
    width: 80% !important;
  }
}
.remark-btn{
  margin-top:25px;
  text-align: center;
.submitRemark{
  background: rgb(26, 79, 133);
  color:#fff;
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
    // .accessoryStyle{
    //   border:1px solid #ccc;height:28px;line-height:28px;padding-left:5px;display: inline-block;
    //   margin:5px 0px;
     input{
        outline: none;
        border: none;
      }
    // }
    .el-form-item__content {
    width: 80%;
  }
  }
  .el-form-item--mini.el-form-item,
  .el-form-item--small.el-form-item {
    margin-bottom: 14px;
  }
  .el-form-item--mini .el-form-item__content,
  .el-form-item--mini .el-form-item__label {
    line-height: 20px;
  }
}
  .el-dialog{
    margin-top:8vh!important;
      height: 600px;
      overflow: auto;
      width: 660px;
    }
   .el-dialog__title {
    line-height: 24px;
    font-size: 15px;
    color: black;
    font-weight: 600;
  }
  .footer {
    margin: 20px 0px 30px 0px;
    text-align: center;
    >a{
      font-size: 14px;
    margin-right: 10px;
    }
  }
   .historyInfo {
        background: #fbfbfb;
        padding: 4px 10px 6px;
        min-height: 20px;
        margin-left: 20px;
        border: 1px solid #f5f5f5;
      }
      .fieldest {
        border: 1px solid #e5e5e5;
        margin-bottom: 15px;
         font-size: 13px;
        padding: 10px 15px 15px;
        legend {
          width: auto;
          margin: 0 0 0 -5px;

          font-weight: bold;
          border-bottom: 0;
          padding: 0 5px;
          color: #333;
        }
        .history_a {
          background: #f1f1f1;
          color: #666 !important;
          //  border: 1px solid #ccc;
          margin-left: 4px;
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
        .el-textarea__inner {
          min-height: 80px !important;
        }
      }
}
</style>

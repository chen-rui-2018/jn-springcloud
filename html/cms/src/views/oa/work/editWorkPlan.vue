<template>
  <div class="editWorkPlan write">
    <h3>智慧园区协同办公设计任务&nbsp; <span>></span>&nbsp;{{ titleText }}</h3>
    <div class="editWorkPlan-content">
      <div class="editWorkPlan-left">
        <el-form
          ref="workForm"
          :rules="rules"
          :model="workForm"
          label-width="100px"
          size="mini"
        >
          <div
            class=""
            style="margin-left:15px;font-size: 17px;"
          >基本信息:</div>
          <el-form-item label="任务名称:" prop="workPlanName">
            <el-input
              v-model="workForm.workPlanName"
              placeholder="请输入任务名称"
            />
          </el-form-item>
          <el-form-item label="所属项目:" prop="itemId">
            <el-select
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
            </el-select>
          </el-form-item>
          <el-form-item label="负责人:">
            <el-select
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
            </el-select>
          </el-form-item>
          <el-form-item label="任务状态:" prop="workPlanStatus">
            <el-select
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
            </el-select>
          </el-form-item>
          <div style="margin-left:15px;margin-top:20px; font-size: 17px;">工时信息:</div>
          <el-form-item label="预计开始:" prop="planStartTime">
            <el-date-picker
              v-model="workForm.planStartTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期"
              style="width: 100%;"
            />
          </el-form-item>
          <el-form-item label="截止时间:" prop="planEndTime">
            <el-date-picker
              v-model="workForm.planEndTime"
              type="datetime"
              value-format="yyyy-MM-dd"
              placeholder="选择日期"
              style="width: 100%;"
            />
          </el-form-item>
          <el-form-item label="实际开始:">
            <el-date-picker
              v-model="workForm.startTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
              style="width: 100%;"
            />
          </el-form-item>
          <el-form-item label="实际结束:">
            <el-date-picker
              v-model="workForm.endTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期"
              style="width: 100%;"
            />
          </el-form-item>
          <el-form-item label="预计工时:" prop="planTime">
            <el-input v-model="workForm.planTime"><template slot="append">小时</template></el-input>
          </el-form-item>
          <el-form-item label="总消耗:" prop="totalConsumeTime">
            <el-input v-model="workForm.totalConsumeTime"><template slot="append">小时</template></el-input>
          </el-form-item>
          <el-form-item label="剩余工时:" prop="totalRemainTime">
            <el-input v-model="workForm.totalRemainTime"><template slot="append">小时</template></el-input>
          </el-form-item>
        </el-form>
      </div>
      <div class="editWorkPlan-right">
        <fieldset class="fieldest">
          <legend><strong>任务描述</strong></legend>
          <div class="editor-container">
            <UE
              ref="ue"
              :default-msg="defaultMsg"
              :config="config"
            />
          </div>
        </fieldset>
        <fieldset class="fieldest">
          <legend><strong>需求描述</strong></legend>
          <el-input
            v-model="workForm.demandDescribe"
            placeholder="请输入需求描述"
            type="textarea"
          />
        </fieldset>
        <div
          style="    font-size: 14px;
    margin-top: 20px;margin-bottom:5px;">附件</div>
        <div
          style="border: 1px solid #ccc;
    padding: 5px 0px 5px 10px;
    font-size: 14px;">
          <input
            type="file"
            @change="getFile($event)"
          >
        </div>
        <div
          style="    font-size: 14px;
    margin-top: 20px;margin-bottom:5px;">备注</div>
        <el-input
          v-model="workForm.remark"
          placeholder="请输入备注"
          type="textarea"
        />
        <!-- <div>附件</div>
        <el-upload
          :on-error="handleError"
          :headers="{token: $store.getters.token}"
          :on-remove="handleRemove"
          :before-upload="beforeUpload"
          :on-success="uploadDone"
          :on-exceed="handleExceed"
          :limit="1"
          :action="baseUrl+'zuul/'+oaUrl+'oa/common/uploadAttachment'">
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">附件大小不能超过50M</div>
        </el-upload> -->
      </div>
    </div>
    <div class="footer">
      <el-button
        :disabled="isDisabled"
        type="primary"
        @click="submitForm('workForm')"
      >保存</el-button>
      <el-button @click="goBack($route)">返回</el-button>
    </div>
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
  </div>
</template>

<script>
import { api, Inventor } from '@/api/axios'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      file: '',
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
      userAccount: [],
      itemOptions: [],
      userOptions: [],
      titleText: '编辑',
      workForm: {
        content: '',
        attachment: '',
        demandDescribe: '',
        endTime: '',
        startTime: '',
        itemId: '',
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
        itemId: [
          { required: true, message: '请选择项目', trigger: 'change' }
        ],
        workPlanName: [
          { required: true, message: '请输入任务名称', trigger: 'blur' }
        ],
        planStartTime: [
          { required: true, message: '请选择预计开始时间', trigger: 'change' }
        ],
        planEndTime: [
          { required: true, message: '请选择截止时间', trigger: 'change' }
        ],
        workPlanStatus: [
          { required: true, message: '请选择任务状态', trigger: 'change' }
        ],
        planTime: [
          { required: true, message: '请输入预计时间', trigger: 'blur' }
        ],
        totalConsumeTime: [
          { required: true, message: '请输入总消耗时间', trigger: 'blur' }
        ],
        totalRemainTime: [
          { required: true, message: '请输入剩余时间', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getALLlist()
    this.getItem()
    this.initList()
  },
  methods: {
    getFile: function(event) {
      this.file = event.target.files[0]
    },
    submitForm(workForm) {
      this.$refs[workForm].validate((valid) => {
        if (valid) {
          this.isDisabled = true
          if (this.userAccount.length === 0) {
            alert('请选择负责人')
            this.isDisabled = false
            return
          }
          if (new Date(this.workForm.planStartTime.replace(/-/g, '\/')) > new Date(this.workForm.planEndTime.replace(/-/g, '\/'))) {
            alert('开始时间必须大于截止时间,请重新选择')
            this.isDisabled = false
            return false
          }
          if (this.file.size) {
            if (this.file.size / 1024 / 1024 > 50) {
              this.$message.error('附件大小不能超过50M')
              this.isDisabled = false
              return false
            }
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
                this.workForm.attachment = res.data.data
                this.submitData(workForm)
              }
              this.isDisabled = false
            })
          } else {
            this.submitData(workForm)
          }
        } else {
          this.isDisabled = false
          return false
        }
      })
    },
    submitData(workForm) {
      this.workForm.content = this.$refs.ue.getUEContent()
      this.workForm.responsibleUserAccount = this.userAccount.join(',')
      if (!this.workForm.startTime) {
        this.workForm.startTime = ''
      }
      this.workForm.planTime = Number(this.workForm.planTime)
      this.workForm.totalConsumeTime = Number(this.workForm.totalConsumeTime)
      this.workForm.totalRemainTime = Number(this.workForm.totalRemainTime)
      api(`${this.GLOBAL.oaUrl}oa/workPlan/update`, this.workForm, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.goBack(this.$route)
          this.$refs[workForm].resetFields()
        } else {
          this.$message.error(res.data.result)
        }
        this.isDisabled = false
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
          // if (data.startTime === null) {
          //   this.workForm.startTime = ''
          // } else {
          //   this.workForm.startTime = data.startTime
          // }
          this.workForm.startTime = data.startTime
          this.workForm.itemId = data.itemId
          this.workForm.planEndTime = data.planEndTime
          this.workForm.planStartTime = data.planStartTime
          this.workForm.planTime = data.planTime
          this.workForm.totalConsumeTime = data.totalConsumeTime
          this.workForm.totalRemainTime = data.totalRemainTime
          this.workForm.workPlanName = data.workPlanName
          this.workForm.workPlanStatus = data.workPlanStatus
          this.history = data.workPlanHistorys
          if (data.responsibleUserAccount) {
            this.userAccount = data.responsibleUserAccount.split(',')
          }
          if (data.content) {
            this.defaultMsg = data.content
          }
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    uploadDone(res, file, fileList) {
      this.workForm.attachment = res.data
    },
    handleRemove(file, fileList) {
      this.workForm.attachment = ''
    },
    handleError(e) {
      this.$message.error('上传文件失败!')
    },
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传1个附件`)
    },
    beforeUpload(file) {
      if (file.size / 1024 / 1024 > 50) {
        this.$message.warning('附件大小不能超过50M')
        return false
      }
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
    },
    // 获取所有用户
    getALLlist() {
      api(
        `${this.GLOBAL.oaUrl}oa/addressBook/list`,
        { page: 1, rows: 2000 },
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          //   this.userNamesOptions = res.data.data
          res.data.data.rows.forEach(val => {
            if (val.name !== null) {
              this.userOptions.push({
                userId: val.id,
                name: val.name,
                account: val.account
              })
            } else {
              this.userOptions.push({
                userId: val.id,
                name: val.account,
                account: val.account
              })
            }
          })
        } else {
          this.$message.error(res.data.result)
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

<style lang="scss">
.editWorkPlan {
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
    // .editWorkPlan-right {
      //     .fieldest {
      // border: 1px solid #e5e5e5;
      // margin-top: 15px;
      // padding: 10px 15px 15px;
      // legend {
      //   width: auto;
      //   margin: 0 0 0 -5px;
      //   font-size: 13px;
      //   font-weight: bold;
      //   border-bottom: 0;
      //   padding: 0 5px;
      //   color: #333;
      // }

    // }
  }
  .footer {
    margin: 20px 0px 30px 0px;
    text-align: center;
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
        margin-top: 15px;
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

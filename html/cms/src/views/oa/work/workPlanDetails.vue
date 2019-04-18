<template>
  <div class="editWorkPlan write">
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
          <ul>
            <li><a v-show="downloadUrl" href="javascript:;" download="" @click="download"> <i class="fa fa-file-text-o"/> {{ fileName }}</a></li>
          </ul>

        </fieldset>
        <fieldset class="fieldest">
          <legend> <strong>历史记录</strong><a
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
    </div>

    <div class="footer">
      <el-button
        :disabled="isDisabled"
        type="primary"
        @click="submitForm('workForm')"
      >保存</el-button>
      <el-button @click="goBack($route)">返回</el-button>
    </div>
  </div>
</template>

<script>
import { api } from '@/api/axios'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      attachment: [],
      downloadUrl: '',
      fileName: '',
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
      titleText: '编辑',
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
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    // submitForm(workForm) {
    //   console.log(this.workForm)
    // },
    download() {
      api(`${this.GLOBAL.oaUrl}oa/common/downLoadAttachment?title=${this.fileName}&url=${this.downloadUrl}`, '', 'get').then(res => {
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
      console.log(query)
      this.workForm.id = query.id
      api(
        `${this.GLOBAL.oaUrl}oa/workPlan/getWorkPlanById?workPlanId=${
          query.id
        }`,
        '',
        'get'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          console.log(res)
          var data = res.data.data
          this.workForm.demandDescribe = data.demandDescribe
          if (data.endTime) {
            this.workForm.endTime = data.endTime
          }
          if (data.startTime) {
            this.workForm.startTime = data.startTime
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

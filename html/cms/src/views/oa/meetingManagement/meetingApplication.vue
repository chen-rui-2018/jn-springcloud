<template>
  <div class="meetingApplication">
    <div class="meetingApplication-top">
      <el-form ref="meetingForm" :model="meetingForm" :show-message="false" hide-required-asterisk class="demo-meetingForm">
        <div style="display:flex">
          <el-form-item label="工单编号" prop="workOrderNum" class="inline">
            <span> {{ meetingForm.workOrderNum }} </span>
          </el-form-item>
          <el-form-item label="工单名称" prop="title" class="inline">
            <span>{{ meetingForm.title }}</span>
          </el-form-item>
        </div>
        <!-- <div style="display:flex">
          <el-form-item label="姓名" class="inline" >
            <span> {{ accountName }} </span>
          </el-form-item>
          <el-form-item label="部门" prop="department " class="inline" >
            <span> 招商部</span>
          </el-form-item>
        </div> -->
        <div style="display:flex">
          <el-form-item label="会议室" prop="meetingRoomId" class="inline">
            <el-input v-model="meetingroomName" :disabled="lookMeetingroom" clearable placeholder="请选择" @click.native="abc()"/>
          </el-form-item>
          <el-form-item label="会议主题" prop="title" class="inline">
            <el-input v-model="meetingForm.title" :disabled="lookMeetingroom" placeholder="请输入内容" clearable />
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="参与人员" prop="participantsId">
            <el-select v-model="meetingForm.participantsId" multiple placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in participantsIdOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"/>
                <!-- <el-input v-model="meetingForm.participantsId" :disabled="lookMeetingroom" clearable placeholder="请输入内容" /> -->
          </el-select></el-form-item>
          <el-form-item label="会议时间:">
            <el-date-picker v-model="meetingForm.startTime" :disabled="lookMeetingroom" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始时间" />
            至
            <el-date-picker v-model="meetingForm.endTime" :disabled="lookMeetingroom" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间" />
          </el-form-item>
        </div>
        <el-form-item label="会议内容" prop="oaMeetingContent" class="inline ueditor">
          <div class="editor-container">
            <UE ref="ue" :default-msg="defaultMsg" :disabled="lookMeetingroom" :config="config" />
          </div>
        </el-form-item>
        <el-form-item label="审批进度" prop="approvalStatus" class="inline">
          <el-steps :space="300" :active="approvals()" finish-status="success">
            <el-step title="发起审批"/>
            <el-step title="领导审批"/>
            <el-step title="审批完成 "/>
          </el-steps>
        </el-form-item>
        <el-form-item v-if="isShow" label="审批状态">
          <el-radio v-model="meetingForm.approvalStatus" :disabled="lookMeetingroom" label="2">通过</el-radio>
          <el-radio v-model="meetingForm.approvalStatus" :disabled="lookMeetingroom" label="3">不通过</el-radio>
          <!-- <el-radio-group v-model="meetingForm.approvalStatus" :disabled="lookMeetingroom">
            <el-radio label="通过"/>
            <el-radio label="不通过"/>
          </el-radio-group> -->
        </el-form-item>
        <el-form-item v-if="isShowApprovalOpinion" label="审批意见" >
          <el-input v-model="meetingForm.approvalOpinion" :disabled="isShowApprovalOpinion" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <div class="primaryList">
          <el-button v-if="!isShow" type="primary" @click="submitForm('meetingForm')">{{ bottonText==="编辑会议"?'再次提交':'提交' }}</el-button>
          <el-button v-if="!isShow" @click="cancel">取消</el-button>
          <!-- <el-button v-if="!isShow  >作废</el-button> -->
          <el-button v-if="isShow" type="primary" @click="goBack($route)">返回</el-button>
        </div>
      </el-form>
    </div>
    <template v-if="dialogFormVisible">
      <el-dialog :visible.sync="dialogFormVisible" class="lookMeetingroom">
        <el-form :inline="true" :model="meetingroomForm" class="filter-bar">
          <!-- <el-form-item label="位置">
            <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable style="width: 150px" class="filter-item" @change="selecteUserStatus">
              <el-option v-for="(item,index) in userStatusOptions" :key="item" :label="item" :value="index" />
            </el-select>
          </el-form-item> -->
          <el-form-item label="会议时间:">
            <el-date-picker v-model="listQuery.startTime" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始时间" />
            至
            <el-date-picker v-model="listQuery.endTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间" />
          </el-form-item>
          <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查询</el-button>
        </el-form>
        <div class="usableMeetingroom">可预约的会议室</div>
        <div class="meetingroomList">
          <div v-for="(item,index) in meetingroomList" :key="index" @click="checkMeetingroom(item)">
            <img :src="item.attachmentPaths[0]" alt="会议室图片">
            <h3>{{ item.name }}</h3>
            <div>会议室说明:{{ item.explains }},可参与人数<span>{{ item.capacity }}</span> </div>
          </div>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='会议申请'?createUserData():updateData()">确认</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </div>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import UE from '../../../components/ue.vue'
import {
  paramApi, api, userAllList
} from '@/api/oa/meetingManagement'
export default {
  components: {
    UE
  },
  data() {
    return {
      meetingroomName: '',
      dialogStatus: '',
      meetingroomForm: {
        meetingroomId: '',
        meetingroomName: ''
      },
      meetingroomList: [],
      isDisabled: false,
      isShowApprovalOpinion: false,
      bottonText: '',
      participantsIdOptions: [],
      lookMeetingroom: false,
      isShow: false,
      accountName: '',
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 200,
        wordCount: false
      },
      describe: '有投影仪',
      dialogFormVisible: false,
      listQuery: {
        recordStatus: '',
        page: 1,
        rows: 10,
        startTime: '',
        endTime: ''
      },
      meetingForm: {
        workOrderNum: '',
        title: '',
        recordStatus: '',
        participantsId: '',
        meetingRoomId: '',
        startTime: '',
        endTime: '',
        oaMeetingContent: '',
        approvalStatus: ''
      },
      userStatusOptions: ['会议室1', '会议室2']
    }
  },
  created() {
    this.initList()
    this.getALLlist()
  },
  methods: {
    // 取消
    cancel() {
      if (this.dialogStatus === '会议申请') {
        this.meetingForm.title = ''
        this.meetingroomName = ''
        this.meetingroomForm.meetingroomId = ''
        this.meetingForm.participantsId = ''
        this.meetingForm.startTime = ''
        this.meetingForm.endTime = ''
        this.meetingForm.oaMeetingContent = ''
        this.$nextTick(() => {
          this.$refs['meetingForm'].clearValidate()
        })
      }
      this.initList()
    },
    createUserData() {
      this.meetingroomName = this.meetingroomForm.meetingroomName
      this.meetingForm.meetingRoomId = this.meetingroomForm.meetingroomId
      this.dialogFormVisible = false
    },
    // 选中的会议室
    checkMeetingroom(item) {
      this.meetingroomForm.meetingroomId = item.id
      this.meetingroomForm.meetingroomName = item.name
    },
    // 获取所有用户
    getALLlist() {
      userAllList().then(res => {
        if (res.data.code === '0000') {
          res.data.data.forEach(val => {
            this.participantsIdOptions.push({ value: val.id, label: val.name })
          })
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
          const latestView = visitedViews.slice(-1)[0]
          if (latestView) {
            this.$router.push(latestView)
          } else {
            this.$router.push('/')
          }
        }
      })
    },
    // 处理状态
    approvals() {
      if (this.meetingForm.approvalStatus === '1') {
        return 2
      } else if (this.meetingForm.approvalStatus === '2') {
        return 3
      } else if (this.meetingForm.approvalStatus === '3') {
        return 1
      } else {
        return 1
      }
    },
    abc() {
      this.dialogFormVisible = true
      // 调用接口发送请求
      api('oa/oaMeetingRoom/availableList', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          console.log(res)
          this.meetingroomList = res.data.data.rows
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    handleFilter() {},
    selecteUserStatus() {},
    submitForm() {
      this.meetingForm.oaMeetingContent = this.$refs.ue.getUEContent()
      console.log(this.meetingForm)
      this.isDisabled = true
      this.$refs['meetingForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api('oa/oaMeeting/add', this.meetingForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              this.goBack(this.$route)
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // 重置表单元素的数据
            this.$refs['meetingForm'].resetFields()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    initList() {
      if (localStorage.getItem('userName')) {
        this.accountName = localStorage.getItem('userName')
      } else {
        this.accountName = localStorage.getItem('account')
      }
      var query = this.$route.query
      console.log(query)
      this.bottonText = query.title
      if (query.id) {
        if (query.title === '查看会议') {
          this.lookMeetingroom = true
          this.isShow = true
        }
        this.isShowApprovalOpinion = true
        paramApi('oa/oaMeeting/selectById', query.id, 'id').then(res => {
          if (res.data.code === '0000') {
            // this.defaultMsg = data.oaMeetingContent
            var data = res.data.data
            this.meetingForm.workOrderNum = data.workOrderNum
            this.meetingForm.title = data.title
            this.meetingForm.participantsId = data.participantsId
            this.meetingForm.meetingRoomId = data.meetingRoomId
            this.meetingForm.startTime = data.startTime
            this.meetingForm.endTime = data.endTime
            this.meetingForm.oaMeetingContent = data.oaMeetingContent
            this.meetingForm.approvalStatus = data.approvalStatus
            this.meetingForm.recordStatus = data.recordStatus.toString()
            this.approvals()
          } else {
            this.$message.error(res.data.result)
          }
        })
      } else {
        var obj = this.$route.query
        var date = new Date()
        var Y = date.getFullYear()
        var m = date.getMonth() + 1
        var d = date.getDate()
        var H = date.getHours()
        var M = date.getMinutes()
        var s = date.getSeconds()
        if (m < 10) {
          m = '0' + m
        }
        if (d < 10) {
          d = '0' + d
        }
        if (H < 10) {
          H = '0' + H
        }
        if (M < 10) {
          M = '0' + M
        }
        if (s < 10) {
          s = '0' + s
        }
        this.dialogStatus = '会议申请'
        var num = Math.floor(Math.random() * (9999 - 1000)) + 1000
        var workOrderNum = obj.workOrder + '-' + Y + m + d + H + M + s + num
        this.meetingForm.workOrderNum = workOrderNum
      }
    }
  }
}
</script>
<style lang="scss">
.meetingApplication{
  .el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
    line-height: 22px !important;
}
}
.el-select-dropdown{
  top:320px !important;
}
.meetingApplication-top {
  .inline {
    display: inline-block;
  }
  .el-form-item__label {
    width: 120px;
    padding: 15px 0;
    display: inline-block;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .edui-default .edui-editor-bottomContainer{
    display: none;
  }
  .el-form-item {
    margin-bottom: 0px;
    flex: 1;
    display: flex;
  }
  .el-form-item__content {
    flex: 1;
    display: inline-block;
    padding: 15px;
    border: 1px solid #ccc;
  }
  .primaryList {
    margin-top: 30px;
    text-align: center;
  }
  .el-steps{
    margin-left: 100px;
  }
  .el-radio+.el-radio {
    margin-left: 280px;
}
.el-radio-group{
  margin-left: 100px;
}
.el-textarea__inner{
  min-height: 120px !important;
}

}
.lookMeetingroom{
  .el-form--inline .el-form-item{
    margin-right: 70px;
  }

  .el-dialog{
 width: 70vw;
  height: 82vh;
  margin-top:6vh !important;
  overflow: auto;
  }
  .usableMeetingroom{
    background-color: #ccc;
    padding: 15px;
    border:1px solid #666;
  }
  .meetingroomList{
   >div{
     width: 31.7%;
     display: inline-block;
     margin-right: 21px;
     margin-top: 30px;
     img{
       width: 100%;
       height: 100%;
     }
   }
  }
  .meetingroomList div:nth-child(3n){
     margin-right: 0px;
   }
   .dialog-footer{
     text-align: center;
   }
}
</style>

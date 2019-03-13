<template>
  <div class="meetingApplication">
    <div class="meetingApplication-top">
      <el-form ref="meetingForm" :model="meetingForm" :rules="rules" hide-required-asterisk class="demo-meetingForm">
        <div style="display:flex">
          <el-form-item label="会议主题" prop="title" class="inline">
            <el-input v-model="meetingForm.title" :disabled="lookMeetingroom" placeholder="请输入内容" clearable />
          </el-form-item>
          <el-form-item label="会议日期:" prop="meetingTime">
            <el-date-picker
              :disabled="lookMeetingroom"
              v-model="startDate"
              value-format="yyyy/MM/dd"
              type="date"
              placeholder="选择日期"/>
              <!-- <el-date-picker v-model="meetingForm.startTime" :disabled="lookMeetingroom" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始时间"/>
            至
            <el-date-picker v-model="meetingForm.endTime" :disabled="lookMeetingroom" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间" /> -->
          <!-- </el-form-item> -->
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="开始时间" class="inline">
            <el-time-select
              :disabled="lookMeetingroom"
              v-model="startTime"
              :picker-options="{
                start: '09:00',
                step: '00:30',
                end: '18:00'
              }"
              placeholder="开始时间"/>
          </el-form-item>
          <el-form-item label="结束时间" class="inline">
            <el-time-select
              :disabled="lookMeetingroom"
              v-model="endTime"
              :picker-options="{
                start: '09:00',
                step: '00:30',
                end: '18:00',
                minTime: startTime
              }"
              placeholder="结束时间"/>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="预约部门" class="inline">
            <span> {{ department }} </span>
          </el-form-item>
          <el-form-item label="预约人" class="inline">
            <span>{{ userName }}</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="会议室" prop="meetingRoomId" class="inline">
            <el-input v-model="meetingroomName" :disabled="lookMeetingroom" placeholder="请选择会议室" @click.native="showMeetingroom()"/>
          </el-form-item>
          <el-form-item label="参与人员" prop="participantsId">
            <el-select v-model="meetingForm.participantsId" :disabled="lookMeetingroom" multiple placeholder="请选择参与人员" style="width:100%">
              <el-option
                v-for="item in participantsIdOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"/>
          </el-select></el-form-item>
        </div>

        <el-form-item label="会议内容" prop="oaMeetingContent" class="inline ueditor">
          <el-input v-model="meetingForm.oaMeetingContent" type="textarea"/>
        </el-form-item>
      </el-form>
      <div class="primaryList">
        <el-button v-if="!isShow" type="primary" @click="dialogStatus==='会议申请'?submitForm('meetingForm'):updateData()" >提交</el-button>
        <el-button v-if="!isShow" @click="cancel">取消</el-button>
        <el-button @click="goBack($route)">返回</el-button>
      </div>
    </div>
    <template v-if="dialogFormVisible">
      <el-dialog :visible.sync="dialogFormVisible" class="lookMeetingroom">
        <el-form :inline="true" class="filter-bar">
          <div class="usableMeetingroom">可预约的会议室</div>
          <div class="meetingroomList">
            <div v-for="(item,idx) in meetingroomList" :key="idx" :class="{'active':idx==index}" @click="checkMeetingroom(item,idx)">
              <img :src="item.attachmentPaths[0]?item.attachmentPaths[0]:'/static/images/meetingroom.jpg'" alt="会议室图片">
              <h3>{{ item.name }}</h3>
              <div>会议室说明:{{ item.explains }} </div>
              <div>可参与人数:{{ item.capacity }} </div>
            </div>
          </div>
          <div class="dialog-footer">
            <el-button :disabled="isDisabled" type="primary" @click="createUserData()">确认</el-button>
            <el-button @click="dialogFormVisible = false">取消</el-button>
          </div>
        </el-form>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import {
  paramApi, api, userAllList, getUserInfo
} from '@/api/oa/meetingManagement'
export default {
  data() {
    var checkBuilding = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }
    return {
      startTime: '',
      endTime: '',
      department: '',
      userName: '',
      oldMeetingTitle: '',
      pageTitle: '',
      approvalBotton: false,
      index: 0,
      meetingroomName: '',
      dialogStatus: '',
      meetingroomForm: {
        meetingroomId: '',
        meetingroomName: ''
      },
      meetingroomList: [],
      isDisabled: false,
      participantsIdOptions: [],
      lookMeetingroom: false,
      isShow: false,
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 200,
        wordCount: false
      },
      dialogFormVisible: false,
      listQuery: {
        page: 1,
        rows: 10,
        startTime: '',
        endTime: ''
      },
      startDate: '',
      meetingForm: {
        title: '',
        participantsId: [],
        meetingRoomId: '',
        startTime: '',
        endTime: '',
        oaMeetingContent: '',
        id: ''
      },
      rules: {
        title: [
          { required: true, message: '请输入会议主题', trigger: 'blur' },
          { validator: checkBuilding, trigger: 'blur' }
        ],
        meetingRoomId: [{ required: true, message: '请选择会议室', trigger: 'change' }],
        oaMeetingContent: [{ required: true, message: '请输入会议内容', trigger: 'blur' }]
      }

    }
  },
  created() {
    this.initList()
    this.getALLlist()
    this.getUserInfo()
  },
  methods: {
    // 取消
    cancel() {
      if (this.dialogStatus === '会议申请') {
        this.meetingForm.title = ''
        this.meetingroomName = ''
        this.meetingroomForm.meetingroomId = ''
        this.meetingForm.participantsId = []
        this.meetingForm.startTime = ''
        this.meetingForm.endTime = ''
        this.endTime = ''
        this.meetingForm.oaMeetingContent = ''
        this.$nextTick(() => {
          this.$refs['meetingForm'].clearValidate()
        })
      }
      this.initList()
    },
    // 确认选中的会议室
    createUserData() {
      if (!this.meetingroomForm.meetingroomId) {
        this.meetingroomName = this.meetingroomList[0].name
        this.meetingForm.meetingRoomId = this.meetingroomList[0].id
      } else {
        this.meetingroomName = this.meetingroomForm.meetingroomName
        this.meetingForm.meetingRoomId = this.meetingroomForm.meetingroomId
      }
      this.dialogFormVisible = false
    },
    // 选中的会议室
    checkMeetingroom(item, idx) {
      this.meetingroomForm.meetingroomId = item.id
      this.meetingroomForm.meetingroomName = item.name
      this.index = idx
    },
    // 获取所有用户
    getALLlist() {
      userAllList().then(res => {
        if (res.data.code === '0000') {
          res.data.data.forEach(val => {
            if (val.name !== null) {
              this.participantsIdOptions.push({ value: val.id, label: val.name })
            } else {
              this.participantsIdOptions.push({ value: val.id, label: val.account })
            }
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取登陆用户信息
    getUserInfo() {
      getUserInfo().then(res => {
        if (res.data.code === '0000') {
          this.userName = res.data.data.name
          if (res.data.data.sysDepartmentPostVO !== null) {
            res.data.data.sysDepartmentPostVO.forEach(val => {
              if (val.isDefault === '1') {
                this.department = val.departmentName
              }
            })
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
          const latestView = visitedViews.slice(-1)[0]
          if (latestView) {
            this.$router.push('meetingListManagement')
          } else {
            this.$router.push('/')
          }
        }
      })
    },
    // 跳出弹框选择会议室
    showMeetingroom() {
      if (this.dialogStatus !== '查看会议') {
        if (!this.endTime) {
          alert('请先选择会议结束时间')
          return false
        }
        this.dialogFormVisible = true
        this.index = 0
        // 调用接口发送请求
        this.listQuery.startTime = this.startDate + ' ' + this.startTime + ':00'
        if (this.endTime) {
          this.listQuery.endTime = this.startDate + ' ' + this.endTime + ':00'
        }
        api('oa/oaMeetingRoom/availableList', this.listQuery).then(res => {
          if (res.data.code === '0000') {
            this.meetingroomList = res.data.data.rows
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    // 弹出的选择会议室对话框的查询条件
    handleFilter() {
      api('oa/oaMeetingRoom/availableList', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.meetingroomList = res.data.data.rows
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 编辑会议申请
    updateData() {
      this.isDisabled = true
      this.meetingForm.startTime = this.startDate + ' ' + this.startTime + ':00'
      this.meetingForm.endTime = this.startDate + ' ' + this.endTime + ':00'
      var today_time = new Date().getTime()
      if (new Date(this.meetingForm.startTime) - today_time < 0) {
        alert('会议开始时间必须大于当前当前时间')
        return
      }
      if (new Date(this.meetingForm.endTime) - new Date(this.meetingForm.startTime) > 0) {
        this.$refs['meetingForm'].validate(valid => {
          if (valid) {
            if (this.meetingForm.participantsId.length > 0 && this.meetingForm.startTime && this.meetingForm.endTime) {
            // 调用接口发送请求
              api('oa/oaMeeting/update', this.meetingForm).then(res => {
                if (res.data.code === '0000') {
                  this.$message({
                    message: '会议编辑成功',
                    type: 'success'
                  })
                  this.goBack(this.$route)
                  // 重置表单元素的数据
                  this.$refs['meetingForm'].resetFields()
                } else {
                  this.$message.error(res.data.result)
                }
                this.isDisabled = false
              })
            }
            if (this.meetingForm.participantsId.length === 0 || this.meetingForm.participantsId === null) {
              alert('请选择参会人员')
            } else if (!this.meetingForm.startTime) {
              alert('请选择会议开始时间')
            } else if (!this.meetingForm.endTime) {
              alert('请选择会议结束时间')
            }
          } else {
            this.isDisabled = false
          }
        })
      } else {
        alert('会议结束时间必须大于会议开始时间')
      }
    },
    // 点击提交的时候
    submitForm() {
      this.isDisabled = true
      this.meetingForm.startTime = this.startDate + ' ' + this.startTime + ':00'
      this.meetingForm.endTime = this.startDate + ' ' + this.endTime + ':00'
      var today_time = new Date().getTime()
      if (new Date(this.meetingForm.startTime) - today_time < 0) {
        alert('会议开始时间必须大于当前当前时间')
        return
      }
      if (new Date(this.meetingForm.endTime) - new Date(this.meetingForm.startTime) > 0) {
        this.$refs['meetingForm'].validate(valid => {
          if (valid) {
            if (this.meetingForm.participantsId.length > 0 && this.meetingForm.startTime && this.meetingForm.endTime) {
            // 调用接口发送请求
              api('oa/oaMeeting/add', this.meetingForm).then(res => {
                if (res.data.code === '0000') {
                  this.$message({
                    message: '会议申请成功',
                    type: 'success'
                  })
                  this.goBack(this.$route)
                  // 重置表单元素的数据
                  this.$refs['meetingForm'].resetFields()
                } else {
                  this.$message.error(res.data.result)
                }
                this.isDisabled = false
              })
            }
            if (this.meetingForm.participantsId.length === 0 || this.meetingForm.participantsId === null) {
              alert('请选择参会人员')
            } else if (!this.meetingForm.startTime) {
              alert('请选择会议开始时间')
            } else if (!this.meetingForm.endTime) {
              alert('请选择会议结束时间')
            }
          } else {
            this.isDisabled = false
          }
        })
      } else {
        alert('会议结束时间必须大于会议开始时间')
      }
    },
    initList() {
      var query = this.$route.query
      this.pageTitle = query.title
      if (query.id) {
        if (query.title === '查看会议') {
          this.lookMeetingroom = true
          this.isShow = true
          this.dialogStatus = '查看会议'
        }
        this.meetingForm.id = query.id
        paramApi('oa/oaMeeting/selectById', query.id, 'id').then(res => {
          if (res.data.code === '0000') {
            var data = res.data.data
            this.meetingForm.title = data.title
            var dataArr = []
            data.participantList.forEach(val => {
              // this.meetingForm.participantsId.push(val.meetingUserId)
              dataArr.push(val.meetingUserId)
            })
            this.meetingForm.participantsId = Array.from(new Set(dataArr))
            this.meetingForm.meetingRoomId = data.meetingRoomId
            this.startTime = data.startTime.substring(10, 16)
            this.endTime = data.endTime.substring(10, 16)
            this.startDate = data.startDate
            this.meetingForm.oaMeetingContent = data.content
            if (data.tbOaMeetingRoom.name !== null || data.tbOaMeetingRoom.name !== '') {
              this.meetingroomName = data.tbOaMeetingRoom.name
            }
            this.oldMeetingTitle = data.title
          } else {
            this.$message.error(res.data.result)
          }
        })
      } else {
        this.dialogStatus = '会议申请'
        this.meetingroomName = query.name
        this.meetingForm.meetingRoomId = query.meetId
        this.startTime = query.currentTime
        this.startDate = query.currentDate
      }
    }
  }
}
</script>
<style lang="scss">

.meetingApplication{
  .el-form-item__error{
    left:22px;
    top:unset;
    padding-top: unset;
  }
}
.meetingApplication-top {
   .el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
    line-height: 22px !important;
}
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
    //  box-sizing: border-box;
     img{
       width: 100%;
       height: 100%;
     }
   }
   .active{
     border:2px solid blueviolet;
   }
   h3{
     text-align: center;
   }
  }
  .meetingroomList div:nth-child(3n){
     margin-right: 0px;
   }
   .dialog-footer{
     text-align: center;
     margin-top:20px;
   }

}
</style>

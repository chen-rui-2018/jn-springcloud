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
          <el-form-item label="组织部门" prop="departmentsId">
            <el-select
              v-model="meetingForm.departmentsId"
              :disabled="lookMeetingroom"
              filterable
              placeholder="请选择组织部门"
              style="width:100%"
              @change="getUserOfDepartment">
              <el-option
                v-for="(item, index) in departmentOptions"
                :disabled="lookMeetingroom"
                :key="index"
                :label="item.label"
                :value="item.value"/>
            </el-select>
          </el-form-item>
          <el-form-item label="组织人" prop="organizationalUser">
            <el-select
              v-loading="userOfDepartmentOptions.length === 0 && dialogStatus !== '会议申请'"
              v-model="meetingForm.organizationalUser"
              :disabled="lookMeetingroom"
              filterable
              placeholder="请先选择组织人"
              style="width:100%">
              <el-option
                v-for="(item, index) in userOfDepartmentOptions"
                :disabled="lookMeetingroom"
                :key="index"
                :label="item.label"
                :value="item.value"/>
            </el-select>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="会议室" prop="meetingRoomId" class="inline">
            <el-input v-model="meetingroomName" :disabled="lookMeetingroom" placeholder="请选择会议室" @click.native="showMeetingroom()"/>
          </el-form-item>
          <el-form-item label="参与人员" prop="participantsStr">
            <el-select
              v-loading="participantsIdOptions.length === 0 && dialogStatus !== '会议申请'"
              v-model="meetingForm.participantsStr"
              :disabled="lookMeetingroom"
              filterable
              multiple
              placeholder="请选择参与人员"
              style="width:100%">
              <el-option
                v-for="item in participantsIdOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"/>
          </el-select></el-form-item>
        </div>
        <el-form-item label="会议方案附件" class="inline ueditor">
          <el-upload
            v-if="!lookMeetingroom"
            :on-error="handleError"
            :disabled="lookMeetingroom"
            :headers="{token: $store.getters.token}"
            :on-remove="handleRemove"
            :before-upload="beforeUpload"
            :on-success="uploadDone"
            :on-exceed="handleExceed"
            :limit="1"
            :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
            accept="image/gif,image/jpeg,image/jpg,image/bmp,image/png,.doc,.rar">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传一个附件，附件大小不能超过20M，只支持{{ acceptType.join(',') }}文件类型</div>
          </el-upload>
          <el-button v-if="meetingForm.fileUrl" size="small" type="primary" icon="el-icon-download"><a :href="meetingForm.fileUrl" download="" target="_blank">点击下载附件</a></el-button>
          <div v-if="!meetingForm.fileUrl && dialogStatus !== '会议申请'" class="attachment-tips">暂无附件</div>
        </el-form-item>
        <el-form-item label="会议内容" prop="oaMeetingContent" class="inline ueditor">
          <el-input v-model="meetingForm.oaMeetingContent" :disabled="lookMeetingroom" type="textarea"/>
        </el-form-item>
      </el-form>
      <div class="primaryList">
        <el-button v-if="!isShow" :disabled="isDisabled" type="primary" @click="dialogStatus==='会议申请'?submitForm('meetingForm'):updateData()" >提交</el-button>
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
            <el-button type="primary" @click="createUserData()">确认</el-button>
            <el-button @click="dialogFormVisible = false">取消</el-button>
          </div>
        </el-form>
      </el-dialog>
    </template>
  </div>
</template>

<script>
import {
  paramApi, api
} from '@/api/axios'
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
      baseUrl: process.env.BASE_API,
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
      departmentOptions: [],
      userOfDepartmentOptions: [],
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
      tempFileUrl: '',
      meetingForm: {
        title: '',
        participantsStr: [],
        departmentsId: '',
        organizationalUser: '',
        meetingRoomId: '',
        startTime: '',
        endTime: '',
        oaMeetingContent: '',
        fileUrl: '',
        id: ''
      },
      acceptType: ['jpg', 'png', 'rar', 'txt', 'zip', 'doc', 'ppt', 'pptx', 'xls', 'pdf', 'docx', 'xlsx'],
      rules: {
        title: [
          { required: true, message: '请输入会议主题', trigger: 'blur' },
          { validator: checkBuilding, trigger: 'blur' }
        ],
        meetingRoomId: [{ required: true, message: '请选择会议室', trigger: 'change' }],
        oaMeetingContent: [{ required: true, message: '请输入会议内容', trigger: 'blur' }],
        departmentsId: [{ required: true, message: '请选择组织部门', trigger: 'change' }],
        organizationalUser: [{ required: true, message: '请选择组织人', trigger: 'change' }],
        participantsStr: [{ required: true, message: '请选择参与人员', trigger: 'change' }]
      }
    }
  },
  created() {
    this.init()
  },
  methods: {
    // 取消
    cancel() {
      if (this.dialogStatus === '会议申请') {
        this.meetingForm.title = ''
        this.meetingroomName = ''
        this.meetingroomForm.meetingroomId = ''
        this.meetingForm.participantsStr = []
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
      api(`${this.GLOBAL.systemUrl}system/sysUser/getUserAll`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
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
    // 获取组织部门列表
    getAllDepartment() {
      api(`${this.GLOBAL.parkUrl}finance/expenses/selectDepartment`, '', 'get').then(({ data }) => {
        if (data.code === this.GLOBAL.code) {
          this.departmentOptions = data.data.map(item => ({ value: item.departmentId, label: item.departmentName }))
        } else {
          this.$message.error(data.result)
        }
      })
    },
    // 获取部门下的用户列表
    getUserOfDepartment() {
      const query = {
        departmentId: this.meetingForm.departmentsId,
        page: 1,
        rows: 2000
      }
      api(`${this.GLOBAL.oaUrl}oa/addressBook/list`, query, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.userOfDepartmentOptions = res.data.data.rows.map(item => ({ value: item.id, label: item.name || item.account }))
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取登陆用户信息
    getUserInfo() {
      api(`${this.GLOBAL.systemUrl}system/sysUser/getUserInfo`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.userName = res.data.data.name
          if (res.data.data.sysDepartmentPostVO && res.data.data.sysDepartmentPostVO.length > 0) {
            res.data.data.sysDepartmentPostVO.forEach(val => {
              if (val.isDefault === '1') {
                this.department = val.departmentName
              }
            })
          } else {
            this.department = '无'
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
          this.$router.push('meetingListManagement')
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
        this.listQuery.endTime = this.startDate + ' ' + this.endTime + ':00'
        api(`${this.GLOBAL.oaUrl}oa/oaMeetingRoom/availableList`, this.listQuery, 'post').then(res => {
          if (res.data.code === this.GLOBAL.code) {
            this.meetingroomList = res.data.data.rows
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    // 弹出的选择会议室对话框的查询条件
    handleFilter() {
      api(`${this.GLOBAL.oaUrl}oa/oaMeetingRoom/availableList`, this.listQuery, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
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
      if (!this.endTime) {
        alert('请选择会议结束时间')
        this.isDisabled = false
        return
      } else if (new Date(this.meetingForm.startTime) - today_time < 0) {
        alert('会议开始时间必须大于当前当前时间')
        this.isDisabled = false
        return
      } else if (this.meetingForm.participantsStr.length === 0) {
        alert('请选择参会人员')
        this.isDisabled = false
        return
      } else if (!this.meetingForm.organizationalUser) {
        alert('请选择组织人')
        return
      }
      if (new Date(this.meetingForm.endTime) - new Date(this.meetingForm.startTime) > 0) {
        this.$refs['meetingForm'].validate(valid => {
          if (valid) {
            if (this.meetingForm.participantsStr.length > 1 && this.meetingForm.startTime && this.meetingForm.endTime) {
              // 调用接口发送请求
              const meetingForm = Object.assign({}, this.meetingForm)
              meetingForm.participantsStr = meetingForm.participantsStr.join('、')
              meetingForm.fileUrl = this.tempFileUrl ? this.tempFileUrl : meetingForm.fileUrl
              api(`${this.GLOBAL.oaUrl}oa/oaMeeting/update`, meetingForm, 'post').then(res => {
                if (res.data.code === this.GLOBAL.code) {
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
          } else {
            this.isDisabled = false
          }
        })
      } else {
        alert('会议结束时间必须大于会议开始时间')
        this.isDisabled = false
        return
      }
    },
    // 点击提交的时候
    submitForm() {
      this.isDisabled = true
      this.meetingForm.startTime = this.startDate + ' ' + this.startTime + ':00'
      this.meetingForm.endTime = this.startDate + ' ' + this.endTime + ':00'
      var today_time = new Date().getTime()
      if (!this.endTime) {
        alert('请选择会议结束时间')
        this.isDisabled = false
        return
      } else if (new Date(this.meetingForm.startTime) - today_time < 0) {
        alert('会议开始时间必须大于当前当前时间')
        this.isDisabled = false
        return
      } else if (this.meetingForm.participantsStr.length === 0) {
        alert('请选择参会人员')
        this.isDisabled = false
        return
      } else if (!this.meetingForm.organizationalUser) {
        alert('请选择组织人')
        return
      }
      if (new Date(this.meetingForm.endTime) - new Date(this.meetingForm.startTime) > 0) {
        this.$refs['meetingForm'].validate(valid => {
          if (valid) {
            if (this.meetingForm.participantsStr.length > 1 && this.meetingForm.startTime && this.meetingForm.endTime) {
            // 调用接口发送请求
              const meetingForm = Object.assign({}, this.meetingForm)
              meetingForm.participantsStr = meetingForm.participantsStr.join('、')
              meetingForm.fileUrl = this.tempFileUrl ? this.tempFileUrl : meetingForm.fileUrl
              api(`${this.GLOBAL.oaUrl}oa/oaMeeting/add`, meetingForm, 'post').then(res => {
                if (res.data.code === this.GLOBAL.code) {
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
          } else {
            this.isDisabled = false
          }
        })
      } else {
        alert('会议结束时间必须大于会议开始时间')
        this.isDisabled = false
        return
      }
    },
    async init() {
      // 查看和编辑的时候，组织人列表请求需要在initList接口取到组织部门id(departmentsId)后再获取部门下员工列表
      this.getALLlist()
      this.getAllDepartment()
      await this.initList()
      if (this.meetingForm.departmentsId) {
        await this.getUserOfDepartment()
      }
    },
    initList() {
      return new Promise((resolve, reject) => {
        var query = this.$route.query
        this.pageTitle = query.title
        if (query.id) {
          if (query.title === '查看会议') {
            this.lookMeetingroom = true
            this.isShow = true
            this.dialogStatus = '查看会议'
          }
          this.meetingForm.id = query.id
          paramApi(`${this.GLOBAL.oaUrl}oa/oaMeeting/selectById`, query.id, 'id').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              var data = res.data.data
              this.meetingForm.title = data.title
              this.meetingForm.departmentsId = data.departmentsId
              this.meetingForm.participantsStr = data.participantsStr.split('、')
              this.meetingForm.departmentsId = data.organizationalId
              this.meetingForm.organizationalUser = data.organizationalUserId
              this.meetingForm.meetingRoomId = data.meetingRoomId
              this.meetingForm.fileUrl = data.fileUrl
              if (data.startTime !== null) {
                this.startTime = data.startTime.substring(10, 16)
              }
              console.log(this.startTime)
              if (data.endTime !== null) {
                this.endTime = data.endTime.substring(10, 16)
              }
              if (data.startDate !== null) {
                this.startDate = data.startDate.replace(/-/g, '/')
              }
              this.meetingForm.oaMeetingContent = data.content
              if (data.tbOaMeetingRoom !== null) {
                this.meetingroomName = data.tbOaMeetingRoom.name
              }
              if (data.departmentName) {
                this.department = data.departmentName
              } else {
                this.department = '无'
              }
              this.userName = data.userName
              this.oldMeetingTitle = data.title
              resolve()
            } else {
              this.$message.error(res.data.result)
              reject()
            }
          })
        } else {
          this.getUserInfo()
          this.dialogStatus = '会议申请'
          this.meetingroomName = query.name
          this.meetingForm.meetingRoomId = query.meetId
          this.startTime = query.currentTime
          this.startDate = query.currentDate
          resolve()
        }
      })
    },
    uploadDone(res, file, fileList) {
      this.tempFileUrl = res.data
    },
    beforeUpload(file) {
      // // 判断上传文件类型
      const isAccept = this.acceptType.indexOf(file.name.substring(file.name.lastIndexOf('.') + 1).toLowerCase())
      if (isAccept < 0) {
        this.$message.warning(`只支持${this.acceptType.join(',')}文件类型`)
        return false
      }
      if (file.size / 1024 / 1024 > 20) {
        this.$message.warning('文件不能大于20M')
        return false
      }
    },
    handleRemove(file, fileList) {
      this.tempFileUrl = ''
    },
    handleError(e) {
      throw new Error(e)
    },
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传1个附件`)
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
     padding: 10px;
    //  box-sizing: border-box;
     img{
       width: 100%;
       height: 182px;
     }
   }
   .active{
     border:2px solid rgb(226, 43, 113);
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
.attachment-tips{
  font-size: 12px;
}
</style>

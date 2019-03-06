<template>
  <div class="addMeetingroom">
    <div class="header">{{ title }}</div>
    <el-form ref="meetingroomForm" :model="meetingroomForm" :rules="rules" class="demo-meetingroomForm">
      <div style="display:flex">
        <el-form-item label="会议室名称" prop="name" class="inline">
          <el-input v-model="meetingroomForm.name" :disabled="lookMeetingroom" clearable placeholder="请输入会议室名称" maxlength="20" />
        </el-form-item>
        <el-form-item label="楼宇" prop="building" class="inline">
          <el-input v-model="meetingroomForm.building" :disabled="lookMeetingroom" clearable placeholder="请输入楼宇" maxlength="20"/>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="楼层" prop="floor" class="inline" >
          <el-input v-model="meetingroomForm.floor" :disabled="lookMeetingroom" clearable placeholder="请输入楼层" maxlength="20" />
        </el-form-item>
        <el-form-item label="房间号" prop="roomNumber" class="inline" >
          <el-input v-model="meetingroomForm.roomNumber" :disabled="lookMeetingroom" clearable placeholder="请输入房间号" maxlength="20" />
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="会议室容量" prop="capacity" class="inline">
          <el-input v-model="meetingroomForm.capacity" :disabled="lookMeetingroom" clearable placeholder="请输入会议室容量(只能输入正整数)" type="number" min="1" @keyup.native="proving($event)"/>
        </el-form-item>
        <el-form-item label="会议室状态" prop="recordStatus" class="inline">
          <el-select v-model="meetingroomForm.recordStatus" :disabled="lookMeetingroom" placeholder="请选择状态" clearable style="width: 100%" class="filter-item" @change="selecteRecordStatus">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="会议室说明" prop="explains" lass="inline">
          <el-input v-model="meetingroomForm.explains" :disabled="lookMeetingroom" placeholder="请输入内容"/>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="会议室图片" prop="attachmentPaths" lass="inline">
          <el-upload
            :limit="3"
            :disabled="lookMeetingroom"
            :on-exceed="handleExceed"
            :on-success="uploadDone"
            :headers="getToken()"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
            :on-error="imgUploadError"
            :file-list="fileList"
            action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
            list-type="picture-card">
            <div v-if="showImg" class="showImg"><img v-for="(item,index) in fileList" :key="index" :src="item" alt="会议室图片"></div>

            <i class="el-icon-plus"/>
          </el-upload>
          <!-- <img v-for="(item,index) in meetingroomForm.attachmentPaths" :src="item.photoUrl" :key="index" alt="会议室图片"> -->
          <el-dialog :visible.sync="dialogVisible">
            <img :src="dialogImageUrl" width="100%" alt="会议室图片">
          </el-dialog>
        </el-form-item>
      </div>
      <div class="primaryList">
        <el-button v-if="!lookMeetingroom" :disabled="isDisabled" type="primary" @click="title==='新增会议室'?submitForm('meetingroomForm'):updateData()">提交</el-button>
        <!-- <el-button v-if="!lookMeetingroom" :disabled="isDisabled" type="primary" @click="submitForm('meetingroomForm')">提交</el-button> -->
        <el-button v-if="!lookMeetingroom" @click="cancel" >取消</el-button>
        <el-button @click="goBack($route)" >返回</el-button>

      </div>
    </el-form>
  </div>
</template>

<script>
import store from '@/store'
import {
  api, paramApi
} from '@/api/oa/meetingManagement'
export default {
  data() {
    var checkmeetingroomName = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        if (this.title === '新增会议室') {
          paramApi('oa/oaMeetingRoom/checkName', this.meetingroomForm.name, 'meetingRoomName').then(res => {
            if (res.data.code === '0000') {
              if (res.data.data === 'success') {
                callback()
              } else {
                callback(new Error('会议室名称已重复'))
              }
            }
          })
        } else {
          callback()
        }
      }
    }
    var checkBuilding = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }
    return {
      showImg: false,
      fileList: [],
      lookMeetingroom: false,
      look: false,
      isDisabled: false,
      dialogImageUrl: '',
      dialogVisible: false,
      statusOptions: [
        {
          value: '1',
          label: '可用'
        },
        {
          value: '2',
          label: '不可用'
        }
      ],
      title: '',
      attachmentList: [],
      meetingroomForm: {
        name: '',
        building: '',
        floor: '',
        roomNumber: '',
        capacity: '',
        recordStatus: '',
        explains: '',
        attachmentPaths: []

      },
      rules: {
        name: [
          { required: true, message: '请输入会议室名称', trigger: 'blur' },
          { validator: checkmeetingroomName, trigger: 'blur' }
        ],
        building: [{ required: true, message: '请输入楼宇', trigger: 'blur' },
          { validator: checkBuilding, trigger: 'blur' }],
        floor: [{ required: true, message: '请输入楼层', trigger: 'blur' },
          { validator: checkBuilding, trigger: 'blur' }],
        roomNumber: [{ required: true, message: '请输入房间号', trigger: 'blur' },
          { validator: checkBuilding, trigger: 'blur' }],
        recordStatus: [{ required: true, message: '请选择状态', trigger: 'change' }],
        // attachmentPaths: [{ required: true, message: '请选择会议图片', trigger: 'change' }],
        capacity: [{ required: true, message: '请输入会议室容量', trigger: 'blur' }]
      }
    }
  },
  created() {
    this.initList()
  },
  methods: {
    cancel() {
      if (this.title === '新增会议室') {
        this.meetingroomForm.roomNumber = ''
        this.meetingroomForm.name = ''
        this.meetingroomForm.building = ''
        this.meetingroomForm.explains = ''
        this.meetingroomForm.capacity = ''
        this.meetingroomForm.floor = ''
        this.meetingroomForm.recordStatus = ''
        this.meetingroomForm.attachmentPaths = []
        this.$nextTick(() => {
          this.$refs['meetingroomForm'].clearValidate()
        })
      }
      this.initList()
    },
    // 图片上传成功时的函数
    uploadDone(res, file, fileList) {
      this.meetingroomForm.attachmentPaths.push(res.data)
    },
    imgUploadError() {
      this.$message.error('上传图片失败!')
    },
    // 新增提交表单
    submitForm() {
      console.log(this.meetingroomForm)
      this.isDisabled = true
      this.$refs['meetingroomForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api('oa/oaMeetingRoom/add', this.meetingroomForm).then(res => {
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
            this.$refs['meetingroomForm'].resetFields()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    isActive(route) {
      return route.path === this.$route.path
    },
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
    // 编辑表单
    updateData() {
      this.isDisabled = true
      this.$refs['meetingroomForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api('oa/oaMeetingRoom/update', this.meetingroomForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              this.goBack(this.$route)
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
    // 删除图片
    handleRemove(file, fileList) {
      // 删除的
      if (this.title === '编辑会议室') {
        var editDelFile = file.url
        var editIndex = this.meetingroomForm.attachmentPaths.indexOf(editDelFile)
        this.meetingroomForm.attachmentPaths.splice(editIndex, 1)
      } else {
        // 先获取当前用户已经删除了文件路径
        var delFile = file.response.data
        var index = this.meetingroomForm.attachmentPaths.indexOf(delFile)
        this.meetingroomForm.attachmentPaths.splice(index, 1)
      }
    },
    // 预览图片
    handlePictureCardPreview(file) {
      if (this.title === '编辑会议室') {
        this.dialogImageUrl = file.url
      }
      this.dialogVisible = true
    },
    // 限制最多只能传3张图片
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传3张图片`)
    },
    // 改变会议室状态
    selecteRecordStatus(value) {
      this.meetingroomForm.recordStatus = value
    },
    // 阻止用户输入负数和小数
    proving(e) {
      var keynum = window.event ? e.keyCode : e.which // 获取键盘码
      if (keynum === 189 || keynum === 190 || keynum === 110 || keynum === 109) {
        alert('禁止输入小数以及负数')
        e.target.value = ''
      }
    },
    // 获取token
    getToken() {
      var token = store.getters.token
      return { 'token': token }
    },
    // 页面初始化
    initList() {
      var query = this.$route.query
      this.title = query.title
      if (query.id) {
        this.meetingroomForm.id = query.id
        paramApi('oa/oaMeetingRoom/selectById', query.id, 'id').then(res => {
          if (res.data.code === '0000') {
            var data = res.data.data
            this.meetingroomForm.name = data.name
            this.meetingroomForm.building = data.building
            this.meetingroomForm.floor = data.floor
            this.meetingroomForm.roomNumber = data.roomNumber
            this.meetingroomForm.capacity = data.capacity
            this.meetingroomForm.explains = data.explains
            this.meetingroomForm.attachmentPaths = data.attachmentPaths
            // this.fileList = data.attachmentPaths
            if (data.attachmentPaths.length > 0 && data.attachmentPaths !== null) {
              var fileListArr = []
              data.attachmentPaths.forEach(val => {
                fileListArr.push({ name: '', url: val })
              })
              // 数组去重
              this.fileList = Array.from(new Set(fileListArr))
            }
            this.meetingroomForm.recordStatus = data.recordStatus.toString()
            // if (this.fileList.length > 0) {
            //   this.showImg = true
            // }
            if (query.title === '查看会议室') {
              this.lookMeetingroom = true
            }
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    }
  }
}
</script>

<style lang="scss">
// .showImg{
//   width: 148px;
//   height: 148px;
//   img{
//     width: 100%;
//     height: 100%;
//     display: inline-block;
//   }
// }
.addMeetingroom {
  .header {
    color: cadetblue;
    background: #f0f0f0;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: Center;
    padding: 20px 0px;
    border:1px solid #ccc;
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
  .el-form-item__error{
    left:22px;
    top:unset;
    padding-top: unset;
  }
}
</style>

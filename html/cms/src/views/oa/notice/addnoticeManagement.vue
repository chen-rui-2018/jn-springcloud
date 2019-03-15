<template>
  <div class="addMeetingroom">
    <div class="header">{{ title }}</div>
    <el-form ref="meetingroomForm" :model="meetingroomForm" :rules="rules" class="demo-meetingroomForm">
      <div style="display:flex">
        <el-form-item label="编号" class="inline setheight">
          <span>{{ workOrder }}</span>
        </el-form-item>
        <el-form-item label="公告标题" prop="noticeTitle" class="inline">
          <el-input v-model="noticeForm.noticeTitle" clearable placeholder="请输入公告标题" maxlength="20"/>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="生效时间" prop="effectiveTime" class="inline" >
          <el-date-picker
            v-model="noticeForm.effectiveTime"
            type="date"
            placeholder="选择生效时间"/>
        </el-form-item>
        <el-form-item label="失效时间" prop="failureTime" class="inline" >
          <el-date-picker
            v-model="noticeForm.failureTime"
            type="date"
            placeholder="选择失效时间"/>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="状态" prop="recordStatus" class="inline">
          <el-select v-model="noticeForm.recordStatus" placeholder="请选择状态">
            <el-option v-for="item in statusOptions" :key="item.dictKey" :label="item.dictValue" :value="item.dictKey" />
          </el-select>
        </el-form-item>
        <el-form-item label="平台类型" prop="platformType" class="inline">
          <el-select v-model="noticeForm.platformType" multiple placeholder="请选择">
            <el-option
              v-for="item in codeOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"/>
          </el-select>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="公告内容" prop="noticeContent" lass="inline">
          <div class="editor-container">
            <UE ref="ue" :default-msg="defaultMsg" :config="config"/>
          </div>
        </el-form-item>
      </div>
      <div class="primaryList">
        <el-button :disabled="isDisabled" type="primary" @click="title==='新增会议室'?submitForm('meetingroomForm'):updateData()">提交</el-button>
        <el-button @click="cancel" >取消</el-button>
        <el-button @click="goBack($route)" >返回</el-button>

      </div>
    </el-form>
  </div>
</template>

<script>
import {
  api, paramApi
} from '@/api/oa/meetingManagement'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    var checknoticeTitle = (rule, value, callback) => {
      const reg = /^[\u4e00-\u9fa5\w]{1,20}$/
      if (!reg.test(value)) {
        callback(new Error('名称只允许数字、中文、字母及下划线'))
      } else {
        callback()
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
      defaultMsg: '这里是UE测试',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      workOrder: '',
      isDisabled: false,
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
      noticeForm: {
        noticeTitle: '',
        effectiveTime: '',
        failureTime: '',
        recordStatus: '',
        platformType: [],
        noticeContent: ''
      },
      rules: {
        noticeTitle: [
          { required: true, message: '请输入公告标题', trigger: 'blur' },
          { validator: checknoticeTitle, trigger: 'blur' }
        ],
        building: [{ required: true, message: '请输入楼宇', trigger: 'blur' },
          { validator: checkBuilding, trigger: 'blur' }],
        floor: [{ required: true, message: '请输入楼层', trigger: 'blur' },
          { validator: checkBuilding, trigger: 'blur' }],
        roomNumber: [{ required: true, message: '请输入房间号', trigger: 'blur' },
          { validator: checkBuilding, trigger: 'blur' }],
        recordStatus: [{ required: true, message: '请选择状态', trigger: 'change' }],
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
    // 新增提交表单
    submitForm() {
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
          // const latestView = visitedViews.slice(-1)[0]
          // if (latestView) {
          //   this.$router.push('meetingroomManagement')
          // } else {
          //   this.$router.push('/')
          // }
          this.$router.push('noticeManagement')
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
    // 页面初始化
    initList() {
      var query = this.$route.query
      console.log(query)
      this.workOrder = query.workOrder
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
    },
    // 改变平台状态
    selecteCodeStatus(value) {
      console.log(value)
      this.listQuery.platformType = value
    }
  }
}
</script>

<style lang="scss">
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
  .el-input--medium{
    width: 300px;
  }
  .el-form-item__content {
    flex: 1;
    // line-height: 36px;
    display: inline-block;
    padding: 10px  15px;
    border: 1px solid #ccc;
  }
  .setheight{
    .el-form-item__content {
      line-height: 36px;
    }
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

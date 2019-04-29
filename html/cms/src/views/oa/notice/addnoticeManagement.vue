<template>
  <div class="addnotice">
    <div class="header">{{ title }}</div>
    <el-form ref="noticeForm" :model="noticeForm" :rules="rules">
      <div style="display:flex">
        <el-form-item id="setheight" label="编号" class="inline ">
          <span>{{ noticeForm.workOrderNum }}</span>
        </el-form-item>
        <el-form-item label="公告标题" prop="noticeTitle" class="inline">
          <el-input v-model="noticeForm.noticeTitle" clearable placeholder="请输入公告标题" maxlength="20"/>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="生效时间" prop="effectiveTime" class="inline" >
          <el-date-picker
            v-model="noticeForm.effectiveTime"
            value-format="yyyy-MM-dd"
            type="date"
            placeholder="选择生效时间"/>
        </el-form-item>
        <el-form-item label="失效时间" prop="failureTime" class="inline" >
          <el-date-picker
            v-model="noticeForm.failureTime"
            value-format="yyyy-MM-dd"
            type="date"
            placeholder="选择失效时间"/>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="状态" prop="recordStatus" class="inline">
          <el-select v-model="noticeForm.recordStatus" placeholder="请选择状态">
            <el-option v-for="item in statusOptions" :key="item.id" :label="item.label" :value="item.id" />
          </el-select>
        </el-form-item>
        <el-form-item label="平台类型" prop="platformType" class="inline">
          <el-select v-model="platformType" value-key="key" multiple placeholder="请选择">
            <el-option
              v-for="item in codeOptions"
              :key="item.key"
              :label="item.lable"
              :value="item"/>
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
        <el-button :disabled="isDisabled" type="primary" @click="title==='新增公告'?submitForm():updateData()">提交</el-button>
        <el-button @click="goBack($route)" >返回</el-button>

      </div>
    </el-form>
  </div>
</template>

<script>
import {
  api, paramApi
} from '@/api/axios'
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
    return {
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      isShow: false,
      platformType: [],
      codeOptions: [],
      isDisabled: false,
      statusOptions: [
        {
          id: '1',
          label: '有效'
        },
        {
          id: '2',
          label: '失效'
        }
      ],
      title: '',
      noticeForm: {
        workOrderNum: '',
        noticeTitle: '',
        effectiveTime: '',
        failureTime: '',
        recordStatus: '',
        platformType: '',
        noticeContent: '',
        id: ''
      },
      code: {
        groupCode: 'platform_type',
        moduleCode: 'springcloud-oa',
        parentGroupCode: 'notice'
      },
      rules: {
        noticeTitle: [
          { required: true, message: '请输入公告标题', trigger: 'blur' },
          { validator: checknoticeTitle, trigger: 'blur' }
        ],
        effectiveTime: [{ required: true, message: '请选择生效时间', trigger: 'change' }],
        failureTime: [{ required: true, message: '请选择失效时间', trigger: 'change' }],
        platformType: [{ required: true, message: '请选择平台类型', trigger: 'blur' }],
        recordStatus: [{ required: true, message: '请选择状态', trigger: 'change' }],
        noticeContent: [{ required: true, message: '请输入公告内容', trigger: 'blur' }]
      }
    }
  },
  created() {
    this.initList()
    this.getCode()
  },
  methods: {
    // 新增提交表单
    submitForm() {
      this.isDisabled = true
      if (this.platformType.length === 0) {
        alert('请选择发布平台')
        this.isDisabled = false
        return false
      }
      if (new Date(this.noticeForm.failureTime.replace(/-/g, '\/')) < new Date(this.noticeForm.effectiveTime.replace(/-/g, '\/'))) {
        alert('失效时间必须大于生效时间,请重新选择')
        this.isDisabled = false
        return false
      }
      this.noticeForm.platformType = JSON.stringify(this.platformType)
      this.noticeForm.noticeContent = this.$refs.ue.getUEContent()
      this.$refs['noticeForm'].validate(valid => {
        if (valid) {
          this.noticeForm.effectiveTime = this.noticeForm.effectiveTime + ' ' + '00:00:00'
          this.noticeForm.failureTime = this.noticeForm.failureTime + ' ' + '23:59:59'
          // 调用接口发送请求
          api(`${this.GLOBAL.oaUrl}oa/notice/addOrUpdateNotice`, this.noticeForm, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '添加成功',
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
    isActive(route) {
      return route.path === this.$route.path
    },
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('noticeManagement')
        }
      })
    },
    // 编辑表单
    updateData() {
      this.isDisabled = true
      if (new Date(this.noticeForm.failureTime.replace(/-/g, '\/')) < new Date(this.noticeForm.effectiveTime.replace(/-/g, '\/'))) {
        alert('失效时间必须大于生效时间,请重新选择')
        this.isDisabled = false
        return false
      }
      if (this.platformType.length === 0) {
        alert('请选择发布平台')
        this.isDisabled = false
        return false
      }
      this.noticeForm.platformType = JSON.stringify(this.platformType)
      this.noticeForm.noticeContent = this.$refs.ue.getUEContent()
      this.$refs['noticeForm'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          this.noticeForm.effectiveTime = this.noticeForm.effectiveTime + ' ' + '00:00:00'
          this.noticeForm.failureTime = this.noticeForm.failureTime + ' ' + '23:59:59'
          api(`${this.GLOBAL.oaUrl}oa/notice/addOrUpdateNotice`, this.noticeForm, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
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
      this.title = query.title
      this.noticeForm.workOrderNum = query.workOrderNum
      if (query.id) {
        this.noticeForm.id = query.id
        paramApi(`${this.GLOBAL.oaUrl}oa/notice/getNoticeById`, query.id, 'noticeId').then(res => {
          if (res.data.code === this.GLOBAL.code) {
            var data = res.data.data
            this.noticeForm.noticeTitle = data.noticeTitle
            this.noticeForm.workOrderNum = data.workOrderNum
            this.noticeForm.effectiveTime = data.effectiveTime.slice(0, 10)
            this.noticeForm.failureTime = data.failureTime.slice(0, 10)
            this.noticeForm.recordStatus = data.recordStatus.toString()
            this.platformType = JSON.parse(data.platformType)
            this.defaultMsg = data.noticeContent
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    // 获取平台类型
    getCode() {
      api(`${this.GLOBAL.systemUrl}system/sysDict/getDict`, this.code, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.codeOptions = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss">
.addnotice {
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
    padding:  15px;
    border: 1px solid #ccc;
  }
  #setheight{
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
    .el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
    line-height: 22px;
  }
}
</style>

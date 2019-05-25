<template>
  <div class="train-addOrEdict">
    <el-card>
      <el-row type="flex" justify="center">
        <el-col :span="16">
          <el-form ref="formData" :model="formData" label-width="100px">
            <el-form-item
              :rules="{required: true, message: '课程名称不能为空', trigger: 'blur'}"
              label="课程名称"
              prop="courseTitle"
            >
              <el-col :span="11">
                <el-input v-model="formData.courseTitle" clearable/>
              </el-col>
            </el-form-item>
            <el-form-item
              :rules="{required: true, message: '培训老师不能为空', trigger: 'blur'}"
              label="培训老师"
              prop="trainTeacher"
            >
              <el-col :span="11">
                <el-input v-model="formData.trainTeacher" clearable/>
              </el-col>
            </el-form-item>
            <el-form-item
              :rules="{required: true, message: '培训地点不能为空', trigger: 'blur'}"
              label="培训地点"
              prop="trainVenue"
            >
              <el-col :span="11">
                <el-input v-model="formData.trainVenue" clearable/>
              </el-col>
            </el-form-item>
            <el-form-item
              :rules="{required: true, message: '培训时间不能为空', trigger: 'blur'}"
              label="培训时间"
            >
              <el-col :span="11">
                <el-date-picker
                  v-model="formData.trainStartTime"
                  type="datetime"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  placeholder="开始时间"
                  style="width: 100%;"
                />
              </el-col>
              <el-col :span="1" style="text-align:center;">至</el-col>
              <el-col :span="11">
                <el-date-picker
                  v-model="formData.trainEndTime"
                  type="datetime"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  placeholder="结束时间"
                  style="width: 100%;"
                />
              </el-col>
            </el-form-item>
            <el-form-item
              :rules="{required: true, message: '课程介绍不能为空', trigger: 'blur'}"
              label="课程介绍"
              prop="trainInfo"
            >
              <div class="editor-container">
                <UE ref="ue" :default-msg="defaultMsg" :config="config"/>
              </div>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submit()">保存</el-button>
              <el-button v-if="!formData.id" @click="cancel()">取消</el-button>
              <el-button @click="goBack($route)">返回</el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import UE from '@/components/ue.vue'
import { api } from '@/api/hr/train'
export default {
  components: { UE },
  data() {
    return {
      formData: {},
      // 富文本
      defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 250,
        autoFloatEnabled: false
      }
    }
  },
  created() {
    this.init()
  },
  methods: {
    // 1.初始化
    init() {
      const query = this.$route.query
      if (query.id) {
        this.formData.id = query.id
        const data = {
          id: query.id
        }
        api('hr/train/list/selectManagement', data).then(res => {
          if (res.data.code === '0000') {
            const data = res.data.data
            this.formData = data
            this.defaultMsg = this.formData.trainInfo
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    // 2.保存提交
    submit() {
      const query = this.$route.query
      this.formData.trainInfo = this.$refs.ue.getUEContent()
      this.$refs['formData'].validate(valid => {
        let url
        if (valid) {
          if (query.id) {
            // 编辑
            url = 'hr/train/list/updateManagement'
          } else {
            // 新增
            url = 'hr/train/list/addManagement'
          }
          api(url, this.formData).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '保存成功',
                type: 'success'
              })
              this.goBack(this.$route)
            } else {
              this.$message.error(res.data.result)
            }
            // 重置表单元素的数据
            this.$refs['formData'].resetFields()
          })
        } else {
          return false
        }
      })
    },
    // 取消
    cancel() {
      const query = this.$route.query
      if (!query.id) {
        this.formData.courseTitle = ''
        this.formData.trainTeacher = ''
        this.formData.trainVenue = ''
        this.formData.trainStartTime = ''
        this.formData.trainEndTime = ''
        this.formData.trainInfo = ''
        this.$refs.ue.editor.setContent('', false)
        this.$nextTick(() => {
          this.$refs['formData'].clearValidate()
        })
      }
      this.init()
    },
    // 返回
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          const latestView = visitedViews.slice(-1)[0]
          if (latestView) {
            this.$router.push('train-list')
          } else {
            this.$router.push('/')
          }
        }
      })
    },
    isActive(route) {
      return route.path === this.$route.path
    }
  }
}
</script>

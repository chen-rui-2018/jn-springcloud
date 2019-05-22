<template>
  <div class="train-detail">
    <el-card>
      <el-row type="flex" justify="center">
        <el-col :span="16">
          <el-form :model="formData" :inline="true">
            <el-col :span="12">
              <el-form-item label="课程名称" prop="courseTitle">
                <el-input v-model="formData.courseTitle" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="培训老师" prop="trainTeacher">
                <el-input v-model="formData.trainTeacher" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-form-item label="培训地点" prop="trainVenue">
              <el-input v-model="formData.trainVenue" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="培训时间">
              <el-col :span="11">
                <el-date-picker
                  v-model="formData.trainStartTime"
                  type="datetime"
                  placeholder="开始时间"
									:disabled="true"
                  style="width: 100%;"
                />
              </el-col>
              <el-col :span="2" style="text-align:center;">至</el-col>
              <el-col :span="11">
                <el-date-picker
                  v-model="formData.trainEndTime"
                  type="datetime"
                  placeholder="结束时间"
									:disabled="true"
                  style="width: 100%;"
                />
              </el-col>
            </el-form-item>
            <el-form-item label="课程内容" prop="content">
              <el-input type="textarea" v-model="formData.trainInfo" :rows="3":disabled="true"></el-input>
            </el-form-item>
            <el-row type="flex" justify="center" style="margin-top:20px;">
              <el-form-item>
                <el-button type="primary" @click="goBack($route)">返回</el-button>
              </el-form-item>
            </el-row>
          </el-form>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import store from '@/store'
import {
  api, paramApi
} from '@/api/hr/train'
export default {
  data() {
    return {
      formData: {}
    }
  },
  created() {
    this.init()
	},
	methods: {
		// 初始化
    init() {
      let query = this.$route.query
      if (query.id) {
        this.formData.id = query.id
        let data = {
          id : query.id
        }
        api('hr/train/list/selectManagement', data).then(res => {
          if (res.data.code === '0000') {
            let data = res.data.data
            this.formData = data
            this.defaultMsg = this.formData.trainInfo
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
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


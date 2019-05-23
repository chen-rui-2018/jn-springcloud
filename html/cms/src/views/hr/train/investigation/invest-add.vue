<template>
  <el-card>
    <!-- 标题 -->
    <el-tabs v-model="activeName">
      <el-tab-pane label="编辑调研" name="first" />
      <el-tab-pane label="发放调研" name="second" />
      <el-tab-pane label="调研结果" name="third" />
    </el-tabs>
    <!-- 试题名称 -->
    <ExamTitle ref="examTitle" :is-add="true" />
    <!-- 题目汇总 -->
    <div v-for="(item, index) of formData.questionList" :key="index">
      <Single v-if="item.titleType === 1" ref="single" :qnum="index+1" @deleteQitem="deleteQitem(item, index)" />
      <Multiple v-if="item.titleType === 2" ref="multiple" :qnum="index+1" @deleteQitem="deleteQitem(item, index)" />
      <Subjective v-if="item.titleType === 3" ref="subjective" :qnum="index+1" @deleteQitem="deleteQitem(item, index)" />
    </div>
    <!-- 题目类型 -->
    <div class="examBlock">
      <div class="examType">
        <i class="el-icon-circle-plus add" />
        <el-button @click="addQitem(1)">
          <i class="el-icon-remove-outline" />单选题
        </el-button>
        <el-button @click="addQitem(2)">
          <i class="el-icon-circle-check-outline" />多选题
        </el-button>
        <el-button @click="addQitem(3)">
          <i class="el-icon-time" />主观题
        </el-button>
      </div>
    </div>
    <!-- 新增 -->
    <el-row type="flex" justify="center">
      <el-col :span="1">
        <el-button type="primary" @click="saveAll">生成调研</el-button>
      </el-col>
    </el-row>
  </el-card>
</template>

<script>
import { api } from '@/api/hr/train'
import ExamTitle from '@/components/QuestionType/examTitle.vue'
import Single from '@/components/QuestionType/single.vue'
import Multiple from '@/components/QuestionType/multiple.vue'
import Subjective from '@/components/QuestionType/subjective.vue'
export default {
  components: { ExamTitle, Single, Multiple, Subjective },
  data() {
    return {
      activeName: 'first',
      Qnum: 0,
      formData: {
        questionList: []
      }
    }
  },
  methods: {
    // 添加题目
    addQitem(titleType) {
      const item = {
        titleType: titleType
      }
      this.formData.questionList.push(item)
    },
    // 删除题目
    deleteQitem(item, index) {
      const vm = this
      vm.formData.questionList.splice(index, 1)
    },
    // 全部保存
    saveAll() {
      // 试题头
      const childrenData = this.$refs.examTitle.passData()
      this.formData = Object.assign(this.formData, childrenData)
      // 题目类型
      let singleIndex = 0
      let multipleIndex = 0
      let subjectiveIndex = 0
      this.formData.questionList.forEach((item, index) => {
        if (item.titleType === 1) {
          const singleData = this.$refs.single[singleIndex].passData()
          this.formData.questionList[index] = Object.assign(
            this.formData.questionList[index],
            singleData
          )
          singleIndex++
        }
        if (item.titleType === 2) {
          const multipleData = this.$refs.multiple[multipleIndex].passData()
          this.formData.questionList[index] = Object.assign(
            this.formData.questionList[index],
            multipleData
          )
          multipleIndex++
        }
        if (item.titleType === 3) {
          const subjectiveData = this.$refs.subjective[
            subjectiveIndex
          ].passData()
          this.formData.questionList[index] = Object.assign(
            this.formData.questionList[index],
            subjectiveData
          )
          subjectiveIndex++
        }
      })
      api('hr/train/addInvestiageAndQuestion', this.formData).then(res => {
        if (res.data.code === '0000') {
          this.$message.success('保存成功！')
          this.goBack(this.$route)
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 返回
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          const latestView = visitedViews.slice(-1)[0]
          if (latestView) {
            this.$router.push('invest-analysis')
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

<style lang="scss"  scoped>
.editBgcolor {
  background-color: #fafafa;
}
.examBlock {
  padding: 20px;
  margin-bottom: 20px;
  .editIcon {
    text-align: right;
    margin-bottom: 20px;
  }
  .showBtn {
    position: absolute;
    right: -57px;
    top: 0;
  }
  .examType {
    display: flex;
    align-items: center;
    i.add {
      font-size: 30px;
      color: #67c23a;
      margin-right: 15px;
    }
  }
  .ptionIcon {
    display: flex;
    justify-content: center;
    align-items: center;
    padding-top: 10px;
    color: #999;
    cursor: pointer;
    i {
      font-size: 20px;
    }
  }
  .addOption {
    width: 100%;
  }
  .score {
    display: inline-block;
    width: 60px;
  }
}
.examItem {
  position: relative;
  background-color: #fafafa;
  .operateBtn {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 120px;
    height: 100%;
    position: absolute;
    right: 0;
    top: 0;
    background-color: #f5f5f5;
    i {
      font-size: 22px;
      color: #999;
      cursor: pointer;
    }
  }
}
</style>

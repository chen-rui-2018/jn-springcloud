<template>
  <el-card>
    <!-- 标题 -->
    <el-tabs v-model="activeName">
      <el-tab-pane label="编辑问卷" name="first"/>
      <el-tab-pane label="发放问卷" name="second"/>
      <el-tab-pane label="问卷结果" name="third"/>
    </el-tabs>
    <!-- 试题名称 -->
    <ExamTitle :is-add="false" :parent-data="formData"/>
    <!-- 题目汇总 -->
    <div
      v-for="(item,index) of formData.questionList"
      :key="index"
      class="examBlock"
      @mouseover="changeActive($event)"
      @mouseout="removeActive($event)"
    >
      <div v-if="!item.isModify">
        <div class="examList">
          <p style="font-size:14px;">
            <span>Q{{ item.Qnum }}</span>&nbsp;&nbsp;
            <span>{{ item.titleName }}</span>&nbsp;&nbsp;
            <span v-if="item.titleType===1">[单选题]</span>
            <span v-if="item.titleType===2">[多选题]</span>
            <span v-if="item.titleType===3">[主观题]</span>&nbsp;&nbsp;
            <span v-if="item.isShowAnswer===1">(必答)</span>
          </p>
          <div v-if="item.titleType === 1 || item.titleType === 2" style="padding-left:26px;">
            <p v-for="(item2,index2) of item.titleOptionList" :key="index2" style="font-size:14px;">
              <span>{{ upperCase[index2] }}</span>&nbsp;&nbsp;
              <span>{{ item2.optionName }}</span>
            </p>
          </div>
          <!-- <el-input v-if="item.titleType === 3" type="textarea" rows="5" v-model="item.optionName" :disabled="true" style="width:36%;"></el-input> -->
        </div>
        <div class="operateBtn">
          <i class="el-icon-edit-outline" @click="modifySelect(item,index)"/>
          <i class="el-icon-delete" @click="deleteSelect(item,index)"/>
        </div>
      </div>
      <!-- 修改 -->
      <div v-click-outside="saveFirst" v-if="item.isModify">
        <el-row>
          <el-form label-width="46px">
            <el-form-item :label="'Q'+item.Qnum" label-width="26px">
              <el-row class="title">
                <el-col :span="10">
                  <el-input v-model="item.titleName"/>
                </el-col>
                <el-col :span="6" style="padding:0 10px;">
                  <span v-if="item.titleType===1">[单选题]</span>
                  <span v-if="item.titleType===2">[多选题]</span>
                  <span v-if="item.titleType===3">[主观题]</span>
                  <el-checkbox
                    :checked="item.isShowAnswer===1?true:false"
                    v-model="item.isShowAnswer"
                    :true-label="1"
                    :false-label="2"
                    style="padding-left:26px;"
                  >必答题</el-checkbox>
                </el-col>
              </el-row>
            </el-form-item>
            <div v-if="item.titleType === 1 || item.titleType === 2">
              <el-form-item
                v-for="(item2,index2) of item.titleOptionList"

                :key="index2"
                :label="upperCase[index2]"
              >
                <el-row class="option">
                  <el-col :span="9">
                    <el-input v-model="item2.optionName"/>
                  </el-col>
                  <el-col :span="2">
                    <span class="ptionIcon">
                      <i class="el-icon-delete" @click="deleteOption(index,index2,item2)"/>
                    </span>
                  </el-col>
                </el-row>
              </el-form-item>
            </div>
            <el-form-item v-if="item.titleType === 1 || item.titleType === 2">
              <el-row>
                <el-col :span="9">
                  <el-button class="addOption" @click="addOption(index)">
                    <i class="el-icon-plus"/>添加选项
                  </el-button>
                </el-col>
              </el-row>
            </el-form-item>
            <!-- <el-form-item v-if="item.titleType === 3">
                            <el-row class="option">
                                <el-col :span="9"><el-input type="textarea" :rows="3" v-model="item.optionName"></el-input></el-col>
                            </el-row>
            </el-form-item>-->
            <el-form-item>
              <el-row>
                <el-col :span="9">
                  <el-button type="primary" @click="saveSelect(item,index)">保存</el-button>
                </el-col>
              </el-row>
            </el-form-item>
          </el-form>
        </el-row>
        <div class="operateBtn">
          <i class="el-icon-delete" @click="deleteSelect(item,index)"/>
        </div>
      </div>
    </div>
    <!-- 题目类型 -->
    <div class="examBlock">
      <div class="examType">
        <i class="el-icon-circle-plus add"/>
        <el-button @click="addQitem(1)">
          <i class="el-icon-remove-outline"/>单选题
        </el-button>
        <el-button @click="addQitem(2)">
          <i class="el-icon-circle-check-outline"/>多选题
        </el-button>
        <el-button @click="addQitem(3)">
          <i class="el-icon-time"/>主观题
        </el-button>
      </div>
    </div>
    <!-- 操作按钮 -->
    <el-row type="flex" justify="center">
      <el-col :span="1">
        <el-button type="primary" @click="goBack($route)">返回</el-button>
      </el-col>
    </el-row>
  </el-card>
</template>

<script>
import { api } from '@/api/hr/train'
import ExamTitle from '@/components/QuestionType/examTitle.vue'
export default {
  components: { ExamTitle },
  // 自定义指令-鼠标点击外事件
  directives: {
    clickOutside: {
      // 初始化指令
      bind(el, binding, vnode) {
        function clickHandler(e) {
          // 这里判断点击的元素是否是本身，是本身，则返回
          if (el.contains(e.target)) {
            return false
          }
          // 判断指令中是否绑定了函数
          if (binding.expression) {
            // 如果绑定了函数 则调用那个函数，此处binding.value就是handleClose方法
            binding.value(e)
          }
        }
        // 给当前元素绑定个私有变量，方便在unbind中可以解除事件监听
        el.__vueClickOutside__ = clickHandler
        document.addEventListener('click', clickHandler)
      },
      update() {},
      unbind(el, binding) {
        // 解除事件监听
        document.removeEventListener('click', el.__vueClickOutside__)
        delete el.__vueClickOutside__
      }
    }
  },
  data() {
    return {
      activeName: 'first',
      isStop: false,
      // 试题题目
      upperCase: [
        'A',
        'B',
        'C',
        'D',
        'E',
        'F',
        'G',
        'H',
        'I',
        'J',
        'K',
        'L',
        'M',
        'N',
        'O',
        'P',
        'Q',
        'R',
        'S',
        'T',
        'U',
        'V',
        'W',
        'X',
        'Y',
        'Z'
      ],
      formData: {
        questionList: []
      }
    }
  },
  created() {
    this.init()
  },
  methods: {
    // 1.初始化
    init() {
      const data = {
        projectId: this.$route.query.id
      }
      api('hr/train/quest/selectInvestigateQuest', data).then(res => {
        if (res.data.code === '0000') {
          this.formData = res.data.data
          // 添加题目修改状态字段
          if (this.formData.questionList) {
            this.formData.questionList.forEach((item, index) => {
              item['Qnum'] = index + 1
              item['isModify'] = false
            })
          }
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 2.鼠标移入移除
    changeActive($event) {
      $event.currentTarget.className = 'examBlock bgColor'
    },
    removeActive($event) {
      $event.currentTarget.className = 'examBlock'
    },
    // 3.渲染列表中修改
    modifySelect(item, index) {
      item.isModify = true
      this.$set(this.formData.questionList, index, item)
    },
    // 4.先保存
    saveFirst() {
      if (this.isStop) {
        return false
      }
      this.$message.warning('请先保存此模块！')
    },
    // 5.渲染列表中保存
    saveSelect(item, index) {
      const vm = this
      item.isModify = false
      item.titleOptionList.forEach((item2, index2) => {
        item2.optionId = vm.upperCase[index2]
      })
      api('hr/train/quest/updateQuestionQuest', item).then(res => {
        if (res.data.code === '0000') {
          this.$set(this.formData.questionList, index, item)
          this.$message.success('保存成功！')
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 6.添加题目选项
    addOption(index) {
      const item = {
        optionId: this.upperCase[
          this.formData.questionList[index].titleOptionList.length
        ],
        optionName: ''
      }
      this.formData.questionList[index].titleOptionList.push(item)
    },
    // 7.删除题目选项
    deleteOption(index1, index2, item2) {
      // 前
      this.formData.questionList[index1].titleOptionList.splice(index2, 1)
      // 后
      if (!this.formData.questionList[index1].deltitleOptionList) {
        this.formData.questionList[index1]['deltitleOptionList'] = []
      }
      this.formData.questionList[index1].deltitleOptionList.push(item2)
    },
    // 8.渲染列表中删除题目
    deleteSelect(item, index) {
      this.isStop = true
      this.$confirm(`删除这道题目, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const data = {
          titleId: item.titleId
        }
        api('hr/train/quest/deleteQuestionQuest', data).then(res => {
          if (res.data.code === '0000') {
            this.formData.questionList.splice(index, 1)
            this.isStop = false
            this.$message.success('删除成功！')
          } else {
            this.$message.error(res.data.result)
          }
        })
      })
    },
    // 9.添加类型题目
    addQitem(titleType) {
      if (!this.formData.questionList) {
        this.formData['questionList'] = []
      }
      const item = {
        Qnum: this.formData.questionList.length + 1,
        titleName: '',
        titleType: titleType,
        isModify: true, // 新增的是修改状态
        isShowAnswer: 2,
        projectId: this.$route.query.id,
        titleOptionList: []
      }
      this.formData.questionList.push(item)
    },
    // 返回
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          const latestView = visitedViews.slice(-1)[0]
          if (latestView) {
            this.$router.push('question-invest')
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
.examBlock {
  position: relative;
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
  .operateBtn {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 120px;
    height: 100%;
    position: absolute;
    right: 0;
    top: 0;
    background-color: #f5f5f5;
    visibility: hidden;
    i {
      font-size: 22px;
      color: #999;
      margin: 15px 0;
      cursor: pointer;
    }
  }
}
.editContent {
  border-top: 1px dashed #ccc;
  border-bottom: 1px dashed #ccc;
  padding: 20px;
}
.bgColor {
  background-color: #fafafa;
  cursor: pointer;
}
.examBlock:hover .operateBtn {
  visibility: visible;
}
</style>

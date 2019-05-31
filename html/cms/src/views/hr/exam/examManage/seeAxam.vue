<template>
  <!--答题页面-->
  <div class="seeAxam">
    <my-container>
      <el-card class="subjectCard">
        <div class="subject">
          <div class="seeAxamHead">
            <p>{{ examInfo.examinaName }}</p>
            <el-row>
              <el-col :span="6" class="col-6">
                <div class="grid-content bg-purple">
                  <p>姓名</p>
                  <p>{{ examInfo.name }}</p>
                </div>
              </el-col>
              <el-col :span="6" class="col-6">
                <div class="grid-content bg-purple">
                  <p>正确率</p>
                  <p>{{ examInfo.accuracyRate }}</p>
                </div>
              </el-col>
              <el-col :span="6" class="col-6">
                <div class="grid-content bg-purple">
                  <p>得分率</p>
                  <p>{{ examInfo.scoreRate }}</p>
                </div>
              </el-col>
              <el-col :span="6" class="col-6">
                <div class="grid-content bg-purple">
                  <p v-if="examInfo.isAdopt==1" class="check">
                    <i class="el-icon-check"/>通过考试
                  </p>
                  <p v-else class="error">
                    <i class="el-icon-error"/>未通过
                  </p>
                  <p>{{ examInfo.achievement }}</p>
                </div>
              </el-col>
            </el-row>
          </div>
          <!--试卷模式-->
          <div
            v-for="(item,index) of examInfo.examinabanksList"
            v-show="!cardAnswer && (item.errorFlag || isExamErrorInfo)"
            :key="index"
            class="examList">
            <!--<p v-for="i in 22">5433</p>-->
            <el-card :id="'examID'+index" style="margin-top: 10px;">
              <div class="disabledCheck">
                <p style="font-size:14px;">
                  <span>Q{{ index+1 }}</span>&nbsp;&nbsp;
                  <span>{{ item.examinationQuestion }}</span>&nbsp;&nbsp;
                  <span v-if="item.testQuestionType==1">[ 单选题 ]</span>
                  <span v-if="item.testQuestionType==2">[ 多选题 ]</span>
                  <span v-if="item.testQuestionType==3">[ 主观题 ]</span>
                  <span v-if="item.testQuestionType==4">[ 判断题 ]</span>
                  <span>(满分：{{ item.fraction }})</span>
                </p>
                <div
                  v-if="item.testQuestionType == 1 || item.testQuestionType == 2"
                  style="padding-left:10px;"
                >
                  <p v-for="(item2,index2) of item.optionList" :key="index2" style="font-size:14px;">
                    <el-radio
                      v-if="item.testQuestionType == 1"
                      v-model="examInfo.examinabanksList[index].answer"
                      :label="item2.optionId"
                    />&nbsp;&nbsp;
                    <el-checkbox
                      v-if="item.testQuestionType == 2"
                      v-model="examInfo.examinabanksList[index].answer"
                      :label="item2.optionId"
                    >{{ item2.optionId }}</el-checkbox>&nbsp;&nbsp;
                    <span>{{ item2.optionName }}</span>
                  </p>
                </div>
                <div v-if="item.testQuestionType == 4" style="padding-left:10px;">
                  <el-radio v-model="examInfo.examinabanksList[index].answer" :label="'Y'">正确</el-radio>&nbsp;&nbsp;
                  <el-radio v-model="examInfo.examinabanksList[index].answer" :label="'N'">错误</el-radio>&nbsp;&nbsp;
                </div>
                <el-input
                  v-if="item.testQuestionType == 3"
                  v-model="item.answer"
                  type="textarea"
                  rows="5"
                />
              </div>

              <div
                :class="{ 'errorBox': item.errorFlag, 'checkBox': !item.errorFlag}"
                class="resultBox"
              >
                <p v-if="item.errorFlag" class="error">
                  <i class="el-icon-error"/> 答错了
                </p>
                <p v-else class="check">
                  <i class="el-icon-check"/> 恭喜你！答对了!
                </p>
                <p>
                  得分：
                  <span class="score">{{ item.titleScore }}</span>分
                </p>
                <p>标准答案：{{ item.standardAnswer }}</p>
                <div v-if="isEdit" class="clearfix">
                  <div class="fl">
                    <span style="line-height: 40px;">评判结果：</span>
                    <el-radio-group v-model="item.errorFlag" @change="chanageUpdateRadio(item)">
                      <el-radio :label="false">正确</el-radio>
                      <el-radio :label="true">错误</el-radio>
                    </el-radio-group>
                  </div>
                  <div style="float: left;margin-left: 30px;line-height: 40px;">
                    <span>得分：</span>
                    <el-input-number
                      :min="0"
                      :max="parseInt(item.fraction)"
                      v-model="item.titleScore"
                      size="mini"
                      @change="chanageUpdate(item)"
                    />
                  </div>
                </div>
              </div>
            </el-card>
          </div>
          <!--答题卡模式-->
          <div v-show="cardAnswer" class="cardAnswer">
            <p class="cardAnswerHead">答题卡</p>
            <el-card>
              <el-button
                v-for="(item,index) of examInfo.examinabanksList"
                :type="item.errorFlag?'danger':'success'"
                :key="index"
                circle
                @click="returnCom('#examID'+index)"
              >{{ index }}</el-button>
            </el-card>
          </div>
          <div class="footerBox">
            <!--<my-container>-->
            <el-button-group v-if="!isEdit" class="subjectCardFooter">
              <el-button class="btn" @click="switchAnswer">{{ cardAnswer?'返回到试卷':'答题卡' }}</el-button>
              <el-button
                id="examID3"
                class="btn"
                type="danger"
                @click="filterData"
              >{{ !isExamErrorInfo?'查看全部':'只看错题' }}</el-button>
            </el-button-group>
            <el-button-group v-else class="subjectCardFooterEdit">
              <el-button class="btn" @click="switchAnswer">{{ cardAnswer?'返回到试卷':'答题卡' }}</el-button>
              <el-button
                id="examID3"
                class="btn"
                type="danger"
                @click="filterData"
              >{{ !isExamErrorInfo?'查看全部':'只看错题' }}</el-button>
              <el-button id="examID3" class="btn" type="primary" @click="submit">提交评卷</el-button>
            </el-button-group>
            <!--</my-container>-->
          </div>
        </div>
      </el-card>
    </my-container>
  </div>
</template>

<script>
import moment from 'moment'
import myContainer from '@/components/responseBox/myContainer' // use clipboard by v-directive
import {
  examSelectExamAndAnswerCard,
  examUpdateResult
} from '@/api/hr/examManage'
export default {
  components: {
    myContainer
  },
  data() {
    return {
      isEdit: true,
      cardAnswer: false,
      userFrom: {
        jobNumber: '',
        id: ''
      },
      isExamErrorInfo: true,
      examInfo: {}
    }
  },
  created() {
    if (this.$route.query.title === '人工评卷') {
      this.isEdit = true
    } else {
      this.isEdit = false
    }
    console.log(Date.parse(new Date(moment().format('YYYY-MM-DD hh:mm:ss'))))
    this.userFrom.id = this.$route.query.id
    this.userFrom.jobNumber = this.$route.query.jobNumber
    this.initData()
  },
  methods: {
    initData() {
      examSelectExamAndAnswerCard(this.userFrom).then(res => {
        if (res.data.code === '0000') {
          if (
            res.data.data.examinabanksList &&
            res.data.data.examinabanksList.length > 0
          ) {
            res.data.data.examinabanksList.forEach(item => {
              if (item.testQuestionType === '2') {
                item.answer = item.answer.split(',') // q
              }
            })
          }
          this.examInfo = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    /* 提交评卷 */
    submit() {
      const examQuery = JSON.parse(JSON.stringify(this.examInfo))
      if (examQuery.examinabanksList && examQuery.examinabanksList.length > 0) {
        examQuery.examinabanksList.forEach(item => {
          if (item.testQuestionType === '2') {
            item.answer = item.answer.join()
          }
        })
      }
      examUpdateResult(examQuery).then(res => {
        if (res.data.code === '0000') {
          this.initData()
          this.$message({
            message: '保存成功',
            type: 'success'
          })
          this.$router.go(-1)
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    chanageUpdateRadio(item) {
      item.updateFlag = true
    },
    chanageUpdate(item) {
      item.updateFlag = true
    },
    /* 过滤数据*/
    filterData() {
      this.isExamErrorInfo = !this.isExamErrorInfo
    },
    /* 试卷答题卡切换*/
    switchAnswer() {
      this.cardAnswer = !this.cardAnswer
    },
    /* 锚点跳转*/
    returnCom(comment) {
      this.cardAnswer = false
      setTimeout(function() {
        const returnEle = document.querySelector(comment)
        if (returnEle) {
          returnEle.scrollIntoView(true)
        }
      }, 50)
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>

<style lang="scss" scoped>
.seeAxam {
  .seeAxamHead {
    text-align: center;
    line-height: 20px;
    .col-6 {
      border: 1px solid #ccc;
    }
  }
  .check {
    color: green;
  }
  .error {
    color: red;
  }
  .disabledCheck {
    pointer-events: none;
    cursor: default;
    opacity: 0.9;
  }
  .examInfo {
    padding: 10px;
    .notes {
      display: inline-block;
      margin-top: 20px;
      color: red;
      text-indent: 18px;
    }
    .demo-ruleForm {
      .btn {
        margin-top: 10px;
        height: 50px;
        width: 100%;
      }
      .user-test {
        color: #999;
        font-size: 12px;
        text-align: center;
      }
    }
  }
  .subjectCard {
    margin-bottom: 80px;
    .resultBox {
      margin-top: 20px;
      padding: 5px 20px;
      .score {
        color: red;
      }
    }
    .errorBox {
      background-color: #eeeeee;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(255, 0, 0, 0.8);
    }
    .checkBox {
      background-color: #fff;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 255, 0, 0.8);
    }
    .cardAnswer {
      .cardAnswerHead {
        color: red;
        text-align: center;
      }
    }
    .footerBox {
      /*width: 100%;*/
      /*position: fixed;*/
      /*left: 0;*/
      /*bottom: 0;*/
    }
    .subjectCardFooter {
      width: 100%;
      text-align: center;
      .btn {
        height: 50px;
        width: 50%;
      }
    }
    .subjectCardFooterEdit {
      width: 100%;
      text-align: center;
      .btn {
        height: 50px;
        width: 33.33%;
      }
    }
  }
  background-color: #fff;
}
</style>

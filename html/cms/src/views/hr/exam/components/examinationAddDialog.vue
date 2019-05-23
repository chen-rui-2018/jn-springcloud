<template>

  <div class="examDialog">
    <el-card>
      <el-form ref="addForm" :model="addForm" :rules="rules" label-width="120px">
        <el-form-item label="试题类型：" prop="testQuestionType">
          <el-select
            v-model="addForm.testQuestionType"
            placeholder="请选择"
            clearable
            style="width: 200px"
            class="filter-item"
            @change="clearForm">
            <el-option label="请选择" value=""/>
            <el-option label="单选" value="1"/>
            <el-option label="多选" value="2"/>
            <el-option label="问答题" value="3"/>
            <el-option label="判断题" value="4"/>
          </el-select>
        </el-form-item>
        <el-form-item label="试题内容：" prop="examinationQuestion">
          <el-input v-model="addForm.examinationQuestion" type="textarea" placeholder="" clearable/>
        </el-form-item>
        <div class="exam-bg">
          <div class="exam-hd" vi-if="addForm.testQuestionType!=3">
            <h4>设置正确答案</h4><span>选项内容</span>
          </div>
          <div class="cl"/>
          <div v-if="addForm.testQuestionType=='1'" class="exam-option-radio">
            <el-radio-group v-model="addForm.answerNumber">
              <ul class="exam-option">
                <li v-for="(item,index) in addForm.optionList" :key="index">
                  <el-radio :label="item.optionId">
                    <el-form-item
                      :label="item.optionId+':'"
                      :prop="'optionList.' + index + '.optionName'"
                      :rules="{required: true, message: '请输入选项内容', trigger: 'blur'}"
                      label-width="30px">
                      <el-input
                        v-model="item.optionName"
                        type="text"
                        style="width:800px;"
                        placeholder=""
                        clearable/>
                    </el-form-item>
                  </el-radio>
                  <el-button
                    v-if="index>3"
                    type="danger"
                    size="small"
                    icon="el-icon-delete"
                    circle
                    @click="deleteOption(index)"/>
                </li>
              </ul>
            </el-radio-group>
            <div class="cl"/>
            <el-button class="filter-item" type="primary" @click="addOption">添加
            </el-button>
          </div>
          <div v-if="addForm.testQuestionType=='2'" class="exam-option-checkbox">
            <el-checkbox-group v-model="answers">
              <ul class="exam-option">
                <li v-for="(item,index) in addForm.optionList" :key="index">
                  <el-checkbox :label="item.optionId">
                    <el-form-item
                      :label="item.optionId+':'"
                      :prop="'optionList.' + index + '.optionName'"
                      :rules="{required: true, message: '请输入选项内容', trigger: 'blur'}"
                      label-width="30px">
                      <el-input
                        v-model="item.optionName"
                        type="text"
                        style="width:800px;"
                        placeholder=""
                        clearable/>
                    </el-form-item>
                  </el-checkbox>
                  <el-button
                    v-if="index>3"
                    type="danger"
                    size="small"
                    icon="el-icon-delete"
                    circle
                    @click="deleteOption(index)"/>
                </li>
              </ul>
            </el-checkbox-group>
            <div class="cl"/>
            <el-button class="filter-item" type="primary" @click="addOption">添加
            </el-button>
          </div>
          <div v-if="addForm.testQuestionType=='3'" class="exam-option-question">

            <el-form-item label="答案：" prop="answerHtml">
              <el-input v-model="addForm.answerHtml" type="textarea" placeholder="" clearable/>
            </el-form-item>

          </div>
          <div v-if="addForm.testQuestionType=='4'" class="exam-option-judge">
            <el-form-item label="答案：">
              <el-radio v-model="addForm.answerNumber" label="Y">对</el-radio>
              <el-radio v-model="addForm.answerNumber" label="N">错</el-radio>
            </el-form-item>
          </div>

          <div>
            <el-row>
              <el-col :span="12">
                <el-form-item label="试题分数：" prop="fraction">
                  <el-input
                    v-model="addForm.fraction"
                    :maxlength="3"
                    type="number"
                    placeholder=""
                    clearable
                    style="width: 200px"/>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="难易度：" prop="examinationDifficulty">
                  <el-select
                    v-model="addForm.examinationDifficulty"
                    placeholder="请选择"
                    clearable
                    style="width: 200px"
                    class="filter-item">
                    <el-option label="请选择" value=""/>
                    <el-option label="不限难度" value="1"/>
                    <el-option label="容易" value="2"/>
                    <el-option label="中等" value="3"/>
                    <el-option label="困难" value="4"/>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-form-item label="试题分析：" prop="itemAnalysis">
              <el-input v-model="addForm.itemAnalysis" type="textarea" placeholder="" clearable/>
            </el-form-item>

            <el-form-item>
              <el-button :disabled="isDisabled" type="primary" @click="addForm.testQuestionId==''?submitForm():updateData()">确定
              </el-button>
              <el-button @click="cancel">取消</el-button>
            </el-form-item>
          </div>
        </div>
      </el-form>
    </el-card>
  </div>

</template>

<script>

import {
  selectExaminabank, addExaminationBank, updateExaminationbank
} from '@/api/hr/examinationList'

export default {
  props: ['examItem'],
  data() {
    const checkAnswerHtml = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入答案'))
      } else {
        callback()
      }
    }
    const positive = /^[1-9]\d{0,2}$/
    const checkRate = (rule, value, callback) => {
      if (!positive.test(value)) {
        callback(new Error('分数不合法'))
      } else {
        callback()
      }
    }

    return {
      title: '',
      isDisabled: false,
      rules: {
        testQuestionType: [{ required: true, message: '请选择试题类型', trigger: 'change' }],
        examinationQuestion: [{ required: true, message: '请输入试题内容', trigger: 'blur' }],
        answerHtml: [{ validator: checkAnswerHtml, trigger: 'blur' }],
        fraction: [{ required: true, message: '请输入分数', trigger: 'blur' }, { validator: checkRate, trigger: 'blur' }],
        examinationDifficulty: [{ required: true, message: '请选择难易度型', trigger: 'change' }]
      },
      addForm: {
        testQuestionId: '',
        testQuestionType: '',
        examinationDifficulty: '',
        examinationQuestion: '',
        optionList: [{ optionId: 'A', optionName: '', serialNumber: 0 },
          { optionId: 'B', optionName: '', serialNumber: 1 },
          { optionId: 'C', optionName: '', serialNumber: 2 },
          { optionId: 'D', optionName: '', serialNumber: 3 }],
        answerNumber: '', // 单选,多选逗号分隔,判断Y/N
        answerHtml: '', // 问答
        fraction: ''
      },
      answers: [],
      optionMap: [
        { id: 0, label: 'A' },
        { id: 1, label: 'B' },
        { id: 2, label: 'C' },
        { id: 3, label: 'D' },
        { id: 4, label: 'E' },
        { id: 5, label: 'F' },
        { id: 6, label: 'G' },
        { id: 7, label: 'H' },
        { id: 8, label: 'I' },
        { id: 9, label: 'J' }
      ]
    }
  },
  mounted() {
    console.log('initList')
    this.initList()
  },
  methods: {
    initList() {
      const query = this.examItem
      if (query.testQuestionId) {
        this.addForm.testQuestionId = query.testQuestionId
        selectExaminabank({ testQuestionId: query.testQuestionId }).then(res => {
          if (res.data.code === '0000') {
            this.addForm = Object.assign({}, res.data.data)
            if (this.addForm.testQuestionType === '2') {
              if (this.addForm.answerNumber) {
                this.answers = this.addForm.answerNumber.split(',')
              }
            }
            this.addForm.optionList.sort((item1, item2) => {
              return item1.serialNumber - item2.serialNumber
            })
          } else {
            this.$message.error(res.data.result)
          }
        })
      } else {
        this.addForm.testQuestionId = ''
      }
    },
    clearForm() {
      this.addForm.answerNumber = ''
      this.addForm.answerHtml = ''
      this.addForm.optionList = this.addForm.optionList.slice(0, 4)
      // this.$refs['addForm'].resetFields()
    },
    addOption() {
      if (this.addForm.optionList.length >= 10) {
        this.$message.error('最多添加个选项')
        return
      }
      this.addForm.optionList.push({
        optionId: this.optionMap[this.addForm.optionList.length].label, optionName: '',
        serialNumber: this.addForm.optionList.length
      })
    },
    deleteOption(index) {
      this.addForm.optionList.splice(index, 1)
      this.addForm.optionList.forEach((item, index2) => {
        item.optionId = this.optionMap[index2].label
      })
    },
    submitForm() {
      console.log('submitForm')
      this.isDisabled = true
      this.$refs['addForm'].validate(valid => {
        if (valid) {
          // 判断单选或判断是否勾选答案
          if (this.addForm.testQuestionType === '1' || this.addForm.testQuestionType === '4') {
            if (this.addForm.answerNumber === '') {
              this.$message.error('请选择试题答案')
              this.isDisabled = false
              return
            }
          }
          // 判断多选是否勾选答案
          if (this.addForm.testQuestionType === '2') {
            if (this.answers.length === 0) {
              this.$message.error('请选择试题答案')
              this.isDisabled = false
              return
            }
            this.addForm.answerNumber = this.answers.sort().join(',')
          }
          addExaminationBank(this.addForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              this.$emit('confirmAddExam', { type: 1, examItem: { ...Object.assign(this.addForm, res.data.data) }})
              //              this.$router.push('examinationList')
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
    updateData() {
      this.isDisabled = true
      this.$refs['addForm'].validate(valid => {
        if (valid) {
          // 判断单选或判断是否勾选答案
          if (this.addForm.testQuestionType === '1' || this.addForm.testQuestionType === '4') {
            if (this.addForm.answerNumber === '') {
              this.$message.error('请选择试题答案')
              this.isDisabled = false
              return
            }
          }
          // 判断多选是否勾选答案
          if (this.addForm.testQuestionType === '2') {
            if (this.answers.length === 0) {
              this.$message.error('请选择试题答案')
              this.isDisabled = false
              return
            }
            this.addForm.answerNumber = this.answers.sort().join(',')
          }

          updateExaminationbank(this.addForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              this.$emit('confirmAddExam', { type: 1, examItem: { ...Object.assign(this.addForm, res.data.data) }})
              //              this.$router.push('examinationList')
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
    cancel() {
      this.$emit('confirmAddExam', { type: 0 })
      //      this.$router.push('examinationList')
    }
  }
}
</script>

<style lang="scss" scoped>

  .cl {
    clear: both;
  }

  .margin-bt {
    margin-bottom: 20px;
  }

  .examDialog {
    .exam-bg {
      margin: 10px 20px;
      border: 1px solid #F6F8FA;

      .exam-hd {
        background-color: #EFF2F5;
        overflow: hidden;
        height: 64px;
        h4 {
          font-size: 14px;
          width: 200px;
          height: 64px;
          line-height: 64px;
          float: left;
          margin: 0;
          padding-left: 10px;
        }
        span {
          float: left;
          margin-left: 100px;
          height: 64px;
          line-height: 64px;
          font-size: 14px;
          font-weight: bold;
        }

      }

    }
    .exam-option-radio .exam-option {
      overflow: hidden;
      padding-top: 20px;
    }
    .exam-option-radio {
      margin-bottom: 20px;
    }
    .exam-option-radio .exam-option ul li {
      float: left;
      height: 80px;
      line-height: 80px;
      margin-bottom: 10px;

    }
    .exam-option-radio .exam-option .el-radio__label > div {
      display: inline-block;
    }
    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
      -webkit-appearance: none;
    }
    input[type="number"] {
      -moz-appearance: textfield;
    }

  }

</style>

<template>
  <div class="holidayList">

    <div class="con">

      <div class="con-head">假期规则设置</div>

      <div class="con-rule">
        <ul>

          <li v-for="(item,index) in holidayRuleList" :key="item.index" class="con-rule-item">
            <span>职工累计工作已满</span>

            <el-input-number :disabled="setInputDisable(item)" v-model="item.reachedYear" :min="0" :max="99" label=""/>

            <!--<input :disabled="setInputDisable(item)" v-model="item.reachedYear" class="shortInput"
                                         maxlength="3" type="number" placeholder="" clearable>-->
            <span>年不满</span> <!--<input :disabled="setInputDisable(item)" v-model="item.notFullYear" class="shortInput"
                                    maxlength="3" type="number" placeholder="" clearable>-->
            <el-input-number :disabled="setInputDisable(item)" v-model="item.notFullYear" :min="0" :max="99" label=""/>
            <span>年，年休假</span> <!--<input :disabled="setInputDisable(item)" v-model="item.annualLeave" class="shortInput"
                                      maxlength="3" type="number" placeholder="" clearable>-->
            <el-input-number :disabled="setInputDisable(item)" v-model="item.annualLeave" :min="0" :max="99" label=""/>
            <span>天</span>
            <el-button
              @click="item.disabled=false">编辑
            </el-button>
            <el-button
              :disabled="item.disabled"
              type="primary"
              @click="handleSave(item,index)">保存
            </el-button>
            <el-button
              type="danger"
              @click="handleDelete(item,index)">删除
            </el-button>

          </li>
        </ul>

        <div class="bottom-btn">
          <el-button
            @click="handleAdd()">添加规则
          </el-button>
        </div>
      </div>

    </div>

  </div>
</template>

<script>
import {
  getHolidayRuleList, addHolidayRule, updateHolidayRule, deleteHolidayRule
} from '@/api/hr/holidayList'

export default {
  data() {
    return {
      disableInput: true,
      holidayRuleModel: {
        reachedYear: 0,
        notFullYear: undefined,
        annualLeave: undefined,
        ruleId: '',
        disabled: false
      },
      holidayRuleList: [],
      listLoading: false
    }
  },
  computed: {
    setInputDisable() {
      return function(item) {
        console.log('jisuan:' + item.disabled)
        if (item.disabled === undefined) {
          return true
        }
        return item.disabled
      }
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    handleSave(item, index) {
      console.log(item)
      const reg = /^([1-9][0-9]*)|(0)$/
      if (!reg.test(item.reachedYear)) {
        this.$message.error('请正确输入已满年限')
        return
      }
      if (!reg.test(item.notFullYear)) {
        this.$message.error('请正确输入未满年限')
        return
      }
      if (!reg.test(item.annualLeave)) {
        this.$message.error('请正确输入休假天数')
        return
      }
      if (!item.ruleId) {
        addHolidayRule(item).then(res => {
          if (res.data.code === '0000') {
            console.log(res.data.data)
            item.ruleId = res.data.data
            item.disabled = true
            this.holidayRuleList.splice(index, 1, item)
            this.$message.success('保存成功')
          } else {
            this.$message.error(res.data.result)
          }
        })
      } else {
        updateHolidayRule(item).then(res => {
          if (res.data.code === '0000') {
            item.disabled = true
            this.holidayRuleList.splice(index, 1, item)
            this.$message.success('保存成功')
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    handleDelete(item, index) {
      this.$confirm(`此操作将永久删除这条规则数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        if (item.ruleId) {
          deleteHolidayRule(item.ruleId).then(res => {
            if (res.data.code === '0000') {
              this.$message.success('删除成功')
              this.holidayRuleList.splice(index, 1)
            } else {
              this.$message.error(res.data.result)
            }
          })
        } else {
          this.holidayRuleList.splice(index, 1)
        }
      })
    },
    handleAdd() {
      const item = Object.assign({}, this.holidayRuleModel)
      this.holidayRuleList.push(item)
    },
    initList() {
      this.listLoading = true
      getHolidayRuleList({}).then(res => {
        if (res.data.code === '0000') {
          const arr = res.data.data
          arr.map(a => {
            a.disabled = true
          })
          this.holidayRuleList = arr
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    }
  }
}
</script>

<style lang="scss">
  .con {
    margin: 0 auto;
    border: 1px solid #000000;
  }

  .con-head {
    text-align: center;
    font-size: 18px;
    font-weight: bold;
    height: 30px;
    line-height: 30px;

  }

  .shortInput {
    width: 60px;
    height: 30px;
    line-height: 30px;
    border: none;
    border-bottom: 1px solid #c3c3c3;
  }

  .con-rule-item {
    margin-bottom: 5px;
    height: 40px;
  }

  .con-rule-item > span {
    line-height: 30px;
    padding-right: 3px;
  }

  .bottom-btn {
    margin-left: 20px;
    margin-bottom: 20px;
  }
</style>

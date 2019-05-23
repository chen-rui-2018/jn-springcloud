<template>
  <!-- 主观题 -->
  <div class="examItem examBlock">
    <div class="content">
      <el-row>
        <el-form label-width="26px">
          <el-form-item :label="'Q'+Qnum" label-width="26px">
            <el-row class="title">
              <el-col :span="10"><el-input v-model="titleName" placeholder="在此输入主观题题目..."/></el-col>
              <el-col :span="6" style="padding:0 10px;">[问答题]<el-checkbox :checked="isShowAnswer===1?true:false" v-model="isShowAnswer" :true-label="1" :false-label="2" style="padding-left:26px;">必答题</el-checkbox></el-col>
              <!-- <el-col :span="3" style="display:flex;"><span class="score">分值</span><el-input></el-input>分</el-col> -->
            </el-row>
          </el-form-item>
          <!-- <el-form-item>
                        <el-row class="option">
                            <el-col :span="10"><el-input type="textarea" :rows="3" placeholder="在此输入主观题答案..."></el-input></el-col>
                        </el-row>
                    </el-form-item> -->
        </el-form>
      </el-row>
    </div>
    <div class="operateBtn"><i class="el-icon-delete" @click="deleteQuestion(Qnum)"/></div>
  </div>
</template>

<script>
export default {
  props: ['Qnum'],
  data() {
    return {
      titleName: '',
      titleType: 3,
      isShowAnswer: 2
    }
  },
  methods: {
    // 传送数据
    passData() {
      const data = {
        titleName: this.titleName,
        isShowAnswer: this.isShowAnswer
      }
      return data
    },
    // 删除题目
    deleteQuestion(Qnum) {
      this.$confirm(`删除这道主观题, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$emit('deleteQitem', Qnum)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
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
        align-items:center;
        i.add {
            font-size:30px;
            color:#67C23A;
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
            font-size:20px;
        }
    }
    .addOption {
        width:100%;
    }
    .score {
        display: inline-block;
        width: 60px;
    }
}
.examItem {
    position:relative;
    background-color:#fafafa;
    .operateBtn {
        display: flex;
        justify-content: center;
        align-items: center;
        width:120px;
        height:100%;
        position:absolute;
        right:0;
        top:0;
        background-color:#F5F5F5;
        i {
            font-size: 22px;
            color: #999;
            cursor: pointer;
        }
    }
}
</style>

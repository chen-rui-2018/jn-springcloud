<template>
  <!--交卷页面-->
  <div class="resultPage">
    <my-container>
      <el-card class="box-card">
        <div class="resultTop">
          {{ resultInfo.achievement }}分
        </div>
        <!-- <el-progress :percentage="100" type="circle" status="text" >{{ resultInfo.achievement }}分</el-progress> -->
        <p >{{ resultInfo.achievement>=resultInfo.passScore?'恭喜您，成功通过本次考试！':'很遗憾没用通过考试！' }}</p>
        <el-row>

          <el-col :span="8">
            <div class="grid-content bg-purple">
              <div class="resultContent">
                <p>正确率 </p>
                <p>{{ resultInfo.accuracyRate }}</p>
              </div>
              <!-- <el-progress :percentage="0" :width="100" :stroke-width="3" type="circle" status="text">
                <p>正确率 </p>
                <p>{{ resultInfo.accuracyRate }}</p>
              </el-progress> -->
            </div>
          </el-col>
          <el-col :span="8">
            <div class="grid-content bg-purple-light">
              <div class="resultContent">
                <p>得分率 </p>
                <p>{{ resultInfo.scoreRate }}</p>
              </div>
              <!-- <el-progress :percentage="0" :width="100" :stroke-width="3" type="circle" status="text">
                <p>得分率 </p>
                <p>{{ resultInfo.scoreRate }}</p>
              </el-progress> -->
            </div>
          </el-col>
          <el-col :span="8">
            <div class="grid-content bg-purple">
              <div class="resultContent">
                <p>用时(分钟)  </p>
                <p>{{ resultInfo.useTime?resultInfo.useTime:'暂无统计' }}</p>
              </div>
              <!-- <el-progress :percentage="0" :width="100" :stroke-width="3" type="circle" status="text">
                <p>用时(分钟) </p>
                <p>{{ resultInfo.useTime?resultInfo.useTime:'暂无统计' }}</p>
              </el-progress> -->
            </div>
          </el-col>
        </el-row>
        <p>请截图保存二维码方便查看成绩</p>
        <vue-qr :size="191" :margin="0" :auto-color="true" :dot-scale="1" :text="resultPageUrl" />
      </el-card>

    </my-container>

  </div>
</template>

<script>
import VueQr from 'vue-qr'
import myContainer from '../../components/responseBox/myContainer' // use clipboard by v-directive
import {
  examSelectExamAndAnswerCard
} from '@/api/hr/examManage'
export default {
  components: {
    VueQr,
    myContainer
  },
  data() {
    return {
      resultPageUrl: window.location.href,
      userFrom: {
        id: ''
      },
      resultInfo: {}

    }
  },
  created() {
    this.userFrom = { ...this.$route.query }
    this.initData()
  },
  methods: {
    initData() {
      examSelectExamAndAnswerCard(this.userFrom).then(res => {
        if (res.data.code === '0000') {
          this.resultInfo = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
	.resultPage {
		text-align: center;
    .resultTop{
      margin: 0 auto;
      line-height: 110px;
      width: 120px;
      height: 120px;
      border: #409EFF 6px solid;
      border-radius: 50%
    }
    .resultContent{
      font-size: 12px;
      color: #666;
      padding-top: 28px;
      margin: 0 auto;
      width: 100px;
      height: 100px;
      border: rgb(228, 219, 219) 2px solid;
      border-radius: 50%;
      p{
        margin: 0;
        padding: 0;
        line-height: 24px;
      }
    }
	}
</style>

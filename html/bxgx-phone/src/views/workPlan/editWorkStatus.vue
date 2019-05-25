<template>
  <div class="editWorkStatus">
    <div class='editWorkStatus-header'>{{workForm.workPlanName}} <span>></span> {{workStatus}}</div>
    <group label-align="left" label-width="4.5em" label-margin-right="2em">
      <datetime title="开始时间：" v-show="workStatus==='开始'" v-model="workForm.startTime" format="YYYY-MM-DD HH:mm"
        value-text-align="left" placeholder="请选择实际开始时间"></datetime>
      <div v-show="workStatus==='完成'" class="weui-cell"><span class="doneText">已消耗：</span><span class="weui-input">{{workForm.totalConsumeTime}}小时</span></div>
      <x-input title="总消耗：" v-show="workStatus==='开始'|| workStatus==='完成'" placeholder="请输入总消耗工时" v-model="workForm.totalConsumeTime"
        :show-clear="false"></x-input>
      <datetime title="完成时间：" v-show="workStatus==='完成'" v-model="workForm.endTime" format="YYYY-MM-DD HH:mm"
        value-text-align="left" placeholder="请选择完成时间"></datetime>
      <x-input title="预计剩余：" v-show="workStatus==='开始'" placeholder="请输入剩余工时" v-model="workForm.totalRemainTime"
        :show-clear="false"></x-input>
      <div class="download" v-show="workStatus==='完成'">
        <span>附件：</span>
        <!-- <form :action="url" method="post" name="file" enctype="multipart/form-data"> -->
        <input type="file" @change="fileChange($event)" ref="file">
        <!-- </form> -->
      </div>
      <x-textarea title="备注：" placeholder="请填写备注" :max="num" :autosize='true' :show-counter="false" :rows="3" v-model="workForm.remark"></x-textarea>

      <div class="subBtn"><span @click="submit">{{workStatus}}</span></div>
    </group>

    <fieldset class="fieldest">
      <legend> <strong>历史记录</strong><a v-show="unbtn" href="javascript:;" class="history_a" @click="unfoldText"> <i
            class="iconfont">&#xe636;</i></a>
        <a v-show="!unbtn" href="javascript:;" class="history_a" @click="unfoldText"> <i class="iconfont">&#xe608;</i></a>
      </legend>
      <ul v-show="history.length>0" style="margin:unset;padding:unset">
        <li v-for="(item,index) in history" :key="index">
          <span v-html="(index+1)+'.  '+item.operateRecode +'' ">{{ (index+1)+'. '+ item.operateRecode }}
          </span>
          <span> <a v-show="unbtn" href="javascript:;" class="history_a" @click="unfoldText">
              <i class="iconfont">&#xe636;</i>
            </a>
            <a v-show="!unbtn" href="javascript:;" class="history_a" @click="unfoldText">
              <i class="iconfont">&#xe608;</i>
            </a></span>
          <div class="historyInfo">
            <div v-show="unfold" v-html="item.operateDetails">{{ item.operateDetails }}</div>
            <div v-html="item.remark">{{ item.remark }}</div>
          </div>
        </li>
      </ul>
    </fieldset>
  </div>
</template>

<script>
export default {
  data () {
    return {
      //   workPlanId: '',
      file: '',
      history: [],
      unbtn: true,
      unfold: false,
      workStatus: '',
      num: 500,
      workForm: {
        workPlanName: '',
        startTime: '',
        id: '',
        endTime: '',
        totalConsumeTime: '',
        totalRemainTime: '',
        workPlanStatus: '',
        remark: '',
        attachment: ''
      }
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    submit () {
      if (this.workStatus === '开始') {
        this.workForm.workPlanStatus = '1'
      } else if (this.workStatus === '暂停') {
        this.workForm.workPlanStatus = '2'
      } else if (this.workStatus === '完成') {
        this.workForm.workPlanStatus = '3'
      }
      if (this.workForm.startTime) {
        this.workForm.startTime = this.workForm.startTime + ':00'
      }
      if (this.workForm.endTime) {
        this.workForm.endTime = this.workForm.endTime + ':00'
      }
      if (this.file) {
        const formData = new FormData()
        formData.append('file', this.file)
        this.api.post({
          url: 'uploadAttachment',
          headerType: 'multipart/form-data',
          data: formData,
          callback: res => {
            console.log(res)
            if (res.code === '0000') {
              this.workForm.attachment = res.data
              this.submitWorkForm()
            } else {
              this.$vux.toast.text(res.result, 'top')
              return false
            }
          }
        })
      } else {
        this.submitWorkForm()
      }
    },
    submitWorkForm () {
      this.api.post({
        url: 'updateWorkPlanStatus',
        data: this.workForm,
        callback: res => {
          if (res.code === '0000') {
            this.$vux.toast.text('操作成功', 'top')
            this.$router.push({ path: '/workPlan/workPlan' })
          } else {
            this.$vux.toast.text(res.result, 'top')
            if (this.workForm.startTime) {
              this.workForm.startTime = this.workForm.startTime.substring(
                0,
                16
              )
            }
            if (this.workForm.endTime) {
              this.workForm.endTime = this.workForm.endTime.substring(0, 16)
            }
          }
        }
      })
    },
    fileChange (event) {
      this.file = event.target.files[0]
    },
    // 点击展开和收起
    unfoldText () {
      this.unbtn = !this.unbtn
      this.unfold = !this.unfold
    },
    init () {
      this.workForm.id = this.$route.query.id
      this.workStatus = this.$route.query.title
      this.api.get({
        url: 'getWorkPlanById',
        data: { workPlanId: this.$route.query.id },
        callback: res => {
          console.log(res)
          if (res.code === '0000') {
            if (this.workStatus === '开始') {
              if (res.data.startTime) {
                this.workForm.startTime = res.data.startTime.substring(0, 16)
              }
              this.workForm.totalConsumeTime = res.data.totalConsumeTime
              this.workForm.totalRemainTime = res.data.totalRemainTime
            } else if (this.workStatus === '完成') {
              this.workForm.totalConsumeTime = res.data.totalConsumeTime
            }
            this.workForm.workPlanName = res.data.workPlanName

            this.history = res.data.workPlanHistorys
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    }
  }
}
</script>

<style lang="scss">
.editWorkStatus-header {
  padding: 30px;
  font-size: 50px;
  color: #333;
  font-weight: 700;
  padding-top: 1.4rem;
  span {
    font-size: 0.666667rem;
    color: black;
    padding: 0px 20px;
  }
}
.editWorkStatus {
  padding: 30px;
  .vux-datetime {
    p {
      font-size: 32px;
      width: 2.4rem !important;
      color: #333;
      font-weight: 800;
      margin-right: unset !important;
    }
  }
  .weui-cells {
    // padding: 20px;
    margin: unset;
  }
  .download {
    font-size: 32px;
    color: #333;
    font-weight: 800;
    margin-bottom: 20px;
    // margin-top: 20px;
    display: flex;
    > span {
      margin-right: 1.05rem;
      // width: 2.4rem;
    }
    input {
      font-size: 83%;
    }
  }
  .weui-cell {
    padding: 0.3rem 0;
  }
  .weui-cells:before {
    border: none;
  }
  .subBtn {
    padding: 20px;
    span {
      margin-left: 27%;
      background: rgb(26, 79, 133);
      color: #fff;
      padding: 10px;
    }
  }
  .weui-cell_access .weui-cell__ft {
    padding-left: 0.3rem;
    font-size: 0.4667rem;
  }
  .weui-textarea {
    font-size: 28px;
    border: 1px solid #ccc;
    padding: 15px;
    width: 91%;
  }
  .weui-input,
  .weui-select {
    font-size: 28px;
  }
  .weui-input {
    padding-left: 0.3rem;
  }
  .weui-cell_select-after .weui-select {
    padding-left: 0.3rem;
  }
  .weui-cell_select .weui-cell__bd:after,
  .weui-cell_access .weui-cell__ft:after {
    border-color: #333;
    width: 0.266667rem;
    height: 0.266667rem;
    right: 0.066667rem;
  }
  .weui-label,
  .doneText {
    font-size: 32px;
    width: 2.4rem !important;
    color: #333;
    font-weight: 800;
    margin-right: unset !important;
  }
  .doneText {
    width: 3.3rem !important;
  }
  .fieldest {
    // margin:0.3rem;
    font-size: 28px;
    border: 1px solid #e5e5e5;
    margin-top: 30px;
    padding: 20px 30px 30px;
    legend {
      width: auto;
      margin: 0 0 0 -5px;
      font-size: 32px;
      font-weight: bold;
      border-bottom: 0;
      padding: 0 5px;
      color: #333;
    }
    .historyInfo {
      background: #fbfbfb;
      padding: 4px 10px 6px;
      min-height: 20px;
      margin-left: 20px;
      border: 1px solid #f5f5f5;
      margin: 20px;
      p {
        margin: 20px;
        line-height: 0.566667rem;
      }
    }
    .history_a {
      background: #f1f1f1;
      color: #666 !important;
      //  border: 1px solid #ccc;
      margin-left: 10px;
      display: inline-block;
      > i {
        border-radius: 4px;
        display: inline-block;
        font-size: 0.4rem;
        text-align: center;
      }
    }
  }
}
</style>

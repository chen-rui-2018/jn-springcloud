<template>
  <div class="editWorkPlan">
    <div class="workForm">
      <div class="workTitle">{{workForm.workPlanName}}</div>
      <group label-align="left" label-width="4.5em" label-margin-right="2em">
        <selector title="项目：" :options="workNameList" placeholder="请选择项目名称" v-model="workForm.itemId"></selector>
        <x-input title="任务名称：" placeholder="请输入任务" v-model="workForm.workPlanName" :show-clear="false"></x-input>
        <selector title="任务状态：" :options="workStatusList" placeholder="请选择任务状态" v-model="workForm.workPlanStatus"></selector>

        <selector title="负责人：" multiple :options="workUserList" placeholder="请选择任务负责人" v-model="workForm.responsibleUserAccount"></selector>
        <!-- <x-input title="负责人：" placeholder="请输入内容" v-model="workForm.responsibleUserAccount" :show-clear="false"></x-input> -->
        <datetime title="预计开始时间：" v-model="workForm.planEndTime" value-text-align="left" placeholder="请选择开始时间"></datetime>
        <datetime title="预计截止时间：" v-model="workForm.planStartTime" placeholder="请选择截止时间" value-text-align="left"></datetime>
        <datetime title="实际开始时间：" v-model="workForm.startTime" format="YYYY-MM-DD HH:mm" value-text-align="left"
          placeholder="请选择实际开始时间"></datetime>
        <datetime title="实际截止时间：" v-model="workForm.endTime" format="YYYY-MM-DD HH:mm" placeholder="请选择实际截止时间"
          value-text-align="left"></datetime>
        <x-input title="预计：" placeholder="请输入预计工时" type="number" v-model="workForm.planTime" :show-clear="false"></x-input>
        <x-input title="消耗：" placeholder="请输入消耗工时" type="number" v-model="workForm.totalConsumeTime" :show-clear="false"></x-input>
        <x-input title="剩余：" placeholder="请输入剩余工时" type="number" v-model="workForm.totalRemainTime" :show-clear="false"></x-input>
         <div class="editDiv"><span>需求描述：</span>
          <editDiv v-model="workForm.demandDescribe">
          </editDiv>
        </div>
        <!-- <x-textarea title="需求描述：" placeholder="请输入任务需求描述" :max="num" :autosize='true' :show-counter="false" v-model="workForm.demandDescribe"></x-textarea> -->
        <!-- <x-textarea title="任务内容：" placeholder="请输入任务内容" :max="num" :autosize='true' :show-counter="false" v-model="workForm.content"></x-textarea> -->
        <div class="editDiv"><span>任务内容：</span>
          <editDiv v-model="workForm.content">
          </editDiv>
        </div>
        <div class="download">
          <span>附件：</span>
          <input type="file" @change="fileChange($event)" ref="file">
        </div>
        <x-textarea title="备注：" placeholder="请添加备注" :max="num" :autosize='true' :show-counter="false" v-model="workForm.remark"></x-textarea>
      </group>
      <div class="footer">
        <span @touchstart="submitWork">确认</span>
        <span @touchstart="cancel">取消</span>
      </div>
    </div>
  </div>
</template>

<script>
import editDiv from '@/views/components/editDiv'
export default {
  components: {
    editDiv
  },
  data () {
    return {
      file: '',
      num: 500,
      workNameList: [],
      workUserList: [],
      workStatusList: [
        { key: '0', value: '未开始' },
        { key: '1', value: '进行中' },
        { key: '2', value: '已暂停' },
        { key: '3', value: '已完成' }
      ],
      workForm: {
        id: '',
        workPlanName: '',
        endTime: '',
        startTime: '',
        attachment: '',
        content: this.value,
        demandDescribe: '',
        itemId: '',
        planEndTime: '',
        planStartTime: '',
        planTime: '',
        remark: '',
        responsibleUserAccount: '',
        totalRemainTime: '', // 剩余工时
        workPlanStatus: '', // 任务状态
        totalConsumeTime: '' // 消耗工时
      }
    }
  },
  mounted () {
    this.getItemAll()
    this.init()
    this.getAllUser()
  },
  methods: {
    //   初始化
    init () {
      this.workForm.id = this.$route.query.id
      this.api.get({
        url: 'getWorkPlanById',
        data: { workPlanId: this.$route.query.id },
        callback: res => {
          console.log(res)
          if (res.code === '0000') {
            this.workForm.workPlanName = res.data.workPlanName
            this.workForm.itemId = res.data.itemId
            this.workForm.workPlanName = res.data.workPlanName
            this.workForm.content = res.data.content
            this.workForm.demandDescribe = res.data.demandDescribe
            this.workForm.planEndTime = res.data.planEndTime
            this.workForm.planStartTime = res.data.planStartTime
            if (res.data.startTime) {
              this.workForm.startTime = res.data.startTime.substring(0, 16)
            }
            if (res.data.endTime) {
              this.workForm.endTime = res.data.endTime.substring(0, 16)
            }
            this.workForm.planTime = res.data.planTime
            this.workForm.responsibleUserAccount =
              res.data.responsibleUserAccount
            this.workForm.totalRemainTime = res.data.totalRemainTime
            this.workForm.workPlanStatus = res.data.workPlanStatus
            this.workForm.totalConsumeTime = res.data.totalConsumeTime
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    cancel () {
      this.init()
    },
    submitWorkForm () {
      if (!this.workForm.itemId) {
        this.$vux.toast.text('请选择所属项目')
        return false
      }
      if (!this.workForm.workPlanName) {
        this.$vux.toast.text('请输入工作计划名称')
        return false
      }
      if (!this.workForm.responsibleUserAccount) {
        this.$vux.toast.text('请选择项目负责人')
        return false
      }
      if (!this.workForm.planStartTime) {
        this.$vux.toast.text('请选择计划开始时间')
        return false
      }
      if (!this.workForm.planEndTime) {
        this.$vux.toast.text('请选择计划结束时间')
        return false
      }
      if (!this.workForm.planTime) {
        this.$vux.toast.text('请输入预计工时')
        return false
      }
      if (!this.workForm.content) {
        this.$vux.toast.text('请填写任务内容')
        return false
      }
      if (!this.workForm.demandDescribe) {
        this.$vux.toast.text('请填写需求描述')
        return false
      }
      if (this.workForm.endTime) {
        this.workForm.endTime = this.workForm.endTime + ':00'
      }
      if (this.workForm.startTime) {
        this.workForm.startTime = this.workForm.startTime + ':00'
      }
      this.api.post({
        url: 'update',
        data: this.workForm,
        callback: res => {
          console.log(res)
          if (res.code === '0000') {
            this.$vux.toast.text('编辑成功')
            this.$router.push({ path: '/workPlan/workPlan' })
          } else {
            this.$vux.toast.text(res.result)
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
    submitWork () {
      if (this.file) {
        const formData = new FormData()
        formData.append('file', this.file)
        this.api.post({
          url: 'uploadAttachment',
          headerType: 'multipart/form-data',
          data: formData,
          callback: res => {
            if (res.code === '0000') {
              this.workForm.attachment = res.data
              this.submitWorkForm()
            } else {
              this.$vux.toast.text(res.result)
            }
          }
        })
      } else {
        this.submitWorkForm()
      }
    },
    // 获取所有用户
    getAllUser () {
      this.api.post({
        url: 'getAllUser',
        data: { page: 1, rows: 2000 },
        callback: res => {
          console.log(res)
          if (res.code === '0000') {
            res.data.rows.forEach(val => {
              if (val.name !== null) {
                this.workUserList.push({
                  key: val.account,
                  value: val.name
                })
              } else {
                this.workUserList.push({
                  key: val.account,
                  value: val.account
                })
              }
            })
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    // 获取所有项目
    getItemAll () {
      this.api.get({
        url: 'getItemAll',
        data: {},
        callback: res => {
          if (res.code === '0000') {
            res.data.forEach(val => {
              this.workNameList.push({ value: val.itemName, key: val.id })
            })
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    fileChange (event) {
      this.file = event.target.files[0]
    }
  }
}
</script>

<style lang="scss">
.editWorkPlan {
  padding: 30px;
  .weui-cells {
    margin-top: unset;
  }
  .workForm {
    .editDiv {
      display: flex;
      margin: 20px 0px;
      > span {
        width: 2.4rem;
        font-size: 28px;
        color: #333;
        font-weight: 800;
      }
      > div {
        font-size: 28px;
        border: 1px solid #ccc;
        padding: 15px;
        min-height: 150px;
        width: 72%;
      }
    }
    .workTitle {
      font-size: 50px;
      color: #333;
      padding: 15px 0px;
      //   text-align: center;
    }
    padding-top: 1rem;
    .vux-selector.weui-cell_select,
    .weui-cell {
      padding: 20px 0;
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
    }
    .weui-label {
      font-size: 28px;
      width: 2.4rem !important;
      color: #333;
      font-weight: 800;
      margin-right: unset !important;
    }
    .vux-datetime {
      p {
        font-size: 28px;
        width: 2.4rem !important;
        color: #333;
        font-weight: 800;
        margin-right: unset !important;
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
    .download {
      font-size: 28px;
      color: #333;
      font-weight: 800;
      margin-bottom: 20px;
      display: flex;
      span {
        margin-right: 1.05rem;
      }
      input {
        font-size: 83%;
      }
    }
    .vux-cell-value {
      color: #333;
    }
  }
  .footer {
    margin-top: 50px;
    padding: 20px;
    text-align: center;
    span {
      display: inline-block;
      width: 2rem;
      text-align: center;
      height: 1rem;
      font-size: 28px;
      line-height: 1rem;
      background: rgb(64, 158, 255);
      border-radius: 50px;
      color: #fff;
      margin-right: 30px;
    }
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
}
</style>

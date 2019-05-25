<template>
  <div class="addWorkPlan">
    <!-- <div class="addWorkPlan-header">添加工作计划</div> -->
    <div class="workForm">
      <group label-align="left" label-width="4.5em" label-margin-right="2em">
        <selector title="所属项目：" :options="workNameList" placeholder="请选择项目名称"  v-model="workForm.itemId"></selector>
        <x-input title="任务名称：" placeholder="请输入任务名称" v-model="workForm.workPlanName" required  :show-clear="false"></x-input>
        <selector title="负责人：" :options="workUserList" placeholder="请选择负责人："  v-model="workForm.responsibleUserAccount"></selector>
        <!-- <x-input title="负责人：" placeholder="请输入内容" v-model="workForm.responsibleUserAccount" required :show-clear="false"></x-input> -->
        <datetime title="开始时间：" v-model="workForm.planStartTime" value-text-align="left" placeholder="请选择开始时间"></datetime>
        <datetime title="截止时间：" v-model="workForm.planEndTime" placeholder="请选择截止时间"  value-text-align="left"></datetime>
        <x-input title="预计工时：" type="number" placeholder="请输入内容" class="timeStyle" required v-model="workForm.planTime" :show-clear="false"></x-input>
        <x-textarea title="需求描述：" placeholder="请输入任务需求描述" :max="num" :autosize='true' :show-counter="false" :rows="3"
          v-model="workForm.demandDescribe"></x-textarea>
        <x-textarea title="任务内容：" placeholder="请输入任务内容" :max="num" :autosize='true' :show-counter="false" :rows="3"
          v-model="workForm.content"></x-textarea>
        <div class="download">
          <div>附件：</div>
          <!-- <form :action="url" method="post" name="file" enctype="multipart/form-data"> -->
            <input type="file" @change="fileChange($event)" ref="file">
          <!-- </form> -->
        </div>
      </group>
      <div class="footer">
        <span @touchstart="submitWork">确认</span>
        <span @touchstart="cancel">取消</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      workPlanNameValue: function (value) {
        return {
          valid: !value,
          msg: '任务名称不能为空'
        }
      },
      // url: this.api.host + 'zuul/' + 'springcloud-oa/oa/common/uploadAttachment',
      file: '',
      num: 500,
      workNameList: [],
      workUserList: [],
      workForm: {
        workPlanName: '',
        attachment: '',
        content: '',
        demandDescribe: '',
        itemId: '',
        planEndTime: '',
        planStartTime: '',
        planTime: '',
        responsibleUserAccount: ''
      }
    }
  },
  mounted () {
    this.getItemAll()
    this.getAllUser()
  },
  methods: {
    cancel () {
      this.workForm.workPlanName = ''
      this.workForm.attachment = ''
      this.workForm.content = ''
      this.workForm.demandDescribe = ''
      this.workForm.itemId = ''
      this.workForm.planEndTime = ''
      this.workForm.planStartTime = ''
      this.workForm.planTime = ''
      this.workForm.responsibleUserAccount = ''
    },
    // 获取所有用户
    getAllUser () {
      this.api.post({
        url: 'getAllUser',
        data: {page: 1, rows: 2000},
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
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    },
    submitWorkForm () {
      if (!this.workForm.itemId) {
        this.$vux.toast.text('请选择所属项目', 'top')
        return false
      }
      if (!this.workForm.workPlanName) {
        this.$vux.toast.text('请输入工作计划名称', 'top')
        return false
      }
      if (!this.workForm.responsibleUserAccount) {
        this.$vux.toast.text('请选择项目负责人', 'top')
        return false
      }
      if (!this.workForm.planStartTime) {
        this.$vux.toast.text('请选择计划开始时间', 'top')
        return false
      }
      if (!this.workForm.planEndTime) {
        this.$vux.toast.text('请选择计划结束时间', 'top')
        return false
      }
      if (!this.workForm.planTime) {
        this.$vux.toast.text('请输入预计工时', 'top')
        return false
      }
      if (!this.workForm.content) {
        this.$vux.toast.text('请填写任务内容', 'top')
        return false
      }
      if (!this.workForm.demandDescribe) {
        this.$vux.toast.text('请填写需求描述', 'top')
        return false
      }
      this.api.post({
        url: 'addWorkPlan',
        data: this.workForm,
        callback: res => {
          if (res.code === '0000') {
            this.$vux.toast.text('添加成功', 'top')
            this.$router.push({path: '/workPlan/workPlan'})
          } else {
            this.$vux.toast.text(res.result, 'top')
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
              this.$vux.toast.text(res.result, 'top')
            }
          }
        })
      } else {
        this.submitWorkForm()
      }
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
            this.$vux.toast.text(res.result, 'top')
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
// .weui-toast.vux-toast-top{
//     top:2.4rem !important;
//   }
.addWorkPlan {
  padding: 30px;
  .weui-cells {
    margin-top: unset;
  }
  .workForm {
    padding-top: 1rem;
    .vux-selector.weui-cell_select,
    .weui-cell {
      padding: 20px 0;
    }
    .weui-label {
      font-size: 32px;
      width: 2.4rem !important;
      color: #333;
      font-weight: 800;
      margin-right: unset !important;
    }
    .vux-datetime {
      p {
        font-size: 32px;
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
      font-size: 32px;
      color: #333;
      font-weight: 800;
      margin-bottom: 20px;
      display:flex;
      >div {
        // margin-right: 1.05rem;
        width: 2.4rem;
      }
      input {
        font-size: 84%;
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
  .weui-cell_select .weui-cell__bd:after,.weui-cell_access .weui-cell__ft:after{
        border-color: #333;
    width: 0.266667rem;
    height: 0.266667rem;
        right: 0.066667rem;
  }

}
</style>

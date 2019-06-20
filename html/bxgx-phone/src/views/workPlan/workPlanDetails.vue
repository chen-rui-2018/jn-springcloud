<template>
  <div class="workPlanDetails">
    <div class="workForm">
      <div class="workTitle">{{workForm.workPlanName}}</div>
      <div><span>项目</span><span>{{workForm.itemName}}</span></div>
      <div><span>任务名称</span><span>{{workForm.itemName}}</span></div>
      <div><span>任务状态</span>
        <span v-show="workForm.workPlanStatus==='0'">未开始</span>
        <span v-show="workForm.workPlanStatus==='1'" style="color:red">进行中</span>
        <span v-show="workForm.workPlanStatus==='2'" style="color:rgb(248, 180, 102)">已暂停</span>
        <span v-show="workForm.workPlanStatus==='3'" style="color:green">已完成</span>
      </div>
      <div><span>负责人</span><span>{{workForm.responsibleUserName}}</span></div>
      <div><span>预计开始时间</span><span>{{workForm.planStartTime}}</span></div>
      <div><span>预计截止时间</span><span>{{workForm.planEndTime}}</span></div>
      <div><span>实际开始时间</span><span>{{workForm.startTime}}</span></div>
      <div><span>实际截止时间</span><span>{{workForm.endTime}}</span></div>
      <div><span>预计工时</span><span>{{workForm.planTime}}</span></div>
      <div><span>消耗工时</span><span>{{workForm.totalConsumeTime}}</span></div>
      <div><span>剩余工时</span><span>{{workForm.totalRemainTime}}</span></div>

      <fieldset class="fieldest">
        <legend><strong>需求描述</strong></legend>
        <div v-html="workForm.demandDescribe" />
      </fieldset>
      <fieldset class="fieldest">
        <legend><strong>任务内容</strong></legend>
        <div class="editor-container" v-html="workForm.content">
        </div>
      </fieldset>
      <fieldset class="fieldest">
        <legend>附件</legend>
        <ul v-show="attachment.length>0" style="margin:unset;padding:unset">
          <li v-for="(item,index) in attachment" :key="index" style="margin: 5px 0px;"><a href="javascript:;" download=""
              @click="download(item)"> <i class="fa fa-file-text-o" /> {{ item.title }}</a></li>
        </ul>

      </fieldset>
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
    <div class="footer">
      <a v-show="workForm.workPlanStatus==='0'" href="javascript:;" @click="handleStart"><i class="iconfont">&#xe642;</i></a>
      <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="handlePasue"><i class="iconfont">&#xe620;</i>
      </a>
      <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="handleDelete"><i class="iconfont">&#xe716;</i></a>
      <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="jobLogging"><i class="iconfont">&#xe68b;</i></a>
      <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="isShowRemark = true"><i class="iconfont">&#xe65a;</i>
      </a>
      <a v-show="workForm.workPlanStatus!=='3'" href="javascript:;" @click="handleEdit"><i class="iconfont">&#xe795;</i>
      </a>
      <a href="javascript:;" @click="goBack"><i class="iconfont">&#xe641;</i> </a>
    </div>
    <div  v-if="isShowRemark">
    <fieldset class="fieldest">
      <legend>备注</legend>
      <x-textarea placeholder="请填写备注" :max="num" :autosize='true' :show-counter="false" :rows="3" v-model="workForm.remark"></x-textarea>
    </fieldset>
      <div class="remark-btn">
        <span size="mini" class="submitRemark" @click="submitRemark">保存</span>
        <span size="mini" @click="isShowRemark = false">返回</span>
      </div>
    </div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      num: 500,
      isShowRemark: false,
      attachment: [],
      history: [],
      unbtn: true,
      unfold: false,
      workForm: {
        id: '',
        workPlanName: '',
        endTime: '',
        startTime: '',
        attachment: '',
        itemName: '',
        content: '',
        demandDescribe: '',
        itemId: '',
        planEndTime: '',
        planStartTime: '',
        planTime: '',
        remark: '',
        responsibleUserName: '',
        totalRemainTime: '', // 剩余工时
        workPlanStatus: '', // 任务状态
        totalConsumeTime: '' // 消耗工时
      }
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    //   点击暂停
    handlePasue () {
      this.$router.push({
        path: 'editWorkStatus',
        query: { id: this.workForm.id, title: '暂停' }
      })
    },
    submitRemark () {
      if (!this.workForm.remark) {
        this.$vux.toast.text('请先填写备注信息')
      }
      this.api.post({
        url: 'addRemark',
        data: { id: this.workForm.id, remark: this.workForm.remark },
        callback: res => {
          if (res.code === '0000') {
            this.$vux.toast.text('操作成功')
            this.init()
            this.isShowRemark = false
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    // 点击完成
    jobLogging () {
      this.$router.push({
        path: 'editWorkStatus',
        query: { id: this.workForm.id, title: '完成' }
      })
    },
    // 点击开始
    handleStart () {
      this.$router.push({
        path: 'editWorkStatus',
        query: { id: this.workForm.id, title: '开始' }
      })
    },
    //   附件下载
    download (item) {
      axios
        .get(`${this.api.host}${this.api.apiURL.downLoadAttachment}`, {
          params: {
            title: item.title,
            url: item.url
          },
          headers: {
            token: sessionStorage.token
          }
        })
        .then(res => {
          window.location.href = res.request.responseURL
        })
    },
    // 返回列表页
    goBack () {
      this.$router.push({ path: 'WorkPlan' })
    },
    // 点击展开和收起
    unfoldText () {
      this.unbtn = !this.unbtn
      this.unfold = !this.unfold
    },
    // 删除工作计划
    handleDelete () {
      this.api.post({
        url: 'deleteBatch',
        dataFlag: true,
        data: { workPlanId: this.workForm.id },
        callback: res => {
          if (res.code === '0000') {
            this.$vux.toast.text('操作成功')
            this.$router.push({ path: '/workPlan/workPlan' })
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    // 点击编辑
    handleEdit () {
      this.$router.push({
        path: 'editWorkPlan',
        query: { id: this.workForm.id }
      })
    },
    //   初始化
    init () {
      this.workForm.id = this.$route.query.id
      this.api.get({
        url: 'getWorkPlanById',
        data: { workPlanId: this.$route.query.id },
        callback: res => {
          if (res.code === '0000') {
            this.workForm.workPlanName = res.data.workPlanName
            this.workForm.itemId = res.data.itemId
            this.workForm.itemName = res.data.itemName
            this.workForm.workPlanName = res.data.workPlanName
            this.workForm.content = res.data.content
            this.workForm.demandDescribe = res.data.demandDescribe
            this.workForm.planEndTime = res.data.planEndTime
            this.workForm.planStartTime = res.data.planStartTime
            this.history = res.data.workPlanHistorys
            if (res.data.startTime) {
              this.workForm.startTime = res.data.startTime.substring(0, 16)
            }
            if (res.data.endTime) {
              this.workForm.endTime = res.data.endTime.substring(0, 16)
            }
            if (res.data.attachment) {
              this.attachment = JSON.parse(res.data.attachment)
            }
            this.workForm.planTime = res.data.planTime
            this.workForm.responsibleUserName = res.data.responsibleUserName
            this.workForm.totalRemainTime = res.data.totalRemainTime
            this.workForm.workPlanStatus = res.data.workPlanStatus
            // console.log(this.workForm.workPlanStatus)
            this.workForm.totalConsumeTime = res.data.totalConsumeTime
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    }
  }
}
</script>

<style lang="scss">
.workPlanDetails {
  padding: 30px;
  font-size: 32px;
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
      .weui-cell:before{
          border:none;
      }
      .weui-textarea{
          border:1px solid #ccc;
          padding: 20px;
          min-height: 150px;
          width: 93%;
      }

    }
    .remark-btn{
          padding: 20px;
          span{
              padding: 10px;
          }
          span:nth-child(1){
              background: rgb(26, 79, 133);
              color:#fff;
          }
      }
  .weui-cells {
    margin-top: unset;
  }
  .pd {
    padding: 20px 0px;
  }
  .footer {
    margin: 30px 0px;
    text-align: center;
    i {
      font-size: 40px;
      margin: 10px;
    }
  }
  .workForm {
    > div {
      padding: 15px 0px;
      span:nth-child(1) {
        //  font-size: 32px;
        width: 4rem;
        display: inline-block;
        color: #333;
        font-weight: 800;
        margin-right: unset;
      }
    }
    .workTitle {
      font-size: 50px;
      color: #333;
      padding: 15px 0px;
      //   text-align: center;
    }
    padding-top: 1rem;

  }
}
</style>

<template>

  <div class="write schedule">
    <div id="calendar" />
    <!-- <div :style="tooltipStyle" class="tooltip" v-html="htmlText">2233</div> -->

    <el-dialog :visible.sync="addDialogVisible" :title="titleText" width="600" class="sched">
      <el-form ref="scheduleForm" :rules="rules" :disabled="isdisabled" :model="scheduleForm" label-width="100px">
        <el-form-item label="日程标题:" prop="title">
          <el-input v-model="scheduleForm.title" clearable />
        </el-form-item>
        <el-form-item label="日程内容:" prop="content">
          <el-input v-model="scheduleForm.content" :autosize="{ minRows: 0, maxRows: 6}" type="textarea" placeholder="请输入内容" maxlength="500" show-word-limit clearable/>
        </el-form-item>
        <el-form-item label="全天:">
          <el-radio-group v-model="scheduleForm.allDay">
            <el-radio label="1">是</el-radio>
            <el-radio label="0">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <div class="timeStyle">
          <el-form-item v-if="scheduleForm.allDay==='0'" label="开始时间:" prop="startTime">
            <el-date-picker
              v-model="scheduleForm.startTime"
              value-format="yyyy-MM-dd HH:mm:ss"
              type="datetime"
              placeholder="选择时间" />
          </el-form-item>
          <el-form-item v-if="scheduleForm.allDay!=='0'" label="开始时间:" prop="dateTime">
            <el-date-picker
              v-model="scheduleForm.dateTime"
              value-format="yyyy-MM-dd"
              type="date"
              placeholder="选择日期" />
          </el-form-item>
        </div>
        <div class="timeStyle">
          <el-form-item v-if="scheduleForm.allDay==='0'" label="结束时间:" prop="endTime">
            <el-date-picker
              v-model="scheduleForm.endTime"
              value-format="yyyy-MM-dd HH:mm:ss"
              type="datetime"
              placeholder="选择时间" />
              <!-- <el-date-picker
              v-if="scheduleForm.allDay!=='0'"
              v-model="endTime"
              value-format="yyyy-MM-dd"
              type="date"
              placeholder="选择日期" /> -->
              <!-- <el-time-picker
              v-if="scheduleForm.allDay==='0'"
              v-model="endMinute"
              value-format="HH:mm:ss"
              arrow-control
              placeholder="请选择时间" /> -->
          </el-form-item>
          <el-form-item v-if="scheduleForm.allDay!=='0'" label="结束时间:" prop="dateTime">
            <el-date-picker
              v-model="scheduleForm.dateTime"
              value-format="yyyy-MM-dd"
              type="date"
              placeholder="选择日期" />
          </el-form-item>
        </div>
        <!-- <div v-if="scheduleForm.allDay==='1'">
          <el-form-item label="结束时间:">
            <el-date-picker v-model="scheduleForm.startTime" value-format="yyyy-MM-dd" type="date" placeholder="选择日期" />
          </el-form-item>
        </div> -->
        <el-form-item label="是否提醒" prop="isRemind">
          <el-radio-group v-model="scheduleForm.isRemind">
            <el-radio label="1">是</el-radio>
            <el-radio label="0">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item v-if="scheduleForm.isRemind==='1'" label="提醒时间" class="timeStyle" prop="remindTime">
          <el-date-picker
            v-model="scheduleForm.remindTime"
            value-format="yyyy-MM-dd HH:mm:ss"
            type="datetime"
            placeholder="选择提醒时间" />

        </el-form-item>
        <el-form-item v-if="scheduleForm.isRemind==='1'" label="提醒方式:">
          <el-checkbox-group v-model="scheduleForm.remindWay">
            <el-checkbox label="1">微信</el-checkbox>
            <el-checkbox label="2">短信</el-checkbox>
            <el-checkbox label="4">app端</el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="备注:" prop="remark">
          <el-input v-model="scheduleForm.remark" :autosize="{ minRows: 0, maxRows: 6}" type="textarea" clearable maxlength="500"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button v-if="titleText!=='新增日程'" type="danger" icon="el-icon-delete" size="mini" @click="handleDelete()">删除</el-button>
        <el-button v-if="titleText!=='查看日程'" :disabled="isDisabled" type="primary" size="mini" @click="submitScheduleForm('scheduleForm')">确定</el-button>
        <el-button v-if="titleText!=='查看日程'" size="mini" @click="addDialogVisible = false">取消</el-button>
        <el-button v-if="titleText==='查看日程'" size="mini" @click="addDialogVisible = false">返回</el-button>
        <el-button v-if="updataBtn&& titleText==='查看日程'" size="mini" @click="changeUpdata">编辑</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { api, paramApi } from '@/api/axios'
import { Calendar } from '@fullcalendar/core'
import dayGridPlugin from '@fullcalendar/daygrid'
// import timeGridPlugin from '@fullcalendar/timegrid'
// import listPlugin from '@fullcalendar/list'
import interactionPlugin from '@fullcalendar/interaction'
// import ToolTip from '@fullcalendar/interaction'

import '@fullcalendar/core/main.css'
import '@fullcalendar/daygrid/main.css'
import '@fullcalendar/timegrid/main.css'
import '@fullcalendar/list/main.css'
// document.addEventListener('DOMContentLoaded', function() {
//   var calendarEl = document.getElementById('calendar')

//   var calendar = new Calendar(calendarEl, {
//     plugins: [dayGridPlugin, timeGridPlugin, listPlugin]
//   })

//   calendar.render()
// })
export default {
  // components: {
  //   FullCalendar // make the <FullCalendar> tag available
  // },
  inject: ['reload'],
  data() {
    return {
      htmlText: '',
      tooltipStyle: {},
      updataBtn: false,
      startData: '',
      isDisabled: false,
      isdisabled: false,
      titleText: '',
      scheduleList: [],
      // startMinute: '',
      // endMinute: '',
      addDialogVisible: false,
      scheduleForm: {
        dateTime: '',
        allDay: '0',
        id: '',
        remindTime: '',
        title: '',
        content: '',
        isRemind: '1',
        startTime: '',
        endTime: '',
        remindWay: []
      },
      rules: {
        title: [{ required: true, message: '请输入日程标题', trigger: 'blur' }],
        content: [
          { required: true, message: '请输入日程内容', trigger: 'blur' }
        ],
        startTime: [
          { required: true, message: '请选择开始时间', trigger: 'change' }
        ],
        dateTime: [
          { required: true, message: '请选择日期', trigger: 'change' }
        ],
        endTime: [{ required: true, message: '请选择结束时间', trigger: 'change' }]
      }
    }
  },
  watch: {
  // 如果 `allDay` 发生改变，这个函数就会运行
    // 'scheduleForm.allDay': function() {
    //   this.scheduleForm.startTime = ''
    //   this.scheduleForm.endTime = ''
    //   this.scheduleForm.dateTime = ''
    // }
  },
  mounted() {
    // this.showSchedule()
    this.initList()
  },
  methods: {
    initList() {
      // this.listLoading = true
      api(`${this.GLOBAL.oaUrl}oa/schedule/list`, '', 'get').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.scheduleList = res.data.data
          this.showSchedule(this.scheduleList)
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    showSchedule(list) {
      var calendarEl = document.getElementById('calendar')
      const calendar = new Calendar(calendarEl, {
        plugins: [dayGridPlugin, interactionPlugin],
        dateClick: info => {
          console.log(info)
          var myDate = new Date()
          if (new Date(myDate.toLocaleDateString()) > info.date) {
            this.$message.error('您不能新增当前日期之前的日程')
            return
          }
          this.titleText = '新增日程'
          this.isdisabled = false
          this.scheduleForm.id = ''
          this.scheduleForm.title = ''
          this.scheduleForm.startTime = ''
          this.scheduleForm.endTime = ''
          this.scheduleForm.content = ''
          this.scheduleForm.remark = ''
          this.scheduleForm.remindTime = ''
          this.scheduleForm.isRemind = '1'
          this.scheduleForm.remindWay = ['4']
          this.scheduleForm.dateTime = ''
          this.addDialogVisible = true
        },
        eventClick: info => {
          // var eventObj = info.event
          console.log(info)
          this.isdisabled = true
          this.titleText = '查看日程'
          var myDate = new Date()
          this.scheduleForm.id = info.event.id
          api(
            `${this.GLOBAL.oaUrl}oa/schedule/getScheduleById?id=${
              this.scheduleForm.id
            }`,
            '',
            'get'
          ).then(res => {
            if (res.data.code === this.GLOBAL.code) {
              console.log(res)
              this.scheduleForm.title = res.data.data.title
              this.scheduleForm.content = res.data.data.content
              if (res.data.data.allDay === '0') {
                this.scheduleForm.startTime = res.data.data.start + ':00'
                this.scheduleForm.endTime = res.data.data.end + ':00'
              } else {
                this.scheduleForm.dateTime = res.data.data.date
              }
              this.scheduleForm.allDay = res.data.data.allDay
              this.scheduleForm.isRemind = res.data.data.isRemind
              this.startData = res.data.data.start
              if (res.data.data.remark) {
                this.scheduleForm.remark = res.data.data.remark
              }
              if (res.data.data.remindWay) {
                this.scheduleForm.remindWay = res.data.data.remindWay.split(
                  ','
                )
              } else {
                this.scheduleForm.remindWay = ['4']
              }

              if (res.data.data.remindTime) {
                this.scheduleForm.remindTime = res.data.data.remindTime + ':00'
              } else {
                this.scheduleForm.remindTime = ''
              }
              this.addDialogVisible = true
              if (
                new Date(myDate.toLocaleDateString()) <=
                new Date(res.data.data.start)
              ) {
                this.updataBtn = true
              } else {
                this.updataBtn = false
              }
            } else {
              this.$message.error(res.data.result)
            }
          })
        },
        // eventRender: function(info) {
        //   new Tooltip(info.el, {
        //     title: info.event.extendedProps.content,
        //     placement: 'top',
        //     trigger: 'hover',
        //     container: 'body'
        //   })
        //   // console.log(tooltip)
        // },
        // eventMouseEnter: info => {
        //   console.log(133)
        //   console.log(info)
        //   this.htmlText = info.event.extendedProps.content
        //   this.tooltipStyle = {
        //     left: info.el.offsetLeft + info.el.offsetWidth / 2 + 'px',
        //     top: info.jsEvent.clientY + 'px'
        //   }
        // },
        header: {
          left: ' prevYear,prev,next,nextYear',
          center: 'title',
          right: 'addEventButton'
        },
        customButtons: {
          addEventButton: {
            text: '新增日程',
            click: () => {
              this.scheduleForm.id = ''
              this.titleText = '新增日程'
              this.isdisabled = false
              this.scheduleForm.remindWay = ['4']
              this.scheduleForm.title = ''
              this.scheduleForm.startTime = ''
              this.scheduleForm.endTime = ''
              this.scheduleForm.remindTime = ''
              this.scheduleForm.content = ''
              this.scheduleForm.remark = ''
              this.scheduleForm.isRemind = '1'
              this.scheduleForm.dateTime = ''
              this.addDialogVisible = true
            }
          }
        },
        navLinks: false, // can click day/week names to navigate views
        editable: true,
        locale: 'zh-cn',
        eventLimit: true, // allow "more" link when too many events
        eventLimitText: '更多',
        eventColor: 'rgb(55, 136, 216)',
        // events: [{ title: 'All Day Event', start: '2019-04-18', color: '#06BB87' }]
        events: list
      })
      calendar.render()
    },
    //  查看改变成编辑
    changeUpdata() {
      var myDate = new Date()
      if (new Date(myDate.toLocaleDateString()) <= new Date(this.startData)) {
        this.titleText = '编辑日程'
        this.isdisabled = false
      }
    },
    // 提交
    submitScheduleForm(scheduleForm) {
      this.isDisabled = true
      this.$refs[scheduleForm].validate(valid => {
        if (valid) {
          if (this.scheduleForm.allDay === '0') {
            if (!this.scheduleForm.startTime) {
              this.$message.error('请选择开始时间')
              this.isDisabled = false
              return
            }
            if (!this.scheduleForm.endTime) {
              this.$message.error('请选择结束时间')
              this.isDisabled = false
              return
            }
            // this.scheduleForm.startTime =
            //   this.scheduleForm.startTime + ' ' + this.startMinute
            // this.scheduleForm.endTime =
            //   this.scheduleForm.endTime + ' ' + this.startMinute
            var today_time = new Date().getTime()
            if (new Date(this.scheduleForm.startTime) < today_time) {
              this.$message.error('开始时间必须大于当前时间')
              this.isDisabled = false
              return
            }
            if (
              new Date(this.scheduleForm.endTime) <=
              new Date(this.scheduleForm.startTime)
            ) {
              this.$message.error('结束时间必须大于开始时间')
              this.isDisabled = false
              return
            }
          }
          if (this.scheduleForm.isRemind === '1') {
            if (!this.scheduleForm.remindTime) {
              this.$message.error('请选择提醒时间')
              this.isDisabled = false
              return
            }
            if (new Date(this.scheduleForm.remindTime) < today_time) {
              this.$message.error('提醒时间必须大于当前时间')
              this.isDisabled = false
              return
            }
            if (this.scheduleForm.allDay === '0') {
              if (
                new Date(this.scheduleForm.remindTime) >=
                new Date(this.scheduleForm.startTime)
              ) {
                this.$message.error('提醒时间必须小于开始时间')
                this.isDisabled = false
                return false
              }
            } else {
              if (
                (new Date(this.scheduleForm.remindTime.replace(new RegExp('-', 'gm'), '/'))).getTime() >=
                (new Date((this.scheduleForm.dateTime + ' 00:00:00').replace(new RegExp('-', 'gm'), '/'))).getTime()
              ) {
                this.$message.error('提醒时间必须小于开始时间')
                this.isDisabled = false
                return false
              }
            }
            this.scheduleForm.remindWay = this.scheduleForm.remindWay.toString()
          } else {
            this.scheduleForm.remindWay = ''
          }
          if (this.scheduleForm.allDay === '1') {
            this.scheduleForm.endTime = this.scheduleForm.dateTime + ' 23:59'
            this.scheduleForm.startTime =
              this.scheduleForm.dateTime + ' 00:00'
          }
          api(
            `${this.GLOBAL.oaUrl}oa/schedule/addOrUpdate`,
            this.scheduleForm,
            'post'
          ).then(res => {
            if (res.data.code === this.GLOBAL.code) {
              console.log(this)
              this.reload()
              if (this.titleText === '新增日程') {
                this.$message({
                  message: '添加成功',
                  type: 'success'
                })
              } else {
                this.$message({
                  message: '编辑成功',
                  type: 'success'
                })
              }

              this.isDisabled = false
              this.addDialogVisible = false
            } else {
              // if (this.scheduleForm.remindWay) {
              //   this.scheduleForm.remindWay = this.scheduleForm.remindWay.split(',')
              // }
              this.$message.error(res.data.result)
              this.isDisabled = false
              return false
            }
          })
        } else {
          this.isDisabled = false
          return false
        }
      })
    },
    // 删除日程
    handleDelete() {
      this.$confirm(`是否删除这条日程, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          paramApi(
            `${this.GLOBAL.oaUrl}oa/schedule/delete`,
            this.scheduleForm.id,
            'scheduleId'
          ).then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              this.reload()
              this.addDialogVisible = false
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {})
    }
  }
}
</script>
<style lang="scss">
.schedule {
  padding: 20px;
  .el-dialog__body {
    padding-top: unset;
    padding-bottom: unset;
  }
  .el-form-item {
    margin-bottom: 16px;
  }
  .sched {
    .el-dialog {
      margin-top: 6vh !important;
      width: 45% ;
    }
  }
  //  .tooltip {
  //     position: fixed;
  //     z-index: 1;
  //     background: #FFC107;
  //     color: black;
  //     width: 150px;
  //     border-radius: 3px;
  //     box-shadow: 0 0 2px rgba(0,0,0,0.5);
  //     padding: 10px;
  //     text-align: center;
  //   }
}
.el-textarea__inner {
  min-height:90px!important;
}
.fc-button-primary {
  color: unset;
  background-color: unset;
  border-color: unset;
  border: none;
}

.popper,
.tooltip {
  position: absolute;
  z-index: 9999;
  background: black;
  color: #fff;
  width: 150px;
  // height: 100px;
  word-wrap: break-word;
  border-radius: 3px;
  box-shadow: 0 0 2px rgba(0, 0, 0, 0.5);
  padding: 10px;
  text-align: center;
}
.style5 .tooltip {
  background: #1e252b;
  color: #ffffff;
  max-width: 200px;
  width: auto;
  font-size: 0.8rem;
  padding: 0.5em 1em;
}
.popper .popper__arrow,
.tooltip .tooltip-arrow {
  width: 0;
  height: 0;
  border-style: solid;
  position: absolute;
  margin: 5px;
}

.tooltip .tooltip-arrow,
.popper .popper__arrow {
  border-color: #ffc107;
}
.style5 .tooltip .tooltip-arrow {
  border-color: #1e252b;
}
.popper[x-placement^="top"],
.tooltip[x-placement^="top"] {
  margin-bottom: 5px;
}
.popper[x-placement^="top"] .popper__arrow,
.tooltip[x-placement^="top"] .tooltip-arrow {
  border-width: 5px 5px 0 5px;
  border-left-color: transparent;
  border-right-color: transparent;
  border-bottom-color: transparent;
  bottom: -5px;
  left: calc(50% - 5px);
  margin-top: 0;
  margin-bottom: 0;
}
.popper[x-placement^="bottom"],
.tooltip[x-placement^="bottom"] {
  margin-top: 5px;
}
.tooltip[x-placement^="bottom"] .tooltip-arrow,
.popper[x-placement^="bottom"] .popper__arrow {
  border-width: 0 5px 5px 5px;
  border-left-color: transparent;
  border-right-color: transparent;
  border-top-color: transparent;
  top: -5px;
  left: calc(50% - 5px);
  margin-top: 0;
  margin-bottom: 0;
}
.tooltip[x-placement^="right"],
.popper[x-placement^="right"] {
  margin-left: 5px;
}
.popper[x-placement^="right"] .popper__arrow,
.tooltip[x-placement^="right"] .tooltip-arrow {
  border-width: 5px 5px 5px 0;
  border-left-color: transparent;
  border-top-color: transparent;
  border-bottom-color: transparent;
  left: -5px;
  top: calc(50% - 5px);
  margin-left: 0;
  margin-right: 0;
}
.popper[x-placement^="left"],
.tooltip[x-placement^="left"] {
  margin-right: 5px;
}
.popper[x-placement^="left"] .popper__arrow,
.tooltip[x-placement^="left"] .tooltip-arrow {
  border-width: 5px 0 5px 5px;
  border-top-color: transparent;
  border-right-color: transparent;
  border-bottom-color: transparent;
  right: -5px;
  top: calc(50% - 5px);
  margin-left: 0;
  margin-right: 0;
}
.fc-day-grid-event .fc-content{
    display: block;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
}
@media screen and (max-width: 900px) {
    .fc-widget-content{
      .fc-day-grid-container{
        height:unset !important;
      }
    }
    body .fc {
    font-size: 0.5em;
}
.el-date-picker .el-picker-panel__content{
  width: 90%;
}
.el-date-picker{
  left:5%!important;
   width: 90%;
}
.el-picker-panel{
  line-height: 10px;
}
// .el-date-table td.current:not(.disabled) span{
//       color: #fff;
//     background-color: #00a041;
// }
// .el-date-table td.today span,.el-radio__input.is-checked+.el-radio__label,.el-checkbox__input.is-checked+.el-checkbox__label{
//   color: #00a041;
// }
// .el-radio__input.is-checked .el-radio__inner,.el-checkbox__input.is-checked .el-checkbox__inner, .el-checkbox__input.is-indeterminate .el-checkbox__inner{
//     color: #00a041;
//     background-color: #00a041;
//     border-color:#00a041;

// }
// .el-checkbox__inner:hover{
//    border-color:#00a041;
// }
.el-popper[x-placement^=bottom] .popper__arrow{
  display: none;
}
.fc-dayGrid-view .fc-body .fc-row{
  min-height: 6em;
}
.el-date-table td span,.el-date-table td div,.el-date-table td{
  height: 20px;
  line-height: 20px;
}

    .fc table{
      font-size: 0.8em;
    }
    .fc-toolbar.fc-header-toolbar{
      margin-bottom: 1em !important;
    }
    .fc-button-primary:not(:disabled):active:focus, .fc-button-primary:not(:disabled).fc-button-active:focus{
      box-shadow:unset;
    }
    .fc-button-primary:not(:disabled):active, .fc-button-primary:not(:disabled).fc-button-active{
      color:unset;
    background-color: unset;
    border-color:unset;
    }
    .fc-button-primary:hover{
       color: unset;
    background-color: unset;
    border-color: unset;
    }
    .fc-button-primary:focus{
       color: unset;
    background-color: unset;
    border-color: unset;
     box-shadow:unset;
    }
    .el-dialog {
    // margin-top: 6vh !important;
    width: 90% !important;
}
.dialog__body ,.el-textarea__inner{
      padding: 5px ;
    font-size: 11px;
    min-height: 60px!important;
}
.el-dialog__body {
  padding: 5px ;
}
.el-date-editor.el-input, .el-date-editor.el-input__inner{
  width: unset;
}
.el-form-item__label{
  width:84px !important;
}
.el-form-item__content{

  margin-left:84px !important;
}
.el-input--medium .el-input__inner{
  height: 28px;
  line-height: 28px;
}
.el-textarea__inner{
  line-height: 1.2;
}
.el-checkbox__label{
  padding-left:3px;
}
.el-checkbox+.el-checkbox{
      margin-left:10px;
}
.timeStyle{
  .el-input--suffix .el-input__inner{
    padding-right:unset;
  }
}
.el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label{
  line-height: 30px;
}
}
</style>

// pages/meeting/makeMeeting/makeMeeting.js
import request from "./../../../utils/http"
const date = new Date()
const years = []
const months = []
const days = []
const hours = []
const minutes = []
var thisMon = date.getMonth();
var thisDay = date.getDate();
var thisHours = date.getHours();
var thisMinutes = date.getMinutes();
for (let i = 2018; i <= date.getFullYear() + 1; i++) {
  years.push(i)
}
for (let i = 1; i <= 11; i++) {
  var k = i;
  if (0 <= i && i < 9) {
    k = "0" + (i + 1);
  } else {
    k = (i + 1);
  }
  months.push(k)
}
if (0 <= thisMon && thisMon < 9) {
  thisMon = "0" + (thisMon + 1);
} else {
  thisMon = (thisMon + 1);
}
if (0 <= thisDay && thisDay < 10) {
  thisDay = "0" + thisDay;
}
var totalDay = mGetDate(date.getFullYear(), thisMon);
for (let i = 1; i <= 31; i++) {
  var k = i;
  if (0 <= i && i < 10) {
    k = "0" + i
  }
  days.push(k)
}
 
for (let i = 0; i <= 23; i++) {
  var k = i;
  if (0 <= i && i < 10) {
    k = "0" + i
  }
  hours.push(k)
}
for (let i = 0; i <= 59; i++) {
  var k = i;
  if (0 <= i && i < 10) {
    k = "0" + i
  }
  minutes.push(k)
}
function mGetDate(year, month) {
  var d = new Date(year, month, 0);
  return d.getDate();
}
 
var app = getApp();
var api = app.globalData.api;
Page({
  data: {
    nvabarData: {
      title: '会议室预约', 
    },
    years: years,
    year: date.getFullYear(),
    months: months,
    month: thisMon,
    days: days,
    day: thisDay,
    value: [1, date.getMonth()-1, date.getDate()-1],
    hours: hours,
    hour: thisHours,
    minutes: minutes,
    minute: thisMinutes,
    roomName:'会议室',
    orgName:'',//组织人姓名
    orgDepartment:'请选择组织人部门',//部门名称
    departmentId:'',//部门id
    meetingPerson:'请选择参会人员',

    endTime: '',
    meetingRoomId: '',//会议室id
    oaMeetingContent: '会议内容',
    organizationalUser: '',//组织人id
    participantsStr: '',//参会人员
    startTime: '请选择会议日期',
    title: '请输入一个主题',
  },
  // 预约
  makeMeeting(){
    if(this.data.endTime!=''&&this.data.meetingRoomId!=''&&this.data.oaMeetingContent!=''&&this.data.organizationalUser!=''&&this.data.participantsStr!=''&&this.data.startTime!=''&&this.data.title!=''){
      let endMinute=this.data.endTime.split(' ')[1].split(":")
      let starMinute=this.data.startTime.split(' ')[1].split(":")
      let endDay=this.data.endTime.split('/')[1]
      let starDay=this.data.startTime.split('/')[1]
      if(endMinute[0]*60+endMinute[1]>starMinute[0]*60+starMinute[1]&&endDay===starDay){
        request.send({
          url: '/springcloud-oa/oa/oaMeeting/add',
          data:  {
            createdTime: this.data.createdTime,
            endTime: this.data.endTime,
            meetingRoomId: this.data.meetingRoomId,//会议室id
            oaMeetingContent: this.data.oaMeetingContent,
            organizationalUser: this.data.organizationalUser,//组织人id
            participantsStr: this.data.participantsStr,//参会人员
            startTime: this.data.startTime,
            title:this.data.title,
          },
          method: 'POST',
        }).then(res=>{
          if(res.data.code==='0000'){
            wx.showToast({
              title: "预约成功",
              icon:'none',
              duration: 1000,
              mask:true
            })
            setTimeout(function(){
              wx.navigateBack({
                delta: 1
              })
            },1000 )
          }else{
            wx.showToast({
              title: res.data.result,
              icon:'none',
              duration: 1500,
              mask:true
            })
          }
        })
      }else{
        wx.showToast({
          title: '请重新选择会议时间！！！',
          icon:'none',
          duration: 1500,
          mask:true
        })
      }
    }else{
      wx.showToast({
        title: '亲，表格不能留空哦！！！',
        icon:'none',
        duration: 1500,
        mask:true
      })
    }
  },
  // 改变选择日期
  bindChange: function (e) {
    const val = e.detail.value
    this.setData({
      year: this.data.years[val[0]],
      month: this.data.months[val[1]],
      day: this.data.days[val[2]],
      hour: this.data.hours[val[3]],
      minute: this.data.minutes[val[4]],
    })
    var totalDay = mGetDate(this.data.year, this.data.month);
    var changeDate = [];
    for (let i = 1; i <= totalDay; i++) {
      var k = i;
      if (0 <= i && i < 10) {
        k = "0" + i
      }
      changeDate.push(k)
    }
    this.setData({
      days: changeDate
    })
  },
  // 显示日期遮罩层
  showDate: function () {
    var animation = wx.createAnimation({
     duration: 200,
     timingFunction: "linear",
     delay: 0
    })
    this.animation = animation
    animation.translateY(300).step()
    this.setData({
     animationData: animation.export(),
     showStar: true,
    })
    setTimeout(function () {
     animation.translateY(0).step()
     this.setData({
      animationData: animation.export()
     })
    }.bind(this), 200)
   },
   // 隐藏日期遮罩层
  hideDate: function () {
    var animation = wx.createAnimation({
      duration: 200,
      timingFunction: "linear",
      delay: 0
    })
    this.animation = animation
    animation.translateY(300).step()
    this.setData({
      animationData: animation.export(),
    })
    setTimeout(function () {
      animation.translateY(0).step()
      this.setData({
      animationData: animation.export(),
      showStar: false,
      })
    }.bind(this), 200)
  },
  showEnd: function () {
    var animation = wx.createAnimation({
     duration: 200,
     timingFunction: "linear",
     delay: 0
    })
    this.animation = animation
    animation.translateY(300).step()
    this.setData({
     animationData: animation.export(),
     showEnd: true,
    })
    setTimeout(function () {
     animation.translateY(0).step()
     this.setData({
      animationData: animation.export()
     })
    }.bind(this), 200)
   },
  hideEnd: function () {
    var animation = wx.createAnimation({
      duration: 200,
      timingFunction: "linear",
      delay: 0
    })
    this.animation = animation
    animation.translateY(300).step()
    this.setData({
      animationData: animation.export(),
    })
    setTimeout(function () {
      animation.translateY(0).step()
      this.setData({
      animationData: animation.export(),
      showEnd: false,
      })
    }.bind(this), 200)
  },
  changeTime(){
    this.hideDate()
    this.setData({
      startTime:this.data.year+'/'+this.data.month+'/'+this.data.day+' '+this.data.hour+':'+this.data.minute+':00'
    })
  },
  changeendTime(){
    this.hideEnd()
    this.setData({
      endTime:this.data.year+'/'+this.data.month+'/'+this.data.day+' '+this.data.hour+':'+this.data.minute+':00'
    })
  },
  goTitle(){
    wx.navigateTo({
      url: './../meetingtitle/meetingtitle'
    });
  },
  goCont(){
    wx.navigateTo({
      url: './../meetingCont/meetingCont'
    });
  },
  goRoom(){
    wx.navigateTo({
      url: './../meetingRoomSelect/meetingRoomSelect'
    }); 
  },
  goDepartment(){
    wx.navigateTo({
      url: './../orgDepartment/orgDepartment'
    });
  },
  goOrgUser(){
    if(this.data.departmentId){
      wx.navigateTo({
        url: './../orgPerson/orgPerson?departmentId='+this.data.departmentId
      }); 
    }else {
      wx.showToast({
        title: '请先选择组织人部门',
        icon:'none',
        duration: 1500,
        mask:true
      })
    }
  },
  selectMeetingPerson(){
    wx.navigateTo({
      url: './../meetingPerson/meetingPerson'
    });
  },
  onLoad: function (options) {
    this.setData({
      meetingRoomId:options.meetingRoomId,
      roomName:options.name
    })
   },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onPullDownRefresh: function () { },
  onReachBottom: function () { },
})
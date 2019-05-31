import request from "./../../../utils/http"
Page({
  data: {
    nvabarData: {
      title: '会议考勤',
    },
    sendData:{
      id:''
    },
    meetingAttendanceType:'',
    meetingId:'',
    meetingApplyDetail:{},
    meetinguser:[],
    userIds:[]
  },
  onLoad: function (options) {
    this.setData({
      sendData:{
        id:options.id
      }
    })

    this.getMeetingApply()
   },
  onReady: function () { },
  onShow: function () { },
  onUnload: function () { },
  onPullDownRefresh: function () { },
  onReachBottom: function () { },
  getMeetingApply(){
    request.send({
      url: '/springcloud-oa/oa/oaMeeting/selectById?id='+this.data.sendData.id,
      data: {},
      method: 'POST',
    }).then(res=>{
      if(res.data.code==='0000'){
        this.setData({
          meetingApplyDetail:res.data.data,
          meetingId:res.data.data.id,
          userIds:res.data.data.participantsStr.split(",")
        })
      }
      this.getMeetingPerson()
    })
  },
  sinIn(e){
    this.setData({
      meetingAttendanceType:e.currentTarget.dataset.type
    })
    // wx.request({
    //   url: 'http://192.168.10.31:1101/springcloud-oa/oa/oaMeetingAttendance/attendance?',
    //   data:{meetingAttendanceType:this.data.meetingAttendanceType,
    //   meetingId:this.data.meetingId,},
    //   header: {'content-type':'application/json','token':this.data.token},
    //   method: 'POST',
    //   dataType: 'json',
    //   success: (res)=>{
    //     if(res.data.code==='0000'){
    //       wx.showToast({
    //         title: '签到成功',
    //         icon:'',
    //         duration: 1000,
    //         mask:true
    //       })
    //     }else{
    //       wx.showToast({
    //         title: res.data.result,
    //         icon:'none',
    //         duration: 1000,
    //         mask:true
    //       })
    //     }
    //   },
    //   fail: ()=>{},
    //   complete: ()=>{}
    // });
    request.send({
      url: '/springcloud-oa/oa/oaMeetingAttendance/attendance',
      data:{meetingAttendanceType:this.data.meetingAttendanceType,
        meetingId:this.data.meetingId},
      method: 'POST',
    }).then(res=>{
      if(res.data.code==='0000'){
        wx.showToast({
          title: '签到成功',
          icon:'',
          duration: 1000,
          mask:true
        })
      }else{
        wx.showToast({
          title: res.data.result,
          icon:'none',
          duration: 1000,
          mask:true
        })
      }
    })
  },
  signOut(e){
    this.setData({
      meetingAttendanceType:e.currentTarget.dataset.type
    })
    // wx.request({
    //   url: 'http://192.168.10.31:1101/springcloud-oa/oa/oaMeetingAttendance/attendance?',
    //   data:{meetingAttendanceType:this.data.meetingAttendanceType,
    //   meetingId:this.data.meetingId,},
    //   header: {'content-type':'application/json','token':this.data.token},
    //   method: 'POST',
    //   dataType: 'json',
    //   success: (res)=>{
    //     if(res.data.code==='0000'){
    //       wx.showToast({
    //         title: '签退成功',
    //         icon:'',
    //         duration: 1000,
    //         mask:true
    //       })
    //     }else{
    //       wx.showToast({
    //         title: res.data.result,
    //         icon:'none',
    //         duration: 1000,
    //         mask:true
    //       })
    //     }
    //   },
    //   fail: ()=>{},
    //   complete: ()=>{}
    // });
    request.send({
      url: '/springcloud-oa/oa/oaMeetingAttendance/attendance',
      data: {meetingAttendanceType:this.data.meetingAttendanceType,
        meetingId:this.data.meetingId},
      method: 'POST',
    }).then(res=>{
      if(res.data.code==='0000'){
        wx.showToast({
          title: '签退成功',
          icon:'',
          duration: 1000,
          mask:true
        })
      }else{
        wx.showToast({
          title: res.data.result,
          icon:'none',
          duration: 1000,
          mask:true
        })
      }
    })
  },
  getMeetingPerson(){
    request.send({
      url: '/springcloud-app-system/system/sysUser/selectUserByIds?userIds='+this.data.userIds,
      data:{},
      method: 'GET',
    }).then(res=>{
      res.data.data.forEach(ele=> {
        this.setData({
          meetinguser:this.data.meetinguser.concat(ele.name)
        })
      });
      this.setData({
        meetinguser:this.data.meetinguser.toString()
      })
    })
  }
})
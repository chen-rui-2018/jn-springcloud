import request from "./../../../utils/http"
const date = new Date()
Page({
  data: {
    nvabarData: { title: '会议室详情', },
    sendData:{
      meetingRoomId:'',
      meetingStartTime:date.getFullYear()+"/"+(date.getMonth()+1) +"/"+date.getDate(),
      page:1,
      rows:20
    },
    token:'',
    meetingDetail:{},
    meetingList:[],
    starTime:'',
    endTime:''
  },
  onLoad: function (options) {
    this.setData({
      sendData:{
        meetingRoomId:options.id
      }
    })
    
   },
  onReady: function () { },
  onShow: function () {
    this.getRoomDetail()
    this.getMeetingList()
   },
  onUnload: function () { },
  onPullDownRefresh: function () { 
    this.onShow( )
  },
  onReachBottom: function () { },
   // 会议室详情
  getRoomDetail(){
    request.send({
      url: '/springcloud-oa/oa/oaMeetingRoom/selectById?id='+this.data.sendData.meetingRoomId,
      data: {},
      method: 'POST',
    }).then(res=>{
      if(res.data.code==='0000'){
        this.setData({
          meetingDetail:res.data.data,
        })
      }
    })
  },
  getMeetingList(){
    request.send({
      url: '/springcloud-oa/oa/oaMeetingRoom/orderList',
      data: this.data.sendData,
      method: 'POST',
    }).then(res=>{
      this.setData({
        meetingList:res.data.data.rows[0].meetingList,
      })
      this.data.meetingList.forEach(ele => {
        let starMinute=ele.startTime.split(":")
        let endMinute=ele.endTime.split(":")
        let meetingTime=((endMinute[0]*60+endMinute[1]*1)-(starMinute[0]*60+starMinute[1]*1))/60
        ele.meetingTime=meetingTime.toFixed(2)
      })
      this.setData({
        meetingList:this.data.meetingList
      })
    })
  },
  goAttendence(e){
    wx.navigateTo({
      url: './../meetingAttendance/meetingAttendance?id='+e.currentTarget.dataset.id
    })
  },
  // 去预约会议
  makeMeeting(){
    wx.navigateTo({
      url: './../makeMeeting/makeMeeting?meetingRoomId='+this.data.meetingDetail.id+'&name='+this.data.meetingDetail.name
    })
  },
})
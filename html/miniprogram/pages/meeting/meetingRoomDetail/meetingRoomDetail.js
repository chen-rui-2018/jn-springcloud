
import {CreateHeader} from "./../../../utils/require"
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
    CreateHeader()
    .then(header=>{
      this.data.token=header.token
      this.getRoomDetail()
      this.getMeetingList()
    })
   },
  onUnload: function () { },
  onPullDownRefresh: function () { },
  onReachBottom: function () { },
   // 会议室详情
  getRoomDetail(){
    wx.request({
      url: 'http://192.168.10.31:1101/springcloud-oa/oa/oaMeetingRoom/selectById?id='+this.data.sendData.meetingRoomId,
      data:{} ,
      header: {'content-type':'application/json','token':this.data.token},
      method: 'POST',
      dataType: 'json',
      success: (res)=>{
        // console.log(res)
        if(res.data.code==='0000'){
          this.setData({
            meetingDetail:res.data.data,
          })
        }
      },
      fail: ()=>{},
      complete: ()=>{}
    });
  },
  getMeetingList(){
    wx.request({
      url: 'http://192.168.10.31:1101/springcloud-oa/oa/oaMeetingRoom/orderList',
      data:this.data.sendData ,
      header: {'content-type':'application/json','token':this.data.token},
      method: 'POST',
      dataType: 'json',
      success: (res)=>{
        if(res.data.code==='0000'){
          this.setData({
            meetingList:res.data.data.rows[0].meetingList,
          })
          res.data.data.rows[0].meetingList.forEach(ele => {
            /* ele.starTime=ele.starTime.split('8') */
            // console.log(ele.starTime)
          });
        }
      },
      fail: ()=>{},
      complete: ()=>{}
    });
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
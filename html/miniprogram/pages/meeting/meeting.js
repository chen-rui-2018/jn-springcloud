// let app= getApp();

// import {CreateHeader} from "./../../utils/require"
import request from "./../../utils/http"
Page({
  data: {
    nvabarData: {
      title: '我的主页', //导航栏 中间的标题
    },
    total:0,
    sendData:{
      name:'',
      page:1,
      rows:10
    },
    token:'',
    roomList:[]
  },
  changesearch(e){
    this.setData({
      'sendData.name':e.detail.value,
      'sendData.page':1
    })
    this.getMeetinRoom()
  },
  scan(){
    wx.scanCode({
      success(res) {
        wx.navigateTo({
          url: res.result
        })
      }
    })
  },
  onLoad:function(){
  },
  onPullDownRefresh(){
    this.getMeetinRoom()
  },
  // 生命周期函数--监听页面显示
  onShow: function () {
    this.getMeetinRoom()
  },
  // 页面上拉触底事件的处理函数
  onReachBottom: function () { 
    if(this.data.sendData.page<Math.ceil(this.data.total/this.data.sendData.rows)){
      this.data.sendData.page++
      request.send({
        url: '/springcloud-oa/oa/oaMeetingRoom/list',
        data: this.data.sendData,
        method: 'POST',
      }).then(res=>{
        if(res.data.code==='0000'){
          this.setData({
            roomList:this.data.roomList.concat(res.data.data.rows),
            total:res.data.data.total
          })
          wx.stopPullDownRefresh()
        }
      })
    }else{
      wx.showToast({
        title: '已到最后一页',
        icon:'none',
        duration: 1000,
        mask:true
      })
    }
  },
  // 请求数据
  getMeetinRoom(){
    this.setData({
      'sendData.page':1
    })
    request.send({
      url: '/springcloud-oa/oa/oaMeetingRoom/list',
      data: this.data.sendData,
      method: 'POST',
    }).then(res=>{
      if(res.data.code==='0000'){
        this.setData({
          roomList:res.data.data.rows,
          total:res.data.data.total
        })
        wx.stopPullDownRefresh()
      }else{
        wx.showToast({
          title: res.data.result,
          icon:'none',
          duration: 1500,
          mask:true
        })
      }
    })
  },
  // 去会议详情
  goDetail(e){
    wx.navigateTo({
      url: './meetingRoomDetail/meetingRoomDetail?id='+e.currentTarget.dataset.id
    })
  },


})
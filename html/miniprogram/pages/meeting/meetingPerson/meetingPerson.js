// pages/meeting/meetingPerson/meetingPerson.js
import request from "./../../../utils/http"
Page({
  data: {
    nvabarData: {
      title: '参会人员', //导航栏 中间的标题
    },
    userList:[],
    sendData:{
      name:'',
      page:1,
      rows:20
    },
    total:'',
    id:[],
    name:[]
  },
  changesearch(e){
    this.setData({
      'sendData.name':e.detail.value
    })
    this.getUserList()
  },
  selectUser(e){
    if(this.data.id.indexOf(e.currentTarget.dataset.id)===-1){
      this.setData({
        id:this.data.id.concat(e.currentTarget.dataset.id),
        name:this.data.name.concat(e.currentTarget.dataset.name),
      })
    }
    this.data.userList[e.currentTarget.dataset.index].checked= !this.data.userList[e.currentTarget.dataset.index].checked
    this.setData({
      userList: this.data.userList
    })
  },
  goback(){
    let pages = getCurrentPages();
    let prevPage = pages[pages.length - 2];
    prevPage.setData({
      participantsStr: this.data.id.toString(),
      meetingPerson:this.data.name.toString()
    })
    wx.navigateBack({
      delta: 1,
    })
  },
  onLoad:function(){
    this.getUserList()
  },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onPullDownRefresh: function () { },
  onReachBottom:function(){
    if(this.data.sendData.page<Math.ceil(this.data.total/this.data.sendData.rows)){
      this.data.sendData.page++
      request.send({
        url: '/springcloud-app-system/system/sysUser/findSysUserByPage',
        data: this.data.sendData,
        method: 'POST',
      }).then(res=>{
        if(res.data.code==='0000'){
          this.setData({
            userList:this.data.userList.concat(res.data.data.rows),
            total:res.data.data.total
          })
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
  getUserList(){
    request.send({
      url: '/springcloud-app-system/system/sysUser/findSysUserByPage',
      data: this.data.sendData,
      method: 'POST',
    }).then(res=>{
      if(res.data.code==='0000'){
        this.setData({
          userList:res.data.data.rows,
          total:res.data.data.total
        })
        this.data.userList.forEach((ele,index) => {
         ele.checked = false
        });
        this.setData({
          userList: this.data.userList
        })
      }
    })
  }
})
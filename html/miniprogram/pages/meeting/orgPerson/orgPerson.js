import request from "./../../../utils/http"
Page({
  data: {
    nvabarData: {
      title: '组织人员', //导航栏 中间的标题
    },
    sendData:{
      departmentId:'',
      name:'',
      page:1,
      rows:20
    },
    total:0,
    userList:[],
    id:'',
    name:''
  },
  changesearch(e){
    this.setData({
      'sendData.name':e.detail.value
    })
    // wx.request({
    //   url: 'http://192.168.10.31:1101/springcloud-oa/oa/addressBook/list',
    //   data: this.data.sendData,
    //   header: {'content-type':'application/json','token':this.data.token},
    //   method: 'POST',
    //   dataType: 'json',
    //   responseType: 'text',
    //   success: (res)=>{
    //     if(res.data.code==='0000'){
    //       this.setData({
    //         userList:res.data.data.rows,
    //         total:res.data.data.total
    //       })
    //     }
    //   },
    //   fail: ()=>{},
    //   complete: ()=>{}
    // });
    request.send({
      url: '/springcloud-oa/oa/addressBook/list',
      data: this.data.sendData,
      method: 'POST',
    }).then(res=>{
      if(res.data.code==='0000'){
        this.setData({
          userList:res.data.data.rows,
          total:res.data.data.total
        })
      }
    })
  },
  selectUser(e){
    this.setData({
      id:e.currentTarget.dataset.id,
      name:e.currentTarget.dataset.name
    })
  },
  onLoad: function (options) {
    this.setData({
      'sendData.departmentId':options.departmentId
    })
    this.getUser()
   },
   getUser(){
  /*   wx.request({
      url: 'http://192.168.10.31:1101/springcloud-oa/oa/addressBook/list',
      data: this.data.sendData,
      header: {'content-type':'application/json','token':this.data.token},
      method: 'POST',
      dataType: 'json',
      responseType: 'text',
      success: (res)=>{
        if(res.data.code==='0000'){
          this.setData({
            userList:this.data.userList.concat(res.data.data.rows),
            total:res.data.data.total
          })
        }
      },
      fail: ()=>{},
      complete: ()=>{}
    }); */
    request.send({
      url: '/springcloud-oa/oa/addressBook/list',
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
   },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onPullDownRefresh: function () { },
  onReachBottom: function () {
    if(this.data.sendData.page<Math.ceil(this.data.total/this.data.sendData.rows)){
      this.data.sendData.page++
      this.getUser()
    }else{
      wx.showToast({
        title: '已到最后一页',
        icon:'none',
        duration: 1000,
        mask:true
      })
    }
   },
   goback(){
    let pages = getCurrentPages();
    let prevPage = pages[pages.length - 2];
    prevPage.setData({
      organizationalUser: this.data.id,
      orgName:this.data.name
    })
    wx.navigateBack({
      delta: 1,
    })
  },
})
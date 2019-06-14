// pages/meeting/meeting.js
import request from "./../../../utils/http"
Page({
  data: {
    nvabarData: {
      title: '组织人部门选择', //导航栏 中间的标题
    },
    token:'',
    departmentList:[],
    id:'',
    orgDepartment:''
  },

  onLoad: function (options) {
    this.getDepartment()
   },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onPullDownRefresh: function () {
    this.onLoad()
   },
  onReachBottom: function () { },
  getDepartment(){
    // wx.request({
    //   url: 'http://192.168.10.31:1101/springcloud-park/finance/expenses/selectDepartment',
    //   data:{},
    //   header: {'content-type':'application/json','token':this.data.token},
    //   method: 'GET',
    //   dataType: 'json',
    //   responseType: 'text',
    //   success: (res)=>{
    //     // console.log(res)
    //     if(res.data.code==='0000'){
    //       this.setData({
    //         departmentList:res.data.data
    //       })
    //     }
    //   },
    //   fail: ()=>{},
    //   complete: ()=>{}
    // });
    request.send({
      url: '/springcloud-park/finance/expenses/selectDepartment',
      data: this.data.sendData,
      method: 'GET',
    }).then(res=>{
      this.setData({
        departmentList:res.data.data
      })
    })
  },
  selectDepart(e){
    this.setData({
      id:e.currentTarget.dataset.id,
      orgDepartment:e.currentTarget.dataset.name,
    })
  },
  goback(){
    let pages = getCurrentPages();
    let prevPage = pages[pages.length - 2];
    prevPage.setData({
      departmentId: this.data.id,
      orgDepartment:this.data.orgDepartment
    })
    wx.navigateBack({
      delta: 1,
    })
  },
})
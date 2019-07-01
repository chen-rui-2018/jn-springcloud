import request from './../../../utils/http'
var app = getApp()
Page({
  data: {
    nvabarData: {
      title: '我的爱车',
    },
    carList:[],
    sendData:{
      page:1,
      rows:10
    },
    total:0,
    carId:'',
    imgBaseUrl:''
  },

  onLoad: function (options) {
    this.setData({
      imgBaseUrl:app.globalData.imgBaseUrl
    })
   },
  onReady: function () { },
  onShow: function () { this.getCarList()},
  onHide: function () { },
  onPullDownRefresh: function () { },
  onReachBottom: function () {
    if(this.data.sendData.page<Math.ceil(this.data.total/this.data.sendData.rows)){
      this.data.sendData.page++
      request.send({
        url: '/springcloud-park/user/parking/carInfo/getCarInfoListByNowUser',
        data: this.data.sendData,
        method: 'GET',
      }).then(res=>{
        if(res.data.code==='0000'){
          this.setData({
            carList:this.data.carList.concat(res.data.data.rows),
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
  delet(e){
    let _this=this
    this.setData({
      carId:e.currentTarget.dataset.id
    })
    wx.showModal({
      title: '是否确定删除?',
      content: '',
      success (res) {
        if (res.confirm) {
          request.send({
            url: 'springcloud-park/user/parking/carInfo/deleteCarInfoByUser?carId='+_this.data.carId,
            data: {},
            method: 'POST',
          }).then(res=>{
            if(res.data.code==='0000'){
              _this.setData({
                carList:[],
              })
              _this.onShow()
              wx.showToast({
                title: '删除成功',
                icon:'none',
                duration: 1000,
                mask:true
              })
            }
          })
        } else if (res.cancel) {
          
        }
      }
    })
    
  },
  goAdd(){
    wx.navigateTo({
      url: './../addCar/addCar'
    })
  },
  getCarList(){
    this.setData({
      "sendData.page":1
    })
    request.send({
      url: 'springcloud-park/user/parking/carInfo/getCarInfoListByNowUser',
      data: this.data.sendData,
      method: 'GET',
    }).then(res=>{
      if(res.data.code==='0000'){
        this.setData({
          carList:res.data.data.rows,
          total:res.data.data.total
        })
      }
    })
  },
 // ListTouch触摸开始
  ListTouchStart(e) {
    this.setData({
      ListTouchStart: e.touches[0].pageX
    })
  },
  // ListTouch计算方向
  ListTouchMove(e) {
    this.setData({
      ListTouchDirection: e.touches[0].pageX - this.data.ListTouchStart > 0 ? 'right' : 'left'
    })
  },
  // ListTouch计算滚动
  ListTouchEnd(e) {
    if (this.data.ListTouchDirection =='left'){
      this.setData({
        modalName: e.currentTarget.dataset.target
      })
    } else {
      this.setData({
        modalName: null
      })
    }
    this.setData({
      ListTouchDirection: null
    })
  },
})
import request from './../../../utils/http'
var app = getApp()
Page({
  data: {
    nvabarData: {
      title: '我的爱车',
    },
    carLicense:'',
    imgBaseUrl:""
  },

  onLoad: function (options) {
    this.setData({
      imgBaseUrl:app.globalData.imgBaseUrl
    })
   },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onPullDownRefresh: function () { },
  onReachBottom: function () { },
  changeInput(e){
    this.setData({
      carLicense:e.detail.value
    })
  },
  add(){
    request.send({
      url: 'springcloud-park/user/parking/carInfo/saveCarInfo',
      data: {carLicense:this.data.carLicense},
      method: 'POST',
    }).then(res=>{
      if(res.data.code==='0000'){
        let _this=this
        wx.showModal({
          title: '是否继续增加车辆',
          content: '点击取消回到上一级',
          success (res) {
            if (res.confirm) {
              _this.setData({
                carLicense:''
              })
            } else if (res.cancel) {
              wx.navigateBack({
                delta: 1
              })
            }
          }
        })
      }
    })
  }
})
// pages/index/parkPay/parkPay.js
import request from "./../../../utils/http"
Page({
  data: {
    nvabarData: {
      title: '临时停车缴费',
    },
    isPayShow:false,
    carLicense:'',//车牌号
    paySend:{ }
  },
  onLoad: function (options) {
    // console.log(app.globalData.openid)
   },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onPullDownRefresh: function () { },
  onReachBottom: function () { },
  gosearch(e){
    this.setData({
      carLicense:e.detail.value
    })
    this.getParkDetail()
  },
  goPay(e){
    request.send({
      url: '/springcloud-park/guest/parking/temporary/createCarParkingBill?parkingId='+e.currentTarget.dataset.parkingid,
      data: {},
      method: 'POST',
    }).then(res=>{
      if(res.data.code==='0000'&&res.data.data.createStatus==="1"){
        this.setData({
          orderId:res.data.data.billId
        })
        request.send({
          url: '/springcloud-payment/pay/createPay',
          data: {
            channelId:"WX_PROGRAM",
            orderId:this.data.orderId,
            paySum:this.data.parkDetail.parkingAmount,
            payType:'PARKING_LEASE'
          },
          method: 'POST',
        }).then(res=>{
          console.log(res)
          if(res.data.code==='0000'){
            this.setData({
              paySend:JSON.parse(res.data.data.orderInfo)
            })
            wx.requestPayment({
              timeStamp: this.data.paySend.timeStamp,
              nonceStr: this.data.paySend.nonceStr,
              package: this.data.paySend.packageValue,
              signType: this.data.paySend.signType,
              paySign: this.data.paySend.paySign,
              success(res) { 
                console.log(res)
              },
              fail(res) {
                console.log(res)
               }
            })
          } 
        })
      }
    })
  },
  getParkDetail(){
    request.send({
      url: '/springcloud-park/guest/parking/temporary/getCarTempParkingDetail',
      data: {carLicense:this.data.carLicense},
      method: 'GET',
    }).then(res=>{
        if(res.data.code==='0000'){
          this.setData({
            parkDetail:res.data.data
          })
        }else if(res.data.code==='40202014'){
          this.setData({
            parkDetail:false
          })
        }
    })
  },
  // 显示支付界面
  showPay: function () {
    var animation = wx.createAnimation({
     duration: 200,
     timingFunction: "linear",
     delay: 0
    })
    this.animation = animation
    animation.translateY(300).step()
    this.setData({
     animationData: animation.export(),
     isPayShow: true,
    })
    setTimeout(function () {
     animation.translateY(0).step()
     this.setData({
      animationData: animation.export()
     })
    }.bind(this), 200)
   },
   // 隐藏支付界面
  hidePay: function () {
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
      isPayShow: false,
      })
    }.bind(this), 200)
  },
})
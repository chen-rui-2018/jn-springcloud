import request from './../../../utils/http'

Page({
  data: {
    nvabarData: {
      title: '缴费记录',
    },
    carLicenseList:[],
    detailSend:{
      areaName:'',
      carLicense:'',
      endTime:"2030-01-01",
      startTime:"2014-01-01",
      page:1,
      rows:5,
    },
    parkDetail:[],
    isClassId:'',
    total:0
  },
  onLoad: function (options) {
    this.getcarLicenseList()
   },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onPullDownRefresh: function () { },
  onReachBottom: function () {
    if(this.data.detailSend.page<Math.ceil(this.data.total/this.data.detailSend.rows)){
      this.data.detailSend.page++
      request.send({
        url: '/springcloud-park/user/parking/carInfo/getCarParkingRecordList',
        data: this.data.detailSend,
        method: 'GET',
      }).then(res=>{
        if(res.data.code==='0000'){
          this.setData({
            parkDetail:this.data.parkDetail.concat(res.data.data.rows), total:res.data.data.total
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
  // 获取车辆列表
  getcarLicenseList(){
    request.send({
      url: '/springcloud-park/user/parking/carInfo/getCarInfoListByNowUser',
      data: {
        page:1,
        rows:100
      },
      method: 'GET',
    }).then(res=>{
      if(res.data.code==='0000'&&res.data.data.rows){
        this.setData({
          carLicenseList:res.data.data.rows,
          "detailSend.carLicense":res.data.data.rows[0].carLicense
        })
        this.getparkDetail()
      }
    })
  },
  // 获取详情
  getparkDetail(){
    request.send({
      url: '/springcloud-park/user/parking/carInfo/getCarParkingRecordList',
      data: this.data.detailSend,
      method: 'GET',
    }).then(res=>{
      if(res.data.code==='0000'){
        this.setData({
          parkDetail:res.data.data.rows, total:res.data.data.total
        })
      }
    })
  },
  //  选择车牌
  selectcarLicense(e){
    this.setData({
      "detailSend.carLicense":this.data.carLicenseList[e.detail.value].carLicense
    })
    this.getparkDetail()
  },
  // 搜索停车场信息
  search(e){
    this.setData({
      "detailSend.carLicense":e.detail.value
    })
    this.getparkDetail()
    
  },
    /*时间选择器 */
  bindDateBeforeChange: function (e) {
    this.setData({
      "detailSend.startTime": e.detail.value
    })
    this.getparkDetail()
  }, 
  /*时间选择器 */
  bindDateAfterChange: function (e) {
    this.setData({
      "detailSend.endTime": e.detail.value
    })
    this.getparkDetail()
  },
  getDateStr(AddDayCount) {   
   var dd = new Date();  
   dd.setDate(dd.getDate()+AddDayCount)
   var y = dd.getFullYear();   
   var m = (dd.getMonth()+1)<10?"0"+(dd.getMonth()+1):(dd.getMonth()+1)
   var d = dd.getDate()<10?"0"+dd.getDate():dd.getDate()
   return y+"-"+m+"-"+d  
  },  
  changeTime(e){
    const date = new Date()
    this.setData({
      "detailSend.endTime":date.getFullYear()+'-'+(date.getMonth()+1)+"-"+(date.getDate()<20?"0"+date.getDate():date.getDate())
    })
    if(e.currentTarget.dataset.id==='1'){
      this.setData({
        "detailSend.startTime":this.getDateStr(-7),
        isClassId:e.currentTarget.dataset.id
      })
      this.getparkDetail()
    }else if(e.currentTarget.dataset.id==='2'){
      this.setData({
        "detailSend.startTime":this.getDateStr(-30),
        isClassId:e.currentTarget.dataset.id
      })
      this.getparkDetail()
    }else if(e.currentTarget.dataset.id==='3'){
      this.setData({
        "detailSend.startTime":this.getDateStr(-180),
        isClassId:e.currentTarget.dataset.id
      })
      this.getparkDetail()
    }else if(e.currentTarget.dataset.id==='4'){
      this.setData({
        "detailSend.startTime":this.getDateStr(-360),
        isClassId:e.currentTarget.dataset.id
      })
      this.getparkDetail()
    }
  }
})
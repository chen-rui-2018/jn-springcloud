<template>
  <div class="attendanceManagement">
    <div class="border pd30 attendanceManagement-top"><span class="iconfont"> <i>&#xe613;</i> {{currentDate}}</span>
      <span> <i class="iconfont">&#xe758;</i> 部门:</span>{{departmentName}}</div>
    <div class="pd30 userLocation"> <span>距离公司：{{distance}}m</span> <span @click="init"><i class="iconfont">&#xe607;</i></span></div>
    <div style="height:200px;border:#ccc solid 1px;" id="dituContent"></div>
    <div class="pd30 border userInfo">
      <div> <span>{{userName.charAt(userName.length - 1)}}</span>{{userName}}</div> <span @click="$router.push({path:'attendanceDetails',query:{id:userInfo.attendanceUser}})">考勤明细
        <i class="iconfont">&#xe61f;</i></span>
    </div>
    <div class="onDuty"><span :class="onDutystandard?'exceedColor':'notColor'"></span>上班时间{{onDutyTime}}</div>
    <div class="signInfo pd30">
      <div v-show="!upTime" @click="signIn">{{signInText}}</div>
      <div v-show="upTime" @click="signIn">
        <span> {{signInText}}</span>
        <span>{{ upTime }}</span>
      </div>
      <div v-show="!downTime" @click="signOut">{{signOutText}}</div>
      <div v-show="downTime" @click="signOut">
        <span> {{signOutText}}</span>
        <span>{{ downTime }}</span>
      </div>
      <!-- <div>{{signOutText}}</div> -->
    </div>
    <div class="offDuty"><span :class="offDutystandard?'exceedColor':'notColor'"></span>下班时间{{offDutyTime}} <div class="wire"></div>
    </div>

    <x-dialog v-model="msg" class="dialog-demo">
      <div style="padding:15px;" class="popUp">
        <img src="/static/images/signIn.png" alt="签到成功图片">
      </div>
      <div class="attendanceTime">{{attendanceTime}}</div>
      <div class="signSuccessfully">{{msgText}}</div>
      <p class="belate" v-show="Number(minute)>0&&userInfo.type==='1'">迟到了,明天早点来哦</p>
      <div @click="msg=false" class="myKnow">
        我知道了
      </div>
    </x-dialog>

  </div>
</template>
<script>
export default {
  data () {
    return {
      departmentName: '',
      msgText: '',
      minute: '',
      distance: '',
      attendanceTime: '11:16',
      msg: false,
      downTime: '',
      upTime: '',
      onDutystandard: false,
      offDutystandard: false,
      signOutText: '签退',
      signInText: '签到',
      enterpriseName: '白下高新',
      currentDate: '',
      userName: '',
      offDutyTime: '18:00',
      onDutyTime: '09:00',
      userInfo: {
        attendanceUser: '',
        attendancePlatform: '2',
        type: '',
        // latitude: 113.442008,
        latitude: '',
        longitude: ''
      }
    }
  },
  mounted () {
    this.init()
    this.getUserInfo()
    this.currentDate = this.api.getCurrentTime()
  },
  methods: {
    // 点击签退
    signOut () {
      if (!this.upTime) {
        this.$vux.toast.text('您未签到，请先签到', 'top')
        return false
      }
      this.userInfo.type = '2'
      this.api.post({
        url: 'attendance',
        data: this.userInfo,
        callback: res => {
          if (res.code === '0000') {
            console.log(res)
            if (res.data) {
              this.msgText = '签退成功'
              this.msg = true
              this.minute = res.data.minute
              this.attendanceTime = res.data.attendanceTime.substr(11, 8)
              this.signOutText = '已签退'
              this.onDutystandard = true
              this.downTime = res.data.attendanceTime.substr(11, 8)
            }
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    },
    // 点击签到
    signIn () {
      if (this.upTime) {
        this.$vux.toast.text('签到失败，不能进行多次签到', 'top')
        return false
      }

      this.userInfo.type = '1'
      this.api.post({
        url: 'attendance',
        data: this.userInfo,
        callback: res => {
          console.log(res)
          if (res.code === '0000') {
            if (res.data) {
              this.attendanceTime = res.data.attendanceTime.substr(11, 8)
              this.msgText = '签到成功'
              this.minute = res.data.minute
              this.msg = true
              this.signInText = '已签到'
              this.onDutystandard = true

              this.upTime = res.data.signInAttendanceTime.substr(11, 8)
            }
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    },
    // 获取用户信息
    getUserInfo () {
      this.api.post({
        url: 'getUserInfo',
        // data: this.workForm,
        callback: res => {
          console.log(res)
          if (res.data) {
            res.data.sysDepartmentPostVO.forEach(val => {
              if (val.isDefault === '1') {
                sessionStorage.departmentName = val.departmentName
                sessionStorage.departmentId = val.departmentId
                this.departmentName = val.departmentName
              }
            })
            this.userInfo.attendanceUser = res.data.id
            if (res.data.name) {
              this.userName = res.data.name
              sessionStorage.userName = res.data.name
            } else {
              this.userName = res.data.account
              sessionStorage.userName = res.data.account
            }
            this.api.get({
              url: 'selectByUserIdAndCurrentDate',
              data: {userId: res.data.id},
              callback: res => {
                if (res.code === '0000') {
                  console.log(res)
                  if (res.data) {
                    this.signInText = '已签到'
                    this.onDutystandard = true
                    // this.departmentName = res.data.departmentName
                    this.upTime = res.data.signInAttendanceTime.substr(11, 8)
                    if (res.data.signOutAttendanceTime !== null) {
                      this.signOutText = '已签退'
                      this.downTime = res.data.signOutAttendanceTime.substr(11, 8)
                      this.offDutystandard = true
                    }
                  }
                } else {
                  this.$vux.toast.text(res.result, 'top')
                }
              }
            })
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    },
    // 注册jsbridge
    connectWebViewJavascriptBridge (callback, isAndroid, isiOS) {
      if (isAndroid) {
        if (window.WebViewJavascriptBridge) {
          console.log(window.WebViewJavascriptBridge)
          callback(window.WebViewJavascriptBridge)
        } else {
          document.addEventListener(
            'WebViewJavascriptBridgeReady'
            , function () {
              callback(window.WebViewJavascriptBridge)
            },
            false
          )
        }
        return
      }

      if (isiOS) {
        if (window.WebViewJavascriptBridge) {
          return callback(window.WebViewJavascriptBridge)
        }
        if (window.WVJBCallbacks) {
          return window.WVJBCallbacks.push(callback)
        }
        window.WVJBCallbacks = [callback]
        var WVJBIframe = document.createElement('iframe')
        WVJBIframe.style.display = 'none'
        WVJBIframe.src = 'https://__bridge_loaded__'
        document.documentElement.appendChild(WVJBIframe)
        setTimeout(function () {
          document.documentElement.removeChild(WVJBIframe)
        }, 0)
      }
    },
    initJsBridge (readyCallback) {
      var u = navigator.userAgent
      var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1 // android终端
      var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/) // ios终端
      // this.connectWebViewJavascriptBridge(callback, isAndroid, isiOS)
      // 调用注册方法
      this.connectWebViewJavascriptBridge(function (bridge) {
        if (isAndroid) {
          bridge.init(function (message, responseCallback) {
            console.log('JS got a message', message)
            // responseCallback(data)
          })
        }
        readyCallback()
      }, isAndroid, isiOS)
    },
    init () {
      this.initJsBridge(function () {
        // 此处调用api
        /// ///
        /// /1、获取经纬度api
        /// /2、播放监控回放录像
        // 通过JsBridge调用原生方法，写法固定，第一个参数时方法名，第二个参数时传入参数，第三个参数时响应回调
        /// /1、获取经纬度api
        // 方法名 getLocation
        // 传参数null
        // 返回response：json字符串  示例如下
        // {"address":"广州天河区体育中心","latitude":28.196193,"longitude":112.860829,"code":"0000","result":"成功"}
        // address：位置名称
        // longitude：经度
        // latitude：纬度
        // code和result 请参考swagger
        window.WebViewJavascriptBridge.callHandler('getLocation', null, function (response) {
          console.log(response)
        })
      })
      // var geolocation = new window.BMap.Geolocation()
      // let that = this
      // geolocation.getCurrentPosition(
      //   function (r) {
      //     if (this.getStatus() === window.BMAP_STATUS_SUCCESS) {
      //       // alert('您的位置：' + r.point.lng + ',' + r.point.lat)
      //       that.userInfo.latitude = r.point.lat
      //       that.userInfo.longitude = r.point.lng
      //       console.log(that.userInfo.latitude, that.userInfo.longitude)
      //       var ggPoint = new window.BMap.Point(that.userInfo.longitude, that.userInfo.latitude)

      //       // 地图初始化
      //       var bm = new window.BMap.Map('dituContent')
      //       bm.centerAndZoom(ggPoint, 15)
      //       bm.enableScrollWheelZoom()
      //       bm.addControl(new window.BMap.NavigationControl())

      //       // 添加gps marker
      //       var markergg = new window.BMap.Marker(ggPoint)
      //       bm.addOverlay(markergg) // 添加GPS marker
      //       var labelgg = new window.BMap.Label('未转换的GPS坐标（错误）', {offset: new window.BMap.Size(20, -10)})
      //       markergg.setLabel(labelgg)
      //       // 坐标转换完之后的回调函数
      //       var translateCallback = function (data) {
      //         if (data.status === 0) {
      //           var marker = new window.BMap.Marker(data.points[0])
      //           bm.addOverlay(marker)
      //           var label = new window.BMap.Label('转换后的百度坐标（正确）', {offset: new window.BMap.Size(20, -10)})
      //           marker.setLabel(label) // 添加百度label
      //           bm.setCenter(data.points[0])
      //         }
      //       }

      //       setTimeout(function () {
      //         var convertor = new window.BMap.Convertor()
      //         var pointArr = []
      //         pointArr.push(ggPoint)
      //         convertor.translate(pointArr, 1, 5, translateCallback)
      //       }, 1000)
      //       that.getLocaltion()
      //     } else {
      //       alert('failed' + this.getStatus())
      //     }
      //   },
      //   { enableHighAccuracy: true }
      // )
    },
    getLocaltion () {
      this.api.get({
        url: 'selectLocation',
        data: {latitude: this.userInfo.latitude, longitude: this.userInfo.longitude},
        callback: res => {
          if (res.code === '0000') {
            this.distance = Number(res.data.distance).toFixed(0)
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.attendanceManagement {
  padding-top: 1rem;
  margin: 30px;
  .iconfont {
    font-size: 0.513333rem;
  }
  .popUp {
    img {
      position: absolute;
      top: 0rem;
      left: 1rem;
      width: 70%;
    }
  }
  .signSuccessfully {
    margin-top: 30px;
    padding: 50px;
    font-size: 60px;
    padding-bottom: 20px;
    color: #47dc8d;
  }
  .belate {
    color: #aaafb5;
    font-size: 40px;
    padding: 20px;
    margin-bottom: 40px;
  }
  .myKnow {
    width: 400px;
    height: 88px;
    background: rgba(72, 219, 141, 1);
    border-radius: 44px;
    margin: 0 auto;
    color: #fff;
    font-size: 40px;
    line-height: 88px;
  }
  .attendanceTime {
    margin: 0 auto;
    margin-top: 300px;
    font-size: 100px;
    // width:268px;
    height: 109px;
    color: rgb(251, 148, 61);
  }
  .attendanceManagement-top {
    font-weight: 700;
    color: #999;
    > span:nth-child(1) {
      font-size: 28px;
      margin-right: 40px;
    }
  }
  .userLocation {
    display: flex;
    justify-content: space-between;
    font-size: 32px;
    color: #333;
    font-weight: 800;
  }
  .userInfo {
    display: flex;
    justify-content: space-between;
    span {
      text-align: center;
      line-height: 100px;
    }
    div > span:nth-child(1) {
      width: 100px;
      height: 100px;
      margin-right: 15px;
      display: inline-block;
      //    padding: 10px;
      background: green;
      color: #fff;
      border-radius: 50%;
    }
  }
  .onDuty,
  .offDuty {
    margin-top: 80px;
    margin-bottom: 80px;
    color: #666;
    font-size: 34px;
    position: relative;
    > span {
      display: inline-block;
      width: 20px;
      height: 20px;
      border-radius: 50%;
      margin-right: 20px;
    }
  }
  .signInfo {
    display: flex;
    justify-content: space-around;
    > div {
      margin: 0.266667rem;
      width: 2.666667rem;
      height: 2.666667rem;
      /* line-height: 2.666667rem; */
      /* text-align: center; */
      border-radius: 50%;
      background: green;
      color: #fff;
      display: flex;
      align-items: center;
      justify-content: center;
      /* flex-wrap: wrap; */
      flex-direction: column;
      > span {
        padding: 10px 0px;
      }
    }
  }
  // .signStyle{
  //     //  display: flex;
  //     // //  flex-direction: column;
  //     // flex-wrap:wrap;
  //     //   margin: 20px;
  //     width: 200px;
  //     height: 200px;
  //     line-height: 200px;
  //     text-align: center;
  //     border-radius: 50%;
  //     background: green;
  //     color: #fff;

  //   }
  .pd30 {
    padding: 30px;
  }
  .border {
    border-bottom: 1px solid #ccc;
  }
  .notColor {
    background: rgb(177, 177, 177);
  }
  .exceedColor {
    background: rgb(42, 152, 253);
  }
  .wire {
    position: absolute;
    top: -6.3rem;
    left: 0.1rem;
    width: 0.046667rem;
    height: 6.633333rem;
    background: rgba(204, 204, 204, 0.836);
    z-index: -1;
  }
}
</style>
<style lang="scss">
.attendanceManagement {
  .weui-toast.vux-toast-top {
    top: 7.133333rem;
  }
  .weui-dialog {
    max-width: unset !important;
    width: 80%;
    height: 70%;
    border-radius: 50px;
  }
}
</style>

<template>
  <div class="attendanceManagement">
    <div class="border pd30 attendanceManagement-top"><span class="iconfont"> <i>&#xe613;</i> {{currentDate}}</span>
      <span> <i class="iconfont">&#xe758;</i> 部门:</span>{{departmentName}}</div>
    <div class="pd30 userLocation"> <span>距离公司：{{distance}}m</span> <span @click="init"><i class="iconfont">&#xe607;</i></span></div>
    <div style="height:100px;border:#ccc solid 1px;" id="dituContent"></div>
    <div class="pd30 border userInfo">
      <div> <span>{{userName.charAt(userName.length - 1)}}</span>{{userName}}</div> <span @click="$router.push({path:'attendanceDetails',query:{id:userInfo.attendanceUser}})">考勤明细 <i class="iconfont">&#xe61f;</i></span>
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
      distance: '50',
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
        latitude: 23.17322,
        longitude: 113.442008
      }
    }
  },
  mounted () {
    this.init()
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
    init () {
      this.getUserInfo()
      this.currentDate = this.api.getCurrentTime()
      // 百度地图API功能
      var map = new window.BMap.Map('dituContent')
      var point = new window.BMap.Point()

      map.centerAndZoom(point, 12)
      setTimeout(function () {
        map.setZoom(18)
      }, 100)
      map.enableScrollWheelZoom()
      var geolocation = new window.BMap.Geolocation()
      let that = this
      geolocation.getCurrentPosition(
        function (r) {
          if (this.getStatus() === window.BMAP_STATUS_SUCCESS) {
            var mk = new window.BMap.Marker(r.point)
            map.addOverlay(mk)
            map.panTo(r.point)

            // alert('您的位置：' + r.point.lng + ',' + r.point.lat)
            that.userInfo.latitude = r.point.lat
            that.userInfo.longitude = r.point.lng
            that.getLocaltion()
          } else {
            alert('failed' + this.getStatus())
          }
        },
        { enableHighAccuracy: true }
      )
    },
    getLocaltion () {
      this.api.get({
        url: 'selectLocation',
        data: {latitude: this.userInfo.latitude, longitude: this.userInfo.longitude},
        callback: res => {
          if (res.code === '0000') {
            console.log(res)
            this.distance = Number(res.data.distance).toFixed(0)
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    }
    // 关于状态码
    // BMAP_STATUS_SUCCESS  检索成功。对应数值“0”。
    // BMAP_STATUS_CITY_LIST  城市列表。对应数值“1”。
    // BMAP_STATUS_UNKNOWN_LOCATION 位置结果未知。对应数值“2”。
    // BMAP_STATUS_UNKNOWN_ROUT 导航结果未知。对应数值“3”。
    // BMAP_STATUS_INVALID_KEY 非法密钥。对应数值“4”。
    // BMAP_STATUS_INVALID_REQUEST  非法请求。对应数值“5”。
    // BMAP_STATUS_PERMISSION_DENIED 没有权限。对应数值“6”。(自 1.1 新增)
    // BMAP_STATUS_SERVICE_UNAVAILABLE 服务不可用。对应数值“7”。(自 1.1 新增)
    // BMAP_STATUS_TIMEOUT 超时。对应数值“8”。(自 1.1 新增)
    //   var map = new window.BMap.Map('dituContent')
    //   var point = new window.BMap.Point() // 默认中心点
    //   var marker = new window.BMap.Marker(point)
    //   //   var opts = {
    //   //     width: 250, // 信息窗口宽度
    //   //     height: 100, // 信息窗口高度
    //   //     title: '经销商地址' // 信息窗口标题
    //   //   }
    //   //   var infoWindow = new window.BMap.InfoWindow('移动拖拽 标记经销商地址', opts) // 创建信息窗口对象
    //   marker.enableDragging() // 启用拖拽
    //   marker.addEventListener('dragend', function (e) {
    //     point = new window.BMap.Point(e.point.lng, e.point.lat) // 标记坐标（拖拽以后的坐标）
    //     marker = new window.BMap.Marker(point)
    //     document.getElementByIdx_x('lng').value = e.point.lng
    //     document.getElementByIdx_x('lat').value = e.point.lat
    //     // infoWindow = new window.BMap.InfoWindow(
    //     //   '当前位置<br />经度：' + e.point.lng + '<br />纬度：' + e.point.lat,
    //     //   opts
    //     // )
    //     // map.openInfoWindow(infoWindow, point)
    //   })
    //   //   map.addControl(new window.BMap.NavigationControl()) // 左上角控件
    //   //   map.enableScrollWheelZoom() // 滚动放大
    //   //   map.enableKeyboard() // 键盘放大
    //   map.centerAndZoom(point, 13) // 绘制地图
    //   map.addOverlay(marker) // 标记地图
    // //   map.openInfoWindow(infoWindow, map.getCenter()) // 打开信息窗口
    // }
  }
}
</script>

<style lang="scss" scoped>

.attendanceManagement {
    padding-top: 1rem;
  margin: 30px;
  .iconfont{
        font-size: 0.513333rem;
  }
  .popUp{
    img{
        position: absolute;
    top:  0rem;
    left: 1rem;
    width: 70%;
    }
  }
  .signSuccessfully{
    margin-top:30px;
    padding: 50px;
    font-size: 60px;
    padding-bottom: 20px;
    color:#47DC8D;
  }
  .belate{
    color:#AAAFB5;
    font-size: 40px;
    padding: 20px;
    margin-bottom: 40px;
  }
  .myKnow{
    width:400px;
height:88px;
background:rgba(72,219,141,1);
border-radius:44px;
margin:0 auto;
color:#fff;
font-size: 40px;
line-height: 88px;
  }
  .attendanceTime{
    margin:0 auto;
    margin-top:300px;
    font-size: 100px;
    // width:268px;
height:109px;
color:rgb(251, 148, 61);
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
    >div {
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
    >span{
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
.attendanceManagement{

.weui-toast.vux-toast-top{
      top: 7.133333rem;
}
.weui-dialog{
  max-width: unset !important;
  width: 80%;
  height: 70%;
  border-radius: 50px;
}
}
</style>

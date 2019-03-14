// pages/register/register.js
const app = getApp()
var countdown = 60;   //验证码重新获取时间，单位秒
var flag=false;       //是否需要注册标识   true:需要注册绑定   false:已注册绑定
var openId="154545";  //openId
var weChatAvatar="";  //微信头像

Page({

  /**
   * 页面的初始数据
   */
  data: {
    phone: '',            //手机号
    code: '',             //验证码
    last_time: '',        //验证码倒计时
    is_show: true,        //验证码是否显示标志，true：显示获取验证码   false:显示验证码倒计时
    countdown: 60,        //倒计时数值
    allShow:false         //是否隐藏  false 为隐藏  true 为显示

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //1.调用接口获取用户的openId和相关头像等信息

    //2.判断openId是否已绑定，若是没有绑定，需要注册登录，若是已绑定，直接跳转到考勤界面
    var that=this;
    var url = app.globalData.registerUrl + 'isBindingOpenId';
    wx.request({
      url: url,
      data: { openId: openId},
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      method:'post',
      success:function(res){
          //没有绑定
          if(res.data.code=='0000' && res.data.data==0){
            that.setData({
              allshow:true
            }),
            flag=true;
          } else if (res.data.code == '0000' && res.data.data == 1){
            //已绑定，跳转到考勤界面

          }else{
            wx.showToast({
              title: '网络异常，请稍后重试！',
              icon: 'none',
              duration: 1500
            })
          }
      }
    })
  },

  //验证码倒计时
  settime: function (that) {
    var t = this;
    if (countdown == 0) {
      that.setData({
        is_show: true
      })
      countdown = 60;
      return;
    } else {
      that.setData({
        is_show: false,
        last_time: countdown
      })

      countdown--;
    }
    setTimeout(function () {
      t.settime(that)
    }
      , 1000)
  },

  //获取用户输入的手机
  userPhoneInput: function (e) {
    this.setData({
      phone: e.detail.value
    })

  },
  //验证码
  userCodeInput: function (e) {
    this.setData({
      code: e.detail.value
    })
  },


  //验证码
  getCode: function () {
    var that = this;
    that.setData({
      flag: true
    })
    var phone = this.data.phone;
    console.log(phone);
    var myreg = /^1[3|4|5|7|8|6][0-9]{9}$/;
    if (!myreg.test(phone)) {
      wx.showToast({
        title: '手机号有误！',
        icon: 'none',
        duration: 1500
      })
    } else {
      wx.request({
        url: app.globalData.registerUrl + 'getCode',
        data: { phone: phone, flag: 2 },
        method: 'post',
        header: {
          'content-type': 'application/x-www-form-urlencoded' // 默认值
        },
        success: function (res) {
          if (res.data.code == '0000') {
            wx.showToast({
              title: '发送成功！',
              icon: 'success',
              duration: 1500
            })
            // 将获取验证码按钮隐藏60s，60s后再次显示
            that.setData({
              is_show: (!that.data.is_show)  //false
            })
            that.settime(that);

          }if (res.data.code == 1) {
            wx.showToast({
              title: '发送失败！',
              icon: 'none',
              duration: 1500
            })
          }
        }, error: function () {
          wx.showToast({
            title: '发送失败！',
            icon: 'none',
            duration: 1500
          })
        }

      })
    }
  },

  
  //点击完成按钮后的操作
  finishRegister: function () {
    var that = this;
    //手机号
    var phone = this.data.phone;
    //验证码
    var code = this.data.code;


    if (code == ""  || phone=="") {
      wx.showToast({
        title: '手机号或验证码填写有误请重新填写！',
        icon: 'none',
        duration: 1500
      })
    } else {
      if (flag) {
          /**注册 */
          wx.request({
            url: app.globalData.registerUrl + 'registerAndBinding',
            data: { 'phone': phone, 'code': code, 'openId': openId, 'weChatAvatar': weChatAvatar},
            method: 'post',
            header: {
              "Content-Type": 'application/json'
            },
            success: function (res) {
              if (res.data.code =='0000' && res.data.data==1) {
                wx.showToast({
                  title: '注册绑定成功！',
                  icon: 'success',
                  duration: 1500
                })
                //跳转到考勤页面
                setTimeout(function () {
                  wx.navigateTo({
                    url: '/pages/login/login',
                  })
                }, 2000)

              } else {
                wx.showToast({
                  title: res.data.result == null ? '验证码错误或验证码已过期':res.data.result,
                  icon: 'none',
                  duration: 1500
                })
              }
            }
          })
        } else {
          wx.showToast({
            title: '注册绑定失败',
            icon: 'success',
            duration: 1500
          })
        }
        return;
    }
  },
  

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
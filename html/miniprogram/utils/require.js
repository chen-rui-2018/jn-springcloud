var apiHost = "https://cms.bxgxq.com/";
var tokenKey = "token";
// 登录地址, 根据这个地址来设置token
var logInUrl = "/Account/LogInForMiniProgram";

/** 
 * @param url:String  require(必需) 请求地址相对路径
 * @param data:Object   可选  请求数据
 * @param success:Function  可选   成功回调函数
 * @param fail:Function     可选    失败回调函数
 */
function getRequest(url, data, success, fail) {
  CreateHeader(url, function (header) {
    wx.request({
      url: apiHost + url,
      method: 'GET',
      data: data,
      header: header,
      success: function (res) {
        if (success && typeof success === "function") {
          success(res);
        }
      },
      fail: function (error) {
        if (fail && typeof fail === "function") {
          fail(error);
        } else {
          console.log(error);
        }
      }
    })
  });
  wx.request({
    url: apiHost + url,
    method: 'GET',
    data: data,
    header: wx.getStorageSync('token'),
    success: function (res) {
      if (success && typeof success === "function") {
        success(res);
      }
    },
    fail: function (error) {
      if (fail && typeof fail === "function") {
        fail(error);
      } else {
        console.log(error);
      }
    }
  })
}
/** 
 * @param url:String  require(必需) 请求地址相对路径
 * @param data:Object   可选  请求数据
 * @param success:Function  可选   成功回调函数
 * @param fail:Function     可选    失败回调函数
 */
function postRequest(url, data, success, fail) {
    wx.request({
      url: apiHost + url,
      method: 'POST',
      data: data,
      header: wx.getStorageSync('token'),
      success: function (res) {
        if (url === logInUrl) {
          // wx.setStorage({
          //   key: tokenKey,
          //   data: res.data.result
          // })
        }
        if (success && typeof success === "function") {
          success(res);
        }
      },
      fail: function (error) {
        if (fail && typeof fail === "function") {
          fail(error);
        } else {
          console.log(error);
        }
      }
    })
  }
 
/** 
 * @param url:String    请求地址(根据请求地址判断是否添加token)
 * @param complete:Function 回调函数
 */
function CreateHeader() {
  return new Promise((resolve, reject) => {
    var header = {
      'content-type': 'application/json'
    }
    wx.request({
      url: 'http://192.168.10.31:1101/springcloud-app-system/login',
      data: {
        account:"wangsong",
        password:"wangsong"
      },
      header: {'content-type':'application/json'},
      method: 'POST',
      dataType: 'json',
      success: (res)=>{
        if(res.data.code==='0000'){
          wx.setStorageSync('token', res.data.data);
          header.token=res.data.data
          resolve(header)
        }
      }
    })
  })
}
export  {getRequest,postRequest,CreateHeader} 
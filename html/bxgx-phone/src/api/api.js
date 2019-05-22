
import axios from 'axios'
export default {
  host: 'http://112.94.22.222:8000/', // api的域名提出来放这里
  apiURL: {
    departList: 'springcloud-park/guest/portal/sp/power/departList', // 实施部门列表
    powerList: 'springcloud-park/guest/portal/sp/power/list', // 权利清单列表
    getpowerDetail: 'springcloud-park/guest/portal/sp/power/get', // 权利详情
    getBusi: 'springcloud-park/guest/portal/sp/power/getBusi', // 服务详情
    spMessage: 'springcloud-park/portal/sp/power/SpMessage', // 留言提交
    perennialList: 'springcloud-enterprise/guest/pd/perennialDeclaration/list', // 常年申报列表
    typeList: 'springcloud-enterprise/guest/pd/declarationNotice/typeList', // 申报中心公告所属类型列表
    declarationList: 'springcloud-enterprise/guest/pd/declarationNotice/list', // 申报中心公告列表
    platformType: 'springcloud-enterprise/pd/declaration/typeList', // 申报中心所属平台类型列表
    selectByTalentNotice: 'springcloud-enterprise/guest/pd/declarationNotice/selectByTalentNotice', // 申报中心-查询公告详情
    getPlatformList: 'springcloud-enterprise/pd/declaration/list', // 申报平台列表
    loginURL: 'springcloud-app-system/login',
    getActivityDetails: 'springcloud-park/guest/getActivityDetails', // 获取活动详情
    findProductDetails: 'springcloud-enterprise/servicemarket/product/web/findProductDetails', // 服务产品详情
    sameTypeProductList: 'springcloud-enterprise/servicemarket/product/web/sameTypeProductList', // 同类型产品
    activityLike: 'springcloud-park/activity/activityLike/activityLike', // 活动点赞
    CancelLike: 'springcloud-park/activity/activityLike/cancelLike', // 取消点赞
    trafficVolume: 'springcloud-enterprise/guest/pd/declarationNotice/trafficVolume', // 申报中心访问量
    onlineBooking: 'springcloud-enterprise/pd/online/onlineBooking', // 申报中心预约申报
    talentsTypeList: 'springcloud-enterprise/guest/pd/talentNotice/typeList', // 人才服务公告所属类型列表
    talentsList: 'springcloud-enterprise/guest/pd/talentNotice/list', // 人才服务公告列表
    talentsDetail: 'springcloud-enterprise/guest/pd/talentNotice/selectByTalentNotice', // 人才服务详情
    talentsVolume: 'springcloud-enterprise/guest/pd/talentNotice/trafficVolume', // 人才服务访问量
    loginURL: 'springcloud-app-system/login'
  },
  setToken: function (obj) { // 设置token在请求头上面
    axios.interceptors.request.use(function (config) {
      config.headers['token'] = obj
      return config
    }, function (error) {
      return Promise.reject(error)
    })
  },
  get: function (url, data, callback, error) {
    if (!url) {
      return alert('未获取到有效的URL')
    };

    if (typeof url === 'object') {
      data = url.data
      callback = url.callback
      error = url.error
      url = url.url
    }
    url = this.apiURL[url]
    if (!data) data = {}

    axios.get(this.host + url, {
      params: data || {},
      headers: {
        'token': sessionStorage.token || ''
      }
    })
      .then(function (response) {
        if (typeof callback === 'function') {
          callback(response.data)
        }
      })
      .catch(function (err) {
        if (typeof error === 'function') {
          error(err)
        } else {
          console.error(err)
        }
      })

    /**  使用实例
     *   无需引入任何文件可全局使用
     *
     *  this.api.get({
     *      url:'loginURL', //此处使用的是apiURL里面的对象key值
     *      data:{   //可选
     *          userId:110
     *      },
     *      callback:function(res){
     *          console.log(res)
     *      },
     *      error:function(err){
     *          console.log(err)
     *      }
     *  })
     *
     */
  },
  post: function (url, data, dataFlag, urlFlag, callback, error) {
    if (!url) {
      return alert('未获取到有效的URL')
    };
    let headerType = url.headerType
    if (typeof url === 'object') {
      data = url.data
      callback = url.callback
      error = url.error
      dataFlag = url.dataFlag
      urlFlag = url.urlFlag
      url = url.url
    }
    if (!urlFlag) {
      url = this.apiURL[url]
    } else {
      url = url
    }

    if (!data) data = {}

    if (dataFlag) {
      var querystring = require('querystring')
      var params = querystring.stringify(data)
      var headerSS = 'application/x-www-form-urlencoded'
    } else {
      var params = JSON.stringify(data)
      var headerSS = 'application/json;charset=UTF-8'
    }

    axios.post(this.host + url, headerType ? data : params, {
      headers: {
        'Content-Type': headerType || headerSS,
        'token': sessionStorage.token || ''
      }
    })
      .then(function (response) {
        if (typeof callback === 'function') {
          callback(response.data)
        }
      })
      .catch(function (err) {
        if (typeof error === 'function') {
          error(err)
        } else {
          console.error(err)
        }
      })

    /**  使用实例
     *   无需引入任何文件可全局使用
     *
     *  this.api.post({
     *      url:'loginURL', //此处使用的是apiURL里面的对象key值
     *      data:{   //可选
     *          userId:110
     *      },
     *      callback:function(res){
     *          console.log(res)
     *      },
     *      error:function(err){
     *          console.log(err)
     *      }
     *  })
     *
     */
  },
  getType (obj) {
    // tostring会返回对应不同的标签的构造函数
    var toString = Object.prototype.toString
    var map = {
      '[object Boolean]': 'boolean',
      '[object Number]': 'number',
      '[object String]': 'string',
      '[object Function]': 'function',
      '[object Array]': 'array',
      '[object Date]': 'date',
      '[object RegExp]': 'regExp',
      '[object Undefined]': 'undefined',
      '[object Null]': 'null',
      '[object Object]': 'object'
    }
    if (obj instanceof Element) {
      return 'element'
    }
    return map[toString.call(obj)]
  },
  deepClone (data) {
    var type = this.getType(data)
    var obj
    if (type === 'array') {
      obj = []
    } else if (type === 'object') {
      obj = {}
    } else {
      // 不再具有下一层次
      return data
    }
    if (type === 'array') {
      for (var i = 0, len = data.length; i < len; i++) {
        obj.push(this.deepClone(data[i]))
      }
    } else if (type === 'object') {
      for (var key in data) {
        obj[key] = this.deepClone(data[key])
      }
    }
    return obj
  },
  AddMinTime (x, type, n) {
    var t = new Date(x)
    var t_s = t.getTime() // 转化为时间戳毫秒数
    var time = new Date(t_s + 1000 * 60 * (n || 0))

    if (type == 'hour') {
      time = new Date(t_s + 1000 * 60 * (n || 0))
    }

    if (type == 'day') {
      time = new Date(t_s + 1000 * 60 * 60 * 24 * (n || 0))
    };

    var yyyy = time.getFullYear(),
      MM = time.getMonth() + 1,
      dd = time.getDate(),
      hh = time.getHours(),
      mm = time.getMinutes(),
      ss = time.getSeconds()
    MM = MM < 10 ? '0' + MM : MM
    dd = dd < 10 ? '0' + dd : dd
    hh = hh < 10 ? '0' + hh : hh
    mm = mm < 10 ? '0' + mm : mm
    ss = ss < 10 ? '0' + ss : ss
    return yyyy + '-' + MM + '-' + dd
  }
  //   getCurrentTime () { // 获取当前时间
  //     var date = new Date()
  //     var seperator1 = '-'
  //     var seperator2 = ':'
  //     var month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1
  //     var strDate = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
  //     var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
  //     return currentdate
  //   }

}

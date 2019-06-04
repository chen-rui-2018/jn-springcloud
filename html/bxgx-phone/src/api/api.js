
import axios from 'axios'
export default {
  // host: 'http://172.16.160.19:6063/#/investment/',
  host: 'http://112.94.22.222:8000/',
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
    findProductDetails: 'springcloud-enterprise/guest/servicemarket/product/web/findProductDetails', // 服务产品详情
    sameTypeProductList: 'springcloud-enterprise/guest/servicemarket/product/web/sameTypeProductList', // 同类型产品
    activityLike: 'springcloud-park/activity/activityLike/activityLike', // 活动点赞
    CancelLike: 'springcloud-park/activity/activityLike/cancelLike', // 取消点赞
    quickApply: 'springcloud-park/activity/activityApply/quickApply', // 快速报名

    trafficVolume: 'springcloud-enterprise/guest/pd/declarationNotice/trafficVolume', // 申报中心访问量
    onlineBooking: 'springcloud-enterprise/pd/online/onlineBooking', // 申报中心预约申报
    talentsTypeList: 'springcloud-enterprise/guest/pd/talentNotice/typeList', // 人才服务公告所属类型列表
    talentsList: 'springcloud-enterprise/guest/pd/talentNotice/list', // 人才服务公告列表
    talentsDetail: 'springcloud-enterprise/guest/pd/talentNotice/selectByTalentNotice', // 人才服务详情
    talentsVolume: 'springcloud-enterprise/guest/pd/talentNotice/trafficVolume', // 人才服务访问量
    // loginURL: 'springcloud-app-system/login',

    // 工作计划管理
    getWorkList: 'springcloud-oa/oa/workPlan/list', // 获取工作计划管理列表
    getItemAll: 'springcloud-oa/oa/workPlan/getItemAll', // 获取所有项目信息
    uploadAttachment: 'zuul/springcloud-oa/oa/common/uploadAttachment', // 上传附件
    getWorkPlanById: 'springcloud-oa/oa/workPlan/getWorkPlanById', // 根据id获取工作计划详情
    getAllUser: 'springcloud-oa/oa/addressBook/list', // 获取所有用户
    addWorkPlan: 'springcloud-oa/oa/workPlan/add', // 添加工作计划
    update: 'springcloud-oa/oa/workPlan/update', // 编辑工作计划
    updateWorkPlanStatus: 'springcloud-oa/oa/workPlan/updateWorkPlanStatus', // 修改任务状态
    downLoadAttachment: 'springcloud-oa/oa/common/downLoadAttachment', // 附件下载
    deleteBatch: 'springcloud-oa/oa/workPlan/deleteBatch', // 删除工作计划
    addRemark: 'springcloud-oa/oa/workPlan/addRemark', // 添加备注

    //  考勤管理
    getUserInfo: 'springcloud-app-system/system/sysUser/getUserInfo', // 获取用户id
    selectByUserIdAndCurrentDate: 'springcloud-oa/oa/attendance/selectByUserIdAndCurrentDate', // 根据用户ID查询当天考勤详情
    attendance: 'springcloud-oa/oa/attendance/attendance', // 考勤签到/签退

    selectAttendanceManagementByUserId: 'springcloud-oa/oa/attendance/selectAttendanceManagementByUserId', // 根据用户id查询用户考勤打卡数据
    selectAttendanceManagementByDepartmentId: 'springcloud-oa/oa/attendance/selectAttendanceManagementByDepartmentId', // 根据部门id查询部门考勤打卡数据
    selectLocation: 'springcloud-oa/oa/attendance/selectLocation', // 根据经纬度查询距离与是否能进行打卡

    findNoticeDetails: 'springcloud-park/guest/park/notice/web/findNoticeDetailsByNoticeId', // 公告详情
    findActivityTypeList: 'springcloud-park/guest/activity/findActivityTypeList', // 查询活动类型列表
    activityListSlim: 'springcloud-park/guest/activity/activityListSlim', // 获取前台活动列表
    getPolicyClassList: 'springcloud-park/guest/policy/policyCenterController/getPolicyClassList', // 政策分类列表
    getPolicyCenterList: 'springcloud-park/guest/policy/policyCenterController/getPolicyCenterList', // 政策中心首页列表
    getPolicyDetails: 'springcloud-park/guest/policy/policyCenterController/getPolicyDetails', // 政策指南详情

    // 招商引资
    getPromotionList: 'springcloud-enterprise/guest/businessHomePageController/getBusinessPromotionList', // (门户各首页企业宣传列表查询)
    basic: 'springcloud-park/guest/portal/park/basic', // 获取园区概况
    getBusinessAdDynamic: 'springcloud-park/guest/portal/businessAd/getBusinessAdDynamic', // 获取招商动态信息
    getBusinessAdDynamicInfo: 'springcloud-park/guest/portal/businessAd/getBusinessAdDynamicInfo', // 获取招商动态信息详情
    getBusinessAdPolicy: 'springcloud-park/guest/portal/businessAd/getBusinessAdPolicy', // 招商政策
    getBusinessAdPolicyInfo: 'springcloud-park/guest/portal/businessAd/getBusinessAdPolicyInfo', // 获取招商政策信息详情
    getBusinessAdContentInfo: 'springcloud-park/guest/portal/businessAd/getBusinessAdContentInfo', // 获取招商信息详情
    parkList: 'springcloud-park/guest/portal/park/list', // 一区多园
    getBusinessAdContent: 'springcloud-park/guest/portal/businessAd/getBusinessAdContent', // 获取招商信息
    getParkDetails: 'springcloud-park/guest/portal/park/get' // 根据ID获取对应园区详情
  },
  setToken: function (obj) {
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
    }
    //  else {
    //   url = url
    // }

    if (!data) data = {}
    var params
    var headerSS
    if (dataFlag) {
      var querystring = require('querystring')
      params = querystring.stringify(data)
      headerSS = 'application/x-www-form-urlencoded'
    } else {
      params = JSON.stringify(data)
      headerSS = 'application/json;charset=UTF-8'
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
    var tS = t.getTime() // 转化为时间戳毫秒数
    var time = new Date(tS + 1000 * 60 * (n || 0))

    if (type === 'hour') {
      time = new Date(tS + 1000 * 60 * (n || 0))
    }

    if (type === 'day') {
      time = new Date(tS + 1000 * 60 * 60 * 24 * (n || 0))
    };

    var yyyy = time.getFullYear()
    var MM = time.getMonth() + 1
    var dd = time.getDate()
    // hh = time.getHours(),
    // mm = time.getMinutes(),
    // ss = time.getSeconds()
    MM = MM < 10 ? '0' + MM : MM
    dd = dd < 10 ? '0' + dd : dd
    // hh = hh < 10 ? '0' + hh : hh
    // mm = mm < 10 ? '0' + mm : mm
    // ss = ss < 10 ? '0' + ss : ss
    return yyyy + '-' + MM + '-' + dd
  },
  getCurrentTime () { // 获取当前时间
    var date = new Date()
    // var seperator1 = '-'
    // var seperator2 = ':'
    var month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1
    var strDate = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
    var currentdate = date.getFullYear() + '年' + month + '月' + strDate + '日'
    return currentdate
  }

}

import axios from "axios"
export default {
    host:"http://112.94.22.222:8000/",//api的域名提出来放这里
    apiURL:{ //API路径统一管理,需要的路径在这里加就可以了
        loginURL:"springcloud-app-system/login",
        findActivityTypeList:"springcloud-park/guest/activity/findActivityTypeList",//查询活动类型列表
        activityListSlim:"springcloud-park/guest/activity/activityListSlim",//获取前台活动列表
        getActivityDetails:"springcloud-park/guest/getActivityDetails",//获取活动详情
        getCommentInfo:"springcloud-park/guest/getCommentInfo",//获取评论信息
        activityApplyList:"springcloud-park/activity/activityApply/activityApplyList",//报名人列表查看
        quickApply:'springcloud-park/activity/activityApply/quickApply',//快速报名
        cancelApply:"springcloud-park/activity/activityApply/cancelApply",//取消报名
        getUserExtension:"springcloud-user/guest/userInfo/getUserExtension",//获取当前用户资料
        activityLike:"springcloud-park/activity/activityLike/activityLike",//活动点赞
        CancelLike:"springcloud-park/activity/activityLike/cancelLike",//取消点赞
        commentActivity:"springcloud-park/comment/review/commentActivity",//活动评论/回复
        activityApplyInfo:"springcloud-park/activity/activityApply/activityApplyInfo",//报名人资料
        getUserCode:"springcloud-user/guest/userJoin/getUserCode",//获取短信验证码[当前用户]
        getCode:"springcloud-user/guest/userJoin/getCode",//获取短信验证码
        addUser:"springcloud-user/guest/userJoin/addUser",//用户注册
        updatePassword:"springcloud-user/guest/userJoin/updatePassword",//修改密码
        getUserPersonInfo:"springcloud-user/user/center/getUserPersonInfo",//根据用户账号获取用户资料信息
        modifyUserPassword:"springcloud-user/user/center/modifyUserPassword",//修改用户密码
        saveUserInfo:"springcloud-user/guest/userInfo/saveUserInfo",//保存用户资料
        getTagCodeList:"springcloud-user/guest/userTag/getTagCodeList",//获取用户字典列表
        findHotProducts:"springcloud-enterprise/servicemarket/product/web/findHotProducts",//热门产品
        selectIndustryList:"springcloud-enterprise/serviceMarket/industryManage/selectIndustryList",//顾问领域列表
        getServiceConsultantList:"springcloud-enterprise/guest/serviceMarket/advisorController/getServiceConsultantList",//机构服务顾问
        selectTeamList:"springcloud-enterprise/guest/serviceMarket/industryManage/selectIndustryList",//机构领域获取
        selectServiceOrgList:"springcloud-enterprise/guest/serviceMarket/org/selectServiceOrgList",//服务机构列表获取
        getServiceRatingInfo:"springcloud-enterprise/guest/serviceMarket/advisorController/getServiceRatingInfo",//最新评价
        getCompassAllCate:"springcloud-park/guest/portal/sp/power/departList",//compassView所有类别
        getpowerList:"springcloud-park/guest/portal/sp/power/list",//权力清单列表
        getpowerDetail:"springcloud-park/guest/portal/sp/power/get",//权利明细
        getseviceDetail:"springcloud-park/guest/portal/sp/power/getBusi",//业务明细（服务详情）
        message:"springcloud-park/portal/sp/power/SpMessage",//我要留言
        getplatform:"springcloud-enterprise/pd/declaration/list",//申报平台列表数据
        getplatformtype:"springcloud-enterprise/pd/declaration/typeList",//申报品台类型
        getdeclarationcentertype:"springcloud-enterprise/guest/pd/declarationNotice/typeList",//申报中心所属类型
        getdeclarationcentertList:"springcloud-enterprise/guest/pd/declarationNotice/list",//申报中心列表数据 
        getnoticeDetail:"springcloud-enterprise/guest/pd/declarationNotice/selectByTalentNotice",//申报公告详情
        addpageviews:"springcloud-enterprise/guest/pd/declarationNotice/trafficVolume",//增加访问量
        gettalentstype:"springcloud-enterprise/guest/pd/talentNotice/typeList",//人才服务公告所属类型列表
        gettalentsList:"springcloud-enterprise/guest/pd/talentNotice/list",//人才服务公告列表
        gettalentDetail:"springcloud-enterprise/guest/pd/talentNotice/selectByTalentNotice",//人才公告详情
        addtalentviews:"springcloud-enterprise/guest/pd/talentNotice/trafficVolume",//增加人才公告详情访问量
        appointment:"springcloud-enterprise/pd/online/onlineBooking",//预约申报
    },
    setToken: function (obj) {   //设置token在请求头上面
        axios.interceptors.request.use(function (config) {
            config.headers['token'] = obj
            return config;
        }, function (error) {
            return Promise.reject(error);
        })
    },
    get: function (url, data, callback, error) {
        let _this = this
        if (!url) {
            return alert("未获取到有效的URL");
        };

        if(typeof url === "object"){
            data = url.data;
            callback = url.callback;
            error = url.error;
            url = url.url;
        }
        url = this.apiURL[url];
        if(!data) data = {}

        axios.get(this.host + url, {
            params: data || {},
            headers:{
                'token':sessionStorage.token || ''
            }
        })
            .then(function (response) {
                if (typeof callback === "function")
                    callback(response.data);
            })
            .catch(function (err) {
                if (typeof error === "function")
                    error(err);
                else
                    console.error(err)
            });



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
    post: function(url, data, dataFlag, urlFlag, callback, error){
        if (!url) {
            return alert("未获取到有效的URL");
        };
        if(typeof url === "object"){
            data = url.data;
            callback = url.callback;
            error = url.error;
            dataFlag = url.dataFlag;
            urlFlag = url.urlFlag;
            url = url.url;
        }
        if(!urlFlag){
            url = this.apiURL[url];
        }else{
            url = url
        }

        if(!data) data = {}
        if(dataFlag){
            var querystring = require('querystring');
            var params = querystring.stringify(data);
            var headerSS = 'application/x-www-form-urlencoded'
        }else{
            var params = JSON.stringify(data);
            var headerSS = 'application/json;charset=UTF-8'
        }
        axios.post(this.host + url, params,{
            headers: {
                'Content-Type':headerSS,
                'token':sessionStorage.token || ''
            }
        })
          .then(function (response) {
            if (typeof callback === "function")
                callback(response.data);

          })
          .catch(function (err) {
            if (typeof error === "function")
                error(err);
            else
                console.error(err)
          });


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
    getType(obj){
        //tostring会返回对应不同的标签的构造函数
        var toString = Object.prototype.toString;
        var map = {
           '[object Boolean]'  : 'boolean',
           '[object Number]'   : 'number',
           '[object String]'   : 'string',
           '[object Function]' : 'function',
           '[object Array]'    : 'array',
           '[object Date]'     : 'date',
           '[object RegExp]'   : 'regExp',
           '[object Undefined]': 'undefined',
           '[object Null]'     : 'null',
           '[object Object]'   : 'object'
       };
       if(obj instanceof Element) {
            return 'element';
       }
       return map[toString.call(obj)];
    },
    deepClone(data){
        var type = this.getType(data);
        var obj;
        if(type === 'array'){
            obj = [];
        } else if(type === 'object'){
            obj = {};
        } else {
            //不再具有下一层次
            return data;
        }
        if(type === 'array'){
            for(var i = 0, len = data.length; i < len; i++){
                obj.push(this.deepClone(data[i]));
            }
        } else if(type === 'object'){
            for(var key in data){
                obj[key] = this.deepClone(data[key]);
            }
        }
        return obj;
    },
    AddMinTime(x,type,n){
		var t = new Date(x);
		var t_s = t.getTime(); //转化为时间戳毫秒数
		var time = new Date(t_s + 1000 * 60 * (n || 0));

		if(type == 'hour') {
			time = new Date(t_s + 1000 * 60 * (n || 0));
		}

		if(type == 'day') {
			time = new Date(t_s + 1000 * 60 * 60 * 24 * (n || 0));
		};

		var yyyy = time.getFullYear(),
			MM = time.getMonth() + 1,
			dd = time.getDate(),
			hh = time.getHours(),
			mm = time.getMinutes(),
			ss = time.getSeconds();
		MM = MM < 10 ? '0' + MM : MM;
		dd = dd < 10 ? '0' + dd : dd;
		hh = hh < 10 ? '0' + hh : hh;
		mm = mm < 10 ? '0' + mm : mm;
		ss = ss < 10 ? '0' + ss : ss;
		return yyyy + '-' + MM + '-' + dd;
	}
}

﻿import axios from "axios"
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
        selectTeamList:"springcloud-enterprise/guest/serviceMarket/industryManage/selectIndustryList",//机构字典
        selectServiceOrgList:"springcloud-enterprise/guest/serviceMarket/org/selectServiceOrgList",//服务机构列表获取
        getServiceRatingInfo:"springcloud-enterprise/guest/serviceMarket/advisorController/getServiceRatingInfo",//最新评价
        selectIndustryProductList:"springcloud-enterprise/guest/serviceMarket/industryManage/selectIndustryProductList",// 服务超市侧边导航
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
        getTechnologyInfoNum:"springcloud-enterprise/guest/technologyFinancial/financialProductController/getTechnologyInfoNum",//科技金融首页投资人数，金融产品数，金融机构数
        getInvestorInfoList:"springcloud-enterprise/guest/technologyFinancial/investorController/getInvestorInfoList",//投资人列表查询
        getFinancialProList:"springcloud-enterprise/guest/technologyFinancial/financialProductController/getFinancialProductList",//金融产品列表查询

        getActivityDetailsFm:"springcloud-enterprise/guest/serviceMarket/org/getActivityDetailsForManage",//获取服务机构详情
        findOrgProductList:"springcloud-enterprise/servicemarket/product/web/findOrgProductList",//机构-服务产品列表
        findOrgCountProductList:"springcloud-enterprise/servicemarket/product/web/findOrgCountProductList",//机构详情下-服务产品列表
        findProductList:"springcloud-enterprise/servicemarket/product/web/findProductList",//服务产品列表
        findProductDetails:"springcloud-enterprise/servicemarket/product/web/findProductDetails",//服务产品详情
        sameTypeProductList:"springcloud-enterprise/servicemarket/product/web/sameTypeProductList",//服务产品详情下的同类型服务列表
        getServiceConList:"springcloud-enterprise/guest/serviceMarket/advisorController/getServiceConsultantList",//服务顾问列表
        getEvaluationCountInfo:"springcloud-enterprise/guest/serviceMarket/advisorController/getEvaluationCountInfo",//服务评价统计信息
        // selActiList:"springcloud-park/activity/selectActivityList",//获取活动资讯
        selActiList:"springcloud-park/guest/activity/findOrgActivityList",//获取活动资讯
        userDemandTechnology:"springcloud-enterprise/serviceMarket/requireManagementController/userDemandTechnology",//用户提需求(科技金融)
        userDemand:"springcloud-enterprise/serviceMarket/requireManagementController/userDemand",// 用户提需求(非科技金融)(pc/app新增需求)
        getServiceAdvisorInfo:"springcloud-enterprise/guest/serviceMarket/advisorController/getServiceAdvisorInfo",// 服务顾问详情
        advisorProductList:"springcloud-enterprise/servicemarket/product/web/advisorProductList",// 服务顾问-服务产品列表
        getInvestorInfoList:"springcloud-enterprise/guest/technologyFinancial/investorController/getInvestorInfoList",// 科技金融-投资人列表
        getInvestorMainArea:"springcloud-enterprise/technologyFinancial/investorController/getInvestorMainArea",// 科技金融-查询投资人主投领域
        getInvestorInfoDetails:"springcloud-enterprise/technologyFinancial/investorController/getInvestorInfoDetails",// 投资人详情/投资人查看

        getOrgProductList:"springcloud-enterprise/servicemarket/product/web/findOrgProductList",//机构-服务产品列表
        getShelfProductList:"springcloud-enterprise/servicemarket/product/web/findShelfProductList",//常规-通过id获取产品名称列表
        upShelfCommonService:"springcloud-enterprise/servicemarket/product/web/upShelfCommonService",//常规产品上架大按钮
        productShelf:"springcloud-enterprise/servicemarket/product/manage/productShelf",//表格常规产品上下架小按钮
        getFinancialProductDetails:"springcloud-enterprise/guest/technologyFinancial/financialProductController/getFinancialProductDetails",//获取科技金融产品详情
        upShelfCommonProduct:"springcloud-enterprise/technologyFinancial/financialProductController/upShelfCommonProduct",//科技金融新增上架
        // 企业数据上报入口
        enterpriseGetForm:"springcloud-enterprise/data/company/getForm", // 获取本月待填报的任务
        enterpriseGetFormed:"springcloud-enterprise/data/company/getFormed", // 获取企业填报历史表单列表
        enterpriseGetFormStruct:"springcloud-enterprise/data/company/getFormStruct", // 获取待填报的表单结构
        enterpriseSaveCompanyFormData:"springcloud-enterprise/data/company/saveCompanyFormData", // 保存企业数据上报信息
        enterpriseSaveCompanyFormDataIsDraft:"springcloud-enterprise/data/company/saveCompanyFormDataIsDraft", // 保存企业数据上报保存为草稿
        enterpriseGetPcAd:"springcloud-enterprise/data/company/getPcAd", // 页面广告获取

        getMyBusiness:"springcloud-enterprise/guest/company/getCompanyDetailByNowAccount",//获取当前用户企业信息
        getUserAccount:"springcloud-app-system/system/sysUser/getUserInfo",//获取用户账号
        postJob:"springcloud-enterprise/enterprise/RecruitController/publishRecruitInfo",//发布招聘
        getInviteStaffList:"springcloud-enterprise/enterprise/InvitationController/getInviteStaffList",//获取邀请员工的资料
        getCompensation:"springcloud-enterprise/guest/CommonController/getServiceCodeList",//获取薪资待遇
        getInviteType:"springcloud-enterprise/guest/CommonController/getServiceCodeList",//获取招聘类型
        getStaffList:"springcloud-enterprise/enterprise/StaffController/getStaffList",//获取员工管理列表
        getWebRecruitList:"springcloud-enterprise/enterprise/RecruitController/getRecruitList",//获取招聘管理列表
        underRecruit:"springcloud-enterprise/enterprise/RecruitController/underRecruit",//上下架招聘
        getRecruitDetails:"springcloud-enterprise/guest/RecruitController/viewRecruitDetails",//获取招聘详情
        editRecruitDetails:"springcloud-enterprise/enterprise/RecruitController/editRecruitInfo",//编辑招聘信息
        getColleagueList:"springcloud-enterprise/enterprise/ColleagueController/getColleagueList",//获取企业同事列表
        delColleague:"springcloud-enterprise/enterprise/ColleagueController/delColleague",//删除企业同事
        cancelContact:"springcloud-enterprise/enterprise/ColleagueController/cancelContact",//取消联系人
        setContact:"springcloud-enterprise/enterprise/ColleagueController/setContact",//设为联系人
        reviewStaff:"springcloud-enterprise/enterprise/StaffController/reviewStaff",//同意邀请员工
        inviteStaffAgain:"springcloud-enterprise/enterprise/InvitationController/inviteStaffAgain",//再次邀请员工
        inviteStaff:"springcloud-enterprise/enterprise/InvitationController/inviteStaff",//邀请员工
        getBusinessPromotionList:"springcloud-enterprise/propaganda/businessPromotionController/getBusinessPromotionList",//获取企业宣传列表
        getPropagandaFeeRulesList:"springcloud-enterprise/propaganda/businessPromotionController/getPropagandaFeeRulesList",//获取企业宣传费用规则
        saveBusinessPromotion:"springcloud-enterprise/propaganda/businessPromotionController/saveBusinessPromotion",//发布企业宣传
        getPropagandaTypeList:"springcloud-enterprise/propaganda/businessPromotionController/getPropagandaTypeList",//获取企业宣传类型
        getPropagandaAreaList:"springcloud-enterprise/propaganda/businessPromotionController/getPropagandaAreaList",//获取企业宣传区域信息
        getBusinessPromotionDetails:"springcloud-enterprise/propaganda/businessPromotionController/getBusinessPromotionDetails",//获取企业宣传详情
        cancelApprove:"springcloud-enterprise/propaganda/businessPromotionController/cancelApprove",//撤消企业申请
        //我的机构
        inviteAdvisor:"springcloud-enterprise/serviceMarket/advisorManagementController/inviteAdvisor",//邀请顾问
        advisorDetails:"springcloud-enterprise/serviceMarket/advisorManagementController/advisorDetails",//获取邀请顾问的资料
        getAdvisorManagementInfo:"springcloud-enterprise/serviceMarket/advisorManagementController/getAdvisorManagementInfo",//获取顾问管理列表
        inviteAgain:"springcloud-enterprise/serviceMarket/advisorManagementController/inviteAgain",//再次邀请顾问
        cancelAsContact:"springcloud-enterprise/serviceMarket/orgColleagueController/cancelAsContact",//机构同事取消联系人
        setAsContact:"springcloud-enterprise/serviceMarket/orgColleagueController/setAsContact",//机构同事设为联系人
        deleteContactOrAdvisor:"springcloud-enterprise/serviceMarket/orgColleagueController/deleteContactOrAdvisor",//机构同事删除联系人
        getOrgColleagueList:"springcloud-enterprise/serviceMarket/orgColleagueController/getOrgColleagueList",//获取机构同事列表
        getMyOrgInfo:"springcloud-enterprise/guest/serviceMarket/org/getMyOrgInfo",//获取我的机构信息
        approvalAdvisorInfo:"springcloud-enterprise/serviceMarket/advisorManagementController/approvalAdvisorInfo",//审批顾问填写信息
        echoUserInfo:"springcloud-enterprise/serviceMarket/advisorManagementController/echoUserInfo",//获取顾问信息
        saveOrUpdateAdvisorBaseInfo:"springcloud-enterprise/serviceMarket/advisorEditController/saveOrUpdateAdvisorBaseInfo",//保存顾问基本信息
        getCertificateTypeList:"springcloud-enterprise/serviceMarket/advisorEditController/getCertificateTypeList",//获取指定证书类型
        saveOrUpdateAdvisorHonor:"springcloud-enterprise/serviceMarket/advisorEditController/saveOrUpdateAdvisorHonor",//新增顾问荣誉资质信息



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
    },
    getCurrentTime() {//获取当前时间
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1<10? "0"+(date.getMonth() + 1):date.getMonth() + 1;
	var strDate = date.getDate()<10? "0" + date.getDate():date.getDate();
	var currentdate = date.getFullYear() + seperator1  + month  + seperator1  + strDate
	return currentdate;
}

}

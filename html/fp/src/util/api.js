import axios from "axios"
export default {
    host:"http://112.94.22.222:8000/",//api的域名提出来放这里
    apiURL:{ //API路径统一管理,需要的路径在这里加就可以了
        loginURL:"springcloud-app-system/login",
        getDynamicMenu:"springcloud-app-system/system/sysMenu/getDynamicMenu",
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
        commentActivityCancelLike:"springcloud-park/comment/review/commentActivityCancelLike",//评论取消点赞
        commentActivityLike:"springcloud-park/comment/review/commentActivityLike",//评论取消点赞
        activityApplyInfo:"springcloud-park/activity/activityApply/activityApplyInfo",//报名人资料
        findActivityRegistration:"springcloud-park/guest/activity/findActivityRegistration",//用户中心-已报名活动列表
        basic:"springcloud-park/guest/portal/park/basic",//获取园区概况
        getBusinessAdDynamic:"springcloud-park/guest/portal/businessAd/getBusinessAdDynamic",//获取招商动态信息
        getBusinessAdDynamicInfo:"springcloud-park/guest/portal/businessAd/getBusinessAdDynamicInfo",//获取招商动态信息详情
        getBusinessAdPolicy:"springcloud-park/guest/portal/businessAd/getBusinessAdPolicy",//招商政策
        getBusinessAdPolicyInfo:"springcloud-park/guest/portal/businessAd/getBusinessAdPolicyInfo",//获取招商政策信息详情
        getBusinessAdContentInfo:"springcloud-park/guest/portal/businessAd/getBusinessAdContentInfo",//获取招商信息详情
        parkList:"springcloud-park/guest/portal/park/list",//一区多园


        getUserCode:"springcloud-user/guest/userJoin/getUserCode",//获取短信验证码[当前用户]
        getCode:"springcloud-user/guest/userJoin/getCode",//获取短信验证码
        addUser:"springcloud-user/guest/userJoin/addUser",//用户注册
        accountIsExist:"springcloud-user/guest/userJoin/accountIsExist",//当前账号是否已存在
        updatePassword:"springcloud-user/guest/userJoin/updatePassword",//修改密码
        getUserPersonInfo:"springcloud-user/user/center/getUserPersonInfo",//根据用户账号获取用户资料信息
        modifyUserPassword:"springcloud-user/user/center/modifyUserPassword",//修改用户密码
        saveUserInfo:"springcloud-user/guest/userInfo/saveUserInfo",//保存用户资料
        getTagCodeList:"springcloud-user/guest/userTag/getTagCodeList",//获取用户字典列表
        findHotProducts:"springcloud-enterprise/guest/servicemarket/product/web/findHotProducts",//热门产品
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
        list:"springcloud-enterprise/guest/pd/perennialDeclaration/list",//常年申报列表
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
        getFinancialProList:"springcloud-enterprise/guest/technologyFinancial/financialProductController/getFinancialProductList",//金融产品列表查询
        getAssureType:"springcloud-enterprise//technologyFinancial/financialProductController/getFinancialProductAssureType",//金融产品担保方式

        getActivityDetailsFm:"springcloud-enterprise/guest/serviceMarket/org/getActivityDetailsForManage",//获取服务机构详情
        findOrgProductList:"springcloud-enterprise/servicemarket/product/web/findOrgProductList",//机构-服务产品列表
        findOrgCountProductList:"springcloud-enterprise/guest/servicemarket/product/web/findOrgCountProductList",//机构详情下-服务产品列表
        findProductList:"springcloud-enterprise/guest/servicemarket/product/web/findProductList",//服务产品列表
        findProductDetails:"springcloud-enterprise/guest/servicemarket/product/web/findProductDetails",//服务产品详情
        sameTypeProductList:"springcloud-enterprise/guest/servicemarket/product/web/sameTypeProductList",//服务产品详情下的同类型服务列表
        getServiceConList:"springcloud-enterprise/guest/serviceMarket/advisorController/getServiceConsultantList",//服务顾问列表
        getEvaluationCountInfo:"springcloud-enterprise/guest/serviceMarket/advisorController/getEvaluationCountInfo",//服务评价统计信息
        // selActiList:"springcloud-park/activity/selectActivityList",//获取活动资讯
        selActiList:"springcloud-park/guest/activity/findOrgActivityList",//获取活动资讯
        userDemandTechnology:"springcloud-enterprise/serviceMarket/requireManagementController/userDemandTechnology",//用户提需求(科技金融)
        userDemand:"springcloud-enterprise/serviceMarket/requireManagementController/userDemand",// 用户提需求(非科技金融)(pc/app新增需求)
        getServiceAdvisorInfo:"springcloud-enterprise/guest/serviceMarket/advisorController/getServiceAdvisorInfo",// 服务顾问详情
        advisorProductList:"springcloud-enterprise/guest/servicemarket/product/web/advisorProductList",// 服务顾问-服务产品列表
        getInvestorInfoList:"springcloud-enterprise/guest/technologyFinancial/investorController/getInvestorInfoList",// 科技金融-投资人列表
        getInvestorMainArea:"springcloud-enterprise/guest/technologyFinancial/investorController/getInvestorMainArea",// 科技金融-查询投资人主投领域
        getInvestorInfoDetails:"springcloud-enterprise/guest/technologyFinancial/investorController/getInvestorInfoDetails",// 投资人详情/投资人查看

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
        enterpriseGetCompanyFormedStruct:"springcloud-enterprise/data/company/getCompanyFormedStruct", // 获取企业已经填报的表单的结构信息和值
        enterpriseSaveCompanyFormData:"springcloud-enterprise/data/company/saveCompanyFormData", // 保存企业数据上报信息

        enterpriseSaveCompanyFormDataIsDraft:"springcloud-enterprise/data/company/saveCompanyFormDataIsDraft", // 保存企业数据上报保存为草稿

        enterpriseGetScientTabHeader:"springcloud-enterprise/data/garden/getScientTabHeader", // 科技园模板表头查询接口
        enterpriseGetImportData:"springcloud-enterprise/data/garden/getImportData", // 科技园模板查询数据接口
        enterpriseImportData:"springcloud-enterprise/data/garden/importData", // 科技园导入接口
        enterpriseGetCheckOrLookInfo:"springcloud-enterprise/data/garden/getCheckOrLookInfo", // 审核列表
        getScienceExcel:"springcloud-enterprise/data/garden/getScienceExcel", // 科技园模板
        getCompanyExcel:"springcloud-enterprise/data/garden/getCompanyExcel", // 纵向树形指标导出模式
        getScienceHeaderExcel:"springcloud-enterprise/data/garden/getScienceHeaderExcel", // 科技园模板表头

        // 个人中心首页
        findEmployeeRequisition:"springcloud-enterprise/userCenter/Index/findEmployeeRequisition", // 员工申请
        findActivityManage:"springcloud-enterprise/userCenter/Index/findActivityManage", // 活动管理
        findAdviserInvitation:"springcloud-enterprise/userCenter/Index/findAdviserInvitation", // 顾问管理
        findEvaluateManage:"springcloud-enterprise/userCenter/Index/findEvaluateManage", // 评价管理
        findReportedData:"springcloud-enterprise/userCenter/Index/findReportedData", // 数据上报
        findRequirementManage:"springcloud-enterprise/userCenter/Index/findRequirementManage", // 需求管理

        //im即时聊天
        selectMsg:"im/selectMsg", // 获取聊天记录
        isSended:"im/isSended", // 消息设置为已读
        selectMsgList:"im/selectMsgList", // 获取聊天列表

     //我的企业
        getMyBusiness:"springcloud-enterprise/guest/company/getCompanyDetailByNowAccount",//获取当前用户企业信息
        getCompanyDetailByAccountOrCompanyId:"springcloud-enterprise/guest/company/getCompanyDetailByAccountOrCompanyId",//根据用户账号/企业ID查询企业信息
        acceptInvite:"springcloud-enterprise/enterprise/InvitationController/acceptInvite",//接受企业邀请
        refuseInvite:"springcloud-enterprise/enterprise/InvitationController/refuseInvite",//拒绝企业邀请
        getUserAccount:"springcloud-app-system/system/sysUser/getUserInfo",//获取用户账号
        leaveCompany:"springcloud-enterprise/enterprise/ColleagueController/leaveCompany",//离开企业
        getUserApprovalStatus:"springcloud-enterprise/serviceMarket/advisorEditController/getUserApprovalStatus",//判断当前登录用户认证顾问的状态
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
        submitAudit:"springcloud-enterprise/propaganda/businessPromotionController/submitAudit",//提交审核
        getPropagandaTypeList:"springcloud-enterprise/propaganda/businessPromotionController/getPropagandaTypeList",//获取企业宣传类型
        getPropagandaAreaList:"springcloud-enterprise/propaganda/businessPromotionController/getPropagandaAreaList",//获取企业宣传区域信息
        getBusinessPromotionDetails:"springcloud-enterprise/propaganda/businessPromotionController/getBusinessPromotionDetails",//获取企业宣传详情
        cancelApprove:"springcloud-enterprise/propaganda/businessPromotionController/cancelApprove",//撤消企业申请
        updateCompanyInfo:"springcloud-enterprise/enterprise/company/updateCompanyInfo",//编辑企业
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
        saveOrUpdateAdvisorExperience:"springcloud-enterprise/serviceMarket/advisorEditController/saveOrUpdateAdvisorExperience",//新增服务经历信息
        saveOrUpdateAdvisorProjectExperience:"springcloud-enterprise/serviceMarket/advisorEditController/saveOrUpdateAdvisorProjectExperience",//新增项目经验信息
        acceptOrgInvitation:"springcloud-enterprise/serviceMarket/acceptOrgInvitationController/acceptOrgInvitation",//接受机构邀请
        refuseInvitation:"springcloud-enterprise/serviceMarket/acceptOrgInvitationController/refuseInvitation",//拒绝机构邀请
        getOrgInfoForManage:"springcloud-enterprise/guest/serviceMarket/org/getOrgInfoForManage",//获取服机构信息[机构详情+产品列表](pc/app机构信息)
        // 角色认证
        getInvestorMainRound:"springcloud-enterprise//guest/technologyFinancial/investorController/getInvestorMainRound",//获取主投领域
        getAffiliationUnit:"springcloud-enterprise/guest/technologyFinancial/investorController/getAffiliationUnit",//获取所属单位
        addInvestorInfo:"springcloud-enterprise/technologyFinancial/investorController/addInvestorInfo",//提交投资人认证资料
        saveOrUpdateOrgDetail:"springcloud-enterprise/guest/orgJoinPark/saveOrUpdateOrgDetail",//服务机构认证
        selectOrgInfo:"springcloud-enterprise/serviceMarket/advisorApproveController/selectOrgInfo",//获取服务机构列表
        serviceAdvisorInfo:"springcloud-enterprise/serviceMarket/advisorEditController/getServiceAdvisorInfo",//服务顾问详情回显
        sendApproval:"springcloud-enterprise/serviceMarket/advisorEditController/sendApproval", // 发送申请/提交审批(将顾问信息审批状态由未反馈改为待审批)



        enterpriseGetPcAd:"springcloud-enterprise/data/company/getPcAd",// 页面广告获取
        selectCompany:"springcloud-enterprise/joinPark/userUpgrade/selectCompany", // 查询公司列表
        changeToStaff:"springcloud-enterprise/joinPark/userUpgrade/changeToStaff", // 升级员工
        changeToCompany:"springcloud-enterprise/joinPark/userUpgrade/changeToCompany", // 升级企业



        addOrEditMemorandum:"springcloud-enterprise/pd/declaration/addOrEditMemorandum",//申报平台备注
        getProductSerialNumber:"springcloud-enterprise/servicemarket/product/manage/getProductSerialNumber",//产品编号获取
        updateCommonProduct:"springcloud-enterprise/servicemarket/product/web/updateCommonProduct",
        upShelfFeatureProduct:"springcloud-enterprise/technologyFinancial/financialProductController/upShelfFeatureProduct",//特色科技金融产品添加
        getFinancialProductAssureType:"springcloud-enterprise/technologyFinancial/financialProductController/getFinancialProductAssureType",//金融产品担保方式
        getFinancialProductLoanType:"springcloud-enterprise/technologyFinancial/financialProductController/getFinancialProductLoanType",//金融产品贷款类别
        addFeatureService:"springcloud-enterprise/servicemarket/product/web/addFeatureService",//添加特色服务产品(非科技金融)
        modifyFeatureProduct:"springcloud-enterprise/technologyFinancial/financialProductController/modifyFeatureProduct",//编辑特色产品科技金融
        updateFeatureProduct:"springcloud-enterprise/servicemarket/product/web/updateFeatureProduct",//编辑特色产品非科技
        getRequireOtherList:"springcloud-enterprise/serviceMarket/requireManagementController/getRequireOtherList",//对他人的需求列表
        getOtherRequireDetails:"springcloud-enterprise/serviceMarket/requireManagementController/getOtherRequireDetails",//对他人的需求详情
        getRequireReceivedList:"springcloud-enterprise/serviceMarket/requireManagementController/getRequireReceivedList",//我收到的需求列表查询
        getReceivedRequireDetails:"springcloud-enterprise/serviceMarket/requireManagementController/getReceivedRequireDetails",//收到的需求详情
        cancelRequire:"springcloud-enterprise/serviceMarket/requireManagementController/cancelRequire",//撤销需求
        getGiveOthersCommentList:"springcloud-enterprise/guest/serviceMarket/comment/getGiveOthersCommentList",//获取对他人的评价列表
        handleRequire:"springcloud-enterprise/serviceMarket/requireManagementController/handleRequire",//对接需求
        getRatingCommentDetail:"springcloud-enterprise/guest/serviceMarket/comment/getRatingCommentDetail",//获取评价页详情
        getGiveMeCommentList:"springcloud-enterprise/guest/serviceMarket/comment/getGiveMeCommentList",//获取我收到的评价
        saveRatingComment:"springcloud-enterprise/guest/serviceMarket/comment/saveRatingComment",//提交评价信息

        getPolicyCenterList:"springcloud-park/guest/policy/policyCenterController/getPolicyCenterList",//政策中心首页列表
        getPolicyClassList:"springcloud-park/guest/policy/policyCenterController/getPolicyClassList",//政策分类列表
        getPolicyLevelList:"springcloud-park/guest/policy/policyCenterController/getPolicyLevelList",//政策级别列表
        getPolicyDetails:"springcloud-park/guest/policy/policyCenterController/getPolicyDetails",//政策指南详情
        getPolicyDiagramDetails:"springcloud-park/guest/policy/policyCenterController/getPolicyDiagramDetails",//图解政策详情
        selectBusinessAreaNum:"springcloud-enterprise/guest/serviceMarket/org/selectBusinessAreaStatisticalNum",//根据业务领域查询服务超市统计数据
        getCompanyList:"springcloud-enterprise/guest/company/getCompanyList",//查询企业列表
        getCompanyNewList:"springcloud-enterprise/guest/company/getCompanyNewList",//查询企业列表-新版
        getBusinessAdContent:"springcloud-park/guest/portal/businessAd/getBusinessAdContent",//获取招商信息


        getRecruitList:"springcloud-enterprise/guest/RecruitController/getWebRecruitList",//招聘列表（门户首页）
        getPromotionList:"springcloud-enterprise/guest/businessHomePageController/getBusinessPromotionList",//(门户各首页企业宣传列表查询)
        getPromotionDetails:"springcloud-enterprise/guest/businessHomePageController/getBusinessPromotionDetails",// (门户各首页企业宣传详情)
        findAllApp:"springcloud-park/message/list/findAllList",//获取一级消息类别下所有消息(APP端)
        getMessageList:"springcloud-park/message/list/findAll",//消息列表
        updateIsReadStatus:"springcloud-park/message/list/updateIsReadStatus",//修改已读状态
        getMessageOneTort:"springcloud-park/message/list/getMessageOneTort",//获取二级消息类别
        getParkList:"springcloud-park/guest/portal/park/list",//获取全部园区数据列表
        getIncubatorList:"springcloud-park/guest/hatch/incubator/list",//众创空间-首页信息查询
        SpAdvertising:"springcloud-park/guest/portal/sp/power/SpAdvertising",//行政审批轮播广告

        SpAdvertising:"springcloud-park/guest/portal/sp/power/SpAdvertising",//行政审批轮播广告

        showNoticeList:"springcloud-park/guest/park/notice/web/showNoticeListForPortal",//门户首页展示(轮播)公告列表
        findNoticeDetails:"springcloud-park/guest/park/notice/web/findNoticeDetailsByNoticeId",//公告详情
        getAchievementList:"springcloud-park/guest/IndexController/getAchievementList",//门户首页-成果展览
        achievementDetails:"springcloud-park/guest/IndexController/getAchievementDetails",//成果详情
        getParkDetails:"springcloud-park/guest/portal/park/get",// 根据ID获取对应园区详情
        getCompanyDetailByAccountOrCompanyId:"springcloud-enterprise/guest/company/getCompanyDetailByAccountOrCompanyId",//根据用户账号查询企业信息
        getCompanyDetails:"springcloud-enterprise/guest/company/getCompanyDetails",//查询企业详情-新版
        getComCommentInfo:"springcloud-enterprise/guest/company/getCommentInfo",//获取评论/留言信息
        getcommentActivity:"springcloud-enterprise/guest/company/commentActivity",//企业留言/留言回复
        getCompanyContactAccount:"springcloud-enterprise/guest/company/getCompanyContactAccount",//获取企业在线联系人账号
        addCareOperate:"springcloud-park/park/manage/care/addCareOperate",// 用户添加关注操作
        cancelCareOperate:"springcloud-park/park/manage/care/cancelCareOperate",//用户取消关注操作

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
                if (typeof callback === "function"){
                    if(response.data.code == "index"){
                        window.sessionStorage.removeItem('token')
                        window.sessionStorage.removeItem('account')
                        window.sessionStorage.removeItem('userInfo')
                        alert(response.data.result);
                        location.href="#login";
                        return
                    }
                    callback(response.data);
                }

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
        let headerType = url.headerType
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

        axios.post(this.host + url, headerType ? data : params,{
            headers: {
                'Content-Type': headerType ? headerType : headerSS,
                'token':sessionStorage.token || ''
            }
        })
          .then(function (response) {
            if (typeof callback === "function"){
                if(response.data.code == "index"){
                    window.sessionStorage.removeItem('token')
                    window.sessionStorage.removeItem('account')
                    window.sessionStorage.removeItem('userInfo')
                    alert(response.data.result);
                    location.href="#login";
                    return
                }
                callback(response.data);
            }


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
    AddMinTime(x,type,n,d){
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
        if(d == ":"){
            return yyyy + ':' + MM + ':' + dd;
        }else{
            return yyyy + '-' + MM + '-' + dd;
        }
    },
    getCurrentTime() {//获取当前时间
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1<10? "0"+(date.getMonth() + 1):date.getMonth() + 1;
	var strDate = date.getDate()<10? "0" + date.getDate():date.getDate();
	var currentdate = date.getFullYear() + seperator1  + month  + seperator1  + strDate
	return currentdate;
    },
    tokenInvalid(){

    }

}

import Vue from 'vue'
import Router from 'vue-router'
import store from '../store'
import { isMobile } from '@/util'
import { urlSearch } from '@/util/index'
import { setToken, getToken, setLastToken, getLastToken } from '@/util/auth'
import api from '@/util/api'
Vue.use(Router)

const router= new Router({
  // mode: 'history', // require service support 去掉url中的#
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return {
        x: 0,
        y: 0
      }
    }
  },
  routes: [{
      path: '/login',
      component: resolve => require(['@/views/login'], resolve),
      meta: {
        title: '登录'
      },
      name: 'login'
    },
    {
      path: '/register',
      component: resolve => require(['@/views/login/register'], resolve),
      meta: {
        title: '注册'
      },
      name: 'register'
    },
    // {
    //   path: '/register-email',
    //   component: resolve => require(['@/views/login/register-email'],resolve),
    //   meta: {title: '邮箱注册'},
    //   name:'register2'
    // },
    {
      path: '/forgetPsw',
      component: resolve => require(['@/views/login/forgetPsw'], resolve),
      meta: {
        title: '忘记密码'
      },
      name: 'forgetPsw'
    },
    {
      path: '/',
      component: resolve => require(['@/views/homeIndex'], resolve),
      children: [{
          path: '/',
          component: resolve => require(['@/views/portalIndex'], resolve),
          meta: {
            title: '门户首页'
          },
          name: 'portalIndex',
        },
        {
          path: '/parkIntroduction',
          component: resolve => require(['@/views/parkIntroduction'], resolve),
          meta: {
            title: '园区介绍'
          },
          name: 'parkIntroduction'
        },
        {
          path: '/investment',
          component: resolve => require(['@/views/investment'], resolve),
          meta: {
            title: '招商引资'
          },
          name: 'investment'
        },
        {
          path: '/parkIntroductionChild',
          component: resolve => require(['@/views/parkIntroductionChild'], resolve),
          meta: {
            title: '子园区介绍'
          },
          name: 'parkIntroductionChild'
        },
        {
          path: '/enterpriseservice',
          component: resolve => require(['@/views/enterpriseservice'], resolve),
          meta: {
            title: '企业服务首页'
          },
          name: 'enterpriseservice'
        },
        {
          path: '/compassView',
          component: resolve => require(['@/views/adminApprove/compassView/compassView'], resolve),
          meta: {
            title: '政策指引'
          },
          name: 'compassView'
        },
        {
          path: '/rightDetail',
          component: resolve => require(['@/views/adminApprove/compassView/rightDetail'], resolve),
          meta: {
            title: '权利详情'
          },
          name: 'rightDetail'
        },
        {
          path: '/serviceDetail',
          component: resolve => require(['@/views/adminApprove/compassView/serviceDetail'], resolve),
          meta: {
            title: '服务详情'
          },
          name: 'serviceDetail'
        },
        {
          path: '/declarationCenter',
          component: resolve => require(['@/views/declarationCenter/declarationCenter'], resolve),
          meta: {
            title: '申报中心'
          },
          name: 'declarationCenter'
        },
        {
          path: '/declarationTimely',
          component: resolve => require(['@/views/declarationCenter/declarationTimely'], resolve),
          meta: {
            title: '及时申报项目'
          },
          name: 'declarationTimely'
        },
        {
          path: '/declarationNoticeDetail',
          component: resolve => require(['@/views/declarationCenter/declarationNoticeDetail'], resolve),
          meta: {
            title: '申报公告详情'
          },
          name: 'declarationNoticeDetail'
        },
        {
          path: '/declarationPlatform',
          component: resolve => require(['@/views/declarationCenter/declarationPlatform'], resolve),
          meta: {
            title: '申报平台'
          },
          name: 'declarationPlatform'
        },
        {
          path: '/talentsService',
          component: resolve => require(['@/views/talentsService/talentsService'], resolve),
          meta: {
            title: '人才服务首页'
          },
          name: 'talentsService'
        },
        {
          path: '/talentPlatform',
          component: resolve => require(['@/views/talentsService/talentPlatform'], resolve),
          meta: {
            title: '人才服务申报平台'
          },
          name: 'talentPlatform'
        },
        {
          path: '/talentsServiceDetail',
          component: resolve => require(['@/views/talentsService/talentsServiceDetail'], resolve),
          meta: {
            title: '人才服务详情'
          },
          name: 'talentsServiceDetail'
        },
        {
          path: '/parkAdvantage',
          component: resolve => require(['@/views/parkAdvantage'], resolve),
          meta: {
            title: '园区优势'
          },
          name: 'parkAdvantage'
        },
        {
          path: 'messageCenter',
          component: resolve => require(['@/views/messageCenter/index'], resolve),
          meta: {
            title: '消息中心'
          },
          children: [{
              path: '/chat',
              component: resolve => require(['@/views/messageCenter/chat'], resolve),
              meta: {
                title: '社区交流'
              },
              name: 'chat'
            },
            {
              path: '/parkNotice',
              component: resolve => require(['@/views/messageCenter/parkNotice'], resolve),
              meta: {
                title: '园区通知'
              },
              name: 'parkNotice',
            },
            {
              path: '/corporateInvitation',
              component: resolve => require(['@/views/messageCenter/parkNotice'], resolve),
              meta: {
                title: '企业邀请'
              },
              name:'corporateInvitation',
            },
            {
              path: '/institutionInvitation',
              component: resolve => require(['@/views/messageCenter/parkNotice'], resolve),
              meta: {
                title: '机构邀请'
              },
              name:'institutionInvitation',
            },
            {
              path: '/enterpriseOrder',
              component: resolve => require(['@/views/messageCenter/parkNotice'], resolve),
              meta: {
                title: '企业订单'
              },
              name: 'enterpriseOrder',
            },
            {
              path: '/informationDynamics',
              component: resolve => require(['@/views/messageCenter/parkNotice'], resolve),
              meta: {
                title: '信息发布动态'
              },
              name: 'informationDynamics',
            },
            {
              path: '/paymentReminder',
              component: resolve => require(['@/views/messageCenter/parkNotice'], resolve),
              meta: {
                title: '缴费提醒'
              },
              name: 'paymentReminder',
            },
            {
              path: '/guestbook',
              component: resolve => require(['@/views/messageCenter/parkNotice'], resolve),
              meta: {
                title: '访客留言'
              },
              name: 'guestbook',
            },
            {
              path: '/dataReminder',
              component: resolve => require(['@/views/messageCenter/parkNotice'], resolve),
              meta: {
                title: '数据上报提醒'
              },
              name: 'dataReminder',
            },
          ]
        },
        {
          path: '/home',
          component: resolve => require(['@/views/home'], resolve),
          meta: {
            title: '用户中心'
          },
          name: 'home',
          // redirect: {
          //   name: 'userCenter'
          // },
          children: [{
              path: '/',
              name: 'userCenter',
              meta: {
                title: '首页'
              },
              component: resolve => require(['@/views/home/userCenter'], resolve)
            }, {
              path: '/userHome',
              name: 'userHome',
              meta: {
                title: '用户资料'
              },
              component: resolve => require(['@/views/home/userHome'], resolve)
            },
            {
              path: '/servicemarket/product/productService/ordinaryProduct',
              name: 'ordinaryProduct',
              meta: {
                title: '常规服务产品'
              },
              component: resolve => require(['@/views/home/productService/ordinaryProduct'], resolve)
            },
            {
              path: '/servicemarket/product/productService/productPutaway',
              name: 'productPutaway',
              meta: {
                title: '常规产品上架'
              },
              component: resolve => require(['@/views/home/productService/productPutaway'], resolve)
            },
            {
              path: '/servicemarket/product/productService/dataReport',
              name: 'dataReport',
              meta: {
                title: '企业数据上报入口',
                keepAlive: true
              },
              component: resolve => require(['@/views/dataReport'], resolve)
            },
            {
              path: '/servicemarket/product/productService/report',
              name: 'dataReportCommonEntrance',
              meta: {
                title: '数据上报'
              },
              component: resolve => require(['@/views/dataReport/report'], resolve)
            },
            {
              path: '/servicemarket/product/productService/dataReportEntrance',
              name: 'dataReportEntrance',
              meta: {
                title: '企业数据上报'
              },
              component: resolve => require(['@/views/dataReport/dataReportEntrance'], resolve)
            },
            {
              path: '/servicemarket/product/productService/ordinaryproductDetail',
              name: 'ordinaryproductDetail',
              meta: {
                title: '产品详情'
              },
              component: resolve => require(['@/views/home/productService/ordinaryproductDetail'], resolve)
            },
            {
              path: '/servicemarket/product/productService/ordinaryproductDetail',
              name: 'ordinaryproductDetail',
              meta: {
                title: '产品详情'
              },
              component: resolve => require(['@/views/home/productService/ordinaryproductDetail'], resolve)
            },
            {
              path: '/servicemarket/product/productService/ordinaryproductEdit',
              name: 'ordinaryproductEdit',
              meta: {
                title: '常规产品编辑'
              },
              component: resolve => require(['@/views/home/productService/ordinaryproductEdit'], resolve)
            },
            {
              path: '/servicemarket/product/productService/specialproduct',
              name: 'specialproduct',
              meta: {
                title: '特色服务产品管理'
              },
              component: resolve => require(['@/views/home/productService/specialproduct'], resolve)

            },
            {
              path: '/servicemarket/product/productService/addScience',
              name: 'addScience',
              meta: {
                title: '新增特色产品'
              },
              component: resolve => require(['@/views/home/productService/addScience'], resolve)
            },
            {
              path: '/servicemarket/product/productService/myApply',
              name: 'myApply',
              meta: {
                title: '我的申请'
              },
              component: resolve => require(['@/views/home/productService/myApply'], resolve)
            },
            {
              path: '/myBusiness/index',
              name: 'business',
              meta: {
                title: '我的企业'
              },
              component: resolve => require(['@/views/home/myBusiness/index'], resolve)
            },
            {
              path: '/myBusiness/editBusiness',
              name: 'editBusiness',
              meta: {
                title: '编辑企业'
              },
              component: resolve => require(['@/views/home/myBusiness/editBusiness'], resolve)
            },
            {
              path: '/myBusiness/businesInvitation',
              name: 'businesInvitation',
              meta: {
                title: '企业邀请'
              },
              component: resolve => require(['@/views/home/myBusiness/businesInvitation'], resolve)
            },
            {
              path: '/myBusiness/recruitmentManagement',
              name: 'recruitmentManagement',
              meta: {
                title: '招聘管理'
              },
              component: resolve => require(['@/views/home/myBusiness/recruitmentManagement'], resolve)
            },
            {
              path: '/myBusiness/postJob',
              name: 'postJob',
              meta: {
                title: '发布招聘'
              },
              component: resolve => require(['@/views/home/myBusiness/postJob'], resolve)
            },
            {
              path: '/myBusiness/editRecruit',
              name: 'editRecruit',
              meta: {
                title: '编辑招聘'
              },
              component: resolve => require(['@/views/home/myBusiness/editRecruit'], resolve)
            },
            {
              path: '/myBusiness/staffManagement',
              name: 'staffManagement',
              meta: {
                title: '员工管理'
              },
              component: resolve => require(['@/views/home/myBusiness/staffManagement'], resolve)
            },
            {
              path: '/myBusiness/InviteEmployees',
              name: 'InviteEmployees',
              meta: {
                title: '邀请员工'
              },
              component: resolve => require(['@/views/home/myBusiness/InviteEmployees'], resolve)
            },
            {
              path: '/roleCertifications/advisoryInformation',
              name: 'advisoryInformation',
              meta: {
                title: '服务专员认证'
              },
              component: resolve => require(['@/views/home/roleCertifications/advisoryInformation'], resolve)
            },
            {
              path: '/roleCertifications/basicInformation',
              name: 'basicInformation',
              meta: {
                title: '服务机构认证'
              },
              component: resolve => require(['@/views/home/roleCertifications/basicInformation'], resolve)
            },
            {
              path: '/myBusiness/enterprisePropaganda',
              name: 'enterprisePropaganda',
              meta: {
                title: '企业宣传'
              },
              component: resolve => require(['@/views/home/myBusiness/enterprisePropaganda'], resolve)
            },
            {
              path: '/myBusiness/organizationPropaganda',
              name: 'organizationPropaganda',
              meta: {
                title: '机构宣传'
              },
              component: resolve => require(['@/views/home/myBusiness/enterprisePropaganda'], resolve)
            },
            {
              path: '/myBusiness/publishingPropaganda',
              name: 'publishingPropaganda',
              meta: {
                title: '发布宣传',
                keepAlive: true
              },
              component: resolve => require(['@/views/home/myBusiness/publishingPropaganda'], resolve)
            },
            {
              path: '/myBusiness/propagandaDetails',
              name: 'propagandaDetails',
              meta: {
                title: '宣传详情'


              },
              component: resolve => require(['@/views/home/myBusiness/propagandaDetails'], resolve)
            },
            {
              path: '/myBusiness/publicityExpense',
              name: 'publicityExpense',
              meta: {
                title: '宣传费用规则'
              },
              component: resolve => require(['@/views/home/myBusiness/publicityExpense'], resolve)
            },
            {
              path: '/myBusiness/colleagueList',
              name: 'colleagueList',
              meta: {
                title: '企业同事'
              },
              component: resolve => require(['@/views/home/myBusiness/colleagueList'], resolve)
            },
            {
              path: '/myBody/index',
              name: 'myBody',
              meta: {
                title: '我的机构'
              },
              component: resolve => require(['@/views/home/myBody/index'], resolve)
            },
            {
              path: '/myBody/counselorManagement',
              name: 'counselorManagement',
              meta: {
                title: '专员管理'
              },
              component: resolve => require(['@/views/home/myBody/counselorManagement'], resolve)
            },
            {
              path: '/myBody/inviteAdviser',
              name: 'inviteAdviser',
              meta: {
                title: '邀请专员'
              },
              component: resolve => require(['@/views/home/myBody/inviteAdviser'], resolve)
            },
            {
              path: '/myBody/advisoryDetails',
              name: 'advisoryDetails',
              meta: {
                title: '专员详情'
              },
              component: resolve => require(['@/views/home/myBody/advisoryDetails'], resolve)
            },
            // {
            //   path: '/myBody/editAdvisers',
            //   name: 'editAdvisers',
            //   meta: {
            //     title: '编辑专员'
            //   },
            //   component: resolve => require(['@/views/home/myBody/editAdvisers'], resolve)
            // },
            {
              path: '/myBody/approveAdvisory',
              name: 'approveAdvisory',
              meta: {
                title: '审批专员'
              },
              component: resolve => require(['@/views/home/myBody/approveAdvisory'], resolve)
            },
            {
              path: '/myBody/acceptInvitation',
              name: 'acceptInvitation ',
              meta: {
                title: '接受机构邀请'
              },
              component: resolve => require(['@/views/home/myBody/acceptInvitation'], resolve)
            },
            {
              path: '/myBody/agencyColleaguesList',
              name: 'agencyColleaguesList',
              meta: {
                title: '机构同事'
              },
              component: resolve => require(['@/views/home/myBody/agencyColleaguesList'], resolve)
            },
            {
              path: '/roleCertifications/investorCertification',
              name: 'investorCertification',
              meta: {
                title: '投资人认证'
              },
              component: resolve => require(['@/views/home/roleCertifications/investorCertification'], resolve)
            },
            {
              path: '/actiManagent',
              component: resolve => require(['@/views/home/actiManagent'], resolve),
              meta: {
                title: '活动管理'
              },
              name: 'actiManagent'
            },
            {
              path: '/iframe',
              name: 'iframe',
              meta: {
                title: '人才申报'
              },
              component: resolve => require(['@/views/home/iframe'], resolve)
            },

            {
              path: '/upgradeStaff',
              name: 'upgradeStaff',
              meta: {
                title: '升级员工'
              },
              component: resolve => require(['@/views/home/upgradeStaff'], resolve)
            },
            {
              path: '/upgradeEnterprise',
              name: 'upgradeEnterprise',
              meta: {
                title: '升级企业'
              },
              component: resolve => require(['@/views/home/upgradeEnterprise'], resolve)
            },
            {
              path: '/servicemarket/product/productService/specialEdit',
              name: 'specialEdit',
              meta: {
                title: '编辑特色产品'
              },
              component: resolve => require(['@/views/home/productService/specialEdit'], resolve)
            },
            {
              path: '/servicemarket/product/productService/myApply',
              name: 'myApply',
              meta: {
                title: '我的申请'
              },
              component: resolve => require(['@/views/home/productService/myApply'], resolve)
            },
            {
              path: '/serviceMarket/requireManagementController/forothersneed',
              name: 'forothersneed',
              meta: {
                title: '对他人的需求'
              },
              component: resolve => require(['@/views/home/needManage/forOthersNeed'], resolve)
            },
            {
              path: '/serviceMarket/requireManagementController/forothersneedDetail',
              name: 'forothersneedDetail',
              meta: {
                title: '需求详情'
              },
              component: resolve => require(['@/views/home/needManage/forothersneedDetail'], resolve)
            },
            {
              path: '/serviceMarket/requireManagementController/receivedNeed',
              name: 'receivedNeed',
              meta: {
                title: '我收到的需求'
              },
              component: resolve => require(['@/views/home/needManage/receivedNeed'], resolve)
            },
            {
              path: '/serviceMarket/requireManagementController/buttNeed',
              name: 'buttNeed',
              meta: {
                title: '对接需求'
              },
              component: resolve => require(['@/views/home/needManage/buttNeed'], resolve)
            },
            {
              path: '/serviceMarket/requireManagementController/buttNeedFinancial',
              name: 'buttNeedFinancial',
              meta: {
                title: '对接需求'
              },
              component: resolve => require(['@/views/home/needManage/buttNeedFinancial'], resolve)
            },
            {
              path: '/serviceMarket/requireManagementController/receivedNeedDetail',
              name: 'receivedNeedDetail',
              meta: {
                title: '需求详情'
              },
              component: resolve => require(['@/views/home/needManage/receivedNeedDetail'], resolve)
            },
            {
              path: '/serviceMarket/comment/forOthersevaluate',
              name: 'forOthersevaluate',
              meta: {
                title: '对他人的评价'
              },
              component: resolve => require(['@/views/home/evaluateManage/forOthersevaluate'], resolve)
            },
            {
              path: '/serviceMarket/comment/evaluateDetail',
              name: 'evaluateDetail',
              meta: {
                title: '评价详情'
              },
              component: resolve => require(['@/views/home/evaluateManage/evaluateDetail'], resolve)
            },
            {
              path: '/serviceMarket/comment/toEvaluate',
              name: 'toEvaluate',
              meta: {
                title: '评价'
              },
              component: resolve => require(['@/views/home/evaluateManage/toEvaluate'], resolve)
            },
            {
              path: '/serviceMarket/comment/receivedEvaluate',
              name: 'receivedEvaluate',
              meta: {
                title: '我收到的评价'
              },
              component: resolve => require(['@/views/home/evaluateManage/receivedEvaluate'], resolve)
            }

          ]
        },
        {
          path: '/dataReportCheck',
          component: resolve => require(['@/views/dataReport/dataReportCheck'], resolve),
          meta: {
            title: '数据上报审核'
          },
          name: 'dataReportCheck'
        },
        {
          path: '/actiCenter',
          component: resolve => require(['@/views/activityCenter/actiCenter'], resolve),
          meta: {
            title: '活动中心首页'
          },
          name: 'actiCenter'
        },
        {
          path: '/actiDetail',
          component: resolve => require(['@/views/activityCenter/actiDetail'], resolve),
          meta: {
            title: '活动详情'
          },
          name: 'actiDetail'
        },
        {
          path: '/regStatus',
          component: resolve => require(['@/views/activityCenter/regStatus'], resolve),
          meta: {
            title: '报名情况列表'
          },
          name: 'regStatus'
        },
        {
          path: '/regData',
          component: resolve => require(['@/views/activityCenter/regData'], resolve),
          meta: {
            title: '报名人资料'
          },
          name: 'regData'
        },
        {
          path: '/policyCenter',
          component: resolve => require(['@/views/policyCenter/policyCenter'], resolve),
          meta: {
            title: '政策中心首页'
          },
          name: 'policyCenter'
        },
        {
          path: '/parkProfile',
          component: resolve => require(['@/views/parkProfile/index'], resolve),
          meta: {
            title: '园区概况'
          },
          name: 'parkProfile'
        },
        {
          path: '/investmentPolicy',
          component: resolve => require(['@/views/investmentPolicy/index'], resolve),
          meta: {
            title: '招商政策'
          },
          name: 'investmentPolicy'
        },
        {
          path: '/investmentPolicyDetail',
          component: resolve => require(['@/views/investmentPolicy/investmentPolicyDetail'], resolve),
          meta: {
            title: '招商政策详情'
          },
          name: 'investmentPolicyDetail'
        },
        {
          path: '/investmentDynamic',
          component: resolve => require(['@/views/investmentDynamic/index'], resolve),
          meta: {
            title: '招商动态'
          },
          name: 'investmentDynamic'
        },
        {
          path: '/investmentDynamicDetail',
          component: resolve => require(['@/views/investmentDynamic/investmentDynamicDetail'], resolve),
          meta: {
            title: '招商动态详情'
          },
          name: 'investmentDynamicDetail'
        },
        {
          path: '/investmentInfo',
          component: resolve => require(['@/views/investmentInfo/index'], resolve),
          meta: {
            title: '招商信息'
          },
          name: 'investmentInfo'
        },
        {
          path: '/investmentInfoDetail',
          component: resolve => require(['@/views/investmentInfo/investmentInfoDetail'], resolve),
          meta: {
            title: '招商信息详情'
          },
          name: 'investmentInfoDetail'
        },
        {
          path: '/graphicPolicy',
          component: resolve => require(['@/views/policyCenter/graphicPolicy'], resolve),
          meta: {
            title: '图解政策详情'
          },
          name: 'graphicPolicy'
        },
        {
          path: '/policyGuide',
          component: resolve => require(['@/views/policyCenter/policyGuide'], resolve),
          meta: {
            title: '政策指南详情'
          },
          name: 'policyGuide'
        },
        {
          path: '/recruitmentList',
          component: resolve => require(['@/views/humanResource'], resolve),
          meta: {
            title: '企业招聘列表'
          },
          name: 'recruitmentList'
        },
        {
          path: '/incubatorEnterprises',
          component: resolve => require(['@/views/incubatorEnterprises'], resolve),
          meta: {
            title: '孵化企业'
          },
          name: 'incubatorEnterprises'
        },
        {
          path: '/noticeList',
          component: resolve => require(['@/views/noticeList'], resolve),
          meta: {
            title: '公告列表'
          },
          name: 'noticeList'
        },
        {
          path: '/announcementDetails',
          component: resolve => require(['@/views/noticeList/announcementDetails'], resolve),
          meta: {
            title: '公告详情'
          },
          name: 'announcementDetails'
        },
        {
          path: '/academicExchange',
          component: resolve => require(['@/views/academicExchange'], resolve),
          meta: {
            title: '学术科技'
          },
          name: 'academicExchange'
        },
        {
          path: '/technologyDetails',
          component: resolve => require(['@/views/academicExchange/technologyDetails'], resolve),
          meta: {
            title: '学术科技详情'
          },
          name: 'technologyDetails'
        },
        {
          path: '/parkDetails',
          component: resolve => require(['@/views/parkDetails'], resolve),
          meta: {
            title: '园区详情'
          },
          name: 'parkDetails'
        },
        {
          path: '/enterpriseInformation',
          component: resolve => require(['@/views/enterpriseInformation'], resolve),
          meta: {
            title: '企业资讯'
          },
          name: 'enterpriseInformation'
        },
        {
          path: '/enterpriseInfoDetails',
          component: resolve => require(['@/views/enterpriseInformation/enterpriseInfoDetails'], resolve),
          meta: {
            title: '企业资讯详情'
          },
          name: 'enterpriseInfoDetails'
        },
        {
          path: '/companyProfile',
          component: resolve => require(['@/views/companyProfile'], resolve),
          meta: {
            title: '企业简介'
          },
          name: 'companyProfile'
        },
        {
          path: '/profileDetails',
          component: resolve => require(['@/views/companyProfile/profileDetails'], resolve),
          meta: {
            title: '企业简介详情'
          },
          name: 'profileDetails'
        },
      ]
    },
    {
      path: '/actiTrain',
      component: resolve => require(['@/views/serviceMarket/actiTrain'], resolve),
      meta: {
        title: '活动培训'
      },
      name: 'actiTrain'
    },
    {
      path: '/actiTrainDetail',
      component: resolve => require(['@/views/serviceMarket/actiTrainDetail'], resolve),
      meta: {
        title: '活动培训详情'
      },
      name: 'actiTrain'
    },
    {
      path: '/actiTrainStatus',
      component: resolve => require(['@/views/serviceMarket/actiTrainStatus'], resolve),
      meta: {
        title: '活动详情报名情况'
      },
      name: 'actiTrainStatus'
    },
    {
      path: '/actiTrainData',
      component: resolve => require(['@/views/serviceMarket/actiTrainData'], resolve),
      meta: {
        title: '活动详情报名人资料'
      },
      name: 'actiTrainData'
    },
    {
      path: '/serMatHp',
      component: resolve => require(['@/views/serviceMarket/'], resolve),
      meta: {
        title: '服务超市首页'
      },
      name: 'serMatHp'
    },
    {
      path: '/serverOrg',
      component: resolve => require(['@/views/serviceMarket/serverOrg'], resolve),
      meta: {
        title: '服务超市-服务机构'
      },
      name: 'serverOrg'
    },
    {
      path: '/serverOrgDetail',
      component: resolve => require(['@/views/serviceMarket/serverOrgDetail'], resolve),
      meta: {
        title: '服务超市-服务机构详情'
      },
      name: 'serverOrgDetail'
    },
    {
      path: '/serverPro',
      component: resolve => require(['@/views/serviceMarket/serverPro'], resolve),
      meta: {
        title: '服务产品'
      },
      name: 'serverPro'
    },
    {
      path: '/serverProDetail',
      component: resolve => require(['@/views/serviceMarket/serverProDetail'], resolve),
      meta: {
        title: '服务产品详情'
      },
      name: 'serverProDetail'
    },
    {
      path: '/serverCon',
      component: resolve => require(['@/views/serviceMarket/serverCon'], resolve),
      meta: {
        title: '服务专员'
      },
      name: 'serverCon'
    },
    {
      path: '/serverConDetail',
      component: resolve => require(['@/views/serviceMarket/serverConDetail'], resolve),
      meta: {
        title: '服务专员详情'
      },
      name: 'serverConDetail'
    },
    {
      path: '/quickSearch',
      component: resolve => require(['@/views/serviceMarket/quickSearch'], resolve),
      meta: {
        title: '服务产品快速查询'
      },
      name: 'quickSearch'
    },
    {
      path: '/aboutUs',
      component: resolve => require(['@/views/serviceMarket/aboutUs'], resolve),
      meta: {
        title: '关于我们'
      },
      name: 'aboutUs'
    },
    // {
    //   path: '/serviceMarketPage',
    //   component: resolve => require(['@/views/serviceMarket/'],resolve),
    //   meta: {title: '服务超市首页'},
    //   name:'serviceMarketPage'
    // },
    /* {
      path: '/compassView',
      component: resolve => require(['@/views/adminApprove/compassView/compassView'], resolve),
      meta: {
        title: '政策指引'
      },
      name: 'compassView'
    },
    {
      path: '/rightDetail',
      component: resolve => require(['@/views/adminApprove/compassView/rightDetail'], resolve),
      meta: {
        title: '权利详情'
      },
      name: 'rightDetail'
    },
    {
      path: '/serviceDetail',
      component: resolve => require(['@/views/adminApprove/compassView/serviceDetail'], resolve),
      meta: {
        title: '服务详情'
      },
      name: 'serviceDetail'
    },
    {
      path: '/declarationCenter',
      component: resolve => require(['@/views/declarationCenter/declarationCenter'], resolve),
      meta: {
        title: '申报中心'
      },
      name: 'declarationCenter'
    },
    {
      path: '/declarationNoticeDetail',
      component: resolve => require(['@/views/declarationCenter/declarationNoticeDetail'], resolve),
      meta: {
        title: '申报公告详情'
      },
      name: 'declarationNoticeDetail'
    },
    {
      path: '/declarationPlatform',
      component: resolve => require(['@/views/declarationCenter/declarationPlatform'], resolve),
      meta: {
        title: '申报平台'
      },
      name: 'declarationPlatform'
    }, */
    {

      path: '/tfindex',
      component: resolve => require(['@/views/technologyFinance'], resolve),
      meta: {
        title: '科技金融首页'
      },
      name: 'tfindex'
    },
    {
      path: '/investor',
      component: resolve => require(['@/views/technologyFinance/investor'], resolve),
      meta: {
        title: '投资人'
      },
      name: 'investor'
    },
    {
      path: '/investorDetail',
      component: resolve => require(['@/views/technologyFinance/investorDetail'], resolve),
      meta: {
        title: '投资人详情'
      },
      name: 'investorDetail'
    },
    {
      path: '/finaInstitution',
      component: resolve => require(['@/views/technologyFinance/finaInstitution'], resolve),
      meta: {
        title: '金融机构'
      },
      name: 'finaInstitution'
    },
    {
      path: '/finaInsDetail',
      component: resolve => require(['@/views/technologyFinance/finaInsDetail'], resolve),
      meta: {
        title: '金融机构详情'
      },
      name: 'finaInsDetail'
    },
    // {
    //   path: '/talentsService',
    //   component: resolve => require(['@/views/talentsService/talentsService'], resolve),
    //   meta: {
    //     title: '人才服务首页'
    //   },
    //   name: 'talentsService'
    // },
    // {
    //   path: '/talentPlatform',
    //   component: resolve => require(['@/views/talentsService/talentPlatform'], resolve),
    //   meta: {
    //     title: '人才服务申报平台'
    //   },
    //   name: 'talentPlatform'
    // },
    // {
    //   path: '/talentsServiceDetail',
    //   component: resolve => require(['@/views/talentsService/talentsServiceDetail'], resolve),
    //   meta: {
    //     title: '人才服务详情'
    //   },
    //   name: 'talentsServiceDetail'
    // },
    {
      path: '/finaPro',
      component: resolve => require(['@/views/technologyFinance/finaPro'], resolve),
      meta: {
        title: '金融产品'
      },
      name: 'finaPro'

    },
    {
      path: '/finaProDetail',
      component: resolve => require(['@/views/technologyFinance/finaProDetail'], resolve),
      meta: {
        title: '金融产品详情'
      },
      name: 'finaProDetail'
    },
    {
      path: '/userinfo',
      component: resolve => require(['@/views/home/userinfo'], resolve),
      meta: {
        title: '用户信息'
      },
      name: 'userinfo'
    },
  ]
})
router.beforeEach((to, from, next) => {
  const token = urlSearch.token
  if (token) {
    setToken(token)
  }
  // 路由iframe字段等于1的时候，去掉导航栏和侧边栏给别的页面嵌入
  const iframe = urlSearch.iframe
  if (Number(iframe) === 1 || isMobile()) {
    store.commit('setHiddenNav', false)
  } else {
    store.commit('setHiddenNav', true)
  }
  next()
})

export default router

import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
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
      children: [
        {
          path: '/',
          component: resolve => require(['@/views/portalIndex'], resolve),
          meta: {
            title: '门户首页'
          },
          name: 'portalIndex',
        },
        {
          path: '/investment',
          component: resolve => require(['@/views/investment'], resolve),
          meta: {
            title: '招商引资'
          },
          name: 'enterpriseservice'
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
          path: '/home',
          component: resolve => require(['@/views/home'], resolve),
          meta: {
            title: '用户中心'
          },
          name: 'home',
          redirect: {
            name: 'userCenter'
          },
          children: [{
            path: '/userHome',
            name: 'userHome',
            meta: {
              title: '用户资料'
            },
            component: resolve => require(['@/views/home/userHome'], resolve)
          },
            {
              path: '/servicemarket/product/userCenter',
              name: 'userCenter',
              meta: {
                title: '首页'
              },
              component: resolve => require(['@/views/home/userCenter'], resolve)
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
              path:'/servicemarket/product/productService/report',
              name:'dataReportCommonEntrance',
              meta: {title: '数据上报'},
              component:resolve => require(['@/views/dataReport/report'],resolve)
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
                title: '常规产品详情'
              },
              component: resolve => require(['@/views/home/productService/ordinaryproductDetail'], resolve)
            },
            {
              path:'/servicemarket/product/productService/ordinaryproductDetail',
              name:'ordinaryproductDetail',
              meta: {title: '产品详情'},
              component:resolve => require(['@/views/home/productService/ordinaryproductDetail'],resolve)
            },
            {
              path:'/servicemarket/product/productService/ordinaryproductEdit',
              name:'ordinaryproductEdit',
              meta: {title: '常规产品编辑'},
              component:resolve => require(['@/views/home/productService/ordinaryproductEdit'],resolve)
            },
            {
              path:'/servicemarket/product/productService/specialproduct',
              name:'specialproduct',
              meta: {title: '特色服务产品管理'},
              component:resolve => require(['@/views/home/productService/specialproduct'],resolve)

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
              path: '/myBusiness/enterprisePropaganda',
              name: 'enterprisePropaganda',
              meta: {
                title: '企业宣传'
              },
              component: resolve => require(['@/views/home/myBusiness/enterprisePropaganda'], resolve)
            },
            {
              path: '/myBusiness/publishingPropaganda',
              name: 'publishingPropaganda',
              meta: {
                title: '发布宣传'
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
                title: '顾问管理'
              },
              component: resolve => require(['@/views/home/myBody/counselorManagement'], resolve)
            },
            {
              path: '/myBody/inviteAdviser',
              name: 'inviteAdviser',
              meta: {
                title: '邀请顾问'
              },
              component: resolve => require(['@/views/home/myBody/inviteAdviser'], resolve)
            },
            {
              path: '/myBody/advisoryDetails',
              name: 'advisoryDetails',
              meta: {
                title: '顾问详情'
              },
              component: resolve => require(['@/views/home/myBody/advisoryDetails'], resolve)
            },
            {
              path: '/myBody/approveAdvisory',
              name: 'approveAdvisory',
              meta: {
                title: '审批顾问'
              },
              component: resolve => require(['@/views/home/myBody/approveAdvisory'], resolve)
            },
            {
              path: '/myBody/acceptInvitation',
              name: 'acceptInvitation ',
              meta: {
                title: '接受结构邀请'
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
              path:'/servicemarket/product/productService/specialEdit',
              name:'specialEdit',
              meta: {title: '编辑特色产品'},
              component:resolve => require(['@/views/home/productService/specialEdit'],resolve)
            },
            {
              path:'/servicemarket/product/productService/myApply',
              name:'myApply',
              meta: {title: '我的申请'},
              component:resolve => require(['@/views/home/productService/myApply'],resolve)
            },
            {
              path:'/serviceMarket/requireManagementController/forothersneed',
              name:'forothersneed',
              meta: {title: '对他人的需求'},
              component:resolve => require(['@/views/home/needManage/forOthersNeed'],resolve)
            },
            {
              path:'/serviceMarket/requireManagementController/forothersneedDetail',
              name:'forothersneedDetail',
              meta: {title: '需求详情'},
              component:resolve => require(['@/views/home/needManage/forothersneedDetail'],resolve)
            },
            {
              path:'/serviceMarket/requireManagementController/receivedNeed',
              name:'receivedNeed',
              meta: {title: '我收到的需求'},
              component:resolve => require(['@/views/home/needManage/receivedNeed'],resolve)
            },
            {
              path:'/serviceMarket/requireManagementController/buttNeed',
              name:'buttNeed',
              meta: {title: '对接需求'},
              component:resolve => require(['@/views/home/needManage/buttNeed'],resolve)
            },
            {
              path:'/serviceMarket/requireManagementController/buttNeedFinancial',
              name:'buttNeedFinancial',
              meta: {title: '对接需求'},
              component:resolve => require(['@/views/home/needManage/buttNeedFinancial'],resolve)
            },
            {
              path:'/serviceMarket/requireManagementController/receivedNeedDetail',
              name:'receivedNeedDetail',
              meta: {title: '需求详情'},
              component:resolve => require(['@/views/home/needManage/receivedNeedDetail'],resolve)
            },
            {
              path:'/serviceMarket/comment/forOthersevaluate',
              name:'forOthersevaluate',
              meta: {title: '对他人的评价'},
              component:resolve => require(['@/views/home/evaluateManage/forOthersevaluate'],resolve)
            },
            {
              path:'/serviceMarket/comment/evaluateDetail',
              name:'evaluateDetail',
              meta: {title: '评价详情'},
              component:resolve => require(['@/views/home/evaluateManage/evaluateDetail'],resolve)
            },
            {
              path:'/serviceMarket/comment/toEvaluate',
              name:'toEvaluate',
              meta: {title: '评价'},
              component:resolve => require(['@/views/home/evaluateManage/toEvaluate'],resolve)
            },
            {
              path:'/serviceMarket/comment/receivedEvaluate',
              name:'receivedEvaluate',
              meta: {title: '我收到的评价'},
              component:resolve => require(['@/views/home/evaluateManage/receivedEvaluate'],resolve)
            }

          ]
        },
        {
          path: '/dataReportCheck',
          component: resolve => require(['@/views/dataReport/dataReportCheck'], resolve),
          meta: {title: '数据上报审核'},
          name: 'dataReportCheck'
        }
      ]
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
      path: '/actiTrain',
      component: resolve => require(['@/views/activityCenter/actiTrain'], resolve),
      meta: {
        title: '活动培训'
      },
      name: 'actiTrain'
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
        title: '服务顾问'
      },
      name: 'serverCon'
    },
    {
      path: '/serverConDetail',
      component: resolve => require(['@/views/serviceMarket/serverConDetail'], resolve),
      meta: {
        title: '服务顾问详情'
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
    /*  {
/*     {
      path: '/familiarProblem',
      component: resolve => require(['@/views/talentsService/familiarProblem'],resolve),
      meta: {title: '常见问题列表'},
      name:'familiarProblem'
    }, */
    /*   {
        path: '/familiarProblemDetail',
        component: resolve => require(['@/views/talentsService/familiarProblemDetail'],resolve),
        meta: {title: '常见问题详情'},
        name:'familiarProblemDetail'
      }, */
    {
      path: '/talentsServiceDetail',
      component: resolve => require(['@/views/talentsService/talentsServiceDetail'], resolve),
      meta: {
        title: '人才服务详情'
      },
      name: 'talentsServiceDetail'
    },
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
  ]
})

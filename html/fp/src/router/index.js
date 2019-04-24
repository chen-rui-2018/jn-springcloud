import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  // mode: 'history', // require service support 去掉url中的#
  routes: [
    {
      path: '/login',
      component: resolve => require(['@/views/login'],resolve),
      meta: {title: '登录'},
      name:'login'
    },
    {
      path: '/register',
      component: resolve => require(['@/views/login/register'],resolve),
      meta: {title: '注册'},
      name:'register'
    },
    // {
    //   path: '/register-email',
    //   component: resolve => require(['@/views/login/register-email'],resolve),
    //   meta: {title: '邮箱注册'},
    //   name:'register2'
    // },
    {
      path: '/forgetPsw',
      component: resolve => require(['@/views/login/forgetPsw'],resolve),
      meta: {title: '忘记密码'},
      name:'forgetPsw'
    },
    {
      path: '/home',
      component: resolve => require(['@/views/home'],resolve),
      meta: {title: '用户中心'},  
      name:'home',
      redirect:{name:'userCenter'},
      children:[
        {
          path:'/servicemarket/product/userCenter',
          name:'userCenter',
          meta: {title: '首页'},  
          component:resolve => require(['@/views/home/userCenter'],resolve)
        },
        {
        path:'/servicemarket/product/productService/ordinaryProduct',
        name:'ordinaryProduct',
        meta: {title: '常规服务产品'},  
        component:resolve => require(['@/views/home/productService/ordinaryProduct'],resolve)
        },
        {
        path:'/servicemarket/product/productService/productPutaway',
        name:'productPutaway',
        meta: {title: '常规产品上架'},
        component:resolve => require(['@/views/home/productService/productPutaway'],resolve)
        },
        {
        path:'/servicemarket/product/productService/ordinaryproductDetail',
        name:'ordinaryproductDetail',
        meta: {title: '常规产品详情'},
        component:resolve => require(['@/views/home/productService/ordinaryproductDetail'],resolve)
        },
        {
        path:'/userHome',
        name:'userHome',
        meta: {title: '用户资料'},
        component:resolve => require(['@/views/home/userHome'],resolve)
        }
      ]
    },
    {
      path: '/userinfo',
      component: resolve => require(['@/views/home/userinfo'],resolve),
      name:'user',
      meta: {title: '用户中心1'},
      
    //   children:[
    //     {
    //     path:'/user/userHome',
    //     name:'userHome',
    //     component:resolve => require(['@/views/home/userHome'],resolve)
    //   },
    //     {
    //     path:'/user/userData',
    //     name:'userData',
    //     component:resolve => require(['@/views/home/userData'],resolve),
    //   },
    // ]
    },
    {
      path: '/',
      component: resolve => require(['@/views/portalIndex'],resolve),
      meta: {title: '门户首页'},
      name:'portalIndex'
    },
    {
      path: '/enterpriseservice',
      component: resolve => require(['@/views/enterpriseservice'],resolve),
      meta: {title: '企业服务首页'},
      name:'enterpriseservice'
    },
    {
      path: '/actiCenter',
      component: resolve => require(['@/views/activityCenter/actiCenter'],resolve),
      meta: {title: '活动中心首页'},
      name:'actiCenter'
    },
    {
      path: '/actiDetail',
      component: resolve => require(['@/views/activityCenter/actiDetail'],resolve),
      meta: {title: '活动详情'},
      name:'actiDetail'
    },
    {
      path: '/regStatus',
      component: resolve => require(['@/views/activityCenter/regStatus'],resolve),
      meta: {title: '报名情况列表'},
      name:'regStatus'
    },
    {
      path: '/regData',
      component: resolve => require(['@/views/activityCenter/regData'],resolve),
      meta: {title: '报名人资料'},
      name:'regData'
    },
    {
      path: '/actiManagent',
      component: resolve => require(['@/views/activityCenter/actiManagent'],resolve),
      meta: {title: '活动管理'},
      name:'actiManagent'
    },
    {
      path: '/actiTrain',
      component: resolve => require(['@/views/activityCenter/actiTrain'],resolve),
      meta: {title: '活动培训'},
      name:'actiTrain'
    },
    {
      path: '/serMatHp',
      component: resolve => require(['@/views/serviceMarket/'],resolve),
      meta: {title: '服务超市首页'},
      name:'serMatHp'
    },
    {
      path: '/serverOrg',
      component: resolve => require(['@/views/serviceMarket/serverOrg'],resolve),
      meta: {title: '服务超市-服务机构'},
      name:'serverOrg'
    },
    {
      path: '/serverOrgDetail',
      component: resolve => require(['@/views/serviceMarket/serverOrgDetail'],resolve),
      meta: {title: '服务超市-服务机构详情'},
      name:'serverOrgDetail'
    },
    {
      path: '/serverPro',
      component: resolve => require(['@/views/serviceMarket/serverPro'],resolve),
      meta: {title: '服务产品'},
      name:'serverPro'
    },
    {
      path: '/serverProDetail',
      component: resolve => require(['@/views/serviceMarket/serverProDetail'],resolve),
      meta: {title: '服务产品详情'},
      name:'serverProDetail'
    },
    {
      path: '/serverCon',
      component: resolve => require(['@/views/serviceMarket/serverCon'],resolve),
      meta: {title: '服务顾问'},
      name:'serverCon'
    },
    {
      path: '/serverConDetail',
      component: resolve => require(['@/views/serviceMarket/serverConDetail'],resolve),
      meta: {title: '服务顾问详情'},
      name:'serverConDetail'
    },
    {
      path: '/quickSearch',
      component: resolve => require(['@/views/serviceMarket/quickSearch'],resolve),
      meta: {title: '服务产品快速查询'},
      name:'quickSearch'
    },
    {
      path: '/aboutUs',
      component: resolve => require(['@/views/serviceMarket/aboutUs'],resolve),
      meta: {title: '关于我们'},
      name:'aboutUs'
    },
    // {
    //   path: '/serviceMarketPage',
    //   component: resolve => require(['@/views/serviceMarket/'],resolve),
    //   meta: {title: '服务超市首页'},
    //   name:'serviceMarketPage'
    // },
    {
      path: '/compassView',
      component: resolve => require(['@/views/adminApprove/compassView/compassView'],resolve),
      meta: {title: '政策指引'},
      name:'compassView'
    },
    {
      path: '/rightDetail',
      component: resolve => require(['@/views/adminApprove/compassView/rightDetail'],resolve),
      meta: {title: '权利详情'},
      name:'rightDetail'
    },
    {
      path: '/serviceDetail',
      component: resolve => require(['@/views/adminApprove/compassView/serviceDetail'],resolve),
      meta: {title: '服务详情'},
      name:'serviceDetail'
    },
    {
      path: '/declarationCenter',
      component: resolve => require(['@/views/declarationCenter/declarationCenter'],resolve),
      meta: {title: '申报中心'},
      name:'declarationCenter'
    },
    {
      path: '/declarationNoticeDetail',
      component: resolve => require(['@/views/declarationCenter/declarationNoticeDetail'],resolve),
      meta: {title: '申报公告详情'},
      name:'declarationNoticeDetail'
    },
    {
      path: '/declarationPlatform',
      component: resolve => require(['@/views/declarationCenter/declarationPlatform'],resolve),
      meta: {title: '申报平台'},
      name:'declarationPlatform'
    },
    {
      path: '/tfindex',
      component: resolve => require(['@/views/technologyFinance'],resolve),
      meta: {title: '科技金融首页'},
      name:'tfindex'
    },
    {
      path: '/investor',
      component: resolve => require(['@/views/technologyFinance/investor'],resolve),
      meta: {title: '投资人'},
      name:'investor'
    },
    {
      path: '/investorDetail',
      component: resolve => require(['@/views/technologyFinance/investorDetail'],resolve),
      meta: {title: '投资人详情'},
      name:'investorDetail'
    },
    {
      path: '/finaInstitution',
      component: resolve => require(['@/views/technologyFinance/finaInstitution'],resolve),
      meta: {title: '金融机构'},
      name:'finaInstitution'
    },
    {
      path: '/finaInsDetail',
      component: resolve => require(['@/views/technologyFinance/finaInsDetail'],resolve),
      meta: {title: '金融机构详情'},
      name:'finaInsDetail'
    },
  ]
})

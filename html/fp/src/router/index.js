import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  // mode: 'history', // require service support 去掉url中的#
  routes: [
    {
      path: '/',
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
      path: '/userinfo',
      component: resolve => require(['@/views/home/userinfo'],resolve),
      name:'user',
      meta: {title: '用户中心'},
      
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
      path: '/index',
      component: resolve => require(['@/views/serviceMarket/index'],resolve),
      meta: {title: '服务超市首页'},
      name:'index'
    },
    {
      path: '/peoDec',
      component: resolve => require(['@/views/peo/peoDec'],resolve),
      meta: {title: '服务超市首页'},
      name:'peoDec'
    },
    {
      path: '/sp/power/list',
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
      path: '/talentsService',
      component: resolve => require(['@/views/talentsService/talentsService'],resolve),
      meta: {title: '人才服务首页'},
      name:'talentsService'
    },
    {
      path: '/talentPlatform',
      component: resolve => require(['@/views/talentsService/talentPlatform'],resolve),
      meta: {title: '人才服务申报平台'},
      name:'talentPlatform'
    },
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
      component: resolve => require(['@/views/talentsService/talentsServiceDetail'],resolve),
      meta: {title: '人才服务详情'},
      name:'talentsServiceDetail'
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
        }
      ]
    }
  ]
})

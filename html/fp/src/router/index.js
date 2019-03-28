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
      path: '/user',
      component: resolve => require(['@/views/home'],resolve),
      meta: {title: '用户中心'},

      children:[
        {
        path:'/user/userHome',
        name:'userHome',
        component:resolve => require(['@/views/home/userHome'],resolve)
      },
        {
        path:'/user/userData',
        name:'userData',
        component:resolve => require(['@/views/home/userData'],resolve)
      },
    ]
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
  ]
})

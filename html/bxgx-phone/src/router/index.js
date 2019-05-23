import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/actiDetail',
      name: 'actiDetail',
      component: () => import('@/views/actiDetail'),
      meta: {title: '活动详情'}
    },
    {
      path: '/guest/portal/sp/power/approvalGuide',
      name: 'approvalGuide',
      meta: {title: '行政审批指南'},
      component: () => import('@/views/administrative/approvalGuide')
    },
    {
      path: '/guest/portal/sp/power/powerDetail',
      name: 'powerDetail',
      meta: {title: '权利详情'},
      component: () => import('@/views/administrative/powerDetail')
    },
    {
      path: '/guest/portal/sp/power/serviceDetail',
      name: 'serviceDetail',
      meta: {title: '服务详情'},
      component: () => import('@/views/administrative/serviceDetail')
    },
    {
      path: '/guest/portal/sp/power/consult',
      name: 'consult',
      meta: {title: '我要留言'},
      component: () => import('@/views/administrative/consult')
    },
    {
      path: '/guest/pd/declarationCenter',
      name: 'declarationCenter',
      meta: {title: '申报中心'},
      component: () => import('@/views/declarationCenter/declarationCenter')
    },
    {
      path: '/guest/pd/declarationPlatform',
      name: 'declarationPlatform',
      meta: {title: '申报平台'},
      component: () => import('@/views/declarationCenter/declarationPlatform')
    },
    {
      path: '/guest/pd/declarationDetail',
      name: 'declarationDetail',
      meta: {title: '申报公告详情'},
      component: () => import('@/views/declarationCenter/declarationDetail')
    },
    {
      path: '/guest/pd/consult',
      name: 'declarationconsult',
      meta: {title: '我要咨询'},
      component: () => import('@/views/declarationCenter/consult')
    },
    {
      path: '/serverProDetail',
      name: 'serverProDetail',
      component: () => import('@/views/serverProDetail'),
      meta: {title: '服务产品详情'}
    },
    {
      path: '/guest/pd/talentNotice/talentsService',
      name: 'talentsService',
      meta: {title: '人才服务'},
      component: () => import('@/views/talentsService/talentsService')
    },
    {
      path: '/guest/pd/talentNotice/talentsServicePlatform',
      name: 'talentsServicePlatform',
      meta: {title: '申报平台'},
      component: () => import('@/views/talentsService/talentsServicePlatform')
    },
    {
      path: '/guest/pd/talentNotice/talentsServiceDetail',
      name: 'talentsServiceDetail',
      meta: {title: '服务详情'},
      component: () => import('@/views/talentsService/talentsServiceDetail')

    }
  ]
})

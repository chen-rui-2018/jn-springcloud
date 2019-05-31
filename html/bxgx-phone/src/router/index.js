import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/investment',
      name: 'investment',
      component: () => import('@/views/investment'),
      meta: {title: '招商引资'}
    },
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
      path: '/guest/portal/sp/power/text',
      name: 'text',
      meta: {title: '实施依据详情'},
      component: () => import('@/views/administrative/text')
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
      component: () => import('@/views/talentsService/talentsServiceDetail')},
    {
      path: '/workPlan/workPlan',
      name: 'workPlan',
      component: () => import('@/views/workPlan/workPlan'),
      meta: {title: '工作计划管理'}
    },
    {
      path: '/workPlan/addWorkPlan',
      name: 'addWorkPlan',
      component: () => import('@/views/workPlan/addWorkPlan'),
      meta: {title: '添加工作计划'}
    },
    {
      path: '/workPlan/editWorkPlan',
      name: 'editWorkPlan',
      component: () => import('@/views/workPlan/editWorkPlan'),
      meta: {title: '编辑工作计划'}
    },
    {
      path: '/workPlan/editWorkStatus',
      name: 'editWorkStatus',
      component: () => import('@/views/workPlan/editWorkStatus'),
      meta: {title: '修改任务状态'}
    },
    {
      path: '/workPlan/workPlanDetails',
      name: 'workPlanDetails',
      component: () => import('@/views/workPlan/workPlanDetails'),
      meta: {title: '工作计划详情'}
    },
    {
      path: '/attendanceManagement/attendanceManagement',
      name: 'attendanceManagement',
      component: () => import('@/views/attendanceManagement/attendanceManagement'),
      meta: {title: '考勤管理'}
    },
    {
      path: '/attendanceManagement/attendanceDetails',
      name: 'attendanceDetails',
      component: () => import('@/views/attendanceManagement/attendanceDetails'),
      meta: {title: '考勤明细'}
    },
    {
      path: '/parkDetais',
      name: 'parkDetais',
      component: () => import('@/views/parkDetais'),
      meta: {title: '公告详情'}
    },
    {
      path: '/moreActi',
      name: 'moreActi',
      component: () => import('@/views/moreActi'),
      meta: {title: '更多活动'}
    },
    {
      path: '/policyGuide',
      name: 'policyGuide',
      component: () => import('@/views/policyGuide'),
      meta: {title: '政策指南'}
    },
    {
      path: '/policyDetails',
      name: 'policyDetails',
      component: () => import('@/views/policyDetails'),
      meta: {title: '政策详情'}
    }
  ]
})

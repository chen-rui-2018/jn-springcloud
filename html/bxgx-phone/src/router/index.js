import Vue from 'vue'
import Router from 'vue-router'
import { urlSearch } from '../utils/index'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/investment',
      name: 'investment',
      component: () => import('@/views/investment'),
      meta: {title: '招商引资'}
    },
    {
      path: '/parkProfile',
      name: 'parkProfile',
      component: () => import('@/views/investment/parkProfile'),
      meta: {title: '园区概况'}
    },
    {
      path: '/investmentPolicy',
      name: 'investmentPolicy',
      component: () => import('@/views/investment/investmentPolicy/index'),
      meta: {title: '招商政策'}
    },
    {
      path: '/investmentPolicyDetail',
      name: 'investmentPolicyDetail',
      component: () => import('@/views/investment/investmentPolicy/detail'),
      meta: {title: '招商政策详情'}
    },
    {
      path: '/investmentDynamic',
      name: 'investmentDynamic',
      component: () => import('@/views/investment/investmentDynamic/index'),
      meta: {title: '招商动态'}
    },
    {
      path: '/investmentDynamicDetail',
      name: 'investmentDynamicDetail',
      component: () => import('@/views/investment/investmentDynamic/detail'),
      meta: {title: '招商动态详情'}
    },
    {
      path: '/investmentInfo',
      name: 'investmentInfo',
      component: () => import('@/views/investment/investmentInfo/index'),
      meta: {title: '招商信息'}
    },
    {
      path: '/investmentInfoDetail',
      name: 'investmentInfoDetail',
      component: () => import('@/views/investment/investmentInfo/detail'),
      meta: {title: '招商信息详情'}
    },
    {
      path: '/parkDetails',
      name: 'parkDetails',
      component: () => import('@/views/investment/parkDetails'),
      meta: {title: '园区信息详情'}
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
      path: '/electricInfo',
      name: 'electricInfo',
      component: () => import('@/views/electricInfo'),
      meta: {title: '我的用电情况'}
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

router.beforeEach((to, from, next) => {
  const token = urlSearch.token
  if (token) {
    sessionStorage.setItem('token', token)
  }
  next()
})

export default router

import Layout from '@/views/layout/Layout'

const portalRouter = {
  path: '/portal',
  component: Layout,
  redirect: 'noredirect',
  name: 'portal',
  meta: {
    title: '门户管理',
    icon: 'chart'
  },
  children: [
    {
      path: 'activityManagement',
      component: () => import('@/views/portal/activityManagement'),
      name: 'activityManagement',
      meta: { title: '活动管理', noCache: true }
    },
    {
      path: 'activityTypeManagement',
      component: () => import('@/views/portal/activityTypeManagement'),
      name: 'activityTypeManagement',
      meta: { title: '活动类型管理', noCache: true }
    },
    {
      path: 'activityAdd',
      component: () => import('@/views/portal/activityAdd'),
      name: 'activityAdd',
      meta: { title: '新增活动', noCache: false },
      hidden: true
    },
    {
      path: 'activityEdit',
      component: () => import('@/views/portal/activityAdd'),
      name: 'activityEdit',
      meta: { title: '编辑活动', noCache: false },
      hidden: true
    },
    {
      path: 'activityCheck',
      component: () => import('@/views/portal/activityAdd'),
      name: 'activityCheck',
      meta: { title: '查看活动', noCache: false },
      hidden: true
    },
    {
      path: 'applyActivityList/:id',
      component: () => import('@/views/portal/applyActivityList'),
      name: 'applyActivityList',
      meta: { title: '活动报名列表', noCache: false },
      hidden: true
    },
    {
      path: 'ServiceManagement',
      component: () => import('@/views/portal/ServiceManagement'),
      name: 'ServiceManagement',
      meta: { title: '服务管理', noCache: true },
      children: [
        {
          path: 'featuredProduct',
          component: () => import('@/views/portal/ServiceManagement/featuredProduct'),
          name: 'featuredProduct',
          meta: { title: '特色服务产品', noCache: true }
        },
        {
          path: 'productApprover/:id',
          component: () => import('@/views/portal/ServiceManagement/productApprover'),
          name: 'productApprover',
          meta: { title: '特色服务产品审批非科技金融', noCache: false },
          hidden: true
        },
        {
          path: 'productApproverFinance/:id',
          component: () => import('@/views/portal/ServiceManagement/productApproverFinance'),
          name: 'productApproverFinance',
          meta: { title: '特色服务产品审批科技金融', noCache: false }

        },
        {
          path: 'findServiceDetail/:id',
          component: () => import('@/views/portal/ServiceManagement/findServiceDetail'),
          name: 'findServiceDetail',
          meta: { title: '特色服务产品查看非科技金融', noCache: false },
          hidden: true
        },
        {
          path: 'findServiceDetailfinance/:id',
          component: () => import('@/views/portal/ServiceManagement/findServiceDetailfinance'),
          name: 'findServiceDetailfinance',
          meta: { title: '特色服务产品查看科技金融', noCache: false },
          hidden: true
        },
        {
          path: 'generalProduct',
          component: () => import('@/views/portal/ServiceManagement/generalProduct'),
          name: 'generalProduct',
          meta: { title: '服务产品管理', noCache: true }
        }
      ]
    },
    {
      path: 'requireManagement',
      component: () => import('@/views/portal/requireManagement'),
      name: 'requireManagement',
      meta: { title: '需求管理', noCache: true }
    },
    {
      path: 'requireDetail',
      component: () => import('@/views/portal/requireDetail'),
      name: 'requireDetail',
      meta: { title: '查看详情', noCache: true }
    }
  ]
}
export default portalRouter

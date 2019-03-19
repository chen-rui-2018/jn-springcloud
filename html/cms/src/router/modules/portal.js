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
    }
  ]
}
export default portalRouter

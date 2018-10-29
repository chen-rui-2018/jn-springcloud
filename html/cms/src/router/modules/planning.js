/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/views/layout/Layout'

const planningRouter = {
  path: '/planning/project',
  component: Layout,
  meta: { title: '规划建设', icon: 'dashboard', noCache: true },
  redirect: 'noredirect',
  name: 'planning',
  children: [{
    path: 'index',
    component: () =>
                import('@/views/planning/project/index'),
    name: 'project',
    meta: { title: '工程项目管理', icon: 'dashboard', noCache: true }
  },
  {
    path: 'detail',
    component: () =>
                import('@/views/planning/project/detail'),
    name: 'ProjectDetail',
    meta: { title: '工程项目管理详情', noCache: true },
    hidden: true
  },
  {
    path: 'test',
    component: () =>
                import('@/views/planning/project/'),
    name: 'project2',
    meta: { title: '招投标管理', icon: 'dashboard', noCache: true }
  }
  ]
}
export default planningRouter

/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/views/layout/Layout'

const operationRouter = {
  path: '/operation',
  component: Layout,
  redirect: 'noredirect',
  name: 'Operation',
  meta: {
    title: '运营分析中心',
    icon: 'chart'
  },
  children: [
    {
      path: 'energy',
      component: () => import('@/views/analysis/energy'),
      name: 'EnergyAnalysis',
      meta: { title: '智慧能源', noCache: true }
    },
    {
      path: 'park',
      component: () => import('@/views/park/development'),
      name: 'parkDevelopment',
      meta: { title: '园区发展', noCache: true }
    },
    {
      path: 'enterprise',
      component: () => import('@/views/enterprise/index'),
      name: 'enterprise',
      meta: { title: '企业信用', noCache: true }
    }
  ]
}
export default operationRouter

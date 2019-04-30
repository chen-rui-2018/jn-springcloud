
import Layout from '@/views/layout/Layout'

const dataReportRouter = {
  path: '/dataReport',
  component: Layout,
  redirect: 'noredirect',
  name: 'dataReport',
  meta: {
    title: '数据上报',
    icon: 'chart'
  },
  children: [
    {
      path: 'targetManagement',
      component: () => import('@/views/dataReport/targetManagement/index'),
      name: 'targetManagement',
      meta: { title: '指标管理', noCache: true }
      // children: [
      //   {
      //     path: 'monitoring',
      //     component: () => import('@/views/financ/finacialMonitoring/monitoring'),
      //     name: 'monitoring',
      //     meta: { title: '监控首页', noCache: true }
      //   }
      // ]
    },
    {
      path: 'template',
      component: () => import('@/views/dataReport/template/index'),
      name: 'template',
      meta: { title: '数据上报模板', noCache: true }
    }
  ]
}
export default dataReportRouter

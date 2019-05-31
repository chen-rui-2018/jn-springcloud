
import Layout from '@/views/layout/Layout'

const financRouter = {
  path: '/financ',
  component: Layout,
  redirect: 'noredirect',
  name: 'financ',
  meta: {
    title: '财务协同',
    icon: 'chart'
  },
  children: [
    {
      path: 'financialMonitoring',
      component: () => import('@/views/financ/finacialMonitoring/index'),
      name: 'financialMonitoring',
      meta: { title: '财务监控', noCache: true },
      children: [
        {
          path: 'monitoring',
          component: () => import('@/views/financ/finacialMonitoring/monitoring'),
          name: 'monitoring',
          meta: { title: '监控首页', noCache: true }
        },
        {
          path: 'budget',
          component: () => import('@/views/financ/finacialMonitoring/budget'),
          name: 'budget',
          meta: { title: '预算录入', noCache: true }
        },
        {
          path: 'expenses',
          component: () => import('@/views/financ/finacialMonitoring/expenses'),
          name: 'expenses',
          meta: { title: '支出录入', noCache: true }
        },
        {
          path: 'income',
          component: () => import('@/views/financ/finacialMonitoring/income'),
          name: 'income',
          meta: { title: '收入情况', noCache: true }
        },
        {
          path: 'financeDetails',
          component: () => import('@/views/financ/finacialMonitoring/financeDetails'),
          name: 'financeDetails',
          meta: { title: '财务明细', noCache: false }
        }
      ]
    }
  ]
}
export default financRouter

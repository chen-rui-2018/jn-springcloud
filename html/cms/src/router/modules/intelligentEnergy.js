
import Layout from '@/views/layout/Layout'

const energyRouter = {
  path: '/intelligentEnergy',
  component: Layout,
  redirect: 'noredirect',
  name: 'intelligentEnergy',
  meta: {
    title: '智慧能源',
    icon: 'chart'
  },
  children: [
    {
      path: 'energyStatistics',
      component: () => import('@/views/intelligentEnergy/energyStatistics'),
      name: 'energyStatistics',
      meta: { title: '能耗统计', noCache: true }
    },
    {
      path: 'groupingEnergyStatistics',
      component: () => import('@/views/intelligentEnergy/groupingEnergyStatistics'),
      name: 'groupingEnergyStatistics',
      meta: { title: '分组能耗统计', noCache: true }
    }
  ]
}
export default energyRouter

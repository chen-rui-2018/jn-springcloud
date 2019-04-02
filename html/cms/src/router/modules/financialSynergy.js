
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
        }
      ]
    }
    //     {
    //       path: 'departmentManagement',
    //       component: () => import('@/views/menu/financ/financialMonitoring/income'),
    //       name: 'departmentManagement',
    //       meta: { title: '部门管理', noCache: true }
    //     },
    //     {
    //       path: 'fileGroupManagement',
    //       component: () => import('@/views/menu/fileGroupManagement'),
    //       name: 'fileGroupManagement',
    //       meta: { title: '文件组管理', noCache: true }
    //     },
    //     {
    //       path: 'postManagement',
    //       component: () => import('@/views/menu/postManagement'),
    //       name: 'postManagement',
    //       meta: { title: '岗位管理', noCache: true }
    //     },
    //     {
    //       path: 'postTypeManagement',
    //       component: () => import('@/views/menu/postTypeManagement'),
    //       name: 'postTypeManagement',
    //       meta: { title: '岗位类型管理', noCache: true }
    //     },
    //     {
    //       path: 'menuManagement',
    //       component: () => import('@/views/menu/menuManagement'),
    //       name: 'menuManagement',
    //       meta: { title: '菜单管理', noCache: true }
    //     },
    //     {
    //       path: 'fileManagement',
    //       component: () => import('@/views/menu/fileManagement'),
    //       name: 'fileManagement',
    //       meta: { title: '文件管理', noCache: true }
    //     },
    //     {
    //       path: 'dataDictionary',
    //       component: () => import('@/views/menu/dataDictionary'),
    //       name: 'dataDictionary',
    //       meta: { title: '数据字典', noCache: true }
    //     },
    //     {
    //       path: 'moduleManagement',
    //       component: () => import('@/views/menu/moduleManagement'),
    //       name: 'moduleManagement',
    //       meta: { title: '模块管理', noCache: true }
    //     }
  ]
}
export default financRouter

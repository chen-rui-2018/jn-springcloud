/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/views/layout/Layout'

const menuRouter = {
  path: '/menu',
  component: Layout,
  redirect: 'noredirect',
  name: 'menu',
  meta: {
    title: '菜单',
    icon: 'chart'
  },
  children: [
    {
      path: 'user-management',
      component: () => import('@/views/menu/userManagement'),
      name: 'user-management',
      meta: { title: '用户管理', noCache: true }
    },
    {
      path: 'user-group-management',
      component: () => import('@/views/menu/user-group-management'),
      name: 'user-group-management',
      meta: { title: '用户组管理', noCache: true }
    },
    {
      path: 'enterprise',
      component: () => import('@/views/enterprise/index'),
      name: 'enterprise',
      meta: { title: '角色管理', noCache: true }
    },
    {
      path: 'details',
      component: () => import('@/views/enterprise/details'),
      name: 'details',
      meta: { title: '权限管理', noCache: true }
      // hidden: true
    }
  ]
}
export default menuRouter

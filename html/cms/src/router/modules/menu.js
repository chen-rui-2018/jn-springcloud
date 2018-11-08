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
      path: 'rolemanagement',
      component: () => import('@/views/menu/roleManagement'),
      name: 'rolemanagement',
      meta: { title: '角色管理', noCache: true }
    },
    {
      path: 'authoritymanagement',
      component: () => import('@/views/menu/authoritymanagement'),
      name: 'authoritymanagement',
      meta: { title: '权限管理', noCache: true }
      // hidden: true
    },
    {
      path: 'menumanagement',
      component: () => import('@/views/menu/menumanagement'),
      name: 'menumanagement',
      meta: { title: '菜单管理', noCache: true }
    }
  ]
}
export default menuRouter

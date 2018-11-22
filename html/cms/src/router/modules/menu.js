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
      path: 'userManagement',
      component: () => import('@/views/menu/userManagement'),
      name: 'userManagement',
      meta: { title: '用户管理', noCache: true }
    },
    {
      path: 'userGroupManagement',
      component: () => import('@/views/menu/userGroupManagement'),
      name: 'userGroupManagement',
      meta: { title: '用户组管理', noCache: true }
    },
    {
      path: 'roleManagement',
      component: () => import('@/views/menu/roleManagement'),
      name: 'roleManagement',
      meta: { title: '角色管理', noCache: true }
    },
    {
      path: 'permissionManagement',
      component: () => import('@/views/menu/permissionManagement'),
      name: 'permissionManagement',
      meta: { title: '权限管理', noCache: true }
      // hidden: true
    },
    {
      path: 'menuManagement',
      component: () => import('@/views/menu/menuManagement'),
      name: 'menuManagement',
      meta: { title: '菜单管理', noCache: true }
    },
    {
      path: 'fileGroupManagement',
      component: () => import('@/views/menu/fileGroupManagement'),
      name: 'fileGroupManagement',
      meta: { title: '文件组管理', noCache: true }
    },
    {
      path: 'postManagement',
      component: () => import('@/views/menu/postManagement'),
      name: 'postManagement',
      meta: { title: '岗位管理', noCache: true }
    }
  ]
}
export default menuRouter

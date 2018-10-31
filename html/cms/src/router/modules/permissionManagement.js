/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/views/layout/Layout'

const permissionManagementRouter = {
  path: '/permissionManagement',
  component: Layout,
  meta: { title: '权限管理', icon: 'dashboard', noCache: true },
  redirect: 'noredirect',
  name: 'permissionManagement',
  children: [{
    path: 'userManagement',
    component: () =>
            import('@/views/permissionManagement/userManagement'),
    name: 'userManagement',
    meta: { title: '用户管理', icon: 'dashboard', noCache: true }
  }, {
    path: 'userGroupManagement',
    component: () =>
            import('@/views/permissionManagement/userGroupManagement'),
    name: 'userGroupManagement',
    meta: { title: '用户组管理', icon: 'dashboard', noCache: true }
  }]
}
export default permissionManagementRouter

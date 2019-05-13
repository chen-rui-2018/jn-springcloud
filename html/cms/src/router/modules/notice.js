
import Layout from '@/views/layout/Layout'

const noticeRouter = {
  path: '/notice',
  component: Layout,
  redirect: 'noredirect',
  name: 'notice',
  meta: {
    title: '对外公告',
    icon: 'chart'
  },
  children: [
    {
      path: '/',
      component: () => import('@/views/notice/index'),
      name: 'notice',
      meta: { title: '对外公告', noCache: true }
    },
    {
      path: 'noticePublish',
      component: () => import('@/views/notice/noticePublish'),
      name: 'noticePublish',
      meta: { title: '发布/编辑公告', noCache: true }
    }
  ]
}
export default noticeRouter

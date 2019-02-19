/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/views/layout/Layout'

const oaRouter = {
  path: '/oa',
  component: Layout,
  redirect: 'noredirect',
  name: 'oa',
  meta: {
    title: '协同办公OA管理',
    icon: 'svg-icon'
  },
  children: [
    {
      path: 'meetingManagement',
      component: () => import('@/views/oa/meetingManagement/index'),
      name: 'meetingManagement',
      meta: { title: '会议管理', noCache: true },
      children: [
        {
          path: 'meetingroomManagement',
          component: () => import('@/views/oa/meetingManagement/meetingroomManagement'),
          name: 'meetingroomManagement',
          meta: { title: '会议室列表', noCache: true, icon: 'list' }
        },
        {
          path: 'conferenceReservation',
          component: () => import('@/views/oa/meetingManagement/conferenceReservation'),
          name: 'conferenceReservation',
          meta: { title: '会议预约', noCache: false }
        },
        {
          path: 'meetingApplication',
          component: () => import('@/views/oa/meetingManagement/meetingApplication'),
          name: 'meetingApplication',
          meta: { title: '会议申请', noCache: false }
        },
        {
          path: 'meetingManagement',
          component: () => import('@/views/oa/meetingManagement/meetingManagement'),
          name: 'meetingManagement',
          meta: { title: '会议列表', noCache: true, icon: 'list' }
        },
        {
          path: 'addMeetingroom',
          component: () => import('@/views/oa/meetingManagement/addMeetingroom'),
          name: 'addMeetingroom',
          meta: { title: '新增会议室', noCache: false }
        },
        {
          path: 'meetingAttendance',
          component: () => import('@/views/oa/meetingManagement/meetingAttendance'),
          name: 'meetingAttendance',
          meta: { title: '会议考勤列表', noCache: true, icon: 'list' }
        }
      ]
    }

  ]
}
export default oaRouter

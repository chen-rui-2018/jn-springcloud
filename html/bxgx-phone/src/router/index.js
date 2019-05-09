import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/actiDetail',
      name: 'actiDetail',
      component: () => import('@/views/actiDetail')
    },
    {
      path: '/guest/portal/sp/power/approvalGuide',
      name: 'approvalGuide',
      meta: {title: '行政审批指南'},
      component: () => import('@/views/administrative/approvalGuide')

    }
  ]
})

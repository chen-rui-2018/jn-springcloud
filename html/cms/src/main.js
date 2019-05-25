import Vue from 'vue'

import Cookies from 'js-cookie'
import ECharts from 'vue-echarts'
Vue.component('chart', ECharts)

import echarts from 'echarts'
Vue.prototype.$echarts = echarts
import 'normalize.css/normalize.css' // A modern alternative to CSS resets
import 'babel-polyfill'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import '@/styles/index.scss' // global css
// 引入字体图标
import '@/assets/icon/css/font-awesome.min.css'
import '@/assets/iconfont/iconfont.css'
import '@/assets/iconfont/iconfont.js'
import '../static/UE/ueditor.config'
import '../static/UE/ueditor.all'
import '../static/UE/lang/zh-cn/zh-cn'
import '../static/UE/ueditor.parse.min.js'
// 引入全局变量
import global from './api/global'
import App from './App'
import router from './router'
import store from './store'
import 'url-search-params-polyfill'
import i18n from './lang' // Internationalization
import './icons' // icon
import './errorLog' // error log
import './permission' // permission control
import './mock' // simulation data

import * as filters from './filters' // global filters
// 挂载全局变量
Vue.prototype.GLOBAL = global

// 引入http
import { get, post } from '@/api/axios'
Vue.prototype.$_get = get
Vue.prototype.$_post = post
Vue.use(Element, {
  size: Cookies.get('size') || 'medium' // set element-ui default size
  // i18n: (key, value) => i18n.t(key, value)
})

// register global utility filters.
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})

Vue.config.productionTip = false

router.beforeEach((to, from, next) => {
  /* ·�ɷ����仯�޸�ҳ��title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

new Vue({
  el: '#app',
  router,
  store,
  i18n,
  render: h => h(App)
})

// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import "@babel/polyfill";
import Vue from 'vue'
import App from './App'
import router from './router'
import '../static/UE/ueditor.config'
import '../static/UE/ueditor.all'
import '../static/UE/lang/zh-cn/zh-cn'
import '../static/UE/ueditor.parse.min.js'
import './assets/iconfont/iconfont.css'
import 'swiper/dist/css/swiper.css'
// import animate from 'animate.css'
import ElementUI from 'element-ui'
import '@/css/theme.scss'
// import VueAwesomeSwiper from 'vue-awesome-swiper'
import '@/css/theme.css'
import store from './store'
import { getToken, setToken, removeToken,setUserInfo,getUserInfo,removeUserInfo } from '@/util/auth'

Vue.use(ElementUI)
// Vue.use(VueAwesomeSwiper, /* { default global options } */)

import api from '@/util/api'
Vue.prototype.api = api
Vue.prototype.getToken = getToken
Vue.prototype.setToken = setToken
Vue.prototype.removeToken = removeToken
Vue.prototype.setUserInfo = setUserInfo
Vue.prototype.getUserInfo = getUserInfo
Vue.prototype.removeUserInfo = removeUserInfo

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
Vue.directive('focus',{

	inserted(el){
		el.focus()
	}
});

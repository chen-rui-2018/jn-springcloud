// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import "@babel/polyfill";
import Vue from 'vue'
import App from './App'
import router from './router'
import './assets/iconfont/iconfont.css'
import 'swiper/dist/css/swiper.css'
// import animate from 'animate.css'
import ElementUI from 'element-ui'
import '@/css/theme.scss'
// import VueAwesomeSwiper from 'vue-awesome-swiper'
import '@/css/theme.css'
import store from './store'

Vue.use(ElementUI)
// Vue.use(VueAwesomeSwiper, /* { default global options } */)

import api from '@/util/api'
Vue.prototype.api = api

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

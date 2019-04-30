// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import "@babel/polyfill";
import Vue from 'vue'
import App from './App'
import router from './router'
import './assets/iconfont/iconfont.css'
import 'swiper/dist/css/swiper.css'
import animate from 'animate.css'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// import VueAwesomeSwiper from 'vue-awesome-swiper'
// import swiper from 'swiper'
import 'swiper/dist/css/swiper.css'

Vue.use(ElementUI)
// Vue.use(VueAwesomeSwiper, /* { default global options } */)

import api from '@/util/api'
Vue.prototype.api = api


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
Vue.directive('focus',{

	inserted(el){
		el.focus()
	}
});

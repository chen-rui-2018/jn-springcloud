// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import './assets/iconfont/iconfont.css'
import {XHeader} from 'vux'
Vue.component('x-header', XHeader)

// import { get, post} from '@/api/http'
// import MintUI from 'mint-ui'
// import 'mint-ui/lib/style.css'
import './assets/iconfont/iconfont.css'
import './assets/font-awesome/css/font-awesome.min.css'
// Vue.prototype.$get = get
// Vue.prototype.$post = post
import api from '@/api/api'
Vue.prototype.api = api
Vue.config.productionTip = false

// Vue.use(MintUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

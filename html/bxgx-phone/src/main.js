// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import './assets/iconfont/iconfont.css'
import 'swiper/dist/css/swiper.css'
import { XHeader, Selector, Checker, CheckerItem, PopupRadio, Group, Icon, Search, XInput, XTable, Scroller, Popover, Toast, ToastPlugin, LoadMore, PopupPicker, Datetime, XTextarea, Cell, XNumber, XDialog, Tab, TabItem, Swiper, SwiperItem } from 'vux'
// import BaiduMap from 'vue-baidu-map'
// import { get, post} from '@/api/http'
// import MintUI from 'mint-ui'
// import 'mint-ui/lib/style.css'
// import './assets/iconfont/iconfont.css'
import './assets/font-awesome/css/font-awesome.min.css'
// Vue.prototype.$get = get
// Vue.prototype.$post = post
import api from '@/api/api'
// Vue.use(BaiduMap, {
//   ak: 'KVelCif7fs2D19DQVz9W6fYEnNbEWE8k'
// })
Vue.prototype.api = api
Vue.component('x-table', XTable)
Vue.component('popup-radio', PopupRadio)
Vue.component('icon', Icon)
Vue.component('swiper', Swiper)
Vue.component('swiper-item', SwiperItem)
Vue.component('x-dialog', XDialog)
Vue.component('tab', Tab)
Vue.component('tab-item', TabItem)
// Vue.use(ToastPlugin)
Vue.use(ToastPlugin, {position: 'top'})
Vue.component('x-header', XHeader)
Vue.component('x-textarea', XTextarea)
Vue.component('x-number', XNumber)
Vue.component('cell', Cell)
Vue.component('datetime', Datetime)
Vue.component('toast', Toast)
Vue.component('search', Search)
Vue.component('scroller', Scroller)
Vue.component('popover', Popover)
Vue.component('selector', Selector)
Vue.component('x-header', XHeader)
Vue.component('x-input', XInput)
Vue.component('checker', Checker)
Vue.component('checker-item', CheckerItem)
Vue.component('load-more', LoadMore)
Vue.component('popup-picker', PopupPicker)
Vue.component('Group', Group)
Vue.component('scroller', Scroller)
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

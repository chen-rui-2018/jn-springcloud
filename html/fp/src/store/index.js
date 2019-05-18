import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
import { isMobile } from '@/util'
const state = {
  needNav: true, // 是否隐藏导航栏，在app.vue设定
  isMobile: isMobile() // 判断设备型号是否是手机

}

const mutations = {
  setNeedNav(state, val) {
    return state.needNav = val
  },
  setInfo(state, data) {
    return state[data.key] = data.data
  }
}

const actions = {}

export default new Vuex.Store({
  state,
  mutations,
  actions
  // strict: process.env.NODE_ENV !== 'production'
})

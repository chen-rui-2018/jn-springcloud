import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const state = {
  needNav: true // 是否隐藏导航栏，在app.vue设定
}

const mutations = {
  setNeedNav(state, val) {
    return state.needNav = val
  }
}

const actions = {}

export default new Vuex.Store({
  state,
  mutations,
  actions
  // strict: process.env.NODE_ENV !== 'production'
})

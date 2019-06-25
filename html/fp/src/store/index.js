import Vue from 'vue'
import Vuex from 'vuex'
import { isMobile } from '@/util'
import api from '@/util/api'
import { getToken } from '@/util/auth'
Vue.use(Vuex)
const getData = function (url, data = {}) {
  return new Promise((resolve, reject) => {
    const token = getToken()
    api.post({
      url: url,
      headers: { token: token },
      data: data,
      callback: res => {
        if (res.code === "0000") {
          resolve(res)
        } else {
          reject(new Error(`Could not get data at api: ${url}, code:${res.code}, msg:${res.result}`))
        }
      }
    })
  })
}

const state = {
  hiddenNav: false, // 是否隐藏导航栏，在app.vue设定
  isMobile: isMobile(), // 判断设备型号是否是手机
  menuItems: []
}

const mutations = {
  setHiddenNav(state, val) {
    return state.hiddenNav = val
  },
  setInfo(state, data) {
    return state[data.key] = data.data
  }
}

const actions = {
  getMenuItems (state) {
    return new Promise(resolve => {
      return getData('getDynamicMenu').then(res => {
        res.data.forEach(val=>{
          if(val.label==='门户'){
            let menuItems = val.children[0].children
            sessionStorage.removeItem('menuItems')
            sessionStorage.menuItems= JSON.stringify(menuItems)
            state.commit('setInfo', {key: 'menuItems', data: menuItems})
            resolve()
          }
        })
      })
    })
  }
}

export default new Vuex.Store({
  state,
  mutations,
  actions
  // strict: process.env.NODE_ENV !== 'production'
})

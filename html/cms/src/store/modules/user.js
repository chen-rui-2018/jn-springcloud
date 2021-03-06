import {
  loginByUsername,
  logout,
  getUserInfo,
  getUsername
} from '@/api/login'
import {
  getToken,
  setToken,
  removeToken
} from '@/utils/auth'
import {
  Message
} from 'element-ui'

const user = {
  state: {
    user: '',
    status: '',
    code: '',
    token: getToken(),
    name: '',
    avatar: '',
    introduction: '',
    roles: [],
    setting: {
      articlePlatform: []
    }
  },

  mutations: {
    SET_CODE: (state, code) => {
      state.code = code
    },
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_INTRODUCTION: (state, introduction) => {
      state.introduction = introduction
    },
    SET_SETTING: (state, setting) => {
      state.setting = setting
    },
    SET_STATUS: (state, status) => {
      state.status = status
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    }
  },

  actions: {
    // 用户名登录
    LoginByUsername({
      commit
    }, userInfo) {
      const username = userInfo.username.trim()
      return new Promise((resolve, reject) => {
        loginByUsername(username, userInfo.password).then(response => {
          const data = response.data
          if (data.code === '0000') {
            commit('SET_TOKEN', data.data)
            setToken(response.data.data)
            getUsername().then(response => {
              if (response.data.code === '0000') {
                if (response.data.data.name) {
                  localStorage.setItem('userName', response.data.data.name)
                } else {
                  localStorage.setItem('account', response.data.data.account)
                }
                localStorage.setItem('id', response.data.data.id)
              }
            })
            resolve(data)
          } else {
            resolve(data)
            Message({
              message: '登录失败,' + data.result,
              type: 'error',
              duration: 5 * 1000
            })
          }
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 获取用户信息
    GetUserInfo({
      commit,
      state
    }) {
      return new Promise((resolve, reject) => {
        getUserInfo(state.token).then(response => {
          if (!response.data) { // 由于mockjs 不支持自定义状态码只能这样hack
            reject('error')
          }
          // const data = response.data

          // if (data.roles && data.roles.length > 0) { // 验证返回的roles是否是一个非空数组
          //  commit('SET_ROLES', data.roles)
          // } else {
          //  reject('getInfo: roles must be a non-null array !')
          // }

          commit('SET_ROLES', ['admin'])
          commit('SET_NAME', 'wangsong')
          commit('SET_AVATAR', '')
          commit('SET_INTRODUCTION', '')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 登出
    LogOut({
      commit,
      state
    }) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
        localStorage.removeItem('userName')
        localStorage.removeItem('account')
      })
    },

    // 前端 登出
    FedLogOut({
      commit
    }) {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        removeToken()
        resolve()
      })
    },

    // 动态修改权限
    ChangeRoles({
      commit,
      dispatch
    }, role) {
      return new Promise(resolve => {
        commit('SET_TOKEN', role)
        setToken(role)
        getUserInfo(role).then(response => {
          const data = response.data
          commit('SET_ROLES', data.roles)
          commit('SET_NAME', data.name)
          commit('SET_AVATAR', data.avatar)
          commit('SET_INTRODUCTION', data.introduction)
          dispatch('GenerateRoutes', data) // 动态修改权限后 重绘侧边菜单
          resolve()
        })
      })
    }
  }
}

export default user

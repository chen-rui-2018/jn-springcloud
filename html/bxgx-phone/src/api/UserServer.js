import BaseModule from './BaseModule'

class UserServer extends BaseModule {
  constructor () {
    super()
  }

  getUsersPageableList (page = 1, size = 20) {
    return this.get(`../static/json/data.json`)
  }

  getUser (id) {
    if (!id) {
      return Promise.reject(new Error(`getUser：id(${id})无效`))
    }
    return this.get(`/users/${id}`)
  }
  deleteUser (id) {
    if (!id) {
      return Promise.reject(new Error(`getUser：id(${id})无效`))
    }
    return this.get(`/users/${id}`)
  }
}

export default new UserServer()

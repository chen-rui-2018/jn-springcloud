import Mock from 'mockjs'
import { param2Obj } from '@/utils' // 将location.search转成json对象

const List = []
const count = 100
for (let i = 0; i < count; i++) {
  List.push(Mock.mock({
    id: '@increment',
    name: '@cname',
    account: '@word(6,11)',
    email: '@email',
    creation_time: '@datetime',
    'department|1': ['A部门', '销售部', '研发部', '市场部'],
    'position|1': ['研发岗', '经理', '普通', '人力'],
    'userStatus|1': ['生效', '不生效'],
    operation: '',
    timestamp: +Mock.Random.date('T')
  }))
}

export default {
  getList: config => {
    const { name, userStatus, department, importance, type, title, page = 1, limit = 20, sort } = param2Obj(config.url)
    let mockList = List.filter(item => {
      if (importance && item.importance !== +importance) return false
      if (type && item.type !== type) return false
      if (title && item.title.indexOf(title) < 0) return false
      if (userStatus && item.userStatus !== userStatus) return false
      if (department && item.department !== department) return false
      if (name && item.name.indexOf(name) < 0) return false
      return true
    })

    if (sort === '-id') {
      mockList = mockList.reverse()
    }
    const pageList = mockList.filter((item, index) => index < limit * page && index >= limit * (page - 1))
    return {
      total: mockList.length,
      items: pageList
    }
  },
  userCreateData: () => ({
    data: 'success'
  })
}

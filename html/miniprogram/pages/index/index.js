Component({
  data: {
    elements: [
      { title: '政策指南', name: 'policy', color: 'purple', icon: 'formfill' },
      { title: '申报公告 ', name: 'declare', color: 'mauve', icon: 'formfill' },
      { title: '园区公告', name: 'notice', color: 'pink', icon: 'formfill' },
      { title: '园区活动', name: 'activity', color: 'brown', icon: 'formfill' },
      { title: '物业报修', name: 'property', color: 'red', icon: 'formfill' },
      { title: '停车缴费', name: 'pay', color: 'orange', icon: 'timefill' },
      { title: '会议签到', name: 'meeting', color: 'green', icon: 'messagefill' },
      { title: '注册', name: 'register', color: 'green', icon: 'messagefill' }
    ],
  },
  onLoad: function () {
  },
  pageLifetimes: {
    show() {
      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 1
        })
      }
    }
  }
})

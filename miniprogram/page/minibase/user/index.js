const app = getApp()

Page({
  data: {
    userInfo: {},
    items: [
      {
        icon: '../../../image/my/iconfont-order.png',
        text: '我的爱车',
        path: '/pages/order/list/index'
      },
      {
        icon: '../../../image/my/iconfont-addr.png',
        text: '我的报修',
        path: '/pages/address/list/index'
      },
      {
        icon: '../../../image/my/iconfont-kefu.png',
        text: '我的活动',
        path: '/pages/address/list/index',
      },
      {
        icon: '../../../image/my/iconfont-help.png',
        text: '缴费记录',
        path: '/pages/help/list/index',
      },
    ],
    settings: [
      {
        icon: '../../../image/my/iconfont-clear.png',
        text: '修改密码',
        path: '/pages/address/list/index',
      },
      {
        icon: '../../../image/my/iconfont-about.png',
        text: '关于我们',
        path: '/pages/about/index'
      },
    ]
  },
  onLoad() {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  navigateTo(e) {
    const index = e.currentTarget.dataset.index
    const path = e.currentTarget.dataset.path

    switch (index) {
      case 2:
        App.WxService.makePhoneCall({
          phoneNumber: path
        })
        break
      default:
        App.WxService.navigateTo(path)
    }
  },
  getUserInfo(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  getStorageInfo() {
  },
  bindtap() {
  },
  logout() {
  },
  signOut() {
  },
})

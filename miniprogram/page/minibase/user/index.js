// const app = getApp()

Page({
  data: {
    userInfo: {},
    items: [
      {
        icon: '../../../image/my/iconfont-order.png',
        text: '我的订单',
        path: '/pages/order/list/index'
      },
      {
        icon: '../../../image/my/iconfont-addr.png',
        text: '收货地址',
        path: '/pages/address/list/index'
      },
      {
        icon: '../../../image/my/iconfont-kefu.png',
        text: '联系客服',
        path: '18521708248',
      },
      {
        icon: '../../../image/my/iconfont-help.png',
        text: '常见问题',
        path: '/pages/help/list/index',
      },
    ],
    settings: [
      {
        icon: '../../../image/my/iconfont-clear.png',
        text: '清除缓存',
        path: '0.0KB'
      },
      {
        icon: '../../../image/my/iconfont-about.png',
        text: '关于我们',
        path: '/pages/about/index'
      },
    ]
  },
  onLoad() {
    this.getUserInfo()
    // this.getStorageInfo()
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
  getUserInfo() {
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

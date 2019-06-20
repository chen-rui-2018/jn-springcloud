// pages/templates/card-list.js
const app = getApp()
const imgBaseUrl = app.globalData.imgBaseUrl
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    url: {   // 图片链接
      type: String,
      observer: function (newVal, oldVal) {}
    },
    title: {   // 右侧标题
      type: String,
      value: '标题',
      observer: function (newVal, oldVal) { }
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    imgBaseUrl
  },

  /**
   * 组件的方法列表
   */
  methods: {

  }
})

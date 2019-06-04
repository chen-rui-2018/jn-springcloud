// pages/templates/cell/cell.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    content: {
      type: String,
      observer: function (newVal, oldVal) { }
    },
    tips: {
      type: String,
      observer: function (newVal, oldVal) { }
    }
  },

  /**
   * 组件的初始数据
   */
  data: {

  },

  /**
   * 组件的方法列表
   */
  methods: {

  },

  options: {
    addGlobalClass: true,
    multipleSlots: true // 在组件定义时的选项中启用多slot支持
  }
})

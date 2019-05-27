// pages/templates/sub-button/sub-button.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    title: {
      type: String,
      value: '提交',
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
    onTap () {
      this.triggerEvent('click', {})
    }
  }
})

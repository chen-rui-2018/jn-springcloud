// pages/templates/uploader/uploader.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    url: {
      type: String,
      observer: function (newVal, oldVal) { }
    },
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
    onTap() {
      this.triggerEvent('click', {})
    }
  },

  options: {
    addGlobalClass: true
  }
  
})

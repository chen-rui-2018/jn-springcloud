<template>
  <div class="ueQuidtor">
    <script id="editor" type="text/plain" />
  </div>
</template>
<script>
export default {
  name: 'UE',
  props: {
    defaultMsg: {
      // type: String,
      default: ''
    },
    config: {
      type: Object,
      default: function() {}
    }
  },
  data() {
    return {
      editor: null
    }
  },
  mounted() {
    const _this = this
    this.editor = window.UE.getEditor('editor', this.config) // 初始化UE
    this.editor.addListener('ready', function() {
      setTimeout(function() {
        _this.editor.setContent(_this.defaultMsg) // 确保UE加载完成后，放入内容。
      }, 200)
    })
  },
  destroyed() {
    this.editor.destroy()
  },
  methods: {
    getUEContent() {
      // 获取内容方法
      return this.editor.getContent()
    }
  }
}
</script>
<style  lang="scss">
.ueQuidtor{

   .el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
    line-height: 22px !important;
}
}
</style>

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
    },
    disabledEditorFlag: {
      // type: boolean,
      default: false
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
        if (_this.disabledEditorFlag) {
          _this.editor.setDisabled()
        }
      }, 500)
    })
  },
  destroyed() {
    this.editor.destroy()
  },
  methods: {
    getUEContent() {
      // 获取内容方法
      return this.editor.getContent()
    },
    hasContents() {
      return this.editor.hasContents()
    },
    setContent(content) {
      console.dir(content)
      this.editor.hasContents(content)
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

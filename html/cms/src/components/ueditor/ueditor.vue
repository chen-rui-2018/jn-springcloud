<template>
  <div>
    <script id="editor" type="text/plain" />
  </div>
</template>

<script>
import '../../../static/UE/jquery-2.2.3.min.js'
import '../../../static/UE/ueditor.config.js'
import '../../../static/UE/ueditor.all.js'
import '../../../static/UE/lang/zh-cn/zh-cn.js'

export default {
  name: 'UEditor',
  props: {
    id: {
      type: String,
      default: function() {}
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
    // eslint-disable-next-line no-unused-vars
    const _this = this
    // eslint-disable-next-line no-undef
    this.editor = UE.delEditor('editor')
    // eslint-disable-next-line no-undef
    this.editor = UE.getEditor('editor', this.config)
  },
  destoryed() {
    this.editor.destory()
  },
  methods: {
    getUEContent: function() {
      return this.editor.getContent()
    },
    getContentTxt: function() {
      return this.editor.getContentTxt()
    }
  }
}
</script>

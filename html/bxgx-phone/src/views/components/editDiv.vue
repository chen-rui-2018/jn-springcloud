<template>
    <div class="edit-div"
         v-html="innerText"
         contenteditable
         @focus="isLocked = true"
         @blur="isLocked = false"
         @input="changeText">
    </div>
</template>
<script>
export default{
  name: 'editDiv',
  props: {
    value: {
      type: String,
      default: ''
    }
  },
  data () {
    return {
      innerText: this.value,
      isLocked: false
    }
  },
  watch: {
    'value' () {
      if (!this.isLocked || !this.innerText) {
        this.innerText = this.value
      }
    }
  },
  methods: {
    changeText () {
      console.dir('123')
      this.$emit('input', this.$el.innerHTML)
    }
  }
}
</script>

<template>
  <div class="monitoring">
    <header>
      <div> <el-date-picker
        v-model="selectYear"
        type="year"
        placeholder="选择年"/></div>
      <div>园区管委会:<span>{{ selectYear }}</span>已支出全年/预算<span>{{ baifen }}</span></div>
    </header>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectYear: '',
      baifen: ''
    }
  }
}
</script>

<style scoped>
 .el-date-editor.el-input, .el-date-editor.el-input__inner{
     width:108px;
 }
</style>

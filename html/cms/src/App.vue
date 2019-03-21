<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default{
  name: 'App'
}
</script>
<style lang='scss'>
body{
  padding-right:0 !important
}
.el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
    line-height: 22px;
}
.avatar-uploader{
  background-color: #f8f8f8;
}
ul{
  list-style: none
}
</style>

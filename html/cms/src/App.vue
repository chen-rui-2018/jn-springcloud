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
 body .el-table th.gutter{
    display: table-cell!important;
 }

 body .el-table colgroup.gutter{
    display: table-cell!important;
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

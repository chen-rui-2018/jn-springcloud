<template>
  <div id="app">
    <router-view v-if="isRouterAlive" />
  </div>
</template>

<script>
export default{
  name: 'App',
  provide() {
    return {
      reload: this.reload()
    }
  },
  data() {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload() {
      this.isRouterAlive = false
      this.$nextTick(function() {
        this.isRouterAlive = true
      })
    }
  }
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
// .el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
//     line-height: 22px;
// }
.avatar-uploader{
  background-color: #f8f8f8;
}
ul{
  list-style: none
}
.download{
      display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    color: rgb(96, 98, 102);
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    font-weight: 500;
    user-select: none;
    font-size: 14px;
    background: rgb(255, 255, 255);
    border-width: 1px;
    border-style: solid;
    border-color: rgb(220, 223, 230);
    border-image: initial;
    outline: none;
    margin: 0px;
    transition: all 0.1s ease 0s;
    padding: 12px 20px;
    border-radius: 4px;
    color: rgb(255, 255, 255);
    background-color: rgb(64, 158, 255);
    border-color: rgb(64, 158, 255);
}

.demo> a:hover{
  color:#fff !important;
}
.el-pagination{
  margin-top:15px;
}
 .el-dialog__footer{
    text-align: center;
  }
</style>

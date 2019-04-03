<template>
  <div id="app">
    <app-header v-if="$route.name=='actiCenter'||$route.name=='actiDetail'||$route.name=='regData'||$route.name=='regStatus'||$route.name=='actiManagent'||$route.name=='peoDec'"></app-header>
    <ser-header v-if="$route.name=='actiTrain'||$route.name=='index'"></ser-header>
    <router-view/>
    <app-footer  v-if="$route.name!=='login'&&$route.name!=='register'&&$route.name!=='forgetPsw'"></app-footer>
  </div>
</template>

<script>
import AppHeader from './components/header'
import AppFooter from './components/footer'
import SerHeader from './components/serverHeader'
import './common/font/font.css'
export default {
  name: 'App',
  components:{AppHeader,AppFooter,SerHeader},
  created(){
    // if(sessionStorage.token){
    //     this.api.setToken(sessionStorage.token)      
    // }
    // this.init()
  },
  methods:{
    // init(){
    //   let _this=this
    //   this.api.post({
    //       url: "loginURL",
    //       data: {
    //         account: "wangsong",
    //         password: "wangsong"
    //       },
    //       dataFlag: false,
    //       callback: function(res) {
    //         if (res.code == "0000") {
    //           _this.api.setToken(res.data)
    //         }
    //       }
    //     });
    // }
  }
}
</script>

<style lang="scss">
/* 引入全局样式 */
@import url(./css/main.css);
@import url(./css/home.css);
#app {
    font-family: 'Microsoft YaHei','Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}
.el-submenu__title{
  padding-left:30px;
  text-align: left;
 }
 /* .el-menu-item-group__title {
  padding-left: 30px;
  text-align: left;
}
.el-submenu__title{
  padding-left: 50px;
} */
</style>

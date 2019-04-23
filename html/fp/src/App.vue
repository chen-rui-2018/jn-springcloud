<template>
  <div id="app">
    <app-header v-if="$route.name=='actiCenter'||$route.name=='actiDetail'||$route.name=='regData'||$route.name=='regStatus'||$route.name=='actiManagent'||$route.name=='peoDec'"></app-header>
    <ser-header v-if="$route.name=='actiTrain'||$route.name=='index'"></ser-header>
    <adminApprove-header v-if="$route.name=='compassView'||$route.name=='rightDetail'||$route.name=='serviceDetail'||$route.name=='declarationPlatform'||$route.name=='declarationNoticeDetail'||$route.name=='declarationCenter'||$route.name=='talentsService'||$route.name=='talentPlatform'||this.$route.name=='familiarProblem'||this.$route.name=='familiarProblemDetail'||this.$route.name=='talentsServiceDetail'"></adminApprove-header>
    <router-view/>
    <app-footer  v-if="$route.name!=='login'&&$route.name!=='register'&&$route.name!=='forgetPsw'"></app-footer>
  </div>
</template>

<script>
import AppHeader from './components/header'
import AppFooter from './components/footer'
import SerHeader from './components/serverHeader'
import adminApproveHeader from './components/adminApproveHeader'
import './common/font/font.css'
export default {
  name: 'App',
  components:{AppHeader,AppFooter,SerHeader,adminApproveHeader},
  created(){
    // if(sessionStorage.token){
    //     this.api.setToken(sessionStorage.token)      
    // }
    this.init()
  },
  methods:{
    init(){
      let _this=this
      this.api.post({
          url: "loginURL",
          data: {
            account: "wangsong",
            password: "wangsong"
          },
          dataFlag: false,
          callback: function(res) {
            if (res.code == "0000") {
             sessionStorage.token=res.data
            }
          }
        });
    }
  }
}
</script>

<style lang="scss">
/* 引入全局样式 */
@import url(./css/main.css);
@import url(./css/home.css);
@import url(./css/serviceMarket.css);
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

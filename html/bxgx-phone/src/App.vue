<template>
  <div id="app">
    <!-- <administrative-header v-if="this.$route.name==='declarationconsult'||this.$route.name==='talentsService'||this.$route.name==='talentsServicePlatform'||this.$route.name==='talentsServiceDetail'||$route.name==='serverProDetail'||$route.name==='actiDetail'||this.$route.name==='approvalGuide'||this.$route.name==='powerDetail'||this.$route.name==='serviceDetail'||this.$route.name==='consult'||this.$route.name==='declarationCenter'||this.$route.name==='declarationPlatform'||this.$route.name==='consult'||this.$route.name==='serverProDetail'||this.$route.name==='actiDetail' || this.$route.name==='workPlan' || this.$route.name==='addWorkPlan'||this.$route.name==='editWorkPlan'||this.$route.name==='editWorkStatus' || this.$route.name==='workPlanDetails'"></administrative-header> -->
    <router-view/>
  </div>
</template>

<script>
import './assets/styles/reset.css'
import administrativeHeader from './components/administrativeHeader'

export default {
  name: 'App',
  components: {administrativeHeader},
  mounted () {
    this.init()
  },
  created () {
    this.init()
    // this.$post({
    //   url: 'http://192.168.10.31:1101/springcloud-app-system/login',
    //   data: {
    //     account: 'wangsong',
    //     password: 'wangsong'
    //   }
    // }).then(res => {
    //   sessionStorage.setItem('token', res.data)
    // })
  },
  methods: {
    init () {
      // sessionStorage.token = this.$route.query.token
      this.api.post({
        url: 'loginURL',
        data: {
          account: 'wangsong',
          password: 'wangsong'
        },
        dataFlag: false,
        callback: function (res) {
          if (res.code === '0000') {
            sessionStorage.token = res.data
          }
        }
      })
    }
  }
}
</script>
<style lang="scss">
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center;
  color: #2c3e50; */
  /* margin-top: 60px; */
}
</style>

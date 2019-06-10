<template>
  <div id="app">
    <administrative-header v-if="this.$route.name==='declarationconsult'||this.$route.name==='talentsService'||this.$route.name==='talentsServicePlatform'||this.$route.name==='talentsServiceDetail'||$route.name==='serverProDetail'||$route.name==='actiDetail'||this.$route.name==='approvalGuide'||this.$route.name==='powerDetail'||this.$route.name==='serviceDetail'||this.$route.name==='consult'||this.$route.name==='declarationCenter'||this.$route.name==='declarationPlatform'||this.$route.name==='declarationDetail'||this.$route.name==='consult'||this.$route.name==='actiDetail' || this.$route.name==='workPlan' || this.$route.name==='addWorkPlan'||this.$route.name==='editWorkPlan'||this.$route.name==='editWorkStatus' || this.$route.name==='workPlanDetails'||this.$route.name==='parkDetais'||this.$route.name==='moreActi'||this.$route.name==='policyGuide'||this.$route.name==='attendanceManagement'||this.$route.name==='attendanceDetails'||this.$route.name==='electricInfo'"></administrative-header>
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
  },
  methods: {
    init () {
      // this.token = this.$route.query.token
      // // sessionStorage.setItem('token', this.token)
      // // console.log()
      // sessionStorage.token = this.$route.query.token
      // console.log(sessionStorage.token)
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

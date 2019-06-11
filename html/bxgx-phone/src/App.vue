<template>
  <div id="app">
    <administrative-header v-if=" this.$route.name==='workPlan' || this.$route.name==='addWorkPlan'||this.$route.name==='editWorkPlan'||this.$route.name==='editWorkStatus' || this.$route.name==='workPlanDetails'||this.$route.name==='attendanceManagement'||this.$route.name==='attendanceDetails'||this.$route.name==='electricInfo'"></administrative-header>
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

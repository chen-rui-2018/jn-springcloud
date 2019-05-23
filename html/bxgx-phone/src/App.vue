<template>
  <div id="app">
    <administrative-header v-if="this.$route.name==='approvalGuide'||this.$route.name==='powerDetail'||this.$route.name==='consult'||this.$route.name==='declarationCenter'||this.$route.name==='declarationPlatform'||this.$route.name==='declarationDetail'||this.$route.name==='consult'||$route.name==='serverProDetail'||$route.name==='actiDetail'" ></administrative-header>

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

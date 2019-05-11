<template>
  <div id="app">
    <administrative-header v-if="this.$route.name==='approvalGuide'" ></administrative-header>
    <router-view/>
  </div>
</template>

<script>

import './assets/styles/reset.css'

import administrativeHeader from './components/administrativeHeader'

export default {
  name: 'App',
  components: {administrativeHeader}
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center;
  color: #2c3e50; */
  /* margin-top: 60px; */
}
</style>

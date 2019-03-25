<template>
  <div class="navbar">
    <hamburger :toggle-click="toggleSideBar" :is-active="sidebar.opened" class="hamburger-container" />

    <breadcrumb class="breadcrumb-container" />
    <a href="http://112.94.22.222:2381" target="_blank" style="display:inline-block;margin-left: 20px;">快速开发平台</a>
    <div class="right-menu">
      <template v-if="device!=='mobile'">
        <!-- <error-log class="errLog-container right-menu-item"/> -->
        <div class="avatar-wrapper">
          <span v-if="userName!==null">
            {{ userName }}
          </span>
          <span v-else>
            {{ account }}
          </span>
          <a href="javascript:void(0)" style="display:inline-block;" @click="logout">退出</a>
        </div>
      </template>
    </div>
    <iframe v-show = "false" ref="iframe" frameborder = "0" src="" name="kskfpt" scrolling="auto"/>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Breadcrumb from '@/components/Breadcrumb'
import Hamburger from '@/components/Hamburger'
// import { loginByUsername } from '@/api/login'
// import ErrorLog from '@/components/ErrorLog'

export default {
  components: {
    Breadcrumb,
    Hamburger
    // ErrorLog,
  },
  data() {
    return {
      account: '',
      userName: ''
    }
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'name',
      // 'avatar',
      'device'
    ])
  },
  mounted() {
    this.userName = localStorage.getItem('userName')
    this.account = localStorage.getItem('account')
    // if (this.userName === null) {
    //   this.account = localStorage.getItem('account')
    // } else {
    //   this.userName = localStorage.getItem('userName')
    // }

    // 登录成功，请求快速快发平台进行登录,iframe
    /* axios.get('http://localhost:8080/ibps/noPasswordLogin.htm?username=' + this.loginForm.username + '&password=123', response => {
      if (response.status >= 200 && response.status < 300) {
        console.log(response.data)
      } else {
        console.log(response.message)
      }
    })*/
    this.$refs.iframe.contentWindow.location.replace('http://112.94.22.222:2381/noPasswordLogin.htm?username=' + localStorage.getItem('account') + '&password=123')
  },
  methods: {
    toggleSideBar() {
      this.$store.dispatch('toggleSideBar')
    },
    logout() {
      this.$store.dispatch('LogOut').then(() => {
        location.reload()// In order to re-instantiate the vue-router object to avoid bugs
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.navbar {
  height: 50px;
  line-height: 50px;
  border-radius: 0px !important;
  .hamburger-container {
    line-height: 58px;
    height: 50px;
    float: left;
    padding: 0 10px;
  }
  .breadcrumb-container {
    float: left;
  }
  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }
  .right-menu {
    float: right;
    height: 100%;
    &:focus {
      outline: none;
    }
    .right-menu-item {
      display: inline-block;
      margin: 0 8px;
    }
    .international {
      vertical-align: top;
    }
    .avatar-wrapper {
      margin-right: 30px;
    }
  }
}
</style>

<template>
  <el-scrollbar wrap-class="scrollbar-wrapper">
    <div :class="{'s-logo':!sidebar.opened}" class="logo" />
    <el-menu
      :unique-opened="true"
      :show-timeout="200"
      :default-active="$route.path"
      :collapse="isCollapse"
      :router="true"
      mode="vertical"
      background-color="#304156"
      text-color="#bfcbd9"
      active-text-color="#409EFF"
      @open="handleOpen"
      @close="handleClose">
      <!-- <sidebar-item v-for="route in permission_routers" :key="route.path" :item="route" :base-path="route.path" /> -->
      <sidebar-item v-for="(item,index,key) in menuItems" :key="key" :item="item" :index="item.id"/>
    </el-menu>
  </el-scrollbar>
</template>
<script>
import { mapGetters } from 'vuex'
import SidebarItem from './SidebarItem'
import { getUserInfo } from '@/api/login.js'
export default {
  components: { SidebarItem },
  data() {
    return {
      menuItems: {}
    }
  },
  computed: {
    ...mapGetters(['permission_routers', 'sidebar']),
    isCollapse() {
      return !this.sidebar.opened
    }
  },
  created() {
    var token = localStorage.getItem(token)
    getUserInfo(token).then(res => {
      console.log(res)
      this.menuItems = res.data.data
    })
  },
  methods: {
    handleOpen(key, keyPath) {
      // console.log(key, keyPath)
    },
    handleClose(key, keyPath) {
      // console.log(key, keyPath)
    }
  }
}
</script>

<style lang="scss" scoped>
.logo {
  height: 56px;
  background: url("/static/corporate/logo/logo.jpg") no-repeat center;
  // background:url('~@/assets/images/logo.jpg') center center / 100% 100% no-repeat ;
}
.s-logo {
  background: url("/static/corporate/logo/small-logo.png") center center
    no-repeat;
}
</style>

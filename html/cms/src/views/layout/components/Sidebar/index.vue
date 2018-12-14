<template>
  <el-scrollbar wrap-class="scrollbar-wrapper">
    <div class="logo"/>
    <el-menu
      :show-timeout="200"
      :default-active="$route.path"
      :collapse="isCollapse"
      mode="vertical"
      background-color="#304156"
      text-color="#bfcbd9"
      active-text-color="#409EFF"
    >
      <sidebar-item v-for="route in permission_routers" :key="route.path" :item="route" :base-path="route.path"/>
    </el-menu>
  </el-scrollbar>
</template>
<script>
import { mapGetters } from 'vuex'
import SidebarItem from './SidebarItem'
export default {
  components: { SidebarItem },
  computed: {
    ...mapGetters([
      'permission_routers',
      'sidebar'
    ]),
    isCollapse() {
      return !this.sidebar.opened
    }
  }
}
</script>

<style lang="scss" scoped>
    .logo{
      // width: 100%;
      height: 56px;
      background:url('~@/assets/images/logo.jpg') center center / 100% 100% no-repeat ;
      // img{
      //   // width: 100%;
      //   height: 100%;
      // }
    }
</style>

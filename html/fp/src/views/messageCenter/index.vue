<template>
  <div :class="{pd: $store.state.needNav}" class="message-center-bg">
    <div class="message-center">
      <div class="nav-tips" v-if="$store.state.needNav">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/home' }">消息中心</el-breadcrumb-item>
          <el-breadcrumb-item>
            <span>{{this.$route.meta.title}}</span>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <el-container>
        <el-aside width="200px">
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo">
            <el-submenu index="1">
              <template slot="title">
                <span>个人动态</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="1-1">选项1</el-menu-item>
                <el-menu-item index="1-2">选项2</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-menu-item index="2" @click.native="$router.push('/messageCenter/chat')">
              <span slot="title">社区交流</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main class="message-center-main">
          <router-view></router-view>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
import { isMobile } from "@/util";
export default {
  name: "MessageCenter",
  data() {
    return {
      isMobile: isMobile()
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~@/css/r-common";
@import "~@/css/common";
$bg-gray: #f3f3f3;
.message-center-bg {
  .message-center-main {
    margin-left: 20px;
  }
  background-color: $bg-gray;
  &.pd {
    padding-top: 66px;
  }
}
  .message-center {
   width: 1190px;
   margin: 0 auto;
   min-height: 500px;
  .el-container {
    min-height: 500px;
  }
  .nav-tips {
    padding: 10px 0;
    background-color: $bg-gray;
  }
  .el-menu {
    border-right: none;
    .el-menu-item {
      border-right: none;
      &.is-active {
        color: $--color-primary;
        border-left: 2px solid $--color-primary;
      }
    }
  }
}
</style>

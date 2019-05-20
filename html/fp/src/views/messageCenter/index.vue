<template>
  <div :class="{pd: $store.state.needNav}" class="message-center-bg">
    <div :class="{pc: !$store.state.isMobile}" class="message-center">
      <div class="nav-tips" v-if="$store.state.needNav">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/home' }">消息中心</el-breadcrumb-item>
          <el-breadcrumb-item>
            <span class="mainColor">{{this.$route.meta.title}}</span>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <el-container>
        <el-aside style="width: 200px;margin-right: 20px;">
          <div class="userImg">
            <div class="imgItem">
              <img src="@/../static/img/larImg.png" alt="">
            </div>
            <!-- <p>{{account}}</p> -->
          </div>
          <el-menu :default-active="this.$route.path" :unique-opened="true" router class="el-menu-vertical-demo">
            <el-submenu index="/messageCenter">
              <template slot="title">
                <span>个人动态</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="/parkNotice">园区通知</el-menu-item>
                <!-- <el-menu-item index="1-2">私人订单</el-menu-item>
                <el-menu-item index="1-2">信用动态</el-menu-item>
                <el-menu-item index="1-2">消费汇总</el-menu-item>
                <el-menu-item index="1-2">收入汇总</el-menu-item>
                <el-menu-item index="1-2">付款通知</el-menu-item> -->
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">
                <span>企业空间</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="/enterpriseOrder">企业订单</el-menu-item>
                <el-menu-item index="/informationDynamics">信息发布动态</el-menu-item>
                <el-menu-item index="/paymentReminder">缴费提醒</el-menu-item>
                <el-menu-item index="/guestbook">访客留言</el-menu-item>
                <el-menu-item index="/dataReminder">数据上报提醒</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-menu-item index="2" @click.native="toChat">
              <span slot="title">社区交流</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main :class="{app: $store.state.isMobile}" class="message-center-main">
          <router-view></router-view>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
export default {
  name: "MessageCenter",
  methods: {
    toChat() {
      const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
      this.$router.push({
        path: '/messageCenter/chat',
        query: {
          fromUser: userInfo.account
        }
      })
    }
  }
}
</script>

<style lang="scss">
@import "~@/css/r-common";
@import "~@/css/common";
$bg-gray: #f3f3f3;
.message-center-bg {
  background-color: $bg-gray;
  .message-center-main {
    padding: 0;
    &.app {
      width: 100%;
      height: 100%;
      position: absolute;
      top: 0;
      left: 0;
      .message-chat,
      .chat-win {
        .chat-win-cell {
          width: 100%;
          height: 100%;
          overflow: auto;
          position: absolute;
          -webkit-overflow-scrolling: touch;
          padding: 50px 10px 50px;
          box-sizing: border-box;
          background-color: #fff;
        }
        width: 100%;
        height: 100%;
        .chat-header {
          width: 100%;
          position: absolute;
          top: 0;
          left:0;
          z-index: 1;
        }
        .chat-main {
          width: 100%;
          height: 100%;
          margin-top: 0;
          box-sizing: border-box;
        }
      }
    }
  }
  &.pd {
    padding: 66px 0;
  }
}
  .message-center {
    &.pc {
      width: 1190px;
    }
   margin: 0 auto;
   min-height: 500px;
  }
.message-center {
  width: 1190px;
  margin: 0 auto;
  min-height: 500px;
  .el-container {
    min-height: 500px;
  }
  .nav-tips {
    padding: 15px 0;
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
  .userImg {
    background: #fff;
    width: 100%;
    text-align: center;
    .imgItem {
      margin: 0 auto;
      padding: 20px 0;
      width: 84px;
      height: 84px;
      img {
        width: 100%;
        height: 100%;
        vertical-align: middle;
        // margin: 0 auto;
      }
    }
  }
}
</style>

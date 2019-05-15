<template>
  <div class="message-center">
    <div class="pd-v-10" v-if="!isMobile">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/home' }">消息中心</el-breadcrumb-item>
        <el-breadcrumb-item>
          <a href="javascript:;">{{this.$route.meta.title}}</a>
        </el-breadcrumb-item>
      </el-breadcrumb>
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
.message-center {
  padding-top: 66px;
  width: 1190px;
  margin: 0 auto;
}
</style>

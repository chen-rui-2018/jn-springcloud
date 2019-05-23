<template>
    <el-container>
        <el-header style="height:100px;line-height:100px">
            <div>
                <img v-if="userData.avatar" :src="userData.avatar" alt="">
                <img v-else src="@/../static/img/larImg.png" alt="">
            </div>
            <span>您好，{{userData.account}}</span>
        </el-header>
        <el-main>
            <div class="imgItem">
                <img src="@/../static/img/rencai-bg.png">
                <div style="color:#999">未找到相关信息</div>
            </div>
        </el-main>
    </el-container>
</template>
<script>
export default {
  props: ["userData"],
  data() {
    return {};
  },
  methods: {}
};
</script>
<style lang="scss">
</style>


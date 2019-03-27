<template>
    <el-container>
        <el-header style="height:130px;line-height:130px">
            <img src="@/../static/img/larImg.png" alt="">
            <span>您好，{{this.$route.query.account}}</span>
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
  data() {
    return {};
  }
};
</script>
<style lang="scss">
</style>


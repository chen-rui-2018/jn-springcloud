<template>
  <el-row>
    <el-col :xs="0" :sm="1" :md="2" :lg="3" :xl="4">&nbsp;</el-col>
    <el-col :xs="24" :sm="22" :md="20" :lg="18" :xl="18">
      <slot/>
    </el-col>
    <el-col :xs="0" :sm="1" :md="2" :lg="3" :xl="4">&nbsp;</el-col>
  </el-row>
</template>

<script>
</script>

<style>
</style>

<template>
  <div class="filter-container">
    <!-- input搜索框 -->
    名称：
    <el-input v-model="listQuery.title" placeholder="请输入名称" style="width: 200px;" class="filter-item" @keyup.enter.native="searchListdata" />
    <!-- 第一个下拉菜单 -->
    状态：
    <el-select v-model="listQuery.status" placeholder="请选择状态" clearable class="filter-item">
      <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />
    </el-select>

    <!-- 搜索按钮 -->
    <el-button class="filter-item" type="primary" round>查询</el-button>
    <!-- 新增按钮 -->
    <el-button class="filter-item" round style="margin-left: 10px;" type="primary" @click="adddialogFormVisible=true">新增</el-button>
  </div>
</template>

<script>
export default {
  props: {
    listQuery: { type: Object,
      default: function() {
        return {}
      }
    },
    statusOptions: {
      type: Array,
      default: function() {
        return []
      }
    }
  },
  data() {
    return {

    }
  }
}
</script>

<style scoped>

</style>

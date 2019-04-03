<template>
    <div class="fullBg">
        <div class="actiManagent w">
            <div class="manNav">
                <el-breadcrumb separator="/">
                    <el-breadcrumb-item :to="{ path: '/' }">用户中心</el-breadcrumb-item>
                    <el-breadcrumb-item class="mainColor">活动管理</el-breadcrumb-item>
                </el-breadcrumb>
            </div>
            <div class="manContent">
                <el-container>
                    <el-aside width="150px">
                        <el-menu default-active="1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
                            <el-menu-item index="1">
                                <span slot="title">首页</span>
                            </el-menu-item>
                            <el-menu-item index="2">
                                <span slot="title">用户资料</span>
                            </el-menu-item>
                            <el-menu-item index="3">
                                <span slot="title">我的企业</span>
                            </el-menu-item>
                            <el-submenu index="4">
                                <template slot="title" style="padding-left:30px;">
                                    <span>角色认证</span>
                                </template>
                                <el-menu-item-group>
                                    <template slot="title">分组一</template>
                                    <el-menu-item index="1-1">选项1</el-menu-item>
                                    <el-menu-item index="1-2">选项2</el-menu-item>
                                </el-menu-item-group>
                                <el-menu-item-group title="分组2">
                                    <el-menu-item index="1-3">选项3</el-menu-item>
                                </el-menu-item-group>
                                <el-submenu index="1-4">
                                    <template slot="title">选项4</template>
                                    <el-menu-item index="1-4-1">选项1</el-menu-item>
                                </el-submenu>
                            </el-submenu>
                        </el-menu>
                    </el-aside>
                    <el-container>
                        <el-header>
                            <span>已报名</span>
                            <span>报名待审批</span>
                            <div style="float:right;z-index:12;">
                                <el-input placeholder="搜索活动" v-model="input" style="height:32px;line-height:32px;">
                                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                                </el-input>
                            </div>
                        </el-header>
                        <el-main>
                            <el-table :data="tableData" style="width: 100%" border fit>
                                <el-table-column prop="actiName" label="活动名称">
                                </el-table-column>
                                <el-table-column prop="actiType" label="活动类型">
                                </el-table-column>
                                <el-table-column prop="actiCost" label="活动费用">
                                </el-table-column>
                                <el-table-column prop="address" label="主办方">
                                </el-table-column>
                                <el-table-column prop="address" label="活动园区">
                                </el-table-column>
                                <el-table-column prop="actiAddress" label="活动地点">
                                </el-table-column>
                                <el-table-column prop="actiTime" label="活动时间">
                                </el-table-column>
                                <el-table-column prop="actiStatus" label="活动状态">
                                </el-table-column>
                                <el-table-column fit label="操作" align="center" width="auto" min-width="200">
                                    <template slot-scope="scope">
                                        <!-- <el-button
            v-if="scope.row.actiStatus==='2'"
            type="text"
            class="operation"
            @click="handleCancelActivity(scope.row)">取消活动
          </el-button>
          <el-button
            v-if="scope.row.actiStatus==='3'||scope.row.actiStatus==='4'"
            type="text"
            class="operation"
            @click="checkDo(scope.row)">查看
          </el-button>
          <el-button
            v-if="scope.row.actiStatus==='1'||scope.row.actiStatus==='3'||scope.row.actiStatus==='4'"
            type="text"
            class="operation"
            @click="handleDeleteActivity(scope.row)">删除
          </el-button>
          <el-button
            v-if="scope.row.isSendMessage==='1'"
            type="text"
            class="operation"
            @click="handlePushMessage(scope.row)">推送
          </el-button> -->
                                    </template>
                                </el-table-column>
                                <el-table-column prop="address" label="详情">
                                    <i class="el-icon-arrow-right"></i>
                                </el-table-column>
                            </el-table>
                        </el-main>
                    </el-container>
                </el-container>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      input: "",
      tableData: []
    };
  },
  methods: {
    handleOpen() {},
    handleClose() {}
  }
};
</script>
<style lang="scss" scoped>
.el-menu-item {
  padding-left: 30px;
  text-align: left;
}
.el-icon-search {
  height: 39px;
  width: 48px;
  background-color: #00a042;
  color: #fff;
  line-height: 39px;
  font-size: 22px;
  margin-left: 176px;
  border-radius: 0 5px 5px 0;
}
.fullBg {
  background: #f3f3f3;
  padding-bottom: 50px;
}
.actiManagent {
  .manNav {
    padding: 20px 0;
  }
  .manContent {
    .el-aside {
      background-color: #d3dce6;
      text-align: center;
      height: 100%;
      //   line-height: 200px;
      margin-right: 20px;
    }
    .el-header {
      background-color: #fff;
      color: #333;
      //   text-align: center;
      line-height: 60px;
      margin-bottom: 20px;
      > span {
        display: inline-block;
        width: 90px;
        padding-bottom: -4px;
        text-align: center;
        color: #9a9a9a;
        border-bottom: 2px solid#00a042;
        margin-right: 30px;
      }
    }
    .el-main {
      background-color: #fff;
      color: #333;
      //   text-align: center;
      line-height: 160px;
    }
  }
}
</style>


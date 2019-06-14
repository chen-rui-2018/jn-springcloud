<template>
  <div class="menu-wrapper">

    <!-- <el-submenu v-if="item.children && item.children.length >= 1&&item.children[1].label!=='服务专员认证'" :index="item.id + ''">
      <template slot="title">
        <i class="el-icon-menu"/>
        <span slot="title">{{ item.label }}</span>
      </template>
      <sidebar-item v-for="subItem in item.children" :key="subItem.id" :item="subItem"/>
    </el-submenu> -->
    <el-submenu v-if="item.children && item.children.length >= 1" :index="item.id + ''" @click="checkOrganization(item)">
      <template slot="title">
        <!-- <i class="el-icon-menu"/> -->
        <span slot="title">{{ item.label }}</span>
      </template>
      <sidebar-item v-for="subItem in item.children" :key="subItem.id" :item="subItem" />
    </el-submenu>

    <el-menu-item v-else :index="`${item.path}`" @click="checkOrganization(item)">
      <!-- <i :class="item.icon"/> -->
      <span slot="title">{{ item.label }}</span>
    </el-menu-item>
    <!-- 选择机构对话框 -->
    <el-dialog title="申请专员" :visible.sync="centerDialogVisible" width="460px;" :modal-append-to-body="false" center>
      <el-form :model="organizationForm" ref="organizationForm" label-width="80px" class="demo-dynamic">
        <el-form-item prop="orgId" label="服务机构" :rules="[
      { required: true, message: '请输入你要申请入驻的机构', trigger: 'change' },
    ]">
          <el-select v-model="organizationForm.orgId" filterable placeholder="请输入你要申请入驻的机构" clearable @change="getBusinessArea">
            <el-option v-for="item in orgArr" :key="item.orgId" :label="item.orgName" :value="item.orgId">
            </el-option>

          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button class="btn" type="primary" @click="toAdvisoryInformation">前往填写资料</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
// import path from 'path'
// import { generateTitle } from '@/utils/i18n'
// import { isExternal } from '@/utils'
// import Item from './Item'
// import AppLink from './Link'
// import FixiOSBug from './FixiOSBug'

export default {
  name: "SidebarItem",
  // components: { Item, AppLink },
  // mixins: [FixiOSBug],
  props: {
    // route object
    item: {
      type: Object,
      required: true
    },
    isNest: {
      type: Boolean,
      default: false
    },
    basePath: {
      type: String,
      default: ""
    }
  },
  data() {
    return {
      onlyOneChild: null,
      centerDialogVisible: false,
      organizationForm: {
        orgName: "",
        orgId: ""
      },
      orgArr: []
    };
  },
  watch: {
    centerDialogVisible(val) {
      !val &&
        setTimeout(() => {
          this.$refs["organizationForm"].resetFields();
        }, 0);
    }
  },
  methods: {
    getBusinessArea(value) {
      this.orgArr.forEach(v => {
        if (value === v.orgId) {
          this.businessArea = v.businessArea;
        }
      });
    },
    // 弹出选择机构对话框
    checkOrganization(item) {
      if (item.label === "服务专员认证") {
        this.api.get({
          url: "getUserApprovalStatus",
          // data: { orgName: "" },
          callback: res => {
            if (res.code == "0000") {
              console.log(res);
              if (res.data.approvalDesc === "未认证"||res.data.approvalDesc==='认证不通过') {
                this.orgArr = [];
                this.organizationForm.orgName = "";
                this.organizationForm.orgId = "";
                this.centerDialogVisible = true;
                this.query();
              }else{
                 this.$router.push({ path: item.path,query:{ isConceal:'1'} });//是否隐藏发送按钮
                // this.$router.push({ path: item.path ,query});
              }
            } else {
              this.$message.error(res.result);
            }
          }
        });
      } else {
        this.$router.push({ path: item.path });
      }
    },
    // 前往填写页面
    toAdvisoryInformation() {
      this.$refs["organizationForm"].validate(valid => {
        if (valid) {
          this.centerDialogVisible = false;
          this.$router.push({
            name: "advisoryInformation",
            query: {
              orgId: this.organizationForm.orgId,
              businessArea: this.businessArea,
              approvalDesc:'未认证'
            }
          });
        } else {
          return false;
        }
      });
    },
    //获取机构列表
    query() {
      this.api.get({
        url: "selectOrgInfo",
        data: { orgName: "" },
        callback: res => {
          if (res.code == "0000") {
            if (res.data != null) {
              this.orgArr = res.data;
            }
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    hasOneShowingChild(children, parent) {
      const showingChildren = children.filter(item => {
        if (item.hidden) {
          return false;
        } else {
          // Temp set(will be used if only has one showing child)
          this.onlyOneChild = item;
          return true;
        }
      });

      // When there is only one child router, the child router is displayed by default
      if (showingChildren.length === 1) {
        return true;
      }

      // Show parent if there are no child router to display
      if (showingChildren.length === 0) {
        this.onlyOneChild = { ...parent, path: "", noShowingChildren: true };
        return true;
      }

      return false;
    }
    // resolvePath(routePath) {
    //   debugger
    //   if (this.isExternalLink(routePath)) {
    //     return routePath
    //   }
    //   return path.resolve(this.basePath, routePath)
    // },
    // isExternalLink(routePath) {
    //   return isExternal(routePath)
    // },
    // handleRoute(item) {
    //   // 通过菜单URL跳转至指定路由
    //   this.$router.push('/' + item.path)
    // },
    // generateTitle
  }
};
</script>
<style lang="scss">
.menu-wrapper {
  .demo-dynamic {
    display: inline-block;
    .el-form-item__content {
      height: 33px;
      line-height: 33px;
      // width: 266px;
    }
    .el-input-group__append {
      background-color: #00a041;
      color: #fff;
      border: none;
      font-size: 13px;
      // border-bottom: 1px solid #fff;
    }
    .el-form-item {
      display: inline-block;
    }
    .el-input__inner {
      height: 33px;
      line-height: 33px;
      width: 266px;
    }
    .el-input {
      width: 266px;
    }
    .el-form-item__label {
      height: 33px;
      line-height: 33px;
    }
    .orgStyle {
      border: 1px solid rgba(65, 215, 135, 1);
      text-align: left;
      margin-bottom: 20px;
      max-height: 150px;
      overflow: auto;
      li {
        margin-left: 10px;
        cursor: pointer;
      }
    }
  }
  .el-dialog--center .el-dialog__body {
    padding: 10px 20px 0px 20px;
    text-align: center;
  }
}
</style>

<template>
  <div class="user-center">
    <div class="user-header">
      <div class="user-header-l">
        <img v-if="userInfo" :src="userInfo.avatar || '@/../static/img/touxiang.png'" alt="">
        <span v-if="userInfo" class="welcome">您好，{{ userInfo.nickName || ''}}</span>
      </div>
      <div class="user-header-r">
        <router-link to="/userHome" class="tag-list">
          <tag type="blue" title="用户资料设置" />
        </router-link>
        <div v-for="(tag, index) in jurisdictionTagList" @click="getJoinParkStatus(tag)" :key="index"
          class="tag-list">
          <tag :type="tag.type" :title="tag.title" />
        </div>
      </div>
    </div>
    <div class="user-main">
      <notice v-if="messageData.company" title="企业邀请" :content="messageData.company.data.length > 0" slotContent type="primary">
        <div v-for="(item, index) in messageData.company.data" :key="index" class="notice-content">
          <div class="notice-dot"></div>
          <div v-if="item.messageContent">
            {{ item.messageContent }}邀请您加入他们的企业，点击
            <router-link :to="`/myBusiness/businesInvitation?comId=${item.messageConnect.comId}&comName=${item.messageConnect.comName}&messageId=${item.id}`"
              style="color: #00a041;">查看详情</router-link>。
          </div>
        </div>
      </notice>
      <router-link to="/myBusiness/staffManagement">
        <notice v-if="cardData.findEmployeeRequisition || cardData.findEmployeeRequisition === ''" :content="cardData.findEmployeeRequisition | wrapNumber"
          title="员工申请" type="info"></notice>
      </router-link>
      <notice v-if="roleJurisdiction" :content="messageData.organization.data.length > 0" title="机构邀请" type="primary"
        slotContent>
        <div v-for="(item, index) in messageData.organization.data" :key="index" class="notice-content">
          <div class="notice-dot"></div>
          <div v-if="item.messageConnect && item.messageConnect.orgName">
            {{ item.messageConnect.orgName }}邀请您加入机构，成为机构专员，点击
            <router-link :to="`/myBody/acceptInvitation?orgId=${item.messageConnect.orgId}&orgName=${item.messageConnect.orgName}&businessArea=${item.messageConnect.businessArea}&messageId=${item.id}`"
              style="color: #00a041;">查看详情</router-link>。
          </div>
        </div>

      </notice>
      <router-link to="/myBody/counselorManagement">
        <notice v-if="cardData.findAdviserInvitation || cardData.findAdviserInvitation === ''" title="专员管理" type="info"
          :content="cardData.findAdviserInvitation | wrapNumber"></notice>
      </router-link>
      <router-link v-if="cardData.findRequirementManage || cardData.findRequirementManage === ''" :to="needManagementPath">
        <notice title="需求管理" type="primary" :content="cardData.findRequirementManage | wrapNumber">
        </notice>
      </router-link>
      <router-link to="/serviceMarket/comment/forOthersevaluate">
        <notice v-if="cardData.findEvaluateManage || cardData.findEvaluateManage === ''" title="评价管理" type="info"
          :content="cardData.findEvaluateManage | wrapNumber"></notice>
      </router-link>
      <router-link to="/actiManagent">
        <notice v-if="cardData.findActivityManage || cardData.findActivityManage === ''" title="活动管理" type="primary"
          :content="cardData.findActivityManage | wrapNumber"></notice>
      </router-link>
      <!--      <router-link to="/servicemarket/product/productService/dataReport">-->
      <!--        <notice-->
      <!--          v-if="cardData.findReportedData || cardData.findReportedData === ''"-->
      <!--          title="数据上报"-->
      <!--          type="info"-->
      <!--          :content="cardData.findReportedData | wrapNumber"-->
      <!--        ></notice>-->
      <!--      </router-link>-->
    </div>
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
import { getUserInfo } from "@/util/auth";
import tag from "./common/tag";
import notice from "./common/notice";

export default {
  name: "userCenter",
  components: {
    tag,
    notice
  },
  data() {
    return {
      organizationForm: {
        orgName: "",
        orgId: ""
      },
      centerDialogVisible:false,
      orgArr: [],
      roleJurisdiction: false,
      loading: true,
      userInfo: "",
      jurisdictionTagList: [],
      tagList: [
        {
          type: "green",
          title: "投资人认证",
          path: "/roleCertifications/investorCertification"
        },
        {
          type: "orange",
          title: "服务专员认证",
          path: "/roleCertifications/advisoryInformation"
        },
        {
          type: "purple",
          title: "机构认证",
          path: "/roleCertifications/basicInformation"
        }
      ],
      cardData: {
        // findReportedData: '', // 数据上报
      },
      messageData: {},
      requestList: [],
      needManagementPath: ""
    };
  },
  filters: {
    wrapNumber(str) {
      if (!str || !arguments[0]) {
        return '';
      }
      return str.replace(/\d+/g, function() {
        return `<span style="color: #00a041">${arguments[0]}</span>`;
      });
    },
     centerDialogVisible(val) {
      !val &&
        setTimeout(() => {
          this.$refs["organizationForm"].resetFields();
        }, 0);
    }
  },
  created() {
    this.init();
  },
  methods: {
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
              approvalDesc: "未认证"
            }
          });
        } else {
          return false;
        }
      });
    },
     getBusinessArea(value) {
      this.orgArr.forEach(v => {
        if (value === v.orgId) {
          this.businessArea = v.businessArea;
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
    // 获取是否可以认证
    getJoinParkStatus(tag) {
      this.api.get({
        url: "getJoinParkStatus",
        callback: res => {
          if (res.code == "0000") {
            if (res.data.code !== "0") {
              this.$message.error(res.data.message);
              return false;
            }else{
               if (tag.title === "服务专员认证") {
                  this.api.get({
                    url: "getUserApprovalStatus",
                    callback: res => {
                      if (res.code == "0000") {
                        if (
                          res.data.approvalDesc === "未认证" ||
                          res.data.approvalDesc === "认证不通过"
                        ) {
                          this.orgArr = [];
                          this.organizationForm.orgName = "";
                          this.organizationForm.orgId = "";
                          this.centerDialogVisible = true;
                          this.query();
                        } else {
                          this.$router.push({
                            path: tag.path,
                            query: { isConceal: "1" }
                          }); //是否隐藏发送按钮
                          // this.$router.push({ path: item.path ,query});
                        }
                      } else {
                        this.$message.error(res.result);
                      }
                    }
                  });
                } else {
                  this.$router.push({ path: tag.path });
                }

            }
          } else {
            this.$message.error(res.result);
            return false;
          }
        }
      });
    },
    init() {
      this.setJurisdiction().then(() => {
        this.getUserInfo();
        this.getCardData();
        this.getMessage();
      });
    },
    setJurisdiction() {
      return new Promise(resolve => {
        // 上方4个导航
        const menuItems = JSON.parse(sessionStorage.menuItems);
        menuItems.forEach(item => {
          // 角色认证
          if (item.label === "加入机构") {
            this.jurisdictionTagList = this.tagList;
            this.roleJurisdiction = true;
            // 机构邀请
            this.$set(this.messageData, "organization", {
              data: {},
              messageTowTort: 7
            });
          }

          // 企业邀请
          if (item.label === "加入园区") {
            this.$set(this.messageData, "company", {
              data: {},
              messageTowTort: 8
            });
          }

          // 员工申请
          if (item.label === "我的企业") {
            for (const list of item.resourcesList) {
              if (list.resourcesName === "编辑企业信息") {
                this.$set(this.cardData, "findEmployeeRequisition", "");
                break;
              }
            }
          }
          // 专员管理
          if (item.label === "我的机构") {
            for (const list of item.resourcesList) {
              if (list.resourcesName === "专员管理") {
                this.$set(this.cardData, "findAdviserInvitation", "");
                break;
              }
            }
          }
          // 评价管理
          if (item.label === "评价管理") {
            this.$set(this.cardData, "findEvaluateManage", "");
          }
          // 活动管理
          if (item.label === "活动管理") {
            this.$set(this.cardData, "findActivityManage", "");
          }
          // 需求管理
          if (item.label === "需求管理") {
            this.$set(this.cardData, "findRequirementManage", "");
            if (item.children && item.children.length > 0) {
              this.needManagementPath = item.children[0].path;
            }
          }
        });
        resolve();
      });
    },
    getMessage() {
      for (const key in this.messageData) {
        if (this.messageData.hasOwnProperty(key) && key) {
          this.api.get({
            url: "getMessageList",
            data: {
              isRead: 0,
              messageTowTort: this.messageData[key].messageTowTort
            },
            callback: res => {
              if (res.code === "0000") {
                if (res.data && res.data.rows && res.data.rows.length > 0 && res.data.rows[0]) {
                  // this.messageData[key].data = res.data.rows
                  this.messageData[key].data = [res.data.rows[0]];
                  this.messageData[key].data.forEach(item => {
                    item.messageConnect = JSON.parse(item.messageConnect);
                  });
                } else {
                  this.messageData[key].data = [];
                }
              } else {
                this.$message.error(res.result);
              }
            }
          });
        }
      }
    },
    getCardData() {
      for (const key in this.cardData) {
        const p = new Promise((resolve, reject) => {
          this.api.get({
            url: key,
            callback: res => {
              if (res.code === "0000") {
                this.cardData[key] = res.data;
                resolve();
              } else {
                this.$message.error(res.result);
                reject();
              }
            }
          });
        });
        this.requestList.push(p);
      }
      Promise.all(this.requestList).then(list => {
        this.loading = false;
      });
    },
    getUserInfo() {
      let userInfo = getUserInfo()
      if (userInfo) {
        userInfo = JSON.parse(userInfo)
      }
      this.userInfo = userInfo || {}
    }
  }
};
</script>
<style lang="scss" scoped>
@import "~@/css/r-common";
@import "~@/css/common";
.user-center {
  color: #333333;
  .notice-content {
    padding: trsw(23);
    @include flex($h: flex-start, $v: center);
  }
  .notice-dot {
    width: trsw(9);
    height: trsw(9);
    margin-right: 6px;
    border-radius: 50%;
    background-color: $--color-primary;
  }
  .user-header {
    padding: 20px 25px;
    background-color: #fff;
    border-radius: 3px;
    @include flex($h: space-between);
    .user-header-l {
      @include flex($h: space-between);

      img {
        width: trsw(83);
        height: trsw(83);
        border-radius: 50%;
        margin-right: trsw(24);
      }

      .welcome {
        font-size: 18px;
      }
    }

    .user-header-r {
      @include flex($h: space-between);

      .tag-list {
        margin-right: 30px;
      }
     >.tag-list:last-child {
        margin-right: 0;
      }
      // .tag-list:last-of-type {
      //   margin-right: 0;
      // }
    }
  }
  .user-main {
    margin-top: 12px;
  }
}
</style>

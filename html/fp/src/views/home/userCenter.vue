<template>
  <div class="user-center">
    <div class="user-header">
      <div class="user-header-l">
        <img v-if="userInfo" :src="userInfo.avatar" alt="">
        <span v-if="userInfo" class="welcome">您好，{{ userInfo.nickName }}</span>
      </div>
      <div class="user-header-r">
        <router-link
          v-for="(tag, index) in tagList"
          :key="index"
          :to="tag.path"
          class="tag-list">
          <tag
            :type="tag.type"
            :title="tag.title"
          />
        </router-link>
      </div>
    </div>
    <div v-loading="loading" class="user-main">
      <notice
        title="企业邀请"
        :content="messageData.company.data.messageContent"
        slotContent
        type="primary"
      >
        <div>
          {{ messageData.company.data.messageContent }}邀请您加入他们的企业，点击
          <router-link :to="`/myBusiness/businesInvitation?${messageData.company.data.messageConnect}`" style="color: #00a041;">查看详情</router-link>。
        </div>
      </notice>
      <router-link to="">
        <notice
          :content="cardData.findEmployeeRequisition | wrapNumber"
          title="员工申请"
          type="info"
        ></notice>
      </router-link>
      <notice
        :content="messageData.organization.data.messageContent"
        title="机构邀请"
        type="primary"
        slotContent
      >
        <div>
          {{ messageData.organization.data.messageContent }}邀请您加入他们机构的顾问，点击
          <router-link :to="`/myBody/acceptInvitation?${messageData.organization.data.messageConnect}`" style="color: #00a041;">查看详情</router-link>。
        </div>
      </notice>
      <router-link to="/myBody/counselorManagement">
        <notice
          title="顾问管理"
          type="info"
          :content="cardData.findAdviserInvitation | wrapNumber"
        ></notice>
      </router-link>
      <router-link to="">
        <notice
          title="需求管理"
          type="primary"
          :content="cardData.findRequirementManage | wrapNumber"
        ></notice>
      </router-link>
      <router-link to="/myBody/counselorManagement">
        <notice
          title="评价管理"
          type="info"
          :content="cardData.findEvaluateManage | wrapNumber"
        ></notice>
      </router-link>
      <router-link to="/actiManagent">
        <notice
          title="活动管理"
          type="primary"
          :content="cardData.findActivityManage | wrapNumber"
        ></notice>
      </router-link>
      <router-link to="/servicemarket/product/productService/dataReport">
        <notice
          title="数据上报"
          type="info"
          :content="cardData.findReportedData | wrapNumber"
        ></notice>
      </router-link>
    </div>
  </div>
</template>
<script>
  import tag from './common/tag'
  import notice from './common/notice'

  export default {
    name: "userCenter",
    components: {
      tag,
      notice
    },
    data() {
      return {
        loading: true,
        userInfo: '',
        tagList: [{
          type: 'blue',
          title: '用户资料设置',
          path: '/userHome'
        }, {
          type: 'green',
          title: '投资人认证',
          path: '/roleCertifications/investorCertification'
        }, {
          type: 'orange',
          title: '顾问认证',
          path: '/roleCertifications/advisoryInformation'
        }, {
          type: 'purple',
          title: '机构认证',
          path: '/roleCertifications/basicInformation'
        }],
        cardData: {
          // findEmployeeRequisition: '', // 员工申请
          findActivityManage: '', // 活动管理
          findAdviserInvitation: '', // 顾问管理
          findEvaluateManage: '', // 评价管理
          findReportedData: '', // 数据上报
          findRequirementManage: '' // 需求管理
        },
        messageData: {
          company: {  // 企业邀请
            data: {},
            messageTowTort: 8
          },
          organization: { // 机构邀请
            data: {},
            messageTowTort: 7
          }
        },
        requestList: []
      }
    },
    filters: {
      wrapNumber(str) {
        if (!str) {
          return ''
        }
        return str.replace(/\d+/g, function () {
          return `<span style="color: #00a041">${ arguments[0] }</span>`
        })
      }
    },
    created() {
      this.init()
    },
    methods: {
      init() {
        this.getUserInfo()
        this.getCardData()
        this.getMessage()
      },
      getMessage() {
        for (const key in this.messageData) {
          this.api.get({
            url: 'getMessageList',
            data: {
              integer: '',
              messageTowTort: this.messageData[key].messageTowTort
            },
            callback: (res) => {
              if (res.code === "0000") {
                this.messageData[key].data = res.data && res.data.rows && res.data.rows.length > 0 ? res.data.rows[0] : {}
              } else {
                this.$message.error(res.result)
              }
            }
          })
        }
      },
      getCardData() {
        for (const key in this.cardData) {
          const p = new Promise((resolve, reject) => {
            this.api.get({
              url: key,
              callback: (res) => {
                if (res.code === "0000") {
                  this.cardData[key] = res.data
                  resolve()
                } else {
                  this.$message.error(res.result)
                  reject()
                }
              }
            })
          })
          this.requestList.push(p)
        }
        Promise.all(this.requestList)
          .then(list => {
            this.loading = false
          })
      },
      getUserInfo() {
        this.userInfo = JSON.parse(window.sessionStorage.getItem('userInfo'))
      }
    }
  }
</script>
<style lang="scss" scoped>
  @import "~@/css/r-common";
  @import "~@/css/common";
  .user-center {
    color: #333333;

    .user-header {
      padding: 32px;
      background-color: #fff;
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

        .tag-list:last-of-type {
          margin-right: 0;
        }
      }
    }
  }
</style>

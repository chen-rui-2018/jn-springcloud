<template>
  <div class="park_Notice">
    <div class="noticeTit">
      <el-breadcrumb>
        <el-breadcrumb-item>{{this.$route.meta.title}}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="noticeContent" v-if="messageList.length>0">
      <ul>
        <li class="noticeLi clearfix" v-for="(item,index) in messageList" :key="index">
          <div class="liTit">
            <i class="iconfont icon-yuandian yuandian1" v-if="item.isRead=='0'&&showFlag!=item.id"></i>
            <i class="noYuandian" v-else></i>
            <span class="color1 notice">{{item.messageTitle}}</span>
            <span class="mesTime color3">{{item.createdTime}}</span>
            <i class="el-icon-arrow-up fr pointer" v-if="showFlag==item.id" @click="showFlag='';item.isRead = '1'"></i>
            <i class="el-icon-arrow-down fr pointer" v-else @click="readMes(item)"></i>
          </div>
          <p class="color2" v-if="showFlag==item.id">{{item.messageContent}}</p>
        </li>
      </ul>
    </div>
    <div class="noticeContent ct" v-else>
      暂无消息！
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      messageList: [],
      messageOneTort: 1,
      messageTowTort: 1,
      showFlag: "",
    };
  },
  created() {
    this.getName();
  },
  mounted() {
    // this.getMessageOneTort();
    // this.getMessageList();
  },
  methods: {
    //判断跳转过来的路径
    getName() {
      if (this.$route.name == "parkNotice") {
        this.messageTowTort = 1;
        this.messageOneTort = 0;
        this.getMessageOneTort();
        this.getMessageList();
      } else if (this.$route.name == "enterpriseOrder") {
        this.messageTowTort = 2;
        this.messageOneTort = 1;
        this.getMessageOneTort();
        this.getMessageList();
      } else if (this.$route.name == "informationDynamics") {
        this.messageTowTort = 3;
        this.messageOneTort = 1;
        this.getMessageOneTort();
        this.getMessageList();
      } else if (this.$route.name == "paymentReminder") {
        this.messageTowTort = 4;
        this.messageOneTort = 1;
        this.getMessageOneTort();
        this.getMessageList();
      } else if (this.$route.name == "guestbook") {
        this.messageTowTort = 5;
        this.messageOneTort = 1;
        this.getMessageOneTort();
        this.getMessageList();
      } else if (this.$route.name == "dataReminder") {
        this.messageTowTort = 6;
        this.messageOneTort = 1;
        this.getMessageOneTort();
        this.getMessageList();
      } else if (this.$route.name == "corporateInvitation") {
        this.messageTowTort = 8;
        this.messageOneTort = 0;
        this.getMessageOneTort();
        this.getMessageList();
      } else if (this.$route.name == "corporateInvitation") {
        this.messageTowTort = 7;
        this.messageOneTort = 0;
        this.getMessageOneTort();
        this.getMessageList();
      }
    },
    readMes(item) {
      this.showFlag = item.id;
      item.isRead = "1";
       this.api.post({
        url: "updateIsReadStatus",
        data: {
          id: item.id
        },
        callback: res => {
          if (res.code === "0000") {
            // this.$message(res.result);
            // this.getMessageList()
          } 
        }
      });
      
    },
    //获取消息列表
    getMessageList() {
      this.api.get({
        url: "getMessageList",
        data: {
          messageTowTort: this.messageTowTort
        },
        callback: res => {
          if (res.code === "0000") {
            this.messageList = res.data.rows;
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    //获取二级消息类别
    getMessageOneTort() {
      this.api.get({
        url: "getMessageOneTort",
        data: {
          messageOneTort: this.messageOneTort
        },
        callback: res => {
          if (res.code === "0000") {
            // this.messageList = res.data.rows[0].messageListModels;
          } else {
            this.$message.error(res.result);
          }
        }
      });
    }
  },
  watch: {
    $route() {
      this.getName();
    }
  }
};
</script>
<style lang="scss">
.park_Notice {
  .message-center-main {
    padding: 0;
  }
  .el-breadcrumb__inner {
    padding: 13px;
    border-bottom: 2px solid #00a041;
    font-size: 16px;
  }
  .noticeTit {
    background-color: #fff;
    padding: 17px;
    font-size: 13px;
    border-radius: 5px;
  }
  .noticeContent {
    margin-top: 14px;
    background-color: #fff;
    padding: 17px;
    .noticeLi {
      border-bottom: 1px solid #eee;
      padding: 20px 0;
      .notice {
        font-size: 15px;
        margin-right: 10px;
      }
      .mesTime {
        font-size: 12px;
      }
      > p {
        font-size: 13px;
        margin-top: 20px;
        padding-left: 20px;
        line-height: 20px;
        // overflow: hidden;
        // text-overflow: ellipsis;
        // white-space: nowrap;
      }
      .yuandian1 {
        color: red;
        font-size: 20px;
        display: inline-block;
        vertical-align: middle;
      }
      .noYuandian {
        display: inline-block;
        width: 20px;
        height: 20px;
        vertical-align: middle;
      }
    }
    .noticeLi:first-child {
      padding-top: 0;
    }
  }
}
</style>

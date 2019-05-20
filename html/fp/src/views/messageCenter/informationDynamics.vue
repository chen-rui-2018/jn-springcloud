<template>
    <div class="infomaDy">
        <div class="noticeTit">
            <span>信息发布动态</span>
        </div>
        <div class="noticeContent">
            <ul>
                <li class="noticeLi" v-for="(item,index) in messageList" :key="index">
                    <div class="liTit">
                        <i class="iconfont icon-yuandian yuandian1" v-if="item.isRead=='0'"></i>
                        <i class="iconfont icon-yuandian yuandian2" v-if="item.isRead=='1'"></i>
                        <span class="color1 notice">{{item.messageTitle}}</span>
                        <span class="mesTime color3">{{item.createdTime}}</span>
                    </div>
                    <p class="color2">{{item.messageContent}}</p>
                </li>
            </ul>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      messageList: [],
      page: 1,
      rows: 5
    };
  },
  mounted() {
    this.getMessageList();
  },
  methods: {
    getMessageList() {
      this.api.get({
        url: "getMessageList",
        data: {
        //   isRead: 0,
          page: this.page,
          rows: this.rows,
          messageOneTort: 0,
          messageTowTort: 3
        },
        callback: res => {
          if (res.code === "0000") {
            this.messageList = res.data.rows[0].messageListModels;
          } else {
            reject();
            this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.infomaDy {
  .message-center-main {
    padding: 0;
  }
  .noticeTit {
    background-color: #fff;
    padding: 17px;
    font-size: 13px;
    border-radius: 5px;
    span {
      padding: 15px 10px;
      border-bottom: 2px solid #00a041;
    }
  }
  .noticeContent {
    margin-top: 14px;
    background-color: #fff;
    padding: 17px;
    .noticeLi {
      border-bottom: 1px solid #eee;
      padding: 20px 0;
      .notice {
        font-size: 13px;
        margin-right: 10px;
      }
      .mesTime {
        font-size: 12px;
      }
      > p {
        font-size: 13px;
        margin-top: 20px;
        padding-left: 20px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
      }
      .yuandian1 {
        color: red;
      }
      .yuandian2 {
        color: #00a041;
      }
    }
    .noticeLi:first-child {
      padding-top: 0;
    }
  }
}
</style>

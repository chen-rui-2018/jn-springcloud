<template>
  <div class="chat-win">
    <div class="chat-header">
      <div class="chat-back">
        <i class="el-icon-arrow-left"></i>
      </div>
      <div class="chat-title">与xxx的聊天</div>
    </div>
    <div class="chat-main">
      <div class="tc">
        <div class="date-tips">04/04</div>
      </div>
      <message-row></message-row>
      <message-row type="right"></message-row>
    </div>
    <div class="chat-footer">
      <avatar class="flex-none"></avatar>
      <div class="chat-footer-right">
        <el-input
          type="textarea"
          :rows="2"
          placeholder="请输入内容"
          v-model="message">
        </el-input>
        <el-button :type="message ? 'primary' : '' " class="send-message">回复</el-button>
      </div>
    </div>
  </div>
</template>

<script>
  import messageRow from './common/messageRow'
  import avatar from './common/avatar'
  export default {
    name: "ChatWin",
    components: {
      messageRow,
      avatar
    },
    data() {
      return {
        message: ''
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "~@/css/r-common";
  @import "~@/css/common";
  .chat-win {
    width: 100%;

    .chat-header {
      @include flex($h: flex-start, $v: stretch);
      height: 50px;
      background-color: #fff;

      .chat-back {
        width: 25%;
        @include flex($h: flex-start);
        padding-left: 20px;
      }

      .chat-title {
        width: 50%;
        @include flex-center;
      }
    }

    .chat-main {
      height: 450px;
      padding: 20px;
      margin-top: 2px;
      background-color: #fff;
      overflow: auto;

      .date-tips {
        display: inline-block;
        width: 90px;
        font-size: 12px;
        border-radius: 4px;
        padding: 2px 0;
        background-color: #B3B3B3;
        color: #fff;
      }
    }

    .chat-footer {
      height: 120px;
      margin-top: 2px;
      padding: 20px;
      background-color: #fff;
      @include flex($h: flex-start, $v: flex-start);

      .chat-footer-right {
        margin-left: 20px;
        flex: 1;
        text-align: right;

        .send-message {
          margin-top: 20px;
        }
      }
    }
  }
</style>

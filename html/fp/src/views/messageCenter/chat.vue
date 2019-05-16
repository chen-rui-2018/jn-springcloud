<template>
    <div class="message-chat">
      <div class="chat-win">
        <div class="chat-header">
          <div class="chat-back">
            <i class="el-icon-arrow-left"></i>
          </div>
          <div class="chat-title">与xxx的聊天</div>
        </div>
        <div class="chat-main"></div>
        <div class="chat-footer"></div>
      </div>
      <div class="friend-list"></div>
    </div>
</template>

<script>
export default {
  name: "Chat"
}
</script>

<style lang="scss" scoped>
  @import "~@/css/r-common";
  @import "~@/css/common";
  .message-chat {
    .chat-win {
      width: 100%;
      background-color: #fff;
      .chat-header {
        @include flex($h: flex-start, $v: stretch);
        height: 50px;
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
        margin-top: 2px;
        height: 350px;
      }
    }
    @include flex($h: flex-start, $v: flex-start);
    .friend-list {
      width: 200px;
      height: 500px;
      flex: none;
      overflow: auto;
      margin-left: 2px;
      background-color: #fff;
    }
  }
</style>

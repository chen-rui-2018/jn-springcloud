<template>
  <div class="message-row" :class="type">
    <avatar :url="url" class="flex-none"></avatar>
    <div class="message-blank-20"></div>
    <div class="message-row-right">
      <div>
        <tips :text="message" :type="type === 'left' ? 'left' : 'right'"></tips>
<!--        <div class="message-delete" @click="deleteMessage">删除</div>-->
      </div>
      <span>
        <i v-if="status === 'fail'" class="message-warning el-icon-warning" @click="reSend"></i>
        <i v-if="status === 'sending'" class="message-loading el-icon-loading"></i>
      </span>
      <div class="message-blank">
      </div>
      <div class="message-time">{{ time }}</div>
    </div>
  </div>
</template>

<script>
  import avatar from './avatar'
  import tips from './tips'

  export default {
    name: "messageRow",
    props: {
      type: {
        type: String,
        required: false,
        default: 'left'
      },
      status: {
        type: [String, Boolean],
        required: false,
        default: false
      },
      url: {
        type: String,
        required: false
      },
      message: {
        type: String,
        required: true
      },
      time: {
        type: [String, Number],
        required: true
      },
      onDelete: {
        type: Function,
        required: false,
        default() {}
      },
      onResend: {
        type: Function,
        required: false,
        default() {}
      }
    },
    components: {
      avatar,
      tips
    },
    methods: {
      deleteMessage() {
        this.onDelete()
      },
      reSend() {
        this.onResend()
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "~@/css/r-common";
  @import "~@/css/common";

  .message-row {
    margin-top: 20px;
    @include flex($h: flex-start, $v: flex-start);

    &.right {
      flex-direction: row-reverse;

      .message-row-right {
        flex-direction: row-reverse;
      }
      .message-row-right {
        .message-delete {
          text-align: left;
        }
      }
    }

    .message-row-right {
      max-width: 70%;
      @include flex($h: flex-start, $v: flex-start);
      .message-delete {
        text-align: right;
        font-size: 10px;
        padding: 10px 0;
        color: #999;
        cursor: pointer;
      }
    }
    .message-blank-20 {
      width: 20px;
      height: 1px;
    }
    .message-blank {
      width: 16px;
      height: 1px;
      flex: none;
    }
    .message-loading,
    .message-warning{
      padding: 0 6px;
      margin-top: 11px;
      text-align: center;
      flex: none;
    }
    .message-warning {
      color: #f56c6c;
      cursor: pointer;
    }
    .message-time {
      margin-top: 13px;
      color: #999;
      font-size: 10px;
      flex: none;
    }
  }
</style>

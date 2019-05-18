<template>
  <div class="message-chat">
    <div class="chat-win">
      <div class="chat-header">
        <div class="chat-back">
          <i class="el-icon-arrow-left"></i>
        </div>
        <div class="chat-title">{{ $route.query.nickName }}的对话</div>
      </div>
      <div ref="chatMain" class="chat-main">
        <div class="no-more" v-if="noMore">没有更多消息了</div>
        <div class="tc" v-if="loading">
          <i class="el-icon-loading"></i>
          <span>正在加载...</span>
        </div>
        <!--          <div class="tc">-->
        <!--            <div class="date-tips">04/04</div>-->
        <!--          </div>-->
        <message-row
          v-for="(item, index) in messageList"
          :key="index"
          :message="item.content.msg"
          :time="item.sendTime | formatTime"
          :on-delete="deleteMessage"
          :type="item.msgType === '0000' ? 'right' : 'left'"
          :url="item.content.url"
        />
      </div>
      <div class="chat-footer" v-if="!$store.state.isMobile">
        <avatar class="flex-none"></avatar>
        <div class="chat-footer-right">
          <el-input
            v-model="message"
            :rows="2"
            :maxlength="600"
            type="textarea"
            @keyup.native.enter.prevent="messageSend"
            placeholder="请输入内容"
          />
          <el-button
            :type="message ? 'primary' : '' "
            class="send-message"
            @click="messageSend"
          >回复
          </el-button>
        </div>
      </div>
      <div v-else class="app-chat-footer">
        <el-input
          v-model="message"
          type="textarea"
          :rows="1"
          :autosize="{ minRows: 1, maxRows: 4 }"
          placeholder="请输入内容"
          class="app-input"
        />
        <el-button size="mini" @click="messageSend">发送</el-button>
      </div>
    </div>
    <div v-if="$store.state.needNav" class="friend-list">
      <div class="friend-list-header">私信列表</div>
      <router-view></router-view>
      <div class="friend-list-main">
        <div
          v-for="(item, index) in userList"
          :key="item.id"
          class="friend-chat"
          @click="tabChat(item)">
          <avatar class="flex-none" size="small"></avatar>
          <div class="friend-row">
            <div class="friend-info">
              <div class="friend-name">{{ item.content.nickName }}</div>
              <div class="chat-time">
                {{ item.sendTime | formatTime }}
                <!--                  <span>星期二</span>-->
                <!--                  <span>10:32</span>-->
              </div>
            </div>
            <div class="message-content">{{ item.content.msg}}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {isArray} from '@/util'
  import avatar from './common/avatar'
  import messageRow from './common/messageRow'
  import axios from 'axios'

  export default {
    name: "Chat",
    components: {
      messageRow,
      avatar
    },
    data() {
      return {
        websocket: null,
        messageList: [],
        message: '',
        userList: [],
        param: {
          id: '',
          fromUser: '',
          toUser: '',
          page: 1,
          rows: 10
        },
        loading: false,
        currentHeight: 0,
        lastHeight: 0,
        noMore: false,
      }
    },
    mounted() {
      this.init()
    },
    filters: {
      formatTime(d) {
        let td = new Date();
        td = new Date(td.getFullYear(), td.getMonth(), td.getDate());
        let od = new Date(d);
        const year = od.getFullYear()
        let mon = od.getMonth() + 1
        mon = mon > 10 ? mon : '0' + mon
        let day = od.getDate()
        day = day > 10 ? day : '0' + day
        let hour = od.getHours()
        hour = hour > 10 ? hour : '0' + hour
        let min = od.getMinutes()
        min = min > 10 ? min : '0' + min

        od = new Date(year, od.getMonth(), day);
        const xc = (od - td) / 1000 / 60 / 60 / 24;

        let tips
        if (xc < -2) {
          if (xc < -7) {
            if (year === new Date().getFullYear()) {
              tips = mon + '-' + day + ' ' + hour + ':' + min
            } else {
              tips = year + '-' + mon + '-' + day + ' ' + hour + ':' + min
            }
          } else {
            tips = -xc + '天前'
          }
        } else if (xc < -1) {
          tips = '前天'
        } else if (xc < 0) {
          tips = '昨天'
        } else if (xc === 0) {
          tips = '今天'
        } else if (xc < 2) {
          tips = '明天'
        } else if (xc < 3) {
          tips = '后天'
        } else {
          tips = xc + '天后'
        }
        return tips + ' ' + hour + ':' + min
      }
    },
    methods: {
      init() {
        if (!this.$route.query.fromUser) {
          this.$message.error('缺少发送人id')
          return
        }
        if (!this.$route.query.toUser) {
          this.$message.error('缺少接收人id')
          return
        }if (!this.$route.query.nickName) {
          this.$message.error('缺少接收人昵称')
          return
        }

        this.param.fromUser = this.$route.query.fromUser
        this.param.toUser = this.$route.query.toUser
        if (!this.param.toUser) {
          return
        }
        this.connect()
        this.getUserList()
        this.getHistoryMessage()
          .then(this.setScrollTop, error => [
            console.dir(error)
          ])
        this.checkHistoryMessage()
      },
      setScrollTop() {
        this.lastHeight = this.$refs.chatMain.scrollHeight
        this.$nextTick(() => {
          this.$refs.chatMain.scrollTop = this.$refs.chatMain.scrollHeight
          this.currentHeight = this.$refs.chatMain.scrollHeight
        })
      },
      checkHistoryMessage() {
        const chatMain = this.$refs.chatMain
        chatMain.addEventListener('scroll', event => {
          const top = chatMain.scrollTop
          if (top <= 0 && !this.loading && !this.noMore) {
            this.param.page++
            this.getHistoryMessage()
              .then(() => {
                this.$refs.chatMain.scrollTop = this.$refs.chatMain.scrollHeight - this.lastHeight
              })
          }
        })
      },
      messageSend() {
        if (!this.message) {
          return
        }
        let data = {
          fromUser: this.param.fromUser,
          toUser: this.param.toUser,
          nickName: this.$route.query.nickName,
          msg: this.message,
          url: 'http://img.52z.com/upload/news/image/20180801/20180801112618_87503.jpg'
        }
        data = JSON.stringify(data)
        this.websocket.send(data)
        this.message = ''
        this.setScrollTop()
      },
      getHistoryMessage() {
        return new Promise((resolve, reject) => {
          if (this.loading) {
            return
          }
          this.loading = true
          axios({
            method: 'post',
            url: 'http://192.168.10.31:8888/im/selectMsg',
            data: this.param
          })
            .then(res => {
              const data = res.data
              if (data.code === '0000') {
                this.lastHeight = this.$refs.chatMain.scrollHeight
                const historyList = this.formatJson(data.data.rows).reverse()
                this.noMore = Math.ceil(data.data.total / this.param.rows) === this.param.page
                this.messageList = historyList.concat(this.messageList)
                if (this.messageList.length > 0) {
                  this.param.id = historyList[0].id
                }
                resolve()
              } else {
                reject()
                this.$message.error(data.result)
              }
              this.loading = false
            })
        })
      },
      getUserList() {
        const param = {
          ...this.param
        }
        delete param.toUser
        axios({
          method: 'post',
          url: 'http://192.168.10.31:8888/im/selectMsgList',
          data: this.param
        })
          .then(res => {
            this.userList = this.formatJson(res.data.data.rows)
          })
      },
      formatJson(arr) {
        return arr.map(item => {
          item.content = JSON.parse(item.content)
          return item
        })
      },
      connect() {
        const vm = this
        if (!window.WebSocket) {
          alert("您的浏览器版本太低，请升级浏览器版本！")
          return
        }
        const wsUrl = "ws://192.168.10.31:8888/websocket"
        const token = "IM_123_qwe**_X_Q"
        this.websocket = new WebSocket(wsUrl + "/" + this.param.fromUser + "/" + token + "?accessToken=123qwe")
        //连接成功建立的回调方法
        this.websocket.onopen = function (event) {
          console.dir('open')
        }

        //接收到消息的回调方法
        this.websocket.onmessage = event => {

          const data = JSON.parse(event.data)
          console.dir(data)
          if (isArray(data) === 'Object') {
            data.content = JSON.parse(data.content)
            if ((data.msgType === '0000' || data.msgType === '1111') && (data.sendId === this.param.toUser || data.sendId === this.param.fromUser)) {
              vm.messageList.push(data)
              this.setScrollTop()
            }
          }
        }

        //连接关闭的回调方法
        this.websocket.onclose = function () {
          console.log(" websocket.onclose :close");
        }

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
          this.websocket.close()
        }
        //连接发生错误的回调方法
        this.websocket.onerror = function () {
          console.log(" websocket.onerror :error");
        }
      },
      tabChat(item) {
        this.$router.push({
          path: '/messageCenter/chat',
          query: {
            nickName: item.content.nickName,
            toUser: item.id,
          }
        })
      },
      deleteMessage() {
        console.dir('delete')
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "~@/css/r-common";
  @import "~@/css/common";
  $bg-gray: #f3f3f3;
  .message-chat {
    color: #333;
    font-size: 14px;
    @include flex($h: flex-start, $v: flex-start);
    width: 100%;
    .chat-win {
      width: 100%;

      .chat-header {
        @include flex($h: flex-start, $v: stretch);
        width: 100%;
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
        height: 400px;
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
      .app-chat-footer {
        width: 100%;
        padding: 10px;
        position: absolute;
        left: 0;
        bottom: 0;
        background-color: $bg-gray;
        box-sizing: border-box;
        @include flex($h: space-between,$v: flex-end);
        .app-input {
          width: 80%;
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

    .friend-list {
      width: 230px;
      flex: none;
      overflow: auto;
      margin-left: 2px;

      .friend-list-header {
        height: 50px;
        padding-left: 20px;
        @include flex($h: flex-start);
        background-color: #fff;
      }

      .friend-list-main {
        margin-top: 2px;
        height: 602px;
        overflow: auto;
        background-color: #fff;

        .friend-chat {
          padding: 20px;
          margin-bottom: 2px;
          font-size: 13px;
          background-color: #F1F1F1;
          cursor: pointer;
          transition: .3s;
          @include flex($h: flex-start, $v: flex-start);

          &:hover {
            background-color: #fafafa;
            transition: .3s;
          }

          &:last-of-type {
            margin-bottom: 0;
          }

          .friend-row {
            width: 154px; // 随便写个值，作用的是flex:1
            flex: 1;
            @include flex($h: space-between, $v: flex-start);
            margin-left: 8px;
            flex-direction: column;

            .friend-info {
              width: 100%;
              height: 32px;
              @include flex($h: space-between);

              .friend-name {
                width: 60px;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
              }

              .chat-time {
                font-size: 12px;
                color: #999;
              }
            }

            .message-content {
              width: 100%;
              color: #999;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
            }
          }
        }
      }
    }

    .no-more {
      text-align: center;
      color: #999;
      font-size: 12px;
    }
  }
</style>
<style>
  .app-input.el-textarea__inner {
    border-radius: 50px !important;
  }
</style>

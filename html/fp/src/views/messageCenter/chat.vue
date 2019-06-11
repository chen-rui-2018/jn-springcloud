<template>
  <div class="message-chat">
    <div class="chat-win">
      <div v-if="$route.query.toUser" class="chat-win-cell">
        <div class="chat-header">
          <div class="chat-back">
            <i class="el-icon-arrow-left"></i>
          </div>
          <div class="chat-title">与 {{ toUserNickName }} 的对话</div>
        </div>
        <div ref="chatMain" class="chat-main">
          <div class="no-more" v-if="noMore">没有更多消息了</div>
          <div class="tc" v-if="loading">
            <i class="el-icon-loading"></i>
            <span>正在加载...</span>
          </div>
          <div
            v-for="(item, index) in messageList"
            :key="index">
            <div v-if="item.showCreateTime" class="tc">
              <div class="date-tips">{{ item.showCreateTime | formatTime }}</div>
            </div>
            <message-row
              :message="item.content.msg"
              :on-delete="deleteMessage"
              :on-resend="() => { reSend(item) }"
              :type="item.msgType === '0000'|| item.sendId === param.fromUser ? 'right' : 'left'"
              :url="item.sendId === param.fromUser ? url : toUrl"
              :status="item.status"
            />
          </div>

        </div>
        <div class="chat-footer" v-if="!$store.state.isMobile">
          <avatar class="flex-none" :url="url"></avatar>
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
      <div v-else-if="!$route.query.toUser && !$store.state.isMobile" class="no-chat">选择一个好友开始聊天吧</div>
    </div>
    <div v-if="$store.state.hiddenNav" class="friend-list">
      <div class="friend-list-header">私信列表</div>
      <router-view></router-view>
      <div class="friend-list-main">
        <div
          v-for="(item, index) in userList"
          :key="item.id"
          class="friend-chat"
          @click="tabChat(item)">
          <avatar :url="item.content.url" class="flex-none" size="small"></avatar>
          <div class="friend-row">
            <div class="friend-info">
              <div class="friend-name">{{ item.content.nickName }}</div>
              <div class="chat-time">
                {{ item.createTime | formatTime }}
                <!--                  <span>星期二</span>-->
                <!--                  <span>10:32</span>-->
              </div>
            </div>
            <div class="message-content">
              <span v-if="item.issended === 'N'" class="unread"></span>
              <span>{{ item.content.msg}}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import { isArray, getDateString } from '@/util'
  import avatar from './common/avatar'
  import messageRow from './common/messageRow'
  import sockHttp from '@/util/sockHttp'
  import { WS_URL } from '@/util/url'
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
        userListParam: {
          fromUser: '',
          page: 1,
          rows: 500
        },
        url: '',
        toUrl: '',
        nickName: '',
        toUserNickName: '',
        loading: false,
        currentHeight: 0,
        lastHeight: 0,
        noMore: false,
        tempMessageList: [],
        loaded: false,
        lastMessageSendTime: ''
      }
    },
    mounted() {
      this.$nextTick(
        this.init()
      )
    },
    watch: {
      '$route'() {
        this.$nextTick(
          this.init()
        )
      }
    },
    filters: {
      formatTime(d) {
        if (!d) {
          return ''
        }
        let td = new Date()
        td = new Date(td.getFullYear(), td.getMonth(), td.getDate())
        let od = new Date(d)
        const year = od.getFullYear()
        let mon = od.getMonth() + 1
        mon = mon > 9 ? mon : '0' + mon
        let day = od.getDate()
        day = day > 9 ? day : '0' + day
        let hour = od.getHours()
        hour = hour > 9 ? hour : '0' + hour
        let min = od.getMinutes()
        min = min > 9 ? min : '0' + min

        od = new Date(year, od.getMonth(), day)
        const xc = (od - td) / 1000 / 60 / 60 / 24;

        let tips
        if (xc < -2) {
          if (xc < -7) {
            if (year === new Date().getFullYear()) {
              return tips = mon + '-' + day + ' ' + hour + ':' + min
            } else {
              return tips = year + '-' + mon + '-' + day + ' ' + hour + ':' + min

            }
          } else {
            tips = -xc + '天前'
          }
        } else if (xc === -2) {
          tips = '前天'
        } else if (xc === -1) {
          tips = '昨天'
        } else if (xc === 0) {
          tips = ''
        } else if (xc === 1) {
          tips = '明天'
        } else if (xc === 2) {
          tips = '后天'
        } else {
          tips = xc + '天后'
        }
        return tips + ' ' + hour + ':' + min
      }
    },
    methods: {
      init() {
        /*  1.app路由要求传参发送人账号fromUser, 接收人账号toUser, 发送人昵称nickName(仅用于对话框显示与xxx在聊天)
         *  2.pc端路由参数可以只有发送人账号fromUser, 因为pc端有联系人列表
         */
        const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))

        this.userListParam.fromUser = this.param.fromUser = this.$route.query.fromUser || userInfo.account
        if (!this.param.fromUser) {
          this.$message.error('缺少发送人账号')
          return
        }
        this.toUserNickName = this.$route.query.nickName
        this.getFromUserInfo()
          .then(() => {
            this.connect()
            this.getUserList()
          })
        // 如果路由参数有接收人账号才去获取第一页历史消息
        if (this.$route.query.toUser) {
          this.param.toUser = this.$route.query.toUser
          this.getHistoryMessage()
            .then(this.setScrollTop, error => [
              console.dir(error)
            ])
          // 注册滚动加载历史消息事件
          this.checkHistoryMessage()
          this.resetWindowScrollTop()
        }
      },
      resetWindowScrollTop() {
        window.addEventListener('blur', () => {
          // alert('blur');
          setTimeout(() => {
            if (document.hasFocus()) {
              let activeElName = document.activeElement.tagName.toLowerCase();
              if (activeElName === 'input' || activeElName === 'textarea') {
                return;
              }
            }
            window.scrollTo(0, document.documentElement.clientHeight);
          }, 20)
        }, true)

        // 输入文字的时候，安卓浏览键盘默认不会把聚焦的输入框顶起，这里把输入框滚上去
        if(/Android 4\.[0-3]/.test(navigator.appVersion)){
          window.addEventListener("resize", function(){
            if(document.activeElement.tagName=="INPUT"){
              window.setTimeout(function(){
                document.activeElement.scrollIntoViewIfNeeded();
              },0);
            }
          })
        }
      },
      getFromUserInfo() {
        return new Promise(resolve => {
          this.api.get({
            url: "getUserPersonInfo",
            data: {
              account: this.param.fromUser
            },
            callback:(res) => {
              if (res.code === "0000") {
                const data = res.data
                this.url = data.avatar
                this.nickName = data.nickName
                resolve()
              } else {
                this.$message.error(res.result);
              }
            }
          })
        })
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
        chatMain && chatMain.addEventListener('scroll', event => {
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
      messageSend(event, msg) {
        const message = msg || this.message
        console.dir(message)
        if (!message) {
          return
        }
        const now = getDateString()
        const chatSendId = now + Math.floor(1000000 * Math.random())
        let data = {
          fromUser: this.param.fromUser,
          toUser: this.param.toUser,
          nickName: this.nickName,
          msg: message,
          chatSendId: chatSendId,
          url: this.url
        }
        const json = {
          content: {
            fromUser: this.param.fromUser,
            toUser: this.param.toUser,
            nickName: this.nickName,
            msg: message,
            chatSendId: chatSendId,
            url: this.url
          },
          createTime: now,
          id: '',
          isSended: '',
          msgType: '0000',
          receiveId: this.param.toUser,
          sendId: this.param.fromUser,
          sendTime: now,
          status: 'sending'
        }
        this.timeShowFilter(json)
        this.messageList.push(json)
        this.tempMessageList.push(json)
        data = JSON.stringify(data)
        this.websocket.send(data)
        this.message = ''
        this.setScrollTop()
      },
      reSend(item) {
        this.messageSend(1, item.content.msg)
      },
      getHistoryMessage() {
        return new Promise((resolve, reject) => {
          if (this.loading) {
            return
          }
          this.loading = true
          sockHttp.post('/im/selectMsg', this.param)
            .then(data => {
              if (data.code === '0000') {
                this.lastHeight = this.$refs.chatMain.scrollHeight
                const historyList = this.formatJson(data.data.rows).reverse()
                this.noMore = historyList.length < this.param.rows
                this.messageList = historyList.concat(this.messageList)
                // 去除同一天同一个小时同一分钟的消息重复的时间
                for (const message of this.messageList) {
                  this.timeShowFilter(message)
                }
                if (historyList && historyList.length > 0) {
                  this.param.id = historyList[0].id
                  if (!this.toUrl) {
                    for (let i = historyList.length - 1; i >= 0; i--) {
                      const item = historyList[i]
                      if (item.content.fromUser === this.param.toUser) {
                        this.toUrl = item.content.url
                        break
                      }
                    }
                  }
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
        sockHttp.post('/im/selectMsgList', this.userListParam)
          .then(res => {
            this.userList = this.formatJson(res.data.rows)
          })
      },
      timeShowFilter(message) {
        const prevTime = message.createTime.substring(0,16)
        if (this.lastMessageSendTime === prevTime) {
          message.createTime = ''
          this.$set(message, 'showCreateTime', '')
        } else {
          this.lastMessageSendTime = prevTime
          this.$set(message, 'showCreateTime', prevTime)
        }
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
        const wsUrl = WS_URL + '/websocket'
        const token = "IM_123_qwe**_X_Q"
        this.websocket = new WebSocket(wsUrl + "/" + this.param.fromUser + "/" + token + "?accessToken=123qwe")
        //连接成功建立的回调方法
        this.websocket.onopen = function (event) {

        }

        //接收到消息的回调方法
        this.websocket.onmessage = event => {

          const data = JSON.parse(event.data)
          if (isArray(data) === 'Object') {
            data.content = JSON.parse(data.content)
            if (data.msgType === '0000' || data.msgType === '1111') {
              this.getUserList()
              if (data.sendId === this.param.toUser || data.sendId === this.param.fromUser) {
                // 如果发送或者接收成功
                const isMine = this.tempMessageList.some((item, index) => {
                  // 如果是刚刚自己发的那条信息，证明发送成功，只需要把发送状态设置成发送成功，不需要再放到消息列表
                  if (item.content.chatSendId === data.content.chatSendId) {
                    item.status = 'success'
                    // 状态改变后，不需要后续逻辑操作，把消息从自己发送的临时列表里删除
                    this.tempMessageList.splice(index, 1)
                    return true
                  }
                })
                // console.dir(isMine)
                // 如果不是自己发的，那么就接收，并放到消息列表
                if (!isMine) {
                  this.toUrl = data.content.url
                  this.timeShowFilter(data)
                  vm.messageList.push(data)
                  this.setScrollTop()
                }
              } else {
                // 如果失败了，找到自己发送的那条，并把状态设置成功为失败
                this.tempMessageList.forEach((item, index) => {
                  if (item.content.chatSendId === data.content.chatSendId) {
                    item.status = 'fail'
                    // 状态改变后，不需要后续逻辑操作，把消息从自己发送的临时列表里删除
                    this.tempMessageList.splice(index, 1)
                  }
                })
              }
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
          path: '/chat',
          query: {
            toUser: item.sendId,
            fromUser: this.param.fromUser,
            nickName: item.content.nickName
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
          background-color: #ccc;
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
              font-size: 12px;
              .unread {
                $size: 8px;
                display: inline-block;
                width: $size;
                height: $size;
                border-radius: 50%;
                background-color: #f56c6c;
              }
            }
          }
        }
      }
    }

    .no-more {
      text-align: center;
      color: #999;
      font-size: 12px;
      padding: 10px;
    }
    .no-chat {
      width: 100%;
      height: 654px;
      color: #666;
      background-color: #fff;
      @include flex-center;
    }
  }
</style>
<style>
  .app-input.el-textarea__inner {
    border-radius: 50px !important;
  }
</style>

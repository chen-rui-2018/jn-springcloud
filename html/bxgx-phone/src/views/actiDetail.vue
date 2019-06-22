<template>
  <div class="actiDetail">
    <div class="actiImg">
      <img :src="actiForm.actiPosterUrl" alt="">
    </div>
    <div class="actiTit">{{actiForm.actiName}}</div>
    <div class="actiTime">
      <div class="timeTit">报名截止还剩</div>
      <div class="timeSecond">
        <span class="time1 time2">{{d}}</span>
        <span class="date1">天</span>
        <span class="time1">{{h}}</span>
        <span class="date1">小时</span>
        <span class="time1">{{m}}</span>
        <span class="date1">分</span>
        <span class="time1">{{s}}</span>
        <span class="date1">秒</span>
        <!-- {{CountDown}} -->
        <!-- {{ `${d}天 ${h}小时 ${m}分钟 ${s}秒` }} -->
      </div>
    </div>
    <div class="actiInfo">
      <ul class="applyInfo">
        <li>
          <img src="@/./assets/images/gerenyonghutouxiang2.png" alt="">
          <span class="liName">{{actiForm.actiOrganizer}}</span>
        </li>
        <li>
          <img src="@/./assets/images/free.png" alt="">
          <span class="liName" v-if="actiForm.actiCost=='0.00'">免费</span>
          <span class="liName" v-else>收费</span>
        </li>
        <li>
          <img src="@/./assets/images/shijian.png" alt="">
          <span class="liName">{{actiForm.applyStartTime}}-{{actiForm.applyEndTime}}</span>
        </li>
        <li class="lastLi">
          <img src="@/./assets/images/renminbi.png" alt="">
          <span class="liName">{{actiForm.actiAddress}}</span>
        </li>
      </ul>
      <div class="applyImg">
        <ul class="applyUl clearfix">
          <li class="applyLi" v-if="activityApplyList!==null&&activityApplyList.length>0,i<5" v-for="(i,k) in activityApplyList" :key="k">
            <img :src="i.avatar" alt="">
          </li>
          <!-- <li claas="applyline"></li> -->
        </ul>
        <div class="applyNum">
          <span>......</span>
          <!-- <span>&hellip;</span> -->
          <span>{{actiForm.applyNum}}人已报名</span>
        </div>
      </div>
    </div>
    <div class="fenge"></div>
    <div class="actiDel">
      <div class="del1">详情</div>
      <p v-html="actiForm.actiDetail" v-if="actiForm.actiDetail"></p>
      <p v-else>暂无内容!</p>
    </div>
    <div class="actiFooter">
      <div class="attention">
        <img src="@/./assets/images/xin.png" v-if="accountIsLike" alt=" " @click="cancelLike(actiForm.id)">
        <img src="@/./assets/images/guanzhu.png" alt="" v-else @click="handleLike(actiForm.id)">
        <span class="att1">关注{{actiForm.actiLike}}</span>
      </div>
      <div class="attend ">
        <span class="stopJoin" v-if="activityApplyShow=='0'">停止报名</span>
        <span v-if="activityApplyShow=='1'" @click="quickSign(actiForm.id)">我要参加</span>
        <span v-if="activityApplyShow=='2'" @click="stopApply(actiForm.id)">取消报名</span>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      actiForm: {},
      activityApplyList: '',
      accountIsLike: false,
      sysTemTime: '',
      applyEndTime: '',
      d: 0,
      h: 0,
      m: 0,
      s: 0,
      CountDown: '',
      apply: {},
      activityApplyShow: '0'
    }
  },
  created () {
    this.actiDel()
  },
  mounted () {
  },
  destroyed () {
    clearInterval(this._interval)
  },
  methods: {
    dispatch (c, b) {
      try {
        var a = document.createEvent('Event')
        a.initEvent(b, true, true)
        c.dispatchEvent(a)
      } catch (d) {
        // alert(d)
      }
    },
    actiDel () {
      let _this = this
      this.api.post({
        url: 'getActivityDetails',
        data: {
          activityId: _this.$route.query.activityId
          // activityId: 'f5c95f9adf714aedab3739cbc9297178'
        },
        dataFlag: true,
        callback: function (res) {
          if (res.code === '0000') {
            _this.actiForm = res.data.activityDetail
            _this.apply = res.data
            _this.accountIsLike = res.data.accountIsLike
            _this.activityApplyShow = res.data.activityApplyShow
            _this.activityApplyList = res.data.activityApplyList
            _this.sysTemTime = _this.getTime(res.data.sysTemTime)
            _this.applyEndTime = _this.getTime(
              res.data.activityDetail.applyEndTime
            )
            _this._interval = setInterval(() => {
              let data = _this.countTime(_this.applyEndTime, _this.sysTemTime)
              _this.sysTemTime = _this.sysTemTime + 1000
              if (data) {
                clearInterval(_this._interval)
              }
            }, 1000)
          } else {
            _this.$vux.toast.text(res.result)
          }
        }
      })
    },
    handleLike (id) {
      if (!sessionStorage.token) {
        this.$vux.toast.text('请先登录')
        return
      }
      let _this = this
      this.api.post({
        url: 'activityLike',
        data: {
          activityId: id
        },
        dataFlag: true,
        callback: function (res) {
          if (res.code === '0000') {
            _this.$vux.toast.text('点赞成功')
            _this.actiForm.actiLike = _this.actiForm.actiLike * 1 + 1
            // _this.$message.success('点赞成功')
            _this.accountIsLike = true
            // window.location.href = 'protocol://android?code=toast&data=' + _this.actiForm.actiLike
            if (_this.$route.query.isMini) {

            } else {
              _this.dispatch(document.queryselector('.attention'), 'click')
              document.queryselector('.attention').click(_this.actiForm.actiLike)
              let action = 'handleLike'
              window.webkit.messageHandlers.jsToOc.postMessage(action, _this.actiForm.actiLike)
            }
          } else {
            _this.$vux.toast.text(res.result)
          }
        }
      })
    },
    cancelLike (id) {
      if (!sessionStorage.token) {
        this.$vux.toast.text('请先登录')
        return
      }
      let _this = this
      this.api.post({
        url: 'CancelLike',
        data: {
          activityId: id
        },
        dataFlag: true,
        callback: function (res) {
          if (res.code === '0000') {
            _this.$vux.toast.text('取消点赞成功')
            _this.actiForm.actiLike -= 1
            _this.accountIsLike = false
            // window.location.href =
            //   'protocol://android?code=toast&data=' + _this.actiForm.actiLike
            if (_this.$route.query.isMini) {

            } else {
              _this.dispatch(document.queryselector('.attention'), 'click')
              document.queryselector('.attention').click(_this.actiForm.actiLike)
              let action = 'cancelLike'
              window.webkit.messageHandlers.jsToOc.postMessage(action, _this.actiForm.actiLike)
            }
          } else {
            _this.$vux.toast.text(res.result)
          }
        }
      })
    },
    quickSign (id) {
      if (!sessionStorage.token) {
        this.$vux.toast.text('请先登录')
        return
      }
      let _this = this
      this.api.post({
        url: `springcloud-park/activity/activityApply/quickApply?activityId=${id}`,
        data: {
          activityId: id
        },
        urlFlag: true,
        callback: res => {
          if (res.code === '0000') {
            // alert(res.result)
            _this.activityApplyShow = '2'
            // this.actiDel()
          } else {
            _this.$vux.toast.text(res.result)
          }
        }
      })
    },
    // 取消报名
    stopApply (id) {
      if (!sessionStorage.token) {
        this.$vux.toast.text('请先登录')
        return
      }
      let _this = this
      this.api.post({
        url: `springcloud-park/activity/activityApply/cancelApply?activityId=${id}`,
        data: {
          activityId: id
        },
        urlFlag: true,
        callback: function (res) {
          if (res.code === '0000') {
            _this.activityApplyShow = '1'
            // _this.actiDel()
          } else {
            _this.$vux.toast.text(res.result)
          }
        }
      })
    },
    getTime (t) {
      return new Date(t).getTime()
    },
    countTime (applyTime, secondsTime) {
      // var secondsTime = new Date(this.sysTemTime).getTime()
      var leftTime = applyTime - secondsTime
      if (leftTime >= 0) {
        let d = Math.floor(leftTime / 1000 / 60 / 60 / 24)
        let h = Math.floor((leftTime / 1000 / 60 / 60) % 24)
        let m = Math.floor((leftTime / 1000 / 60) % 60)
        let s = Math.floor((leftTime / 1000) % 60)
        this.d = d
        this.h = h > 9 ? h : '0' + h
        this.m = m > 9 ? m : '0' + m
        this.s = s > 9 ? s : '0' + s
        // const that = this
        // setTimeout(function () {
        //   that.countTime()
        // }, 1000)
        return false
      } else {
        this.d = '0'
        this.h = '00'
        this.m = '00'
        this.s = '00'
        return true
      }
    }
  }
}
</script>
<style lang="scss" scoped>
.actiDetail {
  width: 100%;
  padding-bottom: 100px;
  // padding-top: 37px;
  .actiImg {
    // height: 357px;
    // height: 100%;
    width: 100%;
    background: #00a041;
    img {
      height: 100%;
      width: 100%;
    }
  }
  .actiTit {
    padding: 39px;
    color: #42454a;
    font-size: 36px;
  }
  .detail {
    text-align: center;
  }
  .actiTime {
    width: 90%;
    height: 180px;
    margin: 0 auto;
    box-shadow: 0px 2px 18px 0px rgba(121, 121, 121, 0.15);
    border-radius: 16px;
    text-align: center;
    .timeTit {
      color: #333;
      padding: 24px 0;
    }
    .time1 {
      display: inline-block;
      width: 81px;
      height: 66px;
      line-height: 66px;
      box-shadow: 0px 2px 18px 0px rgba(121, 121, 121, 0.15);
      border-radius: 5px;
      color: #666;
      font-size: 29px;
      font-weight: 400;
    }
    .time2 {
      margin-left: 7px;
    }
    .date1 {
      font-size: 22px;
      font-weight: 400;
      color: rgba(66, 69, 74, 1);
      margin: 0 12px;
    }
  }
  .actiInfo {
    .applyInfo {
      li {
        padding: 30px;
        border-bottom: 1px solid #eee;
        font-size: 26px;
        color: #333;
        img {
          vertical-align: middle;
          width: 45px;
          height: 45px;
        }
        .liName {
          margin-left: 30px;
        }
      }
      .lastLi {
        border-bottom: none;
      }
    }
  }
  .applyImg {
    padding: 30px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    .applyUl {
      li {
        float: left;
      }
      .applyLi {
        width: 45px;
        height: 45px;
        border: 1px solid #eee;
        border-radius: 50%;
        img {
          width: 100%;
          height: 100%;
        }
      }
      .applyline {
        width: 1px;
        height: 35px;
        background: #ccc;
        margin: 0 10px;
        border: none;
      }
    }
    .applyNum {
      font-size: 30px;
      color: #8c8c8c;
      span:nth-child(2) {
        display: inline-block;
        vertical-align: middle;
      }
    }
  }
  .fenge {
    height: 20px;
    background: #fbfbfb;
  }
  .actiDel {
    padding: 30px;
    .del1 {
      padding-left: 10px;
      border-left: 6px solid #00a041;
      font-size: 30px;
      margin-bottom: 30px;
    }
    // > p {
    //   line-height: 40px;
    // }
  }
  .actiFooter {
    display: flex;
    align-items: center;
    justify-content: center;
    border-top: 1px solid #eee;
    position: fixed;
    bottom: 0;
    z-index: 3;
    height: 100px;
    width: 100%;
    .attention {
      width: 60%;
      height: 100%;
      background: #fff;
      //  display: flex;
      //  align-items: center;
      padding: 30px;
      font-size: 26px;
      img {
        width: 30px;
        height: 28px;
        vertical-align: middle;
        margin-right: 10px;
      }
    }
    .attend {
      width: 40%;
      height: 100%;
      line-height: 100px;
      // padding: 30px;
      span {
        display: inline-block;
        background: #00a041;
        color: #fff;
        // padding: 40px;
        font-size: 34px;
        width: 100%;
        text-align: center;
      }
      .stopJoin{
        background: #eee;
        color:#999;
      }
    }
    .att1 {
      display: inline-block;
      vertical-align: middle;
    }
  }
}
</style>

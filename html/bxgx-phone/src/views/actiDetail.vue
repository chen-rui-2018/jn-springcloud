<template>
  <div class="actiDetail">
    <div class="actiImg">
      <img :src="actiForm.actiPosterUrl" alt="">
    </div>
    <div class="actiTit">{{actiForm.actiName}}</div>
    <div class="actiTime">
      <div class="timeTit">报名截止还剩</div>
      <div class="timeSecond">
        <span class="time1">{{d}}</span>
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
          <span>{{actiForm.applyNum}}人已报名</span>
        </div>
      </div>
    </div>
    <div class="fenge"></div>
    <div class="actiDel">
      <p class="del1">详情</p>
      <p>{{actiForm.actiDetail}}</p>
    </div>
    <div class="actiFooter">
      <div class="attention">
        <img src="@/./assets/images/xin.png" v-if="accountIsLike" alt=" " @click="cancelLike(actiForm.id)">
        <img src="@/./assets/images/guanzhu.png" alt="" v-else @click="handleLike(actiForm.id)">关注{{actiForm.actiLike}}
      </div>
      <div class="attend ">
        我要参加
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
      activityId: ''
    }
  },
  created () {
    this.actiDel()
    this.activityId = this.getUrlParms('activityId')
  },
  mounted () {},
  destroyed () {
    clearInterval(this._interval)
  },
  methods: {
    actiDel () {
      let _this = this
      this.api.post({
        url: 'getActivityDetails',
        data: {
          activityId: _this.activityId
          // activityId: 'f5c95f9adf714aedab3739cbc9297178'
        },
        dataFlag: true,
        callback: function (res) {
          if (res.code === '0000') {
            _this.actiForm = res.data.activityDetail
            _this.activityApplyList = res.data.activityApplyList
            _this.sysTemTime = res.data.sysTemTime
            _this.applyEndTime = res.data.activityDetail.applyEndTime
            _this._interval = setInterval(() => {
              let data = _this.countTime(_this.applyEndTime)
              if (data) {
                clearInterval(_this._interval)
              }
            }, 1000)
          }
        }
      })
    },
    handleLike (id) {
      let _this = this
      this.api.post({
        url: 'activityLike',
        data: {
          activityId: id
        },
        dataFlag: true,
        callback: function (res) {
          if (res.code === '0000') {
            _this.actiForm.actiLike = _this.actiForm.actiLike * 1 + 1
            // _this.$message.success('点赞成功')
            _this.accountIsLike = true
          } else {
            _this.$message.error(res.result)
            this.$vux.toast.text('hello', 'top')
          }
        }
      })
    },
    cancelLike (id) {
      let _this = this
      this.api.post({
        url: 'CancelLike',
        data: {
          activityId: id
        },
        dataFlag: true,
        callback: function (res) {
          if (res.code === '0000') {
            _this.actiForm.actiLike -= 1
            // _this.$message.success('取消点赞成功')
            _this.accountIsLike = false
          } else {
            _this.$message.error(res.result)
          }
        }
      })
    },
    countTime (t) {
      // var secondsTime = new Date(this.sysTemTime).getTime()
      var secondsTime = new Date().getTime()
      var applyTime = new Date(t).getTime()
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
        this.d = 0
        this.h = 0
        this.m = 0
        this.s = 0
        return true
      }
    },
    // 获取地址栏参数，name:参数名称
    getUrlParms (name) {
      debugger
      var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)')
      var r = window.location.search.substr(1).match(reg)
      if (r != null) {
        return unescape(r[2])
      }
      return null
    }
  }
}
</script>
<style lang="scss" scoped>
.actiDetail {
  width: 100%;
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
  }
  .actiFooter {
    display: flex;
    align-items: center;
    justify-content: center;
    border-top: 1px solid #eee;
    .attention {
      flex: 60%;
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
      flex: 40%;
      background: #00a041;
      color: #fff;
      padding: 30px;
      font-size: 34px;
      text-align: center;
    }
  }
}
</style>

<template>
  <div class="moreActi">
    <!-- <div class="approvalGuide_search">
      <search v-model="keyWord" ref="search" @keyup.enter.native="searchFun"></search>
    </div> -->
    <div class="declarationCenter_search">
      <i class="weui-icon-search" v-if="keyWord===''"></i>
      <input type="text" placeholder="搜索" v-model="keyWord" @change="searchFun">
    </div>
    <div class="approvalGuide_main">
      <div class="approvalGuide_tab">
        <tab>
          <tab-item :selected="active===''">
            <span :class="{active:active===''}" @click="toggle('','')">全部</span>
          </tab-item>
          <tab-item v-for="(item,$index) in actiTypeList" :key="$index" :selected="$index===active">
            <span :class="{active:$index===active}" @click="toggle($index,item.typeId)">{{item.typeName}}</span>
          </tab-item>
        </tab>
      </div>
      <div class="approvalGuide_cont">
        <ul>
          <li class="actiLi" v-for="(i,k) in actiListSlim" :key="k">
            <div class="imgItem" @click="$router.push({path:'/actiDetail',query:{activityId:i.id}})">
              <img :src="i.actiPosterUrl" alt="">
            </div>
            <div class="contentLi">
              <div class="tit">{{i.actiName}}</div>
              <div class="acinfo">
                <div class="info1">
                  <img src="@/./assets/images/zhiyuandidian1.png" alt="">
                  <span>{{i.actiAddress}}</span>
                </div>
                <div class="info2">
                  <img src="@/./assets/images/shijian00.png" alt="">
                  <span>{{i.actiStartTime}}-{{i.actiEndTime}}</span>
                </div>
              </div>
              <div class="apply">
                <div class="apply1">
                  <ul>
                    <li v-for="(item,index) in i.avatarList" :key="index"><img :src="item" alt=""></li>
                    <!-- <li><img src="@/./assets/images/tuceng.png" alt=""></li> -->
                  </ul>
                  <span>{{i.applyNum}}/{{i.actiNumber}}</span>
                </div>
                <div class="apply2">
                  <img src="@/./assets/images/xin.png" alt="">
                  <span>{{i.actiLike}}</span>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script>
import {
  Cell,
  CellBox,
  CellFormPreview,
  Group,
  Badge,
  Search,
  Popup,
  Tab,
  TabItem
} from 'vux';

export default {
  data () {
    return {
      active: '',
      total: 0,
      actiTypeList: [],
      keyWord: '',
      page: 1,
      rows: 4,
      actiListSlim: [],
      typeId: ''
    }
  },
  components: {
    Group,
    Cell,
    CellFormPreview,
    CellBox,
    Badge,
    Search,
    Popup,
    Tab,
    TabItem
  },
  mounted () {
    this.getActiType()
    this.scrollBottom()
    this.initList()
  },
  methods: {
    toggle (index, typeId) {
      this.typeId = typeId
      this.active = index
      this.initList()
    },
    searchFun () {
      this.page = 1
      this.initList()
    },
    // tab栏
    scrollBottom () {
      //   let _this = this
      window.onscroll = () => {
        var scrollHeight = Math.max(
          document.documentElement.scrollHeight,
          document.body.scrollHeight
        )
        var scrollTop =
          window.pageYOffset ||
          document.documentElement.scrollTop ||
          document.body.scrollTop
        var clientHeight =
          window.innerHeight ||
          Math.min(
            document.documentElement.clientHeight,
            document.body.clientHeight
          )
        if (clientHeight + scrollTop >= scrollHeight) {
          if (this.page < Math.ceil(this.total / this.rows)) {
            this.page++
            this.api.post({
              url: 'activityListSlim',
              data: {
                keyWord: this.keyWord,
                page: this.page,
                rows: this.rows,
                typeId: this.typeId
              },
              callback: res => {
                if (res.code === '0000') {
                  this.actiListSlim.push(...res.data.rows)
                  this.total = res.data.total
                }
              }
            })
          }
        }
      }
    },
    // 获取活动数据
    initList () {
      this.page = 1
      let _this = this
      this.api.post({
        url: 'activityListSlim',
        data: {
          keyWord: this.keyWord,
          page: this.page,
          rows: this.rows,
          typeId: this.typeId
        },
        callback: function (res) {
          if (res.code === '0000') {
            _this.actiListSlim = res.data.rows
            _this.total = res.data.total
          } else {
            _this.$vux.toast.text(res.result)
          }
        }
      })
    },
    // 获取活动类型
    getActiType () {
      let _this = this
      this.api.post({
        url: 'findActivityTypeList',
        data: {},
        callback: function (res) {
          if (res.code === '0000') {
            _this.actiTypeList = res.data.rows
          } else {
            _this.$vux.toast.text(res.result)
          }
        }
      })
    }
  }
}
</script>

<style lang="scss">
.moreActi {
  overflow: scroll;
  .declarationCenter_search {
    position: fixed;
    z-index: 10;
    width: 100%;
    background-color: #f5f5f5;
    padding: 0 35px;
    display: flex;
    input::placeholder {
      text-align: center;
      font-size: 21px;
    }
    input {
      height: 60px;
      width: 100%;
      margin: 22px 0;
      border-radius: 30px;
      padding: 0 40px;
    }
    i {
      position: absolute;
      top: 37%;
      right: 54%;
    }
  }
  // .approvalGuide_search {
  //   position: fixed;
  //   z-index: 10;
  //   // top: 105px;
  //   width: 100%;
  //   .weui-search-bar {
  //     padding: 28px 32px;
  //   }
  //   .vux-search-box {
  //     position: fixed;
  //     // top: 105px !important;
  //   }
  //   .weui-search-bar__input {
  //     height: 63px;
  //     line-height: 63px;
  //     // border-radius: 30px;
  //   }
  //   .weui-icon-search {
  //     line-height: 63px;
  //   }
  //   .weui-icon-clear {
  //     line-height: 0.8rem;
  //   }
  //   .weui-search-bar.weui-search-bar_focusing .weui-search-bar__cancel-btn {
  //     display: flex;
  //     align-items: center;
  //   }
  //   .weui-search-bar__box {
  //     padding: 0 70px;
  //     .weui-icon-search {
  //       left: 20px;
  //     }
  //     .weui-search-bar__input {
  //       padding: 0;
  //     }
  //   }
  // }
  .approvalGuide_main {
    .approvalGuide_tab {
      // margin-top: 110px;
      position: fixed;
      top: 103px;
      width: 100%;
      z-index: 20;
      background-color: #fff;
      .vux-tab-wrap {
        padding-top: 0;
      }
      .vux-tab-container {
        height: auto;
      }
      .vux-tab {
        height: auto;
        padding-bottom: 0;
        // margin-right: 30px;
        border-bottom: 2px solid #ccc;
        .vux-tab-item {
          flex: 0 0 auto;
          padding: 23px 0;
          padding-right: 70px;
          width: auto;
          &:first-child {
            margin-left: 32px;
          }

          span {
            padding-bottom: 27px;
            font-size: 23px;
          }
          .active {
            border-bottom: 5px solid #07ab50;
            color: #07ab50;
          }
        }
        .vux-tab-ink-bar {
          display: none !important;
        }
      }
    }
    .approvalGuide_cont {
      margin: 30px;
      //   margin-top: 44%;
      margin-top: 230px;
      height: 100%;
      overflow: auto;
      .weui-cells {
        box-shadow: 0px 2px 18px 0px rgba(121, 121, 121, 0.15);
        border-radius: 20px;
        .weui-cell {
          padding: 19px 28px;
          .vux-label {
            font-size: 26px;
          }
        }
        .weui-cell__ft {
          span {
            font-size: 33px;
          }
        }
      }

      .fold_cont {
        overflow: hidden;
        max-height: 0;
        transition: max-height 0.5s cubic-bezier(0, 1, 0, 1) -0.1s;
        padding: 0 28px;
        color: #666666;

        div {
          font-size: 24px;
          border-top: 2px solid #ccc;
          padding: 23px 0;
          display: flex;
          justify-content: space-between;
          .iconfont {
            font-size: 20px;
            color: #ccc;
          }
          &:first-child {
            border: none;
          }
          &:last-child {
            margin-bottom: 15px;
          }
        }
      }
      .sub-item {
        color: #888;
      }
      .animate {
        max-height: 9999px;
        transition-timing-function: cubic-bezier(0.5, 0, 1, 0);
        transition-delay: 0s;
        border-top: 2px solid #ccc;
      }
      .actiLi {
        border-radius: 17px;
        // border: 1px solid #000;
        box-shadow: 0px 5px 7px 0px rgba(0, 0, 0, 0.13);
        margin-bottom: 30px;
      }
      .contentLi {
        padding: 20px;
      }
      .imgItem {
        height: 270px;
        img {
          width: 100%;
          height: 100%;
          border-radius: 17px 17px 0px 0px;
        }
      }
      .tit {
        font-weight: bold;
        color: rgba(71, 71, 71, 1);
        font-size: 30px;
      }
      .acinfo {
        font-weight: 500;
        color: rgba(165, 164, 164, 1);
        font-size: 22px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin: 20px 0;
      }
      .info1 {
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        width: 48%;
      }
      .info1,
      .info2 {
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        img {
          display: inline-block;
          vertical-align: middle;
          width: 18px;
          //   height: 20px;
        }
        span {
          display: inline-block;
          vertical-align: middle;
        }
      }
      .info2 {
        width: 40%;
      }
      .apply {
        display: flex;
        justify-content: space-between;
        align-items: center;
      }
      .apply1 {
        font-weight: 500;
        color: rgba(161, 161, 161, 1);
        font-size: 24px;
        display: flex;
        // justify-content: space-between;
        align-items: center;
        > span {
          margin-left: 10px;
        }
        ul {
          display: flex;
        }
        li {
          width: 38px;
          height: 38px;
          border-radius: 50%;
          margin-left: -20px;
          img {
            width: 100%;
            height: 100%;
            border-radius: 50%;
          }
        }
        li:first-child {
          margin-left: 0;
        }
      }
      .apply2 {
        font-weight: 400;
        color: rgba(0, 160, 65, 1);
        font-size: 22px;
        img {
          width: 20px;
        }
      }
    }
  }
}
</style>

<template>
  <div class="approvalGuide">
    <!-- <div class="approvalGuide_search">
      <search v-model="policySearch" ref="search" @keyup.enter.native="searchEnterFun"></search>
    </div> -->
    <div class="declarationCenter_search">
      <i class="weui-icon-search" v-if="policySearch===''"></i>
      <input type="text" placeholder="搜索" v-model="policySearch" @change="searchEnterFun">
    </div>
    <div class="approvalGuide_main">
      <div class="approvalGuide_tab">
        <tab>
          <tab-item :selected="active===''">
            <span :class="{active:active===''}" @click="toggle('','')">全部政策</span>
          </tab-item>
          <tab-item v-for="(item,$index) in policyClass" :key="$index" :selected="$index===active">
            <span :class="{active:$index===active}" @click="toggle($index,item.policyClassCode)">{{item.policyClassName}}</span>
          </tab-item>
        </tab>
      </div>
      <div class="approvalGuide_cont">
        <ul>
          <li v-for="(i,k) in policyCenterList" :key="k" @click="$router.push({path:'/policyDetails',query:{policyId:i.policyId}})">
            <div class="tit">
              <span>{{i.policyTitle}}</span>
              <span>{{i.issueUnit}}</span>
            </div>
            <p>
              {{i.briefContent}}
            </p>
            <div class="info">
              <div class="info1">{{i.releaseDate}}</div>
              <div class="info2">{{i.readNum}}人浏览</div>
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
} from 'vux'

export default {
  data () {
    return {
      active: '',
      policySearch: '',
      total: 0,

      policyClass: [],
      page: 1,
      row: 8,
      policyCenterList: [],
      policyClassCode: ''
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
    this.scrollBottom()
    this.getPolicyClassList()
    this.getPolicyCenterList()
  },
  methods: {
    // tab栏
    scrollBottom () {
      // let _this = this
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
          // console.log(this)
          if (this.page < Math.ceil(this.total / this.row)) {
            this.page++
            this.api.get({
              url: 'getPolicyCenterList',
              data: {
                needPage: 1,
                page: this.page,
                policyClassCode: this.policyClassCode,
                policyType: 0,
                rows: this.row,
                tableType: 'allPolicy'
              },
              callback: res => {
                if (res.code === '0000') {
                  this.policyCenterList.push(...res.data.rows)
                  this.total = res.data.total
                }
              }
            })
          }
        }
      }
    },
    toggle (index, policyClassCode) {
      this.active = index
      this.policyClassCode = policyClassCode
      this.getPolicyCenterList()
    },
    searchEnterFun () {
      this.page = 1
      this.getPolicyCenterList()
    },
    // 政策中心首页
    getPolicyCenterList () {
      this.page = 1
      let _this = this
      this.api.get({
        url: 'getPolicyCenterList',
        data: {
          needPage: 1,
          page: _this.page,
          policyClassCode: _this.policyClassCode,
          policySearch: _this.policySearch,
          policyType: 0,
          rows: _this.row,
          tableType: 'allPolicy'
        },
        callback: function (res) {
          if (res.code === '0000') {
            _this.policyCenterList = res.data.rows
            _this.total = res.data.total
          } else {
            _this.$vux.toast.text(res.result)
          }
        }
      })
    },
    // 政策分类
    getPolicyClassList () {
      let _this = this
      this.api.get({
        url: 'getPolicyClassList',
        data: {},
        callback: function (res) {
          if (res.code === '0000') {
            _this.policyClass = res.data
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
.approvalGuide {
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
      margin: 30px 0;
      margin-top: 220px;
      // margin-top: 44%;
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

      li {
        border-bottom: 1px solid #eee;
        padding: 30px;
        .tit {
          font-weight: bold;
          height: 32px;
          line-height: 32px;
        }
        .tit,
        .info {
          display: flex;
          justify-content: space-between;
          align-items: center;
          width: 100%;
          span {
            font-size: 30px;
          }
          span:nth-child(1) {
            width: 70%;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
          }
          span:nth-child(2) {
            width: 25%;
            color: #00a041;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
          }
        }
        p {
          font-size: 26px;
          color: #666;
          height: 75px;
          display: -webkit-box;
          -webkit-box-orient: vertical;
          -webkit-line-clamp: 2;
          overflow: hidden;
          line-height: 40px;
          margin: 20px 0;
        }
        .info {
          font-size: 24px;
          color: #a2a2a2;
        }
      }
    }
  }
}
</style>

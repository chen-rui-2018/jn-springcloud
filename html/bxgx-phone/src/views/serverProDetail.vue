<template>
  <div class="serverProDetail">
    <!-- <mt-loadmore :top-method="loadTop" :bottom-method="loadBottom" :bottom-all-loaded="allLoaded" :auto-fill='true' ref="loadmore"> -->
    <scroller lock-x @on-scroll-bottom="onScrollBottom" ref="scrollerBottom">
      <div class="proContent">
        <div class="top">
          <img :src="proDelInfo.pictureUrl" alt="">
        </div>
        <div class="bottom">
          <div class="serverDel">
            <div class="info1">
              <h3>{{proDelInfo.productName}}</h3>
              <div class="fe1">
                <span>机构：{{proDelInfo.orgName}}</span>
                <span>顾问:{{proDelInfo.advisorName}}</span>
              </div>
              <p>参考价格：
                <span style="color:red">{{proDelInfo.referPrice}}</span>元</p>
              <p class="fe1PP">服务周期：{{proDelInfo.serviceCycle}}</p>
            </div>
            <div class="info2">
              <div>
                <span>{{proDelInfo.transactionsNumber}}</span>笔交易</div>
              <div>
                <span>{{proDelInfo.evaluationNumber}}</span>评论</div>
              <div>
                <span>{{proDelInfo.evaluationScore}}</span>分</div>
            </div>
          </div>
          <div class="fenge"></div>
          <div class="serverCon">
            <div class="con1">
              <span @click="showTag=!showTag">产品内容</span>
              <span @click="showTag=!showTag">同类产品</span>
              <div class="border1" v-if="showTag"></div>
              <div class="border2" v-else></div>
            </div>
            <div class="con2">
              <div class="proCon" v-if="showTag">
                <div class="pro1">
                  <h2>服务内容</h2>
                  <p v-html="proDelInfo.productDetails"></p>
                </div>
                <div class="referencePrice">
                  <h4>参考行业价格标准</h4>
                  <x-table :cell-bordered="true" style="background-color:#fff;">
                    <tbody>
                      <tr>
                        <td>月凭证量<br>(份)</td>
                        <td>50份以下</td>
                        <td>50-100份</td>
                        <td>100-200份</td>
                        <td>500份以上</td>
                      </tr>
                      <tr>
                        <td>费用区间<br>(元/月)</td>
                        <td>1000-2000</td>
                        <td>1500-2500</td>
                        <td>3000-5000</td>
                        <td>5000-10000</td>
                      </tr>
                    </tbody>
                  </x-table>
                </div>
                <div class="personQuali">
                  <h4>服务人员资质</h4>
                  <p>1.服务机构有财政局颁发的代理记账许可证书</p>
                  <p>2.服务人员持有《中华人民共和国会计初级资格证书》</p>
                  <p>3.具有3年以上从业经验</p>
                  <p>4.由注册会计师或终极职称会计人员承担质量责任</p>
                </div>
                <div class="expectedEffect">
                  <h4>预计效果及产出</h4>
                  <p>出具符合会计制度、会计准则等规范的账册、报表；按照税法规定报税，并形成纳税申请表</p>
                </div>
              </div>
              <div class="samePro" v-else>

                <ul>
                  <li v-for="(i,k) in sameTypeProList" :key="k">
                    <div class="imgItem">
                      <img :src="i.pictureUrl" alt="">
                    </div>
                    <div class="conItem">
                      <div class="itemTit">{{i.productName}}</div>
                      <p>机构:{{i.orgName}}</p>
                      <p>顾问:{{i.advisorName}}</p>
                      <p>参考价格:
                        <span style="color:red">{{i.referPrice}}</span>元</p>
                      <div class="score">
                        <p>
                          <span style="margin-right:20px">{{i.transactionsNumber}}笔交易</span> {{i.evaluationNumber}}条评论</p>
                        <p style="color:#00a041">{{i.evaluationScore}}分</p>
                      </div>
                    </div>
                  </li>
                </ul>

                <load-more tip="loading" v-if="onFetching"></load-more>
                <!-- <span v-else>没有更多数据了</span> -->
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- </mt-loadmore> -->
    </scroller>
    <div class="fenge1"></div>
    <div class="serverFoot">
      <!-- <span @click="$router.push({path:'/demandRaise',query: { productId: proDelInfo.productId,productName:proDelInfo.productName }})">提需求</span> -->
      <span>提需求</span>
      <span>在线联系</span>
    </div>

  </div>
</template>
<script>
import Vue from 'vue'
import { Sticky, Tab, TabItem, XTable, Scroller, LoadMore } from 'vux'
import { Loadmore } from 'mint-ui'
Vue.component(Loadmore.name, Loadmore)
export default {
  components: {
    Sticky,
    Tab,
    TabItem,
    XTable,
    Scroller,
    LoadMore
  },
  data () {
    return {
      showTag: true,
      demo1: '产品内容',
      index: 0,
      proDelInfo: {},
      sameTypeProList: '',
      page: 1,
      row: 1,
      total: 0,
      onFetching: false,
      allLoaded: false
    }
  },
  mounted () {
    this.findProductDetails()
    this.sameTypeProductList()
  },
  methods: {
    loadTop () {
      // 加载更多数据
      this.page = 1
      setTimeout(() => {
        this.sameTypeProductList()
      }, 500)
      this.allLoaded = false // 若数据已全部获取完毕
    },
    loadBottom () {
      // 加载更多数据
      this.page++
      setTimeout(() => {
        this.sameTypeProductList('bottom')
      }, 500)
    },
    // loadTop () {
    //   this.$refs.loadmore.onTopLoaded()
    // },
    // loadBottom () {
    //   this.allLoaded = true
    //   this.$refs.loadmore.onBottomLoaded()
    // },
    findProductDetails () {
      // 服务产品详情
      let _this = this
      this.api.get({
        url: 'findProductDetails',
        data: {
          // productId: this.$route.query.productId
          productId: '585516648153219072'
        },
        callback: function (res) {
          if (res.code === '0000') {
            _this.proDelInfo = res.data.info
          }
        }
      })
    },
    // 同类产品
    sameTypeProductList (f) {
      let _this = this
      this.api.get({
        url: 'sameTypeProductList',
        data: {
          // signoryId: this.$route.query.signoryId,
          signoryId: 'industrial_tax',
          page: _this.page,
          rows: _this.row
        },
        callback: function (res) {
          if (res.code === '0000') {
            _this.sameTypeProList = res.data.rows
            _this.total = res.data.total
          }
          // if (res.code === '0000') {
          //   if (f) {
          //     _this.sameTypeProList = _this.sameTypeProList.concat(res.data.rows)
          //     // _this.datalist = _this.datalist.concat(res.data.list);
          //   } else {
          //     _this.sameTypeProList = res.data.rows
          //     // _this.datalist = res.data.list;
          //   }
          //   _this.total = res.data.total
          //   // _this.pageTotal = res.data.pageTotal;
          //   if (_this.page === _this.total) {
          //     _this.allLoaded = true// 若数据已全部获取完毕
          //   }
          // } else {
          //   // Toast(res.data.msg)
          //   _this.sameTypeProList = []
          //   _this.total = _this.page
          // }
          // if (f) {
          //   _this.$refs.loadmore.onBottomLoaded()
          // } else {
          //   _this.$refs.loadmore.onTopLoaded()
          // }
        }
      })
    },
    // scrollBottom () {
    //   // let _this = this
    //   window.onscroll = () => {
    //     var scrollHeight = Math.max(
    //       document.documentElement.scrollHeight,
    //       document.body.scrollHeight
    //     )
    //     var scrollTop =
    //       window.pageYOffset ||
    //       document.documentElement.scrollTop ||
    //       document.body.scrollTop
    //     var clientHeight =
    //       window.innerHeight ||
    //       Math.min(
    //         document.documentElement.clientHeight,
    //         document.body.clientHeight
    //       )
    //     if (clientHeight + scrollTop >= scrollHeight - document.getElementsByClassName('adniministrativeHeader')[0].clientHeight) {
    //       // console.log(this)
    //       if (this.page < Math.ceil(this.total / this.row)) {
    //         this.page++
    //         this.api.get({
    //           url: 'sameTypeProductList',
    //           data: {
    //             // signoryId: this.$route.query.signoryId,
    //             signoryId: 'industrial_tax',
    //             page: this.page,
    //             rows: this.row
    //           },
    //           callback: res => {
    //             if (res.code === '0000') {
    //               this.sameTypeProList.push(...res.data.rows)
    //               this.total = res.data.total
    //             }
    //           }
    //         })
    //       }
    //     }
    //   }
    // }
    onScrollBottom () {
      if (this.onFetching === false) {
        if (this.page < Math.ceil(this.total / this.row)) {
          this.onFetching = true
          setTimeout(() => {
            this.page++
            this.api.get({
              url: 'sameTypeProductList',
              data: {
                signoryId: 'industrial_tax',
                page: this.page,
                rows: this.row
              },
              callback: res => {
                if (res.code === '0000') {
                  this.onFetching = false
                  this.sameTypeProList.push(...res.data.rows)
                  // console.log(...res.data.rows)
                }
              }
            })
          }, 1000)
        } else {
          // this.getdeclarationList()
        }
      }
    }
  }
}
</script>
<style lang="scss">
.serverProDetail {
  width: 100%;
  padding-bottom: 120px;
  .proContent {
    position: relative;
  }
  .top {
    height: 480px;
    // height: 100%;
    width: 100%;
    position: absolute;
    z-index: -1;
    img {
      width: 100%;
      height: 100%;
      vertical-align: middle;
    }
    .h2,
    .fa-angle-left {
      display: inline-block;
    }
    .header {
      padding: 30px 34px;
      display: flex;
      align-items: center;
      justify-content: space-around;
      font-size: 32px;
      margin-left: 3px;
      background: #fff;
    }
    .fa-angle-left {
      flex: 3;
      font-size: 47px;
    }
    // .fa-angle-left:before{
    //     content: "";
    //     border-color:#333;
    //     width:20px;
    //     height: 20px;
    //   }
    .h2 {
      flex: 5;
      color: #333;
    }
  }
  .bottom {
    padding-top: 430px;
  }
  .serverDel {
    padding: 40px 0 0 0;
    border-top-left-radius: 20px;
    border-top-right-radius: 20px;
    border: 1px solid #eee;
    // margin-top: -30px;
    background: #fff;
    .fe1 {
      display: flex;
      justify-content: space-around;
      align-items: left;
      > span {
        flex: 1;
      }
    }
    .info1 {
      padding: 0 30px 30px;
      font-size: 26px;
      font-size: 24px;
      color: #333;
      h3 {
        font-size: 30px;
        color: #333;
        margin-bottom: 20px;
      }
      .fe1PP {
        // margin-top: 10px;
      }
      p {
        line-height: 50px;
      }
    }
    .info2 {
      border-top: 1px solid #eee;
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 20px 0;
      > div {
        flex: 1;
        text-align: center;
        border-right: 1px solid #eee;
      }
    }
  }
  .fenge {
    height: 20px;
    background: #fbfbfb;
  }
  .serverCon {
    .mint-tab-item.is-selected {
      border-bottom: thin solid #00a041;
      color: #00a041;
      margin-bottom: 2px;
      //   border-width:15px;
    }
  }
  .proCon {
    padding: 22px 36px;
  }
  .con1 {
    padding: 0 32px;
    border-bottom: 2px solid #eee;
    > span {
      display: inline-block;
      padding: 28px 0;
      font-size: 24px;
      color: #333;
      margin-right: 80px;
      cursor: pointer;
    }
    > span.active {
      color: #00a041;
    }
    .border1,
    .border2 {
      width: 43px;
      height: 5px;
      background: #00a041;
      margin-left: 20px;
    }
    .border2 {
      margin-left: 210px;
    }
  }
  .con2 {
    // padding: 22px 36px;
    .pro1 {
      font-size: 24px;
      h2 {
        color: #333;
        font-weight: bold;
        margin-bottom: 10px;
      }
      p {
        line-height: 40px;
      }
    }
    .referencePrice {
      margin: 50px 0;
      // table {
      //   width: 90%;
      //   margin: 0 auto;
      // }
      td {
        text-align: center;
        border: 1px solid #000;
        vertical-align: middle;
      }
    }
    .expectedEffect {
      margin: 30px 0 50px;
      p {
        line-height: 35px;
        color: #666;
      }
    }
    .personQuali {
      p {
        line-height: 35px;
        color: #666;
      }
    }
    h4 {
      font-size: 22px;
      margin: 20px 0;
      color: #333;
    }
  }
  .samePro {
    li {
      display: flex;
      font-size: 24px;
      color: #757575;
      .score {
        display: flex;
        justify-content: space-between;
        align-items: center;
      }
      .imgItem {
        // width: 198px;
        // height: 198px;
        flex: 1;
        padding: 42px 0 42px 35px;
        img {
          width: 198px;
          height: 198px;
          // width: 100%;
          // height: 100%;
          border-radius: 20px;
        }
      }
      .conItem {
        padding: 42px 35px;
        border-bottom: 2px solid #999;
        flex: 2;
        p {
          line-height: 42px;
        }
      }
    }
    li:nth-child(2) {
      .imgItem {
        border-bottom: 2px solid #ccc;
      }
      .conItem {
      }
    }
    li:last-child {
      .imgItem,
      .conItem {
        border-bottom: none;
      }
    }
    .itemTit {
      color: #222;
      font-size: 30px;
      margin-bottom: 10px;
    }
    // p {
    //   line-height: 40px;
    // }
  }
  .fenge1 {
    height: 40px;
    background: #fbfbfb;
  }
  .serverFoot {
    padding: 22px 34px;
    background: #fff;
    position: fixed;
    height: 120px;
    bottom: 0;
    color: #07ab50;
    > span {
      display: inline-block;
      text-align: center;
      font-size: 28px;
      width: 313px;
      height: 71px;
      line-height: 71px;
      background: rgba(236, 252, 242, 1);
      border: 2px solid rgba(7, 171, 80, 1);
      border-radius: 35px;
      cursor: pointer;
    }
    > span:first-child {
      margin-right: 20px;
    }
  }
}
</style>

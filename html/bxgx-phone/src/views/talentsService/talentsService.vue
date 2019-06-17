<template>
  <div class="talentsServiceCenter">
        <div class="banner"><img src="@/assets/image/talentsServiceCenter-baner.png" alt=""></div>
        <!-- 常年申报 -->
        <div class="perennial">
          <div class="perennial_titile">
            <div>常年申报</div>
            <div>MORE <span class="iconfont icon-jiantou "></span></div>
          </div>
          <div class="perennial_list">
            <ul>
              <li v-for="(item,index) in perennialList" :key="index">
                <div class="list_cont">
                  <p><img src="@/assets/image/perennial.png" alt=""> </p>
                  <p>{{item.title}}</p>
                  <p><span class="el-icon-location"></span>{{item.zoneApplication}}</p>
                  <p>收益：<span>{{item.profit}}</span> </p>
                  <p>价格：{{item.price}}</p>
                </div>
                <div class="list_view"><span>查看详情</span> </div>
              </li>
            </ul>
          </div>
        </div>
        <!-- 申报平台 -->
        <div class="talentsService_platform">
          <div class="platform_titile">
            <div>申报平台</div>
            <div @click="$router.push({path:'/guest/pd/talentNotice/talentsServicePlatform'})">MORE <span class="iconfont icon-jiantou"></span></div>
          </div>
          <div class="platform_cont" @click="$router.push({path:'/guest/pd/talentNotice/talentsServicePlatform'})">
            <p>
              <span class="iconfont icon-deng"> </span>
                汇集常用申报平台，便于企业快速查阅和进入。包含了各类科技项目、企业资质、产品认定、人才计划申报、资金兑现、技术合同登记等业务申报系统。
              <span @touchstart="goplatform">查看详情>><span class="el-icon-d-arrow-right"></span> </span>
            </p>
            <div>
              <img src="@/assets/image/platform.png" alt="">
            </div>
          </div>
        </div>
        <div class="before"></div>
        <!-- 申报中心列表 -->
        <div class="talentsService_list">
          <div class="talentsService_tab">
            <tab>
              <tab-item v-for="(item,$index) in typeList" :key="$index" :selected="item.id===sendData.rangeId">
                <span :class="{'active':item.id===sendData.rangeId}" @click="changetype(item.id)">{{item.rangeName}}</span>
              </tab-item>
            </tab>
          </div>
          <div class="talentsService_list_filter">
            <span @touchstart="filter('1')" :class="{'greenColor':sendData.sortType==='1'}"><i class="iconfont icon-clock-"></i>发布时间排序 </span>
            <span @touchstart="filter('2')" :class="{'greenColor':sendData.sortType==='2'}"><i class="iconfont icon-tiaozheng"></i>时间节点排序 </span>
            <span @touchstart="filter('3')" :class="{'greenColor':sendData.sortType==='3'}"><i class="iconfont icon-hot"></i>热度排序</span>
          </div>
          <div class="talentsService_cont_box">
            <div class="talentsService_cont" v-for="(item,index) in talentsList " :key="index" @click="$router.push({path:'/guest/pd/talentNotice/talentsServiceDetail',query:{id:item.id}}) ">
              <div class="talentsService_cont_left">
                <div class="cont_title"><span class="greenColor">[{{item.rangeId|type}}] </span>{{item.noticeTitle}} </div>
                <div class="cont_detail">
                  <div><span>开始 {{item.createdTime|time}}</span><span>截止 {{item.deadline|time}}</span></div>
                  <span class="greenColor">{{item.isRoofPlacement===1?'置顶':'不置顶'}}</span>
                </div>
              </div>
              <div class="talentsService_cont_right"><span class="iconfont icon-jiantou"></span> </div>
            </div>
          </div>
        </div>
  </div>
</template>
<script>
import {Tab, TabItem, Scroller, LoadMore} from 'vux'
export default {
  components: {
    Tab, TabItem, Scroller, LoadMore
  },
  data () {
    return {
      perennialList: [],
      typeList: [],
      talentsList: [],
      total: 0,
      sendData: {
        page: 1,
        rangeId: '1',
        rows: 2,
        sortType: '1'
      }
    }
  },
  filters: {
    time (time) {
      if (time) {
        return time.split('T')[0]
      }
    },
    type (rangeId) {
      if (rangeId === '1') {
        return '人才工作动态'
      } else if (rangeId === '2') {
        return '人才服务指南'
      } else if (rangeId === '3') {
        return '人才企业培训'
      } else if (rangeId === '4') {
        return '人才扶持计划'
      } else if (rangeId === '5') {
        return '常见问题'
      }
    }
  },
  mounted () {
    this.getperennialList()// 常年申报
    this.getTypeList()
    this.gettalentsList()

    this.scrollBottom()
  },
  methods: {
    scrollBottom () {
      window.onscroll = () => {
        var scrollHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight)
        var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
        var clientHeight = window.innerHeight || Math.min(document.documentElement.clientHeight, document.body.clientHeight)
        if (clientHeight + scrollTop >= scrollHeight) {
          if (this.sendData.page < Math.ceil(this.total / this.sendData.rows)) {
            this.sendData.page++
            this.api.get({
              url: 'talentsList',
              data: this.sendData,
              callback: res => {
                if (res.code === '0000') {
                  this.talentsList.push(...res.data.rows)
                }
              }
            })
          }
        }
      }
    },

    getperennialList () {
      this.api.get({
        url: 'perennialList',
        data: {
          page: 1,
          rows: 4
        },
        callback: res => {
          if (res.code === '0000') {
            // console.log(res)
            this.perennialList = res.data.rows
          }
        }
      })
    },
    getTypeList () {
      this.api.get({
        url: 'talentsTypeList',
        data: { },
        callback: res => {
          if (res.code === '0000') {
            this.typeList = res.data
          }
        }
      })
    },
    gettalentsList () {
      this.sendData.page = 1
      this.api.get({
        url: 'talentsList',
        data: this.sendData,
        callback: res => {
          if (res.code === '0000') {
            // console.log(res)
            this.talentsList = res.data.rows
            this.total = res.data.total
          }
        }
      })
    },
    goplatform () {
    },
    changetype (rangeId) {
      this.sendData.rangeId = rangeId
      this.gettalentsList()
    },
    filter (sortType) {
      this.sendData.sortType = sortType
      this.gettalentsList()
    },
    onScrollBottom () {
      if (this.onFetching === false) {
        if (this.sendData.page < Math.ceil(this.total / this.sendData.rows)) {
          this.onFetching = true
          setTimeout(() => {
            this.sendData.page++
          }, 1000)
        } else {
        }
      }
    }
  }
}
</script>

<style lang="scss">
  .talentsServiceCenter{
    // 常年申报
    .perennial{
      background-color: #fff;
      margin:0 23px;
      margin-top: 30px;
      .perennial_titile{
        display: flex;
        justify-content: space-between;
        div:nth-child(1){
          padding-left: 10px;
          border-left: 7px solid #00a041;
          line-height: 1;
          font-size: 29px;
        }
        div:nth-child(2){
          font-size: 25px;
          color:#00a041;
        }
      }
      .perennial_list{
          overflow: auto;
          margin-top: 33px;
          &::-webkit-scrollbar {display:none}
          ul{
            display: flex;
            width: 100%;
            li{
              width:49%;
              flex:0 0  auto;
              margin-right: 21px;
              border: solid 1px #eeeeee;
              transition:all .3s linear;
              &:last-child{
                margin-right: 0;
              }
              .list_cont{
                padding:0 31px;
                color:#797979;
                font-size: 13px;
                p{
                  margin-top: 9px;
                }
                p:nth-child(1){
                  // width:100%;
                  // height: 107px;
                  border-bottom: 1px solid #eeeeee;
                  padding: 13px 0;
                  margin-top: 0;
                  img{
                    width: 51%;
                    // height: 100%;
                    display: block;
                    margin: auto;
                  }
                }
                p:nth-child(2){
                  color:black;
                  font-size: 16px;
                  padding-top: 18px;
                  line-height: 29px;
                  margin-top: 18px;
                  line-height: 26px;
                  display: -webkit-box;
                  -webkit-box-orient: vertical;
                  -webkit-line-clamp: 2;
                  overflow: hidden;
                  height: 48px;

                }
                p:nth-child(4){
                 span{
                   color:#da0000;
                 }
                }
                p:nth-child(5){
                 margin-bottom: 6px;
                }
              }
              .list_view{
                text-align: center;
                background: #00a041;
                font-size: 13px;
                cursor: pointer;
                span{
                  display: block;
                  padding:11px 0;
                  color:#fff;
                }
              }
            }
          }
        }
    }
    // 大图
    .banner{
      // padding-top: 105px;
      img{
        width:100%;
      }
    }
    // 申报平台
    .talentsService_platform{
      margin:0 23px;
      margin-top: 46px;
      .platform_titile{
        display: flex;
        justify-content: space-between;
        div:nth-child(1){
          padding-left: 10px;
          border-left: 7px solid #00a041;
          line-height: 1;
          font-size: 29px;
        }
        div:nth-child(2){
          font-size: 25px;
          color:#00a041;
        }
      }
      .platform_cont{
        border: solid 1px #eeeeee;
        font-size: 20px;
        color:#797979;
        margin-top: 21px;
        display: flex;
        p{
          margin: 37px 0 43px 27px;
          line-height: 30px;
          width: 100%;
          span:nth-child(1){
            font-size: 13px;
            color:#00a041;
          }
          span:nth-child(2){
            color:#00a041;
            cursor: pointer;
          }
        }
        div{
            margin: auto;
          img{
            width:100%;
          }
        }
      }
    }
    .before{
      margin-top: 42px;
      height: 22px;
      width:100%;
      background-color: #fafafa;
    }
    .greenColor{
      color:#07ab50;
    }
    .talentsService_list{
       .talentsService_tab{
        width:100%;
        z-index: 20;
        background-color: #fff;
        .vux-tab-wrap{
          padding-top: 0;
        }
        .vux-tab-container{
          height: auto;
        }
        .vux-tab{
          height: auto;
          padding-bottom: 0;
          border-bottom: 2px solid #ccc;
          .vux-tab-item{
            flex:0 0 auto;
            padding: 23px 0;
            padding-right: 70px;
            width:auto;
            &:first-child{
              margin-left: 32px;
            }

            span{
            padding-bottom: 27px;
            font-size: 23px;
            }
            .active{
              border-bottom: 5px solid #07ab50;
              color:#07ab50;
            }
          }
           .vux-tab-ink-bar{
             display: none !important;
           }
        }
      }
      .talentsService_list_filter{
        background-color: #f6f6f6;
        font-size: 24px;
        padding:22px 31px;
        display: flex;
        justify-content: space-between;
        padding-top: 110px;
        i{
          font-size: 30px;
        }
      }
      .talentsService_cont_box{
        margin:0 31px;
        margin-bottom: 50px;
        .talentsService_cont{
        border-bottom: 2px solid #efefef;
          display: flex;
          justify-content: space-between;
          align-items: center;
          .talentsService_cont_left{
            width: 92%;
            .cont_title{
              display: -webkit-box;
              -webkit-box-orient: vertical;
              -webkit-line-clamp: 1;
              overflow: hidden;
              font-size: 26px;
              padding-top: 37px;
              line-height: 28px;
            }
            .cont_detail{
              font-size: 23px;
              color:#333333;
              display: flex;
              justify-content: space-between;
              padding-top: 36px;
              padding-bottom: 41px;
              span{
                padding-right: 23px;
              }
            }
          }
          .talentsService_cont_right{
            padding-left: 32px;
            color:#cccccc;
            font-size: 20px;
          }
        }
      }
    }
  }
</style>

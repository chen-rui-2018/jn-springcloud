<template>
  <div class="declarationCenter">
        <div class="banner"><img src="@/assets/image/declarationCenter-baner.png" alt=""></div>
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
        <div class="declaration_platform">
          <div class="platform_titile">
            <div>申报平台</div>
            <div >MORE <span class="iconfont icon-jiantou"></span></div>
          </div>
          <div class="platform_cont" @click="$router.push({path:'/guest/pd/declarationPlatform'})">
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
        <div class="declaration_list">
          <div class="declaration_list_tab">
            <ul >
              <li :class="{'active':sendData.rangeId===''}" @touchstart="changetype('') ">全部</li>
              <li :class="{'active':typeitem.id===sendData.rangeId}" @touchstart="changetype(typeitem.id) " v-for="(typeitem,typeindex) in  typeList" :key="typeindex">{{typeitem.name}} </li>
            </ul>
          </div>
          <div class="declaration_list_filter">
            <span @touchstart="filter('1')" :class="{'greenColor':sendData.sortType==='1'}"><i class="iconfont icon-clock-"></i>发布时间排序 </span>
            <span @touchstart="filter('2')" :class="{'greenColor':sendData.sortType==='2'}"><i class="iconfont icon-tiaozheng"></i>时间节点排序 </span>
            <span @touchstart="filter('3')" :class="{'greenColor':sendData.sortType==='3'}"><i class="iconfont icon-hot"></i>热度排序</span>
          </div>
          <scroller lock-x @on-scroll-bottom="onScrollBottom" ref="scrollerBottom" style="height:auto">
                <div class="box2">
              <!-- <div class="declaration_cont_box">
                <div class="declaration_cont" v-for="(item,index) in declarationList " :key="index">
                  <div class="declaration_cont_left">
                    <div class="cont_title"><span class="greenColor" v-if="item.rangeName">[{{item.rangeName}}] </span>{{item.titleName}} </div>
                    <div class="cont_detail">
                      <div><span>开始 {{item.createdTime|time}}</span><span>截止 {{item.deadline|time}}</span></div>
                      <span class="greenColor">{{item.isRoofPlacement===1?'置顶':'不置顶'}}</span>
                    </div>
                  </div>
                  <div class="declaration_cont_right"><span class="iconfont icon-jiantou"></span> </div>
                </div>
              </div> -->
              <div class="declaration_cont_box">
                <div class="declaration_cont" v-for="(item,index) in declarationList " :key="index" @click="$router.push({path:'/guest/pd/declarationDetail',query:{id:item.id}}) ">
                  <div class="declaration_cont_left">
                    <div class="cont_title"><span class="greenColor" v-if="item.rangeName">[{{item.rangeName}}] </span>{{item.titleName}} </div>
                    <div class="cont_detail">
                      <div><span>开始 {{item.createdTime|time}}</span><span>截止 {{item.deadline|time}}</span></div>
                      <span class="greenColor">{{item.isRoofPlacement===1?'置顶':'不置顶'}}</span>
                    </div>
                  </div>
                  <div class="declaration_cont_right"><span class="iconfont icon-jiantou"></span> </div>
                </div>
                <load-more tip="loading" v-if="onFetching"></load-more>
              </div>
            </div>
          </scroller>
        </div>
  </div>
</template>
<script>
import { Scroller, LoadMore } from 'vux'
export default {
  components: {
    Scroller, LoadMore
  },
  data () {
    return {
      perennialList: [],
      typeList: [],
      declarationList: [],
      total: 0,
      sendData: {
        page: 1,
        rangeId: '',
        rows: 2,
        sortType: '1'
      },
      onFetching: false
    }
  },
  filters: {
    time (time) {
      if (time) {
        return time.split('T')[0]
      }
    }
  },
  mounted () {
    this.getperennialList()// 常年申报
    this.getTypeList()
    this.getdeclarationList()
  },
  methods: {
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
        url: 'typeList',
        data: { },
        callback: res => {
          if (res.code === '0000') {
            this.typeList = res.data
          }
        }
      })
    },
    getdeclarationList () {
      this.sendData.page = 1
      this.api.get({
        url: 'declarationList',
        data: this.sendData,
        callback: res => {
          if (res.code === '0000') {
            // console.log(res)
            this.declarationList = res.data.rows
            this.total = res.data.total
            this.onFetching = false
          }
        }
      })
    },
    goplatform () {
    },
    changetype (rangeId) {
      this.sendData.rangeId = rangeId
      this.getdeclarationList()
    },
    filter (sortType) {
      this.sendData.sortType = sortType
      this.getdeclarationList()
    },
    onScrollBottom () {
      if (this.onFetching === false) {
        if (this.sendData.page < Math.ceil(this.total / this.sendData.rows)) {
          this.onFetching = true
          setTimeout(() => {
            this.sendData.page++
            this.api.get({
              url: 'declarationList',
              data: this.sendData,
              callback: res => {
                if (res.code === '0000') {
                  this.onFetching = false
                  this.declarationList.push(...res.data.rows)
                  // console.log(...res.data.rows)
                }
              }
            })
          }, 1000)
        } else {
        }
      }
    }
  }
}
</script>

<style lang="scss">
  .declarationCenter{
    // 常年申报
    .perennial{
      background-color: #fff;
      margin:0 23px;
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
              width:44%;
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
                  width:100%;
                  height: 107px;
                  border-bottom: 1px solid #eeeeee;
                  padding: 13px 0;
                  margin-top: 0;
                  img{
                    width: 51%;
                    height: 100%;
                    display: block;
                    margin: auto;
                  }
                }
                p:nth-child(2){
                  color:black;
                  font-size: 16px;
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
      padding-top: 105px;
      img{
        width:100%;
      }
    }
    // 申报平台
    .declaration_platform{
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
    .declaration_list{
      .declaration_list_tab{
        padding: 0 31px;
        ul{
          display: flex;
          justify-content: space-between;
          li{
            padding: 25px 0 18px 0;
            font-size: 24px;
          }
          .active{
            color:#07ab50;
            border-bottom: 5px solid #07ab50;
          }
        }
      }
      .declaration_list_filter{
        background-color: #f6f6f6;
        font-size: 24px;
        padding:22px 31px;
        display: flex;
        justify-content: space-between;
        i{
          font-size: 30px;
        }
      }
      .declaration_cont_box{
        margin:0 31px;
        margin-bottom: 50px;
        .declaration_cont{
        border-bottom: 2px solid #efefef;
          display: flex;
          justify-content: space-between;
          align-items: center;
          .declaration_cont_left{
            width: 92%;
            .cont_title{
              display: -webkit-box;
              -webkit-box-orient: vertical;
              -webkit-line-clamp: 1;
              overflow: hidden;
              font-size: 26px;
              margin-top: 37px;
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
          .declaration_cont_right{
            padding-left: 32px;
            color:#cccccc;
            font-size: 20px;
          }
        }
      }
    }
  }
</style>

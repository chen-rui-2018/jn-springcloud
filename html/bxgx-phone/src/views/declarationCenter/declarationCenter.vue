<template>
<div>
    <div class="declarationCenter_search" v-if="isShow!=1">
      <i class="weui-icon-search" v-if="sendData.titleName===''"></i>
      <input type="text" placeholder="搜索" @change="gosearch" v-model="sendData.titleName" >
    </div>
    <!-- v-if="isShow!=1" gosearch-->
  <div class="declarationCenter" :class="{'padding':isShow!=1} ">
    <div class="banner" v-if="isShow===1"><img src="@/assets/image/declarationCenter-baner.png" alt=""></div>
     <!-- 申报中心列表 -->
    <div class="declaration_list">
      <div class="declaration_titile">
        <div>即时申报项目</div>
        <div @click="goItems">MORE <span class="iconfont icon-jiantou"></span></div>
      </div>
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
      <div class="declaration_cont_box">
        <div class="declaration_cont" v-for="(item,index) in declarationList " :key="index" @click="goDetail(item.id)">
          <div class="declaration_cont_left">
            <div class="cont_title"><span class="greenColor">[{{item.rangeId|type}}] </span>{{item.titleName}} </div>
            <div class="cont_detail">
              <div>
                <span>开始：{{item.createdTime|time}}</span><span>截止：{{item.deadline|time}}</span>
                </div>
              <span class="greenColor">{{item.isRoofPlacement===1?'置顶':'不置顶'}}</span>
            </div>
            <div class="cont_depart"><span>申报部门：{{item.timeNode}}</span><span v-if="item.preliminaryDeadline!=null">初审截止时间：{{item.preliminaryDeadline|time}} </span></div>
          </div>
          <div class="declaration_cont_right"><span class="iconfont icon-jiantou"></span> </div>
        </div>
      </div>
    </div>
    <!-- 常年申报 -->
    <div class="perennial" v-if="isShow===1">
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
    <div class="declaration_platform" v-if="isShow===1">
      <div class="platform_titile">
        <div>申报平台</div>
        <div @click="goplatform">MORE <span class="iconfont icon-jiantou"></span></div>
      </div>
      <div class="platform_cont" @click="goplatform">
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
    <div class="before" v-if="isShow===1"></div>
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
        rows: 3,
        sortType: '1',
        titleName: ''
      },
      isShow: 1
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
        return '白下高新区'
      } else if (rangeId === '2') {
        return '秦淮区'
      } else if (rangeId === '3') {
        return '南京市'
      } else if (rangeId === '4') {
        return '江苏省'
      } else if (rangeId === '5') {
        return '国家'
      }
    }
  },
  mounted () {
    if (this.$route.query.isShow) {
      this.isShow = this.$route.query.isShow
    }
    this.getperennialList()// 常年申报
    this.getTypeList()
    this.getdeclarationList()
    // this.scrollBottom()
  },
  methods: {
    goItems () {
      this.$router.push({path: '/guest/pd/DeclarationItems', query: {isShow: this.isShow}})
    },
    goDetail (id) {
      if (this.isShow === 1) {
        this.api.get({
          url: 'trafficVolume',
          data: {id: id},
          callback: res => {
            if (res.code === '0000') {
              this.$router.push({path: '/guest/pd/declarationDetail', query: {id: id}})
            } else {
              this.$vux.toast.text(res.result)
            }
          }
        })
      } else {
        this.api.get({
          url: 'trafficVolume',
          data: {id: id},
          callback: res => {
            if (res.code === '0000') {
              this.$router.push({path: '/guest/pd/declarationDetail', query: {id: id, isShow: '0'}})
            } else {
              this.$vux.toast.text(res.result)
            }
          }
        })
      }
    },
    gosearch () {
      this.getdeclarationList()
    },
    scrollBottom () {
      // let _this = this
      window.onscroll = () => {
        var scrollHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight)
        var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
        var clientHeight = window.innerHeight || Math.min(document.documentElement.clientHeight, document.body.clientHeight)
        if (clientHeight + scrollTop >= scrollHeight) {
          if (this.sendData.page < Math.ceil(this.total / this.sendData.rows)) {
            this.sendData.page++
            this.api.get({
              url: 'declarationList',
              data: this.sendData,
              callback: res => {
                if (res.code === '0000') {
                  this.declarationList.push(...res.data.rows)
                } else {
                  this.$vux.toast.text(res.result, 'middle')
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
          } else {
            this.$vux.toast.text(res.result)
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
          } else {
            this.$vux.toast.text(res.result)
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
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    goplatform () {
      this.api.get({
        url: 'getUserExtension',
        data: { },
        callback: (res) => {
          if (res.code === '0000') {
            if (res.data.roleCode === 'COM_ADMIN' || res.data.roleCode === 'COM_CONTACTS') {
              this.$router.push({path: '/guest/pd/declarationPlatform'})
            } else {
              this.$vux.toast.text('只有企业管理员和企业联系人才可以进申报平台！！')
            }
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    changetype (rangeId) {
      this.sendData.rangeId = rangeId
      this.getdeclarationList()
    },
    filter (sortType) {
      this.sendData.sortType = sortType
      this.getdeclarationList()
    },
    getQueryString (name) {
      var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i')
      var r = window.location.search.substr(1).match(reg)
      if (r != null) {
        return decodeURIComponent(r[2])
      }
      return null
    }
  }
}
</script>

<style lang="scss">
  .declarationCenter_search{
    position: fixed;
    z-index: 10;
    width: 100%;
    background-color: #F5F5F5;
    padding: 0 35px;
    display: flex;
    input::placeholder{
      text-align: center;
      font-size: 21px;
    }
    input{
      height: 60px;
      width:100%;
      margin: 22px 0;
      border-radius: 30px;
      padding: 0 40px;
    }
    i{
      position: absolute;
      top: 42%;
      right: 54%;
      font-size: 21px;
    }
  }
  .padding{
    padding-top: 95px;
  }
  .declarationCenter{
    // 常年申报
    .perennial{
      background-color: #fff;
      margin:0 23px;
      margin-top: 31px;
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
                  overflow: hidden;
                  white-space: nowrap;
                  text-overflow: ellipsis;
                  height: 46px;
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
      margin-top: 31px;
        .declaration_titile{
        margin: 0 31px;
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
      .declaration_list_tab{
        margin: 0 31px;
        margin-top: 15px;
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
        margin-bottom: 20px;
        .declaration_cont{
        border-bottom: 2px solid #efefef;
          display: flex;
          justify-content: space-between;
          align-items: center;
          .declaration_cont_left{
            width: 92%;
            .cont_depart{
              font-size: 23px;
              color:#333333;
              display: flex;
              justify-content: space-between;
              padding-bottom: 36px;
              span{
                // padding-right: 23px;
              }
            }
            .cont_title{
             overflow: hidden;
              white-space: nowrap;
              text-overflow: ellipsis;
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
              padding-bottom: 36px;
              span:first-child{
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

<template>
  <div>
    <!-- <div class="adniministrativeHeader">
      <x-header :left-options="{backText: ''}">{{this.$route.meta.title}} <span slot="right" @click="goConsult">留言</span></x-header>
    </div> -->
    <div class="serviceDeail">
      <div class="serviceDeail_main">
        <!-- 基本信息 -->
        <div class="serviceDeail_baseInfo">
          <div class="baseInfo_title"> 基本信息 </div>
          <div class="baseInfo_detail">
            <div><span>服务名称</span> <span>{{serviceDetail.name}}</span> </div>
            <div><span>发布时间</span> <span>{{serviceDetail.time}}</span> </div>
            <div><span>受理地址</span> <span>{{serviceDetail.dealAddress}}</span> </div>
            <div>
              <span>受理时间</span>
              <span>{{serviceDetail.dealTime}}</span>
              </div>
            <div><span>联系电话</span> <span>{{serviceDetail.linkPhone}}</span> </div>
            <div><span>承诺办理时限方式</span> <span>{{serviceDetail.dealLimitDays}}个工作日</span> </div>
            <div class="online_addr"><span>在线办理</span>
            <span><a :href="serviceDetail.dealUrl">请点击这里</a></span>
            </div>
          </div>
        </div>
        <!-- 办理材料 -->
        <div class="serviceDeail_service">
          <div class="baseInfo_title">办理材料</div>
          <div class="service_detail" v-for="(item,index) in materialList " :key="index">
            <div>
              <span class="hidden">{{item.name}}</span>
              <span @click="download">
                <!-- <a :href="url"  download="">
                  下载
                </a> -->
                <span>下载</span>
                <i class="iconfont icon-jiantou"></i>
              </span>
            </div>
            <div>
              <span>{{item.isRequired===1?'必要':'非必要'}} </span>
              <span>{{item.paperQuantity}} 份纸质</span>
              <span>{{item.isNeedElectronic===1?"需电子档":'不需电子档'}} </span>
            </div>
          </div>

        </div>
        <!-- 办理指引 -->
        <div class="manage_guide">
          <div class="baseInfo_title">依据</div>
          <div class="guide_base" v-html="serviceDetail.dealConditions">
            <!-- <p>{{}} </p> -->
          </div>
          <div class="baseInfo_title">办理流程</div>
          <div v-html="serviceDetail.flowPic" class="handle"></div>
        </div>
        <div v-if="serviceDetail.isContactOnline==='1'" class="btn" @click="$router.push({path: '/guest/portal/sp/power/consult'})"> 在线留言 </div>
        <!-- v-if="serviceDetail.contactQqGroup!=''"  -->
        <div v-if="serviceDetail.contactQqGroup!=''" class="btn" @click="showPlugin(serviceDetail.contactQqGroup)"> q群咨询 </div>
      </div>
    </div>
  </div>
</template>
<script>
import { Alert, AlertModule } from 'vux'
export default {
  components: {
    Alert,
    AlertModule
  },
  data () {
    return {
      id: '',
      serviceDetail: {},
      materialList: [],
      dealUrl: '',
      url: ''
    }
  },
  mounted () {
    this.id = this.$route.query.id
    this.getserviceDetail()
  },
  methods: {
    showPlugin (qq) {
      // console.log(11)
      AlertModule.show({
        title: 'qq群号',
        content: qq,
        onShow () {
        },
        onHide () {
        }
      })
    },
    download (item) {
      // alert(navigator.userAgent)
      // console.log(navigator.userAgent)
      // if (navigator.userAgent.indexOf('iPhone') > -1) {
      //   this.$vux.toast.show({
      //     text: '当前系统暂不支持下载',
      //     type: 'warn',
      //     width: '13em'
      //   })
      //   this.url = 'javascript:;'
      // } else {
      //   if (item === '') {
      // this.$vux.toast.text('暂不支持下载', 'middle')
      this.$vux.toast.show({
        text: '暂不支持下载',
        type: 'warn',
        width: '13em'
      })
      //   this.url = 'javascript:;'
      // } else {
      //   this.url = item
      // }
    }
  },
  getserviceDetail () {
    this.api.get({
      url: 'getBusi',
      data: {
        id: this.id
      },
      callback: res => {
        if (res.code === '0000') {
          // console.log(res)
          this.serviceDetail = res.data
          this.materialList = res.data.materialsModelList
        }
      }
    })
  },
  // goOnline () {
  //   this.dealUrl = `http://192.168.10.31:1101/springcloud-park/guest/portal/sp/power/getDealUrl?id=${this.id}`
  // },
  goConsult () {
    // console.log(1)
    this.$router.push({path: '/guest/portal/sp/power/consult', query: {id: this.id}})
  }
}
// }
</script>

<style lang="scss">
  .serviceDeail{
    height: 100vh;
    background-color: #f5f5f5;
    //  margin-top: 110px;
    .handle{
      text-align: center;
      img{
        width: 500px !important;
      }
    }
    .serviceDeail_main{
        padding-top:26px;
        .hidden{
          overflow: hidden;
          white-space: nowrap;
          text-overflow:ellipsis;
          width:70%;
        }
        .baseInfo_title{
          font-size: 35px;
          padding-top: 28px;
          margin-bottom: 17px;
          font-weight: 600;
        }
      // 基本信息
      .serviceDeail_baseInfo{
        background-color: #fff;
        padding: 0 31px;
        .baseInfo_detail{
          div{
            border-bottom: 2px solid #efefef;
            padding:28px 0;
            font-size: 26px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            &:last-child{
              border:none;
            }
            span:nth-child(1){
              padding-right: 44px;
              width:60%;
              display: inline-block;
            }
            span:nth-child(2){
              // display: inline-block;
              // width: 60%;
            }
          }
          .online_addr{
            padding:15px 0;
            span:nth-child(2){
              padding:13px 32px;
              background-color: #ecfcf2;
              border-radius: 24px;
              border: solid 2px #41d787;
              a{
                color:#07ab50;
                border-bottom: none;
                &:hover {
                  text-decoration: none;
                }
              }
            }
          }
           .do_base{
            width:60%;
          }
        }
      }
      //办理材料
      .serviceDeail_service{
        background-color: #fff;
        margin-top: 25px;
        padding: 0 31px;
        .service_detail{
          padding-bottom: 42px;
          border-bottom: 2px solid #efefef;
          a{
            color:#999;
          }
          a:visited{
            color:#999999;
          }
          div:nth-child(1){
            display: flex;
            justify-content: space-between;
            padding: 27px 0;
            font-size: 26px;
            span:nth-child(2){
              color:#999999
            }
          }
          div:nth-child(2){
            font-size: 22px;
            span{
              padding:11px 16px;
              background-color: #f4f3f3;
              border-radius: 21px;
              margin-right: 20px;
            }
          }
        }
      }
     // 办理指引
     .manage_guide{
       background-color: #fff;
        margin-top: 25px;
        padding: 0 31px;
        margin-bottom: 120px;
      .guide_base{
         padding: 27px 0;
         letter-spacing:6px;
         p{
           line-height: 40px;
         }
      }
     }
     .btn{
        display: flex;
        justify-content: center;
        margin:30px ;
        align-items: center;
        background-color: #ecfcf2;
        border-radius: 41px;
        border: solid 1.5px #009966;
        color:#07ab50;
        font-size: 30px;
        padding: 26px 30px;
      }
    }
  }
</style>

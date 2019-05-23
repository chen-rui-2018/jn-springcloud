<template>
  <div>
    <div class="adniministrativeHeader">
      <x-header :left-options="{backText: ''}">{{this.$route.meta.title}} <span slot="right" @touchstart="goConsult">留言</span></x-header>
    </div>
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
            <div class="online_addr"><span>在线办理</span><span @touchstart="goOnline"><a :href="dealUrl" target="_blank">请点击这里</a></span> </div>
          </div>
        </div>
        <!-- 办理材料 -->
        <div class="serviceDeail_service">
          <div class="baseInfo_title">办理材料</div>
          <div class="service_detail" v-for="(item,index) in materialList " :key="index">
            <div>
              <span class="hidden">{{item.name}}</span>
              <span >
                <a :href="'http://112.94.22.222:2381/ibps'+item.sample">下载</a>
                <i class="iconfont icon-jiantou"></i>
              </span>
            </div>
            <div>
              <span>{{item.isRequired==='0'?'非必要':'必要'}} </span>
              <span>{{item.paperQuantity}} 份纸质</span>
              <span>{{item.isNeedElectronic==='1'?"需电子档":'不需电子档'}} </span>
            </div>
          </div>

        </div>
        <!-- 办理指引 -->
        <div class="manage_guide">
          <div class="baseInfo_title">依据</div>
          <div class="guide_base">
            <p>{{serviceDetail.dealConditions}} </p>
          </div>
          <div class="baseInfo_title">办理流程</div>
          <div v-html="serviceDetail.flowPic"></div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      id: '',
      serviceDetail: {},
      materialList: [],
      dealUrl: ''
    }
  },
  mounted () {
    this.id = this.$route.query.id
    this.getserviceDetail()
  },
  methods: {
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
    goOnline () {
      this.dealUrl = `http://192.168.10.31:1101/springcloud-park/guest/portal/sp/power/getDealUrl?id=${this.id}`
    },
    goConsult () {
      this.$router.push({path: '/guest/portal/sp/power/consult', query: {id: this.id}})
    }
  }
}
</script>

<style lang="scss">
 .adniministrativeHeader{
    z-index: 10;
    position: fixed;
    top:0;
    width: 100%;
    background: #fff;
    padding:30px 34px;
    .vux-header{
      background-color: #fff;
      text-align: center;
      .vux-header-title,.vux-header-left{
        font-size: 32px;
        color:#333333;
      }
      .vux-header-left .left-arrow:before{
        content: "";
        border-color:#333;
        width:20px;
        height: 20px;
      }
      .vux-header-right{
        color:#333333;
        font-size: 26px;
      }
    }
}
  .serviceDeail{
    height: 100vh;
    background-color: #f5f5f5;
     margin-top: 110px;
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
            &:last-child{
              border:none;
            }
            justify-content: space-between;
            span:nth-child(1){
              padding-right: 44px;
              width:60%;
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
      .guide_base{
         padding: 27px 0;
         letter-spacing:6px;
         p{
           line-height: 40px;
         }
      }
     }
    }
  }
</style>

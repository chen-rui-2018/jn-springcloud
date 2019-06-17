<template>
  <div class="powerDetail">
    <div class="powerDetail_main">
      <div class="powerDetail_baseInfo">
        <div class="baseInfo_title"> 基本信息 </div>
        <div class="baseInfo_detail">
          <div><span>类别</span> <span>{{powerDetail.type}}</span> </div>
          <div><span>权利基本编码</span> <span>{{powerDetail.code}} </span> </div>
          <div><span>实施主体</span> <span>{{powerDetail.departName}}</span> </div>
          <div><span>行驶层级</span> <span>{{powerDetail.level}}</span> </div>
          <div>
            <span>实施依据</span>
            <span v-html="powerDetail.settingBasis" class="hidden do_base "></span>
            <span @click="$router.push({path:'/guest/portal/sp/power/text',query:{text:powerDetail.settingBasis}})">查看
              <i class="iconfont icon-jiantou"></i>
            </span>
            </div>
          <div><span>权利来源</span> <span>{{powerDetail.comeFrom}}</span> </div>
          <div><span>备注</span> <span class="hidden">{{powerDetail.notes}}</span> </div>
        </div>
      </div>
      <div class="powerDetail_service">
        <div class="baseInfo_title">审批服务业务</div>
        <div class="service_detail" v-for="(childItem,childIndex) in childList " :key="childIndex" >
          <div @touchstart="goServiceDetail(childItem.id)">
            <span class="hidden">{{childItem.name}}</span>
             <span>查看
              <i class="iconfont icon-jiantou"></i>
            </span>
          </div>
          <div>
            <span>办理机构：</span>
            <span>{{powerDetail.departName}} </span>
          </div>
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
      powerDetail: {},
      childList: []
    }
  },
  mounted () {
    this.id = this.$route.query.id
    this.getPowerDetail()
  },
  methods: {
    getPowerDetail () {
      this.api.get({
        url: 'getpowerDetail',
        data: {
          id: this.id
        },
        callback: res => {
          if (res.code === '0000') {
            // console.log(res)
            this.powerDetail = res.data[0]
            this.childList = res.data[0].busiModelList
          }
        }
      })
    },
    goServiceDetail (id) {
      this.$router.push({path: '/guest/portal/sp/power/serviceDetail', query: {id: id}})
    }
  }
}
</script>

<style lang="scss">
  .powerDetail{
    height: 100vh;
    background-color: #f5f5f5;
    // margin-top: 110px;
    .powerDetail_main{
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
      .powerDetail_baseInfo{
        background-color: #fff;
        padding: 0 31px;
        .baseInfo_detail{
          >div{
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
            }
          }
           .do_base{
            width:60%;
            p{
              height: 0;
            }
          }
        }
      }
      .powerDetail_service{
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
            span:nth-child(2){
              padding:11px 16px;
              background-color: #f4f3f3;
              border-radius: 21px;
            }
          }
        }
      }
    }
  }
</style>

<template>
  <div class="declarationPlatform">
    <div class="banner"><img src="@/assets/image/declarationCenter-baner.png" alt=""></div>
    <div class="declarationPlatform_list">
      <div class="declarationPlatform_tab">
        <tab>
          <tab-item v-for="(item,$index) in typeList" :key="$index" :selected="$index===typeId">
            <span :class="{'active':item.id===sendData.subordinatePlatformName}" @click="toggle(item.id)">{{item.name}}</span>
          </tab-item>
          <tab-item></tab-item>
        </tab>
      </div>
      <div class="declarationPlatform_cont">
        <ul>
          <li v-for="(item,index) in platFormList " :key="index" >
            <p>{{item.platformTitle}}</p>
            <p>
              <span>业务咨询：</span>
              <span v-html="item.businessConsult"></span>
            </p>
            <p v-if="sendData.subordinatePlatformName!='1'">
              <span>账号密码：</span>
              <span><input type="text" v-model="item.accountAndPassword" @input="changeap(item.accountAndPassword,item.id)" placeholder="输入账号密码,例：admin/123(限50字)" maxlength="50"></span></p>
            <p>{{item.remark}} </p>
          </li>
        </ul>
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
      typeList: [],
      typeId: '1',
      sendData: {
        page: 1,
        rows: 3,
        subordinatePlatformName: '1'
      },
      platFormList: [],
      onFetching: false,
      total: 0,
      platformId: '',
      accountAndPassword: ''
    }
  },
  mounted () {
    this.getTypeList()
    this.getPlatformList()
    console.log(sessionStorage.getItem('token'))
  },
  methods: {
    // 备忘录
    changeap (accountAndPassword, id) {
      this.platformId = id
      this.accountAndPassword = accountAndPassword
      this.api.post({
        url: 'addOrEditMemorandum',
        data: {
          accountAndPassword: this.accountAndPassword,
          platformId: this.platformId
        },
        dataFlag: true,
        callback: (res) => {
          // console.log(res);
          if (res.code === '0000') {
          }
        }
      })
    },
    getTypeList () {
      this.api.get({
        url: 'platformType',
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
    getPlatformList () {
      this.sendData.page = 1
      this.api.get({
        url: 'getPlatformList',
        data: this.sendData,
        callback: res => {
          if (res.code === '0000') {
            this.platFormList = res.data.rows
            this.total = res.data.total
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    onScrollBottom () {
      if (this.onFetching === false) {
        if (this.sendData.page < Math.ceil(this.total / this.sendData.rows)) {
          this.onFetching = true
          setTimeout(() => {
            this.sendData.page++
            this.api.get({
              url: 'getPlatformList',
              data: this.sendData,
              callback: res => {
                if (res.code === '0000') {
                  this.onFetching = false
                  this.platFormList.push(...res.data.rows)
                  // console.log(...res.data.rows)
                }
              }
            })
          }, 1000)
        } else {
        }
      }
    },
    toggle (id) {
      this.sendData.subordinatePlatformName = id
      this.getPlatformList()
    }
  }
}
</script>

<style lang="scss">
  .declarationPlatform{
    .banner{
      // padding-top: 105px;
      img{
        width:100%;
      }
    }
    .declarationPlatform_list{
       .declarationPlatform_tab{
        // padding-top: 110px;
        // position: relative;
        // top:0;
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
          // margin-right: 30px;
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
      .declarationPlatform_cont{
        padding-top: 95px;
        ul{
          padding:0 34px;
          li{
            padding: 34px 0;
            border-bottom: 2px solid #efefef;
            font-size: 26px;
            p:nth-child(1){
              font-size: 34px;
              color:#538aef;
            }
            p:nth-child(2){
              padding-top: 32px;
              display: flex;
              span:nth-child(1){
                width:25%;
              }
              span:nth-child(2){
                color:#666666;
                flex:1;
              }
            }
            p:nth-child(3){
              padding-top: 16px;
              display: flex;
              span:nth-child(1){
                width:25%;
              }
              span:nth-child(2){
                color:#666666;
                width:70%;
              }
              input{
                width:100%
              }
            }
            p:nth-child(4){
              padding-top: 30px;
              color:#333333;
            }

          }
        }
      }
    }
  }
</style>

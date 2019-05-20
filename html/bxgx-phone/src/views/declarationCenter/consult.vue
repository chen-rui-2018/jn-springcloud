<template>
  <div class="declarationconsult">
    <div class="declarationconsult_main">
      <div class="declarationconsult_cont">
        <div class="declarationconsult_title">留言内容</div>
        <div class="declarationconsult_form" >
          <group label-align="left" label-width="4.5em" label-margin-right="2em">
            <x-input title="企业名称" placeholder="请输入内容" v-model="messageform.companyName" ></x-input>
            <x-input title="联系人" placeholder="请输入内容" v-model="messageform.concatName"></x-input>
            <x-input title="联系电话" placeholder="请输入内容" v-model="messageform.concatPhone"></x-input>
          </group>
        </div>
      </div>
      <div class="form_textarea">
        <div class="form_textarea_title" >咨询内容</div>
        <x-textarea placeholder="1、问题描述 2、诉求目的" :show-counter="false" :rows="3" v-model="messageform.message"></x-textarea>
      </div>
      <div class="sumbmit">
        <span @touchstart="sumbmit">提交</span>
      </div>
      <div>
        <confirm v-model="isVisible"
        title="留言成功，是否跳到上一页"
        theme="android"
        @on-cancel="onCancel"
        @on-confirm="this.$router.go(-1)"
       >
          <p style="text-align:center;">{{ $t('I miss u sunyi') }}</p>
        </confirm>
      </div>
    </div>
  </div>
</template>
<script>
import { XInput, XTextarea, Group } from 'vux'
export default {
  components: {
    XInput,
    XTextarea,
    Group
  },
  data () {
    return {
      messageform: {
        companyName: '',
        concatName: '',
        concatPhone: '',
        fromBusiId: '',
        message: ''
      },
      isVisible: false
    }
  },
  mounted () {
    this.messageform.id = this.$route.query.id
  },
  sumbmit () {
    this.api.get({
      url: 'spMessage',
      data: this.messageform,
      callback: res => {
        if (res.code === '0000') {
          // console.log(res)
          this.isVisible = true
        }
      }
    })
  },
  onCancel () {
    this.isVisible = false
    this.messageform.companyName = ''
    this.messageform.concatName = ''
    this.messageform.concatPhone = ''
    this.messageform.message = ''
  }
}
</script>

<style lang="scss">
  .declarationconsult{
    height: 100vh;
    background-color: #f5f5f5;
    .declarationconsult_main{
      padding-top:26px;
      .declarationconsult_cont{
        background-color: #fff;
        padding: 0 31px;
        .declarationconsult_title{
          font-size: 35px;
          padding-top: 28px;
        }
        .declarationconsult_form{
          .weui-cells{
            margin-top: 0;
          }
          .weui-cell{
            padding:28px 0;
            border-top: 2px solid #efefef;
            &:first-child{
              border-top:none;
            }
          }
          .weui-label{
            font-size: 26px;
          }
          .weui-cell:before{
            border-top:none;
          }
          .weui-cells:before{
            display: none;
          }
          .weui-cells:after{
            display: none;
          }
        }
      }
      .form_textarea{
        background-color: #fff;
        margin-top: 26px;
        padding: 0 31px;
        // margin-bottom: 100px;
        .form_textarea_title{
          font-size: 26px;
          padding-top: 27px;
        }
        .weui-cell:before{
          display: none;
        }
        .weui-cell{
          padding:27px 0;
        }
      }
      .sumbmit{
        display: flex;
        justify-content: center;
        margin-top: 38px;
        align-items: center;
        span{
          display: inline-block;
          background-color: #ecfcf2;
          border-radius: 41px;
          border: solid 1px #009966;
          padding:26px 312px;
          color:#07ab50;
          // margin: 38px 37px;
        }
      }
    }
  }
</style>

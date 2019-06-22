<template>
  <div class="declartionConsult">
    <div class="declartionConsult_main">
      <div class="declartionConsult_cont">
        <div class="declartionConsult_title">在线预约</div>
        <div class="declartionConsult_form" >
          <group label-align="left" label-width="100%" label-margin-right="1em">
            <!-- <x-input title="* 预约项：" placeholder="请输入内容" v-model="appointment.appointmentItemName" ></x-input> -->
            <x-input title="* 申报项目：" placeholder="请输入内容" v-model="appointment.declareItem"></x-input>
            <x-input title="* 申报企业：" placeholder="请输入内容" v-model="appointment.declareEnterprise"></x-input>
            <x-input title="* 企业联系人：" placeholder="请输入内容" v-model="appointment.contactName"></x-input>
            <x-input title="* 联系电话：" placeholder="请输入内容" v-model="appointment.contactPhone"></x-input>
            <!-- <x-input title="* 电子邮箱：" placeholder="请输入内容" v-model="appointment.email"></x-input> -->
            <div class="upload">
              <div>* 附件：</div>
              <input type="file" @change="fileChange($event)" v-if="isSumbmitShow">
              <a v-else :href="appointment.fileUrl">下载<i class="iconfont icon-jiantou"></i></a>
            </div>
          </group>
        </div>
      </div>
      <div class="form_textarea">
        <div class="form_textarea_title" >预约内容</div>
        <x-textarea placeholder="1、问题描述 2、诉求目的" :show-counter="false" :rows="3" v-model="appointment.remark "></x-textarea>
      </div>
      <div class="sumbmit" v-if="isSumbmitShow">
        <span @click="sumbmit">提交</span>
      </div>
      <div class="success">
        <confirm v-model="isVisible"
        title="留言成功，是否跳到上一页"
        theme="android"
        @on-cancel="onCancel"
        @on-confirm="$router.go(-1)"
       >
          <p style="text-align:center;"></p>
        </confirm>
      </div>
    </div>
  </div>
</template>
<script>
import { XInput, XTextarea, Group, Confirm } from 'vux'
export default {
  components: {
    XInput,
    XTextarea,
    Group,
    Confirm
  },
  data () {
    return {
      appointment: {
        appointmentItemId: '', // 关联的公告ID
        appointmentItemName: '', // 公告标题名称
        contactName: '', // 联系人姓名
        contactPhone: '', // 联系人电话
        email: '', // 电子邮箱
        fileUrl: '', // 附件地址
        remark: '', // 备注
        declareEnterprise: '', // 申报企业
        declareItem: ''// 申报项目名称
      },
      isVisible: false,
      isSumbmitShow: true
    }
  },
  mounted () {
    this.appointment.appointmentItemId = this.$route.query.id
    this.init()
  },
  methods: {
    sumbmit () {
      if (this.appointment.appointmentItemName !== '' || this.appointment.contactName !== '' || this.appointment.contactPhone !== '' || this.appointment.email !== '' || this.appointment.fileUrl !== '' || this.appointment.declareEnterprise !== '' || this.appointment.declareItem !== '') {
        this.api.post({
          url: 'onlineBooking',
          data: this.appointment,
          callback: res => {
            if (res.code === '0000') {
              this.isVisible = true
            } else {
              this.$vux.toast.text(res.result, 'middle')
            }
          }
        })
      } else {
        this.$vux.toast.text('带*号的表格请填写完整', 'middle')
      }
    },
    init () {
      this.api.get({
        url: 'queryOnlineInfo',
        data: {appointmentItemId: this.appointment.appointmentItemId},
        callback: (res) => {
          if (res.code === '0000') {
            this.appointment = res.data
            this.appointment.declareItem = res.data.appointmentItemName
            this.isSumbmitShow = false
            this.$vux.toast.text('亲！您已经预约过了', 'middle')
          } else if (res.code === '5011208') {
            this.api.get({
              url: 'getUserExtension',
              data: { },
              callback: (res) => {
                if (res.code === '0000') {
                  this.appointment.declareItem = this.$route.query.title
                  this.appointment.contactName = res.data.nickName
                  this.appointment.contactPhone = res.data.phone
                  this.appointment.email = res.data.email
                  this.appointment.declareEnterprise = res.data.companyName
                  this.appointment.fileUrl = res.data.fileUrl
                } else {
                  this.$vux.toast.text(res.result, 'middle')
                }
              }
            })
          } else {
            this.$vux.toast.show({
              text: res.result,
              time: 1000,
              position: 'middle'
            })
            setTimeout(() => {
              this.$router.go(-1)
            }, 1300)
          }
        }
      })
    },
    onCancel () {
      this.isVisible = false
      this.appointment.companyName = ''
      this.appointment.concatName = ''
      this.appointment.concatPhone = ''
      this.appointment.message = ''
    },
    fileChange (event) {
      if (event.target.files[0]) {
        const formData = new FormData()
        formData.append('file', event.target.files[0])
        this.api.post({
          url: 'fastUpload',
          data: formData,
          headerType: 'multipart/form-data',
          callback: res => {
            if (res.code === '0000') {
              this.appointment.fileUrl = res.data
            } else {
              this.$vux.toast.text(res.result, 'middle')
            }
          }
        })
      }
    }
  }
}
</script>

<style lang="scss">
  .declartionConsult{
    height: 100vh;
    background-color: #f5f5f5;
    .declartionConsult_main{
      // padding-top:130px;
      .declartionConsult_cont{
        background-color: #fff;
        padding: 0 31px;
        .declartionConsult_title{
          font-size: 35px;
          padding-top: 28px;
        }
        .declartionConsult_form{
          .upload{
            padding:28px 0;
            border-top: 2px solid #efefef;
            display: flex;
            div{
              width:28%
            }
            input{
              width: 70%
            }
            a{
              color: #000;
            }
          }
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
        .weui-textarea{
          height: 180px;
        }
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
      .success{
        .weui-dialog{
          max-width:20em;
        }
        .weui-skin_android .weui-dialog__ft{
          text-align:center;
          font-size: 1.5em;
        }
        .weui-skin_android .weui-dialog__title{
          font-size: 1.5em;
        }
      }
    }
  }
</style>

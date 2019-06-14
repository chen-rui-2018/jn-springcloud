<template>
  <div class="declartionConsult">
    <div class="declartionConsult_main">
      <div class="declartionConsult_cont">
        <div class="declartionConsult_title">咨询内容</div>
        <div class="declartionConsult_form" >
          <group label-align="left" label-width="4.5em" label-margin-right="2em">
            <x-input title="预约项：" placeholder="请输入内容" v-model="appointment.appointmentItemName" ></x-input>
            <x-input title="预约人：" placeholder="请输入内容" v-model="appointment.contactName"></x-input>
            <x-input title="联系电话：" placeholder="请输入内容" v-model="appointment.contactPhone"></x-input>
            <x-input title="电子邮箱：" placeholder="请输入内容" v-model="appointment.email"></x-input>
            <x-input title="申报企业：" placeholder="请输入内容" v-model="appointment.declareEnterprise"></x-input>
            <x-input title="申报名称：" placeholder="请输入内容" v-model="appointment.declareItem"></x-input>
          </group>
        </div>
      </div>
      <div class="form_textarea">
        <div class="form_textarea_title" >咨询内容</div>
        <x-textarea placeholder="1、问题描述 2、诉求目的" :show-counter="false" :rows="3" v-model="appointment.message"></x-textarea>
      </div>
      <div class="sumbmit">
        <span @click="sumbmit">提交</span>
      </div>
      <div>
        <confirm v-model="isVisible"
        title="留言成功，是否跳到上一页"
        theme="android"
        @on-cancel="onCancel"
        @on-confirm="this.$router.go(-1)"
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
      isVisible: false
    }
  },
  mounted () {
    this.appointment.id = this.$route.query.id
  },
  methods: {
    sumbmit () {
      this.api.get({
        url: 'spMessage',
        data: this.appointment,
        callback: res => {
          if (res.code === '0000') {
            this.isVisible = true
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
    }
  }
</style>

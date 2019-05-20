<template>
    <div class="demandRaise">
        <div class="info">
            你正在对<span>南京会计事务所机构的</span><i>法律咨询产</i>品提交服务需求，请认真填写需求描述和联系人信息，机构/顾问收到需求后将与您联系对接
        </div>
        <div class="describe">
            <div class="form_textarea">
                <div class="form_textarea_title">需求描述</div>
                <x-textarea placeholder="请填写需求描述，最多可输入300字" :show-counter="false" :rows="3"></x-textarea>
            </div>
            <div class="consult_form">
                <group label-align="left" label-width="5em" label-margin-right="2em">
                    <x-input title="联系人姓名" placeholder="请输入内容" v-model="value3"></x-input>
                    <x-input title="联系人职务" placeholder="请输入内容" v-model="value3"></x-input>
                    <x-input title="联系人手机" placeholder="请输入内容" v-model="value3"></x-input>
                    <x-input title="联系人邮箱" placeholder="请输入内容" v-model="value3"></x-input>
                </group>
            </div>
        </div>
        <div class="sumbmit">
            <span>提交</span>
        </div>
        <div class="tip">“市场提醒：请务必在线订购，线下交易无法享受市场交易安全保障”</div>
    </div>
</template>
<script>
import { Group, XInput, XTextarea } from 'vux'
export default {
  components: {
    Group,
    XInput,
    XTextarea
  },
  data () {
    return {
      value1: '',
      value3: '',
      value4: ''
    }
  }
}
</script>
<style lang="scss">
.demandRaise {
    background: #f5f5f5;
    height: 100vh;
    width: 100%;
  .info {
    padding: 28px 34px;
    width: 100%;
    border-top: 2px solid #eee;
    font-size: 26px;
    line-height: 40px;
    background: #fff;
    margin-bottom: 20px;
    color: #222;
    span{
        color: #0dac53;
    }
    i{
        color: #f19149;
    }
  }

  .describe {
    // padding: 28px 34px;
    width: 100%;
    font-size: 26px;
    color: #333;
    .consult_title {
      font-size: 35px;
      padding-top: 28px;
    }
    .consult_form {
      .weui-cells {
        margin-top: 0;
      }
      .weui-cell {
        padding: 28px;
        border-top: 2px solid #efefef;
      }
      .weui-label {
        font-size: 26px;
      }
      .weui-cell:before {
        border-top: none;
      }
      .weui-cells:before {
        display: none;
      }
      .weui-cells:after {
        display: none;
      }
      .weui-cell:last-child {
        border-bottom: 2px solid #efefef;
      }
      .weui-cell__primary{
          font-size: 26px;
      }
    }
    .form_textarea {
      background-color: #fff;
      margin-top: 26px;
      padding: 0 31px;
      .form_textarea_title {
        font-size: 26px;
        padding-top: 27px;
      }
      .weui-cell:before {
        display: none;
      }
      .weui-cell {
        padding: 27px 0;
      }
    }
  }
  .sumbmit {
    display: flex;
    justify-content: center;
    margin: 38px 0;
    align-items: center;
    span {
      display: inline-block;
      background-color: #ecfcf2;
      border-radius: 41px;
      border: solid 1px #009966;
      padding: 26px 312px;
      // margin: 38px 37px;
      font-size: 30px;
      color: #07AB50;
    }
  }
  .tip{
      text-align: center;
      color: red;
      font-size: 22px;
  }
}
</style>

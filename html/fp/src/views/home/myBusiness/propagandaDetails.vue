<template>
  <div class="propagandaDetails">
    <div class="ordinary_title font16">
      <div>宣传详情</div>
    </div>
    <div class="ordinary_content">
      <el-form label-width="140px" class="postJobInfo">
        <el-form-item label="发布平台:" prop="post">
          <span>{{issuePlatform}}</span>
        </el-form-item>
        <el-form-item label="生效日期:">
          <span>{{effectiveDate}}</span>
        </el-form-item>
        <el-form-item label="失效日期:">
          <span>{{invalidDate}}</span>
        </el-form-item>
        <el-form-item label="宣传产品:">
          <span>{{propagandaTitle}}</span>
        </el-form-item>
        <el-form-item label="宣传详情:" class="ue">
           <div class="editor-container">
            <UE ref="ue" :default-msg="defaultMsg" :config="config" />
          </div>
          <!-- <span v-html="propagandaDetails">{{propagandaDetails}}</span> -->
        </el-form-item>
        <el-form-item label="宣传海报:">
          <span v-if="posterUrl" class="posterUrlBtn" @click="lookPoster(posterUrl)">点击查看</span>
          <span v-if="!posterUrl">暂无海报图片</span>
          <!-- <span>{{posterUrl}}</span> -->
        </el-form-item>
        <el-form-item label="宣传区域:" class="propagandaArea">
          <!-- <div :class="{'propagandaAreaActive':idx==index}" v-for="(item ,idx) in propagandaAreaArr" :key="idx">
            <img :src="item.propagandaAreaUrl" alt="宣传区域图片"></div> -->
          <img :src="propagandaAreaUrl" alt="" style="width:85px;height:85px">
          <el-radio-group v-model="radio">
            <el-radio :label=0 v-show="position==='top'">顶部</el-radio>
            <el-radio :label=1 v-show="position==='central'">中部</el-radio>
            <el-radio :label=2 v-show="position==='bottom'">底部</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="宣传费用（元）:">
          <span>{{propagandaFee}}</span>
        </el-form-item>
        <div class="business_footer" @click="$router.go(-1)">
          返回
        </div>
      </el-form>
    </div>
    <el-dialog :modal-append-to-body="false" title="海报图片" :visible.sync="dialogVisible" width="39%">
      <img :src="posterUrl" alt="海报图片" style="width:100%;">
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">返 回</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import UE from '@/components/ue.vue'
export default {
   components: { UE },
  data() {
    return {
       defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      radio: undefined,
      propagandaAreaArr: [],
      approvalStatus: "",
      dialogVisible: false,
      propagandaId: "",
      issuePlatform: "",
      effectiveDate: "",
      invalidDate: "",
      propagandaTitle: "",
      // propagandaDetails: "",
      posterUrl: "",
      propagandaAreaUrl: "",
      propagandaFee: "",
      position: undefined
    };
  },
  mounted() {
    this.initList();
  },
  methods: {
    // 获取宣传区域信息
    getPropagandaAreaList() {
      this.api.get({
        url: "getPropagandaAreaList",
        //  data:this.publicityForm,
        callback: res => {
          console.log(res);
          if (res.code === "0000") {
            for (let i = 0; i < res.data.length; i++) {
              if (this.position === res.data[i].propagandaArea) {
                this.propagandaAreaUrl = res.data[i].propagandaAreaUrl;
                return;
              }
            }
          }
        }
      });
    },
    //   初始化
    initList() {
      this.propagandaId = this.$route.query.propagandaId;
      //  this.approvalStatus=this.$route.query.approvalStatus
      this.api.get({
        url: "getBusinessPromotionDetails",
        data: { propagandaId: this.propagandaId },
        callback: res => {
          console.log(res);
          if (res.code === "0000") {
            this.issuePlatform = res.data.issuePlatform;
            this.effectiveDate = res.data.effectiveDate;
            this.invalidDate = res.data.invalidDate;
            this.propagandaTitle = res.data.propagandaTitle;
            this.defaultMsg = res.data.propagandaDetails;
            this.posterUrl = res.data.posterUrl;
            // this.propagandaAreaUrl = res.data.propagandaAreaUrl;
            this.propagandaFee = res.data.propagandaFee;
            this.position = res.data.propagandaArea;
            if (res.data.propagandaArea === "top") {
              this.radio = 0;
            } else if (res.data.propagandaArea === "central") {
              this.radio = 1;
            } else if (res.data.propagandaArea === "bottom") {
              this.radio = 2;
            }
            this.getPropagandaAreaList();
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    //   查看海报图片
    lookPoster(posterUrl) {
      if (!posterUrl) {
        this.$message.error("此宣传没有宣传海报");
      } else {
        this.dialogVisible = true;
      }
    },
    toEnterprisePropaganda() {
      this.$router.push({
        name: "enterprisePropaganda",
        query: { status: this.$route.query.status }
      });
    }
  }
};
</script>

<style lang="scss">
.propagandaDetails {
  .propagandaAreaActive {
    border: 2px solid green;
  }
  width: 100%;
  color: #999;
  .el-form-item__label {
    margin-right: 30px;
    line-height: 26px;
  }
  .posterUrlBtn {
    color: #00a041;
    width: 46px;
    height: 11px;
    font-size: 11px;
    font-family: MicrosoftYaHei;
    font-weight: 400;
    color: rgba(0, 160, 65, 1);
    line-height: 20px;
    cursor: pointer;
  }
  .ordinary_title {
    background-color: #fff;

    padding: 24px 28px;
    // font-size: 13px;
    border-radius: 5px;
  }
  .ordinary_content {
    margin-top: 14px;
    background: #fff;
    padding: 36px 0px;
    .postJobInfo {
      width: 50%;
      margin: 0 auto;
      // margin-left: 200px;

      .el-form-item__content,
      .el-select {
        width: 266px;
      }
      .el-textarea__inner {
        width: 348px;
        min-height: 100px !important;
        background: #fff;
      }
      .el-form-item__content {
        line-height: 26px;
      }
    }
    .business_footer {
      margin: 0 auto;
      margin-top: 58px;
      border-radius: 4px;
      text-align: center;
      cursor: pointer;
      height: 29px;
      line-height: 29px;
      width: 90px;
      color: #41d787;
      background: rgba(236, 252, 242, 1);
      border: 1px solid rgba(65, 215, 135, 1);
      margin-bottom: 17px;
    }
  }
  .propagandaArea {
    .el-radio-group {
      display: block;
      line-height: 1;
      width: 85px;
      // vertical-align: middle;
      font-size: 0;
      margin-left: 30px;
      margin-top: 5px;
      text-align: center;
      .el-radio {
        width: 100%;
      }
    }
  }
   .ue{
        .el-form-item__content,
      .el-select {
        width: 100%!important;
      }
      .el-form-item__content{
        line-height: 22px;
      }
      .edui-default .edui-editor-bottomContainer{
        display: none;
      }
      }
}
</style>

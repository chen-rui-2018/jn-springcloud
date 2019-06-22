<template>
  <div class="publishingProduct" v-loading="loading">
    <div class="ordinary_title font16">
      <div>发布宣传</div>
      <div @click="toEnterprisePropaganda">返回</div>
    </div>
    <div class="ordinary_content">
      <el-form :model="publicityForm" :rules="rules" ref="publicityForm" label-width="124px" class="postJobInfo">
        <el-form-item label="发布平台:" prop="issuePlatform">
          <el-select v-model="publicityForm.issuePlatform" placeholder="请选择发布平台" clearable class="filter-item">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="生效日期:" prop="effectiveDate">
          <el-date-picker v-model="publicityForm.effectiveDate" value-format="yyyy-MM-dd" type="date" placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <!-- <el-form-item label="失效日期:" prop="invalidDate">
     <el-date-picker
      v-model="publicityForm.invalidDate"
        value-format="yyyy-MM-dd"
      type="date"
      placeholder="选择日期">
    </el-date-picker>
  </el-form-item> -->
        <el-form-item label="宣传产品:" prop="propagandaTitle">
          <el-input v-model="publicityForm.propagandaTitle"></el-input>
        </el-form-item>
        <el-form-item label="宣传类型:" prop="propagandaType">
          <el-select v-model="publicityForm.propagandaType" placeholder="请选择宣传类型" clearable class="filter-item">
            <el-option v-for="item in propagandaTypeOptions" :key="item.propagandaTypeCode" :label="item.propagandaTypeName"
              :value="item.propagandaTypeCode" @click.native="selecteStatus(item)" />
          </el-select>
        </el-form-item>
        <el-form-item label="宣传详情:" prop="propagandaDetails">
          <el-input type="textarea" v-model="publicityForm.propagandaDetails" placeholder="宣传详情宣传详情"></el-input>
        </el-form-item>
        <el-form-item label="宣传海报:">
          <el-upload :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'" :headers="headers" :show-file-list="false"
            :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
            <img v-if="publicityForm.posterUrl" :src="publicityForm.posterUrl" alt="宣传图片">
            <i v-else class="el-icon-plus "></i>
          </el-upload>
          <!-- <el-dialog :visible.sync="dialogVisible">
            <img
              style="width:100%;height:200px;"
              :src="dialogImageUrl"
              alt=""
            >
          </el-dialog> -->
        </el-form-item>
        <el-form-item label="宣传区域:" class="propagandaAreaUrl" prop="propagandaAreaUrl">
          <!-- <el-radio-group v-model="publicityForm.propagandaAreaUrl">
    <el-radio label="top">顶部</el-radio>
    <el-radio label="central">中部</el-radio>
    <el-radio label="bottom">底部</el-radio> -->
          <!-- </el-radio-group> -->
          <div :class="{'propagandaAreaActive':idx==index}" v-for="(item ,idx) in propagandaAreaArr" :key="idx" @click="getPropagandaAreaUrl(item,idx)">
            <img :src="item.propagandaAreaUrl" alt="宣传区域图片">
            <el-radio-group v-model="radio">
              <el-radio :label=0 v-show="item.propagandaArea==='top'">顶部</el-radio>
              <el-radio :label=1 v-show="item.propagandaArea==='central'">中部</el-radio>
              <el-radio :label=2 v-show="item.propagandaArea==='bottom'">底部</el-radio>
            </el-radio-group>
          </div>
        </el-form-item>
        <el-form-item label="宣传费用（元）:" class="propaganda">
          <div class="price ct smallSize" :class="{'propagandaTimeActive':inx==priceIndex}" @click="getPropagandaTime(item,inx)"
            v-for="(item ,inx) in propagandaFeeArr" :key="inx">
            <div :class="{'redColor':inx==priceIndex}">￥{{Number(item.propagandaFee).toFixed(2)}} </div>
            <div>{{item.date}}</div>
          </div>
          <!-- <span class="propagandaFeeStyle">{{publicityForm.propagandaFee}}</span> -->
          <div style="margin-top:10px;" @click="toPublicityExpense" class="mainColor smallSize pointer">宣传费用规则</div>
        </el-form-item>
        <div class="business_footer" :disabled="isDisabled" @click="submitForm('publicityForm')">
          提交申请
        </div>
      </el-form>
    </div>
  </div>
</template>
<script>
import { getToken } from '@/util/auth'
export default {
  data() {
    return {
      radio:undefined,
      loading: false,
      baseUrl: this.api.host,
      priceIndex: undefined,
      index: undefined,
      headers: {
        token: getToken()
      },
      currentItem: "",
      isDisabled: false,
      propagandaAreaArr: [],
      propagandaTypeOptions: [],
      propagandaFeeOptions: [],
      statusOptions: [
        {
          value: "1",
          label: "App"
        },
        {
          value: "2",
          label: "门户"
        },
        {
          value: "3",
          label: "其它"
        }
      ],
      currentTime: "",
      proFeeRuleDetails: "",
      // dialogImageUrl: "",
      dialogVisible: false,
      publicityForm: {
        issuePlatform: "",
        effectiveDate: "",
        // invalidDate:'',
        propagandaTitle: "",
        propagandaArea: "",
        propagandaAreaUrl: "",
        proFeeRuleCode: "",
        propagandaType: "",
        areaAmount: "",
        id: "",
        posterUrl: "",
        propagandaTime: "",
        propagandaFee: ""
      },
      propagandaFeeArr: [
        { propagandaFee: "", date: "宣传一个月", num: 1 },
        { propagandaFee: "", date: "宣传三个月", num: 3 },
        { propagandaFee: "", date: "宣传六个月", num: 6 },
        { propagandaFee: "", date: "宣传一年", num: 12 }
      ],
      rules: {
        issuePlatform: [
          { required: true, message: "请选择发布平台", trigger: "change" }
        ],
        effectiveDate: [
          { required: true, message: "请选择生效日期", trigger: "change" }
        ],
        // invalidDate: [
        //   { required: true, message: '请选择失效日期', trigger: 'change' }
        // ],
        propagandaTitle: [
          { required: true, message: "请输入产品名称", trigger: "blur" }
        ],
        // propagandaType: [
        //   { required: true, message: "请选择宣传类型", trigger: "change" }
        // ],
        propagandaDetails: [
          { required: true, message: "请填写宣传详情", trigger: "blur" }
        ]
      }
    };
  },
  mounted() {
    this.initList();
  },
  methods: {
    initList() {
      // Promise.all([this.getPropagandaTypeList, this.getPropagandaFeeRulesList])
      // .then(arr => {
      //   console.dir(arr)
      // })
      this.getPropagandaTypeList().then(() => {
        this.getPropagandaFeeRulesList().then(() => {
          for (const type of this.propagandaTypeOptions) {
            for (const rule of this.propagandaFeeOptions) {
              if (rule.proFeeRuleCode === type.propagandaTypeCode) {
                type.price = rule.propagandaFee;
              }
            }
          }
        });
      });

      this.getPropagandaAreaList();
      this.currentTime = this.api.getCurrentTime();
    },
    // 获取选中的区域信息
    getPropagandaAreaUrl(item, idx) {
      this.publicityForm.propagandaArea = item.propagandaArea;
      this.publicityForm.propagandaAreaUrl = item.propagandaAreaUrl;
      this.publicityForm.areaAmount = item.areaAmount;
      this.index = idx;
      this.radio=idx
      this.calcPrice();
    },
    // 选择宣传时间
    getPropagandaTime(item, inx) {
      if (item.date == "宣传一个月") {
        this.publicityForm.propagandaTime = 1;
      } else if (item.date == "宣传三个月") {
        this.publicityForm.propagandaTime = 3;
      } else if (item.date == "宣传六个月") {
        this.publicityForm.propagandaTime = 6;
      } else if (item.date == "宣传一年") {
        this.publicityForm.propagandaTime = 12;
      }
      this.publicityForm.propagandaFee = item.propagandaFee;
      this.priceIndex = inx;
    },
    // 获取选中的宣传类型
    selecteStatus(item) {
      console.log(item);
      this.currentItem = item;
      this.propagandaFeeOptions.forEach(v => {
        if (item.propagandaTypeCode == v.proFeeRuleCode) {
          this.proFeeRuleDetails = v.proFeeRuleDetails;
          this.publicityForm.proFeeRuleCode = v.proFeeRuleCode;
        }
      });
      console.log(this.proFeeRuleDetails);
      // console.dir(this.publicityForm);
      this.calcPrice();
      // for (let i = 0; i < this.propagandaFeeOptions.length; i++) {
      //  if(value===this.propagandaFeeOptions[i].proFeeRuleCode){
      //    this.publicityForm.proFeeRuleCode=this.propagandaFeeOptions[i].proFeeRuleCode
      //   //  this.publicityForm.propagandaFee=this.propagandaFeeOptions[i].propagandaFee
      //   //  for(let i=0;i<this.propagandaFeeArr.length;i++){
      //   //    this.propagandaAreaArr[i].propagandaFee=this.publicityForm.propagandaFee*(i+1)
      //   //  }
      //   //  this.proFeeRuleDetails=this.propagandaFeeOptions[i].proFeeRuleDetails
      //    return
      //  }
      // }
    },
    calcPrice() {
      this.propagandaFeeArr.forEach((val, index) => {
        val.propagandaFee =
          Number(this.currentItem.price * val.num) +
          Number(this.publicityForm.areaAmount);
      });
    },
    // 获取宣传类型
    getPropagandaTypeList() {
      return new Promise(resolve => {
        this.api.get({
          url: "getPropagandaTypeList",
          //  data:this.publicityForm,
          callback: res => {
            console.log(res);
            if (res.code === "0000") {
              this.propagandaTypeOptions = res.data;
            }
            resolve();
          }
        });
      });
    },
    // 获取宣传区域信息
    getPropagandaAreaList() {
      this.api.get({
        url: "getPropagandaAreaList",
        //  data:this.publicityForm,
        callback: res => {
          console.log(res);
          if (res.code === "0000") {
            this.propagandaAreaArr = res.data;
          }
        }
      });
    },
    // 获取宣传费用规则
    getPropagandaFeeRulesList() {
      return new Promise(resolve => {
        this.api.get({
          url: "getPropagandaFeeRulesList",
          //  data:this.publicityForm,
          callback: res => {
            console.log(res);
            if (res.code === "0000") {
              this.propagandaFeeOptions = res.data;
            }
            resolve();
          }
        });
      });
    },
    toEnterprisePropaganda() {
      this.$router.push({ name: "enterprisePropaganda" });
    },
    handleExceed(files, fileList) {
      this.$message.warning(`只能上传一张海报图片`);
    },
    handleRemove(file, fileList) {
      this.dialogImageUrl = "";
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    handleAvatarSuccess(res, file) {
      this.publicityForm.posterUrl = res.data;
    },
    beforeAvatarUpload(file) {
      const isLt2M = file.size / 1024 / 1024 < 1;
      const isJPG = file.type === "image/jpeg" || file.type === "image/png";
      if (!isLt2M) {
        this.$message.error("上传图片大小不能超过 1MB!");
      }
      if (!isJPG) {
        this.$message.error("上传图片只能是 JPG、png 格式!");
      }
      return isJPG && isLt2M;
    },
    toPublicityExpense() {
      if (!this.publicityForm.propagandaType) {
        this.$message.error("请先选择宣传类型");
        return;
      }

      this.$router.push({
        name: "publicityExpense",
        query: { proFeeRuleDetails: this.proFeeRuleDetails }
      });
    },
    submitForm(publicityForm) {
      this.isDisabled = true;
      console.log(this.publicityForm.posterUrl);
      this.$refs[publicityForm].validate(valid => {
        if (valid) {
          console.log(this.publicityForm);
          if (
            new Date(this.publicityForm.effectiveDate) <=
            new Date(this.currentTime)
          ) {
            this.$message.error("生效日期必须大于当前日期,请重新选择");
            this.isDisabled = false;
            return;
          }
          //  if(new Date(this.publicityForm.effectiveDate)>= new Date(this.publicityForm.invalidDate)){
          //   this.$message.error('失效日期必须大于生效日期,请重新选择')
          //   this.isDisabled=false
          //   return
          // }
          if (!this.publicityForm.posterUrl) {
            this.$message.error("请选择海报图片");
            this.isDisabled = false;
            return;
          }
          if (!this.publicityForm.propagandaAreaUrl) {
            this.$message.error("请选择宣传区域");
            this.isDisabled = false;
            return;
          }
          if (!this.publicityForm.propagandaTime) {
            this.$message.error("请选择宣传费用");
            this.isDisabled = false;
            return;
          }
          this.loading = true;
          this.api.post({
            url: "saveBusinessPromotion",
            data: this.publicityForm,
            callback: res => {
              this.loading = false;
              if (res.code === "0000") {
                this.$message({
                  message: "操作成功,请等待审核",
                  type: "success"
                });
                this.$router.push({ name: "enterprisePropaganda" });
                this.$refs[publicityForm].resetFields();
                this.publicityForm.posterUrl = "";
                this.priceIndex = undefined;
                this.index = undefined;
                this.propagandaFeeArr.forEach(val => {
                  val.propagandaFee = "";
                });
              } else {
                this.$message.error(res.result);
              }
            }
          });
        }
      });
    }
  }
};
</script>

<style lang="scss">
.propagandaAreaActive {
  border: 2px solid green;
}

.propaganda {
  .el-form-item__content {
    line-height: unset;
  }
}
.price {
  display: inline-block;
  margin-right: 40px;
  width: 85px;
  height: 85px;
  cursor: pointer;
  color: #999;
  background: rgba(245, 245, 245, 1);
  border: 1px solid rgba(232, 232, 232, 1);
  border-radius: 4px;
  > div:nth-child(1) {
    padding: 18px;
  }
}
.propagandaTimeActive {
  background: rgba(236, 252, 242, 1);
  color: #00a041;
  border: 1px solid rgba(65, 215, 135, 1);
}
.propagandaAreaUrl {
  div {
    > div {
      display: inline-block;
      margin-right: 46px;
      width: 85px;
      height: 85px;
      cursor: pointer;
      img {
        height: 100%;
        width: 100%;
      }
    }
    .el-radio-group{
      width: 100%;
      height: 20px;
       text-align: center;
      .el-radio{
        width: 100%;
      }
    }
  }
}
.propagandaFeeStyle {
  display: inline-block;
}
.publishingProduct {
  width: 100%;
  .el-upload {
    width: 85px;
    height: 85px;
    line-height: 85px;
    border: 1px dashed #c0ccda;
    border-radius: 6px;
    > i {
      font-size: 28px;
      color: #8c939d;
    }
    > img {
      border-radius: 6px;
      width: 85px;
      height: 85px;
      vertical-align: initial;
    }
  }
  //  .el-upload{
  //    width: 85px;
  //   height: 85px;
  //   line-height: 85px;
  //   border: 1px dashed #c0ccda;
  //   border-radius: 6px;
  //   >i{
  //     font-size: 28px;
  //   color: #8c939d;
  //   }
  //   >img{
  //     width: 86px;
  //     height: 86px;
  //   }
  // }
  .ordinary_title {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 17px;
    // font-size: 13px;
    border-radius: 5px;
    div:nth-child(2) {
      width: 50px;
      height: 26px;
      background: rgba(236, 252, 242, 1);
      border: 1px solid rgba(65, 215, 135, 1);
      border-radius: 4px;
      text-align: center;
      line-height: 26px;
      font-size: 12px;
      color: #00a041;
      cursor: pointer;
    }
  }
  .el-upload-list--picture-card .el-upload-list__item {
    width: 85px;
    height: 85px;
  }
  .el-upload--picture-card {
    width: 85px;
    height: 85px;
    line-height: 85px;
  }
  .ordinary_content {
    margin-top: 14px;
    background: #fff;
    padding: 36px 0px;
    .postJobInfo {
      width: 65%;
      margin-left: 200px;

      .el-date-editor.el-input,
      .el-date-editor.el-input__inner {
        width: 266px;
      }
      .el-input {
        width: 266px;
      }
      .el-textarea__inner {
        width: 348px;
        min-height: 100px !important;
        background: #fff;
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
}
</style>

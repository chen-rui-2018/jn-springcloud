<template>
  <div class="finaProDetail w">
    <div class="serverOrgMenu color2">
      <span class="pointer" @click="$router.push({path:'/tfindex'})">首页/</span>
      <span class="pointer" @click="$router.push({path:'/finaPro'})">金融产品</span>
      <span>/</span>
      <span class="mainColor agent">产品详情</span>
    </div>
    <div class="agentInfo">
      <el-card>
        <div class="agent1 clearfix">
          <div class="agentTil fl color1">{{serverOrgDetailList.productName}}</div>
          <div class="orgBtn fr mainColor" v-if="serverOrgDetailList.orgName" @click="raiseDemand(serverOrgDetailList.productId,serverOrgDetailList.productName)">提需求</div>
        </div>
        <div class="agent2 clearfix pr color2">
          <div class="agentImg fl">
            <img v-if="serverOrgDetailList.pictureUrl" :src="serverOrgDetailList.pictureUrl" alt="">
            <img v-else src="@/../static/img/product.png" alt="">
          </div>
          <div class="agent2Info fl color2 clearfix" id="agent2Info">
            <p>服务机构：{{serverOrgDetailList.orgName}}</p>
            <p>担保方式：{{serverOrgDetailList.assureMethodName}}</p>
            <p>贷款额度：
              <span class="mainColor">{{serverOrgDetailList.loanAmountMin}}-{{serverOrgDetailList.loanAmountMax}}</span>万元
            </p>
            <p>贷款期限：{{serverOrgDetailList.loanTermMin}}个月-{{serverOrgDetailList.loanTermMax}}个月</p>
            <p class="fl" style="margin-top:20px">产品编号：
              <span class="mainColor">{{serverOrgDetailList.serialNumber}}</span>
            </p>
            <div class="lastP color3" style="margin-top:0">
              <span>交易量：{{serverOrgDetailList.transactionNum}}</span>
              <span>浏览：{{serverOrgDetailList.viewCount}}</span>
              <span>服务评分：{{serverOrgDetailList.evaluationScore}}</span>
            </div>
          </div>
        </div>
      </el-card>
    </div>
    <div class="agentDel">
      <div class="agentDelTit">产品详情</div>
      <div class="agentDelCon pr color1">
        <!-- <div class="mainColor shouqi pointer" v-if="zankaiFlag" @click="zankaiFlag=!zankaiFlag">
          收起
          <i class="el-icon-arrow-up"></i>
        </div>
        <div class="mainColor shouqi zhankai pointer" v-else @click="zankaiFlag=!zankaiFlag">
          展开
          <i class="el-icon-arrow-down"></i>
        </div> -->
        <el-card>
          <!-- <el-tabs v-model="activeName">
            <el-tab-pane label="基本信息" name="baseInfo">
              <div class="basicInfo" v-if="zankaiFlag">
                <table class="table-orgspace mainBorder">
                  <tr>
                    <td class="table-orgspace-title">参考利率范围：</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div class="mainColor">{{serverOrgDetailList.refRateMin}}%-{{serverOrgDetailList.refRateMax}}%</div>
                    </td>
                    <td class="table-orgspace-title">是否网贷直联：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div v-if="serverOrgDetailList.isOnlineLoan=='0'">
                        否
                      </div>
                      <div v-if="serverOrgDetailList.isOnlineLoan=='1'">
                        是
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">是否政策性产品：</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div v-if="serverOrgDetailList.isPolicyPro=='0'">
                        否
                      </div>
                      <div v-if="serverOrgDetailList.isPolicyPro=='1'">
                        是
                      </div>
                    </td>
                    <td class="table-orgspace-title">是否通用产品：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div v-if="serverOrgDetailList.isGeneralPro=='0'">
                        否
                      </div>
                      <div v-if="serverOrgDetailList.isGeneralPro=='1'">
                        是
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">贷款类别：</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div>{{serverOrgDetailList.loanCategoryName}}</div>
                    </td>
                    <td class="table-orgspace-title">是否人民币：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div v-if="serverOrgDetailList.isRmb=='0'">
                        否
                      </div>
                      <div v-if="serverOrgDetailList.isRmb=='1'">
                        是
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">贷款额度：</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div>
                        <span class="mainColor">{{serverOrgDetailList.loanAmountMin}}</span>万元-
                        <span class="mainColor">{{serverOrgDetailList.loanAmountMax}}</span>万元
                      </div>
                    </td>
                    <td class="table-orgspace-title">贷款期限：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div>
                        {{serverOrgDetailList.loanTermMin}}个月-{{serverOrgDetailList.loanTermMax}}个月
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">担保方式：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col">{{serverOrgDetailList.assureMethodName}}</div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">产品特点：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col">{{serverOrgDetailList.productFeature}}</div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">申请条件：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col" v-html="serverOrgDetailList.applyCondition"></div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">提交材料：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col" v-html="serverOrgDetailList.submitMaterial"></div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">适用客户：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col">{{serverOrgDetailList.applicableCuster}}</div>
                    </td>
                  </tr>
                </table>
              </div>
            </el-tab-pane>
          </el-tabs> -->
          <div class="finaProContent">
            <div class="d1">
              <p>
                <span>参考利率范围：</span>
                <span class="finaColor">{{serverOrgDetailList.refRateMin}}%-{{serverOrgDetailList.refRateMax}}%</span>
              </p>
              <p>
                <span>是否网贷直联：</span>
                <span class="finaColor" v-if="serverOrgDetailList.isOnlineLoan=='0'">
                  否
                </span>
                <span class="finaColor" v-if="serverOrgDetailList.isOnlineLoan=='1'">
                  是
                </span>
              </p>
            </div>
            <div class="d1">
              <p>
                <span>是否政策性产品：</span>
                <span class="finaColor" v-if="serverOrgDetailList.isPolicyPro=='0'">
                  否
                </span>
                <span class="finaColor" v-if="serverOrgDetailList.isPolicyPro=='1'">
                  是
                </span>
              </p>
              <p>
                <span>是否通用产品：</span>
                <span class="finaColor" v-if="serverOrgDetailList.isGeneralPro=='0'">
                  否
                </span>
                <span class="finaColor" v-if="serverOrgDetailList.isGeneralPro=='1'">
                  是
                </span>
              </p>
            </div>
            <div class="d1">
              <p>
                <span>是否人民币：</span>
                <span class="finaColor" v-if="serverOrgDetailList.isRmb=='0'">
                  否
                </span>
                <span class="finaColor" v-if="serverOrgDetailList.isRmb=='1'">
                  是
                </span>
              </p>
              <p>
                <span>贷款类别：</span>
                <span class="finaColor">{{serverOrgDetailList.loanCategoryName}}</span>
              </p>
            </div>
            <div class="d1">
              <p>
                <span>贷款额度：</span>
                <span class="finaColor">{{serverOrgDetailList.loanAmountMin}}万元-{{serverOrgDetailList.loanAmountMax}}万元</span>
              </p>
              <p>
                <span>贷款期限：</span>
                <span class="finaColor">{{serverOrgDetailList.loanTermMin}}个月-{{serverOrgDetailList.loanTermMax}}个月</span>
              </p>
            </div>
            <div class="d2">
              <span>担保方式：</span>
              <span>{{serverOrgDetailList.assureMethodName}}</span>
            </div>
            <div class="d2">
              <span>适用客户：</span>
              <span class="span1">{{serverOrgDetailList.applicableCuster}}</span>
            </div>
            <div class="d2 d4">
              <span>产品特点：</span>
              <span class="span1">{{serverOrgDetailList.productFeature}}</span>
            </div>
            <div class="d3">
              <span class="finaColor">申请条件：</span>
              <p v-html="serverOrgDetailList.applyCondition"></p>
            </div>
            <div class="d3">
              <span class="finaColor">提交材料：</span>
              <p v-html="serverOrgDetailList.submitMaterial"></p>
            </div>
          </div>
        </el-card>
      </div>
    </div>
    <!-- 提需求弹框 -->
    <template v-if="financialProVisible">
      <el-dialog :visible.sync="financialProVisible" width="600px" :modal-append-to-body=false :lock-scroll="false">
        <div v-if="islogin">
          <el-form ref="financialProform" :rules="rules" :model="financialProform" label-position="right" label-width="150px" style="max-width:500px;">
            <el-form-item label="融资金额(万元):" prop="financingAmount">
              <el-input v-model.trim="financialProform.financingAmount" placeholder="请输入融资金额" maxlength="100" clearable/>
            </el-form-item>
            <el-form-item label="融资期限(月):" prop="financingPeriod">
              <el-select v-model="financialProform.financingPeriod" placeholder="请选择" style="width:100%">
                <el-option v-for="(item,index) in options" :key="index" :label="item.label" :value="item.value" />
                <!-- <el-option value="3个月及以下"/>
              <el-option value="6个月及以下"/>
              <el-option value="12个月及以下"/>
              <el-option value="36个月及以下"/>
              <el-option value="36个月以上"/> -->
              </el-select>
            </el-form-item>

            <el-form-item label="资金需求日期:" prop="expectedDate">
              <!-- <el-input v-model.trim="financialProform.expectedDate" placeholder="请输入需求日期，如2019-04-10" maxlength="100" clearable/> -->
              <el-date-picker v-model="financialProform.expectedDate" type="date" placeholder="选择日期" style="width:100%" value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="资金需求说明:" prop="fundsReqDesc">
              <el-input v-model.trim="financialProform.fundsReqDesc" class="demandTextArea" :rows="4" type="textarea" placeholder="可不填" maxlength="100" clearable/>
            </el-form-item>
          </el-form>
          <div class="demandLine"></div>
          <div class="demandDia" @click="demandDia()">提交需求</div>
        </div>
        <div v-else class="loginTip">
          你还未
          <span class="mainColor pointer" @click="goLogin">登录</span>
          /
          <span class="mainColor pointer" @click="$router.push({path:'/register'})">注册</span>
          企业账号
        </div>
      </el-dialog>
    </template>
  </div>
</template>
<script>
export default {
  data() {
    return {
      islogin: true,
      zankaiFlag: true,
      activeName: "baseInfo",
      serverOrgDetailList: {},
      financialProVisible: false,
      financialProform: {
        financingAmount: "",
        financingPeriod: "",
        financingPeriodMax: "",
        financingPeriodMin: "",
        expectedDate: "",
        fundsReqDesc: "",
        productId: "",
        productName: ""
      },
      rules: {
        financingAmount: [
          { required: true, message: "请输入融资金额", trigger: "blur" }
        ],
        financingPeriod: [
          { required: true, message: "请选择融资期限", trigger: "change" }
        ],
        expectedDate: [
          {
            required: true,
            message: "请输入需求日期，格式为xxxx-yy-rr",
            trigger: "blur"
          }
        ]
      },
      options: [
        {
          value: 0,
          label: "3个月及以下"
        },
        {
          value: 1,
          label: "6个月及以下"
        },
        {
          value: 2,
          label: "12个月及以下"
        },
        {
          value: 3,
          label: "36个月及以下"
        },
        {
          value: 4,
          label: "36个月以上"
        }
      ],
      arr: [
        {
          loanTermMax: 3,
          loanTermMin: ""
        },
        {
          loanTermMax: 6,
          loanTermMin: ""
        },
        {
          loanTermMax: 12,
          loanTermMin: ""
        },
        {
          loanTermMax: 36,
          loanTermMin: ""
        },
        {
          loanTermMax: "",
          loanTermMin: 36
        }
      ],
      serverProform: {
        requireDetail: "",
        productId: "",
        productName: ""
      },
      evaCount: {},
      sortTypes: "",
      ratingType: "",
      timeInterval: "0"
    };
  },
  created() {
    this.initList();
  },
  methods: {
    goLogin() {
      window.sessionStorage.setItem("PresetRoute", this.$route.fullPath);
      this.$router.push({ path: "/login" });
    },
    //判断是否登录
    isLogin() {
      if (!this.getToken()) {
        this.islogin = false;
      }
    },
    //用户提需求
    demandDia() {
      // if(!this.financialProform.financingPeriod){
      //   return
      // }
      let _this = this;
      let max = this.arr[this.financialProform.financingPeriod].loanTermMax;
      let min = this.arr[this.financialProform.financingPeriod].loanTermMin;
      this.api.post({
        url: "userDemandTechnology",
        data: {
          expectedDate: _this.financialProform.expectedDate,
          financingAmount: _this.financialProform.financingAmount,
          financingPeriodMax: max,
          financingPeriodMin: min,
          productId: _this.financialProform.productId,
          productName: _this.financialProform.productName,
          fundsReqDesc: _this.financialProform.fundsReqDesc
        },
        callback: function(res) {
          if (res.code == "0000") {
            console.log(res);
            _this.$message.success("提交需求成功");
            _this.financialProVisible = false;
          } else {
            _this.$message.error(res.result);
            _this.finaProVisible = false;
          }
        }
      });
    },
    //提需求
    raiseDemand(productId, productName) {
      this.isLogin();
      this.financialProVisible = true;
      this.financialProform.expectedDate = "";
      this.financialProform.financingAmount = "";
      this.financialProform.financingPeriodMax = "";
      this.financialProform.financingPeriodMin = "";
      this.financialProform.financingPeriod = "";
      this.financialProform.fundsReqDesc = "";
      this.financialProform.productId = productId;
      this.financialProform.productName = productName;
    },

    initList() {
      let _this = this;
      this.api.get({
        url: "getFinancialProductDetails",
        data: {
          productId: _this.$route.query.productId
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverOrgDetailList = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.finaProDetail {
  .finaProContent {
    .d1 {
      margin-top: 10px;
      display: flex;
      align-items: right;
      justify-content: space-between;
      p {
        width: 50%;
        > span:nth-child(1) {
          display: inline-block;
          width: 110px;
          text-align: right;
        }
      }
    }
    .d2 {
      margin-top: 10px;
      span:nth-child(1) {
        display: inline-block;
        width: 110px;
        text-align: right;
      }
      .span1 {
        line-height: 20px;
      }
    }
    .d3 {
      margin-top: 10px;
      p {
        font-size: 13px;
        line-height: 20px;
        margin-top: 5px;
      }
    }
    .d4 {
      text-indent: -7rem;
      margin-left: 7rem;
    }
    span {
      font-size: 13px;
      color: #666;
    }
    .finaColor {
      color: #d21d00;
      font-size: 16px;
    }
  }
  .agentDel {
    padding-bottom: 50px;
  }
  #agent2Info {
    > p {
      margin-bottom: 5px;
    }
    .lastP {
      padding-top: 20px;
      // position: static;
    }
  }
  .serverPro,
  .serConsultant,
  .serEvaluation,
  .actiConsultation {
    .pagination-container {
      margin-top: 30px;
    }
  }
  .el-textarea__inner:focus {
    outline: 0;
    border-color: #00a041;
  }
  .demandDia {
    background: #ecfcf2;
    padding: 8px 10px;
    width: 80px;
    margin: 0 auto;
    border: 1px solid #00a041;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    color: #00a041;
  }
  .demandLine {
    height: 1px;
    width: 600px;
    position: relative;
    left: -20px;
    background: #eee;
    margin-bottom: 20px;
    margin-top: 10px;
  }
}
</style>

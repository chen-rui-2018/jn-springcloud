<template>
  <div class="finaInstitution w">
    <div class="serverOrgMenu">
      <span class="pointer" @click="$router.push({path:'/tfindex'})">首页</span>
      <span>/</span>
      <span class="mainColor agent">金融产品</span>
    </div>
    <div class="serverOrgNav mainBorder">
      <div v-if="showFlag">
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">贷款期限：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto;">
            <li :class="{'active1':filterFlag1 == ''}" @click="handleFilter1('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag1}">
            <li class="wid1" v-for="(i,k) in options2" :key='k' @click="handleFilter1(i.value,i.loanTermMax,i.loanTermMin)" :class="{'active1':filterFlag1 == i.value}">{{i.label}}</li>
          </ul>
          <div class="fr" v-if="widFun('wid1')">
            <i class="el-icon-arrow-down" v-if="flag1" @click="flag1 = !flag1"></i>
            <i class="el-icon-arrow-up" v-else @click="flag1 = !flag1"></i>
          </div>
        </div>
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">担保方式：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto">
            <li :class="{'active1':filterFlag2 == ''}" @click="handleFilter2('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag2}">
            <li class="wid2" v-for="(i,k) in guaranteeMode" :key='k' @click="handleFilter2(i.assureCode)" :class="{'active1':filterFlag2 == i.assureCode}">{{i.assureName}}</li>
          </ul>
          <div class="fr" v-if="widFun('wid2')">
            <i class="el-icon-arrow-down" v-if="flag2" @click="flag2 = !flag2"></i>
            <i class="el-icon-arrow-up" v-else @click="flag2 = !flag2"></i>
          </div>
        </div>
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">网贷直联：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto">
            <li :class="{'active1':filterFlag3 == ''}" @click="handleFilter3('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag3}">
            <li class="wid3" @click="handleFilter3('1')" :class="{'active1':filterFlag3 == '1'}">是</li>
            <li class="wid3" @click="handleFilter3('0')" :class="{'active1':filterFlag3 == '0'}">否</li>
          </ul>
        </div>
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">政策性产品：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto">
            <li :class="{'active1':filterFlag4 == ''}" @click="handleFilter4('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag4}">
            <li class="wid4" @click="handleFilter4('1')" :class="{'active1':filterFlag4 == '1'}">是</li>
            <li class="wid4" @click="handleFilter4('0')" :class="{'active1':filterFlag4 == '0'}">否</li>
          </ul>
          <div class="fr" v-if="widFun('wid4')">
            <i class="el-icon-arrow-down" v-if="flag4" @click="flag4 = !flag4"></i>
            <i class="el-icon-arrow-up" v-else @click="flag4 = !flag4"></i>
          </div>
        </div>
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">贷款额度：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto">
            <li :class="{'active1':filterFlag5 == ''}" @click="handleFilter5('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag5}">
            <li class="wid5" v-for="(i,k) in options1" :key='k' @click="handleFilter5(i.value,i.loanAmountMax,i.loanAmountMin)" :class="{'active1':filterFlag5 == i.value}">{{i.label}}</li>
          </ul>
          <div class="fr" v-if="widFun('wid5')">
            <i class="el-icon-arrow-down" v-if="flag5" @click="flag5 = !flag5"></i>
            <i class="el-icon-arrow-up" v-else @click="flag5 = !flag5"></i>
          </div>
        </div>
        <div class="nav1 nav2 mainColor pointer" style="color:#00a041" @click="showFlag=!showFlag">
          收起
          <i class="el-icon-arrow-up" style="color:#00a041"></i>
        </div>
      </div>
      <div v-else>
        <div class="nav1 nav2 mainColor pointer" style="color:#00a041" @click="showFlag=!showFlag">
          更多筛选条件
          <i class="el-icon-arrow-down" style="color:#00a041"></i>
        </div>
      </div>
    </div>
    <div class="serverOrgFilter mainBorder clearfix">
      <div class="filLeft fl">
        共有<i class="mainColor">{{total}}</i>个符合条件的结果
      </div>
      <div class="filRight fr">
        <input type="text" placeholder="搜索关键字" v-model="keyW">
        <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
      </div>
    </div>
    <div class="serverOrgContent" id="serverOrgContent">
      <ul>
        <li class="clearfix" v-for="(i,k) in serverAgent" :key='k'>
          <div class="orgImg fl pointer" @click="handleOrgDel(i.productId)">
            <img v-if="i.pictureUrl" :src="i.pictureUrl" alt="">
            <img v-else src="@/../static/img/product.png" alt="">
          </div>
          <div class="orgCon fl">
            <div class="conTil">{{i.productName}}</div>
            <div class="conContent clearfix color3">
              <div class="left1 fl">
                <p>服务机构：
                  <span class="mainColor">{{i.orgName}}</span>
                </p>
                <p>参考利率范围：<span class="mainColor">{{i.refRateMin}}-{{i.refRateMax}}</span></p>
                <p>贷款期限:
                  <span class="mainColor">{{i.loanTermMin}}-{{i.loanTermMax}}</span>笔交易</p>
                  <p>担保方式：{{i.assureMethodName}}</p>
                  <p>贷款额度：<span class="mainColor">{{i.loanAmountMin}}-{{i.loanAmountMax}}</span>万元</p>
              </div>
              <div class="right1 fl">
                <p>
                  <el-rate v-model="i.ratingScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                  </el-rate>
                  <span class="mainColor">{{i.ratingNum}}</span>条评价</p>
                <p style="text-align:center">
                  累计<span class="mainColor">{{i.transactionNum}}</span>笔交易
                </p>
              </div>
            </div>
          </div>
          <div class="orgBtn fr mainColor" @click="raiseDemand(i)">
            提需求
          </div>
        </li>
      </ul>
    </div>
    <div class="pagination-container">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage1" :page-sizes="[3, 6, 9, 12]" :page-size="row" layout="total,prev, pager, next,sizes" :total="total">
      </el-pagination>
    </div>
    <!-- 提需求 -->
    <template v-if="finaProVisible">
      <el-dialog :visible.sync="finaProVisible" width="600px" :modal-append-to-body=false :lock-scroll="false">
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
            <el-input v-model.trim="financialProform.expectedDate" placeholder="请输入需求日期，如2019-04-10" maxlength="100" clearable/>
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
          <span class="mainColor pointer" @click="$router.push({path:'/login'})">登录</span>
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
      islogin:true,
      guaranteeMode:[],
      assureMethodCode:'',
      onlineLoan:'',
      policyProduct:'',
      loanTermMax:'',
      loanTermMin:'',
      loanAmountMax:'',
      loanAmountMin:'',
      total: 0,
      currentPage1: 1,
      row: 3,
      page: 1,
      serverAgent: [],
      sortTypes: "",
      keyW: "",
      industrySector:"",
      developmentStage:"",
      companyNature:"",
      colorFlag: "",
      filterFlag1: "",
      filterFlag2: "",
      filterFlag3: "",
      filterFlag4: "",
      filterFlag5: "",
      flag1: true,
      flag2: true,
      flag3: true,
      flag4: true,
      flag5: true,
      showFlag: true,
      finaProVisible:false,
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
          { required: true, message: "请输入需求日期，格式为xxxx-yy-rr", trigger: "blur" }
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
      options1: [
        {
          value: 5,
          label: "100万及以下",
          loanAmountMax: 100,
          loanAmountMin: ""
        },
        {
          value: 6,
          label: "200万及以下",
          loanAmountMax: 200,
          loanAmountMin: ""
        },
        {
          value: 7,
          label: "300万及以下",
          loanAmountMax: 300,
          loanAmountMin: ""
        },
        {
          value: 8,
          label: "500万及以下",
           loanAmountMax: 500,
          loanAmountMin: ""
        },
        {
          value: 9,
          label: "1000万及以下",
          loanAmountMax: 1000,
          loanAmountMin: ""
        },
        {
          value: 10,
          label: "1000万及以上",
          loanAmountMax: "",
          loanAmountMin: 1000,
        }
      ],
      options2: [
        {
          value: 11,
          label: "3个月及以下",
          loanTermMax: 3,
          loanTermMin: "",
        },
        {
          value: 1,
          label: "6个月及以下",
          loanTermMax: 6,
          loanTermMin: "",
        },
        {
          value: 2,
          label: "12个月及以下",
           loanTermMax: 12,
          loanTermMin: "",
        },
        {
          value: 3,
          label: "36个月及以下",
          loanTermMax: 36,
          loanTermMin: "",
        },
        {
          value: 4,
          label: "36个月以上",
          loanTermMax: "",
          loanTermMin: 36,
        }
      ],
    };
  },
  mounted() {
    this.initList();
    this.getAssureType()
  },
  methods: {
      //判断是否登录
    isLogin() {
      if (!sessionStorage.userInfo) {
        this.islogin = false;
      }
    },
    widFun(i) {
      let doc = document.getElementsByClassName(i);
      let num = 0;
      for (let it of doc) {
        num += it.offsetWidth * 1;
      }
      // console.log(num);
      if (num >= 860) {
        return true;
      } else {
        return false;
      }
    },
    //提交需求
    demandDia() {
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
            _this.$message.success("提交需求成功");
            _this.finaProVisible = false;
          } else {
            _this.$message.error(res.result);
            _this.finaProVisible = false;
          }
        }
      });
    },
    //提需求
    raiseDemand(i) {
      // if (!sessionStorage.userInfo) {
      //   this.$message.error("请先登录");
      //   return;
      // }
      this.isLogin()
      this.finaProVisible = true;
      this.financialProform.expectedDate = "";
      this.financialProform.financingAmount = "";
      this.financialProform.financingPeriodMax = "";
      this.financialProform.financingPeriodMin = "";
      this.financialProform.financingPeriod = "";
      this.financialProform.fundsReqDesc = "";
      this.financialProform.productId = i.productId;
      this.financialProform.productName = i.productName;
    },
    handleFilter1(i,j,k) {
       if(j!=''){
        this.loanTermMax=j
      } else{
        this.loanTermMin=k
      }
      this.filterFlag1 = i;
      this.initList();
    },
    handleFilter2(i) {
      this.assureMethodCode=`${i}`,
      this.filterFlag2 = i;
      this.initList();
    },
    handleFilter3(i) {
      this.onlineLoan=i
      this.filterFlag3 = i;
      this.initList();
    },
    handleFilter4(i) {
      this.policyProduct=i
      this.filterFlag4 = i;
      this.initList();
    },
    handleFilter5(i,j,k) {
      if(j!=''){
        this.loanAmountMax=j
      } else{
        this.loanAmountMin=k
      }
      this.filterFlag5 = i;
      this.initList();
    },
    //搜索
    handleSearchList() {
      this.page = 1;
      this.initList();
    },
    //跳转详情页
    handleOrgDel(productId) {
      this.$router.push({ path: "finaProDetail", query: { productId: productId } });
    },
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.row = val;
      this.page = 1;
      this.initList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.initList();
    },
    //金融产品列表
    initList() {
      let _this = this;
      let data = {
          needPage:1,
          page: _this.page,
          rows: _this.row,
          keyWord:_this.keyW,
          assureMethodCode:_this.assureMethodCode,
          loanAmountMin:_this.loanAmountMin,
          loanAmountMax:_this.loanAmountMax,
          loanTermMax:_this.loanTermMax,
          loanTermMin:_this.loanTermMin,
          onlineLoan:_this.onlineLoan,
          policyProduct:_this.policyProduct,
        }
      this.api.get({
        url: "getFinancialProList",
        data: data,
        dataFlag:true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverAgent = res.data.rows;
            _this.total = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //金融产品担保方式
   getAssureType() {
      let _this = this;
      let data = {}
      this.api.get({
        url: "getAssureType",
        data: data,
        dataFlag:true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.guaranteeMode=res.data
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },


  }
};
</script>
<style lang="scss">
.finaInstitution{
  padding-top:65px;
   .icon-sousuo {
        background: #00a041;
        color: #fff;
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px
      }
  #serverOrgContent{
   .conTil{
     margin-bottom:15px;
   }
   .left1{
     >p{
       margin-bottom: 3px;
     }
   }
   .conContent{
     font-size: 13px;
   }
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

<template>
  <div class="serverOrg w">
    <div class="serverOrgMenu">
      <span class="pointer" @click="$router.push({path:'/serMatHp'})">首页</span>
      <span>/</span>
      <span class="mainColor agent">服务机构</span>
    </div>
    <div class="serverOrgNav mainBorder">
      <div class="nav1 clearfix">
        <div class="nav1Tit fl">业务领域：</div>
        <ul class="nav1Ul fl clearfix" style="width:auto;">
          <li :class="{'active1':filterFlag == ''}" @click="handleFilter('')">不限</li>
        </ul>
        <ul class="nav1Ul fl clearfix" :class="{'sh':!flag1}">
          <li class="wid1" v-for="(i,k) in businessArea" :key='k' @click="handleFilter(i.id)" :class="{'active1':filterFlag == i.id}">{{i.preValue}}</li>
        </ul>
        <div class="fr" v-if="widFun('wid1')">
          <i class="el-icon-arrow-down" v-if="flag1" @click="flag1 = !flag1"></i>
          <i class="el-icon-arrow-up" v-else @click="flag1 = !flag1"></i>
        </div>
      </div>
      <div v-if="showFlag">
        <div class="nav1 mainColor" style="color:#00a041">
          <img src="@/../static/img/dengpao.png" alt=""> 请选择您的企业特性，系统将自动为您推荐合适的服务机构
        </div>
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">所属行业：</div>
          <!-- <div class="fl" :class="{'active':filterFlag1 == ''}" @click="handleFilter1('')">不限</div> -->
          <ul class="nav1Ul fl clearfix" style="width:auto;">
            <li :class="{'active1':filterFlag1 == ''}" @click="handleFilter1('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag2}">
            <li class="wid2" v-for="(i,k) in industryField" :key='k' @click="handleFilter1(i.id)" :class="{'active1':filterFlag1 == i.id}">{{i.preValue}}</li>
          </ul>
          <div class="fr" v-if="widFun('wid2')">
            <i class="el-icon-arrow-down" v-if="flag2" @click="flag2 = !flag2"></i>
            <i class="el-icon-arrow-up" v-else @click="flag2 = !flag2"></i>
          </div>
        </div>
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">发展阶段：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto">
            <li :class="{'active1':filterFlag2 == ''}" @click="handleFilter2('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag3}">
            <li class="wid3" v-for="(i,k) in developStage" :key='k' @click="handleFilter2(i.id)" :class="{'active1':filterFlag2 == i.id}">{{i.preValue}}</li>
          </ul>
          <div class="fr" v-if="widFun('wid3')">
            <i class="el-icon-arrow-down" v-if="flag3" @click="flag3 = !flag3"></i>
            <i class="el-icon-arrow-up" v-else @click="flag3 = !flag3"></i>
          </div>
        </div>
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">企业性质：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto">
            <li :class="{'active1':filterFlag3 == ''}" @click="handleFilter3('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag4}">
            <li class="wid4" v-for="(i,k) in enterpriseNature" :key='k' @click="handleFilter3(i.id)" :class="{'active1':filterFlag3 == i.id}">{{i.preValue}}</li>
          </ul>
          <div class="fr" v-if="widFun('wid4')">
            <i class="el-icon-arrow-down" v-if="flag4" @click="flag4 = !flag4"></i>
            <i class="el-icon-arrow-up" v-else @click="flag4 = !flag4"></i>
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
      <div class="filLeft fl">排序：
        <span @click="handleFil('')" :class="{'active2':colorFlag == ''}">综合</span>
        <span @click="handleFil('popularity')" :class="{'active2':colorFlag == 'popularity'}">人气</span>
        <!-- <span>好评</span> -->
        <span @click="handleFil('serviceNum')" :class="{'active2':colorFlag == 'serviceNum'}">服务量</span>
      </div>
      <div class="filRight fr">
        <input type="text" placeholder="搜索关键字" v-model="keyW">
        <i class="iconfont icon-sousuo" @click="handleSearchList"></i>
      </div>
    </div>
    <div class="serverOrgContent">
      <ul>
        <li class="clearfix" v-for="(i,k) in serverAgent" :key='k'>
          <div class="orgImg fl" @click="handleOrgDel(i.orgId)">
            <!-- <img src="@/../static/img/ins1.png" alt=""> -->
            <img :src="i.orgLogo" alt="">
          </div>
          <div class="orgCon fl">
            <div class="conTil">{{i.orgName}}</div>
            <div class="conContent clearfix color3">
              <div class="left1 fl">
                <p>电话：
                  <span class="mainColor">{{i.orgPhone}}</span>
                </p>
                <p>地址：{{i.orgAddress}}</p>
                <p>累计
                  <span class="mainColor">{{i.transactionNum}}</span>笔交易</p>
              </div>
              <div class="right1 fl">
                <p>
                  <el-rate v-model="i.attitudeScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                  </el-rate>
                  <span class="mainColor">{{i.evaluationNum}}</span>条评价</p>
                <p>
                  {{i.attitudeScore}}分
                </p>
              </div>
            </div>
          </div>
          <div class="orgBtn fr mainColor">
            <a href="javascript:;" @click="onlineContact">在线联系</a>
          </div>
        </li>
      </ul>
    </div>
    <div class="pagination-container">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage1" :page-sizes="[3, 6, 9, 12]" :page-size="row" layout="total,prev, pager, next,sizes" :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      total: 0,
      currentPage1: 1,
      row: 3,
      page: 1,
      serverAgent: [],
      sortTypes: "",
      keyW: "",
      businessType: "",
      industrySector: "",
      developmentStage: "",
      companyNature: "",
      colorFlag: "",
      filterFlag1: "",
      filterFlag2: "",
      filterFlag3: "",
      filterFlag: "",
      flag1: true,
      flag2: true,
      flag3: true,
      flag4: true,
      businessArea: [],
      industryField: [],
      developStage: [],
      enterpriseNature: [],
      showFlag: true
    };
  },
  mounted() {
    this.initList();
    this.selectIndustryList();
    if(this.$route.query.searchData){
      this.keyW=this.$route.query.searchData
      this.initList();
    }
  },
  methods: {
    onlineContact() {
      if (!sessionStorage.userInfo) {
        this.$message.error("请先登录");
        return;
      }
      this.$router.push({ path: "/chat" });
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
    //排序
    handleFil(i) {
      this.colorFlag = i;
      this.sortTypes = i;
      this.page = 1;
      this.initList();
    },
    //领域搜索
    handleFilter(i) {
      (this.businessType = `${i}`), (this.filterFlag = i);
      this.initList();
    },
    handleFilter1(i) {
      (this.industrySector = `${i}`),
        // this.industrySector=[]
        // this.industrySector.push(i);
        (this.filterFlag1 = i);
      this.initList();
    },
    handleFilter2(i) {
      (this.developmentStage = `${i}`),
        // this.developmentStage=[]
        // this.developmentStage.push(i);
        (this.filterFlag2 = i);
      this.initList();
    },
    handleFilter3(i) {
      this.companyNature = `${i}`;
      this.filterFlag3 = i;
      this.initList();
    },
    //搜索
    handleSearchList() {
      this.page = 1;
      this.initList();
    },
    //跳转详情页
    handleOrgDel(orgId) {
      this.$router.push({ path: "serverOrgDetail", query: { orgId: orgId } });
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
    //服务机构列表
    initList() {
      let _this = this;
      let data = {
        businessType: _this.businessType,
        industrySector: _this.industrySector,
        developmentStage: _this.developmentStage,
        companyNature: _this.companyNature,
        page: _this.page,
        rows: _this.row,
        sortTypes: _this.sortTypes,
        orgName: _this.keyW
      };
      this.api.get({
        url: "selectServiceOrgList",
        data: data,
        dataFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverAgent = res.data.rows;
            for (let it in _this.serverAgent) {
              _this.serverAgent[it].attitudeScore =
                _this.serverAgent[it].attitudeScore * 1;
            }
            _this.total = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //机构字典
    selectIndustryList() {
      let _this = this;
      this.api.get({
        url: "selectTeamList",
        data: {
          id: "",
          preType: "",
          preValue: ""
        },
        callback: function(res) {
          if (res.code == "0000") {
            for (let it in res.data) {
              if (res.data[it].preType == "0") {
                _this.businessArea.push(res.data[it]);
              } else if (res.data[it].preType == "1") {
                _this.industryField.push(res.data[it]);
              } else if (res.data[it].preType == "2") {
                _this.developStage.push(res.data[it]);
              } else {
                _this.enterpriseNature.push(res.data[it]);
              }
            }
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
.serverOrg {
  padding-top: 65px;
}
</style>

<template>
  <div class="companyProfile w">
    <div class="serverOrgMenu">
      <span class="pointer" @click="$router.push({path:'/'})">首页</span>
      <span>/</span>
      <span class="mainColor agent">企业简介</span>
    </div>
    <div class="serverOrgNav mainBorder">
      <div v-if="showFlag">
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">所属园区：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto;">
            <li :class="{'active1':filterFlag == ''}" @click="handleFilter('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag1}">
            <li class="wid1" v-for="(i,k) in parkList" :key='k' @click="handleFilter(i.id)" :class="{'active1':filterFlag == i.id}">{{i.parkName}}</li>
          </ul>
          <div class="fr" v-if="widFun('wid1')">
            <i class="el-icon-arrow-down" v-if="flag1" @click="flag1 = !flag1"></i>
            <i class="el-icon-arrow-up" v-else @click="flag1 = !flag1"></i>
          </div>
        </div>
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">产业领域：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto;">
            <li :class="{'active1':filterFlag1 == ''}" @click="handleFilter1('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag2}">
            <li class="wid2" v-for="(i,k) in companyList1" :key='k' @click="handleFilter1(i.id)" :class="{'active1':filterFlag1 == i.id}">{{i.preValue}}</li>
          </ul>
          <div class="fr" v-if="widFun('wid2')">
            <i class="el-icon-arrow-down" v-if="flag2" @click="flag2 = !flag2"></i>
            <i class="el-icon-arrow-up" v-else @click="flag2 = !flag2"></i>
          </div>
        </div>
        <div class="nav1 clearfix">
          <div class="nav1Tit fl">企业来源：</div>
          <ul class="nav1Ul fl clearfix" style="width:auto">
            <li :class="{'active1':filterFlag2 == ''}" @click="handleFilter2('')">不限</li>
          </ul>
          <ul class="nav1Ul fl clearfix" :class="{'sh':!flag3}">
            <li class="wid3" v-for="(i,k) in enterpriseSource" :key='k' @click="handleFilter2(i.id)" :class="{'active1':filterFlag2 == i.id}">{{i.name}}</li>
          </ul>
          <div class="fr" v-if="widFun('wid3')">
            <i class="el-icon-arrow-down" v-if="flag3" @click="flag3 = !flag3"></i>
            <i class="el-icon-arrow-up" v-else @click="flag3 = !flag3"></i>
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
        <!-- <span @click="handleFil('popularity')" :class="{'active2':colorFlag == 'popularity'}">关注</span> -->
        <span @click="handleFil('browse_number')" :class="{'active2':colorFlag == 'browse_number'}">浏览量</span>
        <!-- <span @click="handleFil('serviceNum')" :class="{'active2':colorFlag == 'serviceNum'}">留言</span> -->
      </div>
      <div class="filRight fr">
        <input type="text" placeholder="搜索关键字" v-model="comName">
        <i class="iconfont icon-sousuo" style="background: #00a041;color: #fff;" @click="handleSearchList"></i>
      </div>
    </div>
    <div class="serverOrgContent">
      <ul>
        <li class="clearfix" v-for="(i,k) in CompanyList" :key='k'>
          <div class="orgImg fl pointer" @click="handleOrgDel(i.id)">
            <!-- <img src="@/../static/img/ins1.png" alt=""> -->
            <img :src="i.avatar" alt="">
          </div>
          <div class="orgCon fl">
            <div class="conTil">{{i.comName}}</div>
            <div class="conContent clearfix color3">
              <div class="left1 fl">
                <p>官网：
                  <span class="mainColor">{{i.comWeb}}</span>
                </p>
                <p>服务：{{i.comServer}}</p>
                <p>需求： {{i.comDemand}}
                </p>
              </div>
              <div class="right1 fl">
                <p>
                  <i class="el-icon-view">&nbsp;{{i.browseNumber}}</i>
                  <i class="iconfont icon-liuyan1"></i><span style="font-size:14px;">&nbsp;{{i.commentNumber}}</span>
                </p>
              </div>
            </div>
          </div>
          <div class="orgBtn1 fr">
            <p class="orgP">
              <span class="color3">累计
                <i class="mainColor">{{i.careUser}}</i>人关注</span>
            </p>
            <p>
              <a class="attention" v-if="attentionFlag" @click="handleAttention(i.id)">+关注</a>
              <a class="attention" v-else>已关注</a>
              <a @click="$router.push({path:'/recruitmentList',query:{comId:i.id}})">热招职位</a>
            </p>
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
      attentionFlag:true,
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
      filterFlag: "",
      flag1: true,
      flag2: true,
      flag3: true,
      showFlag: true,
      CompanyList: [],
      companyList1: [],
      enterpriseSource: [
        { name: "人才企业", id: "1" },
        { name: "招商企业", id: "2" }
      ],
      parkList: [],
      affiliatedPark: "",
      comSource: "",
      comType: "",
      comName: "",
      induType: "",
      orderByClause: "",
      token:'',
    };
  },
  created(){
    this.token=sessionStorage.getItem('token')
  },
  mounted() {
    this.getParkList();
    this.selectIndustryList();
    this.getCompanyList();
    if(this.$route.query.id){
      this.induType=this.$route.query.id
    } 
  },
  methods: {
    //关注
    handleAttention(id){
      if(sessionStorage.token){
        this.api.post({
        url: "addCareOperate",
        data: {
          account:id,
          receiveType:-2
        },
        callback: (res)=> {
          if (res.code == "0000") {
            // _this.parkList = res.data;
          } else {
            this.$message.error(res.result);
          }
        }
      });
      } else{
        this.$message.error('你还未登录')
        return
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
    //排序
    handleFil(i) {
      this.colorFlag = i;
      this.orderByClause = i;
      this.page = 1;
      this.getCompanyList()
    },
    //园区搜索
    handleFilter(i) {
      this.affiliatedPark = i;
      this.filterFlag = i;
      this.getCompanyList();
    },
    handleFilter1(i) {
      this.induType = i;
      this.filterFlag1 = i;
      this.getCompanyList();
    },
    handleFilter2(i) {
      this.comSource = i;
      this.filterFlag2 = i;
      this.getCompanyList();
    },
    //搜索
    handleSearchList() {
      this.page = 1;
      this.getCompanyList();
    },
    //跳转详情页
    handleOrgDel(id) {
      this.$router.push({ path: "profileDetails", query: { id: id } });
    },
    //改变每页显示多少条的回调函数
    handleSizeChange(val) {
      this.row = val;
      this.page = 1;
      this.getCompanyList();
    },
    //改变当前页码的回调函数
    handleCurrentChange(val) {
      this.page = val;
      this.getCompanyList();
    },
    // 查询企业列表   排序那块还没确定
    getCompanyList() {
      let _this = this;
      this.api.get({
        url: "getCompanyNewList",
        data: {
          page: _this.page,
          rows: _this.row,
          affiliatedPark: _this.affiliatedPark,
          comSource: _this.comSource,
          comType: _this.comType,
          comName: _this.comName,
          induType: _this.induType,
          orderByClause: _this.orderByClause,
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.CompanyList = res.data.rows.data;
            _this.total = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //产业领域
    selectIndustryList() {
      let _this = this;
      this.api.get({
        url: "selectTeamList",
        data: {
          preType: 1
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.companyList1 = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //获取全部园区数据
    getParkList() {
      let _this = this;
      this.api.get({
        url: "getParkList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.parkList = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //用户添加关注，需登录
    addCareOperate() {
      let _this = this;
      this.api.post({
        url: "addCareOperate",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            // _this.parkList = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //用户取消关注，需登录
    cancelCareOperate() {
      let _this = this;
      this.api.post({
        url: "cancelCareOperate",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            // _this.parkList = res.data;
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
.companyProfile {
  padding-top: 65px;
  .serverOrgContent {
    .orgBtn1 {
      p {
        display: inline-block;
        vertical-align: top;
      }
      .orgP {
        font-size: 12px;
        margin-top: 5px;
        margin-right: 5px;
      }
      a {
        display: block;
        font-size: 13px;
        background: #ecfcf2;
        padding: 6px 20px;
        border: 1px solid #00a041;
        border-radius: 4px;
        // margin-top: 50px;
        cursor: pointer;
        color: #00a041;
        text-align: center;
      }
      .attention {
        background: #00a041;
        color: #fff;
        margin-bottom: 20px;
      }
    }
    .el-icon-view,.iconfont {
      font-size: 14px;
    }
    .icon-liuyan1 {
      margin-left: 20px;
      // font-size: 16px;
    }
  }
}
</style>

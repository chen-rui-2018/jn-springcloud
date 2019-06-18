<template>
    <div class="park_child">
      <div class="parkDetai w">
        <!-- 面包屑 -->
        <div class="approve_breadcrumb">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>
              <a href="#/parkIntroduction">园区介绍</a>
            </el-breadcrumb-item>
            <el-breadcrumb-item>
              <a href="javascript:;">{{parkDetail.parkName}}</a>
            </el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <div class="park_main clearfix">
            <div class="imgItm fl">
                <img :src="parkDetail.mainPicture" alt="">
            </div>
            <div class="parkInfo fl">
              <div class="tit color1">{{parkDetail.parkName}}</div>
              <div class="color3" v-html="parkDetail.parkIntroduce">
              </div>
            </div>
        </div>
      </div>
      <div class="park_enterprise">
        <div class="w">
          <div class="parkTitle clearfix">
            <h5 class="fl color1">园区企业</h5>
          </div>
          <div class="parkEnterpriseDetail">
            <ul>
              <li class="none" v-if="parkEnterprise.length===0">暂无</li>
              <li class="parkLogo" v-for="(item,index) in parkEnterprise" :key="index" v-else>
                <div><img :src="item.avatar" alt=""></div>
                <div>{{item.comName}}</div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      id:'',
      parkDetail: {},
      parkEnterprise:[]
    }
  },
  mounted() {
    this.id=this.$route.query.id
    this.getParkDetails()
    this.getParkEnterprise()
  },
  methods: {
    // 园区介绍
    getParkDetails() {
      this.api.get({
        url: "getParkDetails",
        data: {
          id:this.id
        },
        callback: (res)=> {
          if (res.code == "0000") {
            this.parkDetail =res.data;
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    // 园区企业
    getParkEnterprise(){
      this.api.get({
        url: "getCompanyNewList",
        data: {
          affiliatedPark:this.id
        },
        callback: (res)=> {
          if (res.code == "0000") {
            // console.log(res)
            this.parkEnterprise =res.data.rows;
          } else {
            this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.park_child {
  padding-top: 65px;
  .parkDetai {
      // margin-bottom:35px;
    .approve_breadcrumb{
      padding: 15px 0;
      font-size: 12px;
      .el-breadcrumb__item:last-child .el-breadcrumb__inner a{
        color:#00a041;  
      }
    }
    .park_main {
      border: NaNpx solid rgba(238, 238, 238, 1);
      box-shadow: 0px 1px 11px 0px rgba(4, 0, 0, 0.05);
      border-radius: 7px;
      padding: 30px;
      // display: flex;
      .imgItm{
          height: 316px;
          width: 316px;
        img{
          height: 100%;
          width: 100%;
        }
      }
      .parkInfo {
        margin-left: 36px;
        width: 67%;
        .tit {
          font-size: 20px;
          margin-bottom: 20px;
          font-family:"MicrosoftYaHei";
        }
        p {
          font-size: 14px;
        }
      }
    }
  }
  .park_enterprise{
    background: #f5f5f5;
    margin-top: 35px;
    padding-top: 44px;
    .parkTitle{
      h5 {
      font-size: 18px;
      color: #333;
      font-family:"MicrosoftYaHei";
      font-weight: normal;
      }
      .moreList {
        font-size: 15px;
      }
      .el-icon-arrow-right {
        margin-left: 5px;
      }
    }
    .parkEnterpriseDetail{
      margin-top: 37px;
      ul{
        display: flex;
        flex-wrap: wrap;
        .parkLogo{
          background-color: #fff;
          width: 224px;
          height: 141px;
          margin-right: 17px;
          margin-bottom: 19px;
          display: flex;
          flex-wrap: wrap;
          justify-content: center;
          border-radius: 6px;
          transition: all 0.5s;
          &:hover{
            box-shadow: 0px 0px 12px 1px rgba(0, 0, 0, 0.07);
            transform: translateY(-6px);
          }
          &:nth-child(5n){
            margin-right: 0;
          }
          div:nth-child(1){
            height: 70px;
            margin: 0 auto;
            margin: 14px 14px 0 14px;
            width:100%;
            img{
              height: 100%;
              margin: 0 auto;
              display: block;
              width: 70%;
            }
          }
          div:nth-child(2){
            color:#999;
            font-size: 14px;
            padding: 0 14px;
            text-align: center;
            width: 100%;
          }
        }
        .none{
          padding-bottom:30px ;
        }
      }
    }
  }

}
</style>

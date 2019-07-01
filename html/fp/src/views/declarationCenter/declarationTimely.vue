<template>
  <div class="declarationCenter">
    <div class="banner" ref="banner">
      <div class="swiper-container">
          <div class="swiper-wrapper">
              <div class="swiper-slide"> <img src="@/assets/image/declaration.png" alt=""> </div>
          </div>
      </div>
    </div>
    <div class="declarationCenter_content"><!-- 版心 -->
      <!-- 面包屑 -->
      <div class="approve_breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/enterpriseservice' }">企业服务</el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="#/declarationCenter">申报中心</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="javascript:;">及时申报项目</a>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!-- 申报中心列表 -->
      <div class="declaration_centerList">
        <!-- <div class="declaration_titile">申报中心列表</div> -->
        <div class="declaration_titile">
          <div>即时申报项目</div>
        </div>
        <div class="declaration_list">
          <!-- 筛选 -->
          <div class="filter">
            <div>
              <span @click="filter('1')" :class="{'fontcolor':sortType==='1'}"><i class="iconfont icon-clock-"></i>发布时间排序 </span>
              <span @click="filter('2')" :class="{'fontcolor':sortType==='2'}"><i class="iconfont icon-tiaozheng"></i>时间节点排序 </span>
              <span @click="filter('3')" :class="{'fontcolor':sortType==='3'}"><i class="iconfont icon-hot"></i>热度排序</span>
            </div>
          </div>
          <!-- 内容 -->
          <div class="list_cont">
            <el-tabs v-model="rangeId" @tab-click="switchto">
              <el-tab-pane  v-for="(typeitem,typeindex) in typeList" :key="typeindex">
                <div slot="label" :name="typeitem.id">{{typeitem.name}}</div>
                <div class="lists" v-for="(centeritem,centerindex) in centerList" :key="centerindex" @click="gonoticedetail(centeritem)" >
                  <div class="list_cont_left">
                    <p>【{{centeritem.rangeId|type}}】{{centeritem.titleName}}</p> 
                    <p>
                      <span>发布日期：{{centeritem.createdTime|time}}</span>
                      <!-- <span>状态：<span class="fontcolor">{{centeritem.isRoofPlacement|isRoof}}</span>
                      </span> -->
                    </p>
                    <p>申报部门：{{centeritem.timeNode}}</p>
                    <p>
                      <!-- <span ></span> -->
                      <span>最终截止时间：{{centeritem.deadline|time}}</span>
                      <span v-if="centeritem.preliminaryDeadline!=null">初审截止时间：<span >{{centeritem.preliminaryDeadline|time}}</span>
                      </span>
                    </p>
                  </div>
                  <div class="list_cont_check" @click="gonoticedetail(centeritem)"> <span>查看详情</span> </div>
                </div>
              </el-tab-pane>
            </el-tabs>
          </div>
        </div>
      </div>
      <!-- 分页 -->
      <div class="paging" >
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :page-sizes="[6, 12, 18, 24]"
          :page-size="100"
          layout="total,prev, pager, next,sizes"
          :total="total">
        </el-pagination>
      </div>
    </div><!-- 版心 -->
  </div>
</template>
<script>
import { getToken } from '@/util/auth'
export default {
    data () {
      return {
        total:1,
        typeList:[],//区类型
        centerList:[],
        rangeId:'',//所属类型
        sortType:'1',//排序
        page:1,
        rows:6,
        perennialList:[],
      }
    },
    filters: {
      isRoof(val){
        if(val===1){
          return '置顶'
        }else if(val===2){
          return '不置顶'
        }
      },
      time(time){
        if(time){
          // return time.split("T")[0]
          let dateee = new Date(time).toJSON();
          return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
        }
      },
      type(rangeId){
        if(rangeId==='1'){
          return '白下高新区'
        }else if(rangeId==='2'){
          return '秦淮区'
        }else if(rangeId==='3'){
          return '南京市'
        }else if(rangeId==='4'){
          return '江苏省'
        }else if(rangeId==='5'){
          return '国家'
        }
      }
    },
    created () {
      this.getdeclarationcentertype()//区类型
      this.getdeclarationcenterList()//公告列表获取
    },
    methods: {
      //区类型获取
      getdeclarationcentertype(){
        let _this = this;
        this.api.get({
          url: "getdeclarationcentertype",
          data: {
          },
          callback: function(res) {
            if (res.code == "0000") {
              // console.log(res)
              let typelist=[]
              res.data.forEach((item,index)=>{
                typelist.push({
                  id:item.id,
                  name:item.name
                })
              })
              typelist.unshift({
                id:'',
                name:'全部'
              })
              _this.typeList = typelist;
            }else{
              _this.$message.error(res.result)              
            }
          }
        });
      },
      //公告列表获取
      getdeclarationcenterList(){
        let _this = this;
        this.api.get({
          url: "getdeclarationcentertList",
          data: {
            rangeId:this.rangeId==='0'?'':this.rangeId,
            sortType:this.sortType,
            page:this.page,
            rows:this.rows
          },
          callback: function(res) {
            if (res.code == "0000") {
              // console.log(res)
              _this.centerList = res.data.rows;
              _this.total=res.data.total
            }else{
              _this.$message.error(res.result)              
            }
          }
        });
      },
      //排序
      filter(val){
        this.sortType=val
        this.getdeclarationcenterList()
      },
      //切换区
      switchto(){
        this.getdeclarationcenterList()
      },
      gonoticedetail(item){
        this.api.get({
          url: "addpageviews",
          data: {
            id:item.id
          },
          callback: (res)=> {
            if(res.code==='0000'){
              this.$router.push({path:'/declarationNoticeDetail',query:{id:item.id,rangeId:item.rangeId}})
            }else{
              this.$message.error(res.result)
            }
          }
        });
      },
      handleSizeChange(val) {
      // console.log(`每页 ${val} 条`);
        this.rows=val
        this.getdeclarationcenterList()
      },
      handleCurrentChange(val) {
        // console.log(`当前页: ${val}`);
        this.page=val
        this.getdeclarationcenterList()
      },
    }
  }
</script>

<style lang="scss">

  .declarationCenter{
    // margin-top: 230px;
    .banner{
      position: relative;
      .swiper-button-prev, .swiper-button-next{
        display: block;
        width: 43px;
        height: 43px;
        border: 1px solid #fff;
        border-radius: 50%;
        background-size: 0 0;
        text-align: center;
        i{
          font-size: 36px;
          line-height: 44px;
          color:#fff;
        }
      }
      .swiper-button-next{
        right: 95px;
      }
      .swiper-button-prev{
        left:95px;
      }
    }
  .swiper-container-horizontal > .swiper-pagination-bullets .swiper-pagination-bullet{
    margin: 5px 4px;
  }
  .swiper-pagination-bullet{
    background-color: #fff;
    opacity: 0.5;
  }
   .swiper-pagination-fraction, .swiper-pagination-custom, .swiper-container-horizontal > .swiper-pagination-bullets{
      position: absolute;
      right: 152px;
      top: 0;
      left: auto;
      width: 1%;
      }
    .swiper-container{
      img{
        width:100%;
        vertical-align: middle;
      }
      .swiper-pagination{
        display: flex;
        flex-direction: column;
        justify-content: center;
      }
      .swiper-pagination-bullet-active{
        border-radius: 5px;
        height: 50px;
        background: #fff;
        opacity: 1;
      }
    }
    @keyframes bounce-up {
    25% {
        transform: translateY(5px);
    }
    50%, 100% {
        transform: translateY(0);
    }
    75% {
        transform: translateY(-5px);
        }
    }
    .animate-bounce-up{
      animation: bounce-up 2s linear infinite;
    }
    .approve_content{
      width: 1190px;
      margin: 0 auto;
    }
    // 加载动画
    .el-loading-mask{
      .el-loading-spinner .path{
        stroke:#00a041;
      }
      .el-loading-spinner{
        top:30%;
      }
    }
    .declarationCenter_content{
      width: 1190px;
      margin: 0 auto;
      // 面包屑
      .approve_breadcrumb{
        padding: 15px 0;
        font-size: 12px;
        .el-breadcrumb__item:last-child .el-breadcrumb__inner a{
          color:#00a041;  
        }
      }
      // 申报中心列表
      .declaration_centerList{
        // margin-top: 54px;
        .declaration_titile{
          display: flex;
          justify-content: space-between;
          div:nth-child(1){
            padding-left: 10px;
            border-left: 4px solid #00a041;
            line-height: 1;
          }
          div:nth-child(2){
            font-size: 12px;
            color:#00a041;
            cursor: pointer;
          }
        }
        .declaration_list{
          // margin-top: 21px;
          // 筛选
          .filter{
            display: flex;
            justify-content: flex-end;
            color:#797979;
            font-size: 13px;
            margin-top: 10px;
            div{
              font-size: 13px;
              span{
                cursor: pointer;
                margin-left: 39px;
                i{
                  padding-right: 10px;
                }
              }
            }
          }
          // 内容
          .list_cont{
            // margin-top: 14px;
            // tab栏
            .el-tabs__header{
              margin: 0;
              .el-tabs__active-bar{
                background-color: #00a041;
              }
              .el-tabs__item.is-active{
                color: #00a041;
              }
              .el-tabs__item:hover{
                 color:#00a041;
               }
            }
            // 内容
            .lists{
              display: flex;
              justify-content: space-between;
              align-items: center;
              border-bottom: solid 1px #eeeeee;
              padding-bottom: 15px;
              margin-top: 30px;
              cursor: pointer;
              .list_cont_left{
                color:#999999;
                font-size: 12px;
                p{
                  margin-bottom: 10px;
                  line-height: 1;
                  &:nth-child(1){
                    font-size: 15px;
                    color:black;
                    margin-bottom: 20px;
                  }
                  &:nth-child(2){
                    span{
                      padding-right: 121px;
                    }
                  }
                  &:nth-child(4){
                    span{
                      padding-right: 98px;
                    }
                  }
                }
              }
              .list_cont_check{
                cursor: pointer;
                span{
                  font-size: 12px;
                  color:#00a041;
                  background-color: #ecfcf2;
                  border-radius: 5px;
                  border: solid 1px #41d787;
                  padding: 5px 15px;
                }
              }
            }
          }
        }
        .fontcolor{
          color:#00a041;
        }
      }
      //分页
      .paging{
        text-align: center;
        margin: 31px 0 76px 0;
        .el-pagination.is-background .btn-prev,.el-pagination.is-background .btn-next{
          border: 1px solid #eee;
          background-color: #fff;
        }
        .el-pagination.is-background .el-pager li{
          background-color: #fff;
          border: 1px solid #eee;
        }
        .el-pagination.is-background .el-pager li:not(.disabled).active{
          background-color: #00a041;
          color: #fff;
        }
        .el-pagination__sizes .el-input .el-input__inner:hover{
          border-color: #00a041;
        }
        .el-select .el-input__inner:focus{
          border-color:#00a041;
        }
        .el-pagination.is-background .el-pager li:not(.disabled):hover{
          color:#000;
          
        }
      }
    }
  }
</style>

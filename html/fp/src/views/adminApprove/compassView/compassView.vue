<template>
  <div class="compass_view" v-loading="loading">
    <div class="banner" ref="banner">
      <div class="swiper-container">
          <div class="swiper-wrapper">
              <div class="swiper-slide" v-for="(item,index) in bannerList"> <img :src="item.adUrl" alt=""> </div>
          </div>
          <div class="swiper-pagination"></div>
           <div class="swiper-button-prev">
            <i class="el-icon-arrow-left"></i>
          </div>
          <div class="swiper-button-next">
            <i class="el-icon-arrow-right"></i>
          </div>
      </div>
    </div>
    <div class="approve_content"><!-- 版心 -->
      <!-- 面包屑 -->
      <div class="approve_breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item :to="{path: '/compassView'}">
            <a href="javascript:;">行政审批</a>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!-- 所有类别 -->
      <div class="all_cate clearfix">
        <!-- <div class="fl all" @click="changename('')"><span :class="{'isSlect_all':name===''}">所有类别：</span></div> -->
        <div class="all_cate_box clearfix">
          <div>省级：</div>
          <ul>
            <!-- <li style="font-size:14px">省级：</li> -->
            <li v-for="(item,index) in allCateList[0]" :key="index" @click="changename(item.id)"><span :class="{'isSlect_cate':item.id===name}">{{item.name}}</span></li>
          </ul>
        </div>
        <div class="all_cate_box clearfix">
          <div>市级：</div>
          <ul>
            <!-- <li style="font-size:14px">市级：</li> -->
            <li v-for="(item,index) in allCateList[1]" :key="index" @click="changename(item.id)"><span :class="{'isSlect_cate':item.id===name}">{{item.name}}</span></li>
          </ul>
        </div>
        <div class="all_cate_box clearfix">
          <div>区级：</div>
          <ul>
            <!-- <li style="font-size:14px">区级：</li> -->
            <li v-for="(item,index) in allCateList[2]" :key="index" @click="changename(item.id)"><span :class="{'isSlect_cate':item.id===name}">{{item.name}}</span></li>
          </ul>
        </div>
      </div>
      <!-- 直接审批 -->
      <div>
        <!-- 标题 -->
        <div class="direct_approve">
          <div class="direct_title">直接审批</div>
          <div class="actiSearch">
            <input type="text" placeholder="输入要搜索的关键字" v-model="search">
            <i class="iconfont icon-sousuo" @click="handlesearch"></i>
          </div>
        </div>
        <div class="direct_approve_list">
            <el-collapse accordion>
              <el-collapse-item v-for="(poweritem,powerindex) in powerList" :key="powerindex">
                <template slot="title"  >
                  <span></span><span v-if="poweritem.childs.length!=0">{{poweritem.name}}</span>
                  <span v-else @click="gotorightdetail(poweritem.id)">{{poweritem.name}}</span>
                </template>
                  <p v-for="(childsitem,childsindex) in poweritem.childs" :key="childsindex" @click="gotorightdetail(childsitem.id)"><span></span>{{childsitem.name}}</p>
                  <!-- <p v-show="poweritem.childs.length===0">暂无数据</p> -->
              </el-collapse-item>
            </el-collapse>
        </div>
      </div>
      <!-- 分页 -->
      <div class="paging">
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
import Swiper from 'swiper'
export default {
  data () {
    return {
      total:20,
      name:'',//类别
      allCateList:[],
      powerList:[],
      search:"",
      page:1,
      rows:6,
      total:0,
      loading:true,
      bannerList:[]
    }
  },
  created () {
    this.getAllCate()
    // this.getPowerList()
    this.getImg()
    if(sessionStorage.getItem("url")){
      this.name=sessionStorage.getItem("name")
      this.getPowerList()
    }else{
       this.getPowerList()
    }
  },
  destroyed () {
    sessionStorage.removeItem("url")
    sessionStorage.removeItem("name")
  },
  methods: {
    // 初始化swiper
    swiperInit(){
        var mySwiper = new Swiper ('.swiper-container', {
        loop: true, 
        pagination: {
          el: '.swiper-pagination',
        },
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        },
      })
    },
    getImg(){
      this.api.get({
        url: "SpAdvertising",
        data: {
          name:this.name
         },
        callback: (res)=>{
          if (res.code == "0000") {
          this.bannerList=res.data
          this.$nextTick(() => {
            this.swiperInit()  
          })
          }
        }
      });
    },
    handleSizeChange(val) {
      // console.log(`每页 ${val} 条`);
      this.rows=val
      this.getPowerList()
    },
    handleCurrentChange(val) {
      // console.log(`当前页: ${val}`);
      this.page=val
      this.getPowerList()
    },
    // 所有类别
    getAllCate(){
      let _this = this;
      this.api.get({
        url: "getCompassAllCate",
        data: {
          name:this.name
         },
        callback: function(res) {
          if (res.code == "0000") {
            _this.allCateList = res.data;
          }
        }
      });
    },
    getPowerList(){
      let _this = this;
      this.api.get({
        url: "getpowerList",
        data: {
          departId:this.name,
          name:this.search,
          page:this.page,
          rows:this.rows,
         },
        callback: function(res) {
          // console.log(res);
          if (res.code == "0000") {
            _this.loading=false
            _this.powerList = res.data.rows;
            _this.total=res.data.total
          }
        }
      });
    },
    //改变name
    changename(name){
      if(this.name===name){
        this.name=''
        this.getPowerList()
      }else{
        this.name=name
        this.loading=true
        this.getPowerList()
      }
    },
    //搜索
    handlesearch(){
      this.loading=true
      this.getPowerList()
    },
    //跳转到rightdetail
    gotorightdetail(id){
      // sessionStorage.setItem("id",id)
      this.$router.push({path:'/rightDetail',query:{id:id,name:this.name}})
    }
  }
}
</script>
<style lang="scss">
  .compass_view{
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
    // 面包屑
    .approve_breadcrumb{
      padding: 15px 0;
      font-size: 12px;
      .el-breadcrumb__item:last-child .el-breadcrumb__inner a{
        color:#00a041;  
      }
    }
    // 所有类别
    .all_cate{
      border: 1px solid #eeeeee;
      padding:16px;
      font-size: 12px;
      .all_cate_box{
        div{
          float: left;
          line-height: 45px;
        }
      }
      .all{
        width:8.3%;
        border-bottom: 1px solid #eeeeee;
        padding-bottom: 15px;
        margin-top: 14px;
      }
      .isSlect_all{
        background: #00a041;
        border-radius: 5px;
        color: #fff;
        padding: 3px 5px;
      }
      ul{
        display: flex;
        flex-wrap: wrap;
        padding-bottom: 0;
        .isSlect_cate{
          background: #00a041;
          border-radius: 5px;
          color:#fff;
        }
        li{
          // width:8.3%;
          // padding-bottom:16px;
          line-height: 45px;
          padding-right: 17px;
          border-style: solid;
          border-width: 0 0 1px 0;
          border-color: #eeeeee;
          span{
            padding: 3px 13px;
            cursor: pointer;
          }
        }
      }
    }
    // 直接审批标题
    .direct_approve{
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-top: 20px;
      padding-bottom: 13px;
      border-bottom: 1px solid #eeeeee;
      .direct_title{
        padding-left: 10px;
        border-left: 4px solid #00a041;
        line-height: 1;
      }
      .actiSearch {
        width: 200px;
        height: 30px;
        line-height: 30px;
        text-align: center;
        padding-right: 40px;
        border: 1px solid #eee;
        border-radius: 5px;
        >input {
          border: 0;
          width: 80%;
        }
        input,
        textarea,
        select,
        button {
          text-rendering: auto;
          color: #333;
          letter-spacing: normal;
          word-spacing: normal;
          text-transform: none;
          text-indent: 0;
          text-shadow: none;
          display: inline-block;
          text-align: start;
          margin: 0em;
          font: 400 14px Arial;
        }
  
        >.icon-sousuo {
          position: relative;
          top: -30px;
          right: -120px;
          cursor: pointer;
          font-size: 20px;
          display: inline-block;
          width: 36px;
          line-height: 30px;
          text-align: center;
          border-left: 1px solid #eee;
        }
      }
    }
    .direct_approve_list{
      padding-top:15px;
      .el-collapse{
        border-bottom:none;
        border-top:none;
      }
      .el-collapse-item{
        border: 1px solid #EBEEF5;
        margin-top: 23px;
      }
      .el-collapse-item__header{
        padding-left: 16px;
        border-bottom:none;
        span{
          font-size: 15px;
          width:100%;
          &:first-child{
            display: inline-block;
            width: 8px;
            height: 8px;
            border-radius: 50%;
            background-color:#00a041;
            margin-right: 8px;
          }
        }
      }
      .el-collapse-item__wrap{
        // border: 1px solid #EBEEF5;
        border-top: none;
        border-bottom:none;
      }
      .el-collapse-item__content{
        margin-left: 34px;
        padding-bottom:0;
        p{
          border-top: 1px solid #eeeeee;
          height: 40px;
          line-height: 40px;
          color:#999999;
          &:hover{
            cursor:pointer;
          }
          span{
            display: inline-block;
            width: 4px;
            height: 4px;
            line-height: 4px;
            border-radius: 50%;
            background-color:#999999;
            margin-right: 8px;
            margin-bottom: 3px;
          }
        }
      }
    }
    //分页
    .paging{
      text-align: center;
      margin:66px 0 78px 0 ;
      .el-pagination.is-background .btn-prev,.el-pagination.is-background .btn-next{
          border: 1px solid #eee;
          background-color: #fff;
        }
        .el-pagination.is-background .el-pager li{
          background-color: #fff;
          border: 1px solid #eee;
        }
        .el-pagination.is-background .el-pager li:not(.disabled):hover{
          color:#00a041;
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
        
    }
  }
</style>


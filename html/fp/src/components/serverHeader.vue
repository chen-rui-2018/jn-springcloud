<template>
  <div id="serverHeader" @mouseleave="searchLeave" ref="indexHeader">
    <!-- 头部 -->
    <div class="headContent" ref="headContent">
        <div class="bannerNav" :class="{'bannerNavAct':isActClass===true}">
            <div class="w clearfix type_page">
                <div class="titleImg ">
                  <div>
                    <!-- <img src="@/../static/img/LOGO1.png" alt="" class="pointer" @click="$router.push({path:'/'})" v-if="isActClass===false"> -->
                    <img src="@/../static/img/login-logo.png" alt="" class="pointer" @click="$router.push({path:'/'})">
                  </div>
                  <div class="title">服务超市</div>
                </div>
                <div class="bannerUl">
                    <li @click='$router.push({path:"/serMatHp"})'>首页</li>
                    <li :class="{'active':this.$route.name==='serverOrg'||this.$route.name==='serverOrgDetail'}" @click='$router.push({path:"/serverOrg"})'>服务机构</li>
                    <li @click='$router.push({path:"/serverPro"})' :class="{'active':this.$route.name==='serverPro'||this.$route.name==='serverProDetail'}">服务产品</li>
                    <li @click='$router.push({path:"/serverCon"})' :class="{'active':this.$route.name==='serverCon'||this.$route.name==='serverConDetail'}">服务顾问</li>
                    <li @click='$router.push({path:"/actiTrain"})' :class="{'active':this.$route.name==='actiTrain'||this.$route.name==='actiDetail'}">活动培训</li>
                    <li @click='$router.push({path:"/aboutUs"})' :class="{'active':this.$route.name==='aboutUs'}">关于我们</li>
                </div>
                <div class="headerRight">
                  <div class="search" >
                    <i class="el-icon-search" style="font-size:20px" @click="show3=true"></i>
                  </div>
                  <div class="navlogin">
                    <a>登录</a>
                    <span class="line">|</span>
                    <a>注册</a>
                  </div>
                  <div class="navlogin">
                    <i class="el-icon-bell"></i>
                    <span class="line">|</span>
                  </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 搜索框  ,'search_box_margin':show3-->
    <div class="search_box" :class="{'search_box_act':isActClass===true}">
      <el-collapse-transition>
          <div v-if="show3">
            <div class="transition-box">
              <el-input placeholder="请输入内容" v-model="searchData" class="input-with-select">
                <el-select v-model="select" slot="prepend" placeholder="产品" @visible-change="changeselectShow">
                  <el-option label="机构" value="1"></el-option>
                  <el-option label="产品" value="2"></el-option>
                  <el-option label="顾问" value="3"></el-option>
                  <el-option label="活动" value="3"></el-option>
                </el-select>
                <el-button slot="append" icon="el-icon-search">搜索 </el-button>
              </el-input>
            </div>
          </div>
      </el-collapse-transition>
    </div>
  </div>
</template>

<script>
import swiper from "swiper"
export default {
  data() {
    return {
      offsetTop:0,
       isActClass:false,
       isNavShow:true,
       show3:false,
       searchData:'',
       select:'',
       menuShow:true,
       sliderData:[
         {name:'工商服务', 
          id:1,
          childs:[
           {name:'代',id:4},
           {name:'年度财务审计',id:5},
           {name:'年度财务审计',id:5},
           {name:'年度财务审计',id:5},
           {name:'年度财务审计',id:5}
          ]
         },
         {name:'法律服务',
          id:2,
          childs:[
           {name:'代理',id:4},
           {name:'年度财务审计',id:5},
           {name:'年度财务审计',id:5}
         ]},
         {name:'人力资源',id:3,childs:[
           {name:'代理记',id:4},
           {name:'年度财务审计',id:5},
           {name:'年度财务审计',id:5}
         ]},
        {name:'人力资源',id:3,childs:[
           {name:'代理记',id:4},
           {name:'年度财务审计',id:5},
           {name:'年度财务审计',id:5}
         ]}
       ],
       sekectShow:false
    };
  },
  mounted(){
   this.getIndustryList()
  },
  methods: {
     searchLeave() {
      if (this.sekectShow) {
        this.show3 = true
      } else {
        this.show3 = false
      }
      
      console.dir(this.show3)
    },
    changeselectShow(val){
      this.sekectShow=val
    },
     handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      getIndustryList(){
      let _this = this;
      this.api.get({
        url: "selectIndustryList",
        data: { },
        callback: function(res) {
          // console.log(res);
          if (res.code == "0000") {
            _this.industryList = res.data.rows;
          }
        }
      });
    },
  }
};
</script>

<style lang="scss" scoped>
// 头部
#serverHeader {
  position: fixed;
  width: 100%;
  z-index: 100;
  .headContent {
    .bannerNav {
      width: 100%;
      color: #000;
      background: #fff;
      border-bottom: 1px solid #eee;
      box-shadow: 0px 0px 12px 1px rgba(0, 0, 0, 0.07) ;
      .type_page{
        display: flex;
        justify-content: space-between;
        align-items: center;
        width: 84%;
      }
      .title{
        font-size: 25px;
        margin-left: 20px;
      }
      .titleImg {
        display: flex;
            width: 22%;
        div:nth-child(1){
          width: 50%;
        }
        img {
          width: 100%;
          height: 100%;
          vertical-align: middle;
        }
      }
      .bannerUl {
        list-style: none;
        line-height: 64px;
        font-size: 13px;
        display: flex;
        margin: 0 7%;
        flex: 1;
        justify-content: space-around;
        text-align: center;
          li {
          width: 16%;
          cursor: pointer;
          border-radius: 5px;
        }
        .active{
          color:#00a041;
        }
      }
      .headerRight {
        font-size: 12px;
        display: flex;
        .search {
          display: inline-block;
          margin-right: 20px;
          vertical-align: middle;
          i {
            width: 20px;
            height: 20px;
          }
        }
        .navlogin {
          .line {
            display: inline-block;
            height: 12px;
            margin: 0 15px;
          }
        }
      }
    }
    .bannerNavAct{
      background-color: #fff;
      color: black;
      border-bottom: 1px solid #eee;
      box-shadow:0 10px 10px -10px #ccc;
    }
  }
  // 侧边栏
  .fadeInDown{
    animation-duration: 2s;
  }
  .fadeOutUp{
    animation-duration: 2s;
  }
  .nav{
    // animation: fadeInDown 3s ;
    position: absolute;
    left: 13%;
    width: 16%;
    margin-top: 14px;
    font-size: 13px;
    // border:1px solid black;
    .nav_cont{
      display: flex;
      flex-wrap: wrap;
      .nav_cont_son {
        display: none;
        color:#fff;
        background: rgba(0, 0, 0,0.3);
        padding:20px 20px;
        span{
            display: inline-block;
            width: 5px;
            height: 5px;
            border-radius: 50%;
            background-color: #fff;
            margin-right: 8px;
          }
        div:hover{
          color:#00a041;
        }
        div:hover span{
          background-color: #00a041;
        }
      }
      &:hover .nav_cont_son {
        display: flex;
        flex-wrap: wrap;
        position: absolute;
        right: -366px;
        background: rgba(0, 0, 0,0.3);
        width: 326px;
        div{
          width: 50%;
          line-height: 40px;
        }
      }
      &:hover .nav_cont_father{
        background-color: #fff;
        color:#00a041;
      }
      .nav_cont_father{
        background: rgba(0, 0, 0,0.3);
        // position: relative;
        width: 100%;
        color:#fff;
        padding:20px 20px 20px 28px;
        display: flex;
        justify-content: space-between;
      }
    }
  }

.search_box{
  background: #fff;
  text-align: center;
  box-shadow:0 10px 10px -10px #ccc;
  .el-input-group{
   
    border-radius: 28px;
    width:42%;
    margin:43px 0;
    .el-input{
      width:94px;
    }
    .el-input__inner:focus{
      border-color: #00a041;
      
    }
    .el-input-group__append, .el-input-group__prepend{
      border-radius: 28px;
    }
    .el-input-group__append{
      /* border-top-left-radius: 0;
      border-bottom-left-radius: 0; */
      background: #00a041;
      color:#fff;
      right: 58px;
      .el-button{
        margin: -10px -10px;
      }
    }
    .el-input-group__prepend{
      border-top-right-radius: 0; 
      border-bottom-right-radius: 0;
      background-color: #fff;
      padding: 0px 17px 0 9px;
      
      input{
        color:#666666;
        text-align: right;
        border-right: none;
        &:focus{
          border-left: none;
        }
      }
    }
  }
}
.search_box_act{
  background:#fff;
  box-shadow:0 10px 10px -10px #ccc;
}
  
}

</style>

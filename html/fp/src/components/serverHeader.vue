<template>
    <div id="serverHeader">
      <div class="fullNav clearfix">
          <div class="navLeft fl" @click="isVisibility=true">
              <i class="iconfont icon-caidan"></i>
              <span>网站导航</span>
          </div>
          <ul class="navRight fr">
              <li>联系客服</li>
              <li class="line"></li>
              <li>下载APP</li>
              <li class="line"></li>
              <li>关注微信</li>
              <li class="line"></li>
              <li>登录</li>
              <li class="line"></li>
              <li>注册</li>
          </ul>
      </div>
      <div class="headContent">
          <div class="searchNav">
              <div class="trainLogo">
                  <img src="@/../static/img/greenLogo.png" alt="">
              </div>
              <div class="trainSearch pr">
                  <input type="text" placeholder="请输入搜索关键词">
                  <div class="iconSearch">
                      <i class="el-icon-search" style="font-size:20px;"></i>
                      <span>搜索</span>
                  </div>
                  <!-- <el-button type="primary" icon="el-icon-search" style="background:#00a042;height:40px;font-size:20px;line-height:40px;">搜索</el-button> -->
                  <div class="keyWord">
                      <span>机构</span>
                      <span>产品</span>
                      <span>顾问</span>
                      <span>活动</span>
                  </div>
              </div>
          </div>
          <div class="bannerNav">
              <div class="w clearfix">
                  <div class="bannerSer fl">
                    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
                        <el-submenu index="2">
                          <template slot="title">
                            <i class="iconfont icon-menu1"></i> 
                            <span>帮您快速找服务</span>
                          </template>
                            <el-menu-item  v-for="(i,k) in industryList" :key="k">{{i.preValue}}</el-menu-item>
                        </el-submenu>
                    </el-menu>
                  </div>
                  <div class="bannerUl fr">
                      <li :class="{'active':flag1==''}" @click="handJump('')">首页</li>
                      <li v-for="(i,k) in bannerList" :key="k" :class="{'active':flag1==i.name}" @click="handJump(i)">{{i.name}}</li>
                  </div>
              </div>
          </div>
      </div>
      <!-- 网站导航侧边 -->
      <div class="serve_slide">
        <el-dialog :visible.sync="isVisibility">
          <div class="slide_nav">
            <p >首页</p>
            <p>招商引资</p>
            <p>智慧党建</p>
            <p>秦淮区1+X公共服务平台</p>
            <div class="slide_nav_fence">
              <ul>
                <li>申报中心</li>
                <li>政策中心</li>
                <li>行政中心</li>
                <li>活动中心</li>
                <li>科技金融</li>
                <li>人力资源</li>
                <li>服务超市</li>
              </ul>
            </div>
          </div>

          <div class="personal_center ">
            <p>用户中心</p>
            <p>消息中心</p>
          </div>
        </el-dialog>
      </div>
    </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: '2',
      // activeIndex2: '1',
      isVisibility:false,
      flag1:'',
      bannerList:[
        // {
        // name:"首页",
        // path:"/serMatHp",
        // },
        {
        name:"服务机构",
        path:"/serverOrg",
        },
        {
        name:"服务产品",
        path:"/serverPro",
        },
        {
        name:"服务顾问",
        path:"/serverCon",
        },
        {
        name:"活动培训",
        path:"/actiTrain",
        },
        {
        name:"关于我们",
        path:"/aboutUs",
        }
      ],
      industryList:[]//快速寻找服务下拉
    };
  },
  mounted(){
   this.getIndustryList()
  },
  methods: {
    handJump(i){
      this.flag1=i.name;
      if(this.flag1==''){
        debugger
        this.$router.push({ path:'/serMatHp'});
      } else {
        this.$router.push({ path: i.path});
      }
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
#serverHeader {
  .fullNav {
    // width: 1286px;
    // margin:0 auto;
    padding: 10px 40px;
    background: #eeeeee;
    color: #9a9a9a;
    .navLeft {
    }
    .navRight {
      > li {
        float: left;
      }
      > .line {
        display: inline-block;
        height: 12px;
        width: 1px;
        margin: 0 20px;
        background-color: #9a9a9a;
        padding: 0;
        margin-top: 6px;
      }
    }
  }
  .headContent {
    .searchNav {
      width: 1190px;
      margin: 0 auto;
      .trainLogo {
        display: inline-block;
        padding: 20px 0;
        width: 155px;
        height: 42px;
        > img {
          width: 100%;
          height: 100%;
          // vertical-align: middle;
        }
      }
      .trainSearch {
        display: inline-block;
        margin-left: 250px;
        top: 8px;
        > input {
          height: 40px;
          border: 2px solid #00a042;
          border-radius: 5px;
          width: 400px;
          padding-right: 90px;
          // text-indent: 15px;
        }
        input,
        textarea,
        select,
        button {
          text-rendering: auto;
          color: #d4d4d4;
          letter-spacing: normal;
          word-spacing: normal;
          text-transform: none;
          text-indent: 15px;
          text-shadow: none;
          display: inline-block;
          text-align: start;
          margin: 0em;
          font: 400 16px Arial;
        }
        .iconSearch {
          color: #fff;
          font-size: 18px;
          position: absolute;
          right: 0;
          top: 2px;
          height: 41px;
          width: 90px;
          line-height: 40px;
          text-align: center;
          background: #00a042;
          border-radius: 0 5px 5px 0;
        }
      }
    }

    .bannerNav {
      width: 100%;
      color: #fff;
      // padding: 20px 0;
      background-color: #00a042;
      font-size: 16px;
      .bannerSer {
        padding: 0 40px 0 20px;
        .icon-menu1 {
          font-size: 18px;
          margin-right: 20px;
          color: #fff;
        }
      }
      .bannerUl {
        list-style: none;
        line-height: 60px;
        > li {
          float: left;
          padding: 0 40px;
          cursor: pointer;
        }
        // > li:last-child {
        //   padding-right: 0;
        // }
        >li.active{
          background-color: #007f34;
        }
      }
    }
  }
  .serve_slide{
    .slide_nav{
      color:#00a042;
      border-bottom: 1px solid #00a042;
      padding: 20px;
      p{
        padding-bottom: 30px;
        font-size: 18px;
      }
      p:nth-child(4){
        padding-bottom:0px;
      }
      .slide_nav_fence{
        font-size: 15px;
        li{
          padding-bottom: 8px; 
          &:nth-child(1){
            padding-top: 20px;
          }
        }
      }
    }
    .personal_center{
      padding: 30px 20px;
      p{
        padding-bottom: 15px;
      }
    }
  }
}

</style>

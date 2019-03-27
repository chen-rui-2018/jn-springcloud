<template>
    <div id="serverHeader">
        <div class="fullNav clearfix">
            <div class="navLeft fl">
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
                        <i class="iconfont icon-menu1"></i>
                        <span>帮您快速找服务</span>
                    </div>
                    <div class="bannerUl fr">
                        <li>首页</li>
                        <li>服务机构</li>
                        <li>服务产品</li>
                        <li>服务顾问</li>
                        <li>活动培训</li>
                        <li>关于我们</li>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {}
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
        width: 218px;
        height: 54px;
        > img {
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
      padding: 20px 0;
      background-color: #00a042;
      font-size: 16px;
      .bannerSer {
        padding: 0 40px 0 20px;
        .icon-menu1 {
          font-size: 18px;
          margin-right: 20px;
        }
      }
      .bannerUl {
        list-style: none;
        > li {
          float: left;
          padding: 0 40px;
        }
        > li:last-child {
          padding-right: 0;
        }
      }
    }
  }
}
</style>

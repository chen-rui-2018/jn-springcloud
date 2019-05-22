<template>
    <div class="aboutUs w">
        <div class="serverOrgMenu">
            <span class="pointer" @click="$routet.push({path:'/enterpriseservice'})">企业服务</span>
            <span>/</span>
            <span class="pointer" @click="$routet.push({path:'/serMatHp'})">服务超市</span>
            <span>/</span>
            <span class="mainColor agent">关于我们</span>
        </div>
        <div class="aboutContent">
            <el-container>
                <el-aside width="150px" v-if="flag1">
                    <div class="abtUs">关于我们</div>
                    <!-- <div class="abtCot" @click="showFlag=!showFlag" :class="{'active':showFlag}">超市介绍</div> -->
                    <ul class="abtMenu">
                        <li @click="showFlag=!showFlag" :class="{'active0':showFlag}">超市介绍</li>
                        <!-- <li :class="{'active':curindex==k}" class="lis" v-for="(i,k) in abtMenu" :key="k" :data-id="i.id" @mouseover="handleLi(i,k)">{{i.name}}</li> -->
                        <!-- <li :class="{'active':curindex==k}" class="lis" v-for="(i,k) in abtMenu" :key="k" :data-id="i.id" @click="handleLi(i,k)">{{i.name}}</li> -->
                        <li @click="showFlag=!showFlag" :class="{'active0':!showFlag}">联系我们</li>
                    </ul>
                    <!-- <div class="abtCot" @click="showFlag=!showFlag" :class="{'active':!showFlag}">联系我们</div> -->
                </el-aside>
                <!-- <el-aside width="150px" style="position:fixed" v-else>
                    <div class="abtUs">关于我们</div> -->
                    <!-- <div class="abtCot" @click="showFlag=!showFlag" :class="{'active':showFlag}">超市介绍</div> -->
                    <!-- <ul class="abtMenu">
                        <li @click="showFlag=!showFlag" :class="{'active':showFlag}">超市介绍</li>
                        <li :class="{'active':curindex==k}" class="lis" v-for="(i,k) in abtMenu" :key="k" :data-id="i.id" @mouseover="handleLi(i,k)">{{i.name}}</li>
                        <li @click="showFlag=!showFlag" :class="{'active':!showFlag}">联系我们</li>
                    </ul> -->
                    <!-- <div class="abtCot" @click="showFlag=!showFlag" :class="{'active':!showFlag}">联系我们</div> -->
                <!-- </el-aside> -->
                <el-main v-if="showFlag" class="elMain">
                    <div class="enterpriSever">
                        <div class="title mainColor">企业服务超市</div>
                        <p class="color2">
                            企业服务超市（以下简称“超市”）是由南京白下高新区发展服务中心作为指导单位、园区企业发展服务促进会（以下简称“企服会”）作为 运营方协力推进，针对企业各类非核心业务外包需求，为服务机构与企业搭建的公益性的服务供需对接线上交流平台。
                        </p>
                    </div>
                    <div class="item enterpriSever" id="item1">
                        <div class="title mainColor">超市定位</div>
                        <div class="enterCon clearfix">
                            <div class="dataMid fl">
                                <div class="dataCircle">
                                    <img src="@/../static/img/yuandian.png" alt="">
                                </div>
                                <div class="dataLine"></div>
                                <div class="dataCircle">
                                    <img src="@/../static/img/yuandian.png" alt="">
                                </div>
                                <div class="dataLine"></div>
                                <div class="dataCircle">
                                    <img src="@/../static/img/yuandian.png" alt="">
                                </div>
                            </div>
                            <div class="dataRight fl">
                                <div>区域性权威的科技服务业信息共享平台，服务企业及机构。</div>
                                <div>对企业：帮助企业快速找到诚信规范、价格合理的合作伙伴。</div>
                                <div>对机构：帮助服务机构拓展市场，促进供需双方共同成长。</div>
                            </div>
                        </div>
                    </div>
                    <div class="item enterpriSever" id="item2">
                        <div class="title mainColor">面向对象</div>
                        <div class="enterCon clearfix">
                            <div class="dataMid fl">
                                <div class="dataCircle">
                                    <img src="@/../static/img/yuandian.png" alt="">
                                </div>
                                <div class="dataLine"></div>
                                <div class="dataCircle">
                                    <img src="@/../static/img/yuandian.png" alt="">
                                </div>
                                <div class="dataLine"></div>
                                <div class="dataCircle">
                                    <img src="@/../static/img/yuandian.png" alt="">
                                </div>
                                <div class="dataLine"></div>
                                <div class="dataCircle">
                                    <img src="@/../static/img/yuandian.png" alt="">
                                </div>
                            </div>
                            <div class="dataRight fl">
                                <div>面向专业服务机构开放，具体要求详见
                                    <a class="mainColor pointer">《秦淮区“1+X”公共服务中心商务服务领域》</a>
                                </div>
                                <div>面向专业服务顾问开放。</div>
                                <div>面向政府与相关行业主管部门开放。</div>
                                <div>面向所有企业开放。</div>
                            </div>
                        </div>
                    </div>
                    <div class="item enterpriSever" id="item3">
                        <div class="title mainColor">服务功能</div>
                        <p class="color2" style="width:850px">
                            多渠道采集服务机构、服务人员信息，健全机构及顾问服务档案，建立属于口碑服务的服务供需匹配及服务质量等管理体系； 整合上下游服务链，实现供需精准对接、评价评优、政策兑现、活动培训、行业分析、咨询服务等功能； 基于服务大数据，为企业提供更专业的平台化服务，为区域高端服务业产业分析提供基础数据。
                        </p>
                    </div>
                    <div class="item enterpriSever dataLoad" id="item4">
                        <div class="title mainColor">资料下载</div>
                        <ul class="dataUl">
                            <li>
                                <div class="enclosure">附件1</div>
                                <!-- <a href="/epservice/techsub/Apps/epssm/Tpl/Home/default/Public/download/企业服务超市用户使用手册【机构版】.pdf" target="_blank" download="企业服务超市用户使用手册【机构版】.pdf">企业服务超市用户使用手册【机构版】</a> -->
                                <a href="javascript:;" target="_blank" download="企业服务超市用户使用手册【机构版】.pdf">企业服务超市用户使用手册【机构版】</a>
                            </li>
                            <li>
                                <div class="enclosure">附件2</div>
                                <a href="javascript:;">企业服务超市用户使用手册【顾问版】</a>
                            </li>
                            <li>
                                <div class="enclosure">附件3</div>
                                <a href="javascript:;">企业服务超市用户使用手册【企业版】</a>
                            </li>
                        </ul>
                    </div>
                </el-main>
                <el-main v-else>
                    <div class="enterpriSever">
                        <div class="enterCon1 clearfix">
                            <div class="enterLeft fl">
                                <div class="title mainColor">联系我们</div>
                                <p class="p1">如您遇到任何问题，均可通过以下方式联系我们：</p>
                                <div class="left1">秦淮区“1+X”公共服务中心</div>
                                <div class="left1">
                                    <p>地址：南京市秦淮区紫丹路9号</p>
                                    <p>电话：
                                        <span style="color:#0C3BD5">
                                           025-69978813
                                        </span>
                                    </p>
                                    <p>邮箱：
                                        <span class="mainColor"> qhq1x_gov@163.com</span>
                                    </p>
                                </div>
                                <div class="left1">
                                    <p>服务热线：025-69978843</p>
                                    <!-- <p>邮编：467300</p>
                                    <p>咨询：
                                        <span style="color:#0C3BD5">51818518</span>
                                    </p>
                                    <p>传真：
                                        <span class="mainColor">0512-67068099</span>
                                    </p> -->
                                </div>
                                <!-- <div style="margin-bottom:50px">企业发展沙龙：
                                    <span class="mainColor"> 0512-67068048</span>
                                </div> -->
                            </div>
                            <div class="enterRight fl">
                                <p>关注微信公众号</p>
                                <img src="@/../static/img/erweima1.jpg" alt="">
                                <p>BAIXIAGAOXIN</p>
                            </div>
                        </div>
                    </div>
                    <iframe src="/static/map.html" frameborder="0" height="300" width="700"></iframe>
                    <!-- <div id="allmap" style="height:300px"></div> -->
                </el-main>
            </el-container>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      showFlag: true,
      curindex:0,
      flag1:true,
      abtMenu: [
        // {
        //   name: "超市介绍",
        //   flag: ""
        // },
        {
          name: "超市定位",
          id: "item1"
        },
        {
          name: "面向对象",
          id: "item2"
        },
        {
          name: "服务功能",
          id: "item3"
        },
        {
          name: "资料下载",
          id: "item4"
        }
      ]
    };
  },
  mounted() {
       window.addEventListener('scroll',this.handleScroll)
      this.init();
    //   this.initScroll()
    // var map = new BMap.Map("allmap");
    // map.enableScrollWheelZoom(); //启用滚轮放大缩小，默认禁用
    // map.enableContinuousZoom(); //启用地图惯性拖拽，默认禁用
    // map.centerAndZoom("北京", 12); // 初始化地图,设置城市和地图级别。
  },
  methods: {
      init(){
          for(let i = 0; i < this.abtMenu.length;i++){        
              this.abtMenu[i].top = document.getElementById(this.abtMenu[i].id).offsetTop;
          }
      },
    handleLi(i,k) {
        if(this.curindex == k){
            return
        }
        this.curindex = k;
        window.scrollTo(0,i.top);
    },
    handleScroll(){
        for(let i = 0; i < this.abtMenu.length;i++){
            if(this.abtMenu[i].top >= this.getScrollTop()){
                if(i>0){
                    this.curindex = i - 1;
                    return
                }
            }
        }
    },
    getScrollTop() {
      var scroll_top = 0;
      if (document.documentElement && document.documentElement.scrollTop) {
        scroll_top = document.documentElement.scrollTop;
      } else if (document.body) {
        scroll_top = document.body.scrollTop;
      }
      return scroll_top;
    },
  }
};
</script>
<style lang="scss">
.aboutUs {
    padding-top: 65px;
  .aboutContent {
    .el-aside {
      background-color: #f5f6f8;
      color: #333;
      text-align: center;
      height: 380px;
    }

    .el-main {
      //   background-color: #e9eef3;
      color: #333;
      //   text-align: center;
      //   line-height: 160px;
      padding: 0 20px;
    }
    .el-container {
      margin-bottom: 40px;
    }
    .abtUs {
      padding: 10px 0;
      background: #00a041;
      color: #fff;
      font-size: 17px;
    }
    .abtMenu {
      margin-top: 10px;
      > li {
        color: #333;
        font-size: 14px;
        padding: 14px 0;
        cursor: pointer;
      }
      > li.active0 {
        color: #00a041;
      }
    }
    .abtCot {
      font-size: 14px;
      margin-top: 10px;
      margin-bottom: 50px;
      cursor: pointer;
    }
  }
  .enterpriSever {
    .title {
      font-size: 23px;
      //   cursor: pointer;
    }
    > p {
      font-size: 13px;
      padding: 30px 0;
    //   width: 820px;
    }
    .enterCon {
      margin: 30px 0;
      color: #666;
      .dataMid {
        .dataCircle {
          width: 15px;
          height: 15px;
          > img {
            width: 100%;
            height: 100%;
          }
        }
        .dataLine {
          width: 1px;
          height: 55px;
          margin-left: 7px;
          background-color: #00a041;
        }
      }
      .dataRight {
        font-size: 13px;
        margin-left: 10px;
        > div {
          margin-bottom: 53px;
        }
        > div:last-child {
          margin-bottom: 0;
        }
      }
    }
    .enterCon1 {
      font-size: 13px;
      .enterLeft {
        .p1 {
          margin: 30px 0;
        }
        .left1 {
          margin-bottom: 30px;
          > p {
            height: 30px;
          }
        }
      }
      .enterRight {
        text-align: center;
        margin-left: 250px;
        margin-top: 60px;
        > img {
          width: 110px;
          height: 110px;
        }
      }
    }
  }
  .dataLoad {
    .title {
      margin-bottom: 15px;
    }
    .dataUl {
      font-size: 13px;
      > li {
        .enclosure {
          padding: 5px 10px;
          background: #00a041;
          color: #fff;
          display: inline-block;
          margin-right: 10px;
          margin-top: 15px;
        }
        > a {
          display: inline-block;
          vertical-align: middle;
          text-decoration: underline;
          color: #666;
        }
      }
    }
  }
}
</style>

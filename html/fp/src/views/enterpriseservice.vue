<template>
    <div class="enterpriseservice">
        <div class="portalIndexImg">
            <div id="header">
                <div class="headerContainer clearfix">
                    <div class="titleImg fl"><img src="@/../static/img/LOGO1.png" class="pointer" alt="" @click="$router.push({path:'/'})"></div>
                    <div class="headerRight fr">
                        <div class="search" v-if="!sousuo">
                            <i class="el-icon-search" @click="handleChange" style="font-size:20px"></i>
                        </div>
                        <div class="navlogin">
                            <a @click="$router.push({path:'/login'})">登录</a>
                            <span class="line">|</span>
                            <a @click="$router.push({path:'/register'})">注册</a>
                        </div>
                    </div>
                    <div class="nav">
                        <transition name="fade">
                            <div class="sousuo posA" v-if="sousuo">
                                <i class="el-icon-close" style="vertical-align: middle;" @click="sousuo=false"></i>
                                <input type="text" v-focus @keyup.enter="handleSearch">
                                <i class="el-icon-search" style="vertical-align: middle;" @click="sousuo=false"></i>
                            </div>
                            <ul class="posA clearfix" id="posA" v-else>
                                <li class="firstLi" @click="$router.push({path:'/'})">
                                    <a href="javascript:void(0);">首页</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);">招商引资</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);">智慧党建</a>
                                </li>
                                <li class="lastLi">
                                    <a href="javascript:void(0);">企业服务</a>
                                </li>
                            </ul>

                        </transition>
                    </div>
                </div>
            </div>
            <el-carousel :interval="5000" arrow="never">
                <!-- <el-carousel-item v-for="item in 4" :key="item"> -->
                <el-carousel-item>
                    <h3><img class="porImg" src="@/../static/img/qiye1.png" alt="" @click="$router.push({path:'/serMatHp'})"></h3>
                </el-carousel-item>
            </el-carousel>
            <div class="quickEnter">
                <ul>
                    <li>
                        <span>人才申报</span>
                        <p>PEOPLE&nbsp;DECLARE</p>
                        <img src="@/../static/img/right-arrow.png" alt="">
                    </li>
                    <li>
                        <span>高新企业</span>
                        <p>HIGH-TECH&nbsp;ENTERPRISE</p>
                        <img src="@/../static/img/right-arrow.png" alt="">
                    </li>
                    <li>
                        <span>孵化企业</span>
                        <p>INCUBATION&nbsp;ENTERPRISE</p>
                        <img src="@/../static/img/right-arrow.png" alt="">
                    </li>
                    <li>
                        <span>行政审批</span>
                        <p>ADMINISTRATIVE&nbsp;EXAMINATIO</p>
                        <img src="@/../static/img/right-arrow.png" alt="">
                    </li>
                </ul>
            </div>
        </div>
        <div class="declarationNotice w pr">
            <div class="tit color2 pr">申报中心
            </div>
            <div class="eng mainColor">DECLARE&nbsp;CENTER</div>
            <div class="line"></div>
            <div class="info clearfix">
                <div class="left fl">
                    <div class="lf">
                        <ul>
                            <li class="li1">01</li>
                            <li class="li2" id="li2"></li>
                            <li class="li3">02</li>
                            <li class="li4" id="li4"></li>
                            <li class="li5">03</li>
                        </ul>
                    </div>
                    <div class="rt">
                        <ul>
                            <li class="t1 color1">关于高新技术企业认定的申报及专项投资申报
                                <p>申报截止时间：2019-03-26</p>
                            </li>
                            <li class="t1 color1">申报高新技术产品认定,是国家高新技术企业认定的加分项。
                                <p>申报截止时间：2019-03-26</p>
                            </li>
                            <li class="t1 color1">南京市人民政府关于高新区企业资质荣誉申请...
                                <p>申报截止时间：2019-03-26</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="right fl"></div>

            </div>
            <div class="pagination-container">
                <el-pagination background layout="prev, pager, next" :total="30">
                </el-pagination>
            </div>
        </div>
        <div class="policyCenter w">
            <div class="tit color2 pr">政策中心
            </div>
            <div class="eng mainColor">POLICY&nbsp;CENTER</div>
            <div class="line"></div>
            <div class="paging w pr">
                <el-carousel :interval="5000" arrow="always">
                    <el-carousel-item v-for="item in 3" :key="item">
                        <ul class="page1 clearfix">
                            <li>
                                <div class="left1">N</div>
                                <div class="right1">
                                    <div class="rightTit color1">白下高新区金融扶持政策</div>
                                    <p class="color2">中央政府发布国发5号文，进一步扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....</p>
                                    <div class="liBom clearfix">
                                        <p class="fl color3">
                                            <i class="el-icon-view"></i>&nbsp;89</p>
                                        <span class="fr mainColor">南京市级</span>
                                        <i class="fr mainColor" style="marin-left:25px;">财政引导</i>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="left1">E</div>
                                <div class="right1">
                                    <div class="rightTit color1">南京白下高新区税收优惠政策</div>
                                    <p class="color2">中央政府发布国发5号文，进一步扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....</p>
                                    <div class="liBom clearfix">
                                        <p class="fl color3">
                                            <i class="el-icon-view"></i>&nbsp;89</p>
                                        <span class="fr mainColor">南京市级</span>
                                        <i class="fr mainColor" style="marin-left:25px;">财政引导</i>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="left1">W</div>
                                <div class="right1">
                                    <div class="rightTit color1">南京市人民政府人才激励政策...</div>
                                    <p class="color2">中央政府发布国发5号文，进一步扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....</p>
                                    <div class="liBom clearfix">
                                        <p class="fl color3">
                                            <i class="el-icon-view"></i>&nbsp;89</p>
                                        <span class="fr mainColor">南京市级</span>
                                        <i class="fr mainColor" style="marin-left:25px;">财政引导</i>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="left1">S</div>
                                <div class="right1">
                                    <div class="rightTit color1">关于维护知识产权政策</div>
                                    <p class="color2">中央政府发布国发5号文，进一步扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上....</p>
                                    <div class="liBom clearfix">
                                        <p class="fl color3">
                                            <i class="el-icon-view"></i>&nbsp;89</p>
                                        <span class="fr mainColor">南京市级</span>
                                        <i class="fr mainColor" style="marin-left:25px;">财政引导</i>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </el-carousel-item>
                </el-carousel>
                <!-- <ul class="page2">
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
                <div class="arrow">
                    <div class="arrow1"></div>
                    <div class="arrow2"></div>
                </div> -->
            </div>
        </div>
        <div class="approval">
            <div class="approvalInfo w">
                <div class="approTit">行政审批</div>
                <div class="approEng">Administrative&nbsp;approval</div>
                <div class="line"></div>
                <div class="approDel">了解详情&nbsp;&nbsp;<img src="@/../static/img/xiala.png" alt=""><img src="@/../static/img/xiala.png" alt=""></div>
            </div>
        </div>
        <div class="popularActi w">
            <div class="tit color2">活动中心</div>
            <div class="eng mainColor">Activity&nbsp;center</div>
            <div class="line"></div>
            <div class="acti pr">
                <el-carousel :interval="5000" arrow="always" :autoplay="false">
                    <el-carousel-item v-for="item in 4" :key="item">
                        <ul class="actiUl clearfix">
                            <li>
                                <div class="postImgItem">
                                    <img src="@/../static/img/heng4.png" class="postImg" alt="活动海报图片">
                                </div>
                                <div class="actiInfo">
                                    <p class="actiNameItem">
                                        白下高新科技园区国庆红歌唱响比赛， 大型主题活动即将开始
                                    </p>
                                    <p class="actiTimer">
                                        <i class="el-icon-time"></i>
                                        <span>10/17 周日14:00-17:00</span>
                                        <!-- <span>{{item.actiStartTime}}-{{item.actiEndTime.split(' ')[1]}}</span> -->
                                        <!-- <span>周日14：00-17：00</span> -->
                                    </p>
                                    <p>
                                        <i class="el-icon-location-outline"></i>
                                        <span>白下高新区管委会161号—A座</span>
                                    </p>
                                </div>
                                <div class="actiNum clearfix">
                                    <div class="avatar">
                                        <ul>
                                            <!-- <li v-for="(i,k) in item.avatarList" v-if="i<5" :key='k'><img :src="i" alt=""></li> -->
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                        </ul>
                                    </div>
                                    <i>678/1000名</i>
                                    <p class="avaP">
                                        <img src="@/../static/img/xin.png" alt="">16
                                    </p>
                                </div>
                            </li>
                            <li>
                                <div class="postImgItem postImgItem2">
                                    <img src="@/../static/img/dengpao2.png" class="postImg" alt="活动海报图片">
                                </div>
                                <div class="actiInfo">
                                    <p class="actiNameItem">
                                        白下高新科技园区国庆红歌唱响比赛， 大型主题活动即将开始
                                    </p>
                                    <p class="actiTimer">
                                        <i class="el-icon-time"></i>
                                        <span>10/17 周日14:00-17:00</span>
                                        <!-- <span>{{item.actiStartTime}}-{{item.actiEndTime.split(' ')[1]}}</span> -->
                                        <!-- <span>周日14：00-17：00</span> -->
                                    </p>
                                    <p>
                                        <i class="el-icon-location-outline"></i>
                                        <span>白下高新区管委会161号—A座</span>
                                    </p>
                                </div>
                                <div class="actiNum clearfix">
                                    <div class="avatar">
                                        <ul>
                                            <!-- <li v-for="(i,k) in item.avatarList" v-if="i<5" :key='k'><img :src="i" alt=""></li> -->
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                        </ul>
                                    </div>
                                    <i>678/1000名</i>
                                    <p class="avaP">
                                        <img src="@/../static/img/xin.png" alt="">16
                                    </p>
                                </div>
                            </li>
                            <li>
                                <div class="postImgItem">
                                    <img src="@/../static/img/heng3.png" class="postImg" alt="活动海报图片">
                                </div>
                                <div class="actiInfo">
                                    <p class="actiNameItem">
                                        白下高新科技园区国庆红歌唱响比赛， 大型主题活动即将开始
                                    </p>
                                    <p class="actiTimer">
                                        <i class="el-icon-time"></i>
                                        <span>10/17 周日14:00-17:00</span>
                                        <!-- <span>{{item.actiStartTime}}-{{item.actiEndTime.split(' ')[1]}}</span> -->
                                        <!-- <span>周日14：00-17：00</span> -->
                                    </p>
                                    <p>
                                        <i class="el-icon-location-outline"></i>
                                        <span>白下高新区管委会161号—A座</span>
                                    </p>
                                </div>
                                <div class="actiNum clearfix">
                                    <div class="avatar">
                                        <ul>
                                            <!-- <li v-for="(i,k) in item.avatarList" v-if="i<5" :key='k'><img :src="i" alt=""></li> -->
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                            <li><img src="" alt=""></li>
                                        </ul>
                                    </div>
                                    <i>678/1000名</i>
                                    <p class="avaP">
                                        <img src="@/../static/img/xin.png" alt="">16
                                    </p>
                                </div>
                            </li>
                        </ul>
                    </el-carousel-item>
                </el-carousel>
                <!-- <i class="iconfont icon-leftarrow pointer"></i>
                <i class="iconfont icon-rightarrow pointer"></i> -->
                <div class="lejieDel">了解详情</div>
            </div>
        </div>
        <!-- 科技金融 -->
        <div class="technologyFinance pr">
            <div class="w">
                <div class="tuoyuan">
                    <i class="el-icon-arrow-down"></i>
                </div>
                <div class="tit color2 pr pointer" @click="$router.push({path:'/tfindex'})">科技金融
                </div>
                <div class="eng mainColor pointer" @click="$router.push({path:'/tfindex'})">SCIENCE&nbsp;AND&nbsp;FINACIAL</div>
                <div class="line"></div>
                <div class="btns" id="btns">
                    <button class="btn1">投资人</button>
                    <button class="btn2 btn11">金融产品</button>
                    <button class="btn2">金融机构</button>
                </div>
                <div class="tecnInfo clearfix">
                   <!--  <div class="info1 clearfix">
                        <div class="lef1 fl clearfix">
                            <div class="imgItem fl"><img src="@/../static/img/largeImg.png" alt=""></div>
                            <div class="itemInfo fr">
                                <span class="color1">郭龙华/总经理</span>
                                <p class="color3 if1">苏州万隆永鼎会计师事务所有限公司</p>
                                <p class="color3">合伙人</p>
                            </div>
                        </div>
                        <ul class="lef2 fr clearfix">
                            <li class="clearfix">
                                <div class="imgItem fl"><img src="@/../static/img/largeImg.png" alt=""></div>
                                <div class="itemInfo fr">
                                    <span class="color1">郭龙华/总经理</span>
                                    <p class="color3 if1">苏州万隆永鼎会计师事务所有限公司</p>
                                    <p class="color3">合伙人</p>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="imgItem fl"><img src="@/../static/img/图层 46.png" alt=""></div>
                                <div class="itemInfo fr">
                                    <span class="color1">郭龙华/总经理</span>
                                    <p class="color3 if1">苏州万隆永鼎会计师事务所有限公司</p>
                                    <p class="color3">合伙人</p>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="imgItem fl"><img src="@/../static/img/49.png" alt=""></div>
                                <div class="itemInfo fr">
                                    <span class="color1">郭龙华/总经理</span>
                                    <p class="color3 if1">苏州万隆永鼎会计师事务所有限公司</p>
                                    <p class="color3">合伙人</p>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="imgItem fl"><img src="@/../static/img/图层 44.png" alt=""></div>
                                <div class="itemInfo fr">
                                    <span class="color1">郭龙华/总经理</span>
                                    <p class="color3 if1">苏州万隆永鼎会计师事务所有限公司</p>
                                    <p class="color3">合伙人</p>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="info1 clearfix">
                        <div class="lef1 fl clearfix">
                            <div class="imgItem fl"><img src="@/../static/img/51.png" alt=""></div>
                            <div class="itemInfo fr">
                                <span class="color1">郭龙华/总经理</span>
                                <p class="color3 if1">苏州万隆永鼎会计师事务所有限公司</p>
                                <p class="color3">合伙人</p>
                            </div>
                        </div>
                        <ul class="lef2 fr clearfix">
                            <li class="clearfix">
                                <div class="imgItem fl"><img src="@/../static/img/图层 47.png" alt=""></div>
                                <div class="itemInfo fr">
                                    <span class="color1">郭龙华/总经理</span>
                                    <p class="color3 if1">苏州万隆永鼎会计师事务所有限公司</p>
                                    <p class="color3">合伙人</p>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="imgItem fl"><img src="@/../static/img/图层 46.png" alt=""></div>
                                <div class="itemInfo fr">
                                    <span class="color1">郭龙华/总经理</span>
                                    <p class="color3 if1">苏州万隆永鼎会计师事务所有限公司</p>
                                    <p class="color3">合伙人</p>
                                </div>
                            </li>
                            <li class="clearfix">
                                <div class="imgItem fl"><img src="@/../static/img/49.png" alt=""></div>
                                <div class="itemInfo fr">
                                    <span class="color1">郭龙华/总经理</span>
                                    <p class="color3 if1">苏州万隆永鼎会计师事务所有限公司</p>
                                    <p class="color3">合伙人</p>
                                </div>
                            </li>
                            <li class="clearfix lastLi">
                                <div class="liImg">
                                    <img src="@/../static/img/xiao.png" alt="">
                                </div>
                                <div class="liBtn">
                                    MORE
                                    <img src="@/../static/img/xiala1.png" alt="">
                                </div>
                            </li>
                        </ul>
                    </div> -->
                    <div id="conselor_info">
                        <ul>
                            <li class="conselor_left">
                                <div v-for="(item,index) in 2" :key="index">
                                <a href="javascript:;">
                                    <div class="info_img"><img src="@/assets/image/test2.png" alt=""></div>
                                    <div class="info_all">
                                    <div class="info_name"><span>郭龙华</span>/<span>总经理</span></div>
                                    <div class="info_detail">
                                        <p>苏州万隆永鼎会计师事务所有限公司</p>
                                        <p>合伙人</p>
                                    </div>
                                    </div>
                                </a>
                                </div>
                            </li>
                            <li class="conselor_mid">
                                <div v-for="(counselorinfoItem2,counselorinfoindex2) in 8" :key="counselorinfoindex2" class="conselor_mid_list">
                                <a href="javascript:;">
                                    <div class="info_img"><img src="@/assets/image/test2.png" alt=""></div>
                                    <div class="info_all">
                                    <div class="info_name"><span>郭龙华</span>/<span>总经理</span></div>
                                    <div class="info_detail">
                                        <p>苏州万隆永鼎会计师事务所有限公司</p>
                                        <p>合伙人</p>
                                    </div>
                                    </div>
                                </a>
                                </div>
                                
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="humanResources">
            <div class="tit pr">人力资源
            </div>
            <div class="eng">THE&nbsp;HUMAN&nbsp;RESOURCES</div>
            <div class="line"></div>
            <div class="humanResInfo w">
                <el-card>
                    <div class="infoTit clearfix">
                        <div class="btn fl">
                            <button class="btn1">企业招聘</button>
                            <button class="btn2">服务</button>
                        </div>
                        <div class="chage fr color3 pointer">
                            <img src="@/../static/img/huanyipi.png" alt=""> 换一批
                        </div>
                    </div>
                    <ul class="infoCon">
                        <li class="clearfix">
                            <div class="con1 fl mainBorder">
                                <img src="@/../static/img/图层 54.png" alt="">
                            </div>
                            <div class="con2 fl">
                                <p class="color4">招聘岗位：人力专员</p>
                                <p>招聘企业： 苏宁易购</p>
                                <p>招聘人数: 3人</p>
                                <p>薪资待遇：
                                    <span class="mainColor">面议</span>
                                </p>
                                <p>发布时间: 2018-10-17 14:02:58</p>
                            </div>
                            <div class="con3 fr">
                                <button class="btn1">在线联系</button>
                                <button class="btn2">了解详情</button>
                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="con1 fl mainBorder">
                                <img src="@/../static/img/图层 54.png" alt="">
                            </div>
                            <div class="con2 fl">
                                <p class="color4">招聘岗位：人力专员</p>
                                <p>招聘企业： 苏宁易购</p>
                                <p>招聘人数: 3人</p>
                                <p>薪资待遇：
                                    <span class="mainColor">面议</span>
                                </p>
                                <p>发布时间: 2018-10-17 14:02:58</p>
                            </div>
                            <div class="con3 fr">
                                <button class="btn1">在线联系</button>
                                <button class="btn2">了解详情</button>
                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="con1 fl mainBorder">
                                <img src="@/../static/img/图层 54.png" alt="">
                            </div>
                            <div class="con2 fl">
                                <p class="color4">招聘岗位：人力专员</p>
                                <p>招聘企业： 苏宁易购</p>
                                <p>招聘人数: 3人</p>
                                <p>薪资待遇：
                                    <span class="mainColor">面议</span>
                                </p>
                                <p>发布时间: 2018-10-17 14:02:58</p>
                            </div>
                            <div class="con3 fr">
                                <button class="btn1">在线联系</button>
                                <button class="btn2">了解详情</button>
                            </div>
                        </li>
                    </ul>
                </el-card>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      sousuo: false
    };
  },
  mounted() {
    this.$router.afterEach((to, from, next) => {
      window.scrollTo(0, 0);
    });
  },
  methods: {
    onchange() {
      console.log(0);
    },
    aa() {
      console.log(111);
    },
    handleChange() {
      this.sousuo = true;
    }
  }
};
</script>
<style lang="scss">
.enterpriseservice {
  #header #posA {
    > .firstLi {
      // background: rgba(255, 255, 255, 0.2);
      background: inherit;
      color: #fff;
      border-radius: none;
    }
    > .firstLi:hover {
      background: #fff;
      color: #00a041;
      border-radius: 5px;
    }
    .lastLi {
      background: #fff;
      color: #00a041;
      border-radius: 5px;
    }
  }
  .portalIndexImg {
    //   height: 650px;
    .porImg {
      width: 100%;
      height: 100%;
      height: 650px;
    }
    // .el-carousel__item:nth-child(2n) {
    //   background: url("../../static/img/qiye.png") 100% 100% / 100% 100%
    //     no-repeat;
    // }

    // .el-carousel__item:nth-child(2n + 1) {
    //   background: url("../../static/img/qiye.png") 100% 100% / 100% 100%
    //     no-repeat;
    // }
    .el-carousel__indicators {
      display: none;
    }
  }
  .declarationNotice {
    #li2,
    #li4 {
      height: 64px;
    }
  }
  .policyCenter {
    .paging {
      .el-carousel {
        padding: 50px 0;
      }
      .page1 {
        width: 800px;
        margin: 0 auto;
        > li {
          float: left;
          width: 340px;
          padding: 20px;
          border: 1px solid #d1d1d1;
          margin-right: 30px;
          margin-bottom: 30px;
          .left1 {
            width: 36px;
            height: 36px;
            color: #fff;
            line-height: 36px;
            margin-right: 20px;
            display: inline-block;
            vertical-align: middle;
            background: url("../../static/img/tuoyuan4.png") 100% 100% / 100%
              100% no-repeat;
          }
          .right1 {
            font-size: 12px;
            display: inline-block;
            vertical-align: middle;
            width: 278px;
            text-align: left;
            .rightTit {
              font-size: 14px;
            }
            > p {
              margin-top: 20px;
              margin-bottom: 10px;
            }
            .liBom {
              > span {
                margin-left: 20px;
              }
            }
          }
        }
        > li:nth-child(2n) {
          margin-right: 0;
        }
      }
      > .page2 {
        width: 60px;
        margin: 0 auto;
        margin-top: 60px;
        li {
          float: left;
          width: 10px;
          height: 10px;
          border-radius: 50%;
          background-color: #e1e1e1;
          margin-right: 10px;
        }
        li:nth-child(2) {
          background: #00a041;
        }
      }
      .arrow {
        width: 17px;
        height: 31px;
        .arrow1 {
          width: 17px;
          height: 31px;
          position: absolute;
          left: 130px;
          top: 178px;
          background: url("../../static/img/zuo2.png") 100% 100% / 100% 100%
            no-repeat;
        }
        .arrow2 {
          width: 17px;
          height: 31px;
          position: absolute;
          right: 130px;
          top: 178px;
          background: url("../../static/img/you2.png") 100% 100% / 100% 100%
            no-repeat;
        }
      }
      .el-carousel__arrow {
        background: none;
        color: #eee;
        font-size: 35px;
      }
      .el-carousel__arrow--left {
        left: 130px;
      }
      .el-carousel__arrow--right {
        right: 130px;
      }
      .el-carousel__button {
        width: 9px;
        height: 9px;
        background: #e1e1e1;
        border-radius: 50%;
      }
      .el-carousel__indicator.is-active .el-carousel__button {
        background: #00a041;
      }
    }
  }
  .approval {
    height: 461px;
    background: url("../../static/img/tuceng4.png") 100% 100% / 100% 100%
      no-repeat;
    .approvalInfo {
      color: #fff;
      padding-top: 120px;
      padding-left: 200px;
      .approTit {
        font-size: 26px;
      }
      .approEng {
        font-size: 43px;
      }
      .line {
        width: 33px;
        height: 1px;
        background: #fff;
        // margin: 0 auto;
        margin-top: 5px;
        margin-bottom: 20px;
      }
      .approDel {
        font-size: 12px;
        margin-top: 40px;
        > img {
          width: 5px;
          height: 9px;
        }
      }
    }
  }
  .technologyFinance {
    #btns {
      margin: 50px 0;
      > button:hover {
        color: #fff;
        background: #00a041;
      }
      .btn11 {
        border-radius: 0;
      }
    }
    .tecnInfo {
      .info1 {
        padding: 0 120px;
        margin-bottom: 10px;
        .lef1 {
          border: 1px solid #dedede;
          padding: 20px;
          width: 320px;
          text-align: left;
          //   display: inline-block;
          margin-right: 10px;
          > .imgItem {
            width: 117px;
            height: 117px;
            //   display: inline-block;
            //   vertical-align: middle;
            > img {
              width: 100%;
              height: 100%;
            }
          }
          > .itemInfo {
            //   display: inline-block;
            font-size: 12px;
            > span {
              font-size: 14px;
            }
            .if1 {
              margin-top: 20px;
              margin-bottom: 5px;
            }
          }
        }
        .lef2 {
          //  display: inline-block;
          width: 577px;
          > li {
            float: left;
            height: 53px;
            padding: 10px;
            width: 260px;
            border: 1px solid #dedede;
            text-align: left;
            margin-bottom: 10px;
            margin-right: 10px;
            > .imgItem {
              width: 58px;
              height: 58px;
              > img {
                width: 100%;
                height: 100%;
              }
            }
            > .itemInfo {
              font-size: 12px;
              > span {
                font-size: 14px;
              }
              .if1 {
                // margin-top: 8px;
                // margin-bottom: 5px;
              }
            }
          }
          > li:nth-child(2n) {
            margin-right: 0;
          }
          > .lastLi {
            border: none;
            .liImg {
              width: 100px;
              height: 44px;
              display: inline-block;
              vertical-align: middle;
              margin: 0 10px;
              > img {
                width: 100%;
                height: 100%;
              }
            }
            .liBtn {
              display: inline-block;
              vertical-align: middle;
              width: 65px;
              text-align: center;
              padding: 5px 10px;
              color: #00a041;
              border: 1px solid #00a041;
              border-radius: 5px;
              font-size: 12px;
              > img {
                width: 5px;
                height: 9px;
              }
            }
          }
        }
      }
    }
  }
  .humanResources {
    height: 337px;
    color: #fff;
    margin-bottom: 550px;
    background: url("../../static/img/tuceng5.png") 100% 100% / 100% 100%
      no-repeat;
    .line {
      background: #fff;
    }
    .humanResInfo {
      margin-top: 50px;
      .el-card {
        width: 80%;
        margin: 0 auto;
      }
      .el-card__body {
        padding: 20px 30px;
        padding-bottom: 50px;
      }
      .infoTit {
        .btn {
          font-size: 0;
          > button {
            padding: 5px 20px;
            background: #fff;
            border: none;
            border: 1px solid #c2c2c2;
            color: #999;
            outline: none;
            width: 97px;
          }
          >button:hover{
              color: #fff;
            background: #00a041;
          }
          .btn1 {
            color: #fff;
            background: #00a041;
            border-top-left-radius: 3px;
            border-bottom-left-radius: 3px;
          }
          .btn2 {
            border-top-right-radius: 3px;
            border-bottom-right-radius: 3px;
            border-left: none;
          }
        }
        .chage {
          font-size: 12px;
          margin-top: 10px;
          > img {
            width: 16px;
            height: 13px;
            display: inline-block;
            vertical-align: middle;
          }
        }
      }
      .infoCon {
        > li {
          padding: 30px 0;
          border-bottom: 1px solid #eee;
          .con1 {
            padding: 20px 50px;
            > img {
              width: 83px;
              height: 90px;
            }
          }
          .con2 {
            text-align: left;
            font-size: 13px;
            color: #999;
            margin-left: 30px;
            > p {
              line-height: 25px;
            }
            > p:first-child {
              margin-bottom: 10px;
              font-size: 14px;
            }
          }
          .con3 {
            font-size: 12px;
            margin-top: 40px;
            .btn1 {
              color: #fff;
              background: #00a041;
              outline: none;
              border: none;
              padding: 6px 15px;
              border-radius: 5px;
              margin-right: 20px;
            }
            .btn2 {
              color: #00a041;
              background: #ecfcf2;
              outline: none;
              border: 1px solid #41d787;
              padding: 5px 15px;
              border-radius: 5px;
            }
          }
        }
        > li:last-child {
          border: none;
        }
      }
    }
  }
  #conselor_info{
    ul{
        display: flex;
        .conselor_left{
        width: 36%;
        a{
            border: 1px solid #dedede;
            display: flex;
                margin-top: 20px;
            .info_img{
            width:46%;
            img{
                width: 80%;
                border-radius: 50%;
                display: block;
                margin: 20px auto;
            }
            }
            .info_all{
            margin: auto 0;
            .info_name{
                padding-bottom: 18px;
            }
            .info_detail{
                font-size: 12px;
                color: #999;
            }
            }
        }
        }
        .conselor_mid{
        width: 63%;
        .conselor_mid_list{
            float: left;
            width: 50%;
        }
        a{
            border: 1px solid #dedede;
            display: flex;
            margin-top: 20px;
            margin-left: 20px;
            .info_img{
            width: 27%;
            img{
                width: 79%;
                border-radius: 50%;
                display: block;
                margin: 6px auto;
            }
            }
            .info_all{
            margin: auto 10px;
            .info_name{
                padding-bottom: 18px;
            }
            .info_detail{
                font-size: 12px;
                color: #999;
            }
            }
        }
        }
    }
    }
}
</style>


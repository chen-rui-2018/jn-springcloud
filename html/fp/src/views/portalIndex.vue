<template>
  <div class="portalIndex">
    <div class="portalIndexImg">
      <div id="header">
        <div class="headerContainer clearfix">
          <div class="titleImg fl"><img src="@/../static/img/LOGO1.png" alt=""></div>
          <!-- <div class="menu" style="display:none">
            <i class="el-icon-close"></i>
            <input type="text">
            <i class="el-icon-search"></i>
          </div> -->
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
              <ul class="posA clearfix" v-else>
                <li>
                  <a href="javascript:void(0);">首页</a>
                </li>
                <li>
                  <a href="javascript:void(0);">招商引资</a>
                </li>
                <li>
                  <a href="javascript:void(0);">智慧党建</a>
                </li>
                <li @click="$router.push({path:'/enterpriseservice'})">
                  <a href="javascript:void(0);">企业服务</a>
                </li>
              </ul>

            </transition>
          </div>
        </div>
      </div>
      <el-carousel :interval="5000" arrow="always">
        <el-carousel-item v-for="item in 4" :key="item">
          <!-- <h3>{{ item }}</h3> -->
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
    <div class="parkNotice w clearfix">
      <div class="fl"><img src="@/../static/img/园区公告.png" alt=""></div>
      <span>热烈庆祝XXX公司入驻南京白下高新区XXX园区。为实现共创共收打造良好环境基础实现科技人才的引进与推动时代化做出...</span>
      <div class="fr">更多&nbsp;&nbsp;
        <i class="iconfont icon-you"></i>
      </div>
    </div>
    <div class="declarationNotice pr">
      <div class="w">
        <div class="tuoyuan">
          <i class="el-icon-arrow-down"></i>
        </div>
        <div class="tit color2 pr">申报公告
          <div class="titImg" @click="onClick">
            <img src="@/../static/img/huidaodingbu.png" alt="">
          </div>
        </div>
        <div class="eng mainColor">Declare&nbsp;the&nbsp;announcement</div>
        <div class="line"></div>
        <div class="btns">
          <button class="btn1">政府扶持</button>
          <button class="btn2">了解详情</button>
        </div>
        <div class="info clearfix">
          <div class="left fl">
            <div class="lf">
              <ul>
                <li class="li1">01</li>
                <li class="li2"></li>
                <li class="li3">02</li>
                <li class="li4"></li>
                <li class="li5">03</li>
              </ul>
            </div>
            <div class="rt">
              <ul>
                <li class="t1 color1">关于高新技术企业认定的申报及专项投资申报
                  <p>提供高企政策相关的： 财务需求打磨、资质及人员规划、知识产权规划、搭建专业研发制度、成果转化协助、挖掘提升高新产品价值等全方位辅导；提供高企相关的6大政策支持讲解；提供高企7个基本硬性条件解读；提供全套高企认定材料准备和制作服务，提供全套高企认定材料准备和制作服务。</p>
                </li>
                <li class="t1 color1">申报高新技术产品认定,是国家高新技术企业认定的加分项。
                </li>
                <li class="t1 color1">南京市人民政府关于高新区企业资质荣誉申请...
                </li>
              </ul>
            </div>
          </div>
          <div class="right fl"></div>

        </div>
      </div>
      <div class="pagination-container">
        <el-pagination background layout="prev, pager, next" :total="30">
        </el-pagination>
      </div>
    </div>
    <div class="policyGuide">
      <div class="tit">政策指南</div>
      <div class="eng">Policy&nbsp;guidelines</div>
      <div class="line"></div>
      <div class="fenye w pr">
        <el-carousel :interval="5000" arrow="always">
          <el-carousel-item v-for="item in 3" :key="item">
            <!-- <h3>{{ item }}</h3> -->
            <ul class="qiehuan1" id="qiehuan1">
              <li>
                <p class="liTit">白下高新区金融扶持政策</p>
                <p class="liInfo">
                  中央政府发布国发5号文，进一步 扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....
                </p>
                <div class="liBom clearfix">
                  <p class="fl">
                    <i class="el-icon-view"></i>&nbsp;89</p>
                  <span class="fr">南京市级</span>
                  <i class="fr">财政引导</i>
                </div>
              </li>
              <li>
                <p class="liTit">白下高新区金融扶持政策</p>
                <p class="liInfo">
                  中央政府发布国发5号文，进一步 扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....
                </p>
                <div class="liBom clearfix">
                  <p class="fl">
                    <i class="el-icon-view"></i>&nbsp;89</p>
                  <span class="fr">南京市级</span>
                  <i class="fr">财政引导</i>
                </div>
              </li>
              <li>
                <p class="liTit">白下高新区金融扶持政策</p>
                <p class="liInfo">
                  中央政府发布国发5号文，进一步 扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....
                </p>
                <div class="liBom clearfix">
                  <p class="fl">
                    <i class="el-icon-view"></i>&nbsp;89</p>
                  <span class="fr">南京市级</span>
                  <i class="fr">财政引导</i>
                </div>
              </li>
              <li>
                <p class="liTit">白下高新区金融扶持政策</p>
                <p class="liInfo">
                  中央政府发布国发5号文，进一步 扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....
                </p>
                <div class="liBom clearfix">
                  <p class="fl">
                    <i class="el-icon-view"></i>&nbsp;89</p>
                  <span class="fr">南京市级</span>
                  <i class="fr">财政引导</i>
                </div>
              </li>
            </ul>
          </el-carousel-item>
        </el-carousel>
        <!-- <ul class="qiehuan1">
          <li>
            <p class="liTit">白下高新区金融扶持政策</p>
            <p class="liInfo">
              中央政府发布国发5号文，进一步 扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....
            </p>
            <div class="liBom clearfix">
              <p class="fl"><i class="el-icon-view"></i>&nbsp;89</p>
              <span class="fr">南京市级</span>
              <i class="fr">财政引导</i>
            </div>
          </li>
          <li>
            <p class="liTit">白下高新区金融扶持政策</p>
            <p class="liInfo">
              中央政府发布国发5号文，进一步 扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....
            </p>
            <div class="liBom clearfix">
              <p class="fl"><i class="el-icon-view"></i>&nbsp;89</p>
              <span class="fr">南京市级</span>
              <i class="fr">财政引导</i>
            </div>
          </li>
          <li>
            <p class="liTit">白下高新区金融扶持政策</p>
            <p class="liInfo">
              中央政府发布国发5号文，进一步 扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....
            </p>
            <div class="liBom clearfix">
              <p class="fl"><i class="el-icon-view"></i>&nbsp;89</p>
              <span class="fr">南京市级</span>
              <i class="fr">财政引导</i>
            </div>
          </li>
          <li>
            <p class="liTit">白下高新区金融扶持政策</p>
            <p class="liInfo">
              中央政府发布国发5号文，进一步 扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政府特发....
            </p>
            <div class="liBom clearfix">
              <p class="fl"><i class="el-icon-view"></i>&nbsp;89</p>
              <span class="fr">南京市级</span>
              <i class="fr">财政引导</i>
            </div>
          </li>
        </ul> -->
        <!-- <ul class="qiehuan2 clearfix">
          <li></li>
          <li></li>
          <li></li>
        </ul> -->
        <!-- <div class="arrow">
          <div class="arrow1"></div>
          <div class="arrow2"></div>
        </div> -->
      </div>
    </div>
    <div class="popularActi w">
      <div class="tit color2">热门活动</div>
      <div class="eng mainColor">Popular&nbsp;activities</div>
      <div class="line"></div>
      <div class="acti">
        <el-carousel :interval="5000" arrow="always" :autoplay="false">
          <el-carousel-item v-for="item in 4" :key="item">
            <ul class="actiUl clearfix">
              <li>
                <div class="postImgItem">
                  <img src="@/../static/img/heng1.png" class="postImg" alt="活动海报图片">
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
                    <!-- <i class="iconfont icon-xihuan"></i>16 -->
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
                    <!-- <i class="iconfont icon-xihuan"></i>16 -->
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
    <div class="districtGardens w">
      <div class="tit color2">一区多园</div>
      <div class="eng mainColor">Area&nbsp;more&nbsp;garden</div>
      <div class="line"></div>
      <div class="card pr">
        <el-carousel  arrow="always">
          <el-carousel-item v-for="item in 4" :key="item">
        <!-- <el-carousel-item v-for="item in 3" :key="item"> -->
        <ul class="cardUl">
          <li>
            <el-card>
              <img src="@/../static/img/图层 50.png" alt="">
              <p class="mainColor">白下高新A园</p>
              <div>Baixia high-tech zone A</div>
            </el-card>
          </li>
          <li>
            <el-card>
              <img src="@/../static/img/图层 49.png" alt="">
              <p class="mainColor">白下高新A园</p>
              <div>Baixia high-tech zone A</div>
            </el-card>
          </li>
          <li>
            <el-card>
              <img src="@/../static/img/图层 51.png" alt="">
              <p class="mainColor">白下高新A园</p>
              <div>Baixia high-tech zone A</div>
            </el-card>
          </li>
        </ul>
         </el-carousel-item>
        </el-carousel>
        <!-- </el-carousel-item> -->
        <!-- <div class="arrow">
          <div class="arrow1"></div>
          <div class="arrow2"></div>
        </div> -->
      </div>
    </div>
    <div class="enterpriseinfo w">
      <div class="tit color2">企业资讯</div>
      <div class="eng mainColor">Enterprise&nbsp;information</div>
      <div class="line"></div>
      <div class="enterPriseCon">
        <div class="con1">
          <img src="@/../static/img/图层 5.png" alt="">
          <div class="conTit1 color1">龙虎网"黑科技"亮相融交南京市第六届金梧桐激奖颁奖典礼</div>
          <div class="conInfo">
            <img src="@/../static/img/图层 4.png" alt="">
            <span>2019-7-2 10:23</span>
          </div>
          <p class="color3">
            龙虎网讯（记者 陶禹歌）“刷”一下脸就能打印参观证，手机上也能看“ 大片范”龙虎网讯（记者 陶禹歌）“刷”一下脸就能打印参观证，手机上 也能看“大片范”的现场直播在今龙虎网讯（记者 陶禹歌）“刷”一下脸 就能打印参观证，手机上也能看“大片范”的现场直播在今…
          </p>
          <div class="more">
            MORE
          </div>
        </div>
        <div class="con2">
          <div class="conT1">
            <div class="conlef1">
              <img src="@/../static/img/图层 5.png" alt="">
              <div class="conTit1 color1">
                互联网创业的利与弊
              </div>
              <div class="conInfo">
                <img src="@/../static/img/图层 9.png" alt="">
                <span>2019-7-2 10:23</span>
              </div>
              <p class="color3"> 互联网讯（记者 陶禹歌）“刷”一下脸 就能打印参观证，手机上也能看“大片 范”龙虎网讯（记者 陶…</p>
              <div class="more">
                MORE
              </div>
            </div>
            <div class="conlef1 conlef2">
              <img src="@/../static/img/图层 5.png" alt="">
              <div class="conTit1 color1">
                互联网创业的利与弊
              </div>
              <div class="conInfo">
                <img src="@/../static/img/图层 9.png" alt="">
                <span>2019-7-2 10:23</span>
              </div>
              <p class="color3"> 互联网讯（记者 陶禹歌）“刷”一下脸 就能打印参观证，手机上也能看“大片 范”龙虎网讯（记者 陶…</p>
              <div class="more">
                MORE
              </div>
            </div>
          </div>
          <div class="conT2">
            <div class="contop1 clearfix">
              <div class="fl">
                <i></i>
                <span class="color1">IOS开发如何轻松搞定导航栏</span>
                <p>
                  <img src="@/../static/img/图层 4.png" alt="">
                  <span>2019-7-2 10:23</span>
                </p>
              </div>
              <p class="fr mainColor">MORE</p>
            </div>
            <div class="contop1 contop2 clearfix">
              <div class="fl">
                <i></i>
                <span class="color1">IOS开发如何轻松搞定导航栏</span>
                <p>
                  <img src="@/../static/img/图层 4.png" alt="">
                  <span>2019-7-2 10:23</span>
                </p>
              </div>
              <p class="fr mainColor">MORE</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="enterprisesPark">
      <div class="tit" style="margin-top:20px">园内企业</div>
      <div class="eng">The&nbsp;park&nbsp;enterprises</div>
      <div class="line"></div>
      <div class="enterPark w">
        <ul>
          <li class="active">
            <img src="@/../static/img/云计算.png" alt="">
            <p>云计算</p>
          </li>
          <li>
            <img src="@/../static/img/智能公交.png" alt="">
            <p>智能公交</p>
          </li>
          <li>
            <img src="@/../static/img/文化创意.png" alt="">
            <p>文化创意</p>
          </li>
          <li>
            <img src="@/../static/img/军民融合.png" alt="">
            <p>军民融合</p>
          </li>
          <li>
            <img src="@/../static/img/电子商务.png" alt="">
            <p>电子商务</p>
          </li>
          <li>
            <img src="@/../static/img/工业设计.png" alt="">
            <p>工业设计</p>
          </li>
          <li>
            <img src="@/../static/img/现代服务业.png" alt="">
            <p>现代服务业</p>
          </li>
          <li>
            <img src="@/../static/img/互联网.png" alt="">
            <p>互联网</p>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      sousuo: false,
    };
  },
  mounted() {
    window.addEventListener("scroll", this.handleScroll, true);
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
  },
  methods: {
    onClick(){
      document.body.scrollTop = document.documentElement.scrollTop = 0;
    },
    handleScroll() {
      // console.log(this.getScrollTop())HAOhao
      if (
        this.getScrollTop() > document.getElementById("header").clientHeight
      ) {
        this.headFlag = true;
      } else {
        this.headFlag = false;
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
    handleChange() {
      this.sousuo = true;
    }
  }
};
</script>
<style lang="scss">
.portalIndex {
  .portalIndexImg {
    .el-carousel__item:nth-child(2n) {
      background: url("../../static/img/c11.png") 100% 100% / 100% 100%
        no-repeat;
    }

    .el-carousel__item:nth-child(2n + 1) {
      background: url("../../static/img/c11.png") 100% 100% / 100% 100%
        no-repeat;
    }
  }
  #qiehuan1 {
    margin-top: 20px;
    > li {
      display: inline-block;
      width: 190px;
      height: 210px;
      padding: 30px 10px;
      font-size: 12px;
      text-align: left;
      margin-right: 15px;
      vertical-align: middle;
      background-color: rgba(255, 255, 255, 0.2);
      .liTit {
        font-size: 14px;
        text-align: center;
      }
      .liInfo {
        margin: 40px 0 50px 0;
      }
      .liBom {
        padding: 0 15px;
        > i {
          margin-right: 8px;
        }
      }
    }
    >li:hover{
      transition: 0.3s all;
      transform: scale(1.1);
    }
  }
  .policyGuide {
    .el-carousel__button {
      width: 9px;
      height: 9px;
      border-radius: 50%;
    }
    .el-carousel__arrow {
      background: none;
      font-size: 30px;
      top: 40%;
    }
    .el-carousel__arrow--left {
      left: 64px;
    }
    .el-carousel__arrow--right {
      right: 64px;
    }
  }
}
</style>


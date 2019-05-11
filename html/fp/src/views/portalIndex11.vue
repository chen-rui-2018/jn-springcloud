<template>
  <div class="portalIndex">
    <div class="portalIndexImg">
      <div  class="header" id="header" :class="{'headerw':showFF}">
        <div class="headerContainer clearfix">
          <div class="titleImg fl">
            <img src="@/../static/img/LOGO1.png" v-if="!showFF" class="pointer" alt="" @click="$router.push({path:'/'})">
            <img src="@/../static/img/login-logo.png" v-else class="pointer" alt="" @click="$router.push({path:'/'})">
            </div>
          <!-- <div class="menu" style="display:none">
            <i class="el-icon-close"></i>
            <input type="text">
            <i class="el-icon-search"></i>
          </div> -->
          <div class="headerRight fr">
            <div class="search pointer">
              <i class="el-icon-search" @click="show4=true" style="font-size:20px"></i>
            </div>
            <div class="navlogin">
              <a @click="$router.push({path:'/login'})">登录</a>
              <span class="line">|</span>
              <a @click="$router.push({path:'/register'})">注册</a>
            </div>
          </div>
          <div class="nav" id="nav">
            <!-- <transition name="fade"> -->
            <!-- <div class="sousuo posA" v-if="sousuo">
                <i class="el-icon-close" style="vertical-align: middle;" @click="sousuo=false"></i>
                <input type="text" v-focus @keyup.enter="handleSearch">
                <i class="el-icon-search" style="vertical-align: middle;" @click="sousuo=false"></i>
              </div> -->
            <ul class="posA clearfix">
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

            <!-- </transition> -->
          </div>
        </div>
      </div>
      <div class="search_box" id="search_box" :class="{'searchbox':showFF}">
        <el-collapse-transition>
          <div v-show="show4">
            <div class="transition-box">
              <el-input placeholder="请输入内容" v-model="searchData" class="input-with-select">
                <el-button slot="append" icon="el-icon-search">搜索 </el-button>
              </el-input>
            </div>
          </div>
        </el-collapse-transition>
      </div>
      <!-- <el-carousel :interval="5000" arrow="always">
        <el-carousel-item v-for="item in 4" :key="item">
        </el-carousel-item>
      </el-carousel> -->

    </div>
    <div class="portalCon">
      <div class="banner pr">
        <div class="swiper-container">
          <div class="swiper-wrapper">
            <div class="swiper-slide">
              <img src="@/../static/img/c11.png" alt="">
            </div>
            <div class="swiper-slide">
              <img src="@/../static/img/c11.png" alt="">
            </div>
            <div class="swiper-slide">
              <img src="@/../static/img/c11.png" alt="">
            </div>
          </div>
          <!-- 如果需要分页器 -->
          <div class="swiper-pagination"></div>

          <!-- 如果需要导航按钮 -->
          <div class="swiper-button-prev">
            <i class="iconfont icon-leftarrow pointer"></i>
          </div>
          <div class="swiper-button-next">
            <i class="iconfont icon-rightarrow pointer"></i>
          </div>

          <!-- 如果需要滚动条 -->
          <!-- <div class="swiper-scrollbar"></div> -->
        </div>
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
        <div class="fr pointer">更多&nbsp;&nbsp;
          <i class="iconfont icon-you"></i>
        </div>
      </div>
      <div class="declarationNotice portalNotice animation-dom pr" data-class="bottom">
        <div class="w">
          <div class="tuoyuan">
            <i class="el-icon-arrow-down"></i>
          </div>
          <div class="animation-dom" data-class="bottom">
            <div class="tit color2 pr">申报公告
              <div class="titImg" @click="onClick">
                <img src="@/../static/img/huidaodingbu.png" alt="">
              </div>
            </div>
            <div class="eng mainColor">Declare&nbsp;the&nbsp;announcement</div>
            <div class="line"></div>
          </div>
          <div class="animation-dom" id="pn2" data-class="bottom1">
            <div class="btns">
              <button class="btn1">政府扶持</button>
              <button class="btn2">了解详情</button>
            </div>
            <div class="info ">
              <div class="left pr">
                <!-- <div class="lf">
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
            </div> -->
                <!-- <div class="leftLine"></div> -->
                <el-collapse accordion v-model="activeNames">
                  <el-collapse-item name="1">
                    <template slot="title">
                      <div class="li1">01</div>关于高新技术企业认定的申报及专项投资申报
                    </template>
                    <div>提供高企政策相关的： 财务需求打磨、资质及人员规划、知识产权规划、搭建专业研发制度、成果转化协助、挖掘提升高新产品价值等全方位辅导；提供高企相关的6大政策支持讲解；提供高企7个基本硬性条件解读；提供全套高企认定材料准备和制作服务，提供全套高企认定材料准备和制作服务。</div>
                  </el-collapse-item>
                  <el-collapse-item>
                    <template slot="title">
                      <div class="li3">02</div>申报高新技术产品认定,是国家高新技术企业认定的加分项。
                    </template>
                    <!-- <div>简化流程：设计简洁直观的操作流程；</div> -->
                    <!-- <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
                    <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div> -->
                  </el-collapse-item>
                  <el-collapse-item>
                    <template slot="title">
                      <div class="li5">03</div>南京市人民政府关于高新区企业资质荣誉申请...
                    </template>
                    <div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
                    <div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
                  </el-collapse-item>
                </el-collapse>
              </div>
              <div class="right"></div>

            </div>
            <div class="pagination-container">
              <el-pagination background layout="prev, pager, next" :total="30">
              </el-pagination>
            </div>
          </div>
        </div>

      </div>
      <div class="policyGuide animation-dom" data-class="bottom1">
        <div  class="animation-dom" data-class="bottom1">
          <div class="tit">政策指南</div>
          <div class="eng">Policy&nbsp;guidelines</div>
          <div class="line"></div>
        </div>
        <div class="fenye fenye1 w pr animation-dom" data-class="bottom2">
          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div class="swiper-slide" style="width:100%" v-for="(i,k) in [1,1,1]" :key="k">
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
              </div>
            </div>
            <!-- 如果需要分页器 -->
            <div class="swiper-pagination"></div>

            <!-- 如果需要导航按钮 -->
            <div class="swiper-button-prev"></div>
            <div class="swiper-button-next"></div>
          </div>
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
      <div class="popularActi w animation-dom" data-class="bottom2">
        <div class="animation-dom" data-class="bottom">
          <div class="tit color2">热门活动</div>
        <div class="eng mainColor">Popular&nbsp;activities</div>
        <div class="line"></div>
        </div>
        <div class="acti animation-dom" data-class="bottom1">
          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div class="swiper-slide" style="width:100%">
                <ul class="actiUl clearfix">
                  <li>
                    <!-- <transition name="el-fade-in"> -->
                    <div class="postImgItem" v-if="show1" @mouseenter.stop="show1=!show1" :class="{'poIm':!show1}">
                      <img src="@/../static/img/heng1.png" class="postImg" alt="活动海报图片">
                    </div>
                    <div class=" postImgItem2" v-else @mouseleave.stop="show1=!show1" :class="{'poIm1':!show1}">
                      <img src="@/../static/img/dengpao2.png" class="postImg1" alt="活动海报图片">
                    </div>
                    <!-- </transition> -->
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
                    <div class="postImgItem" v-if="show2" @mouseenter.stop="show2=!show2">
                      <img src="@/../static/img/heng1.png" class="postImg" alt="活动海报图片">
                    </div>
                    <div class=" postImgItem2" v-else @mouseleave.stop="show2=!show2">
                      <img src="@/../static/img/dengpao2.png" class="postImg1" alt="活动海报图片">
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
                    <div class="postImgItem" v-if="show3" @mouseenter.stop="show3=!show3">
                      <img src="@/../static/img/heng3.png" class="postImg" alt="活动海报图片">
                    </div>
                    <div class=" postImgItem2" v-else @mouseleave.stop="show3=!show3">
                      <img src="@/../static/img/dengpao2.png" class="postImg1" alt="活动海报图片">
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
              </div>
            </div>
            <!-- 如果需要分页器 -->
            <!-- <div class="swiper-pagination"></div> -->

            <!-- 如果需要导航按钮 -->
            <div class="swiper-button-prev">
              <i class="iconfont icon-leftarrow pointer"></i>
            </div>
            <div class="swiper-button-next">
              <i class="iconfont icon-rightarrow pointer"></i>
            </div>
          </div>

          <!-- <i class="iconfont icon-leftarrow pointer"></i>
        <i class="iconfont icon-rightarrow pointer"></i> -->
          <div class="lejieDel">了解详情</div>
        </div>
      </div>
      <div class="districtGardens w animation-dom"  data-class="bottom2">
        <div class="animation-dom" data-class="bottom">
          <div class="tit color2">一区多园</div>
          <div class="eng mainColor">Area&nbsp;more&nbsp;garden</div>
          <div class="line"></div>
        </div>
        <div class="card pr animation-dom" data-class="bottom1">
          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div class="swiper-slide" style="width:100%">
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
              </div>
            </div>
            <!-- 如果需要分页器 -->
            <!-- <div class="swiper-pagination"></div> -->

            <!-- 如果需要导航按钮 -->
            <div class="swiper-button-prev"></div>
            <div class="swiper-button-next"></div>
          </div>
          <!-- </el-carousel-item> -->
          <!-- <div class="arrow">
          <div class="arrow1"></div>
          <div class="arrow2"></div>
        </div> -->
        </div>
      </div>
      <div class="enterpriseinfo w animation-dom" data-class="bottom2">
        <div class="animation-dom" data-class="bottom">
          <div class="tit color2">企业资讯</div>
          <div class="eng mainColor">Enterprise&nbsp;information</div>
          <div class="line"></div>
        </div>
        <div class="enterPriseCon animation-dom" data-class="bottom1">
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
      <div class="enterprisesPark animation-dom" data-class="bottom2">
        <div class="animation-dom" data-class="bottom1">
          <div class="tit" style="margin-top:20px">园内企业</div>
          <div class="eng">The&nbsp;park&nbsp;enterprises</div>
          <div class="line"></div>
        </div>
        <div class="enterPark w animation-dom" data-class="bottom2">
          <ul class="animation-dom enterUl" data-class="bottom2">
            <li class="ainimation-dom" data-class="bottom3">
              <!-- <div> -->
              <img src="@/../static/img/云计算.png" alt="">
              <p>云计算</p>
              <!-- </div> -->
            </li>
            <li  class="ainimation-dom" data-class="bottom3">
              <img src="@/../static/img/智能公交.png" alt="">
              <p>智能交通</p>
            </li>
            <li class="ainimation-dom" data-class="bottom4">
              <img src="@/../static/img/文化创意.png" alt="">
              <p>文化创意</p>
            </li>
            <li class="ainimation-dom" data-class="bottom5">
              <img src="@/../static/img/军民融合.png" alt="">
              <p>军民融合</p>
            </li>
            <li class="ainimation-dom" data-class="bottom5">
              <img src="@/../static/img/电子商务.png" alt="">
              <p>电子商务</p>
            </li>
            <li class="ainimation-dom" data-class="bottom6">
              <img src="@/../static/img/工业设计.png" alt="">
              <p>工业设计</p>
            </li>
            <li class="ainimation-dom" data-class="bottom7">
              <img src="@/../static/img/现代服务业.png" alt="">
              <p>现代服务业</p>
            </li>
            <li class="ainimation-dom" data-class="bottom8">
              <img src="@/../static/img/互联网.png" alt="">
              <p>互联网</p>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import swiper from "swiper";
export default {
  data() {
    return {
      // sousuo: false,
      show1: true,
      show2: true,
      show3: true,
      show4: false,
      searchData: "",
      showFF:false,
      donmList: [],
      activeNames: ['1']
    };
  },
  mounted() {
    this.$router.afterEach((to, from, next) => {
      window.scrollTo(0, 0);
    });
    this.swiperinit();
    window.addEventListener("scroll", this.handleScroll, true);
    const arr = document.getElementsByClassName('animation-dom')
    for (const node of arr) {
      this.donmList.push({
        top: this.getElementLeft(node),
        node: node
      })
    };  
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
  },
  methods: {
    swiperinit() {
      var mySwiper = new swiper(".swiper-container", {
        direction: "horizontal", // 垂直切换选项
        loop: true, // 循环模式选项

        // 如果需要分页器
        pagination: {
          el: ".swiper-pagination",
          // bulletElement: "li"
        },
        // 如果需要前进后退按钮
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
        },

        // 如果需要滚动条
        scrollbar: {
          el: ".swiper-scrollbar"
        }
      });
    },
    onClick() {
      document.body.scrollTop = document.documentElement.scrollTop = 0;
    },
    getElementLeft(element) {
      var top = element.offsetTop;
      var curEle = element.offsetParent;

      while (curEle !== null) {
        top += curEle.offsetTop;
        curEle = curEle.offsetParent;
      }
      return top;
    },

    handleScroll() {
      const osTop =
        document.documentElement.scrollTop ||
        document.documentElement.scrollTop;
      
      for (const dom of this.donmList) {
        if (osTop + innerHeight + 300 >= dom.top + 100) {
          const name =dom.node.dataset.class;
          dom.node.classList.add(name);
        }
      }
      if (
        this.getScrollTop() > document.getElementById("header").clientHeight
      ) {
        this.showFF = true;
      } else {
        this.showFF = false;
      }
      if (
        this.getScrollTop() > document.getElementById("search_box").clientHeight
      ) {
        this.show4 = false;
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
    }
    // handleChange() {
    //   this.sousuo = true;
    // }
  }
};
</script>
<style lang="scss">
@keyframes qfyfadeInLeft {
  0% {
    opacity: 0;
    transform: translateY(0);
  }
  100% {
    opacity: 1;
    transform: translateY(10%);
  }
}

.portalIndex {
  #pn2,
  .portalNotice,
  .policyGuide,
  .popularActi,
  .districtGardens,
  .enterpriseinfo,
  .enterprisesPark {
    opacity: 0;
  }
  .enterPark {
    .enterUl{
      opacity: 0;
    }
  }
  .bottom {
    animation: fadeInUp 2s ease forwards;
  }
  .bottom1 {
    animation: fadeInUp 2s ease 0.5s forwards;
  }
  .bottom2 {
    animation: fadeInUp 2s ease 1s forwards;
  }
  .bottom3 {
    animation: fadeInUp 1s ease 1.5s forwards;
  }
  .bottom4 {
    animation: fadeInUp 1s ease 2s forwards;
  }
  .bottom5 {
    animation: fadeInUp 1s ease 2.5s forwards;
  }
  .bottom6 {
    animation: fadeInUp 1s ease 3s forwards;
  }
  .bottom7 {
    animation: fadeInUp 1s ease 3.5s forwards;
  }
  .bottom8 {
    animation: fadeInUp 1s ease 4s forwards;
  }
  // .left {
  //   animation: fadeInLeft 2s ease 1s forwards;
  // }
  // .right {
  //   animation: fadeInRight 2s ease 1s forwards;
  // }
  .portalIndexImg {
    position: fixed;
    z-index: 99999 !important;
    width: 100%;
    .headerw{
      background: #fff;
      box-shadow: 0 2px 12px 0px rgba(0, 0, 0, 0.3);
      // box-shadow:0 10px 10px -10px #ccc;
      color: #666;
      #nav,.headerRight{
        color: #666;
        li{
          a{
            color:#666;
          }
        }
        li:nth-child(1){
          background: none;
          border-radius: none;
          a{
            color:#00a041;
          }
        }
        li:hover{
          background: none;
          color: #00a041;
        }
      }
    }
    
  }
  .portalCon{
   .banner{
     .swiper-wrapper {
      .swiper-slide {
        width: 100%;
      }
      img {
        width: 100%;
        vertical-align: middle;
      }
    }
    .swiper-button-prev,
    .swiper-button-next {
      background: none;
      width: 34px;
      height: 34px;
      color: #fff;
      font-size: 60px;
      .icon-leftarrow,
      .icon-rightarrow {
        font-size: 34px;
      }
    }
    .swiper-button-prev {
      left: 60px;
    }
    .swiper-button-next {
      right: 60px;
    }
    .swiper-pagination {
      bottom: 36%;
      left: 92%;
      .swiper-pagination-bullet {
        display: block;
        margin-bottom: 10px;
      }
      .swiper-pagination-bullet-active {
        background: #fff;
        height: 65px;
        border-radius: 4px;
      }
    }
   }
  }
  #qiehuan1 {
    margin: 20px 0;
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
    > li:hover {
      transition: 0.3s all;
      transform: scale(1.1);
    }
  }
  .portalNotice {
    .left {
      text-align: left;
      .leftLine {
        position: absolute;
        width: 2px;
        height: 100%;
        background: #000;
      }
      .el-collapse,
      .el-collapse-item__header,
      .el-collapse-item__wrap {
        border: none;
      }
      .el-collapse-item__wrap {
        // text-indent: 3.5em;
      }
      .el-collapse-item__content{
        margin-left: 58px;
        color:#999;
      }
      .el-collapse-item__header{
        font-size: 15px;
      }
      .el-collapse-item__arrow {
        display: none;
      }
    }
  }
  .policyGuide {
    .swiper-container {
      padding-bottom: 60px;
    }
    .swiper-pagination-bullet {
      background: red;
    }
    .swiper-pagination-bullet-active {
      background: #fff;
    }
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
    .fenye1 {
      .swiper-button-prev,
      .swiper-button-next {
        width: 17px;
        height: 31px;
        top: 55%;
      }
      .swiper-button-prev,
      .swiper-container-rtl .swiper-button-next {
        background: url("../../static/img/zuo1.png") 100% 100% / 100% 100%
          no-repeat;
        left: 90px;
        right: auto;
      }
      .swiper-button-next,
      .swiper-container-rtl .swiper-button-prev {
        background: url("../../static/img/you1.png") 100% 100% / 100% 100%
          no-repeat;
        right: 100px;
        left: auto;
      }
    }
  }
  .popularActi {
    .swiper-button-prev,
    .swiper-button-next {
      width: 34px;
      height: 34px;
    }
  }

  .districtGardens {
    .card {
      .swiper-container {
        padding: 30px 0;
      }
    }
    .swiper-button-next,
    .swiper-container-rtl .swiper-button-prev {
      background: url("../../static/img/you2.png") 100% 100% / 100% 100%
        no-repeat;
      right: 95px;
      left: auto;
      width: 17px;
      height: 31px;
    }
    .swiper-button-prev,
    .swiper-container-rtl .swiper-button-next {
      background: url("../../static/img/zuo2.png") 100% 100% / 100% 100%
        no-repeat;
      left: 95px;
      right: auto;
      width: 17px;
      height: 31px;
    }
    .cardUl {
      > li {
        transition: all 0.6s;
      }
      > li:hover {
        transform: scale(1.1);
        box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.2);
      }
      
    }
  }
  .enterpriseinfo {
    .enterPriseCon {
      .con1 {
        overflow: hidden;
      }
      .con1 img {
        transition: all 0.6s;
      }
      .con1 img:hover {
        transform: scale(1.1);
      }
      .con2 {
        .conlef1 {
          overflow: hidden;
          img {
            transition: all 0.6s;
          }
          img:hover {
            transform: scale(1.1);
          }
        }
      }
    }
  }
  .enterprisesPark {
    .enterPark {
      // li{
      //   // transition: all 0.6s;
      // }
      // li:hover{
      //  transform: scale(1.1);
      //  transition: all 0.6s;

      // }
    }
  }
}
</style>


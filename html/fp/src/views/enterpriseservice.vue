<template>
    <div class="enterpriseservice">
        <div class="portalIndexImg">
            <div id="poheader" class="header" :class="{'headerw':showFF}">
                <div class="headerContainer clearfix">
                    <div class="titleImg fl">
                        <img src="@/../static/img/LOGO1.png" v-if="!showFF"  class="pointer" alt="" @click="$router.push({path:'/'})">
                        <img src="@/../static/img/login-logo.png" v-else class="pointer" alt="" @click="$router.push({path:'/'})">
                        </div>
                    <div class="headerRight fr">
                        <div class="search pointer" >
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
                            <ul class="posA clearfix" id="posA">
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

                        <!-- </transition> -->
                    </div>
                </div>
            </div>
            <div class="search_box" id="search_box" :class="{'searchbox':showFF}" @mouseleave="show4=!show4">
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
        </div>
        <div class="enterpriseCon">
            <div class="banner pr">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/banner11.png" alt="" @click="$router.push({path:'/serMatHp'})">
                        </div>
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/banner11.png" alt="" @click="$router.push({path:'/serMatHp'})">
                        </div>
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/banner11.png" alt="" @click="$router.push({path:'/serMatHp'})">
                        </div>                  
                    </div>
                    <!-- 如果需要分页器 -->
                         <div class="swiper-pagination"></div>

                        <!-- 如果需要导航按钮 -->
                        <div class="swiper-button-prev" @mouseenter="showBtn=!showBtn" @mouseleave="showBtn=!showBtn">
                            <i class="iconfont icon-leftarrow pointer" v-show="showBtn"></i>
                        </div>
                        <div class="swiper-button-next"  @mouseenter="showBtn=!showBtn" @mouseleave="showBtn=!showBtn">
                            <i class="iconfont icon-rightarrow pointer" v-show="showBtn"></i>
                        </div>
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
            <div class="declarationNotice w pr" ref="declarationNotice" data-class="bottom">
                <div ref="deNotice1" data-class="bottom">
                    <div class="tit color2 pr">申报中心
                    </div>
                    <div class="eng mainColor">Declare&nbsp;center</div>
                    <div class="line"></div>
                </div>
                <div ref="deNotice2" data-class="bottom1">
                    <div class="info clearfix">
                        <div class="left fl pr">
                            <el-collapse accordion v-model="activeNames" @change="handleChange11">
                                <el-collapse-item name='1'>
                                    <template slot="title">
                                        <div class="li1 aa" :class="{'active':sw=='1'}">01</div>
                                        <span class="color1">关于高新技术企业认定的申报及专项投资申报</span>
                                    </template>
                                    <p>申报截止时间：2019-03-26</p>
                                    <!-- <div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div> -->
                                </el-collapse-item>
                                <el-collapse-item name='2'>
                                    <template slot="title">
                                        <div class="li3 aa" :class="{'active':sw=='2'}">02</div>申报高新技术产品认定,是国家高新技术企业认定的加分项。
                                    </template>
                                    <p>申报截止时间：2019-03-26</p>
                                </el-collapse-item>
                                <el-collapse-item name='3'>
                                    <template slot="title">
                                        <div class="li5 aa" :class="{'active':sw=='3'}">03</div>南京市人民政府关于高新区企业资质荣誉申请...
                                    </template>
                                    <p>申报截止时间：2019-03-26</p>
                                </el-collapse-item>
                            </el-collapse>
                        </div>
                        <div class="right fl"></div>
                    </div>
                    <div class="pagination-container">
                        <el-pagination background layout="prev, pager, next" :total="30">
                        </el-pagination>
                    </div>
                </div>

            </div>
            <div class="policyCenter w" ref="policyCenter" data-class="bottom1">
                <div ref="poCenter1" data-class="bottom">
                    <div class="tit color2 pr">政策中心
                    </div>
                    <div class="eng mainColor">Policy&nbsp;center</div>
                    <div class="line"></div>
                </div>
                <div class="paging w pr" ref="poCenter2" data-class="bottom">
                    <div class="swiper-container">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide">
                                <ul class="page1 clearfix" ref="poCenter3" data-class="bottom">
                                    <li ref="li11" data-class="left">
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
                                    <li ref="li22" data-class="right">
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
                                    <li ref="li33" data-class="left">
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
                                    <li ref="li44" data-class="right">
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
                            </div>
                            <div class="swiper-slide">
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
                                    <li >
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
                                    <li >
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
                            </div>
                            <div class="swiper-slide">
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
                                    <li >
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
                                    <li >
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
                            </div>
                        </div>
                        
                        <div class="swiper-pagination"></div>
                        <div class="swiper-button-prev"></div>
                        <div class="swiper-button-next"></div>
                    </div>
                </div>
            </div>
            <div class="approval" ref="approval" data-class="bottom">
                <div class="approvalInfo w" ref="approval1" data-class="bottom1">
                    <div class="approTit">行政审批</div>
                    <div class="approEng">Administrative&nbsp;approval</div>
                    <div class="line"></div>
                    <div class="approDel">了解详情&nbsp;&nbsp;<img src="@/../static/img/xiala.png" alt=""><img src="@/../static/img/xiala.png" alt=""></div>
                </div>
            </div>
            <div class="popularActi w" ref="popularActi" data-class="bottom">
                <div ref="acti11" data-class="bottom">
                    <div class="tit color2">活动中心</div>
                    <div class="eng mainColor">Activity&nbsp;center</div>
                    <div class="line"></div>
                </div>
                <div class="acti pr" ref="acti22" data-class="bottom1">
                    <div class="swiper-container">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide" style="width:100%">
                                <ul class="actiUl clearfix">
                                    <li>
                                        <!-- <div class="postImgItem" >
                                            <img src="@/../static/img/heng1.png" class="postImg" v-if="show1" @mouseenter.stop="show1=!show1" alt="活动海报图片">
                                            <img src="@/../static/img/组 40.png" class="postImg" v-else @mouseleave.stop="show1=!show1" alt="活动海报图片">
                                        </div> -->
                                        <div class="postImgItem" @mouseenter.stop="show1=!show1,show11=!show11" @mouseleave.stop="show1=!show1,show11=!show11">
                                            <img src="@/../static/img/heng1.png" :class="{'poIm':show1}" class="postImg" alt="活动海报图片">
                                            <img src="@/../static/img/组 40.png" :class="{'poIm':show11}" class="postImg1" alt="活动海报图片">
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
                                        <!-- <div class="postImgItem" >
                                            <img src="@/../static/img/heng1.png" class="postImg" v-if="show2" @mouseenter.stop="show2=!show2" alt="活动海报图片">
                                            <img src="@/../static/img/组 40.png" class="postImg" v-else @mouseleave.stop="show2=!show2" alt="活动海报图片">
                                        </div> -->
                                        <div class="postImgItem" @mouseenter.stop="show2=!show2,show22=!show22" @mouseleave.stop="show2=!show2,show22=!show22">
                                            <img src="@/../static/img/heng1.png" :class="{'poIm':show2}" class="postImg" alt="活动海报图片">
                                            <img src="@/../static/img/组 40.png" :class="{'poIm':show22}" class="postImg1" alt="活动海报图片">
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
                                        <!-- <div class="postImgItem" >
                                            <img src="@/../static/img/heng3.png" class="postImg" v-if="show3" @mouseenter.stop="show3=!show3" alt="活动海报图片">
                                            <img src="@/../static/img/组 40.png" class="postImg" v-else @mouseleave.stop="show3=!show3" alt="活动海报图片">
                                        </div> -->
                                        <div class="postImgItem" @mouseenter.stop="show3=!show3,show33=!show33" @mouseleave.stop="show3=!show3,show33=!show33">
                                            <img src="@/../static/img/heng1.png" :class="{'poIm':show3}" class="postImg" alt="活动海报图片">
                                            <img src="@/../static/img/组 40.png" :class="{'poIm':show33}" class="postImg1" alt="活动海报图片">
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
                        <div class="swiper-pagination" style="display:none"></div>

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
            <!-- 科技金融 -->
            <div class="technologyFinance pr" ref="technologyFinance" data-class="bottom">
                <div class="tuoyuan">
                    <i class="el-icon-arrow-down"></i>
                </div>
                <div class="w" ref="tech" data-class="bottom">

                    <div ref="tech1" data-class="bottom">
                        <div class="tit color2 pr pointer" @click="$router.push({path:'/tfindex'})">科技金融
                        </div>
                        <div class="eng mainColor pointer" @click="$router.push({path:'/tfindex'})">Science&nbsp;and&nbsp;finacial</div>
                        <div class="line"></div>
                    </div>
                    <div ref="tech2" data-class="bottom1">
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
                                                    <div class="info_name">
                                                        <span>郭龙华</span>/
                                                        <span>总经理</span>
                                                    </div>
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
                                                    <div class="info_name">
                                                        <span>郭龙华</span>/
                                                        <span>总经理</span>
                                                    </div>
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
            </div>
            <div class="humanResources" ref="humanResources" data-class="bottom">
                <div ref="human1" data-class="bottom">
                    <div class="tit pr">人力资源
                    </div>
                    <div class="eng">The&nbsp;humen&nbsp;resources</div>
                    <div class="line"></div>
                </div>
                <div class="humanResInfo w" ref="human2" data-class="bottom1">
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
                        <ul class="infoCon" ref="human3" data-class="bottom1">
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
    </div>
</template>
<script>
import swiper from "swiper";
export default {
  data() {
    return {
      showFF: false,
      show1: false,
      show11: false,
      show22: false,
      show33: false,
      show2: false,
      show3: false,
      show4: false,
      activeNames: ["1"],
      searchData:'',
      showBtn:false,
      sw:'1',
    };
  },
  mounted() {
    this.$router.afterEach((to, from, next) => {
      window.scrollTo(0, 0);
    });
    this.init();
    window.addEventListener("scroll", this.handleScroll);
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
  },
  methods: {
    handleChange11(val) {
        console.log(val);
        if(val=='2'){
            this.sw='2'
        } else if(val=='3'){
            this.sw='3'
        } else{
            this.sw='1'
        }
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
      for (const key in this.$refs) {
        const top = this.getElementLeft(this.$refs[key]);
        // console.dir(top);
        if (osTop + innerHeight + 300 >= top + 100) {
          const name = this.$refs[key].dataset.class;
          this.$refs[key].classList.add(name);
        }
      }
      if (
        this.getScrollTop() > document.getElementById("poheader").clientHeight
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
    },
    init() {
      var mySwiper = new swiper(".swiper-container", {
        direction: "horizontal", // 垂直切换选项
        loop: true, // 循环模式选项

        // 如果需要分页器
        pagination: {
          el: ".swiper-pagination"
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
    onchange() {
      console.log(0);
    },
    aa() {
      console.log(111);
    },
    handleChange() {
    //   this.sousuo = true;
    }
  }
};
</script>
<style lang="scss">
// @keyframes qfe_btt {
//   0% {
//     transform: translate(0, 10%);
//     opacity: 0;
//   }
//   100% {
//     transform: translate(0, 0);
//     opacity: 1;
//   }
// }

.enterpriseservice {
  .declarationNotice,
  .policyCenter,
  .approval,
  .popularActi,
  .technologyFinance,
  .humanResources,
  .humanResInfo {
    opacity: 0;
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
  .left {
    animation: fadeInLeft 3s ease .5s forwards;
  }
  .right {
    animation: fadeInRight 3s ease .5s forwards;
  }
  .swiper-container {
    width: 100%;
  }
 
  .portalIndexImg {
      color:#fff;
    .swiper-slide {
      > img {
        width: 100%;
        vertical-align: middle;
      }
    }
    .headerw{
      background: #fff;
      // box-shadow: 0 2px 12px 0px rgba(0, 0, 0, 0.3);
      border: 1px solid #eee;
      box-shadow:0 10px 10px -10px #ccc;
      color: #666;
      #nav,.headerRight{
        color: #666;
        li{
          a{
            color:#666;
          }
        }
        li:nth-child(4){
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
         li:hover a{
            color:#00a041;
        }
      }
    }
     #posA {
      li{
          color:#fff;
      }
        > .firstLi {
        // background: rgba(255, 255, 255, 0.2);
        background: inherit;
        border-radius: none;
        }
        > li:hover {
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
  }
  .enterpriseCon{
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
        font-size: 45px;
      }
    }
    .swiper-button-prev {
      left: 60px;
    }
    .swiper-button-next {
      right: 60px;
    }
    .swiper-pagination {
      bottom: 40%;
      left: 92%;
      .swiper-pagination-bullet {
        display: block;
        margin-bottom: 10px;
        opacity: 1;
        background: #ccc;
      }
      .swiper-pagination-bullet-active {
        background: #fff;
        height: 50px;
        border-radius: 4px;
      }
    }
   }
  }
  .declarationNotice {
    #li2,
    #li4 {
      height: 64px;
    }
    .li5,
    .li1,
    .li3 {
      z-index: 3;
    }
    .pagination-container {
      margin-top: 50px;
    }
    .left {
      text-align: left;
      .leftLine {
        position: absolute;
        width: 2px;
        height: 67%;
        background: #ccc;
        top: 14%;
        left: 20px;
      }
      .leftLine.act {
        height: 50%;
      }
      .el-collapse,
      .el-collapse-item__header,
      .el-collapse-item__wrap {
        border: none;
      }
      .el-collapse-item__wrap {
        // text-indent: 3.5em;
      }
      .el-collapse-item__arrow {
        display: none;
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
  .policyCenter {
    .paging {
      .swiper-container {
        padding: 40px 0;
      }
      .swiper-button-prev,
      .swiper-button-next {
        width: 17px;
        height: 31px;
      }
      .swiper-pagination-bullet {
        background: #999;
      }
      .swiper-pagination-bullet-active {
        background: #00a041;
      }
      .swiper-button-prev,
      .swiper-container-rtl .swiper-button-next {
        background: url("../../static/img/zuo2.png") 100% 100% / 100% 100%
          no-repeat;
        left: 135px;
        right: auto;
      }
      .swiper-button-next,
      .swiper-container-rtl .swiper-button-prev {
        background: url("../../static/img/you2.png") 100% 100% / 100% 100%
          no-repeat;
        right: 135px;
        left: auto;
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
          //   .right1:hover {
          //     background: #ffffff !important;
          //     animation: qfe_btt 0.7s 1 ease;
          //     opacity: 1;
          //   }
        }
        > li:nth-child(2n) {
          margin-right: 0;
        }
        >li:hover{
            box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .2);
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
      //   .el-carousel__arrow {
      //     background: none;
      //     color: #eee;
      //     font-size: 35px;
      //   }
      //   .el-carousel__arrow--left {
      //     left: 130px;
      //   }
      //   .el-carousel__arrow--right {
      //     right: 130px;
      //   }
      //   .el-carousel__button {
      //     width: 9px;
      //     height: 9px;
      //     background: #e1e1e1;
      //     border-radius: 50%;
      //   }
      //   .el-carousel__indicator.is-active .el-carousel__button {
      //     background: #00a041;
      //   }
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
        font-weight: 100;
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
          > button:hover {
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
  #conselor_info {
    ul {
      display: flex;
      .conselor_left {
        width: 36%;
        a {
          border: 1px solid #dedede;
          display: flex;
          margin-top: 20px;
          .info_img {
            width: 46%;
            img {
              width: 80%;
              border-radius: 50%;
              display: block;
              margin: 20px auto;
            }
          }
          .info_all {
            margin: auto 0;
            .info_name {
              padding-bottom: 18px;
            }
            .info_detail {
              font-size: 12px;
              color: #999;
            }
          }
        }
      }
      .conselor_mid {
        width: 63%;
        .conselor_mid_list {
          float: left;
          width: 50%;
        }
        a {
          border: 1px solid #dedede;
          display: flex;
          margin-top: 20px;
          margin-left: 20px;
          .info_img {
            width: 27%;
            img {
              width: 79%;
              border-radius: 50%;
              display: block;
              margin: 6px auto;
            }
          }
          .info_all {
            margin: auto 10px;
            .info_name {
              padding-bottom: 18px;
            }
            .info_detail {
              font-size: 12px;
              color: #999;
            }
          }
        }
      }
      a {
        transition: all 0.6s;
      }
      a:hover {
        box-shadow: 0px 0px 12px 3px rgba(0, 0, 0, 0.1);
      }
    }
  }
}
</style>


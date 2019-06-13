<template>
  <div class="enterpriseservice">
    <div class="enterpriseCon">
      <div class="banner pr">
        <div class="swiper-container">
          <div class="swiper-wrapper">
            <div class="swiper-slide pointer" style="width:100%" v-for="(banner, index) in bannerList" :key="index">
              <img :src="banner.posterUrl" :data-path="'/serMatHp'" alt="">
            </div>
            <!-- <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/banner11.png" alt="" @click="$router.push({path:'/serMatHp'})">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/banner11.png" alt="" @click="$router.push({path:'/serMatHp'})">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/banner11.png" alt="" @click="$router.push({path:'/serMatHp'})">
            </div> -->
          </div>
          <!-- 如果需要分页器 -->
          <div class="swiper-pagination"></div>

          <!-- 如果需要导航按钮 -->
          <div class="swiper-button-prev" @mouseenter="showBtn=!showBtn" @mouseleave="showBtn=!showBtn">
            <i class="iconfont icon-leftarrow pointer" v-show="showBtn"></i>
          </div>
          <div class="swiper-button-next" @mouseenter="showBtn=!showBtn" @mouseleave="showBtn=!showBtn">
            <i class="iconfont icon-rightarrow pointer" v-show="showBtn"></i>
          </div>
          <!-- 如果需要滚动条 -->
          <!-- <div class="swiper-scrollbar"></div> -->
        </div>
        <div class="quickEnter">
          <ul>
            <li @click="$router.push({path:'/talentsService'})">
              <span>人才服务</span>
              <p>THE&nbsp;TALENT&nbsp;SERVICE</p>
              <img src="@/../static/img/right-arrow.png" alt="">
            </li>
            <li @click="$router.push({path:'/declarationCenter'})">
              <span>申报中心</span>
              <p>DECLARE&nbsp;CENTER</p>
              <img src="@/../static/img/right-arrow.png" alt="">
            </li>
            <li @click="$router.push({path:'/incubatorEnterprises'})">
              <span>孵化企业</span>
              <p>INCUBATION&nbsp;ENTERPRISE</p>
              <img src="@/../static/img/right-arrow.png" alt="">
            </li>
            <li @click="$router.push({path:'/compassView'})">
              <span>行政审批</span>
              <p>ADMINISTRATIVE&nbsp;EXAMINATIO</p>
              <img src="@/../static/img/right-arrow.png" alt="">
            </li>
          </ul>
        </div>
      </div>
      <div class="declarationNotice w pr" ref="declarationNotice" data-class="bottom">
        <div ref="deNotice1" data-class="bottom" class="pointer" @click="$router.push({path:'/declarationCenter'})">
          <div class="tit color2 pr">申报中心
          </div>
          <div class="eng mainColor">Declare&nbsp;center</div>
          <div class="line"></div>
        </div>
        <div ref="deNotice2" data-class="bottom1">
          <div class="info clearfix">
            <div class="left fl pr">
              <el-collapse accordion v-model="activeNames" @change="handleChange11">
                <el-collapse-item :name="index+1" v-for="(notice,index) in declarationNotice" :key="index">
                  <template slot="title">
                    <div class="li1 aa" :class="{'active0':sw==index}">{{'0'+(index+1)}}</div>
                    <span class="color1">{{notice.titleName}}</span>
                  </template>
                  <p>申报截止时间：{{notice.deadline|time}}</p>
                </el-collapse-item>
              </el-collapse>
              <!-- <el-collapse accordion v-model="activeNames" @change="handleChange11">
                <el-collapse-item name='1'>
                  <template slot="title">
                    <div class="li1 aa" :class="{'active':sw=='0'}">01</div>
                    <span class="color1">关于高新技术企业认定的申报及专项投资申报</span>
                  </template>
                  <p>申报截止时间：2019-03-26</p>
                </el-collapse-item>
                <el-collapse-item name='2'>
                  <template slot="title">
                    <div class="li3 aa" :class="{'active':sw=='1'}">02</div>申报高新技术产品认定,是国家高新技术企业认定的加分项。
                  </template>
                  <p>申报截止时间：2019-03-26</p>
                </el-collapse-item>
                <el-collapse-item name='3'>
                  <template slot="title">
                    <div class="li5 aa" :class="{'active':sw=='2'}">03</div>南京市人民政府关于高新区企业资质荣誉申请...
                  </template>
                  <p>申报截止时间：2019-03-26</p>
                </el-collapse-item>
              </el-collapse> -->
            </div>
            <div class="right fl"></div>
          </div>
          <div class="pagination-container">
            <el-pagination :page-sizes="[3, 6, 9, 12]" :page-size="rows1" background layout="prev, pager, next" :total="total1" @size-change="handleSizeChange" @current-change="handleCurrentChange">
            </el-pagination>
          </div>
        </div>

      </div>
      <div class="policyCenter w" ref="policyCenter" data-class="bottom1">
        <div ref="poCenter1" data-class="bottom" class="pointer" @click="$router.push({path:'/policyCenter'})">
          <div class="tit color2 pr">政策中心
          </div>
          <div class="eng mainColor">Policy&nbsp;center</div>
          <div class="line"></div>
        </div>
        <div class="paging w pr" ref="poCenter2" data-class="bottom">
          <div class="swiper-container1">
            <div class="swiper-wrapper">
              <div class="swiper-slide" v-for="(list, listIndex) in policyCenterList" :key="listIndex">
                <ul class="page1 clearfix" ref="poCenter3" data-class="bottom">
                  <li ref="li11" data-class="left" class="pointer" v-for="(item, index) in list" :key="index" @click="$router.push({path:'/policyGuide',query:{policyId:item.policyId}})">
                    <div class="left1">N</div>
                    <div class="right1">
                      <div class="rightTit color1">{{item.policyTitle}}</div>
                      <p class="color2">{{item.briefContent}}</p>
                      <div class="liBom clearfix">
                        <p class="fl color3">
                          <i class="el-icon-view"></i>&nbsp;{{item.readNum}}</p>
                        <span class="fr mainColor">{{item.policyLevelName}}</span>
                        <i class="fr mainColor" style="marin-left:25px;">{{item.policyClassName}}</i>
                      </div>
                    </div>
                  </li>

                </ul>
              </div>
              <!-- <div class="swiper-slide">
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
              </div> -->
            </div>

            <div class="swiper-pagination"></div>
            <div class="swiper-button-prev" v-show="policyCenterList.length > 1"></div>
            <div class="swiper-button-next" v-show="policyCenterList.length > 1"></div>
          </div>
        </div>
      </div>
      <div class="approval" ref="approval" data-class="bottom">
        <div class="approvalInfo w pointer" ref="approval1" data-class="bottom1" @click="$router.push({path:'/compassView'})">
          <div class="approTit">行政审批</div>
          <div class="approEng">Administrative&nbsp;approval</div>
          <div class="line"></div>
          <div class="approDel">了解详情&nbsp;&nbsp;<img src="@/../static/img/xiala.png" alt=""><img src="@/../static/img/xiala.png" alt=""></div>
        </div>
      </div>
      <div class="popularActi w" ref="popularActi" data-class="bottom">
        <div ref="acti11" data-class="bottom" class="pointer" @click="$router.push({path:'/actiCenter'})">
          <div class="tit color2">活动中心</div>
          <div class="eng mainColor">Activity&nbsp;center</div>
          <div class="line"></div>
        </div>
        <div class="acti pr" ref="acti22" data-class="bottom1">
          <i class="iconfont icon-leftarrow pointer" @click="leftPage"></i>
          <i class="iconfont icon-rightarrow pointer" @click="rightPage"></i>
          <ul class="actiUl clearfix">
            <li v-for="(i,k) in actiListSlim" :key="k">
              <div class="postImgItem" @mouseenter.stop="show1=i.id,show11=i.id" @mouseleave.stop="show1='',show11=''">
                <img :src="i.actiPosterUrl" :class="{'poIm':show1==i.id}" class="postImg pointer" alt="活动海报图片">
                <img src="@/../static/img/组 40.png" :class="{'poIm':show11==i.id}" class="postImg1 pointer" alt="活动海报图片" @click="$router.push({ path: '/actiDetail', query: { activityId: i.id } })">
              </div>
              <div class="actiInfo">
                <p class="actiNameItem">
                  {{i.actiName}}
                </p>
                <p class="actiTimer">
                  <i class="el-icon-time"></i>
                  <span>{{i.actiStartTime}}-{{i.actiEndTime}}</span>
                </p>
                <p class="actiAddress">
                  <i class="el-icon-location-outline"></i>
                  <span>{{i.actiAddress}}</span>
                </p>
              </div>
              <div class="actiNum clearfix">
                <div class="avatar">
                  <ul>
                    <li v-for="(item,key) in i.avatarList" v-if="item<5" :key='key'><img :src="item" alt=""></li>
                  </ul>
                </div>
                <i>{{i.applyNum}}/{{i.actiNumber}}名</i>
                <p class="avaP">
                  <!-- <i class="iconfont icon-xihuan"></i>16 -->
                  <img src="@/../static/img/xin.png" alt="">{{i.actiLike}}
                </p>
              </div>
            </li>
            <!-- <div v-for="it in arr"> //企业招聘弹框
              <div>
                <button @click="flag = it.id"></button>
                <div class="jiegou" v-if="flag == it.id">
                  <button @click="flag=''">x</button>
                </div>
              </div>
            </div> -->
            <!-- <li>
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
                </p>
                <p>
                  <i class="el-icon-location-outline"></i>
                  <span>白下高新区管委会161号—A座</span>
                </p>
              </div>
              <div class="actiNum clearfix">
                <div class="avatar">
                  <ul>
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
            </li> -->
          </ul>
          <!-- <i class="iconfont icon-leftarrow pointer"></i>
                <i class="iconfont icon-rightarrow pointer"></i> -->
          <div class="lejieDel pointer" @click="$router.push({path:'/actiCenter'})">了解详情</div>
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
              <button class="btn1" :class="{'btActive':flag44=='0'}" @click="flag44 = '0'">投资人</button>
              <button class="btn2 btn11" :class="{'btActive':flag44=='1'}" @click="flag44 = '1'">金融产品</button>
              <button class="btn2" :class="{'btActive':flag44=='2'}" @click="flag44 = '2'">金融机构</button>
            </div>
            <div class="tecnInfo clearfix">
              <div id="conselor_info" v-if="flag44 == '0'">
                <ul>
                  <li class="conselor_left">
                    <div v-for="(item,index) in investorInfoList" :key="index" v-if="index<2">
                      <a href="javascript:;">
                        <div class="info_img">
                          <div @click="$router.push({path:'investorDetail',query:{investorAccount:item.investorAccount}})"><img v-if="item.avatar" :src="item.avatar" alt=""> <img v-else src="@/../static/img/larImg.png" alt=""></div>
                        </div>
                        <div class="info_all">
                          <div class="info_name">
                            <span>{{item.investorName}}</span>/
                            <span>{{item.position}}</span>
                          </div>
                          <div class="info_detail">
                            <p>{{item.orgName}}</p>
                            <p>{{item.position}}</p>
                          </div>
                        </div>
                      </a>
                    </div>
                  </li>
                  <li class="conselor_mid">
                    <div v-for="(item2,index2) in investorInfoList" :key="index2" v-if="index2>1&&index2<10" class="conselor_mid_list">
                      <a href="javascript:;">
                        <div class="info_img" @click="$router.push({path:'investorDetail',query:{investorAccount:item2.investorAccount}})"><img :src="item2.avatar" alt=""></div>
                        <div class="info_all">
                          <div class="info_name">
                            <span>{{item2.investorName}}</span>/
                            <span>{{item2.position}}</span>
                          </div>
                          <div class="info_detail">
                            <p>{{item2.orgName}}</p>
                            <p>{{item2.position}}</p>
                          </div>
                        </div>
                      </a>
                    </div>

                  </li>
                </ul>
              </div>
              <div class="finnaPro" v-if="flag44 == '1'">
                <ul>
                  <li class="clearfix" v-for="(i,k) in finaProList" :key='k' v-if="k<3">
                    <div class="orgImg fl pointer" @click="$router.push({ path: 'finaProDetail', query: { productId: i.productId } })">
                      <img v-if="i.pictureUrl" :src="i.pictureUrl" alt="">
                      <img v-else src="@/../static/img/product.png" alt="">
                    </div>
                    <div class="orgCon fl">
                      <div class="conTil">{{i.productName}}</div>
                      <div class="conContent clearfix color3">
                        <div class="left1 fl">
                          <p>服务机构：
                            <span class="mainColor">{{i.orgName}}</span>
                          </p>
                          <p>参考利率范围：
                            <span class="mainColor">{{i.refRateMin}}-{{i.refRateMax}}</span>
                          </p>
                          <p>贷款期限:
                            <span class="mainColor">{{i.loanTermMin}}-{{i.loanTermMax}}</span>笔交易</p>
                          <p>担保方式：{{i.assureMethodName}}</p>
                          <p>贷款额度：
                            <span class="mainColor">{{i.loanAmountMin}}-{{i.loanAmountMax}}</span>万元</p>
                        </div>
                        <div class="right1 fl">
                          <p>
                            <el-rate v-model="i.ratingScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                            </el-rate>
                            <span class="mainColor">{{i.ratingNum}}</span>条评价</p>
                          <p style="text-align:center">
                            累计
                            <span class="mainColor">{{i.transactionNum}}</span>笔交易
                          </p>
                        </div>
                      </div>
                    </div>
                    <div class="orgBtn fr mainColor" @click="raiseDemand(i)">
                      提需求
                    </div>
                  </li>
                </ul>
              </div>
              <div class="finnaOrg" v-if="flag44 == '2'">
                <ul>
                  <li class="clearfix" v-for="(i,k) in finaOrgLost" :key='k' v-if="k<3">
                    <div class="orgImg fl pointer" @click="$router.push({ path: 'finaInsDetail', query: { orgId: i.orgId } })">
                      <img :src="i.orgLogo" alt="">
                    </div>
                    <div class="orgCon fl">
                      <div class="conTil" style="margin-bottom:40px">{{i.orgName}}</div>
                      <div class="conContent clearfix color3">
                        <div class="left1 fl">
                          <p>电话：
                            <span class="mainColor">{{i.orgPhone}}</span>
                          </p>
                          <p>地址：{{i.orgAddress}}</p>
                          <p>累计
                            <span class="mainColor">{{i.transactionNum}}</span>笔交易</p>
                        </div>
                        <div class="right1 fl">
                          <p>
                            <el-rate v-model="i.attitudeScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                            </el-rate>
                            <span class="mainColor">{{i.evaluationNum}}</span>条评价</p>
                          <p>
                            {{i.attitudeScore}}分
                          </p>
                        </div>
                      </div>
                    </div>
                    <div class="orgBtn fr mainColor">
                      <a href="javascript:;" @click="onlineContat(i.orgAccount,i.orgName)">在线联系</a>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="humanResources" ref="humanResources" data-class="bottom">
        <div ref="human1" data-class="bottom" class="pointer" @click="$router.push({path:'/recruitmentList'})">
          <div class="tit pr">人力资源
          </div>
          <div class="eng">The&nbsp;humen&nbsp;resources</div>
          <div class="line"></div>
        </div>
        <div class="humanResInfo w" ref="human2" data-class="bottom1">
          <el-card>
            <div class="infoTit clearfix">
              <div class="btn fl">
                <button class="btn0 pointer" :class="{'btnActive':flag55}" @click="flag55=true">企业招聘</button>
                <button class="btn2 pointer" :class="{'btnActive':!flag55}" @click="flag55=false">服务</button>
              </div>
              <div class="chage fr color3 pointer" @click="hanlepage">
                <img src="@/../static/img/huanyipi.png" alt=""> 换一批
              </div>
            </div>
            <ul class="infoCon" ref="human3" data-class="bottom1" v-if='flag55'>
              <li class="clearfix pr" v-for="(i,k) in humanResourcesList" :key="k">
                <div class="con1 fl">
                  <img :src="i.comAvatar" alt="">
                </div>
                <div class="con2 fl">
                  <p class="color4">招聘岗位：{{i.post}}</p>
                  <p>招聘企业： {{i.comName}}</p>
                  <p>招聘人数：{{i.num}}人</p>
                  <p>薪资待遇：
                    <span class="mainColor">{{i.salaryName}}</span>
                  </p>
                  <p>发布时间：{{i.createdTime}}</p>
                </div>
                <div class="con3 fr">
                  <button class="btn1 pointer" @click="onlineContact(i.comId)">在线联系</button>
                  <button class="btn2 pointer" @click.stop="getRecruitDetails(i.id),detailFlag=i.id">了解详情</button>
                </div>
                <!-- 详情弹框 -->
                <div class="detailRes" v-if="detailFlag==i.id">
                  <!-- <el-card> -->
                  <div class="detail">招聘详情</div>
                  <p class="p1">企业名称：{{humanDetail.comName}}</p>
                  <p class="p1">发布时间：{{humanDetail.createdTime}}</p>
                  <p class="p1">岗位详情：</p>
                  <span v-html="humanDetail.details"></span>
                  <!-- </el-card> -->
                </div>
              </li>
            </ul>
            <div class="serverOrgContent" v-else>
              <ul>
                <li class="clearfix" v-for="(i,k) in serverProList" :key='k'>
                  <div class="orgImg fl pointer" @click="handleProDel(i.productId,i.signoryId)">
                    <img v-if="i.pictureUrl" :src="i.pictureUrl" alt="">
                    <img v-else src="@/../static/img/product.png" alt="">
                  </div>
                  <div class="orgCon fl">
                    <div class="conTil">{{i.productName}}</div>
                    <div class="conContent clearfix color3">
                      <div class="left1 fl" id="left1">
                        <p>服务机构：{{i.orgName}}
                        </p>
                        <p>服务顾问：{{i.advisorName}}</p>
                        <p>参考价格
                          <span class="mainColor">{{i.referPrice}}</span>元</p>
                        <p>累计
                          <span class="mainColor">{{i.transactionsNumber}}</span>笔交易</p>
                      </div>
                      <div class="right1 fl">
                        <p>
                          <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                          </el-rate>
                          <span class="mainColor">{{i.evaluationNumber}}</span>条评价</p>
                      </div>
                    </div>
                  </div>
                  <div class="orgBtn fr mainColor" @click="demandRaise(i)">提需求</div>
                </li>
              </ul>
            </div>
          </el-card>
        </div>
      </div>

    </div>
    <!-- 金融提需求弹框 -->
    <template v-if="financialProVisible">
      <el-dialog :visible.sync="financialProVisible" width="600px" :append-to-body="true" :lock-scroll="false">
        <div v-if="islogin">
          <el-form ref="financialProform" :rules="rules" :model="financialProform" label-position="right" label-width="150px" style="max-width:500px;">
            <el-form-item label="融资金额(万元):" prop="financingAmount">
              <el-input v-model.trim="financialProform.financingAmount" placeholder="请输入融资金额" maxlength="100" clearable/>
            </el-form-item>
            <el-form-item label="融资期限(月):" prop="financingPeriod">
              <el-select v-model="financialProform.financingPeriod" placeholder="请选择" style="width:100%">
                <el-option v-for="(item,index) in options" :key="index" :label="item.label" :value="item.value" />
              </el-select>
            </el-form-item>

            <el-form-item label="资金需求日期:" prop="expectedDate">
              <!-- <el-input v-model.trim="financialProform.expectedDate" placeholder="请输入需求日期，如2019-04-10" maxlength="100" clearable/> -->
              <el-date-picker v-model="financialProform.expectedDate" type="date" placeholder="选择日期" style="width:100%" value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="资金需求说明:" prop="fundsReqDesc">
              <el-input v-model.trim="financialProform.fundsReqDesc" class="demandTextArea" :rows="4" type="textarea" placeholder="可不填" maxlength="100" clearable/>
            </el-form-item>
          </el-form>
          <div class="demandLine"></div>
          <div class="demandDia1" @click="demandDia()" style="background: #ecfcf2;
    padding: 8px 10px;
    width: 80px;
    margin: 0 auto;
    border: 1px solid #00a041;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    color: #00a041;">提交需求</div>
        </div>
        <div v-else class="loginTip" style="text-align:center;padding-bottom:20px">
          你还未
          <span class="mainColor pointer" @click="goLogin">登录</span>
          /
          <span class="mainColor pointer" @click="$router.push({path:'/register'})">注册</span>
          企业账号
        </div>
      </el-dialog>
    </template>
    <!-- 服务产品提需求弹框 -->
    <template v-if="serverProVisible">
      <el-dialog :visible.sync="serverProVisible" width="530px" :append-to-body="true" :lock-scroll="false">
        <div v-if="islogin">
          <el-form ref="financialProform" :model="serverProform" label-position="right" label-width="100px" style="max-width:436px;">
            <el-form-item label="需求描述:" prop="requireDetail" style="font-size:13px">
              <el-input v-model.trim="serverProform.requireDetail" class="demandTextArea" :rows="4" type="textarea" placeholder="可不填" maxlength="100" clearable/>
            </el-form-item>
          </el-form>
          <div class="demandLine"></div>
          <div class="serverTip mainColor">市场提醒：请务必在线订购，线下交易无法享受市场交易安全保障</div>
          <div class="demandDia" @click="demandDia1()" style="   display: inline-block;
    background: #ecfcf2;
    padding: 8px 10px;
    width: 80px;
        margin-left: 200px;
    margin-top: 20px;
    border: 1px solid #00a041;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    color: #00a041;
    font-size: 12px;">提交需求</div>
        </div>
        <div v-else class="loginTip" style="text-align:center;padding-bottom:20px">
          你还未
          <span class="mainColor pointer" @click="goLogin">登录</span>
          /
          <span class="mainColor pointer" @click="$router.push({path:'/register'})">注册</span>
          企业账号
        </div>
      </el-dialog>
    </template>
    <template v-if="concatVisible">
      <el-dialog :visible.sync="concatVisible" width="530px" :append-to-body="true" :lock-scroll="false">
        <div class="loginTip" style="text-align:center;padding-bottom:20px">
          你还未
          <span class="mainColor pointer" @click="goLogin">登录</span>
          /
          <span class="mainColor pointer" @click="$router.push({path:'/register'})">注册</span>
          账号
        </div>
      </el-dialog>
    </template>
  </div>
</template>
<script>
import swiper from "swiper";
import bus from "@/util/bus";
export default {
  data() {
    return {
      serverProVisible: false,
      serverProform: {
        requireDetail: "",
        productId: "",
        productName: ""
      },
      financialProVisible: false,
      financialProform: {
        financingAmount: "",
        financingPeriod: "",
        financingPeriodMax: "",
        financingPeriodMin: "",
        expectedDate: "",
        fundsReqDesc: "",
        productId: "",
        productName: ""
      },
      options: [
        {
          value: 0,
          label: "3个月及以下"
        },
        {
          value: 1,
          label: "6个月及以下"
        },
        {
          value: 2,
          label: "12个月及以下"
        },
        {
          value: 3,
          label: "36个月及以下"
        },
        {
          value: 4,
          label: "36个月以上"
        }
      ],
      arr: [
        {
          loanTermMax: 3,
          loanTermMin: ""
        },
        {
          loanTermMax: 6,
          loanTermMin: ""
        },
        {
          loanTermMax: 12,
          loanTermMin: ""
        },
        {
          loanTermMax: 36,
          loanTermMin: ""
        },
        {
          loanTermMax: "",
          loanTermMin: 36
        }
      ],
      rules: {
        financingAmount: [
          { required: true, message: "请输入融资金额", trigger: "blur" }
        ],
        financingPeriod: [
          { required: true, message: "请选择融资期限", trigger: "change" }
        ],
        expectedDate: [
          { required: true, message: "请输入需求日期", trigger: "blur" }
        ]
      },
      detailFlag: "",
      flag55: true,
      flag44: "0",
      showFF: false,
      show1: false,
      show11: false,
      show22: false,
      show33: false,
      show2: false,
      show3: false,
      show4: false,
      activeNames: ["1"],
      searchData: "",
      showBtn: false,
      sw: "0",
      page1: 1,
      rows1: 3,
      total1: 0,
      declarationNotice: [],
      page2: 1,
      rows2: 4,
      total2: 0,
      policyCenterList: [],
      page3: 1,
      rows3: 3,
      total3: 0,
      actiListSlim: [],
      page4: 1,
      rows4: 10,
      investorInfoList: [],
      page5: 1,
      rows5: 3,
      finaProList: [],
      page6: 1,
      rows6: 3,
      finaOrgLost: [],
      page7: 1,
      rows7: 3,
      total7: 0,
      humanResourcesList: [],
      bannerList: [],
      page8: 1,
      rows8: 3,
      total8: 0,
      serverProList: [],
      humanDetail: {},
      islogin: true,
      concatVisible: false
    };
  },
  filters: {
    time(time) {
      if (time) {
        // return time.split("T")[0]
        let dateee = new Date(time).toJSON();
        return new Date(+new Date(dateee) + 8 * 3600 * 1000)
          .toISOString()
          .replace(/T/g, " ")
          .replace(/\.[\d]{3}Z/, "");
      }
    }
  },
  mounted() {
    this.$router.afterEach((to, from, next) => {
      window.scrollTo(0, 0);
    });
    // this.init();
    window.addEventListener("scroll", this.handleScroll);
    this.getdeclarationtList(); //申报公告
    this.getPolicyCenterList(); //政策中心
    this.getRecruitList(); //招聘
    this.getActiList(); //活动
    this.getInvestorInfoList(); //投资人
    this.getProList(); //服务产品列表
    this.getFinaOrg(); //金融机构
    this.getFinaPro(); //金融产品
    this.getBanner();
    // Promise.all([this.getBanner()]).then(() => {
    //   this.init();
    // });
  },
  created() {
    let _this = this;
    bus.$on("closeKnow", msg => {
      _this.detailFlag = "";
    });
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
  },
  methods: {
     goLogin() {
      window.sessionStorage.setItem("PresetRoute", this.$route.fullPath);
      this.$router.push({ path: "/login" });
    },
    //判断是否登录
    isLogin() {
      if (!sessionStorage.userInfo) {
        this.islogin = false;
      }
    },
    //在线联系
    onlineContat(orgAccount, orgName) {
      if (!sessionStorage.userInfo) {
        this.concatVisible = true;
        return;
      }
      this.$router.push({
        path: "/chat",
        query: {
          fromUser: JSON.parse(sessionStorage.userInfo).account,
          toUser: orgAccount,
          nickName: orgName
        }
      });
    },
    //企业招聘列表在线联系
    onlineContact(id) {
      if (!sessionStorage.userInfo) {
        this.concatVisible = true;
        return;
      }
      this.api.get({
        url: "getCompanyContactAccount",
        data: {
          comId: id
        },
        callback: res => {
          if (res.code == "0000") {
            // this.typeList = res.data;
            if (
              JSON.parse(sessionStorage.userInfo).account == res.data.account
            ) {
              this.$message.error("当前登录的账号跟聊天对象一样");
              return;
            }
            this.$router.push({
              path: "/chat",
              query: {
                fromUser: JSON.parse(sessionStorage.userInfo).account,
                toUser: res.data.account,
                nickName: res.data.nickName
              }
            });
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    //金融产品提需求
    raiseDemand(i) {
      // if (!sessionStorage.userInfo) {
      //   this.$message.error("请先登录");
      //   return;
      // }
      this.isLogin();
      this.financialProVisible = true;
      this.financialProform.expectedDate = "";
      this.financialProform.financingAmount = "";
      this.financialProform.financingPeriodMax = "";
      this.financialProform.financingPeriodMin = "";
      this.financialProform.financingPeriod = "";
      this.financialProform.fundsReqDesc = "";
      this.financialProform.productId = i.productId;
      this.financialProform.productName = i.productName;
    },
    //用户提交需求
    demandDia() {
      // if(!this.financialProform.financingPeriod){
      //   return
      // }
      let _this = this;
      let max = this.arr[this.financialProform.financingPeriod].loanTermMax;
      let min = this.arr[this.financialProform.financingPeriod].loanTermMin;
      this.api.post({
        url: "userDemandTechnology",
        data: {
          expectedDate: _this.financialProform.expectedDate,
          financingAmount: _this.financialProform.financingAmount,
          financingPeriodMax: max,
          financingPeriodMin: min,
          productId: _this.financialProform.productId,
          productName: _this.financialProform.productName,
          fundsReqDesc: _this.financialProform.fundsReqDesc
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.$message.success("提交需求成功");
            _this.financialProVisible = false;
          } else {
            _this.$message.error(res.result);
            _this.financialProVisible = false;
          }
        }
      });
    },
    //服务产品提需求
    demandRaise(i) {
      // if (!sessionStorage.userInfo) {
      //   this.$message.error("请先登录");
      //   return;
      // }
      this.isLogin();
      this.serverProVisible = true;
      this.serverProform.requireDetail = "";
      this.serverProform.productId = i.productId;
      this.serverProform.productName = i.productName;
    },
    demandDia1() {
      let _this = this;
      this.api.post({
        url: "userDemand",
        data: {
          productId: _this.serverProform.productId,
          productName: _this.serverProform.productName,
          requireDetail: _this.serverProform.requireDetail
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.$message.success("提交需求成功");
            _this.serverProVisible = false;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    handleProDel(productId, signoryId) {
      this.$router.push({
        path: "serverProDetail",
        query: { productId: productId, signoryId: signoryId }
      });
    },
    //招聘与服务切换翻页
    hanlepage() {
      if (this.flag55 == true) {
        if (this.page7 >= Math.ceil(this.total7 / this.rows7)) {
          // this.$message.error("没有更多数据了");
          this.page7 = 1;
          this.getRecruitList();
          // return;
        } else {
          this.page7++;
          this.getRecruitList();
        }
      } else {
        if (this.page8 >= Math.ceil(this.total8 / this.rows8)) {
          // this.$message.error("没有更多数据了");
          this.page8 = 1;
          this.getProList();
          // return;
        } else {
          this.page8++;
          this.getProList();
        }
      }
    },
    formatArr(arr, n) {
      const len = arr.length;
      let lineNum = len % 4 === 0 ? len / 4 : Math.floor(len / 4 + 1);
      const result = [];
      for (let i = 0; i < lineNum; i++) {
        // slice() 方法返回一个从开始到结束（不包括结束）选择的数组的一部分浅拷贝到一个新数组对象。且原始数组不会被修改。
        let temp = arr.slice(i * n, i * n + n);
        result.push(temp);
      }
      return result;
    },
    handleChange11(val) {
      if (val == "2") {
        this.sw = "1";
      } else if (val == "3") {
        this.sw = "2";
      } else {
        this.sw = "0";
      }
    },
    getElementLeft(element) {
      if (!element) {
        return 0;
      }
      var top = element.offsetTop;
      if (!element.offsetParent) {
        return top;
      }
      var curEle = element.offsetParent;

      while (curEle !== null) {
        top += curEle.offsetTop;
        curEle = curEle.offsetParent;
      }
      return top;
    },
    getScrollOffset() {
      // 除IE8及更早版本
      if (window.pageXOffset != null) {
        return {
          x: window.pageXOffset,
          y: window.pageYOffset
        };
      }
      // 标准模式下的IE
      if (document.compatMode == "css1Compat") {
        return {
          x: document.documentElement.scrollLeft,
          y: document.documentElement.scrollTop
        };
      }
      // 怪异模式下的浏览器
      return {
        x: document.body.scrollLeft,
        y: document.body.scrollTop
      };
    },
    handleScroll() {
      const osTop = this.getScrollOffset().y;
      for (const key in this.$refs) {
        const top = this.getElementLeft(this.$refs[key]);
        // console.dir(top);
        if (osTop + innerHeight + 300 >= top + 100) {
          const name = this.$refs[key].dataset.class;
          this.$refs[key].classList.add(name);
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
    //swiper初始化
    // init() {
    //   var mySwiper = new swiper(".swiper-container", {
    //     direction: "horizontal", // 垂直切换选项
    //     loop: true, // 循环模式选项
    //     noSwiping: true,
    //     on: {
    //       click: e => {
    //         // let url = e.target.dataset.jumpurl;
    //         // this.bannerJump(url);
    //         // console.log(e);
    //       }
    //     },
    //     observer: true,
    //     observeParents: true, //修改swiper的父元素时，自动初始化swiper
    //     // 如果需要分页器
    //     pagination: {
    //       el: ".swiper-pagination"
    //     },
    //     // 如果需要前进后退按钮
    //     navigation: {
    //       nextEl: ".swiper-button-next",
    //       prevEl: ".swiper-button-prev"
    //     },

    //     // 如果需要滚动条
    //     scrollbar: {
    //       el: ".swiper-scrollbar"
    //     }
    //   });
    // },
    swiperinit(name, obj) {
      var mySwiper = new swiper(name, obj);
    },
    handleChange() {
      //   this.sousuo = true;
    },
    //申报公告列表
    getdeclarationtList() {
      let _this = this;
      this.api.get({
        url: "getdeclarationcentertList",
        data: {
          rangeId: 1,
          page: _this.page1,
          rows: _this.rows1,
          sortType: 1
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.declarationNotice = res.data.rows;
            _this.total1 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //申报公告分页
    handleSizeChange(val) {
      this.rows1 = val;
      this.page1 = 1;
      this.getdeclarationtList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page1 = val;
      this.getdeclarationtList();
    },
    //政策中心首页
    getPolicyCenterList() {
      // return new Promise((resolve, reject) => {
      this.api.get({
        url: "getPolicyCenterList",
        data: {
          needPage: 1,
          policyType: 0,
          page: this.page2,
          rows: this.rows2,
          tableType: "allPolicy"
        },
        callback: res => {
          if (res.code === "0000") {
            this.policyCenterList = this.formatArr(res.data.rows, 4);
            this.total2 = res.data.total;
            let obj = {
              // direction: "horizontal", // 垂直切换选项
              // loop: true, // 循环模式选项
              // noSwiping: true,
              // autoplay: true,
              // autoplay: {
              //   delay: 2000,
              // },
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
            };
            setTimeout(() => {
              this.swiperinit(".swiper-container1", obj);
            }, 0);
          } else {
            this.$message.error(res.result);
            // reject();
          }
        }
      });
      // });
    },
    //活动中心
    getActiList() {
      let _this = this;
      this.api.post({
        url: "activityListSlim",
        data: {
          page: _this.page3,
          rows: _this.rows3
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.actiListSlim = res.data.rows;
            _this.total3 = res.data.total;
          }
        }
      });
    },
    //活动中心左翻页
    leftPage() {
      if (this.page3 <= 1) {
        this.$message.error("已经是第一页了");
        return;
      }
      this.page3--;
      this.getActiList();
    },
    //活动中心右翻页
    rightPage() {
      if (this.page3 >= Math.ceil(this.total3 / this.rows3)) {
        this.page3 = 1;
        this.getActiList();
      } else {
        this.page3++;
        this.getActiList();
      }
    },
    //科技金融-投资人列表
    getInvestorInfoList() {
      let _this = this;
      this.api.get({
        url: "getInvestorInfoList",
        data: {
          needPage: 1,
          mainCode: "",
          page: _this.page4,
          rows: _this.rows4
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.investorInfoList = res.data.rows;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //科技金融-金融产品列表
    getFinaPro() {
      let _this = this;
      let data = {
        needPage: 1,
        page: _this.page5,
        rows: _this.rows5
      };
      this.api.get({
        url: "getFinancialProList",
        data: data,
        dataFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.finaProList = res.data.rows;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //科技金融-金融机构列表
    getFinaOrg() {
      let _this = this;
      let data = {
        businessType: "technology_finance",
        page: _this.page6,
        rows: _this.rows6
      };
      this.api.get({
        url: "selectServiceOrgList",
        data: data,
        dataFlag: true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.finaOrgLost = res.data.rows;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    // 企业宣传列表查询
    getBanner() {
      // return new Promise((resolve, reject) => {
      let _this = this;
      this.api.get({
        url: "getPromotionList",
        data: {
          issuePlatform: 2,
          // propagandaType: 'home_banner_pc',//没有图片，暂时先用招商的测试
          propagandaType: "enterprise_banner",
          needPage: 0
        },
        callback: res => {
          if (res.code === "0000") {
            this.bannerList = res.data.rows;
            // resolve();
            let obj = {
              direction: "horizontal", // 垂直切换选项
              loop: true, // 循环模式选项
              noSwiping: true,
              // autoplay: true,
              observer: false,
              // autoplay: {
              //   delay: 2000
              // },
              on: {
                click: function(e) {
                  let path = e.path[0].getAttribute("data-path");
                  _this.$router.push(path);
                }
              },
              // 如果需要分页器
              pagination: {
                el: ".swiper-pagination"
              },
              // 如果需要前进后退按钮
              navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev"
              }
            };
            setTimeout(() => {
              this.swiperinit(".swiper-container", obj);
            }, 0);
          } else {
            // reject();
            this.$message.error(res.result);
          }
        }
      });
      // });
    },
    //获取招聘详情
    getRecruitDetails(id) {
      let _this = this;
      this.api.get({
        url: "getRecruitDetails",
        data: {
          recruitId: id
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.humanDetail = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //获取招聘列表
    getRecruitList() {
      let _this = this;
      this.api.get({
        url: "getRecruitList",
        data: {
          page: _this.page7,
          rows: _this.rows7
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.humanResourcesList = res.data.rows;
            _this.total7 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //服务产品列表
    getProList() {
      let _this = this;
      this.api.get({
        url: "findProductList",
        data: {
          page: _this.page8,
          // signoryId: _this.signoryId,
          rows: _this.rows8
          // keyWords: _this.keyWords,
          // sortTypes: _this.sortTypes,
          // productType: _this.productType
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverProList = res.data.rows;
            _this.total8 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
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
    animation: fadeInLeft 3s ease 0.5s forwards;
  }
  .right {
    animation: fadeInRight 3s ease 0.5s forwards;
  }
  .swiper-container {
    width: 100%;
  }
  .enterpriseCon {
    .banner {
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
    .icon-leftarrow {
      position: absolute;
      left: -55px;
      top: 42%;
      font-size: 34px;
      height: 34px;
      color: #d0d0d0;
      //   top: 440px;
    }
    .icon-rightarrow {
      position: absolute;
      right: -55px;
      font-size: 34px;
      height: 34px;
      color: #d0d0d0;
      top: 440px;
      top: 42%;
    }
    .actiAddress {
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
    }
  }
  .policyCenter {
    .paging {
      overflow: hidden;
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
        > li:hover {
          box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.2);
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
    .finnaPro,
    .finnaOrg {
      margin-top: 20px;
      margin-bottom: 70px;

      > ul {
        > li {
          padding: 20px 0;
          border-bottom: 1px solid #eee;

          .orgImg {
            width: 198px;
            height: 128px;

            > img {
              width: 100%;
              height: 100%;
              border-radius: 7px;
            }
          }

          .orgCon {
            margin-left: 20px;
            text-align: left;
            .conTil {
              font-size: 15px;
              color: #222;
              font-weight: bold;
              margin-bottom: 13px;
            }

            .conContent {
              font-size: 12px;

              .left1 {
                width: 300px;

                > p {
                  margin-bottom: 5px;
                }
              }

              .right1 {
                // margin-left: 40px;
                > p {
                  margin-bottom: 5px;
                }

                .el-rate {
                  display: inline-block;
                }

                //   .el-rate__icon{
                //       color:#009f42 !important;
                //   }
              }
            }
          }

          .orgBtn {
            font-size: 13px;
            background: #ecfcf2;
            padding: 6px 20px;
            border: 1px solid #00a041;
            border-radius: 4px;
            margin-top: 50px;
            cursor: pointer;
          }
        }

        // > li:first-child {
        //   padding-top: 10px;
        // }
      }
    }
    // #btns {
    //   margin: 50px 0;
    //   > button:hover {
    //     color: #fff;
    //     background: #00a041;
    //   }
    //   .btn11 {
    //     border-radius: 0;
    //   }
    //   >button.btActive{
    //      color: #fff;
    //     background: #00a041;
    //   }
    // }
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
      .el-card {
        width: 80%;
        margin: 0 auto;
        overflow: visible;
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
          .btn0 {
            border-top-left-radius: 3px;
            border-bottom-left-radius: 3px;
          }
          .btn2 {
            border-top-right-radius: 3px;
            border-bottom-right-radius: 3px;
            border-left: none;
          }
          > button.btnActive {
            color: #fff;
            background: #00a041;
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
            // padding: 20px 50px;
            width: 183px;
            height: 130px;
            > img {
              // width: 83px;
              // height: 90px;
              width: 100%;
              height: 100%;
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
        .detailRes {
          width: 500px;
          position: absolute;
          right: 85px;
          top: 68px;
          text-align: left;
          z-index: 3;
          // height: 300px;
          // overflow: auto;
          box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.5);
          padding: 20px 30px;
          background: #fff;
          .detail {
            margin-bottom: 10px;
            color: #333;
          }
          p {
            font-size: 13px;
          }
          // .el-card__body {
          //   padding: 20px 30px;
          //   // width: 300px;
          // }
        }
      }
      .serverOrgContent {
        margin-top: 20px;
        margin-bottom: 70px;

        > ul {
          > li {
            padding: 20px 0;
            border-bottom: 1px solid #eee;

            .orgImg {
              width: 200px;
              height: 130px;

              > img {
                width: 100%;
                height: 100%;
              }
            }

            .orgCon {
              margin-left: 20px;
              text-align: left;

              .conTil {
                font-size: 15px;
                color: #222;
                font-weight: bold;
                margin-bottom: 30px;
              }

              .conContent {
                font-size: 12px;

                .left1 {
                  width: 300px;

                  > p {
                    margin-bottom: 5px;
                  }
                }

                .right1 {
                  > p {
                    margin-bottom: 5px;
                  }

                  .el-rate {
                    display: inline-block;
                  }
                }
              }
            }

            .orgBtn {
              font-size: 13px;
              background: #ecfcf2;
              padding: 6px 20px;
              border: 1px solid #00a041;
              border-radius: 4px;
              margin-top: 50px;
              cursor: pointer;
            }
          }

          > li:first-child {
            padding-top: 10px;
          }
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
              width: 157px;
              height: 157px;
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
              width: 75px;
              height: 75px;
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
  .demandDia1 {
    background: #ecfcf2;
    padding: 8px 10px;
    width: 80px;
    margin: 0 auto;
    border: 1px solid #00a041;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    color: #00a041;
  }
  .demandLine {
    height: 1px;
    width: 600px;
    position: relative;
    left: -20px;
    background: #eee;
    margin-bottom: 20px;
    margin-top: 10px;
  }
  .demandTextArea {
    .el-textarea__inner {
      background: #fff;
    }
  }
  .serverTip {
    display: inline-block;
    font-size: 12px;
  }
  .demandDia {
    display: inline-block;
    background: #ecfcf2;
    padding: 8px 10px;
    width: 80px;
    margin: 0 auto;
    border: 1px solid #00a041;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    color: #00a041;
    margin-left: 20px;
    font-size: 12px;
  }
}
</style>


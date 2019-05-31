<template>
  <div class="portalIndex">
    <div class="portalCon">
      <div class="banner pr">
        <div class="swiper-container">
          <div class="swiper-wrapper">
            <!-- <div class="swiper-slide swiper-no-swiping" > -->
            <div class="swiper-slide" v-for="(banner, index) in bannerList" :key="index">
              <img :src="banner.posterUrl" alt="">
              <!-- <img src="@/../static/img/c11.png" alt=""> -->
            </div>
            <!-- <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/c11.png" alt="" @click="$router.push({path:'/serMatHp'})">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/c11.png" alt="" @click="$router.push({path:'/serMatHp'})">
            </div>
            <div class="swiper-slide" style="width:100%">
              <img src="@/../static/img/c11.png" alt="" @click="$router.push({path:'/serMatHp'})">
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
              <span>人才申报</span>
              <p>PEOPLE&nbsp;DECLARE</p>
              <img src="@/../static/img/right-arrow.png" alt="">
            </li>
            <li @click="$router.push({path:'/companyProfile'})">
              <span>高新企业</span>
              <p>HIGH-TECH&nbsp;ENTERPRISE</p>
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
      <div class="parkNotice w clearfix" ref="parkNotice" data-class="bottom">
        <div class="noticeTitle">
          <img src="@/../static/img/notice.png" alt="">
        </div>
        <div class="noticeBox">
          <ul class="noticeList" :class="{marquee_top:animate}">
            <li class="pointer" v-for="(i,k) in noticeList" :key="k" @click="$router.push({path:'/announcementDetails',query:{noticeId:i.noticeId}})">{{i.noticeTitle}}</li>
          </ul>
        </div>
        <!-- <span class="pointer" @click="$router.push({path:'/announcementDetails'})">热烈庆祝XXX公司入驻南京白下高新区XXX园区。为实现共创共收打造良好环境基础实现科技人才的引进与推动时代化做出...</span> -->
        <!-- <div class="fr pointer">更多&nbsp;&nbsp;
          <i class="iconfont icon-you"></i>
        </div> -->
      </div>
      <div class="declarationNotice portalNotice pr" ref="portalNotice" data-class="bottom">
        <div class="w">
          <div class="tuoyuan">
            <i class="el-icon-arrow-down"></i>
          </div>
          <div ref="portal1" data-class="bottom">
            <div class="tit color2 pr">
              <div class="pointer" @click="$router.push({path:'/talentsService'})">申报公告</div>
              <div class="titImg" @click="onClick">
                <img src="@/../static/img/huidaodingbu.png" alt="">
              </div>
            </div>
            <div class="eng mainColor pointer" @click="$router.push({path:'/talentsService'})">Declare&nbsp;the&nbsp;announcement</div>
            <div class="line"></div>
          </div>
          <div ref="portal2" id="pn2" data-class="bottom1">
            <div class="btns">
              <button class="btn1">政府扶持</button>
              <button class="btn2" @click="$router.push({path:'/talentsService'})">了解详情</button>
            </div>
            <div class="info clearfix">
              <div class="left fl pr">
                <el-collapse accordion v-model="activeNames" @change="handleChangeName">
                  <el-collapse-item :name="k+1" v-for="(i,k) in declarationNotice" :key="k">
                    <template slot="title">
                      <div class="li1 aa" :class="{'active0':sw==k}">{{'0'+(k+1)}}</div>
                      <span>{{i.noticeTitle}}</span>
                    </template>
                    <div v-html="i.announcementContent">
                    </div>
                  </el-collapse-item>
                  <!-- <el-collapse-item name="1">
                    <template slot="title">
                      <div class="li3 aa" :class="{'active':sw=='0'}">01</div>
                      <span>申报高新技术产品认定,是国家高新技术企业认定的加分项。</span>
                    </template>
                    <div>简化流程：设计简洁直观的操作流程；</div>
                    <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
                    <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
                  </el-collapse-item>
                  <el-collapse-item name="2">
                    <template slot="title">
                      <div class="li3 aa" :class="{'active':sw=='1'}">02</div>
                      <span>申报高新技术产品认定,是国家高新技术企业认定的加分项。</span>
                    </template>
                    <div>简化流程：设计简洁直观的操作流程；</div>
                    <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
                    <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
                  </el-collapse-item>
                  <el-collapse-item name="3">
                    <template slot="title">
                      <div class="li5 aa" :class="{'active':sw=='2'}">03</div>
                      <span>南京市人民政府关于高新区企业资质荣誉申请...</span>
                    </template>
                    <div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
                    <div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
                  </el-collapse-item> -->
                </el-collapse>
              </div>
              <div class="right fl"></div>

            </div>
            <div class="pagination-container">
              <el-pagination :page-sizes="[3, 6, 9, 12]" :page-size="rows1" background layout="prev, pager, next" :total="total1" @size-change="handleSizeChange" @current-change="handleCurrentChange">
              </el-pagination>
            </div>
          </div>
        </div>

      </div>
      <div class="policyGuide" ref="policyGuide" data-class="bottom">
        <div ref="policy1" data-class="bottom1">
          <div class="tit pointer" @click="$router.push({path:'/policyCenter'})">政策指南</div>
          <div class="eng pointer" @click="$router.push({path:'/policyCenter'})">Policy&nbsp;guidelines</div>
          <div class="line"></div>
        </div>
        <div class="fenye fenye1 w pr" ref="policyGuide2" data-class="bottom1">
          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div class="swiper-slide" style="width:100%" v-for="(bannerList, k) in policyCenterList" :key="k">
                <ul class="qiehuan1" id="qiehuan1">
                  <li v-for="(banner, index) in bannerList" :key="index" class="pointer" @click="$router.push({path:'/policyGuide',query:{policyId:banner.policyId}})">
                    <p class="liTit">{{banner.policyTitle}}</p>
                    <p class="liInfo">
                      {{ banner.policyTitle }}
                    </p>
                    <div class="liBom clearfix">
                      <p class="fl">
                        <i class="el-icon-view"></i>&nbsp;{{banner.readNum}}</p>
                      <span class="fr">{{banner.policyLevelName}}</span>
                      <i class="fr">{{banner.policyClassName}}</i>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
            <!-- 如果需要分页器 -->
            <div class="swiper-pagination"></div>

            <!-- 如果需要导航按钮 -->
            <div class="swiper-button-prev" v-if="policyCenterList&&policyCenterList.length>1"></div>
            <div class="swiper-button-next" v-if="policyCenterList&&policyCenterList.length>1"></div>
          </div>
        </div>
      </div>
      <div class="popularActi w" ref="popularActi" data-class="bottom1">
        <div ref="popularActi1" data-class="bottom">
          <div class="tit color2 pointer" @click="$router.push({path:'/actiCenter'})">热门活动</div>
          <div class="eng mainColor pointer" @click="$router.push({path:'/actiCenter'})">Popular&nbsp;activities</div>
          <div class="line"></div>
        </div>
        <div class="acti pr" ref="popularActi2" data-class="bottom1">
          <!-- <div class="swiper-container">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide" style="width:100%"> -->
          <i class="iconfont icon-leftarrow pointer" @click="leftPage"></i>
          <i class="iconfont icon-rightarrow pointer" @click="rightPage"></i>
          <ul class="actiUl clearfix">
            <li v-for="(i,k) in actiListSlim" :key="k">
              <!-- <transition name="fade"> -->
              <!-- <div class="postImgItem" @mouseenter.stop="show1=!show1,show11=!show11" @mouseleave.stop="show1=!show1,show11=!show11"> -->
              <div class="postImgItem" @mouseenter.stop="show1=i.id,show11=i.id" @mouseleave.stop="show1=i.id,show11=i.id">
                <img :src="i.actiPosterUrl" :class="{'poIm':show1==i.id}" class="postImg pointer" alt="活动海报图片">
                <img src="@/../static/img/组 40.png" :class="{'poIm':show11==i.id}" class="postImg1 pointer" alt="活动海报图片" @click="$router.push({ path: '/actiDetail', query: { activityId: i.id } })">
              </div>
              <!-- <div class="postImgItem" >
                                            <img src="@/../static/img/heng1.png" class="postImg" v-if="show1" @mouseenter.stop="showH" alt="活动海报图片">
                                            <img src="@/../static/img/组 40.png" class="postImg" v-else @mouseleave.stop="showY" alt="活动海报图片">
                                        </div> -->
              <!-- </transition> -->
              <div class="actiInfo">
                <p class="actiNameItem">
                  {{i.actiName}}
                </p>
                <p class="actiTimer">
                  <i class="el-icon-time"></i>
                  <span>{{i.actiStartTime}}-{{i.actiEndTime}}</span>
                  <!-- <span>{{item.actiStartTime}}-{{item.actiEndTime.split(' ')[1]}}</span> -->
                  <!-- <span>周日14：00-17：00</span> -->
                </p>
                <p>
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
          </ul>
          <div class="lejieDel pointer" @click="$router.push({path:'/actiCenter'})">了解详情</div>
        </div>
      </div>
      <div class="districtGardens w" ref="districtGardens" data-class="bottom1">
        <div ref="disGardens" data-class="bottom" class="pointer" @click="$router.push({path:'/investment'})">
          <div class="tit color2">一区多园</div>
          <div class="eng mainColor">Area&nbsp;more&nbsp;garden</div>
          <div class="line"></div>
        </div>
        <div class="card pr" ref="disGardens1" data-class="bottom1">
          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div class="swiper-slide" style="width:100%" v-for="(item,index) in CompanyList" :key="index">
                <!-- <i class="iconfont icon-zuo pointer" @click="leftChange1"></i>
          <i class="iconfont icon-you pointer" @click="rightChange2"></i> -->
                <ul class="cardUl">
                  <li v-for="(i,k) in item" :key="k">
                    <el-card>
                      <div class="cardImg pointer" style="width:200px;height:200px" @click.stop="$router.push({ path: 'parkDetails', query: { id : i.id } })">
                        <img :src="i.mainPicture" alt="" style="width:100%;height:100%">
                      </div>
                      <p class="mainColor">{{i.parkName}}</p>
                      <!-- <div>{{i.content}}</div> -->
                    </el-card>
                  </li>
                </ul>
              </div>
            </div>
            <!-- 如果需要分页器 -->
            <div class="swiper-pagination" style="display:none"></div>

            <!-- 如果需要导航按钮 -->
            <div class="swiper-button-prev" v-if="CompanyList.length>1"></div>
            <div class="swiper-button-next" v-if="CompanyList.length>1"></div>
          </div>
          <!-- <div class="arrow">
            <div class="arrow1"></div>
            <div class="arrow2"></div>
          </div> -->
        </div>
      </div>
      <div class="enterpriseinfo w" ref="enterpriseinfo" data-class="bottom1">
        <div ref="enterInfo" data-class="bottom" class="pointer" @click="$router.push({path:'/enterpriseInformation'})">
          <div class="tit color2">企业资讯</div>
          <div class="eng mainColor">Enterprise&nbsp;information</div>
          <div class="line"></div>
        </div>
        <div class="enterPriseCon" ref="enterInfo1" data-class="bottom1">
          <div class="con1" v-for="(i,k) in recruitmentTable" :key="k" v-if="k==0">
            <img :src="i.posterUrl" alt="" style="width:416px;height:232px;">
            <!-- <img src="@/../static/img/图层 4.png" alt=""> -->
            <div class="conTit1 color1">{{i.propagandaTitle}}</div>
            <div class="conInfo">
              <!-- <img src="@/../static/img/图层 4.png" alt=""> -->
              <span>{{i.createdTime}}</span>
            </div>
            <p class="color3 proDetal">
              {{i.propagandaDetails}}
            </p>
            <div class="more pointer" @click="$router.push({ path: 'enterpriseInfoDetails', query: { propagandaId : i.id } })">
              MORE
            </div>
          </div>
          <div class="con2">
            <div class="conT1">
              <div class="conlef1" v-for="(i,k) in recruitmentTable" :key="k" v-if="k>0&&k<3">
                <div style="width:192px;height:108px"><img :src="i.posterUrl" alt="" style="width:100%;height:100%"></div>
                <div class="conTit1 color1">
                  {{i.propagandaTitle}}
                </div>
                <div class="conInfo">
                  <!-- <img src="@/../static/img/图层 9.png" alt=""> -->
                  <span>{{i.createdTime}}</span>
                </div>
                <p class="color3 proDetal">{{i.propagandaDetails}}</p>
                <div class="more pointer" @click="$router.push({ path: 'enterpriseInfoDetails', query: { propagandaId : i.id } })">
                  MORE
                </div>
              </div>
              <!-- <div class="conlef1 conlef2">
                <div style="width:192px;height:108px"><img src="@/../static/img/图层 5.png" alt="" style="width:100%;height:100%"></div>
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
              </div> -->
            </div>
            <div class="conT2">
              <div class="contop1 clearfix" v-for="(i,k) in recruitmentTable" :key="k" v-if="k>2&&k<5">
                <div class="fl">
                  <i></i>
                  <span class="color1" style="text-align:left">{{i.propagandaTitle}}</span>
                  <p>
                    <!-- <img src="@/../static/img/图层 4.png" alt=""> -->
                    <span class="sp1">{{i.createdTime}}</span>
                  </p>
                </div>
                <p class="fr mainColor pointer" @click="$router.push({ path: 'enterpriseInfoDetails', query: { propagandaId : i.id } })">MORE</p>
              </div>
              <!-- <div class="contop1 contop2 clearfix">
                <div class="fl">
                  <i></i>
                  <span class="color1">IOS开发如何轻松搞定导航栏</span>
                  <p>
                    <img src="@/../static/img/图层 4.png" alt="">
                    <span>2019-7-2 10:23</span>
                  </p>
                </div>
                <p class="fr mainColor">MORE</p>
              </div> -->
            </div>
          </div>
        </div>
      </div>
      <div class="academiExchange w" ref="academiExchange" data-class="bottom1">
        <div ref="academiInfo" data-class="bottom" class="pointer" @click="$router.push({path:'/academicExchange'})">
          <div class="tit color4">学术交流&科技成果</div>
          <div class="eng mainColor">Science&nbsp;and&nbsp;technology</div>
          <div class="line"></div>
        </div>
        <div class="academiCon" ref="academiInfo1" data-class="bottom1">
          <ul class="academiUl">
            <li class="pointer" v-for="(i,k) in achievementList" :key="k" @click="$router.push({path:'/academicExchange'})">
              <div class="acaImg">
                <img src="@/../static/img/academic.png" alt="">
              </div>
              <div class="acaContent">
                <div class="conTitle color1">{{i.name}}</div>
                <p class="acontent color2">一句话描述一句话描述一句话描述一句话描述一句话描述一句话描述一句话描述一句话描述一句话描述一句话描述</p>
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="enterprisesPark" ref="enterprisesPark" data-class="bottom1">
        <div ref="enter1" data-class="bottom1" class="pointer" @click="$router.push({path:'/companyProfile'})">
          <div class="tit" style="margin-top:20px">园内企业</div>
          <div class="eng">The&nbsp;park&nbsp;enterprises</div>
          <div class="line"></div>
        </div>
        <div class="enterPark w" ref="enter2" data-class="bottom2">
          <ul ref="enter3">
            <li :ref="i.id" :class="{'bottom2':i.flag}" class="pointer" v-for="(i,k) in companyList1" :key="k" @click="$router.push({path:'/companyProfile',query:{id:i.id}})">
              <div class="li1Div">
                <img :src='"@/../static/img/"+i.id+".png"' alt="">
                <p>{{i.preValue}}</p>
              </div>
            </li>
            <!-- <li ref="li1" data-class="bottom2">
              <div class="li1Div">
                <img src="@/../static/img/云计算.png" alt="">
                <p>云计算</p>
              </div>
            </li>
            <li ref="li2" data-class="bottom3">
              <div class="li1Div">
                <img src="@/../static/img/智能公交.png" alt="">
                <p>智能交通</p>
              </div>
            </li>
            <li ref="li3" data-class="bottom4">
              <div class="li1Div">
                <img src="@/../static/img/文化创意.png" alt="">
                <p>文化创意</p>
              </div>

            </li>
            <li ref="li4" data-class="bottom5">
              <div class="li1Div">
                <img src="@/../static/img/军民融合.png" alt="">
                <p>军民融合</p>
              </div>

            </li>
            <li ref="li5" data-class="bottom5">
              <div class="li1Div">
                <img src="@/../static/img/电子商务.png" alt="">
                <p>电子商务</p>
              </div>

            </li>
            <li ref="li6" data-class="bottom6">
              <div class="li1Div">
                <img src="@/../static/img/工业设计.png" alt="">
                <p>工业设计</p>
              </div>

            </li>
            <li ref="li7" data-class="bottom7">
              <div class="li1Div">
                <img src="@/../static/img/现代服务业.png" alt="">
                <p>现代服务业</p>
              </div>

            </li>
            <li ref="li8" data-class="bottom8">
              <div class="li1Div">
                <img src="@/../static/img/互联网.png" alt="">
                <p>互联网</p>
              </div>

            </li> -->
          </ul>
        </div>
      </div>
      <div class="link w clearfix">
        <h5 class="tit fl">链接:</h5>
        <ul class="linkUl fl clearfix">
          <li>
            <a href="http://49.65.0.116/12345cas/login?service=http%3A%2F%2F49.65.0.116%2Fnjzwfwrx&nsukey=AQQco%2FbD85TPQaQNmfSSOPDaBrhZLXABGuGPn7Lwy0TvAoJHmW58tc8YB2ZyQjAWeTnP0Kxw1pc8yzu3qB1vCsDXLfOnavjwy%2Bx9AercmpzFykXcLIWEEcNXCL0y42GcdlxRk4XYUv0dYKNhybhClDVCP5x%2Fe7t4F%2B5MmUzb65JMOEMr9b7fnQZqLhwizwAgdmMtm3cJLXtHU5bRESEfPw%3D%3D" target="_blank">12345平台</a>
          </li>
          <li class="line"></li>
          <li>
            <a href="http://ids.nanjing.gov.cn:8081/12345/regedit/regedit.html" target="_blank">12345注册</a>
          </li>
          <li class="line"></li>
          <li>
            <a href="http://nj.jszwfw.gov.cn/" target="_blank">办证大厅</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>
  <script>
import swiper from "swiper";
export default {
  data() {
    return {
      animate: false,
      show1: "",
      show11: "",
      show22: false,
      show33: false,
      show2: false,
      show3: false,
      show4: false,
      searchData: "",
      showFF: false,
      activeNames: ["1"],
      sw: "0",
      showBtn: false,
      page1: 1,
      rows1: 3,
      total1: 0,
      declarationNotice: "",
      page2: 1,
      rows2: 4,
      total2: 0,
      policyCenterList: [],
      page3: 1,
      rows3: 3,
      total3: 0,
      actiListSlim: [],
      page4: 1,
      rows4: 5,
      total4: 0,
      recruitmentTable: "",
      page5: 1,
      rows5: 3,
      total5: 0,
      CompanyList: [],
      bannerList: [], //首页轮播图
      noticeList: [],
      timer: "",
      achievementList: [
        { name: "学术交流", content: "" },
        { name: "科技成果", content: "" }
      ],
      companyList1: [],
      showSSSNum: 0,
      clientHeight: this.getClientHeight(),
      comFlag: false
    };
  },
  created() {
    this.timer = setInterval(this.showMarquee, 2000);
  },
  mounted() {
    this.swiperinit();
    window.addEventListener("scroll", this.handleScroll);
    this.gettalentsList();
    Promise.all([
      this.getPolicyCenterList(),
      this.getBannerList(),
      this.getBusinessAdContent()
    ]).then(() => {
      this.swiperinit();
    });
    // this.getPolicyCenterList()
    // .then(this.swiperinit);
    this.getActiList();
    this.getBusinessPromotionList();
    // this.getPropagandaTypeList();//获取宣传类型
    this.getCompanyList();

    this.showNoticeList(); //园区公告滚动
  },
  destroyed() {
    window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
    clearInterval(this.timer);
  },
  methods: {
    showH() {
      this.show1 = true;
      // setTimeout(()=>{
      this.show11 = true;
      // },500)
    },
    showY() {
      this.show11 = false;
      // setTimeout(()=>{
      this.show1 = false;
      // },500)
    },
    //申报公告
    handleChangeName(val) {
      console.log(val);
      if (val == "2") {
        this.sw = "1";
      } else if (val == "3") {
        this.sw = "2";
      } else {
        this.sw = "0";
      }
    },
    swiperinit() {
      // if (this.policyCenterList.length <= 1 ) {
      //   return
      // }
      var mySwiper = new swiper(".swiper-container", {
        direction: "horizontal", // 垂直切换选项
        loop: true, // 循环模式选项
        noSwiping: true,
        // autoplay: true,
        // autoplay: {
        //   delay: 5000,
        // },
        on: {
          click: e => {
            // let url = e.target.dataset.jumpurl;
            // this.bannerJump(url);
            console.log(e);
          }
        },
        observer: true,
        observeParents: true, //修改swiper的父元素时，自动初始化swiper
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
    bannerJump(url) {
      window.location.href = url;
    },
    onClick() {
      document.body.scrollTop = document.documentElement.scrollTop = 0;
    },
    getElementLeft(element) {
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
      let op = this.getElementLeft(this.$refs["enter2"]) - this.clientHeight;
      if (osTop >= op && this.showSSSNum == 0 && this.comFlag) {
        this.animateSSS();
        this.showSSSNum++;
      }
      //   const osTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0; //用于FF
      // console.dir(osTop)
      // const arr = document.getElementsByClassName('.animation-dom')
      for (const key in this.$refs) {
        const top = this.getElementLeft(this.$refs[key]);

        // console.dir(top);
        if (osTop + innerHeight + 300 >= top + 100) {
          const name = this.$refs[key].dataset.class;
          this.$refs[key].classList.add(name);
        }
      }
      if (
        this.getScrollTop() > document.getElementById("header").clientHeight
      ) {
        this.showFF = true;
        this.show4 = false;
      } else {
        this.showFF = false;
      }
      //    if (
      //     this.getScrollTop() > document.getElementById("search_box").clientHeight
      //   ) {
      //     this.show4 = false;
      //   }
      // console.log(this.getScrollTop())HAOhao
      // if (
      //   this.getScrollTop() > document.getElementById("header").clientHeight
      // ) {
      //   this.headFlag = true;
      // } else {
      //   this.headFlag = false;
      // }
    },
    getClientHeight() {
      var clientHeight = 0;
      if (document.body.clientHeight && document.documentElement.clientHeight) {
        var clientHeight =
          document.body.clientHeight < document.documentElement.clientHeight
            ? document.body.clientHeight
            : document.documentElement.clientHeight;
      } else {
        var clientHeight =
          document.body.clientHeight > document.documentElement.clientHeight
            ? document.body.clientHeight
            : document.documentElement.clientHeight;
      }
      return clientHeight;
    },
    //园内企业动画
    animateSSS() {
      let num = 500;
      let _this = this;
      for (let i = 0; i < this.companyList1.length; i++) {
        if (i == 0) {
          _this.companyList1[i].flag = true;
        }
        setTimeout(() => {
          _this.companyList1[i].flag = true;
        }, num * i);
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
    //公告滚动
    showMarquee() {
      this.animate = true;

      setTimeout(() => {
        this.noticeList.push(this.noticeList[0]);
        this.noticeList.shift();
        this.animate = false;
      }, 500);
    },
    //园区公告滚动
    showNoticeList() {
      let _this = this;
      this.api.get({
        url: "showNoticeList",
        data: {
          page: 1,
          rows: 5
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.noticeList = res.data.rows;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //人才服务公告列表
    gettalentsList() {
      let _this = this;
      this.api.get({
        url: "gettalentsList",
        data: {
          sortType: 1,
          page: _this.page1,
          rows: _this.rows1
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
      this.gettalentsList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page1 = val;
      this.gettalentsList();
    },
    //政策指南
    getPolicyCenterList() {
      return new Promise((resolve, reject) => {
        let _this = this;
        this.api.get({
          url: "getPolicyCenterList",
          data: {
            needPage: 1,
            page: _this.page2,
            rows: _this.rows2,
            tableType: "allPolicy",
            policyType: "0"
          },
          callback: function(res) {
            if (res.code == "0000") {
              _this.policyCenterList = _this.formatArr(res.data.rows, 4);
              // let baseArray = res.data.rows;
              // let len = baseArray.length;
              // let n = 4;
              // let lineNum = len % 4 === 0 ? len / 4 : Math.floor(len / 4 + 1);
              // for (let i = 0; i < lineNum; i++) {
              //   let temp = baseArray.slice(i * n, i * n + n);
              //   _this.policyCenterList.push(temp);
              // }
              _this.total2 = res.data.total;
              setTimeout(() => {
                _this.swiperinit();
              }, 0);
              resolve(2);
            } else {
              _this.$message.error(res.result);
            }
          }
        });
      });
    },
    //热门活动
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
    //热门活动左翻页
    leftPage() {
      if (this.page3 <= 1) {
        this.$message.error("已经是第一页了");
        return;
      }
      this.page3--;
      this.getActiList();
    },
    //热门活动右翻页
    rightPage() {
      if (this.page3 >= this.total3) {
        this.$message.error("没有更多数据了");
        return;
      }
      this.page3++;
      this.getActiList();
    },
    // 首页轮播图
    getBannerList() {
      return new Promise((resolve, reject) => {
        this.api.get({
          url: "getPromotionList",
          data: {
            issuePlatform: 2,
            // propagandaType: 'home_banner_pc',//没有图片，暂时先用招商的测试
            propagandaType: "home_banner",
            needPage: 0
          },
          callback: res => {
            if (res.code === "0000") {
              this.bannerList = res.data.rows;
              resolve();
            } else {
              reject();
              this.$message.error(res.result);
            }
          }
        });
      });
    },
    // 企业咨讯  企业宣传列表查询   资讯详情没有返回，日期前边的图标还没确定
    getBusinessPromotionList() {
      let _this = this;
      this.api.get({
        url: "getPromotionList",
        data: {
          page: this.page4,
          rows: this.rows4,
          issuePlatform: 2,
          needPage: "1",
          // approvalStatus: 6,
          propagandaType: "business_news"
          // status: 1
        },
        // dataFlag:true,
        callback: function(res) {
          if (res.code == "0000") {
            _this.recruitmentTable = res.data.rows;
            _this.total4 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    //获取宣传类型
    // getPropagandaTypeList() {
    //   let _this = this;
    //   this.api.get({
    //     url: "getPropagandaTypeList",
    //     data: {},
    //     callback: function(res) {
    //       if (res.code == "0000") {
    //       } else {
    //         _this.$message.error(res.result);
    //       }
    //     }
    //   });
    // },
    // 园内企业--服务超市-机构字典
    getCompanyList() {
      let _this = this;
      this.api.get({
        url: "selectTeamList",
        data: {
          preType: 1
        },
        callback: function(res) {
          if (res.code == "0000") {
            for (let it in res.data) {
              res.data[it].flag = false;
            }
            _this.companyList1 = res.data;
            _this.comFlag = true;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    // 一区多园
    getBusinessAdContent() {
      let _this = this;
      this.api.get({
        url: "getParkList",
        data: {
          // parkId: "576809512829190144",
          // parkId: "570329542049136640",
          // page: _this.page5,
          // rows: _this.rows5
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.CompanyList = _this.formatArr(res.data, 3);
            _this.total5 = res.data.total;
            setTimeout(() => {
              _this.swiperinit();
            }, 0);
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
  .academiExchange {
    .academiCon {
      padding-top: 50px;
    }
    .acaContent {
      margin-left: 20px;
      overflow: hidden;
      .conTitle {
        font-size: 16px;
      }
    }
    .academiUl {
      display: flex;
      align-items: center;
      justify-content: space-between;
      flex-wrap: wrap;
      li {
        padding: 20px;
        width: 45%;
        // margin-bottom: 30px;
        box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
        border-radius: 4px;
        border: 1px solid #ebeef5;
        transition: 0.3s;
        display: flex;
        justify-content: space-between;
        text-align: left;
        transition: transform 0.2s;
      }
      > li:hover {
        transform: translateY(-20px);
        box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.2);
      }
      .acontent {
        font-size: 13px;
        margin-top: 20px;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 5;
        overflow: hidden;
        height: 85px;
      }
    }
  }
  #pn2 {
    .btn1 {
      color: #fff;
      background: #00a041;
    }
  }
  .link {
    margin-bottom: 20px;
    font-size: 13px;
    .tit {
      font-size: 13px;
    }
    .linkUl {
      li {
        float: left;
        padding: 0 20px;
        border-right: 1px solid #999;
        a {
          color: #333;
          cursor: pointer;
        }
        a:hover {
          text-decoration: underline;
        }
      }
      // .line{
      //   width: 1px;
      //   height: 10px;
      //   background: #999;
      //   margin:0 20px;
      //   line-height: 10px;
      // }
      li:last-child {
        border: none;
      }
    }
  }
  .portalCon {
    .portalNotice,
    .policyGuide,
    .popularActi,
    .districtGardens,
    .enterpriseinfo,
    .enterprisesPark {
      opacity: 0;
    }
  }
  .enterPark {
    // li {
    //   opacity: 0;
    // }
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
  .bottom9 {
    animation: fadeInUp 1s ease 4.5s forwards;
  }
  // .portalIndexImg {
  //   position: fixed;
  //   z-index: 99;
  //   width: 100%;
  //   .headerw {
  //     background: #fff;
  //     border-bottom: 1px solid #eee;
  //     box-shadow: 0 10px 10px -10px #ccc;
  //     color: #666;
  //     #nav,
  //     .headerRight {
  //       color: #666;
  //       li {
  //         a {
  //           color: #666;
  //         }
  //       }
  //       li:nth-child(1) {
  //         background: none;
  //         border-radius: none;
  //         a {
  //           color: #00a041;
  //         }
  //       }
  //       li:hover {
  //         background: none;
  //       }
  //       li:hover a {
  //         color: #00a041;
  //       }
  //     }
  //   }
  //   .search_box {
  //     background: rgba(0, 0, 0, 0.3);
  //     .el-input-group {
  //       border-radius: 28px;
  //       width: 42%;
  //       margin: 43px 0;
  //       .el-input {
  //         width: 94px;
  //       }
  //       .el-input__inner:focus {
  //         border-color: #00a041;
  //       }
  //       .el-input-group__append,
  //       .el-input-group__prepend {
  //         border-radius: 28px;
  //       }
  //       .el-input-group__append {
  //         /* border-top-left-radius: 0;
  //       border-bottom-left-radius: 0; */
  //         background: #00a041;
  //         color: #fff;
  //         right: 58px;
  //         .el-button {
  //           margin: -10px -10px;
  //         }
  //       }
  //       .el-input-group__prepend {
  //         border-top-right-radius: 0;
  //         border-bottom-right-radius: 0;
  //         background-color: #fff;
  //         padding: 0px 17px 0 9px;
  //         input {
  //           color: #666666;
  //           text-align: right;
  //         }
  //       }
  //     }
  //     .input-with-select .el-input__inner {
  //       border-top-left-radius: 19px;
  //       border-bottom-left-radius: 19px;
  //       border: 1px solid #00a041;
  //     }
  //   }
  //   .searchbox {
  //     background: #fff;
  //     box-shadow: 0 10px 10px -10px #ccc;
  //   }
  // }
  .portalCon {
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
    .parkNotice {
      // width: 100%;
      display: flex;
      box-sizing: border-box;
      overflow: hidden;
      height: 50px;
      line-height: 20px;
      align-items: center;
      padding: 0;
      .noticeTitle {
        padding: 0 20px;
        height: 21px;
        // width: 80px;
        font-size: 14px;
        align-items: center;
        // background: url("../../static/img/notice.png") 100% 100% / 100% 100% no-repeat;
      }
      .noticeBox {
        display: block;
        position: relative;
        width: 60%;
        height: 30px;
        overflow: hidden;
      }
      .noticeList {
        display: block;
        position: absolute;
        top: 0;
        left: 0;
      }
      .marquee_top {
        transition: all 0.5s;
        margin-top: -30px;
      }
      .noticeList li {
        height: 30px;
        line-height: 30px;
        font-size: 14px;
        padding-left: 20px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
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
      margin-right: 22px;
      vertical-align: middle;
      background-color: rgba(255, 255, 255, 0.2);
      .liTit {
        font-size: 16px;
        text-align: center;
        height: 42px;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
        overflow: hidden;
      }
      .liInfo {
        margin: 40px 0 50px 0;
        height: 65px;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 4;
        overflow: hidden;
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
      .el-collapse-item__arrow {
        display: none;
      }
    }
  }
  .policyGuide {
    .swiper-container {
      padding-bottom: 60px;
    }
    // .swiper-pagination-bullet {
    //   background: red;
    // }
    // .swiper-pagination-bullet-active {
    //   background: #fff;
    // }
    .swiper-pagination-bullet {
      //   display: block;
      margin-bottom: 10px;
      opacity: 1;
      background: #97ecc8;
    }
    .swiper-pagination-bullet-active {
      background: #fff;
      //   height: 65px;
      border-radius: 4px;
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
        top: 48%;
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
  }

  .districtGardens {
    .icon-zuo {
      position: absolute;
      left: 6%;
      top: 42%;
      font-size: 34px;
      height: 34px;
      color: #d0d0d0;
      border: none;
      //   top: 440px;
    }
    .icon-you {
      position: absolute;
      right: 6%;
      font-size: 34px;
      height: 34px;
      color: #d0d0d0;
      top: 42%;
      border: none;
    }
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
      .proDetal {
          height: 32px;
          display: -webkit-box;
          -webkit-box-orient: vertical;
          -webkit-line-clamp: 2;
          overflow: hidden;
        }
        .conTit1{
          height: 40px;
          display: -webkit-box;
          -webkit-box-orient: vertical;
          -webkit-line-clamp: 2;
          overflow: hidden;
        }
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


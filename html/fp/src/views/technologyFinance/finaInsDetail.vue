<template>
  <div class="finaInsDetail w">
    <div class="serverOrgMenu color2">
      <span class="pointer" @click="$router.push({path:'/tfindex'})">首页/</span>
      <span class="pointer" @click="$router.push({path:'/finaInstitution'})">金融机构</span>
      <span>/</span>
      <span class="mainColor agent">金融机构详情</span>
    </div>
    <div class="agentInfo">
      <el-card>
        <div class="agent1 clearfix">
          <div class="agentTil fl color1">{{serverOrgDetailList.orgName}}</div>
          <div class="orgBtn fr mainColor pointer" @click="onlineContat(serverOrgDetailList.orgAccount,serverOrgDetailList.orgName)">在线联系</div>
        </div>
        <div class="agent2 clearfix pr color2">
          <div class="agentImg fl">
            <img :src="serverOrgDetailList.orgLogo" alt="">
            <!-- <img v-else src="@/../static/img/product.png" alt=""> -->
          </div>
          <div class="agent2Info fl color2">
            <p>客户偏好：
              <span v-for="(item1,k1) in serverOrgDetailList.developmentStage" :key="k1">{{item1.orgTraitName}},</span>
              <span v-for="(item2,k2) in serverOrgDetailList.industrySector" :key="k2+item2">{{item2.orgTraitName}}</span>
            </p>
            <p>业务擅长：{{serverOrgDetailList.orgSpeciality}}</p>
            <p>咨询电话：
              <span class="mainColor">{{serverOrgDetailList.orgPhone}}</span>
            </p>
            <p>公司地址：{{serverOrgDetailList.orgAddress}}</p>
            <p class="lastP color3">
              <span>交易量：{{serverOrgDetailList.transactionCount}}</span>
              <span>浏览：{{serverOrgDetailList.orgShow}}</span>
              <span>服务评分：{{serverOrgDetailList.orgServiceScore}}</span>
            </p>
          </div>
        </div>
      </el-card>
    </div>
    <div class="agentDel">
      <div class="agentDelTit">机构详情</div>
      <div class="agentDelCon pr color1">
        <div class="mainColor shouqi pointer" v-if="zankaiFlag" @click='zankaiFlag=!zankaiFlag'>
          收起
          <i class="el-icon-arrow-up"></i>
        </div>
        <div class="mainColor shouqi zhankai pointer" v-else @click='zankaiFlag=!zankaiFlag'>
          展开
          <i class="el-icon-arrow-down"></i>
        </div>
        <el-card>
          <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="基本信息" name="baseInfo">
              <div class="basicInfo" v-if="zankaiFlag">
                <table class="table-orgspace mainBorder">
                  <tr>
                    <td class="table-orgspace-title">业务领域：</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div>{{serverOrgDetailList.businessTypeName}}</div>
                    </td>
                    <td class="table-orgspace-title">公司网址：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div>
                        <a :href="serverOrgDetailList.orgWeb" target="_blank" class="mainColor">{{serverOrgDetailList.orgWeb}}</a>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">主营业务：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div v-html="serverOrgDetailList.orgBusiness"></div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">机构简介：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col">{{serverOrgDetailList.orgSynopsis}}</div>
                    </td>
                  </tr>
                </table>
              </div>
            </el-tab-pane>
            <el-tab-pane label="工商信息" name="businessinfo">
              <div class="businessinfo" v-if="zankaiFlag">
                <table class="table-orgspace mainBorder">
                  <!-- <tr>
                    <td class="table-orgspace-title">组织代码机构：</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div>{{serverOrgDetailList.orgCode}}</div>
                    </td>
                    <td class="table-orgspace-title">类型：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div>
                        <a href="http://www.szzhonghe.com/" target="_blank">{{serverOrgDetailList.orgBusinType}}</a>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">经营状态：</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div v-if="serverOrgDetailList.operateStatus=='0'">冻结</div>
                      <div v-if="serverOrgDetailList.operateStatus=='1'">正常户</div>
                    </td>
                    <td class="table-orgspace-title">成立时间：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div>
                        <div>{{serverOrgDetailList.orgRegisterTime}}</div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">法人/主要负责人：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col">{{serverOrgDetailList.orgPrincipal}}</div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">经营场所：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col">{{serverOrgDetailList.orgBusinAddresse}}</div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">经营范围：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col">{{serverOrgDetailList.orgBusinScope}}</div>
                    </td>
                  </tr> -->
                  <tr>
                    <td class="table-orgspace-title">营业执照：</td>
                    <td class="table-orgspace-detail" colspan="6">
                      <div class="table-orgspace-col businessImg"><img :src="serverOrgDetailList.orgLicensesUrl" alt=""></div>
                    </td>
                  </tr>
                </table>
              </div>
            </el-tab-pane>
            <el-tab-pane label="荣誉资质" name="honor">
              <div class="honor clearfix" v-if="zankaiFlag">
                <ul>
                  <li class="" v-for="(i,k) in serverOrgDetailList.honorLicense" :key="k">
                    <div class="honorImg"><img :src="i.fileUrl" alt=""></div>
                    <div class="dataCircle"><img src="@/../static/img/yuandian.png" alt=""></div>
                    <div class="honorTime">{{i.awardTime}}获得</div>
                    <div class="honorName">{{i.certName}}
                      <p>颁发部门：{{i.awardDepart}}</p>
                    </div>
                  </li>
                </ul>
              </div>
            </el-tab-pane>
            <el-tab-pane label="团队信息" name="teamInfo">
              <div class="teamInfo" v-if="zankaiFlag">
                <div class="contact-detail-title">
                  <div class="contact-title">
                    <span class="contact-detail-img mr5"></span>人员结构
                  </div>
                  <table class="table-orgspace mainBorder">
                    <tbody>
                      <tr>
                        <td class="table-orgspace-title" width="120px;">员工人数：</td>
                        <td class="table-orgspace-detail" width="300px">{{serverOrgDetailList.staffCount}}</td>
                        <td class="table-orgspace-title" width="120px;">执业人员人数：</td>
                        <td class="table-orgspace-detail" style="width:322px;">{{serverOrgDetailList.professionNum}} （占比{{(Number(serverOrgDetailList.professionNum/serverOrgDetailList.staffCount)*100).toFixed(0)}}%）
                        </td>
                      </tr>
                      <tr>
                        <td class="table-orgspace-title">本科：</td>
                        <td class="table-orgspace-detail">{{serverOrgDetailList.bachelorNum}}（占比{{(Number(serverOrgDetailList.bachelorNum/serverOrgDetailList.staffCount)*100).toFixed(0)}}%）
                        </td>
                        <td class="table-orgspace-title">硕士：</td>
                        <td class="table-orgspace-detail">{{serverOrgDetailList.masterNum}} （占比{{(Number(serverOrgDetailList.masterNum/serverOrgDetailList.staffCount)*100).toFixed(0)}}%）
                        </td>
                      </tr>
                      <!-- <tr>
                        <td class="table-orgspace-title">博士：</td>
                        <td class="table-orgspace-detail">
                          {{serverOrgDetailList.doctorNum}}（占比{{(Number(serverOrgDetailList.doctorNum/serverOrgDetailList.staffCount)*100).toFixed(0)}}%）
                        </td>
                        <td class="table-orgspace-title">海归：</td>
                        <td class="table-orgspace-detail">
                          {{serverOrgDetailList.returneeNum}}（占比{{(Number(serverOrgDetailList.returneeNum/serverOrgDetailList.staffCount)*100).toFixed(0)}}%）
                        </td>
                      </tr> -->
                      <tr>
                        <td class="table-orgspace-title">博士：</td>
                        <td class="table-orgspace-detail" colspan="4">
                          <div class="table-orgspace-col">{{serverOrgDetailList.doctorNum}}（占比{{(Number(serverOrgDetailList.doctorNum/serverOrgDetailList.staffCount)*100).toFixed(0)}}%）</div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div class="contact-detail-title  mt20">
                  <div class="contact-title">
                    <span class="contact-detail-img mr5"></span>核心团队
                  </div>
                  <table class="table-orgspace mainBorder">
                    <tbody>
                      <tr>
                        <td class="table-orgspace-title" width="120px;">姓名</td>
                        <td class="table-orgspace-title" width="120px;">职务</td>
                        <td class="table-orgspace-title" width="120px;">从业年限</td>
                        <td class="table-orgspace-title" width="220px;">资质</td>
                        <td class="table-orgspace-title" width="260px;">业务特长</td>
                      </tr>
                      <tr v-for="(i,k) in serverOrgDetailList.orgTeams" :key="k">
                        <td class="table-orgspace-detail">{{i.conName}}</td>
                        <td class="table-orgspace-detail">
                          <div class="table-orgspace-col">{{i.conPosition}}</div>
                        </td>
                        <td class="table-orgspace-detail">{{i.conTime}}</td>
                        <td class="table-orgspace-detail">
                          <div class="table-orgspace-col">{{i.conQuali}}</div>
                        </td>
                        <td class="table-orgspace-detail">
                          <div class="table-orgspace-col">{{i.conSpeciality}}</div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="联系信息" name="contactInfo">
              <div class="contactInfo" v-if="zankaiFlag">
                <div class="contact-detail-title">
                  <div class="contact-title">
                    <span class="contact-detail-img mr5"></span>联系人信息
                  </div>
                  <table class="table-orgspace">
                    <tbody>
                      <tr>
                        <td class="table-orgspace-title ta_c" width="60px;">姓名：</td>
                        <td class="table-orgspace-detail" width="120px">{{serverOrgDetailList.conName}}</td>
                        <td class="table-orgspace-title ta_c" width="60px;">职务：</td>
                        <td class="table-orgspace-detail" width="120px">{{serverOrgDetailList.position}}</td>
                        <td class="table-orgspace-title ta_c" width="60px;">手机：</td>
                        <td class="table-orgspace-detail">{{serverOrgDetailList.conPhone}}</td>
                        <td class="table-orgspace-title ta_c" width="60px;word-break:break-all;">邮箱：</td>
                        <td class="table-orgspace-detail" style="word-break: break-all;">
                          <div class="table-orgspace-col">{{serverOrgDetailList.conEmail}}</div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div class="contact-detail-title mt20">
                  <div class="contact-title">
                    <span class="contact-detail-img mr5"></span>电话/地址
                  </div>
                  <table class="table-orgspace">
                    <tbody>
                      <tr>
                        <td class="table-orgspace-title" style="width:90px;">服务热线：</td>
                        <td class="table-orgspace-detail">{{serverOrgDetailList.orgPhone}}</td>
                      </tr>
                      <tr>
                        <td class="table-orgspace-title">办公地址：</td>
                        <td class="table-orgspace-detail" style="line-height: 25px;">
                          <p>{{serverOrgDetailList.orgAddress}}</p>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>

            </el-tab-pane>
          </el-tabs>
        </el-card>
      </div>
    </div>

    <div class="agentCon">
      <div class="agentFil mainBorder">
        <ul class="select-list clearfix" v-if="showFlag1">
          <li>
            <a href="javascript:;">筛选：</a>
          </li>
          <li class="list-item current" :class="{'active3':flag1==''}" @click="screenPro('')">
            <a href="javascript:;" data="%" v-if="serverPro.length>0">全部({{serverPro[0].serviceTotal}})</a>
            <a href="javascript:;" data="%" v-else>全部(0)</a>
          </li>
          <li class="list-item " :class="{'active3':flag1=='0'}" @click="screenPro('0')">
            <a href="javascript:;" data="常规服务" v-if="serverPro.length>0">常规服务({{serverPro[0].commonTotal}})</a>
            <a href="javascript:;" data="%" v-else>常规服务(0)</a>
          </li>
          <li class="list-item " :class="{'active3':flag1=='1'}" @click="screenPro('1')">
            <a href="javascript:;" data="特色服务" v-if="serverPro.length>0">特色服务({{serverPro[0].featureTotal}})</a>
            <a href="javascript:;" data="%" v-else>特色服务(0)</a>
          </li>
        </ul>
        <ul class="select-list clearfix" v-if="showFlag2">
          <li>
            <a href="javascript:;">筛选：</a>
          </li>
          <li class="list-item current" :class="{'active3':flag3==''}" @click="screenEva('')">
            <a href="javascript:;" data="%">全部({{evaCount.evaluationTotal}})</a>
          </li>
          <li class="list-item " :class="{'active3':flag3=='praise'}" @click="screenEva('praise')">
            <a href="javascript:;">好评({{evaCount.praiseNum}})</a>
          </li>
          <li class="list-item " :class="{'active3':flag3=='average'}" @click="screenEva('average')">
            <a href="javascript:;">中评({{evaCount.averageNum}})</a>
          </li>
          <li class="list-item " :class="{'active3':flag3=='badReview'}" @click="screenEva('badReview')">
            <a href="javascript:;">差评({{evaCount.badReviewNum}})</a>
          </li>
        </ul>
        <ul class="select-list clearfix" v-if="showFlag4">
          <li>
            <a href="javascript:;">筛选：</a>
          </li>
          <li class="list-item current" :class="{'active3':flag4=='0'}" @click="screenActi('0')">
            <a href="javascript:;" v-if="serverActiList.length>0">全部({{serverActiList[0].actiNum}})</a>
            <a href="javascript:;" v-else>全部(0)</a>
          </li>
          <li class="list-item " :class="{'active3':flag4=='1'}" @click="screenActi('1')">
            <a href="javascript:;" v-if="serverActiList.length>0">最近一周({{serverActiList[0].weekNum}})</a>
            <a href="javascript:;" v-else>最近一周(0)</a>
          </li>
          <li class="list-item " :class="{'active3':flag4=='2'}" @click="screenActi('2')">
            <a href="javascript:;" v-if="serverActiList.length>0">最近一月({{serverActiList[0].monthNum}})</a>
            <a href="javascript:;" v-else>最近一月(0)</a>
          </li>
        </ul>
      </div>
      <el-tabs v-model="activeName1" @tab-click="handleSerpro" ref="tabP">
        <el-tab-pane name="serverPro">
          <span slot="label" v-if="serverPro.length>0">服务产品({{total1}})</span>
          <span slot="label" v-else>服务产品(0)</span>
          <div class="serverPro">
            <ul class="list-imgleft">
              <li class="list-item pr clearfix" v-for="(i,k) in serverPro" :key='k'>
                <!-- 上架时间 begin -->
                <div class="list-item-date"></div>
                <!-- 上架时间 end -->
                <!-- 左侧logo begin-->
                <div class="list-imgleft-container product nopic pointer fl" @click="$router.push({ path: 'finaProDetail', query: { productId: i.productId } })">
                  <img v-if="i.pictureUrl" :src="i.pictureUrl" alt="">
                  <img v-else src="@/../static/img/product.png" alt="">
                </div>
                <!-- 左侧logo end-->
                <!-- 中间信息 beign -->
                <div class="list-info-middle inner-product pointer fl" @click="$router.push({ path: 'finaProDetail', query: { productId: i.productId } })">
                  <!-- 中间上半部分--标题和标签 begin -->
                  <div class="list-info-top-title">
                    <!-- 头部 begin -->
                    <div class="info-top">
                      <div class="top-title inner-product">
                        <span>{{i.productName}}</span>
                        <div class="clear"></div>
                      </div>
                    </div>
                  </div>
                  <!-- 中间上半部分--标题和标签 end -->
                  <!-- 中间下半部分--参考信息、交易均价和交易 begin -->
                  <div class="list-info-bottom-detail clearfix">
                    <!-- 参考信息、交易均价 begin -->
                    <div class="detail-contact inner-product">
                      <div class="search_area text-of" title="王振英 , 包美芬 , 高凤清">顾&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;问：{{i.advisorName}}</div>
                      <div class="text-of mt5">参考价格：{{i.referPrice}}元</div>
                      <div>累计
                        <span class="mainColor">{{i.transactionsNumber}}</span>&nbsp;笔交易</div>
                    </div>
                    <!-- 参考信息、交易均价 end -->
                    <!-- 评价 begin -->
                    <div class="detail-evaluate inner-product">
                      <div class="score">
                        <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" style="display:inline-block" score-template="{value}">
                        </el-rate>
                        <span class="c_default b">{{i.evaluationNumber}}</span>
                        <span>条评价</span>
                      </div>
                      <div class="links mt5">
                        {{i.evaluationScore}}分
                      </div>
                    </div>
                    <!-- 评价 end -->
                    <!-- 交易量 begin -->

                    <!-- 交易量 end -->
                  </div>
                  <!-- 中间上半部分--参考信息、交易均价和交易 end -->
                </div>
                <div class="detail-count fr">
                  <div class="orgBtn fr mainColor pointer" @click="demandRaise(i)">提需求</div>
                </div>
                <!-- 中间信息 end -->
                <div class="clear"></div>
              </li>
            </ul>
            <div class="pagination-container">
              <el-pagination background @size-change="handleSizeChange1" @current-change="handleCurrentChange1" :current-page="currentPage1" :page-sizes="[3, 6, 9, 12]" :page-size="row1" layout="total, sizes, prev, pager, next, jumper" :total="total1">
              </el-pagination>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane name="serEvaluation">
          <span slot="label">服务评价({{evaCount.evaluationTotal}})</span>
          <div class="serEvaluation">
            <ul class="list-imgleft">
              <li class="list-item pr clearfix" v-for="(i,k) in serviceRatingList" :key='k'>
                <!-- 左侧logo begin-->
                <div class="list-imgleft-container product nopic fl">
                  <img :src="i.pictureUrl" alt="">
                </div>
                <!-- 左侧logo end-->
                <!-- 中间信息 beign -->
                <div class="list-info-middle inner-product fl">
                  <!-- 中间上半部分--标题和标签 begin -->
                  <div class="list-info-top-title">
                    <!-- 头部 begin -->
                    <div class="info-top">
                      <div class="top-title inner-product">
                        <span>{{i.productName}}</span>
                        <div class="clear"></div>
                      </div>
                    </div>
                  </div>
                  <!-- 中间上半部分--标题和标签 end -->
                  <!-- 中间下半部分--参考信息、交易均价和交易 begin -->
                  <div class="list-info-bottom-detail">
                    <!-- 参考信息、交易均价 begin -->
                    <div class="detail-contact inner-product">
                      <div class="search_area text-of" title="王振英 , 包美芬 , 高凤清">服务专员：{{i.advisorName}}</div>
                      <!-- <div class="text-of mt5">参考价格：1000-10000元</div> -->
                      <span class="evaluate-container">
                        <span class="arrow-container">{{i.evaluationDesc}}</span>
                      </span>
                    </div>
                    <!-- 参考信息、交易均价 end -->
                    <!-- 评价 begin -->
                    <div class="detail-evaluate inner-product">
                      <div class="score">
                        <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" style="display:inline-block" score-template="{value}">
                        </el-rate>
                        <span class="c_default b">1</span>
                        <span>条评价</span>
                      </div>
                      <div class="links mt5">
                        {{i.evaluationScore}}分
                      </div>
                    </div>
                    <!-- 评价 end -->
                  </div>
                  
                  <!-- 中间上半部分--参考信息、交易均价和交易 end -->
                </div>
                  <div class="detail-count fr">
                      <!-- <span>累计
                        <span class="c_default ml5 mr5">40</span>笔交易</span> -->
                      <div class="list-item-info">
                        <p>{{i.evaluationAccount}}</p>
                        <p>{{i.evaluationTime}}</p>
                      </div>
                    </div>
              </li>
            </ul>
            <div class="pagination-container">
              <el-pagination background @size-change="handleSizeChange4" @current-change="handleCurrentChange4" :current-page="currentPage1" :page-sizes="[3, 6, 9, 12]" :page-size="row4" layout="total, sizes, prev, pager, next, jumper" :total="total4">
              </el-pagination>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane name="actiConsultation">
          <span slot="label" v-if="serverActiList.length>0">活动资讯({{serverActiList[0].actiNum}})</span>
          <span slot="label" v-else>活动资讯(0)</span>
          <div class="actiConsultation">
            <ul class="allActiUl clearfix">
              <li v-for="(i,k) in serverActiList" :key='k' class="pointer" @click="$router.push({ path: 'actiDetail', query: { activityId: i.id } })">
                <div class="postImgItem pointer">
                  <img :src="i.actiPosterUrl" class="postImg" alt="活动海报图片">
                </div>
                <div class="actiInfo">
                  <p class="actiNameItem">{{i.actiName}}</p>
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
                      <li v-for="(item,k) in i.avatarList" v-if="k<5" :key='k'><img :src="item" alt=""></li>
                      <!-- <li></li> -->
                    </ul>
                  </div>
                  <i>{{i.actiNum}}/{{i.actiNumber}}</i>
                  <p class="mainColor">
                    <!-- <i class="iconfont icon-xihuan"></i>{{i.actiLike}} -->
                    <img src="@/../static/img/xin.png" alt="" style="margin-right:0">
                    <span>{{i.actiLike}}</span>
                  </p>
                </div>
              </li>
            </ul>
            <div class="pagination-container">
              <el-pagination background @size-change="handleSizeChange3" @current-change="handleCurrentChange3" :current-page="currentPage1" :page-sizes="[4, 8, 12, 16]" :page-size="row3" layout="total, sizes, prev, pager, next, jumper" :total="total3">
              </el-pagination>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
    <!-- 提需求弹框 -->
    <template v-if="serverConVisible">
      <el-dialog :visible.sync="serverConVisible" width="530px" top="30vh" :modal-append-to-body=false>
        <div v-if="islogin">
          <el-form ref="financialProform" :model="serverProform" label-position="right" label-width="100px" style="max-width:436px;">
            <el-form-item label="需求描述:" prop="requireDetail" style="font-size:13px">
              <el-input v-model.trim="serverProform.requireDetail" class="demandTextArea" :rows="4" type="textarea" placeholder="可不填" maxlength="100" clearable/>
            </el-form-item>
          </el-form>
          <div class="demandLine"></div>
          <div class="serverTip mainColor">市场提醒：请务必在线订购，线下交易无法享受市场交易安全保障</div>
          <div class="demandDia11" @click="demandDia()">提交需求</div>
        </div>
        <div v-else class="loginTip">
          你还未
          <span class="mainColor pointer" @click="goLogin">登录</span>
          /
          <span class="mainColor pointer" @click="$router.push({path:'/register'})">注册</span>
          企业账号
        </div>
      </el-dialog>
    </template>
    <template v-if="concatVisible">
      <el-dialog :visible.sync="concatVisible" width="530px" top="30vh" :modal-append-to-body=false :lock-scroll="false">
        <div class="loginTip">
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
export default {
  data() {
    return {
      islogin: true,
      concatVisible: false,
      serverConVisible: false,
      zankaiFlag: true,
      activeName1: "serverPro",
      activeName: "baseInfo",
      serverOrgDetailList: {},
      serverPro: [
        // {
        //   serviceTotal: "",
        //   commonTotal: "",
        //   featureTotal
        // }
      ],
      currentPage1: 1,
      row1: 3,
      page1: 1,
      total1: 0,
      serviceConsultant: [],
      serverActiList: [],
      row3: 4,
      page3: 1,
      total3: 0,
      serviceRatingList: [],
      row4: 3,
      page4: 1,
      total4: 0,
      evaCount: {},
      showFlag1: true,
      showFlag2: false,
      showFlag4: false,
      flag4: "0",
      flag1: "",
      flag3: "",
      serverProform: {
        requireDetail: "",
        productId: "",
        productName: ""
      },
      productType: "",
      timeInterval: "0",
      ratingType: ""
    };
  },
  created() {
    this.initList();
    this.findOrgCountProductList();
    this.selActiList();
    this.getServiceRatingInfo();
    this.getEvaluationCountInfo();
  },
  methods: {
    goLogin() {
      window.sessionStorage.setItem("PresetRoute", this.$route.fullPath);
      this.$router.push({ path: "/login" });
    },
    //判断是否登录
    isLogin() {
      if (!this.getToken()) {
        this.islogin = false;
      }
    },
    //在线联系
    onlineContat(investorAccount, investorName) {
      if (!this.getUserInfo()) {
        this.concatVisible = true;
        return;
      }
      this.$router.push({
        path: "/chat",
        query: {
          fromUser: JSON.parse(this.getUserInfo()).account,
          toUser: orgAccount,
          nickName: ogeName
        }
      });
    },
    //提需求
    demandRaise(i) {
      this.isLogin();
      this.serverConVisible = true;
      this.serverProform.productId = i.productId;
      this.serverProform.productName = i.productName;
    },
    demandDia() {
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
            if (_this.serverProform.requireDetail == "") {
              _this.serverConVisible = false;
              return;
            } else {
              _this.$message.success("提交需求成功");
              _this.serverConVisible = false;
            }
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    screenPro(i) {
      //服务产品筛选
      (this.productType = i),
        (this.flag1 = i),
        (this.page1 = 1),
        this.findOrgCountProductList();
    },
    screenEva(i) {
      //筛选评价
      (this.ratingType = i),
        (this.flag3 = i),
        (this.page4 = 1),
        this.getServiceRatingInfo();
    },
    screenActi(i) {
      //筛选活动
      (this.timeInterval = i),
        (this.flag4 = i),
        (this.page3 = 1),
        this.selActiList();
    },
    handleSerpro(tab, event) {
      if (tab.name == "serEvaluation") {
        this.showFlag1 = false;
        this.showFlag2 = true;
        this.showFlag4 = false;
      } else if (tab.name == "actiConsultation") {
        this.showFlag2 = false;
        this.showFlag1 = false;
        this.showFlag4 = true;
      } else {
        this.showFlag2 = false;
        this.showFlag1 = true;
        this.showFlag4 = false;
      }
    },
    handleSizeChange1(val) {
      //改变每页显示多少条的回调函数
      this.row1 = val;
      this.page1 = 1;
      this.findOrgCountProductList();
    },
    handleCurrentChange1(val) {
      //改变当前页码的回调函数
      this.page1 = val;
      this.findOrgCountProductList();
    },
    handleSizeChange3(val) {
      //改变每页显示多少条的回调函数
      this.row3 = val;
      this.page3 = 1;
      this.selActiList();
    },
    handleCurrentChange3(val) {
      //改变当前页码的回调函数
      this.page3 = val;
      this.selActiList();
    },
    handleSizeChange4(val) {
      //改变每页显示多少条的回调函数
      this.row4 = val;
      this.page4 = 1;
      this.getServiceRatingInfo();
    },
    handleCurrentChange4(val) {
      //改变当前页码的回调函数
      this.page4 = val;
      this.getServiceRatingInfo();
    },
    handleClick(tab, event) {
      // console.log(tab, event);
    },
    getEvaluationCountInfo() {
      //服务评价统计信息
      let _this = this;
      this.api.get({
        url: "getEvaluationCountInfo",
        data: {
          orgId: _this.$route.query.orgId,
          // orgId: "1001211",
          needPage: 1,
          isPublicPage: 0,
          page: _this.page4,
          rows: _this.row4
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.evaCount = res.data;
            setTimeout(() => {
              _this.$refs["tabP"].$children[0].$forceUpdate();
            }, 0);
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    getServiceRatingInfo() {
      //服务评价
      let _this = this;
      this.api.get({
        url: "getServiceRatingInfo",
        data: {
          orgId: _this.$route.query.orgId,
          // orgId: "1001211",
          needPage: 1,
          isPublicPage: 0,
          page: _this.page4,
          rows: _this.row4,
          ratingType: _this.ratingType
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serviceRatingList = res.data.rows;
            _this.total4 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    selActiList() {
      //活动资讯
      let _this = this;
      this.api.get({
        url: "selActiList",
        data: {
          // actiType: "org_activity",
          page: _this.page3,
          rows: _this.row3,
          timeInterval: _this.timeInterval
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverActiList = res.data.rows;
            _this.total3 = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    findOrgCountProductList() {
      //机构详情-服务产品
      let _this = this;
      this.api.get({
        url: "findOrgCountProductList",
        data: {
          orgd: _this.$route.query.orgId,
          page: _this.page1,
          rows: _this.row1,
          productType: _this.productType
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverPro = res.data.rows;
            _this.total1 = res.data.total;
            setTimeout(() => {
              _this.$refs["tabP"].$children[0].$forceUpdate();
            }, 0);
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    initList() {
      let _this = this;
      this.api.get({
        url: "getActivityDetailsFm",
        data: {
          orgId: _this.$route.query.orgId
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverOrgDetailList = res.data;
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
.serverOrgDetail {
  .serverPro,
  .serConsultant,
  .serEvaluation,
  .actiConsultation {
    .pagination-container {
      margin-top: 30px;
    }
  }
}
.finaInsDetail {
  .businessinfo {
    .businessImg {
      width: 130px;
      height: 80px;
      display: inline-block;
      vertical-align: middle;

      > img {
        width: 100%;
        height: 100%;
      }
    }
  }
  .serverTip {
    display: inline-block;
    font-size: 12px;
  }
  .el-tabs__item {
    height: 50px;
    line-height: 50px;
  }
  .demandDia11 {
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
  .demandLine {
    height: 1px;
    width: 530px;
    position: relative;
    left: -20px;
    background: #eee;
    margin-bottom: 20px;
    margin-top: 10px;
  }
}
</style>

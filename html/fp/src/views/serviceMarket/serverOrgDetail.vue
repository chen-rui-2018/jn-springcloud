<template>
  <div class="serverOrgDetail w">
    <div class="serverOrgMenu color2">
      <span>首页/</span>
      <span>服务机构</span>
      <span>/</span>
      <span class="mainColor agent">服务机构详情</span>
    </div>
    <div class="agentInfo">
      <el-card>
        <div class="agent1 clearfix">
          <div class="agentTil fl color1">{{serverOrgDetailList.orgName}}</div>
          <div class="orgBtn fr mainColor">在线联系</div>
        </div>
        <div class="agent2 clearfix color2">
          <div class="agentImg fl">
            <!-- <img src="@/../static/img/ins1.png" alt=""> -->
            <img :src="serverOrgDetailList.orgLogo" alt="">
          </div>
          <div class="agent2Info fl color2">
            <p>客户偏好：{{serverOrgDetailList.orgHobby}}</p>
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
        <div class="mainColor shouqi pointer" v-if="zankaiFlag" @click='handleZd'>
          收起
          <i class="el-icon-arrow-up"></i>
        </div>
        <div class="mainColor shouqi zhankai pointer" v-else @click='handleZk'>
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
                      <div>{{serverOrgDetailList.businessType}}</div>
                    </td>
                    <td class="table-orgspace-title">公司网址：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div>
                        <a :href="serverOrgDetailList.orgWeb" target="_blank">{{serverOrgDetailList.orgWeb}}</a>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">主营业务：</td>
                    <td class="table-orgspace-detail" colspan="4">
                      <div class="table-orgspace-col">{{serverOrgDetailList.orgBusiness}}</div>
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
                  <tr>
                    <td class="table-orgspace-title">组织代码机构:</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div>{{serverOrgDetailList.orgCode}}</div>
                    </td>
                    <td class="table-orgspace-title">类型：</td>
                    <td class="table-orgspace-detail" style="width:322px;word-break: break-all;">
                      <div>
                        <!-- <a href="http://www.szzhonghe.com/" target="_blank">http://www.szzhonghe.com/</a> -->
                        {{serverOrgDetailList.orgBusinType}}
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-orgspace-title">经营状态：</td>
                    <td class="table-orgspace-detail" width="300px" colspan="2">
                      <div v-if="serverOrgDetailList.operateStatus==='0'">冻结</div>
                      <div v-if="serverOrgDetailList.operateStatus==='1'">正常户</div>
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
                        <td class="table-orgspace-detail" style="width:322px;">{{serverOrgDetailList.professionNum}}（占比{{(Number(serverOrgDetailList.professionNum/serverOrgDetailList.staffCount)*100).toFixed(2)}}%）
                        </td>
                      </tr>
                      <tr>
                        <td class="table-orgspace-title">本科：</td>
                        <td class="table-orgspace-detail">{{serverOrgDetailList.bachelorNum}}（占比{{(Number(serverOrgDetailList.bachelorNum/serverOrgDetailList.staffCount)*100).toFixed(2)}}%）
                        </td>
                        <td class="table-orgspace-title">硕士：</td>
                        <td class="table-orgspace-detail">{{serverOrgDetailList.masterNum}}（占比{{(Number(serverOrgDetailList.masterNum/serverOrgDetailList.staffCount)*100).toFixed(2)}}%）
                        </td>
                      </tr>
                      <tr>
                        <td class="table-orgspace-title">博士：</td>
                        <td class="table-orgspace-detail">
                          <font>{{serverOrgDetailList.doctorNum}}（占比{{(Number(serverOrgDetailList.doctorNum/serverOrgDetailList.staffCount)*100).toFixed(2)}}%）</font>
                        </td>
                        <td class="table-orgspace-title">海归：</td>
                        <td class="table-orgspace-detail">
                          <font>{{serverOrgDetailList.returneeNum}}（占比{{(Number(serverOrgDetailList.returneeNum/serverOrgDetailList.staffCount)*100).toFixed(2)}}%）</font>
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
          <li class="list-item current" :class="{'active':flag1==''}" @click="screenPro('')" v-if="serverPro.length>0">
            <a href="javascript:;" data="%">全部({{serverPro[0].serviceTotal}})</a>
          </li>
          <li class="list-item " :class="{'active':flag1=='0'}" @click="screenPro('0')" v-if="serverPro.length>0">
            <a href="javascript:;" data="常规服务">常规服务({{serverPro[0].commonTotal}})</a>
          </li>
          <li class="list-item " :class="{'active':flag1=='1'}" @click="screenPro('1')" v-if="serverPro.length>0">
            <a href="javascript:;" data="特色服务">特色服务({{serverPro[0].featureTotal}})</a>
          </li>
        </ul>
        <ul class="select-list clearfix" v-if="showFlag2">
          <li >
            <a href="javascript:;">排序：</a>
          </li>
          <li class="list-item current" :class="{'active':flag2=='integrate'}" @click="screenSerCon('integrate')">
            <a href="javascript:;" >综合</a>
          </li>
          <li class="list-item " :class="{'active':flag2=='popularity'}" @click="screenSerCon('popularity')">
            <a href="javascript:;" >人气</a>
          </li>
          <li class="list-item " :class="{'active':flag2=='praise'}" @click="screenSerCon('praise')">
            <a href="javascript:;">好评</a>
          </li>
          <li class="list-item " :class="{'active':flag2=='serviceNum'}" @click="screenSerCon('serviceNum')">
            <a href="javascript:;" >服务量</a>
          </li>
        </ul>
        <ul class="select-list clearfix" v-if="showFlag3">
          <li>
            <a href="javascript:;">筛选：</a>
          </li>
          <li class="list-item current" :class="{'active':flag3==''}" @click="screenEva('')">
            <a href="javascript:;" data="%">全部({{evaCount.evaluationTotal}})</a>
          </li>
          <li class="list-item " :class="{'active':flag3=='praise'}" @click="screenEva('praise')">
            <a href="javascript:;">好评({{evaCount.praiseNum}})</a>
          </li>
          <li class="list-item " :class="{'active':flag3=='average'}" @click="screenEva('average')">
            <a href="javascript:;">中评({{evaCount.averageNum}})</a>
          </li>
          <li class="list-item " :class="{'active':flag3=='badReview'}" @click="screenEva('badReview')">
            <a href="javascript:;">差评({{evaCount.badReviewNum}})</a>
          </li>
        </ul>
        <ul class="select-list clearfix" v-if="showFlag4">
          <li>
            <a href="javascript:;">筛选：</a>
          </li>
          <li class="list-item current" :class="{'active':flag4=='0'}" @click="screenActi('0')">
            <a href="javascript:;">全部({{serverActiList[0].actiNum}})</a>
          </li>
          <li class="list-item " :class="{'active':flag4=='1'}" @click="screenActi('1')">
            <a href="javascript:;">最近一周({{serverActiList[0].weekNum}})</a>
          </li>
          <li class="list-item " :class="{'active':flag4=='2'}" @click="screenActi('2')">
            <a href="javascript:;">最近一月({{serverActiList[0].monthNum}})</a>
          </li>
        </ul>
      </div>
      <el-tabs v-model="activeName1" @tab-click="handleSerpro">
        <el-tab-pane name="serverPro" >
          <span slot="label">服务产品({{serverPro[0].serviceTotal}})</span>
          <div class="serverPro">
            <ul class="list-imgleft">
              <li class="list-item pr" v-for="(i,k) in serverPro" :key='k'>
                <!-- 上架时间 begin -->
                <div class="list-item-date"></div>
                <!-- 上架时间 end -->
                <!-- 左侧logo begin-->
                <div class="list-imgleft-container product nopic">
                  <img :src="i.pictureUrl" alt="">
                </div>
                <!-- 左侧logo end-->
                <!-- 中间信息 beign -->
                <div class="list-info-middle inner-product">
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
                      <div class="text-of mt5">参考价格：{{i.referPrice}}</div>
                      <div>累计
                        <span class="mainColor">{{i.transactionsNumber}}</span>笔交易</div>
                    </div>
                    <!-- 参考信息、交易均价 end -->
                    <!-- 评价 begin -->
                    <div class="detail-evaluate inner-product">
                      <div class="score">
                        <!-- <el-rate :model="parseInt(i.evaluationScore)" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                      </el-rate> -->
                        <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
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
                    <div class="detail-count">
                      <!-- <span>累计
                        <span class="c_default ml5 mr5">40</span>笔交易</span> -->
                      <div class="orgBtn fr mainColor" @click="demandRaise(i)">提需求</div>
                    </div>
                    <!-- 交易量 end -->
                  </div>
                  <!-- 中间上半部分--参考信息、交易均价和交易 end -->
                </div>
                <!-- 中间信息 end -->
                <div class="clear"></div>
              </li>
            </ul>
            <div class="pagination-container">
              <el-pagination background @size-change="handleSizeChange1" @current-change="handleCurrentChange1" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row1" layout="total,prev, pager, next,sizes" :total="total1">
              </el-pagination>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane  name="serConsultant" >
          <span slot="label">服务顾问({{total2}})</span>
          <div class="serConsultant">
            <ul class="list-imgleft adviser">
              <li class="list-item" v-for="(i,k) in serviceConsultant" :key='k'>
                <!-- 左侧logo begin-->
                <div class="list-imgleft-container noconsultant">
                  <img :src="i.avatar" alt="">
                </div>
                <!-- 左侧logo end-->
                <!-- 中间信息 beign -->
                <div class="list-info-middle inner-consultant">
                  <!-- 中间上半部分--标题和标签 begin -->
                  <div class="list-info-top-title">
                    <!-- 头部 begin -->
                    <div class="info-top">
                      <div class="top-title inner-consultant" onclick="window.open('/epservice/techsub/Apps/epssm/index.php?s=/Home/ConsultantSpace/space/id/86c91e1d-b3ce-11e7-9663-000c29881ee3')">
                        <span>{{i.advisorName}}/{{i.position}}</span>
                        <div class="icons">
                          <!-- 是否认证标签 -->
                        </div>
                        <div class="clear"></div>
                      </div>
                    </div>
                  </div>
                  <!-- 中间上半部分--标题和标签 end -->
                  <!-- 中间下半部分--电话、地址评价和交易 begin -->
                  <div class="list-info-bottom-detail">
                    <!-- 所属机构、电话 begin -->
                    <div class="detail-contact inner-consultant">
                      <div class="text-of">从业年限：
                        <font style="color:#ccc;">{{i.workingYears}}</font>
                      </div>
                      <div class="search_area pt5 text-of" title="">业务擅长：{{i.goodAtBusiness}}</div>
                      <div>累计
                        <span class="mainColor">{{i.transactionNum}}</span>笔交易</div>
                    </div>
                    <!-- 地址、电话 end -->
                    <!-- 评价 begin -->
                    <div class="detail-evaluate inner-consultant">
                      <div class="score">
                        <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                      </el-rate>
                        <span class="c_default b">{{i.evaluationNum}}</span>
                        <span>条评价</span>
                      </div>
                      <div class="links mt5">
                        <div class="links mt5">
                          {{i.evaluationScore}}分
                        </div>
                      </div>
                    </div>
                    <!-- 评价 end -->
                    <!-- 交易量 begin -->
                    <!-- <div class="detail-count">
                      <span>累计交易
                        <span class="c_default ml5 mr5">19</span>笔</span>
                    </div> -->
                    <!-- 交易量 end -->
                  </div>
                  <!-- 中间上半部分--电话、地址评价和交易 end -->
                </div>
                <!-- 中间信息 end -->
                <div class="clear"></div>
              </li>
            </ul>
            <div class="pagination-container">
              <el-pagination background @size-change="handleSizeChange2" @current-change="handleCurrentChange2" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row2" layout="total,prev, pager, next,sizes" :total="total2">
              </el-pagination>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane name="serEvaluation" >
          <span slot="label">服务评价({{evaCount.evaluationTotal}})</span>
          <div class="serEvaluation">
            <ul class="list-imgleft">
              <li class="list-item pr" v-for="(i,k) in serviceRatingList" :key='k'>
                <!-- 上架时间 begin -->
                <div class="list-item-date"></div>
                <!-- 上架时间 end -->
                <!-- 左侧logo begin-->
                <div class="list-imgleft-container product nopic">
                  <img :src="i.pictureUrl" alt="">
                </div>
                <!-- 左侧logo end-->
                <!-- 中间信息 beign -->
                <div class="list-info-middle inner-product">
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
                      <div class="search_area text-of" title="王振英 , 包美芬 , 高凤清">服务顾问：{{i.advisorName}}</div>
                      <!-- <div class="text-of mt5">参考价格：1000-10000元</div> -->
                      <span class="evaluate-container">
                        <span class="arrow-container">{{i.evaluationDesc}}</span>
                      </span>
                    </div>
                    <!-- 参考信息、交易均价 end -->
                    <!-- 评价 begin -->
                    <div class="detail-evaluate inner-product">
                      <div class="score">
                        <!-- <el-rate disabled text-color="#00a041" style="display:inline-block" score-template="{value}">
                        </el-rate> -->
                        <el-rate v-model="i.evaluationScore*1" :colors="['#00a041', '#00a041', '#00a041']" disabled text-color="#00a041" score-template="{value}">
                      </el-rate>
                        <span class="c_default b">1</span>
                        <span>条评价</span>
                      </div>
                      <div class="links mt5">
                        {{i.evaluationScore}}分
                      </div>
                    </div>
                    <!-- 评价 end -->
                    <!-- 交易量 begin -->
                    <div class="detail-count" clearfix>
                      <!-- <span>累计
                        <span class="c_default ml5 mr5">40</span>笔交易</span> -->
                      <div class="list-item-info fr">
                        <p>{{i.evaluationAccount}}</p>
                        <p>{{i.evaluationTime}}</p>
                      </div>
                    </div>
                    <!-- 交易量 end -->
                  </div>
                  <!-- 中间上半部分--参考信息、交易均价和交易 end -->
                </div>
                <!-- 中间信息 end -->
                <div class="clear"></div>
              </li>
            </ul>
            <div class="pagination-container">
              <el-pagination background @size-change="handleSizeChange4" @current-change="handleCurrentChange4" :current-page="currentPage1" :page-sizes="[5, 10, 15, 20]" :page-size="row4" layout="total,prev, pager, next,sizes" :total="total4">
              </el-pagination>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane name="actiConsultation">
          <span slot="label">活动资讯({{total3}})</span>
          <div class="actiConsultation">
            <ul class="allActiUl clearfix">
              <li v-for="(i,k) in serverActiList" :key='k'>
                <div class="postImgItem">
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
                      <!-- <li v-for="(i,k) in item.avatarList" v-if="i<5" :key='k'><img :src="i" alt=""></li> -->
                      <li></li>
                    </ul>
                  </div>
                  <i>{{i.actiNum}}/{{i.actiNumber}}</i>
                  <span class="mainColor">
                    <i class="iconfont icon-xihuan"></i>{{i.actiLike}}</span>
                </div>
              </li>
            </ul>
            <div class="pagination-container">
              <el-pagination background @size-change="handleSizeChange3" @current-change="handleCurrentChange3" :current-page="currentPage1" :page-sizes="[8, 12, 16, 20]" :page-size="row3" layout="total,prev, pager, next,sizes" :total="total3">
              </el-pagination>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
     <!-- 提需求弹框 -->
      <template v-if="serverOrgVisible">
            <el-dialog :visible.sync="serverOrgVisible" width="530px" top="30vh">
                <el-form ref="financialProform" :model="serverProform" label-position="right" label-width="100px" style="max-width:436px;">
                    <el-form-item label="需求描述:" prop="requireDetail" style="font-size:13px">
                        <el-input v-model.trim="serverProform.requireDetail" class="demandTextArea" :rows="4" type="textarea" placeholder="可不填" maxlength="100" clearable/>
                    </el-form-item>
                </el-form>
                <div class="demandLine"></div>
                <div class="serverTip mainColor">市场提醒：请务必在线订购，线下交易无法享受市场交易安全保障</div>
                <div class="demandDia" @click="demandDia()">提交需求</div>
            </el-dialog>
      </template>
  </div>
</template>
<script>
export default {
  data() {
    return {
      zankaiFlag: false,
      activeName: "baseInfo",
      activeName1: "serverPro",
      serverOrgDetailList: {},
      serverOrgVisible:false,
      serverProform: {
        requireDetail: "",
        productId: "",
        productName: ""
      },
      flag1:"",
      flag2:"",
      flag3:"",
      flag4:"0",
      showFlag1:true,
      showFlag2:false,
      showFlag3:false,
      showFlag4:false,
      serverPro: [],
      currentPage1: 1,
      row1: 5,
      page1: 1,
      total1: 0,
      serviceConsultant: [],
      row2: 5,
      page2: 1,
      total2: 0,
      serverActiList: [],
      row3: 8,
      page3: 1,
      total3: 0,
      serviceRatingList: [],
      row4: 5,
      page4: 1,
      total4: 0,
      evaCount:{},
      sortTypes:'',
      ratingType:'',
      timeInterval:'0',
    };
  },
  created() {
    this.initList();
    this.findOrgCountProductList();
    this.getServiceConList();
    this.selActiList();
    this.getServiceRatingInfo();
    this.getEvaluationCountInfo()
  },
  methods: {
     demandRaise(i) { //提需求
      this.serverOrgVisible = true;
      this.serverProform.requireDetail = "";
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
            _this.$message.success("提交需求成功");
            _this.serverOrgVisible = false;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
     screenPro(i){ //服务产品筛选
        this.productType=i,
        this.flag1=i,
        this.page1=1,
        this.findOrgCountProductList();
    },
    screenSerCon(i){ //筛选服务顾问
        this.sortTypes=i,
        this.flag2=i,
        this.page2=1,
        this.getServiceConList();
    },
    screenEva(i){ //筛选评价
        this.ratingType=i,
        this.flag3=i,
        this.page4=1,
        this.getServiceRatingInfo();
    },
    screenActi(i){  //筛选活动
        this.timeInterval=i,
        this.flag4=i,
        this.page3=1,
        this.selActiList()
    },
    handleSerpro(tab, event) {
      if(tab.name=='serConsultant'){
        //  this.getServiceConList()
         this.showFlag2=true
         this.showFlag1=false
         this.showFlag3=false
         this.showFlag4=false
      } else if(tab.name=='serEvaluation'){
        // this.getServiceRatingInfo()
        // this.getEvaluationCountInfo()
         this.showFlag2=false
         this.showFlag1=false
         this.showFlag3=true
         this.showFlag4=false
      } else if(tab.name=='actiConsultation'){
        // this.selActiList()
        this.showFlag2=false
         this.showFlag1=false
         this.showFlag3=false
         this.showFlag4=true
      } else{
        // this.findOrgCountProductList()
         this.showFlag2=false
         this.showFlag1=true
         this.showFlag3=false
         this.showFlag4=false
      }
    },
    handleZk() {
      this.zankaiFlag = true;
    },
    handleZd() {
      this.zankaiFlag = false;
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
    handleSizeChange2(val) {
      //改变每页显示多少条的回调函数
      this.row2 = val;
      this.page2 = 1;
      this.getServiceConList();
    },
    handleCurrentChange2(val) {
      //改变当前页码的回调函数
      this.page2 = val;
      this.getServiceConList();
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
          timeInterval:'0',
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
          ratingType:_this.ratingType,
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
    getServiceConList() {
      //服务顾问
      let _this = this;
      this.api.get({
        url: "getServiceConList",
        data: {
          orgId: _this.$route.query.orgId,
          // orgId: "1001211",
          page: _this.page2,
          rows: _this.row2,
          sortTypes:_this.sortTypes,
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serviceConsultant = res.data.rows;
            _this.total2 = res.data.total;
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
          productType:_this.productType,
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.serverPro = res.data.rows;
            _this.total1 = res.data.total;
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
  .el-textarea__inner:focus {
    outline: 0;
    border-color: #00a041;
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

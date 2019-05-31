<template>
  <div class="enterpriseservice">
    <div class="enterpriseCon">
      <div class="banner pr">
        <div class="swiper-container">
          <div class="swiper-wrapper">
            <div
              v-for="(banner, index) in bannerList"
              :key="index"
              class="swiper-slide"
              style="width:100%">
              <img :src="banner.posterUrl" alt=""/>
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
      <div class="popularActi w" ref="popularActi" data-class="bottom" style="padding-bottom: 20px;">
        <router-link to="/parkProfile">
          <div ref="acti11" data-class="bottom">
            <div class="tit color2">园区概况</div>
            <div class="eng mainColor">PARK PROFILE</div>
            <div class="line"></div>
          </div>
        </router-link>
      </div>
      <div class="flex-center op-0" ref="arrowDown" data-class="bottom">
        <arrow-down line></arrow-down>
      </div>
      <div class="park-info op-0" ref="park-info" data-class="bottom1">
        <div class="park-poster">
          <img src="@/../static/img/investment-profile.png" alt="">
        </div>
        <div class="park-desc">
          <span v-if="!showMore">{{ parkDesc | formatParkDesc}}</span>
          <span v-else>{{ parkDesc }}</span>
<!--          <div v-html="basicHtml"></div>-->
          <more-btn v-if="!showMore" class="more-desc" @click.native="showMore = true"></more-btn>
        </div>
      </div>
      <div class="park-film op-0" ref="park-film" data-class="bottom1">
        <div class="film-desc">
          <div>
            <div class="film-desc-title">视频展示</div>
            <div class="film-desc-subheading">VIDEO DISPLAY</div>
          </div>
          <div class="film-desc-content">南京白下高新技术产业园区位于南京市东部风景秀丽的紫金山脚下，毗邻南京理工大学。园区自2001年成立以来，先后被批准为国家大学科 技园、国家专利产业化试点基开 南京白下高新技术产业园区位于南京市东部风景秀丽的紫金山脚下，毗邻南京理工大学。园区自2001年成立以来，先后被批准为国家大学科 技园、国家专利产业化试点基开 先后被批准为国家大学科技园。</div>
          <div class="square-angle-bg">
            <div class="square-angle">
              <span class="square-angle-l"></span><i class="square-angle-r el-icon-caret-right"></i>
            </div>
          </div>
        </div>
        <div class="film-show">
          <video src="" width="100%" poster="@/../static/img/investment-film.png"></video>
<!--          <img src="@/../static/img/banner11.png" alt="">-->
          <div class="film-play"></div>
          <div class="green-frame"></div>
        </div>
      </div>

      <div class="policyCenter pd-b-n w" ref="policyCenter" data-class="bottom1">
        <router-link to="/investmentPolicy">
          <div ref="poCenter1" data-class="bottom">
            <div class="tit color2 pr">招商政策</div>
            <div class="eng mainColor">INVESTMENT POLICY</div>
            <div class="line"></div>
          </div>
        </router-link>
        <div class="paging w pr" ref="poCenter2" data-class="bottom">
          <div class="swiper-container">
            <div class="swiper-wrapper">
              <div
                v-for="(list, listIndex) in businessAdPolicy"
                :key="listIndex"
                class="swiper-slide"
              >
                <ul class="page1 clearfix" data-class="bottom">
                  <li
                    v-for="(item, index) in list"
                    :key="index"
                    class="pointer"
                    data-class="left"
                    @click="$router.push({path:'/investmentPolicyDetail',query:{ id: item.id }})"
                  >
                    <div class="left1">N</div>
                    <div class="right1">
                      <div class="rightTit color1">{{ item.title }}</div>
<!--                      <p class="investment-card-subtitle color2">中央政府发布国发5号文，进一步扩大对外开放积极利用本土资源与外建立良好的经济贸易往来。为取得经济贸易往来上的进一步突破，中央政</p>-->
                      <p class="investment-card-subtitle color2">{{ item.subTitle }}</p>
                      <div class="liBom clearfix">
                        <p class="fl color3">
                          <i class="el-icon-view"></i>
                          <span>{{ item.viewCount }}</span>
                        </p>
                        <span class="fr gray-tips">{{ item.startTime }}</span>
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
        <div class="districtGardens w" ref="districtGardens" data-class="bottom1">
          <router-link to="/investmentDynamic">
            <div ref="disGardens" data-class="bottom">
              <div class="tit color2">招商动态</div>
              <div class="eng mainColor">MERCHANTS DYNAMIC</div>
              <div class="line"></div>
            </div>
          </router-link>
          <div class="more-garden">
            <div
              v-for="(item, index) in businessAdDynamic"
              :key="index"
              class="more-garden-card"
              @click="$router.push({ path:'/investmentDynamicDetail',query:{ id: item.id } })"
            >
              <div class="more-garden-card-cell">
                <img class="more-garden-img" :src="item.adCover" alt=""/>
                <div class="more-garden-desc">{{ item.title }}</div>
                <div class="more-garden-footer">
                  <span class="more-garden-date">{{ item.startTime }}</span>
                  <more-btn></more-btn>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div v-if="loadingParkList" class="districtGardens w" ref="districtGardens" data-class="bottom1">
          <div ref="disGardens" data-class="bottom">
            <div class="tit color2">一区多园</div>
            <div class="eng mainColor">AREA MORE GARDEN</div>
            <div class="line"></div>
          </div>
        </div>
      </div>
      <div class="multi-park-frame op-0" ref="multi-park-frame" data-class="bottom1">
        <div
          v-for="row in parkList"
          :key="row.id"
          class="multi-park-bg">
          <div
            class="multi-park">
            <div class="multi-park-title">
              <div class="fw-title">{{ row.parkName }}</div>
              <router-link :to="'/investmentInfo?parkId=' + row.id" class="gray-tips">查看更多</router-link>
            </div>
            <div class="multi-park-content">
              <div
                v-for="(item, index) in row.list"
                :key="index"
                :class="{small: index !== 0}"
                class="multi-park-card"
              >
                <div class="multi-park-card-cell">
                  <router-link
                    v-if="index === 0"
                    :to="'/parkDetails?id=' + row.id">
                    <img :src="item.adCover"  alt=""/>
                  </router-link>
                  <img v-else :src="item.adCover"  alt=""/>
                  <router-link
                    v-if="index !== 0"
                    :to="'/investmentInfoDetail?id=' + item.id">
                    <div class="multi-park-desc">
                      <div class="fw-title">{{ item.title }}</div>
                      <div class="gray-tips">{{ item.subTitle }}</div>
                      <div class="tag-list">
                        <div class="tag-btn">
                          <el-tag
                            v-for="(tag, tagIndex) in item.adFlag.split(',')"
                            v-if="tagIndex < 2"
                            :key="tagIndex"
                            class="tag-text"
                            type="success"
                            size="mini"
                            color="#ECFCF2"
                          >{{ tag }}</el-tag>
                          <div v-if="item.adFlag.split(',').length >= 2">...</div>
                        </div>
                        <div class="method-btn">立即考察</div>
                      </div>
                    </div>
                  </router-link>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import arrowDown from './common/arrowDown'
  import moreBtn from './common/moreBtn'
  import swiper from "swiper";
  export default {
    components: {
      arrowDown,
      moreBtn
    },
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
        showMore: false,
        parkDesc: '南京白下高新技术产业园区位于南京市东部风景秀丽的紫金山脚下，毗邻南京理工大学。园区自2001年成立以来，先后被批准为国家大学科南京白下高新技术产业园区位于南京市东部风景秀丽的紫金山脚下，毗邻南京理工大学。园区自2001年成立以来，先后被批准为国家大学科',
        activeNames: ["1"],
        searchData:'',
        showBtn:false,
        sw:'1',
        nodeList: [],
        bannerList: [],
        basicHtml: '',
        businessAdDynamic: [],
        businessAdPolicy: [],
        parkList: [],
        loadingParkList: false
      }
    },
    mounted() {
      this.init();
    },
    destroyed() {
      window.removeEventListener("scroll", this.handleScroll); //  离开页面清除（移除）滚轮滚动事件
    },
    filters: {
      formatParkDesc(str) {
        return  str.substring(0, 112) + '...'
      }
    },
    methods: {
      getBasic() {
        return new Promise((resolve, reject) => {
          this.api.get({
            url: 'basic',
            callback: (res) => {
              if (res.code === "0000") {
                this.basicHtml = res.data.parkIntroduce
                resolve()
              } else {
                this.$message.error(res.result)
                reject()
              }
            }
          })
        })
      },
      getBusinessAdDynamic() {
        return new Promise((resolve, reject) => {
          this.api.get({
            url: 'getBusinessAdDynamic',
            callback: (res) => {
              if (res.code === "0000") {
                this.businessAdDynamic = res.data
                resolve()
              } else {
                this.$message.error(res.result)
                reject()
              }
            }
          })
        })
      },
      getBusinessAdPolicy() {
        return new Promise((resolve, reject) => {
          this.api.get({
            url: 'getBusinessAdPolicy',
            callback: (res) => {
              if (res.code === "0000") {
                this.businessAdPolicy = this.formatArr(res.data, 4)
                resolve()
              } else {
                this.$message.error(res.result)
                reject()
              }
            }
          })
        })
      },
      getPartList() {
        return new Promise((resolve, reject) => {
          this.api.get({
            url: 'parkList',
            callback: (res) => {
              if (res.code === "0000") {
                this.parkList = res.data
                resolve()
              } else {
                this.$message.error(res.result)
                reject()
              }
            }
          })
        })
      },
      getPartDetail(parkId) {
        return new Promise((resolve, reject) => {
          this.api.get({
            url: 'getBusinessAdContent',
            data: {
              parkId: parkId
            },
            callback: (res) => {
              if (res.code === "0000") {
                resolve(res.data)
              } else {
                this.$message.error(res.result)
                reject()
              }
            }
          })
        })
      },
      formatArr(arr, n) {
        const len = arr.length;
        let lineNum = len % 4 === 0 ? len / 4 : Math.floor( (len / 4) + 1 );
        const result = [];
        for (let i = 0; i < lineNum; i++) {
          // slice() 方法返回一个从开始到结束（不包括结束）选择的数组的一部分浅拷贝到一个新数组对象。且原始数组不会被修改。
          let temp = arr.slice(i*n, i*n+n);
          result.push(temp);
        }
        return result
      },
      handleChange11(val) {
        if(val=='2'){
          this.sw='2'
        } else if(val=='3'){
          this.sw='3'
        } else{
          this.sw='1'
        }
      },
      formatScrollTop() {
        const refs = this.$refs
        for (const key in refs) {
          const top = this.getElementLeft(refs[key]);
          const node = {
            top: top,
            el: refs[key]
          }
          this.nodeList.push(node)
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
      getScrollOffset(){
        // 除IE8及更早版本
        if( window.pageXOffset != null ){
          return {
            x : window.pageXOffset,
            y : window.pageYOffset
          }
        }
        // 标准模式下的IE
        if( document.compatMode == "css1Compat" ){
          return {
            x : document.documentElement.scrollLeft,
            y : document.documentElement.scrollTop
          }
        }
        // 怪异模式下的浏览器
        return {
          x : document.body.scrollLeft,
          y : document.body.scrollTop
        }
      },
      handleScroll() {
        const osTop = this.getScrollOffset().y;
        for (const node of this.nodeList) {
          const top = node.top;
          // console.dir(top);
          if (osTop + innerHeight + 300 >= top + 100) {
            const name = node.el.dataset.class;
            node.el.classList.add(name);
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
      init() {
        this.getPartList()
          .then(() => {
            this.parkList.forEach((item, index) => {
              this.getPartDetail(item.id)
                .then((data) => {
                  const rows = data.rows
                 rows.unshift({
                    adCover: item.mainPicture
                  })
                  this.$set(item, 'list',rows)
                })
            })
            this.$nextTick(() => {
              this.loadingParkList = true
            })
          })
        Promise.all([
          this.getBanner(),
          this.getBasic(),
          this.getBusinessAdDynamic(),
          this.getBusinessAdPolicy(),
        ])
          .then(() => {
            this.formatScrollTop()
            window.addEventListener("scroll", this.handleScroll);
            new swiper(".swiper-container", {
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
          })
      },
      getBanner() {
        return new Promise((resolve, reject) => {
          this.api.get({
            url: 'getPromotionList',
            data: {
              approvalStatus: 6,
              status: 1,
              propagandaType: 'investment_banner',
              needPage: 0
            },
            callback: (res) => {
              if (res.code === "0000") {
                this.bannerList = res.data.rows
                resolve()
              } else {
                this.$message.error(res.result)
                reject()
              }
            }
          })
        })
      },
      handleChange() {
        //   this.sousuo = true;
      }
    }
  };
</script>
<style lang="scss">
  @import "~@/css/common";
  @import "~@/css/r-common";
  .enterpriseservice {
      .park-info {
        width: 800px;
        margin: 0 auto;
        .park-poster {
          img {
            width: 100%;
          }
        }
        .park-desc {
          margin-top: 10px;
          position: relative;
          font-size: 12px;
          color: #666;
          line-height: 24px;
          .more-desc {
            position: absolute;
            right: 0;
            bottom: 0;
          }
        }
      }
    .park-film {
      margin: 68px auto;
      @include flex;
      color: #fff;
      .film-desc {
        width: 52%;
        font-size: 12px;
        padding: 20px 30px 20px calc((100% - 900px) / 2);
        background-color: $--color-primary;
        box-sizing: border-box;
        .film-desc-title {
          font-size: 24px;
        }
        .film-desc-subheading {
          margin-top: 4px;
        }
        .film-desc-content {
          margin-top: 20px;
          line-height: 26px;
        }
        .square-angle-bg {
          @include flex($h: flex-end);
          .square-angle {
            margin-top: trsw(28);
            border: 1px solid #fff;
            width: trsw(110);
            height: trsw(30);
            @include flex($h: flex-end, $v: center);
            padding: 0 10px;
            .square-angle-l {
              width: trsw(45);
              height: 2px;
              transform: translateX(5px);
              background-color: #fff;
            }
          }
        }
      }
      .film-show {
        width: 48%;
        box-sizing: border-box;
        position: relative;
        .green-frame {
          width: 368px;
          height: 354px;
          position: absolute;
          left: -34px;
          top: 50%;
          z-index: 1;
          transform: translateY(-50%);
          border: 1px solid $--color-primary;
        }
        video{
          width: 100%;
          height: 100%;
          vertical-align: middle;
        }
        .film-play {
          $size: 74px;
          width: $size;
          height: $size;
          position: absolute;
          left: 112px;
          top: 50%;
          transform: translateY(-50%);
          @include image('~@/../static/img/film-play.png');
          transition: .3s;
          cursor: pointer;
          &.hover {
            opacity: .9;
          }
        }
      }
    }
    .more-garden {
      width: 900px;
      margin: 60px auto;
      flex-wrap: wrap;
      @include flex;
      .more-garden-card {
        width: 300px;
        box-sizing: border-box;
        padding: 20px;
        .more-garden-card-cell {
          cursor: pointer;
          width: 100%;
          padding: 30px;
          box-shadow:0px 0px 18px 0px rgba(208,209,210,0.42);
          box-sizing: border-box;
          transform: scale(1);
          transition: .3s;
          &:hover {
            transform: scale(1.1);
          }
          .more-garden-img {
            width: 200px;
            display: block;
            height: 200px;
            border-radius: 50%;
          }
          .more-garden-desc {
            height: 48px;
            margin-top: 35px;
            text-align: left;
            font-size: 12px;
            color: #666;
            overflow: hidden;
            text-overflow:ellipsis;//文本溢出显示省略号
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
          }
          .more-garden-footer {
            margin-top: 22px;
            font-size: 12px;
            @include flex($h: space-between);
            .more-garden-date {
              color: #999;
            }
          }
        }
      }
    }
    .multi-park-frame {
      padding-bottom: 55px;
    }
    .multi-park-bg {
      padding: 15px 0;
      border-bottom: 6px solid #fafafa;
      &:last-of-type {
        border-bottom: 0;
      }
    }
    .multi-park {
      width: 900px;
      margin: 0 auto;
      .multi-park-title {
        padding: 10px 0;
        @include flex($h: space-between);
      }
      .multi-park-content {
        border-top: 1px solid rgb(238,238,238);
        $bg-gray: #DEDEDE;
        @include flex($h: flex-start, $v: flex-start);
        .multi-park-card {
          width: 25%;
          box-sizing: border-box;
          text-align: left;
          height: 285px;
          &.small {
            padding: 6px;
            box-sizing: border-box;
            .multi-park-card-cell {
              height: 100%;
              border: 1px solid $bg-gray;
              img {
                margin-top: 0;
                height: 133px;
              }
            }
          }
          img {
            width: 100%;
            margin-top: -1px;
            display: block;
            height: 285px;
          }
          .multi-park-desc {
            .fw-title {
              font-size: 13px;
              margin: 0 auto 10px;
              padding: 6px;
            }
            .gray-tips {
              height: 56px;
              padding: 6px;
              overflow: hidden;
              text-overflow: ellipsis;
              display: -webkit-box;
              -webkit-line-clamp: 3;
              -webkit-box-orient: vertical;
              box-sizing: border-box;
            }
          }
          .tag-list {
            @include flex($h: space-between);
            padding: 8px 6px 6px;
            color: $--color-primary;
            margin-top: 8px;
            border-top: 1px solid $bg-gray;
            .el-tag--success {
              max-width: 60px;
              color: $--color-primary;
              border-color: #41D787;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
            }
            .tag-btn {
              @include flex($h: space-between);
              .tag-text {
                margin-right: 6px;
                &.last-of-type {
                  margin-right: 0;
                }
              }
            }
            font-size: 12px;
          }
        }
      }
    }
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
      &.pd-b-n {
        padding: 0;
      }
      .investment-card-subtitle {
        height: 48px;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 3;
        overflow: hidden;
      }
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

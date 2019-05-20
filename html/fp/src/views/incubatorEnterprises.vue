<template>
    <div class="incubatorEnterprises">
        <div class="enterpriseBan">
            <div class="bannerEnt pr">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/createspace.png" alt="">
                        </div>
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/createspace.png" alt="">
                        </div>
                        <div class="swiper-slide" style="width:100%">
                            <img src="@/../static/img/createspace.png" alt="">
                        </div>
                    </div>
                    <!-- 如果需要分页器 -->
                    <div class="swiper-pagination"></div>

                    <!-- 如果需要导航按钮 -->
                    <div class="swiper-button-prev">
                        <!-- <i class="iconfont icon-leftarrow pointer"></i> -->
                    </div>
                    <div class="swiper-button-next">
                        <!-- <i class="iconfont icon-rightarrow pointer"></i> -->
                    </div>
                </div>
            </div>
        </div>
        <div class="enterpriseCon w">
             <div class="incubatorNav">
                <span>首页</span>
                <span>/</span>
                <span class="mainColor">孵化企业</span>
            </div>
        </div>
    </div>
</template>
<script>
import swiper from "swiper";
export default {
  data() {},
  mounted() {
    this.swiperinit();
  },
  methods: {
    swiperinit() {
      var mySwiper = new swiper(".swiper-container", {
        direction: "horizontal", // 垂直切换选项
        loop: true, // 循环模式选项
        noSwiping: true,
        // autoplay: true,
        // autoplay: {
        //   delay: 5000,
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
      });
    }
  }
};
</script>
<style lang="scss">
.incubatorEnterprises {
  .bannerEnt {
    img {
        width: 100%;
        height: 100%;
      }
  }
  .incubatorNav{
      padding:15px 0;
      font-size: 13px;
  }
}
</style>

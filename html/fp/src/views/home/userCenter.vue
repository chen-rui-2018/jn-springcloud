<template>
  <div class="user-center">
    <div class="user-header">
        <div class="user-header-l">
          <img src="http://img0.pconline.com.cn/pconline/1506/29/6638168_1752_thumb.jpg" alt="">
          <span class="welcome">您好，123434</span>
        </div>
        <div class="user-header-r">
         <tag
           v-for="(tag, index) in tagList"
           :type="tag.type"
           :title="tag.title"
           :key="index"
           class="tag-list"
         />
        </div>
    </div>
    <div class="user-main">
      <notice >
        <div>XXX邀请你加入，点击查看详情</div>
      </notice>
    </div>
  </div>
</template>
<script>
  import tag from './common/tag'
  import notice from './common/notice'
 export default {
   name: "userCenter",
   components: {
     tag,
     notice
   },
   data() {
     return {
       tagList: [{
         type: 'blue',
         title: '用户资料设置'
       },{
         type: 'green',
         title: '投资人认证'
       },{
         type: 'orange',
         title: '顾问认证'
       },{
         type: 'purple',
         title: '机构认证'
       }]
     }
   }
  }
</script>
<style lang="scss" scoped>
  @import "~@/css/r-common";
  .user-center {
    color: #333333;
    .user-header {
      padding: 16px;
      background-color: #fff;
      @include flex($h: space-between);
      .user-header-l {
        @include flex($h: space-between);
        img {
          width: trsw(83);
          height: trsw(83);
          border-radius: 50%;
          padding: 24px;
        }
        .welcome {
          font-size: 18px;
        }
      }
      .user-header-r {
        @include flex($h: space-between);
        .tag-list {
          margin-right: 30px;
        }
        .tag-list:last-of-type {
          margin-right: 0;
        }
      }
    }
  }
</style>

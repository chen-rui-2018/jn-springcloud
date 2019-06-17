<template>
    <div class="marquee">

        <div class="marquee_title">
            <span>免费微报</span>
        </div>
        <div class="marquee_box">
            <ul class="marquee_list" :class="{marquee_top:animate}">
                <li v-for="(item,index) in marqueeList">{{item.name}}</li>
            </ul>
        </div>
    </div>
</template> 
<script>
export default {
  data() {
    return {
      animate: false,

      marqueeList: [
        {
          name: "1军电视剧烦恼是的空间开发"
        },

        {
          name: "2军水电费了羧甲淀粉钠盛开"
        },

        {
          name: "3军第三方库收到货否"
        },

        {
          name: "4军杜师傅iOS"
        }
      ]
    };
  },
  created: function() {
    // 页面显示
    setInterval(this.showMarquee, 2000);
  },
  methods: {
    showMarquee: function() {
      this.animate = true;

      setTimeout(() => {
        this.marqueeList.push(this.marqueeList[0]);

        this.marqueeList.shift();

        this.animate = false;
      }, 500);
    }
  }
};
</script>
 
<style scoped>
.marquee {
  width: 100%;

  height: 50px;

  align-items: center;

  color: #3a3a3a;

  background-color: white;

  display: flex;

  box-sizing: border-box;

  overflow: hidden;
}

.marquee_title {
  padding: 0 20px;

  height: 21px;

  font-size: 14px;

  border-right: 1px solid #d8d8d8;

  align-items: center;
}

.marquee_box {
  display: block;

  position: relative;

  width: 60%;

  height: 30px;

  overflow: hidden;
}

.marquee_list {
  display: block;

  position: absolute;

  top: 0;

  left: 0;
}

.marquee_top {
  transition: all 0.5s;

  margin-top: -30px;
}

.marquee_list li {
  height: 30px;

  line-height: 30px;

  font-size: 14px;

  padding-left: 20px;
}

/* .marquee_list li span {
  padding: 0 2px;
} */
</style>

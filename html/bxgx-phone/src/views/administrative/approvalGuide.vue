<template>
  <div class="approvalGuide">
    <div class="approvalGuide_search">
      <!-- <mt-search v-model="value"></mt-search> -->
    </div>
    <div class="approvalGuide_main">
      <div class="approvalGuide_tab">
        <span class="slider "><i class="iconfont icon-icon-"></i> </span>
        <ul>
          <li v-for="(item,$index) in arr" :key="$index" @touchstart="toggle($index)" :class="{active:$index==active}">{{item}}</li>
        </ul>
      </div>
      <div class="approvalGuide_cont">
        <ul>
          <li>
            <div class="cont_title">
              <div>建设项目安全设施设计审查</div>
              <div>
                <span class="iconfont icon-07jiantouxiangshang"></span>
                <span class="iconfont icon-07jiantouxiangshang"></span>
              </div>
            </div>
            <div class="cont_section">
              <div>非煤矿矿山建设项目安全设施设计审查</div>
              <div>非煤矿矿山建设项目安全设施设计审查</div>
              <div>非煤矿矿山建设项目安全设施设计审查</div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      active: 0,
      value: '',
      arr: [
        '新闻',
        '视频',
        '社会',
        '军事',
        '军事1',
        '军事2',
        '军事3',
        '军事4',
        '军事5',
        '军事6',
        '军事74555555555555555'
      ]
    }
  },
  methods: {
    toggle (index) {
      this.active = index
    }
  }
}
</script>

<style lang="scss">
  .approvalGuide{
    .approvalGuide_search{

    }
    .approvalGuide_main{

      .approvalGuide_tab{
        position: relative;
         .slider{
            position: absolute;
            right: 0;
            display: flex;
            align-items: center;
            height: 99%;
            margin:auto 0;
            background-color: #fff;
            box-shadow: 0px 2px 18px 0px rgba(121, 121, 121, 0.15);
            // font-size: 26px;
            padding:0 27px;
            i{
              font-size: 32px;
              width: 32px;
            }
          }
        ul{
          padding: 0 32px;
          margin-right: 90px;
          display: flex;
          align-items: center;
          overflow: auto;
          border-bottom: 2px solid #cdcdcd;
          &::-webkit-scrollbar {
              display: none;
            }
        li{
          text-align: center;
          font-size: 23px;
          flex-shrink: 0;
          padding: 23px 0;
          // margin-top: 13px;
          margin-right: 72px;
        }
        .active{
          color: #07ab50;
          border-bottom: 5px solid #07ab50;
        }
        }
      }
      .approvalGuide_cont{
        margin:30px;
        li{
          box-shadow: 0px 2px 18px 0px rgba(121, 121, 121, 0.15);
          border-radius: 20px;
          .cont_title{
            padding:25px 26px 19px 26px ;
            display: flex;
            justify-content: space-between;
            font-size: 26px;
            color: #333333;
            span{
              font-size: 33px;
              color:#cdcdcd;
            }
          }
          .cont_section{
            border-top: 2px solid #ccc;
            padding:0 26px ;
            div{
              border-top: 2px solid #ccc;
              font-size: 26px;
              padding:26px 0;
              &:first-child{
                border:none;
              }
            }
          }
        }
      }
    }
  }
</style>

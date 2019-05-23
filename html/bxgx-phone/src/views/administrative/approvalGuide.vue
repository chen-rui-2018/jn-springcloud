<template>
  <div class="approvalGuide">
    <div class="approvalGuide_search">
      <search
      v-model="value"
      ref="search"></search>
    </div>
    <div class="approvalGuide_main">
      <div class="approvalGuide_tab">
         <span class="slider_btn" @click="isSlider=true"><i class="iconfont icon-icon-"></i> </span>
         <tab>
          <tab-item :selected="active===''" ><span :class="{active:active===''}" @click="toggle('','')">全部</span></tab-item>
          <tab-item v-for="(item,$index) in departList" :key="$index" :selected="$index===active">
            <span :class="{active:$index===active}" @click="toggle($index,item.id)">{{item.name}}</span>
          </tab-item>
        </tab>
      </div>
      <!-- 侧边栏-->
        <popup v-model="isSlider" position="right" width="81%">
          <div class="slider_box">
            <div class="slider_title"><span>部门</span> <span @click="toggle('','')">全部</span> </div>
            <div class="slider_cont">
              <div v-for="(item,index) in departList" :key="index"  @click="toggle(index,item.id)">{{item.name}}</div>
            </div>
            <div class="slider_sure">
              <span>重置</span>
              <span>确定</span>
            </div>
          </div>
        </popup>
      <div class="approvalGuide_cont">
        <group v-for="(powerItem,powerIndex) in poweList" :key="powerIndex">
          <div class="approvalGuide_box" >
            <cell
              :title="powerItem.name"
              :border-intent="false"
              @click.native="powerItem.isfold = !powerItem.isfold"
              v-if="powerItem.childs.length!=0"
              >
              <div>
                <span class="iconfont icon-07jiantouxiangshang" style="color: #cdcdcd " v-if="powerItem.isfold"></span>
                <span v-else class="iconfont icon-07jiantouxiangxia" style="color: #cdcdcd " ></span>
              </div>
            </cell>
            <cell
              :title="powerItem.name"
              :border-intent="false"
              @click.native="goPower(powerItem.id)"
              v-else
              >
              <div>
                <span class="iconfont icon-07jiantouxiangshang" style="color: #cdcdcd " v-if="powerItem.isfold"></span>
                <span v-else class="iconfont icon-07jiantouxiangxia" style="color: #cdcdcd " ></span>
              </div>
            </cell>
            <div class="fold_cont" :class="powerItem.isfold?'animate':''" v-for="(childItem,childIndex) in powerItem.childs " :key="childIndex">
              <div @click="goPower(childItem.id)"><span>{{childItem.name}} </span><span class="iconfont icon-jiantou" ></span></div>
            </div>
          </div>
        </group>
      </div>
    </div>
  </div>
</template>
<script>
import {Cell, CellBox, CellFormPreview, Group, Badge, Search, Popup, Tab, TabItem} from 'vux'
export default {
  data () {
    return {
      active: '',
      value: '',
      // isfold: false,
      isSlider: false,
      departList: [],
      sendData: {
        code: '',
        departId: '',
        name: '',
        page: 1,
        parentId: '',
        rows: 20,
        type: ''
      },
      poweList: []

    }
  },
  components: { Group, Cell, CellFormPreview, CellBox, Badge, Search, Popup, Tab, TabItem },
  mounted () {
    this.getdepartList()
    this.getPoweList()
  },
  methods: {
    // tab栏
    getdepartList () {
      let _this = this
      this.api.get({
        url: 'departList',
        data: this.sendData,
        callback: function (res) {
          if (res.code === '0000') {
            // console.log(res)
            _this.departList = res.data
          }
        }
      })
    },
    // 列表
    getPoweList () {
      this.api.get({
        url: 'powerList',
        data: this.sendData,
        callback: res => {
          if (res.code === '0000') {
            this.poweList = res.data.rows
            this.poweList.forEach(ele => {
              this.$set(ele, 'isfold', false)
            })
            this.isSlider = false
          }
        }
      })
    },
    // 去详情
    goPower (id) {
      // console.log(id)
      this.$router.push({path: '/guest/portal/sp/power/powerDetail', query: {id: id}})
    },
    toggle (index, id) {
      // console.log(index)
      this.active = index
      this.sendData.departId = id
      this.getPoweList()
    }
  }
}
</script>

<style lang="scss">
  .approvalGuide{
    .approvalGuide_search{
      position: fixed;
      z-index: 10;
      top:105px;
        width: 100%;
      .weui-search-bar{
        padding:28px 32px;
      }
      .vux-search-box{
        position: fixed;
        top:105px !important;
      }
      .weui-search-bar__input{
        height: 63px;
        line-height: 63px;
        // border-radius: 30px;
      }
      .weui-icon-search{
        line-height: 63px;
      }
       .weui-icon-clear{
          line-height: 0.8rem;
       }
      .weui-search-bar.weui-search-bar_focusing .weui-search-bar__cancel-btn{
        display: flex;
        align-items: center;
      }
      .weui-search-bar__box{
        padding:0 70px;
        .weui-icon-search{
          left:20px;
        }
        .weui-search-bar__input{
          padding:0;
        }
      }
    }
    .approvalGuide_main{
      .approvalGuide_tab{
        margin-top: 110px;
        position: fixed;
        top:113px;
        width:100%;
        z-index: 20;
        background-color: #fff;
        .slider_btn{
            position: absolute;
            right: 0;
            display: flex;
            align-items: center;
            height: 99%;
            margin:auto 0;
            background-color: #fff;
            box-shadow: 0px 2px 18px 0px rgba(121, 121, 121, 0.15);
            // font-size: 26px;
            padding:42px 27px;
            z-index: 20;
              i{
                font-size: 32px;
                width: 32px;
              }
        }
        .vux-tab-wrap{
          padding-top: 0;
        }
        .vux-tab-container{
          height: auto;
        }
        .vux-tab{
          height: auto;
          padding-bottom: 0;
          margin-right: 30px;
          border-bottom: 2px solid #ccc;
          .vux-tab-item{
            flex:0 0 auto;
            padding: 23px 0;
            padding-right: 70px;
            width:auto;
            &:first-child{
              margin-left: 32px;
            }

            span{
            padding-bottom: 27px;
            font-size: 23px;
            }
            .active{
              border-bottom: 5px solid #07ab50;
              color:#07ab50;
            }
          }
           .vux-tab-ink-bar{
             display: none !important;
           }
        }
      }
      .approvalGuide_cont{
        margin:30px;
        margin-top: 44%;
        .weui-cells{
          box-shadow: 0px 2px 18px 0px rgba(121, 121, 121, 0.15);
          border-radius: 20px;
          .weui-cell{
            padding:19px 28px;
            .vux-label{
              font-size: 26px;
            }
          }
          .weui-cell__ft{
            span{
              font-size: 33px;
            }
          }
        }

        .fold_cont {
          overflow: hidden;
          max-height: 0;
          transition: max-height .5s cubic-bezier(0, 1, 0, 1) -.1s;
          padding:0 28px;
          color:#666666;

          div{
          font-size: 24px;
          border-top: 2px solid #ccc;
          padding:23px 0;
          display: flex;
          justify-content: space-between;
          .iconfont{
            font-size: 20px;
            color:#ccc;
          }
          &:first-child{
              border:none;
            }
          &:last-child{
            margin-bottom: 15px;
          }
          }
        }
         .sub-item {
          color: #888;
        }
        .animate {
          max-height: 9999px;
          transition-timing-function: cubic-bezier(0.5, 0, 1, 0);
          transition-delay: 0s;
          border-top: 2px solid #ccc;
        }
      }
      // 侧边栏
      .vux-popup-dialog{
        background-color: #fff;
        .slider_box{
          padding:0 31px;
          margin-bottom: 35px;
          .slider_title{
            margin-top: 68px;
            font-size: 26px;
            display: flex;
            justify-content: space-between;
            span:nth-child(2){
              color:#666666;
            }
          }
          .slider_cont{
            margin-top: 38px;
            font-size: 24px;
            color:#4a4a4a;
            display: flex;
            flex-wrap: wrap;
            div{
              padding: 13px 17px;
              background-color: #f4f3f3;
              border-radius: 25px;
              border: solid 2px #535353;
              margin-right: 15px;
              margin-bottom: 18px;
            }
          }
          .slider_sure{
            display: flex;
            justify-content: space-between;
            font-size: 27px;
            span:nth-child(1){
              padding:24px 104px;
              color: #666666;
              background-color: #f0f0f0;
              border-radius: 35px;
            }
            span:nth-child(2){
              padding:24px 104px;
              background-color: #ecfcf2;
              border-radius: 35px;
              border: solid 2px #07ab50;
              color:#07ab50;
            }
          }
        }
      }
    }
  }
</style>

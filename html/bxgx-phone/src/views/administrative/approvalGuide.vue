<template>
  <div class="approvalGuide">
    <div class="approvalGuide_search">
      <i class="weui-icon-search" v-if="sendData.name===''"></i>
      <input type="text" placeholder="搜索" @change="gosearch" v-model="sendData.name" >
    </div>
        <div class="approvalGuide_main">
          <div class="approvalGuide_tab1">
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
            </div>
          </popup>
           <!-- <scroller lock-x @on-scroll-bottom="onScrollBottom" ref="scrollerBottom" style="height:569px">
              <div class="box2"> -->
                <div class="approvalGuide_cont1">
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
                  <!-- <load-more tip="loading" v-if="onFetching"></load-more> -->
                </div>
              <!-- </div>
          </scroller> -->
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
      poweList: [],
      total: 0
    }
  },
  components: { Group, Cell, CellFormPreview, CellBox, Badge, Search, Popup, Tab, TabItem },
  mounted () {
    this.getdepartList()
    this.getPoweList()
    this.scrollBottom()
    if (sessionStorage.getItem('url')) {
      this.active = sessionStorage.getItem('active') * 1
      this.sendData.departId = sessionStorage.getItem('departId')
      this.getPoweList()
    } else {
      this.getPoweList()
    }
  },
  methods: {
    // tab栏
    scrollBottom () {
      // let _this = this
      window.onscroll = () => {
        var scrollHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight)
        var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
        var clientHeight = window.innerHeight || Math.min(document.documentElement.clientHeight, document.body.clientHeight)
        if (clientHeight + scrollTop >= scrollHeight) {
          // console.log(this)
          if (this.sendData.page < Math.ceil(this.total / this.sendData.rows)) {
            this.sendData.page++
            this.api.get({
              url: 'powerList',
              data: this.sendData,
              callback: res => {
                if (res.code === '0000') {
                  this.poweList.push(...res.data.rows)
                  this.total = res.data.total
                  this.poweList.forEach(ele => {
                    this.$set(ele, 'isfold', false)
                  })
                  this.isSlider = false
                }
              }
            })
          }
        }
      }
    },
    getdepartList () {
      this.api.get({
        url: 'departList',
        data: this.sendData,
        callback: (res) => {
          if (res.code === '0000') {
            // console.log(res)
            this.departList.push(...res.data[0])
            this.departList.push(...res.data[1])
            this.departList.push(...res.data[2])
            //  res.data.forEach(ele => {

            // })
          }
        }
      })
    },
    // 列表
    getPoweList () {
      this.sendData.page = 1
      this.api.get({
        url: 'powerList',
        data: this.sendData,
        callback: res => {
          if (res.code === '0000') {
            // this.poweList.push(...res.data.rows)
            this.poweList = res.data.rows
            this.total = res.data.total
            this.poweList.forEach(ele => {
              this.$set(ele, 'isfold', false)
            })
            this.isSlider = false
            this.onFetching = false
          }
        }
      })
    },
    // 去详情
    goPower (id) {
      sessionStorage.setItem('url', 'powerDetail')
      sessionStorage.setItem('active', this.active)
      sessionStorage.setItem('departId', this.sendData.departId)
      this.$router.push({path: '/guest/portal/sp/power/powerDetail', query: {id: id}})
    },
    toggle (index, id) {
      this.active = index
      this.sendData.departId = id
      this.getPoweList()
    },
    gosearch () {
      this.getPoweList()
    }
  }
}
</script>

<style lang="scss">
  .approvalGuide{
    overflow: scroll;

    .approvalGuide_search{
      position: fixed;
      z-index: 10;
      width: 100%;
      background-color: #F5F5F5;
      padding: 0 35px;
      display: flex;
      input::placeholder{
        text-align: center;
        font-size: 21px;
      }
      input{
        height: 60px;
        width:100%;
        margin: 22px 0;
        border-radius: 30px;
        padding: 0 40px;
      }
      i{
        position: absolute;
        top: 38.5%;
        right: 54%;
        font-size: 21px;
      }
    }
    .approvalGuide_main{
      .approvalGuide_tab1{
        // margin-top: 110px;
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
          border-bottom: 2px solid #e3e3d3;
          .vux-tab-item{
            flex:0 0 auto;
            padding: 23px 0;
            padding-right: 70px;
            width:auto;
            &:first-child{
              margin-left: 32px;
            }

            span{
            padding-bottom: 28px;
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
      .approvalGuide_cont1{
        padding: 0 0.4rem;
        margin-top: 27%;
        height: 100% ;
        overflow: auto;
        .weui-cells{
          box-shadow: 0px 2px 18px 0px rgba(121, 121, 121, 0.15);
          border-radius: 20px;
          // padding-left: 10px;
          // padding-right: 10px;
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
      .vux-cell-primary{
        overflow: hidden;
        p{
          overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;
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

        }
      }
    }
  }
</style>

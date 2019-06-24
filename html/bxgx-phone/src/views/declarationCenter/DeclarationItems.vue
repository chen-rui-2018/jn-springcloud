<template>
      <div class="declaration_item">
      <div class="declaration_list_tab">
        <ul >
          <li :class="{'active':sendData.rangeId===''}" @touchstart="changetype('') ">全部</li>
          <li :class="{'active':typeitem.id===sendData.rangeId}" @touchstart="changetype(typeitem.id) " v-for="(typeitem,typeindex) in  typeList" :key="typeindex">{{typeitem.name}} </li>
        </ul>
      </div>
      <div class="declaration_list_filter">
        <span @touchstart="filter('1')" :class="{'greenColor':sendData.sortType==='1'}"><i class="iconfont icon-clock-"></i>发布时间排序 </span>
        <span @touchstart="filter('2')" :class="{'greenColor':sendData.sortType==='2'}"><i class="iconfont icon-tiaozheng"></i>时间节点排序 </span>
        <span @touchstart="filter('3')" :class="{'greenColor':sendData.sortType==='3'}"><i class="iconfont icon-hot"></i>热度排序</span>
      </div>
      <div class="declaration_cont_box">
        <div class="declaration_cont" v-for="(item,index) in declarationList " :key="index" @click="goDetail(item.id)">
          <div class="declaration_cont_left">
            <div class="cont_title"><span class="greenColor">[{{item.rangeId|type}}] </span>{{item.titleName}} </div>
            <div class="cont_detail">
              <div>
                <span>开始：{{item.createdTime|time}}</span><span>截止：{{item.deadline|time}}</span>
                </div>
              <span class="greenColor">{{item.isRoofPlacement===1?'置顶':'不置顶'}}</span>
            </div>
            <div class="cont_depart"><span>申报部门：{{item.timeNode}}</span><span v-if="item.preliminaryDeadline!=null">初审截止时间：{{item.preliminaryDeadline|time}} </span></div>
          </div>
          <div class="declaration_cont_right"><span class="iconfont icon-jiantou"></span> </div>
        </div>
      </div>
    </div>
</template>
<script>
export default {
  data () {
    return {
      typeList: [],
      declarationList: [],
      total: 0,
      sendData: {
        page: 1,
        rangeId: '',
        rows: 10,
        sortType: '1',
        titleName: ''
      },
      isShow: 1
    }
  },
  filters: {
    time (time) {
      if (time) {
        return time.split('T')[0]
      }
    },
    type (rangeId) {
      if (rangeId === '1') {
        return '白下高新区'
      } else if (rangeId === '2') {
        return '秦淮区'
      } else if (rangeId === '3') {
        return '南京市'
      } else if (rangeId === '4') {
        return '江苏省'
      } else if (rangeId === '5') {
        return '国家'
      }
    }
  },
  mounted () {
    this.isShow = this.$route.query.isShow
    this.getTypeList()
    this.getdeclarationList()
    this.scrollBottom()
  },
  methods: {
    goDetail (id) {
      // if (this.isShow === 1) {
      this.$router.push({path: '/guest/pd/declarationDetail', query: {id: id, isShow: this.isShow}})
      // } else {
      //   this.$router.push({path: '/guest/pd/declarationDetail', query: {id: id, isShow: '0'}})
      // }
    },
    gosearch () {
      this.getdeclarationList()
    },
    scrollBottom () {
      // let _this = this
      window.onscroll = () => {
        var scrollHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight)
        var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
        var clientHeight = window.innerHeight || Math.min(document.documentElement.clientHeight, document.body.clientHeight)
        if (clientHeight + scrollTop >= scrollHeight) {
          if (this.sendData.page < Math.ceil(this.total / this.sendData.rows)) {
            this.sendData.page++
            this.api.get({
              url: 'declarationList',
              data: this.sendData,
              callback: res => {
                if (res.code === '0000') {
                  this.declarationList.push(...res.data.rows)
                }
              }
            })
          }
        }
      }
    },
    getTypeList () {
      this.api.get({
        url: 'typeList',
        data: { },
        callback: res => {
          if (res.code === '0000') {
            this.typeList = res.data
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    getdeclarationList () {
      this.sendData.page = 1
      this.api.get({
        url: 'declarationList',
        data: this.sendData,
        callback: res => {
          if (res.code === '0000') {
            // console.log(res)
            this.declarationList = res.data.rows
            this.total = res.data.total
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    goplatform () {
    },
    changetype (rangeId) {
      this.sendData.rangeId = rangeId
      this.getdeclarationList()
    },
    filter (sortType) {
      this.sendData.sortType = sortType
      this.getdeclarationList()
    },
    getQueryString (name) {
      var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i')
      var r = window.location.search.substr(1).match(reg)
      if (r != null) {
        return decodeURIComponent(r[2])
      }
      return null
    }
  }
}
</script>
<style lang="scss">
  .declaration_item{
    // margin-top: 31px;
    .greenColor{
      color:#07ab50;
    }
    .declaration_list_tab{
      padding: 0 31px;
      ul{
        display: flex;
        justify-content: space-between;
        li{
          padding: 25px 0 18px 0;
          font-size: 24px;
        }
        .active{
          color:#07ab50;
          border-bottom: 5px solid #07ab50;
        }
      }
    }
    .declaration_list_filter{
      background-color: #f6f6f6;
      font-size: 24px;
      padding:22px 31px;
      display: flex;
      justify-content: space-between;
      i{
        font-size: 30px;
      }
    }
    .declaration_cont_box{
      margin:0 31px;
      margin-bottom: 20px;
      .declaration_cont{
      border-bottom: 2px solid #efefef;
        display: flex;
        justify-content: space-between;
        align-items: center;
        .declaration_cont_left{
          width: 92%;
          .cont_depart{
            font-size: 23px;
            color:#333333;
            display: flex;
            justify-content: space-between;
            padding-bottom: 36px;
            span{
              // padding-right: 23px;
            }
          }
          .cont_title{
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            font-size: 26px;
            padding-top: 37px;
            line-height: 28px;
          }
          .cont_detail{
            font-size: 23px;
            color:#333333;
            display: flex;
            justify-content: space-between;
            padding-top: 36px;
            padding-bottom: 36px;
            span:first-child{
              padding-right: 23px;
            }
          }
        }
        .declaration_cont_right{
          padding-left: 32px;
          color:#cccccc;
          font-size: 20px;
        }
      }
    }
  }
</style>

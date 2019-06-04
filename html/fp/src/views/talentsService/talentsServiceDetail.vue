<template>
  <div class="talentsServiceDetail">
    <div class="talentsServiceDetail_content"><!-- 版心 -->
      <!-- 面包屑 -->
      <div class="talentsServiceDetail_breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="#/talentsService">人才服务</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="javascript:;">人才服务详情</a>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!-- 大标题 -->
      <div class="right_headline">
        <p class="detail_maintitle"><span v-if="talentDetailList.rangeId!='5'">【{{talentDetailList.rangeName}}】</span>{{talentDetailList.noticeTitle}}
        </p>
        <!-- 附件下载 -->
        <div class="accessory_dowload">
          <div class="accessory">
            <span>附件下载:</span>
            <div class="accessory_right">
              <a v-if="fileList.length===0" href="javascript:;">暂无</a>
              <a  :href="item.filePath" v-for="(item,index) in fileList " :key="index">附件{{index+1}}  {{item.fileName}}</a>
              <p>
                <span>发布时间:<span class="color">{{talentDetailList.createdTime|time}}</span> </span>
                <span>阅读量: {{talentDetailList.browseTimes}}次</span> 
              </p>
            </div>
          </div>
        </div>
      </div>
      <!-- 公告详情 -->
      <div class="notice_content">
        <div class="notice_title">公告详情</div>
        <div class="notice_detail" v-html="talentDetailList.announcementContent">
          
        </div>
      </div>
    </div><!-- 版心 -->
  </div>
</template>
<script>
export default {
  data () {
    return {
      id:"",
      talentDetailList:{},
      fileList:[]
    }
  },
  filters: {
    time(time){
      if(time){
        // return time.split("T")[0]
        let dateee = new Date(time).toJSON();
        return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '') 
      }
    }
  },
  mounted () {
    this.id=this.$route.query.id
    this.getDetailList()
    this.addtalentviews()
  },
  methods: {
    getDetailList(){
      let _this = this;
      this.api.get({
        url: "gettalentDetail",
        data: {
          id:this.id
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.talentDetailList = res.data;
            if(res.data.fileUrl!==''){
              _this.fileList=JSON.parse(res.data.fileUrl)
            }
          }
        }
      });
    },
    addtalentviews(){
      let _this = this;
      this.api.get({
        url: "addtalentviews",
        data: {
          id:this.id
        },
        callback: function(res) {
          if (res.code == "0000") {
          }
        }
      });
    },
  }
}
</script>

<style lang="scss">
  .talentsServiceDetail{
     padding-top: 67px;
    .talentsServiceDetail_content{
      width: 1190px;
      margin: 0 auto;
      // 面包屑
      .talentsServiceDetail_breadcrumb{
        padding: 15px 0;
        font-size: 12px;
        .el-breadcrumb__item:last-child .el-breadcrumb__inner a{
          color:#00a041;  
        }
      }
      // 大标题
      .right_headline{
        box-shadow: 0px 1px 15px 0px 
          rgba(4, 0, 0, 0.05);
        border-radius: 8px;
        border: solid 1px #eeeeee;
        padding:30px 31px 18px 31px;
        .detail_maintitle{
          font-size: 21px;
          border-bottom: 1px solid #eeeeee;
          padding-bottom: 19px;
          // span{
          //   // float:right;
          //   font-size: 12px;
          //   padding:3px 5px;
          //   border-radius: 5px;
          //   &:hover{
          //     cursor:pointer;
          //   }
          // }
          // span:nth-child(2){
          //   background-color: #ecfcf2;
          //   border-radius: 5px;
          //   border: solid 1px #41d787;
          //   color:#00a041;
          //   border-radius: 5px;
          //   margin-right: 12px;
          // }
          // span:nth-child(1){
          //   background-color: #00a041;
          //   color:#FFF;
          //   border: solid 1px #00a041;
          // }
        }
        .accessory_dowload{
          margin-top: 24px;
          font-size: 13px;
          .accessory{
            display: flex;
            .accessory_right{
              margin-left: 7px;
              flex:1;
              a{
                display: block;
                color:#00a041;
                padding-bottom: 10px;
              }
              p{
                float:right;
                span{
                  font-size: 12px;
                  color:#666666;
                  float: right;
                  &:nth-child(1){
                    span{
                      color:#00a041;
                      padding-left: 0px;
                    }
                    padding-left: 20px;
                  }
                }
              }
            }

          }
        }
      }
      // 公告详情
      .notice_content{
        margin-top: 30px;
        margin-bottom: 61px;
        .notice_title{
          font-size: 17px;
        }
        .notice_detail{
          margin-top: 17px;
          box-shadow: 0px 1px 15px 0px rgba(4, 0, 0, 0.05);
          border-radius: 8px;
          border: solid 1px #eeeeee;
          padding:46px 41px 62px 41px;
        }
      }
      .color{
        color:#00a041;
      }
    }
  }
</style>
